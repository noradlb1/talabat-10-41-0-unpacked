package androidx.arch.core.executor;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import i.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@SuppressLint({"SyntheticAccessor"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class TaskExecutorWithFakeMainThread extends TaskExecutor {

    /* renamed from: a  reason: collision with root package name */
    public List<Throwable> f925a = Collections.synchronizedList(new ArrayList());
    private ExecutorService mIOService;
    private final int mIOThreadCount;
    /* access modifiers changed from: private */
    public AtomicReference<Thread> mMainThread = new AtomicReference<>();
    private ExecutorService mMainThreadService = Executors.newSingleThreadExecutor(new ThreadFactory() {
        public Thread newThread(@NonNull Runnable runnable) {
            b.a(TaskExecutorWithFakeMainThread.this.mMainThread, (Object) null, new LoggingThread(runnable));
            return (Thread) TaskExecutorWithFakeMainThread.this.mMainThread.get();
        }
    });

    public class LoggingThread extends Thread {
        public LoggingThread(final Runnable runnable) {
            super(new Runnable() {
                public void run() {
                    try {
                        runnable.run();
                    } catch (Throwable th2) {
                        TaskExecutorWithFakeMainThread.this.f925a.add(th2);
                    }
                }
            });
        }
    }

    public TaskExecutorWithFakeMainThread(int i11) {
        this.mIOThreadCount = i11;
        this.mIOService = Executors.newFixedThreadPool(i11, new ThreadFactory() {
            public Thread newThread(@NonNull Runnable runnable) {
                return new LoggingThread(runnable);
            }
        });
    }

    public List<Throwable> b() {
        return this.f925a;
    }

    public void c(int i11) throws InterruptedException {
        this.mMainThreadService.shutdown();
        this.mIOService.shutdown();
        ExecutorService executorService = this.mMainThreadService;
        long j11 = (long) i11;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        executorService.awaitTermination(j11, timeUnit);
        this.mIOService.awaitTermination(j11, timeUnit);
    }

    public void drainTasks(int i11) throws InterruptedException {
        if (!isMainThread()) {
            final CountDownLatch countDownLatch = new CountDownLatch(this.mIOThreadCount);
            final CountDownLatch countDownLatch2 = new CountDownLatch(1);
            for (int i12 = 0; i12 < this.mIOThreadCount; i12++) {
                executeOnDiskIO(new Runnable() {
                    public void run() {
                        countDownLatch.countDown();
                        try {
                            countDownLatch2.await();
                        } catch (InterruptedException e11) {
                            throw new RuntimeException(e11);
                        }
                    }
                });
            }
            final CountDownLatch countDownLatch3 = new CountDownLatch(1);
            postToMainThread(new Runnable() {
                public void run() {
                    countDownLatch3.countDown();
                }
            });
            long j11 = (long) i11;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            if (countDownLatch.await(j11, timeUnit)) {
                countDownLatch2.countDown();
                if (!countDownLatch3.await(j11, timeUnit)) {
                    throw new AssertionError("Could not drain UI tasks in " + i11 + " seconds");
                }
                return;
            }
            throw new AssertionError("Could not drain IO tasks in " + i11 + " seconds");
        }
        throw new IllegalStateException();
    }

    public void executeOnDiskIO(Runnable runnable) {
        this.mIOService.execute(runnable);
    }

    public boolean isMainThread() {
        return Thread.currentThread() == this.mMainThread.get();
    }

    public void postToMainThread(Runnable runnable) {
        this.mMainThreadService.execute(runnable);
    }
}
