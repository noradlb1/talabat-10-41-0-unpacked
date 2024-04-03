package io.reactivex.internal.operators.observable;

import i.b;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
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

public final class ObservableFlatMapSingle<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends SingleSource<? extends R>> f17236c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f17237d;

    public static final class FlatMapSingleObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 8600231336733376951L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f17238b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f17239c;

        /* renamed from: d  reason: collision with root package name */
        public final CompositeDisposable f17240d = new CompositeDisposable();

        /* renamed from: e  reason: collision with root package name */
        public final AtomicInteger f17241e = new AtomicInteger(1);

        /* renamed from: f  reason: collision with root package name */
        public final AtomicThrowable f17242f = new AtomicThrowable();

        /* renamed from: g  reason: collision with root package name */
        public final Function<? super T, ? extends SingleSource<? extends R>> f17243g;

        /* renamed from: h  reason: collision with root package name */
        public final AtomicReference<SpscLinkedArrayQueue<R>> f17244h = new AtomicReference<>();

        /* renamed from: i  reason: collision with root package name */
        public Disposable f17245i;

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f17246j;

        public final class InnerObserver extends AtomicReference<Disposable> implements SingleObserver<R>, Disposable {
            private static final long serialVersionUID = -502562646270949838L;

            public InnerObserver() {
            }

            public void dispose() {
                DisposableHelper.dispose(this);
            }

            public boolean isDisposed() {
                return DisposableHelper.isDisposed((Disposable) get());
            }

            public void onError(Throwable th2) {
                FlatMapSingleObserver.this.e(this, th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public void onSuccess(R r11) {
                FlatMapSingleObserver.this.f(this, r11);
            }
        }

        public FlatMapSingleObserver(Observer<? super R> observer, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z11) {
            this.f17238b = observer;
            this.f17243g = function;
            this.f17239c = z11;
        }

        public void a() {
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f17244h.get();
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
            Observer<? super R> observer = this.f17238b;
            AtomicInteger atomicInteger = this.f17241e;
            AtomicReference<SpscLinkedArrayQueue<R>> atomicReference = this.f17244h;
            int i11 = 1;
            while (!this.f17246j) {
                if (this.f17239c || ((Throwable) this.f17242f.get()) == null) {
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
                        Throwable terminate = this.f17242f.terminate();
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
                    Throwable terminate2 = this.f17242f.terminate();
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
                SpscLinkedArrayQueue<R> spscLinkedArrayQueue2 = this.f17244h.get();
                if (spscLinkedArrayQueue2 != null) {
                    return spscLinkedArrayQueue2;
                }
                spscLinkedArrayQueue = new SpscLinkedArrayQueue<>(Observable.bufferSize());
            } while (!b.a(this.f17244h, (Object) null, spscLinkedArrayQueue));
            return spscLinkedArrayQueue;
        }

        public void dispose() {
            this.f17246j = true;
            this.f17245i.dispose();
            this.f17240d.dispose();
        }

        public void e(FlatMapSingleObserver<T, R>.InnerObserver innerObserver, Throwable th2) {
            this.f17240d.delete(innerObserver);
            if (this.f17242f.addThrowable(th2)) {
                if (!this.f17239c) {
                    this.f17245i.dispose();
                    this.f17240d.dispose();
                }
                this.f17241e.decrementAndGet();
                b();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void f(FlatMapSingleObserver<T, R>.InnerObserver innerObserver, R r11) {
            this.f17240d.delete(innerObserver);
            if (get() == 0) {
                boolean z11 = false;
                if (compareAndSet(0, 1)) {
                    this.f17238b.onNext(r11);
                    if (this.f17241e.decrementAndGet() == 0) {
                        z11 = true;
                    }
                    SpscLinkedArrayQueue spscLinkedArrayQueue = this.f17244h.get();
                    if (!z11 || (spscLinkedArrayQueue != null && !spscLinkedArrayQueue.isEmpty())) {
                        if (decrementAndGet() == 0) {
                            return;
                        }
                        c();
                    }
                    Throwable terminate = this.f17242f.terminate();
                    if (terminate != null) {
                        this.f17238b.onError(terminate);
                        return;
                    } else {
                        this.f17238b.onComplete();
                        return;
                    }
                }
            }
            SpscLinkedArrayQueue d11 = d();
            synchronized (d11) {
                d11.offer(r11);
            }
            this.f17241e.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            c();
        }

        public boolean isDisposed() {
            return this.f17246j;
        }

        public void onComplete() {
            this.f17241e.decrementAndGet();
            b();
        }

        public void onError(Throwable th2) {
            this.f17241e.decrementAndGet();
            if (this.f17242f.addThrowable(th2)) {
                if (!this.f17239c) {
                    this.f17240d.dispose();
                }
                b();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            try {
                SingleSource singleSource = (SingleSource) ObjectHelper.requireNonNull(this.f17243g.apply(t11), "The mapper returned a null SingleSource");
                this.f17241e.getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.f17246j && this.f17240d.add(innerObserver)) {
                    singleSource.subscribe(innerObserver);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f17245i.dispose();
                onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17245i, disposable)) {
                this.f17245i = disposable;
                this.f17238b.onSubscribe(this);
            }
        }
    }

    public ObservableFlatMapSingle(ObservableSource<T> observableSource, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z11) {
        super(observableSource);
        this.f17236c = function;
        this.f17237d = z11;
    }

    public void subscribeActual(Observer<? super R> observer) {
        this.f16799b.subscribe(new FlatMapSingleObserver(observer, this.f17236c, this.f17237d));
    }
}
