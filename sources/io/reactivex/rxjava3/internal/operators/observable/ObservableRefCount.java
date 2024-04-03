package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableRefCount<T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ConnectableObservable<T> f22049b;

    /* renamed from: c  reason: collision with root package name */
    public final int f22050c;

    /* renamed from: d  reason: collision with root package name */
    public final long f22051d;

    /* renamed from: e  reason: collision with root package name */
    public final TimeUnit f22052e;

    /* renamed from: f  reason: collision with root package name */
    public final Scheduler f22053f;

    /* renamed from: g  reason: collision with root package name */
    public RefConnection f22054g;

    public static final class RefConnection extends AtomicReference<Disposable> implements Runnable, Consumer<Disposable> {
        private static final long serialVersionUID = -4552101107598366241L;

        /* renamed from: b  reason: collision with root package name */
        public final ObservableRefCount<?> f22055b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f22056c;

        /* renamed from: d  reason: collision with root package name */
        public long f22057d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f22058e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f22059f;

        public RefConnection(ObservableRefCount<?> observableRefCount) {
            this.f22055b = observableRefCount;
        }

        public void run() {
            this.f22055b.c(this);
        }

        public void accept(Disposable disposable) {
            DisposableHelper.replace(this, disposable);
            synchronized (this.f22055b) {
                if (this.f22059f) {
                    this.f22055b.f22049b.reset();
                }
            }
        }
    }

    public static final class RefCountObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = -7419642935409022375L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f22060b;

        /* renamed from: c  reason: collision with root package name */
        public final ObservableRefCount<T> f22061c;

        /* renamed from: d  reason: collision with root package name */
        public final RefConnection f22062d;

        /* renamed from: e  reason: collision with root package name */
        public Disposable f22063e;

        public RefCountObserver(Observer<? super T> observer, ObservableRefCount<T> observableRefCount, RefConnection refConnection) {
            this.f22060b = observer;
            this.f22061c = observableRefCount;
            this.f22062d = refConnection;
        }

        public void dispose() {
            this.f22063e.dispose();
            if (compareAndSet(false, true)) {
                this.f22061c.a(this.f22062d);
            }
        }

        public boolean isDisposed() {
            return this.f22063e.isDisposed();
        }

        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.f22061c.b(this.f22062d);
                this.f22060b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (compareAndSet(false, true)) {
                this.f22061c.b(this.f22062d);
                this.f22060b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            this.f22060b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22063e, disposable)) {
                this.f22063e = disposable;
                this.f22060b.onSubscribe(this);
            }
        }
    }

    public ObservableRefCount(ConnectableObservable<T> connectableObservable) {
        this(connectableObservable, 1, 0, TimeUnit.NANOSECONDS, (Scheduler) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(io.reactivex.rxjava3.internal.operators.observable.ObservableRefCount.RefConnection r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            io.reactivex.rxjava3.internal.operators.observable.ObservableRefCount$RefConnection r0 = r5.f22054g     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x003d
            if (r0 == r6) goto L_0x0008
            goto L_0x003d
        L_0x0008:
            long r0 = r6.f22057d     // Catch:{ all -> 0x003f }
            r2 = 1
            long r0 = r0 - r2
            r6.f22057d = r0     // Catch:{ all -> 0x003f }
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x003b
            boolean r0 = r6.f22058e     // Catch:{ all -> 0x003f }
            if (r0 != 0) goto L_0x001a
            goto L_0x003b
        L_0x001a:
            long r0 = r5.f22051d     // Catch:{ all -> 0x003f }
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0025
            r5.c(r6)     // Catch:{ all -> 0x003f }
            monitor-exit(r5)     // Catch:{ all -> 0x003f }
            return
        L_0x0025:
            io.reactivex.rxjava3.internal.disposables.SequentialDisposable r0 = new io.reactivex.rxjava3.internal.disposables.SequentialDisposable     // Catch:{ all -> 0x003f }
            r0.<init>()     // Catch:{ all -> 0x003f }
            r6.f22056c = r0     // Catch:{ all -> 0x003f }
            monitor-exit(r5)     // Catch:{ all -> 0x003f }
            io.reactivex.rxjava3.core.Scheduler r1 = r5.f22053f
            long r2 = r5.f22051d
            java.util.concurrent.TimeUnit r4 = r5.f22052e
            io.reactivex.rxjava3.disposables.Disposable r6 = r1.scheduleDirect(r6, r2, r4)
            r0.replace(r6)
            return
        L_0x003b:
            monitor-exit(r5)     // Catch:{ all -> 0x003f }
            return
        L_0x003d:
            monitor-exit(r5)     // Catch:{ all -> 0x003f }
            return
        L_0x003f:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x003f }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableRefCount.a(io.reactivex.rxjava3.internal.operators.observable.ObservableRefCount$RefConnection):void");
    }

    public void b(RefConnection refConnection) {
        synchronized (this) {
            if (this.f22054g == refConnection) {
                Disposable disposable = refConnection.f22056c;
                if (disposable != null) {
                    disposable.dispose();
                    refConnection.f22056c = null;
                }
                long j11 = refConnection.f22057d - 1;
                refConnection.f22057d = j11;
                if (j11 == 0) {
                    this.f22054g = null;
                    this.f22049b.reset();
                }
            }
        }
    }

    public void c(RefConnection refConnection) {
        synchronized (this) {
            if (refConnection.f22057d == 0 && refConnection == this.f22054g) {
                this.f22054g = null;
                Disposable disposable = (Disposable) refConnection.get();
                DisposableHelper.dispose(refConnection);
                if (disposable == null) {
                    refConnection.f22059f = true;
                } else {
                    this.f22049b.reset();
                }
            }
        }
    }

    public void subscribeActual(Observer<? super T> observer) {
        RefConnection refConnection;
        boolean z11;
        Disposable disposable;
        synchronized (this) {
            refConnection = this.f22054g;
            if (refConnection == null) {
                refConnection = new RefConnection(this);
                this.f22054g = refConnection;
            }
            long j11 = refConnection.f22057d;
            if (j11 == 0 && (disposable = refConnection.f22056c) != null) {
                disposable.dispose();
            }
            long j12 = j11 + 1;
            refConnection.f22057d = j12;
            if (refConnection.f22058e || j12 != ((long) this.f22050c)) {
                z11 = false;
            } else {
                z11 = true;
                refConnection.f22058e = true;
            }
        }
        this.f22049b.subscribe(new RefCountObserver(observer, this, refConnection));
        if (z11) {
            this.f22049b.connect(refConnection);
        }
    }

    public ObservableRefCount(ConnectableObservable<T> connectableObservable, int i11, long j11, TimeUnit timeUnit, Scheduler scheduler) {
        this.f22049b = connectableObservable;
        this.f22050c = i11;
        this.f22051d = j11;
        this.f22052e = timeUnit;
        this.f22053f = scheduler;
    }
}
