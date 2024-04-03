package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
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

public final class FlowableConcatMapSingle<T, R> extends Flowable<R> {

    /* renamed from: c  reason: collision with root package name */
    public final Flowable<T> f21149c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends SingleSource<? extends R>> f21150d;

    /* renamed from: e  reason: collision with root package name */
    public final ErrorMode f21151e;

    /* renamed from: f  reason: collision with root package name */
    public final int f21152f;

    public static final class ConcatMapSingleSubscriber<T, R> extends ConcatMapXMainSubscriber<T> implements Subscription {
        private static final long serialVersionUID = -9140123220065488293L;

        /* renamed from: j  reason: collision with root package name */
        public final Subscriber<? super R> f21153j;

        /* renamed from: k  reason: collision with root package name */
        public final Function<? super T, ? extends SingleSource<? extends R>> f21154k;

        /* renamed from: l  reason: collision with root package name */
        public final AtomicLong f21155l = new AtomicLong();

        /* renamed from: m  reason: collision with root package name */
        public final ConcatMapSingleObserver<R> f21156m = new ConcatMapSingleObserver<>(this);

        /* renamed from: n  reason: collision with root package name */
        public long f21157n;

        /* renamed from: o  reason: collision with root package name */
        public int f21158o;

        /* renamed from: p  reason: collision with root package name */
        public R f21159p;

        /* renamed from: q  reason: collision with root package name */
        public volatile int f21160q;

        public static final class ConcatMapSingleObserver<R> extends AtomicReference<Disposable> implements SingleObserver<R> {
            private static final long serialVersionUID = -3051469169682093892L;

            /* renamed from: b  reason: collision with root package name */
            public final ConcatMapSingleSubscriber<?, R> f21161b;

            public ConcatMapSingleObserver(ConcatMapSingleSubscriber<?, R> concatMapSingleSubscriber) {
                this.f21161b = concatMapSingleSubscriber;
            }

            public void a() {
                DisposableHelper.dispose(this);
            }

            public void onError(Throwable th2) {
                this.f21161b.f(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }

            public void onSuccess(R r11) {
                this.f21161b.g(r11);
            }
        }

        public ConcatMapSingleSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends SingleSource<? extends R>> function, int i11, ErrorMode errorMode) {
            super(i11, errorMode);
            this.f21153j = subscriber;
            this.f21154k = function;
        }

        public void a() {
            this.f21159p = null;
        }

        public void b() {
            this.f21156m.a();
        }

        public void c() {
            boolean z11;
            if (getAndIncrement() == 0) {
                Subscriber<? super R> subscriber = this.f21153j;
                ErrorMode errorMode = this.f21116d;
                SimpleQueue<T> simpleQueue = this.f21117e;
                AtomicThrowable atomicThrowable = this.f21114b;
                AtomicLong atomicLong = this.f21155l;
                int i11 = this.f21115c;
                int i12 = i11 - (i11 >> 1);
                boolean z12 = this.f21121i;
                int i13 = 1;
                while (true) {
                    if (this.f21120h) {
                        simpleQueue.clear();
                        this.f21159p = null;
                    } else {
                        int i14 = this.f21160q;
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
                                            int i15 = this.f21158o + 1;
                                            if (i15 == i12) {
                                                this.f21158o = 0;
                                                this.f21118f.request((long) i12);
                                            } else {
                                                this.f21158o = i15;
                                            }
                                        }
                                        try {
                                            Object apply = this.f21154k.apply(poll);
                                            Objects.requireNonNull(apply, "The mapper returned a null SingleSource");
                                            SingleSource singleSource = (SingleSource) apply;
                                            this.f21160q = 1;
                                            singleSource.subscribe(this.f21156m);
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
                                long j11 = this.f21157n;
                                if (j11 != atomicLong.get()) {
                                    R r11 = this.f21159p;
                                    this.f21159p = null;
                                    subscriber.onNext(r11);
                                    this.f21157n = j11 + 1;
                                    this.f21160q = 0;
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
                this.f21159p = null;
                atomicThrowable.tryTerminateConsumer((Subscriber<?>) subscriber);
            }
        }

        public void cancel() {
            e();
        }

        public void d() {
            this.f21153j.onSubscribe(this);
        }

        public void f(Throwable th2) {
            if (this.f21114b.tryAddThrowableOrReport(th2)) {
                if (this.f21116d != ErrorMode.END) {
                    this.f21118f.cancel();
                }
                this.f21160q = 0;
                c();
            }
        }

        public void g(R r11) {
            this.f21159p = r11;
            this.f21160q = 2;
            c();
        }

        public void request(long j11) {
            BackpressureHelper.add(this.f21155l, j11);
            c();
        }
    }

    public FlowableConcatMapSingle(Flowable<T> flowable, Function<? super T, ? extends SingleSource<? extends R>> function, ErrorMode errorMode, int i11) {
        this.f21149c = flowable;
        this.f21150d = function;
        this.f21151e = errorMode;
        this.f21152f = i11;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f21149c.subscribe(new ConcatMapSingleSubscriber(subscriber, this.f21150d, this.f21152f, this.f21151e));
    }
}
