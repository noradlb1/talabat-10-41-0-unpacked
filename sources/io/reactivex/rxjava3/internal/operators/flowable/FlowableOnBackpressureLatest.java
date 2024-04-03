package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import org.reactivestreams.Subscriber;

public final class FlowableOnBackpressureLatest<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class BackpressureLatestSubscriber<T> extends AbstractBackpressureThrottlingSubscriber<T, T> {
        private static final long serialVersionUID = 163080509307634843L;

        public BackpressureLatestSubscriber(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public void onNext(T t11) {
            this.f19259h.lazySet(t11);
            b();
        }
    }

    public FlowableOnBackpressureLatest(Flowable<T> flowable) {
        super(flowable);
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f19260c.subscribe(new BackpressureLatestSubscriber(subscriber));
    }
}
