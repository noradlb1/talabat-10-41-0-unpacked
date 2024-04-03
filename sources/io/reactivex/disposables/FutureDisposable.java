package io.reactivex.disposables;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

final class FutureDisposable extends AtomicReference<Future<?>> implements Disposable {
    private static final long serialVersionUID = 6545242830671168775L;
    private final boolean allowInterrupt;

    public FutureDisposable(Future<?> future, boolean z11) {
        super(future);
        this.allowInterrupt = z11;
    }

    public void dispose() {
        Future future = (Future) getAndSet((Object) null);
        if (future != null) {
            future.cancel(this.allowInterrupt);
        }
    }

    public boolean isDisposed() {
        Future future = (Future) get();
        if (future == null || future.isDone()) {
            return true;
        }
        return false;
    }
}
