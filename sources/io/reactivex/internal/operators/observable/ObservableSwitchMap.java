package io.reactivex.internal.operators.observable;

import i.b;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSwitchMap<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends ObservableSource<? extends R>> f17726c;

    /* renamed from: d  reason: collision with root package name */
    public final int f17727d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f17728e;

    public static final class SwitchMapInnerObserver<T, R> extends AtomicReference<Disposable> implements Observer<R> {
        private static final long serialVersionUID = 3837284832786408377L;

        /* renamed from: b  reason: collision with root package name */
        public final SwitchMapObserver<T, R> f17729b;

        /* renamed from: c  reason: collision with root package name */
        public final long f17730c;

        /* renamed from: d  reason: collision with root package name */
        public final int f17731d;

        /* renamed from: e  reason: collision with root package name */
        public volatile SimpleQueue<R> f17732e;

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f17733f;

        public SwitchMapInnerObserver(SwitchMapObserver<T, R> switchMapObserver, long j11, int i11) {
            this.f17729b = switchMapObserver;
            this.f17730c = j11;
            this.f17731d = i11;
        }

        public void cancel() {
            DisposableHelper.dispose(this);
        }

        public void onComplete() {
            if (this.f17730c == this.f17729b.f17744k) {
                this.f17733f = true;
                this.f17729b.b();
            }
        }

        public void onError(Throwable th2) {
            this.f17729b.c(this, th2);
        }

        public void onNext(R r11) {
            if (this.f17730c == this.f17729b.f17744k) {
                if (r11 != null) {
                    this.f17732e.offer(r11);
                }
                this.f17729b.b();
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(7);
                    if (requestFusion == 1) {
                        this.f17732e = queueDisposable;
                        this.f17733f = true;
                        this.f17729b.b();
                        return;
                    } else if (requestFusion == 2) {
                        this.f17732e = queueDisposable;
                        return;
                    }
                }
                this.f17732e = new SpscLinkedArrayQueue(this.f17731d);
            }
        }
    }

    public static final class SwitchMapObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: l  reason: collision with root package name */
        public static final SwitchMapInnerObserver<Object, Object> f17734l;
        private static final long serialVersionUID = -3491074160481096299L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f17735b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends ObservableSource<? extends R>> f17736c;

        /* renamed from: d  reason: collision with root package name */
        public final int f17737d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f17738e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicThrowable f17739f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f17740g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f17741h;

        /* renamed from: i  reason: collision with root package name */
        public Disposable f17742i;

        /* renamed from: j  reason: collision with root package name */
        public final AtomicReference<SwitchMapInnerObserver<T, R>> f17743j = new AtomicReference<>();

        /* renamed from: k  reason: collision with root package name */
        public volatile long f17744k;

        static {
            SwitchMapInnerObserver<Object, Object> switchMapInnerObserver = new SwitchMapInnerObserver<>((SwitchMapObserver) null, -1, 1);
            f17734l = switchMapInnerObserver;
            switchMapInnerObserver.cancel();
        }

        public SwitchMapObserver(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, int i11, boolean z11) {
            this.f17735b = observer;
            this.f17736c = function;
            this.f17737d = i11;
            this.f17738e = z11;
            this.f17739f = new AtomicThrowable();
        }

        public void a() {
            SwitchMapInnerObserver<Object, Object> andSet;
            SwitchMapInnerObserver<Object, Object> switchMapInnerObserver = this.f17743j.get();
            SwitchMapInnerObserver<Object, Object> switchMapInnerObserver2 = f17734l;
            if (switchMapInnerObserver != switchMapInnerObserver2 && (andSet = this.f17743j.getAndSet(switchMapInnerObserver2)) != switchMapInnerObserver2 && andSet != null) {
                andSet.cancel();
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:86:0x000f A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b() {
            /*
                r13 = this;
                int r0 = r13.getAndIncrement()
                if (r0 == 0) goto L_0x0007
                return
            L_0x0007:
                io.reactivex.Observer<? super R> r0 = r13.f17735b
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableSwitchMap$SwitchMapInnerObserver<T, R>> r1 = r13.f17743j
                boolean r2 = r13.f17738e
                r3 = 1
                r4 = r3
            L_0x000f:
                boolean r5 = r13.f17741h
                if (r5 == 0) goto L_0x0014
                return
            L_0x0014:
                boolean r5 = r13.f17740g
                r6 = 0
                if (r5 == 0) goto L_0x0052
                java.lang.Object r5 = r1.get()
                if (r5 != 0) goto L_0x0021
                r5 = r3
                goto L_0x0022
            L_0x0021:
                r5 = r6
            L_0x0022:
                if (r2 == 0) goto L_0x0038
                if (r5 == 0) goto L_0x0052
                io.reactivex.internal.util.AtomicThrowable r1 = r13.f17739f
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
                io.reactivex.internal.util.AtomicThrowable r7 = r13.f17739f
                java.lang.Object r7 = r7.get()
                java.lang.Throwable r7 = (java.lang.Throwable) r7
                if (r7 == 0) goto L_0x004c
                io.reactivex.internal.util.AtomicThrowable r1 = r13.f17739f
                java.lang.Throwable r1 = r1.terminate()
                r0.onError(r1)
                return
            L_0x004c:
                if (r5 == 0) goto L_0x0052
                r0.onComplete()
                return
            L_0x0052:
                java.lang.Object r5 = r1.get()
                io.reactivex.internal.operators.observable.ObservableSwitchMap$SwitchMapInnerObserver r5 = (io.reactivex.internal.operators.observable.ObservableSwitchMap.SwitchMapInnerObserver) r5
                if (r5 == 0) goto L_0x00e9
                io.reactivex.internal.fuseable.SimpleQueue<R> r7 = r5.f17732e
                if (r7 == 0) goto L_0x00e9
                boolean r8 = r5.f17733f
                r9 = 0
                if (r8 == 0) goto L_0x0089
                boolean r8 = r7.isEmpty()
                if (r2 == 0) goto L_0x006f
                if (r8 == 0) goto L_0x0089
                i.b.a(r1, r5, r9)
                goto L_0x000f
            L_0x006f:
                io.reactivex.internal.util.AtomicThrowable r10 = r13.f17739f
                java.lang.Object r10 = r10.get()
                java.lang.Throwable r10 = (java.lang.Throwable) r10
                if (r10 == 0) goto L_0x0083
                io.reactivex.internal.util.AtomicThrowable r1 = r13.f17739f
                java.lang.Throwable r1 = r1.terminate()
                r0.onError(r1)
                return
            L_0x0083:
                if (r8 == 0) goto L_0x0089
                i.b.a(r1, r5, r9)
                goto L_0x000f
            L_0x0089:
                r8 = r6
            L_0x008a:
                boolean r10 = r13.f17741h
                if (r10 == 0) goto L_0x008f
                return
            L_0x008f:
                java.lang.Object r10 = r1.get()
                if (r5 == r10) goto L_0x0097
            L_0x0095:
                r8 = r3
                goto L_0x00e1
            L_0x0097:
                if (r2 != 0) goto L_0x00ad
                io.reactivex.internal.util.AtomicThrowable r10 = r13.f17739f
                java.lang.Object r10 = r10.get()
                java.lang.Throwable r10 = (java.lang.Throwable) r10
                if (r10 == 0) goto L_0x00ad
                io.reactivex.internal.util.AtomicThrowable r1 = r13.f17739f
                java.lang.Throwable r1 = r1.terminate()
                r0.onError(r1)
                return
            L_0x00ad:
                boolean r10 = r5.f17733f
                java.lang.Object r11 = r7.poll()     // Catch:{ all -> 0x00b4 }
                goto L_0x00d2
            L_0x00b4:
                r8 = move-exception
                io.reactivex.exceptions.Exceptions.throwIfFatal(r8)
                io.reactivex.internal.util.AtomicThrowable r11 = r13.f17739f
                r11.addThrowable(r8)
                i.b.a(r1, r5, r9)
                if (r2 != 0) goto L_0x00cd
                r13.a()
                io.reactivex.disposables.Disposable r8 = r13.f17742i
                r8.dispose()
                r13.f17740g = r3
                goto L_0x00d0
            L_0x00cd:
                r5.cancel()
            L_0x00d0:
                r8 = r3
                r11 = r9
            L_0x00d2:
                if (r11 != 0) goto L_0x00d6
                r12 = r3
                goto L_0x00d7
            L_0x00d6:
                r12 = r6
            L_0x00d7:
                if (r10 == 0) goto L_0x00df
                if (r12 == 0) goto L_0x00df
                i.b.a(r1, r5, r9)
                goto L_0x0095
            L_0x00df:
                if (r12 == 0) goto L_0x00e5
            L_0x00e1:
                if (r8 == 0) goto L_0x00e9
                goto L_0x000f
            L_0x00e5:
                r0.onNext(r11)
                goto L_0x008a
            L_0x00e9:
                int r4 = -r4
                int r4 = r13.addAndGet(r4)
                if (r4 != 0) goto L_0x000f
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableSwitchMap.SwitchMapObserver.b():void");
        }

        public void c(SwitchMapInnerObserver<T, R> switchMapInnerObserver, Throwable th2) {
            if (switchMapInnerObserver.f17730c != this.f17744k || !this.f17739f.addThrowable(th2)) {
                RxJavaPlugins.onError(th2);
                return;
            }
            if (!this.f17738e) {
                this.f17742i.dispose();
                this.f17740g = true;
            }
            switchMapInnerObserver.f17733f = true;
            b();
        }

        public void dispose() {
            if (!this.f17741h) {
                this.f17741h = true;
                this.f17742i.dispose();
                a();
            }
        }

        public boolean isDisposed() {
            return this.f17741h;
        }

        public void onComplete() {
            if (!this.f17740g) {
                this.f17740g = true;
                b();
            }
        }

        public void onError(Throwable th2) {
            if (this.f17740g || !this.f17739f.addThrowable(th2)) {
                RxJavaPlugins.onError(th2);
                return;
            }
            if (!this.f17738e) {
                a();
            }
            this.f17740g = true;
            b();
        }

        public void onNext(T t11) {
            SwitchMapInnerObserver<Object, Object> switchMapInnerObserver;
            long j11 = this.f17744k + 1;
            this.f17744k = j11;
            SwitchMapInnerObserver switchMapInnerObserver2 = this.f17743j.get();
            if (switchMapInnerObserver2 != null) {
                switchMapInnerObserver2.cancel();
            }
            try {
                ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.f17736c.apply(t11), "The ObservableSource returned is null");
                SwitchMapInnerObserver switchMapInnerObserver3 = new SwitchMapInnerObserver(this, j11, this.f17737d);
                do {
                    switchMapInnerObserver = this.f17743j.get();
                    if (switchMapInnerObserver == f17734l) {
                        return;
                    }
                } while (!b.a(this.f17743j, switchMapInnerObserver, switchMapInnerObserver3));
                observableSource.subscribe(switchMapInnerObserver3);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f17742i.dispose();
                onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17742i, disposable)) {
                this.f17742i = disposable;
                this.f17735b.onSubscribe(this);
            }
        }
    }

    public ObservableSwitchMap(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends R>> function, int i11, boolean z11) {
        super(observableSource);
        this.f17726c = function;
        this.f17727d = i11;
        this.f17728e = z11;
    }

    public void subscribeActual(Observer<? super R> observer) {
        if (!ObservableScalarXMap.tryScalarXMapSubscribe(this.f16799b, observer, this.f17726c)) {
            this.f16799b.subscribe(new SwitchMapObserver(observer, this.f17726c, this.f17727d, this.f17728e));
        }
    }
}
