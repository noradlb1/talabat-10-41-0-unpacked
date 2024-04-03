package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.QueueSubscription;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableZip<T, R> extends Flowable<R> {

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<? extends T>[] f20736c;

    /* renamed from: d  reason: collision with root package name */
    public final Iterable<? extends Publisher<? extends T>> f20737d;

    /* renamed from: e  reason: collision with root package name */
    public final Function<? super Object[], ? extends R> f20738e;

    /* renamed from: f  reason: collision with root package name */
    public final int f20739f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f20740g;

    public static final class ZipCoordinator<T, R> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = -2434867452883857743L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f20741b;

        /* renamed from: c  reason: collision with root package name */
        public final ZipSubscriber<T, R>[] f20742c;

        /* renamed from: d  reason: collision with root package name */
        public final Function<? super Object[], ? extends R> f20743d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicLong f20744e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicThrowable f20745f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f20746g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f20747h;

        /* renamed from: i  reason: collision with root package name */
        public final Object[] f20748i;

        public ZipCoordinator(Subscriber<? super R> subscriber, Function<? super Object[], ? extends R> function, int i11, int i12, boolean z11) {
            this.f20741b = subscriber;
            this.f20743d = function;
            this.f20746g = z11;
            ZipSubscriber<T, R>[] zipSubscriberArr = new ZipSubscriber[i11];
            for (int i13 = 0; i13 < i11; i13++) {
                zipSubscriberArr[i13] = new ZipSubscriber<>(this, i12);
            }
            this.f20748i = new Object[i11];
            this.f20742c = zipSubscriberArr;
            this.f20744e = new AtomicLong();
            this.f20745f = new AtomicThrowable();
        }

        public void a() {
            for (ZipSubscriber<T, R> cancel : this.f20742c) {
                cancel.cancel();
            }
        }

        public void b() {
            int i11;
            T t11;
            boolean z11;
            T t12;
            boolean z12;
            if (getAndIncrement() == 0) {
                Subscriber<? super R> subscriber = this.f20741b;
                ZipSubscriber<T, R>[] zipSubscriberArr = this.f20742c;
                int length = zipSubscriberArr.length;
                Object[] objArr = this.f20748i;
                int i12 = 1;
                do {
                    long j11 = this.f20744e.get();
                    long j12 = 0;
                    while (true) {
                        i11 = (j11 > j12 ? 1 : (j11 == j12 ? 0 : -1));
                        if (i11 == 0) {
                            break;
                        } else if (!this.f20747h) {
                            if (this.f20746g || this.f20745f.get() == null) {
                                boolean z13 = false;
                                for (int i13 = 0; i13 < length; i13++) {
                                    ZipSubscriber<T, R> zipSubscriber = zipSubscriberArr[i13];
                                    if (objArr[i13] == null) {
                                        boolean z14 = zipSubscriber.f20754g;
                                        SimpleQueue<T> simpleQueue = zipSubscriber.f20752e;
                                        if (simpleQueue != null) {
                                            try {
                                                t12 = simpleQueue.poll();
                                            } catch (Throwable th2) {
                                                Throwable th3 = th2;
                                                Exceptions.throwIfFatal(th3);
                                                this.f20745f.tryAddThrowableOrReport(th3);
                                                if (!this.f20746g) {
                                                    a();
                                                    this.f20745f.tryTerminateConsumer((Subscriber<?>) subscriber);
                                                    return;
                                                }
                                                t12 = null;
                                                z14 = true;
                                            }
                                        } else {
                                            t12 = null;
                                        }
                                        if (t12 == null) {
                                            z12 = true;
                                        } else {
                                            z12 = false;
                                        }
                                        if (z14 && z12) {
                                            a();
                                            this.f20745f.tryTerminateConsumer((Subscriber<?>) subscriber);
                                            return;
                                        } else if (!z12) {
                                            objArr[i13] = t12;
                                        } else {
                                            z13 = true;
                                        }
                                    }
                                }
                                if (z13) {
                                    break;
                                }
                                try {
                                    Object apply = this.f20743d.apply(objArr.clone());
                                    Objects.requireNonNull(apply, "The zipper returned a null value");
                                    subscriber.onNext(apply);
                                    j12++;
                                    Arrays.fill(objArr, (Object) null);
                                } catch (Throwable th4) {
                                    Exceptions.throwIfFatal(th4);
                                    a();
                                    this.f20745f.tryAddThrowableOrReport(th4);
                                    this.f20745f.tryTerminateConsumer((Subscriber<?>) subscriber);
                                    return;
                                }
                            } else {
                                a();
                                this.f20745f.tryTerminateConsumer((Subscriber<?>) subscriber);
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (i11 == 0) {
                        if (!this.f20747h) {
                            if (this.f20746g || this.f20745f.get() == null) {
                                for (int i14 = 0; i14 < length; i14++) {
                                    ZipSubscriber<T, R> zipSubscriber2 = zipSubscriberArr[i14];
                                    if (objArr[i14] == null) {
                                        boolean z15 = zipSubscriber2.f20754g;
                                        SimpleQueue<T> simpleQueue2 = zipSubscriber2.f20752e;
                                        if (simpleQueue2 != null) {
                                            try {
                                                t11 = simpleQueue2.poll();
                                            } catch (Throwable th5) {
                                                Throwable th6 = th5;
                                                Exceptions.throwIfFatal(th6);
                                                this.f20745f.tryAddThrowableOrReport(th6);
                                                if (!this.f20746g) {
                                                    a();
                                                    this.f20745f.tryTerminateConsumer((Subscriber<?>) subscriber);
                                                    return;
                                                }
                                                t11 = null;
                                                z15 = true;
                                            }
                                        } else {
                                            t11 = null;
                                        }
                                        if (t11 == null) {
                                            z11 = true;
                                        } else {
                                            z11 = false;
                                        }
                                        if (z15 && z11) {
                                            a();
                                            this.f20745f.tryTerminateConsumer((Subscriber<?>) subscriber);
                                            return;
                                        } else if (!z11) {
                                            objArr[i14] = t11;
                                        }
                                    }
                                }
                            } else {
                                a();
                                this.f20745f.tryTerminateConsumer((Subscriber<?>) subscriber);
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (j12 != 0) {
                        for (ZipSubscriber<T, R> request : zipSubscriberArr) {
                            request.request(j12);
                        }
                        if (j11 != Long.MAX_VALUE) {
                            this.f20744e.addAndGet(-j12);
                        }
                    }
                    i12 = addAndGet(-i12);
                } while (i12 != 0);
            }
        }

        public void c(ZipSubscriber<T, R> zipSubscriber, Throwable th2) {
            if (this.f20745f.tryAddThrowableOrReport(th2)) {
                zipSubscriber.f20754g = true;
                b();
            }
        }

        public void cancel() {
            if (!this.f20747h) {
                this.f20747h = true;
                a();
            }
        }

        public void d(Publisher<? extends T>[] publisherArr, int i11) {
            ZipSubscriber<T, R>[] zipSubscriberArr = this.f20742c;
            int i12 = 0;
            while (i12 < i11 && !this.f20747h) {
                if (this.f20746g || this.f20745f.get() == null) {
                    publisherArr[i12].subscribe(zipSubscriberArr[i12]);
                    i12++;
                } else {
                    return;
                }
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f20744e, j11);
                b();
            }
        }
    }

    public static final class ZipSubscriber<T, R> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -4627193790118206028L;

        /* renamed from: b  reason: collision with root package name */
        public final ZipCoordinator<T, R> f20749b;

        /* renamed from: c  reason: collision with root package name */
        public final int f20750c;

        /* renamed from: d  reason: collision with root package name */
        public final int f20751d;

        /* renamed from: e  reason: collision with root package name */
        public SimpleQueue<T> f20752e;

        /* renamed from: f  reason: collision with root package name */
        public long f20753f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f20754g;

        /* renamed from: h  reason: collision with root package name */
        public int f20755h;

        public ZipSubscriber(ZipCoordinator<T, R> zipCoordinator, int i11) {
            this.f20749b = zipCoordinator;
            this.f20750c = i11;
            this.f20751d = i11 - (i11 >> 2);
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        public void onComplete() {
            this.f20754g = true;
            this.f20749b.b();
        }

        public void onError(Throwable th2) {
            this.f20749b.c(this, th2);
        }

        public void onNext(T t11) {
            if (this.f20755h != 2) {
                this.f20752e.offer(t11);
            }
            this.f20749b.b();
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.f20755h = requestFusion;
                        this.f20752e = queueSubscription;
                        this.f20754g = true;
                        this.f20749b.b();
                        return;
                    } else if (requestFusion == 2) {
                        this.f20755h = requestFusion;
                        this.f20752e = queueSubscription;
                        subscription.request((long) this.f20750c);
                        return;
                    }
                }
                this.f20752e = new SpscArrayQueue(this.f20750c);
                subscription.request((long) this.f20750c);
            }
        }

        public void request(long j11) {
            if (this.f20755h != 1) {
                long j12 = this.f20753f + j11;
                if (j12 >= ((long) this.f20751d)) {
                    this.f20753f = 0;
                    ((Subscription) get()).request(j12);
                    return;
                }
                this.f20753f = j12;
            }
        }
    }

    public FlowableZip(Publisher<? extends T>[] publisherArr, Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i11, boolean z11) {
        this.f20736c = publisherArr;
        this.f20737d = iterable;
        this.f20738e = function;
        this.f20739f = i11;
        this.f20740g = z11;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        int i11;
        Publisher<? extends T>[] publisherArr = this.f20736c;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            i11 = 0;
            for (Publisher<? extends T> publisher : this.f20737d) {
                if (i11 == publisherArr.length) {
                    Publisher<? extends T>[] publisherArr2 = new Publisher[((i11 >> 2) + i11)];
                    System.arraycopy(publisherArr, 0, publisherArr2, 0, i11);
                    publisherArr = publisherArr2;
                }
                publisherArr[i11] = publisher;
                i11++;
            }
        } else {
            i11 = publisherArr.length;
        }
        int i12 = i11;
        if (i12 == 0) {
            EmptySubscription.complete(subscriber);
            return;
        }
        ZipCoordinator zipCoordinator = new ZipCoordinator(subscriber, this.f20738e, i12, this.f20739f, this.f20740g);
        subscriber.onSubscribe(zipCoordinator);
        zipCoordinator.d(publisherArr, i12);
    }
}
