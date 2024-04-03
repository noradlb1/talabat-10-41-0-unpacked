package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableAutoConnect<T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ConnectableObservable<? extends T> f21353b;

    /* renamed from: c  reason: collision with root package name */
    public final int f21354c;

    /* renamed from: d  reason: collision with root package name */
    public final Consumer<? super Disposable> f21355d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicInteger f21356e = new AtomicInteger();

    public ObservableAutoConnect(ConnectableObservable<? extends T> connectableObservable, int i11, Consumer<? super Disposable> consumer) {
        this.f21353b = connectableObservable;
        this.f21354c = i11;
        this.f21355d = consumer;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f21353b.subscribe(observer);
        if (this.f21356e.incrementAndGet() == this.f21354c) {
            this.f21353b.connect(this.f21355d);
        }
    }
}
