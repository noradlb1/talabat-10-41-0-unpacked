package io.reactivex.rxjava3.processors;

import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class UnicastProcessor<T> extends FlowableProcessor<T> {

    /* renamed from: c  reason: collision with root package name */
    public final SpscLinkedArrayQueue<T> f23347c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<Runnable> f23348d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f23349e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f23350f;

    /* renamed from: g  reason: collision with root package name */
    public Throwable f23351g;

    /* renamed from: h  reason: collision with root package name */
    public final AtomicReference<Subscriber<? super T>> f23352h = new AtomicReference<>();

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f23353i;

    /* renamed from: j  reason: collision with root package name */
    public final AtomicBoolean f23354j = new AtomicBoolean();

    /* renamed from: k  reason: collision with root package name */
    public final BasicIntQueueSubscription<T> f23355k = new UnicastQueueSubscription();

    /* renamed from: l  reason: collision with root package name */
    public final AtomicLong f23356l = new AtomicLong();

    /* renamed from: m  reason: collision with root package name */
    public boolean f23357m;

    public final class UnicastQueueSubscription extends BasicIntQueueSubscription<T> {
        private static final long serialVersionUID = -4896760517184205454L;

        public UnicastQueueSubscription() {
        }

        public void cancel() {
            if (!UnicastProcessor.this.f23353i) {
                UnicastProcessor.this.f23353i = true;
                UnicastProcessor.this.c();
                UnicastProcessor.this.f23352h.lazySet((Object) null);
                if (UnicastProcessor.this.f23355k.getAndIncrement() == 0) {
                    UnicastProcessor.this.f23352h.lazySet((Object) null);
                    UnicastProcessor unicastProcessor = UnicastProcessor.this;
                    if (!unicastProcessor.f23357m) {
                        unicastProcessor.f23347c.clear();
                    }
                }
            }
        }

        public void clear() {
            UnicastProcessor.this.f23347c.clear();
        }

        public boolean isEmpty() {
            return UnicastProcessor.this.f23347c.isEmpty();
        }

        @Nullable
        public T poll() {
            return UnicastProcessor.this.f23347c.poll();
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(UnicastProcessor.this.f23356l, j11);
                UnicastProcessor.this.d();
            }
        }

        public int requestFusion(int i11) {
            if ((i11 & 2) == 0) {
                return 0;
            }
            UnicastProcessor.this.f23357m = true;
            return 2;
        }
    }

    public UnicastProcessor(int i11, Runnable runnable, boolean z11) {
        this.f23347c = new SpscLinkedArrayQueue<>(i11);
        this.f23348d = new AtomicReference<>(runnable);
        this.f23349e = z11;
    }

    @NonNull
    @CheckReturnValue
    public static <T> UnicastProcessor<T> create() {
        return new UnicastProcessor<>(Flowable.bufferSize(), (Runnable) null, true);
    }

    public boolean b(boolean z11, boolean z12, boolean z13, Subscriber<? super T> subscriber, SpscLinkedArrayQueue<T> spscLinkedArrayQueue) {
        if (this.f23353i) {
            spscLinkedArrayQueue.clear();
            this.f23352h.lazySet((Object) null);
            return true;
        } else if (!z12) {
            return false;
        } else {
            if (z11 && this.f23351g != null) {
                spscLinkedArrayQueue.clear();
                this.f23352h.lazySet((Object) null);
                subscriber.onError(this.f23351g);
                return true;
            } else if (!z13) {
                return false;
            } else {
                Throwable th2 = this.f23351g;
                this.f23352h.lazySet((Object) null);
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
        Runnable andSet = this.f23348d.getAndSet((Object) null);
        if (andSet != null) {
            andSet.run();
        }
    }

    public void d() {
        if (this.f23355k.getAndIncrement() == 0) {
            Subscriber subscriber = this.f23352h.get();
            int i11 = 1;
            while (subscriber == null) {
                i11 = this.f23355k.addAndGet(-i11);
                if (i11 != 0) {
                    subscriber = this.f23352h.get();
                } else {
                    return;
                }
            }
            if (this.f23357m) {
                e(subscriber);
            } else {
                f(subscriber);
            }
        }
    }

    public void e(Subscriber<? super T> subscriber) {
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.f23347c;
        int i11 = 1;
        boolean z11 = !this.f23349e;
        while (!this.f23353i) {
            boolean z12 = this.f23350f;
            if (!z11 || !z12 || this.f23351g == null) {
                subscriber.onNext(null);
                if (z12) {
                    this.f23352h.lazySet((Object) null);
                    Throwable th2 = this.f23351g;
                    if (th2 != null) {
                        subscriber.onError(th2);
                        return;
                    } else {
                        subscriber.onComplete();
                        return;
                    }
                } else {
                    i11 = this.f23355k.addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                }
            } else {
                spscLinkedArrayQueue.clear();
                this.f23352h.lazySet((Object) null);
                subscriber.onError(this.f23351g);
                return;
            }
        }
        this.f23352h.lazySet((Object) null);
    }

    public void f(Subscriber<? super T> subscriber) {
        int i11;
        long j11;
        boolean z11;
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.f23347c;
        boolean z12 = true;
        boolean z13 = !this.f23349e;
        int i12 = 1;
        while (true) {
            long j12 = this.f23356l.get();
            long j13 = 0;
            while (true) {
                i11 = (j12 > j13 ? 1 : (j12 == j13 ? 0 : -1));
                if (i11 == 0) {
                    j11 = j13;
                    break;
                }
                boolean z14 = this.f23350f;
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
                if (b(z13, this.f23350f, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                    return;
                }
            }
            if (!(j11 == 0 || j12 == Long.MAX_VALUE)) {
                this.f23356l.addAndGet(-j11);
            }
            i12 = this.f23355k.addAndGet(-i12);
            if (i12 != 0) {
                z12 = true;
            } else {
                return;
            }
        }
    }

    @CheckReturnValue
    @Nullable
    public Throwable getThrowable() {
        if (this.f23350f) {
            return this.f23351g;
        }
        return null;
    }

    @CheckReturnValue
    public boolean hasComplete() {
        return this.f23350f && this.f23351g == null;
    }

    @CheckReturnValue
    public boolean hasSubscribers() {
        return this.f23352h.get() != null;
    }

    @CheckReturnValue
    public boolean hasThrowable() {
        return this.f23350f && this.f23351g != null;
    }

    public void onComplete() {
        if (!this.f23350f && !this.f23353i) {
            this.f23350f = true;
            c();
            d();
        }
    }

    public void onError(Throwable th2) {
        ExceptionHelper.nullCheck(th2, "onError called with a null Throwable.");
        if (this.f23350f || this.f23353i) {
            RxJavaPlugins.onError(th2);
            return;
        }
        this.f23351g = th2;
        this.f23350f = true;
        c();
        d();
    }

    public void onNext(T t11) {
        ExceptionHelper.nullCheck(t11, "onNext called with a null value.");
        if (!this.f23350f && !this.f23353i) {
            this.f23347c.offer(t11);
            d();
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (this.f23350f || this.f23353i) {
            subscription.cancel();
        } else {
            subscription.request(Long.MAX_VALUE);
        }
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (this.f23354j.get() || !this.f23354j.compareAndSet(false, true)) {
            EmptySubscription.error(new IllegalStateException("This processor allows only a single Subscriber"), subscriber);
            return;
        }
        subscriber.onSubscribe(this.f23355k);
        this.f23352h.set(subscriber);
        if (this.f23353i) {
            this.f23352h.lazySet((Object) null);
        } else {
            d();
        }
    }

    @NonNull
    @CheckReturnValue
    public static <T> UnicastProcessor<T> create(int i11) {
        ObjectHelper.verifyPositive(i11, "capacityHint");
        return new UnicastProcessor<>(i11, (Runnable) null, true);
    }

    @NonNull
    @CheckReturnValue
    public static <T> UnicastProcessor<T> create(boolean z11) {
        return new UnicastProcessor<>(Flowable.bufferSize(), (Runnable) null, z11);
    }

    @NonNull
    @CheckReturnValue
    public static <T> UnicastProcessor<T> create(int i11, @NonNull Runnable runnable) {
        return create(i11, runnable, true);
    }

    @NonNull
    @CheckReturnValue
    public static <T> UnicastProcessor<T> create(int i11, @NonNull Runnable runnable, boolean z11) {
        Objects.requireNonNull(runnable, "onTerminate");
        ObjectHelper.verifyPositive(i11, "capacityHint");
        return new UnicastProcessor<>(i11, runnable, z11);
    }
}
