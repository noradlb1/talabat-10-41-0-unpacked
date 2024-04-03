package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.flowables.GroupedFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.EmptyComponent;
import io.reactivex.plugins.RxJavaPlugins;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableGroupBy<T, K, V> extends AbstractFlowableWithUpstream<T, GroupedFlowable<K, V>> {

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends K> f15333d;

    /* renamed from: e  reason: collision with root package name */
    public final Function<? super T, ? extends V> f15334e;

    /* renamed from: f  reason: collision with root package name */
    public final int f15335f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f15336g;

    /* renamed from: h  reason: collision with root package name */
    public final Function<? super Consumer<Object>, ? extends Map<K, Object>> f15337h;

    public static final class EvictionAction<K, V> implements Consumer<GroupedUnicast<K, V>> {

        /* renamed from: b  reason: collision with root package name */
        public final Queue<GroupedUnicast<K, V>> f15338b;

        public EvictionAction(Queue<GroupedUnicast<K, V>> queue) {
            this.f15338b = queue;
        }

        public void accept(GroupedUnicast<K, V> groupedUnicast) {
            this.f15338b.offer(groupedUnicast);
        }
    }

    public static final class GroupBySubscriber<T, K, V> extends BasicIntQueueSubscription<GroupedFlowable<K, V>> implements FlowableSubscriber<T> {

        /* renamed from: r  reason: collision with root package name */
        public static final Object f15339r = new Object();
        private static final long serialVersionUID = -3688291656102519502L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super GroupedFlowable<K, V>> f15340b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends K> f15341c;

        /* renamed from: d  reason: collision with root package name */
        public final Function<? super T, ? extends V> f15342d;

        /* renamed from: e  reason: collision with root package name */
        public final int f15343e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f15344f;

        /* renamed from: g  reason: collision with root package name */
        public final Map<Object, GroupedUnicast<K, V>> f15345g;

        /* renamed from: h  reason: collision with root package name */
        public final SpscLinkedArrayQueue<GroupedFlowable<K, V>> f15346h;

        /* renamed from: i  reason: collision with root package name */
        public final Queue<GroupedUnicast<K, V>> f15347i;

        /* renamed from: j  reason: collision with root package name */
        public Subscription f15348j;

        /* renamed from: k  reason: collision with root package name */
        public final AtomicBoolean f15349k = new AtomicBoolean();

        /* renamed from: l  reason: collision with root package name */
        public final AtomicLong f15350l = new AtomicLong();

        /* renamed from: m  reason: collision with root package name */
        public final AtomicInteger f15351m = new AtomicInteger(1);

        /* renamed from: n  reason: collision with root package name */
        public Throwable f15352n;

        /* renamed from: o  reason: collision with root package name */
        public volatile boolean f15353o;

        /* renamed from: p  reason: collision with root package name */
        public boolean f15354p;

        /* renamed from: q  reason: collision with root package name */
        public boolean f15355q;

        public GroupBySubscriber(Subscriber<? super GroupedFlowable<K, V>> subscriber, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i11, boolean z11, Map<Object, GroupedUnicast<K, V>> map, Queue<GroupedUnicast<K, V>> queue) {
            this.f15340b = subscriber;
            this.f15341c = function;
            this.f15342d = function2;
            this.f15343e = i11;
            this.f15344f = z11;
            this.f15345g = map;
            this.f15347i = queue;
            this.f15346h = new SpscLinkedArrayQueue<>(i11);
        }

        private void completeEvictions() {
            if (this.f15347i != null) {
                int i11 = 0;
                while (true) {
                    GroupedUnicast poll = this.f15347i.poll();
                    if (poll == null) {
                        break;
                    }
                    poll.onComplete();
                    i11++;
                }
                if (i11 != 0) {
                    this.f15351m.addAndGet(-i11);
                }
            }
        }

        public boolean a(boolean z11, boolean z12, Subscriber<?> subscriber, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            if (this.f15349k.get()) {
                spscLinkedArrayQueue.clear();
                return true;
            } else if (this.f15344f) {
                if (!z11 || !z12) {
                    return false;
                }
                Throwable th2 = this.f15352n;
                if (th2 != null) {
                    subscriber.onError(th2);
                } else {
                    subscriber.onComplete();
                }
                return true;
            } else if (!z11) {
                return false;
            } else {
                Throwable th3 = this.f15352n;
                if (th3 != null) {
                    spscLinkedArrayQueue.clear();
                    subscriber.onError(th3);
                    return true;
                } else if (!z12) {
                    return false;
                } else {
                    subscriber.onComplete();
                    return true;
                }
            }
        }

        public void b() {
            Throwable th2;
            SpscLinkedArrayQueue<GroupedFlowable<K, V>> spscLinkedArrayQueue = this.f15346h;
            Subscriber<? super GroupedFlowable<K, V>> subscriber = this.f15340b;
            int i11 = 1;
            while (!this.f15349k.get()) {
                boolean z11 = this.f15353o;
                if (!z11 || this.f15344f || (th2 = this.f15352n) == null) {
                    subscriber.onNext(null);
                    if (z11) {
                        Throwable th3 = this.f15352n;
                        if (th3 != null) {
                            subscriber.onError(th3);
                            return;
                        } else {
                            subscriber.onComplete();
                            return;
                        }
                    } else {
                        i11 = addAndGet(-i11);
                        if (i11 == 0) {
                            return;
                        }
                    }
                } else {
                    spscLinkedArrayQueue.clear();
                    subscriber.onError(th2);
                    return;
                }
            }
        }

        public void c() {
            int i11;
            boolean z11;
            SpscLinkedArrayQueue<GroupedFlowable<K, V>> spscLinkedArrayQueue = this.f15346h;
            Subscriber<? super GroupedFlowable<K, V>> subscriber = this.f15340b;
            int i12 = 1;
            do {
                long j11 = this.f15350l.get();
                long j12 = 0;
                while (true) {
                    i11 = (j12 > j11 ? 1 : (j12 == j11 ? 0 : -1));
                    if (i11 == 0) {
                        break;
                    }
                    boolean z12 = this.f15353o;
                    GroupedFlowable poll = spscLinkedArrayQueue.poll();
                    if (poll == null) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (!a(z12, z11, subscriber, spscLinkedArrayQueue)) {
                        if (z11) {
                            break;
                        }
                        subscriber.onNext(poll);
                        j12++;
                    } else {
                        return;
                    }
                }
                if (i11 != 0 || !a(this.f15353o, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                    if (j12 != 0) {
                        if (j11 != Long.MAX_VALUE) {
                            this.f15350l.addAndGet(-j12);
                        }
                        this.f15348j.request(j12);
                    }
                    i12 = addAndGet(-i12);
                } else {
                    return;
                }
            } while (i12 != 0);
        }

        public void cancel() {
            if (this.f15349k.compareAndSet(false, true)) {
                completeEvictions();
                if (this.f15351m.decrementAndGet() == 0) {
                    this.f15348j.cancel();
                }
            }
        }

        public void clear() {
            this.f15346h.clear();
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                if (this.f15355q) {
                    b();
                } else {
                    c();
                }
            }
        }

        public boolean isEmpty() {
            return this.f15346h.isEmpty();
        }

        public void onComplete() {
            if (!this.f15354p) {
                for (GroupedUnicast<K, V> onComplete : this.f15345g.values()) {
                    onComplete.onComplete();
                }
                this.f15345g.clear();
                Queue<GroupedUnicast<K, V>> queue = this.f15347i;
                if (queue != null) {
                    queue.clear();
                }
                this.f15354p = true;
                this.f15353o = true;
                drain();
            }
        }

        public void onError(Throwable th2) {
            if (this.f15354p) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f15354p = true;
            for (GroupedUnicast<K, V> onError : this.f15345g.values()) {
                onError.onError(th2);
            }
            this.f15345g.clear();
            Queue<GroupedUnicast<K, V>> queue = this.f15347i;
            if (queue != null) {
                queue.clear();
            }
            this.f15352n = th2;
            this.f15353o = true;
            drain();
        }

        public void onNext(T t11) {
            Object obj;
            boolean z11;
            if (!this.f15354p) {
                SpscLinkedArrayQueue<GroupedFlowable<K, V>> spscLinkedArrayQueue = this.f15346h;
                try {
                    Object apply = this.f15341c.apply(t11);
                    if (apply != null) {
                        obj = apply;
                    } else {
                        obj = f15339r;
                    }
                    GroupedUnicast groupedUnicast = this.f15345g.get(obj);
                    if (groupedUnicast != null) {
                        z11 = false;
                    } else if (!this.f15349k.get()) {
                        groupedUnicast = GroupedUnicast.createWith(apply, this.f15343e, this, this.f15344f);
                        this.f15345g.put(obj, groupedUnicast);
                        this.f15351m.getAndIncrement();
                        z11 = true;
                    } else {
                        return;
                    }
                    try {
                        groupedUnicast.onNext(ObjectHelper.requireNonNull(this.f15342d.apply(t11), "The valueSelector returned null"));
                        completeEvictions();
                        if (z11) {
                            spscLinkedArrayQueue.offer(groupedUnicast);
                            drain();
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.f15348j.cancel();
                        onError(th2);
                    }
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    this.f15348j.cancel();
                    onError(th3);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15348j, subscription)) {
                this.f15348j = subscription;
                this.f15340b.onSubscribe(this);
                subscription.request((long) this.f15343e);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f15350l, j11);
                drain();
            }
        }

        public int requestFusion(int i11) {
            if ((i11 & 2) == 0) {
                return 0;
            }
            this.f15355q = true;
            return 2;
        }

        @Nullable
        public GroupedFlowable<K, V> poll() {
            return this.f15346h.poll();
        }

        public void cancel(K k11) {
            if (k11 == null) {
                k11 = f15339r;
            }
            this.f15345g.remove(k11);
            if (this.f15351m.decrementAndGet() == 0) {
                this.f15348j.cancel();
                if (!this.f15355q && getAndIncrement() == 0) {
                    this.f15346h.clear();
                }
            }
        }
    }

    public static final class GroupedUnicast<K, T> extends GroupedFlowable<K, T> {

        /* renamed from: d  reason: collision with root package name */
        public final State<T, K> f15356d;

        public GroupedUnicast(K k11, State<T, K> state) {
            super(k11);
            this.f15356d = state;
        }

        public static <T, K> GroupedUnicast<K, T> createWith(K k11, int i11, GroupBySubscriber<?, K, T> groupBySubscriber, boolean z11) {
            return new GroupedUnicast<>(k11, new State(i11, groupBySubscriber, k11, z11));
        }

        public void onComplete() {
            this.f15356d.onComplete();
        }

        public void onError(Throwable th2) {
            this.f15356d.onError(th2);
        }

        public void onNext(T t11) {
            this.f15356d.onNext(t11);
        }

        public void subscribeActual(Subscriber<? super T> subscriber) {
            this.f15356d.subscribe(subscriber);
        }
    }

    public static final class State<T, K> extends BasicIntQueueSubscription<T> implements Publisher<T> {
        private static final long serialVersionUID = -3852313036005250360L;

        /* renamed from: b  reason: collision with root package name */
        public final K f15357b;

        /* renamed from: c  reason: collision with root package name */
        public final SpscLinkedArrayQueue<T> f15358c;

        /* renamed from: d  reason: collision with root package name */
        public final GroupBySubscriber<?, K, T> f15359d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f15360e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicLong f15361f = new AtomicLong();

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f15362g;

        /* renamed from: h  reason: collision with root package name */
        public Throwable f15363h;

        /* renamed from: i  reason: collision with root package name */
        public final AtomicBoolean f15364i = new AtomicBoolean();

        /* renamed from: j  reason: collision with root package name */
        public final AtomicReference<Subscriber<? super T>> f15365j = new AtomicReference<>();

        /* renamed from: k  reason: collision with root package name */
        public final AtomicBoolean f15366k = new AtomicBoolean();

        /* renamed from: l  reason: collision with root package name */
        public boolean f15367l;

        /* renamed from: m  reason: collision with root package name */
        public int f15368m;

        public State(int i11, GroupBySubscriber<?, K, T> groupBySubscriber, K k11, boolean z11) {
            this.f15358c = new SpscLinkedArrayQueue<>(i11);
            this.f15359d = groupBySubscriber;
            this.f15357b = k11;
            this.f15360e = z11;
        }

        public boolean a(boolean z11, boolean z12, Subscriber<? super T> subscriber, boolean z13, long j11) {
            if (this.f15364i.get()) {
                while (this.f15358c.poll() != null) {
                    j11++;
                }
                if (j11 != 0) {
                    this.f15359d.f15348j.request(j11);
                }
                return true;
            } else if (!z11) {
                return false;
            } else {
                if (!z13) {
                    Throwable th2 = this.f15363h;
                    if (th2 != null) {
                        this.f15358c.clear();
                        subscriber.onError(th2);
                        return true;
                    } else if (!z12) {
                        return false;
                    } else {
                        subscriber.onComplete();
                        return true;
                    }
                } else if (!z12) {
                    return false;
                } else {
                    Throwable th3 = this.f15363h;
                    if (th3 != null) {
                        subscriber.onError(th3);
                    } else {
                        subscriber.onComplete();
                    }
                    return true;
                }
            }
        }

        public void b() {
            Throwable th2;
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.f15358c;
            Subscriber subscriber = this.f15365j.get();
            int i11 = 1;
            while (true) {
                if (subscriber != null) {
                    if (!this.f15364i.get()) {
                        boolean z11 = this.f15362g;
                        if (!z11 || this.f15360e || (th2 = this.f15363h) == null) {
                            subscriber.onNext(null);
                            if (z11) {
                                Throwable th3 = this.f15363h;
                                if (th3 != null) {
                                    subscriber.onError(th3);
                                    return;
                                } else {
                                    subscriber.onComplete();
                                    return;
                                }
                            }
                        } else {
                            spscLinkedArrayQueue.clear();
                            subscriber.onError(th2);
                            return;
                        }
                    } else {
                        return;
                    }
                }
                i11 = addAndGet(-i11);
                if (i11 != 0) {
                    if (subscriber == null) {
                        subscriber = this.f15365j.get();
                    }
                } else {
                    return;
                }
            }
        }

        public void c() {
            int i11;
            boolean z11;
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.f15358c;
            boolean z12 = this.f15360e;
            Subscriber subscriber = this.f15365j.get();
            int i12 = 1;
            while (true) {
                if (subscriber != null) {
                    long j11 = this.f15361f.get();
                    long j12 = 0;
                    while (true) {
                        i11 = (j12 > j11 ? 1 : (j12 == j11 ? 0 : -1));
                        if (i11 == 0) {
                            break;
                        }
                        boolean z13 = this.f15362g;
                        T poll = spscLinkedArrayQueue.poll();
                        if (poll == null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        T t11 = poll;
                        long j13 = j12;
                        if (!a(z13, z11, subscriber, z12, j12)) {
                            if (z11) {
                                j12 = j13;
                                break;
                            } else {
                                subscriber.onNext(t11);
                                j12 = j13 + 1;
                            }
                        } else {
                            return;
                        }
                    }
                    if (i11 == 0) {
                        long j14 = j12;
                        if (!a(this.f15362g, spscLinkedArrayQueue.isEmpty(), subscriber, z12, j12)) {
                            j12 = j14;
                        } else {
                            return;
                        }
                    }
                    if (j12 != 0) {
                        if (j11 != Long.MAX_VALUE) {
                            this.f15361f.addAndGet(-j12);
                        }
                        this.f15359d.f15348j.request(j12);
                    }
                }
                i12 = addAndGet(-i12);
                if (i12 != 0) {
                    if (subscriber == null) {
                        subscriber = this.f15365j.get();
                    }
                } else {
                    return;
                }
            }
        }

        public void cancel() {
            if (this.f15364i.compareAndSet(false, true)) {
                this.f15359d.cancel(this.f15357b);
                drain();
            }
        }

        public void clear() {
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.f15358c;
            while (spscLinkedArrayQueue.poll() != null) {
                this.f15368m++;
            }
            d();
        }

        public void d() {
            int i11 = this.f15368m;
            if (i11 != 0) {
                this.f15368m = 0;
                this.f15359d.f15348j.request((long) i11);
            }
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                if (this.f15367l) {
                    b();
                } else {
                    c();
                }
            }
        }

        public boolean isEmpty() {
            if (!this.f15358c.isEmpty()) {
                return false;
            }
            d();
            return true;
        }

        public void onComplete() {
            this.f15362g = true;
            drain();
        }

        public void onError(Throwable th2) {
            this.f15363h = th2;
            this.f15362g = true;
            drain();
        }

        public void onNext(T t11) {
            this.f15358c.offer(t11);
            drain();
        }

        @Nullable
        public T poll() {
            T poll = this.f15358c.poll();
            if (poll != null) {
                this.f15368m++;
                return poll;
            }
            d();
            return null;
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f15361f, j11);
                drain();
            }
        }

        public int requestFusion(int i11) {
            if ((i11 & 2) == 0) {
                return 0;
            }
            this.f15367l = true;
            return 2;
        }

        public void subscribe(Subscriber<? super T> subscriber) {
            if (this.f15366k.compareAndSet(false, true)) {
                subscriber.onSubscribe(this);
                this.f15365j.lazySet(subscriber);
                drain();
                return;
            }
            EmptySubscription.error(new IllegalStateException("Only one Subscriber allowed!"), subscriber);
        }
    }

    public FlowableGroupBy(Flowable<T> flowable, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i11, boolean z11, Function<? super Consumer<Object>, ? extends Map<K, Object>> function3) {
        super(flowable);
        this.f15333d = function;
        this.f15334e = function2;
        this.f15335f = i11;
        this.f15336g = z11;
        this.f15337h = function3;
    }

    public void subscribeActual(Subscriber<? super GroupedFlowable<K, V>> subscriber) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        Map map;
        try {
            if (this.f15337h == null) {
                map = new ConcurrentHashMap();
                concurrentLinkedQueue = null;
            } else {
                concurrentLinkedQueue = new ConcurrentLinkedQueue();
                map = (Map) this.f15337h.apply(new EvictionAction(concurrentLinkedQueue));
            }
            this.f14763c.subscribe(new GroupBySubscriber(subscriber, this.f15333d, this.f15334e, this.f15335f, this.f15336g, map, concurrentLinkedQueue));
        } catch (Exception e11) {
            Exceptions.throwIfFatal(e11);
            subscriber.onSubscribe(EmptyComponent.INSTANCE);
            subscriber.onError(e11);
        }
    }
}
