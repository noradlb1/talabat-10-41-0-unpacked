package io.reactivex.rxjava3.internal.operators.flowable;

import i.b;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.flowables.ConnectableFlowable;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.QueueSubscription;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowablePublish<T> extends ConnectableFlowable<T> implements HasUpstreamPublisher<T> {

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<T> f20112c;

    /* renamed from: d  reason: collision with root package name */
    public final int f20113d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<PublishConnection<T>> f20114e = new AtomicReference<>();

    public static final class InnerSubscription<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = 2845000326761540265L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f20115b;

        /* renamed from: c  reason: collision with root package name */
        public final PublishConnection<T> f20116c;

        /* renamed from: d  reason: collision with root package name */
        public long f20117d;

        public InnerSubscription(Subscriber<? super T> subscriber, PublishConnection<T> publishConnection) {
            this.f20115b = subscriber;
            this.f20116c = publishConnection;
        }

        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.f20116c.d(this);
                this.f20116c.c();
            }
        }

        public boolean isCancelled() {
            return get() == Long.MIN_VALUE;
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.addCancel(this, j11);
                this.f20116c.c();
            }
        }
    }

    public static final class PublishConnection<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {

        /* renamed from: l  reason: collision with root package name */
        public static final InnerSubscription[] f20118l = new InnerSubscription[0];

        /* renamed from: m  reason: collision with root package name */
        public static final InnerSubscription[] f20119m = new InnerSubscription[0];
        private static final long serialVersionUID = -1672047311619175801L;

        /* renamed from: b  reason: collision with root package name */
        public final AtomicReference<PublishConnection<T>> f20120b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReference<Subscription> f20121c = new AtomicReference<>();

        /* renamed from: d  reason: collision with root package name */
        public final AtomicBoolean f20122d = new AtomicBoolean();

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReference<InnerSubscription<T>[]> f20123e;

        /* renamed from: f  reason: collision with root package name */
        public final int f20124f;

        /* renamed from: g  reason: collision with root package name */
        public volatile SimpleQueue<T> f20125g;

        /* renamed from: h  reason: collision with root package name */
        public int f20126h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f20127i;

        /* renamed from: j  reason: collision with root package name */
        public Throwable f20128j;

        /* renamed from: k  reason: collision with root package name */
        public int f20129k;

        public PublishConnection(AtomicReference<PublishConnection<T>> atomicReference, int i11) {
            this.f20120b = atomicReference;
            this.f20124f = i11;
            this.f20123e = new AtomicReference<>(f20118l);
        }

        public boolean a(InnerSubscription<T> innerSubscription) {
            InnerSubscription[] innerSubscriptionArr;
            InnerSubscription[] innerSubscriptionArr2;
            do {
                innerSubscriptionArr = (InnerSubscription[]) this.f20123e.get();
                if (innerSubscriptionArr == f20119m) {
                    return false;
                }
                int length = innerSubscriptionArr.length;
                innerSubscriptionArr2 = new InnerSubscription[(length + 1)];
                System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr2, 0, length);
                innerSubscriptionArr2[length] = innerSubscription;
            } while (!b.a(this.f20123e, innerSubscriptionArr, innerSubscriptionArr2));
            return true;
        }

        public boolean b(boolean z11, boolean z12) {
            if (!z11 || !z12) {
                return false;
            }
            Throwable th2 = this.f20128j;
            if (th2 != null) {
                e(th2);
                return true;
            }
            for (InnerSubscription innerSubscription : (InnerSubscription[]) this.f20123e.getAndSet(f20119m)) {
                if (!innerSubscription.isCancelled()) {
                    innerSubscription.f20115b.onComplete();
                }
            }
            return true;
        }

        public void c() {
            boolean z11;
            boolean z12;
            if (getAndIncrement() == 0) {
                SimpleQueue<T> simpleQueue = this.f20125g;
                int i11 = this.f20129k;
                int i12 = this.f20124f;
                int i13 = i12 - (i12 >> 2);
                if (this.f20126h != 1) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                int i14 = 1;
                int i15 = i11;
                SimpleQueue<T> simpleQueue2 = simpleQueue;
                int i16 = i15;
                while (true) {
                    if (simpleQueue2 != null) {
                        InnerSubscription<T>[] innerSubscriptionArr = (InnerSubscription[]) this.f20123e.get();
                        long j11 = Long.MAX_VALUE;
                        boolean z13 = false;
                        for (InnerSubscription<T> innerSubscription : innerSubscriptionArr) {
                            long j12 = innerSubscription.get();
                            if (j12 != Long.MIN_VALUE) {
                                j11 = Math.min(j12 - innerSubscription.f20117d, j11);
                                z13 = true;
                            }
                        }
                        long j13 = 0;
                        if (!z13) {
                            j11 = 0;
                        }
                        while (true) {
                            if (j11 == j13) {
                                break;
                            }
                            boolean z14 = this.f20127i;
                            try {
                                T poll = simpleQueue2.poll();
                                if (poll == null) {
                                    z12 = true;
                                } else {
                                    z12 = false;
                                }
                                if (!b(z14, z12)) {
                                    if (z12) {
                                        break;
                                    }
                                    for (InnerSubscription<T> innerSubscription2 : innerSubscriptionArr) {
                                        if (!innerSubscription2.isCancelled()) {
                                            innerSubscription2.f20115b.onNext(poll);
                                            innerSubscription2.f20117d++;
                                        }
                                    }
                                    if (z11 && (i16 = i16 + 1) == i13) {
                                        this.f20121c.get().request((long) i13);
                                        i16 = 0;
                                    }
                                    j11--;
                                    if (innerSubscriptionArr != this.f20123e.get()) {
                                        break;
                                    }
                                    j13 = 0;
                                } else {
                                    return;
                                }
                            } catch (Throwable th2) {
                                Throwable th3 = th2;
                                Exceptions.throwIfFatal(th3);
                                this.f20121c.get().cancel();
                                simpleQueue2.clear();
                                this.f20127i = true;
                                e(th3);
                                return;
                            }
                        }
                        if (b(this.f20127i, simpleQueue2.isEmpty())) {
                            return;
                        }
                    }
                    this.f20129k = i16;
                    i14 = addAndGet(-i14);
                    if (i14 != 0) {
                        if (simpleQueue2 == null) {
                            simpleQueue2 = this.f20125g;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        public void d(InnerSubscription<T> innerSubscription) {
            InnerSubscription<T>[] innerSubscriptionArr;
            InnerSubscription[] innerSubscriptionArr2;
            do {
                innerSubscriptionArr = (InnerSubscription[]) this.f20123e.get();
                int length = innerSubscriptionArr.length;
                if (length != 0) {
                    int i11 = 0;
                    while (true) {
                        if (i11 >= length) {
                            i11 = -1;
                            break;
                        } else if (innerSubscriptionArr[i11] == innerSubscription) {
                            break;
                        } else {
                            i11++;
                        }
                    }
                    if (i11 >= 0) {
                        if (length == 1) {
                            innerSubscriptionArr2 = f20118l;
                        } else {
                            InnerSubscription[] innerSubscriptionArr3 = new InnerSubscription[(length - 1)];
                            System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr3, 0, i11);
                            System.arraycopy(innerSubscriptionArr, i11 + 1, innerSubscriptionArr3, i11, (length - i11) - 1);
                            innerSubscriptionArr2 = innerSubscriptionArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!b.a(this.f20123e, innerSubscriptionArr, innerSubscriptionArr2));
        }

        public void dispose() {
            this.f20123e.getAndSet(f20119m);
            b.a(this.f20120b, this, (Object) null);
            SubscriptionHelper.cancel(this.f20121c);
        }

        public void e(Throwable th2) {
            for (InnerSubscription innerSubscription : (InnerSubscription[]) this.f20123e.getAndSet(f20119m)) {
                if (!innerSubscription.isCancelled()) {
                    innerSubscription.f20115b.onError(th2);
                }
            }
        }

        public boolean isDisposed() {
            return this.f20123e.get() == f20119m;
        }

        public void onComplete() {
            this.f20127i = true;
            c();
        }

        public void onError(Throwable th2) {
            if (this.f20127i) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f20128j = th2;
            this.f20127i = true;
            c();
        }

        public void onNext(T t11) {
            if (this.f20126h != 0 || this.f20125g.offer(t11)) {
                c();
            } else {
                onError(new MissingBackpressureException("Prefetch queue is full?!"));
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.f20121c, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.f20126h = requestFusion;
                        this.f20125g = queueSubscription;
                        this.f20127i = true;
                        c();
                        return;
                    } else if (requestFusion == 2) {
                        this.f20126h = requestFusion;
                        this.f20125g = queueSubscription;
                        subscription.request((long) this.f20124f);
                        return;
                    }
                }
                this.f20125g = new SpscArrayQueue(this.f20124f);
                subscription.request((long) this.f20124f);
            }
        }
    }

    public FlowablePublish(Publisher<T> publisher, int i11) {
        this.f20112c = publisher;
        this.f20113d = i11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect(io.reactivex.rxjava3.functions.Consumer<? super io.reactivex.rxjava3.disposables.Disposable> r5) {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish$PublishConnection<T>> r0 = r4.f20114e
            java.lang.Object r0 = r0.get()
            io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish$PublishConnection r0 = (io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish.PublishConnection) r0
            if (r0 == 0) goto L_0x0010
            boolean r1 = r0.isDisposed()
            if (r1 == 0) goto L_0x0023
        L_0x0010:
            io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish$PublishConnection r1 = new io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish$PublishConnection
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish$PublishConnection<T>> r2 = r4.f20114e
            int r3 = r4.f20113d
            r1.<init>(r2, r3)
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish$PublishConnection<T>> r2 = r4.f20114e
            boolean r0 = i.b.a(r2, r0, r1)
            if (r0 != 0) goto L_0x0022
            goto L_0x0000
        L_0x0022:
            r0 = r1
        L_0x0023:
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.f20122d
            boolean r1 = r1.get()
            r2 = 0
            if (r1 != 0) goto L_0x0036
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.f20122d
            r3 = 1
            boolean r1 = r1.compareAndSet(r2, r3)
            if (r1 == 0) goto L_0x0036
            r2 = r3
        L_0x0036:
            r5.accept(r0)     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x0040
            org.reactivestreams.Publisher<T> r5 = r4.f20112c
            r5.subscribe(r0)
        L_0x0040:
            return
        L_0x0041:
            r5 = move-exception
            io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r5)
            java.lang.RuntimeException r5 = io.reactivex.rxjava3.internal.util.ExceptionHelper.wrapOrThrow(r5)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish.connect(io.reactivex.rxjava3.functions.Consumer):void");
    }

    public void reset() {
        PublishConnection publishConnection = this.f20114e.get();
        if (publishConnection != null && publishConnection.isDisposed()) {
            b.a(this.f20114e, publishConnection, (Object) null);
        }
    }

    public Publisher<T> source() {
        return this.f20112c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> r5) {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish$PublishConnection<T>> r0 = r4.f20114e
            java.lang.Object r0 = r0.get()
            io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish$PublishConnection r0 = (io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish.PublishConnection) r0
            if (r0 != 0) goto L_0x001d
            io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish$PublishConnection r1 = new io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish$PublishConnection
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish$PublishConnection<T>> r2 = r4.f20114e
            int r3 = r4.f20113d
            r1.<init>(r2, r3)
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish$PublishConnection<T>> r2 = r4.f20114e
            boolean r0 = i.b.a(r2, r0, r1)
            if (r0 != 0) goto L_0x001c
            goto L_0x0000
        L_0x001c:
            r0 = r1
        L_0x001d:
            io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish$InnerSubscription r1 = new io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish$InnerSubscription
            r1.<init>(r5, r0)
            r5.onSubscribe(r1)
            boolean r5 = r0.a(r1)
            if (r5 == 0) goto L_0x0039
            boolean r5 = r1.isCancelled()
            if (r5 == 0) goto L_0x0035
            r0.d(r1)
            goto L_0x0038
        L_0x0035:
            r0.c()
        L_0x0038:
            return
        L_0x0039:
            java.lang.Throwable r5 = r0.f20128j
            if (r5 == 0) goto L_0x0043
            org.reactivestreams.Subscriber<? super T> r0 = r1.f20115b
            r0.onError(r5)
            goto L_0x0048
        L_0x0043:
            org.reactivestreams.Subscriber<? super T> r5 = r1.f20115b
            r5.onComplete()
        L_0x0048:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish.subscribeActual(org.reactivestreams.Subscriber):void");
    }
}
