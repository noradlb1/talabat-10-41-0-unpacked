package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observables.ConnectableObservable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableAutoConnect<T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ConnectableObservable<? extends T> f16848b;

    /* renamed from: c  reason: collision with root package name */
    public final int f16849c;

    /* renamed from: d  reason: collision with root package name */
    public final Consumer<? super Disposable> f16850d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicInteger f16851e = new AtomicInteger();

    public ObservableAutoConnect(ConnectableObservable<? extends T> connectableObservable, int i11, Consumer<? super Disposable> consumer) {
        this.f16848b = connectableObservable;
        this.f16849c = i11;
        this.f16850d = consumer;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f16848b.subscribe(observer);
        if (this.f16851e.incrementAndGet() == this.f16849c) {
            this.f16848b.connect(this.f16850d);
        }
    }
}
