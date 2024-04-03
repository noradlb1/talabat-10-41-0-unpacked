package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public final class FlowableAllSingle<T> extends Single<Boolean> implements FuseToFlowable<Boolean> {

    /* renamed from: b  reason: collision with root package name */
    public final Flowable<T> f19285b;

    /* renamed from: c  reason: collision with root package name */
    public final Predicate<? super T> f19286c;

    public static final class AllSubscriber<T> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super Boolean> f19287b;

        /* renamed from: c  reason: collision with root package name */
        public final Predicate<? super T> f19288c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f19289d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f19290e;

        public AllSubscriber(SingleObserver<? super Boolean> singleObserver, Predicate<? super T> predicate) {
            this.f19287b = singleObserver;
            this.f19288c = predicate;
        }

        public void dispose() {
            this.f19289d.cancel();
            this.f19289d = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f19289d == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            if (!this.f19290e) {
                this.f19290e = true;
                this.f19289d = SubscriptionHelper.CANCELLED;
                this.f19287b.onSuccess(Boolean.TRUE);
            }
        }

        public void onError(Throwable th2) {
            if (this.f19290e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f19290e = true;
            this.f19289d = SubscriptionHelper.CANCELLED;
            this.f19287b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f19290e) {
                try {
                    if (!this.f19288c.test(t11)) {
                        this.f19290e = true;
                        this.f19289d.cancel();
                        this.f19289d = SubscriptionHelper.CANCELLED;
                        this.f19287b.onSuccess(Boolean.FALSE);
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f19289d.cancel();
                    this.f19289d = SubscriptionHelper.CANCELLED;
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f19289d, subscription)) {
                this.f19289d = subscription;
                this.f19287b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableAllSingle(Flowable<T> flowable, Predicate<? super T> predicate) {
        this.f19285b = flowable;
        this.f19286c = predicate;
    }

    public Flowable<Boolean> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableAll(this.f19285b, this.f19286c));
    }

    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.f19285b.subscribe(new AllSubscriber(singleObserver, this.f19286c));
    }
}
