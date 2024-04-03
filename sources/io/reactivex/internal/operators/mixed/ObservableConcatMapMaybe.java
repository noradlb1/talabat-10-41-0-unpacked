package io.reactivex.internal.operators.mixed;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatMapMaybe<T, R> extends Observable<R> {

    /* renamed from: b  reason: collision with root package name */
    public final Observable<T> f16723b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends MaybeSource<? extends R>> f16724c;

    /* renamed from: d  reason: collision with root package name */
    public final ErrorMode f16725d;

    /* renamed from: e  reason: collision with root package name */
    public final int f16726e;

    public static final class ConcatMapMaybeMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -9140123220065488293L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f16727b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends MaybeSource<? extends R>> f16728c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicThrowable f16729d = new AtomicThrowable();

        /* renamed from: e  reason: collision with root package name */
        public final ConcatMapMaybeObserver<R> f16730e = new ConcatMapMaybeObserver<>(this);

        /* renamed from: f  reason: collision with root package name */
        public final SimplePlainQueue<T> f16731f;

        /* renamed from: g  reason: collision with root package name */
        public final ErrorMode f16732g;

        /* renamed from: h  reason: collision with root package name */
        public Disposable f16733h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f16734i;

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f16735j;

        /* renamed from: k  reason: collision with root package name */
        public R f16736k;

        /* renamed from: l  reason: collision with root package name */
        public volatile int f16737l;

        public static final class ConcatMapMaybeObserver<R> extends AtomicReference<Disposable> implements MaybeObserver<R> {
            private static final long serialVersionUID = -3051469169682093892L;

            /* renamed from: b  reason: collision with root package name */
            public final ConcatMapMaybeMainObserver<?, R> f16738b;

            public ConcatMapMaybeObserver(ConcatMapMaybeMainObserver<?, R> concatMapMaybeMainObserver) {
                this.f16738b = concatMapMaybeMainObserver;
            }

            public void a() {
                DisposableHelper.dispose(this);
            }

            public void onComplete() {
                this.f16738b.b();
            }

            public void onError(Throwable th2) {
                this.f16738b.c(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }

            public void onSuccess(R r11) {
                this.f16738b.d(r11);
            }
        }

        public ConcatMapMaybeMainObserver(Observer<? super R> observer, Function<? super T, ? extends MaybeSource<? extends R>> function, int i11, ErrorMode errorMode) {
            this.f16727b = observer;
            this.f16728c = function;
            this.f16732g = errorMode;
            this.f16731f = new SpscLinkedArrayQueue(i11);
        }

        public void a() {
            if (getAndIncrement() == 0) {
                Observer<? super R> observer = this.f16727b;
                ErrorMode errorMode = this.f16732g;
                SimplePlainQueue<T> simplePlainQueue = this.f16731f;
                AtomicThrowable atomicThrowable = this.f16729d;
                int i11 = 1;
                while (true) {
                    if (this.f16735j) {
                        simplePlainQueue.clear();
                        this.f16736k = null;
                    } else {
                        int i12 = this.f16737l;
                        if (atomicThrowable.get() == null || !(errorMode == ErrorMode.IMMEDIATE || (errorMode == ErrorMode.BOUNDARY && i12 == 0))) {
                            boolean z11 = false;
                            if (i12 == 0) {
                                boolean z12 = this.f16734i;
                                T poll = simplePlainQueue.poll();
                                if (poll == null) {
                                    z11 = true;
                                }
                                if (z12 && z11) {
                                    Throwable terminate = atomicThrowable.terminate();
                                    if (terminate == null) {
                                        observer.onComplete();
                                        return;
                                    } else {
                                        observer.onError(terminate);
                                        return;
                                    }
                                } else if (!z11) {
                                    try {
                                        MaybeSource maybeSource = (MaybeSource) ObjectHelper.requireNonNull(this.f16728c.apply(poll), "The mapper returned a null MaybeSource");
                                        this.f16737l = 1;
                                        maybeSource.subscribe(this.f16730e);
                                    } catch (Throwable th2) {
                                        Exceptions.throwIfFatal(th2);
                                        this.f16733h.dispose();
                                        simplePlainQueue.clear();
                                        atomicThrowable.addThrowable(th2);
                                        observer.onError(atomicThrowable.terminate());
                                        return;
                                    }
                                }
                            } else if (i12 == 2) {
                                R r11 = this.f16736k;
                                this.f16736k = null;
                                observer.onNext(r11);
                                this.f16737l = 0;
                            }
                        }
                    }
                    i11 = addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                }
                simplePlainQueue.clear();
                this.f16736k = null;
                observer.onError(atomicThrowable.terminate());
            }
        }

        public void b() {
            this.f16737l = 0;
            a();
        }

        public void c(Throwable th2) {
            if (this.f16729d.addThrowable(th2)) {
                if (this.f16732g != ErrorMode.END) {
                    this.f16733h.dispose();
                }
                this.f16737l = 0;
                a();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void d(R r11) {
            this.f16736k = r11;
            this.f16737l = 2;
            a();
        }

        public void dispose() {
            this.f16735j = true;
            this.f16733h.dispose();
            this.f16730e.a();
            if (getAndIncrement() == 0) {
                this.f16731f.clear();
                this.f16736k = null;
            }
        }

        public boolean isDisposed() {
            return this.f16735j;
        }

        public void onComplete() {
            this.f16734i = true;
            a();
        }

        public void onError(Throwable th2) {
            if (this.f16729d.addThrowable(th2)) {
                if (this.f16732g == ErrorMode.IMMEDIATE) {
                    this.f16730e.a();
                }
                this.f16734i = true;
                a();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            this.f16731f.offer(t11);
            a();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16733h, disposable)) {
                this.f16733h = disposable;
                this.f16727b.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMapMaybe(Observable<T> observable, Function<? super T, ? extends MaybeSource<? extends R>> function, ErrorMode errorMode, int i11) {
        this.f16723b = observable;
        this.f16724c = function;
        this.f16725d = errorMode;
        this.f16726e = i11;
    }

    public void subscribeActual(Observer<? super R> observer) {
        if (!ScalarXMapZHelper.b(this.f16723b, this.f16724c, observer)) {
            this.f16723b.subscribe(new ConcatMapMaybeMainObserver(observer, this.f16724c, this.f16726e, this.f16725d));
        }
    }
}
