package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public final class FlowableCountSingle<T> extends Single<Long> implements FuseToFlowable<Long> {

    /* renamed from: b  reason: collision with root package name */
    public final Flowable<T> f19552b;

    public static final class CountSubscriber implements FlowableSubscriber<Object>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super Long> f19553b;

        /* renamed from: c  reason: collision with root package name */
        public Subscription f19554c;

        /* renamed from: d  reason: collision with root package name */
        public long f19555d;

        public CountSubscriber(SingleObserver<? super Long> singleObserver) {
            this.f19553b = singleObserver;
        }

        public void dispose() {
            this.f19554c.cancel();
            this.f19554c = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f19554c == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            this.f19554c = SubscriptionHelper.CANCELLED;
            this.f19553b.onSuccess(Long.valueOf(this.f19555d));
        }

        public void onError(Throwable th2) {
            this.f19554c = SubscriptionHelper.CANCELLED;
            this.f19553b.onError(th2);
        }

        public void onNext(Object obj) {
            this.f19555d++;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f19554c, subscription)) {
                this.f19554c = subscription;
                this.f19553b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableCountSingle(Flowable<T> flowable) {
        this.f19552b = flowable;
    }

    public Flowable<Long> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableCount(this.f19552b));
    }

    public void subscribeActual(SingleObserver<? super Long> singleObserver) {
        this.f19552b.subscribe(new CountSubscriber(singleObserver));
    }
}
