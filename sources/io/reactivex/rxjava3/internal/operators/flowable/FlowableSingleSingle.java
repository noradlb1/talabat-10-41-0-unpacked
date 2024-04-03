package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import org.reactivestreams.Subscription;

public final class FlowableSingleSingle<T> extends Single<T> implements FuseToFlowable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Flowable<T> f20358b;

    /* renamed from: c  reason: collision with root package name */
    public final T f20359c;

    public static final class SingleElementSubscriber<T> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f20360b;

        /* renamed from: c  reason: collision with root package name */
        public final T f20361c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f20362d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f20363e;

        /* renamed from: f  reason: collision with root package name */
        public T f20364f;

        public SingleElementSubscriber(SingleObserver<? super T> singleObserver, T t11) {
            this.f20360b = singleObserver;
            this.f20361c = t11;
        }

        public void dispose() {
            this.f20362d.cancel();
            this.f20362d = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f20362d == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            if (!this.f20363e) {
                this.f20363e = true;
                this.f20362d = SubscriptionHelper.CANCELLED;
                T t11 = this.f20364f;
                this.f20364f = null;
                if (t11 == null) {
                    t11 = this.f20361c;
                }
                if (t11 != null) {
                    this.f20360b.onSuccess(t11);
                } else {
                    this.f20360b.onError(new NoSuchElementException());
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f20363e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f20363e = true;
            this.f20362d = SubscriptionHelper.CANCELLED;
            this.f20360b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f20363e) {
                if (this.f20364f != null) {
                    this.f20363e = true;
                    this.f20362d.cancel();
                    this.f20362d = SubscriptionHelper.CANCELLED;
                    this.f20360b.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.f20364f = t11;
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f20362d, subscription)) {
                this.f20362d = subscription;
                this.f20360b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableSingleSingle(Flowable<T> flowable, T t11) {
        this.f20358b = flowable;
        this.f20359c = t11;
    }

    public Flowable<T> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableSingle(this.f20358b, this.f20359c, true));
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f20358b.subscribe(new SingleElementSubscriber(singleObserver, this.f20359c));
    }
}
