package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableBuffer<T, C extends Collection<? super T>> extends AbstractFlowableWithUpstream<T, C> {

    /* renamed from: d  reason: collision with root package name */
    public final int f14818d;

    /* renamed from: e  reason: collision with root package name */
    public final int f14819e;

    /* renamed from: f  reason: collision with root package name */
    public final Callable<C> f14820f;

    public static final class PublisherBufferExactSubscriber<T, C extends Collection<? super T>> implements FlowableSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super C> f14821b;

        /* renamed from: c  reason: collision with root package name */
        public final Callable<C> f14822c;

        /* renamed from: d  reason: collision with root package name */
        public final int f14823d;

        /* renamed from: e  reason: collision with root package name */
        public C f14824e;

        /* renamed from: f  reason: collision with root package name */
        public Subscription f14825f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f14826g;

        /* renamed from: h  reason: collision with root package name */
        public int f14827h;

        public PublisherBufferExactSubscriber(Subscriber<? super C> subscriber, int i11, Callable<C> callable) {
            this.f14821b = subscriber;
            this.f14823d = i11;
            this.f14822c = callable;
        }

        public void cancel() {
            this.f14825f.cancel();
        }

        public void onComplete() {
            if (!this.f14826g) {
                this.f14826g = true;
                C c11 = this.f14824e;
                if (c11 != null && !c11.isEmpty()) {
                    this.f14821b.onNext(c11);
                }
                this.f14821b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f14826g) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f14826g = true;
            this.f14821b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f14826g) {
                C c11 = this.f14824e;
                if (c11 == null) {
                    try {
                        c11 = (Collection) ObjectHelper.requireNonNull(this.f14822c.call(), "The bufferSupplier returned a null buffer");
                        this.f14824e = c11;
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        cancel();
                        onError(th2);
                        return;
                    }
                }
                c11.add(t11);
                int i11 = this.f14827h + 1;
                if (i11 == this.f14823d) {
                    this.f14827h = 0;
                    this.f14824e = null;
                    this.f14821b.onNext(c11);
                    return;
                }
                this.f14827h = i11;
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f14825f, subscription)) {
                this.f14825f = subscription;
                this.f14821b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                this.f14825f.request(BackpressureHelper.multiplyCap(j11, (long) this.f14823d));
            }
        }
    }

    public static final class PublisherBufferOverlappingSubscriber<T, C extends Collection<? super T>> extends AtomicLong implements FlowableSubscriber<T>, Subscription, BooleanSupplier {
        private static final long serialVersionUID = -7370244972039324525L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super C> f14828b;

        /* renamed from: c  reason: collision with root package name */
        public final Callable<C> f14829c;

        /* renamed from: d  reason: collision with root package name */
        public final int f14830d;

        /* renamed from: e  reason: collision with root package name */
        public final int f14831e;

        /* renamed from: f  reason: collision with root package name */
        public final ArrayDeque<C> f14832f = new ArrayDeque<>();

        /* renamed from: g  reason: collision with root package name */
        public final AtomicBoolean f14833g = new AtomicBoolean();

        /* renamed from: h  reason: collision with root package name */
        public Subscription f14834h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f14835i;

        /* renamed from: j  reason: collision with root package name */
        public int f14836j;

        /* renamed from: k  reason: collision with root package name */
        public volatile boolean f14837k;

        /* renamed from: l  reason: collision with root package name */
        public long f14838l;

        public PublisherBufferOverlappingSubscriber(Subscriber<? super C> subscriber, int i11, int i12, Callable<C> callable) {
            this.f14828b = subscriber;
            this.f14830d = i11;
            this.f14831e = i12;
            this.f14829c = callable;
        }

        public void cancel() {
            this.f14837k = true;
            this.f14834h.cancel();
        }

        public boolean getAsBoolean() {
            return this.f14837k;
        }

        public void onComplete() {
            if (!this.f14835i) {
                this.f14835i = true;
                long j11 = this.f14838l;
                if (j11 != 0) {
                    BackpressureHelper.produced(this, j11);
                }
                QueueDrainHelper.postComplete(this.f14828b, this.f14832f, this, this);
            }
        }

        public void onError(Throwable th2) {
            if (this.f14835i) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f14835i = true;
            this.f14832f.clear();
            this.f14828b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f14835i) {
                ArrayDeque<C> arrayDeque = this.f14832f;
                int i11 = this.f14836j;
                int i12 = i11 + 1;
                if (i11 == 0) {
                    try {
                        arrayDeque.offer((Collection) ObjectHelper.requireNonNull(this.f14829c.call(), "The bufferSupplier returned a null buffer"));
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        cancel();
                        onError(th2);
                        return;
                    }
                }
                Collection collection = (Collection) arrayDeque.peek();
                if (collection != null && collection.size() + 1 == this.f14830d) {
                    arrayDeque.poll();
                    collection.add(t11);
                    this.f14838l++;
                    this.f14828b.onNext(collection);
                }
                Iterator<C> it = arrayDeque.iterator();
                while (it.hasNext()) {
                    ((Collection) it.next()).add(t11);
                }
                if (i12 == this.f14831e) {
                    i12 = 0;
                }
                this.f14836j = i12;
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f14834h, subscription)) {
                this.f14834h = subscription;
                this.f14828b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                if (!QueueDrainHelper.postCompleteRequest(j11, this.f14828b, this.f14832f, this, this)) {
                    if (this.f14833g.get() || !this.f14833g.compareAndSet(false, true)) {
                        this.f14834h.request(BackpressureHelper.multiplyCap((long) this.f14831e, j11));
                        return;
                    }
                    this.f14834h.request(BackpressureHelper.addCap((long) this.f14830d, BackpressureHelper.multiplyCap((long) this.f14831e, j11 - 1)));
                }
            }
        }
    }

    public static final class PublisherBufferSkipSubscriber<T, C extends Collection<? super T>> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -5616169793639412593L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super C> f14839b;

        /* renamed from: c  reason: collision with root package name */
        public final Callable<C> f14840c;

        /* renamed from: d  reason: collision with root package name */
        public final int f14841d;

        /* renamed from: e  reason: collision with root package name */
        public final int f14842e;

        /* renamed from: f  reason: collision with root package name */
        public C f14843f;

        /* renamed from: g  reason: collision with root package name */
        public Subscription f14844g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f14845h;

        /* renamed from: i  reason: collision with root package name */
        public int f14846i;

        public PublisherBufferSkipSubscriber(Subscriber<? super C> subscriber, int i11, int i12, Callable<C> callable) {
            this.f14839b = subscriber;
            this.f14841d = i11;
            this.f14842e = i12;
            this.f14840c = callable;
        }

        public void cancel() {
            this.f14844g.cancel();
        }

        public void onComplete() {
            if (!this.f14845h) {
                this.f14845h = true;
                C c11 = this.f14843f;
                this.f14843f = null;
                if (c11 != null) {
                    this.f14839b.onNext(c11);
                }
                this.f14839b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f14845h) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f14845h = true;
            this.f14843f = null;
            this.f14839b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f14845h) {
                C c11 = this.f14843f;
                int i11 = this.f14846i;
                int i12 = i11 + 1;
                if (i11 == 0) {
                    try {
                        c11 = (Collection) ObjectHelper.requireNonNull(this.f14840c.call(), "The bufferSupplier returned a null buffer");
                        this.f14843f = c11;
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        cancel();
                        onError(th2);
                        return;
                    }
                }
                if (c11 != null) {
                    c11.add(t11);
                    if (c11.size() == this.f14841d) {
                        this.f14843f = null;
                        this.f14839b.onNext(c11);
                    }
                }
                if (i12 == this.f14842e) {
                    i12 = 0;
                }
                this.f14846i = i12;
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f14844g, subscription)) {
                this.f14844g = subscription;
                this.f14839b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            if (!SubscriptionHelper.validate(j11)) {
                return;
            }
            if (get() != 0 || !compareAndSet(0, 1)) {
                this.f14844g.request(BackpressureHelper.multiplyCap((long) this.f14842e, j11));
                return;
            }
            this.f14844g.request(BackpressureHelper.addCap(BackpressureHelper.multiplyCap(j11, (long) this.f14841d), BackpressureHelper.multiplyCap((long) (this.f14842e - this.f14841d), j11 - 1)));
        }
    }

    public FlowableBuffer(Flowable<T> flowable, int i11, int i12, Callable<C> callable) {
        super(flowable);
        this.f14818d = i11;
        this.f14819e = i12;
        this.f14820f = callable;
    }

    public void subscribeActual(Subscriber<? super C> subscriber) {
        int i11 = this.f14818d;
        int i12 = this.f14819e;
        if (i11 == i12) {
            this.f14763c.subscribe(new PublisherBufferExactSubscriber(subscriber, i11, this.f14820f));
        } else if (i12 > i11) {
            this.f14763c.subscribe(new PublisherBufferSkipSubscriber(subscriber, this.f14818d, this.f14819e, this.f14820f));
        } else {
            this.f14763c.subscribe(new PublisherBufferOverlappingSubscriber(subscriber, this.f14818d, this.f14819e, this.f14820f));
        }
    }
}
