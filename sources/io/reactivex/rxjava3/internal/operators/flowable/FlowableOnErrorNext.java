package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableOnErrorNext<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super Throwable, ? extends Publisher<? extends T>> f20104d;

    public static final class OnErrorNextSubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 4063763155303814625L;

        /* renamed from: j  reason: collision with root package name */
        public final Subscriber<? super T> f20105j;

        /* renamed from: k  reason: collision with root package name */
        public final Function<? super Throwable, ? extends Publisher<? extends T>> f20106k;

        /* renamed from: l  reason: collision with root package name */
        public boolean f20107l;

        /* renamed from: m  reason: collision with root package name */
        public boolean f20108m;

        /* renamed from: n  reason: collision with root package name */
        public long f20109n;

        public OnErrorNextSubscriber(Subscriber<? super T> subscriber, Function<? super Throwable, ? extends Publisher<? extends T>> function) {
            super(false);
            this.f20105j = subscriber;
            this.f20106k = function;
        }

        public void onComplete() {
            if (!this.f20108m) {
                this.f20108m = true;
                this.f20107l = true;
                this.f20105j.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (!this.f20107l) {
                this.f20107l = true;
                try {
                    Object apply = this.f20106k.apply(th2);
                    Objects.requireNonNull(apply, "The nextSupplier returned a null Publisher");
                    Publisher publisher = (Publisher) apply;
                    long j11 = this.f20109n;
                    if (j11 != 0) {
                        produced(j11);
                    }
                    publisher.subscribe(this);
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    this.f20105j.onError(new CompositeException(th2, th3));
                }
            } else if (this.f20108m) {
                RxJavaPlugins.onError(th2);
            } else {
                this.f20105j.onError(th2);
            }
        }

        public void onNext(T t11) {
            if (!this.f20108m) {
                if (!this.f20107l) {
                    this.f20109n++;
                }
                this.f20105j.onNext(t11);
            }
        }

        public void onSubscribe(Subscription subscription) {
            setSubscription(subscription);
        }
    }

    public FlowableOnErrorNext(Flowable<T> flowable, Function<? super Throwable, ? extends Publisher<? extends T>> function) {
        super(flowable);
        this.f20104d = function;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        OnErrorNextSubscriber onErrorNextSubscriber = new OnErrorNextSubscriber(subscriber, this.f20104d);
        subscriber.onSubscribe(onErrorNextSubscriber);
        this.f19260c.subscribe(onErrorNextSubscriber);
    }
}
