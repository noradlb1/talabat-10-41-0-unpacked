package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public final class FlowableIgnoreElementsCompletable<T> extends Completable implements FuseToFlowable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Flowable<T> f19916b;

    public static final class IgnoreElementsSubscriber<T> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f19917b;

        /* renamed from: c  reason: collision with root package name */
        public Subscription f19918c;

        public IgnoreElementsSubscriber(CompletableObserver completableObserver) {
            this.f19917b = completableObserver;
        }

        public void dispose() {
            this.f19918c.cancel();
            this.f19918c = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f19918c == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            this.f19918c = SubscriptionHelper.CANCELLED;
            this.f19917b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f19918c = SubscriptionHelper.CANCELLED;
            this.f19917b.onError(th2);
        }

        public void onNext(T t11) {
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f19918c, subscription)) {
                this.f19918c = subscription;
                this.f19917b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableIgnoreElementsCompletable(Flowable<T> flowable) {
        this.f19916b = flowable;
    }

    public Flowable<T> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableIgnoreElements(this.f19916b));
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f19916b.subscribe(new IgnoreElementsSubscriber(completableObserver));
    }
}
