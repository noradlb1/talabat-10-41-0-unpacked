package io.reactivex.rxjava3.processors;

import i.b;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ReplayProcessor<T> extends FlowableProcessor<T> {
    private static final Object[] EMPTY_ARRAY = new Object[0];

    /* renamed from: f  reason: collision with root package name */
    public static final ReplaySubscription[] f23310f = new ReplaySubscription[0];

    /* renamed from: g  reason: collision with root package name */
    public static final ReplaySubscription[] f23311g = new ReplaySubscription[0];

    /* renamed from: c  reason: collision with root package name */
    public final ReplayBuffer<T> f23312c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f23313d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<ReplaySubscription<T>[]> f23314e = new AtomicReference<>(f23310f);

    public static final class Node<T> extends AtomicReference<Node<T>> {
        private static final long serialVersionUID = 6404226426336033100L;

        /* renamed from: b  reason: collision with root package name */
        public final T f23315b;

        public Node(T t11) {
            this.f23315b = t11;
        }
    }

    public interface ReplayBuffer<T> {
        void complete();

        void error(Throwable th2);

        Throwable getError();

        @Nullable
        T getValue();

        T[] getValues(T[] tArr);

        boolean isDone();

        void next(T t11);

        void replay(ReplaySubscription<T> replaySubscription);

        int size();

        void trimHead();
    }

    public static final class ReplaySubscription<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 466549804534799122L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f23316b;

        /* renamed from: c  reason: collision with root package name */
        public final ReplayProcessor<T> f23317c;

        /* renamed from: d  reason: collision with root package name */
        public Object f23318d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicLong f23319e = new AtomicLong();

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f23320f;

        /* renamed from: g  reason: collision with root package name */
        public long f23321g;

        public ReplaySubscription(Subscriber<? super T> subscriber, ReplayProcessor<T> replayProcessor) {
            this.f23316b = subscriber;
            this.f23317c = replayProcessor;
        }

        public void cancel() {
            if (!this.f23320f) {
                this.f23320f = true;
                this.f23317c.c(this);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f23319e, j11);
                this.f23317c.f23312c.replay(this);
            }
        }
    }

    public static final class SizeAndTimeBoundReplayBuffer<T> implements ReplayBuffer<T> {

        /* renamed from: a  reason: collision with root package name */
        public final int f23322a;

        /* renamed from: b  reason: collision with root package name */
        public final long f23323b;

        /* renamed from: c  reason: collision with root package name */
        public final TimeUnit f23324c;

        /* renamed from: d  reason: collision with root package name */
        public final Scheduler f23325d;

        /* renamed from: e  reason: collision with root package name */
        public int f23326e;

        /* renamed from: f  reason: collision with root package name */
        public volatile TimedNode<T> f23327f;

        /* renamed from: g  reason: collision with root package name */
        public TimedNode<T> f23328g;

        /* renamed from: h  reason: collision with root package name */
        public Throwable f23329h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f23330i;

        public SizeAndTimeBoundReplayBuffer(int i11, long j11, TimeUnit timeUnit, Scheduler scheduler) {
            this.f23322a = i11;
            this.f23323b = j11;
            this.f23324c = timeUnit;
            this.f23325d = scheduler;
            TimedNode<T> timedNode = new TimedNode<>(null, 0);
            this.f23328g = timedNode;
            this.f23327f = timedNode;
        }

        public TimedNode<T> a() {
            TimedNode<T> timedNode;
            TimedNode<T> timedNode2 = this.f23327f;
            long now = this.f23325d.now(this.f23324c) - this.f23323b;
            Object obj = timedNode2.get();
            while (true) {
                TimedNode<T> timedNode3 = (TimedNode) obj;
                timedNode = timedNode2;
                timedNode2 = timedNode3;
                if (timedNode2 == null || timedNode2.f23338c > now) {
                    return timedNode;
                }
                obj = timedNode2.get();
            }
            return timedNode;
        }

        public int b(TimedNode<T> timedNode) {
            int i11 = 0;
            while (i11 != Integer.MAX_VALUE && (timedNode = (TimedNode) timedNode.get()) != null) {
                i11++;
            }
            return i11;
        }

        public void c() {
            int i11 = this.f23326e;
            if (i11 > this.f23322a) {
                this.f23326e = i11 - 1;
                this.f23327f = (TimedNode) this.f23327f.get();
            }
            long now = this.f23325d.now(this.f23324c) - this.f23323b;
            TimedNode<T> timedNode = this.f23327f;
            while (this.f23326e > 1) {
                TimedNode<T> timedNode2 = (TimedNode) timedNode.get();
                if (timedNode2.f23338c > now) {
                    this.f23327f = timedNode;
                    return;
                } else {
                    this.f23326e--;
                    timedNode = timedNode2;
                }
            }
            this.f23327f = timedNode;
        }

        public void complete() {
            d();
            this.f23330i = true;
        }

        public void d() {
            long now = this.f23325d.now(this.f23324c) - this.f23323b;
            TimedNode<T> timedNode = this.f23327f;
            while (true) {
                TimedNode<T> timedNode2 = (TimedNode) timedNode.get();
                if (timedNode2 == null) {
                    if (timedNode.f23337b != null) {
                        this.f23327f = new TimedNode<>(null, 0);
                        return;
                    } else {
                        this.f23327f = timedNode;
                        return;
                    }
                } else if (timedNode2.f23338c <= now) {
                    timedNode = timedNode2;
                } else if (timedNode.f23337b != null) {
                    TimedNode<T> timedNode3 = new TimedNode<>(null, 0);
                    timedNode3.lazySet(timedNode.get());
                    this.f23327f = timedNode3;
                    return;
                } else {
                    this.f23327f = timedNode;
                    return;
                }
            }
        }

        public void error(Throwable th2) {
            d();
            this.f23329h = th2;
            this.f23330i = true;
        }

        public Throwable getError() {
            return this.f23329h;
        }

        @Nullable
        public T getValue() {
            TimedNode<T> timedNode = this.f23327f;
            while (true) {
                TimedNode<T> timedNode2 = (TimedNode) timedNode.get();
                if (timedNode2 == null) {
                    break;
                }
                timedNode = timedNode2;
            }
            if (timedNode.f23338c < this.f23325d.now(this.f23324c) - this.f23323b) {
                return null;
            }
            return timedNode.f23337b;
        }

        public T[] getValues(T[] tArr) {
            TimedNode a11 = a();
            int b11 = b(a11);
            if (b11 != 0) {
                if (tArr.length < b11) {
                    tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), b11);
                }
                for (int i11 = 0; i11 != b11; i11++) {
                    a11 = (TimedNode) a11.get();
                    tArr[i11] = a11.f23337b;
                }
                if (tArr.length > b11) {
                    tArr[b11] = null;
                }
            } else if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }

        public boolean isDone() {
            return this.f23330i;
        }

        public void next(T t11) {
            TimedNode<T> timedNode = new TimedNode<>(t11, this.f23325d.now(this.f23324c));
            TimedNode<T> timedNode2 = this.f23328g;
            this.f23328g = timedNode;
            this.f23326e++;
            timedNode2.set(timedNode);
            c();
        }

        public void replay(ReplaySubscription<T> replaySubscription) {
            int i11;
            boolean z11;
            if (replaySubscription.getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = replaySubscription.f23316b;
                TimedNode timedNode = (TimedNode) replaySubscription.f23318d;
                if (timedNode == null) {
                    timedNode = a();
                }
                long j11 = replaySubscription.f23321g;
                int i12 = 1;
                do {
                    long j12 = replaySubscription.f23319e.get();
                    while (true) {
                        i11 = (j11 > j12 ? 1 : (j11 == j12 ? 0 : -1));
                        if (i11 == 0) {
                            break;
                        } else if (replaySubscription.f23320f) {
                            replaySubscription.f23318d = null;
                            return;
                        } else {
                            boolean z12 = this.f23330i;
                            TimedNode timedNode2 = (TimedNode) timedNode.get();
                            if (timedNode2 == null) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (z12 && z11) {
                                replaySubscription.f23318d = null;
                                replaySubscription.f23320f = true;
                                Throwable th2 = this.f23329h;
                                if (th2 == null) {
                                    subscriber.onComplete();
                                    return;
                                } else {
                                    subscriber.onError(th2);
                                    return;
                                }
                            } else if (z11) {
                                break;
                            } else {
                                subscriber.onNext(timedNode2.f23337b);
                                j11++;
                                timedNode = timedNode2;
                            }
                        }
                    }
                    if (i11 == 0) {
                        if (replaySubscription.f23320f) {
                            replaySubscription.f23318d = null;
                            return;
                        } else if (this.f23330i && timedNode.get() == null) {
                            replaySubscription.f23318d = null;
                            replaySubscription.f23320f = true;
                            Throwable th3 = this.f23329h;
                            if (th3 == null) {
                                subscriber.onComplete();
                                return;
                            } else {
                                subscriber.onError(th3);
                                return;
                            }
                        }
                    }
                    replaySubscription.f23318d = timedNode;
                    replaySubscription.f23321g = j11;
                    i12 = replaySubscription.addAndGet(-i12);
                } while (i12 != 0);
            }
        }

        public int size() {
            return b(a());
        }

        public void trimHead() {
            if (this.f23327f.f23337b != null) {
                TimedNode<T> timedNode = new TimedNode<>(null, 0);
                timedNode.lazySet(this.f23327f.get());
                this.f23327f = timedNode;
            }
        }
    }

    public static final class SizeBoundReplayBuffer<T> implements ReplayBuffer<T> {

        /* renamed from: a  reason: collision with root package name */
        public final int f23331a;

        /* renamed from: b  reason: collision with root package name */
        public int f23332b;

        /* renamed from: c  reason: collision with root package name */
        public volatile Node<T> f23333c;

        /* renamed from: d  reason: collision with root package name */
        public Node<T> f23334d;

        /* renamed from: e  reason: collision with root package name */
        public Throwable f23335e;

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f23336f;

        public SizeBoundReplayBuffer(int i11) {
            this.f23331a = i11;
            Node<T> node = new Node<>(null);
            this.f23334d = node;
            this.f23333c = node;
        }

        public void a() {
            int i11 = this.f23332b;
            if (i11 > this.f23331a) {
                this.f23332b = i11 - 1;
                this.f23333c = (Node) this.f23333c.get();
            }
        }

        public void complete() {
            trimHead();
            this.f23336f = true;
        }

        public void error(Throwable th2) {
            this.f23335e = th2;
            trimHead();
            this.f23336f = true;
        }

        public Throwable getError() {
            return this.f23335e;
        }

        public T getValue() {
            Node<T> node = this.f23333c;
            while (true) {
                Node<T> node2 = (Node) node.get();
                if (node2 == null) {
                    return node.f23315b;
                }
                node = node2;
            }
        }

        public T[] getValues(T[] tArr) {
            Node<T> node = this.f23333c;
            Node<T> node2 = node;
            int i11 = 0;
            while (true) {
                node2 = (Node) node2.get();
                if (node2 == null) {
                    break;
                }
                i11++;
            }
            if (tArr.length < i11) {
                tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i11);
            }
            for (int i12 = 0; i12 < i11; i12++) {
                node = (Node) node.get();
                tArr[i12] = node.f23315b;
            }
            if (tArr.length > i11) {
                tArr[i11] = null;
            }
            return tArr;
        }

        public boolean isDone() {
            return this.f23336f;
        }

        public void next(T t11) {
            Node<T> node = new Node<>(t11);
            Node<T> node2 = this.f23334d;
            this.f23334d = node;
            this.f23332b++;
            node2.set(node);
            a();
        }

        public void replay(ReplaySubscription<T> replaySubscription) {
            int i11;
            boolean z11;
            if (replaySubscription.getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = replaySubscription.f23316b;
                Node<T> node = (Node) replaySubscription.f23318d;
                if (node == null) {
                    node = this.f23333c;
                }
                long j11 = replaySubscription.f23321g;
                int i12 = 1;
                do {
                    long j12 = replaySubscription.f23319e.get();
                    while (true) {
                        i11 = (j11 > j12 ? 1 : (j11 == j12 ? 0 : -1));
                        if (i11 == 0) {
                            break;
                        } else if (replaySubscription.f23320f) {
                            replaySubscription.f23318d = null;
                            return;
                        } else {
                            boolean z12 = this.f23336f;
                            Node<T> node2 = (Node) node.get();
                            if (node2 == null) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (z12 && z11) {
                                replaySubscription.f23318d = null;
                                replaySubscription.f23320f = true;
                                Throwable th2 = this.f23335e;
                                if (th2 == null) {
                                    subscriber.onComplete();
                                    return;
                                } else {
                                    subscriber.onError(th2);
                                    return;
                                }
                            } else if (z11) {
                                break;
                            } else {
                                subscriber.onNext(node2.f23315b);
                                j11++;
                                node = node2;
                            }
                        }
                    }
                    if (i11 == 0) {
                        if (replaySubscription.f23320f) {
                            replaySubscription.f23318d = null;
                            return;
                        } else if (this.f23336f && node.get() == null) {
                            replaySubscription.f23318d = null;
                            replaySubscription.f23320f = true;
                            Throwable th3 = this.f23335e;
                            if (th3 == null) {
                                subscriber.onComplete();
                                return;
                            } else {
                                subscriber.onError(th3);
                                return;
                            }
                        }
                    }
                    replaySubscription.f23318d = node;
                    replaySubscription.f23321g = j11;
                    i12 = replaySubscription.addAndGet(-i12);
                } while (i12 != 0);
            }
        }

        public int size() {
            Node<T> node = this.f23333c;
            int i11 = 0;
            while (i11 != Integer.MAX_VALUE && (node = (Node) node.get()) != null) {
                i11++;
            }
            return i11;
        }

        public void trimHead() {
            if (this.f23333c.f23315b != null) {
                Node<T> node = new Node<>(null);
                node.lazySet(this.f23333c.get());
                this.f23333c = node;
            }
        }
    }

    public static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
        private static final long serialVersionUID = 6404226426336033100L;

        /* renamed from: b  reason: collision with root package name */
        public final T f23337b;

        /* renamed from: c  reason: collision with root package name */
        public final long f23338c;

        public TimedNode(T t11, long j11) {
            this.f23337b = t11;
            this.f23338c = j11;
        }
    }

    public static final class UnboundedReplayBuffer<T> implements ReplayBuffer<T> {

        /* renamed from: a  reason: collision with root package name */
        public final List<T> f23339a;

        /* renamed from: b  reason: collision with root package name */
        public Throwable f23340b;

        /* renamed from: c  reason: collision with root package name */
        public volatile boolean f23341c;

        /* renamed from: d  reason: collision with root package name */
        public volatile int f23342d;

        public UnboundedReplayBuffer(int i11) {
            this.f23339a = new ArrayList(i11);
        }

        public void complete() {
            this.f23341c = true;
        }

        public void error(Throwable th2) {
            this.f23340b = th2;
            this.f23341c = true;
        }

        public Throwable getError() {
            return this.f23340b;
        }

        @Nullable
        public T getValue() {
            int i11 = this.f23342d;
            if (i11 == 0) {
                return null;
            }
            return this.f23339a.get(i11 - 1);
        }

        public T[] getValues(T[] tArr) {
            int i11 = this.f23342d;
            if (i11 == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
            List<T> list = this.f23339a;
            if (tArr.length < i11) {
                tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i11);
            }
            for (int i12 = 0; i12 < i11; i12++) {
                tArr[i12] = list.get(i12);
            }
            if (tArr.length > i11) {
                tArr[i11] = null;
            }
            return tArr;
        }

        public boolean isDone() {
            return this.f23341c;
        }

        public void next(T t11) {
            this.f23339a.add(t11);
            this.f23342d++;
        }

        public void replay(ReplaySubscription<T> replaySubscription) {
            int i11;
            int i12;
            if (replaySubscription.getAndIncrement() == 0) {
                List<T> list = this.f23339a;
                Subscriber<? super T> subscriber = replaySubscription.f23316b;
                Integer num = (Integer) replaySubscription.f23318d;
                if (num != null) {
                    i11 = num.intValue();
                } else {
                    i11 = 0;
                    replaySubscription.f23318d = 0;
                }
                long j11 = replaySubscription.f23321g;
                int i13 = 1;
                do {
                    long j12 = replaySubscription.f23319e.get();
                    while (true) {
                        i12 = (j11 > j12 ? 1 : (j11 == j12 ? 0 : -1));
                        if (i12 == 0) {
                            break;
                        } else if (replaySubscription.f23320f) {
                            replaySubscription.f23318d = null;
                            return;
                        } else {
                            boolean z11 = this.f23341c;
                            int i14 = this.f23342d;
                            if (z11 && i11 == i14) {
                                replaySubscription.f23318d = null;
                                replaySubscription.f23320f = true;
                                Throwable th2 = this.f23340b;
                                if (th2 == null) {
                                    subscriber.onComplete();
                                    return;
                                } else {
                                    subscriber.onError(th2);
                                    return;
                                }
                            } else if (i11 == i14) {
                                break;
                            } else {
                                subscriber.onNext(list.get(i11));
                                i11++;
                                j11++;
                            }
                        }
                    }
                    if (i12 == 0) {
                        if (replaySubscription.f23320f) {
                            replaySubscription.f23318d = null;
                            return;
                        }
                        boolean z12 = this.f23341c;
                        int i15 = this.f23342d;
                        if (z12 && i11 == i15) {
                            replaySubscription.f23318d = null;
                            replaySubscription.f23320f = true;
                            Throwable th3 = this.f23340b;
                            if (th3 == null) {
                                subscriber.onComplete();
                                return;
                            } else {
                                subscriber.onError(th3);
                                return;
                            }
                        }
                    }
                    replaySubscription.f23318d = Integer.valueOf(i11);
                    replaySubscription.f23321g = j11;
                    i13 = replaySubscription.addAndGet(-i13);
                } while (i13 != 0);
            }
        }

        public int size() {
            return this.f23342d;
        }

        public void trimHead() {
        }
    }

    public ReplayProcessor(ReplayBuffer<T> replayBuffer) {
        this.f23312c = replayBuffer;
    }

    @NonNull
    @CheckReturnValue
    public static <T> ReplayProcessor<T> create() {
        return new ReplayProcessor<>(new UnboundedReplayBuffer(16));
    }

    @NonNull
    @CheckReturnValue
    public static <T> ReplayProcessor<T> createWithSize(int i11) {
        ObjectHelper.verifyPositive(i11, "maxSize");
        return new ReplayProcessor<>(new SizeBoundReplayBuffer(i11));
    }

    @NonNull
    @CheckReturnValue
    public static <T> ReplayProcessor<T> createWithTime(long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        ObjectHelper.verifyPositive(j11, "maxAge");
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return new ReplayProcessor<>(new SizeAndTimeBoundReplayBuffer(Integer.MAX_VALUE, j11, timeUnit, scheduler));
    }

    @NonNull
    @CheckReturnValue
    public static <T> ReplayProcessor<T> createWithTimeAndSize(long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, int i11) {
        ObjectHelper.verifyPositive(i11, "maxSize");
        ObjectHelper.verifyPositive(j11, "maxAge");
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return new ReplayProcessor<>(new SizeAndTimeBoundReplayBuffer(i11, j11, timeUnit, scheduler));
    }

    public boolean b(ReplaySubscription<T> replaySubscription) {
        ReplaySubscription[] replaySubscriptionArr;
        ReplaySubscription[] replaySubscriptionArr2;
        do {
            replaySubscriptionArr = (ReplaySubscription[]) this.f23314e.get();
            if (replaySubscriptionArr == f23311g) {
                return false;
            }
            int length = replaySubscriptionArr.length;
            replaySubscriptionArr2 = new ReplaySubscription[(length + 1)];
            System.arraycopy(replaySubscriptionArr, 0, replaySubscriptionArr2, 0, length);
            replaySubscriptionArr2[length] = replaySubscription;
        } while (!b.a(this.f23314e, replaySubscriptionArr, replaySubscriptionArr2));
        return true;
    }

    public void c(ReplaySubscription<T> replaySubscription) {
        ReplaySubscription<T>[] replaySubscriptionArr;
        ReplaySubscription[] replaySubscriptionArr2;
        do {
            replaySubscriptionArr = (ReplaySubscription[]) this.f23314e.get();
            if (replaySubscriptionArr != f23311g && replaySubscriptionArr != f23310f) {
                int length = replaySubscriptionArr.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        i11 = -1;
                        break;
                    } else if (replaySubscriptionArr[i11] == replaySubscription) {
                        break;
                    } else {
                        i11++;
                    }
                }
                if (i11 >= 0) {
                    if (length == 1) {
                        replaySubscriptionArr2 = f23310f;
                    } else {
                        ReplaySubscription[] replaySubscriptionArr3 = new ReplaySubscription[(length - 1)];
                        System.arraycopy(replaySubscriptionArr, 0, replaySubscriptionArr3, 0, i11);
                        System.arraycopy(replaySubscriptionArr, i11 + 1, replaySubscriptionArr3, i11, (length - i11) - 1);
                        replaySubscriptionArr2 = replaySubscriptionArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!b.a(this.f23314e, replaySubscriptionArr, replaySubscriptionArr2));
    }

    public void cleanupBuffer() {
        this.f23312c.trimHead();
    }

    @CheckReturnValue
    @Nullable
    public Throwable getThrowable() {
        ReplayBuffer<T> replayBuffer = this.f23312c;
        if (replayBuffer.isDone()) {
            return replayBuffer.getError();
        }
        return null;
    }

    @CheckReturnValue
    public T getValue() {
        return this.f23312c.getValue();
    }

    @CheckReturnValue
    public Object[] getValues() {
        Object[] objArr = EMPTY_ARRAY;
        Object[] values = getValues(objArr);
        return values == objArr ? new Object[0] : values;
    }

    @CheckReturnValue
    public boolean hasComplete() {
        ReplayBuffer<T> replayBuffer = this.f23312c;
        if (!replayBuffer.isDone() || replayBuffer.getError() != null) {
            return false;
        }
        return true;
    }

    @CheckReturnValue
    public boolean hasSubscribers() {
        return ((ReplaySubscription[]) this.f23314e.get()).length != 0;
    }

    @CheckReturnValue
    public boolean hasThrowable() {
        ReplayBuffer<T> replayBuffer = this.f23312c;
        if (!replayBuffer.isDone() || replayBuffer.getError() == null) {
            return false;
        }
        return true;
    }

    @CheckReturnValue
    public boolean hasValue() {
        return this.f23312c.size() != 0;
    }

    public void onComplete() {
        if (!this.f23313d) {
            this.f23313d = true;
            ReplayBuffer<T> replayBuffer = this.f23312c;
            replayBuffer.complete();
            for (ReplaySubscription replay : (ReplaySubscription[]) this.f23314e.getAndSet(f23311g)) {
                replayBuffer.replay(replay);
            }
        }
    }

    public void onError(Throwable th2) {
        ExceptionHelper.nullCheck(th2, "onError called with a null Throwable.");
        if (this.f23313d) {
            RxJavaPlugins.onError(th2);
            return;
        }
        this.f23313d = true;
        ReplayBuffer<T> replayBuffer = this.f23312c;
        replayBuffer.error(th2);
        for (ReplaySubscription replay : (ReplaySubscription[]) this.f23314e.getAndSet(f23311g)) {
            replayBuffer.replay(replay);
        }
    }

    public void onNext(T t11) {
        ExceptionHelper.nullCheck(t11, "onNext called with a null value.");
        if (!this.f23313d) {
            ReplayBuffer<T> replayBuffer = this.f23312c;
            replayBuffer.next(t11);
            for (ReplaySubscription replay : (ReplaySubscription[]) this.f23314e.get()) {
                replayBuffer.replay(replay);
            }
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (this.f23313d) {
            subscription.cancel();
        } else {
            subscription.request(Long.MAX_VALUE);
        }
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        ReplaySubscription replaySubscription = new ReplaySubscription(subscriber, this);
        subscriber.onSubscribe(replaySubscription);
        if (!b(replaySubscription) || !replaySubscription.f23320f) {
            this.f23312c.replay(replaySubscription);
        } else {
            c(replaySubscription);
        }
    }

    @NonNull
    @CheckReturnValue
    public static <T> ReplayProcessor<T> create(int i11) {
        ObjectHelper.verifyPositive(i11, "capacityHint");
        return new ReplayProcessor<>(new UnboundedReplayBuffer(i11));
    }

    @CheckReturnValue
    public T[] getValues(T[] tArr) {
        return this.f23312c.getValues(tArr);
    }
}
