package io.reactivex.internal.operators.flowable;

import i.b;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
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

public final class FlowableFlatMapSingle<T, R> extends AbstractFlowableWithUpstream<T, R> {

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends SingleSource<? extends R>> f15274d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f15275e;

    /* renamed from: f  reason: collision with root package name */
    public final int f15276f;

    public static final class FlatMapSingleSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 8600231336733376951L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f15277b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f15278c;

        /* renamed from: d  reason: collision with root package name */
        public final int f15279d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicLong f15280e = new AtomicLong();

        /* renamed from: f  reason: collision with root package name */
        public final CompositeDisposable f15281f = new CompositeDisposable();

        /* renamed from: g  reason: collision with root package name */
        public final AtomicInteger f15282g = new AtomicInteger(1);

        /* renamed from: h  reason: collision with root package name */
        public final AtomicThrowable f15283h = new AtomicThrowable();

        /* renamed from: i  reason: collision with root package name */
        public final Function<? super T, ? extends SingleSource<? extends R>> f15284i;

        /* renamed from: j  reason: collision with root package name */
        public final AtomicReference<SpscLinkedArrayQueue<R>> f15285j = new AtomicReference<>();

        /* renamed from: k  reason: collision with root package name */
        public Subscription f15286k;

        /* renamed from: l  reason: collision with root package name */
        public volatile boolean f15287l;

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
            this.f15277b = subscriber;
            this.f15284i = function;
            this.f15278c = z11;
            this.f15279d = i11;
        }

        public void a() {
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f15285j.get();
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
            Subscriber<? super R> subscriber = this.f15277b;
            AtomicInteger atomicInteger = this.f15282g;
            AtomicReference<SpscLinkedArrayQueue<R>> atomicReference = this.f15285j;
            int i12 = 1;
            do {
                long j11 = this.f15280e.get();
                long j12 = 0;
                while (true) {
                    i11 = (j12 > j11 ? 1 : (j12 == j11 ? 0 : -1));
                    z11 = false;
                    if (i11 == 0) {
                        break;
                    } else if (this.f15287l) {
                        a();
                        return;
                    } else if (this.f15278c || ((Throwable) this.f15283h.get()) == null) {
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
                            Throwable terminate = this.f15283h.terminate();
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
                        Throwable terminate2 = this.f15283h.terminate();
                        a();
                        subscriber.onError(terminate2);
                        return;
                    }
                }
                if (i11 == 0) {
                    if (this.f15287l) {
                        a();
                        return;
                    } else if (this.f15278c || ((Throwable) this.f15283h.get()) == null) {
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
                            Throwable terminate3 = this.f15283h.terminate();
                            if (terminate3 != null) {
                                subscriber.onError(terminate3);
                                return;
                            } else {
                                subscriber.onComplete();
                                return;
                            }
                        }
                    } else {
                        Throwable terminate4 = this.f15283h.terminate();
                        a();
                        subscriber.onError(terminate4);
                        return;
                    }
                }
                if (j12 != 0) {
                    BackpressureHelper.produced(this.f15280e, j12);
                    if (this.f15279d != Integer.MAX_VALUE) {
                        this.f15286k.request(j12);
                    }
                }
                i12 = addAndGet(-i12);
            } while (i12 != 0);
        }

        public void cancel() {
            this.f15287l = true;
            this.f15286k.cancel();
            this.f15281f.dispose();
        }

        public SpscLinkedArrayQueue<R> d() {
            SpscLinkedArrayQueue<R> spscLinkedArrayQueue;
            do {
                SpscLinkedArrayQueue<R> spscLinkedArrayQueue2 = this.f15285j.get();
                if (spscLinkedArrayQueue2 != null) {
                    return spscLinkedArrayQueue2;
                }
                spscLinkedArrayQueue = new SpscLinkedArrayQueue<>(Flowable.bufferSize());
            } while (!b.a(this.f15285j, (Object) null, spscLinkedArrayQueue));
            return spscLinkedArrayQueue;
        }

        public void e(FlatMapSingleSubscriber<T, R>.InnerObserver innerObserver, Throwable th2) {
            this.f15281f.delete(innerObserver);
            if (this.f15283h.addThrowable(th2)) {
                if (!this.f15278c) {
                    this.f15286k.cancel();
                    this.f15281f.dispose();
                } else if (this.f15279d != Integer.MAX_VALUE) {
                    this.f15286k.request(1);
                }
                this.f15282g.decrementAndGet();
                b();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void f(FlatMapSingleSubscriber<T, R>.InnerObserver innerObserver, R r11) {
            this.f15281f.delete(innerObserver);
            if (get() == 0) {
                boolean z11 = false;
                if (compareAndSet(0, 1)) {
                    if (this.f15282g.decrementAndGet() == 0) {
                        z11 = true;
                    }
                    if (this.f15280e.get() != 0) {
                        this.f15277b.onNext(r11);
                        SpscLinkedArrayQueue spscLinkedArrayQueue = this.f15285j.get();
                        if (!z11 || (spscLinkedArrayQueue != null && !spscLinkedArrayQueue.isEmpty())) {
                            BackpressureHelper.produced(this.f15280e, 1);
                            if (this.f15279d != Integer.MAX_VALUE) {
                                this.f15286k.request(1);
                            }
                        } else {
                            Throwable terminate = this.f15283h.terminate();
                            if (terminate != null) {
                                this.f15277b.onError(terminate);
                                return;
                            } else {
                                this.f15277b.onComplete();
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
            this.f15282g.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            c();
        }

        public void onComplete() {
            this.f15282g.decrementAndGet();
            b();
        }

        public void onError(Throwable th2) {
            this.f15282g.decrementAndGet();
            if (this.f15283h.addThrowable(th2)) {
                if (!this.f15278c) {
                    this.f15281f.dispose();
                }
                b();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            try {
                SingleSource singleSource = (SingleSource) ObjectHelper.requireNonNull(this.f15284i.apply(t11), "The mapper returned a null SingleSource");
                this.f15282g.getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.f15287l && this.f15281f.add(innerObserver)) {
                    singleSource.subscribe(innerObserver);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f15286k.cancel();
                onError(th2);
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15286k, subscription)) {
                this.f15286k = subscription;
                this.f15277b.onSubscribe(this);
                int i11 = this.f15279d;
                if (i11 == Integer.MAX_VALUE) {
                    subscription.request(Long.MAX_VALUE);
                } else {
                    subscription.request((long) i11);
                }
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f15280e, j11);
                b();
            }
        }
    }

    public FlowableFlatMapSingle(Flowable<T> flowable, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z11, int i11) {
        super(flowable);
        this.f15274d = function;
        this.f15275e = z11;
        this.f15276f = i11;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f14763c.subscribe(new FlatMapSingleSubscriber(subscriber, this.f15274d, this.f15275e, this.f15276f));
    }
}
