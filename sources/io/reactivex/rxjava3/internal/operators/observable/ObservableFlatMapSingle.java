package io.reactivex.rxjava3.internal.operators.observable;

import i.b;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
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

public final class ObservableFlatMapSingle<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends SingleSource<? extends R>> f21763c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f21764d;

    public static final class FlatMapSingleObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 8600231336733376951L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f21765b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f21766c;

        /* renamed from: d  reason: collision with root package name */
        public final CompositeDisposable f21767d = new CompositeDisposable();

        /* renamed from: e  reason: collision with root package name */
        public final AtomicInteger f21768e = new AtomicInteger(1);

        /* renamed from: f  reason: collision with root package name */
        public final AtomicThrowable f21769f = new AtomicThrowable();

        /* renamed from: g  reason: collision with root package name */
        public final Function<? super T, ? extends SingleSource<? extends R>> f21770g;

        /* renamed from: h  reason: collision with root package name */
        public final AtomicReference<SpscLinkedArrayQueue<R>> f21771h = new AtomicReference<>();

        /* renamed from: i  reason: collision with root package name */
        public Disposable f21772i;

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f21773j;

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
            this.f21765b = observer;
            this.f21770g = function;
            this.f21766c = z11;
        }

        public void a() {
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f21771h.get();
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
            Observer<? super R> observer = this.f21765b;
            AtomicInteger atomicInteger = this.f21768e;
            AtomicReference<SpscLinkedArrayQueue<R>> atomicReference = this.f21771h;
            int i11 = 1;
            while (!this.f21773j) {
                if (this.f21766c || ((Throwable) this.f21769f.get()) == null) {
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
                        this.f21769f.tryTerminateConsumer((Observer<?>) this.f21765b);
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
                    this.f21769f.tryTerminateConsumer((Observer<?>) observer);
                    return;
                }
            }
            a();
        }

        public SpscLinkedArrayQueue<R> d() {
            SpscLinkedArrayQueue<R> spscLinkedArrayQueue = this.f21771h.get();
            if (spscLinkedArrayQueue != null) {
                return spscLinkedArrayQueue;
            }
            SpscLinkedArrayQueue<R> spscLinkedArrayQueue2 = new SpscLinkedArrayQueue<>(Observable.bufferSize());
            if (b.a(this.f21771h, (Object) null, spscLinkedArrayQueue2)) {
                return spscLinkedArrayQueue2;
            }
            return this.f21771h.get();
        }

        public void dispose() {
            this.f21773j = true;
            this.f21772i.dispose();
            this.f21767d.dispose();
            this.f21769f.tryTerminateAndReport();
        }

        public void e(FlatMapSingleObserver<T, R>.InnerObserver innerObserver, Throwable th2) {
            this.f21767d.delete(innerObserver);
            if (this.f21769f.tryAddThrowableOrReport(th2)) {
                if (!this.f21766c) {
                    this.f21772i.dispose();
                    this.f21767d.dispose();
                }
                this.f21768e.decrementAndGet();
                b();
            }
        }

        public void f(FlatMapSingleObserver<T, R>.InnerObserver innerObserver, R r11) {
            this.f21767d.delete(innerObserver);
            if (get() == 0) {
                boolean z11 = false;
                if (compareAndSet(0, 1)) {
                    this.f21765b.onNext(r11);
                    if (this.f21768e.decrementAndGet() == 0) {
                        z11 = true;
                    }
                    SpscLinkedArrayQueue spscLinkedArrayQueue = this.f21771h.get();
                    if (!z11 || (spscLinkedArrayQueue != null && !spscLinkedArrayQueue.isEmpty())) {
                        if (decrementAndGet() == 0) {
                            return;
                        }
                        c();
                    }
                    this.f21769f.tryTerminateConsumer((Observer<?>) this.f21765b);
                    return;
                }
            }
            SpscLinkedArrayQueue d11 = d();
            synchronized (d11) {
                d11.offer(r11);
            }
            this.f21768e.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            c();
        }

        public boolean isDisposed() {
            return this.f21773j;
        }

        public void onComplete() {
            this.f21768e.decrementAndGet();
            b();
        }

        public void onError(Throwable th2) {
            this.f21768e.decrementAndGet();
            if (this.f21769f.tryAddThrowableOrReport(th2)) {
                if (!this.f21766c) {
                    this.f21767d.dispose();
                }
                b();
            }
        }

        public void onNext(T t11) {
            try {
                Object apply = this.f21770g.apply(t11);
                Objects.requireNonNull(apply, "The mapper returned a null SingleSource");
                SingleSource singleSource = (SingleSource) apply;
                this.f21768e.getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.f21773j && this.f21767d.add(innerObserver)) {
                    singleSource.subscribe(innerObserver);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f21772i.dispose();
                onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21772i, disposable)) {
                this.f21772i = disposable;
                this.f21765b.onSubscribe(this);
            }
        }
    }

    public ObservableFlatMapSingle(ObservableSource<T> observableSource, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z11) {
        super(observableSource);
        this.f21763c = function;
        this.f21764d = z11;
    }

    public void subscribeActual(Observer<? super R> observer) {
        this.f21304b.subscribe(new FlatMapSingleObserver(observer, this.f21763c, this.f21764d));
    }
}
