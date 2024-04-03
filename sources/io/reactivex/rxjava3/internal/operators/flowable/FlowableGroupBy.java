package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.flowables.GroupedFlowable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.EmptyComponent;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
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
    public final Function<? super T, ? extends K> f19850d;

    /* renamed from: e  reason: collision with root package name */
    public final Function<? super T, ? extends V> f19851e;

    /* renamed from: f  reason: collision with root package name */
    public final int f19852f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f19853g;

    /* renamed from: h  reason: collision with root package name */
    public final Function<? super Consumer<Object>, ? extends Map<K, Object>> f19854h;

    public static final class EvictionAction<K, V> implements Consumer<GroupedUnicast<K, V>> {

        /* renamed from: b  reason: collision with root package name */
        public final Queue<GroupedUnicast<K, V>> f19855b;

        public EvictionAction(Queue<GroupedUnicast<K, V>> queue) {
            this.f19855b = queue;
        }

        public void accept(GroupedUnicast<K, V> groupedUnicast) {
            this.f19855b.offer(groupedUnicast);
        }
    }

    public static final class GroupedUnicast<K, T> extends GroupedFlowable<K, T> {

        /* renamed from: d  reason: collision with root package name */
        public final State<T, K> f19871d;

        public GroupedUnicast(K k11, State<T, K> state) {
            super(k11);
            this.f19871d = state;
        }

        public static <T, K> GroupedUnicast<K, T> createWith(K k11, int i11, GroupBySubscriber<?, K, T> groupBySubscriber, boolean z11) {
            return new GroupedUnicast<>(k11, new State(i11, groupBySubscriber, k11, z11));
        }

        public void onComplete() {
            this.f19871d.onComplete();
        }

        public void onError(Throwable th2) {
            this.f19871d.onError(th2);
        }

        public void onNext(T t11) {
            this.f19871d.onNext(t11);
        }

        public void subscribeActual(Subscriber<? super T> subscriber) {
            this.f19871d.subscribe(subscriber);
        }
    }

    public static final class State<T, K> extends BasicIntQueueSubscription<T> implements Publisher<T> {
        private static final long serialVersionUID = -3852313036005250360L;

        /* renamed from: b  reason: collision with root package name */
        public final K f19872b;

        /* renamed from: c  reason: collision with root package name */
        public final SpscLinkedArrayQueue<T> f19873c;

        /* renamed from: d  reason: collision with root package name */
        public final GroupBySubscriber<?, K, T> f19874d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f19875e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicLong f19876f = new AtomicLong();

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f19877g;

        /* renamed from: h  reason: collision with root package name */
        public Throwable f19878h;

        /* renamed from: i  reason: collision with root package name */
        public final AtomicBoolean f19879i = new AtomicBoolean();

        /* renamed from: j  reason: collision with root package name */
        public final AtomicReference<Subscriber<? super T>> f19880j = new AtomicReference<>();

        /* renamed from: k  reason: collision with root package name */
        public boolean f19881k;

        /* renamed from: l  reason: collision with root package name */
        public int f19882l;

        /* renamed from: m  reason: collision with root package name */
        public final AtomicInteger f19883m = new AtomicInteger();

        /* renamed from: n  reason: collision with root package name */
        public final AtomicBoolean f19884n = new AtomicBoolean();

        public State(int i11, GroupBySubscriber<?, K, T> groupBySubscriber, K k11, boolean z11) {
            this.f19873c = new SpscLinkedArrayQueue<>(i11);
            this.f19874d = groupBySubscriber;
            this.f19872b = k11;
            this.f19875e = z11;
        }

        public void a() {
            if ((this.f19883m.get() & 2) == 0 && this.f19884n.compareAndSet(false, true)) {
                this.f19874d.cancel(this.f19872b);
            }
        }

        public boolean b(boolean z11, boolean z12, Subscriber<? super T> subscriber, boolean z13, long j11, boolean z14) {
            if (this.f19879i.get()) {
                c(j11, z14);
                return true;
            } else if (!z11) {
                return false;
            } else {
                if (!z13) {
                    Throwable th2 = this.f19878h;
                    if (th2 != null) {
                        this.f19873c.clear();
                        this.f19879i.lazySet(true);
                        subscriber.onError(th2);
                        return true;
                    } else if (!z12) {
                        return false;
                    } else {
                        this.f19879i.lazySet(true);
                        subscriber.onComplete();
                        f(j11, z14);
                        return true;
                    }
                } else if (!z12) {
                    return false;
                } else {
                    this.f19879i.lazySet(true);
                    Throwable th3 = this.f19878h;
                    if (th3 != null) {
                        subscriber.onError(th3);
                    } else {
                        subscriber.onComplete();
                        f(j11, z14);
                    }
                    return true;
                }
            }
        }

        public void c(long j11, boolean z11) {
            while (this.f19873c.poll() != null) {
                j11++;
            }
            f(j11, z11);
        }

        public void cancel() {
            if (this.f19879i.compareAndSet(false, true)) {
                a();
                drain();
            }
        }

        public void clear() {
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.f19873c;
            while (spscLinkedArrayQueue.poll() != null) {
                this.f19882l++;
            }
            j();
        }

        public void d() {
            Throwable th2;
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.f19873c;
            Subscriber subscriber = this.f19880j.get();
            int i11 = 1;
            while (true) {
                if (subscriber != null) {
                    if (!this.f19879i.get()) {
                        boolean z11 = this.f19877g;
                        if (!z11 || this.f19875e || (th2 = this.f19878h) == null) {
                            subscriber.onNext(null);
                            if (z11) {
                                Throwable th3 = this.f19878h;
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
                        subscriber = this.f19880j.get();
                    }
                } else {
                    return;
                }
            }
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                if (this.f19881k) {
                    d();
                } else {
                    e();
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0066, code lost:
            if (r18 != 0) goto L_0x007f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0068, code lost:
            r21 = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0079, code lost:
            if (b(r8.f19877g, r9.isEmpty(), r13, r10, r5, false) == false) goto L_0x007c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x007c, code lost:
            r3 = r21;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x007f, code lost:
            r3 = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0082, code lost:
            if (r3 == r23) goto L_0x008c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0084, code lost:
            io.reactivex.rxjava3.internal.util.BackpressureHelper.produced(r8.f19876f, r3);
            g(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0012, code lost:
            continue;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void e() {
            /*
                r25 = this;
                r8 = r25
                io.reactivex.rxjava3.operators.SpscLinkedArrayQueue<T> r9 = r8.f19873c
                boolean r10 = r8.f19875e
                java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscriber<? super T>> r0 = r8.f19880j
                java.lang.Object r0 = r0.get()
                org.reactivestreams.Subscriber r0 = (org.reactivestreams.Subscriber) r0
                java.util.concurrent.atomic.AtomicBoolean r11 = r8.f19879i
                r13 = r0
                r14 = 1
            L_0x0012:
                boolean r0 = r11.get()
                r15 = 0
                r5 = 0
                if (r0 == 0) goto L_0x0020
                r8.c(r5, r15)
                goto L_0x008c
            L_0x0020:
                if (r13 == 0) goto L_0x008c
                java.util.concurrent.atomic.AtomicLong r0 = r8.f19876f
                long r16 = r0.get()
                r3 = r5
            L_0x0029:
                int r18 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
                if (r18 == 0) goto L_0x0063
                boolean r1 = r8.f19877g
                java.lang.Object r7 = r9.poll()
                if (r7 != 0) goto L_0x0038
                r19 = 1
                goto L_0x003a
            L_0x0038:
                r19 = r15
            L_0x003a:
                r20 = r19 ^ 1
                r0 = r25
                r2 = r19
                r21 = r3
                r3 = r13
                r4 = r10
                r23 = r5
                r5 = r21
                r12 = r7
                r7 = r20
                boolean r0 = r0.b(r1, r2, r3, r4, r5, r7)
                if (r0 == 0) goto L_0x0052
                goto L_0x0012
            L_0x0052:
                if (r19 == 0) goto L_0x0057
                r5 = r21
                goto L_0x0066
            L_0x0057:
                r13.onNext(r12)
                r0 = 1
                r5 = r21
                long r3 = r5 + r0
                r5 = r23
                goto L_0x0029
            L_0x0063:
                r23 = r5
                r5 = r3
            L_0x0066:
                if (r18 != 0) goto L_0x007f
                boolean r1 = r8.f19877g
                boolean r2 = r9.isEmpty()
                r7 = 0
                r0 = r25
                r3 = r13
                r4 = r10
                r21 = r5
                boolean r0 = r0.b(r1, r2, r3, r4, r5, r7)
                if (r0 == 0) goto L_0x007c
                goto L_0x0012
            L_0x007c:
                r3 = r21
                goto L_0x0080
            L_0x007f:
                r3 = r5
            L_0x0080:
                int r0 = (r3 > r23 ? 1 : (r3 == r23 ? 0 : -1))
                if (r0 == 0) goto L_0x008c
                java.util.concurrent.atomic.AtomicLong r0 = r8.f19876f
                io.reactivex.rxjava3.internal.util.BackpressureHelper.produced(r0, r3)
                r8.g(r3)
            L_0x008c:
                int r0 = -r14
                int r14 = r8.addAndGet(r0)
                if (r14 != 0) goto L_0x0094
                return
            L_0x0094:
                if (r13 != 0) goto L_0x0012
                java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscriber<? super T>> r0 = r8.f19880j
                java.lang.Object r0 = r0.get()
                r13 = r0
                org.reactivestreams.Subscriber r13 = (org.reactivestreams.Subscriber) r13
                goto L_0x0012
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableGroupBy.State.e():void");
        }

        public void f(long j11, boolean z11) {
            if (z11) {
                j11++;
            }
            if (j11 != 0) {
                g(j11);
            }
        }

        public void g(long j11) {
            if ((this.f19883m.get() & 2) == 0) {
                this.f19874d.b(j11);
            }
        }

        public boolean h() {
            return this.f19883m.get() == 0 && this.f19883m.compareAndSet(0, 2);
        }

        public boolean i() {
            boolean compareAndSet = this.f19884n.compareAndSet(false, true);
            this.f19877g = true;
            drain();
            return compareAndSet;
        }

        public boolean isEmpty() {
            if (this.f19873c.isEmpty()) {
                j();
                return true;
            }
            j();
            return false;
        }

        public void j() {
            int i11 = this.f19882l;
            if (i11 != 0) {
                this.f19882l = 0;
                g((long) i11);
            }
        }

        public void onComplete() {
            this.f19877g = true;
            drain();
        }

        public void onError(Throwable th2) {
            this.f19878h = th2;
            this.f19877g = true;
            drain();
        }

        public void onNext(T t11) {
            this.f19873c.offer(t11);
            drain();
        }

        @Nullable
        public T poll() {
            T poll = this.f19873c.poll();
            if (poll != null) {
                this.f19882l++;
                return poll;
            }
            j();
            return null;
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f19876f, j11);
                drain();
            }
        }

        public int requestFusion(int i11) {
            return 0;
        }

        public void subscribe(Subscriber<? super T> subscriber) {
            int i11;
            do {
                i11 = this.f19883m.get();
                if ((i11 & 1) != 0) {
                    EmptySubscription.error(new IllegalStateException("Only one Subscriber allowed!"), subscriber);
                    return;
                }
            } while (!this.f19883m.compareAndSet(i11, i11 | 1));
            subscriber.onSubscribe(this);
            this.f19880j.lazySet(subscriber);
            if (this.f19879i.get()) {
                this.f19880j.lazySet((Object) null);
            } else {
                drain();
            }
        }
    }

    public FlowableGroupBy(Flowable<T> flowable, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i11, boolean z11, Function<? super Consumer<Object>, ? extends Map<K, Object>> function3) {
        super(flowable);
        this.f19850d = function;
        this.f19851e = function2;
        this.f19852f = i11;
        this.f19853g = z11;
        this.f19854h = function3;
    }

    public void subscribeActual(Subscriber<? super GroupedFlowable<K, V>> subscriber) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        Map map;
        try {
            if (this.f19854h == null) {
                map = new ConcurrentHashMap();
                concurrentLinkedQueue = null;
            } else {
                concurrentLinkedQueue = new ConcurrentLinkedQueue();
                map = (Map) this.f19854h.apply(new EvictionAction(concurrentLinkedQueue));
            }
            this.f19260c.subscribe(new GroupBySubscriber(subscriber, this.f19850d, this.f19851e, this.f19852f, this.f19853g, map, concurrentLinkedQueue));
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            subscriber.onSubscribe(EmptyComponent.INSTANCE);
            subscriber.onError(th2);
        }
    }

    public static final class GroupBySubscriber<T, K, V> extends AtomicLong implements FlowableSubscriber<T>, Subscription {

        /* renamed from: p  reason: collision with root package name */
        public static final Object f19856p = new Object();
        private static final long serialVersionUID = -3688291656102519502L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super GroupedFlowable<K, V>> f19857b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends K> f19858c;

        /* renamed from: d  reason: collision with root package name */
        public final Function<? super T, ? extends V> f19859d;

        /* renamed from: e  reason: collision with root package name */
        public final int f19860e;

        /* renamed from: f  reason: collision with root package name */
        public final int f19861f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f19862g;

        /* renamed from: h  reason: collision with root package name */
        public final Map<Object, GroupedUnicast<K, V>> f19863h;

        /* renamed from: i  reason: collision with root package name */
        public final Queue<GroupedUnicast<K, V>> f19864i;

        /* renamed from: j  reason: collision with root package name */
        public Subscription f19865j;

        /* renamed from: k  reason: collision with root package name */
        public final AtomicBoolean f19866k = new AtomicBoolean();

        /* renamed from: l  reason: collision with root package name */
        public long f19867l;

        /* renamed from: m  reason: collision with root package name */
        public final AtomicInteger f19868m = new AtomicInteger(1);

        /* renamed from: n  reason: collision with root package name */
        public final AtomicLong f19869n = new AtomicLong();

        /* renamed from: o  reason: collision with root package name */
        public boolean f19870o;

        public GroupBySubscriber(Subscriber<? super GroupedFlowable<K, V>> subscriber, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i11, boolean z11, Map<Object, GroupedUnicast<K, V>> map, Queue<GroupedUnicast<K, V>> queue) {
            this.f19857b = subscriber;
            this.f19858c = function;
            this.f19859d = function2;
            this.f19860e = i11;
            this.f19861f = i11 - (i11 >> 2);
            this.f19862g = z11;
            this.f19863h = map;
            this.f19864i = queue;
        }

        public static String a(long j11) {
            return "Unable to emit a new group (#" + j11 + ") due to lack of requests. Please make sure the downstream can always accept a new group as well as each group is consumed in order for the whole operator to be able to proceed.";
        }

        private void completeEvictions() {
            if (this.f19864i != null) {
                int i11 = 0;
                while (true) {
                    GroupedUnicast poll = this.f19864i.poll();
                    if (poll == null) {
                        break;
                    } else if (poll.f19871d.i()) {
                        i11++;
                    }
                }
                if (i11 != 0) {
                    this.f19868m.addAndGet(-i11);
                }
            }
        }

        public void b(long j11) {
            long j12;
            long addCap;
            AtomicLong atomicLong = this.f19869n;
            int i11 = this.f19861f;
            do {
                j12 = atomicLong.get();
                addCap = BackpressureHelper.addCap(j12, j11);
            } while (!atomicLong.compareAndSet(j12, addCap));
            while (true) {
                long j13 = (long) i11;
                if (addCap >= j13) {
                    if (atomicLong.compareAndSet(addCap, addCap - j13)) {
                        this.f19865j.request(j13);
                    }
                    addCap = atomicLong.get();
                } else {
                    return;
                }
            }
        }

        public void cancel() {
            if (this.f19866k.compareAndSet(false, true)) {
                completeEvictions();
                if (this.f19868m.decrementAndGet() == 0) {
                    this.f19865j.cancel();
                }
            }
        }

        public void onComplete() {
            if (!this.f19870o) {
                for (GroupedUnicast<K, V> onComplete : this.f19863h.values()) {
                    onComplete.onComplete();
                }
                this.f19863h.clear();
                completeEvictions();
                this.f19870o = true;
                this.f19857b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f19870o) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f19870o = true;
            for (GroupedUnicast<K, V> onError : this.f19863h.values()) {
                onError.onError(th2);
            }
            this.f19863h.clear();
            completeEvictions();
            this.f19857b.onError(th2);
        }

        public void onNext(T t11) {
            Object obj;
            boolean z11;
            if (!this.f19870o) {
                try {
                    Object apply = this.f19858c.apply(t11);
                    if (apply != null) {
                        obj = apply;
                    } else {
                        obj = f19856p;
                    }
                    GroupedUnicast groupedUnicast = this.f19863h.get(obj);
                    if (groupedUnicast != null) {
                        z11 = false;
                    } else if (!this.f19866k.get()) {
                        groupedUnicast = GroupedUnicast.createWith(apply, this.f19860e, this, this.f19862g);
                        this.f19863h.put(obj, groupedUnicast);
                        this.f19868m.getAndIncrement();
                        z11 = true;
                    } else {
                        return;
                    }
                    try {
                        groupedUnicast.onNext(ExceptionHelper.nullCheck(this.f19859d.apply(t11), "The valueSelector returned a null value."));
                        completeEvictions();
                        if (!z11) {
                            return;
                        }
                        if (this.f19867l != get()) {
                            this.f19867l++;
                            this.f19857b.onNext(groupedUnicast);
                            if (groupedUnicast.f19871d.h()) {
                                cancel(apply);
                                groupedUnicast.onComplete();
                                b(1);
                                return;
                            }
                            return;
                        }
                        this.f19865j.cancel();
                        onError(new MissingBackpressureException(a(this.f19867l)));
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.f19865j.cancel();
                        if (z11) {
                            if (this.f19867l != get()) {
                                this.f19857b.onNext(groupedUnicast);
                            } else {
                                MissingBackpressureException missingBackpressureException = new MissingBackpressureException(a(this.f19867l));
                                missingBackpressureException.initCause(th2);
                                onError(missingBackpressureException);
                                return;
                            }
                        }
                        onError(th2);
                    }
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    this.f19865j.cancel();
                    onError(th3);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f19865j, subscription)) {
                this.f19865j = subscription;
                this.f19857b.onSubscribe(this);
                subscription.request((long) this.f19860e);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this, j11);
            }
        }

        public void cancel(K k11) {
            if (k11 == null) {
                k11 = f19856p;
            }
            if (this.f19863h.remove(k11) != null && this.f19868m.decrementAndGet() == 0) {
                this.f19865j.cancel();
            }
        }
    }
}
