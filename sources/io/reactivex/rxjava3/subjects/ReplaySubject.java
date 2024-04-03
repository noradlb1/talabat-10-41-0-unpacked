package io.reactivex.rxjava3.subjects;

import i.b;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ReplaySubject<T> extends Subject<T> {
    private static final Object[] EMPTY_ARRAY = new Object[0];

    /* renamed from: e  reason: collision with root package name */
    public static final ReplayDisposable[] f23424e = new ReplayDisposable[0];

    /* renamed from: f  reason: collision with root package name */
    public static final ReplayDisposable[] f23425f = new ReplayDisposable[0];

    /* renamed from: b  reason: collision with root package name */
    public final ReplayBuffer<T> f23426b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<ReplayDisposable<T>[]> f23427c = new AtomicReference<>(f23424e);

    /* renamed from: d  reason: collision with root package name */
    public boolean f23428d;

    public static final class Node<T> extends AtomicReference<Node<T>> {
        private static final long serialVersionUID = 6404226426336033100L;

        /* renamed from: b  reason: collision with root package name */
        public final T f23429b;

        public Node(T t11) {
            this.f23429b = t11;
        }
    }

    public interface ReplayBuffer<T> {
        void add(T t11);

        void addFinal(Object obj);

        boolean compareAndSet(Object obj, Object obj2);

        Object get();

        @Nullable
        T getValue();

        T[] getValues(T[] tArr);

        void replay(ReplayDisposable<T> replayDisposable);

        int size();

        void trimHead();
    }

    public static final class ReplayDisposable<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 466549804534799122L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f23430b;

        /* renamed from: c  reason: collision with root package name */
        public final ReplaySubject<T> f23431c;

        /* renamed from: d  reason: collision with root package name */
        public Object f23432d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f23433e;

        public ReplayDisposable(Observer<? super T> observer, ReplaySubject<T> replaySubject) {
            this.f23430b = observer;
            this.f23431c = replaySubject;
        }

        public void dispose() {
            if (!this.f23433e) {
                this.f23433e = true;
                this.f23431c.b(this);
            }
        }

        public boolean isDisposed() {
            return this.f23433e;
        }
    }

    public static final class SizeAndTimeBoundReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = -8056260896137901749L;

        /* renamed from: b  reason: collision with root package name */
        public final int f23434b;

        /* renamed from: c  reason: collision with root package name */
        public final long f23435c;

        /* renamed from: d  reason: collision with root package name */
        public final TimeUnit f23436d;

        /* renamed from: e  reason: collision with root package name */
        public final Scheduler f23437e;

        /* renamed from: f  reason: collision with root package name */
        public int f23438f;

        /* renamed from: g  reason: collision with root package name */
        public volatile TimedNode<Object> f23439g;

        /* renamed from: h  reason: collision with root package name */
        public TimedNode<Object> f23440h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f23441i;

        public SizeAndTimeBoundReplayBuffer(int i11, long j11, TimeUnit timeUnit, Scheduler scheduler) {
            this.f23434b = i11;
            this.f23435c = j11;
            this.f23436d = timeUnit;
            this.f23437e = scheduler;
            TimedNode<Object> timedNode = new TimedNode<>(null, 0);
            this.f23440h = timedNode;
            this.f23439g = timedNode;
        }

        public TimedNode<Object> a() {
            TimedNode<Object> timedNode;
            TimedNode<Object> timedNode2 = this.f23439g;
            long now = this.f23437e.now(this.f23436d) - this.f23435c;
            Object obj = timedNode2.get();
            while (true) {
                TimedNode<Object> timedNode3 = (TimedNode) obj;
                timedNode = timedNode2;
                timedNode2 = timedNode3;
                if (timedNode2 == null || timedNode2.f23448c > now) {
                    return timedNode;
                }
                obj = timedNode2.get();
            }
            return timedNode;
        }

        public void add(T t11) {
            TimedNode<Object> timedNode = new TimedNode<>(t11, this.f23437e.now(this.f23436d));
            TimedNode<Object> timedNode2 = this.f23440h;
            this.f23440h = timedNode;
            this.f23438f++;
            timedNode2.set(timedNode);
            c();
        }

        public void addFinal(Object obj) {
            TimedNode<Object> timedNode = new TimedNode<>(obj, Long.MAX_VALUE);
            TimedNode<Object> timedNode2 = this.f23440h;
            this.f23440h = timedNode;
            this.f23438f++;
            timedNode2.lazySet(timedNode);
            d();
            this.f23441i = true;
        }

        public int b(TimedNode<Object> timedNode) {
            int i11 = 0;
            while (i11 != Integer.MAX_VALUE) {
                TimedNode<Object> timedNode2 = (TimedNode) timedNode.get();
                if (timedNode2 == null) {
                    T t11 = timedNode.f23447b;
                    if (NotificationLite.isComplete(t11) || NotificationLite.isError(t11)) {
                        return i11 - 1;
                    }
                    return i11;
                }
                i11++;
                timedNode = timedNode2;
            }
            return i11;
        }

        public void c() {
            int i11 = this.f23438f;
            if (i11 > this.f23434b) {
                this.f23438f = i11 - 1;
                this.f23439g = (TimedNode) this.f23439g.get();
            }
            long now = this.f23437e.now(this.f23436d) - this.f23435c;
            TimedNode<Object> timedNode = this.f23439g;
            while (this.f23438f > 1) {
                TimedNode<Object> timedNode2 = (TimedNode) timedNode.get();
                if (timedNode2.f23448c > now) {
                    this.f23439g = timedNode;
                    return;
                } else {
                    this.f23438f--;
                    timedNode = timedNode2;
                }
            }
            this.f23439g = timedNode;
        }

        public void d() {
            long now = this.f23437e.now(this.f23436d) - this.f23435c;
            TimedNode<Object> timedNode = this.f23439g;
            while (true) {
                TimedNode<Object> timedNode2 = (TimedNode) timedNode.get();
                if (timedNode2.get() == null) {
                    if (timedNode.f23447b != null) {
                        TimedNode<Object> timedNode3 = new TimedNode<>(null, 0);
                        timedNode3.lazySet(timedNode.get());
                        this.f23439g = timedNode3;
                        return;
                    }
                    this.f23439g = timedNode;
                    return;
                } else if (timedNode2.f23448c <= now) {
                    timedNode = timedNode2;
                } else if (timedNode.f23447b != null) {
                    TimedNode<Object> timedNode4 = new TimedNode<>(null, 0);
                    timedNode4.lazySet(timedNode.get());
                    this.f23439g = timedNode4;
                    return;
                } else {
                    this.f23439g = timedNode;
                    return;
                }
            }
        }

        @Nullable
        public T getValue() {
            T t11;
            TimedNode<Object> timedNode = this.f23439g;
            TimedNode<Object> timedNode2 = null;
            while (true) {
                TimedNode<Object> timedNode3 = (TimedNode) timedNode.get();
                if (timedNode3 == null) {
                    break;
                }
                timedNode2 = timedNode;
                timedNode = timedNode3;
            }
            if (timedNode.f23448c < this.f23437e.now(this.f23436d) - this.f23435c || (t11 = timedNode.f23447b) == null) {
                return null;
            }
            if (NotificationLite.isComplete(t11) || NotificationLite.isError(t11)) {
                return timedNode2.f23447b;
            }
            return t11;
        }

        public T[] getValues(T[] tArr) {
            TimedNode<Object> a11 = a();
            int b11 = b(a11);
            if (b11 != 0) {
                if (tArr.length < b11) {
                    tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), b11);
                }
                for (int i11 = 0; i11 != b11; i11++) {
                    a11 = (TimedNode) a11.get();
                    tArr[i11] = a11.f23447b;
                }
                if (tArr.length > b11) {
                    tArr[b11] = null;
                }
            } else if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }

        public void replay(ReplayDisposable<T> replayDisposable) {
            if (replayDisposable.getAndIncrement() == 0) {
                Observer<? super T> observer = replayDisposable.f23430b;
                TimedNode<Object> timedNode = (TimedNode) replayDisposable.f23432d;
                if (timedNode == null) {
                    timedNode = a();
                }
                int i11 = 1;
                while (!replayDisposable.f23433e) {
                    TimedNode<Object> timedNode2 = (TimedNode) timedNode.get();
                    if (timedNode2 == null) {
                        replayDisposable.f23432d = timedNode;
                        i11 = replayDisposable.addAndGet(-i11);
                        if (i11 == 0) {
                            return;
                        }
                    } else {
                        T t11 = timedNode2.f23447b;
                        if (!this.f23441i || timedNode2.get() != null) {
                            observer.onNext(t11);
                            timedNode = timedNode2;
                        } else {
                            if (NotificationLite.isComplete(t11)) {
                                observer.onComplete();
                            } else {
                                observer.onError(NotificationLite.getError(t11));
                            }
                            replayDisposable.f23432d = null;
                            replayDisposable.f23433e = true;
                            return;
                        }
                    }
                }
                replayDisposable.f23432d = null;
            }
        }

        public int size() {
            return b(a());
        }

        public void trimHead() {
            TimedNode<Object> timedNode = this.f23439g;
            if (timedNode.f23447b != null) {
                TimedNode<Object> timedNode2 = new TimedNode<>(null, 0);
                timedNode2.lazySet(timedNode.get());
                this.f23439g = timedNode2;
            }
        }
    }

    public static final class SizeBoundReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 1107649250281456395L;

        /* renamed from: b  reason: collision with root package name */
        public final int f23442b;

        /* renamed from: c  reason: collision with root package name */
        public int f23443c;

        /* renamed from: d  reason: collision with root package name */
        public volatile Node<Object> f23444d;

        /* renamed from: e  reason: collision with root package name */
        public Node<Object> f23445e;

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f23446f;

        public SizeBoundReplayBuffer(int i11) {
            this.f23442b = i11;
            Node<Object> node = new Node<>(null);
            this.f23445e = node;
            this.f23444d = node;
        }

        public void a() {
            int i11 = this.f23443c;
            if (i11 > this.f23442b) {
                this.f23443c = i11 - 1;
                this.f23444d = (Node) this.f23444d.get();
            }
        }

        public void add(T t11) {
            Node<Object> node = new Node<>(t11);
            Node<Object> node2 = this.f23445e;
            this.f23445e = node;
            this.f23443c++;
            node2.set(node);
            a();
        }

        public void addFinal(Object obj) {
            Node<Object> node = new Node<>(obj);
            Node<Object> node2 = this.f23445e;
            this.f23445e = node;
            this.f23443c++;
            node2.lazySet(node);
            trimHead();
            this.f23446f = true;
        }

        @Nullable
        public T getValue() {
            Node<Object> node = this.f23444d;
            Node<Object> node2 = null;
            while (true) {
                Node<Object> node3 = (Node) node.get();
                if (node3 == null) {
                    break;
                }
                node2 = node;
                node = node3;
            }
            T t11 = node.f23429b;
            if (t11 == null) {
                return null;
            }
            if (NotificationLite.isComplete(t11) || NotificationLite.isError(t11)) {
                return node2.f23429b;
            }
            return t11;
        }

        public T[] getValues(T[] tArr) {
            Node<Object> node = this.f23444d;
            int size = size();
            if (size != 0) {
                if (tArr.length < size) {
                    tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
                }
                for (int i11 = 0; i11 != size; i11++) {
                    node = (Node) node.get();
                    tArr[i11] = node.f23429b;
                }
                if (tArr.length > size) {
                    tArr[size] = null;
                }
            } else if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }

        public void replay(ReplayDisposable<T> replayDisposable) {
            if (replayDisposable.getAndIncrement() == 0) {
                Observer<? super T> observer = replayDisposable.f23430b;
                Node<Object> node = (Node) replayDisposable.f23432d;
                if (node == null) {
                    node = this.f23444d;
                }
                int i11 = 1;
                while (!replayDisposable.f23433e) {
                    Node<Object> node2 = (Node) node.get();
                    if (node2 != null) {
                        T t11 = node2.f23429b;
                        if (!this.f23446f || node2.get() != null) {
                            observer.onNext(t11);
                            node = node2;
                        } else {
                            if (NotificationLite.isComplete(t11)) {
                                observer.onComplete();
                            } else {
                                observer.onError(NotificationLite.getError(t11));
                            }
                            replayDisposable.f23432d = null;
                            replayDisposable.f23433e = true;
                            return;
                        }
                    } else if (node.get() != null) {
                        continue;
                    } else {
                        replayDisposable.f23432d = node;
                        i11 = replayDisposable.addAndGet(-i11);
                        if (i11 == 0) {
                            return;
                        }
                    }
                }
                replayDisposable.f23432d = null;
            }
        }

        public int size() {
            Node<Object> node = this.f23444d;
            int i11 = 0;
            while (i11 != Integer.MAX_VALUE) {
                Node<Object> node2 = (Node) node.get();
                if (node2 == null) {
                    T t11 = node.f23429b;
                    if (NotificationLite.isComplete(t11) || NotificationLite.isError(t11)) {
                        return i11 - 1;
                    }
                    return i11;
                }
                i11++;
                node = node2;
            }
            return i11;
        }

        public void trimHead() {
            Node<Object> node = this.f23444d;
            if (node.f23429b != null) {
                Node<Object> node2 = new Node<>(null);
                node2.lazySet(node.get());
                this.f23444d = node2;
            }
        }
    }

    public static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
        private static final long serialVersionUID = 6404226426336033100L;

        /* renamed from: b  reason: collision with root package name */
        public final T f23447b;

        /* renamed from: c  reason: collision with root package name */
        public final long f23448c;

        public TimedNode(T t11, long j11) {
            this.f23447b = t11;
            this.f23448c = j11;
        }
    }

    public static final class UnboundedReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = -733876083048047795L;

        /* renamed from: b  reason: collision with root package name */
        public final List<Object> f23449b;

        /* renamed from: c  reason: collision with root package name */
        public volatile boolean f23450c;

        /* renamed from: d  reason: collision with root package name */
        public volatile int f23451d;

        public UnboundedReplayBuffer(int i11) {
            this.f23449b = new ArrayList(i11);
        }

        public void add(T t11) {
            this.f23449b.add(t11);
            this.f23451d++;
        }

        public void addFinal(Object obj) {
            this.f23449b.add(obj);
            trimHead();
            this.f23451d++;
            this.f23450c = true;
        }

        @Nullable
        public T getValue() {
            int i11 = this.f23451d;
            if (i11 == 0) {
                return null;
            }
            List<Object> list = this.f23449b;
            T t11 = list.get(i11 - 1);
            if (!NotificationLite.isComplete(t11) && !NotificationLite.isError(t11)) {
                return t11;
            }
            if (i11 == 1) {
                return null;
            }
            return list.get(i11 - 2);
        }

        public T[] getValues(T[] tArr) {
            int i11 = this.f23451d;
            if (i11 == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
            List list = this.f23449b;
            Object obj = list.get(i11 - 1);
            if ((NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) && i11 - 1 == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
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

        public void replay(ReplayDisposable<T> replayDisposable) {
            int i11;
            int i12;
            if (replayDisposable.getAndIncrement() == 0) {
                List<Object> list = this.f23449b;
                Observer<? super T> observer = replayDisposable.f23430b;
                Integer num = (Integer) replayDisposable.f23432d;
                if (num != null) {
                    i11 = num.intValue();
                } else {
                    i11 = 0;
                    replayDisposable.f23432d = 0;
                }
                int i13 = 1;
                while (!replayDisposable.f23433e) {
                    int i14 = this.f23451d;
                    while (i14 != i11) {
                        if (replayDisposable.f23433e) {
                            replayDisposable.f23432d = null;
                            return;
                        }
                        Object obj = list.get(i11);
                        if (this.f23450c && (i12 = i11 + 1) == i14 && i12 == (i14 = this.f23451d)) {
                            if (NotificationLite.isComplete(obj)) {
                                observer.onComplete();
                            } else {
                                observer.onError(NotificationLite.getError(obj));
                            }
                            replayDisposable.f23432d = null;
                            replayDisposable.f23433e = true;
                            return;
                        }
                        observer.onNext(obj);
                        i11++;
                    }
                    if (i11 == this.f23451d) {
                        replayDisposable.f23432d = Integer.valueOf(i11);
                        i13 = replayDisposable.addAndGet(-i13);
                        if (i13 == 0) {
                            return;
                        }
                    }
                }
                replayDisposable.f23432d = null;
            }
        }

        public int size() {
            int i11 = this.f23451d;
            if (i11 == 0) {
                return 0;
            }
            int i12 = i11 - 1;
            Object obj = this.f23449b.get(i12);
            if (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) {
                return i12;
            }
            return i11;
        }

        public void trimHead() {
        }
    }

    public ReplaySubject(ReplayBuffer<T> replayBuffer) {
        this.f23426b = replayBuffer;
    }

    @NonNull
    @CheckReturnValue
    public static <T> ReplaySubject<T> create() {
        return new ReplaySubject<>(new UnboundedReplayBuffer(16));
    }

    @NonNull
    @CheckReturnValue
    public static <T> ReplaySubject<T> createWithSize(int i11) {
        ObjectHelper.verifyPositive(i11, "maxSize");
        return new ReplaySubject<>(new SizeBoundReplayBuffer(i11));
    }

    @NonNull
    @CheckReturnValue
    public static <T> ReplaySubject<T> createWithTime(long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        ObjectHelper.verifyPositive(j11, "maxAge");
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return new ReplaySubject<>(new SizeAndTimeBoundReplayBuffer(Integer.MAX_VALUE, j11, timeUnit, scheduler));
    }

    @NonNull
    @CheckReturnValue
    public static <T> ReplaySubject<T> createWithTimeAndSize(long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, int i11) {
        ObjectHelper.verifyPositive(i11, "maxSize");
        ObjectHelper.verifyPositive(j11, "maxAge");
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return new ReplaySubject<>(new SizeAndTimeBoundReplayBuffer(i11, j11, timeUnit, scheduler));
    }

    public boolean a(ReplayDisposable<T> replayDisposable) {
        ReplayDisposable[] replayDisposableArr;
        ReplayDisposable[] replayDisposableArr2;
        do {
            replayDisposableArr = (ReplayDisposable[]) this.f23427c.get();
            if (replayDisposableArr == f23425f) {
                return false;
            }
            int length = replayDisposableArr.length;
            replayDisposableArr2 = new ReplayDisposable[(length + 1)];
            System.arraycopy(replayDisposableArr, 0, replayDisposableArr2, 0, length);
            replayDisposableArr2[length] = replayDisposable;
        } while (!b.a(this.f23427c, replayDisposableArr, replayDisposableArr2));
        return true;
    }

    public void b(ReplayDisposable<T> replayDisposable) {
        ReplayDisposable<T>[] replayDisposableArr;
        ReplayDisposable[] replayDisposableArr2;
        do {
            replayDisposableArr = (ReplayDisposable[]) this.f23427c.get();
            if (replayDisposableArr != f23425f && replayDisposableArr != f23424e) {
                int length = replayDisposableArr.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        i11 = -1;
                        break;
                    } else if (replayDisposableArr[i11] == replayDisposable) {
                        break;
                    } else {
                        i11++;
                    }
                }
                if (i11 >= 0) {
                    if (length == 1) {
                        replayDisposableArr2 = f23424e;
                    } else {
                        ReplayDisposable[] replayDisposableArr3 = new ReplayDisposable[(length - 1)];
                        System.arraycopy(replayDisposableArr, 0, replayDisposableArr3, 0, i11);
                        System.arraycopy(replayDisposableArr, i11 + 1, replayDisposableArr3, i11, (length - i11) - 1);
                        replayDisposableArr2 = replayDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!b.a(this.f23427c, replayDisposableArr, replayDisposableArr2));
    }

    public ReplayDisposable<T>[] c(Object obj) {
        this.f23426b.compareAndSet((Object) null, obj);
        return (ReplayDisposable[]) this.f23427c.getAndSet(f23425f);
    }

    public void cleanupBuffer() {
        this.f23426b.trimHead();
    }

    @CheckReturnValue
    @Nullable
    public Throwable getThrowable() {
        Object obj = this.f23426b.get();
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    @CheckReturnValue
    @Nullable
    public T getValue() {
        return this.f23426b.getValue();
    }

    @CheckReturnValue
    public Object[] getValues() {
        Object[] objArr = EMPTY_ARRAY;
        Object[] values = getValues(objArr);
        return values == objArr ? new Object[0] : values;
    }

    @CheckReturnValue
    public boolean hasComplete() {
        return NotificationLite.isComplete(this.f23426b.get());
    }

    @CheckReturnValue
    public boolean hasObservers() {
        return ((ReplayDisposable[]) this.f23427c.get()).length != 0;
    }

    @CheckReturnValue
    public boolean hasThrowable() {
        return NotificationLite.isError(this.f23426b.get());
    }

    @CheckReturnValue
    public boolean hasValue() {
        return this.f23426b.size() != 0;
    }

    public void onComplete() {
        if (!this.f23428d) {
            this.f23428d = true;
            Object complete = NotificationLite.complete();
            ReplayBuffer<T> replayBuffer = this.f23426b;
            replayBuffer.addFinal(complete);
            for (ReplayDisposable replay : c(complete)) {
                replayBuffer.replay(replay);
            }
        }
    }

    public void onError(Throwable th2) {
        ExceptionHelper.nullCheck(th2, "onError called with a null Throwable.");
        if (this.f23428d) {
            RxJavaPlugins.onError(th2);
            return;
        }
        this.f23428d = true;
        Object error = NotificationLite.error(th2);
        ReplayBuffer<T> replayBuffer = this.f23426b;
        replayBuffer.addFinal(error);
        for (ReplayDisposable replay : c(error)) {
            replayBuffer.replay(replay);
        }
    }

    public void onNext(T t11) {
        ExceptionHelper.nullCheck(t11, "onNext called with a null value.");
        if (!this.f23428d) {
            ReplayBuffer<T> replayBuffer = this.f23426b;
            replayBuffer.add(t11);
            for (ReplayDisposable replay : (ReplayDisposable[]) this.f23427c.get()) {
                replayBuffer.replay(replay);
            }
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (this.f23428d) {
            disposable.dispose();
        }
    }

    public void subscribeActual(Observer<? super T> observer) {
        ReplayDisposable replayDisposable = new ReplayDisposable(observer, this);
        observer.onSubscribe(replayDisposable);
        if (!a(replayDisposable) || !replayDisposable.f23433e) {
            this.f23426b.replay(replayDisposable);
        } else {
            b(replayDisposable);
        }
    }

    @NonNull
    @CheckReturnValue
    public static <T> ReplaySubject<T> create(int i11) {
        ObjectHelper.verifyPositive(i11, "capacityHint");
        return new ReplaySubject<>(new UnboundedReplayBuffer(i11));
    }

    @CheckReturnValue
    public T[] getValues(T[] tArr) {
        return this.f23426b.getValues(tArr);
    }
}
