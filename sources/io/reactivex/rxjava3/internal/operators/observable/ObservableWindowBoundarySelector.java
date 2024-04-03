package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.operators.SimplePlainQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableWindowBoundarySelector<T, B, V> extends AbstractObservableWithUpstream<T, Observable<T>> {

    /* renamed from: c  reason: collision with root package name */
    public final ObservableSource<B> f22463c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super B, ? extends ObservableSource<V>> f22464d;

    /* renamed from: e  reason: collision with root package name */
    public final int f22465e;

    public static final class WindowBoundaryMainObserver<T, B, V> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = 8646217640096099753L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super Observable<T>> f22466b;

        /* renamed from: c  reason: collision with root package name */
        public final ObservableSource<B> f22467c;

        /* renamed from: d  reason: collision with root package name */
        public final Function<? super B, ? extends ObservableSource<V>> f22468d;

        /* renamed from: e  reason: collision with root package name */
        public final int f22469e;

        /* renamed from: f  reason: collision with root package name */
        public final CompositeDisposable f22470f;

        /* renamed from: g  reason: collision with root package name */
        public final WindowStartObserver<B> f22471g;

        /* renamed from: h  reason: collision with root package name */
        public final List<UnicastSubject<T>> f22472h;

        /* renamed from: i  reason: collision with root package name */
        public final SimplePlainQueue<Object> f22473i = new MpscLinkedQueue();

        /* renamed from: j  reason: collision with root package name */
        public final AtomicLong f22474j;

        /* renamed from: k  reason: collision with root package name */
        public final AtomicBoolean f22475k;

        /* renamed from: l  reason: collision with root package name */
        public final AtomicLong f22476l;

        /* renamed from: m  reason: collision with root package name */
        public volatile boolean f22477m;

        /* renamed from: n  reason: collision with root package name */
        public volatile boolean f22478n;

        /* renamed from: o  reason: collision with root package name */
        public volatile boolean f22479o;

        /* renamed from: p  reason: collision with root package name */
        public final AtomicThrowable f22480p;

        /* renamed from: q  reason: collision with root package name */
        public Disposable f22481q;

        public static final class WindowEndObserverIntercept<T, V> extends Observable<T> implements Observer<V>, Disposable {

            /* renamed from: b  reason: collision with root package name */
            public final WindowBoundaryMainObserver<T, ?, V> f22482b;

            /* renamed from: c  reason: collision with root package name */
            public final UnicastSubject<T> f22483c;

            /* renamed from: d  reason: collision with root package name */
            public final AtomicReference<Disposable> f22484d = new AtomicReference<>();

            /* renamed from: e  reason: collision with root package name */
            public final AtomicBoolean f22485e = new AtomicBoolean();

            public WindowEndObserverIntercept(WindowBoundaryMainObserver<T, ?, V> windowBoundaryMainObserver, UnicastSubject<T> unicastSubject) {
                this.f22482b = windowBoundaryMainObserver;
                this.f22483c = unicastSubject;
            }

            public boolean a() {
                return !this.f22485e.get() && this.f22485e.compareAndSet(false, true);
            }

            public void dispose() {
                DisposableHelper.dispose(this.f22484d);
            }

            public boolean isDisposed() {
                return this.f22484d.get() == DisposableHelper.DISPOSED;
            }

            public void onComplete() {
                this.f22482b.a(this);
            }

            public void onError(Throwable th2) {
                if (isDisposed()) {
                    RxJavaPlugins.onError(th2);
                } else {
                    this.f22482b.b(th2);
                }
            }

            public void onNext(V v11) {
                if (DisposableHelper.dispose(this.f22484d)) {
                    this.f22482b.a(this);
                }
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this.f22484d, disposable);
            }

            public void subscribeActual(Observer<? super T> observer) {
                this.f22483c.subscribe(observer);
                this.f22485e.set(true);
            }
        }

        public static final class WindowStartItem<B> {

            /* renamed from: a  reason: collision with root package name */
            public final B f22486a;

            public WindowStartItem(B b11) {
                this.f22486a = b11;
            }
        }

        public static final class WindowStartObserver<B> extends AtomicReference<Disposable> implements Observer<B> {
            private static final long serialVersionUID = -3326496781427702834L;

            /* renamed from: b  reason: collision with root package name */
            public final WindowBoundaryMainObserver<?, B, ?> f22487b;

            public WindowStartObserver(WindowBoundaryMainObserver<?, B, ?> windowBoundaryMainObserver) {
                this.f22487b = windowBoundaryMainObserver;
            }

            public void a() {
                DisposableHelper.dispose(this);
            }

            public void onComplete() {
                this.f22487b.e();
            }

            public void onError(Throwable th2) {
                this.f22487b.f(th2);
            }

            public void onNext(B b11) {
                this.f22487b.d(b11);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public WindowBoundaryMainObserver(Observer<? super Observable<T>> observer, ObservableSource<B> observableSource, Function<? super B, ? extends ObservableSource<V>> function, int i11) {
            this.f22466b = observer;
            this.f22467c = observableSource;
            this.f22468d = function;
            this.f22469e = i11;
            this.f22470f = new CompositeDisposable();
            this.f22472h = new ArrayList();
            this.f22474j = new AtomicLong(1);
            this.f22475k = new AtomicBoolean();
            this.f22480p = new AtomicThrowable();
            this.f22471g = new WindowStartObserver<>(this);
            this.f22476l = new AtomicLong();
        }

        public void a(WindowEndObserverIntercept<T, V> windowEndObserverIntercept) {
            this.f22473i.offer(windowEndObserverIntercept);
            c();
        }

        public void b(Throwable th2) {
            this.f22481q.dispose();
            this.f22471g.a();
            this.f22470f.dispose();
            if (this.f22480p.tryAddThrowableOrReport(th2)) {
                this.f22478n = true;
                c();
            }
        }

        public void c() {
            boolean z11;
            if (getAndIncrement() == 0) {
                Observer<? super Observable<T>> observer = this.f22466b;
                SimplePlainQueue<Object> simplePlainQueue = this.f22473i;
                List<UnicastSubject<T>> list = this.f22472h;
                int i11 = 1;
                while (true) {
                    if (this.f22477m) {
                        simplePlainQueue.clear();
                        list.clear();
                    } else {
                        boolean z12 = this.f22478n;
                        Object poll = simplePlainQueue.poll();
                        if (poll == null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z12 && (z11 || this.f22480p.get() != null)) {
                            g(observer);
                            this.f22477m = true;
                        } else if (!z11) {
                            if (poll instanceof WindowStartItem) {
                                if (!this.f22475k.get()) {
                                    try {
                                        Object apply = this.f22468d.apply(((WindowStartItem) poll).f22486a);
                                        Objects.requireNonNull(apply, "The closingIndicator returned a null ObservableSource");
                                        ObservableSource observableSource = (ObservableSource) apply;
                                        this.f22474j.getAndIncrement();
                                        UnicastSubject create = UnicastSubject.create(this.f22469e, this);
                                        WindowEndObserverIntercept windowEndObserverIntercept = new WindowEndObserverIntercept(this, create);
                                        observer.onNext(windowEndObserverIntercept);
                                        if (windowEndObserverIntercept.a()) {
                                            create.onComplete();
                                        } else {
                                            list.add(create);
                                            this.f22470f.add(windowEndObserverIntercept);
                                            observableSource.subscribe(windowEndObserverIntercept);
                                        }
                                    } catch (Throwable th2) {
                                        Exceptions.throwIfFatal(th2);
                                        this.f22481q.dispose();
                                        this.f22471g.a();
                                        this.f22470f.dispose();
                                        Exceptions.throwIfFatal(th2);
                                        this.f22480p.tryAddThrowableOrReport(th2);
                                        this.f22478n = true;
                                    }
                                }
                            } else if (poll instanceof WindowEndObserverIntercept) {
                                UnicastSubject<T> unicastSubject = ((WindowEndObserverIntercept) poll).f22483c;
                                list.remove(unicastSubject);
                                this.f22470f.delete((Disposable) poll);
                                unicastSubject.onComplete();
                            } else {
                                for (UnicastSubject<T> onNext : list) {
                                    onNext.onNext(poll);
                                }
                            }
                        } else if (this.f22479o && list.size() == 0) {
                            this.f22481q.dispose();
                            this.f22471g.a();
                            this.f22470f.dispose();
                            g(observer);
                            this.f22477m = true;
                        }
                    }
                    i11 = addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                }
            }
        }

        public void d(B b11) {
            this.f22473i.offer(new WindowStartItem(b11));
            c();
        }

        public void dispose() {
            if (!this.f22475k.compareAndSet(false, true)) {
                return;
            }
            if (this.f22474j.decrementAndGet() == 0) {
                this.f22481q.dispose();
                this.f22471g.a();
                this.f22470f.dispose();
                this.f22480p.tryTerminateAndReport();
                this.f22477m = true;
                c();
                return;
            }
            this.f22471g.a();
        }

        public void e() {
            this.f22479o = true;
            c();
        }

        public void f(Throwable th2) {
            this.f22481q.dispose();
            this.f22470f.dispose();
            if (this.f22480p.tryAddThrowableOrReport(th2)) {
                this.f22478n = true;
                c();
            }
        }

        public void g(Observer<?> observer) {
            Throwable terminate = this.f22480p.terminate();
            if (terminate == null) {
                for (UnicastSubject<T> onComplete : this.f22472h) {
                    onComplete.onComplete();
                }
                observer.onComplete();
            } else if (terminate != ExceptionHelper.TERMINATED) {
                for (UnicastSubject<T> onError : this.f22472h) {
                    onError.onError(terminate);
                }
                observer.onError(terminate);
            }
        }

        public boolean isDisposed() {
            return this.f22475k.get();
        }

        public void onComplete() {
            this.f22471g.a();
            this.f22470f.dispose();
            this.f22478n = true;
            c();
        }

        public void onError(Throwable th2) {
            this.f22471g.a();
            this.f22470f.dispose();
            if (this.f22480p.tryAddThrowableOrReport(th2)) {
                this.f22478n = true;
                c();
            }
        }

        public void onNext(T t11) {
            this.f22473i.offer(t11);
            c();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22481q, disposable)) {
                this.f22481q = disposable;
                this.f22466b.onSubscribe(this);
                this.f22467c.subscribe(this.f22471g);
            }
        }

        public void run() {
            if (this.f22474j.decrementAndGet() == 0) {
                this.f22481q.dispose();
                this.f22471g.a();
                this.f22470f.dispose();
                this.f22480p.tryTerminateAndReport();
                this.f22477m = true;
                c();
            }
        }
    }

    public ObservableWindowBoundarySelector(ObservableSource<T> observableSource, ObservableSource<B> observableSource2, Function<? super B, ? extends ObservableSource<V>> function, int i11) {
        super(observableSource);
        this.f22463c = observableSource2;
        this.f22464d = function;
        this.f22465e = i11;
    }

    public void subscribeActual(Observer<? super Observable<T>> observer) {
        this.f21304b.subscribe(new WindowBoundaryMainObserver(observer, this.f22463c, this.f22464d, this.f22465e));
    }
}
