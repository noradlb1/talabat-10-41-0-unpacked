package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.observers.QueueDrainObserver;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.observers.SerializedObserver;
import java.util.Collection;
import java.util.Objects;

public final class ObservableBufferExactBoundary<T, U extends Collection<? super T>, B> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: c  reason: collision with root package name */
    public final ObservableSource<B> f21391c;

    /* renamed from: d  reason: collision with root package name */
    public final Supplier<U> f21392d;

    public static final class BufferBoundaryObserver<T, U extends Collection<? super T>, B> extends DisposableObserver<B> {

        /* renamed from: c  reason: collision with root package name */
        public final BufferExactBoundaryObserver<T, U, B> f21393c;

        public BufferBoundaryObserver(BufferExactBoundaryObserver<T, U, B> bufferExactBoundaryObserver) {
            this.f21393c = bufferExactBoundaryObserver;
        }

        public void onComplete() {
            this.f21393c.onComplete();
        }

        public void onError(Throwable th2) {
            this.f21393c.onError(th2);
        }

        public void onNext(B b11) {
            this.f21393c.c();
        }
    }

    public static final class BufferExactBoundaryObserver<T, U extends Collection<? super T>, B> extends QueueDrainObserver<T, U, U> implements Disposable {

        /* renamed from: h  reason: collision with root package name */
        public final Supplier<U> f21394h;

        /* renamed from: i  reason: collision with root package name */
        public final ObservableSource<B> f21395i;

        /* renamed from: j  reason: collision with root package name */
        public Disposable f21396j;

        /* renamed from: k  reason: collision with root package name */
        public Disposable f21397k;

        /* renamed from: l  reason: collision with root package name */
        public U f21398l;

        public BufferExactBoundaryObserver(Observer<? super U> observer, Supplier<U> supplier, ObservableSource<B> observableSource) {
            super(observer, new MpscLinkedQueue());
            this.f21394h = supplier;
            this.f21395i = observableSource;
        }

        public void c() {
            try {
                U u11 = this.f21394h.get();
                Objects.requireNonNull(u11, "The buffer supplied is null");
                U u12 = (Collection) u11;
                synchronized (this) {
                    U u13 = this.f21398l;
                    if (u13 != null) {
                        this.f21398l = u12;
                        a(u13, false, this);
                    }
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                dispose();
                this.f19056c.onError(th2);
            }
        }

        public void dispose() {
            if (!this.f19058e) {
                this.f19058e = true;
                this.f21397k.dispose();
                this.f21396j.dispose();
                if (enter()) {
                    this.f19057d.clear();
                }
            }
        }

        public boolean isDisposed() {
            return this.f19058e;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
            io.reactivex.rxjava3.internal.util.QueueDrainHelper.drainLoop(r3.f19057d, r3.f19056c, false, r3, r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x000b, code lost:
            r3.f19057d.offer(r0);
            r3.f19059f = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
            if (enter() == false) goto L_?;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onComplete() {
            /*
                r3 = this;
                monitor-enter(r3)
                U r0 = r3.f21398l     // Catch:{ all -> 0x0022 }
                if (r0 != 0) goto L_0x0007
                monitor-exit(r3)     // Catch:{ all -> 0x0022 }
                return
            L_0x0007:
                r1 = 0
                r3.f21398l = r1     // Catch:{ all -> 0x0022 }
                monitor-exit(r3)     // Catch:{ all -> 0x0022 }
                io.reactivex.rxjava3.operators.SimplePlainQueue<U> r1 = r3.f19057d
                r1.offer(r0)
                r0 = 1
                r3.f19059f = r0
                boolean r0 = r3.enter()
                if (r0 == 0) goto L_0x0021
                io.reactivex.rxjava3.operators.SimplePlainQueue<U> r0 = r3.f19057d
                io.reactivex.rxjava3.core.Observer<? super V> r1 = r3.f19056c
                r2 = 0
                io.reactivex.rxjava3.internal.util.QueueDrainHelper.drainLoop(r0, r1, r2, r3, r3)
            L_0x0021:
                return
            L_0x0022:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0022 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableBufferExactBoundary.BufferExactBoundaryObserver.onComplete():void");
        }

        public void onError(Throwable th2) {
            dispose();
            this.f19056c.onError(th2);
        }

        public void onNext(T t11) {
            synchronized (this) {
                U u11 = this.f21398l;
                if (u11 != null) {
                    u11.add(t11);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21396j, disposable)) {
                this.f21396j = disposable;
                try {
                    U u11 = this.f21394h.get();
                    Objects.requireNonNull(u11, "The buffer supplied is null");
                    this.f21398l = (Collection) u11;
                    BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(this);
                    this.f21397k = bufferBoundaryObserver;
                    this.f19056c.onSubscribe(this);
                    if (!this.f19058e) {
                        this.f21395i.subscribe(bufferBoundaryObserver);
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f19058e = true;
                    disposable.dispose();
                    EmptyDisposable.error(th2, (Observer<?>) this.f19056c);
                }
            }
        }

        public void accept(Observer<? super U> observer, U u11) {
            this.f19056c.onNext(u11);
        }
    }

    public ObservableBufferExactBoundary(ObservableSource<T> observableSource, ObservableSource<B> observableSource2, Supplier<U> supplier) {
        super(observableSource);
        this.f21391c = observableSource2;
        this.f21392d = supplier;
    }

    public void subscribeActual(Observer<? super U> observer) {
        this.f21304b.subscribe(new BufferExactBoundaryObserver(new SerializedObserver(observer), this.f21392d, this.f21391c));
    }
}
