package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.QueueDrainHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableBuffer<T, C extends Collection<? super T>> extends AbstractFlowableWithUpstream<T, C> {

    /* renamed from: d  reason: collision with root package name */
    public final int f19315d;

    /* renamed from: e  reason: collision with root package name */
    public final int f19316e;

    /* renamed from: f  reason: collision with root package name */
    public final Supplier<C> f19317f;

    public static final class PublisherBufferExactSubscriber<T, C extends Collection<? super T>> implements FlowableSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super C> f19318b;

        /* renamed from: c  reason: collision with root package name */
        public final Supplier<C> f19319c;

        /* renamed from: d  reason: collision with root package name */
        public final int f19320d;

        /* renamed from: e  reason: collision with root package name */
        public C f19321e;

        /* renamed from: f  reason: collision with root package name */
        public Subscription f19322f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f19323g;

        /* renamed from: h  reason: collision with root package name */
        public int f19324h;

        public PublisherBufferExactSubscriber(Subscriber<? super C> subscriber, int i11, Supplier<C> supplier) {
            this.f19318b = subscriber;
            this.f19320d = i11;
            this.f19319c = supplier;
        }

        public void cancel() {
            this.f19322f.cancel();
        }

        public void onComplete() {
            if (!this.f19323g) {
                this.f19323g = true;
                C c11 = this.f19321e;
                this.f19321e = null;
                if (c11 != null) {
                    this.f19318b.onNext(c11);
                }
                this.f19318b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f19323g) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f19321e = null;
            this.f19323g = true;
            this.f19318b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f19323g) {
                C c11 = this.f19321e;
                if (c11 == null) {
                    try {
                        C c12 = this.f19319c.get();
                        Objects.requireNonNull(c12, "The bufferSupplier returned a null buffer");
                        c11 = (Collection) c12;
                        this.f19321e = c11;
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        cancel();
                        onError(th2);
                        return;
                    }
                }
                c11.add(t11);
                int i11 = this.f19324h + 1;
                if (i11 == this.f19320d) {
                    this.f19324h = 0;
                    this.f19321e = null;
                    this.f19318b.onNext(c11);
                    return;
                }
                this.f19324h = i11;
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f19322f, subscription)) {
                this.f19322f = subscription;
                this.f19318b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                this.f19322f.request(BackpressureHelper.multiplyCap(j11, (long) this.f19320d));
            }
        }
    }

    public static final class PublisherBufferOverlappingSubscriber<T, C extends Collection<? super T>> extends AtomicLong implements FlowableSubscriber<T>, Subscription, BooleanSupplier {
        private static final long serialVersionUID = -7370244972039324525L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super C> f19325b;

        /* renamed from: c  reason: collision with root package name */
        public final Supplier<C> f19326c;

        /* renamed from: d  reason: collision with root package name */
        public final int f19327d;

        /* renamed from: e  reason: collision with root package name */
        public final int f19328e;

        /* renamed from: f  reason: collision with root package name */
        public final ArrayDeque<C> f19329f = new ArrayDeque<>();

        /* renamed from: g  reason: collision with root package name */
        public final AtomicBoolean f19330g = new AtomicBoolean();

        /* renamed from: h  reason: collision with root package name */
        public Subscription f19331h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f19332i;

        /* renamed from: j  reason: collision with root package name */
        public int f19333j;

        /* renamed from: k  reason: collision with root package name */
        public volatile boolean f19334k;

        /* renamed from: l  reason: collision with root package name */
        public long f19335l;

        public PublisherBufferOverlappingSubscriber(Subscriber<? super C> subscriber, int i11, int i12, Supplier<C> supplier) {
            this.f19325b = subscriber;
            this.f19327d = i11;
            this.f19328e = i12;
            this.f19326c = supplier;
        }

        public void cancel() {
            this.f19334k = true;
            this.f19331h.cancel();
        }

        public boolean getAsBoolean() {
            return this.f19334k;
        }

        public void onComplete() {
            if (!this.f19332i) {
                this.f19332i = true;
                long j11 = this.f19335l;
                if (j11 != 0) {
                    BackpressureHelper.produced(this, j11);
                }
                QueueDrainHelper.postComplete(this.f19325b, this.f19329f, this, this);
            }
        }

        public void onError(Throwable th2) {
            if (this.f19332i) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f19332i = true;
            this.f19329f.clear();
            this.f19325b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f19332i) {
                ArrayDeque<C> arrayDeque = this.f19329f;
                int i11 = this.f19333j;
                int i12 = i11 + 1;
                if (i11 == 0) {
                    try {
                        C c11 = this.f19326c.get();
                        Objects.requireNonNull(c11, "The bufferSupplier returned a null buffer");
                        arrayDeque.offer((Collection) c11);
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        cancel();
                        onError(th2);
                        return;
                    }
                }
                Collection collection = (Collection) arrayDeque.peek();
                if (collection.size() + 1 == this.f19327d) {
                    arrayDeque.poll();
                    collection.add(t11);
                    this.f19335l++;
                    this.f19325b.onNext(collection);
                }
                Iterator<C> it = arrayDeque.iterator();
                while (it.hasNext()) {
                    ((Collection) it.next()).add(t11);
                }
                if (i12 == this.f19328e) {
                    i12 = 0;
                }
                this.f19333j = i12;
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f19331h, subscription)) {
                this.f19331h = subscription;
                this.f19325b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                if (!QueueDrainHelper.postCompleteRequest(j11, this.f19325b, this.f19329f, this, this)) {
                    if (this.f19330g.get() || !this.f19330g.compareAndSet(false, true)) {
                        this.f19331h.request(BackpressureHelper.multiplyCap((long) this.f19328e, j11));
                        return;
                    }
                    this.f19331h.request(BackpressureHelper.addCap((long) this.f19327d, BackpressureHelper.multiplyCap((long) this.f19328e, j11 - 1)));
                }
            }
        }
    }

    public static final class PublisherBufferSkipSubscriber<T, C extends Collection<? super T>> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -5616169793639412593L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super C> f19336b;

        /* renamed from: c  reason: collision with root package name */
        public final Supplier<C> f19337c;

        /* renamed from: d  reason: collision with root package name */
        public final int f19338d;

        /* renamed from: e  reason: collision with root package name */
        public final int f19339e;

        /* renamed from: f  reason: collision with root package name */
        public C f19340f;

        /* renamed from: g  reason: collision with root package name */
        public Subscription f19341g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f19342h;

        /* renamed from: i  reason: collision with root package name */
        public int f19343i;

        public PublisherBufferSkipSubscriber(Subscriber<? super C> subscriber, int i11, int i12, Supplier<C> supplier) {
            this.f19336b = subscriber;
            this.f19338d = i11;
            this.f19339e = i12;
            this.f19337c = supplier;
        }

        public void cancel() {
            this.f19341g.cancel();
        }

        public void onComplete() {
            if (!this.f19342h) {
                this.f19342h = true;
                C c11 = this.f19340f;
                this.f19340f = null;
                if (c11 != null) {
                    this.f19336b.onNext(c11);
                }
                this.f19336b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f19342h) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f19342h = true;
            this.f19340f = null;
            this.f19336b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f19342h) {
                C c11 = this.f19340f;
                int i11 = this.f19343i;
                int i12 = i11 + 1;
                if (i11 == 0) {
                    try {
                        C c12 = this.f19337c.get();
                        Objects.requireNonNull(c12, "The bufferSupplier returned a null buffer");
                        c11 = (Collection) c12;
                        this.f19340f = c11;
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        cancel();
                        onError(th2);
                        return;
                    }
                }
                if (c11 != null) {
                    c11.add(t11);
                    if (c11.size() == this.f19338d) {
                        this.f19340f = null;
                        this.f19336b.onNext(c11);
                    }
                }
                if (i12 == this.f19339e) {
                    i12 = 0;
                }
                this.f19343i = i12;
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f19341g, subscription)) {
                this.f19341g = subscription;
                this.f19336b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            if (!SubscriptionHelper.validate(j11)) {
                return;
            }
            if (get() != 0 || !compareAndSet(0, 1)) {
                this.f19341g.request(BackpressureHelper.multiplyCap((long) this.f19339e, j11));
                return;
            }
            this.f19341g.request(BackpressureHelper.addCap(BackpressureHelper.multiplyCap(j11, (long) this.f19338d), BackpressureHelper.multiplyCap((long) (this.f19339e - this.f19338d), j11 - 1)));
        }
    }

    public FlowableBuffer(Flowable<T> flowable, int i11, int i12, Supplier<C> supplier) {
        super(flowable);
        this.f19315d = i11;
        this.f19316e = i12;
        this.f19317f = supplier;
    }

    public void subscribeActual(Subscriber<? super C> subscriber) {
        int i11 = this.f19315d;
        int i12 = this.f19316e;
        if (i11 == i12) {
            this.f19260c.subscribe(new PublisherBufferExactSubscriber(subscriber, i11, this.f19317f));
        } else if (i12 > i11) {
            this.f19260c.subscribe(new PublisherBufferSkipSubscriber(subscriber, this.f19315d, this.f19316e, this.f19317f));
        } else {
            this.f19260c.subscribe(new PublisherBufferOverlappingSubscriber(subscriber, this.f19315d, this.f19316e, this.f19317f));
        }
    }
}
