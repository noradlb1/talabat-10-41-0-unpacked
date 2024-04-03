package io.reactivex.rxjava3.internal.operators.flowable;

import i.b;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
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

public final class FlowableFlatMapSingle<T, R> extends AbstractFlowableWithUpstream<T, R> {

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends SingleSource<? extends R>> f19781d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f19782e;

    /* renamed from: f  reason: collision with root package name */
    public final int f19783f;

    public static final class FlatMapSingleSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 8600231336733376951L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f19784b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f19785c;

        /* renamed from: d  reason: collision with root package name */
        public final int f19786d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicLong f19787e = new AtomicLong();

        /* renamed from: f  reason: collision with root package name */
        public final CompositeDisposable f19788f = new CompositeDisposable();

        /* renamed from: g  reason: collision with root package name */
        public final AtomicInteger f19789g = new AtomicInteger(1);

        /* renamed from: h  reason: collision with root package name */
        public final AtomicThrowable f19790h = new AtomicThrowable();

        /* renamed from: i  reason: collision with root package name */
        public final Function<? super T, ? extends SingleSource<? extends R>> f19791i;

        /* renamed from: j  reason: collision with root package name */
        public final AtomicReference<SpscLinkedArrayQueue<R>> f19792j = new AtomicReference<>();

        /* renamed from: k  reason: collision with root package name */
        public Subscription f19793k;

        /* renamed from: l  reason: collision with root package name */
        public volatile boolean f19794l;

        public final class InnerObserver extends AtomicReference<Disposable> implements SingleObserver<R>, Disposable {
            private static final long serialVersionUID = -502562646270949838L;

            public InnerObserver() {
            }

            public void dispose() {
                DisposableHelper.dispose(this);
            }

            public boolean isDisposed() {
                return DisposableHelper.isDisposed((Disposable) get());
            }

            public void onError(Throwable th2) {
                FlatMapSingleSubscriber.this.e(this, th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public void onSuccess(R r11) {
                FlatMapSingleSubscriber.this.f(this, r11);
            }
        }

        public FlatMapSingleSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z11, int i11) {
            this.f19784b = subscriber;
            this.f19791i = function;
            this.f19785c = z11;
            this.f19786d = i11;
        }

        public void a() {
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f19792j.get();
            if (spscLinkedArrayQueue != null) {
                spscLinkedArrayQueue.clear();
            }
        }

        public void b() {
            if (getAndIncrement() == 0) {
                c();
            }
        }

        public void c() {
            int i11;
            boolean z11;
            boolean z12;
            boolean z13;
            Object obj;
            boolean z14;
            Subscriber<? super R> subscriber = this.f19784b;
            AtomicInteger atomicInteger = this.f19789g;
            AtomicReference<SpscLinkedArrayQueue<R>> atomicReference = this.f19792j;
            int i12 = 1;
            do {
                long j11 = this.f19787e.get();
                long j12 = 0;
                while (true) {
                    i11 = (j12 > j11 ? 1 : (j12 == j11 ? 0 : -1));
                    z11 = false;
                    if (i11 == 0) {
                        break;
                    } else if (this.f19794l) {
                        a();
                        return;
                    } else if (this.f19785c || ((Throwable) this.f19790h.get()) == null) {
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
                            this.f19790h.tryTerminateConsumer((Subscriber<?>) subscriber);
                            return;
                        } else if (z14) {
                            break;
                        } else {
                            subscriber.onNext(obj);
                            j12++;
                        }
                    } else {
                        a();
                        this.f19790h.tryTerminateConsumer((Subscriber<?>) this.f19784b);
                        return;
                    }
                }
                if (i11 == 0) {
                    if (this.f19794l) {
                        a();
                        return;
                    } else if (this.f19785c || ((Throwable) this.f19790h.get()) == null) {
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
                            this.f19790h.tryTerminateConsumer((Subscriber<?>) subscriber);
                            return;
                        }
                    } else {
                        a();
                        this.f19790h.tryTerminateConsumer((Subscriber<?>) subscriber);
                        return;
                    }
                }
                if (j12 != 0) {
                    BackpressureHelper.produced(this.f19787e, j12);
                    if (this.f19786d != Integer.MAX_VALUE) {
                        this.f19793k.request(j12);
                    }
                }
                i12 = addAndGet(-i12);
            } while (i12 != 0);
        }

        public void cancel() {
            this.f19794l = true;
            this.f19793k.cancel();
            this.f19788f.dispose();
            this.f19790h.tryTerminateAndReport();
        }

        public SpscLinkedArrayQueue<R> d() {
            SpscLinkedArrayQueue<R> spscLinkedArrayQueue = this.f19792j.get();
            if (spscLinkedArrayQueue != null) {
                return spscLinkedArrayQueue;
            }
            SpscLinkedArrayQueue<R> spscLinkedArrayQueue2 = new SpscLinkedArrayQueue<>(Flowable.bufferSize());
            if (b.a(this.f19792j, (Object) null, spscLinkedArrayQueue2)) {
                return spscLinkedArrayQueue2;
            }
            return this.f19792j.get();
        }

        public void e(FlatMapSingleSubscriber<T, R>.InnerObserver innerObserver, Throwable th2) {
            this.f19788f.delete(innerObserver);
            if (this.f19790h.tryAddThrowableOrReport(th2)) {
                if (!this.f19785c) {
                    this.f19793k.cancel();
                    this.f19788f.dispose();
                } else if (this.f19786d != Integer.MAX_VALUE) {
                    this.f19793k.request(1);
                }
                this.f19789g.decrementAndGet();
                b();
            }
        }

        public void f(FlatMapSingleSubscriber<T, R>.InnerObserver innerObserver, R r11) {
            this.f19788f.delete(innerObserver);
            if (get() == 0) {
                boolean z11 = false;
                if (compareAndSet(0, 1)) {
                    if (this.f19789g.decrementAndGet() == 0) {
                        z11 = true;
                    }
                    if (this.f19787e.get() != 0) {
                        this.f19784b.onNext(r11);
                        SpscLinkedArrayQueue spscLinkedArrayQueue = this.f19792j.get();
                        if (!z11 || (spscLinkedArrayQueue != null && !spscLinkedArrayQueue.isEmpty())) {
                            BackpressureHelper.produced(this.f19787e, 1);
                            if (this.f19786d != Integer.MAX_VALUE) {
                                this.f19793k.request(1);
                            }
                        } else {
                            this.f19790h.tryTerminateConsumer((Subscriber<?>) this.f19784b);
                            return;
                        }
                    } else {
                        SpscLinkedArrayQueue d11 = d();
                        synchronized (d11) {
                            d11.offer(r11);
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                    c();
                }
            }
            SpscLinkedArrayQueue d12 = d();
            synchronized (d12) {
                d12.offer(r11);
            }
            this.f19789g.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            c();
        }

        public void onComplete() {
            this.f19789g.decrementAndGet();
            b();
        }

        public void onError(Throwable th2) {
            this.f19789g.decrementAndGet();
            if (this.f19790h.tryAddThrowableOrReport(th2)) {
                if (!this.f19785c) {
                    this.f19788f.dispose();
                }
                b();
            }
        }

        public void onNext(T t11) {
            try {
                Object apply = this.f19791i.apply(t11);
                Objects.requireNonNull(apply, "The mapper returned a null SingleSource");
                SingleSource singleSource = (SingleSource) apply;
                this.f19789g.getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.f19794l && this.f19788f.add(innerObserver)) {
                    singleSource.subscribe(innerObserver);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f19793k.cancel();
                onError(th2);
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f19793k, subscription)) {
                this.f19793k = subscription;
                this.f19784b.onSubscribe(this);
                int i11 = this.f19786d;
                if (i11 == Integer.MAX_VALUE) {
                    subscription.request(Long.MAX_VALUE);
                } else {
                    subscription.request((long) i11);
                }
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f19787e, j11);
                b();
            }
        }
    }

    public FlowableFlatMapSingle(Flowable<T> flowable, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z11, int i11) {
        super(flowable);
        this.f19781d = function;
        this.f19782e = z11;
        this.f19783f = i11;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f19260c.subscribe(new FlatMapSingleSubscriber(subscriber, this.f19781d, this.f19782e, this.f19783f));
    }
}
