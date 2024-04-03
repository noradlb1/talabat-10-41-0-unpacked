package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableRefCount<T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ConnectableObservable<T> f17510b;

    /* renamed from: c  reason: collision with root package name */
    public final int f17511c;

    /* renamed from: d  reason: collision with root package name */
    public final long f17512d;

    /* renamed from: e  reason: collision with root package name */
    public final TimeUnit f17513e;

    /* renamed from: f  reason: collision with root package name */
    public final Scheduler f17514f;

    /* renamed from: g  reason: collision with root package name */
    public RefConnection f17515g;

    public static final class RefConnection extends AtomicReference<Disposable> implements Runnable, Consumer<Disposable> {
        private static final long serialVersionUID = -4552101107598366241L;

        /* renamed from: b  reason: collision with root package name */
        public final ObservableRefCount<?> f17516b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f17517c;

        /* renamed from: d  reason: collision with root package name */
        public long f17518d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f17519e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f17520f;

        public RefConnection(ObservableRefCount<?> observableRefCount) {
            this.f17516b = observableRefCount;
        }

        public void run() {
            this.f17516b.e(this);
        }

        public void accept(Disposable disposable) throws Exception {
            DisposableHelper.replace(this, disposable);
            synchronized (this.f17516b) {
                if (this.f17520f) {
                    ((ResettableConnectable) this.f17516b.f17510b).resetIf(disposable);
                }
            }
        }
    }

    public static final class RefCountObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = -7419642935409022375L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17521b;

        /* renamed from: c  reason: collision with root package name */
        public final ObservableRefCount<T> f17522c;

        /* renamed from: d  reason: collision with root package name */
        public final RefConnection f17523d;

        /* renamed from: e  reason: collision with root package name */
        public Disposable f17524e;

        public RefCountObserver(Observer<? super T> observer, ObservableRefCount<T> observableRefCount, RefConnection refConnection) {
            this.f17521b = observer;
            this.f17522c = observableRefCount;
            this.f17523d = refConnection;
        }

        public void dispose() {
            this.f17524e.dispose();
            if (compareAndSet(false, true)) {
                this.f17522c.a(this.f17523d);
            }
        }

        public boolean isDisposed() {
            return this.f17524e.isDisposed();
        }

        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.f17522c.d(this.f17523d);
                this.f17521b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (compareAndSet(false, true)) {
                this.f17522c.d(this.f17523d);
                this.f17521b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            this.f17521b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17524e, disposable)) {
                this.f17524e = disposable;
                this.f17521b.onSubscribe(this);
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
    public void a(io.reactivex.internal.operators.observable.ObservableRefCount.RefConnection r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            io.reactivex.internal.operators.observable.ObservableRefCount$RefConnection r0 = r5.f17515g     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x003d
            if (r0 == r6) goto L_0x0008
            goto L_0x003d
        L_0x0008:
            long r0 = r6.f17518d     // Catch:{ all -> 0x003f }
            r2 = 1
            long r0 = r0 - r2
            r6.f17518d = r0     // Catch:{ all -> 0x003f }
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x003b
            boolean r0 = r6.f17519e     // Catch:{ all -> 0x003f }
            if (r0 != 0) goto L_0x001a
            goto L_0x003b
        L_0x001a:
            long r0 = r5.f17512d     // Catch:{ all -> 0x003f }
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0025
            r5.e(r6)     // Catch:{ all -> 0x003f }
            monitor-exit(r5)     // Catch:{ all -> 0x003f }
            return
        L_0x0025:
            io.reactivex.internal.disposables.SequentialDisposable r0 = new io.reactivex.internal.disposables.SequentialDisposable     // Catch:{ all -> 0x003f }
            r0.<init>()     // Catch:{ all -> 0x003f }
            r6.f17517c = r0     // Catch:{ all -> 0x003f }
            monitor-exit(r5)     // Catch:{ all -> 0x003f }
            io.reactivex.Scheduler r1 = r5.f17514f
            long r2 = r5.f17512d
            java.util.concurrent.TimeUnit r4 = r5.f17513e
            io.reactivex.disposables.Disposable r6 = r1.scheduleDirect(r6, r2, r4)
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
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableRefCount.a(io.reactivex.internal.operators.observable.ObservableRefCount$RefConnection):void");
    }

    public void b(RefConnection refConnection) {
        Disposable disposable = refConnection.f17517c;
        if (disposable != null) {
            disposable.dispose();
            refConnection.f17517c = null;
        }
    }

    public void c(RefConnection refConnection) {
        ConnectableObservable<T> connectableObservable = this.f17510b;
        if (connectableObservable instanceof Disposable) {
            ((Disposable) connectableObservable).dispose();
        } else if (connectableObservable instanceof ResettableConnectable) {
            ((ResettableConnectable) connectableObservable).resetIf((Disposable) refConnection.get());
        }
    }

    public void d(RefConnection refConnection) {
        synchronized (this) {
            if (this.f17510b instanceof ObservablePublishClassic) {
                RefConnection refConnection2 = this.f17515g;
                if (refConnection2 != null && refConnection2 == refConnection) {
                    this.f17515g = null;
                    b(refConnection);
                }
                long j11 = refConnection.f17518d - 1;
                refConnection.f17518d = j11;
                if (j11 == 0) {
                    c(refConnection);
                }
            } else {
                RefConnection refConnection3 = this.f17515g;
                if (refConnection3 != null && refConnection3 == refConnection) {
                    b(refConnection);
                    long j12 = refConnection.f17518d - 1;
                    refConnection.f17518d = j12;
                    if (j12 == 0) {
                        this.f17515g = null;
                        c(refConnection);
                    }
                }
            }
        }
    }

    public void e(RefConnection refConnection) {
        synchronized (this) {
            if (refConnection.f17518d == 0 && refConnection == this.f17515g) {
                this.f17515g = null;
                Disposable disposable = (Disposable) refConnection.get();
                DisposableHelper.dispose(refConnection);
                ConnectableObservable<T> connectableObservable = this.f17510b;
                if (connectableObservable instanceof Disposable) {
                    ((Disposable) connectableObservable).dispose();
                } else if (connectableObservable instanceof ResettableConnectable) {
                    if (disposable == null) {
                        refConnection.f17520f = true;
                    } else {
                        ((ResettableConnectable) connectableObservable).resetIf(disposable);
                    }
                }
            }
        }
    }

    public void subscribeActual(Observer<? super T> observer) {
        RefConnection refConnection;
        boolean z11;
        Disposable disposable;
        synchronized (this) {
            refConnection = this.f17515g;
            if (refConnection == null) {
                refConnection = new RefConnection(this);
                this.f17515g = refConnection;
            }
            long j11 = refConnection.f17518d;
            if (j11 == 0 && (disposable = refConnection.f17517c) != null) {
                disposable.dispose();
            }
            long j12 = j11 + 1;
            refConnection.f17518d = j12;
            if (refConnection.f17519e || j12 != ((long) this.f17511c)) {
                z11 = false;
            } else {
                z11 = true;
                refConnection.f17519e = true;
            }
        }
        this.f17510b.subscribe(new RefCountObserver(observer, this, refConnection));
        if (z11) {
            this.f17510b.connect(refConnection);
        }
    }

    public ObservableRefCount(ConnectableObservable<T> connectableObservable, int i11, long j11, TimeUnit timeUnit, Scheduler scheduler) {
        this.f17510b = connectableObservable;
        this.f17511c = i11;
        this.f17512d = j11;
        this.f17513e = timeUnit;
        this.f17514f = scheduler;
    }
}
