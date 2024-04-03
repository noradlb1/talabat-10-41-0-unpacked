package io.reactivex.internal.operators.flowable;

import i.b;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowablePublishAlt<T> extends ConnectableFlowable<T> implements HasUpstreamPublisher<T>, ResettableConnectable {

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<T> f15605c;

    /* renamed from: d  reason: collision with root package name */
    public final int f15606d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<PublishConnection<T>> f15607e = new AtomicReference<>();

    public static final class InnerSubscription<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = 2845000326761540265L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15608b;

        /* renamed from: c  reason: collision with root package name */
        public final PublishConnection<T> f15609c;

        /* renamed from: d  reason: collision with root package name */
        public long f15610d;

        public InnerSubscription(Subscriber<? super T> subscriber, PublishConnection<T> publishConnection) {
            this.f15608b = subscriber;
            this.f15609c = publishConnection;
        }

        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.f15609c.d(this);
                this.f15609c.c();
            }
        }

        public boolean isCancelled() {
            return get() == Long.MIN_VALUE;
        }

        public void request(long j11) {
            BackpressureHelper.addCancel(this, j11);
            this.f15609c.c();
        }
    }

    public static final class PublishConnection<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {

        /* renamed from: l  reason: collision with root package name */
        public static final InnerSubscription[] f15611l = new InnerSubscription[0];

        /* renamed from: m  reason: collision with root package name */
        public static final InnerSubscription[] f15612m = new InnerSubscription[0];
        private static final long serialVersionUID = -1672047311619175801L;

        /* renamed from: b  reason: collision with root package name */
        public final AtomicReference<PublishConnection<T>> f15613b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReference<Subscription> f15614c = new AtomicReference<>();

        /* renamed from: d  reason: collision with root package name */
        public final AtomicBoolean f15615d = new AtomicBoolean();

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReference<InnerSubscription<T>[]> f15616e;

        /* renamed from: f  reason: collision with root package name */
        public final int f15617f;

        /* renamed from: g  reason: collision with root package name */
        public volatile SimpleQueue<T> f15618g;

        /* renamed from: h  reason: collision with root package name */
        public int f15619h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f15620i;

        /* renamed from: j  reason: collision with root package name */
        public Throwable f15621j;

        /* renamed from: k  reason: collision with root package name */
        public int f15622k;

        public PublishConnection(AtomicReference<PublishConnection<T>> atomicReference, int i11) {
            this.f15613b = atomicReference;
            this.f15617f = i11;
            this.f15616e = new AtomicReference<>(f15611l);
        }

        public boolean a(InnerSubscription<T> innerSubscription) {
            InnerSubscription[] innerSubscriptionArr;
            InnerSubscription[] innerSubscriptionArr2;
            do {
                innerSubscriptionArr = (InnerSubscription[]) this.f15616e.get();
                if (innerSubscriptionArr == f15612m) {
                    return false;
                }
                int length = innerSubscriptionArr.length;
                innerSubscriptionArr2 = new InnerSubscription[(length + 1)];
                System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr2, 0, length);
                innerSubscriptionArr2[length] = innerSubscription;
            } while (!b.a(this.f15616e, innerSubscriptionArr, innerSubscriptionArr2));
            return true;
        }

        public boolean b(boolean z11, boolean z12) {
            if (!z11 || !z12) {
                return false;
            }
            Throwable th2 = this.f15621j;
            if (th2 != null) {
                e(th2);
                return true;
            }
            for (InnerSubscription innerSubscription : (InnerSubscription[]) this.f15616e.getAndSet(f15612m)) {
                if (!innerSubscription.isCancelled()) {
                    innerSubscription.f15608b.onComplete();
                }
            }
            return true;
        }

        public void c() {
            boolean z11;
            boolean z12;
            if (getAndIncrement() == 0) {
                SimpleQueue<T> simpleQueue = this.f15618g;
                int i11 = this.f15622k;
                int i12 = this.f15617f;
                int i13 = i12 - (i12 >> 2);
                if (this.f15619h != 1) {
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
                        InnerSubscription<T>[] innerSubscriptionArr = (InnerSubscription[]) this.f15616e.get();
                        long j11 = Long.MAX_VALUE;
                        boolean z13 = false;
                        for (InnerSubscription<T> innerSubscription : innerSubscriptionArr) {
                            long j12 = innerSubscription.get();
                            if (j12 != Long.MIN_VALUE) {
                                j11 = Math.min(j12 - innerSubscription.f15610d, j11);
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
                            boolean z14 = this.f15620i;
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
                                            innerSubscription2.f15608b.onNext(poll);
                                            innerSubscription2.f15610d++;
                                        }
                                    }
                                    if (z11 && (i16 = i16 + 1) == i13) {
                                        this.f15614c.get().request((long) i13);
                                        i16 = 0;
                                    }
                                    j11--;
                                    if (innerSubscriptionArr != this.f15616e.get()) {
                                        break;
                                    }
                                    j13 = 0;
                                } else {
                                    return;
                                }
                            } catch (Throwable th2) {
                                Throwable th3 = th2;
                                Exceptions.throwIfFatal(th3);
                                this.f15614c.get().cancel();
                                simpleQueue2.clear();
                                this.f15620i = true;
                                e(th3);
                                return;
                            }
                        }
                        if (b(this.f15620i, simpleQueue2.isEmpty())) {
                            return;
                        }
                    }
                    this.f15622k = i16;
                    i14 = addAndGet(-i14);
                    if (i14 != 0) {
                        if (simpleQueue2 == null) {
                            simpleQueue2 = this.f15618g;
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
                innerSubscriptionArr = (InnerSubscription[]) this.f15616e.get();
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
                            innerSubscriptionArr2 = f15611l;
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
            } while (!b.a(this.f15616e, innerSubscriptionArr, innerSubscriptionArr2));
        }

        public void dispose() {
            this.f15616e.getAndSet(f15612m);
            b.a(this.f15613b, this, (Object) null);
            SubscriptionHelper.cancel(this.f15614c);
        }

        public void e(Throwable th2) {
            for (InnerSubscription innerSubscription : (InnerSubscription[]) this.f15616e.getAndSet(f15612m)) {
                if (!innerSubscription.isCancelled()) {
                    innerSubscription.f15608b.onError(th2);
                }
            }
        }

        public boolean isDisposed() {
            return this.f15616e.get() == f15612m;
        }

        public void onComplete() {
            this.f15620i = true;
            c();
        }

        public void onError(Throwable th2) {
            if (this.f15620i) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f15621j = th2;
            this.f15620i = true;
            c();
        }

        public void onNext(T t11) {
            if (this.f15619h != 0 || this.f15618g.offer(t11)) {
                c();
            } else {
                onError(new MissingBackpressureException("Prefetch queue is full?!"));
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.f15614c, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.f15619h = requestFusion;
                        this.f15618g = queueSubscription;
                        this.f15620i = true;
                        c();
                        return;
                    } else if (requestFusion == 2) {
                        this.f15619h = requestFusion;
                        this.f15618g = queueSubscription;
                        subscription.request((long) this.f15617f);
                        return;
                    }
                }
                this.f15618g = new SpscArrayQueue(this.f15617f);
                subscription.request((long) this.f15617f);
            }
        }
    }

    public FlowablePublishAlt(Publisher<T> publisher, int i11) {
        this.f15605c = publisher;
        this.f15606d = i11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect(io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> r5) {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowablePublishAlt$PublishConnection<T>> r0 = r4.f15607e
            java.lang.Object r0 = r0.get()
            io.reactivex.internal.operators.flowable.FlowablePublishAlt$PublishConnection r0 = (io.reactivex.internal.operators.flowable.FlowablePublishAlt.PublishConnection) r0
            if (r0 == 0) goto L_0x0010
            boolean r1 = r0.isDisposed()
            if (r1 == 0) goto L_0x0023
        L_0x0010:
            io.reactivex.internal.operators.flowable.FlowablePublishAlt$PublishConnection r1 = new io.reactivex.internal.operators.flowable.FlowablePublishAlt$PublishConnection
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowablePublishAlt$PublishConnection<T>> r2 = r4.f15607e
            int r3 = r4.f15606d
            r1.<init>(r2, r3)
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowablePublishAlt$PublishConnection<T>> r2 = r4.f15607e
            boolean r0 = i.b.a(r2, r0, r1)
            if (r0 != 0) goto L_0x0022
            goto L_0x0000
        L_0x0022:
            r0 = r1
        L_0x0023:
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.f15615d
            boolean r1 = r1.get()
            r2 = 0
            if (r1 != 0) goto L_0x0036
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.f15615d
            r3 = 1
            boolean r1 = r1.compareAndSet(r2, r3)
            if (r1 == 0) goto L_0x0036
            r2 = r3
        L_0x0036:
            r5.accept(r0)     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x0040
            org.reactivestreams.Publisher<T> r5 = r4.f15605c
            r5.subscribe(r0)
        L_0x0040:
            return
        L_0x0041:
            r5 = move-exception
            io.reactivex.exceptions.Exceptions.throwIfFatal(r5)
            java.lang.RuntimeException r5 = io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(r5)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowablePublishAlt.connect(io.reactivex.functions.Consumer):void");
    }

    public int publishBufferSize() {
        return this.f15606d;
    }

    public void resetIf(Disposable disposable) {
        b.a(this.f15607e, (PublishConnection) disposable, (Object) null);
    }

    public Publisher<T> source() {
        return this.f15605c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> r5) {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowablePublishAlt$PublishConnection<T>> r0 = r4.f15607e
            java.lang.Object r0 = r0.get()
            io.reactivex.internal.operators.flowable.FlowablePublishAlt$PublishConnection r0 = (io.reactivex.internal.operators.flowable.FlowablePublishAlt.PublishConnection) r0
            if (r0 != 0) goto L_0x001d
            io.reactivex.internal.operators.flowable.FlowablePublishAlt$PublishConnection r1 = new io.reactivex.internal.operators.flowable.FlowablePublishAlt$PublishConnection
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowablePublishAlt$PublishConnection<T>> r2 = r4.f15607e
            int r3 = r4.f15606d
            r1.<init>(r2, r3)
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowablePublishAlt$PublishConnection<T>> r2 = r4.f15607e
            boolean r0 = i.b.a(r2, r0, r1)
            if (r0 != 0) goto L_0x001c
            goto L_0x0000
        L_0x001c:
            r0 = r1
        L_0x001d:
            io.reactivex.internal.operators.flowable.FlowablePublishAlt$InnerSubscription r1 = new io.reactivex.internal.operators.flowable.FlowablePublishAlt$InnerSubscription
            r1.<init>(r5, r0)
            r5.onSubscribe(r1)
            boolean r2 = r0.a(r1)
            if (r2 == 0) goto L_0x0039
            boolean r5 = r1.isCancelled()
            if (r5 == 0) goto L_0x0035
            r0.d(r1)
            goto L_0x0038
        L_0x0035:
            r0.c()
        L_0x0038:
            return
        L_0x0039:
            java.lang.Throwable r0 = r0.f15621j
            if (r0 == 0) goto L_0x0041
            r5.onError(r0)
            goto L_0x0044
        L_0x0041:
            r5.onComplete()
        L_0x0044:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowablePublishAlt.subscribeActual(org.reactivestreams.Subscriber):void");
    }
}
