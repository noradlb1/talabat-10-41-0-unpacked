package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
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

public final class FlowableMergeWithMaybe<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final MaybeSource<? extends T> f15484d;

    public static final class MergeWithObserver<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -4592979584110982903L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15485b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReference<Subscription> f15486c = new AtomicReference<>();

        /* renamed from: d  reason: collision with root package name */
        public final OtherObserver<T> f15487d = new OtherObserver<>(this);

        /* renamed from: e  reason: collision with root package name */
        public final AtomicThrowable f15488e = new AtomicThrowable();

        /* renamed from: f  reason: collision with root package name */
        public final AtomicLong f15489f = new AtomicLong();

        /* renamed from: g  reason: collision with root package name */
        public final int f15490g;

        /* renamed from: h  reason: collision with root package name */
        public final int f15491h;

        /* renamed from: i  reason: collision with root package name */
        public volatile SimplePlainQueue<T> f15492i;

        /* renamed from: j  reason: collision with root package name */
        public T f15493j;

        /* renamed from: k  reason: collision with root package name */
        public volatile boolean f15494k;

        /* renamed from: l  reason: collision with root package name */
        public volatile boolean f15495l;

        /* renamed from: m  reason: collision with root package name */
        public volatile int f15496m;

        /* renamed from: n  reason: collision with root package name */
        public long f15497n;

        /* renamed from: o  reason: collision with root package name */
        public int f15498o;

        public static final class OtherObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
            private static final long serialVersionUID = -2935427570954647017L;

            /* renamed from: b  reason: collision with root package name */
            public final MergeWithObserver<T> f15499b;

            public OtherObserver(MergeWithObserver<T> mergeWithObserver) {
                this.f15499b = mergeWithObserver;
            }

            public void onComplete() {
                this.f15499b.d();
            }

            public void onError(Throwable th2) {
                this.f15499b.e(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public void onSuccess(T t11) {
                this.f15499b.f(t11);
            }
        }

        public MergeWithObserver(Subscriber<? super T> subscriber) {
            this.f15485b = subscriber;
            int bufferSize = Flowable.bufferSize();
            this.f15490g = bufferSize;
            this.f15491h = bufferSize - (bufferSize >> 2);
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
            Subscriber<? super T> subscriber = this.f15485b;
            long j11 = this.f15497n;
            int i12 = this.f15498o;
            int i13 = this.f15491h;
            int i14 = 1;
            int i15 = 1;
            while (true) {
                long j12 = this.f15489f.get();
                while (true) {
                    i11 = (j11 > j12 ? 1 : (j11 == j12 ? 0 : -1));
                    if (i11 == 0) {
                        break;
                    } else if (this.f15494k) {
                        this.f15493j = null;
                        this.f15492i = null;
                        return;
                    } else if (this.f15488e.get() != null) {
                        this.f15493j = null;
                        this.f15492i = null;
                        subscriber.onError(this.f15488e.terminate());
                        return;
                    } else {
                        int i16 = this.f15496m;
                        if (i16 == i14) {
                            T t12 = this.f15493j;
                            this.f15493j = null;
                            this.f15496m = 2;
                            subscriber.onNext(t12);
                            j11++;
                        } else {
                            boolean z13 = this.f15495l;
                            SimplePlainQueue<T> simplePlainQueue = this.f15492i;
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
                                this.f15492i = null;
                                subscriber.onComplete();
                                return;
                            } else if (z12) {
                                break;
                            } else {
                                subscriber.onNext(t11);
                                j11++;
                                i12++;
                                if (i12 == i13) {
                                    this.f15486c.get().request((long) i13);
                                    i12 = 0;
                                }
                                i14 = 1;
                            }
                        }
                    }
                }
                if (i11 == 0) {
                    if (this.f15494k) {
                        this.f15493j = null;
                        this.f15492i = null;
                        return;
                    } else if (this.f15488e.get() != null) {
                        this.f15493j = null;
                        this.f15492i = null;
                        subscriber.onError(this.f15488e.terminate());
                        return;
                    } else {
                        boolean z14 = this.f15495l;
                        SimplePlainQueue<T> simplePlainQueue2 = this.f15492i;
                        if (simplePlainQueue2 == null || simplePlainQueue2.isEmpty()) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z14 && z11 && this.f15496m == 2) {
                            this.f15492i = null;
                            subscriber.onComplete();
                            return;
                        }
                    }
                }
                this.f15497n = j11;
                this.f15498o = i12;
                i15 = addAndGet(-i15);
                if (i15 != 0) {
                    i14 = 1;
                } else {
                    return;
                }
            }
        }

        public SimplePlainQueue<T> c() {
            SimplePlainQueue<T> simplePlainQueue = this.f15492i;
            if (simplePlainQueue != null) {
                return simplePlainQueue;
            }
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(Flowable.bufferSize());
            this.f15492i = spscArrayQueue;
            return spscArrayQueue;
        }

        public void cancel() {
            this.f15494k = true;
            SubscriptionHelper.cancel(this.f15486c);
            DisposableHelper.dispose(this.f15487d);
            if (getAndIncrement() == 0) {
                this.f15492i = null;
                this.f15493j = null;
            }
        }

        public void d() {
            this.f15496m = 2;
            a();
        }

        public void e(Throwable th2) {
            if (this.f15488e.addThrowable(th2)) {
                SubscriptionHelper.cancel(this.f15486c);
                a();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void f(T t11) {
            if (compareAndSet(0, 1)) {
                long j11 = this.f15497n;
                if (this.f15489f.get() != j11) {
                    this.f15497n = j11 + 1;
                    this.f15485b.onNext(t11);
                    this.f15496m = 2;
                } else {
                    this.f15493j = t11;
                    this.f15496m = 1;
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            } else {
                this.f15493j = t11;
                this.f15496m = 1;
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        public void onComplete() {
            this.f15495l = true;
            a();
        }

        public void onError(Throwable th2) {
            if (this.f15488e.addThrowable(th2)) {
                DisposableHelper.dispose(this.f15487d);
                a();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            if (compareAndSet(0, 1)) {
                long j11 = this.f15497n;
                if (this.f15489f.get() != j11) {
                    SimplePlainQueue<T> simplePlainQueue = this.f15492i;
                    if (simplePlainQueue == null || simplePlainQueue.isEmpty()) {
                        this.f15497n = j11 + 1;
                        this.f15485b.onNext(t11);
                        int i11 = this.f15498o + 1;
                        if (i11 == this.f15491h) {
                            this.f15498o = 0;
                            this.f15486c.get().request((long) i11);
                        } else {
                            this.f15498o = i11;
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
            SubscriptionHelper.setOnce(this.f15486c, subscription, (long) this.f15490g);
        }

        public void request(long j11) {
            BackpressureHelper.add(this.f15489f, j11);
            a();
        }
    }

    public FlowableMergeWithMaybe(Flowable<T> flowable, MaybeSource<? extends T> maybeSource) {
        super(flowable);
        this.f15484d = maybeSource;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(subscriber);
        subscriber.onSubscribe(mergeWithObserver);
        this.f14763c.subscribe(mergeWithObserver);
        this.f15484d.subscribe(mergeWithObserver.f15487d);
    }
}
