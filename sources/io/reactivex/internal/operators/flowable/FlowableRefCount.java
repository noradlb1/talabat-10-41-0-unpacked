package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableRefCount<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final ConnectableFlowable<T> f15679c;

    /* renamed from: d  reason: collision with root package name */
    public final int f15680d;

    /* renamed from: e  reason: collision with root package name */
    public final long f15681e;

    /* renamed from: f  reason: collision with root package name */
    public final TimeUnit f15682f;

    /* renamed from: g  reason: collision with root package name */
    public final Scheduler f15683g;

    /* renamed from: h  reason: collision with root package name */
    public RefConnection f15684h;

    public static final class RefConnection extends AtomicReference<Disposable> implements Runnable, Consumer<Disposable> {
        private static final long serialVersionUID = -4552101107598366241L;

        /* renamed from: b  reason: collision with root package name */
        public final FlowableRefCount<?> f15685b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f15686c;

        /* renamed from: d  reason: collision with root package name */
        public long f15687d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f15688e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f15689f;

        public RefConnection(FlowableRefCount<?> flowableRefCount) {
            this.f15685b = flowableRefCount;
        }

        public void run() {
            this.f15685b.f(this);
        }

        public void accept(Disposable disposable) throws Exception {
            DisposableHelper.replace(this, disposable);
            synchronized (this.f15685b) {
                if (this.f15689f) {
                    ((ResettableConnectable) this.f15685b.f15679c).resetIf(disposable);
                }
            }
        }
    }

    public static final class RefCountSubscriber<T> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -7419642935409022375L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15690b;

        /* renamed from: c  reason: collision with root package name */
        public final FlowableRefCount<T> f15691c;

        /* renamed from: d  reason: collision with root package name */
        public final RefConnection f15692d;

        /* renamed from: e  reason: collision with root package name */
        public Subscription f15693e;

        public RefCountSubscriber(Subscriber<? super T> subscriber, FlowableRefCount<T> flowableRefCount, RefConnection refConnection) {
            this.f15690b = subscriber;
            this.f15691c = flowableRefCount;
            this.f15692d = refConnection;
        }

        public void cancel() {
            this.f15693e.cancel();
            if (compareAndSet(false, true)) {
                this.f15691c.b(this.f15692d);
            }
        }

        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.f15691c.e(this.f15692d);
                this.f15690b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (compareAndSet(false, true)) {
                this.f15691c.e(this.f15692d);
                this.f15690b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            this.f15690b.onNext(t11);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15693e, subscription)) {
                this.f15693e = subscription;
                this.f15690b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f15693e.request(j11);
        }
    }

    public FlowableRefCount(ConnectableFlowable<T> connectableFlowable) {
        this(connectableFlowable, 1, 0, TimeUnit.NANOSECONDS, (Scheduler) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(io.reactivex.internal.operators.flowable.FlowableRefCount.RefConnection r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            io.reactivex.internal.operators.flowable.FlowableRefCount$RefConnection r0 = r5.f15684h     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x003d
            if (r0 == r6) goto L_0x0008
            goto L_0x003d
        L_0x0008:
            long r0 = r6.f15687d     // Catch:{ all -> 0x003f }
            r2 = 1
            long r0 = r0 - r2
            r6.f15687d = r0     // Catch:{ all -> 0x003f }
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x003b
            boolean r0 = r6.f15688e     // Catch:{ all -> 0x003f }
            if (r0 != 0) goto L_0x001a
            goto L_0x003b
        L_0x001a:
            long r0 = r5.f15681e     // Catch:{ all -> 0x003f }
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0025
            r5.f(r6)     // Catch:{ all -> 0x003f }
            monitor-exit(r5)     // Catch:{ all -> 0x003f }
            return
        L_0x0025:
            io.reactivex.internal.disposables.SequentialDisposable r0 = new io.reactivex.internal.disposables.SequentialDisposable     // Catch:{ all -> 0x003f }
            r0.<init>()     // Catch:{ all -> 0x003f }
            r6.f15686c = r0     // Catch:{ all -> 0x003f }
            monitor-exit(r5)     // Catch:{ all -> 0x003f }
            io.reactivex.Scheduler r1 = r5.f15683g
            long r2 = r5.f15681e
            java.util.concurrent.TimeUnit r4 = r5.f15682f
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
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableRefCount.b(io.reactivex.internal.operators.flowable.FlowableRefCount$RefConnection):void");
    }

    public void c(RefConnection refConnection) {
        Disposable disposable = refConnection.f15686c;
        if (disposable != null) {
            disposable.dispose();
            refConnection.f15686c = null;
        }
    }

    public void d(RefConnection refConnection) {
        ConnectableFlowable<T> connectableFlowable = this.f15679c;
        if (connectableFlowable instanceof Disposable) {
            ((Disposable) connectableFlowable).dispose();
        } else if (connectableFlowable instanceof ResettableConnectable) {
            ((ResettableConnectable) connectableFlowable).resetIf((Disposable) refConnection.get());
        }
    }

    public void e(RefConnection refConnection) {
        synchronized (this) {
            if (this.f15679c instanceof FlowablePublishClassic) {
                RefConnection refConnection2 = this.f15684h;
                if (refConnection2 != null && refConnection2 == refConnection) {
                    this.f15684h = null;
                    c(refConnection);
                }
                long j11 = refConnection.f15687d - 1;
                refConnection.f15687d = j11;
                if (j11 == 0) {
                    d(refConnection);
                }
            } else {
                RefConnection refConnection3 = this.f15684h;
                if (refConnection3 != null && refConnection3 == refConnection) {
                    c(refConnection);
                    long j12 = refConnection.f15687d - 1;
                    refConnection.f15687d = j12;
                    if (j12 == 0) {
                        this.f15684h = null;
                        d(refConnection);
                    }
                }
            }
        }
    }

    public void f(RefConnection refConnection) {
        synchronized (this) {
            if (refConnection.f15687d == 0 && refConnection == this.f15684h) {
                this.f15684h = null;
                Disposable disposable = (Disposable) refConnection.get();
                DisposableHelper.dispose(refConnection);
                ConnectableFlowable<T> connectableFlowable = this.f15679c;
                if (connectableFlowable instanceof Disposable) {
                    ((Disposable) connectableFlowable).dispose();
                } else if (connectableFlowable instanceof ResettableConnectable) {
                    if (disposable == null) {
                        refConnection.f15689f = true;
                    } else {
                        ((ResettableConnectable) connectableFlowable).resetIf(disposable);
                    }
                }
            }
        }
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        RefConnection refConnection;
        boolean z11;
        Disposable disposable;
        synchronized (this) {
            refConnection = this.f15684h;
            if (refConnection == null) {
                refConnection = new RefConnection(this);
                this.f15684h = refConnection;
            }
            long j11 = refConnection.f15687d;
            if (j11 == 0 && (disposable = refConnection.f15686c) != null) {
                disposable.dispose();
            }
            long j12 = j11 + 1;
            refConnection.f15687d = j12;
            if (refConnection.f15688e || j12 != ((long) this.f15680d)) {
                z11 = false;
            } else {
                z11 = true;
                refConnection.f15688e = true;
            }
        }
        this.f15679c.subscribe(new RefCountSubscriber(subscriber, this, refConnection));
        if (z11) {
            this.f15679c.connect(refConnection);
        }
    }

    public FlowableRefCount(ConnectableFlowable<T> connectableFlowable, int i11, long j11, TimeUnit timeUnit, Scheduler scheduler) {
        this.f15679c = connectableFlowable;
        this.f15680d = i11;
        this.f15681e = j11;
        this.f15682f = timeUnit;
        this.f15683g = scheduler;
    }
}
