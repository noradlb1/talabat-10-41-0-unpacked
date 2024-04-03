package io.reactivex.processors;

import io.reactivex.Flowable;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class UnicastProcessor<T> extends FlowableProcessor<T> {

    /* renamed from: c  reason: collision with root package name */
    public final SpscLinkedArrayQueue<T> f18749c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<Runnable> f18750d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f18751e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f18752f;

    /* renamed from: g  reason: collision with root package name */
    public Throwable f18753g;

    /* renamed from: h  reason: collision with root package name */
    public final AtomicReference<Subscriber<? super T>> f18754h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f18755i;

    /* renamed from: j  reason: collision with root package name */
    public final AtomicBoolean f18756j;

    /* renamed from: k  reason: collision with root package name */
    public final BasicIntQueueSubscription<T> f18757k;

    /* renamed from: l  reason: collision with root package name */
    public final AtomicLong f18758l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f18759m;

    public final class UnicastQueueSubscription extends BasicIntQueueSubscription<T> {
        private static final long serialVersionUID = -4896760517184205454L;

        public UnicastQueueSubscription() {
        }

        public void cancel() {
            if (!UnicastProcessor.this.f18755i) {
                UnicastProcessor.this.f18755i = true;
                UnicastProcessor.this.c();
                UnicastProcessor.this.f18754h.lazySet((Object) null);
                if (UnicastProcessor.this.f18757k.getAndIncrement() == 0) {
                    UnicastProcessor.this.f18754h.lazySet((Object) null);
                    UnicastProcessor unicastProcessor = UnicastProcessor.this;
                    if (!unicastProcessor.f18759m) {
                        unicastProcessor.f18749c.clear();
                    }
                }
            }
        }

        public void clear() {
            UnicastProcessor.this.f18749c.clear();
        }

        public boolean isEmpty() {
            return UnicastProcessor.this.f18749c.isEmpty();
        }

        @Nullable
        public T poll() {
            return UnicastProcessor.this.f18749c.poll();
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(UnicastProcessor.this.f18758l, j11);
                UnicastProcessor.this.d();
            }
        }

        public int requestFusion(int i11) {
            if ((i11 & 2) == 0) {
                return 0;
            }
            UnicastProcessor.this.f18759m = true;
            return 2;
        }
    }

    public UnicastProcessor(int i11) {
        this(i11, (Runnable) null, true);
    }

    @CheckReturnValue
    @NonNull
    public static <T> UnicastProcessor<T> create() {
        return new UnicastProcessor<>(Flowable.bufferSize());
    }

    public boolean b(boolean z11, boolean z12, boolean z13, Subscriber<? super T> subscriber, SpscLinkedArrayQueue<T> spscLinkedArrayQueue) {
        if (this.f18755i) {
            spscLinkedArrayQueue.clear();
            this.f18754h.lazySet((Object) null);
            return true;
        } else if (!z12) {
            return false;
        } else {
            if (z11 && this.f18753g != null) {
                spscLinkedArrayQueue.clear();
                this.f18754h.lazySet((Object) null);
                subscriber.onError(this.f18753g);
                return true;
            } else if (!z13) {
                return false;
            } else {
                Throwable th2 = this.f18753g;
                this.f18754h.lazySet((Object) null);
                if (th2 != null) {
                    subscriber.onError(th2);
                } else {
                    subscriber.onComplete();
                }
                return true;
            }
        }
    }

    public void c() {
        Runnable andSet = this.f18750d.getAndSet((Object) null);
        if (andSet != null) {
            andSet.run();
        }
    }

    public void d() {
        if (this.f18757k.getAndIncrement() == 0) {
            Subscriber subscriber = this.f18754h.get();
            int i11 = 1;
            while (subscriber == null) {
                i11 = this.f18757k.addAndGet(-i11);
                if (i11 != 0) {
                    subscriber = this.f18754h.get();
                } else {
                    return;
                }
            }
            if (this.f18759m) {
                e(subscriber);
            } else {
                f(subscriber);
            }
        }
    }

    public void e(Subscriber<? super T> subscriber) {
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.f18749c;
        int i11 = 1;
        boolean z11 = !this.f18751e;
        while (!this.f18755i) {
            boolean z12 = this.f18752f;
            if (!z11 || !z12 || this.f18753g == null) {
                subscriber.onNext(null);
                if (z12) {
                    this.f18754h.lazySet((Object) null);
                    Throwable th2 = this.f18753g;
                    if (th2 != null) {
                        subscriber.onError(th2);
                        return;
                    } else {
                        subscriber.onComplete();
                        return;
                    }
                } else {
                    i11 = this.f18757k.addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                }
            } else {
                spscLinkedArrayQueue.clear();
                this.f18754h.lazySet((Object) null);
                subscriber.onError(this.f18753g);
                return;
            }
        }
        this.f18754h.lazySet((Object) null);
    }

    public void f(Subscriber<? super T> subscriber) {
        int i11;
        long j11;
        boolean z11;
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.f18749c;
        boolean z12 = true;
        boolean z13 = !this.f18751e;
        int i12 = 1;
        while (true) {
            long j12 = this.f18758l.get();
            long j13 = 0;
            while (true) {
                i11 = (j12 > j13 ? 1 : (j12 == j13 ? 0 : -1));
                if (i11 == 0) {
                    j11 = j13;
                    break;
                }
                boolean z14 = this.f18752f;
                T poll = spscLinkedArrayQueue.poll();
                if (poll == null) {
                    z11 = z12;
                } else {
                    z11 = false;
                }
                T t11 = poll;
                j11 = j13;
                if (!b(z13, z14, z11, subscriber, spscLinkedArrayQueue)) {
                    if (z11) {
                        break;
                    }
                    subscriber.onNext(t11);
                    j13 = 1 + j11;
                    z12 = true;
                } else {
                    return;
                }
            }
            Subscriber<? super T> subscriber2 = subscriber;
            if (i11 == 0) {
                if (b(z13, this.f18752f, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                    return;
                }
            }
            if (!(j11 == 0 || j12 == Long.MAX_VALUE)) {
                this.f18758l.addAndGet(-j11);
            }
            i12 = this.f18757k.addAndGet(-i12);
            if (i12 != 0) {
                z12 = true;
            } else {
                return;
            }
        }
    }

    @Nullable
    public Throwable getThrowable() {
        if (this.f18752f) {
            return this.f18753g;
        }
        return null;
    }

    public boolean hasComplete() {
        return this.f18752f && this.f18753g == null;
    }

    public boolean hasSubscribers() {
        return this.f18754h.get() != null;
    }

    public boolean hasThrowable() {
        return this.f18752f && this.f18753g != null;
    }

    public void onComplete() {
        if (!this.f18752f && !this.f18755i) {
            this.f18752f = true;
            c();
            d();
        }
    }

    public void onError(Throwable th2) {
        ObjectHelper.requireNonNull(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f18752f || this.f18755i) {
            RxJavaPlugins.onError(th2);
            return;
        }
        this.f18753g = th2;
        this.f18752f = true;
        c();
        d();
    }

    public void onNext(T t11) {
        ObjectHelper.requireNonNull(t11, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f18752f && !this.f18755i) {
            this.f18749c.offer(t11);
            d();
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (this.f18752f || this.f18755i) {
            subscription.cancel();
        } else {
            subscription.request(Long.MAX_VALUE);
        }
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (this.f18756j.get() || !this.f18756j.compareAndSet(false, true)) {
            EmptySubscription.error(new IllegalStateException("This processor allows only a single Subscriber"), subscriber);
            return;
        }
        subscriber.onSubscribe(this.f18757k);
        this.f18754h.set(subscriber);
        if (this.f18755i) {
            this.f18754h.lazySet((Object) null);
        } else {
            d();
        }
    }

    public UnicastProcessor(int i11, Runnable runnable) {
        this(i11, runnable, true);
    }

    @CheckReturnValue
    @NonNull
    public static <T> UnicastProcessor<T> create(int i11) {
        return new UnicastProcessor<>(i11);
    }

    public UnicastProcessor(int i11, Runnable runnable, boolean z11) {
        this.f18749c = new SpscLinkedArrayQueue<>(ObjectHelper.verifyPositive(i11, "capacityHint"));
        this.f18750d = new AtomicReference<>(runnable);
        this.f18751e = z11;
        this.f18754h = new AtomicReference<>();
        this.f18756j = new AtomicBoolean();
        this.f18757k = new UnicastQueueSubscription();
        this.f18758l = new AtomicLong();
    }

    @CheckReturnValue
    @NonNull
    public static <T> UnicastProcessor<T> create(boolean z11) {
        return new UnicastProcessor<>(Flowable.bufferSize(), (Runnable) null, z11);
    }

    @CheckReturnValue
    @NonNull
    public static <T> UnicastProcessor<T> create(int i11, Runnable runnable) {
        ObjectHelper.requireNonNull(runnable, "onTerminate");
        return new UnicastProcessor<>(i11, runnable);
    }

    @CheckReturnValue
    @NonNull
    public static <T> UnicastProcessor<T> create(int i11, Runnable runnable, boolean z11) {
        ObjectHelper.requireNonNull(runnable, "onTerminate");
        return new UnicastProcessor<>(i11, runnable, z11);
    }
}
