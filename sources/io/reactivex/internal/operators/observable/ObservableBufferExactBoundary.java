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
import java.util.Collection;
import java.util.concurrent.Callable;

public final class ObservableBufferExactBoundary<T, U extends Collection<? super T>, B> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: c  reason: collision with root package name */
    public final ObservableSource<B> f16895c;

    /* renamed from: d  reason: collision with root package name */
    public final Callable<U> f16896d;

    public static final class BufferBoundaryObserver<T, U extends Collection<? super T>, B> extends DisposableObserver<B> {

        /* renamed from: b  reason: collision with root package name */
        public final BufferExactBoundaryObserver<T, U, B> f16897b;

        public BufferBoundaryObserver(BufferExactBoundaryObserver<T, U, B> bufferExactBoundaryObserver) {
            this.f16897b = bufferExactBoundaryObserver;
        }

        public void onComplete() {
            this.f16897b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f16897b.onError(th2);
        }

        public void onNext(B b11) {
            this.f16897b.c();
        }
    }

    public static final class BufferExactBoundaryObserver<T, U extends Collection<? super T>, B> extends QueueDrainObserver<T, U, U> implements Disposable {

        /* renamed from: h  reason: collision with root package name */
        public final Callable<U> f16898h;

        /* renamed from: i  reason: collision with root package name */
        public final ObservableSource<B> f16899i;

        /* renamed from: j  reason: collision with root package name */
        public Disposable f16900j;

        /* renamed from: k  reason: collision with root package name */
        public Disposable f16901k;

        /* renamed from: l  reason: collision with root package name */
        public U f16902l;

        public BufferExactBoundaryObserver(Observer<? super U> observer, Callable<U> callable, ObservableSource<B> observableSource) {
            super(observer, new MpscLinkedQueue());
            this.f16898h = callable;
            this.f16899i = observableSource;
        }

        public void c() {
            try {
                U u11 = (Collection) ObjectHelper.requireNonNull(this.f16898h.call(), "The buffer supplied is null");
                synchronized (this) {
                    U u12 = this.f16902l;
                    if (u12 != null) {
                        this.f16902l = u11;
                        a(u12, false, this);
                    }
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                dispose();
                this.f14575c.onError(th2);
            }
        }

        public void dispose() {
            if (!this.f14577e) {
                this.f14577e = true;
                this.f16901k.dispose();
                this.f16900j.dispose();
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
                U r0 = r3.f16902l     // Catch:{ all -> 0x0022 }
                if (r0 != 0) goto L_0x0007
                monitor-exit(r3)     // Catch:{ all -> 0x0022 }
                return
            L_0x0007:
                r1 = 0
                r3.f16902l = r1     // Catch:{ all -> 0x0022 }
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
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableBufferExactBoundary.BufferExactBoundaryObserver.onComplete():void");
        }

        public void onError(Throwable th2) {
            dispose();
            this.f14575c.onError(th2);
        }

        public void onNext(T t11) {
            synchronized (this) {
                U u11 = this.f16902l;
                if (u11 != null) {
                    u11.add(t11);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16900j, disposable)) {
                this.f16900j = disposable;
                try {
                    this.f16902l = (Collection) ObjectHelper.requireNonNull(this.f16898h.call(), "The buffer supplied is null");
                    BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(this);
                    this.f16901k = bufferBoundaryObserver;
                    this.f14575c.onSubscribe(this);
                    if (!this.f14577e) {
                        this.f16899i.subscribe(bufferBoundaryObserver);
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f14577e = true;
                    disposable.dispose();
                    EmptyDisposable.error(th2, (Observer<?>) this.f14575c);
                }
            }
        }

        public void accept(Observer<? super U> observer, U u11) {
            this.f14575c.onNext(u11);
        }
    }

    public ObservableBufferExactBoundary(ObservableSource<T> observableSource, ObservableSource<B> observableSource2, Callable<U> callable) {
        super(observableSource);
        this.f16895c = observableSource2;
        this.f16896d = callable;
    }

    public void subscribeActual(Observer<? super U> observer) {
        this.f16799b.subscribe(new BufferExactBoundaryObserver(new SerializedObserver(observer), this.f16896d, this.f16895c));
    }
}
