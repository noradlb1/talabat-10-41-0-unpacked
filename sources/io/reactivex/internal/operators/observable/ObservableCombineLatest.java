package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableCombineLatest<T, R> extends Observable<R> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<? extends T>[] f16972b;

    /* renamed from: c  reason: collision with root package name */
    public final Iterable<? extends ObservableSource<? extends T>> f16973c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super Object[], ? extends R> f16974d;

    /* renamed from: e  reason: collision with root package name */
    public final int f16975e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f16976f;

    public static final class CombinerObserver<T, R> extends AtomicReference<Disposable> implements Observer<T> {
        private static final long serialVersionUID = -4823716997131257941L;

        /* renamed from: b  reason: collision with root package name */
        public final LatestCoordinator<T, R> f16977b;

        /* renamed from: c  reason: collision with root package name */
        public final int f16978c;

        public CombinerObserver(LatestCoordinator<T, R> latestCoordinator, int i11) {
            this.f16977b = latestCoordinator;
            this.f16978c = i11;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public void onComplete() {
            this.f16977b.d(this.f16978c);
        }

        public void onError(Throwable th2) {
            this.f16977b.e(this.f16978c, th2);
        }

        public void onNext(T t11) {
            this.f16977b.f(this.f16978c, t11);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public static final class LatestCoordinator<T, R> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 8567835998786448817L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f16979b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super Object[], ? extends R> f16980c;

        /* renamed from: d  reason: collision with root package name */
        public final CombinerObserver<T, R>[] f16981d;

        /* renamed from: e  reason: collision with root package name */
        public Object[] f16982e;

        /* renamed from: f  reason: collision with root package name */
        public final SpscLinkedArrayQueue<Object[]> f16983f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f16984g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f16985h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f16986i;

        /* renamed from: j  reason: collision with root package name */
        public final AtomicThrowable f16987j = new AtomicThrowable();

        /* renamed from: k  reason: collision with root package name */
        public int f16988k;

        /* renamed from: l  reason: collision with root package name */
        public int f16989l;

        public LatestCoordinator(Observer<? super R> observer, Function<? super Object[], ? extends R> function, int i11, int i12, boolean z11) {
            this.f16979b = observer;
            this.f16980c = function;
            this.f16984g = z11;
            this.f16982e = new Object[i11];
            CombinerObserver<T, R>[] combinerObserverArr = new CombinerObserver[i11];
            for (int i13 = 0; i13 < i11; i13++) {
                combinerObserverArr[i13] = new CombinerObserver<>(this, i13);
            }
            this.f16981d = combinerObserverArr;
            this.f16983f = new SpscLinkedArrayQueue<>(i12);
        }

        public void a() {
            for (CombinerObserver<T, R> dispose : this.f16981d) {
                dispose.dispose();
            }
        }

        public void b(SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            synchronized (this) {
                this.f16982e = null;
            }
            spscLinkedArrayQueue.clear();
        }

        public void c() {
            boolean z11;
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue<Object[]> spscLinkedArrayQueue = this.f16983f;
                Observer<? super R> observer = this.f16979b;
                boolean z12 = this.f16984g;
                int i11 = 1;
                while (!this.f16985h) {
                    if (z12 || this.f16987j.get() == null) {
                        boolean z13 = this.f16986i;
                        Object[] poll = spscLinkedArrayQueue.poll();
                        if (poll == null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z13 && z11) {
                            b(spscLinkedArrayQueue);
                            Throwable terminate = this.f16987j.terminate();
                            if (terminate == null) {
                                observer.onComplete();
                                return;
                            } else {
                                observer.onError(terminate);
                                return;
                            }
                        } else if (z11) {
                            i11 = addAndGet(-i11);
                            if (i11 == 0) {
                                return;
                            }
                        } else {
                            try {
                                observer.onNext(ObjectHelper.requireNonNull(this.f16980c.apply(poll), "The combiner returned a null value"));
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                this.f16987j.addThrowable(th2);
                                a();
                                b(spscLinkedArrayQueue);
                                observer.onError(this.f16987j.terminate());
                                return;
                            }
                        }
                    } else {
                        a();
                        b(spscLinkedArrayQueue);
                        observer.onError(this.f16987j.terminate());
                        return;
                    }
                }
                b(spscLinkedArrayQueue);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0017, code lost:
            if (r2 == r0.length) goto L_0x0019;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x001c, code lost:
            if (r4 == false) goto L_0x0021;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x001e, code lost:
            a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0021, code lost:
            c();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0024, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void d(int r4) {
            /*
                r3 = this;
                monitor-enter(r3)
                java.lang.Object[] r0 = r3.f16982e     // Catch:{ all -> 0x0025 }
                if (r0 != 0) goto L_0x0007
                monitor-exit(r3)     // Catch:{ all -> 0x0025 }
                return
            L_0x0007:
                r4 = r0[r4]     // Catch:{ all -> 0x0025 }
                r1 = 1
                if (r4 != 0) goto L_0x000e
                r4 = r1
                goto L_0x000f
            L_0x000e:
                r4 = 0
            L_0x000f:
                if (r4 != 0) goto L_0x0019
                int r2 = r3.f16989l     // Catch:{ all -> 0x0025 }
                int r2 = r2 + r1
                r3.f16989l = r2     // Catch:{ all -> 0x0025 }
                int r0 = r0.length     // Catch:{ all -> 0x0025 }
                if (r2 != r0) goto L_0x001b
            L_0x0019:
                r3.f16986i = r1     // Catch:{ all -> 0x0025 }
            L_0x001b:
                monitor-exit(r3)     // Catch:{ all -> 0x0025 }
                if (r4 == 0) goto L_0x0021
                r3.a()
            L_0x0021:
                r3.c()
                return
            L_0x0025:
                r4 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0025 }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableCombineLatest.LatestCoordinator.d(int):void");
        }

        public void dispose() {
            if (!this.f16985h) {
                this.f16985h = true;
                a();
                if (getAndIncrement() == 0) {
                    b(this.f16983f);
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0023, code lost:
            if (r1 == r4.length) goto L_0x0025;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0028, code lost:
            r0 = r3;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void e(int r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                io.reactivex.internal.util.AtomicThrowable r0 = r2.f16987j
                boolean r0 = r0.addThrowable(r4)
                if (r0 == 0) goto L_0x0036
                boolean r4 = r2.f16984g
                r0 = 1
                if (r4 == 0) goto L_0x002d
                monitor-enter(r2)
                java.lang.Object[] r4 = r2.f16982e     // Catch:{ all -> 0x002a }
                if (r4 != 0) goto L_0x0014
                monitor-exit(r2)     // Catch:{ all -> 0x002a }
                return
            L_0x0014:
                r3 = r4[r3]     // Catch:{ all -> 0x002a }
                if (r3 != 0) goto L_0x001a
                r3 = r0
                goto L_0x001b
            L_0x001a:
                r3 = 0
            L_0x001b:
                if (r3 != 0) goto L_0x0025
                int r1 = r2.f16989l     // Catch:{ all -> 0x002a }
                int r1 = r1 + r0
                r2.f16989l = r1     // Catch:{ all -> 0x002a }
                int r4 = r4.length     // Catch:{ all -> 0x002a }
                if (r1 != r4) goto L_0x0027
            L_0x0025:
                r2.f16986i = r0     // Catch:{ all -> 0x002a }
            L_0x0027:
                monitor-exit(r2)     // Catch:{ all -> 0x002a }
                r0 = r3
                goto L_0x002d
            L_0x002a:
                r3 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x002a }
                throw r3
            L_0x002d:
                if (r0 == 0) goto L_0x0032
                r2.a()
            L_0x0032:
                r2.c()
                goto L_0x0039
            L_0x0036:
                io.reactivex.plugins.RxJavaPlugins.onError(r4)
            L_0x0039:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableCombineLatest.LatestCoordinator.e(int, java.lang.Throwable):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
            if (r4 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0025, code lost:
            c();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void f(int r4, T r5) {
            /*
                r3 = this;
                monitor-enter(r3)
                java.lang.Object[] r0 = r3.f16982e     // Catch:{ all -> 0x0029 }
                if (r0 != 0) goto L_0x0007
                monitor-exit(r3)     // Catch:{ all -> 0x0029 }
                return
            L_0x0007:
                r1 = r0[r4]     // Catch:{ all -> 0x0029 }
                int r2 = r3.f16988k     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0011
                int r2 = r2 + 1
                r3.f16988k = r2     // Catch:{ all -> 0x0029 }
            L_0x0011:
                r0[r4] = r5     // Catch:{ all -> 0x0029 }
                int r4 = r0.length     // Catch:{ all -> 0x0029 }
                if (r2 != r4) goto L_0x0021
                io.reactivex.internal.queue.SpscLinkedArrayQueue<java.lang.Object[]> r4 = r3.f16983f     // Catch:{ all -> 0x0029 }
                java.lang.Object r5 = r0.clone()     // Catch:{ all -> 0x0029 }
                r4.offer(r5)     // Catch:{ all -> 0x0029 }
                r4 = 1
                goto L_0x0022
            L_0x0021:
                r4 = 0
            L_0x0022:
                monitor-exit(r3)     // Catch:{ all -> 0x0029 }
                if (r4 == 0) goto L_0x0028
                r3.c()
            L_0x0028:
                return
            L_0x0029:
                r4 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0029 }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableCombineLatest.LatestCoordinator.f(int, java.lang.Object):void");
        }

        public boolean isDisposed() {
            return this.f16985h;
        }

        public void subscribe(ObservableSource<? extends T>[] observableSourceArr) {
            CombinerObserver<T, R>[] combinerObserverArr = this.f16981d;
            int length = combinerObserverArr.length;
            this.f16979b.onSubscribe(this);
            for (int i11 = 0; i11 < length && !this.f16986i && !this.f16985h; i11++) {
                observableSourceArr[i11].subscribe(combinerObserverArr[i11]);
            }
        }
    }

    public ObservableCombineLatest(ObservableSource<? extends T>[] observableSourceArr, Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i11, boolean z11) {
        this.f16972b = observableSourceArr;
        this.f16973c = iterable;
        this.f16974d = function;
        this.f16975e = i11;
        this.f16976f = z11;
    }

    public void subscribeActual(Observer<? super R> observer) {
        int i11;
        ObservableSource<? extends T>[] observableSourceArr = this.f16972b;
        if (observableSourceArr == null) {
            observableSourceArr = new ObservableSource[8];
            i11 = 0;
            for (ObservableSource<? extends T> observableSource : this.f16973c) {
                if (i11 == observableSourceArr.length) {
                    ObservableSource<? extends T>[] observableSourceArr2 = new ObservableSource[((i11 >> 2) + i11)];
                    System.arraycopy(observableSourceArr, 0, observableSourceArr2, 0, i11);
                    observableSourceArr = observableSourceArr2;
                }
                observableSourceArr[i11] = observableSource;
                i11++;
            }
        } else {
            i11 = observableSourceArr.length;
        }
        int i12 = i11;
        if (i12 == 0) {
            EmptyDisposable.complete((Observer<?>) observer);
            return;
        }
        new LatestCoordinator(observer, this.f16974d, i12, this.f16975e, this.f16976f).subscribe(observableSourceArr);
    }
}
