package io.reactivex.internal.operators.mixed;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableConcatMapSingle<T, R> extends Flowable<R> {

    /* renamed from: c  reason: collision with root package name */
    public final Flowable<T> f16631c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends SingleSource<? extends R>> f16632d;

    /* renamed from: e  reason: collision with root package name */
    public final ErrorMode f16633e;

    /* renamed from: f  reason: collision with root package name */
    public final int f16634f;

    public static final class ConcatMapSingleSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -9140123220065488293L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f16635b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends SingleSource<? extends R>> f16636c;

        /* renamed from: d  reason: collision with root package name */
        public final int f16637d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicLong f16638e = new AtomicLong();

        /* renamed from: f  reason: collision with root package name */
        public final AtomicThrowable f16639f = new AtomicThrowable();

        /* renamed from: g  reason: collision with root package name */
        public final ConcatMapSingleObserver<R> f16640g = new ConcatMapSingleObserver<>(this);

        /* renamed from: h  reason: collision with root package name */
        public final SimplePlainQueue<T> f16641h;

        /* renamed from: i  reason: collision with root package name */
        public final ErrorMode f16642i;

        /* renamed from: j  reason: collision with root package name */
        public Subscription f16643j;

        /* renamed from: k  reason: collision with root package name */
        public volatile boolean f16644k;

        /* renamed from: l  reason: collision with root package name */
        public volatile boolean f16645l;

        /* renamed from: m  reason: collision with root package name */
        public long f16646m;

        /* renamed from: n  reason: collision with root package name */
        public int f16647n;

        /* renamed from: o  reason: collision with root package name */
        public R f16648o;

        /* renamed from: p  reason: collision with root package name */
        public volatile int f16649p;

        public static final class ConcatMapSingleObserver<R> extends AtomicReference<Disposable> implements SingleObserver<R> {
            private static final long serialVersionUID = -3051469169682093892L;

            /* renamed from: b  reason: collision with root package name */
            public final ConcatMapSingleSubscriber<?, R> f16650b;

            public ConcatMapSingleObserver(ConcatMapSingleSubscriber<?, R> concatMapSingleSubscriber) {
                this.f16650b = concatMapSingleSubscriber;
            }

            public void a() {
                DisposableHelper.dispose(this);
            }

            public void onError(Throwable th2) {
                this.f16650b.b(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }

            public void onSuccess(R r11) {
                this.f16650b.c(r11);
            }
        }

        public ConcatMapSingleSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends SingleSource<? extends R>> function, int i11, ErrorMode errorMode) {
            this.f16635b = subscriber;
            this.f16636c = function;
            this.f16637d = i11;
            this.f16642i = errorMode;
            this.f16641h = new SpscArrayQueue(i11);
        }

        public void a() {
            boolean z11;
            if (getAndIncrement() == 0) {
                Subscriber<? super R> subscriber = this.f16635b;
                ErrorMode errorMode = this.f16642i;
                SimplePlainQueue<T> simplePlainQueue = this.f16641h;
                AtomicThrowable atomicThrowable = this.f16639f;
                AtomicLong atomicLong = this.f16638e;
                int i11 = this.f16637d;
                int i12 = i11 - (i11 >> 1);
                int i13 = 1;
                while (true) {
                    if (this.f16645l) {
                        simplePlainQueue.clear();
                        this.f16648o = null;
                    } else {
                        int i14 = this.f16649p;
                        if (atomicThrowable.get() == null || !(errorMode == ErrorMode.IMMEDIATE || (errorMode == ErrorMode.BOUNDARY && i14 == 0))) {
                            if (i14 == 0) {
                                boolean z12 = this.f16644k;
                                T poll = simplePlainQueue.poll();
                                if (poll == null) {
                                    z11 = true;
                                } else {
                                    z11 = false;
                                }
                                if (z12 && z11) {
                                    Throwable terminate = atomicThrowable.terminate();
                                    if (terminate == null) {
                                        subscriber.onComplete();
                                        return;
                                    } else {
                                        subscriber.onError(terminate);
                                        return;
                                    }
                                } else if (!z11) {
                                    int i15 = this.f16647n + 1;
                                    if (i15 == i12) {
                                        this.f16647n = 0;
                                        this.f16643j.request((long) i12);
                                    } else {
                                        this.f16647n = i15;
                                    }
                                    try {
                                        SingleSource singleSource = (SingleSource) ObjectHelper.requireNonNull(this.f16636c.apply(poll), "The mapper returned a null SingleSource");
                                        this.f16649p = 1;
                                        singleSource.subscribe(this.f16640g);
                                    } catch (Throwable th2) {
                                        Exceptions.throwIfFatal(th2);
                                        this.f16643j.cancel();
                                        simplePlainQueue.clear();
                                        atomicThrowable.addThrowable(th2);
                                        subscriber.onError(atomicThrowable.terminate());
                                        return;
                                    }
                                }
                            } else if (i14 == 2) {
                                long j11 = this.f16646m;
                                if (j11 != atomicLong.get()) {
                                    R r11 = this.f16648o;
                                    this.f16648o = null;
                                    subscriber.onNext(r11);
                                    this.f16646m = j11 + 1;
                                    this.f16649p = 0;
                                }
                            }
                        }
                    }
                    i13 = addAndGet(-i13);
                    if (i13 == 0) {
                        return;
                    }
                }
                simplePlainQueue.clear();
                this.f16648o = null;
                subscriber.onError(atomicThrowable.terminate());
            }
        }

        public void b(Throwable th2) {
            if (this.f16639f.addThrowable(th2)) {
                if (this.f16642i != ErrorMode.END) {
                    this.f16643j.cancel();
                }
                this.f16649p = 0;
                a();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void c(R r11) {
            this.f16648o = r11;
            this.f16649p = 2;
            a();
        }

        public void cancel() {
            this.f16645l = true;
            this.f16643j.cancel();
            this.f16640g.a();
            if (getAndIncrement() == 0) {
                this.f16641h.clear();
                this.f16648o = null;
            }
        }

        public void onComplete() {
            this.f16644k = true;
            a();
        }

        public void onError(Throwable th2) {
            if (this.f16639f.addThrowable(th2)) {
                if (this.f16642i == ErrorMode.IMMEDIATE) {
                    this.f16640g.a();
                }
                this.f16644k = true;
                a();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f16641h.offer(t11)) {
                this.f16643j.cancel();
                onError(new MissingBackpressureException("queue full?!"));
                return;
            }
            a();
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f16643j, subscription)) {
                this.f16643j = subscription;
                this.f16635b.onSubscribe(this);
                subscription.request((long) this.f16637d);
            }
        }

        public void request(long j11) {
            BackpressureHelper.add(this.f16638e, j11);
            a();
        }
    }

    public FlowableConcatMapSingle(Flowable<T> flowable, Function<? super T, ? extends SingleSource<? extends R>> function, ErrorMode errorMode, int i11) {
        this.f16631c = flowable;
        this.f16632d = function;
        this.f16633e = errorMode;
        this.f16634f = i11;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f16631c.subscribe(new ConcatMapSingleSubscriber(subscriber, this.f16632d, this.f16634f, this.f16633e));
    }
}
