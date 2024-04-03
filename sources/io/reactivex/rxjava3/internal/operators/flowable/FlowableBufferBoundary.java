package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableBufferBoundary<T, U extends Collection<? super T>, Open, Close> extends AbstractFlowableWithUpstream<T, U> {

    /* renamed from: d  reason: collision with root package name */
    public final Supplier<U> f19344d;

    /* renamed from: e  reason: collision with root package name */
    public final Publisher<? extends Open> f19345e;

    /* renamed from: f  reason: collision with root package name */
    public final Function<? super Open, ? extends Publisher<? extends Close>> f19346f;

    public static final class BufferBoundarySubscriber<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -8466418554264089604L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super C> f19347b;

        /* renamed from: c  reason: collision with root package name */
        public final Supplier<C> f19348c;

        /* renamed from: d  reason: collision with root package name */
        public final Publisher<? extends Open> f19349d;

        /* renamed from: e  reason: collision with root package name */
        public final Function<? super Open, ? extends Publisher<? extends Close>> f19350e;

        /* renamed from: f  reason: collision with root package name */
        public final CompositeDisposable f19351f = new CompositeDisposable();

        /* renamed from: g  reason: collision with root package name */
        public final AtomicLong f19352g = new AtomicLong();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicReference<Subscription> f19353h = new AtomicReference<>();

        /* renamed from: i  reason: collision with root package name */
        public final AtomicThrowable f19354i = new AtomicThrowable();

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f19355j;

        /* renamed from: k  reason: collision with root package name */
        public final SpscLinkedArrayQueue<C> f19356k = new SpscLinkedArrayQueue<>(Flowable.bufferSize());

        /* renamed from: l  reason: collision with root package name */
        public volatile boolean f19357l;

        /* renamed from: m  reason: collision with root package name */
        public long f19358m;

        /* renamed from: n  reason: collision with root package name */
        public Map<Long, C> f19359n = new LinkedHashMap();

        /* renamed from: o  reason: collision with root package name */
        public long f19360o;

        public static final class BufferOpenSubscriber<Open> extends AtomicReference<Subscription> implements FlowableSubscriber<Open>, Disposable {
            private static final long serialVersionUID = -8498650778633225126L;

            /* renamed from: b  reason: collision with root package name */
            public final BufferBoundarySubscriber<?, ?, Open, ?> f19361b;

            public BufferOpenSubscriber(BufferBoundarySubscriber<?, ?, Open, ?> bufferBoundarySubscriber) {
                this.f19361b = bufferBoundarySubscriber;
            }

            public void dispose() {
                SubscriptionHelper.cancel(this);
            }

            public boolean isDisposed() {
                return get() == SubscriptionHelper.CANCELLED;
            }

            public void onComplete() {
                lazySet(SubscriptionHelper.CANCELLED);
                this.f19361b.e(this);
            }

            public void onError(Throwable th2) {
                lazySet(SubscriptionHelper.CANCELLED);
                this.f19361b.a(this, th2);
            }

            public void onNext(Open open) {
                this.f19361b.d(open);
            }

            public void onSubscribe(Subscription subscription) {
                SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
            }
        }

        public BufferBoundarySubscriber(Subscriber<? super C> subscriber, Publisher<? extends Open> publisher, Function<? super Open, ? extends Publisher<? extends Close>> function, Supplier<C> supplier) {
            this.f19347b = subscriber;
            this.f19348c = supplier;
            this.f19349d = publisher;
            this.f19350e = function;
        }

        public void a(Disposable disposable, Throwable th2) {
            SubscriptionHelper.cancel(this.f19353h);
            this.f19351f.delete(disposable);
            onError(th2);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
            if (r4 == false) goto L_0x002f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
            r3.f19355j = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
            c();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0032, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b(io.reactivex.rxjava3.internal.operators.flowable.FlowableBufferBoundary.BufferCloseSubscriber<T, C> r4, long r5) {
            /*
                r3 = this;
                io.reactivex.rxjava3.disposables.CompositeDisposable r0 = r3.f19351f
                r0.delete(r4)
                io.reactivex.rxjava3.disposables.CompositeDisposable r4 = r3.f19351f
                int r4 = r4.size()
                r0 = 1
                if (r4 != 0) goto L_0x0015
                java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> r4 = r3.f19353h
                io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper.cancel(r4)
                r4 = r0
                goto L_0x0016
            L_0x0015:
                r4 = 0
            L_0x0016:
                monitor-enter(r3)
                java.util.Map<java.lang.Long, C> r1 = r3.f19359n     // Catch:{ all -> 0x0033 }
                if (r1 != 0) goto L_0x001d
                monitor-exit(r3)     // Catch:{ all -> 0x0033 }
                return
            L_0x001d:
                io.reactivex.rxjava3.operators.SpscLinkedArrayQueue<C> r2 = r3.f19356k     // Catch:{ all -> 0x0033 }
                java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0033 }
                java.lang.Object r5 = r1.remove(r5)     // Catch:{ all -> 0x0033 }
                r2.offer(r5)     // Catch:{ all -> 0x0033 }
                monitor-exit(r3)     // Catch:{ all -> 0x0033 }
                if (r4 == 0) goto L_0x002f
                r3.f19355j = r0
            L_0x002f:
                r3.c()
                return
            L_0x0033:
                r4 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0033 }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableBufferBoundary.BufferBoundarySubscriber.b(io.reactivex.rxjava3.internal.operators.flowable.FlowableBufferBoundary$BufferCloseSubscriber, long):void");
        }

        public void c() {
            int i11;
            boolean z11;
            if (getAndIncrement() == 0) {
                long j11 = this.f19360o;
                Subscriber<? super C> subscriber = this.f19347b;
                SpscLinkedArrayQueue<C> spscLinkedArrayQueue = this.f19356k;
                int i12 = 1;
                do {
                    long j12 = this.f19352g.get();
                    while (true) {
                        i11 = (j11 > j12 ? 1 : (j11 == j12 ? 0 : -1));
                        if (i11 == 0) {
                            break;
                        } else if (this.f19357l) {
                            spscLinkedArrayQueue.clear();
                            return;
                        } else {
                            boolean z12 = this.f19355j;
                            if (!z12 || this.f19354i.get() == null) {
                                Collection collection = (Collection) spscLinkedArrayQueue.poll();
                                if (collection == null) {
                                    z11 = true;
                                } else {
                                    z11 = false;
                                }
                                if (z12 && z11) {
                                    subscriber.onComplete();
                                    return;
                                } else if (z11) {
                                    break;
                                } else {
                                    subscriber.onNext(collection);
                                    j11++;
                                }
                            } else {
                                spscLinkedArrayQueue.clear();
                                this.f19354i.tryTerminateConsumer((Subscriber<?>) subscriber);
                                return;
                            }
                        }
                    }
                    if (i11 == 0) {
                        if (this.f19357l) {
                            spscLinkedArrayQueue.clear();
                            return;
                        } else if (this.f19355j) {
                            if (this.f19354i.get() != null) {
                                spscLinkedArrayQueue.clear();
                                this.f19354i.tryTerminateConsumer((Subscriber<?>) subscriber);
                                return;
                            } else if (spscLinkedArrayQueue.isEmpty()) {
                                subscriber.onComplete();
                                return;
                            }
                        }
                    }
                    this.f19360o = j11;
                    i12 = addAndGet(-i12);
                } while (i12 != 0);
            }
        }

        public void cancel() {
            if (SubscriptionHelper.cancel(this.f19353h)) {
                this.f19357l = true;
                this.f19351f.dispose();
                synchronized (this) {
                    this.f19359n = null;
                }
                if (getAndIncrement() != 0) {
                    this.f19356k.clear();
                }
            }
        }

        public void d(Open open) {
            try {
                C c11 = this.f19348c.get();
                Objects.requireNonNull(c11, "The bufferSupplier returned a null Collection");
                Collection collection = (Collection) c11;
                Object apply = this.f19350e.apply(open);
                Objects.requireNonNull(apply, "The bufferClose returned a null Publisher");
                Publisher publisher = (Publisher) apply;
                long j11 = this.f19358m;
                this.f19358m = 1 + j11;
                synchronized (this) {
                    Map<Long, C> map = this.f19359n;
                    if (map != null) {
                        map.put(Long.valueOf(j11), collection);
                        BufferCloseSubscriber bufferCloseSubscriber = new BufferCloseSubscriber(this, j11);
                        this.f19351f.add(bufferCloseSubscriber);
                        publisher.subscribe(bufferCloseSubscriber);
                    }
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                SubscriptionHelper.cancel(this.f19353h);
                onError(th2);
            }
        }

        public void e(BufferOpenSubscriber<Open> bufferOpenSubscriber) {
            this.f19351f.delete(bufferOpenSubscriber);
            if (this.f19351f.size() == 0) {
                SubscriptionHelper.cancel(this.f19353h);
                this.f19355j = true;
                c();
            }
        }

        public void onComplete() {
            this.f19351f.dispose();
            synchronized (this) {
                Map<Long, C> map = this.f19359n;
                if (map != null) {
                    for (C offer : map.values()) {
                        this.f19356k.offer(offer);
                    }
                    this.f19359n = null;
                    this.f19355j = true;
                    c();
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f19354i.tryAddThrowableOrReport(th2)) {
                this.f19351f.dispose();
                synchronized (this) {
                    this.f19359n = null;
                }
                this.f19355j = true;
                c();
            }
        }

        public void onNext(T t11) {
            synchronized (this) {
                Map<Long, C> map = this.f19359n;
                if (map != null) {
                    for (C add : map.values()) {
                        add.add(t11);
                    }
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.f19353h, subscription)) {
                BufferOpenSubscriber bufferOpenSubscriber = new BufferOpenSubscriber(this);
                this.f19351f.add(bufferOpenSubscriber);
                this.f19349d.subscribe(bufferOpenSubscriber);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void request(long j11) {
            BackpressureHelper.add(this.f19352g, j11);
            c();
        }
    }

    public static final class BufferCloseSubscriber<T, C extends Collection<? super T>> extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
        private static final long serialVersionUID = -8498650778633225126L;

        /* renamed from: b  reason: collision with root package name */
        public final BufferBoundarySubscriber<T, C, ?, ?> f19362b;

        /* renamed from: c  reason: collision with root package name */
        public final long f19363c;

        public BufferCloseSubscriber(BufferBoundarySubscriber<T, C, ?, ?> bufferBoundarySubscriber, long j11) {
            this.f19362b = bufferBoundarySubscriber;
            this.f19363c = j11;
        }

        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        public boolean isDisposed() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            Object obj = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (obj != subscriptionHelper) {
                lazySet(subscriptionHelper);
                this.f19362b.b(this, this.f19363c);
            }
        }

        public void onError(Throwable th2) {
            Object obj = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (obj != subscriptionHelper) {
                lazySet(subscriptionHelper);
                this.f19362b.a(this, th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(Object obj) {
            Subscription subscription = (Subscription) get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                lazySet(subscriptionHelper);
                subscription.cancel();
                this.f19362b.b(this, this.f19363c);
            }
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    public FlowableBufferBoundary(Flowable<T> flowable, Publisher<? extends Open> publisher, Function<? super Open, ? extends Publisher<? extends Close>> function, Supplier<U> supplier) {
        super(flowable);
        this.f19345e = publisher;
        this.f19346f = function;
        this.f19344d = supplier;
    }

    public void subscribeActual(Subscriber<? super U> subscriber) {
        BufferBoundarySubscriber bufferBoundarySubscriber = new BufferBoundarySubscriber(subscriber, this.f19345e, this.f19346f, this.f19344d);
        subscriber.onSubscribe(bufferBoundarySubscriber);
        this.f19260c.subscribe(bufferBoundarySubscriber);
    }
}
