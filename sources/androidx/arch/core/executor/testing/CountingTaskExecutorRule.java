package androidx.arch.core.executor.testing;

import android.os.SystemClock;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.executor.DefaultTaskExecutor;
import androidx.arch.core.executor.TaskExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class CountingTaskExecutorRule extends TestWatcher {
    private final Object mCountLock = new Object();
    private int mTaskCount = 0;

    public class CountingRunnable implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final Runnable f937b;

        public CountingRunnable(Runnable runnable) {
            this.f937b = runnable;
            CountingTaskExecutorRule.this.m();
        }

        public void run() {
            try {
                this.f937b.run();
            } finally {
                CountingTaskExecutorRule.this.l();
            }
        }
    }

    public void drainTasks(int i11, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        long uptimeMillis = SystemClock.uptimeMillis() + timeUnit.toMillis((long) i11);
        synchronized (this.mCountLock) {
            while (this.mTaskCount != 0) {
                long uptimeMillis2 = uptimeMillis - SystemClock.uptimeMillis();
                if (uptimeMillis2 > 0) {
                    this.mCountLock.wait(uptimeMillis2);
                } else {
                    throw new TimeoutException("could not drain tasks");
                }
            }
        }
    }

    public void g(Description description) {
        super.g(description);
        ArchTaskExecutor.getInstance().setDelegate((TaskExecutor) null);
    }

    public boolean isIdle() {
        boolean z11;
        synchronized (this.mCountLock) {
            if (this.mTaskCount == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
        }
        return z11;
    }

    public void j(Description description) {
        super.j(description);
        ArchTaskExecutor.getInstance().setDelegate(new DefaultTaskExecutor() {
            public void executeOnDiskIO(Runnable runnable) {
                super.executeOnDiskIO(new CountingRunnable(runnable));
            }

            public void postToMainThread(Runnable runnable) {
                super.postToMainThread(new CountingRunnable(runnable));
            }
        });
    }

    public void l() {
        synchronized (this.mCountLock) {
            int i11 = this.mTaskCount - 1;
            this.mTaskCount = i11;
            if (i11 == 0) {
                n();
                this.mCountLock.notifyAll();
            }
        }
    }

    public void m() {
        synchronized (this.mCountLock) {
            this.mTaskCount++;
        }
    }

    public void n() {
    }
}
