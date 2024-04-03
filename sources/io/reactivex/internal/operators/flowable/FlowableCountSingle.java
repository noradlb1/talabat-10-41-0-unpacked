package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public final class FlowableCountSingle<T> extends Single<Long> implements FuseToFlowable<Long> {

    /* renamed from: b  reason: collision with root package name */
    public final Flowable<T> f15046b;

    public static final class CountSubscriber implements FlowableSubscriber<Object>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super Long> f15047b;

        /* renamed from: c  reason: collision with root package name */
        public Subscription f15048c;

        /* renamed from: d  reason: collision with root package name */
        public long f15049d;

        public CountSubscriber(SingleObserver<? super Long> singleObserver) {
            this.f15047b = singleObserver;
        }

        public void dispose() {
            this.f15048c.cancel();
            this.f15048c = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f15048c == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            this.f15048c = SubscriptionHelper.CANCELLED;
            this.f15047b.onSuccess(Long.valueOf(this.f15049d));
        }

        public void onError(Throwable th2) {
            this.f15048c = SubscriptionHelper.CANCELLED;
            this.f15047b.onError(th2);
        }

        public void onNext(Object obj) {
            this.f15049d++;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15048c, subscription)) {
                this.f15048c = subscription;
                this.f15047b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableCountSingle(Flowable<T> flowable) {
        this.f15046b = flowable;
    }

    public Flowable<Long> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableCount(this.f15046b));
    }

    public void subscribeActual(SingleObserver<? super Long> singleObserver) {
        this.f15046b.subscribe(new CountSubscriber(singleObserver));
    }
}
