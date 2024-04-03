package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableZip<T, R> extends Flowable<R> {

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<? extends T>[] f16237c;

    /* renamed from: d  reason: collision with root package name */
    public final Iterable<? extends Publisher<? extends T>> f16238d;

    /* renamed from: e  reason: collision with root package name */
    public final Function<? super Object[], ? extends R> f16239e;

    /* renamed from: f  reason: collision with root package name */
    public final int f16240f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f16241g;

    public static final class ZipCoordinator<T, R> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = -2434867452883857743L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f16242b;

        /* renamed from: c  reason: collision with root package name */
        public final ZipSubscriber<T, R>[] f16243c;

        /* renamed from: d  reason: collision with root package name */
        public final Function<? super Object[], ? extends R> f16244d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicLong f16245e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicThrowable f16246f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f16247g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f16248h;

        /* renamed from: i  reason: collision with root package name */
        public final Object[] f16249i;

        public ZipCoordinator(Subscriber<? super R> subscriber, Function<? super Object[], ? extends R> function, int i11, int i12, boolean z11) {
            this.f16242b = subscriber;
            this.f16244d = function;
            this.f16247g = z11;
            ZipSubscriber<T, R>[] zipSubscriberArr = new ZipSubscriber[i11];
            for (int i13 = 0; i13 < i11; i13++) {
                zipSubscriberArr[i13] = new ZipSubscriber<>(this, i12);
            }
            this.f16249i = new Object[i11];
            this.f16243c = zipSubscriberArr;
            this.f16245e = new AtomicLong();
            this.f16246f = new AtomicThrowable();
        }

        public void a() {
            for (ZipSubscriber<T, R> cancel : this.f16243c) {
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
                Subscriber<? super R> subscriber = this.f16242b;
                ZipSubscriber<T, R>[] zipSubscriberArr = this.f16243c;
                int length = zipSubscriberArr.length;
                Object[] objArr = this.f16249i;
                int i12 = 1;
                do {
                    long j11 = this.f16245e.get();
                    long j12 = 0;
                    while (true) {
                        i11 = (j11 > j12 ? 1 : (j11 == j12 ? 0 : -1));
                        if (i11 == 0) {
                            break;
                        } else if (!this.f16248h) {
                            if (this.f16247g || this.f16246f.get() == null) {
                                boolean z13 = false;
                                for (int i13 = 0; i13 < length; i13++) {
                                    ZipSubscriber<T, R> zipSubscriber = zipSubscriberArr[i13];
                                    if (objArr[i13] == null) {
                                        try {
                                            boolean z14 = zipSubscriber.f16255g;
                                            SimpleQueue<T> simpleQueue = zipSubscriber.f16253e;
                                            if (simpleQueue != null) {
                                                t12 = simpleQueue.poll();
                                            } else {
                                                t12 = null;
                                            }
                                            if (t12 == null) {
                                                z12 = true;
                                            } else {
                                                z12 = false;
                                            }
                                            if (!z14 || !z12) {
                                                if (!z12) {
                                                    objArr[i13] = t12;
                                                }
                                                z13 = true;
                                            } else {
                                                a();
                                                if (((Throwable) this.f16246f.get()) != null) {
                                                    subscriber.onError(this.f16246f.terminate());
                                                    return;
                                                } else {
                                                    subscriber.onComplete();
                                                    return;
                                                }
                                            }
                                        } catch (Throwable th2) {
                                            Exceptions.throwIfFatal(th2);
                                            this.f16246f.addThrowable(th2);
                                            if (!this.f16247g) {
                                                a();
                                                subscriber.onError(this.f16246f.terminate());
                                                return;
                                            }
                                        }
                                    }
                                }
                                if (z13) {
                                    break;
                                }
                                try {
                                    subscriber.onNext(ObjectHelper.requireNonNull(this.f16244d.apply(objArr.clone()), "The zipper returned a null value"));
                                    j12++;
                                    Arrays.fill(objArr, (Object) null);
                                } catch (Throwable th3) {
                                    Exceptions.throwIfFatal(th3);
                                    a();
                                    this.f16246f.addThrowable(th3);
                                    subscriber.onError(this.f16246f.terminate());
                                    return;
                                }
                            } else {
                                a();
                                subscriber.onError(this.f16246f.terminate());
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (i11 == 0) {
                        if (!this.f16248h) {
                            if (this.f16247g || this.f16246f.get() == null) {
                                for (int i14 = 0; i14 < length; i14++) {
                                    ZipSubscriber<T, R> zipSubscriber2 = zipSubscriberArr[i14];
                                    if (objArr[i14] == null) {
                                        try {
                                            boolean z15 = zipSubscriber2.f16255g;
                                            SimpleQueue<T> simpleQueue2 = zipSubscriber2.f16253e;
                                            if (simpleQueue2 != null) {
                                                t11 = simpleQueue2.poll();
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
                                                if (((Throwable) this.f16246f.get()) != null) {
                                                    subscriber.onError(this.f16246f.terminate());
                                                    return;
                                                } else {
                                                    subscriber.onComplete();
                                                    return;
                                                }
                                            } else if (!z11) {
                                                objArr[i14] = t11;
                                            }
                                        } catch (Throwable th4) {
                                            Exceptions.throwIfFatal(th4);
                                            this.f16246f.addThrowable(th4);
                                            if (!this.f16247g) {
                                                a();
                                                subscriber.onError(this.f16246f.terminate());
                                                return;
                                            }
                                        }
                                    }
                                }
                            } else {
                                a();
                                subscriber.onError(this.f16246f.terminate());
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
                            this.f16245e.addAndGet(-j12);
                        }
                    }
                    i12 = addAndGet(-i12);
                } while (i12 != 0);
            }
        }

        public void c(ZipSubscriber<T, R> zipSubscriber, Throwable th2) {
            if (this.f16246f.addThrowable(th2)) {
                zipSubscriber.f16255g = true;
                b();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void cancel() {
            if (!this.f16248h) {
                this.f16248h = true;
                a();
            }
        }

        public void d(Publisher<? extends T>[] publisherArr, int i11) {
            ZipSubscriber<T, R>[] zipSubscriberArr = this.f16243c;
            int i12 = 0;
            while (i12 < i11 && !this.f16248h) {
                if (this.f16247g || this.f16246f.get() == null) {
                    publisherArr[i12].subscribe(zipSubscriberArr[i12]);
                    i12++;
                } else {
                    return;
                }
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f16245e, j11);
                b();
            }
        }
    }

    public static final class ZipSubscriber<T, R> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -4627193790118206028L;

        /* renamed from: b  reason: collision with root package name */
        public final ZipCoordinator<T, R> f16250b;

        /* renamed from: c  reason: collision with root package name */
        public final int f16251c;

        /* renamed from: d  reason: collision with root package name */
        public final int f16252d;

        /* renamed from: e  reason: collision with root package name */
        public SimpleQueue<T> f16253e;

        /* renamed from: f  reason: collision with root package name */
        public long f16254f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f16255g;

        /* renamed from: h  reason: collision with root package name */
        public int f16256h;

        public ZipSubscriber(ZipCoordinator<T, R> zipCoordinator, int i11) {
            this.f16250b = zipCoordinator;
            this.f16251c = i11;
            this.f16252d = i11 - (i11 >> 2);
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        public void onComplete() {
            this.f16255g = true;
            this.f16250b.b();
        }

        public void onError(Throwable th2) {
            this.f16250b.c(this, th2);
        }

        public void onNext(T t11) {
            if (this.f16256h != 2) {
                this.f16253e.offer(t11);
            }
            this.f16250b.b();
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.f16256h = requestFusion;
                        this.f16253e = queueSubscription;
                        this.f16255g = true;
                        this.f16250b.b();
                        return;
                    } else if (requestFusion == 2) {
                        this.f16256h = requestFusion;
                        this.f16253e = queueSubscription;
                        subscription.request((long) this.f16251c);
                        return;
                    }
                }
                this.f16253e = new SpscArrayQueue(this.f16251c);
                subscription.request((long) this.f16251c);
            }
        }

        public void request(long j11) {
            if (this.f16256h != 1) {
                long j12 = this.f16254f + j11;
                if (j12 >= ((long) this.f16252d)) {
                    this.f16254f = 0;
                    ((Subscription) get()).request(j12);
                    return;
                }
                this.f16254f = j12;
            }
        }
    }

    public FlowableZip(Publisher<? extends T>[] publisherArr, Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i11, boolean z11) {
        this.f16237c = publisherArr;
        this.f16238d = iterable;
        this.f16239e = function;
        this.f16240f = i11;
        this.f16241g = z11;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        int i11;
        Publisher<? extends T>[] publisherArr = this.f16237c;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            i11 = 0;
            for (Publisher<? extends T> publisher : this.f16238d) {
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
        ZipCoordinator zipCoordinator = new ZipCoordinator(subscriber, this.f16239e, i12, this.f16240f, this.f16241g);
        subscriber.onSubscribe(zipCoordinator);
        zipCoordinator.d(publisherArr, i12);
    }
}
