package io.reactivex.internal.operators.flowable;

import i.b;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.DisposableSubscriber;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWindowBoundarySupplier<T, B> extends AbstractFlowableWithUpstream<T, Flowable<T>> {

    /* renamed from: d  reason: collision with root package name */
    public final Callable<? extends Publisher<B>> f16153d;

    /* renamed from: e  reason: collision with root package name */
    public final int f16154e;

    public static final class WindowBoundaryInnerSubscriber<T, B> extends DisposableSubscriber<B> {

        /* renamed from: c  reason: collision with root package name */
        public final WindowBoundaryMainSubscriber<T, B> f16155c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f16156d;

        public WindowBoundaryInnerSubscriber(WindowBoundaryMainSubscriber<T, B> windowBoundaryMainSubscriber) {
            this.f16155c = windowBoundaryMainSubscriber;
        }

        public void onComplete() {
            if (!this.f16156d) {
                this.f16156d = true;
                this.f16155c.c();
            }
        }

        public void onError(Throwable th2) {
            if (this.f16156d) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f16156d = true;
            this.f16155c.d(th2);
        }

        public void onNext(B b11) {
            if (!this.f16156d) {
                this.f16156d = true;
                dispose();
                this.f16155c.e(this);
            }
        }
    }

    public static final class WindowBoundaryMainSubscriber<T, B> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {

        /* renamed from: o  reason: collision with root package name */
        public static final WindowBoundaryInnerSubscriber<Object, Object> f16157o = new WindowBoundaryInnerSubscriber<>((WindowBoundaryMainSubscriber) null);

        /* renamed from: p  reason: collision with root package name */
        public static final Object f16158p = new Object();
        private static final long serialVersionUID = 2233020065421370272L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super Flowable<T>> f16159b;

        /* renamed from: c  reason: collision with root package name */
        public final int f16160c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReference<WindowBoundaryInnerSubscriber<T, B>> f16161d = new AtomicReference<>();

        /* renamed from: e  reason: collision with root package name */
        public final AtomicInteger f16162e = new AtomicInteger(1);

        /* renamed from: f  reason: collision with root package name */
        public final MpscLinkedQueue<Object> f16163f = new MpscLinkedQueue<>();

        /* renamed from: g  reason: collision with root package name */
        public final AtomicThrowable f16164g = new AtomicThrowable();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicBoolean f16165h = new AtomicBoolean();

        /* renamed from: i  reason: collision with root package name */
        public final Callable<? extends Publisher<B>> f16166i;

        /* renamed from: j  reason: collision with root package name */
        public final AtomicLong f16167j;

        /* renamed from: k  reason: collision with root package name */
        public Subscription f16168k;

        /* renamed from: l  reason: collision with root package name */
        public volatile boolean f16169l;

        /* renamed from: m  reason: collision with root package name */
        public UnicastProcessor<T> f16170m;

        /* renamed from: n  reason: collision with root package name */
        public long f16171n;

        public WindowBoundaryMainSubscriber(Subscriber<? super Flowable<T>> subscriber, int i11, Callable<? extends Publisher<B>> callable) {
            this.f16159b = subscriber;
            this.f16160c = i11;
            this.f16166i = callable;
            this.f16167j = new AtomicLong();
        }

        public void a() {
            AtomicReference<WindowBoundaryInnerSubscriber<T, B>> atomicReference = this.f16161d;
            WindowBoundaryInnerSubscriber<Object, Object> windowBoundaryInnerSubscriber = f16157o;
            Disposable andSet = atomicReference.getAndSet(windowBoundaryInnerSubscriber);
            if (andSet != null && andSet != windowBoundaryInnerSubscriber) {
                andSet.dispose();
            }
        }

        public void b() {
            boolean z11;
            if (getAndIncrement() == 0) {
                Subscriber<? super Flowable<T>> subscriber = this.f16159b;
                MpscLinkedQueue<Object> mpscLinkedQueue = this.f16163f;
                AtomicThrowable atomicThrowable = this.f16164g;
                long j11 = this.f16171n;
                int i11 = 1;
                while (this.f16162e.get() != 0) {
                    UnicastProcessor<T> unicastProcessor = this.f16170m;
                    boolean z12 = this.f16169l;
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
                                    this.f16170m = null;
                                    unicastProcessor.onComplete();
                                }
                                subscriber.onComplete();
                                return;
                            }
                            if (unicastProcessor != null) {
                                this.f16170m = null;
                                unicastProcessor.onError(terminate);
                            }
                            subscriber.onError(terminate);
                            return;
                        } else if (z11) {
                            this.f16171n = j11;
                            i11 = addAndGet(-i11);
                            if (i11 == 0) {
                                return;
                            }
                        } else if (poll != f16158p) {
                            unicastProcessor.onNext(poll);
                        } else {
                            if (unicastProcessor != null) {
                                this.f16170m = null;
                                unicastProcessor.onComplete();
                            }
                            if (!this.f16165h.get()) {
                                if (j11 != this.f16167j.get()) {
                                    UnicastProcessor<T> create = UnicastProcessor.create(this.f16160c, this);
                                    this.f16170m = create;
                                    this.f16162e.getAndIncrement();
                                    try {
                                        Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.f16166i.call(), "The other Callable returned a null Publisher");
                                        WindowBoundaryInnerSubscriber windowBoundaryInnerSubscriber = new WindowBoundaryInnerSubscriber(this);
                                        if (b.a(this.f16161d, (Object) null, windowBoundaryInnerSubscriber)) {
                                            publisher.subscribe(windowBoundaryInnerSubscriber);
                                            j11++;
                                            subscriber.onNext(create);
                                        }
                                    } catch (Throwable th2) {
                                        Exceptions.throwIfFatal(th2);
                                        atomicThrowable.addThrowable(th2);
                                        this.f16169l = true;
                                    }
                                } else {
                                    this.f16168k.cancel();
                                    a();
                                    atomicThrowable.addThrowable(new MissingBackpressureException("Could not deliver a window due to lack of requests"));
                                    this.f16169l = true;
                                }
                            }
                        }
                    } else {
                        mpscLinkedQueue.clear();
                        Throwable terminate2 = atomicThrowable.terminate();
                        if (unicastProcessor != null) {
                            this.f16170m = null;
                            unicastProcessor.onError(terminate2);
                        }
                        subscriber.onError(terminate2);
                        return;
                    }
                }
                mpscLinkedQueue.clear();
                this.f16170m = null;
            }
        }

        public void c() {
            this.f16168k.cancel();
            this.f16169l = true;
            b();
        }

        public void cancel() {
            if (this.f16165h.compareAndSet(false, true)) {
                a();
                if (this.f16162e.decrementAndGet() == 0) {
                    this.f16168k.cancel();
                }
            }
        }

        public void d(Throwable th2) {
            this.f16168k.cancel();
            if (this.f16164g.addThrowable(th2)) {
                this.f16169l = true;
                b();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void e(WindowBoundaryInnerSubscriber<T, B> windowBoundaryInnerSubscriber) {
            b.a(this.f16161d, windowBoundaryInnerSubscriber, (Object) null);
            this.f16163f.offer(f16158p);
            b();
        }

        public void onComplete() {
            a();
            this.f16169l = true;
            b();
        }

        public void onError(Throwable th2) {
            a();
            if (this.f16164g.addThrowable(th2)) {
                this.f16169l = true;
                b();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            this.f16163f.offer(t11);
            b();
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f16168k, subscription)) {
                this.f16168k = subscription;
                this.f16159b.onSubscribe(this);
                this.f16163f.offer(f16158p);
                b();
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void request(long j11) {
            BackpressureHelper.add(this.f16167j, j11);
        }

        public void run() {
            if (this.f16162e.decrementAndGet() == 0) {
                this.f16168k.cancel();
            }
        }
    }

    public FlowableWindowBoundarySupplier(Flowable<T> flowable, Callable<? extends Publisher<B>> callable, int i11) {
        super(flowable);
        this.f16153d = callable;
        this.f16154e = i11;
    }

    public void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        this.f14763c.subscribe(new WindowBoundaryMainSubscriber(subscriber, this.f16154e, this.f16153d));
    }
}
