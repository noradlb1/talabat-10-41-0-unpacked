package androidx.room;

import androidx.annotation.NonNull;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

class TransactionExecutor implements Executor {
    private Runnable mActive;
    private final Executor mExecutor;
    private final ArrayDeque<Runnable> mTasks = new ArrayDeque<>();

    public TransactionExecutor(@NonNull Executor executor) {
        this.mExecutor = executor;
    }

    public synchronized void a() {
        Runnable poll = this.mTasks.poll();
        this.mActive = poll;
        if (poll != null) {
            this.mExecutor.execute(poll);
        }
    }

    public synchronized void execute(final Runnable runnable) {
        this.mTasks.offer(new Runnable() {
            public void run() {
                try {
                    runnable.run();
                } finally {
                    TransactionExecutor.this.a();
                }
            }
        });
        if (this.mActive == null) {
            a();
        }
    }
}
