package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableMergeWithSingle<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final SingleSource<? extends T> f15500d;

    public static final class MergeWithObserver<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -4592979584110982903L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15501b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReference<Subscription> f15502c = new AtomicReference<>();

        /* renamed from: d  reason: collision with root package name */
        public final OtherObserver<T> f15503d = new OtherObserver<>(this);

        /* renamed from: e  reason: collision with root package name */
        public final AtomicThrowable f15504e = new AtomicThrowable();

        /* renamed from: f  reason: collision with root package name */
        public final AtomicLong f15505f = new AtomicLong();

        /* renamed from: g  reason: collision with root package name */
        public final int f15506g;

        /* renamed from: h  reason: collision with root package name */
        public final int f15507h;

        /* renamed from: i  reason: collision with root package name */
        public volatile SimplePlainQueue<T> f15508i;

        /* renamed from: j  reason: collision with root package name */
        public T f15509j;

        /* renamed from: k  reason: collision with root package name */
        public volatile boolean f15510k;

        /* renamed from: l  reason: collision with root package name */
        public volatile boolean f15511l;

        /* renamed from: m  reason: collision with root package name */
        public volatile int f15512m;

        /* renamed from: n  reason: collision with root package name */
        public long f15513n;

        /* renamed from: o  reason: collision with root package name */
        public int f15514o;

        public static final class OtherObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T> {
            private static final long serialVersionUID = -2935427570954647017L;

            /* renamed from: b  reason: collision with root package name */
            public final MergeWithObserver<T> f15515b;

            public OtherObserver(MergeWithObserver<T> mergeWithObserver) {
                this.f15515b = mergeWithObserver;
            }

            public void onError(Throwable th2) {
                this.f15515b.d(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public void onSuccess(T t11) {
                this.f15515b.e(t11);
            }
        }

        public MergeWithObserver(Subscriber<? super T> subscriber) {
            this.f15501b = subscriber;
            int bufferSize = Flowable.bufferSize();
            this.f15506g = bufferSize;
            this.f15507h = bufferSize - (bufferSize >> 2);
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
            Subscriber<? super T> subscriber = this.f15501b;
            long j11 = this.f15513n;
            int i12 = this.f15514o;
            int i13 = this.f15507h;
            int i14 = 1;
            int i15 = 1;
            while (true) {
                long j12 = this.f15505f.get();
                while (true) {
                    i11 = (j11 > j12 ? 1 : (j11 == j12 ? 0 : -1));
                    if (i11 == 0) {
                        break;
                    } else if (this.f15510k) {
                        this.f15509j = null;
                        this.f15508i = null;
                        return;
                    } else if (this.f15504e.get() != null) {
                        this.f15509j = null;
                        this.f15508i = null;
                        subscriber.onError(this.f15504e.terminate());
                        return;
                    } else {
                        int i16 = this.f15512m;
                        if (i16 == i14) {
                            T t12 = this.f15509j;
                            this.f15509j = null;
                            this.f15512m = 2;
                            subscriber.onNext(t12);
                            j11++;
                        } else {
                            boolean z13 = this.f15511l;
                            SimplePlainQueue<T> simplePlainQueue = this.f15508i;
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
                                this.f15508i = null;
                                subscriber.onComplete();
                                return;
                            } else if (z12) {
                                break;
                            } else {
                                subscriber.onNext(t11);
                                j11++;
                                i12++;
                                if (i12 == i13) {
                                    this.f15502c.get().request((long) i13);
                                    i12 = 0;
                                }
                                i14 = 1;
                            }
                        }
                    }
                }
                if (i11 == 0) {
                    if (this.f15510k) {
                        this.f15509j = null;
                        this.f15508i = null;
                        return;
                    } else if (this.f15504e.get() != null) {
                        this.f15509j = null;
                        this.f15508i = null;
                        subscriber.onError(this.f15504e.terminate());
                        return;
                    } else {
                        boolean z14 = this.f15511l;
                        SimplePlainQueue<T> simplePlainQueue2 = this.f15508i;
                        if (simplePlainQueue2 == null || simplePlainQueue2.isEmpty()) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z14 && z11 && this.f15512m == 2) {
                            this.f15508i = null;
                            subscriber.onComplete();
                            return;
                        }
                    }
                }
                this.f15513n = j11;
                this.f15514o = i12;
                i15 = addAndGet(-i15);
                if (i15 != 0) {
                    i14 = 1;
                } else {
                    return;
                }
            }
        }

        public SimplePlainQueue<T> c() {
            SimplePlainQueue<T> simplePlainQueue = this.f15508i;
            if (simplePlainQueue != null) {
                return simplePlainQueue;
            }
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(Flowable.bufferSize());
            this.f15508i = spscArrayQueue;
            return spscArrayQueue;
        }

        public void cancel() {
            this.f15510k = true;
            SubscriptionHelper.cancel(this.f15502c);
            DisposableHelper.dispose(this.f15503d);
            if (getAndIncrement() == 0) {
                this.f15508i = null;
                this.f15509j = null;
            }
        }

        public void d(Throwable th2) {
            if (this.f15504e.addThrowable(th2)) {
                SubscriptionHelper.cancel(this.f15502c);
                a();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void e(T t11) {
            if (compareAndSet(0, 1)) {
                long j11 = this.f15513n;
                if (this.f15505f.get() != j11) {
                    this.f15513n = j11 + 1;
                    this.f15501b.onNext(t11);
                    this.f15512m = 2;
                } else {
                    this.f15509j = t11;
                    this.f15512m = 1;
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            } else {
                this.f15509j = t11;
                this.f15512m = 1;
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        public void onComplete() {
            this.f15511l = true;
            a();
        }

        public void onError(Throwable th2) {
            if (this.f15504e.addThrowable(th2)) {
                DisposableHelper.dispose(this.f15503d);
                a();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            if (compareAndSet(0, 1)) {
                long j11 = this.f15513n;
                if (this.f15505f.get() != j11) {
                    SimplePlainQueue<T> simplePlainQueue = this.f15508i;
                    if (simplePlainQueue == null || simplePlainQueue.isEmpty()) {
                        this.f15513n = j11 + 1;
                        this.f15501b.onNext(t11);
                        int i11 = this.f15514o + 1;
                        if (i11 == this.f15507h) {
                            this.f15514o = 0;
                            this.f15502c.get().request((long) i11);
                        } else {
                            this.f15514o = i11;
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
            SubscriptionHelper.setOnce(this.f15502c, subscription, (long) this.f15506g);
        }

        public void request(long j11) {
            BackpressureHelper.add(this.f15505f, j11);
            a();
        }
    }

    public FlowableMergeWithSingle(Flowable<T> flowable, SingleSource<? extends T> singleSource) {
        super(flowable);
        this.f15500d = singleSource;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(subscriber);
        subscriber.onSubscribe(mergeWithObserver);
        this.f14763c.subscribe(mergeWithObserver);
        this.f15500d.subscribe(mergeWithObserver.f15503d);
    }
}
