package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableBufferBoundary<T, U extends Collection<? super T>, Open, Close> extends AbstractFlowableWithUpstream<T, U> {

    /* renamed from: d  reason: collision with root package name */
    public final Callable<U> f14847d;

    /* renamed from: e  reason: collision with root package name */
    public final Publisher<? extends Open> f14848e;

    /* renamed from: f  reason: collision with root package name */
    public final Function<? super Open, ? extends Publisher<? extends Close>> f14849f;

    public static final class BufferBoundarySubscriber<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -8466418554264089604L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super C> f14850b;

        /* renamed from: c  reason: collision with root package name */
        public final Callable<C> f14851c;

        /* renamed from: d  reason: collision with root package name */
        public final Publisher<? extends Open> f14852d;

        /* renamed from: e  reason: collision with root package name */
        public final Function<? super Open, ? extends Publisher<? extends Close>> f14853e;

        /* renamed from: f  reason: collision with root package name */
        public final CompositeDisposable f14854f = new CompositeDisposable();

        /* renamed from: g  reason: collision with root package name */
        public final AtomicLong f14855g = new AtomicLong();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicReference<Subscription> f14856h = new AtomicReference<>();

        /* renamed from: i  reason: collision with root package name */
        public final AtomicThrowable f14857i = new AtomicThrowable();

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f14858j;

        /* renamed from: k  reason: collision with root package name */
        public final SpscLinkedArrayQueue<C> f14859k = new SpscLinkedArrayQueue<>(Flowable.bufferSize());

        /* renamed from: l  reason: collision with root package name */
        public volatile boolean f14860l;

        /* renamed from: m  reason: collision with root package name */
        public long f14861m;

        /* renamed from: n  reason: collision with root package name */
        public Map<Long, C> f14862n = new LinkedHashMap();

        /* renamed from: o  reason: collision with root package name */
        public long f14863o;

        public static final class BufferOpenSubscriber<Open> extends AtomicReference<Subscription> implements FlowableSubscriber<Open>, Disposable {
            private static final long serialVersionUID = -8498650778633225126L;

            /* renamed from: b  reason: collision with root package name */
            public final BufferBoundarySubscriber<?, ?, Open, ?> f14864b;

            public BufferOpenSubscriber(BufferBoundarySubscriber<?, ?, Open, ?> bufferBoundarySubscriber) {
                this.f14864b = bufferBoundarySubscriber;
            }

            public void dispose() {
                SubscriptionHelper.cancel(this);
            }

            public boolean isDisposed() {
                return get() == SubscriptionHelper.CANCELLED;
            }

            public void onComplete() {
                lazySet(SubscriptionHelper.CANCELLED);
                this.f14864b.e(this);
            }

            public void onError(Throwable th2) {
                lazySet(SubscriptionHelper.CANCELLED);
                this.f14864b.a(this, th2);
            }

            public void onNext(Open open) {
                this.f14864b.d(open);
            }

            public void onSubscribe(Subscription subscription) {
                SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
            }
        }

        public BufferBoundarySubscriber(Subscriber<? super C> subscriber, Publisher<? extends Open> publisher, Function<? super Open, ? extends Publisher<? extends Close>> function, Callable<C> callable) {
            this.f14850b = subscriber;
            this.f14851c = callable;
            this.f14852d = publisher;
            this.f14853e = function;
        }

        public void a(Disposable disposable, Throwable th2) {
            SubscriptionHelper.cancel(this.f14856h);
            this.f14854f.delete(disposable);
            onError(th2);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
            if (r4 == false) goto L_0x002f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
            r3.f14858j = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
            c();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0032, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b(io.reactivex.internal.operators.flowable.FlowableBufferBoundary.BufferCloseSubscriber<T, C> r4, long r5) {
            /*
                r3 = this;
                io.reactivex.disposables.CompositeDisposable r0 = r3.f14854f
                r0.delete(r4)
                io.reactivex.disposables.CompositeDisposable r4 = r3.f14854f
                int r4 = r4.size()
                r0 = 1
                if (r4 != 0) goto L_0x0015
                java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> r4 = r3.f14856h
                io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(r4)
                r4 = r0
                goto L_0x0016
            L_0x0015:
                r4 = 0
            L_0x0016:
                monitor-enter(r3)
                java.util.Map<java.lang.Long, C> r1 = r3.f14862n     // Catch:{ all -> 0x0033 }
                if (r1 != 0) goto L_0x001d
                monitor-exit(r3)     // Catch:{ all -> 0x0033 }
                return
            L_0x001d:
                io.reactivex.internal.queue.SpscLinkedArrayQueue<C> r2 = r3.f14859k     // Catch:{ all -> 0x0033 }
                java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0033 }
                java.lang.Object r5 = r1.remove(r5)     // Catch:{ all -> 0x0033 }
                r2.offer(r5)     // Catch:{ all -> 0x0033 }
                monitor-exit(r3)     // Catch:{ all -> 0x0033 }
                if (r4 == 0) goto L_0x002f
                r3.f14858j = r0
            L_0x002f:
                r3.c()
                return
            L_0x0033:
                r4 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0033 }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableBufferBoundary.BufferBoundarySubscriber.b(io.reactivex.internal.operators.flowable.FlowableBufferBoundary$BufferCloseSubscriber, long):void");
        }

        public void c() {
            int i11;
            boolean z11;
            if (getAndIncrement() == 0) {
                long j11 = this.f14863o;
                Subscriber<? super C> subscriber = this.f14850b;
                SpscLinkedArrayQueue<C> spscLinkedArrayQueue = this.f14859k;
                int i12 = 1;
                do {
                    long j12 = this.f14855g.get();
                    while (true) {
                        i11 = (j11 > j12 ? 1 : (j11 == j12 ? 0 : -1));
                        if (i11 == 0) {
                            break;
                        } else if (this.f14860l) {
                            spscLinkedArrayQueue.clear();
                            return;
                        } else {
                            boolean z12 = this.f14858j;
                            if (!z12 || this.f14857i.get() == null) {
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
                                subscriber.onError(this.f14857i.terminate());
                                return;
                            }
                        }
                    }
                    if (i11 == 0) {
                        if (this.f14860l) {
                            spscLinkedArrayQueue.clear();
                            return;
                        } else if (this.f14858j) {
                            if (this.f14857i.get() != null) {
                                spscLinkedArrayQueue.clear();
                                subscriber.onError(this.f14857i.terminate());
                                return;
                            } else if (spscLinkedArrayQueue.isEmpty()) {
                                subscriber.onComplete();
                                return;
                            }
                        }
                    }
                    this.f14863o = j11;
                    i12 = addAndGet(-i12);
                } while (i12 != 0);
            }
        }

        public void cancel() {
            if (SubscriptionHelper.cancel(this.f14856h)) {
                this.f14860l = true;
                this.f14854f.dispose();
                synchronized (this) {
                    this.f14862n = null;
                }
                if (getAndIncrement() != 0) {
                    this.f14859k.clear();
                }
            }
        }

        public void d(Open open) {
            try {
                Collection collection = (Collection) ObjectHelper.requireNonNull(this.f14851c.call(), "The bufferSupplier returned a null Collection");
                Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.f14853e.apply(open), "The bufferClose returned a null Publisher");
                long j11 = this.f14861m;
                this.f14861m = 1 + j11;
                synchronized (this) {
                    Map<Long, C> map = this.f14862n;
                    if (map != null) {
                        map.put(Long.valueOf(j11), collection);
                        BufferCloseSubscriber bufferCloseSubscriber = new BufferCloseSubscriber(this, j11);
                        this.f14854f.add(bufferCloseSubscriber);
                        publisher.subscribe(bufferCloseSubscriber);
                    }
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                SubscriptionHelper.cancel(this.f14856h);
                onError(th2);
            }
        }

        public void e(BufferOpenSubscriber<Open> bufferOpenSubscriber) {
            this.f14854f.delete(bufferOpenSubscriber);
            if (this.f14854f.size() == 0) {
                SubscriptionHelper.cancel(this.f14856h);
                this.f14858j = true;
                c();
            }
        }

        public void onComplete() {
            this.f14854f.dispose();
            synchronized (this) {
                Map<Long, C> map = this.f14862n;
                if (map != null) {
                    for (C offer : map.values()) {
                        this.f14859k.offer(offer);
                    }
                    this.f14862n = null;
                    this.f14858j = true;
                    c();
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f14857i.addThrowable(th2)) {
                this.f14854f.dispose();
                synchronized (this) {
                    this.f14862n = null;
                }
                this.f14858j = true;
                c();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            synchronized (this) {
                Map<Long, C> map = this.f14862n;
                if (map != null) {
                    for (C add : map.values()) {
                        add.add(t11);
                    }
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.f14856h, subscription)) {
                BufferOpenSubscriber bufferOpenSubscriber = new BufferOpenSubscriber(this);
                this.f14854f.add(bufferOpenSubscriber);
                this.f14852d.subscribe(bufferOpenSubscriber);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void request(long j11) {
            BackpressureHelper.add(this.f14855g, j11);
            c();
        }
    }

    public static final class BufferCloseSubscriber<T, C extends Collection<? super T>> extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
        private static final long serialVersionUID = -8498650778633225126L;

        /* renamed from: b  reason: collision with root package name */
        public final BufferBoundarySubscriber<T, C, ?, ?> f14865b;

        /* renamed from: c  reason: collision with root package name */
        public final long f14866c;

        public BufferCloseSubscriber(BufferBoundarySubscriber<T, C, ?, ?> bufferBoundarySubscriber, long j11) {
            this.f14865b = bufferBoundarySubscriber;
            this.f14866c = j11;
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
                this.f14865b.b(this, this.f14866c);
            }
        }

        public void onError(Throwable th2) {
            Object obj = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (obj != subscriptionHelper) {
                lazySet(subscriptionHelper);
                this.f14865b.a(this, th2);
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
                this.f14865b.b(this, this.f14866c);
            }
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    public FlowableBufferBoundary(Flowable<T> flowable, Publisher<? extends Open> publisher, Function<? super Open, ? extends Publisher<? extends Close>> function, Callable<U> callable) {
        super(flowable);
        this.f14848e = publisher;
        this.f14849f = function;
        this.f14847d = callable;
    }

    public void subscribeActual(Subscriber<? super U> subscriber) {
        BufferBoundarySubscriber bufferBoundarySubscriber = new BufferBoundarySubscriber(subscriber, this.f14848e, this.f14849f, this.f14847d);
        subscriber.onSubscribe(bufferBoundarySubscriber);
        this.f14763c.subscribe(bufferBoundarySubscriber);
    }
}
