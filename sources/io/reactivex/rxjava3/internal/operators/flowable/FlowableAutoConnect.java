package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.flowables.ConnectableFlowable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;

public final class FlowableAutoConnect<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final ConnectableFlowable<? extends T> f19311c;

    /* renamed from: d  reason: collision with root package name */
    public final int f19312d;

    /* renamed from: e  reason: collision with root package name */
    public final Consumer<? super Disposable> f19313e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicInteger f19314f = new AtomicInteger();

    public FlowableAutoConnect(ConnectableFlowable<? extends T> connectableFlowable, int i11, Consumer<? super Disposable> consumer) {
        this.f19311c = connectableFlowable;
        this.f19312d = i11;
        this.f19313e = consumer;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f19311c.subscribe(subscriber);
        if (this.f19314f.incrementAndGet() == this.f19312d) {
            this.f19311c.connect(this.f19313e);
        }
    }
}
