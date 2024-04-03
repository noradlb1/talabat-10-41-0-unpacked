package io.reactivex.rxjava3.internal.operators.observable;

import i.b;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamObservableSource;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Timed;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableReplay<T> extends ConnectableObservable<T> implements HasUpstreamObservableSource<T> {

    /* renamed from: f  reason: collision with root package name */
    public static final BufferSupplier f22084f = new UnBoundedFactory();

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f22085b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<ReplayObserver<T>> f22086c;

    /* renamed from: d  reason: collision with root package name */
    public final BufferSupplier<T> f22087d;

    /* renamed from: e  reason: collision with root package name */
    public final ObservableSource<T> f22088e;

    public static abstract class BoundedReplayBuffer<T> extends AtomicReference<Node> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 2346567790059478686L;

        /* renamed from: b  reason: collision with root package name */
        public Node f22089b;

        /* renamed from: c  reason: collision with root package name */
        public int f22090c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f22091d;

        public BoundedReplayBuffer(boolean z11) {
            this.f22091d = z11;
            Node node = new Node((Object) null);
            this.f22089b = node;
            set(node);
        }

        public final void a(Node node) {
            this.f22089b.set(node);
            this.f22089b = node;
            this.f22090c++;
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
            this.f22090c--;
            f((Node) ((Node) get()).get());
        }

        public final void error(Throwable th2) {
            a(new Node(b(NotificationLite.error(th2))));
            i();
        }

        public final void f(Node node) {
            if (this.f22091d) {
                Node node2 = new Node((Object) null);
                node2.lazySet(node.get());
                node = node2;
            }
            set(node);
        }

        public final void g() {
            Node node = (Node) get();
            if (node.f22096b != null) {
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
                        innerDisposable.f22094d = node;
                    }
                    while (!innerDisposable.isDisposed()) {
                        Node node2 = (Node) node.get();
                        if (node2 == null) {
                            innerDisposable.f22094d = node;
                            i11 = innerDisposable.addAndGet(-i11);
                        } else if (NotificationLite.accept(d(node2.f22096b), innerDisposable.f22093c)) {
                            innerDisposable.f22094d = null;
                            return;
                        } else {
                            node = node2;
                        }
                    }
                    innerDisposable.f22094d = null;
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
        public final ReplayObserver<T> f22092b;

        /* renamed from: c  reason: collision with root package name */
        public final Observer<? super T> f22093c;

        /* renamed from: d  reason: collision with root package name */
        public Object f22094d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f22095e;

        public InnerDisposable(ReplayObserver<T> replayObserver, Observer<? super T> observer) {
            this.f22092b = replayObserver;
            this.f22093c = observer;
        }

        public <U> U a() {
            return this.f22094d;
        }

        public void dispose() {
            if (!this.f22095e) {
                this.f22095e = true;
                this.f22092b.b(this);
                this.f22094d = null;
            }
        }

        public boolean isDisposed() {
            return this.f22095e;
        }
    }

    public static final class MulticastReplay<R, U> extends Observable<R> {
        private final Supplier<? extends ConnectableObservable<U>> connectableFactory;
        private final Function<? super Observable<U>, ? extends ObservableSource<R>> selector;

        public MulticastReplay(Supplier<? extends ConnectableObservable<U>> supplier, Function<? super Observable<U>, ? extends ObservableSource<R>> function) {
            this.connectableFactory = supplier;
            this.selector = function;
        }

        public void subscribeActual(Observer<? super R> observer) {
            try {
                Object obj = this.connectableFactory.get();
                Objects.requireNonNull(obj, "The connectableFactory returned a null ConnectableObservable");
                ConnectableObservable connectableObservable = (ConnectableObservable) obj;
                Object apply = this.selector.apply(connectableObservable);
                Objects.requireNonNull(apply, "The selector returned a null ObservableSource");
                ObservableSource observableSource = (ObservableSource) apply;
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
        public final Object f22096b;

        public Node(Object obj) {
            this.f22096b = obj;
        }
    }

    public interface ReplayBuffer<T> {
        void complete();

        void error(Throwable th2);

        void next(T t11);

        void replay(InnerDisposable<T> innerDisposable);
    }

    public static final class ReplayBufferSupplier<T> implements BufferSupplier<T> {

        /* renamed from: a  reason: collision with root package name */
        public final int f22097a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f22098b;

        public ReplayBufferSupplier(int i11, boolean z11) {
            this.f22097a = i11;
            this.f22098b = z11;
        }

        public ReplayBuffer<T> call() {
            return new SizeBoundReplayBuffer(this.f22097a, this.f22098b);
        }
    }

    public static final class ReplayObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {

        /* renamed from: g  reason: collision with root package name */
        public static final InnerDisposable[] f22099g = new InnerDisposable[0];

        /* renamed from: h  reason: collision with root package name */
        public static final InnerDisposable[] f22100h = new InnerDisposable[0];
        private static final long serialVersionUID = -533785617179540163L;

        /* renamed from: b  reason: collision with root package name */
        public final ReplayBuffer<T> f22101b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f22102c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReference<InnerDisposable[]> f22103d = new AtomicReference<>(f22099g);

        /* renamed from: e  reason: collision with root package name */
        public final AtomicBoolean f22104e = new AtomicBoolean();

        /* renamed from: f  reason: collision with root package name */
        public final AtomicReference<ReplayObserver<T>> f22105f;

        public ReplayObserver(ReplayBuffer<T> replayBuffer, AtomicReference<ReplayObserver<T>> atomicReference) {
            this.f22101b = replayBuffer;
            this.f22105f = atomicReference;
        }

        public boolean a(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = this.f22103d.get();
                if (innerDisposableArr == f22100h) {
                    return false;
                }
                int length = innerDisposableArr.length;
                innerDisposableArr2 = new InnerDisposable[(length + 1)];
                System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                innerDisposableArr2[length] = innerDisposable;
            } while (!b.a(this.f22103d, innerDisposableArr, innerDisposableArr2));
            return true;
        }

        public void b(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = this.f22103d.get();
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
                            innerDisposableArr2 = f22099g;
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
            } while (!b.a(this.f22103d, innerDisposableArr, innerDisposableArr2));
        }

        public void c() {
            for (InnerDisposable replay : this.f22103d.get()) {
                this.f22101b.replay(replay);
            }
        }

        public void d() {
            for (InnerDisposable replay : this.f22103d.getAndSet(f22100h)) {
                this.f22101b.replay(replay);
            }
        }

        public void dispose() {
            this.f22103d.set(f22100h);
            b.a(this.f22105f, this, (Object) null);
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return this.f22103d.get() == f22100h;
        }

        public void onComplete() {
            if (!this.f22102c) {
                this.f22102c = true;
                this.f22101b.complete();
                d();
            }
        }

        public void onError(Throwable th2) {
            if (!this.f22102c) {
                this.f22102c = true;
                this.f22101b.error(th2);
                d();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f22102c) {
                this.f22101b.next(t11);
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
        public void subscribe(io.reactivex.rxjava3.core.Observer<? super T> r4) {
            /*
                r3 = this;
            L_0x0000:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$ReplayObserver<T>> r0 = r3.curr
                java.lang.Object r0 = r0.get()
                io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$ReplayObserver r0 = (io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.ReplayObserver) r0
                if (r0 != 0) goto L_0x0022
                io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$BufferSupplier<T> r0 = r3.bufferFactory
                io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$ReplayBuffer r0 = r0.call()
                io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$ReplayObserver r1 = new io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$ReplayObserver
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$ReplayObserver<T>> r2 = r3.curr
                r1.<init>(r0, r2)
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$ReplayObserver<T>> r0 = r3.curr
                r2 = 0
                boolean r0 = i.b.a(r0, r2, r1)
                if (r0 != 0) goto L_0x0021
                goto L_0x0000
            L_0x0021:
                r0 = r1
            L_0x0022:
                io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$InnerDisposable r1 = new io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$InnerDisposable
                r1.<init>(r0, r4)
                r4.onSubscribe(r1)
                r0.a(r1)
                boolean r4 = r1.isDisposed()
                if (r4 == 0) goto L_0x0037
                r0.b(r1)
                return
            L_0x0037:
                io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$ReplayBuffer<T> r4 = r0.f22101b
                r4.replay(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.ReplaySource.subscribe(io.reactivex.rxjava3.core.Observer):void");
        }
    }

    public static final class ScheduledReplaySupplier<T> implements BufferSupplier<T> {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f22106a;
        private final int bufferSize;
        private final long maxAge;
        private final Scheduler scheduler;
        private final TimeUnit unit;

        public ScheduledReplaySupplier(int i11, long j11, TimeUnit timeUnit, Scheduler scheduler2, boolean z11) {
            this.bufferSize = i11;
            this.maxAge = j11;
            this.unit = timeUnit;
            this.scheduler = scheduler2;
            this.f22106a = z11;
        }

        public ReplayBuffer<T> call() {
            return new SizeAndTimeBoundReplayBuffer(this.bufferSize, this.maxAge, this.unit, this.scheduler, this.f22106a);
        }
    }

    public static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = 3457957419649567404L;

        /* renamed from: e  reason: collision with root package name */
        public final Scheduler f22107e;

        /* renamed from: f  reason: collision with root package name */
        public final long f22108f;

        /* renamed from: g  reason: collision with root package name */
        public final TimeUnit f22109g;

        /* renamed from: h  reason: collision with root package name */
        public final int f22110h;

        public SizeAndTimeBoundReplayBuffer(int i11, long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
            super(z11);
            this.f22107e = scheduler;
            this.f22110h = i11;
            this.f22108f = j11;
            this.f22109g = timeUnit;
        }

        public Object b(Object obj) {
            return new Timed(obj, this.f22107e.now(this.f22109g), this.f22109g);
        }

        public Node c() {
            Node node;
            long now = this.f22107e.now(this.f22109g) - this.f22108f;
            Node node2 = (Node) get();
            Object obj = node2.get();
            while (true) {
                Node node3 = (Node) obj;
                node = node2;
                node2 = node3;
                if (node2 != null) {
                    Timed timed = (Timed) node2.f22096b;
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
            long now = this.f22107e.now(this.f22109g) - this.f22108f;
            Node node2 = (Node) get();
            Node node3 = (Node) node2.get();
            int i11 = 0;
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                int i12 = this.f22090c;
                if (i12 > 1) {
                    if (i12 <= this.f22110h) {
                        if (((Timed) node2.f22096b).time() > now) {
                            break;
                        }
                        i11++;
                        this.f22090c--;
                        node3 = (Node) node2.get();
                    } else {
                        i11++;
                        this.f22090c = i12 - 1;
                        node3 = (Node) node2.get();
                    }
                } else {
                    break;
                }
            }
            if (i11 != 0) {
                f(node);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:7:0x003c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void i() {
            /*
                r10 = this;
                io.reactivex.rxjava3.core.Scheduler r0 = r10.f22107e
                java.util.concurrent.TimeUnit r1 = r10.f22109g
                long r0 = r0.now(r1)
                long r2 = r10.f22108f
                long r0 = r0 - r2
                java.lang.Object r2 = r10.get()
                io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$Node r2 = (io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.Node) r2
                java.lang.Object r3 = r2.get()
                io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$Node r3 = (io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.Node) r3
                r4 = 0
            L_0x0018:
                r9 = r3
                r3 = r2
                r2 = r9
                int r5 = r10.f22090c
                r6 = 1
                if (r5 <= r6) goto L_0x003a
                java.lang.Object r5 = r2.f22096b
                io.reactivex.rxjava3.schedulers.Timed r5 = (io.reactivex.rxjava3.schedulers.Timed) r5
                long r7 = r5.time()
                int r5 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r5 > 0) goto L_0x003a
                int r4 = r4 + 1
                int r3 = r10.f22090c
                int r3 = r3 - r6
                r10.f22090c = r3
                java.lang.Object r3 = r2.get()
                io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$Node r3 = (io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.Node) r3
                goto L_0x0018
            L_0x003a:
                if (r4 == 0) goto L_0x003f
                r10.f(r3)
            L_0x003f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.SizeAndTimeBoundReplayBuffer.i():void");
        }
    }

    public static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = -5898283885385201806L;

        /* renamed from: e  reason: collision with root package name */
        public final int f22111e;

        public SizeBoundReplayBuffer(int i11, boolean z11) {
            super(z11);
            this.f22111e = i11;
        }

        public void h() {
            if (this.f22090c > this.f22111e) {
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
        public volatile int f22112b;

        public UnboundedReplayBuffer(int i11) {
            super(i11);
        }

        public void complete() {
            add(NotificationLite.complete());
            this.f22112b++;
        }

        public void error(Throwable th2) {
            add(NotificationLite.error(th2));
            this.f22112b++;
        }

        public void next(T t11) {
            add(NotificationLite.next(t11));
            this.f22112b++;
        }

        public void replay(InnerDisposable<T> innerDisposable) {
            int i11;
            if (innerDisposable.getAndIncrement() == 0) {
                Observer<? super T> observer = innerDisposable.f22093c;
                int i12 = 1;
                while (!innerDisposable.isDisposed()) {
                    int i13 = this.f22112b;
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
                    innerDisposable.f22094d = Integer.valueOf(i11);
                    i12 = innerDisposable.addAndGet(-i12);
                    if (i12 == 0) {
                        return;
                    }
                }
            }
        }
    }

    private ObservableReplay(ObservableSource<T> observableSource, ObservableSource<T> observableSource2, AtomicReference<ReplayObserver<T>> atomicReference, BufferSupplier<T> bufferSupplier) {
        this.f22088e = observableSource;
        this.f22085b = observableSource2;
        this.f22086c = atomicReference;
        this.f22087d = bufferSupplier;
    }

    public static <T> ConnectableObservable<T> a(ObservableSource<T> observableSource, BufferSupplier<T> bufferSupplier) {
        AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.onAssembly(new ObservableReplay(new ReplaySource(atomicReference, bufferSupplier), observableSource, atomicReference, bufferSupplier));
    }

    public static <T> ConnectableObservable<T> create(ObservableSource<T> observableSource, int i11, boolean z11) {
        if (i11 == Integer.MAX_VALUE) {
            return createFrom(observableSource);
        }
        return a(observableSource, new ReplayBufferSupplier(i11, z11));
    }

    public static <T> ConnectableObservable<T> createFrom(ObservableSource<? extends T> observableSource) {
        return a(observableSource, f22084f);
    }

    public static <U, R> Observable<R> multicastSelector(Supplier<? extends ConnectableObservable<U>> supplier, Function<? super Observable<U>, ? extends ObservableSource<R>> function) {
        return RxJavaPlugins.onAssembly(new MulticastReplay(supplier, function));
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect(io.reactivex.rxjava3.functions.Consumer<? super io.reactivex.rxjava3.disposables.Disposable> r5) {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$ReplayObserver<T>> r0 = r4.f22086c
            java.lang.Object r0 = r0.get()
            io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$ReplayObserver r0 = (io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.ReplayObserver) r0
            if (r0 == 0) goto L_0x0010
            boolean r1 = r0.isDisposed()
            if (r1 == 0) goto L_0x0027
        L_0x0010:
            io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$BufferSupplier<T> r1 = r4.f22087d
            io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$ReplayBuffer r1 = r1.call()
            io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$ReplayObserver r2 = new io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$ReplayObserver
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$ReplayObserver<T>> r3 = r4.f22086c
            r2.<init>(r1, r3)
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$ReplayObserver<T>> r1 = r4.f22086c
            boolean r0 = i.b.a(r1, r0, r2)
            if (r0 != 0) goto L_0x0026
            goto L_0x0000
        L_0x0026:
            r0 = r2
        L_0x0027:
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.f22104e
            boolean r1 = r1.get()
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x003b
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.f22104e
            boolean r1 = r1.compareAndSet(r3, r2)
            if (r1 == 0) goto L_0x003b
            r1 = r2
            goto L_0x003c
        L_0x003b:
            r1 = r3
        L_0x003c:
            r5.accept(r0)     // Catch:{ all -> 0x0047 }
            if (r1 == 0) goto L_0x0046
            io.reactivex.rxjava3.core.ObservableSource<T> r5 = r4.f22085b
            r5.subscribe(r0)
        L_0x0046:
            return
        L_0x0047:
            r5 = move-exception
            io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r5)
            if (r1 == 0) goto L_0x0052
            java.util.concurrent.atomic.AtomicBoolean r0 = r0.f22104e
            r0.compareAndSet(r2, r3)
        L_0x0052:
            io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r5)
            java.lang.RuntimeException r5 = io.reactivex.rxjava3.internal.util.ExceptionHelper.wrapOrThrow(r5)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.connect(io.reactivex.rxjava3.functions.Consumer):void");
    }

    public void reset() {
        ReplayObserver replayObserver = this.f22086c.get();
        if (replayObserver != null && replayObserver.isDisposed()) {
            b.a(this.f22086c, replayObserver, (Object) null);
        }
    }

    public ObservableSource<T> source() {
        return this.f22085b;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f22088e.subscribe(observer);
    }

    public static <T> ConnectableObservable<T> create(ObservableSource<T> observableSource, long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
        return create(observableSource, j11, timeUnit, scheduler, Integer.MAX_VALUE, z11);
    }

    public static <T> ConnectableObservable<T> create(ObservableSource<T> observableSource, long j11, TimeUnit timeUnit, Scheduler scheduler, int i11, boolean z11) {
        return a(observableSource, new ScheduledReplaySupplier(i11, j11, timeUnit, scheduler, z11));
    }
}
