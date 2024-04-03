package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.operators.SimplePlainQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWindowBoundarySelector<T, B, V> extends AbstractFlowableWithUpstream<T, Flowable<T>> {

    /* renamed from: d  reason: collision with root package name */
    public final Publisher<B> f20643d;

    /* renamed from: e  reason: collision with root package name */
    public final Function<? super B, ? extends Publisher<V>> f20644e;

    /* renamed from: f  reason: collision with root package name */
    public final int f20645f;

    public static final class WindowBoundaryMainSubscriber<T, B, V> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = 8646217640096099753L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super Flowable<T>> f20646b;

        /* renamed from: c  reason: collision with root package name */
        public final Publisher<B> f20647c;

        /* renamed from: d  reason: collision with root package name */
        public final Function<? super B, ? extends Publisher<V>> f20648d;

        /* renamed from: e  reason: collision with root package name */
        public final int f20649e;

        /* renamed from: f  reason: collision with root package name */
        public final CompositeDisposable f20650f;

        /* renamed from: g  reason: collision with root package name */
        public final WindowStartSubscriber<B> f20651g;

        /* renamed from: h  reason: collision with root package name */
        public final List<UnicastProcessor<T>> f20652h;

        /* renamed from: i  reason: collision with root package name */
        public final SimplePlainQueue<Object> f20653i = new MpscLinkedQueue();

        /* renamed from: j  reason: collision with root package name */
        public final AtomicLong f20654j;

        /* renamed from: k  reason: collision with root package name */
        public final AtomicBoolean f20655k;

        /* renamed from: l  reason: collision with root package name */
        public final AtomicLong f20656l;

        /* renamed from: m  reason: collision with root package name */
        public long f20657m;

        /* renamed from: n  reason: collision with root package name */
        public volatile boolean f20658n;

        /* renamed from: o  reason: collision with root package name */
        public volatile boolean f20659o;

        /* renamed from: p  reason: collision with root package name */
        public volatile boolean f20660p;

        /* renamed from: q  reason: collision with root package name */
        public final AtomicThrowable f20661q;

        /* renamed from: r  reason: collision with root package name */
        public Subscription f20662r;

        public static final class WindowEndSubscriberIntercept<T, V> extends Flowable<T> implements FlowableSubscriber<V>, Disposable {

            /* renamed from: c  reason: collision with root package name */
            public final WindowBoundaryMainSubscriber<T, ?, V> f20663c;

            /* renamed from: d  reason: collision with root package name */
            public final UnicastProcessor<T> f20664d;

            /* renamed from: e  reason: collision with root package name */
            public final AtomicReference<Subscription> f20665e = new AtomicReference<>();

            /* renamed from: f  reason: collision with root package name */
            public final AtomicBoolean f20666f = new AtomicBoolean();

            public WindowEndSubscriberIntercept(WindowBoundaryMainSubscriber<T, ?, V> windowBoundaryMainSubscriber, UnicastProcessor<T> unicastProcessor) {
                this.f20663c = windowBoundaryMainSubscriber;
                this.f20664d = unicastProcessor;
            }

            public boolean b() {
                return !this.f20666f.get() && this.f20666f.compareAndSet(false, true);
            }

            public void dispose() {
                SubscriptionHelper.cancel(this.f20665e);
            }

            public boolean isDisposed() {
                return this.f20665e.get() == SubscriptionHelper.CANCELLED;
            }

            public void onComplete() {
                this.f20663c.a(this);
            }

            public void onError(Throwable th2) {
                if (isDisposed()) {
                    RxJavaPlugins.onError(th2);
                } else {
                    this.f20663c.b(th2);
                }
            }

            public void onNext(V v11) {
                if (SubscriptionHelper.cancel(this.f20665e)) {
                    this.f20663c.a(this);
                }
            }

            public void onSubscribe(Subscription subscription) {
                if (SubscriptionHelper.setOnce(this.f20665e, subscription)) {
                    subscription.request(Long.MAX_VALUE);
                }
            }

            public void subscribeActual(Subscriber<? super T> subscriber) {
                this.f20664d.subscribe(subscriber);
                this.f20666f.set(true);
            }
        }

        public static final class WindowStartItem<B> {

            /* renamed from: a  reason: collision with root package name */
            public final B f20667a;

            public WindowStartItem(B b11) {
                this.f20667a = b11;
            }
        }

        public static final class WindowStartSubscriber<B> extends AtomicReference<Subscription> implements FlowableSubscriber<B> {
            private static final long serialVersionUID = -3326496781427702834L;

            /* renamed from: b  reason: collision with root package name */
            public final WindowBoundaryMainSubscriber<?, B, ?> f20668b;

            public WindowStartSubscriber(WindowBoundaryMainSubscriber<?, B, ?> windowBoundaryMainSubscriber) {
                this.f20668b = windowBoundaryMainSubscriber;
            }

            public void a() {
                SubscriptionHelper.cancel(this);
            }

            public void onComplete() {
                this.f20668b.e();
            }

            public void onError(Throwable th2) {
                this.f20668b.f(th2);
            }

            public void onNext(B b11) {
                this.f20668b.d(b11);
            }

            public void onSubscribe(Subscription subscription) {
                if (SubscriptionHelper.setOnce(this, subscription)) {
                    subscription.request(Long.MAX_VALUE);
                }
            }
        }

        public WindowBoundaryMainSubscriber(Subscriber<? super Flowable<T>> subscriber, Publisher<B> publisher, Function<? super B, ? extends Publisher<V>> function, int i11) {
            this.f20646b = subscriber;
            this.f20647c = publisher;
            this.f20648d = function;
            this.f20649e = i11;
            this.f20650f = new CompositeDisposable();
            this.f20652h = new ArrayList();
            this.f20654j = new AtomicLong(1);
            this.f20655k = new AtomicBoolean();
            this.f20661q = new AtomicThrowable();
            this.f20651g = new WindowStartSubscriber<>(this);
            this.f20656l = new AtomicLong();
        }

        public void a(WindowEndSubscriberIntercept<T, V> windowEndSubscriberIntercept) {
            this.f20653i.offer(windowEndSubscriberIntercept);
            c();
        }

        public void b(Throwable th2) {
            this.f20662r.cancel();
            this.f20651g.a();
            this.f20650f.dispose();
            if (this.f20661q.tryAddThrowableOrReport(th2)) {
                this.f20659o = true;
                c();
            }
        }

        public void c() {
            boolean z11;
            if (getAndIncrement() == 0) {
                Subscriber<? super Flowable<T>> subscriber = this.f20646b;
                SimplePlainQueue<Object> simplePlainQueue = this.f20653i;
                List<UnicastProcessor<T>> list = this.f20652h;
                int i11 = 1;
                while (true) {
                    if (this.f20658n) {
                        simplePlainQueue.clear();
                        list.clear();
                    } else {
                        boolean z12 = this.f20659o;
                        Object poll = simplePlainQueue.poll();
                        if (poll == null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z12 && (z11 || this.f20661q.get() != null)) {
                            g(subscriber);
                            this.f20658n = true;
                        } else if (!z11) {
                            if (poll instanceof WindowStartItem) {
                                if (!this.f20655k.get()) {
                                    long j11 = this.f20657m;
                                    if (this.f20656l.get() != j11) {
                                        this.f20657m = j11 + 1;
                                        try {
                                            Object apply = this.f20648d.apply(((WindowStartItem) poll).f20667a);
                                            Objects.requireNonNull(apply, "The closingIndicator returned a null Publisher");
                                            Publisher publisher = (Publisher) apply;
                                            this.f20654j.getAndIncrement();
                                            UnicastProcessor create = UnicastProcessor.create(this.f20649e, this);
                                            WindowEndSubscriberIntercept windowEndSubscriberIntercept = new WindowEndSubscriberIntercept(this, create);
                                            subscriber.onNext(windowEndSubscriberIntercept);
                                            if (windowEndSubscriberIntercept.b()) {
                                                create.onComplete();
                                            } else {
                                                list.add(create);
                                                this.f20650f.add(windowEndSubscriberIntercept);
                                                publisher.subscribe(windowEndSubscriberIntercept);
                                            }
                                        } catch (Throwable th2) {
                                            Exceptions.throwIfFatal(th2);
                                            this.f20662r.cancel();
                                            this.f20651g.a();
                                            this.f20650f.dispose();
                                            Exceptions.throwIfFatal(th2);
                                            this.f20661q.tryAddThrowableOrReport(th2);
                                            this.f20659o = true;
                                        }
                                    } else {
                                        this.f20662r.cancel();
                                        this.f20651g.a();
                                        this.f20650f.dispose();
                                        this.f20661q.tryAddThrowableOrReport(new MissingBackpressureException(FlowableWindowTimed.b(j11)));
                                        this.f20659o = true;
                                    }
                                }
                            } else if (poll instanceof WindowEndSubscriberIntercept) {
                                UnicastProcessor<T> unicastProcessor = ((WindowEndSubscriberIntercept) poll).f20664d;
                                list.remove(unicastProcessor);
                                this.f20650f.delete((Disposable) poll);
                                unicastProcessor.onComplete();
                            } else {
                                for (UnicastProcessor<T> onNext : list) {
                                    onNext.onNext(poll);
                                }
                            }
                        } else if (this.f20660p && list.size() == 0) {
                            this.f20662r.cancel();
                            this.f20651g.a();
                            this.f20650f.dispose();
                            g(subscriber);
                            this.f20658n = true;
                        }
                    }
                    i11 = addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                }
            }
        }

        public void cancel() {
            if (!this.f20655k.compareAndSet(false, true)) {
                return;
            }
            if (this.f20654j.decrementAndGet() == 0) {
                this.f20662r.cancel();
                this.f20651g.a();
                this.f20650f.dispose();
                this.f20661q.tryTerminateAndReport();
                this.f20658n = true;
                c();
                return;
            }
            this.f20651g.a();
        }

        public void d(B b11) {
            this.f20653i.offer(new WindowStartItem(b11));
            c();
        }

        public void e() {
            this.f20660p = true;
            c();
        }

        public void f(Throwable th2) {
            this.f20662r.cancel();
            this.f20650f.dispose();
            if (this.f20661q.tryAddThrowableOrReport(th2)) {
                this.f20659o = true;
                c();
            }
        }

        public void g(Subscriber<?> subscriber) {
            Throwable terminate = this.f20661q.terminate();
            if (terminate == null) {
                for (UnicastProcessor<T> onComplete : this.f20652h) {
                    onComplete.onComplete();
                }
                subscriber.onComplete();
            } else if (terminate != ExceptionHelper.TERMINATED) {
                for (UnicastProcessor<T> onError : this.f20652h) {
                    onError.onError(terminate);
                }
                subscriber.onError(terminate);
            }
        }

        public void onComplete() {
            this.f20651g.a();
            this.f20650f.dispose();
            this.f20659o = true;
            c();
        }

        public void onError(Throwable th2) {
            this.f20651g.a();
            this.f20650f.dispose();
            if (this.f20661q.tryAddThrowableOrReport(th2)) {
                this.f20659o = true;
                c();
            }
        }

        public void onNext(T t11) {
            this.f20653i.offer(t11);
            c();
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f20662r, subscription)) {
                this.f20662r = subscription;
                this.f20646b.onSubscribe(this);
                this.f20647c.subscribe(this.f20651g);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f20656l, j11);
            }
        }

        public void run() {
            if (this.f20654j.decrementAndGet() == 0) {
                this.f20662r.cancel();
                this.f20651g.a();
                this.f20650f.dispose();
                this.f20661q.tryTerminateAndReport();
                this.f20658n = true;
                c();
            }
        }
    }

    public FlowableWindowBoundarySelector(Flowable<T> flowable, Publisher<B> publisher, Function<? super B, ? extends Publisher<V>> function, int i11) {
        super(flowable);
        this.f20643d = publisher;
        this.f20644e = function;
        this.f20645f = i11;
    }

    public void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        this.f19260c.subscribe(new WindowBoundaryMainSubscriber(subscriber, this.f20643d, this.f20644e, this.f20645f));
    }
}
