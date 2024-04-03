package io.reactivex.rxjava3.internal.operators.flowable;

import i.b;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.flowables.ConnectableFlowable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.rxjava3.internal.subscribers.SubscriberResourceWrapper;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Timed;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableReplay<T> extends ConnectableFlowable<T> implements HasUpstreamPublisher<T> {

    /* renamed from: g  reason: collision with root package name */
    public static final Supplier f20221g = new DefaultUnboundedFactory();

    /* renamed from: c  reason: collision with root package name */
    public final Flowable<T> f20222c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<ReplaySubscriber<T>> f20223d;

    /* renamed from: e  reason: collision with root package name */
    public final Supplier<? extends ReplayBuffer<T>> f20224e;

    /* renamed from: f  reason: collision with root package name */
    public final Publisher<T> f20225f;

    public static abstract class BoundedReplayBuffer<T> extends AtomicReference<Node> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 2346567790059478686L;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f20226b;

        /* renamed from: c  reason: collision with root package name */
        public Node f20227c;

        /* renamed from: d  reason: collision with root package name */
        public int f20228d;

        /* renamed from: e  reason: collision with root package name */
        public long f20229e;

        public BoundedReplayBuffer(boolean z11) {
            this.f20226b = z11;
            Node node = new Node((Object) null, 0);
            this.f20227c = node;
            set(node);
        }

        public final void a(Node node) {
            this.f20227c.set(node);
            this.f20227c = node;
            this.f20228d++;
        }

        public Object b(Object obj, boolean z11) {
            return obj;
        }

        public Node c() {
            return (Node) get();
        }

        public final void complete() {
            Object b11 = b(NotificationLite.complete(), true);
            long j11 = this.f20229e + 1;
            this.f20229e = j11;
            a(new Node(b11, j11));
            i();
        }

        public Object d(Object obj) {
            return obj;
        }

        public final void e() {
            Node node = (Node) ((Node) get()).get();
            if (node != null) {
                this.f20228d--;
                f(node);
                return;
            }
            throw new IllegalStateException("Empty list!");
        }

        public final void error(Throwable th2) {
            Object b11 = b(NotificationLite.error(th2), true);
            long j11 = this.f20229e + 1;
            this.f20229e = j11;
            a(new Node(b11, j11));
            i();
        }

        public final void f(Node node) {
            if (this.f20226b) {
                Node node2 = new Node((Object) null, node.f20238c);
                node2.lazySet(node.get());
                node = node2;
            }
            set(node);
        }

        public final void g() {
            Node node = (Node) get();
            if (node.f20237b != null) {
                Node node2 = new Node((Object) null, 0);
                node2.lazySet(node.get());
                set(node2);
            }
        }

        public abstract void h();

        public void i() {
            g();
        }

        public final void next(T t11) {
            Object b11 = b(NotificationLite.next(t11), false);
            long j11 = this.f20229e + 1;
            this.f20229e = j11;
            a(new Node(b11, j11));
            h();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
            if (r2 != Long.MAX_VALUE) goto L_0x001d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
            r0 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001d, code lost:
            r0 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001e, code lost:
            r5 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.Node) r14.a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
            if (r5 != null) goto L_0x0035;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0028, code lost:
            r5 = c();
            r14.f20232d = r5;
            io.reactivex.rxjava3.internal.util.BackpressureHelper.add(r14.f20233e, r5.f20238c);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0035, code lost:
            r8 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0036, code lost:
            r10 = (r2 > 0 ? 1 : (r2 == 0 ? 0 : -1));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0039, code lost:
            if (r10 == 0) goto L_0x0082;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x003f, code lost:
            if (r14.isDisposed() == false) goto L_0x0044;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0041, code lost:
            r14.f20232d = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0043, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0044, code lost:
            r12 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.Node) r5.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x004a, code lost:
            if (r12 == null) goto L_0x0082;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x004c, code lost:
            r5 = d(r12.f20237b);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0058, code lost:
            if (io.reactivex.rxjava3.internal.util.NotificationLite.accept(r5, r14.f20231c) == false) goto L_0x005d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x005a, code lost:
            r14.f20232d = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x005c, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x005d, code lost:
            r8 = r8 + 1;
            r2 = r2 - 1;
            r5 = r12;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0063, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0064, code lost:
            io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r0);
            r14.f20232d = null;
            r14.dispose();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0070, code lost:
            if (io.reactivex.rxjava3.internal.util.NotificationLite.isError(r5) != false) goto L_0x007e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0078, code lost:
            r14.f20231c.onError(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x007e, code lost:
            io.reactivex.rxjava3.plugins.RxJavaPlugins.onError(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0082, code lost:
            if (r10 != 0) goto L_0x008d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0088, code lost:
            if (r14.isDisposed() == false) goto L_0x008d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x008a, code lost:
            r14.f20232d = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x008c, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x008f, code lost:
            if (r8 == 0) goto L_0x0098;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0091, code lost:
            r14.f20232d = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0093, code lost:
            if (r0 != false) goto L_0x0098;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0095, code lost:
            r14.produced(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0098, code lost:
            monitor-enter(r14);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x009b, code lost:
            if (r14.f20235g != false) goto L_0x00a1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x009d, code lost:
            r14.f20234f = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x009f, code lost:
            monitor-exit(r14);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x00a0, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x00a1, code lost:
            r14.f20235g = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x00a3, code lost:
            monitor-exit(r14);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x000d, code lost:
            r2 = r14.get();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void replay(io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.InnerSubscription<T> r14) {
            /*
                r13 = this;
                monitor-enter(r14)
                boolean r0 = r14.f20234f     // Catch:{ all -> 0x00a9 }
                r1 = 1
                if (r0 == 0) goto L_0x000a
                r14.f20235g = r1     // Catch:{ all -> 0x00a9 }
                monitor-exit(r14)     // Catch:{ all -> 0x00a9 }
                return
            L_0x000a:
                r14.f20234f = r1     // Catch:{ all -> 0x00a9 }
                monitor-exit(r14)     // Catch:{ all -> 0x00a9 }
            L_0x000d:
                long r2 = r14.get()
                r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                r4 = 0
                if (r0 != 0) goto L_0x001d
                r0 = r1
                goto L_0x001e
            L_0x001d:
                r0 = r4
            L_0x001e:
                java.lang.Object r5 = r14.a()
                io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$Node r5 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.Node) r5
                r6 = 0
                if (r5 != 0) goto L_0x0035
                io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$Node r5 = r13.c()
                r14.f20232d = r5
                java.util.concurrent.atomic.AtomicLong r8 = r14.f20233e
                long r9 = r5.f20238c
                io.reactivex.rxjava3.internal.util.BackpressureHelper.add(r8, r9)
            L_0x0035:
                r8 = r6
            L_0x0036:
                int r10 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
                r11 = 0
                if (r10 == 0) goto L_0x0082
                boolean r12 = r14.isDisposed()
                if (r12 == 0) goto L_0x0044
                r14.f20232d = r11
                return
            L_0x0044:
                java.lang.Object r12 = r5.get()
                io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$Node r12 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.Node) r12
                if (r12 == 0) goto L_0x0082
                java.lang.Object r5 = r12.f20237b
                java.lang.Object r5 = r13.d(r5)
                org.reactivestreams.Subscriber<? super T> r10 = r14.f20231c     // Catch:{ all -> 0x0063 }
                boolean r10 = io.reactivex.rxjava3.internal.util.NotificationLite.accept((java.lang.Object) r5, r10)     // Catch:{ all -> 0x0063 }
                if (r10 == 0) goto L_0x005d
                r14.f20232d = r11     // Catch:{ all -> 0x0063 }
                return
            L_0x005d:
                r10 = 1
                long r8 = r8 + r10
                long r2 = r2 - r10
                r5 = r12
                goto L_0x0036
            L_0x0063:
                r0 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r0)
                r14.f20232d = r11
                r14.dispose()
                boolean r1 = io.reactivex.rxjava3.internal.util.NotificationLite.isError(r5)
                if (r1 != 0) goto L_0x007e
                boolean r1 = io.reactivex.rxjava3.internal.util.NotificationLite.isComplete(r5)
                if (r1 != 0) goto L_0x007e
                org.reactivestreams.Subscriber<? super T> r14 = r14.f20231c
                r14.onError(r0)
                goto L_0x0081
            L_0x007e:
                io.reactivex.rxjava3.plugins.RxJavaPlugins.onError(r0)
            L_0x0081:
                return
            L_0x0082:
                if (r10 != 0) goto L_0x008d
                boolean r2 = r14.isDisposed()
                if (r2 == 0) goto L_0x008d
                r14.f20232d = r11
                return
            L_0x008d:
                int r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
                if (r2 == 0) goto L_0x0098
                r14.f20232d = r5
                if (r0 != 0) goto L_0x0098
                r14.produced(r8)
            L_0x0098:
                monitor-enter(r14)
                boolean r0 = r14.f20235g     // Catch:{ all -> 0x00a6 }
                if (r0 != 0) goto L_0x00a1
                r14.f20234f = r4     // Catch:{ all -> 0x00a6 }
                monitor-exit(r14)     // Catch:{ all -> 0x00a6 }
                return
            L_0x00a1:
                r14.f20235g = r4     // Catch:{ all -> 0x00a6 }
                monitor-exit(r14)     // Catch:{ all -> 0x00a6 }
                goto L_0x000d
            L_0x00a6:
                r0 = move-exception
                monitor-exit(r14)     // Catch:{ all -> 0x00a6 }
                throw r0
            L_0x00a9:
                r0 = move-exception
                monitor-exit(r14)     // Catch:{ all -> 0x00a9 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer.replay(io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$InnerSubscription):void");
        }
    }

    public static final class DefaultUnboundedFactory implements Supplier<Object> {
        public Object get() {
            return new UnboundedReplayBuffer(16);
        }
    }

    public static final class InnerSubscription<T> extends AtomicLong implements Subscription, Disposable {
        private static final long serialVersionUID = -4453897557930727610L;

        /* renamed from: b  reason: collision with root package name */
        public final ReplaySubscriber<T> f20230b;

        /* renamed from: c  reason: collision with root package name */
        public final Subscriber<? super T> f20231c;

        /* renamed from: d  reason: collision with root package name */
        public Object f20232d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicLong f20233e = new AtomicLong();

        /* renamed from: f  reason: collision with root package name */
        public boolean f20234f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f20235g;

        public InnerSubscription(ReplaySubscriber<T> replaySubscriber, Subscriber<? super T> subscriber) {
            this.f20230b = replaySubscriber;
            this.f20231c = subscriber;
        }

        public <U> U a() {
            return this.f20232d;
        }

        public void cancel() {
            dispose();
        }

        public void dispose() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.f20230b.c(this);
                this.f20230b.b();
                this.f20232d = null;
            }
        }

        public boolean isDisposed() {
            return get() == Long.MIN_VALUE;
        }

        public long produced(long j11) {
            return BackpressureHelper.producedCancel(this, j11);
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11) && BackpressureHelper.addCancel(this, j11) != Long.MIN_VALUE) {
                BackpressureHelper.add(this.f20233e, j11);
                this.f20230b.b();
                this.f20230b.f20243b.replay(this);
            }
        }
    }

    public static final class MulticastFlowable<R, U> extends Flowable<R> {
        private final Supplier<? extends ConnectableFlowable<U>> connectableFactory;
        private final Function<? super Flowable<U>, ? extends Publisher<R>> selector;

        public final class DisposableConsumer implements Consumer<Disposable> {
            private final SubscriberResourceWrapper<R> srw;

            public DisposableConsumer(SubscriberResourceWrapper<R> subscriberResourceWrapper) {
                this.srw = subscriberResourceWrapper;
            }

            public void accept(Disposable disposable) {
                this.srw.setResource(disposable);
            }
        }

        public MulticastFlowable(Supplier<? extends ConnectableFlowable<U>> supplier, Function<? super Flowable<U>, ? extends Publisher<R>> function) {
            this.connectableFactory = supplier;
            this.selector = function;
        }

        public void subscribeActual(Subscriber<? super R> subscriber) {
            try {
                ConnectableFlowable connectableFlowable = (ConnectableFlowable) ExceptionHelper.nullCheck(this.connectableFactory.get(), "The connectableFactory returned a null ConnectableFlowable.");
                try {
                    Publisher publisher = (Publisher) ExceptionHelper.nullCheck(this.selector.apply(connectableFlowable), "The selector returned a null Publisher.");
                    SubscriberResourceWrapper subscriberResourceWrapper = new SubscriberResourceWrapper(subscriber);
                    publisher.subscribe(subscriberResourceWrapper);
                    connectableFlowable.connect(new DisposableConsumer(subscriberResourceWrapper));
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    EmptySubscription.error(th2, subscriber);
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                EmptySubscription.error(th3, subscriber);
            }
        }
    }

    public static final class Node extends AtomicReference<Node> {
        private static final long serialVersionUID = 245354315435971818L;

        /* renamed from: b  reason: collision with root package name */
        public final Object f20237b;

        /* renamed from: c  reason: collision with root package name */
        public final long f20238c;

        public Node(Object obj, long j11) {
            this.f20237b = obj;
            this.f20238c = j11;
        }
    }

    public interface ReplayBuffer<T> {
        void complete();

        void error(Throwable th2);

        void next(T t11);

        void replay(InnerSubscription<T> innerSubscription);
    }

    public static final class ReplayBufferSupplier<T> implements Supplier<ReplayBuffer<T>> {

        /* renamed from: b  reason: collision with root package name */
        public final int f20239b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f20240c;

        public ReplayBufferSupplier(int i11, boolean z11) {
            this.f20239b = i11;
            this.f20240c = z11;
        }

        public ReplayBuffer<T> get() {
            return new SizeBoundReplayBuffer(this.f20239b, this.f20240c);
        }
    }

    public static final class ReplayPublisher<T> implements Publisher<T> {
        private final Supplier<? extends ReplayBuffer<T>> bufferFactory;
        private final AtomicReference<ReplaySubscriber<T>> curr;

        public ReplayPublisher(AtomicReference<ReplaySubscriber<T>> atomicReference, Supplier<? extends ReplayBuffer<T>> supplier) {
            this.curr = atomicReference;
            this.bufferFactory = supplier;
        }

        /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void subscribe(org.reactivestreams.Subscriber<? super T> r4) {
            /*
                r3 = this;
            L_0x0000:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplaySubscriber<T>> r0 = r3.curr
                java.lang.Object r0 = r0.get()
                io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplaySubscriber r0 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.ReplaySubscriber) r0
                if (r0 != 0) goto L_0x002d
                io.reactivex.rxjava3.functions.Supplier<? extends io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplayBuffer<T>> r0 = r3.bufferFactory     // Catch:{ all -> 0x0025 }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0025 }
                io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplayBuffer r0 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.ReplayBuffer) r0     // Catch:{ all -> 0x0025 }
                io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplaySubscriber r1 = new io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplaySubscriber
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplaySubscriber<T>> r2 = r3.curr
                r1.<init>(r0, r2)
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplaySubscriber<T>> r0 = r3.curr
                r2 = 0
                boolean r0 = i.b.a(r0, r2, r1)
                if (r0 != 0) goto L_0x0023
                goto L_0x0000
            L_0x0023:
                r0 = r1
                goto L_0x002d
            L_0x0025:
                r0 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r0)
                io.reactivex.rxjava3.internal.subscriptions.EmptySubscription.error(r0, r4)
                return
            L_0x002d:
                io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$InnerSubscription r1 = new io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$InnerSubscription
                r1.<init>(r0, r4)
                r4.onSubscribe(r1)
                r0.a(r1)
                boolean r4 = r1.isDisposed()
                if (r4 == 0) goto L_0x0042
                r0.c(r1)
                return
            L_0x0042:
                r0.b()
                io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplayBuffer<T> r4 = r0.f20243b
                r4.replay(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.ReplayPublisher.subscribe(org.reactivestreams.Subscriber):void");
        }
    }

    public static final class ReplaySubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: i  reason: collision with root package name */
        public static final InnerSubscription[] f20241i = new InnerSubscription[0];

        /* renamed from: j  reason: collision with root package name */
        public static final InnerSubscription[] f20242j = new InnerSubscription[0];
        private static final long serialVersionUID = 7224554242710036740L;

        /* renamed from: b  reason: collision with root package name */
        public final ReplayBuffer<T> f20243b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f20244c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReference<InnerSubscription<T>[]> f20245d = new AtomicReference<>(f20241i);

        /* renamed from: e  reason: collision with root package name */
        public final AtomicBoolean f20246e = new AtomicBoolean();

        /* renamed from: f  reason: collision with root package name */
        public final AtomicInteger f20247f = new AtomicInteger();

        /* renamed from: g  reason: collision with root package name */
        public long f20248g;

        /* renamed from: h  reason: collision with root package name */
        public final AtomicReference<ReplaySubscriber<T>> f20249h;

        public ReplaySubscriber(ReplayBuffer<T> replayBuffer, AtomicReference<ReplaySubscriber<T>> atomicReference) {
            this.f20243b = replayBuffer;
            this.f20249h = atomicReference;
        }

        public boolean a(InnerSubscription<T> innerSubscription) {
            InnerSubscription[] innerSubscriptionArr;
            InnerSubscription[] innerSubscriptionArr2;
            do {
                innerSubscriptionArr = (InnerSubscription[]) this.f20245d.get();
                if (innerSubscriptionArr == f20242j) {
                    return false;
                }
                int length = innerSubscriptionArr.length;
                innerSubscriptionArr2 = new InnerSubscription[(length + 1)];
                System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr2, 0, length);
                innerSubscriptionArr2[length] = innerSubscription;
            } while (!b.a(this.f20245d, innerSubscriptionArr, innerSubscriptionArr2));
            return true;
        }

        public void b() {
            AtomicInteger atomicInteger = this.f20247f;
            if (atomicInteger.getAndIncrement() == 0) {
                int i11 = 1;
                while (!isDisposed()) {
                    Subscription subscription = (Subscription) get();
                    if (subscription != null) {
                        long j11 = this.f20248g;
                        long j12 = j11;
                        for (InnerSubscription innerSubscription : (InnerSubscription[]) this.f20245d.get()) {
                            j12 = Math.max(j12, innerSubscription.f20233e.get());
                        }
                        long j13 = j12 - j11;
                        if (j13 != 0) {
                            this.f20248g = j12;
                            subscription.request(j13);
                        }
                    }
                    i11 = atomicInteger.addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                }
            }
        }

        public void c(InnerSubscription<T> innerSubscription) {
            InnerSubscription[] innerSubscriptionArr;
            InnerSubscription[] innerSubscriptionArr2;
            do {
                innerSubscriptionArr = (InnerSubscription[]) this.f20245d.get();
                int length = innerSubscriptionArr.length;
                if (length != 0) {
                    int i11 = 0;
                    while (true) {
                        if (i11 >= length) {
                            i11 = -1;
                            break;
                        } else if (innerSubscriptionArr[i11].equals(innerSubscription)) {
                            break;
                        } else {
                            i11++;
                        }
                    }
                    if (i11 >= 0) {
                        if (length == 1) {
                            innerSubscriptionArr2 = f20241i;
                        } else {
                            InnerSubscription[] innerSubscriptionArr3 = new InnerSubscription[(length - 1)];
                            System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr3, 0, i11);
                            System.arraycopy(innerSubscriptionArr, i11 + 1, innerSubscriptionArr3, i11, (length - i11) - 1);
                            innerSubscriptionArr2 = innerSubscriptionArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!b.a(this.f20245d, innerSubscriptionArr, innerSubscriptionArr2));
        }

        public void dispose() {
            this.f20245d.set(f20242j);
            b.a(this.f20249h, this, (Object) null);
            SubscriptionHelper.cancel(this);
        }

        public boolean isDisposed() {
            return this.f20245d.get() == f20242j;
        }

        public void onComplete() {
            if (!this.f20244c) {
                this.f20244c = true;
                this.f20243b.complete();
                for (InnerSubscription replay : (InnerSubscription[]) this.f20245d.getAndSet(f20242j)) {
                    this.f20243b.replay(replay);
                }
            }
        }

        public void onError(Throwable th2) {
            if (!this.f20244c) {
                this.f20244c = true;
                this.f20243b.error(th2);
                for (InnerSubscription replay : (InnerSubscription[]) this.f20245d.getAndSet(f20242j)) {
                    this.f20243b.replay(replay);
                }
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f20244c) {
                this.f20243b.next(t11);
                for (InnerSubscription replay : (InnerSubscription[]) this.f20245d.get()) {
                    this.f20243b.replay(replay);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                b();
                for (InnerSubscription replay : (InnerSubscription[]) this.f20245d.get()) {
                    this.f20243b.replay(replay);
                }
            }
        }
    }

    public static final class ScheduledReplayBufferSupplier<T> implements Supplier<ReplayBuffer<T>> {

        /* renamed from: b  reason: collision with root package name */
        public final boolean f20250b;
        private final int bufferSize;
        private final long maxAge;
        private final Scheduler scheduler;
        private final TimeUnit unit;

        public ScheduledReplayBufferSupplier(int i11, long j11, TimeUnit timeUnit, Scheduler scheduler2, boolean z11) {
            this.bufferSize = i11;
            this.maxAge = j11;
            this.unit = timeUnit;
            this.scheduler = scheduler2;
            this.f20250b = z11;
        }

        public ReplayBuffer<T> get() {
            return new SizeAndTimeBoundReplayBuffer(this.bufferSize, this.maxAge, this.unit, this.scheduler, this.f20250b);
        }
    }

    public static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = 3457957419649567404L;

        /* renamed from: f  reason: collision with root package name */
        public final Scheduler f20251f;

        /* renamed from: g  reason: collision with root package name */
        public final long f20252g;

        /* renamed from: h  reason: collision with root package name */
        public final TimeUnit f20253h;

        /* renamed from: i  reason: collision with root package name */
        public final int f20254i;

        public SizeAndTimeBoundReplayBuffer(int i11, long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
            super(z11);
            this.f20251f = scheduler;
            this.f20254i = i11;
            this.f20252g = j11;
            this.f20253h = timeUnit;
        }

        public Object b(Object obj, boolean z11) {
            return new Timed(obj, z11 ? Long.MAX_VALUE : this.f20251f.now(this.f20253h), this.f20253h);
        }

        public Node c() {
            Node node;
            long now = this.f20251f.now(this.f20253h) - this.f20252g;
            Node node2 = (Node) get();
            Object obj = node2.get();
            while (true) {
                Node node3 = (Node) obj;
                node = node2;
                node2 = node3;
                if (node2 != null) {
                    Timed timed = (Timed) node2.f20237b;
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
            long now = this.f20251f.now(this.f20253h) - this.f20252g;
            Node node2 = (Node) get();
            Node node3 = (Node) node2.get();
            int i11 = 0;
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                int i12 = this.f20228d;
                if (i12 > 1) {
                    if (i12 <= this.f20254i) {
                        if (((Timed) node2.f20237b).time() > now) {
                            break;
                        }
                        i11++;
                        this.f20228d--;
                        node3 = (Node) node2.get();
                    } else {
                        i11++;
                        this.f20228d = i12 - 1;
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
                io.reactivex.rxjava3.core.Scheduler r0 = r10.f20251f
                java.util.concurrent.TimeUnit r1 = r10.f20253h
                long r0 = r0.now(r1)
                long r2 = r10.f20252g
                long r0 = r0 - r2
                java.lang.Object r2 = r10.get()
                io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$Node r2 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.Node) r2
                java.lang.Object r3 = r2.get()
                io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$Node r3 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.Node) r3
                r4 = 0
            L_0x0018:
                r9 = r3
                r3 = r2
                r2 = r9
                int r5 = r10.f20228d
                r6 = 1
                if (r5 <= r6) goto L_0x003a
                java.lang.Object r5 = r2.f20237b
                io.reactivex.rxjava3.schedulers.Timed r5 = (io.reactivex.rxjava3.schedulers.Timed) r5
                long r7 = r5.time()
                int r5 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r5 > 0) goto L_0x003a
                int r4 = r4 + 1
                int r3 = r10.f20228d
                int r3 = r3 - r6
                r10.f20228d = r3
                java.lang.Object r3 = r2.get()
                io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$Node r3 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.Node) r3
                goto L_0x0018
            L_0x003a:
                if (r4 == 0) goto L_0x003f
                r10.f(r3)
            L_0x003f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.SizeAndTimeBoundReplayBuffer.i():void");
        }
    }

    public static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = -5898283885385201806L;

        /* renamed from: f  reason: collision with root package name */
        public final int f20255f;

        public SizeBoundReplayBuffer(int i11, boolean z11) {
            super(z11);
            this.f20255f = i11;
        }

        public void h() {
            if (this.f20228d > this.f20255f) {
                e();
            }
        }
    }

    public static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 7063189396499112664L;

        /* renamed from: b  reason: collision with root package name */
        public volatile int f20256b;

        public UnboundedReplayBuffer(int i11) {
            super(i11);
        }

        public void complete() {
            add(NotificationLite.complete());
            this.f20256b++;
        }

        public void error(Throwable th2) {
            add(NotificationLite.error(th2));
            this.f20256b++;
        }

        public void next(T t11) {
            add(NotificationLite.next(t11));
            this.f20256b++;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
            if (r15.isDisposed() == false) goto L_0x0016;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0015, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0016, code lost:
            r1 = r14.f20256b;
            r2 = (java.lang.Integer) r15.a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
            if (r2 == null) goto L_0x0026;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0021, code lost:
            r2 = r2.intValue();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0026, code lost:
            r2 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0027, code lost:
            r4 = r15.get();
            r8 = r4;
            r10 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
            if (r8 == 0) goto L_0x0069;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0033, code lost:
            if (r2 >= r1) goto L_0x0069;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0035, code lost:
            r12 = get(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x003d, code lost:
            if (io.reactivex.rxjava3.internal.util.NotificationLite.accept(r12, r0) == false) goto L_0x0040;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x003f, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0044, code lost:
            if (r15.isDisposed() == false) goto L_0x0047;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0046, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0047, code lost:
            r2 = r2 + 1;
            r8 = r8 - 1;
            r10 = r10 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x004e, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x004f, code lost:
            io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r1);
            r15.dispose();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0059, code lost:
            if (io.reactivex.rxjava3.internal.util.NotificationLite.isError(r12) != false) goto L_0x0065;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0061, code lost:
            r0.onError(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0065, code lost:
            io.reactivex.rxjava3.plugins.RxJavaPlugins.onError(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x006b, code lost:
            if (r10 == 0) goto L_0x007f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x006d, code lost:
            r15.f20232d = java.lang.Integer.valueOf(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x007a, code lost:
            if (r4 == Long.MAX_VALUE) goto L_0x007f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x007c, code lost:
            r15.produced(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x007f, code lost:
            monitor-enter(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0082, code lost:
            if (r15.f20235g != false) goto L_0x0088;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0084, code lost:
            r15.f20234f = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0086, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0087, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0088, code lost:
            r15.f20235g = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x008a, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x000d, code lost:
            r0 = r15.f20231c;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void replay(io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.InnerSubscription<T> r15) {
            /*
                r14 = this;
                monitor-enter(r15)
                boolean r0 = r15.f20234f     // Catch:{ all -> 0x008f }
                r1 = 1
                if (r0 == 0) goto L_0x000a
                r15.f20235g = r1     // Catch:{ all -> 0x008f }
                monitor-exit(r15)     // Catch:{ all -> 0x008f }
                return
            L_0x000a:
                r15.f20234f = r1     // Catch:{ all -> 0x008f }
                monitor-exit(r15)     // Catch:{ all -> 0x008f }
                org.reactivestreams.Subscriber<? super T> r0 = r15.f20231c
            L_0x000f:
                boolean r1 = r15.isDisposed()
                if (r1 == 0) goto L_0x0016
                return
            L_0x0016:
                int r1 = r14.f20256b
                java.lang.Object r2 = r15.a()
                java.lang.Integer r2 = (java.lang.Integer) r2
                r3 = 0
                if (r2 == 0) goto L_0x0026
                int r2 = r2.intValue()
                goto L_0x0027
            L_0x0026:
                r2 = r3
            L_0x0027:
                long r4 = r15.get()
                r6 = 0
                r8 = r4
                r10 = r6
            L_0x002f:
                int r12 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
                if (r12 == 0) goto L_0x0069
                if (r2 >= r1) goto L_0x0069
                java.lang.Object r12 = r14.get(r2)
                boolean r12 = io.reactivex.rxjava3.internal.util.NotificationLite.accept((java.lang.Object) r12, r0)     // Catch:{ all -> 0x004e }
                if (r12 == 0) goto L_0x0040
                return
            L_0x0040:
                boolean r12 = r15.isDisposed()
                if (r12 == 0) goto L_0x0047
                return
            L_0x0047:
                int r2 = r2 + 1
                r12 = 1
                long r8 = r8 - r12
                long r10 = r10 + r12
                goto L_0x002f
            L_0x004e:
                r1 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r1)
                r15.dispose()
                boolean r15 = io.reactivex.rxjava3.internal.util.NotificationLite.isError(r12)
                if (r15 != 0) goto L_0x0065
                boolean r15 = io.reactivex.rxjava3.internal.util.NotificationLite.isComplete(r12)
                if (r15 != 0) goto L_0x0065
                r0.onError(r1)
                goto L_0x0068
            L_0x0065:
                io.reactivex.rxjava3.plugins.RxJavaPlugins.onError(r1)
            L_0x0068:
                return
            L_0x0069:
                int r1 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r1 == 0) goto L_0x007f
                java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
                r15.f20232d = r1
                r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r1 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
                if (r1 == 0) goto L_0x007f
                r15.produced(r10)
            L_0x007f:
                monitor-enter(r15)
                boolean r1 = r15.f20235g     // Catch:{ all -> 0x008c }
                if (r1 != 0) goto L_0x0088
                r15.f20234f = r3     // Catch:{ all -> 0x008c }
                monitor-exit(r15)     // Catch:{ all -> 0x008c }
                return
            L_0x0088:
                r15.f20235g = r3     // Catch:{ all -> 0x008c }
                monitor-exit(r15)     // Catch:{ all -> 0x008c }
                goto L_0x000f
            L_0x008c:
                r0 = move-exception
                monitor-exit(r15)     // Catch:{ all -> 0x008c }
                throw r0
            L_0x008f:
                r0 = move-exception
                monitor-exit(r15)     // Catch:{ all -> 0x008f }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.UnboundedReplayBuffer.replay(io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$InnerSubscription):void");
        }
    }

    private FlowableReplay(Publisher<T> publisher, Flowable<T> flowable, AtomicReference<ReplaySubscriber<T>> atomicReference, Supplier<? extends ReplayBuffer<T>> supplier) {
        this.f20225f = publisher;
        this.f20222c = flowable;
        this.f20223d = atomicReference;
        this.f20224e = supplier;
    }

    public static <T> ConnectableFlowable<T> b(Flowable<T> flowable, Supplier<? extends ReplayBuffer<T>> supplier) {
        AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.onAssembly(new FlowableReplay(new ReplayPublisher(atomicReference, supplier), flowable, atomicReference, supplier));
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> flowable, int i11, boolean z11) {
        if (i11 == Integer.MAX_VALUE) {
            return createFrom(flowable);
        }
        return b(flowable, new ReplayBufferSupplier(i11, z11));
    }

    public static <T> ConnectableFlowable<T> createFrom(Flowable<? extends T> flowable) {
        return b(flowable, f20221g);
    }

    public static <U, R> Flowable<R> multicastSelector(Supplier<? extends ConnectableFlowable<U>> supplier, Function<? super Flowable<U>, ? extends Publisher<R>> function) {
        return new MulticastFlowable(supplier, function);
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect(io.reactivex.rxjava3.functions.Consumer<? super io.reactivex.rxjava3.disposables.Disposable> r5) {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplaySubscriber<T>> r0 = r4.f20223d
            java.lang.Object r0 = r0.get()
            io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplaySubscriber r0 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.ReplaySubscriber) r0
            if (r0 == 0) goto L_0x0010
            boolean r1 = r0.isDisposed()
            if (r1 == 0) goto L_0x0029
        L_0x0010:
            io.reactivex.rxjava3.functions.Supplier<? extends io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplayBuffer<T>> r1 = r4.f20224e     // Catch:{ all -> 0x005c }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x005c }
            io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplayBuffer r1 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.ReplayBuffer) r1     // Catch:{ all -> 0x005c }
            io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplaySubscriber r2 = new io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplaySubscriber
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplaySubscriber<T>> r3 = r4.f20223d
            r2.<init>(r1, r3)
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplaySubscriber<T>> r1 = r4.f20223d
            boolean r0 = i.b.a(r1, r0, r2)
            if (r0 != 0) goto L_0x0028
            goto L_0x0000
        L_0x0028:
            r0 = r2
        L_0x0029:
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.f20246e
            boolean r1 = r1.get()
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x003d
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.f20246e
            boolean r1 = r1.compareAndSet(r3, r2)
            if (r1 == 0) goto L_0x003d
            r1 = r2
            goto L_0x003e
        L_0x003d:
            r1 = r3
        L_0x003e:
            r5.accept(r0)     // Catch:{ all -> 0x0049 }
            if (r1 == 0) goto L_0x0048
            io.reactivex.rxjava3.core.Flowable<T> r5 = r4.f20222c
            r5.subscribe(r0)
        L_0x0048:
            return
        L_0x0049:
            r5 = move-exception
            io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r5)
            if (r1 == 0) goto L_0x0054
            java.util.concurrent.atomic.AtomicBoolean r0 = r0.f20246e
            r0.compareAndSet(r2, r3)
        L_0x0054:
            io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r5)
            java.lang.RuntimeException r5 = io.reactivex.rxjava3.internal.util.ExceptionHelper.wrapOrThrow(r5)
            throw r5
        L_0x005c:
            r5 = move-exception
            io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r5)
            java.lang.RuntimeException r5 = io.reactivex.rxjava3.internal.util.ExceptionHelper.wrapOrThrow(r5)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.connect(io.reactivex.rxjava3.functions.Consumer):void");
    }

    public void reset() {
        ReplaySubscriber replaySubscriber = this.f20223d.get();
        if (replaySubscriber != null && replaySubscriber.isDisposed()) {
            b.a(this.f20223d, replaySubscriber, (Object) null);
        }
    }

    public Publisher<T> source() {
        return this.f20222c;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f20225f.subscribe(subscriber);
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> flowable, long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
        return create(flowable, j11, timeUnit, scheduler, Integer.MAX_VALUE, z11);
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> flowable, long j11, TimeUnit timeUnit, Scheduler scheduler, int i11, boolean z11) {
        return b(flowable, new ScheduledReplayBufferSupplier(i11, j11, timeUnit, scheduler, z11));
    }
}
