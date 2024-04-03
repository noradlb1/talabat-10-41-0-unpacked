package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.processors.FlowableProcessor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscriber;

final class FlowableWindowSubscribeIntercept<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final FlowableProcessor<T> f20669c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicBoolean f20670d = new AtomicBoolean();

    public FlowableWindowSubscribeIntercept(FlowableProcessor<T> flowableProcessor) {
        this.f20669c = flowableProcessor;
    }

    public boolean b() {
        return !this.f20670d.get() && this.f20670d.compareAndSet(false, true);
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f20669c.subscribe(subscriber);
        this.f20670d.set(true);
    }
}
