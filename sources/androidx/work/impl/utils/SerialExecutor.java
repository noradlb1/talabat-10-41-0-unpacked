package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

public class SerialExecutor implements Executor {
    private volatile Runnable mActive;
    private final Executor mExecutor;
    private final Object mLock = new Object();
    private final ArrayDeque<Task> mTasks = new ArrayDeque<>();

    public static class Task implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final SerialExecutor f38135b;

        /* renamed from: c  reason: collision with root package name */
        public final Runnable f38136c;

        public Task(@NonNull SerialExecutor serialExecutor, @NonNull Runnable runnable) {
            this.f38135b = serialExecutor;
            this.f38136c = runnable;
        }

        public void run() {
            try {
                this.f38136c.run();
            } finally {
                this.f38135b.a();
            }
        }
    }

    public SerialExecutor(@NonNull Executor executor) {
        this.mExecutor = executor;
    }

    public void a() {
        synchronized (this.mLock) {
            Runnable poll = this.mTasks.poll();
            this.mActive = poll;
            if (poll != null) {
                this.mExecutor.execute(this.mActive);
            }
        }
    }

    public void execute(@NonNull Runnable runnable) {
        synchronized (this.mLock) {
            this.mTasks.add(new Task(this, runnable));
            if (this.mActive == null) {
                a();
            }
        }
    }

    @VisibleForTesting
    @NonNull
    public Executor getDelegatedExecutor() {
        return this.mExecutor;
    }

    public boolean hasPendingTasks() {
        boolean z11;
        synchronized (this.mLock) {
            if (!this.mTasks.isEmpty()) {
                z11 = true;
            } else {
                z11 = false;
            }
        }
        return z11;
    }
}
