package io.reactivex.internal.operators.mixed;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
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

public final class FlowableConcatMapMaybe<T, R> extends Flowable<R> {

    /* renamed from: c  reason: collision with root package name */
    public final Flowable<T> f16611c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends MaybeSource<? extends R>> f16612d;

    /* renamed from: e  reason: collision with root package name */
    public final ErrorMode f16613e;

    /* renamed from: f  reason: collision with root package name */
    public final int f16614f;

    public static final class ConcatMapMaybeSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -9140123220065488293L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f16615b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends MaybeSource<? extends R>> f16616c;

        /* renamed from: d  reason: collision with root package name */
        public final int f16617d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicLong f16618e = new AtomicLong();

        /* renamed from: f  reason: collision with root package name */
        public final AtomicThrowable f16619f = new AtomicThrowable();

        /* renamed from: g  reason: collision with root package name */
        public final ConcatMapMaybeObserver<R> f16620g = new ConcatMapMaybeObserver<>(this);

        /* renamed from: h  reason: collision with root package name */
        public final SimplePlainQueue<T> f16621h;

        /* renamed from: i  reason: collision with root package name */
        public final ErrorMode f16622i;

        /* renamed from: j  reason: collision with root package name */
        public Subscription f16623j;

        /* renamed from: k  reason: collision with root package name */
        public volatile boolean f16624k;

        /* renamed from: l  reason: collision with root package name */
        public volatile boolean f16625l;

        /* renamed from: m  reason: collision with root package name */
        public long f16626m;

        /* renamed from: n  reason: collision with root package name */
        public int f16627n;

        /* renamed from: o  reason: collision with root package name */
        public R f16628o;

        /* renamed from: p  reason: collision with root package name */
        public volatile int f16629p;

        public static final class ConcatMapMaybeObserver<R> extends AtomicReference<Disposable> implements MaybeObserver<R> {
            private static final long serialVersionUID = -3051469169682093892L;

            /* renamed from: b  reason: collision with root package name */
            public final ConcatMapMaybeSubscriber<?, R> f16630b;

            public ConcatMapMaybeObserver(ConcatMapMaybeSubscriber<?, R> concatMapMaybeSubscriber) {
                this.f16630b = concatMapMaybeSubscriber;
            }

            public void a() {
                DisposableHelper.dispose(this);
            }

            public void onComplete() {
                this.f16630b.b();
            }

            public void onError(Throwable th2) {
                this.f16630b.c(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }

            public void onSuccess(R r11) {
                this.f16630b.d(r11);
            }
        }

        public ConcatMapMaybeSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends MaybeSource<? extends R>> function, int i11, ErrorMode errorMode) {
            this.f16615b = subscriber;
            this.f16616c = function;
            this.f16617d = i11;
            this.f16622i = errorMode;
            this.f16621h = new SpscArrayQueue(i11);
        }

        public void a() {
            boolean z11;
            if (getAndIncrement() == 0) {
                Subscriber<? super R> subscriber = this.f16615b;
                ErrorMode errorMode = this.f16622i;
                SimplePlainQueue<T> simplePlainQueue = this.f16621h;
                AtomicThrowable atomicThrowable = this.f16619f;
                AtomicLong atomicLong = this.f16618e;
                int i11 = this.f16617d;
                int i12 = i11 - (i11 >> 1);
                int i13 = 1;
                while (true) {
                    if (this.f16625l) {
                        simplePlainQueue.clear();
                        this.f16628o = null;
                    } else {
                        int i14 = this.f16629p;
                        if (atomicThrowable.get() == null || !(errorMode == ErrorMode.IMMEDIATE || (errorMode == ErrorMode.BOUNDARY && i14 == 0))) {
                            if (i14 == 0) {
                                boolean z12 = this.f16624k;
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
                                    int i15 = this.f16627n + 1;
                                    if (i15 == i12) {
                                        this.f16627n = 0;
                                        this.f16623j.request((long) i12);
                                    } else {
                                        this.f16627n = i15;
                                    }
                                    try {
                                        MaybeSource maybeSource = (MaybeSource) ObjectHelper.requireNonNull(this.f16616c.apply(poll), "The mapper returned a null MaybeSource");
                                        this.f16629p = 1;
                                        maybeSource.subscribe(this.f16620g);
                                    } catch (Throwable th2) {
                                        Exceptions.throwIfFatal(th2);
                                        this.f16623j.cancel();
                                        simplePlainQueue.clear();
                                        atomicThrowable.addThrowable(th2);
                                        subscriber.onError(atomicThrowable.terminate());
                                        return;
                                    }
                                }
                            } else if (i14 == 2) {
                                long j11 = this.f16626m;
                                if (j11 != atomicLong.get()) {
                                    R r11 = this.f16628o;
                                    this.f16628o = null;
                                    subscriber.onNext(r11);
                                    this.f16626m = j11 + 1;
                                    this.f16629p = 0;
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
                this.f16628o = null;
                subscriber.onError(atomicThrowable.terminate());
            }
        }

        public void b() {
            this.f16629p = 0;
            a();
        }

        public void c(Throwable th2) {
            if (this.f16619f.addThrowable(th2)) {
                if (this.f16622i != ErrorMode.END) {
                    this.f16623j.cancel();
                }
                this.f16629p = 0;
                a();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void cancel() {
            this.f16625l = true;
            this.f16623j.cancel();
            this.f16620g.a();
            if (getAndIncrement() == 0) {
                this.f16621h.clear();
                this.f16628o = null;
            }
        }

        public void d(R r11) {
            this.f16628o = r11;
            this.f16629p = 2;
            a();
        }

        public void onComplete() {
            this.f16624k = true;
            a();
        }

        public void onError(Throwable th2) {
            if (this.f16619f.addThrowable(th2)) {
                if (this.f16622i == ErrorMode.IMMEDIATE) {
                    this.f16620g.a();
                }
                this.f16624k = true;
                a();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f16621h.offer(t11)) {
                this.f16623j.cancel();
                onError(new MissingBackpressureException("queue full?!"));
                return;
            }
            a();
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f16623j, subscription)) {
                this.f16623j = subscription;
                this.f16615b.onSubscribe(this);
                subscription.request((long) this.f16617d);
            }
        }

        public void request(long j11) {
            BackpressureHelper.add(this.f16618e, j11);
            a();
        }
    }

    public FlowableConcatMapMaybe(Flowable<T> flowable, Function<? super T, ? extends MaybeSource<? extends R>> function, ErrorMode errorMode, int i11) {
        this.f16611c = flowable;
        this.f16612d = function;
        this.f16613e = errorMode;
        this.f16614f = i11;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f16611c.subscribe(new ConcatMapMaybeSubscriber(subscriber, this.f16612d, this.f16614f, this.f16613e));
    }
}
