package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class ScheduledDirectTask extends AbstractDirectTask implements Callable<Void> {
    private static final long serialVersionUID = 1811839108042568751L;

    public ScheduledDirectTask(Runnable runnable, boolean z11) {
        super(runnable, z11);
    }

    public /* bridge */ /* synthetic */ Runnable getWrappedRunnable() {
        return super.getWrappedRunnable();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public Void call() {
        this.f23020d = Thread.currentThread();
        try {
            this.f23018b.run();
            lazySet(AbstractDirectTask.f23016e);
            this.f23020d = null;
            return null;
        } catch (Throwable th2) {
            RxJavaPlugins.onError(th2);
            throw th2;
        }
    }
}
