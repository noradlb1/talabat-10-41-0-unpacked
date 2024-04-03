package com.huawei.location.router.dispatch;

import com.huawei.location.router.BaseRouterTaskCallImpl;
import com.huawei.location.router.RouterTaskHandler;
import com.huawei.location.router.entity.RouterRequest;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DispatchThreadPoolExecutor extends ThreadPoolExecutor {
    public DispatchThreadPoolExecutor(int i11, int i12, long j11, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i11, i12, j11, timeUnit, blockingQueue, threadFactory);
    }

    private void processRequest(DispatchBaseRunnable dispatchBaseRunnable) {
        Thread.setDefaultUncaughtExceptionHandler(new DispatchThreadExceptionHandler(dispatchBaseRunnable));
        RouterRequest routerRequest = dispatchBaseRunnable.getRouterRequest();
        if (routerRequest != null) {
            String str = RouterTaskHandler.getInstance().getApiRequestMap().get(routerRequest.getApiName());
            if (str != null) {
                try {
                    dispatchBaseRunnable.setApiRequest((BaseRouterTaskCallImpl) Class.forName(str).newInstance());
                } catch (ClassNotFoundException unused) {
                    throw new DispatchException(10003, "class not found exception");
                } catch (IllegalAccessException unused2) {
                    throw new DispatchException(10003, "IllegalAccessException");
                } catch (InstantiationException unused3) {
                    throw new DispatchException(10003, "InstantiationException");
                } catch (Exception unused4) {
                    throw new DispatchException(10003, "InstantiationException");
                }
            } else {
                throw new DispatchException(10001, "api interface not register");
            }
        } else {
            throw new DispatchException(10002, "TaskApiEntity Object is Empty");
        }
    }

    public void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        if (runnable instanceof DispatchRunnable) {
            processRequest((DispatchRunnable) runnable);
        }
        if (runnable instanceof FutureDispatch) {
            Callable callable = ((FutureDispatch) runnable).getCallable();
            if (callable instanceof DispatchCallable) {
                processRequest((DispatchCallable) callable);
            }
        }
    }

    public <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new FutureDispatch(callable);
    }
}
