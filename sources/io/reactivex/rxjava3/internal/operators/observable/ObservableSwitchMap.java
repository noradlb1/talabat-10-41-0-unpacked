package io.reactivex.rxjava3.internal.operators.observable;

import i.b;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.operators.QueueDisposable;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSwitchMap<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends ObservableSource<? extends R>> f22269c;

    /* renamed from: d  reason: collision with root package name */
    public final int f22270d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f22271e;

    public static final class SwitchMapInnerObserver<T, R> extends AtomicReference<Disposable> implements Observer<R> {
        private static final long serialVersionUID = 3837284832786408377L;

        /* renamed from: b  reason: collision with root package name */
        public final SwitchMapObserver<T, R> f22272b;

        /* renamed from: c  reason: collision with root package name */
        public final long f22273c;

        /* renamed from: d  reason: collision with root package name */
        public final int f22274d;

        /* renamed from: e  reason: collision with root package name */
        public volatile SimpleQueue<R> f22275e;

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f22276f;

        public SwitchMapInnerObserver(SwitchMapObserver<T, R> switchMapObserver, long j11, int i11) {
            this.f22272b = switchMapObserver;
            this.f22273c = j11;
            this.f22274d = i11;
        }

        public void cancel() {
            DisposableHelper.dispose(this);
        }

        public void onComplete() {
            if (this.f22273c == this.f22272b.f22287k) {
                this.f22276f = true;
                this.f22272b.b();
            }
        }

        public void onError(Throwable th2) {
            this.f22272b.c(this, th2);
        }

        public void onNext(R r11) {
            if (this.f22273c == this.f22272b.f22287k) {
                if (r11 != null) {
                    this.f22275e.offer(r11);
                }
                this.f22272b.b();
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(7);
                    if (requestFusion == 1) {
                        this.f22275e = queueDisposable;
                        this.f22276f = true;
                        this.f22272b.b();
                        return;
                    } else if (requestFusion == 2) {
                        this.f22275e = queueDisposable;
                        return;
                    }
                }
                this.f22275e = new SpscLinkedArrayQueue(this.f22274d);
            }
        }
    }

    public static final class SwitchMapObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: l  reason: collision with root package name */
        public static final SwitchMapInnerObserver<Object, Object> f22277l;
        private static final long serialVersionUID = -3491074160481096299L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f22278b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends ObservableSource<? extends R>> f22279c;

        /* renamed from: d  reason: collision with root package name */
        public final int f22280d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f22281e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicThrowable f22282f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f22283g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f22284h;

        /* renamed from: i  reason: collision with root package name */
        public Disposable f22285i;

        /* renamed from: j  reason: collision with root package name */
        public final AtomicReference<SwitchMapInnerObserver<T, R>> f22286j = new AtomicReference<>();

        /* renamed from: k  reason: collision with root package name */
        public volatile long f22287k;

        static {
            SwitchMapInnerObserver<Object, Object> switchMapInnerObserver = new SwitchMapInnerObserver<>((SwitchMapObserver) null, -1, 1);
            f22277l = switchMapInnerObserver;
            switchMapInnerObserver.cancel();
        }

        public SwitchMapObserver(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, int i11, boolean z11) {
            this.f22278b = observer;
            this.f22279c = function;
            this.f22280d = i11;
            this.f22281e = z11;
            this.f22282f = new AtomicThrowable();
        }

        public void a() {
            SwitchMapInnerObserver andSet = this.f22286j.getAndSet(f22277l);
            if (andSet != null) {
                andSet.cancel();
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:71:0x000f A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b() {
            /*
                r13 = this;
                int r0 = r13.getAndIncrement()
                if (r0 == 0) goto L_0x0007
                return
            L_0x0007:
                io.reactivex.rxjava3.core.Observer<? super R> r0 = r13.f22278b
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.observable.ObservableSwitchMap$SwitchMapInnerObserver<T, R>> r1 = r13.f22286j
                boolean r2 = r13.f22281e
                r3 = 1
                r4 = r3
            L_0x000f:
                boolean r5 = r13.f22284h
                if (r5 == 0) goto L_0x0014
                return
            L_0x0014:
                boolean r5 = r13.f22283g
                r6 = 0
                if (r5 == 0) goto L_0x004e
                java.lang.Object r5 = r1.get()
                if (r5 != 0) goto L_0x0021
                r5 = r3
                goto L_0x0022
            L_0x0021:
                r5 = r6
            L_0x0022:
                if (r2 == 0) goto L_0x0038
                if (r5 == 0) goto L_0x004e
                io.reactivex.rxjava3.internal.util.AtomicThrowable r1 = r13.f22282f
                java.lang.Object r1 = r1.get()
                java.lang.Throwable r1 = (java.lang.Throwable) r1
                if (r1 == 0) goto L_0x0034
                r0.onError(r1)
                goto L_0x0037
            L_0x0034:
                r0.onComplete()
            L_0x0037:
                return
            L_0x0038:
                io.reactivex.rxjava3.internal.util.AtomicThrowable r7 = r13.f22282f
                java.lang.Object r7 = r7.get()
                java.lang.Throwable r7 = (java.lang.Throwable) r7
                if (r7 == 0) goto L_0x0048
                io.reactivex.rxjava3.internal.util.AtomicThrowable r1 = r13.f22282f
                r1.tryTerminateConsumer((io.reactivex.rxjava3.core.Observer<?>) r0)
                return
            L_0x0048:
                if (r5 == 0) goto L_0x004e
                r0.onComplete()
                return
            L_0x004e:
                java.lang.Object r5 = r1.get()
                io.reactivex.rxjava3.internal.operators.observable.ObservableSwitchMap$SwitchMapInnerObserver r5 = (io.reactivex.rxjava3.internal.operators.observable.ObservableSwitchMap.SwitchMapInnerObserver) r5
                if (r5 == 0) goto L_0x00b7
                io.reactivex.rxjava3.operators.SimpleQueue<R> r7 = r5.f22275e
                if (r7 == 0) goto L_0x00b7
                r8 = r6
            L_0x005b:
                boolean r9 = r13.f22284h
                if (r9 == 0) goto L_0x0060
                return
            L_0x0060:
                java.lang.Object r9 = r1.get()
                if (r5 == r9) goto L_0x0068
            L_0x0066:
                r8 = r3
                goto L_0x00af
            L_0x0068:
                if (r2 != 0) goto L_0x007a
                io.reactivex.rxjava3.internal.util.AtomicThrowable r9 = r13.f22282f
                java.lang.Object r9 = r9.get()
                java.lang.Throwable r9 = (java.lang.Throwable) r9
                if (r9 == 0) goto L_0x007a
                io.reactivex.rxjava3.internal.util.AtomicThrowable r1 = r13.f22282f
                r1.tryTerminateConsumer((io.reactivex.rxjava3.core.Observer<?>) r0)
                return
            L_0x007a:
                boolean r9 = r5.f22276f
                r10 = 0
                java.lang.Object r11 = r7.poll()     // Catch:{ all -> 0x0082 }
                goto L_0x00a0
            L_0x0082:
                r8 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r8)
                io.reactivex.rxjava3.internal.util.AtomicThrowable r11 = r13.f22282f
                r11.tryAddThrowableOrReport(r8)
                i.b.a(r1, r5, r10)
                if (r2 != 0) goto L_0x009b
                r13.a()
                io.reactivex.rxjava3.disposables.Disposable r8 = r13.f22285i
                r8.dispose()
                r13.f22283g = r3
                goto L_0x009e
            L_0x009b:
                r5.cancel()
            L_0x009e:
                r8 = r3
                r11 = r10
            L_0x00a0:
                if (r11 != 0) goto L_0x00a4
                r12 = r3
                goto L_0x00a5
            L_0x00a4:
                r12 = r6
            L_0x00a5:
                if (r9 == 0) goto L_0x00ad
                if (r12 == 0) goto L_0x00ad
                i.b.a(r1, r5, r10)
                goto L_0x0066
            L_0x00ad:
                if (r12 == 0) goto L_0x00b3
            L_0x00af:
                if (r8 == 0) goto L_0x00b7
                goto L_0x000f
            L_0x00b3:
                r0.onNext(r11)
                goto L_0x005b
            L_0x00b7:
                int r4 = -r4
                int r4 = r13.addAndGet(r4)
                if (r4 != 0) goto L_0x000f
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableSwitchMap.SwitchMapObserver.b():void");
        }

        public void c(SwitchMapInnerObserver<T, R> switchMapInnerObserver, Throwable th2) {
            if (switchMapInnerObserver.f22273c != this.f22287k || !this.f22282f.tryAddThrowable(th2)) {
                RxJavaPlugins.onError(th2);
                return;
            }
            if (!this.f22281e) {
                this.f22285i.dispose();
                this.f22283g = true;
            }
            switchMapInnerObserver.f22276f = true;
            b();
        }

        public void dispose() {
            if (!this.f22284h) {
                this.f22284h = true;
                this.f22285i.dispose();
                a();
                this.f22282f.tryTerminateAndReport();
            }
        }

        public boolean isDisposed() {
            return this.f22284h;
        }

        public void onComplete() {
            if (!this.f22283g) {
                this.f22283g = true;
                b();
            }
        }

        public void onError(Throwable th2) {
            if (this.f22283g || !this.f22282f.tryAddThrowable(th2)) {
                RxJavaPlugins.onError(th2);
                return;
            }
            if (!this.f22281e) {
                a();
            }
            this.f22283g = true;
            b();
        }

        public void onNext(T t11) {
            SwitchMapInnerObserver<Object, Object> switchMapInnerObserver;
            long j11 = this.f22287k + 1;
            this.f22287k = j11;
            SwitchMapInnerObserver switchMapInnerObserver2 = this.f22286j.get();
            if (switchMapInnerObserver2 != null) {
                switchMapInnerObserver2.cancel();
            }
            try {
                Object apply = this.f22279c.apply(t11);
                Objects.requireNonNull(apply, "The ObservableSource returned is null");
                ObservableSource observableSource = (ObservableSource) apply;
                SwitchMapInnerObserver switchMapInnerObserver3 = new SwitchMapInnerObserver(this, j11, this.f22280d);
                do {
                    switchMapInnerObserver = this.f22286j.get();
                    if (switchMapInnerObserver == f22277l) {
                        return;
                    }
                } while (!b.a(this.f22286j, switchMapInnerObserver, switchMapInnerObserver3));
                observableSource.subscribe(switchMapInnerObserver3);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f22285i.dispose();
                onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22285i, disposable)) {
                this.f22285i = disposable;
                this.f22278b.onSubscribe(this);
            }
        }
    }

    public ObservableSwitchMap(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends R>> function, int i11, boolean z11) {
        super(observableSource);
        this.f22269c = function;
        this.f22270d = i11;
        this.f22271e = z11;
    }

    public void subscribeActual(Observer<? super R> observer) {
        if (!ObservableScalarXMap.tryScalarXMapSubscribe(this.f21304b, observer, this.f22269c)) {
            this.f21304b.subscribe(new SwitchMapObserver(observer, this.f22269c, this.f22270d, this.f22271e));
        }
    }
}
