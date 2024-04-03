package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WorkTimer {
    private static final String TAG = Logger.tagWithPrefix("WorkTimer");

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, WorkTimerRunnable> f38172a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, TimeLimitExceededListener> f38173b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final Object f38174c = new Object();
    private final ThreadFactory mBackgroundThreadFactory;
    private final ScheduledExecutorService mExecutorService;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface TimeLimitExceededListener {
        void onTimeLimitExceeded(@NonNull String str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class WorkTimerRunnable implements Runnable {
        private final String mWorkSpecId;
        private final WorkTimer mWorkTimer;

        public WorkTimerRunnable(@NonNull WorkTimer workTimer, @NonNull String str) {
            this.mWorkTimer = workTimer;
            this.mWorkSpecId = str;
        }

        public void run() {
            synchronized (this.mWorkTimer.f38174c) {
                if (this.mWorkTimer.f38172a.remove(this.mWorkSpecId) != null) {
                    TimeLimitExceededListener remove = this.mWorkTimer.f38173b.remove(this.mWorkSpecId);
                    if (remove != null) {
                        remove.onTimeLimitExceeded(this.mWorkSpecId);
                    }
                } else {
                    Logger.get().debug("WrkTimerRunnable", String.format("Timer with %s is already marked as complete.", new Object[]{this.mWorkSpecId}), new Throwable[0]);
                }
            }
        }
    }

    public WorkTimer() {
        AnonymousClass1 r02 = new ThreadFactory() {
            private int mThreadsCreated = 0;

            public Thread newThread(@NonNull Runnable runnable) {
                Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
                newThread.setName("WorkManager-WorkTimer-thread-" + this.mThreadsCreated);
                this.mThreadsCreated = this.mThreadsCreated + 1;
                return newThread;
            }
        };
        this.mBackgroundThreadFactory = r02;
        this.mExecutorService = Executors.newSingleThreadScheduledExecutor(r02);
    }

    @VisibleForTesting
    @NonNull
    public ScheduledExecutorService getExecutorService() {
        return this.mExecutorService;
    }

    @VisibleForTesting
    @NonNull
    public synchronized Map<String, TimeLimitExceededListener> getListeners() {
        return this.f38173b;
    }

    @VisibleForTesting
    @NonNull
    public synchronized Map<String, WorkTimerRunnable> getTimerMap() {
        return this.f38172a;
    }

    public void onDestroy() {
        if (!this.mExecutorService.isShutdown()) {
            this.mExecutorService.shutdownNow();
        }
    }

    public void startTimer(@NonNull String str, long j11, @NonNull TimeLimitExceededListener timeLimitExceededListener) {
        synchronized (this.f38174c) {
            Logger.get().debug(TAG, String.format("Starting timer for %s", new Object[]{str}), new Throwable[0]);
            stopTimer(str);
            WorkTimerRunnable workTimerRunnable = new WorkTimerRunnable(this, str);
            this.f38172a.put(str, workTimerRunnable);
            this.f38173b.put(str, timeLimitExceededListener);
            this.mExecutorService.schedule(workTimerRunnable, j11, TimeUnit.MILLISECONDS);
        }
    }

    public void stopTimer(@NonNull String str) {
        synchronized (this.f38174c) {
            if (this.f38172a.remove(str) != null) {
                Logger.get().debug(TAG, String.format("Stopping timer for %s", new Object[]{str}), new Throwable[0]);
                this.f38173b.remove(str);
            }
        }
    }
}
