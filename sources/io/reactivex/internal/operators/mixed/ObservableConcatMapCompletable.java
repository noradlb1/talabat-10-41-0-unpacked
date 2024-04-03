package io.reactivex.internal.operators.mixed;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatMapCompletable<T> extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final Observable<T> f16707b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends CompletableSource> f16708c;

    /* renamed from: d  reason: collision with root package name */
    public final ErrorMode f16709d;

    /* renamed from: e  reason: collision with root package name */
    public final int f16710e;

    public static final class ConcatMapCompletableObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 3610901111000061034L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f16711b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends CompletableSource> f16712c;

        /* renamed from: d  reason: collision with root package name */
        public final ErrorMode f16713d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicThrowable f16714e = new AtomicThrowable();

        /* renamed from: f  reason: collision with root package name */
        public final ConcatMapInnerObserver f16715f = new ConcatMapInnerObserver(this);

        /* renamed from: g  reason: collision with root package name */
        public final int f16716g;

        /* renamed from: h  reason: collision with root package name */
        public SimpleQueue<T> f16717h;

        /* renamed from: i  reason: collision with root package name */
        public Disposable f16718i;

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f16719j;

        /* renamed from: k  reason: collision with root package name */
        public volatile boolean f16720k;

        /* renamed from: l  reason: collision with root package name */
        public volatile boolean f16721l;

        public static final class ConcatMapInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = 5638352172918776687L;

            /* renamed from: b  reason: collision with root package name */
            public final ConcatMapCompletableObserver<?> f16722b;

            public ConcatMapInnerObserver(ConcatMapCompletableObserver<?> concatMapCompletableObserver) {
                this.f16722b = concatMapCompletableObserver;
            }

            public void a() {
                DisposableHelper.dispose(this);
            }

            public void onComplete() {
                this.f16722b.b();
            }

            public void onError(Throwable th2) {
                this.f16722b.c(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }
        }

        public ConcatMapCompletableObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, ErrorMode errorMode, int i11) {
            this.f16711b = completableObserver;
            this.f16712c = function;
            this.f16713d = errorMode;
            this.f16716g = i11;
        }

        public void a() {
            boolean z11;
            CompletableSource completableSource;
            if (getAndIncrement() == 0) {
                AtomicThrowable atomicThrowable = this.f16714e;
                ErrorMode errorMode = this.f16713d;
                while (!this.f16721l) {
                    if (!this.f16719j) {
                        if (errorMode != ErrorMode.BOUNDARY || atomicThrowable.get() == null) {
                            boolean z12 = this.f16720k;
                            try {
                                T poll = this.f16717h.poll();
                                if (poll != null) {
                                    completableSource = (CompletableSource) ObjectHelper.requireNonNull(this.f16712c.apply(poll), "The mapper returned a null CompletableSource");
                                    z11 = false;
                                } else {
                                    completableSource = null;
                                    z11 = true;
                                }
                                if (z12 && z11) {
                                    this.f16721l = true;
                                    Throwable terminate = atomicThrowable.terminate();
                                    if (terminate != null) {
                                        this.f16711b.onError(terminate);
                                        return;
                                    } else {
                                        this.f16711b.onComplete();
                                        return;
                                    }
                                } else if (!z11) {
                                    this.f16719j = true;
                                    completableSource.subscribe(this.f16715f);
                                }
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                this.f16721l = true;
                                this.f16717h.clear();
                                this.f16718i.dispose();
                                atomicThrowable.addThrowable(th2);
                                this.f16711b.onError(atomicThrowable.terminate());
                                return;
                            }
                        } else {
                            this.f16721l = true;
                            this.f16717h.clear();
                            this.f16711b.onError(atomicThrowable.terminate());
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                this.f16717h.clear();
            }
        }

        public void b() {
            this.f16719j = false;
            a();
        }

        public void c(Throwable th2) {
            if (!this.f16714e.addThrowable(th2)) {
                RxJavaPlugins.onError(th2);
            } else if (this.f16713d == ErrorMode.IMMEDIATE) {
                this.f16721l = true;
                this.f16718i.dispose();
                Throwable terminate = this.f16714e.terminate();
                if (terminate != ExceptionHelper.TERMINATED) {
                    this.f16711b.onError(terminate);
                }
                if (getAndIncrement() == 0) {
                    this.f16717h.clear();
                }
            } else {
                this.f16719j = false;
                a();
            }
        }

        public void dispose() {
            this.f16721l = true;
            this.f16718i.dispose();
            this.f16715f.a();
            if (getAndIncrement() == 0) {
                this.f16717h.clear();
            }
        }

        public boolean isDisposed() {
            return this.f16721l;
        }

        public void onComplete() {
            this.f16720k = true;
            a();
        }

        public void onError(Throwable th2) {
            if (!this.f16714e.addThrowable(th2)) {
                RxJavaPlugins.onError(th2);
            } else if (this.f16713d == ErrorMode.IMMEDIATE) {
                this.f16721l = true;
                this.f16715f.a();
                Throwable terminate = this.f16714e.terminate();
                if (terminate != ExceptionHelper.TERMINATED) {
                    this.f16711b.onError(terminate);
                }
                if (getAndIncrement() == 0) {
                    this.f16717h.clear();
                }
            } else {
                this.f16720k = true;
                a();
            }
        }

        public void onNext(T t11) {
            if (t11 != null) {
                this.f16717h.offer(t11);
            }
            a();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16718i, disposable)) {
                this.f16718i = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(3);
                    if (requestFusion == 1) {
                        this.f16717h = queueDisposable;
                        this.f16720k = true;
                        this.f16711b.onSubscribe(this);
                        a();
                        return;
                    } else if (requestFusion == 2) {
                        this.f16717h = queueDisposable;
                        this.f16711b.onSubscribe(this);
                        return;
                    }
                }
                this.f16717h = new SpscLinkedArrayQueue(this.f16716g);
                this.f16711b.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMapCompletable(Observable<T> observable, Function<? super T, ? extends CompletableSource> function, ErrorMode errorMode, int i11) {
        this.f16707b = observable;
        this.f16708c = function;
        this.f16709d = errorMode;
        this.f16710e = i11;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        if (!ScalarXMapZHelper.a(this.f16707b, this.f16708c, completableObserver)) {
            this.f16707b.subscribe(new ConcatMapCompletableObserver(completableObserver, this.f16708c, this.f16709d, this.f16710e));
        }
    }
}
