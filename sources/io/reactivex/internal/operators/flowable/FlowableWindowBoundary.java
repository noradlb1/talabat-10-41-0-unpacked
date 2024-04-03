package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.DisposableSubscriber;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWindowBoundary<T, B> extends AbstractFlowableWithUpstream<T, Flowable<T>> {

    /* renamed from: d  reason: collision with root package name */
    public final Publisher<B> f16118d;

    /* renamed from: e  reason: collision with root package name */
    public final int f16119e;

    public static final class WindowBoundaryInnerSubscriber<T, B> extends DisposableSubscriber<B> {

        /* renamed from: c  reason: collision with root package name */
        public final WindowBoundaryMainSubscriber<T, B> f16120c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f16121d;

        public WindowBoundaryInnerSubscriber(WindowBoundaryMainSubscriber<T, B> windowBoundaryMainSubscriber) {
            this.f16120c = windowBoundaryMainSubscriber;
        }

        public void onComplete() {
            if (!this.f16121d) {
                this.f16121d = true;
                this.f16120c.b();
            }
        }

        public void onError(Throwable th2) {
            if (this.f16121d) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f16121d = true;
            this.f16120c.c(th2);
        }

        public void onNext(B b11) {
            if (!this.f16121d) {
                this.f16120c.d();
            }
        }
    }

    public static final class WindowBoundaryMainSubscriber<T, B> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {

        /* renamed from: n  reason: collision with root package name */
        public static final Object f16122n = new Object();
        private static final long serialVersionUID = 2233020065421370272L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super Flowable<T>> f16123b;

        /* renamed from: c  reason: collision with root package name */
        public final int f16124c;

        /* renamed from: d  reason: collision with root package name */
        public final WindowBoundaryInnerSubscriber<T, B> f16125d = new WindowBoundaryInnerSubscriber<>(this);

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReference<Subscription> f16126e = new AtomicReference<>();

        /* renamed from: f  reason: collision with root package name */
        public final AtomicInteger f16127f = new AtomicInteger(1);

        /* renamed from: g  reason: collision with root package name */
        public final MpscLinkedQueue<Object> f16128g = new MpscLinkedQueue<>();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicThrowable f16129h = new AtomicThrowable();

        /* renamed from: i  reason: collision with root package name */
        public final AtomicBoolean f16130i = new AtomicBoolean();

        /* renamed from: j  reason: collision with root package name */
        public final AtomicLong f16131j = new AtomicLong();

        /* renamed from: k  reason: collision with root package name */
        public volatile boolean f16132k;

        /* renamed from: l  reason: collision with root package name */
        public UnicastProcessor<T> f16133l;

        /* renamed from: m  reason: collision with root package name */
        public long f16134m;

        public WindowBoundaryMainSubscriber(Subscriber<? super Flowable<T>> subscriber, int i11) {
            this.f16123b = subscriber;
            this.f16124c = i11;
        }

        public void a() {
            boolean z11;
            if (getAndIncrement() == 0) {
                Subscriber<? super Flowable<T>> subscriber = this.f16123b;
                MpscLinkedQueue<Object> mpscLinkedQueue = this.f16128g;
                AtomicThrowable atomicThrowable = this.f16129h;
                long j11 = this.f16134m;
                int i11 = 1;
                while (this.f16127f.get() != 0) {
                    UnicastProcessor<T> unicastProcessor = this.f16133l;
                    boolean z12 = this.f16132k;
                    if (!z12 || atomicThrowable.get() == null) {
                        Object poll = mpscLinkedQueue.poll();
                        if (poll == null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z12 && z11) {
                            Throwable terminate = atomicThrowable.terminate();
                            if (terminate == null) {
                                if (unicastProcessor != null) {
                                    this.f16133l = null;
                                    unicastProcessor.onComplete();
                                }
                                subscriber.onComplete();
                                return;
                            }
                            if (unicastProcessor != null) {
                                this.f16133l = null;
                                unicastProcessor.onError(terminate);
                            }
                            subscriber.onError(terminate);
                            return;
                        } else if (z11) {
                            this.f16134m = j11;
                            i11 = addAndGet(-i11);
                            if (i11 == 0) {
                                return;
                            }
                        } else if (poll != f16122n) {
                            unicastProcessor.onNext(poll);
                        } else {
                            if (unicastProcessor != null) {
                                this.f16133l = null;
                                unicastProcessor.onComplete();
                            }
                            if (!this.f16130i.get()) {
                                UnicastProcessor<T> create = UnicastProcessor.create(this.f16124c, this);
                                this.f16133l = create;
                                this.f16127f.getAndIncrement();
                                if (j11 != this.f16131j.get()) {
                                    j11++;
                                    subscriber.onNext(create);
                                } else {
                                    SubscriptionHelper.cancel(this.f16126e);
                                    this.f16125d.dispose();
                                    atomicThrowable.addThrowable(new MissingBackpressureException("Could not deliver a window due to lack of requests"));
                                    this.f16132k = true;
                                }
                            }
                        }
                    } else {
                        mpscLinkedQueue.clear();
                        Throwable terminate2 = atomicThrowable.terminate();
                        if (unicastProcessor != null) {
                            this.f16133l = null;
                            unicastProcessor.onError(terminate2);
                        }
                        subscriber.onError(terminate2);
                        return;
                    }
                }
                mpscLinkedQueue.clear();
                this.f16133l = null;
            }
        }

        public void b() {
            SubscriptionHelper.cancel(this.f16126e);
            this.f16132k = true;
            a();
        }

        public void c(Throwable th2) {
            SubscriptionHelper.cancel(this.f16126e);
            if (this.f16129h.addThrowable(th2)) {
                this.f16132k = true;
                a();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void cancel() {
            if (this.f16130i.compareAndSet(false, true)) {
                this.f16125d.dispose();
                if (this.f16127f.decrementAndGet() == 0) {
                    SubscriptionHelper.cancel(this.f16126e);
                }
            }
        }

        public void d() {
            this.f16128g.offer(f16122n);
            a();
        }

        public void onComplete() {
            this.f16125d.dispose();
            this.f16132k = true;
            a();
        }

        public void onError(Throwable th2) {
            this.f16125d.dispose();
            if (this.f16129h.addThrowable(th2)) {
                this.f16132k = true;
                a();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            this.f16128g.offer(t11);
            a();
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this.f16126e, subscription, Long.MAX_VALUE);
        }

        public void request(long j11) {
            BackpressureHelper.add(this.f16131j, j11);
        }

        public void run() {
            if (this.f16127f.decrementAndGet() == 0) {
                SubscriptionHelper.cancel(this.f16126e);
            }
        }
    }

    public FlowableWindowBoundary(Flowable<T> flowable, Publisher<B> publisher, int i11) {
        super(flowable);
        this.f16118d = publisher;
        this.f16119e = i11;
    }

    public void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        WindowBoundaryMainSubscriber windowBoundaryMainSubscriber = new WindowBoundaryMainSubscriber(subscriber, this.f16119e);
        subscriber.onSubscribe(windowBoundaryMainSubscriber);
        windowBoundaryMainSubscriber.d();
        this.f16118d.subscribe(windowBoundaryMainSubscriber.f16125d);
        this.f14763c.subscribe(windowBoundaryMainSubscriber);
    }
}
