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

public final class FlowableAnySingle<T> extends Single<Boolean> implements FuseToFlowable<Boolean> {

    /* renamed from: b  reason: collision with root package name */
    public final Flowable<T> f14808b;

    /* renamed from: c  reason: collision with root package name */
    public final Predicate<? super T> f14809c;

    public static final class AnySubscriber<T> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super Boolean> f14810b;

        /* renamed from: c  reason: collision with root package name */
        public final Predicate<? super T> f14811c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f14812d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f14813e;

        public AnySubscriber(SingleObserver<? super Boolean> singleObserver, Predicate<? super T> predicate) {
            this.f14810b = singleObserver;
            this.f14811c = predicate;
        }

        public void dispose() {
            this.f14812d.cancel();
            this.f14812d = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f14812d == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            if (!this.f14813e) {
                this.f14813e = true;
                this.f14812d = SubscriptionHelper.CANCELLED;
                this.f14810b.onSuccess(Boolean.FALSE);
            }
        }

        public void onError(Throwable th2) {
            if (this.f14813e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f14813e = true;
            this.f14812d = SubscriptionHelper.CANCELLED;
            this.f14810b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f14813e) {
                try {
                    if (this.f14811c.test(t11)) {
                        this.f14813e = true;
                        this.f14812d.cancel();
                        this.f14812d = SubscriptionHelper.CANCELLED;
                        this.f14810b.onSuccess(Boolean.TRUE);
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f14812d.cancel();
                    this.f14812d = SubscriptionHelper.CANCELLED;
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f14812d, subscription)) {
                this.f14812d = subscription;
                this.f14810b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableAnySingle(Flowable<T> flowable, Predicate<? super T> predicate) {
        this.f14808b = flowable;
        this.f14809c = predicate;
    }

    public Flowable<Boolean> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableAny(this.f14808b, this.f14809c));
    }

    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.f14808b.subscribe(new AnySubscriber(singleObserver, this.f14809c));
    }
}
