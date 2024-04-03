package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.flowables.ConnectableFlowable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableRefCount<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final ConnectableFlowable<T> f20186c;

    /* renamed from: d  reason: collision with root package name */
    public final int f20187d;

    /* renamed from: e  reason: collision with root package name */
    public final long f20188e;

    /* renamed from: f  reason: collision with root package name */
    public final TimeUnit f20189f;

    /* renamed from: g  reason: collision with root package name */
    public final Scheduler f20190g;

    /* renamed from: h  reason: collision with root package name */
    public RefConnection f20191h;

    public static final class RefConnection extends AtomicReference<Disposable> implements Runnable, Consumer<Disposable> {
        private static final long serialVersionUID = -4552101107598366241L;

        /* renamed from: b  reason: collision with root package name */
        public final FlowableRefCount<?> f20192b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f20193c;

        /* renamed from: d  reason: collision with root package name */
        public long f20194d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f20195e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f20196f;

        public RefConnection(FlowableRefCount<?> flowableRefCount) {
            this.f20192b = flowableRefCount;
        }

        public void run() {
            this.f20192b.d(this);
        }

        public void accept(Disposable disposable) {
            DisposableHelper.replace(this, disposable);
            synchronized (this.f20192b) {
                if (this.f20196f) {
                    this.f20192b.f20186c.reset();
                }
            }
        }
    }

    public static final class RefCountSubscriber<T> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -7419642935409022375L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f20197b;

        /* renamed from: c  reason: collision with root package name */
        public final FlowableRefCount<T> f20198c;

        /* renamed from: d  reason: collision with root package name */
        public final RefConnection f20199d;

        /* renamed from: e  reason: collision with root package name */
        public Subscription f20200e;

        public RefCountSubscriber(Subscriber<? super T> subscriber, FlowableRefCount<T> flowableRefCount, RefConnection refConnection) {
            this.f20197b = subscriber;
            this.f20198c = flowableRefCount;
            this.f20199d = refConnection;
        }

        public void cancel() {
            this.f20200e.cancel();
            if (compareAndSet(false, true)) {
                this.f20198c.b(this.f20199d);
            }
        }

        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.f20198c.c(this.f20199d);
                this.f20197b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (compareAndSet(false, true)) {
                this.f20198c.c(this.f20199d);
                this.f20197b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            this.f20197b.onNext(t11);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f20200e, subscription)) {
                this.f20200e = subscription;
                this.f20197b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f20200e.request(j11);
        }
    }

    public FlowableRefCount(ConnectableFlowable<T> connectableFlowable) {
        this(connectableFlowable, 1, 0, TimeUnit.NANOSECONDS, (Scheduler) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(io.reactivex.rxjava3.internal.operators.flowable.FlowableRefCount.RefConnection r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            io.reactivex.rxjava3.internal.operators.flowable.FlowableRefCount$RefConnection r0 = r5.f20191h     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x003d
            if (r0 == r6) goto L_0x0008
            goto L_0x003d
        L_0x0008:
            long r0 = r6.f20194d     // Catch:{ all -> 0x003f }
            r2 = 1
            long r0 = r0 - r2
            r6.f20194d = r0     // Catch:{ all -> 0x003f }
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x003b
            boolean r0 = r6.f20195e     // Catch:{ all -> 0x003f }
            if (r0 != 0) goto L_0x001a
            goto L_0x003b
        L_0x001a:
            long r0 = r5.f20188e     // Catch:{ all -> 0x003f }
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0025
            r5.d(r6)     // Catch:{ all -> 0x003f }
            monitor-exit(r5)     // Catch:{ all -> 0x003f }
            return
        L_0x0025:
            io.reactivex.rxjava3.internal.disposables.SequentialDisposable r0 = new io.reactivex.rxjava3.internal.disposables.SequentialDisposable     // Catch:{ all -> 0x003f }
            r0.<init>()     // Catch:{ all -> 0x003f }
            r6.f20193c = r0     // Catch:{ all -> 0x003f }
            monitor-exit(r5)     // Catch:{ all -> 0x003f }
            io.reactivex.rxjava3.core.Scheduler r1 = r5.f20190g
            long r2 = r5.f20188e
            java.util.concurrent.TimeUnit r4 = r5.f20189f
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
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableRefCount.b(io.reactivex.rxjava3.internal.operators.flowable.FlowableRefCount$RefConnection):void");
    }

    public void c(RefConnection refConnection) {
        synchronized (this) {
            if (this.f20191h == refConnection) {
                Disposable disposable = refConnection.f20193c;
                if (disposable != null) {
                    disposable.dispose();
                    refConnection.f20193c = null;
                }
                long j11 = refConnection.f20194d - 1;
                refConnection.f20194d = j11;
                if (j11 == 0) {
                    this.f20191h = null;
                    this.f20186c.reset();
                }
            }
        }
    }

    public void d(RefConnection refConnection) {
        synchronized (this) {
            if (refConnection.f20194d == 0 && refConnection == this.f20191h) {
                this.f20191h = null;
                Disposable disposable = (Disposable) refConnection.get();
                DisposableHelper.dispose(refConnection);
                if (disposable == null) {
                    refConnection.f20196f = true;
                } else {
                    this.f20186c.reset();
                }
            }
        }
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        RefConnection refConnection;
        boolean z11;
        Disposable disposable;
        synchronized (this) {
            refConnection = this.f20191h;
            if (refConnection == null) {
                refConnection = new RefConnection(this);
                this.f20191h = refConnection;
            }
            long j11 = refConnection.f20194d;
            if (j11 == 0 && (disposable = refConnection.f20193c) != null) {
                disposable.dispose();
            }
            long j12 = j11 + 1;
            refConnection.f20194d = j12;
            if (refConnection.f20195e || j12 != ((long) this.f20187d)) {
                z11 = false;
            } else {
                z11 = true;
                refConnection.f20195e = true;
            }
        }
        this.f20186c.subscribe(new RefCountSubscriber(subscriber, this, refConnection));
        if (z11) {
            this.f20186c.connect(refConnection);
        }
    }

    public FlowableRefCount(ConnectableFlowable<T> connectableFlowable, int i11, long j11, TimeUnit timeUnit, Scheduler scheduler) {
        this.f20186c = connectableFlowable;
        this.f20187d = i11;
        this.f20188e = j11;
        this.f20189f = timeUnit;
        this.f20190g = scheduler;
    }
}
