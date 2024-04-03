package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableWindowBoundary<T, B> extends AbstractObservableWithUpstream<T, Observable<T>> {

    /* renamed from: c  reason: collision with root package name */
    public final ObservableSource<B> f22448c;

    /* renamed from: d  reason: collision with root package name */
    public final int f22449d;

    public static final class WindowBoundaryInnerObserver<T, B> extends DisposableObserver<B> {

        /* renamed from: c  reason: collision with root package name */
        public final WindowBoundaryMainObserver<T, B> f22450c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f22451d;

        public WindowBoundaryInnerObserver(WindowBoundaryMainObserver<T, B> windowBoundaryMainObserver) {
            this.f22450c = windowBoundaryMainObserver;
        }

        public void onComplete() {
            if (!this.f22451d) {
                this.f22451d = true;
                this.f22450c.b();
            }
        }

        public void onError(Throwable th2) {
            if (this.f22451d) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f22451d = true;
            this.f22450c.c(th2);
        }

        public void onNext(B b11) {
            if (!this.f22451d) {
                this.f22450c.d();
            }
        }
    }

    public static final class WindowBoundaryMainObserver<T, B> extends AtomicInteger implements Observer<T>, Disposable, Runnable {

        /* renamed from: l  reason: collision with root package name */
        public static final Object f22452l = new Object();
        private static final long serialVersionUID = 2233020065421370272L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super Observable<T>> f22453b;

        /* renamed from: c  reason: collision with root package name */
        public final int f22454c;

        /* renamed from: d  reason: collision with root package name */
        public final WindowBoundaryInnerObserver<T, B> f22455d = new WindowBoundaryInnerObserver<>(this);

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReference<Disposable> f22456e = new AtomicReference<>();

        /* renamed from: f  reason: collision with root package name */
        public final AtomicInteger f22457f = new AtomicInteger(1);

        /* renamed from: g  reason: collision with root package name */
        public final MpscLinkedQueue<Object> f22458g = new MpscLinkedQueue<>();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicThrowable f22459h = new AtomicThrowable();

        /* renamed from: i  reason: collision with root package name */
        public final AtomicBoolean f22460i = new AtomicBoolean();

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f22461j;

        /* renamed from: k  reason: collision with root package name */
        public UnicastSubject<T> f22462k;

        public WindowBoundaryMainObserver(Observer<? super Observable<T>> observer, int i11) {
            this.f22453b = observer;
            this.f22454c = i11;
        }

        public void a() {
            boolean z11;
            if (getAndIncrement() == 0) {
                Observer<? super Observable<T>> observer = this.f22453b;
                MpscLinkedQueue<Object> mpscLinkedQueue = this.f22458g;
                AtomicThrowable atomicThrowable = this.f22459h;
                int i11 = 1;
                while (this.f22457f.get() != 0) {
                    UnicastSubject<T> unicastSubject = this.f22462k;
                    boolean z12 = this.f22461j;
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
                                    this.f22462k = null;
                                    unicastSubject.onComplete();
                                }
                                observer.onComplete();
                                return;
                            }
                            if (unicastSubject != null) {
                                this.f22462k = null;
                                unicastSubject.onError(terminate);
                            }
                            observer.onError(terminate);
                            return;
                        } else if (z11) {
                            i11 = addAndGet(-i11);
                            if (i11 == 0) {
                                return;
                            }
                        } else if (poll != f22452l) {
                            unicastSubject.onNext(poll);
                        } else {
                            if (unicastSubject != null) {
                                this.f22462k = null;
                                unicastSubject.onComplete();
                            }
                            if (!this.f22460i.get()) {
                                UnicastSubject<T> create = UnicastSubject.create(this.f22454c, this);
                                this.f22462k = create;
                                this.f22457f.getAndIncrement();
                                ObservableWindowSubscribeIntercept observableWindowSubscribeIntercept = new ObservableWindowSubscribeIntercept(create);
                                observer.onNext(observableWindowSubscribeIntercept);
                                if (observableWindowSubscribeIntercept.a()) {
                                    create.onComplete();
                                }
                            }
                        }
                    } else {
                        mpscLinkedQueue.clear();
                        Throwable terminate2 = atomicThrowable.terminate();
                        if (unicastSubject != null) {
                            this.f22462k = null;
                            unicastSubject.onError(terminate2);
                        }
                        observer.onError(terminate2);
                        return;
                    }
                }
                mpscLinkedQueue.clear();
                this.f22462k = null;
            }
        }

        public void b() {
            DisposableHelper.dispose(this.f22456e);
            this.f22461j = true;
            a();
        }

        public void c(Throwable th2) {
            DisposableHelper.dispose(this.f22456e);
            if (this.f22459h.tryAddThrowableOrReport(th2)) {
                this.f22461j = true;
                a();
            }
        }

        public void d() {
            this.f22458g.offer(f22452l);
            a();
        }

        public void dispose() {
            if (this.f22460i.compareAndSet(false, true)) {
                this.f22455d.dispose();
                if (this.f22457f.decrementAndGet() == 0) {
                    DisposableHelper.dispose(this.f22456e);
                }
            }
        }

        public boolean isDisposed() {
            return this.f22460i.get();
        }

        public void onComplete() {
            this.f22455d.dispose();
            this.f22461j = true;
            a();
        }

        public void onError(Throwable th2) {
            this.f22455d.dispose();
            if (this.f22459h.tryAddThrowableOrReport(th2)) {
                this.f22461j = true;
                a();
            }
        }

        public void onNext(T t11) {
            this.f22458g.offer(t11);
            a();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this.f22456e, disposable)) {
                d();
            }
        }

        public void run() {
            if (this.f22457f.decrementAndGet() == 0) {
                DisposableHelper.dispose(this.f22456e);
            }
        }
    }

    public ObservableWindowBoundary(ObservableSource<T> observableSource, ObservableSource<B> observableSource2, int i11) {
        super(observableSource);
        this.f22448c = observableSource2;
        this.f22449d = i11;
    }

    public void subscribeActual(Observer<? super Observable<T>> observer) {
        WindowBoundaryMainObserver windowBoundaryMainObserver = new WindowBoundaryMainObserver(observer, this.f22449d);
        observer.onSubscribe(windowBoundaryMainObserver);
        this.f22448c.subscribe(windowBoundaryMainObserver.f22455d);
        this.f21304b.subscribe(windowBoundaryMainObserver);
    }
}
