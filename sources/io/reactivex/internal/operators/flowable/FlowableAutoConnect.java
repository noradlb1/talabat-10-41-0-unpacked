package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;

public final class FlowableAutoConnect<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final ConnectableFlowable<? extends T> f14814c;

    /* renamed from: d  reason: collision with root package name */
    public final int f14815d;

    /* renamed from: e  reason: collision with root package name */
    public final Consumer<? super Disposable> f14816e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicInteger f14817f = new AtomicInteger();

    public FlowableAutoConnect(ConnectableFlowable<? extends T> connectableFlowable, int i11, Consumer<? super Disposable> consumer) {
        this.f14814c = connectableFlowable;
        this.f14815d = i11;
        this.f14816e = consumer;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f14814c.subscribe(subscriber);
        if (this.f14817f.incrementAndGet() == this.f14815d) {
            this.f14814c.connect(this.f14816e);
        }
    }
}
