package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableAmb<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<? extends T>[] f14794c;

    /* renamed from: d  reason: collision with root package name */
    public final Iterable<? extends Publisher<? extends T>> f14795d;

    public static final class AmbCoordinator<T> implements Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f14796b;

        /* renamed from: c  reason: collision with root package name */
        public final AmbInnerSubscriber<T>[] f14797c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicInteger f14798d = new AtomicInteger();

        public AmbCoordinator(Subscriber<? super T> subscriber, int i11) {
            this.f14796b = subscriber;
            this.f14797c = new AmbInnerSubscriber[i11];
        }

        public void cancel() {
            if (this.f14798d.get() != -1) {
                this.f14798d.lazySet(-1);
                for (AmbInnerSubscriber<T> cancel : this.f14797c) {
                    cancel.cancel();
                }
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                int i11 = this.f14798d.get();
                if (i11 > 0) {
                    this.f14797c[i11 - 1].request(j11);
                } else if (i11 == 0) {
                    for (AmbInnerSubscriber<T> request : this.f14797c) {
                        request.request(j11);
                    }
                }
            }
        }

        public void subscribe(Publisher<? extends T>[] publisherArr) {
            AmbInnerSubscriber<T>[] ambInnerSubscriberArr = this.f14797c;
            int length = ambInnerSubscriberArr.length;
            int i11 = 0;
            while (i11 < length) {
                int i12 = i11 + 1;
                ambInnerSubscriberArr[i11] = new AmbInnerSubscriber<>(this, i12, this.f14796b);
                i11 = i12;
            }
            this.f14798d.lazySet(0);
            this.f14796b.onSubscribe(this);
            for (int i13 = 0; i13 < length && this.f14798d.get() == 0; i13++) {
                publisherArr[i13].subscribe(ambInnerSubscriberArr[i13]);
            }
        }

        public boolean win(int i11) {
            int i12 = 0;
            if (this.f14798d.get() != 0 || !this.f14798d.compareAndSet(0, i11)) {
                return false;
            }
            AmbInnerSubscriber<T>[] ambInnerSubscriberArr = this.f14797c;
            int length = ambInnerSubscriberArr.length;
            while (i12 < length) {
                int i13 = i12 + 1;
                if (i13 != i11) {
                    ambInnerSubscriberArr[i12].cancel();
                }
                i12 = i13;
            }
            return true;
        }
    }

    public static final class AmbInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -1185974347409665484L;

        /* renamed from: b  reason: collision with root package name */
        public final AmbCoordinator<T> f14799b;

        /* renamed from: c  reason: collision with root package name */
        public final int f14800c;

        /* renamed from: d  reason: collision with root package name */
        public final Subscriber<? super T> f14801d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f14802e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicLong f14803f = new AtomicLong();

        public AmbInnerSubscriber(AmbCoordinator<T> ambCoordinator, int i11, Subscriber<? super T> subscriber) {
            this.f14799b = ambCoordinator;
            this.f14800c = i11;
            this.f14801d = subscriber;
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        public void onComplete() {
            if (this.f14802e) {
                this.f14801d.onComplete();
            } else if (this.f14799b.win(this.f14800c)) {
                this.f14802e = true;
                this.f14801d.onComplete();
            } else {
                ((Subscription) get()).cancel();
            }
        }

        public void onError(Throwable th2) {
            if (this.f14802e) {
                this.f14801d.onError(th2);
            } else if (this.f14799b.win(this.f14800c)) {
                this.f14802e = true;
                this.f14801d.onError(th2);
            } else {
                ((Subscription) get()).cancel();
                RxJavaPlugins.onError(th2);
            }
        }

        public void onNext(T t11) {
            if (this.f14802e) {
                this.f14801d.onNext(t11);
            } else if (this.f14799b.win(this.f14800c)) {
                this.f14802e = true;
                this.f14801d.onNext(t11);
            } else {
                ((Subscription) get()).cancel();
            }
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this, this.f14803f, subscription);
        }

        public void request(long j11) {
            SubscriptionHelper.deferredRequest(this, this.f14803f, j11);
        }
    }

    public FlowableAmb(Publisher<? extends T>[] publisherArr, Iterable<? extends Publisher<? extends T>> iterable) {
        this.f14794c = publisherArr;
        this.f14795d = iterable;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        int i11;
        Publisher<? extends T>[] publisherArr = this.f14794c;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            try {
                i11 = 0;
                for (Publisher<? extends T> publisher : this.f14795d) {
                    if (publisher == null) {
                        EmptySubscription.error(new NullPointerException("One of the sources is null"), subscriber);
                        return;
                    }
                    if (i11 == publisherArr.length) {
                        Publisher<? extends T>[] publisherArr2 = new Publisher[((i11 >> 2) + i11)];
                        System.arraycopy(publisherArr, 0, publisherArr2, 0, i11);
                        publisherArr = publisherArr2;
                    }
                    int i12 = i11 + 1;
                    publisherArr[i11] = publisher;
                    i11 = i12;
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                EmptySubscription.error(th2, subscriber);
                return;
            }
        } else {
            i11 = publisherArr.length;
        }
        if (i11 == 0) {
            EmptySubscription.complete(subscriber);
        } else if (i11 == 1) {
            publisherArr[0].subscribe(subscriber);
        } else {
            new AmbCoordinator(subscriber, i11).subscribe(publisherArr);
        }
    }
}
