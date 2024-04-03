package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
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

public final class FlowableMergeWithMaybe<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final MaybeSource<? extends T> f20007d;

    public static final class MergeWithObserver<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -4592979584110982903L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f20008b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReference<Subscription> f20009c = new AtomicReference<>();

        /* renamed from: d  reason: collision with root package name */
        public final OtherObserver<T> f20010d = new OtherObserver<>(this);

        /* renamed from: e  reason: collision with root package name */
        public final AtomicThrowable f20011e = new AtomicThrowable();

        /* renamed from: f  reason: collision with root package name */
        public final AtomicLong f20012f = new AtomicLong();

        /* renamed from: g  reason: collision with root package name */
        public final int f20013g;

        /* renamed from: h  reason: collision with root package name */
        public final int f20014h;

        /* renamed from: i  reason: collision with root package name */
        public volatile SimplePlainQueue<T> f20015i;

        /* renamed from: j  reason: collision with root package name */
        public T f20016j;

        /* renamed from: k  reason: collision with root package name */
        public volatile boolean f20017k;

        /* renamed from: l  reason: collision with root package name */
        public volatile boolean f20018l;

        /* renamed from: m  reason: collision with root package name */
        public volatile int f20019m;

        /* renamed from: n  reason: collision with root package name */
        public long f20020n;

        /* renamed from: o  reason: collision with root package name */
        public int f20021o;

        public static final class OtherObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
            private static final long serialVersionUID = -2935427570954647017L;

            /* renamed from: b  reason: collision with root package name */
            public final MergeWithObserver<T> f20022b;

            public OtherObserver(MergeWithObserver<T> mergeWithObserver) {
                this.f20022b = mergeWithObserver;
            }

            public void onComplete() {
                this.f20022b.d();
            }

            public void onError(Throwable th2) {
                this.f20022b.e(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public void onSuccess(T t11) {
                this.f20022b.f(t11);
            }
        }

        public MergeWithObserver(Subscriber<? super T> subscriber) {
            this.f20008b = subscriber;
            int bufferSize = Flowable.bufferSize();
            this.f20013g = bufferSize;
            this.f20014h = bufferSize - (bufferSize >> 2);
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
            Subscriber<? super T> subscriber = this.f20008b;
            long j11 = this.f20020n;
            int i12 = this.f20021o;
            int i13 = this.f20014h;
            int i14 = 1;
            int i15 = 1;
            while (true) {
                long j12 = this.f20012f.get();
                while (true) {
                    i11 = (j11 > j12 ? 1 : (j11 == j12 ? 0 : -1));
                    if (i11 == 0) {
                        break;
                    } else if (this.f20017k) {
                        this.f20016j = null;
                        this.f20015i = null;
                        return;
                    } else if (this.f20011e.get() != null) {
                        this.f20016j = null;
                        this.f20015i = null;
                        this.f20011e.tryTerminateConsumer((Subscriber<?>) this.f20008b);
                        return;
                    } else {
                        int i16 = this.f20019m;
                        if (i16 == i14) {
                            T t12 = this.f20016j;
                            this.f20016j = null;
                            this.f20019m = 2;
                            subscriber.onNext(t12);
                            j11++;
                        } else {
                            boolean z13 = this.f20018l;
                            SimplePlainQueue<T> simplePlainQueue = this.f20015i;
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
                                this.f20015i = null;
                                subscriber.onComplete();
                                return;
                            } else if (z12) {
                                break;
                            } else {
                                subscriber.onNext(t11);
                                j11++;
                                i12++;
                                if (i12 == i13) {
                                    this.f20009c.get().request((long) i13);
                                    i12 = 0;
                                }
                                i14 = 1;
                            }
                        }
                    }
                }
                if (i11 == 0) {
                    if (this.f20017k) {
                        this.f20016j = null;
                        this.f20015i = null;
                        return;
                    } else if (this.f20011e.get() != null) {
                        this.f20016j = null;
                        this.f20015i = null;
                        this.f20011e.tryTerminateConsumer((Subscriber<?>) this.f20008b);
                        return;
                    } else {
                        boolean z14 = this.f20018l;
                        SimplePlainQueue<T> simplePlainQueue2 = this.f20015i;
                        if (simplePlainQueue2 == null || simplePlainQueue2.isEmpty()) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z14 && z11 && this.f20019m == 2) {
                            this.f20015i = null;
                            subscriber.onComplete();
                            return;
                        }
                    }
                }
                this.f20020n = j11;
                this.f20021o = i12;
                i15 = addAndGet(-i15);
                if (i15 != 0) {
                    i14 = 1;
                } else {
                    return;
                }
            }
        }

        public SimplePlainQueue<T> c() {
            SimplePlainQueue<T> simplePlainQueue = this.f20015i;
            if (simplePlainQueue != null) {
                return simplePlainQueue;
            }
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(Flowable.bufferSize());
            this.f20015i = spscArrayQueue;
            return spscArrayQueue;
        }

        public void cancel() {
            this.f20017k = true;
            SubscriptionHelper.cancel(this.f20009c);
            DisposableHelper.dispose(this.f20010d);
            this.f20011e.tryTerminateAndReport();
            if (getAndIncrement() == 0) {
                this.f20015i = null;
                this.f20016j = null;
            }
        }

        public void d() {
            this.f20019m = 2;
            a();
        }

        public void e(Throwable th2) {
            if (this.f20011e.tryAddThrowableOrReport(th2)) {
                SubscriptionHelper.cancel(this.f20009c);
                a();
            }
        }

        public void f(T t11) {
            if (compareAndSet(0, 1)) {
                long j11 = this.f20020n;
                if (this.f20012f.get() != j11) {
                    this.f20020n = j11 + 1;
                    this.f20008b.onNext(t11);
                    this.f20019m = 2;
                } else {
                    this.f20016j = t11;
                    this.f20019m = 1;
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            } else {
                this.f20016j = t11;
                this.f20019m = 1;
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        public void onComplete() {
            this.f20018l = true;
            a();
        }

        public void onError(Throwable th2) {
            if (this.f20011e.tryAddThrowableOrReport(th2)) {
                DisposableHelper.dispose(this.f20010d);
                a();
            }
        }

        public void onNext(T t11) {
            if (compareAndSet(0, 1)) {
                long j11 = this.f20020n;
                if (this.f20012f.get() != j11) {
                    SimplePlainQueue<T> simplePlainQueue = this.f20015i;
                    if (simplePlainQueue == null || simplePlainQueue.isEmpty()) {
                        this.f20020n = j11 + 1;
                        this.f20008b.onNext(t11);
                        int i11 = this.f20021o + 1;
                        if (i11 == this.f20014h) {
                            this.f20021o = 0;
                            this.f20009c.get().request((long) i11);
                        } else {
                            this.f20021o = i11;
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
            SubscriptionHelper.setOnce(this.f20009c, subscription, (long) this.f20013g);
        }

        public void request(long j11) {
            BackpressureHelper.add(this.f20012f, j11);
            a();
        }
    }

    public FlowableMergeWithMaybe(Flowable<T> flowable, MaybeSource<? extends T> maybeSource) {
        super(flowable);
        this.f20007d = maybeSource;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(subscriber);
        subscriber.onSubscribe(mergeWithObserver);
        this.f19260c.subscribe(mergeWithObserver);
        this.f20007d.subscribe(mergeWithObserver.f20010d);
    }
}
