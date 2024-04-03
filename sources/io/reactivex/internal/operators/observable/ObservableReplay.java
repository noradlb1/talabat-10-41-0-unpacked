package io.reactivex.internal.operators.observable;

import i.b;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.HasUpstreamObservableSource;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Timed;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableReplay<T> extends ConnectableObservable<T> implements HasUpstreamObservableSource<T>, ResettableConnectable {

    /* renamed from: f  reason: collision with root package name */
    public static final BufferSupplier f17545f = new UnBoundedFactory();

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f17546b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<ReplayObserver<T>> f17547c;

    /* renamed from: d  reason: collision with root package name */
    public final BufferSupplier<T> f17548d;

    /* renamed from: e  reason: collision with root package name */
    public final ObservableSource<T> f17549e;

    public static abstract class BoundedReplayBuffer<T> extends AtomicReference<Node> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 2346567790059478686L;

        /* renamed from: b  reason: collision with root package name */
        public Node f17550b;

        /* renamed from: c  reason: collision with root package name */
        public int f17551c;

        public BoundedReplayBuffer() {
            Node node = new Node((Object) null);
            this.f17550b = node;
            set(node);
        }

        public final void a(Node node) {
            this.f17550b.set(node);
            this.f17550b = node;
            this.f17551c++;
        }

        public Object b(Object obj) {
            return obj;
        }

        public Node c() {
            return (Node) get();
        }

        public final void complete() {
            a(new Node(b(NotificationLite.complete())));
            i();
        }

        public Object d(Object obj) {
            return obj;
        }

        public final void e() {
            this.f17551c--;
            f((Node) ((Node) get()).get());
        }

        public final void error(Throwable th2) {
            a(new Node(b(NotificationLite.error(th2))));
            i();
        }

        public final void f(Node node) {
            set(node);
        }

        public final void g() {
            Node node = (Node) get();
            if (node.f17556b != null) {
                Node node2 = new Node((Object) null);
                node2.lazySet(node.get());
                set(node2);
            }
        }

        public abstract void h();

        public void i() {
            g();
        }

        public final void next(T t11) {
            a(new Node(b(NotificationLite.next(t11))));
            h();
        }

        public final void replay(InnerDisposable<T> innerDisposable) {
            if (innerDisposable.getAndIncrement() == 0) {
                int i11 = 1;
                do {
                    Node node = (Node) innerDisposable.a();
                    if (node == null) {
                        node = c();
                        innerDisposable.f17554d = node;
                    }
                    while (!innerDisposable.isDisposed()) {
                        Node node2 = (Node) node.get();
                        if (node2 == null) {
                            innerDisposable.f17554d = node;
                            i11 = innerDisposable.addAndGet(-i11);
                        } else if (NotificationLite.accept(d(node2.f17556b), innerDisposable.f17553c)) {
                            innerDisposable.f17554d = null;
                            return;
                        } else {
                            node = node2;
                        }
                    }
                    innerDisposable.f17554d = null;
                    return;
                } while (i11 != 0);
            }
        }
    }

    public interface BufferSupplier<T> {
        ReplayBuffer<T> call();
    }

    public static final class DisposeConsumer<R> implements Consumer<Disposable> {
        private final ObserverResourceWrapper<R> srw;

        public DisposeConsumer(ObserverResourceWrapper<R> observerResourceWrapper) {
            this.srw = observerResourceWrapper;
        }

        public void accept(Disposable disposable) {
            this.srw.setResource(disposable);
        }
    }

    public static final class InnerDisposable<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 2728361546769921047L;

        /* renamed from: b  reason: collision with root package name */
        public final ReplayObserver<T> f17552b;

        /* renamed from: c  reason: collision with root package name */
        public final Observer<? super T> f17553c;

        /* renamed from: d  reason: collision with root package name */
        public Object f17554d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f17555e;

        public InnerDisposable(ReplayObserver<T> replayObserver, Observer<? super T> observer) {
            this.f17552b = replayObserver;
            this.f17553c = observer;
        }

        public <U> U a() {
            return this.f17554d;
        }

        public void dispose() {
            if (!this.f17555e) {
                this.f17555e = true;
                this.f17552b.b(this);
                this.f17554d = null;
            }
        }

        public boolean isDisposed() {
            return this.f17555e;
        }
    }

    public static final class MulticastReplay<R, U> extends Observable<R> {
        private final Callable<? extends ConnectableObservable<U>> connectableFactory;
        private final Function<? super Observable<U>, ? extends ObservableSource<R>> selector;

        public MulticastReplay(Callable<? extends ConnectableObservable<U>> callable, Function<? super Observable<U>, ? extends ObservableSource<R>> function) {
            this.connectableFactory = callable;
            this.selector = function;
        }

        public void subscribeActual(Observer<? super R> observer) {
            try {
                ConnectableObservable connectableObservable = (ConnectableObservable) ObjectHelper.requireNonNull(this.connectableFactory.call(), "The connectableFactory returned a null ConnectableObservable");
                ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.selector.apply(connectableObservable), "The selector returned a null ObservableSource");
                ObserverResourceWrapper observerResourceWrapper = new ObserverResourceWrapper(observer);
                observableSource.subscribe(observerResourceWrapper);
                connectableObservable.connect(new DisposeConsumer(observerResourceWrapper));
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                EmptyDisposable.error(th2, (Observer<?>) observer);
            }
        }
    }

    public static final class Node extends AtomicReference<Node> {
        private static final long serialVersionUID = 245354315435971818L;

        /* renamed from: b  reason: collision with root package name */
        public final Object f17556b;

        public Node(Object obj) {
            this.f17556b = obj;
        }
    }

    public static final class Replay<T> extends ConnectableObservable<T> {

        /* renamed from: co  reason: collision with root package name */
        private final ConnectableObservable<T> f17557co;
        private final Observable<T> observable;

        public Replay(ConnectableObservable<T> connectableObservable, Observable<T> observable2) {
            this.f17557co = connectableObservable;
            this.observable = observable2;
        }

        public void connect(Consumer<? super Disposable> consumer) {
            this.f17557co.connect(consumer);
        }

        public void subscribeActual(Observer<? super T> observer) {
            this.observable.subscribe(observer);
        }
    }

    public interface ReplayBuffer<T> {
        void complete();

        void error(Throwable th2);

        void next(T t11);

        void replay(InnerDisposable<T> innerDisposable);
    }

    public static final class ReplayBufferSupplier<T> implements BufferSupplier<T> {
        private final int bufferSize;

        public ReplayBufferSupplier(int i11) {
            this.bufferSize = i11;
        }

        public ReplayBuffer<T> call() {
            return new SizeBoundReplayBuffer(this.bufferSize);
        }
    }

    public static final class ReplayObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        public static final InnerDisposable[] f17558f = new InnerDisposable[0];

        /* renamed from: g  reason: collision with root package name */
        public static final InnerDisposable[] f17559g = new InnerDisposable[0];
        private static final long serialVersionUID = -533785617179540163L;

        /* renamed from: b  reason: collision with root package name */
        public final ReplayBuffer<T> f17560b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f17561c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReference<InnerDisposable[]> f17562d = new AtomicReference<>(f17558f);

        /* renamed from: e  reason: collision with root package name */
        public final AtomicBoolean f17563e = new AtomicBoolean();

        public ReplayObserver(ReplayBuffer<T> replayBuffer) {
            this.f17560b = replayBuffer;
        }

        public boolean a(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = this.f17562d.get();
                if (innerDisposableArr == f17559g) {
                    return false;
                }
                int length = innerDisposableArr.length;
                innerDisposableArr2 = new InnerDisposable[(length + 1)];
                System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                innerDisposableArr2[length] = innerDisposable;
            } while (!b.a(this.f17562d, innerDisposableArr, innerDisposableArr2));
            return true;
        }

        public void b(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = this.f17562d.get();
                int length = innerDisposableArr.length;
                if (length != 0) {
                    int i11 = 0;
                    while (true) {
                        if (i11 >= length) {
                            i11 = -1;
                            break;
                        } else if (innerDisposableArr[i11].equals(innerDisposable)) {
                            break;
                        } else {
                            i11++;
                        }
                    }
                    if (i11 >= 0) {
                        if (length == 1) {
                            innerDisposableArr2 = f17558f;
                        } else {
                            InnerDisposable[] innerDisposableArr3 = new InnerDisposable[(length - 1)];
                            System.arraycopy(innerDisposableArr, 0, innerDisposableArr3, 0, i11);
                            System.arraycopy(innerDisposableArr, i11 + 1, innerDisposableArr3, i11, (length - i11) - 1);
                            innerDisposableArr2 = innerDisposableArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!b.a(this.f17562d, innerDisposableArr, innerDisposableArr2));
        }

        public void c() {
            for (InnerDisposable replay : this.f17562d.get()) {
                this.f17560b.replay(replay);
            }
        }

        public void d() {
            for (InnerDisposable replay : this.f17562d.getAndSet(f17559g)) {
                this.f17560b.replay(replay);
            }
        }

        public void dispose() {
            this.f17562d.set(f17559g);
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return this.f17562d.get() == f17559g;
        }

        public void onComplete() {
            if (!this.f17561c) {
                this.f17561c = true;
                this.f17560b.complete();
                d();
            }
        }

        public void onError(Throwable th2) {
            if (!this.f17561c) {
                this.f17561c = true;
                this.f17560b.error(th2);
                d();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f17561c) {
                this.f17560b.next(t11);
                c();
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                c();
            }
        }
    }

    public static final class ReplaySource<T> implements ObservableSource<T> {
        private final BufferSupplier<T> bufferFactory;
        private final AtomicReference<ReplayObserver<T>> curr;

        public ReplaySource(AtomicReference<ReplayObserver<T>> atomicReference, BufferSupplier<T> bufferSupplier) {
            this.curr = atomicReference;
            this.bufferFactory = bufferSupplier;
        }

        /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void subscribe(io.reactivex.Observer<? super T> r4) {
            /*
                r3 = this;
            L_0x0000:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver<T>> r0 = r3.curr
                java.lang.Object r0 = r0.get()
                io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver r0 = (io.reactivex.internal.operators.observable.ObservableReplay.ReplayObserver) r0
                if (r0 != 0) goto L_0x0020
                io.reactivex.internal.operators.observable.ObservableReplay$BufferSupplier<T> r0 = r3.bufferFactory
                io.reactivex.internal.operators.observable.ObservableReplay$ReplayBuffer r0 = r0.call()
                io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver r1 = new io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver
                r1.<init>(r0)
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver<T>> r0 = r3.curr
                r2 = 0
                boolean r0 = i.b.a(r0, r2, r1)
                if (r0 != 0) goto L_0x001f
                goto L_0x0000
            L_0x001f:
                r0 = r1
            L_0x0020:
                io.reactivex.internal.operators.observable.ObservableReplay$InnerDisposable r1 = new io.reactivex.internal.operators.observable.ObservableReplay$InnerDisposable
                r1.<init>(r0, r4)
                r4.onSubscribe(r1)
                r0.a(r1)
                boolean r4 = r1.isDisposed()
                if (r4 == 0) goto L_0x0035
                r0.b(r1)
                return
            L_0x0035:
                io.reactivex.internal.operators.observable.ObservableReplay$ReplayBuffer<T> r4 = r0.f17560b
                r4.replay(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableReplay.ReplaySource.subscribe(io.reactivex.Observer):void");
        }
    }

    public static final class ScheduledReplaySupplier<T> implements BufferSupplier<T> {
        private final int bufferSize;
        private final long maxAge;
        private final Scheduler scheduler;
        private final TimeUnit unit;

        public ScheduledReplaySupplier(int i11, long j11, TimeUnit timeUnit, Scheduler scheduler2) {
            this.bufferSize = i11;
            this.maxAge = j11;
            this.unit = timeUnit;
            this.scheduler = scheduler2;
        }

        public ReplayBuffer<T> call() {
            return new SizeAndTimeBoundReplayBuffer(this.bufferSize, this.maxAge, this.unit, this.scheduler);
        }
    }

    public static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = 3457957419649567404L;

        /* renamed from: d  reason: collision with root package name */
        public final Scheduler f17564d;

        /* renamed from: e  reason: collision with root package name */
        public final long f17565e;

        /* renamed from: f  reason: collision with root package name */
        public final TimeUnit f17566f;

        /* renamed from: g  reason: collision with root package name */
        public final int f17567g;

        public SizeAndTimeBoundReplayBuffer(int i11, long j11, TimeUnit timeUnit, Scheduler scheduler) {
            this.f17564d = scheduler;
            this.f17567g = i11;
            this.f17565e = j11;
            this.f17566f = timeUnit;
        }

        public Object b(Object obj) {
            return new Timed(obj, this.f17564d.now(this.f17566f), this.f17566f);
        }

        public Node c() {
            Node node;
            long now = this.f17564d.now(this.f17566f) - this.f17565e;
            Node node2 = (Node) get();
            Object obj = node2.get();
            while (true) {
                Node node3 = (Node) obj;
                node = node2;
                node2 = node3;
                if (node2 != null) {
                    Timed timed = (Timed) node2.f17556b;
                    if (NotificationLite.isComplete(timed.value()) || NotificationLite.isError(timed.value()) || timed.time() > now) {
                        break;
                    }
                    obj = node2.get();
                } else {
                    break;
                }
            }
            return node;
        }

        public Object d(Object obj) {
            return ((Timed) obj).value();
        }

        public void h() {
            Node node;
            long now = this.f17564d.now(this.f17566f) - this.f17565e;
            Node node2 = (Node) get();
            Node node3 = (Node) node2.get();
            int i11 = 0;
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 == null) {
                    break;
                }
                int i12 = this.f17551c;
                if (i12 <= this.f17567g || i12 <= 1) {
                    if (((Timed) node2.f17556b).time() > now) {
                        break;
                    }
                    i11++;
                    this.f17551c--;
                    node3 = (Node) node2.get();
                } else {
                    i11++;
                    this.f17551c = i12 - 1;
                    node3 = (Node) node2.get();
                }
            }
            if (i11 != 0) {
                f(node);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x003e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void i() {
            /*
                r10 = this;
                io.reactivex.Scheduler r0 = r10.f17564d
                java.util.concurrent.TimeUnit r1 = r10.f17566f
                long r0 = r0.now(r1)
                long r2 = r10.f17565e
                long r0 = r0 - r2
                java.lang.Object r2 = r10.get()
                io.reactivex.internal.operators.observable.ObservableReplay$Node r2 = (io.reactivex.internal.operators.observable.ObservableReplay.Node) r2
                java.lang.Object r3 = r2.get()
                io.reactivex.internal.operators.observable.ObservableReplay$Node r3 = (io.reactivex.internal.operators.observable.ObservableReplay.Node) r3
                r4 = 0
            L_0x0018:
                r9 = r3
                r3 = r2
                r2 = r9
                if (r2 == 0) goto L_0x003c
                int r5 = r10.f17551c
                r6 = 1
                if (r5 <= r6) goto L_0x003c
                java.lang.Object r5 = r2.f17556b
                io.reactivex.schedulers.Timed r5 = (io.reactivex.schedulers.Timed) r5
                long r7 = r5.time()
                int r5 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r5 > 0) goto L_0x003c
                int r4 = r4 + 1
                int r3 = r10.f17551c
                int r3 = r3 - r6
                r10.f17551c = r3
                java.lang.Object r3 = r2.get()
                io.reactivex.internal.operators.observable.ObservableReplay$Node r3 = (io.reactivex.internal.operators.observable.ObservableReplay.Node) r3
                goto L_0x0018
            L_0x003c:
                if (r4 == 0) goto L_0x0041
                r10.f(r3)
            L_0x0041:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableReplay.SizeAndTimeBoundReplayBuffer.i():void");
        }
    }

    public static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = -5898283885385201806L;

        /* renamed from: d  reason: collision with root package name */
        public final int f17568d;

        public SizeBoundReplayBuffer(int i11) {
            this.f17568d = i11;
        }

        public void h() {
            if (this.f17551c > this.f17568d) {
                e();
            }
        }
    }

    public static final class UnBoundedFactory implements BufferSupplier<Object> {
        public ReplayBuffer<Object> call() {
            return new UnboundedReplayBuffer(16);
        }
    }

    public static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 7063189396499112664L;

        /* renamed from: b  reason: collision with root package name */
        public volatile int f17569b;

        public UnboundedReplayBuffer(int i11) {
            super(i11);
        }

        public void complete() {
            add(NotificationLite.complete());
            this.f17569b++;
        }

        public void error(Throwable th2) {
            add(NotificationLite.error(th2));
            this.f17569b++;
        }

        public void next(T t11) {
            add(NotificationLite.next(t11));
            this.f17569b++;
        }

        public void replay(InnerDisposable<T> innerDisposable) {
            int i11;
            if (innerDisposable.getAndIncrement() == 0) {
                Observer<? super T> observer = innerDisposable.f17553c;
                int i12 = 1;
                while (!innerDisposable.isDisposed()) {
                    int i13 = this.f17569b;
                    Integer num = (Integer) innerDisposable.a();
                    if (num != null) {
                        i11 = num.intValue();
                    } else {
                        i11 = 0;
                    }
                    while (i11 < i13) {
                        if (!NotificationLite.accept(get(i11), observer) && !innerDisposable.isDisposed()) {
                            i11++;
                        } else {
                            return;
                        }
                    }
                    innerDisposable.f17554d = Integer.valueOf(i11);
                    i12 = innerDisposable.addAndGet(-i12);
                    if (i12 == 0) {
                        return;
                    }
                }
            }
        }
    }

    private ObservableReplay(ObservableSource<T> observableSource, ObservableSource<T> observableSource2, AtomicReference<ReplayObserver<T>> atomicReference, BufferSupplier<T> bufferSupplier) {
        this.f17549e = observableSource;
        this.f17546b = observableSource2;
        this.f17547c = atomicReference;
        this.f17548d = bufferSupplier;
    }

    public static <T> ConnectableObservable<T> a(ObservableSource<T> observableSource, BufferSupplier<T> bufferSupplier) {
        AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.onAssembly(new ObservableReplay(new ReplaySource(atomicReference, bufferSupplier), observableSource, atomicReference, bufferSupplier));
    }

    public static <T> ConnectableObservable<T> create(ObservableSource<T> observableSource, int i11) {
        if (i11 == Integer.MAX_VALUE) {
            return createFrom(observableSource);
        }
        return a(observableSource, new ReplayBufferSupplier(i11));
    }

    public static <T> ConnectableObservable<T> createFrom(ObservableSource<? extends T> observableSource) {
        return a(observableSource, f17545f);
    }

    public static <U, R> Observable<R> multicastSelector(Callable<? extends ConnectableObservable<U>> callable, Function<? super Observable<U>, ? extends ObservableSource<R>> function) {
        return RxJavaPlugins.onAssembly(new MulticastReplay(callable, function));
    }

    public static <T> ConnectableObservable<T> observeOn(ConnectableObservable<T> connectableObservable, Scheduler scheduler) {
        return RxJavaPlugins.onAssembly(new Replay(connectableObservable, connectableObservable.observeOn(scheduler)));
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect(io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> r5) {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver<T>> r0 = r4.f17547c
            java.lang.Object r0 = r0.get()
            io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver r0 = (io.reactivex.internal.operators.observable.ObservableReplay.ReplayObserver) r0
            if (r0 == 0) goto L_0x0010
            boolean r1 = r0.isDisposed()
            if (r1 == 0) goto L_0x0025
        L_0x0010:
            io.reactivex.internal.operators.observable.ObservableReplay$BufferSupplier<T> r1 = r4.f17548d
            io.reactivex.internal.operators.observable.ObservableReplay$ReplayBuffer r1 = r1.call()
            io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver r2 = new io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver
            r2.<init>(r1)
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver<T>> r1 = r4.f17547c
            boolean r0 = i.b.a(r1, r0, r2)
            if (r0 != 0) goto L_0x0024
            goto L_0x0000
        L_0x0024:
            r0 = r2
        L_0x0025:
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.f17563e
            boolean r1 = r1.get()
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0039
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.f17563e
            boolean r1 = r1.compareAndSet(r3, r2)
            if (r1 == 0) goto L_0x0039
            r1 = r2
            goto L_0x003a
        L_0x0039:
            r1 = r3
        L_0x003a:
            r5.accept(r0)     // Catch:{ all -> 0x0045 }
            if (r1 == 0) goto L_0x0044
            io.reactivex.ObservableSource<T> r5 = r4.f17546b
            r5.subscribe(r0)
        L_0x0044:
            return
        L_0x0045:
            r5 = move-exception
            if (r1 == 0) goto L_0x004d
            java.util.concurrent.atomic.AtomicBoolean r0 = r0.f17563e
            r0.compareAndSet(r2, r3)
        L_0x004d:
            io.reactivex.exceptions.Exceptions.throwIfFatal(r5)
            java.lang.RuntimeException r5 = io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(r5)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableReplay.connect(io.reactivex.functions.Consumer):void");
    }

    public void resetIf(Disposable disposable) {
        b.a(this.f17547c, (ReplayObserver) disposable, (Object) null);
    }

    public ObservableSource<T> source() {
        return this.f17546b;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f17549e.subscribe(observer);
    }

    public static <T> ConnectableObservable<T> create(ObservableSource<T> observableSource, long j11, TimeUnit timeUnit, Scheduler scheduler) {
        return create(observableSource, j11, timeUnit, scheduler, Integer.MAX_VALUE);
    }

    public static <T> ConnectableObservable<T> create(ObservableSource<T> observableSource, long j11, TimeUnit timeUnit, Scheduler scheduler, int i11) {
        return a(observableSource, new ScheduledReplaySupplier(i11, j11, timeUnit, scheduler));
    }
}
