package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableBufferBoundarySupplier<T, U extends Collection<? super T>, B> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: c  reason: collision with root package name */
    public final Callable<? extends ObservableSource<B>> f16886c;

    /* renamed from: d  reason: collision with root package name */
    public final Callable<U> f16887d;

    public static final class BufferBoundaryObserver<T, U extends Collection<? super T>, B> extends DisposableObserver<B> {

        /* renamed from: b  reason: collision with root package name */
        public final BufferBoundarySupplierObserver<T, U, B> f16888b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f16889c;

        public BufferBoundaryObserver(BufferBoundarySupplierObserver<T, U, B> bufferBoundarySupplierObserver) {
            this.f16888b = bufferBoundarySupplierObserver;
        }

        public void onComplete() {
            if (!this.f16889c) {
                this.f16889c = true;
                this.f16888b.d();
            }
        }

        public void onError(Throwable th2) {
            if (this.f16889c) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f16889c = true;
            this.f16888b.onError(th2);
        }

        public void onNext(B b11) {
            if (!this.f16889c) {
                this.f16889c = true;
                dispose();
                this.f16888b.d();
            }
        }
    }

    public static final class BufferBoundarySupplierObserver<T, U extends Collection<? super T>, B> extends QueueDrainObserver<T, U, U> implements Disposable {

        /* renamed from: h  reason: collision with root package name */
        public final Callable<U> f16890h;

        /* renamed from: i  reason: collision with root package name */
        public final Callable<? extends ObservableSource<B>> f16891i;

        /* renamed from: j  reason: collision with root package name */
        public Disposable f16892j;

        /* renamed from: k  reason: collision with root package name */
        public final AtomicReference<Disposable> f16893k = new AtomicReference<>();

        /* renamed from: l  reason: collision with root package name */
        public U f16894l;

        public BufferBoundarySupplierObserver(Observer<? super U> observer, Callable<U> callable, Callable<? extends ObservableSource<B>> callable2) {
            super(observer, new MpscLinkedQueue());
            this.f16890h = callable;
            this.f16891i = callable2;
        }

        public void c() {
            DisposableHelper.dispose(this.f16893k);
        }

        public void d() {
            try {
                U u11 = (Collection) ObjectHelper.requireNonNull(this.f16890h.call(), "The buffer supplied is null");
                try {
                    ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.f16891i.call(), "The boundary ObservableSource supplied is null");
                    BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(this);
                    if (DisposableHelper.replace(this.f16893k, bufferBoundaryObserver)) {
                        synchronized (this) {
                            U u12 = this.f16894l;
                            if (u12 != null) {
                                this.f16894l = u11;
                                observableSource.subscribe(bufferBoundaryObserver);
                                a(u12, false, this);
                            }
                        }
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f14577e = true;
                    this.f16892j.dispose();
                    this.f14575c.onError(th2);
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                dispose();
                this.f14575c.onError(th3);
            }
        }

        public void dispose() {
            if (!this.f14577e) {
                this.f14577e = true;
                this.f16892j.dispose();
                c();
                if (enter()) {
                    this.f14576d.clear();
                }
            }
        }

        public boolean isDisposed() {
            return this.f14577e;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
            io.reactivex.internal.util.QueueDrainHelper.drainLoop(r3.f14576d, r3.f14575c, false, r3, r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x000b, code lost:
            r3.f14576d.offer(r0);
            r3.f14578f = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
            if (enter() == false) goto L_?;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onComplete() {
            /*
                r3 = this;
                monitor-enter(r3)
                U r0 = r3.f16894l     // Catch:{ all -> 0x0022 }
                if (r0 != 0) goto L_0x0007
                monitor-exit(r3)     // Catch:{ all -> 0x0022 }
                return
            L_0x0007:
                r1 = 0
                r3.f16894l = r1     // Catch:{ all -> 0x0022 }
                monitor-exit(r3)     // Catch:{ all -> 0x0022 }
                io.reactivex.internal.fuseable.SimplePlainQueue<U> r1 = r3.f14576d
                r1.offer(r0)
                r0 = 1
                r3.f14578f = r0
                boolean r0 = r3.enter()
                if (r0 == 0) goto L_0x0021
                io.reactivex.internal.fuseable.SimplePlainQueue<U> r0 = r3.f14576d
                io.reactivex.Observer<? super V> r1 = r3.f14575c
                r2 = 0
                io.reactivex.internal.util.QueueDrainHelper.drainLoop(r0, r1, r2, r3, r3)
            L_0x0021:
                return
            L_0x0022:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0022 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableBufferBoundarySupplier.BufferBoundarySupplierObserver.onComplete():void");
        }

        public void onError(Throwable th2) {
            dispose();
            this.f14575c.onError(th2);
        }

        public void onNext(T t11) {
            synchronized (this) {
                U u11 = this.f16894l;
                if (u11 != null) {
                    u11.add(t11);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16892j, disposable)) {
                this.f16892j = disposable;
                Observer<? super V> observer = this.f14575c;
                try {
                    this.f16894l = (Collection) ObjectHelper.requireNonNull(this.f16890h.call(), "The buffer supplied is null");
                    try {
                        ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.f16891i.call(), "The boundary ObservableSource supplied is null");
                        BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(this);
                        this.f16893k.set(bufferBoundaryObserver);
                        observer.onSubscribe(this);
                        if (!this.f14577e) {
                            observableSource.subscribe(bufferBoundaryObserver);
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.f14577e = true;
                        disposable.dispose();
                        EmptyDisposable.error(th2, (Observer<?>) observer);
                    }
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    this.f14577e = true;
                    disposable.dispose();
                    EmptyDisposable.error(th3, (Observer<?>) observer);
                }
            }
        }

        public void accept(Observer<? super U> observer, U u11) {
            this.f14575c.onNext(u11);
        }
    }

    public ObservableBufferBoundarySupplier(ObservableSource<T> observableSource, Callable<? extends ObservableSource<B>> callable, Callable<U> callable2) {
        super(observableSource);
        this.f16886c = callable;
        this.f16887d = callable2;
    }

    public void subscribeActual(Observer<? super U> observer) {
        this.f16799b.subscribe(new BufferBoundarySupplierObserver(new SerializedObserver(observer), this.f16887d, this.f16886c));
    }
}
