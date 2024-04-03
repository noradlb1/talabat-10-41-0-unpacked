package io.reactivex.rxjava3.internal.operators.flowable;

import i.b;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFlatMapMaybe<T, R> extends AbstractFlowableWithUpstream<T, R> {

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends MaybeSource<? extends R>> f19762d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f19763e;

    /* renamed from: f  reason: collision with root package name */
    public final int f19764f;

    public static final class FlatMapMaybeSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 8600231336733376951L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f19765b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f19766c;

        /* renamed from: d  reason: collision with root package name */
        public final int f19767d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicLong f19768e = new AtomicLong();

        /* renamed from: f  reason: collision with root package name */
        public final CompositeDisposable f19769f = new CompositeDisposable();

        /* renamed from: g  reason: collision with root package name */
        public final AtomicInteger f19770g = new AtomicInteger(1);

        /* renamed from: h  reason: collision with root package name */
        public final AtomicThrowable f19771h = new AtomicThrowable();

        /* renamed from: i  reason: collision with root package name */
        public final Function<? super T, ? extends MaybeSource<? extends R>> f19772i;

        /* renamed from: j  reason: collision with root package name */
        public final AtomicReference<SpscLinkedArrayQueue<R>> f19773j = new AtomicReference<>();

        /* renamed from: k  reason: collision with root package name */
        public Subscription f19774k;

        /* renamed from: l  reason: collision with root package name */
        public volatile boolean f19775l;

        public final class InnerObserver extends AtomicReference<Disposable> implements MaybeObserver<R>, Disposable {
            private static final long serialVersionUID = -502562646270949838L;

            public InnerObserver() {
            }

            public void dispose() {
                DisposableHelper.dispose(this);
            }

            public boolean isDisposed() {
                return DisposableHelper.isDisposed((Disposable) get());
            }

            public void onComplete() {
                FlatMapMaybeSubscriber.this.f(this);
            }

            public void onError(Throwable th2) {
                FlatMapMaybeSubscriber.this.g(this, th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public void onSuccess(R r11) {
                FlatMapMaybeSubscriber.this.h(this, r11);
            }
        }

        public FlatMapMaybeSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z11, int i11) {
            this.f19765b = subscriber;
            this.f19772i = function;
            this.f19766c = z11;
            this.f19767d = i11;
        }

        public static boolean a(boolean z11, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            return z11 && (spscLinkedArrayQueue == null || spscLinkedArrayQueue.isEmpty());
        }

        public void b() {
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f19773j.get();
            if (spscLinkedArrayQueue != null) {
                spscLinkedArrayQueue.clear();
            }
        }

        public void c() {
            if (getAndIncrement() == 0) {
                d();
            }
        }

        public void cancel() {
            this.f19775l = true;
            this.f19774k.cancel();
            this.f19769f.dispose();
            this.f19771h.tryTerminateAndReport();
        }

        public void d() {
            int i11;
            boolean z11;
            boolean z12;
            boolean z13;
            Object obj;
            boolean z14;
            Subscriber<? super R> subscriber = this.f19765b;
            AtomicInteger atomicInteger = this.f19770g;
            AtomicReference<SpscLinkedArrayQueue<R>> atomicReference = this.f19773j;
            int i12 = 1;
            do {
                long j11 = this.f19768e.get();
                long j12 = 0;
                while (true) {
                    i11 = (j12 > j11 ? 1 : (j12 == j11 ? 0 : -1));
                    z11 = false;
                    if (i11 == 0) {
                        break;
                    } else if (this.f19775l) {
                        b();
                        return;
                    } else if (this.f19766c || ((Throwable) this.f19771h.get()) == null) {
                        if (atomicInteger.get() == 0) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        SpscLinkedArrayQueue spscLinkedArrayQueue = atomicReference.get();
                        if (spscLinkedArrayQueue != null) {
                            obj = spscLinkedArrayQueue.poll();
                        } else {
                            obj = null;
                        }
                        if (obj == null) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        if (z13 && z14) {
                            this.f19771h.tryTerminateConsumer((Subscriber<?>) subscriber);
                            return;
                        } else if (z14) {
                            break;
                        } else {
                            subscriber.onNext(obj);
                            j12++;
                        }
                    } else {
                        b();
                        this.f19771h.tryTerminateConsumer((Subscriber<?>) subscriber);
                        return;
                    }
                }
                if (i11 == 0) {
                    if (this.f19775l) {
                        b();
                        return;
                    } else if (this.f19766c || ((Throwable) this.f19771h.get()) == null) {
                        if (atomicInteger.get() == 0) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        SpscLinkedArrayQueue spscLinkedArrayQueue2 = atomicReference.get();
                        if (spscLinkedArrayQueue2 == null || spscLinkedArrayQueue2.isEmpty()) {
                            z11 = true;
                        }
                        if (z12 && z11) {
                            this.f19771h.tryTerminateConsumer((Subscriber<?>) subscriber);
                            return;
                        }
                    } else {
                        b();
                        this.f19771h.tryTerminateConsumer((Subscriber<?>) subscriber);
                        return;
                    }
                }
                if (j12 != 0) {
                    BackpressureHelper.produced(this.f19768e, j12);
                    if (this.f19767d != Integer.MAX_VALUE) {
                        this.f19774k.request(j12);
                    }
                }
                i12 = addAndGet(-i12);
            } while (i12 != 0);
        }

        public SpscLinkedArrayQueue<R> e() {
            SpscLinkedArrayQueue<R> spscLinkedArrayQueue = this.f19773j.get();
            if (spscLinkedArrayQueue != null) {
                return spscLinkedArrayQueue;
            }
            SpscLinkedArrayQueue<R> spscLinkedArrayQueue2 = new SpscLinkedArrayQueue<>(Flowable.bufferSize());
            if (b.a(this.f19773j, (Object) null, spscLinkedArrayQueue2)) {
                return spscLinkedArrayQueue2;
            }
            return this.f19773j.get();
        }

        public void f(FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver) {
            this.f19769f.delete(innerObserver);
            if (get() == 0) {
                boolean z11 = false;
                if (compareAndSet(0, 1)) {
                    if (this.f19770g.decrementAndGet() == 0) {
                        z11 = true;
                    }
                    if (a(z11, this.f19773j.get())) {
                        this.f19771h.tryTerminateConsumer((Subscriber<?>) this.f19765b);
                        return;
                    }
                    if (this.f19767d != Integer.MAX_VALUE) {
                        this.f19774k.request(1);
                    }
                    if (decrementAndGet() != 0) {
                        d();
                        return;
                    }
                    return;
                }
            }
            this.f19770g.decrementAndGet();
            if (this.f19767d != Integer.MAX_VALUE) {
                this.f19774k.request(1);
            }
            c();
        }

        public void g(FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver, Throwable th2) {
            this.f19769f.delete(innerObserver);
            if (this.f19771h.tryAddThrowableOrReport(th2)) {
                if (!this.f19766c) {
                    this.f19774k.cancel();
                    this.f19769f.dispose();
                } else if (this.f19767d != Integer.MAX_VALUE) {
                    this.f19774k.request(1);
                }
                this.f19770g.decrementAndGet();
                c();
            }
        }

        public void h(FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver, R r11) {
            this.f19769f.delete(innerObserver);
            if (get() == 0) {
                boolean z11 = false;
                if (compareAndSet(0, 1)) {
                    if (this.f19770g.decrementAndGet() == 0) {
                        z11 = true;
                    }
                    if (this.f19768e.get() != 0) {
                        this.f19765b.onNext(r11);
                        if (a(z11, this.f19773j.get())) {
                            this.f19771h.tryTerminateConsumer((Subscriber<?>) this.f19765b);
                            return;
                        }
                        BackpressureHelper.produced(this.f19768e, 1);
                        if (this.f19767d != Integer.MAX_VALUE) {
                            this.f19774k.request(1);
                        }
                    } else {
                        SpscLinkedArrayQueue e11 = e();
                        synchronized (e11) {
                            e11.offer(r11);
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                    d();
                }
            }
            SpscLinkedArrayQueue e12 = e();
            synchronized (e12) {
                e12.offer(r11);
            }
            this.f19770g.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            d();
        }

        public void onComplete() {
            this.f19770g.decrementAndGet();
            c();
        }

        public void onError(Throwable th2) {
            this.f19770g.decrementAndGet();
            if (this.f19771h.tryAddThrowableOrReport(th2)) {
                if (!this.f19766c) {
                    this.f19769f.dispose();
                }
                c();
            }
        }

        public void onNext(T t11) {
            try {
                Object apply = this.f19772i.apply(t11);
                Objects.requireNonNull(apply, "The mapper returned a null MaybeSource");
                MaybeSource maybeSource = (MaybeSource) apply;
                this.f19770g.getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.f19775l && this.f19769f.add(innerObserver)) {
                    maybeSource.subscribe(innerObserver);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f19774k.cancel();
                onError(th2);
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f19774k, subscription)) {
                this.f19774k = subscription;
                this.f19765b.onSubscribe(this);
                int i11 = this.f19767d;
                if (i11 == Integer.MAX_VALUE) {
                    subscription.request(Long.MAX_VALUE);
                } else {
                    subscription.request((long) i11);
                }
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f19768e, j11);
                c();
            }
        }
    }

    public FlowableFlatMapMaybe(Flowable<T> flowable, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z11, int i11) {
        super(flowable);
        this.f19762d = function;
        this.f19763e = z11;
        this.f19764f = i11;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f19260c.subscribe(new FlatMapMaybeSubscriber(subscriber, this.f19762d, this.f19763e, this.f19764f));
    }
}
