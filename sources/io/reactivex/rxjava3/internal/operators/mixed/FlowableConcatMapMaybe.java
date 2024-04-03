package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import io.reactivex.rxjava3.operators.SimpleQueue;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableConcatMapMaybe<T, R> extends Flowable<R> {

    /* renamed from: c  reason: collision with root package name */
    public final Flowable<T> f21132c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends MaybeSource<? extends R>> f21133d;

    /* renamed from: e  reason: collision with root package name */
    public final ErrorMode f21134e;

    /* renamed from: f  reason: collision with root package name */
    public final int f21135f;

    public static final class ConcatMapMaybeSubscriber<T, R> extends ConcatMapXMainSubscriber<T> implements Subscription {
        private static final long serialVersionUID = -9140123220065488293L;

        /* renamed from: j  reason: collision with root package name */
        public final Subscriber<? super R> f21136j;

        /* renamed from: k  reason: collision with root package name */
        public final Function<? super T, ? extends MaybeSource<? extends R>> f21137k;

        /* renamed from: l  reason: collision with root package name */
        public final AtomicLong f21138l = new AtomicLong();

        /* renamed from: m  reason: collision with root package name */
        public final ConcatMapMaybeObserver<R> f21139m = new ConcatMapMaybeObserver<>(this);

        /* renamed from: n  reason: collision with root package name */
        public long f21140n;

        /* renamed from: o  reason: collision with root package name */
        public int f21141o;

        /* renamed from: p  reason: collision with root package name */
        public R f21142p;

        /* renamed from: q  reason: collision with root package name */
        public volatile int f21143q;

        public static final class ConcatMapMaybeObserver<R> extends AtomicReference<Disposable> implements MaybeObserver<R> {
            private static final long serialVersionUID = -3051469169682093892L;

            /* renamed from: b  reason: collision with root package name */
            public final ConcatMapMaybeSubscriber<?, R> f21144b;

            public ConcatMapMaybeObserver(ConcatMapMaybeSubscriber<?, R> concatMapMaybeSubscriber) {
                this.f21144b = concatMapMaybeSubscriber;
            }

            public void a() {
                DisposableHelper.dispose(this);
            }

            public void onComplete() {
                this.f21144b.f();
            }

            public void onError(Throwable th2) {
                this.f21144b.g(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }

            public void onSuccess(R r11) {
                this.f21144b.h(r11);
            }
        }

        public ConcatMapMaybeSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends MaybeSource<? extends R>> function, int i11, ErrorMode errorMode) {
            super(i11, errorMode);
            this.f21136j = subscriber;
            this.f21137k = function;
        }

        public void a() {
            this.f21142p = null;
        }

        public void b() {
            this.f21139m.a();
        }

        public void c() {
            boolean z11;
            if (getAndIncrement() == 0) {
                Subscriber<? super R> subscriber = this.f21136j;
                ErrorMode errorMode = this.f21116d;
                SimpleQueue<T> simpleQueue = this.f21117e;
                AtomicThrowable atomicThrowable = this.f21114b;
                AtomicLong atomicLong = this.f21138l;
                int i11 = this.f21115c;
                int i12 = i11 - (i11 >> 1);
                boolean z12 = this.f21121i;
                int i13 = 1;
                while (true) {
                    if (this.f21120h) {
                        simpleQueue.clear();
                        this.f21142p = null;
                    } else {
                        int i14 = this.f21143q;
                        if (atomicThrowable.get() == null || !(errorMode == ErrorMode.IMMEDIATE || (errorMode == ErrorMode.BOUNDARY && i14 == 0))) {
                            if (i14 == 0) {
                                boolean z13 = this.f21119g;
                                try {
                                    T poll = simpleQueue.poll();
                                    if (poll == null) {
                                        z11 = true;
                                    } else {
                                        z11 = false;
                                    }
                                    if (z13 && z11) {
                                        atomicThrowable.tryTerminateConsumer((Subscriber<?>) subscriber);
                                        return;
                                    } else if (!z11) {
                                        if (!z12) {
                                            int i15 = this.f21141o + 1;
                                            if (i15 == i12) {
                                                this.f21141o = 0;
                                                this.f21118f.request((long) i12);
                                            } else {
                                                this.f21141o = i15;
                                            }
                                        }
                                        try {
                                            Object apply = this.f21137k.apply(poll);
                                            Objects.requireNonNull(apply, "The mapper returned a null MaybeSource");
                                            MaybeSource maybeSource = (MaybeSource) apply;
                                            this.f21143q = 1;
                                            maybeSource.subscribe(this.f21139m);
                                        } catch (Throwable th2) {
                                            Exceptions.throwIfFatal(th2);
                                            this.f21118f.cancel();
                                            simpleQueue.clear();
                                            atomicThrowable.tryAddThrowableOrReport(th2);
                                            atomicThrowable.tryTerminateConsumer((Subscriber<?>) subscriber);
                                            return;
                                        }
                                    }
                                } catch (Throwable th3) {
                                    Throwable th4 = th3;
                                    Exceptions.throwIfFatal(th4);
                                    this.f21118f.cancel();
                                    atomicThrowable.tryAddThrowableOrReport(th4);
                                    atomicThrowable.tryTerminateConsumer((Subscriber<?>) subscriber);
                                    return;
                                }
                            } else if (i14 == 2) {
                                long j11 = this.f21140n;
                                if (j11 != atomicLong.get()) {
                                    R r11 = this.f21142p;
                                    this.f21142p = null;
                                    subscriber.onNext(r11);
                                    this.f21140n = j11 + 1;
                                    this.f21143q = 0;
                                }
                            }
                        }
                    }
                    i13 = addAndGet(-i13);
                    if (i13 == 0) {
                        return;
                    }
                }
                simpleQueue.clear();
                this.f21142p = null;
                atomicThrowable.tryTerminateConsumer((Subscriber<?>) subscriber);
            }
        }

        public void cancel() {
            e();
        }

        public void d() {
            this.f21136j.onSubscribe(this);
        }

        public void f() {
            this.f21143q = 0;
            c();
        }

        public void g(Throwable th2) {
            if (this.f21114b.tryAddThrowableOrReport(th2)) {
                if (this.f21116d != ErrorMode.END) {
                    this.f21118f.cancel();
                }
                this.f21143q = 0;
                c();
            }
        }

        public void h(R r11) {
            this.f21142p = r11;
            this.f21143q = 2;
            c();
        }

        public void request(long j11) {
            BackpressureHelper.add(this.f21138l, j11);
            c();
        }
    }

    public FlowableConcatMapMaybe(Flowable<T> flowable, Function<? super T, ? extends MaybeSource<? extends R>> function, ErrorMode errorMode, int i11) {
        this.f21132c = flowable;
        this.f21133d = function;
        this.f21134e = errorMode;
        this.f21135f = i11;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f21132c.subscribe(new ConcatMapMaybeSubscriber(subscriber, this.f21133d, this.f21135f, this.f21134e));
    }
}
