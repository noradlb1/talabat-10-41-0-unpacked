package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableZipIterable<T, U, V> extends AbstractFlowableWithUpstream<T, V> {

    /* renamed from: d  reason: collision with root package name */
    public final Iterable<U> f20756d;

    /* renamed from: e  reason: collision with root package name */
    public final BiFunction<? super T, ? super U, ? extends V> f20757e;

    public static final class ZipIterableSubscriber<T, U, V> implements FlowableSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super V> f20758b;

        /* renamed from: c  reason: collision with root package name */
        public final Iterator<U> f20759c;

        /* renamed from: d  reason: collision with root package name */
        public final BiFunction<? super T, ? super U, ? extends V> f20760d;

        /* renamed from: e  reason: collision with root package name */
        public Subscription f20761e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f20762f;

        public ZipIterableSubscriber(Subscriber<? super V> subscriber, Iterator<U> it, BiFunction<? super T, ? super U, ? extends V> biFunction) {
            this.f20758b = subscriber;
            this.f20759c = it;
            this.f20760d = biFunction;
        }

        public void a(Throwable th2) {
            Exceptions.throwIfFatal(th2);
            this.f20762f = true;
            this.f20761e.cancel();
            this.f20758b.onError(th2);
        }

        public void cancel() {
            this.f20761e.cancel();
        }

        public void onComplete() {
            if (!this.f20762f) {
                this.f20762f = true;
                this.f20758b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f20762f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f20762f = true;
            this.f20758b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f20762f) {
                try {
                    U next = this.f20759c.next();
                    Objects.requireNonNull(next, "The iterator returned a null value");
                    try {
                        Object apply = this.f20760d.apply(t11, next);
                        Objects.requireNonNull(apply, "The zipper function returned a null value");
                        this.f20758b.onNext(apply);
                        try {
                            if (!this.f20759c.hasNext()) {
                                this.f20762f = true;
                                this.f20761e.cancel();
                                this.f20758b.onComplete();
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
            if (SubscriptionHelper.validate(this.f20761e, subscription)) {
                this.f20761e = subscription;
                this.f20758b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f20761e.request(j11);
        }
    }

    public FlowableZipIterable(Flowable<T> flowable, Iterable<U> iterable, BiFunction<? super T, ? super U, ? extends V> biFunction) {
        super(flowable);
        this.f20756d = iterable;
        this.f20757e = biFunction;
    }

    public void subscribeActual(Subscriber<? super V> subscriber) {
        try {
            Iterator<U> it = this.f20756d.iterator();
            Objects.requireNonNull(it, "The iterator returned by other is null");
            Iterator it2 = it;
            try {
                if (!it2.hasNext()) {
                    EmptySubscription.complete(subscriber);
                } else {
                    this.f19260c.subscribe(new ZipIterableSubscriber(subscriber, it2, this.f20757e));
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
