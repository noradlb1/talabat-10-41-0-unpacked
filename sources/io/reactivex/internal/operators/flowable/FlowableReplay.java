package io.reactivex.internal.operators.flowable;

import i.b;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.internal.subscribers.SubscriberResourceWrapper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Timed;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableReplay<T> extends ConnectableFlowable<T> implements HasUpstreamPublisher<T>, ResettableConnectable {

    /* renamed from: g  reason: collision with root package name */
    public static final Callable f15714g = new DefaultUnboundedFactory();

    /* renamed from: c  reason: collision with root package name */
    public final Flowable<T> f15715c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<ReplaySubscriber<T>> f15716d;

    /* renamed from: e  reason: collision with root package name */
    public final Callable<? extends ReplayBuffer<T>> f15717e;

    /* renamed from: f  reason: collision with root package name */
    public final Publisher<T> f15718f;

    public static class BoundedReplayBuffer<T> extends AtomicReference<Node> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 2346567790059478686L;

        /* renamed from: b  reason: collision with root package name */
        public Node f15719b;

        /* renamed from: c  reason: collision with root package name */
        public int f15720c;

        /* renamed from: d  reason: collision with root package name */
        public long f15721d;

        public BoundedReplayBuffer() {
            Node node = new Node((Object) null, 0);
            this.f15719b = node;
            set(node);
        }

        public final void a(Node node) {
            this.f15719b.set(node);
            this.f15719b = node;
            this.f15720c++;
        }

        public Object b(Object obj) {
            return obj;
        }

        public Node c() {
            return (Node) get();
        }

        public final void complete() {
            Object b11 = b(NotificationLite.complete());
            long j11 = this.f15721d + 1;
            this.f15721d = j11;
            a(new Node(b11, j11));
            i();
        }

        public Object d(Object obj) {
            return obj;
        }

        public final void e() {
            Node node = (Node) ((Node) get()).get();
            if (node != null) {
                this.f15720c--;
                f(node);
                return;
            }
            throw new IllegalStateException("Empty list!");
        }

        public final void error(Throwable th2) {
            Object b11 = b(NotificationLite.error(th2));
            long j11 = this.f15721d + 1;
            this.f15721d = j11;
            a(new Node(b11, j11));
            i();
        }

        public final void f(Node node) {
            set(node);
        }

        public final void g() {
            Node node = (Node) get();
            if (node.f15730b != null) {
                Node node2 = new Node((Object) null, 0);
                node2.lazySet(node.get());
                set(node2);
            }
        }

        public void h() {
        }

        public void i() {
            g();
        }

        public final void next(T t11) {
            Object b11 = b(NotificationLite.next(t11));
            long j11 = this.f15721d + 1;
            this.f15721d = j11;
            a(new Node(b11, j11));
            h();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0012, code lost:
            if (r15.isDisposed() == false) goto L_0x0017;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0014, code lost:
            r15.f15725d = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0016, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0017, code lost:
            r3 = r15.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
            if (r3 != Long.MAX_VALUE) goto L_0x0027;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0025, code lost:
            r0 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0027, code lost:
            r0 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0028, code lost:
            r6 = (io.reactivex.internal.operators.flowable.FlowableReplay.Node) r15.a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0030, code lost:
            if (r6 != null) goto L_0x003f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0032, code lost:
            r6 = c();
            r15.f15725d = r6;
            io.reactivex.internal.util.BackpressureHelper.add(r15.f15726e, r6.f15731c);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x003f, code lost:
            r9 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0042, code lost:
            if (r3 == 0) goto L_0x0087;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0044, code lost:
            r11 = (io.reactivex.internal.operators.flowable.FlowableReplay.Node) r6.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x004a, code lost:
            if (r11 == null) goto L_0x0087;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x004c, code lost:
            r6 = d(r11.f15730b);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0058, code lost:
            if (io.reactivex.internal.util.NotificationLite.accept(r6, r15.f15724c) == false) goto L_0x005d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x005a, code lost:
            r15.f15725d = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x005c, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x005d, code lost:
            r9 = r9 + 1;
            r3 = r3 - 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0065, code lost:
            if (r15.isDisposed() == false) goto L_0x006a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0067, code lost:
            r15.f15725d = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0069, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x006a, code lost:
            r6 = r11;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x006c, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x006d, code lost:
            io.reactivex.exceptions.Exceptions.throwIfFatal(r0);
            r15.f15725d = null;
            r15.dispose();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0079, code lost:
            if (io.reactivex.internal.util.NotificationLite.isError(r6) != false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0081, code lost:
            r15.f15724c.onError(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0089, code lost:
            if (r9 == 0) goto L_0x0092;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x008b, code lost:
            r15.f15725d = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x008d, code lost:
            if (r0 != false) goto L_0x0092;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x008f, code lost:
            r15.produced(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0092, code lost:
            monitor-enter(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0095, code lost:
            if (r15.f15728g != false) goto L_0x009b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0097, code lost:
            r15.f15727f = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0099, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x009a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x009b, code lost:
            r15.f15728g = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x009d, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void replay(io.reactivex.internal.operators.flowable.FlowableReplay.InnerSubscription<T> r15) {
            /*
                r14 = this;
                monitor-enter(r15)
                boolean r0 = r15.f15727f     // Catch:{ all -> 0x00a3 }
                r1 = 1
                if (r0 == 0) goto L_0x000a
                r15.f15728g = r1     // Catch:{ all -> 0x00a3 }
                monitor-exit(r15)     // Catch:{ all -> 0x00a3 }
                return
            L_0x000a:
                r15.f15727f = r1     // Catch:{ all -> 0x00a3 }
                monitor-exit(r15)     // Catch:{ all -> 0x00a3 }
            L_0x000d:
                boolean r0 = r15.isDisposed()
                r2 = 0
                if (r0 == 0) goto L_0x0017
                r15.f15725d = r2
                return
            L_0x0017:
                long r3 = r15.get()
                r5 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                r5 = 0
                if (r0 != 0) goto L_0x0027
                r0 = r1
                goto L_0x0028
            L_0x0027:
                r0 = r5
            L_0x0028:
                java.lang.Object r6 = r15.a()
                io.reactivex.internal.operators.flowable.FlowableReplay$Node r6 = (io.reactivex.internal.operators.flowable.FlowableReplay.Node) r6
                r7 = 0
                if (r6 != 0) goto L_0x003f
                io.reactivex.internal.operators.flowable.FlowableReplay$Node r6 = r14.c()
                r15.f15725d = r6
                java.util.concurrent.atomic.AtomicLong r9 = r15.f15726e
                long r10 = r6.f15731c
                io.reactivex.internal.util.BackpressureHelper.add(r9, r10)
            L_0x003f:
                r9 = r7
            L_0x0040:
                int r11 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
                if (r11 == 0) goto L_0x0087
                java.lang.Object r11 = r6.get()
                io.reactivex.internal.operators.flowable.FlowableReplay$Node r11 = (io.reactivex.internal.operators.flowable.FlowableReplay.Node) r11
                if (r11 == 0) goto L_0x0087
                java.lang.Object r6 = r11.f15730b
                java.lang.Object r6 = r14.d(r6)
                org.reactivestreams.Subscriber<? super T> r12 = r15.f15724c     // Catch:{ all -> 0x006c }
                boolean r12 = io.reactivex.internal.util.NotificationLite.accept((java.lang.Object) r6, r12)     // Catch:{ all -> 0x006c }
                if (r12 == 0) goto L_0x005d
                r15.f15725d = r2     // Catch:{ all -> 0x006c }
                return
            L_0x005d:
                r12 = 1
                long r9 = r9 + r12
                long r3 = r3 - r12
                boolean r6 = r15.isDisposed()
                if (r6 == 0) goto L_0x006a
                r15.f15725d = r2
                return
            L_0x006a:
                r6 = r11
                goto L_0x0040
            L_0x006c:
                r0 = move-exception
                io.reactivex.exceptions.Exceptions.throwIfFatal(r0)
                r15.f15725d = r2
                r15.dispose()
                boolean r1 = io.reactivex.internal.util.NotificationLite.isError(r6)
                if (r1 != 0) goto L_0x0086
                boolean r1 = io.reactivex.internal.util.NotificationLite.isComplete(r6)
                if (r1 != 0) goto L_0x0086
                org.reactivestreams.Subscriber<? super T> r15 = r15.f15724c
                r15.onError(r0)
            L_0x0086:
                return
            L_0x0087:
                int r2 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
                if (r2 == 0) goto L_0x0092
                r15.f15725d = r6
                if (r0 != 0) goto L_0x0092
                r15.produced(r9)
            L_0x0092:
                monitor-enter(r15)
                boolean r0 = r15.f15728g     // Catch:{ all -> 0x00a0 }
                if (r0 != 0) goto L_0x009b
                r15.f15727f = r5     // Catch:{ all -> 0x00a0 }
                monitor-exit(r15)     // Catch:{ all -> 0x00a0 }
                return
            L_0x009b:
                r15.f15728g = r5     // Catch:{ all -> 0x00a0 }
                monitor-exit(r15)     // Catch:{ all -> 0x00a0 }
                goto L_0x000d
            L_0x00a0:
                r0 = move-exception
                monitor-exit(r15)     // Catch:{ all -> 0x00a0 }
                throw r0
            L_0x00a3:
                r0 = move-exception
                monitor-exit(r15)     // Catch:{ all -> 0x00a3 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer.replay(io.reactivex.internal.operators.flowable.FlowableReplay$InnerSubscription):void");
        }
    }

    public static final class ConnectableFlowableReplay<T> extends ConnectableFlowable<T> {

        /* renamed from: cf  reason: collision with root package name */
        private final ConnectableFlowable<T> f15722cf;
        private final Flowable<T> flowable;

        public ConnectableFlowableReplay(ConnectableFlowable<T> connectableFlowable, Flowable<T> flowable2) {
            this.f15722cf = connectableFlowable;
            this.flowable = flowable2;
        }

        public void connect(Consumer<? super Disposable> consumer) {
            this.f15722cf.connect(consumer);
        }

        public void subscribeActual(Subscriber<? super T> subscriber) {
            this.flowable.subscribe(subscriber);
        }
    }

    public static final class DefaultUnboundedFactory implements Callable<Object> {
        public Object call() {
            return new UnboundedReplayBuffer(16);
        }
    }

    public static final class InnerSubscription<T> extends AtomicLong implements Subscription, Disposable {
        private static final long serialVersionUID = -4453897557930727610L;

        /* renamed from: b  reason: collision with root package name */
        public final ReplaySubscriber<T> f15723b;

        /* renamed from: c  reason: collision with root package name */
        public final Subscriber<? super T> f15724c;

        /* renamed from: d  reason: collision with root package name */
        public Object f15725d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicLong f15726e = new AtomicLong();

        /* renamed from: f  reason: collision with root package name */
        public boolean f15727f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f15728g;

        public InnerSubscription(ReplaySubscriber<T> replaySubscriber, Subscriber<? super T> subscriber) {
            this.f15723b = replaySubscriber;
            this.f15724c = subscriber;
        }

        public <U> U a() {
            return this.f15725d;
        }

        public void cancel() {
            dispose();
        }

        public void dispose() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.f15723b.c(this);
                this.f15723b.b();
                this.f15725d = null;
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
                BackpressureHelper.add(this.f15726e, j11);
                this.f15723b.b();
                this.f15723b.f15734b.replay(this);
            }
        }
    }

    public static final class MulticastFlowable<R, U> extends Flowable<R> {
        private final Callable<? extends ConnectableFlowable<U>> connectableFactory;
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

        public MulticastFlowable(Callable<? extends ConnectableFlowable<U>> callable, Function<? super Flowable<U>, ? extends Publisher<R>> function) {
            this.connectableFactory = callable;
            this.selector = function;
        }

        public void subscribeActual(Subscriber<? super R> subscriber) {
            try {
                ConnectableFlowable connectableFlowable = (ConnectableFlowable) ObjectHelper.requireNonNull(this.connectableFactory.call(), "The connectableFactory returned null");
                try {
                    Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.selector.apply(connectableFlowable), "The selector returned a null Publisher");
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
        public final Object f15730b;

        /* renamed from: c  reason: collision with root package name */
        public final long f15731c;

        public Node(Object obj, long j11) {
            this.f15730b = obj;
            this.f15731c = j11;
        }
    }

    public interface ReplayBuffer<T> {
        void complete();

        void error(Throwable th2);

        void next(T t11);

        void replay(InnerSubscription<T> innerSubscription);
    }

    public static final class ReplayBufferTask<T> implements Callable<ReplayBuffer<T>> {
        private final int bufferSize;

        public ReplayBufferTask(int i11) {
            this.bufferSize = i11;
        }

        public ReplayBuffer<T> call() {
            return new SizeBoundReplayBuffer(this.bufferSize);
        }
    }

    public static final class ReplayPublisher<T> implements Publisher<T> {
        private final Callable<? extends ReplayBuffer<T>> bufferFactory;
        private final AtomicReference<ReplaySubscriber<T>> curr;

        public ReplayPublisher(AtomicReference<ReplaySubscriber<T>> atomicReference, Callable<? extends ReplayBuffer<T>> callable) {
            this.curr = atomicReference;
            this.bufferFactory = callable;
        }

        /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void subscribe(org.reactivestreams.Subscriber<? super T> r4) {
            /*
                r3 = this;
            L_0x0000:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableReplay$ReplaySubscriber<T>> r0 = r3.curr
                java.lang.Object r0 = r0.get()
                io.reactivex.internal.operators.flowable.FlowableReplay$ReplaySubscriber r0 = (io.reactivex.internal.operators.flowable.FlowableReplay.ReplaySubscriber) r0
                if (r0 != 0) goto L_0x002b
                java.util.concurrent.Callable<? extends io.reactivex.internal.operators.flowable.FlowableReplay$ReplayBuffer<T>> r0 = r3.bufferFactory     // Catch:{ all -> 0x0023 }
                java.lang.Object r0 = r0.call()     // Catch:{ all -> 0x0023 }
                io.reactivex.internal.operators.flowable.FlowableReplay$ReplayBuffer r0 = (io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer) r0     // Catch:{ all -> 0x0023 }
                io.reactivex.internal.operators.flowable.FlowableReplay$ReplaySubscriber r1 = new io.reactivex.internal.operators.flowable.FlowableReplay$ReplaySubscriber
                r1.<init>(r0)
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableReplay$ReplaySubscriber<T>> r0 = r3.curr
                r2 = 0
                boolean r0 = i.b.a(r0, r2, r1)
                if (r0 != 0) goto L_0x0021
                goto L_0x0000
            L_0x0021:
                r0 = r1
                goto L_0x002b
            L_0x0023:
                r0 = move-exception
                io.reactivex.exceptions.Exceptions.throwIfFatal(r0)
                io.reactivex.internal.subscriptions.EmptySubscription.error(r0, r4)
                return
            L_0x002b:
                io.reactivex.internal.operators.flowable.FlowableReplay$InnerSubscription r1 = new io.reactivex.internal.operators.flowable.FlowableReplay$InnerSubscription
                r1.<init>(r0, r4)
                r4.onSubscribe(r1)
                r0.a(r1)
                boolean r4 = r1.isDisposed()
                if (r4 == 0) goto L_0x0040
                r0.c(r1)
                return
            L_0x0040:
                r0.b()
                io.reactivex.internal.operators.flowable.FlowableReplay$ReplayBuffer<T> r4 = r0.f15734b
                r4.replay(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableReplay.ReplayPublisher.subscribe(org.reactivestreams.Subscriber):void");
        }
    }

    public static final class ReplaySubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: i  reason: collision with root package name */
        public static final InnerSubscription[] f15732i = new InnerSubscription[0];

        /* renamed from: j  reason: collision with root package name */
        public static final InnerSubscription[] f15733j = new InnerSubscription[0];
        private static final long serialVersionUID = 7224554242710036740L;

        /* renamed from: b  reason: collision with root package name */
        public final ReplayBuffer<T> f15734b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f15735c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReference<InnerSubscription<T>[]> f15736d = new AtomicReference<>(f15732i);

        /* renamed from: e  reason: collision with root package name */
        public final AtomicBoolean f15737e = new AtomicBoolean();

        /* renamed from: f  reason: collision with root package name */
        public final AtomicInteger f15738f = new AtomicInteger();

        /* renamed from: g  reason: collision with root package name */
        public long f15739g;

        /* renamed from: h  reason: collision with root package name */
        public long f15740h;

        public ReplaySubscriber(ReplayBuffer<T> replayBuffer) {
            this.f15734b = replayBuffer;
        }

        public boolean a(InnerSubscription<T> innerSubscription) {
            InnerSubscription[] innerSubscriptionArr;
            InnerSubscription[] innerSubscriptionArr2;
            innerSubscription.getClass();
            do {
                innerSubscriptionArr = (InnerSubscription[]) this.f15736d.get();
                if (innerSubscriptionArr == f15733j) {
                    return false;
                }
                int length = innerSubscriptionArr.length;
                innerSubscriptionArr2 = new InnerSubscription[(length + 1)];
                System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr2, 0, length);
                innerSubscriptionArr2[length] = innerSubscription;
            } while (!b.a(this.f15736d, innerSubscriptionArr, innerSubscriptionArr2));
            return true;
        }

        public void b() {
            if (this.f15738f.getAndIncrement() == 0) {
                int i11 = 1;
                while (!isDisposed()) {
                    InnerSubscription[] innerSubscriptionArr = (InnerSubscription[]) this.f15736d.get();
                    long j11 = this.f15739g;
                    long j12 = j11;
                    for (InnerSubscription innerSubscription : innerSubscriptionArr) {
                        j12 = Math.max(j12, innerSubscription.f15726e.get());
                    }
                    long j13 = this.f15740h;
                    Subscription subscription = (Subscription) get();
                    long j14 = j12 - j11;
                    if (j14 != 0) {
                        this.f15739g = j12;
                        if (subscription == null) {
                            long j15 = j13 + j14;
                            if (j15 < 0) {
                                j15 = Long.MAX_VALUE;
                            }
                            this.f15740h = j15;
                        } else if (j13 != 0) {
                            this.f15740h = 0;
                            subscription.request(j13 + j14);
                        } else {
                            subscription.request(j14);
                        }
                    } else if (!(j13 == 0 || subscription == null)) {
                        this.f15740h = 0;
                        subscription.request(j13);
                    }
                    i11 = this.f15738f.addAndGet(-i11);
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
                innerSubscriptionArr = (InnerSubscription[]) this.f15736d.get();
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
                            innerSubscriptionArr2 = f15732i;
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
            } while (!b.a(this.f15736d, innerSubscriptionArr, innerSubscriptionArr2));
        }

        public void dispose() {
            this.f15736d.set(f15733j);
            SubscriptionHelper.cancel(this);
        }

        public boolean isDisposed() {
            return this.f15736d.get() == f15733j;
        }

        public void onComplete() {
            if (!this.f15735c) {
                this.f15735c = true;
                this.f15734b.complete();
                for (InnerSubscription replay : (InnerSubscription[]) this.f15736d.getAndSet(f15733j)) {
                    this.f15734b.replay(replay);
                }
            }
        }

        public void onError(Throwable th2) {
            if (!this.f15735c) {
                this.f15735c = true;
                this.f15734b.error(th2);
                for (InnerSubscription replay : (InnerSubscription[]) this.f15736d.getAndSet(f15733j)) {
                    this.f15734b.replay(replay);
                }
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f15735c) {
                this.f15734b.next(t11);
                for (InnerSubscription replay : (InnerSubscription[]) this.f15736d.get()) {
                    this.f15734b.replay(replay);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                b();
                for (InnerSubscription replay : (InnerSubscription[]) this.f15736d.get()) {
                    this.f15734b.replay(replay);
                }
            }
        }
    }

    public static final class ScheduledReplayBufferTask<T> implements Callable<ReplayBuffer<T>> {
        private final int bufferSize;
        private final long maxAge;
        private final Scheduler scheduler;
        private final TimeUnit unit;

        public ScheduledReplayBufferTask(int i11, long j11, TimeUnit timeUnit, Scheduler scheduler2) {
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

        /* renamed from: e  reason: collision with root package name */
        public final Scheduler f15741e;

        /* renamed from: f  reason: collision with root package name */
        public final long f15742f;

        /* renamed from: g  reason: collision with root package name */
        public final TimeUnit f15743g;

        /* renamed from: h  reason: collision with root package name */
        public final int f15744h;

        public SizeAndTimeBoundReplayBuffer(int i11, long j11, TimeUnit timeUnit, Scheduler scheduler) {
            this.f15741e = scheduler;
            this.f15744h = i11;
            this.f15742f = j11;
            this.f15743g = timeUnit;
        }

        public Object b(Object obj) {
            return new Timed(obj, this.f15741e.now(this.f15743g), this.f15743g);
        }

        public Node c() {
            Node node;
            long now = this.f15741e.now(this.f15743g) - this.f15742f;
            Node node2 = (Node) get();
            Object obj = node2.get();
            while (true) {
                Node node3 = (Node) obj;
                node = node2;
                node2 = node3;
                if (node2 != null) {
                    Timed timed = (Timed) node2.f15730b;
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
            long now = this.f15741e.now(this.f15743g) - this.f15742f;
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
                int i12 = this.f15720c;
                if (i12 <= this.f15744h || i12 <= 1) {
                    if (((Timed) node2.f15730b).time() > now) {
                        break;
                    }
                    i11++;
                    this.f15720c--;
                    node3 = (Node) node2.get();
                } else {
                    i11++;
                    this.f15720c = i12 - 1;
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
                io.reactivex.Scheduler r0 = r10.f15741e
                java.util.concurrent.TimeUnit r1 = r10.f15743g
                long r0 = r0.now(r1)
                long r2 = r10.f15742f
                long r0 = r0 - r2
                java.lang.Object r2 = r10.get()
                io.reactivex.internal.operators.flowable.FlowableReplay$Node r2 = (io.reactivex.internal.operators.flowable.FlowableReplay.Node) r2
                java.lang.Object r3 = r2.get()
                io.reactivex.internal.operators.flowable.FlowableReplay$Node r3 = (io.reactivex.internal.operators.flowable.FlowableReplay.Node) r3
                r4 = 0
            L_0x0018:
                r9 = r3
                r3 = r2
                r2 = r9
                if (r2 == 0) goto L_0x003c
                int r5 = r10.f15720c
                r6 = 1
                if (r5 <= r6) goto L_0x003c
                java.lang.Object r5 = r2.f15730b
                io.reactivex.schedulers.Timed r5 = (io.reactivex.schedulers.Timed) r5
                long r7 = r5.time()
                int r5 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r5 > 0) goto L_0x003c
                int r4 = r4 + 1
                int r3 = r10.f15720c
                int r3 = r3 - r6
                r10.f15720c = r3
                java.lang.Object r3 = r2.get()
                io.reactivex.internal.operators.flowable.FlowableReplay$Node r3 = (io.reactivex.internal.operators.flowable.FlowableReplay.Node) r3
                goto L_0x0018
            L_0x003c:
                if (r4 == 0) goto L_0x0041
                r10.f(r3)
            L_0x0041:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableReplay.SizeAndTimeBoundReplayBuffer.i():void");
        }
    }

    public static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = -5898283885385201806L;

        /* renamed from: e  reason: collision with root package name */
        public final int f15745e;

        public SizeBoundReplayBuffer(int i11) {
            this.f15745e = i11;
        }

        public void h() {
            if (this.f15720c > this.f15745e) {
                e();
            }
        }
    }

    public static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 7063189396499112664L;

        /* renamed from: b  reason: collision with root package name */
        public volatile int f15746b;

        public UnboundedReplayBuffer(int i11) {
            super(i11);
        }

        public void complete() {
            add(NotificationLite.complete());
            this.f15746b++;
        }

        public void error(Throwable th2) {
            add(NotificationLite.error(th2));
            this.f15746b++;
        }

        public void next(T t11) {
            add(NotificationLite.next(t11));
            this.f15746b++;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
            if (r15.isDisposed() == false) goto L_0x0016;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0015, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0016, code lost:
            r1 = r14.f15746b;
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
            if (r8 == 0) goto L_0x0065;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0033, code lost:
            if (r2 >= r1) goto L_0x0065;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0035, code lost:
            r12 = get(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x003d, code lost:
            if (io.reactivex.internal.util.NotificationLite.accept(r12, r0) == false) goto L_0x0040;
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
            io.reactivex.exceptions.Exceptions.throwIfFatal(r1);
            r15.dispose();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0059, code lost:
            if (io.reactivex.internal.util.NotificationLite.isError(r12) != false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0061, code lost:
            r0.onError(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0067, code lost:
            if (r10 == 0) goto L_0x007b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0069, code lost:
            r15.f15725d = java.lang.Integer.valueOf(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0076, code lost:
            if (r4 == Long.MAX_VALUE) goto L_0x007b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0078, code lost:
            r15.produced(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x007b, code lost:
            monitor-enter(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x007e, code lost:
            if (r15.f15728g != false) goto L_0x0084;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0080, code lost:
            r15.f15727f = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0082, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0083, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0084, code lost:
            r15.f15728g = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0086, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x000d, code lost:
            r0 = r15.f15724c;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void replay(io.reactivex.internal.operators.flowable.FlowableReplay.InnerSubscription<T> r15) {
            /*
                r14 = this;
                monitor-enter(r15)
                boolean r0 = r15.f15727f     // Catch:{ all -> 0x008b }
                r1 = 1
                if (r0 == 0) goto L_0x000a
                r15.f15728g = r1     // Catch:{ all -> 0x008b }
                monitor-exit(r15)     // Catch:{ all -> 0x008b }
                return
            L_0x000a:
                r15.f15727f = r1     // Catch:{ all -> 0x008b }
                monitor-exit(r15)     // Catch:{ all -> 0x008b }
                org.reactivestreams.Subscriber<? super T> r0 = r15.f15724c
            L_0x000f:
                boolean r1 = r15.isDisposed()
                if (r1 == 0) goto L_0x0016
                return
            L_0x0016:
                int r1 = r14.f15746b
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
                if (r12 == 0) goto L_0x0065
                if (r2 >= r1) goto L_0x0065
                java.lang.Object r12 = r14.get(r2)
                boolean r12 = io.reactivex.internal.util.NotificationLite.accept((java.lang.Object) r12, r0)     // Catch:{ all -> 0x004e }
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
                io.reactivex.exceptions.Exceptions.throwIfFatal(r1)
                r15.dispose()
                boolean r15 = io.reactivex.internal.util.NotificationLite.isError(r12)
                if (r15 != 0) goto L_0x0064
                boolean r15 = io.reactivex.internal.util.NotificationLite.isComplete(r12)
                if (r15 != 0) goto L_0x0064
                r0.onError(r1)
            L_0x0064:
                return
            L_0x0065:
                int r1 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r1 == 0) goto L_0x007b
                java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
                r15.f15725d = r1
                r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r1 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
                if (r1 == 0) goto L_0x007b
                r15.produced(r10)
            L_0x007b:
                monitor-enter(r15)
                boolean r1 = r15.f15728g     // Catch:{ all -> 0x0088 }
                if (r1 != 0) goto L_0x0084
                r15.f15727f = r3     // Catch:{ all -> 0x0088 }
                monitor-exit(r15)     // Catch:{ all -> 0x0088 }
                return
            L_0x0084:
                r15.f15728g = r3     // Catch:{ all -> 0x0088 }
                monitor-exit(r15)     // Catch:{ all -> 0x0088 }
                goto L_0x000f
            L_0x0088:
                r0 = move-exception
                monitor-exit(r15)     // Catch:{ all -> 0x0088 }
                throw r0
            L_0x008b:
                r0 = move-exception
                monitor-exit(r15)     // Catch:{ all -> 0x008b }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableReplay.UnboundedReplayBuffer.replay(io.reactivex.internal.operators.flowable.FlowableReplay$InnerSubscription):void");
        }
    }

    private FlowableReplay(Publisher<T> publisher, Flowable<T> flowable, AtomicReference<ReplaySubscriber<T>> atomicReference, Callable<? extends ReplayBuffer<T>> callable) {
        this.f15718f = publisher;
        this.f15715c = flowable;
        this.f15716d = atomicReference;
        this.f15717e = callable;
    }

    public static <T> ConnectableFlowable<T> b(Flowable<T> flowable, Callable<? extends ReplayBuffer<T>> callable) {
        AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.onAssembly(new FlowableReplay(new ReplayPublisher(atomicReference, callable), flowable, atomicReference, callable));
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> flowable, int i11) {
        if (i11 == Integer.MAX_VALUE) {
            return createFrom(flowable);
        }
        return b(flowable, new ReplayBufferTask(i11));
    }

    public static <T> ConnectableFlowable<T> createFrom(Flowable<? extends T> flowable) {
        return b(flowable, f15714g);
    }

    public static <U, R> Flowable<R> multicastSelector(Callable<? extends ConnectableFlowable<U>> callable, Function<? super Flowable<U>, ? extends Publisher<R>> function) {
        return new MulticastFlowable(callable, function);
    }

    public static <T> ConnectableFlowable<T> observeOn(ConnectableFlowable<T> connectableFlowable, Scheduler scheduler) {
        return RxJavaPlugins.onAssembly(new ConnectableFlowableReplay(connectableFlowable, connectableFlowable.observeOn(scheduler)));
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect(io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> r5) {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableReplay$ReplaySubscriber<T>> r0 = r4.f15716d
            java.lang.Object r0 = r0.get()
            io.reactivex.internal.operators.flowable.FlowableReplay$ReplaySubscriber r0 = (io.reactivex.internal.operators.flowable.FlowableReplay.ReplaySubscriber) r0
            if (r0 == 0) goto L_0x0010
            boolean r1 = r0.isDisposed()
            if (r1 == 0) goto L_0x0027
        L_0x0010:
            java.util.concurrent.Callable<? extends io.reactivex.internal.operators.flowable.FlowableReplay$ReplayBuffer<T>> r1 = r4.f15717e     // Catch:{ all -> 0x0057 }
            java.lang.Object r1 = r1.call()     // Catch:{ all -> 0x0057 }
            io.reactivex.internal.operators.flowable.FlowableReplay$ReplayBuffer r1 = (io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer) r1     // Catch:{ all -> 0x0057 }
            io.reactivex.internal.operators.flowable.FlowableReplay$ReplaySubscriber r2 = new io.reactivex.internal.operators.flowable.FlowableReplay$ReplaySubscriber
            r2.<init>(r1)
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableReplay$ReplaySubscriber<T>> r1 = r4.f15716d
            boolean r0 = i.b.a(r1, r0, r2)
            if (r0 != 0) goto L_0x0026
            goto L_0x0000
        L_0x0026:
            r0 = r2
        L_0x0027:
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.f15737e
            boolean r1 = r1.get()
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x003b
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.f15737e
            boolean r1 = r1.compareAndSet(r3, r2)
            if (r1 == 0) goto L_0x003b
            r1 = r2
            goto L_0x003c
        L_0x003b:
            r1 = r3
        L_0x003c:
            r5.accept(r0)     // Catch:{ all -> 0x0047 }
            if (r1 == 0) goto L_0x0046
            io.reactivex.Flowable<T> r5 = r4.f15715c
            r5.subscribe(r0)
        L_0x0046:
            return
        L_0x0047:
            r5 = move-exception
            if (r1 == 0) goto L_0x004f
            java.util.concurrent.atomic.AtomicBoolean r0 = r0.f15737e
            r0.compareAndSet(r2, r3)
        L_0x004f:
            io.reactivex.exceptions.Exceptions.throwIfFatal(r5)
            java.lang.RuntimeException r5 = io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(r5)
            throw r5
        L_0x0057:
            r5 = move-exception
            io.reactivex.exceptions.Exceptions.throwIfFatal(r5)
            java.lang.RuntimeException r5 = io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(r5)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableReplay.connect(io.reactivex.functions.Consumer):void");
    }

    public void resetIf(Disposable disposable) {
        b.a(this.f15716d, (ReplaySubscriber) disposable, (Object) null);
    }

    public Publisher<T> source() {
        return this.f15715c;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f15718f.subscribe(subscriber);
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> flowable, long j11, TimeUnit timeUnit, Scheduler scheduler) {
        return create(flowable, j11, timeUnit, scheduler, Integer.MAX_VALUE);
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> flowable, long j11, TimeUnit timeUnit, Scheduler scheduler, int i11) {
        return b(flowable, new ScheduledReplayBufferTask(i11, j11, timeUnit, scheduler));
    }
}
