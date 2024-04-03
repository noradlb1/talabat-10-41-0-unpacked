package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableCombineLatest<T, R> extends Observable<R> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<? extends T>[] f21468b;

    /* renamed from: c  reason: collision with root package name */
    public final Iterable<? extends ObservableSource<? extends T>> f21469c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super Object[], ? extends R> f21470d;

    /* renamed from: e  reason: collision with root package name */
    public final int f21471e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f21472f;

    public static final class CombinerObserver<T, R> extends AtomicReference<Disposable> implements Observer<T> {
        private static final long serialVersionUID = -4823716997131257941L;

        /* renamed from: b  reason: collision with root package name */
        public final LatestCoordinator<T, R> f21473b;

        /* renamed from: c  reason: collision with root package name */
        public final int f21474c;

        public CombinerObserver(LatestCoordinator<T, R> latestCoordinator, int i11) {
            this.f21473b = latestCoordinator;
            this.f21474c = i11;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public void onComplete() {
            this.f21473b.d(this.f21474c);
        }

        public void onError(Throwable th2) {
            this.f21473b.e(this.f21474c, th2);
        }

        public void onNext(T t11) {
            this.f21473b.f(this.f21474c, t11);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public static final class LatestCoordinator<T, R> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 8567835998786448817L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f21475b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super Object[], ? extends R> f21476c;

        /* renamed from: d  reason: collision with root package name */
        public final CombinerObserver<T, R>[] f21477d;

        /* renamed from: e  reason: collision with root package name */
        public Object[] f21478e;

        /* renamed from: f  reason: collision with root package name */
        public final SpscLinkedArrayQueue<Object[]> f21479f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f21480g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f21481h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f21482i;

        /* renamed from: j  reason: collision with root package name */
        public final AtomicThrowable f21483j = new AtomicThrowable();

        /* renamed from: k  reason: collision with root package name */
        public int f21484k;

        /* renamed from: l  reason: collision with root package name */
        public int f21485l;

        public LatestCoordinator(Observer<? super R> observer, Function<? super Object[], ? extends R> function, int i11, int i12, boolean z11) {
            this.f21475b = observer;
            this.f21476c = function;
            this.f21480g = z11;
            this.f21478e = new Object[i11];
            CombinerObserver<T, R>[] combinerObserverArr = new CombinerObserver[i11];
            for (int i13 = 0; i13 < i11; i13++) {
                combinerObserverArr[i13] = new CombinerObserver<>(this, i13);
            }
            this.f21477d = combinerObserverArr;
            this.f21479f = new SpscLinkedArrayQueue<>(i12);
        }

        public void a() {
            for (CombinerObserver<T, R> dispose : this.f21477d) {
                dispose.dispose();
            }
        }

        public void b(SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            synchronized (this) {
                this.f21478e = null;
            }
            spscLinkedArrayQueue.clear();
        }

        public void c() {
            boolean z11;
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue<Object[]> spscLinkedArrayQueue = this.f21479f;
                Observer<? super R> observer = this.f21475b;
                boolean z12 = this.f21480g;
                int i11 = 1;
                while (!this.f21481h) {
                    if (z12 || this.f21483j.get() == null) {
                        boolean z13 = this.f21482i;
                        Object[] poll = spscLinkedArrayQueue.poll();
                        if (poll == null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z13 && z11) {
                            b(spscLinkedArrayQueue);
                            this.f21483j.tryTerminateConsumer((Observer<?>) observer);
                            return;
                        } else if (z11) {
                            i11 = addAndGet(-i11);
                            if (i11 == 0) {
                                return;
                            }
                        } else {
                            try {
                                Object apply = this.f21476c.apply(poll);
                                Objects.requireNonNull(apply, "The combiner returned a null value");
                                observer.onNext(apply);
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                this.f21483j.tryAddThrowableOrReport(th2);
                                a();
                                b(spscLinkedArrayQueue);
                                this.f21483j.tryTerminateConsumer((Observer<?>) observer);
                                return;
                            }
                        }
                    } else {
                        a();
                        b(spscLinkedArrayQueue);
                        this.f21483j.tryTerminateConsumer((Observer<?>) observer);
                        return;
                    }
                }
                b(spscLinkedArrayQueue);
                this.f21483j.tryTerminateAndReport();
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
                java.lang.Object[] r0 = r3.f21478e     // Catch:{ all -> 0x0025 }
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
                int r2 = r3.f21485l     // Catch:{ all -> 0x0025 }
                int r2 = r2 + r1
                r3.f21485l = r2     // Catch:{ all -> 0x0025 }
                int r0 = r0.length     // Catch:{ all -> 0x0025 }
                if (r2 != r0) goto L_0x001b
            L_0x0019:
                r3.f21482i = r1     // Catch:{ all -> 0x0025 }
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
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableCombineLatest.LatestCoordinator.d(int):void");
        }

        public void dispose() {
            if (!this.f21481h) {
                this.f21481h = true;
                a();
                c();
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
                io.reactivex.rxjava3.internal.util.AtomicThrowable r0 = r2.f21483j
                boolean r4 = r0.tryAddThrowableOrReport(r4)
                if (r4 == 0) goto L_0x0035
                boolean r4 = r2.f21480g
                r0 = 1
                if (r4 == 0) goto L_0x002d
                monitor-enter(r2)
                java.lang.Object[] r4 = r2.f21478e     // Catch:{ all -> 0x002a }
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
                int r1 = r2.f21485l     // Catch:{ all -> 0x002a }
                int r1 = r1 + r0
                r2.f21485l = r1     // Catch:{ all -> 0x002a }
                int r4 = r4.length     // Catch:{ all -> 0x002a }
                if (r1 != r4) goto L_0x0027
            L_0x0025:
                r2.f21482i = r0     // Catch:{ all -> 0x002a }
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
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableCombineLatest.LatestCoordinator.e(int, java.lang.Throwable):void");
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
                java.lang.Object[] r0 = r3.f21478e     // Catch:{ all -> 0x0029 }
                if (r0 != 0) goto L_0x0007
                monitor-exit(r3)     // Catch:{ all -> 0x0029 }
                return
            L_0x0007:
                r1 = r0[r4]     // Catch:{ all -> 0x0029 }
                int r2 = r3.f21484k     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0011
                int r2 = r2 + 1
                r3.f21484k = r2     // Catch:{ all -> 0x0029 }
            L_0x0011:
                r0[r4] = r5     // Catch:{ all -> 0x0029 }
                int r4 = r0.length     // Catch:{ all -> 0x0029 }
                if (r2 != r4) goto L_0x0021
                io.reactivex.rxjava3.operators.SpscLinkedArrayQueue<java.lang.Object[]> r4 = r3.f21479f     // Catch:{ all -> 0x0029 }
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
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableCombineLatest.LatestCoordinator.f(int, java.lang.Object):void");
        }

        public boolean isDisposed() {
            return this.f21481h;
        }

        public void subscribe(ObservableSource<? extends T>[] observableSourceArr) {
            CombinerObserver<T, R>[] combinerObserverArr = this.f21477d;
            int length = combinerObserverArr.length;
            this.f21475b.onSubscribe(this);
            for (int i11 = 0; i11 < length && !this.f21482i && !this.f21481h; i11++) {
                observableSourceArr[i11].subscribe(combinerObserverArr[i11]);
            }
        }
    }

    public ObservableCombineLatest(ObservableSource<? extends T>[] observableSourceArr, Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i11, boolean z11) {
        this.f21468b = observableSourceArr;
        this.f21469c = iterable;
        this.f21470d = function;
        this.f21471e = i11;
        this.f21472f = z11;
    }

    public void subscribeActual(Observer<? super R> observer) {
        int i11;
        ObservableSource<? extends T>[] observableSourceArr = this.f21468b;
        if (observableSourceArr == null) {
            observableSourceArr = new ObservableSource[8];
            try {
                i11 = 0;
                for (ObservableSource<? extends T> observableSource : this.f21469c) {
                    if (i11 == observableSourceArr.length) {
                        ObservableSource<? extends T>[] observableSourceArr2 = new ObservableSource[((i11 >> 2) + i11)];
                        System.arraycopy(observableSourceArr, 0, observableSourceArr2, 0, i11);
                        observableSourceArr = observableSourceArr2;
                    }
                    int i12 = i11 + 1;
                    Objects.requireNonNull(observableSource, "The Iterator returned a null ObservableSource");
                    observableSourceArr[i11] = observableSource;
                    i11 = i12;
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                EmptyDisposable.error(th2, (Observer<?>) observer);
                return;
            }
        } else {
            i11 = observableSourceArr.length;
        }
        int i13 = i11;
        if (i13 == 0) {
            EmptyDisposable.complete((Observer<?>) observer);
            return;
        }
        new LatestCoordinator(observer, this.f21470d, i13, this.f21471e, this.f21472f).subscribe(observableSourceArr);
    }
}
