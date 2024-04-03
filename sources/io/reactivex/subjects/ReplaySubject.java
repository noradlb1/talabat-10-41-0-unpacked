package io.reactivex.subjects;

import i.b;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ReplaySubject<T> extends Subject<T> {
    private static final Object[] EMPTY_ARRAY = new Object[0];

    /* renamed from: e  reason: collision with root package name */
    public static final ReplayDisposable[] f23619e = new ReplayDisposable[0];

    /* renamed from: f  reason: collision with root package name */
    public static final ReplayDisposable[] f23620f = new ReplayDisposable[0];

    /* renamed from: b  reason: collision with root package name */
    public final ReplayBuffer<T> f23621b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<ReplayDisposable<T>[]> f23622c = new AtomicReference<>(f23619e);

    /* renamed from: d  reason: collision with root package name */
    public boolean f23623d;

    public static final class Node<T> extends AtomicReference<Node<T>> {
        private static final long serialVersionUID = 6404226426336033100L;

        /* renamed from: b  reason: collision with root package name */
        public final T f23624b;

        public Node(T t11) {
            this.f23624b = t11;
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
        public final Observer<? super T> f23625b;

        /* renamed from: c  reason: collision with root package name */
        public final ReplaySubject<T> f23626c;

        /* renamed from: d  reason: collision with root package name */
        public Object f23627d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f23628e;

        public ReplayDisposable(Observer<? super T> observer, ReplaySubject<T> replaySubject) {
            this.f23625b = observer;
            this.f23626c = replaySubject;
        }

        public void dispose() {
            if (!this.f23628e) {
                this.f23628e = true;
                this.f23626c.b(this);
            }
        }

        public boolean isDisposed() {
            return this.f23628e;
        }
    }

    public static final class SizeAndTimeBoundReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = -8056260896137901749L;

        /* renamed from: b  reason: collision with root package name */
        public final int f23629b;

        /* renamed from: c  reason: collision with root package name */
        public final long f23630c;

        /* renamed from: d  reason: collision with root package name */
        public final TimeUnit f23631d;

        /* renamed from: e  reason: collision with root package name */
        public final Scheduler f23632e;

        /* renamed from: f  reason: collision with root package name */
        public int f23633f;

        /* renamed from: g  reason: collision with root package name */
        public volatile TimedNode<Object> f23634g;

        /* renamed from: h  reason: collision with root package name */
        public TimedNode<Object> f23635h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f23636i;

        public SizeAndTimeBoundReplayBuffer(int i11, long j11, TimeUnit timeUnit, Scheduler scheduler) {
            this.f23629b = ObjectHelper.verifyPositive(i11, "maxSize");
            this.f23630c = ObjectHelper.verifyPositive(j11, "maxAge");
            this.f23631d = (TimeUnit) ObjectHelper.requireNonNull(timeUnit, "unit is null");
            this.f23632e = (Scheduler) ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            TimedNode<Object> timedNode = new TimedNode<>(null, 0);
            this.f23635h = timedNode;
            this.f23634g = timedNode;
        }

        public TimedNode<Object> a() {
            TimedNode<Object> timedNode;
            TimedNode<Object> timedNode2 = this.f23634g;
            long now = this.f23632e.now(this.f23631d) - this.f23630c;
            Object obj = timedNode2.get();
            while (true) {
                TimedNode<Object> timedNode3 = (TimedNode) obj;
                timedNode = timedNode2;
                timedNode2 = timedNode3;
                if (timedNode2 == null || timedNode2.f23643c > now) {
                    return timedNode;
                }
                obj = timedNode2.get();
            }
            return timedNode;
        }

        public void add(T t11) {
            TimedNode<Object> timedNode = new TimedNode<>(t11, this.f23632e.now(this.f23631d));
            TimedNode<Object> timedNode2 = this.f23635h;
            this.f23635h = timedNode;
            this.f23633f++;
            timedNode2.set(timedNode);
            c();
        }

        public void addFinal(Object obj) {
            TimedNode<Object> timedNode = new TimedNode<>(obj, Long.MAX_VALUE);
            TimedNode<Object> timedNode2 = this.f23635h;
            this.f23635h = timedNode;
            this.f23633f++;
            timedNode2.lazySet(timedNode);
            d();
            this.f23636i = true;
        }

        public int b(TimedNode<Object> timedNode) {
            int i11 = 0;
            while (i11 != Integer.MAX_VALUE) {
                TimedNode<Object> timedNode2 = (TimedNode) timedNode.get();
                if (timedNode2 == null) {
                    T t11 = timedNode.f23642b;
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
            int i11 = this.f23633f;
            if (i11 > this.f23629b) {
                this.f23633f = i11 - 1;
                this.f23634g = (TimedNode) this.f23634g.get();
            }
            long now = this.f23632e.now(this.f23631d) - this.f23630c;
            TimedNode<Object> timedNode = this.f23634g;
            while (this.f23633f > 1) {
                TimedNode<Object> timedNode2 = (TimedNode) timedNode.get();
                if (timedNode2 == null) {
                    this.f23634g = timedNode;
                    return;
                } else if (timedNode2.f23643c > now) {
                    this.f23634g = timedNode;
                    return;
                } else {
                    this.f23633f--;
                    timedNode = timedNode2;
                }
            }
            this.f23634g = timedNode;
        }

        public void d() {
            long now = this.f23632e.now(this.f23631d) - this.f23630c;
            TimedNode<Object> timedNode = this.f23634g;
            while (true) {
                TimedNode<Object> timedNode2 = (TimedNode) timedNode.get();
                if (timedNode2.get() == null) {
                    if (timedNode.f23642b != null) {
                        TimedNode<Object> timedNode3 = new TimedNode<>(null, 0);
                        timedNode3.lazySet(timedNode.get());
                        this.f23634g = timedNode3;
                        return;
                    }
                    this.f23634g = timedNode;
                    return;
                } else if (timedNode2.f23643c <= now) {
                    timedNode = timedNode2;
                } else if (timedNode.f23642b != null) {
                    TimedNode<Object> timedNode4 = new TimedNode<>(null, 0);
                    timedNode4.lazySet(timedNode.get());
                    this.f23634g = timedNode4;
                    return;
                } else {
                    this.f23634g = timedNode;
                    return;
                }
            }
        }

        @Nullable
        public T getValue() {
            T t11;
            TimedNode<Object> timedNode = this.f23634g;
            TimedNode<Object> timedNode2 = null;
            while (true) {
                TimedNode<Object> timedNode3 = (TimedNode) timedNode.get();
                if (timedNode3 == null) {
                    break;
                }
                timedNode2 = timedNode;
                timedNode = timedNode3;
            }
            if (timedNode.f23643c < this.f23632e.now(this.f23631d) - this.f23630c || (t11 = timedNode.f23642b) == null) {
                return null;
            }
            if (NotificationLite.isComplete(t11) || NotificationLite.isError(t11)) {
                return timedNode2.f23642b;
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
                    tArr[i11] = a11.f23642b;
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
                Observer<? super T> observer = replayDisposable.f23625b;
                TimedNode<Object> timedNode = (TimedNode) replayDisposable.f23627d;
                if (timedNode == null) {
                    timedNode = a();
                }
                int i11 = 1;
                while (!replayDisposable.f23628e) {
                    while (!replayDisposable.f23628e) {
                        TimedNode<Object> timedNode2 = (TimedNode) timedNode.get();
                        if (timedNode2 != null) {
                            T t11 = timedNode2.f23642b;
                            if (!this.f23636i || timedNode2.get() != null) {
                                observer.onNext(t11);
                                timedNode = timedNode2;
                            } else {
                                if (NotificationLite.isComplete(t11)) {
                                    observer.onComplete();
                                } else {
                                    observer.onError(NotificationLite.getError(t11));
                                }
                                replayDisposable.f23627d = null;
                                replayDisposable.f23628e = true;
                                return;
                            }
                        } else if (timedNode.get() == null) {
                            replayDisposable.f23627d = timedNode;
                            i11 = replayDisposable.addAndGet(-i11);
                            if (i11 == 0) {
                                return;
                            }
                        }
                    }
                    replayDisposable.f23627d = null;
                    return;
                }
                replayDisposable.f23627d = null;
            }
        }

        public int size() {
            return b(a());
        }

        public void trimHead() {
            TimedNode<Object> timedNode = this.f23634g;
            if (timedNode.f23642b != null) {
                TimedNode<Object> timedNode2 = new TimedNode<>(null, 0);
                timedNode2.lazySet(timedNode.get());
                this.f23634g = timedNode2;
            }
        }
    }

    public static final class SizeBoundReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 1107649250281456395L;

        /* renamed from: b  reason: collision with root package name */
        public final int f23637b;

        /* renamed from: c  reason: collision with root package name */
        public int f23638c;

        /* renamed from: d  reason: collision with root package name */
        public volatile Node<Object> f23639d;

        /* renamed from: e  reason: collision with root package name */
        public Node<Object> f23640e;

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f23641f;

        public SizeBoundReplayBuffer(int i11) {
            this.f23637b = ObjectHelper.verifyPositive(i11, "maxSize");
            Node<Object> node = new Node<>(null);
            this.f23640e = node;
            this.f23639d = node;
        }

        public void a() {
            int i11 = this.f23638c;
            if (i11 > this.f23637b) {
                this.f23638c = i11 - 1;
                this.f23639d = (Node) this.f23639d.get();
            }
        }

        public void add(T t11) {
            Node<Object> node = new Node<>(t11);
            Node<Object> node2 = this.f23640e;
            this.f23640e = node;
            this.f23638c++;
            node2.set(node);
            a();
        }

        public void addFinal(Object obj) {
            Node<Object> node = new Node<>(obj);
            Node<Object> node2 = this.f23640e;
            this.f23640e = node;
            this.f23638c++;
            node2.lazySet(node);
            trimHead();
            this.f23641f = true;
        }

        @Nullable
        public T getValue() {
            Node<Object> node = this.f23639d;
            Node<Object> node2 = null;
            while (true) {
                Node<Object> node3 = (Node) node.get();
                if (node3 == null) {
                    break;
                }
                node2 = node;
                node = node3;
            }
            T t11 = node.f23624b;
            if (t11 == null) {
                return null;
            }
            if (NotificationLite.isComplete(t11) || NotificationLite.isError(t11)) {
                return node2.f23624b;
            }
            return t11;
        }

        public T[] getValues(T[] tArr) {
            Node<Object> node = this.f23639d;
            int size = size();
            if (size != 0) {
                if (tArr.length < size) {
                    tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
                }
                for (int i11 = 0; i11 != size; i11++) {
                    node = (Node) node.get();
                    tArr[i11] = node.f23624b;
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
                Observer<? super T> observer = replayDisposable.f23625b;
                Node<Object> node = (Node) replayDisposable.f23627d;
                if (node == null) {
                    node = this.f23639d;
                }
                int i11 = 1;
                while (!replayDisposable.f23628e) {
                    Node<Object> node2 = (Node) node.get();
                    if (node2 != null) {
                        T t11 = node2.f23624b;
                        if (!this.f23641f || node2.get() != null) {
                            observer.onNext(t11);
                            node = node2;
                        } else {
                            if (NotificationLite.isComplete(t11)) {
                                observer.onComplete();
                            } else {
                                observer.onError(NotificationLite.getError(t11));
                            }
                            replayDisposable.f23627d = null;
                            replayDisposable.f23628e = true;
                            return;
                        }
                    } else if (node.get() != null) {
                        continue;
                    } else {
                        replayDisposable.f23627d = node;
                        i11 = replayDisposable.addAndGet(-i11);
                        if (i11 == 0) {
                            return;
                        }
                    }
                }
                replayDisposable.f23627d = null;
            }
        }

        public int size() {
            Node<Object> node = this.f23639d;
            int i11 = 0;
            while (i11 != Integer.MAX_VALUE) {
                Node<Object> node2 = (Node) node.get();
                if (node2 == null) {
                    T t11 = node.f23624b;
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
            Node<Object> node = this.f23639d;
            if (node.f23624b != null) {
                Node<Object> node2 = new Node<>(null);
                node2.lazySet(node.get());
                this.f23639d = node2;
            }
        }
    }

    public static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
        private static final long serialVersionUID = 6404226426336033100L;

        /* renamed from: b  reason: collision with root package name */
        public final T f23642b;

        /* renamed from: c  reason: collision with root package name */
        public final long f23643c;

        public TimedNode(T t11, long j11) {
            this.f23642b = t11;
            this.f23643c = j11;
        }
    }

    public static final class UnboundedReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = -733876083048047795L;

        /* renamed from: b  reason: collision with root package name */
        public final List<Object> f23644b;

        /* renamed from: c  reason: collision with root package name */
        public volatile boolean f23645c;

        /* renamed from: d  reason: collision with root package name */
        public volatile int f23646d;

        public UnboundedReplayBuffer(int i11) {
            this.f23644b = new ArrayList(ObjectHelper.verifyPositive(i11, "capacityHint"));
        }

        public void add(T t11) {
            this.f23644b.add(t11);
            this.f23646d++;
        }

        public void addFinal(Object obj) {
            this.f23644b.add(obj);
            trimHead();
            this.f23646d++;
            this.f23645c = true;
        }

        @Nullable
        public T getValue() {
            int i11 = this.f23646d;
            if (i11 == 0) {
                return null;
            }
            List<Object> list = this.f23644b;
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
            int i11 = this.f23646d;
            if (i11 == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
            List list = this.f23644b;
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
                List<Object> list = this.f23644b;
                Observer<? super T> observer = replayDisposable.f23625b;
                Integer num = (Integer) replayDisposable.f23627d;
                if (num != null) {
                    i11 = num.intValue();
                } else {
                    i11 = 0;
                    replayDisposable.f23627d = 0;
                }
                int i13 = 1;
                while (!replayDisposable.f23628e) {
                    int i14 = this.f23646d;
                    while (i14 != i11) {
                        if (replayDisposable.f23628e) {
                            replayDisposable.f23627d = null;
                            return;
                        }
                        Object obj = list.get(i11);
                        if (this.f23645c && (i12 = i11 + 1) == i14 && i12 == (i14 = this.f23646d)) {
                            if (NotificationLite.isComplete(obj)) {
                                observer.onComplete();
                            } else {
                                observer.onError(NotificationLite.getError(obj));
                            }
                            replayDisposable.f23627d = null;
                            replayDisposable.f23628e = true;
                            return;
                        }
                        observer.onNext(obj);
                        i11++;
                    }
                    if (i11 == this.f23646d) {
                        replayDisposable.f23627d = Integer.valueOf(i11);
                        i13 = replayDisposable.addAndGet(-i13);
                        if (i13 == 0) {
                            return;
                        }
                    }
                }
                replayDisposable.f23627d = null;
            }
        }

        public int size() {
            int i11 = this.f23646d;
            if (i11 == 0) {
                return 0;
            }
            int i12 = i11 - 1;
            Object obj = this.f23644b.get(i12);
            if (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) {
                return i12;
            }
            return i11;
        }

        public void trimHead() {
        }
    }

    public ReplaySubject(ReplayBuffer<T> replayBuffer) {
        this.f23621b = replayBuffer;
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplaySubject<T> create() {
        return new ReplaySubject<>(new UnboundedReplayBuffer(16));
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplaySubject<T> createWithSize(int i11) {
        return new ReplaySubject<>(new SizeBoundReplayBuffer(i11));
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplaySubject<T> createWithTime(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        return new ReplaySubject<>(new SizeAndTimeBoundReplayBuffer(Integer.MAX_VALUE, j11, timeUnit, scheduler));
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplaySubject<T> createWithTimeAndSize(long j11, TimeUnit timeUnit, Scheduler scheduler, int i11) {
        return new ReplaySubject<>(new SizeAndTimeBoundReplayBuffer(i11, j11, timeUnit, scheduler));
    }

    public boolean a(ReplayDisposable<T> replayDisposable) {
        ReplayDisposable[] replayDisposableArr;
        ReplayDisposable[] replayDisposableArr2;
        do {
            replayDisposableArr = (ReplayDisposable[]) this.f23622c.get();
            if (replayDisposableArr == f23620f) {
                return false;
            }
            int length = replayDisposableArr.length;
            replayDisposableArr2 = new ReplayDisposable[(length + 1)];
            System.arraycopy(replayDisposableArr, 0, replayDisposableArr2, 0, length);
            replayDisposableArr2[length] = replayDisposable;
        } while (!b.a(this.f23622c, replayDisposableArr, replayDisposableArr2));
        return true;
    }

    public void b(ReplayDisposable<T> replayDisposable) {
        ReplayDisposable<T>[] replayDisposableArr;
        ReplayDisposable[] replayDisposableArr2;
        do {
            replayDisposableArr = (ReplayDisposable[]) this.f23622c.get();
            if (replayDisposableArr != f23620f && replayDisposableArr != f23619e) {
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
                        replayDisposableArr2 = f23619e;
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
        } while (!b.a(this.f23622c, replayDisposableArr, replayDisposableArr2));
    }

    public ReplayDisposable<T>[] c(Object obj) {
        if (this.f23621b.compareAndSet((Object) null, obj)) {
            return (ReplayDisposable[]) this.f23622c.getAndSet(f23620f);
        }
        return f23620f;
    }

    public void cleanupBuffer() {
        this.f23621b.trimHead();
    }

    @Nullable
    public Throwable getThrowable() {
        Object obj = this.f23621b.get();
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    @Nullable
    public T getValue() {
        return this.f23621b.getValue();
    }

    public Object[] getValues() {
        Object[] objArr = EMPTY_ARRAY;
        Object[] values = getValues(objArr);
        return values == objArr ? new Object[0] : values;
    }

    public boolean hasComplete() {
        return NotificationLite.isComplete(this.f23621b.get());
    }

    public boolean hasObservers() {
        return ((ReplayDisposable[]) this.f23622c.get()).length != 0;
    }

    public boolean hasThrowable() {
        return NotificationLite.isError(this.f23621b.get());
    }

    public boolean hasValue() {
        return this.f23621b.size() != 0;
    }

    public void onComplete() {
        if (!this.f23623d) {
            this.f23623d = true;
            Object complete = NotificationLite.complete();
            ReplayBuffer<T> replayBuffer = this.f23621b;
            replayBuffer.addFinal(complete);
            for (ReplayDisposable replay : c(complete)) {
                replayBuffer.replay(replay);
            }
        }
    }

    public void onError(Throwable th2) {
        ObjectHelper.requireNonNull(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f23623d) {
            RxJavaPlugins.onError(th2);
            return;
        }
        this.f23623d = true;
        Object error = NotificationLite.error(th2);
        ReplayBuffer<T> replayBuffer = this.f23621b;
        replayBuffer.addFinal(error);
        for (ReplayDisposable replay : c(error)) {
            replayBuffer.replay(replay);
        }
    }

    public void onNext(T t11) {
        ObjectHelper.requireNonNull(t11, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f23623d) {
            ReplayBuffer<T> replayBuffer = this.f23621b;
            replayBuffer.add(t11);
            for (ReplayDisposable replay : (ReplayDisposable[]) this.f23622c.get()) {
                replayBuffer.replay(replay);
            }
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (this.f23623d) {
            disposable.dispose();
        }
    }

    public void subscribeActual(Observer<? super T> observer) {
        ReplayDisposable replayDisposable = new ReplayDisposable(observer, this);
        observer.onSubscribe(replayDisposable);
        if (replayDisposable.f23628e) {
            return;
        }
        if (!a(replayDisposable) || !replayDisposable.f23628e) {
            this.f23621b.replay(replayDisposable);
        } else {
            b(replayDisposable);
        }
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplaySubject<T> create(int i11) {
        return new ReplaySubject<>(new UnboundedReplayBuffer(i11));
    }

    public T[] getValues(T[] tArr) {
        return this.f23621b.getValues(tArr);
    }
}
