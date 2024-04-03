package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Objects;

public final class ObservableDefer<T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Supplier<? extends ObservableSource<? extends T>> f21617b;

    public ObservableDefer(Supplier<? extends ObservableSource<? extends T>> supplier) {
        this.f21617b = supplier;
    }

    public void subscribeActual(Observer<? super T> observer) {
        try {
            Object obj = this.f21617b.get();
            Objects.requireNonNull(obj, "The supplier returned a null ObservableSource");
            ((ObservableSource) obj).subscribe(observer);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (Observer<?>) observer);
        }
    }
}
