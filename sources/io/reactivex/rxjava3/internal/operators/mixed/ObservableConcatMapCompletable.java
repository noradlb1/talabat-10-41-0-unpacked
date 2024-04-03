package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import io.reactivex.rxjava3.operators.SimpleQueue;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatMapCompletable<T> extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final Observable<T> f21231b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends CompletableSource> f21232c;

    /* renamed from: d  reason: collision with root package name */
    public final ErrorMode f21233d;

    /* renamed from: e  reason: collision with root package name */
    public final int f21234e;

    public static final class ConcatMapCompletableObserver<T> extends ConcatMapXMainObserver<T> {
        private static final long serialVersionUID = 3610901111000061034L;

        /* renamed from: i  reason: collision with root package name */
        public final CompletableObserver f21235i;

        /* renamed from: j  reason: collision with root package name */
        public final Function<? super T, ? extends CompletableSource> f21236j;

        /* renamed from: k  reason: collision with root package name */
        public final ConcatMapInnerObserver f21237k = new ConcatMapInnerObserver(this);

        /* renamed from: l  reason: collision with root package name */
        public volatile boolean f21238l;

        public static final class ConcatMapInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = 5638352172918776687L;

            /* renamed from: b  reason: collision with root package name */
            public final ConcatMapCompletableObserver<?> f21239b;

            public ConcatMapInnerObserver(ConcatMapCompletableObserver<?> concatMapCompletableObserver) {
                this.f21239b = concatMapCompletableObserver;
            }

            public void a() {
                DisposableHelper.dispose(this);
            }

            public void onComplete() {
                this.f21239b.e();
            }

            public void onError(Throwable th2) {
                this.f21239b.f(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }
        }

        public ConcatMapCompletableObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, ErrorMode errorMode, int i11) {
            super(i11, errorMode);
            this.f21235i = completableObserver;
            this.f21236j = function;
        }

        public void b() {
            this.f21237k.a();
        }

        public void c() {
            boolean z11;
            CompletableSource completableSource;
            if (getAndIncrement() == 0) {
                AtomicThrowable atomicThrowable = this.f21107b;
                ErrorMode errorMode = this.f21109d;
                SimpleQueue<T> simpleQueue = this.f21110e;
                while (!this.f21113h) {
                    if (atomicThrowable.get() == null || (errorMode != ErrorMode.IMMEDIATE && (errorMode != ErrorMode.BOUNDARY || this.f21238l))) {
                        if (!this.f21238l) {
                            boolean z12 = this.f21112g;
                            try {
                                T poll = simpleQueue.poll();
                                if (poll != null) {
                                    Object apply = this.f21236j.apply(poll);
                                    Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
                                    completableSource = (CompletableSource) apply;
                                    z11 = false;
                                } else {
                                    completableSource = null;
                                    z11 = true;
                                }
                                if (z12 && z11) {
                                    this.f21113h = true;
                                    atomicThrowable.tryTerminateConsumer(this.f21235i);
                                    return;
                                } else if (!z11) {
                                    this.f21238l = true;
                                    completableSource.subscribe(this.f21237k);
                                }
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                this.f21113h = true;
                                simpleQueue.clear();
                                this.f21111f.dispose();
                                atomicThrowable.tryAddThrowableOrReport(th2);
                                atomicThrowable.tryTerminateConsumer(this.f21235i);
                                return;
                            }
                        }
                        if (decrementAndGet() == 0) {
                            return;
                        }
                    } else {
                        this.f21113h = true;
                        simpleQueue.clear();
                        atomicThrowable.tryTerminateConsumer(this.f21235i);
                        return;
                    }
                }
                simpleQueue.clear();
            }
        }

        public void d() {
            this.f21235i.onSubscribe(this);
        }

        public void e() {
            this.f21238l = false;
            c();
        }

        public void f(Throwable th2) {
            if (this.f21107b.tryAddThrowableOrReport(th2)) {
                if (this.f21109d != ErrorMode.END) {
                    this.f21111f.dispose();
                }
                this.f21238l = false;
                c();
            }
        }
    }

    public ObservableConcatMapCompletable(Observable<T> observable, Function<? super T, ? extends CompletableSource> function, ErrorMode errorMode, int i11) {
        this.f21231b = observable;
        this.f21232c = function;
        this.f21233d = errorMode;
        this.f21234e = i11;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        if (!ScalarXMapZHelper.a(this.f21231b, this.f21232c, completableObserver)) {
            this.f21231b.subscribe(new ConcatMapCompletableObserver(completableObserver, this.f21232c, this.f21233d, this.f21234e));
        }
    }
}
