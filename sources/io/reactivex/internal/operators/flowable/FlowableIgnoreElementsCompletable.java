package io.reactivex.internal.operators.flowable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public final class FlowableIgnoreElementsCompletable<T> extends Completable implements FuseToFlowable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Flowable<T> f15400b;

    public static final class IgnoreElementsSubscriber<T> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f15401b;

        /* renamed from: c  reason: collision with root package name */
        public Subscription f15402c;

        public IgnoreElementsSubscriber(CompletableObserver completableObserver) {
            this.f15401b = completableObserver;
        }

        public void dispose() {
            this.f15402c.cancel();
            this.f15402c = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f15402c == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            this.f15402c = SubscriptionHelper.CANCELLED;
            this.f15401b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f15402c = SubscriptionHelper.CANCELLED;
            this.f15401b.onError(th2);
        }

        public void onNext(T t11) {
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15402c, subscription)) {
                this.f15402c = subscription;
                this.f15401b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableIgnoreElementsCompletable(Flowable<T> flowable) {
        this.f15400b = flowable;
    }

    public Flowable<T> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableIgnoreElements(this.f15400b));
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f15400b.subscribe(new IgnoreElementsSubscriber(completableObserver));
    }
}
