package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableZipIterable<T, U, V> extends AbstractFlowableWithUpstream<T, V> {

    /* renamed from: d  reason: collision with root package name */
    public final Iterable<U> f16257d;

    /* renamed from: e  reason: collision with root package name */
    public final BiFunction<? super T, ? super U, ? extends V> f16258e;

    public static final class ZipIterableSubscriber<T, U, V> implements FlowableSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super V> f16259b;

        /* renamed from: c  reason: collision with root package name */
        public final Iterator<U> f16260c;

        /* renamed from: d  reason: collision with root package name */
        public final BiFunction<? super T, ? super U, ? extends V> f16261d;

        /* renamed from: e  reason: collision with root package name */
        public Subscription f16262e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f16263f;

        public ZipIterableSubscriber(Subscriber<? super V> subscriber, Iterator<U> it, BiFunction<? super T, ? super U, ? extends V> biFunction) {
            this.f16259b = subscriber;
            this.f16260c = it;
            this.f16261d = biFunction;
        }

        public void a(Throwable th2) {
            Exceptions.throwIfFatal(th2);
            this.f16263f = true;
            this.f16262e.cancel();
            this.f16259b.onError(th2);
        }

        public void cancel() {
            this.f16262e.cancel();
        }

        public void onComplete() {
            if (!this.f16263f) {
                this.f16263f = true;
                this.f16259b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f16263f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f16263f = true;
            this.f16259b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f16263f) {
                try {
                    try {
                        this.f16259b.onNext(ObjectHelper.requireNonNull(this.f16261d.apply(t11, ObjectHelper.requireNonNull(this.f16260c.next(), "The iterator returned a null value")), "The zipper function returned a null value"));
                        try {
                            if (!this.f16260c.hasNext()) {
                                this.f16263f = true;
                                this.f16262e.cancel();
                                this.f16259b.onComplete();
                            }
                        } catch (Throwable th2) {
                            a(th2);
                        }
                    } catch (Throwable th3) {
                        a(th3);
                    }
                } catch (Throwable th4) {
                    a(th4);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f16262e, subscription)) {
                this.f16262e = subscription;
                this.f16259b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f16262e.request(j11);
        }
    }

    public FlowableZipIterable(Flowable<T> flowable, Iterable<U> iterable, BiFunction<? super T, ? super U, ? extends V> biFunction) {
        super(flowable);
        this.f16257d = iterable;
        this.f16258e = biFunction;
    }

    public void subscribeActual(Subscriber<? super V> subscriber) {
        try {
            Iterator it = (Iterator) ObjectHelper.requireNonNull(this.f16257d.iterator(), "The iterator returned by other is null");
            try {
                if (!it.hasNext()) {
                    EmptySubscription.complete(subscriber);
                } else {
                    this.f14763c.subscribe(new ZipIterableSubscriber(subscriber, it, this.f16258e));
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                EmptySubscription.error(th2, subscriber);
            }
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            EmptySubscription.error(th3, subscriber);
        }
    }
}
