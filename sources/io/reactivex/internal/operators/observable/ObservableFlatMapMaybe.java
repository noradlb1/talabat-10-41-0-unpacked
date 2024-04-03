package io.reactivex.internal.operators.observable;

import i.b;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableFlatMapMaybe<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends MaybeSource<? extends R>> f17224c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f17225d;

    public static final class FlatMapMaybeObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 8600231336733376951L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f17226b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f17227c;

        /* renamed from: d  reason: collision with root package name */
        public final CompositeDisposable f17228d = new CompositeDisposable();

        /* renamed from: e  reason: collision with root package name */
        public final AtomicInteger f17229e = new AtomicInteger(1);

        /* renamed from: f  reason: collision with root package name */
        public final AtomicThrowable f17230f = new AtomicThrowable();

        /* renamed from: g  reason: collision with root package name */
        public final Function<? super T, ? extends MaybeSource<? extends R>> f17231g;

        /* renamed from: h  reason: collision with root package name */
        public final AtomicReference<SpscLinkedArrayQueue<R>> f17232h = new AtomicReference<>();

        /* renamed from: i  reason: collision with root package name */
        public Disposable f17233i;

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f17234j;

        public final class InnerObserver extends AtomicReference<Disposable> implements MaybeObserver<R>, Disposable {
            private static final long serialVersionUID = -502562646270949838L;

            public InnerObserver() {
            }

            public void dispose() {
                DisposableHelper.dispose(this);
            }

            public boolean isDisposed() {
                return DisposableHelper.isDisposed((Disposable) get());
            }

            public void onComplete() {
                FlatMapMaybeObserver.this.e(this);
            }

            public void onError(Throwable th2) {
                FlatMapMaybeObserver.this.f(this, th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public void onSuccess(R r11) {
                FlatMapMaybeObserver.this.g(this, r11);
            }
        }

        public FlatMapMaybeObserver(Observer<? super R> observer, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z11) {
            this.f17226b = observer;
            this.f17231g = function;
            this.f17227c = z11;
        }

        public void a() {
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f17232h.get();
            if (spscLinkedArrayQueue != null) {
                spscLinkedArrayQueue.clear();
            }
        }

        public void b() {
            if (getAndIncrement() == 0) {
                c();
            }
        }

        public void c() {
            boolean z11;
            Object obj;
            Observer<? super R> observer = this.f17226b;
            AtomicInteger atomicInteger = this.f17229e;
            AtomicReference<SpscLinkedArrayQueue<R>> atomicReference = this.f17232h;
            int i11 = 1;
            while (!this.f17234j) {
                if (this.f17227c || ((Throwable) this.f17230f.get()) == null) {
                    boolean z12 = false;
                    if (atomicInteger.get() == 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    SpscLinkedArrayQueue spscLinkedArrayQueue = atomicReference.get();
                    if (spscLinkedArrayQueue != null) {
                        obj = spscLinkedArrayQueue.poll();
                    } else {
                        obj = null;
                    }
                    if (obj == null) {
                        z12 = true;
                    }
                    if (z11 && z12) {
                        Throwable terminate = this.f17230f.terminate();
                        if (terminate != null) {
                            observer.onError(terminate);
                            return;
                        } else {
                            observer.onComplete();
                            return;
                        }
                    } else if (z12) {
                        i11 = addAndGet(-i11);
                        if (i11 == 0) {
                            return;
                        }
                    } else {
                        observer.onNext(obj);
                    }
                } else {
                    Throwable terminate2 = this.f17230f.terminate();
                    a();
                    observer.onError(terminate2);
                    return;
                }
            }
            a();
        }

        public SpscLinkedArrayQueue<R> d() {
            SpscLinkedArrayQueue<R> spscLinkedArrayQueue;
            do {
                SpscLinkedArrayQueue<R> spscLinkedArrayQueue2 = this.f17232h.get();
                if (spscLinkedArrayQueue2 != null) {
                    return spscLinkedArrayQueue2;
                }
                spscLinkedArrayQueue = new SpscLinkedArrayQueue<>(Observable.bufferSize());
            } while (!b.a(this.f17232h, (Object) null, spscLinkedArrayQueue));
            return spscLinkedArrayQueue;
        }

        public void dispose() {
            this.f17234j = true;
            this.f17233i.dispose();
            this.f17228d.dispose();
        }

        public void e(FlatMapMaybeObserver<T, R>.InnerObserver innerObserver) {
            this.f17228d.delete(innerObserver);
            if (get() == 0) {
                boolean z11 = false;
                if (compareAndSet(0, 1)) {
                    if (this.f17229e.decrementAndGet() == 0) {
                        z11 = true;
                    }
                    SpscLinkedArrayQueue spscLinkedArrayQueue = this.f17232h.get();
                    if (z11 && (spscLinkedArrayQueue == null || spscLinkedArrayQueue.isEmpty())) {
                        Throwable terminate = this.f17230f.terminate();
                        if (terminate != null) {
                            this.f17226b.onError(terminate);
                            return;
                        } else {
                            this.f17226b.onComplete();
                            return;
                        }
                    } else if (decrementAndGet() != 0) {
                        c();
                        return;
                    } else {
                        return;
                    }
                }
            }
            this.f17229e.decrementAndGet();
            b();
        }

        public void f(FlatMapMaybeObserver<T, R>.InnerObserver innerObserver, Throwable th2) {
            this.f17228d.delete(innerObserver);
            if (this.f17230f.addThrowable(th2)) {
                if (!this.f17227c) {
                    this.f17233i.dispose();
                    this.f17228d.dispose();
                }
                this.f17229e.decrementAndGet();
                b();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void g(FlatMapMaybeObserver<T, R>.InnerObserver innerObserver, R r11) {
            this.f17228d.delete(innerObserver);
            if (get() == 0) {
                boolean z11 = false;
                if (compareAndSet(0, 1)) {
                    this.f17226b.onNext(r11);
                    if (this.f17229e.decrementAndGet() == 0) {
                        z11 = true;
                    }
                    SpscLinkedArrayQueue spscLinkedArrayQueue = this.f17232h.get();
                    if (!z11 || (spscLinkedArrayQueue != null && !spscLinkedArrayQueue.isEmpty())) {
                        if (decrementAndGet() == 0) {
                            return;
                        }
                        c();
                    }
                    Throwable terminate = this.f17230f.terminate();
                    if (terminate != null) {
                        this.f17226b.onError(terminate);
                        return;
                    } else {
                        this.f17226b.onComplete();
                        return;
                    }
                }
            }
            SpscLinkedArrayQueue d11 = d();
            synchronized (d11) {
                d11.offer(r11);
            }
            this.f17229e.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            c();
        }

        public boolean isDisposed() {
            return this.f17234j;
        }

        public void onComplete() {
            this.f17229e.decrementAndGet();
            b();
        }

        public void onError(Throwable th2) {
            this.f17229e.decrementAndGet();
            if (this.f17230f.addThrowable(th2)) {
                if (!this.f17227c) {
                    this.f17228d.dispose();
                }
                b();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            try {
                MaybeSource maybeSource = (MaybeSource) ObjectHelper.requireNonNull(this.f17231g.apply(t11), "The mapper returned a null MaybeSource");
                this.f17229e.getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.f17234j && this.f17228d.add(innerObserver)) {
                    maybeSource.subscribe(innerObserver);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f17233i.dispose();
                onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17233i, disposable)) {
                this.f17233i = disposable;
                this.f17226b.onSubscribe(this);
            }
        }
    }

    public ObservableFlatMapMaybe(ObservableSource<T> observableSource, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z11) {
        super(observableSource);
        this.f17224c = function;
        this.f17225d = z11;
    }

    public void subscribeActual(Observer<? super R> observer) {
        this.f16799b.subscribe(new FlatMapMaybeObserver(observer, this.f17224c, this.f17225d));
    }
}
