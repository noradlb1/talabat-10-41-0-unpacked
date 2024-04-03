package io.reactivex.internal.operators.flowable;

import i.b;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFlatMapMaybe<T, R> extends AbstractFlowableWithUpstream<T, R> {

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends MaybeSource<? extends R>> f15254d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f15255e;

    /* renamed from: f  reason: collision with root package name */
    public final int f15256f;

    public static final class FlatMapMaybeSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 8600231336733376951L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f15257b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f15258c;

        /* renamed from: d  reason: collision with root package name */
        public final int f15259d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicLong f15260e = new AtomicLong();

        /* renamed from: f  reason: collision with root package name */
        public final CompositeDisposable f15261f = new CompositeDisposable();

        /* renamed from: g  reason: collision with root package name */
        public final AtomicInteger f15262g = new AtomicInteger(1);

        /* renamed from: h  reason: collision with root package name */
        public final AtomicThrowable f15263h = new AtomicThrowable();

        /* renamed from: i  reason: collision with root package name */
        public final Function<? super T, ? extends MaybeSource<? extends R>> f15264i;

        /* renamed from: j  reason: collision with root package name */
        public final AtomicReference<SpscLinkedArrayQueue<R>> f15265j = new AtomicReference<>();

        /* renamed from: k  reason: collision with root package name */
        public Subscription f15266k;

        /* renamed from: l  reason: collision with root package name */
        public volatile boolean f15267l;

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
                FlatMapMaybeSubscriber.this.e(this);
            }

            public void onError(Throwable th2) {
                FlatMapMaybeSubscriber.this.f(this, th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public void onSuccess(R r11) {
                FlatMapMaybeSubscriber.this.g(this, r11);
            }
        }

        public FlatMapMaybeSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z11, int i11) {
            this.f15257b = subscriber;
            this.f15264i = function;
            this.f15258c = z11;
            this.f15259d = i11;
        }

        public void a() {
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f15265j.get();
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
            Subscriber<? super R> subscriber = this.f15257b;
            AtomicInteger atomicInteger = this.f15262g;
            AtomicReference<SpscLinkedArrayQueue<R>> atomicReference = this.f15265j;
            int i12 = 1;
            do {
                long j11 = this.f15260e.get();
                long j12 = 0;
                while (true) {
                    i11 = (j12 > j11 ? 1 : (j12 == j11 ? 0 : -1));
                    z11 = false;
                    if (i11 == 0) {
                        break;
                    } else if (this.f15267l) {
                        a();
                        return;
                    } else if (this.f15258c || ((Throwable) this.f15263h.get()) == null) {
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
                            Throwable terminate = this.f15263h.terminate();
                            if (terminate != null) {
                                subscriber.onError(terminate);
                                return;
                            } else {
                                subscriber.onComplete();
                                return;
                            }
                        } else if (z14) {
                            break;
                        } else {
                            subscriber.onNext(obj);
                            j12++;
                        }
                    } else {
                        Throwable terminate2 = this.f15263h.terminate();
                        a();
                        subscriber.onError(terminate2);
                        return;
                    }
                }
                if (i11 == 0) {
                    if (this.f15267l) {
                        a();
                        return;
                    } else if (this.f15258c || ((Throwable) this.f15263h.get()) == null) {
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
                            Throwable terminate3 = this.f15263h.terminate();
                            if (terminate3 != null) {
                                subscriber.onError(terminate3);
                                return;
                            } else {
                                subscriber.onComplete();
                                return;
                            }
                        }
                    } else {
                        Throwable terminate4 = this.f15263h.terminate();
                        a();
                        subscriber.onError(terminate4);
                        return;
                    }
                }
                if (j12 != 0) {
                    BackpressureHelper.produced(this.f15260e, j12);
                    if (this.f15259d != Integer.MAX_VALUE) {
                        this.f15266k.request(j12);
                    }
                }
                i12 = addAndGet(-i12);
            } while (i12 != 0);
        }

        public void cancel() {
            this.f15267l = true;
            this.f15266k.cancel();
            this.f15261f.dispose();
        }

        public SpscLinkedArrayQueue<R> d() {
            SpscLinkedArrayQueue<R> spscLinkedArrayQueue;
            do {
                SpscLinkedArrayQueue<R> spscLinkedArrayQueue2 = this.f15265j.get();
                if (spscLinkedArrayQueue2 != null) {
                    return spscLinkedArrayQueue2;
                }
                spscLinkedArrayQueue = new SpscLinkedArrayQueue<>(Flowable.bufferSize());
            } while (!b.a(this.f15265j, (Object) null, spscLinkedArrayQueue));
            return spscLinkedArrayQueue;
        }

        public void e(FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver) {
            this.f15261f.delete(innerObserver);
            if (get() == 0) {
                boolean z11 = false;
                if (compareAndSet(0, 1)) {
                    if (this.f15262g.decrementAndGet() == 0) {
                        z11 = true;
                    }
                    SpscLinkedArrayQueue spscLinkedArrayQueue = this.f15265j.get();
                    if (!z11 || (spscLinkedArrayQueue != null && !spscLinkedArrayQueue.isEmpty())) {
                        if (this.f15259d != Integer.MAX_VALUE) {
                            this.f15266k.request(1);
                        }
                        if (decrementAndGet() != 0) {
                            c();
                            return;
                        }
                        return;
                    }
                    Throwable terminate = this.f15263h.terminate();
                    if (terminate != null) {
                        this.f15257b.onError(terminate);
                        return;
                    } else {
                        this.f15257b.onComplete();
                        return;
                    }
                }
            }
            this.f15262g.decrementAndGet();
            if (this.f15259d != Integer.MAX_VALUE) {
                this.f15266k.request(1);
            }
            b();
        }

        public void f(FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver, Throwable th2) {
            this.f15261f.delete(innerObserver);
            if (this.f15263h.addThrowable(th2)) {
                if (!this.f15258c) {
                    this.f15266k.cancel();
                    this.f15261f.dispose();
                } else if (this.f15259d != Integer.MAX_VALUE) {
                    this.f15266k.request(1);
                }
                this.f15262g.decrementAndGet();
                b();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void g(FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver, R r11) {
            this.f15261f.delete(innerObserver);
            if (get() == 0) {
                boolean z11 = false;
                if (compareAndSet(0, 1)) {
                    if (this.f15262g.decrementAndGet() == 0) {
                        z11 = true;
                    }
                    if (this.f15260e.get() != 0) {
                        this.f15257b.onNext(r11);
                        SpscLinkedArrayQueue spscLinkedArrayQueue = this.f15265j.get();
                        if (!z11 || (spscLinkedArrayQueue != null && !spscLinkedArrayQueue.isEmpty())) {
                            BackpressureHelper.produced(this.f15260e, 1);
                            if (this.f15259d != Integer.MAX_VALUE) {
                                this.f15266k.request(1);
                            }
                        } else {
                            Throwable terminate = this.f15263h.terminate();
                            if (terminate != null) {
                                this.f15257b.onError(terminate);
                                return;
                            } else {
                                this.f15257b.onComplete();
                                return;
                            }
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
            this.f15262g.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            c();
        }

        public void onComplete() {
            this.f15262g.decrementAndGet();
            b();
        }

        public void onError(Throwable th2) {
            this.f15262g.decrementAndGet();
            if (this.f15263h.addThrowable(th2)) {
                if (!this.f15258c) {
                    this.f15261f.dispose();
                }
                b();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            try {
                MaybeSource maybeSource = (MaybeSource) ObjectHelper.requireNonNull(this.f15264i.apply(t11), "The mapper returned a null MaybeSource");
                this.f15262g.getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.f15267l && this.f15261f.add(innerObserver)) {
                    maybeSource.subscribe(innerObserver);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f15266k.cancel();
                onError(th2);
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15266k, subscription)) {
                this.f15266k = subscription;
                this.f15257b.onSubscribe(this);
                int i11 = this.f15259d;
                if (i11 == Integer.MAX_VALUE) {
                    subscription.request(Long.MAX_VALUE);
                } else {
                    subscription.request((long) i11);
                }
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f15260e, j11);
                b();
            }
        }
    }

    public FlowableFlatMapMaybe(Flowable<T> flowable, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z11, int i11) {
        super(flowable);
        this.f15254d = function;
        this.f15255e = z11;
        this.f15256f = i11;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f14763c.subscribe(new FlatMapMaybeSubscriber(subscriber, this.f15254d, this.f15255e, this.f15256f));
    }
}
