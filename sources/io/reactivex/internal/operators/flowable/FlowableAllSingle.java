package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public final class FlowableAllSingle<T> extends Single<Boolean> implements FuseToFlowable<Boolean> {

    /* renamed from: b  reason: collision with root package name */
    public final Flowable<T> f14788b;

    /* renamed from: c  reason: collision with root package name */
    public final Predicate<? super T> f14789c;

    public static final class AllSubscriber<T> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super Boolean> f14790b;

        /* renamed from: c  reason: collision with root package name */
        public final Predicate<? super T> f14791c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f14792d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f14793e;

        public AllSubscriber(SingleObserver<? super Boolean> singleObserver, Predicate<? super T> predicate) {
            this.f14790b = singleObserver;
            this.f14791c = predicate;
        }

        public void dispose() {
            this.f14792d.cancel();
            this.f14792d = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f14792d == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            if (!this.f14793e) {
                this.f14793e = true;
                this.f14792d = SubscriptionHelper.CANCELLED;
                this.f14790b.onSuccess(Boolean.TRUE);
            }
        }

        public void onError(Throwable th2) {
            if (this.f14793e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f14793e = true;
            this.f14792d = SubscriptionHelper.CANCELLED;
            this.f14790b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f14793e) {
                try {
                    if (!this.f14791c.test(t11)) {
                        this.f14793e = true;
                        this.f14792d.cancel();
                        this.f14792d = SubscriptionHelper.CANCELLED;
                        this.f14790b.onSuccess(Boolean.FALSE);
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f14792d.cancel();
                    this.f14792d = SubscriptionHelper.CANCELLED;
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f14792d, subscription)) {
                this.f14792d = subscription;
                this.f14790b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableAllSingle(Flowable<T> flowable, Predicate<? super T> predicate) {
        this.f14788b = flowable;
        this.f14789c = predicate;
    }

    public Flowable<Boolean> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableAll(this.f14788b, this.f14789c));
    }

    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.f14788b.subscribe(new AllSubscriber(singleObserver, this.f14789c));
    }
}
