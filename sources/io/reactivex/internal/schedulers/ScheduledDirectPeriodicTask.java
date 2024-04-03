package io.reactivex.internal.schedulers;

import io.reactivex.plugins.RxJavaPlugins;

public final class ScheduledDirectPeriodicTask extends AbstractDirectTask implements Runnable {
    private static final long serialVersionUID = 1811839108042568751L;

    public ScheduledDirectPeriodicTask(Runnable runnable) {
        super(runnable);
    }

    public /* bridge */ /* synthetic */ Runnable getWrappedRunnable() {
        return super.getWrappedRunnable();
    }

    public void run() {
        this.f18464c = Thread.currentThread();
        try {
            this.f18463b.run();
            this.f18464c = null;
        } catch (Throwable th2) {
            this.f18464c = null;
            lazySet(AbstractDirectTask.f18461d);
            RxJavaPlugins.onError(th2);
        }
    }
}
