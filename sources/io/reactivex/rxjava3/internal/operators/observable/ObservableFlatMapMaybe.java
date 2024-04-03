package io.reactivex.rxjava3.internal.operators.observable;

import i.b;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableFlatMapMaybe<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends MaybeSource<? extends R>> f21751c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f21752d;

    public static final class FlatMapMaybeObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 8600231336733376951L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f21753b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f21754c;

        /* renamed from: d  reason: collision with root package name */
        public final CompositeDisposable f21755d = new CompositeDisposable();

        /* renamed from: e  reason: collision with root package name */
        public final AtomicInteger f21756e = new AtomicInteger(1);

        /* renamed from: f  reason: collision with root package name */
        public final AtomicThrowable f21757f = new AtomicThrowable();

        /* renamed from: g  reason: collision with root package name */
        public final Function<? super T, ? extends MaybeSource<? extends R>> f21758g;

        /* renamed from: h  reason: collision with root package name */
        public final AtomicReference<SpscLinkedArrayQueue<R>> f21759h = new AtomicReference<>();

        /* renamed from: i  reason: collision with root package name */
        public Disposable f21760i;

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f21761j;

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
            this.f21753b = observer;
            this.f21758g = function;
            this.f21754c = z11;
        }

        public void a() {
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f21759h.get();
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
            Observer<? super R> observer = this.f21753b;
            AtomicInteger atomicInteger = this.f21756e;
            AtomicReference<SpscLinkedArrayQueue<R>> atomicReference = this.f21759h;
            int i11 = 1;
            while (!this.f21761j) {
                if (this.f21754c || ((Throwable) this.f21757f.get()) == null) {
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
                        this.f21757f.tryTerminateConsumer((Observer<?>) observer);
                        return;
                    } else if (z12) {
                        i11 = addAndGet(-i11);
                        if (i11 == 0) {
                            return;
                        }
                    } else {
                        observer.onNext(obj);
                    }
                } else {
                    a();
                    this.f21757f.tryTerminateConsumer((Observer<?>) observer);
                    return;
                }
            }
            a();
        }

        public SpscLinkedArrayQueue<R> d() {
            SpscLinkedArrayQueue<R> spscLinkedArrayQueue = this.f21759h.get();
            if (spscLinkedArrayQueue != null) {
                return spscLinkedArrayQueue;
            }
            SpscLinkedArrayQueue<R> spscLinkedArrayQueue2 = new SpscLinkedArrayQueue<>(Observable.bufferSize());
            if (b.a(this.f21759h, (Object) null, spscLinkedArrayQueue2)) {
                return spscLinkedArrayQueue2;
            }
            return this.f21759h.get();
        }

        public void dispose() {
            this.f21761j = true;
            this.f21760i.dispose();
            this.f21755d.dispose();
            this.f21757f.tryTerminateAndReport();
        }

        public void e(FlatMapMaybeObserver<T, R>.InnerObserver innerObserver) {
            this.f21755d.delete(innerObserver);
            if (get() == 0) {
                boolean z11 = false;
                if (compareAndSet(0, 1)) {
                    if (this.f21756e.decrementAndGet() == 0) {
                        z11 = true;
                    }
                    SpscLinkedArrayQueue spscLinkedArrayQueue = this.f21759h.get();
                    if (z11 && (spscLinkedArrayQueue == null || spscLinkedArrayQueue.isEmpty())) {
                        this.f21757f.tryTerminateConsumer((Observer<?>) this.f21753b);
                        return;
                    } else if (decrementAndGet() != 0) {
                        c();
                        return;
                    } else {
                        return;
                    }
                }
            }
            this.f21756e.decrementAndGet();
            b();
        }

        public void f(FlatMapMaybeObserver<T, R>.InnerObserver innerObserver, Throwable th2) {
            this.f21755d.delete(innerObserver);
            if (this.f21757f.tryAddThrowableOrReport(th2)) {
                if (!this.f21754c) {
                    this.f21760i.dispose();
                    this.f21755d.dispose();
                }
                this.f21756e.decrementAndGet();
                b();
            }
        }

        public void g(FlatMapMaybeObserver<T, R>.InnerObserver innerObserver, R r11) {
            this.f21755d.delete(innerObserver);
            if (get() == 0) {
                boolean z11 = false;
                if (compareAndSet(0, 1)) {
                    this.f21753b.onNext(r11);
                    if (this.f21756e.decrementAndGet() == 0) {
                        z11 = true;
                    }
                    SpscLinkedArrayQueue spscLinkedArrayQueue = this.f21759h.get();
                    if (!z11 || (spscLinkedArrayQueue != null && !spscLinkedArrayQueue.isEmpty())) {
                        if (decrementAndGet() == 0) {
                            return;
                        }
                        c();
                    }
                    this.f21757f.tryTerminateConsumer((Observer<?>) this.f21753b);
                    return;
                }
            }
            SpscLinkedArrayQueue d11 = d();
            synchronized (d11) {
                d11.offer(r11);
            }
            this.f21756e.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            c();
        }

        public boolean isDisposed() {
            return this.f21761j;
        }

        public void onComplete() {
            this.f21756e.decrementAndGet();
            b();
        }

        public void onError(Throwable th2) {
            this.f21756e.decrementAndGet();
            if (this.f21757f.tryAddThrowableOrReport(th2)) {
                if (!this.f21754c) {
                    this.f21755d.dispose();
                }
                b();
            }
        }

        public void onNext(T t11) {
            try {
                Object apply = this.f21758g.apply(t11);
                Objects.requireNonNull(apply, "The mapper returned a null MaybeSource");
                MaybeSource maybeSource = (MaybeSource) apply;
                this.f21756e.getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.f21761j && this.f21755d.add(innerObserver)) {
                    maybeSource.subscribe(innerObserver);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f21760i.dispose();
                onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21760i, disposable)) {
                this.f21760i = disposable;
                this.f21753b.onSubscribe(this);
            }
        }
    }

    public ObservableFlatMapMaybe(ObservableSource<T> observableSource, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z11) {
        super(observableSource);
        this.f21751c = function;
        this.f21752d = z11;
    }

    public void subscribeActual(Observer<? super R> observer) {
        this.f21304b.subscribe(new FlatMapMaybeObserver(observer, this.f21751c, this.f21752d));
    }
}
