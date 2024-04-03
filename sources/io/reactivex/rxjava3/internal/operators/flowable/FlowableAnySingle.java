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

public final class FlowableAnySingle<T> extends Single<Boolean> implements FuseToFlowable<Boolean> {

    /* renamed from: b  reason: collision with root package name */
    public final Flowable<T> f19305b;

    /* renamed from: c  reason: collision with root package name */
    public final Predicate<? super T> f19306c;

    public static final class AnySubscriber<T> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super Boolean> f19307b;

        /* renamed from: c  reason: collision with root package name */
        public final Predicate<? super T> f19308c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f19309d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f19310e;

        public AnySubscriber(SingleObserver<? super Boolean> singleObserver, Predicate<? super T> predicate) {
            this.f19307b = singleObserver;
            this.f19308c = predicate;
        }

        public void dispose() {
            this.f19309d.cancel();
            this.f19309d = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f19309d == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            if (!this.f19310e) {
                this.f19310e = true;
                this.f19309d = SubscriptionHelper.CANCELLED;
                this.f19307b.onSuccess(Boolean.FALSE);
            }
        }

        public void onError(Throwable th2) {
            if (this.f19310e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f19310e = true;
            this.f19309d = SubscriptionHelper.CANCELLED;
            this.f19307b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f19310e) {
                try {
                    if (this.f19308c.test(t11)) {
                        this.f19310e = true;
                        this.f19309d.cancel();
                        this.f19309d = SubscriptionHelper.CANCELLED;
                        this.f19307b.onSuccess(Boolean.TRUE);
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f19309d.cancel();
                    this.f19309d = SubscriptionHelper.CANCELLED;
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f19309d, subscription)) {
                this.f19309d = subscription;
                this.f19307b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableAnySingle(Flowable<T> flowable, Predicate<? super T> predicate) {
        this.f19305b = flowable;
        this.f19306c = predicate;
    }

    public Flowable<Boolean> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableAny(this.f19305b, this.f19306c));
    }

    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.f19305b.subscribe(new AnySubscriber(singleObserver, this.f19306c));
    }
}
