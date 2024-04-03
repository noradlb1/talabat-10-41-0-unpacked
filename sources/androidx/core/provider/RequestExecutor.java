package androidx.core.provider;

import android.os.Handler;
import android.os.Process;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class RequestExecutor {

    public static class DefaultThreadFactory implements ThreadFactory {
        private int mPriority;
        private String mThreadName;

        public static class ProcessPriorityThread extends Thread {
            private final int mPriority;

            public ProcessPriorityThread(Runnable runnable, String str, int i11) {
                super(runnable, str);
                this.mPriority = i11;
            }

            public void run() {
                Process.setThreadPriority(this.mPriority);
                super.run();
            }
        }

        public DefaultThreadFactory(@NonNull String str, int i11) {
            this.mThreadName = str;
            this.mPriority = i11;
        }

        public Thread newThread(Runnable runnable) {
            return new ProcessPriorityThread(runnable, this.mThreadName, this.mPriority);
        }
    }

    public static class HandlerExecutor implements Executor {
        private final Handler mHandler;

        public HandlerExecutor(@NonNull Handler handler) {
            this.mHandler = (Handler) Preconditions.checkNotNull(handler);
        }

        public void execute(@NonNull Runnable runnable) {
            if (!this.mHandler.post((Runnable) Preconditions.checkNotNull(runnable))) {
                throw new RejectedExecutionException(this.mHandler + " is shutting down");
            }
        }
    }

    public static class ReplyRunnable<T> implements Runnable {
        @NonNull
        private Callable<T> mCallable;
        @NonNull
        private Consumer<T> mConsumer;
        @NonNull
        private Handler mHandler;

        public ReplyRunnable(@NonNull Handler handler, @NonNull Callable<T> callable, @NonNull Consumer<T> consumer) {
            this.mCallable = callable;
            this.mConsumer = consumer;
            this.mHandler = handler;
        }

        public void run() {
            final T t11;
            try {
                t11 = this.mCallable.call();
            } catch (Exception unused) {
                t11 = null;
            }
            final Consumer<T> consumer = this.mConsumer;
            this.mHandler.post(new Runnable() {
                public void run() {
                    consumer.accept(t11);
                }
            });
        }
    }

    private RequestExecutor() {
    }

    public static ThreadPoolExecutor a(@NonNull String str, int i11, @IntRange(from = 0) int i12) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, (long) i12, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new DefaultThreadFactory(str, i11));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static Executor b(@NonNull Handler handler) {
        return new HandlerExecutor(handler);
    }

    public static <T> void c(@NonNull Executor executor, @NonNull Callable<T> callable, @NonNull Consumer<T> consumer) {
        executor.execute(new ReplyRunnable(CalleeHandler.a(), callable, consumer));
    }

    public static <T> T d(@NonNull ExecutorService executorService, @NonNull Callable<T> callable, @IntRange(from = 0) int i11) throws InterruptedException {
        try {
            return executorService.submit(callable).get((long) i11, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e11) {
            throw new RuntimeException(e11);
        } catch (InterruptedException e12) {
            throw e12;
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
