package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class ScheduledDirectPeriodicTask extends AbstractDirectTask implements Runnable {
    private static final long serialVersionUID = 1811839108042568751L;

    public ScheduledDirectPeriodicTask(Runnable runnable, boolean z11) {
        super(runnable, z11);
    }

    public /* bridge */ /* synthetic */ Runnable getWrappedRunnable() {
        return super.getWrappedRunnable();
    }

    public void run() {
        this.f23020d = Thread.currentThread();
        try {
            this.f23018b.run();
            this.f23020d = null;
        } catch (Throwable th2) {
            dispose();
            this.f23020d = null;
            RxJavaPlugins.onError(th2);
            throw th2;
        }
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
