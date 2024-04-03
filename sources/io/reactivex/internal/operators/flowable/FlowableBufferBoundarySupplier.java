package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.DisposableSubscriber;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableBufferBoundarySupplier<T, U extends Collection<? super T>, B> extends AbstractFlowableWithUpstream<T, U> {

    /* renamed from: d  reason: collision with root package name */
    public final Callable<? extends Publisher<B>> f14867d;

    /* renamed from: e  reason: collision with root package name */
    public final Callable<U> f14868e;

    public static final class BufferBoundarySubscriber<T, U extends Collection<? super T>, B> extends DisposableSubscriber<B> {

        /* renamed from: c  reason: collision with root package name */
        public final BufferBoundarySupplierSubscriber<T, U, B> f14869c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f14870d;

        public BufferBoundarySubscriber(BufferBoundarySupplierSubscriber<T, U, B> bufferBoundarySupplierSubscriber) {
            this.f14869c = bufferBoundarySupplierSubscriber;
        }

        public void onComplete() {
            if (!this.f14870d) {
                this.f14870d = true;
                this.f14869c.d();
            }
        }

        public void onError(Throwable th2) {
            if (this.f14870d) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f14870d = true;
            this.f14869c.onError(th2);
        }

        public void onNext(B b11) {
            if (!this.f14870d) {
                this.f14870d = true;
                a();
                this.f14869c.d();
            }
        }
    }

    public static final class BufferBoundarySupplierSubscriber<T, U extends Collection<? super T>, B> extends QueueDrainSubscriber<T, U, U> implements Subscription, Disposable {

        /* renamed from: i  reason: collision with root package name */
        public final Callable<U> f14871i;

        /* renamed from: j  reason: collision with root package name */
        public final Callable<? extends Publisher<B>> f14872j;

        /* renamed from: k  reason: collision with root package name */
        public Subscription f14873k;

        /* renamed from: l  reason: collision with root package name */
        public final AtomicReference<Disposable> f14874l = new AtomicReference<>();

        /* renamed from: m  reason: collision with root package name */
        public U f14875m;

        public BufferBoundarySupplierSubscriber(Subscriber<? super U> subscriber, Callable<U> callable, Callable<? extends Publisher<B>> callable2) {
            super(subscriber, new MpscLinkedQueue());
            this.f14871i = callable;
            this.f14872j = callable2;
        }

        public void c() {
            DisposableHelper.dispose(this.f14874l);
        }

        public void cancel() {
            if (!this.f18590f) {
                this.f18590f = true;
                this.f14873k.cancel();
                c();
                if (enter()) {
                    this.f18589e.clear();
                }
            }
        }

        public void d() {
            try {
                U u11 = (Collection) ObjectHelper.requireNonNull(this.f14871i.call(), "The buffer supplied is null");
                try {
                    Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.f14872j.call(), "The boundary publisher supplied is null");
                    BufferBoundarySubscriber bufferBoundarySubscriber = new BufferBoundarySubscriber(this);
                    if (DisposableHelper.replace(this.f14874l, bufferBoundarySubscriber)) {
                        synchronized (this) {
                            U u12 = this.f14875m;
                            if (u12 != null) {
                                this.f14875m = u11;
                                publisher.subscribe(bufferBoundarySubscriber);
                                a(u12, false, this);
                            }
                        }
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f18590f = true;
                    this.f14873k.cancel();
                    this.f18588d.onError(th2);
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                cancel();
                this.f18588d.onError(th3);
            }
        }

        public void dispose() {
            this.f14873k.cancel();
            c();
        }

        public boolean isDisposed() {
            return this.f14874l.get() == DisposableHelper.DISPOSED;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
            io.reactivex.internal.util.QueueDrainHelper.drainMaxLoop(r3.f18589e, r3.f18588d, false, r3, r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x000b, code lost:
            r3.f18589e.offer(r0);
            r3.f18591g = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
            if (enter() == false) goto L_?;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onComplete() {
            /*
                r3 = this;
                monitor-enter(r3)
                U r0 = r3.f14875m     // Catch:{ all -> 0x0022 }
                if (r0 != 0) goto L_0x0007
                monitor-exit(r3)     // Catch:{ all -> 0x0022 }
                return
            L_0x0007:
                r1 = 0
                r3.f14875m = r1     // Catch:{ all -> 0x0022 }
                monitor-exit(r3)     // Catch:{ all -> 0x0022 }
                io.reactivex.internal.fuseable.SimplePlainQueue<U> r1 = r3.f18589e
                r1.offer(r0)
                r0 = 1
                r3.f18591g = r0
                boolean r0 = r3.enter()
                if (r0 == 0) goto L_0x0021
                io.reactivex.internal.fuseable.SimplePlainQueue<U> r0 = r3.f18589e
                org.reactivestreams.Subscriber<? super V> r1 = r3.f18588d
                r2 = 0
                io.reactivex.internal.util.QueueDrainHelper.drainMaxLoop(r0, r1, r2, r3, r3)
            L_0x0021:
                return
            L_0x0022:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0022 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableBufferBoundarySupplier.BufferBoundarySupplierSubscriber.onComplete():void");
        }

        public void onError(Throwable th2) {
            cancel();
            this.f18588d.onError(th2);
        }

        public void onNext(T t11) {
            synchronized (this) {
                U u11 = this.f14875m;
                if (u11 != null) {
                    u11.add(t11);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f14873k, subscription)) {
                this.f14873k = subscription;
                Subscriber<? super V> subscriber = this.f18588d;
                try {
                    this.f14875m = (Collection) ObjectHelper.requireNonNull(this.f14871i.call(), "The buffer supplied is null");
                    try {
                        Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.f14872j.call(), "The boundary publisher supplied is null");
                        BufferBoundarySubscriber bufferBoundarySubscriber = new BufferBoundarySubscriber(this);
                        this.f14874l.set(bufferBoundarySubscriber);
                        subscriber.onSubscribe(this);
                        if (!this.f18590f) {
                            subscription.request(Long.MAX_VALUE);
                            publisher.subscribe(bufferBoundarySubscriber);
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.f18590f = true;
                        subscription.cancel();
                        EmptySubscription.error(th2, subscriber);
                    }
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    this.f18590f = true;
                    subscription.cancel();
                    EmptySubscription.error(th3, subscriber);
                }
            }
        }

        public void request(long j11) {
            requested(j11);
        }

        public boolean accept(Subscriber<? super U> subscriber, U u11) {
            this.f18588d.onNext(u11);
            return true;
        }
    }

    public FlowableBufferBoundarySupplier(Flowable<T> flowable, Callable<? extends Publisher<B>> callable, Callable<U> callable2) {
        super(flowable);
        this.f14867d = callable;
        this.f14868e = callable2;
    }

    public void subscribeActual(Subscriber<? super U> subscriber) {
        this.f14763c.subscribe(new BufferBoundarySupplierSubscriber(new SerializedSubscriber(subscriber), this.f14868e, this.f14867d));
    }
}
