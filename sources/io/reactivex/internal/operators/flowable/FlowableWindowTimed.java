package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWindowTimed<T> extends AbstractFlowableWithUpstream<T, Flowable<T>> {

    /* renamed from: d  reason: collision with root package name */
    public final long f16172d;

    /* renamed from: e  reason: collision with root package name */
    public final long f16173e;

    /* renamed from: f  reason: collision with root package name */
    public final TimeUnit f16174f;

    /* renamed from: g  reason: collision with root package name */
    public final Scheduler f16175g;

    /* renamed from: h  reason: collision with root package name */
    public final long f16176h;

    /* renamed from: i  reason: collision with root package name */
    public final int f16177i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f16178j;

    public static final class WindowExactBoundedSubscriber<T> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements Subscription {

        /* renamed from: i  reason: collision with root package name */
        public final long f16179i;

        /* renamed from: j  reason: collision with root package name */
        public final TimeUnit f16180j;

        /* renamed from: k  reason: collision with root package name */
        public final Scheduler f16181k;

        /* renamed from: l  reason: collision with root package name */
        public final int f16182l;

        /* renamed from: m  reason: collision with root package name */
        public final boolean f16183m;

        /* renamed from: n  reason: collision with root package name */
        public final long f16184n;

        /* renamed from: o  reason: collision with root package name */
        public final Scheduler.Worker f16185o;

        /* renamed from: p  reason: collision with root package name */
        public long f16186p;

        /* renamed from: q  reason: collision with root package name */
        public long f16187q;

        /* renamed from: r  reason: collision with root package name */
        public Subscription f16188r;

        /* renamed from: s  reason: collision with root package name */
        public UnicastProcessor<T> f16189s;

        /* renamed from: t  reason: collision with root package name */
        public volatile boolean f16190t;

        /* renamed from: u  reason: collision with root package name */
        public final SequentialDisposable f16191u = new SequentialDisposable();

        public static final class ConsumerIndexHolder implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final long f16192b;

            /* renamed from: c  reason: collision with root package name */
            public final WindowExactBoundedSubscriber<?> f16193c;

            public ConsumerIndexHolder(long j11, WindowExactBoundedSubscriber<?> windowExactBoundedSubscriber) {
                this.f16192b = j11;
                this.f16193c = windowExactBoundedSubscriber;
            }

            public void run() {
                WindowExactBoundedSubscriber<?> windowExactBoundedSubscriber = this.f16193c;
                if (!windowExactBoundedSubscriber.f18590f) {
                    windowExactBoundedSubscriber.f18589e.offer(this);
                } else {
                    windowExactBoundedSubscriber.f16190t = true;
                }
                if (windowExactBoundedSubscriber.enter()) {
                    windowExactBoundedSubscriber.e();
                }
            }
        }

        public WindowExactBoundedSubscriber(Subscriber<? super Flowable<T>> subscriber, long j11, TimeUnit timeUnit, Scheduler scheduler, int i11, long j12, boolean z11) {
            super(subscriber, new MpscLinkedQueue());
            this.f16179i = j11;
            this.f16180j = timeUnit;
            this.f16181k = scheduler;
            this.f16182l = i11;
            this.f16184n = j12;
            this.f16183m = z11;
            if (z11) {
                this.f16185o = scheduler.createWorker();
            } else {
                this.f16185o = null;
            }
        }

        public void cancel() {
            this.f18590f = true;
        }

        public void disposeTimer() {
            this.f16191u.dispose();
            Scheduler.Worker worker = this.f16185o;
            if (worker != null) {
                worker.dispose();
            }
        }

        public void e() {
            boolean z11;
            SimplePlainQueue<U> simplePlainQueue = this.f18589e;
            Subscriber<? super V> subscriber = this.f18588d;
            UnicastProcessor<T> unicastProcessor = this.f16189s;
            int i11 = 1;
            while (!this.f16190t) {
                boolean z12 = this.f18591g;
                U poll = simplePlainQueue.poll();
                if (poll == null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                boolean z13 = poll instanceof ConsumerIndexHolder;
                if (z12 && (z11 || z13)) {
                    this.f16189s = null;
                    simplePlainQueue.clear();
                    Throwable th2 = this.f18592h;
                    if (th2 != null) {
                        unicastProcessor.onError(th2);
                    } else {
                        unicastProcessor.onComplete();
                    }
                    disposeTimer();
                    return;
                } else if (z11) {
                    i11 = leave(-i11);
                    if (i11 == 0) {
                        return;
                    }
                } else {
                    int i12 = i11;
                    if (z13) {
                        ConsumerIndexHolder consumerIndexHolder = (ConsumerIndexHolder) poll;
                        if (!this.f16183m || this.f16187q == consumerIndexHolder.f16192b) {
                            unicastProcessor.onComplete();
                            this.f16186p = 0;
                            unicastProcessor = UnicastProcessor.create(this.f16182l);
                            this.f16189s = unicastProcessor;
                            long requested = requested();
                            if (requested != 0) {
                                subscriber.onNext(unicastProcessor);
                                if (requested != Long.MAX_VALUE) {
                                    produced(1);
                                }
                            } else {
                                this.f16189s = null;
                                this.f18589e.clear();
                                this.f16188r.cancel();
                                subscriber.onError(new MissingBackpressureException("Could not deliver first window due to lack of requests."));
                                disposeTimer();
                                return;
                            }
                        }
                    } else {
                        unicastProcessor.onNext(NotificationLite.getValue(poll));
                        long j11 = this.f16186p + 1;
                        if (j11 >= this.f16184n) {
                            this.f16187q++;
                            this.f16186p = 0;
                            unicastProcessor.onComplete();
                            long requested2 = requested();
                            if (requested2 != 0) {
                                UnicastProcessor<T> create = UnicastProcessor.create(this.f16182l);
                                this.f16189s = create;
                                this.f18588d.onNext(create);
                                if (requested2 != Long.MAX_VALUE) {
                                    produced(1);
                                }
                                if (this.f16183m) {
                                    ((Disposable) this.f16191u.get()).dispose();
                                    Scheduler.Worker worker = this.f16185o;
                                    ConsumerIndexHolder consumerIndexHolder2 = new ConsumerIndexHolder(this.f16187q, this);
                                    long j12 = this.f16179i;
                                    this.f16191u.replace(worker.schedulePeriodically(consumerIndexHolder2, j12, j12, this.f16180j));
                                }
                                unicastProcessor = create;
                            } else {
                                this.f16189s = null;
                                this.f16188r.cancel();
                                this.f18588d.onError(new MissingBackpressureException("Could not deliver window due to lack of requests"));
                                disposeTimer();
                                return;
                            }
                        } else {
                            this.f16186p = j11;
                        }
                    }
                    i11 = i12;
                }
            }
            this.f16188r.cancel();
            simplePlainQueue.clear();
            disposeTimer();
        }

        public void onComplete() {
            this.f18591g = true;
            if (enter()) {
                e();
            }
            this.f18588d.onComplete();
        }

        public void onError(Throwable th2) {
            this.f18592h = th2;
            this.f18591g = true;
            if (enter()) {
                e();
            }
            this.f18588d.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f16190t) {
                if (fastEnter()) {
                    UnicastProcessor<T> unicastProcessor = this.f16189s;
                    unicastProcessor.onNext(t11);
                    long j11 = this.f16186p + 1;
                    if (j11 >= this.f16184n) {
                        this.f16187q++;
                        this.f16186p = 0;
                        unicastProcessor.onComplete();
                        long requested = requested();
                        if (requested != 0) {
                            UnicastProcessor<T> create = UnicastProcessor.create(this.f16182l);
                            this.f16189s = create;
                            this.f18588d.onNext(create);
                            if (requested != Long.MAX_VALUE) {
                                produced(1);
                            }
                            if (this.f16183m) {
                                ((Disposable) this.f16191u.get()).dispose();
                                Scheduler.Worker worker = this.f16185o;
                                ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.f16187q, this);
                                long j12 = this.f16179i;
                                this.f16191u.replace(worker.schedulePeriodically(consumerIndexHolder, j12, j12, this.f16180j));
                            }
                        } else {
                            this.f16189s = null;
                            this.f16188r.cancel();
                            this.f18588d.onError(new MissingBackpressureException("Could not deliver window due to lack of requests"));
                            disposeTimer();
                            return;
                        }
                    } else {
                        this.f16186p = j11;
                    }
                    if (leave(-1) == 0) {
                        return;
                    }
                } else {
                    this.f18589e.offer(NotificationLite.next(t11));
                    if (!enter()) {
                        return;
                    }
                }
                e();
            }
        }

        public void onSubscribe(Subscription subscription) {
            Disposable disposable;
            if (SubscriptionHelper.validate(this.f16188r, subscription)) {
                this.f16188r = subscription;
                Subscriber<? super V> subscriber = this.f18588d;
                subscriber.onSubscribe(this);
                if (!this.f18590f) {
                    UnicastProcessor<T> create = UnicastProcessor.create(this.f16182l);
                    this.f16189s = create;
                    long requested = requested();
                    if (requested != 0) {
                        subscriber.onNext(create);
                        if (requested != Long.MAX_VALUE) {
                            produced(1);
                        }
                        ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.f16187q, this);
                        if (this.f16183m) {
                            Scheduler.Worker worker = this.f16185o;
                            long j11 = this.f16179i;
                            disposable = worker.schedulePeriodically(consumerIndexHolder, j11, j11, this.f16180j);
                        } else {
                            Scheduler scheduler = this.f16181k;
                            long j12 = this.f16179i;
                            disposable = scheduler.schedulePeriodicallyDirect(consumerIndexHolder, j12, j12, this.f16180j);
                        }
                        if (this.f16191u.replace(disposable)) {
                            subscription.request(Long.MAX_VALUE);
                            return;
                        }
                        return;
                    }
                    this.f18590f = true;
                    subscription.cancel();
                    subscriber.onError(new MissingBackpressureException("Could not deliver initial window due to lack of requests."));
                }
            }
        }

        public void request(long j11) {
            requested(j11);
        }
    }

    public static final class WindowExactUnboundedSubscriber<T> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements Subscription, Runnable {

        /* renamed from: q  reason: collision with root package name */
        public static final Object f16194q = new Object();

        /* renamed from: i  reason: collision with root package name */
        public final long f16195i;

        /* renamed from: j  reason: collision with root package name */
        public final TimeUnit f16196j;

        /* renamed from: k  reason: collision with root package name */
        public final Scheduler f16197k;

        /* renamed from: l  reason: collision with root package name */
        public final int f16198l;

        /* renamed from: m  reason: collision with root package name */
        public Subscription f16199m;

        /* renamed from: n  reason: collision with root package name */
        public UnicastProcessor<T> f16200n;

        /* renamed from: o  reason: collision with root package name */
        public final SequentialDisposable f16201o = new SequentialDisposable();

        /* renamed from: p  reason: collision with root package name */
        public volatile boolean f16202p;

        public WindowExactUnboundedSubscriber(Subscriber<? super Flowable<T>> subscriber, long j11, TimeUnit timeUnit, Scheduler scheduler, int i11) {
            super(subscriber, new MpscLinkedQueue());
            this.f16195i = j11;
            this.f16196j = timeUnit;
            this.f16197k = scheduler;
            this.f16198l = i11;
        }

        public void c() {
            SimplePlainQueue<U> simplePlainQueue = this.f18589e;
            Subscriber<? super V> subscriber = this.f18588d;
            UnicastProcessor<T> unicastProcessor = this.f16200n;
            int i11 = 1;
            while (true) {
                boolean z11 = this.f16202p;
                boolean z12 = this.f18591g;
                U poll = simplePlainQueue.poll();
                if (!z12 || !(poll == null || poll == f16194q)) {
                    if (poll == null) {
                        i11 = leave(-i11);
                        if (i11 == 0) {
                            return;
                        }
                    } else if (poll == f16194q) {
                        unicastProcessor.onComplete();
                        if (!z11) {
                            unicastProcessor = UnicastProcessor.create(this.f16198l);
                            this.f16200n = unicastProcessor;
                            long requested = requested();
                            if (requested != 0) {
                                subscriber.onNext(unicastProcessor);
                                if (requested != Long.MAX_VALUE) {
                                    produced(1);
                                }
                            } else {
                                this.f16200n = null;
                                this.f18589e.clear();
                                this.f16199m.cancel();
                                subscriber.onError(new MissingBackpressureException("Could not deliver first window due to lack of requests."));
                                this.f16201o.dispose();
                                return;
                            }
                        } else {
                            this.f16199m.cancel();
                        }
                    } else {
                        unicastProcessor.onNext(NotificationLite.getValue(poll));
                    }
                }
            }
            this.f16200n = null;
            simplePlainQueue.clear();
            Throwable th2 = this.f18592h;
            if (th2 != null) {
                unicastProcessor.onError(th2);
            } else {
                unicastProcessor.onComplete();
            }
            this.f16201o.dispose();
        }

        public void cancel() {
            this.f18590f = true;
        }

        public void onComplete() {
            this.f18591g = true;
            if (enter()) {
                c();
            }
            this.f18588d.onComplete();
        }

        public void onError(Throwable th2) {
            this.f18592h = th2;
            this.f18591g = true;
            if (enter()) {
                c();
            }
            this.f18588d.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f16202p) {
                if (fastEnter()) {
                    this.f16200n.onNext(t11);
                    if (leave(-1) == 0) {
                        return;
                    }
                } else {
                    this.f18589e.offer(NotificationLite.next(t11));
                    if (!enter()) {
                        return;
                    }
                }
                c();
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f16199m, subscription)) {
                this.f16199m = subscription;
                this.f16200n = UnicastProcessor.create(this.f16198l);
                Subscriber<? super V> subscriber = this.f18588d;
                subscriber.onSubscribe(this);
                long requested = requested();
                if (requested != 0) {
                    subscriber.onNext(this.f16200n);
                    if (requested != Long.MAX_VALUE) {
                        produced(1);
                    }
                    if (!this.f18590f) {
                        SequentialDisposable sequentialDisposable = this.f16201o;
                        Scheduler scheduler = this.f16197k;
                        long j11 = this.f16195i;
                        if (sequentialDisposable.replace(scheduler.schedulePeriodicallyDirect(this, j11, j11, this.f16196j))) {
                            subscription.request(Long.MAX_VALUE);
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.f18590f = true;
                subscription.cancel();
                subscriber.onError(new MissingBackpressureException("Could not deliver first window due to lack of requests."));
            }
        }

        public void request(long j11) {
            requested(j11);
        }

        public void run() {
            if (this.f18590f) {
                this.f16202p = true;
            }
            this.f18589e.offer(f16194q);
            if (enter()) {
                c();
            }
        }
    }

    public static final class WindowSkipSubscriber<T> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements Subscription, Runnable {

        /* renamed from: i  reason: collision with root package name */
        public final long f16203i;

        /* renamed from: j  reason: collision with root package name */
        public final long f16204j;

        /* renamed from: k  reason: collision with root package name */
        public final TimeUnit f16205k;

        /* renamed from: l  reason: collision with root package name */
        public final Scheduler.Worker f16206l;

        /* renamed from: m  reason: collision with root package name */
        public final int f16207m;

        /* renamed from: n  reason: collision with root package name */
        public final List<UnicastProcessor<T>> f16208n = new LinkedList();

        /* renamed from: o  reason: collision with root package name */
        public Subscription f16209o;

        /* renamed from: p  reason: collision with root package name */
        public volatile boolean f16210p;

        public final class Completion implements Runnable {
            private final UnicastProcessor<T> processor;

            public Completion(UnicastProcessor<T> unicastProcessor) {
                this.processor = unicastProcessor;
            }

            public void run() {
                WindowSkipSubscriber.this.c(this.processor);
            }
        }

        public static final class SubjectWork<T> {

            /* renamed from: a  reason: collision with root package name */
            public final UnicastProcessor<T> f16212a;

            /* renamed from: b  reason: collision with root package name */
            public final boolean f16213b;

            public SubjectWork(UnicastProcessor<T> unicastProcessor, boolean z11) {
                this.f16212a = unicastProcessor;
                this.f16213b = z11;
            }
        }

        public WindowSkipSubscriber(Subscriber<? super Flowable<T>> subscriber, long j11, long j12, TimeUnit timeUnit, Scheduler.Worker worker, int i11) {
            super(subscriber, new MpscLinkedQueue());
            this.f16203i = j11;
            this.f16204j = j12;
            this.f16205k = timeUnit;
            this.f16206l = worker;
            this.f16207m = i11;
        }

        public void c(UnicastProcessor<T> unicastProcessor) {
            this.f18589e.offer(new SubjectWork(unicastProcessor, false));
            if (enter()) {
                d();
            }
        }

        public void cancel() {
            this.f18590f = true;
        }

        public void d() {
            boolean z11;
            SimplePlainQueue<U> simplePlainQueue = this.f18589e;
            Subscriber<? super V> subscriber = this.f18588d;
            List<UnicastProcessor<T>> list = this.f16208n;
            int i11 = 1;
            while (!this.f16210p) {
                boolean z12 = this.f18591g;
                U poll = simplePlainQueue.poll();
                if (poll == null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                boolean z13 = poll instanceof SubjectWork;
                if (z12 && (z11 || z13)) {
                    simplePlainQueue.clear();
                    Throwable th2 = this.f18592h;
                    if (th2 != null) {
                        for (UnicastProcessor<T> onError : list) {
                            onError.onError(th2);
                        }
                    } else {
                        for (UnicastProcessor<T> onComplete : list) {
                            onComplete.onComplete();
                        }
                    }
                    list.clear();
                    this.f16206l.dispose();
                    return;
                } else if (z11) {
                    i11 = leave(-i11);
                    if (i11 == 0) {
                        return;
                    }
                } else if (z13) {
                    SubjectWork subjectWork = (SubjectWork) poll;
                    if (!subjectWork.f16213b) {
                        list.remove(subjectWork.f16212a);
                        subjectWork.f16212a.onComplete();
                        if (list.isEmpty() && this.f18590f) {
                            this.f16210p = true;
                        }
                    } else if (!this.f18590f) {
                        long requested = requested();
                        if (requested != 0) {
                            UnicastProcessor create = UnicastProcessor.create(this.f16207m);
                            list.add(create);
                            subscriber.onNext(create);
                            if (requested != Long.MAX_VALUE) {
                                produced(1);
                            }
                            this.f16206l.schedule(new Completion(create), this.f16203i, this.f16205k);
                        } else {
                            subscriber.onError(new MissingBackpressureException("Can't emit window due to lack of requests"));
                        }
                    }
                } else {
                    for (UnicastProcessor<T> onNext : list) {
                        onNext.onNext(poll);
                    }
                }
            }
            this.f16209o.cancel();
            simplePlainQueue.clear();
            list.clear();
            this.f16206l.dispose();
        }

        public void onComplete() {
            this.f18591g = true;
            if (enter()) {
                d();
            }
            this.f18588d.onComplete();
        }

        public void onError(Throwable th2) {
            this.f18592h = th2;
            this.f18591g = true;
            if (enter()) {
                d();
            }
            this.f18588d.onError(th2);
        }

        public void onNext(T t11) {
            if (fastEnter()) {
                for (UnicastProcessor<T> onNext : this.f16208n) {
                    onNext.onNext(t11);
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.f18589e.offer(t11);
                if (!enter()) {
                    return;
                }
            }
            d();
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f16209o, subscription)) {
                this.f16209o = subscription;
                this.f18588d.onSubscribe(this);
                if (!this.f18590f) {
                    long requested = requested();
                    if (requested != 0) {
                        UnicastProcessor create = UnicastProcessor.create(this.f16207m);
                        this.f16208n.add(create);
                        this.f18588d.onNext(create);
                        if (requested != Long.MAX_VALUE) {
                            produced(1);
                        }
                        this.f16206l.schedule(new Completion(create), this.f16203i, this.f16205k);
                        Scheduler.Worker worker = this.f16206l;
                        long j11 = this.f16204j;
                        worker.schedulePeriodically(this, j11, j11, this.f16205k);
                        subscription.request(Long.MAX_VALUE);
                        return;
                    }
                    subscription.cancel();
                    this.f18588d.onError(new MissingBackpressureException("Could not emit the first window due to lack of requests"));
                }
            }
        }

        public void request(long j11) {
            requested(j11);
        }

        public void run() {
            SubjectWork subjectWork = new SubjectWork(UnicastProcessor.create(this.f16207m), true);
            if (!this.f18590f) {
                this.f18589e.offer(subjectWork);
            }
            if (enter()) {
                d();
            }
        }
    }

    public FlowableWindowTimed(Flowable<T> flowable, long j11, long j12, TimeUnit timeUnit, Scheduler scheduler, long j13, int i11, boolean z11) {
        super(flowable);
        this.f16172d = j11;
        this.f16173e = j12;
        this.f16174f = timeUnit;
        this.f16175g = scheduler;
        this.f16176h = j13;
        this.f16177i = i11;
        this.f16178j = z11;
    }

    public void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        long j11 = this.f16172d;
        long j12 = this.f16173e;
        if (j11 == j12) {
            long j13 = this.f16176h;
            if (j13 == Long.MAX_VALUE) {
                this.f14763c.subscribe(new WindowExactUnboundedSubscriber(serializedSubscriber, this.f16172d, this.f16174f, this.f16175g, this.f16177i));
            } else {
                this.f14763c.subscribe(new WindowExactBoundedSubscriber(serializedSubscriber, j11, this.f16174f, this.f16175g, this.f16177i, j13, this.f16178j));
            }
        } else {
            this.f14763c.subscribe(new WindowSkipSubscriber(serializedSubscriber, j11, j12, this.f16174f, this.f16175g.createWorker(), this.f16177i));
        }
    }
}
