package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import io.reactivex.rxjava3.operators.SimpleQueue;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableConcatMapCompletable<T> extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final Flowable<T> f21122b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends CompletableSource> f21123c;

    /* renamed from: d  reason: collision with root package name */
    public final ErrorMode f21124d;

    /* renamed from: e  reason: collision with root package name */
    public final int f21125e;

    public static final class ConcatMapCompletableObserver<T> extends ConcatMapXMainSubscriber<T> implements Disposable {
        private static final long serialVersionUID = 3610901111000061034L;

        /* renamed from: j  reason: collision with root package name */
        public final CompletableObserver f21126j;

        /* renamed from: k  reason: collision with root package name */
        public final Function<? super T, ? extends CompletableSource> f21127k;

        /* renamed from: l  reason: collision with root package name */
        public final ConcatMapInnerObserver f21128l = new ConcatMapInnerObserver(this);

        /* renamed from: m  reason: collision with root package name */
        public volatile boolean f21129m;

        /* renamed from: n  reason: collision with root package name */
        public int f21130n;

        public static final class ConcatMapInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = 5638352172918776687L;

            /* renamed from: b  reason: collision with root package name */
            public final ConcatMapCompletableObserver<?> f21131b;

            public ConcatMapInnerObserver(ConcatMapCompletableObserver<?> concatMapCompletableObserver) {
                this.f21131b = concatMapCompletableObserver;
            }

            public void a() {
                DisposableHelper.dispose(this);
            }

            public void onComplete() {
                this.f21131b.f();
            }

            public void onError(Throwable th2) {
                this.f21131b.g(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }
        }

        public ConcatMapCompletableObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, ErrorMode errorMode, int i11) {
            super(i11, errorMode);
            this.f21126j = completableObserver;
            this.f21127k = function;
        }

        public void b() {
            this.f21128l.a();
        }

        public void c() {
            boolean z11;
            if (getAndIncrement() == 0) {
                ErrorMode errorMode = this.f21116d;
                SimpleQueue<T> simpleQueue = this.f21117e;
                AtomicThrowable atomicThrowable = this.f21114b;
                boolean z12 = this.f21121i;
                while (!this.f21120h) {
                    if (atomicThrowable.get() == null || (errorMode != ErrorMode.IMMEDIATE && (errorMode != ErrorMode.BOUNDARY || this.f21129m))) {
                        if (!this.f21129m) {
                            boolean z13 = this.f21119g;
                            try {
                                T poll = simpleQueue.poll();
                                if (poll == null) {
                                    z11 = true;
                                } else {
                                    z11 = false;
                                }
                                if (z13 && z11) {
                                    atomicThrowable.tryTerminateConsumer(this.f21126j);
                                    return;
                                } else if (!z11) {
                                    int i11 = this.f21115c;
                                    int i12 = i11 - (i11 >> 1);
                                    if (!z12) {
                                        int i13 = this.f21130n + 1;
                                        if (i13 == i12) {
                                            this.f21130n = 0;
                                            this.f21118f.request((long) i12);
                                        } else {
                                            this.f21130n = i13;
                                        }
                                    }
                                    try {
                                        Object apply = this.f21127k.apply(poll);
                                        Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
                                        CompletableSource completableSource = (CompletableSource) apply;
                                        this.f21129m = true;
                                        completableSource.subscribe(this.f21128l);
                                    } catch (Throwable th2) {
                                        Exceptions.throwIfFatal(th2);
                                        simpleQueue.clear();
                                        this.f21118f.cancel();
                                        atomicThrowable.tryAddThrowableOrReport(th2);
                                        atomicThrowable.tryTerminateConsumer(this.f21126j);
                                        return;
                                    }
                                }
                            } catch (Throwable th3) {
                                Exceptions.throwIfFatal(th3);
                                this.f21118f.cancel();
                                atomicThrowable.tryAddThrowableOrReport(th3);
                                atomicThrowable.tryTerminateConsumer(this.f21126j);
                                return;
                            }
                        }
                        if (decrementAndGet() == 0) {
                            return;
                        }
                    } else {
                        simpleQueue.clear();
                        atomicThrowable.tryTerminateConsumer(this.f21126j);
                        return;
                    }
                }
                simpleQueue.clear();
            }
        }

        public void d() {
            this.f21126j.onSubscribe(this);
        }

        public void dispose() {
            e();
        }

        public void f() {
            this.f21129m = false;
            c();
        }

        public void g(Throwable th2) {
            if (!this.f21114b.tryAddThrowableOrReport(th2)) {
                return;
            }
            if (this.f21116d == ErrorMode.IMMEDIATE) {
                this.f21118f.cancel();
                this.f21114b.tryTerminateConsumer(this.f21126j);
                if (getAndIncrement() == 0) {
                    this.f21117e.clear();
                    return;
                }
                return;
            }
            this.f21129m = false;
            c();
        }

        public boolean isDisposed() {
            return this.f21120h;
        }
    }

    public FlowableConcatMapCompletable(Flowable<T> flowable, Function<? super T, ? extends CompletableSource> function, ErrorMode errorMode, int i11) {
        this.f21122b = flowable;
        this.f21123c = function;
        this.f21124d = errorMode;
        this.f21125e = i11;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f21122b.subscribe(new ConcatMapCompletableObserver(completableObserver, this.f21123c, this.f21124d, this.f21125e));
    }
}
