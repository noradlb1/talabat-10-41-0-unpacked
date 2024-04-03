package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableWindowBoundary<T, B> extends AbstractObservableWithUpstream<T, Observable<T>> {

    /* renamed from: c  reason: collision with root package name */
    public final ObservableSource<B> f17907c;

    /* renamed from: d  reason: collision with root package name */
    public final int f17908d;

    public static final class WindowBoundaryInnerObserver<T, B> extends DisposableObserver<B> {

        /* renamed from: b  reason: collision with root package name */
        public final WindowBoundaryMainObserver<T, B> f17909b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f17910c;

        public WindowBoundaryInnerObserver(WindowBoundaryMainObserver<T, B> windowBoundaryMainObserver) {
            this.f17909b = windowBoundaryMainObserver;
        }

        public void onComplete() {
            if (!this.f17910c) {
                this.f17910c = true;
                this.f17909b.b();
            }
        }

        public void onError(Throwable th2) {
            if (this.f17910c) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f17910c = true;
            this.f17909b.c(th2);
        }

        public void onNext(B b11) {
            if (!this.f17910c) {
                this.f17909b.d();
            }
        }
    }

    public static final class WindowBoundaryMainObserver<T, B> extends AtomicInteger implements Observer<T>, Disposable, Runnable {

        /* renamed from: l  reason: collision with root package name */
        public static final Object f17911l = new Object();
        private static final long serialVersionUID = 2233020065421370272L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super Observable<T>> f17912b;

        /* renamed from: c  reason: collision with root package name */
        public final int f17913c;

        /* renamed from: d  reason: collision with root package name */
        public final WindowBoundaryInnerObserver<T, B> f17914d = new WindowBoundaryInnerObserver<>(this);

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReference<Disposable> f17915e = new AtomicReference<>();

        /* renamed from: f  reason: collision with root package name */
        public final AtomicInteger f17916f = new AtomicInteger(1);

        /* renamed from: g  reason: collision with root package name */
        public final MpscLinkedQueue<Object> f17917g = new MpscLinkedQueue<>();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicThrowable f17918h = new AtomicThrowable();

        /* renamed from: i  reason: collision with root package name */
        public final AtomicBoolean f17919i = new AtomicBoolean();

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f17920j;

        /* renamed from: k  reason: collision with root package name */
        public UnicastSubject<T> f17921k;

        public WindowBoundaryMainObserver(Observer<? super Observable<T>> observer, int i11) {
            this.f17912b = observer;
            this.f17913c = i11;
        }

        public void a() {
            boolean z11;
            if (getAndIncrement() == 0) {
                Observer<? super Observable<T>> observer = this.f17912b;
                MpscLinkedQueue<Object> mpscLinkedQueue = this.f17917g;
                AtomicThrowable atomicThrowable = this.f17918h;
                int i11 = 1;
                while (this.f17916f.get() != 0) {
                    UnicastSubject<T> unicastSubject = this.f17921k;
                    boolean z12 = this.f17920j;
                    if (!z12 || atomicThrowable.get() == null) {
                        Object poll = mpscLinkedQueue.poll();
                        if (poll == null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z12 && z11) {
                            Throwable terminate = atomicThrowable.terminate();
                            if (terminate == null) {
                                if (unicastSubject != null) {
                                    this.f17921k = null;
                                    unicastSubject.onComplete();
                                }
                                observer.onComplete();
                                return;
                            }
                            if (unicastSubject != null) {
                                this.f17921k = null;
                                unicastSubject.onError(terminate);
                            }
                            observer.onError(terminate);
                            return;
                        } else if (z11) {
                            i11 = addAndGet(-i11);
                            if (i11 == 0) {
                                return;
                            }
                        } else if (poll != f17911l) {
                            unicastSubject.onNext(poll);
                        } else {
                            if (unicastSubject != null) {
                                this.f17921k = null;
                                unicastSubject.onComplete();
                            }
                            if (!this.f17919i.get()) {
                                UnicastSubject<T> create = UnicastSubject.create(this.f17913c, this);
                                this.f17921k = create;
                                this.f17916f.getAndIncrement();
                                observer.onNext(create);
                            }
                        }
                    } else {
                        mpscLinkedQueue.clear();
                        Throwable terminate2 = atomicThrowable.terminate();
                        if (unicastSubject != null) {
                            this.f17921k = null;
                            unicastSubject.onError(terminate2);
                        }
                        observer.onError(terminate2);
                        return;
                    }
                }
                mpscLinkedQueue.clear();
                this.f17921k = null;
            }
        }

        public void b() {
            DisposableHelper.dispose(this.f17915e);
            this.f17920j = true;
            a();
        }

        public void c(Throwable th2) {
            DisposableHelper.dispose(this.f17915e);
            if (this.f17918h.addThrowable(th2)) {
                this.f17920j = true;
                a();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void d() {
            this.f17917g.offer(f17911l);
            a();
        }

        public void dispose() {
            if (this.f17919i.compareAndSet(false, true)) {
                this.f17914d.dispose();
                if (this.f17916f.decrementAndGet() == 0) {
                    DisposableHelper.dispose(this.f17915e);
                }
            }
        }

        public boolean isDisposed() {
            return this.f17919i.get();
        }

        public void onComplete() {
            this.f17914d.dispose();
            this.f17920j = true;
            a();
        }

        public void onError(Throwable th2) {
            this.f17914d.dispose();
            if (this.f17918h.addThrowable(th2)) {
                this.f17920j = true;
                a();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            this.f17917g.offer(t11);
            a();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this.f17915e, disposable)) {
                d();
            }
        }

        public void run() {
            if (this.f17916f.decrementAndGet() == 0) {
                DisposableHelper.dispose(this.f17915e);
            }
        }
    }

    public ObservableWindowBoundary(ObservableSource<T> observableSource, ObservableSource<B> observableSource2, int i11) {
        super(observableSource);
        this.f17907c = observableSource2;
        this.f17908d = i11;
    }

    public void subscribeActual(Observer<? super Observable<T>> observer) {
        WindowBoundaryMainObserver windowBoundaryMainObserver = new WindowBoundaryMainObserver(observer, this.f17908d);
        observer.onSubscribe(windowBoundaryMainObserver);
        this.f17907c.subscribe(windowBoundaryMainObserver.f17914d);
        this.f16799b.subscribe(windowBoundaryMainObserver);
    }
}
