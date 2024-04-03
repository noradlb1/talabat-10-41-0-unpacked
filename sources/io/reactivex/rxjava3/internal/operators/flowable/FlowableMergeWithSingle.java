package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.SimplePlainQueue;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableMergeWithSingle<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final SingleSource<? extends T> f20023d;

    public static final class MergeWithObserver<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -4592979584110982903L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f20024b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReference<Subscription> f20025c = new AtomicReference<>();

        /* renamed from: d  reason: collision with root package name */
        public final OtherObserver<T> f20026d = new OtherObserver<>(this);

        /* renamed from: e  reason: collision with root package name */
        public final AtomicThrowable f20027e = new AtomicThrowable();

        /* renamed from: f  reason: collision with root package name */
        public final AtomicLong f20028f = new AtomicLong();

        /* renamed from: g  reason: collision with root package name */
        public final int f20029g;

        /* renamed from: h  reason: collision with root package name */
        public final int f20030h;

        /* renamed from: i  reason: collision with root package name */
        public volatile SimplePlainQueue<T> f20031i;

        /* renamed from: j  reason: collision with root package name */
        public T f20032j;

        /* renamed from: k  reason: collision with root package name */
        public volatile boolean f20033k;

        /* renamed from: l  reason: collision with root package name */
        public volatile boolean f20034l;

        /* renamed from: m  reason: collision with root package name */
        public volatile int f20035m;

        /* renamed from: n  reason: collision with root package name */
        public long f20036n;

        /* renamed from: o  reason: collision with root package name */
        public int f20037o;

        public static final class OtherObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T> {
            private static final long serialVersionUID = -2935427570954647017L;

            /* renamed from: b  reason: collision with root package name */
            public final MergeWithObserver<T> f20038b;

            public OtherObserver(MergeWithObserver<T> mergeWithObserver) {
                this.f20038b = mergeWithObserver;
            }

            public void onError(Throwable th2) {
                this.f20038b.d(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public void onSuccess(T t11) {
                this.f20038b.e(t11);
            }
        }

        public MergeWithObserver(Subscriber<? super T> subscriber) {
            this.f20024b = subscriber;
            int bufferSize = Flowable.bufferSize();
            this.f20029g = bufferSize;
            this.f20030h = bufferSize - (bufferSize >> 2);
        }

        public void a() {
            if (getAndIncrement() == 0) {
                b();
            }
        }

        public void b() {
            int i11;
            boolean z11;
            T t11;
            boolean z12;
            Subscriber<? super T> subscriber = this.f20024b;
            long j11 = this.f20036n;
            int i12 = this.f20037o;
            int i13 = this.f20030h;
            int i14 = 1;
            int i15 = 1;
            while (true) {
                long j12 = this.f20028f.get();
                while (true) {
                    i11 = (j11 > j12 ? 1 : (j11 == j12 ? 0 : -1));
                    if (i11 == 0) {
                        break;
                    } else if (this.f20033k) {
                        this.f20032j = null;
                        this.f20031i = null;
                        return;
                    } else if (this.f20027e.get() != null) {
                        this.f20032j = null;
                        this.f20031i = null;
                        this.f20027e.tryTerminateConsumer((Subscriber<?>) this.f20024b);
                        return;
                    } else {
                        int i16 = this.f20035m;
                        if (i16 == i14) {
                            T t12 = this.f20032j;
                            this.f20032j = null;
                            this.f20035m = 2;
                            subscriber.onNext(t12);
                            j11++;
                        } else {
                            boolean z13 = this.f20034l;
                            SimplePlainQueue<T> simplePlainQueue = this.f20031i;
                            if (simplePlainQueue != null) {
                                t11 = simplePlainQueue.poll();
                            } else {
                                t11 = null;
                            }
                            if (t11 == null) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            if (z13 && z12 && i16 == 2) {
                                this.f20031i = null;
                                subscriber.onComplete();
                                return;
                            } else if (z12) {
                                break;
                            } else {
                                subscriber.onNext(t11);
                                j11++;
                                i12++;
                                if (i12 == i13) {
                                    this.f20025c.get().request((long) i13);
                                    i12 = 0;
                                }
                                i14 = 1;
                            }
                        }
                    }
                }
                if (i11 == 0) {
                    if (this.f20033k) {
                        this.f20032j = null;
                        this.f20031i = null;
                        return;
                    } else if (this.f20027e.get() != null) {
                        this.f20032j = null;
                        this.f20031i = null;
                        this.f20027e.tryTerminateConsumer((Subscriber<?>) this.f20024b);
                        return;
                    } else {
                        boolean z14 = this.f20034l;
                        SimplePlainQueue<T> simplePlainQueue2 = this.f20031i;
                        if (simplePlainQueue2 == null || simplePlainQueue2.isEmpty()) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z14 && z11 && this.f20035m == 2) {
                            this.f20031i = null;
                            subscriber.onComplete();
                            return;
                        }
                    }
                }
                this.f20036n = j11;
                this.f20037o = i12;
                i15 = addAndGet(-i15);
                if (i15 != 0) {
                    i14 = 1;
                } else {
                    return;
                }
            }
        }

        public SimplePlainQueue<T> c() {
            SimplePlainQueue<T> simplePlainQueue = this.f20031i;
            if (simplePlainQueue != null) {
                return simplePlainQueue;
            }
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(Flowable.bufferSize());
            this.f20031i = spscArrayQueue;
            return spscArrayQueue;
        }

        public void cancel() {
            this.f20033k = true;
            SubscriptionHelper.cancel(this.f20025c);
            DisposableHelper.dispose(this.f20026d);
            this.f20027e.tryTerminateAndReport();
            if (getAndIncrement() == 0) {
                this.f20031i = null;
                this.f20032j = null;
            }
        }

        public void d(Throwable th2) {
            if (this.f20027e.tryAddThrowableOrReport(th2)) {
                SubscriptionHelper.cancel(this.f20025c);
                a();
            }
        }

        public void e(T t11) {
            if (compareAndSet(0, 1)) {
                long j11 = this.f20036n;
                if (this.f20028f.get() != j11) {
                    this.f20036n = j11 + 1;
                    this.f20024b.onNext(t11);
                    this.f20035m = 2;
                } else {
                    this.f20032j = t11;
                    this.f20035m = 1;
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            } else {
                this.f20032j = t11;
                this.f20035m = 1;
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        public void onComplete() {
            this.f20034l = true;
            a();
        }

        public void onError(Throwable th2) {
            if (this.f20027e.tryAddThrowableOrReport(th2)) {
                DisposableHelper.dispose(this.f20026d);
                a();
            }
        }

        public void onNext(T t11) {
            if (compareAndSet(0, 1)) {
                long j11 = this.f20036n;
                if (this.f20028f.get() != j11) {
                    SimplePlainQueue<T> simplePlainQueue = this.f20031i;
                    if (simplePlainQueue == null || simplePlainQueue.isEmpty()) {
                        this.f20036n = j11 + 1;
                        this.f20024b.onNext(t11);
                        int i11 = this.f20037o + 1;
                        if (i11 == this.f20030h) {
                            this.f20037o = 0;
                            this.f20025c.get().request((long) i11);
                        } else {
                            this.f20037o = i11;
                        }
                    } else {
                        simplePlainQueue.offer(t11);
                    }
                } else {
                    c().offer(t11);
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                c().offer(t11);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this.f20025c, subscription, (long) this.f20029g);
        }

        public void request(long j11) {
            BackpressureHelper.add(this.f20028f, j11);
            a();
        }
    }

    public FlowableMergeWithSingle(Flowable<T> flowable, SingleSource<? extends T> singleSource) {
        super(flowable);
        this.f20023d = singleSource;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(subscriber);
        subscriber.onSubscribe(mergeWithObserver);
        this.f19260c.subscribe(mergeWithObserver);
        this.f20023d.subscribe(mergeWithObserver.f20026d);
    }
}
