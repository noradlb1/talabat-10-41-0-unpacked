package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import io.reactivex.rxjava3.subscribers.DisposableSubscriber;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWindowBoundary<T, B> extends AbstractFlowableWithUpstream<T, Flowable<T>> {

    /* renamed from: d  reason: collision with root package name */
    public final Publisher<B> f20626d;

    /* renamed from: e  reason: collision with root package name */
    public final int f20627e;

    public static final class WindowBoundaryInnerSubscriber<T, B> extends DisposableSubscriber<B> {

        /* renamed from: c  reason: collision with root package name */
        public final WindowBoundaryMainSubscriber<T, B> f20628c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f20629d;

        public WindowBoundaryInnerSubscriber(WindowBoundaryMainSubscriber<T, B> windowBoundaryMainSubscriber) {
            this.f20628c = windowBoundaryMainSubscriber;
        }

        public void onComplete() {
            if (!this.f20629d) {
                this.f20629d = true;
                this.f20628c.b();
            }
        }

        public void onError(Throwable th2) {
            if (this.f20629d) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f20629d = true;
            this.f20628c.c(th2);
        }

        public void onNext(B b11) {
            if (!this.f20629d) {
                this.f20628c.d();
            }
        }
    }

    public static final class WindowBoundaryMainSubscriber<T, B> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {

        /* renamed from: n  reason: collision with root package name */
        public static final Object f20630n = new Object();
        private static final long serialVersionUID = 2233020065421370272L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super Flowable<T>> f20631b;

        /* renamed from: c  reason: collision with root package name */
        public final int f20632c;

        /* renamed from: d  reason: collision with root package name */
        public final WindowBoundaryInnerSubscriber<T, B> f20633d = new WindowBoundaryInnerSubscriber<>(this);

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReference<Subscription> f20634e = new AtomicReference<>();

        /* renamed from: f  reason: collision with root package name */
        public final AtomicInteger f20635f = new AtomicInteger(1);

        /* renamed from: g  reason: collision with root package name */
        public final MpscLinkedQueue<Object> f20636g = new MpscLinkedQueue<>();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicThrowable f20637h = new AtomicThrowable();

        /* renamed from: i  reason: collision with root package name */
        public final AtomicBoolean f20638i = new AtomicBoolean();

        /* renamed from: j  reason: collision with root package name */
        public final AtomicLong f20639j = new AtomicLong();

        /* renamed from: k  reason: collision with root package name */
        public volatile boolean f20640k;

        /* renamed from: l  reason: collision with root package name */
        public UnicastProcessor<T> f20641l;

        /* renamed from: m  reason: collision with root package name */
        public long f20642m;

        public WindowBoundaryMainSubscriber(Subscriber<? super Flowable<T>> subscriber, int i11) {
            this.f20631b = subscriber;
            this.f20632c = i11;
        }

        public void a() {
            boolean z11;
            if (getAndIncrement() == 0) {
                Subscriber<? super Flowable<T>> subscriber = this.f20631b;
                MpscLinkedQueue<Object> mpscLinkedQueue = this.f20636g;
                AtomicThrowable atomicThrowable = this.f20637h;
                long j11 = this.f20642m;
                int i11 = 1;
                while (this.f20635f.get() != 0) {
                    UnicastProcessor<T> unicastProcessor = this.f20641l;
                    boolean z12 = this.f20640k;
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
                                    this.f20641l = null;
                                    unicastProcessor.onComplete();
                                }
                                subscriber.onComplete();
                                return;
                            }
                            if (unicastProcessor != null) {
                                this.f20641l = null;
                                unicastProcessor.onError(terminate);
                            }
                            subscriber.onError(terminate);
                            return;
                        } else if (z11) {
                            this.f20642m = j11;
                            i11 = addAndGet(-i11);
                            if (i11 == 0) {
                                return;
                            }
                        } else if (poll != f20630n) {
                            unicastProcessor.onNext(poll);
                        } else {
                            if (unicastProcessor != null) {
                                this.f20641l = null;
                                unicastProcessor.onComplete();
                            }
                            if (!this.f20638i.get()) {
                                UnicastProcessor<T> create = UnicastProcessor.create(this.f20632c, this);
                                this.f20641l = create;
                                this.f20635f.getAndIncrement();
                                if (j11 != this.f20639j.get()) {
                                    j11++;
                                    FlowableWindowSubscribeIntercept flowableWindowSubscribeIntercept = new FlowableWindowSubscribeIntercept(create);
                                    subscriber.onNext(flowableWindowSubscribeIntercept);
                                    if (flowableWindowSubscribeIntercept.b()) {
                                        create.onComplete();
                                    }
                                } else {
                                    SubscriptionHelper.cancel(this.f20634e);
                                    this.f20633d.dispose();
                                    atomicThrowable.tryAddThrowableOrReport(new MissingBackpressureException("Could not deliver a window due to lack of requests"));
                                    this.f20640k = true;
                                }
                            }
                        }
                    } else {
                        mpscLinkedQueue.clear();
                        Throwable terminate2 = atomicThrowable.terminate();
                        if (unicastProcessor != null) {
                            this.f20641l = null;
                            unicastProcessor.onError(terminate2);
                        }
                        subscriber.onError(terminate2);
                        return;
                    }
                }
                mpscLinkedQueue.clear();
                this.f20641l = null;
            }
        }

        public void b() {
            SubscriptionHelper.cancel(this.f20634e);
            this.f20640k = true;
            a();
        }

        public void c(Throwable th2) {
            SubscriptionHelper.cancel(this.f20634e);
            if (this.f20637h.tryAddThrowableOrReport(th2)) {
                this.f20640k = true;
                a();
            }
        }

        public void cancel() {
            if (this.f20638i.compareAndSet(false, true)) {
                this.f20633d.dispose();
                if (this.f20635f.decrementAndGet() == 0) {
                    SubscriptionHelper.cancel(this.f20634e);
                }
            }
        }

        public void d() {
            this.f20636g.offer(f20630n);
            a();
        }

        public void onComplete() {
            this.f20633d.dispose();
            this.f20640k = true;
            a();
        }

        public void onError(Throwable th2) {
            this.f20633d.dispose();
            if (this.f20637h.tryAddThrowableOrReport(th2)) {
                this.f20640k = true;
                a();
            }
        }

        public void onNext(T t11) {
            this.f20636g.offer(t11);
            a();
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this.f20634e, subscription, Long.MAX_VALUE);
        }

        public void request(long j11) {
            BackpressureHelper.add(this.f20639j, j11);
        }

        public void run() {
            if (this.f20635f.decrementAndGet() == 0) {
                SubscriptionHelper.cancel(this.f20634e);
            }
        }
    }

    public FlowableWindowBoundary(Flowable<T> flowable, Publisher<B> publisher, int i11) {
        super(flowable);
        this.f20626d = publisher;
        this.f20627e = i11;
    }

    public void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        WindowBoundaryMainSubscriber windowBoundaryMainSubscriber = new WindowBoundaryMainSubscriber(subscriber, this.f20627e);
        subscriber.onSubscribe(windowBoundaryMainSubscriber);
        windowBoundaryMainSubscriber.d();
        this.f20626d.subscribe(windowBoundaryMainSubscriber.f20633d);
        this.f19260c.subscribe(windowBoundaryMainSubscriber);
    }
}
