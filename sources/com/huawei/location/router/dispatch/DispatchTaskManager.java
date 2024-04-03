package com.huawei.location.router.dispatch;

import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.ExecutorManager;
import com.huawei.location.router.entity.IRouterResponse;
import com.huawei.location.router.entity.RouterRequest;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class DispatchTaskManager {
    private static final long KEEP_ALIVE_TIME = 60;
    private static final String LOCATION_DISPATCH_TASK_MANAGER = "Location_DispatchTaskManager";
    private static final int THREAD_CORE = Runtime.getRuntime().availableProcessors();
    private static final int THREAD_TIME_OUT_SECONDS = 3;
    private ThreadPoolExecutor mExecutorService;

    public static class Vw {
        /* access modifiers changed from: private */

        /* renamed from: yn  reason: collision with root package name */
        public static final DispatchTaskManager f50213yn = new DispatchTaskManager();
    }

    private DispatchTaskManager() {
        init();
    }

    public static DispatchTaskManager getInstance() {
        return Vw.f50213yn;
    }

    private void init() {
        int i11 = THREAD_CORE;
        DispatchThreadPoolExecutor dispatchThreadPoolExecutor = new DispatchThreadPoolExecutor(i11, i11 * 2, 60, TimeUnit.SECONDS, new LinkedBlockingDeque(), ExecutorManager.createThreadFactory(LOCATION_DISPATCH_TASK_MANAGER));
        this.mExecutorService = dispatchThreadPoolExecutor;
        dispatchThreadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public void dispatchTask(RouterRequest routerRequest) {
        ThreadPoolExecutor threadPoolExecutor = this.mExecutorService;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.execute(new DispatchRunnable(routerRequest));
        }
    }

    public IRouterResponse executeTask(RouterRequest routerRequest) {
        ThreadPoolExecutor threadPoolExecutor = this.mExecutorService;
        if (threadPoolExecutor == null) {
            return null;
        }
        try {
            return (IRouterResponse) threadPoolExecutor.submit(new DispatchCallable(routerRequest)).get(3, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException unused) {
            LogConsole.e("DispatchTaskManager", "enqueue task failed");
            return null;
        }
    }
}
