package io.reactivex.processors;

import i.b;
import io.reactivex.Scheduler;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ReplayProcessor<T> extends FlowableProcessor<T> {
    private static final Object[] EMPTY_ARRAY = new Object[0];

    /* renamed from: f  reason: collision with root package name */
    public static final ReplaySubscription[] f18712f = new ReplaySubscription[0];

    /* renamed from: g  reason: collision with root package name */
    public static final ReplaySubscription[] f18713g = new ReplaySubscription[0];

    /* renamed from: c  reason: collision with root package name */
    public final ReplayBuffer<T> f18714c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f18715d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<ReplaySubscription<T>[]> f18716e = new AtomicReference<>(f18712f);

    public static final class Node<T> extends AtomicReference<Node<T>> {
        private static final long serialVersionUID = 6404226426336033100L;

        /* renamed from: b  reason: collision with root package name */
        public final T f18717b;

        public Node(T t11) {
            this.f18717b = t11;
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
        public final Subscriber<? super T> f18718b;

        /* renamed from: c  reason: collision with root package name */
        public final ReplayProcessor<T> f18719c;

        /* renamed from: d  reason: collision with root package name */
        public Object f18720d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicLong f18721e = new AtomicLong();

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f18722f;

        /* renamed from: g  reason: collision with root package name */
        public long f18723g;

        public ReplaySubscription(Subscriber<? super T> subscriber, ReplayProcessor<T> replayProcessor) {
            this.f18718b = subscriber;
            this.f18719c = replayProcessor;
        }

        public void cancel() {
            if (!this.f18722f) {
                this.f18722f = true;
                this.f18719c.c(this);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f18721e, j11);
                this.f18719c.f18714c.replay(this);
            }
        }
    }

    public static final class SizeAndTimeBoundReplayBuffer<T> implements ReplayBuffer<T> {

        /* renamed from: a  reason: collision with root package name */
        public final int f18724a;

        /* renamed from: b  reason: collision with root package name */
        public final long f18725b;

        /* renamed from: c  reason: collision with root package name */
        public final TimeUnit f18726c;

        /* renamed from: d  reason: collision with root package name */
        public final Scheduler f18727d;

        /* renamed from: e  reason: collision with root package name */
        public int f18728e;

        /* renamed from: f  reason: collision with root package name */
        public volatile TimedNode<T> f18729f;

        /* renamed from: g  reason: collision with root package name */
        public TimedNode<T> f18730g;

        /* renamed from: h  reason: collision with root package name */
        public Throwable f18731h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f18732i;

        public SizeAndTimeBoundReplayBuffer(int i11, long j11, TimeUnit timeUnit, Scheduler scheduler) {
            this.f18724a = ObjectHelper.verifyPositive(i11, "maxSize");
            this.f18725b = ObjectHelper.verifyPositive(j11, "maxAge");
            this.f18726c = (TimeUnit) ObjectHelper.requireNonNull(timeUnit, "unit is null");
            this.f18727d = (Scheduler) ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            TimedNode<T> timedNode = new TimedNode<>(null, 0);
            this.f18730g = timedNode;
            this.f18729f = timedNode;
        }

        public TimedNode<T> a() {
            TimedNode<T> timedNode;
            TimedNode<T> timedNode2 = this.f18729f;
            long now = this.f18727d.now(this.f18726c) - this.f18725b;
            Object obj = timedNode2.get();
            while (true) {
                TimedNode<T> timedNode3 = (TimedNode) obj;
                timedNode = timedNode2;
                timedNode2 = timedNode3;
                if (timedNode2 == null || timedNode2.f18740c > now) {
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
            int i11 = this.f18728e;
            if (i11 > this.f18724a) {
                this.f18728e = i11 - 1;
                this.f18729f = (TimedNode) this.f18729f.get();
            }
            long now = this.f18727d.now(this.f18726c) - this.f18725b;
            TimedNode<T> timedNode = this.f18729f;
            while (this.f18728e > 1) {
                TimedNode<T> timedNode2 = (TimedNode) timedNode.get();
                if (timedNode2 == null) {
                    this.f18729f = timedNode;
                    return;
                } else if (timedNode2.f18740c > now) {
                    this.f18729f = timedNode;
                    return;
                } else {
                    this.f18728e--;
                    timedNode = timedNode2;
                }
            }
            this.f18729f = timedNode;
        }

        public void complete() {
            d();
            this.f18732i = true;
        }

        public void d() {
            long now = this.f18727d.now(this.f18726c) - this.f18725b;
            TimedNode<T> timedNode = this.f18729f;
            while (true) {
                TimedNode<T> timedNode2 = (TimedNode) timedNode.get();
                if (timedNode2 == null) {
                    if (timedNode.f18739b != null) {
                        this.f18729f = new TimedNode<>(null, 0);
                        return;
                    } else {
                        this.f18729f = timedNode;
                        return;
                    }
                } else if (timedNode2.f18740c <= now) {
                    timedNode = timedNode2;
                } else if (timedNode.f18739b != null) {
                    TimedNode<T> timedNode3 = new TimedNode<>(null, 0);
                    timedNode3.lazySet(timedNode.get());
                    this.f18729f = timedNode3;
                    return;
                } else {
                    this.f18729f = timedNode;
                    return;
                }
            }
        }

        public void error(Throwable th2) {
            d();
            this.f18731h = th2;
            this.f18732i = true;
        }

        public Throwable getError() {
            return this.f18731h;
        }

        @Nullable
        public T getValue() {
            TimedNode<T> timedNode = this.f18729f;
            while (true) {
                TimedNode<T> timedNode2 = (TimedNode) timedNode.get();
                if (timedNode2 == null) {
                    break;
                }
                timedNode = timedNode2;
            }
            if (timedNode.f18740c < this.f18727d.now(this.f18726c) - this.f18725b) {
                return null;
            }
            return timedNode.f18739b;
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
                    tArr[i11] = a11.f18739b;
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
            return this.f18732i;
        }

        public void next(T t11) {
            TimedNode<T> timedNode = new TimedNode<>(t11, this.f18727d.now(this.f18726c));
            TimedNode<T> timedNode2 = this.f18730g;
            this.f18730g = timedNode;
            this.f18728e++;
            timedNode2.set(timedNode);
            c();
        }

        public void replay(ReplaySubscription<T> replaySubscription) {
            int i11;
            boolean z11;
            if (replaySubscription.getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = replaySubscription.f18718b;
                TimedNode timedNode = (TimedNode) replaySubscription.f18720d;
                if (timedNode == null) {
                    timedNode = a();
                }
                long j11 = replaySubscription.f18723g;
                int i12 = 1;
                do {
                    long j12 = replaySubscription.f18721e.get();
                    while (true) {
                        i11 = (j11 > j12 ? 1 : (j11 == j12 ? 0 : -1));
                        if (i11 == 0) {
                            break;
                        } else if (replaySubscription.f18722f) {
                            replaySubscription.f18720d = null;
                            return;
                        } else {
                            boolean z12 = this.f18732i;
                            TimedNode timedNode2 = (TimedNode) timedNode.get();
                            if (timedNode2 == null) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (z12 && z11) {
                                replaySubscription.f18720d = null;
                                replaySubscription.f18722f = true;
                                Throwable th2 = this.f18731h;
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
                                subscriber.onNext(timedNode2.f18739b);
                                j11++;
                                timedNode = timedNode2;
                            }
                        }
                    }
                    if (i11 == 0) {
                        if (replaySubscription.f18722f) {
                            replaySubscription.f18720d = null;
                            return;
                        } else if (this.f18732i && timedNode.get() == null) {
                            replaySubscription.f18720d = null;
                            replaySubscription.f18722f = true;
                            Throwable th3 = this.f18731h;
                            if (th3 == null) {
                                subscriber.onComplete();
                                return;
                            } else {
                                subscriber.onError(th3);
                                return;
                            }
                        }
                    }
                    replaySubscription.f18720d = timedNode;
                    replaySubscription.f18723g = j11;
                    i12 = replaySubscription.addAndGet(-i12);
                } while (i12 != 0);
            }
        }

        public int size() {
            return b(a());
        }

        public void trimHead() {
            if (this.f18729f.f18739b != null) {
                TimedNode<T> timedNode = new TimedNode<>(null, 0);
                timedNode.lazySet(this.f18729f.get());
                this.f18729f = timedNode;
            }
        }
    }

    public static final class SizeBoundReplayBuffer<T> implements ReplayBuffer<T> {

        /* renamed from: a  reason: collision with root package name */
        public final int f18733a;

        /* renamed from: b  reason: collision with root package name */
        public int f18734b;

        /* renamed from: c  reason: collision with root package name */
        public volatile Node<T> f18735c;

        /* renamed from: d  reason: collision with root package name */
        public Node<T> f18736d;

        /* renamed from: e  reason: collision with root package name */
        public Throwable f18737e;

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f18738f;

        public SizeBoundReplayBuffer(int i11) {
            this.f18733a = ObjectHelper.verifyPositive(i11, "maxSize");
            Node<T> node = new Node<>(null);
            this.f18736d = node;
            this.f18735c = node;
        }

        public void a() {
            int i11 = this.f18734b;
            if (i11 > this.f18733a) {
                this.f18734b = i11 - 1;
                this.f18735c = (Node) this.f18735c.get();
            }
        }

        public void complete() {
            trimHead();
            this.f18738f = true;
        }

        public void error(Throwable th2) {
            this.f18737e = th2;
            trimHead();
            this.f18738f = true;
        }

        public Throwable getError() {
            return this.f18737e;
        }

        public T getValue() {
            Node<T> node = this.f18735c;
            while (true) {
                Node<T> node2 = (Node) node.get();
                if (node2 == null) {
                    return node.f18717b;
                }
                node = node2;
            }
        }

        public T[] getValues(T[] tArr) {
            Node<T> node = this.f18735c;
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
                tArr[i12] = node.f18717b;
            }
            if (tArr.length > i11) {
                tArr[i11] = null;
            }
            return tArr;
        }

        public boolean isDone() {
            return this.f18738f;
        }

        public void next(T t11) {
            Node<T> node = new Node<>(t11);
            Node<T> node2 = this.f18736d;
            this.f18736d = node;
            this.f18734b++;
            node2.set(node);
            a();
        }

        public void replay(ReplaySubscription<T> replaySubscription) {
            int i11;
            boolean z11;
            if (replaySubscription.getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = replaySubscription.f18718b;
                Node<T> node = (Node) replaySubscription.f18720d;
                if (node == null) {
                    node = this.f18735c;
                }
                long j11 = replaySubscription.f18723g;
                int i12 = 1;
                do {
                    long j12 = replaySubscription.f18721e.get();
                    while (true) {
                        i11 = (j11 > j12 ? 1 : (j11 == j12 ? 0 : -1));
                        if (i11 == 0) {
                            break;
                        } else if (replaySubscription.f18722f) {
                            replaySubscription.f18720d = null;
                            return;
                        } else {
                            boolean z12 = this.f18738f;
                            Node<T> node2 = (Node) node.get();
                            if (node2 == null) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (z12 && z11) {
                                replaySubscription.f18720d = null;
                                replaySubscription.f18722f = true;
                                Throwable th2 = this.f18737e;
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
                                subscriber.onNext(node2.f18717b);
                                j11++;
                                node = node2;
                            }
                        }
                    }
                    if (i11 == 0) {
                        if (replaySubscription.f18722f) {
                            replaySubscription.f18720d = null;
                            return;
                        } else if (this.f18738f && node.get() == null) {
                            replaySubscription.f18720d = null;
                            replaySubscription.f18722f = true;
                            Throwable th3 = this.f18737e;
                            if (th3 == null) {
                                subscriber.onComplete();
                                return;
                            } else {
                                subscriber.onError(th3);
                                return;
                            }
                        }
                    }
                    replaySubscription.f18720d = node;
                    replaySubscription.f18723g = j11;
                    i12 = replaySubscription.addAndGet(-i12);
                } while (i12 != 0);
            }
        }

        public int size() {
            Node<T> node = this.f18735c;
            int i11 = 0;
            while (i11 != Integer.MAX_VALUE && (node = (Node) node.get()) != null) {
                i11++;
            }
            return i11;
        }

        public void trimHead() {
            if (this.f18735c.f18717b != null) {
                Node<T> node = new Node<>(null);
                node.lazySet(this.f18735c.get());
                this.f18735c = node;
            }
        }
    }

    public static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
        private static final long serialVersionUID = 6404226426336033100L;

        /* renamed from: b  reason: collision with root package name */
        public final T f18739b;

        /* renamed from: c  reason: collision with root package name */
        public final long f18740c;

        public TimedNode(T t11, long j11) {
            this.f18739b = t11;
            this.f18740c = j11;
        }
    }

    public static final class UnboundedReplayBuffer<T> implements ReplayBuffer<T> {

        /* renamed from: a  reason: collision with root package name */
        public final List<T> f18741a;

        /* renamed from: b  reason: collision with root package name */
        public Throwable f18742b;

        /* renamed from: c  reason: collision with root package name */
        public volatile boolean f18743c;

        /* renamed from: d  reason: collision with root package name */
        public volatile int f18744d;

        public UnboundedReplayBuffer(int i11) {
            this.f18741a = new ArrayList(ObjectHelper.verifyPositive(i11, "capacityHint"));
        }

        public void complete() {
            this.f18743c = true;
        }

        public void error(Throwable th2) {
            this.f18742b = th2;
            this.f18743c = true;
        }

        public Throwable getError() {
            return this.f18742b;
        }

        @Nullable
        public T getValue() {
            int i11 = this.f18744d;
            if (i11 == 0) {
                return null;
            }
            return this.f18741a.get(i11 - 1);
        }

        public T[] getValues(T[] tArr) {
            int i11 = this.f18744d;
            if (i11 == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
            List<T> list = this.f18741a;
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
            return this.f18743c;
        }

        public void next(T t11) {
            this.f18741a.add(t11);
            this.f18744d++;
        }

        public void replay(ReplaySubscription<T> replaySubscription) {
            int i11;
            int i12;
            if (replaySubscription.getAndIncrement() == 0) {
                List<T> list = this.f18741a;
                Subscriber<? super T> subscriber = replaySubscription.f18718b;
                Integer num = (Integer) replaySubscription.f18720d;
                if (num != null) {
                    i11 = num.intValue();
                } else {
                    i11 = 0;
                    replaySubscription.f18720d = 0;
                }
                long j11 = replaySubscription.f18723g;
                int i13 = 1;
                do {
                    long j12 = replaySubscription.f18721e.get();
                    while (true) {
                        i12 = (j11 > j12 ? 1 : (j11 == j12 ? 0 : -1));
                        if (i12 == 0) {
                            break;
                        } else if (replaySubscription.f18722f) {
                            replaySubscription.f18720d = null;
                            return;
                        } else {
                            boolean z11 = this.f18743c;
                            int i14 = this.f18744d;
                            if (z11 && i11 == i14) {
                                replaySubscription.f18720d = null;
                                replaySubscription.f18722f = true;
                                Throwable th2 = this.f18742b;
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
                        if (replaySubscription.f18722f) {
                            replaySubscription.f18720d = null;
                            return;
                        }
                        boolean z12 = this.f18743c;
                        int i15 = this.f18744d;
                        if (z12 && i11 == i15) {
                            replaySubscription.f18720d = null;
                            replaySubscription.f18722f = true;
                            Throwable th3 = this.f18742b;
                            if (th3 == null) {
                                subscriber.onComplete();
                                return;
                            } else {
                                subscriber.onError(th3);
                                return;
                            }
                        }
                    }
                    replaySubscription.f18720d = Integer.valueOf(i11);
                    replaySubscription.f18723g = j11;
                    i13 = replaySubscription.addAndGet(-i13);
                } while (i13 != 0);
            }
        }

        public int size() {
            return this.f18744d;
        }

        public void trimHead() {
        }
    }

    public ReplayProcessor(ReplayBuffer<T> replayBuffer) {
        this.f18714c = replayBuffer;
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplayProcessor<T> create() {
        return new ReplayProcessor<>(new UnboundedReplayBuffer(16));
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplayProcessor<T> createWithSize(int i11) {
        return new ReplayProcessor<>(new SizeBoundReplayBuffer(i11));
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplayProcessor<T> createWithTime(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        return new ReplayProcessor<>(new SizeAndTimeBoundReplayBuffer(Integer.MAX_VALUE, j11, timeUnit, scheduler));
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplayProcessor<T> createWithTimeAndSize(long j11, TimeUnit timeUnit, Scheduler scheduler, int i11) {
        return new ReplayProcessor<>(new SizeAndTimeBoundReplayBuffer(i11, j11, timeUnit, scheduler));
    }

    public boolean b(ReplaySubscription<T> replaySubscription) {
        ReplaySubscription[] replaySubscriptionArr;
        ReplaySubscription[] replaySubscriptionArr2;
        do {
            replaySubscriptionArr = (ReplaySubscription[]) this.f18716e.get();
            if (replaySubscriptionArr == f18713g) {
                return false;
            }
            int length = replaySubscriptionArr.length;
            replaySubscriptionArr2 = new ReplaySubscription[(length + 1)];
            System.arraycopy(replaySubscriptionArr, 0, replaySubscriptionArr2, 0, length);
            replaySubscriptionArr2[length] = replaySubscription;
        } while (!b.a(this.f18716e, replaySubscriptionArr, replaySubscriptionArr2));
        return true;
    }

    public void c(ReplaySubscription<T> replaySubscription) {
        ReplaySubscription<T>[] replaySubscriptionArr;
        ReplaySubscription[] replaySubscriptionArr2;
        do {
            replaySubscriptionArr = (ReplaySubscription[]) this.f18716e.get();
            if (replaySubscriptionArr != f18713g && replaySubscriptionArr != f18712f) {
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
                        replaySubscriptionArr2 = f18712f;
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
        } while (!b.a(this.f18716e, replaySubscriptionArr, replaySubscriptionArr2));
    }

    public void cleanupBuffer() {
        this.f18714c.trimHead();
    }

    @Nullable
    public Throwable getThrowable() {
        ReplayBuffer<T> replayBuffer = this.f18714c;
        if (replayBuffer.isDone()) {
            return replayBuffer.getError();
        }
        return null;
    }

    public T getValue() {
        return this.f18714c.getValue();
    }

    public Object[] getValues() {
        Object[] objArr = EMPTY_ARRAY;
        Object[] values = getValues(objArr);
        return values == objArr ? new Object[0] : values;
    }

    public boolean hasComplete() {
        ReplayBuffer<T> replayBuffer = this.f18714c;
        if (!replayBuffer.isDone() || replayBuffer.getError() != null) {
            return false;
        }
        return true;
    }

    public boolean hasSubscribers() {
        return ((ReplaySubscription[]) this.f18716e.get()).length != 0;
    }

    public boolean hasThrowable() {
        ReplayBuffer<T> replayBuffer = this.f18714c;
        if (!replayBuffer.isDone() || replayBuffer.getError() == null) {
            return false;
        }
        return true;
    }

    public boolean hasValue() {
        return this.f18714c.size() != 0;
    }

    public void onComplete() {
        if (!this.f18715d) {
            this.f18715d = true;
            ReplayBuffer<T> replayBuffer = this.f18714c;
            replayBuffer.complete();
            for (ReplaySubscription replay : (ReplaySubscription[]) this.f18716e.getAndSet(f18713g)) {
                replayBuffer.replay(replay);
            }
        }
    }

    public void onError(Throwable th2) {
        ObjectHelper.requireNonNull(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f18715d) {
            RxJavaPlugins.onError(th2);
            return;
        }
        this.f18715d = true;
        ReplayBuffer<T> replayBuffer = this.f18714c;
        replayBuffer.error(th2);
        for (ReplaySubscription replay : (ReplaySubscription[]) this.f18716e.getAndSet(f18713g)) {
            replayBuffer.replay(replay);
        }
    }

    public void onNext(T t11) {
        ObjectHelper.requireNonNull(t11, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f18715d) {
            ReplayBuffer<T> replayBuffer = this.f18714c;
            replayBuffer.next(t11);
            for (ReplaySubscription replay : (ReplaySubscription[]) this.f18716e.get()) {
                replayBuffer.replay(replay);
            }
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (this.f18715d) {
            subscription.cancel();
        } else {
            subscription.request(Long.MAX_VALUE);
        }
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        ReplaySubscription replaySubscription = new ReplaySubscription(subscriber, this);
        subscriber.onSubscribe(replaySubscription);
        if (!b(replaySubscription) || !replaySubscription.f18722f) {
            this.f18714c.replay(replaySubscription);
        } else {
            c(replaySubscription);
        }
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplayProcessor<T> create(int i11) {
        return new ReplayProcessor<>(new UnboundedReplayBuffer(i11));
    }

    public T[] getValues(T[] tArr) {
        return this.f18714c.getValues(tArr);
    }
}
