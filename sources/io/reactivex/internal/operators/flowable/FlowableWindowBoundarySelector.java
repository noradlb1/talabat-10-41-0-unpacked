package io.reactivex.internal.operators.flowable;

import i.b;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.DisposableSubscriber;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWindowBoundarySelector<T, B, V> extends AbstractFlowableWithUpstream<T, Flowable<T>> {

    /* renamed from: d  reason: collision with root package name */
    public final Publisher<B> f16135d;

    /* renamed from: e  reason: collision with root package name */
    public final Function<? super B, ? extends Publisher<V>> f16136e;

    /* renamed from: f  reason: collision with root package name */
    public final int f16137f;

    public static final class OperatorWindowBoundaryCloseSubscriber<T, V> extends DisposableSubscriber<V> {

        /* renamed from: c  reason: collision with root package name */
        public final WindowBoundaryMainSubscriber<T, ?, V> f16138c;

        /* renamed from: d  reason: collision with root package name */
        public final UnicastProcessor<T> f16139d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f16140e;

        public OperatorWindowBoundaryCloseSubscriber(WindowBoundaryMainSubscriber<T, ?, V> windowBoundaryMainSubscriber, UnicastProcessor<T> unicastProcessor) {
            this.f16138c = windowBoundaryMainSubscriber;
            this.f16139d = unicastProcessor;
        }

        public void onComplete() {
            if (!this.f16140e) {
                this.f16140e = true;
                this.f16138c.c(this);
            }
        }

        public void onError(Throwable th2) {
            if (this.f16140e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f16140e = true;
            this.f16138c.e(th2);
        }

        public void onNext(V v11) {
            a();
            onComplete();
        }
    }

    public static final class OperatorWindowBoundaryOpenSubscriber<T, B> extends DisposableSubscriber<B> {

        /* renamed from: c  reason: collision with root package name */
        public final WindowBoundaryMainSubscriber<T, B, ?> f16141c;

        public OperatorWindowBoundaryOpenSubscriber(WindowBoundaryMainSubscriber<T, B, ?> windowBoundaryMainSubscriber) {
            this.f16141c = windowBoundaryMainSubscriber;
        }

        public void onComplete() {
            this.f16141c.onComplete();
        }

        public void onError(Throwable th2) {
            this.f16141c.e(th2);
        }

        public void onNext(B b11) {
            this.f16141c.f(b11);
        }
    }

    public static final class WindowBoundaryMainSubscriber<T, B, V> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements Subscription {

        /* renamed from: i  reason: collision with root package name */
        public final Publisher<B> f16142i;

        /* renamed from: j  reason: collision with root package name */
        public final Function<? super B, ? extends Publisher<V>> f16143j;

        /* renamed from: k  reason: collision with root package name */
        public final int f16144k;

        /* renamed from: l  reason: collision with root package name */
        public final CompositeDisposable f16145l;

        /* renamed from: m  reason: collision with root package name */
        public Subscription f16146m;

        /* renamed from: n  reason: collision with root package name */
        public final AtomicReference<Disposable> f16147n = new AtomicReference<>();

        /* renamed from: o  reason: collision with root package name */
        public final List<UnicastProcessor<T>> f16148o;

        /* renamed from: p  reason: collision with root package name */
        public final AtomicLong f16149p;

        /* renamed from: q  reason: collision with root package name */
        public final AtomicBoolean f16150q;

        public WindowBoundaryMainSubscriber(Subscriber<? super Flowable<T>> subscriber, Publisher<B> publisher, Function<? super B, ? extends Publisher<V>> function, int i11) {
            super(subscriber, new MpscLinkedQueue());
            AtomicLong atomicLong = new AtomicLong();
            this.f16149p = atomicLong;
            this.f16150q = new AtomicBoolean();
            this.f16142i = publisher;
            this.f16143j = function;
            this.f16144k = i11;
            this.f16145l = new CompositeDisposable();
            this.f16148o = new ArrayList();
            atomicLong.lazySet(1);
        }

        public boolean accept(Subscriber<? super Flowable<T>> subscriber, Object obj) {
            return false;
        }

        public void c(OperatorWindowBoundaryCloseSubscriber<T, V> operatorWindowBoundaryCloseSubscriber) {
            this.f16145l.delete(operatorWindowBoundaryCloseSubscriber);
            this.f18589e.offer(new WindowOperation(operatorWindowBoundaryCloseSubscriber.f16139d, null));
            if (enter()) {
                d();
            }
        }

        public void cancel() {
            if (this.f16150q.compareAndSet(false, true)) {
                DisposableHelper.dispose(this.f16147n);
                if (this.f16149p.decrementAndGet() == 0) {
                    this.f16146m.cancel();
                }
            }
        }

        public void d() {
            boolean z11;
            SimplePlainQueue<U> simplePlainQueue = this.f18589e;
            Subscriber<? super V> subscriber = this.f18588d;
            List<UnicastProcessor<T>> list = this.f16148o;
            int i11 = 1;
            while (true) {
                boolean z12 = this.f18591g;
                U poll = simplePlainQueue.poll();
                if (poll == null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z12 && z11) {
                    dispose();
                    Throwable th2 = this.f18592h;
                    if (th2 != null) {
                        for (UnicastProcessor<T> onError : list) {
                            onError.onError(th2);
                        }
                    } else {
                        for (UnicastProcessor<T> onComplete : list) {
                            onComplete.onComplete();
                        }
                    }
                    list.clear();
                    return;
                } else if (z11) {
                    i11 = leave(-i11);
                    if (i11 == 0) {
                        return;
                    }
                } else if (poll instanceof WindowOperation) {
                    WindowOperation windowOperation = (WindowOperation) poll;
                    UnicastProcessor<T> unicastProcessor = windowOperation.f16151a;
                    if (unicastProcessor != null) {
                        if (list.remove(unicastProcessor)) {
                            windowOperation.f16151a.onComplete();
                            if (this.f16149p.decrementAndGet() == 0) {
                                dispose();
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.f16150q.get()) {
                        UnicastProcessor create = UnicastProcessor.create(this.f16144k);
                        long requested = requested();
                        if (requested != 0) {
                            list.add(create);
                            subscriber.onNext(create);
                            if (requested != Long.MAX_VALUE) {
                                produced(1);
                            }
                            try {
                                Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.f16143j.apply(windowOperation.f16152b), "The publisher supplied is null");
                                OperatorWindowBoundaryCloseSubscriber operatorWindowBoundaryCloseSubscriber = new OperatorWindowBoundaryCloseSubscriber(this, create);
                                if (this.f16145l.add(operatorWindowBoundaryCloseSubscriber)) {
                                    this.f16149p.getAndIncrement();
                                    publisher.subscribe(operatorWindowBoundaryCloseSubscriber);
                                }
                            } catch (Throwable th3) {
                                cancel();
                                subscriber.onError(th3);
                            }
                        } else {
                            cancel();
                            subscriber.onError(new MissingBackpressureException("Could not deliver new window due to lack of requests"));
                        }
                    }
                } else {
                    for (UnicastProcessor<T> onNext : list) {
                        onNext.onNext(NotificationLite.getValue(poll));
                    }
                }
            }
        }

        public void dispose() {
            this.f16145l.dispose();
            DisposableHelper.dispose(this.f16147n);
        }

        public void e(Throwable th2) {
            this.f16146m.cancel();
            this.f16145l.dispose();
            DisposableHelper.dispose(this.f16147n);
            this.f18588d.onError(th2);
        }

        public void f(B b11) {
            this.f18589e.offer(new WindowOperation((UnicastProcessor) null, b11));
            if (enter()) {
                d();
            }
        }

        public void onComplete() {
            if (!this.f18591g) {
                this.f18591g = true;
                if (enter()) {
                    d();
                }
                if (this.f16149p.decrementAndGet() == 0) {
                    this.f16145l.dispose();
                }
                this.f18588d.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f18591g) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f18592h = th2;
            this.f18591g = true;
            if (enter()) {
                d();
            }
            if (this.f16149p.decrementAndGet() == 0) {
                this.f16145l.dispose();
            }
            this.f18588d.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f18591g) {
                if (fastEnter()) {
                    for (UnicastProcessor<T> onNext : this.f16148o) {
                        onNext.onNext(t11);
                    }
                    if (leave(-1) == 0) {
                        return;
                    }
                } else {
                    this.f18589e.offer(NotificationLite.next(t11));
                    if (!enter()) {
                        return;
                    }
                }
                d();
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f16146m, subscription)) {
                this.f16146m = subscription;
                this.f18588d.onSubscribe(this);
                if (!this.f16150q.get()) {
                    OperatorWindowBoundaryOpenSubscriber operatorWindowBoundaryOpenSubscriber = new OperatorWindowBoundaryOpenSubscriber(this);
                    if (b.a(this.f16147n, (Object) null, operatorWindowBoundaryOpenSubscriber)) {
                        subscription.request(Long.MAX_VALUE);
                        this.f16142i.subscribe(operatorWindowBoundaryOpenSubscriber);
                    }
                }
            }
        }

        public void request(long j11) {
            requested(j11);
        }
    }

    public static final class WindowOperation<T, B> {

        /* renamed from: a  reason: collision with root package name */
        public final UnicastProcessor<T> f16151a;

        /* renamed from: b  reason: collision with root package name */
        public final B f16152b;

        public WindowOperation(UnicastProcessor<T> unicastProcessor, B b11) {
            this.f16151a = unicastProcessor;
            this.f16152b = b11;
        }
    }

    public FlowableWindowBoundarySelector(Flowable<T> flowable, Publisher<B> publisher, Function<? super B, ? extends Publisher<V>> function, int i11) {
        super(flowable);
        this.f16135d = publisher;
        this.f16136e = function;
        this.f16137f = i11;
    }

    public void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        this.f14763c.subscribe(new WindowBoundaryMainSubscriber(new SerializedSubscriber(subscriber), this.f16135d, this.f16136e, this.f16137f));
    }
}
