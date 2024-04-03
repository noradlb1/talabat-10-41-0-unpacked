package io.reactivex.internal.operators.observable;

import i.b;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableWindowBoundarySupplier<T, B> extends AbstractObservableWithUpstream<T, Observable<T>> {

    /* renamed from: c  reason: collision with root package name */
    public final Callable<? extends ObservableSource<B>> f17940c;

    /* renamed from: d  reason: collision with root package name */
    public final int f17941d;

    public static final class WindowBoundaryInnerObserver<T, B> extends DisposableObserver<B> {

        /* renamed from: b  reason: collision with root package name */
        public final WindowBoundaryMainObserver<T, B> f17942b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f17943c;

        public WindowBoundaryInnerObserver(WindowBoundaryMainObserver<T, B> windowBoundaryMainObserver) {
            this.f17942b = windowBoundaryMainObserver;
        }

        public void onComplete() {
            if (!this.f17943c) {
                this.f17943c = true;
                this.f17942b.c();
            }
        }

        public void onError(Throwable th2) {
            if (this.f17943c) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f17943c = true;
            this.f17942b.d(th2);
        }

        public void onNext(B b11) {
            if (!this.f17943c) {
                this.f17943c = true;
                dispose();
                this.f17942b.e(this);
            }
        }
    }

    public static final class WindowBoundaryMainObserver<T, B> extends AtomicInteger implements Observer<T>, Disposable, Runnable {

        /* renamed from: m  reason: collision with root package name */
        public static final WindowBoundaryInnerObserver<Object, Object> f17944m = new WindowBoundaryInnerObserver<>((WindowBoundaryMainObserver) null);

        /* renamed from: n  reason: collision with root package name */
        public static final Object f17945n = new Object();
        private static final long serialVersionUID = 2233020065421370272L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super Observable<T>> f17946b;

        /* renamed from: c  reason: collision with root package name */
        public final int f17947c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReference<WindowBoundaryInnerObserver<T, B>> f17948d = new AtomicReference<>();

        /* renamed from: e  reason: collision with root package name */
        public final AtomicInteger f17949e = new AtomicInteger(1);

        /* renamed from: f  reason: collision with root package name */
        public final MpscLinkedQueue<Object> f17950f = new MpscLinkedQueue<>();

        /* renamed from: g  reason: collision with root package name */
        public final AtomicThrowable f17951g = new AtomicThrowable();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicBoolean f17952h = new AtomicBoolean();

        /* renamed from: i  reason: collision with root package name */
        public final Callable<? extends ObservableSource<B>> f17953i;

        /* renamed from: j  reason: collision with root package name */
        public Disposable f17954j;

        /* renamed from: k  reason: collision with root package name */
        public volatile boolean f17955k;

        /* renamed from: l  reason: collision with root package name */
        public UnicastSubject<T> f17956l;

        public WindowBoundaryMainObserver(Observer<? super Observable<T>> observer, int i11, Callable<? extends ObservableSource<B>> callable) {
            this.f17946b = observer;
            this.f17947c = i11;
            this.f17953i = callable;
        }

        public void a() {
            AtomicReference<WindowBoundaryInnerObserver<T, B>> atomicReference = this.f17948d;
            WindowBoundaryInnerObserver<Object, Object> windowBoundaryInnerObserver = f17944m;
            Disposable andSet = atomicReference.getAndSet(windowBoundaryInnerObserver);
            if (andSet != null && andSet != windowBoundaryInnerObserver) {
                andSet.dispose();
            }
        }

        public void b() {
            boolean z11;
            if (getAndIncrement() == 0) {
                Observer<? super Observable<T>> observer = this.f17946b;
                MpscLinkedQueue<Object> mpscLinkedQueue = this.f17950f;
                AtomicThrowable atomicThrowable = this.f17951g;
                int i11 = 1;
                while (this.f17949e.get() != 0) {
                    UnicastSubject<T> unicastSubject = this.f17956l;
                    boolean z12 = this.f17955k;
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
                                    this.f17956l = null;
                                    unicastSubject.onComplete();
                                }
                                observer.onComplete();
                                return;
                            }
                            if (unicastSubject != null) {
                                this.f17956l = null;
                                unicastSubject.onError(terminate);
                            }
                            observer.onError(terminate);
                            return;
                        } else if (z11) {
                            i11 = addAndGet(-i11);
                            if (i11 == 0) {
                                return;
                            }
                        } else if (poll != f17945n) {
                            unicastSubject.onNext(poll);
                        } else {
                            if (unicastSubject != null) {
                                this.f17956l = null;
                                unicastSubject.onComplete();
                            }
                            if (!this.f17952h.get()) {
                                UnicastSubject<T> create = UnicastSubject.create(this.f17947c, this);
                                this.f17956l = create;
                                this.f17949e.getAndIncrement();
                                try {
                                    ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.f17953i.call(), "The other Callable returned a null ObservableSource");
                                    WindowBoundaryInnerObserver windowBoundaryInnerObserver = new WindowBoundaryInnerObserver(this);
                                    if (b.a(this.f17948d, (Object) null, windowBoundaryInnerObserver)) {
                                        observableSource.subscribe(windowBoundaryInnerObserver);
                                        observer.onNext(create);
                                    }
                                } catch (Throwable th2) {
                                    Exceptions.throwIfFatal(th2);
                                    atomicThrowable.addThrowable(th2);
                                    this.f17955k = true;
                                }
                            }
                        }
                    } else {
                        mpscLinkedQueue.clear();
                        Throwable terminate2 = atomicThrowable.terminate();
                        if (unicastSubject != null) {
                            this.f17956l = null;
                            unicastSubject.onError(terminate2);
                        }
                        observer.onError(terminate2);
                        return;
                    }
                }
                mpscLinkedQueue.clear();
                this.f17956l = null;
            }
        }

        public void c() {
            this.f17954j.dispose();
            this.f17955k = true;
            b();
        }

        public void d(Throwable th2) {
            this.f17954j.dispose();
            if (this.f17951g.addThrowable(th2)) {
                this.f17955k = true;
                b();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void dispose() {
            if (this.f17952h.compareAndSet(false, true)) {
                a();
                if (this.f17949e.decrementAndGet() == 0) {
                    this.f17954j.dispose();
                }
            }
        }

        public void e(WindowBoundaryInnerObserver<T, B> windowBoundaryInnerObserver) {
            b.a(this.f17948d, windowBoundaryInnerObserver, (Object) null);
            this.f17950f.offer(f17945n);
            b();
        }

        public boolean isDisposed() {
            return this.f17952h.get();
        }

        public void onComplete() {
            a();
            this.f17955k = true;
            b();
        }

        public void onError(Throwable th2) {
            a();
            if (this.f17951g.addThrowable(th2)) {
                this.f17955k = true;
                b();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            this.f17950f.offer(t11);
            b();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17954j, disposable)) {
                this.f17954j = disposable;
                this.f17946b.onSubscribe(this);
                this.f17950f.offer(f17945n);
                b();
            }
        }

        public void run() {
            if (this.f17949e.decrementAndGet() == 0) {
                this.f17954j.dispose();
            }
        }
    }

    public ObservableWindowBoundarySupplier(ObservableSource<T> observableSource, Callable<? extends ObservableSource<B>> callable, int i11) {
        super(observableSource);
        this.f17940c = callable;
        this.f17941d = i11;
    }

    public void subscribeActual(Observer<? super Observable<T>> observer) {
        this.f16799b.subscribe(new WindowBoundaryMainObserver(observer, this.f17941d, this.f17940c));
    }
}
