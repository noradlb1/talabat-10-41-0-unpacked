package io.reactivex.disposables;

import io.reactivex.annotations.NonNull;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

abstract class ReferenceDisposable<T> extends AtomicReference<T> implements Disposable {
    private static final long serialVersionUID = 6537757548749041217L;

    public ReferenceDisposable(T t11) {
        super(ObjectHelper.requireNonNull(t11, "value is null"));
    }

    public abstract void a(@NonNull T t11);

    public final void dispose() {
        Object andSet;
        if (get() != null && (andSet = getAndSet((Object) null)) != null) {
            a(andSet);
        }
    }

    public final boolean isDisposed() {
        return get() == null;
    }
}
