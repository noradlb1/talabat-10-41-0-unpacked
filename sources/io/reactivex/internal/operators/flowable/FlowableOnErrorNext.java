package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableOnErrorNext<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super Throwable, ? extends Publisher<? extends T>> f15578d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f15579e;

    public static final class OnErrorNextSubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 4063763155303814625L;

        /* renamed from: j  reason: collision with root package name */
        public final Subscriber<? super T> f15580j;

        /* renamed from: k  reason: collision with root package name */
        public final Function<? super Throwable, ? extends Publisher<? extends T>> f15581k;

        /* renamed from: l  reason: collision with root package name */
        public final boolean f15582l;

        /* renamed from: m  reason: collision with root package name */
        public boolean f15583m;

        /* renamed from: n  reason: collision with root package name */
        public boolean f15584n;

        /* renamed from: o  reason: collision with root package name */
        public long f15585o;

        public OnErrorNextSubscriber(Subscriber<? super T> subscriber, Function<? super Throwable, ? extends Publisher<? extends T>> function, boolean z11) {
            super(false);
            this.f15580j = subscriber;
            this.f15581k = function;
            this.f15582l = z11;
        }

        public void onComplete() {
            if (!this.f15584n) {
                this.f15584n = true;
                this.f15583m = true;
                this.f15580j.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (!this.f15583m) {
                this.f15583m = true;
                if (!this.f15582l || (th2 instanceof Exception)) {
                    try {
                        Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.f15581k.apply(th2), "The nextSupplier returned a null Publisher");
                        long j11 = this.f15585o;
                        if (j11 != 0) {
                            produced(j11);
                        }
                        publisher.subscribe(this);
                    } catch (Throwable th3) {
                        Exceptions.throwIfFatal(th3);
                        this.f15580j.onError(new CompositeException(th2, th3));
                    }
                } else {
                    this.f15580j.onError(th2);
                }
            } else if (this.f15584n) {
                RxJavaPlugins.onError(th2);
            } else {
                this.f15580j.onError(th2);
            }
        }

        public void onNext(T t11) {
            if (!this.f15584n) {
                if (!this.f15583m) {
                    this.f15585o++;
                }
                this.f15580j.onNext(t11);
            }
        }

        public void onSubscribe(Subscription subscription) {
            setSubscription(subscription);
        }
    }

    public FlowableOnErrorNext(Flowable<T> flowable, Function<? super Throwable, ? extends Publisher<? extends T>> function, boolean z11) {
        super(flowable);
        this.f15578d = function;
        this.f15579e = z11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        OnErrorNextSubscriber onErrorNextSubscriber = new OnErrorNextSubscriber(subscriber, this.f15578d, this.f15579e);
        subscriber.onSubscribe(onErrorNextSubscriber);
        this.f14763c.subscribe(onErrorNextSubscriber);
    }
}
