package io.reactivex.internal.schedulers;

import java.util.concurrent.Callable;

public final class ScheduledDirectTask extends AbstractDirectTask implements Callable<Void> {
    private static final long serialVersionUID = 1811839108042568751L;

    public ScheduledDirectTask(Runnable runnable) {
        super(runnable);
    }

    public /* bridge */ /* synthetic */ Runnable getWrappedRunnable() {
        return super.getWrappedRunnable();
    }

    public Void call() throws Exception {
        this.f18464c = Thread.currentThread();
        try {
            this.f18463b.run();
            return null;
        } finally {
            lazySet(AbstractDirectTask.f18461d);
            this.f18464c = null;
        }
    }
}
