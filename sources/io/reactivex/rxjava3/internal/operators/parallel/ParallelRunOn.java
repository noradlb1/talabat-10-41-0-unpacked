package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.schedulers.SchedulerMultiWorkerSupport;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelRunOn<T> extends ParallelFlowable<T> {

    /* renamed from: a  reason: collision with root package name */
    public final ParallelFlowable<? extends T> f22719a;

    /* renamed from: b  reason: collision with root package name */
    public final Scheduler f22720b;

    /* renamed from: c  reason: collision with root package name */
    public final int f22721c;

    public static abstract class BaseRunOnSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = 9222303586456402150L;

        /* renamed from: b  reason: collision with root package name */
        public final int f22722b;

        /* renamed from: c  reason: collision with root package name */
        public final int f22723c;

        /* renamed from: d  reason: collision with root package name */
        public final SpscArrayQueue<T> f22724d;

        /* renamed from: e  reason: collision with root package name */
        public final Scheduler.Worker f22725e;

        /* renamed from: f  reason: collision with root package name */
        public Subscription f22726f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f22727g;

        /* renamed from: h  reason: collision with root package name */
        public Throwable f22728h;

        /* renamed from: i  reason: collision with root package name */
        public final AtomicLong f22729i = new AtomicLong();

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f22730j;

        /* renamed from: k  reason: collision with root package name */
        public int f22731k;

        public BaseRunOnSubscriber(int i11, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
            this.f22722b = i11;
            this.f22724d = spscArrayQueue;
            this.f22723c = i11 - (i11 >> 2);
            this.f22725e = worker;
        }

        public final void a() {
            if (getAndIncrement() == 0) {
                this.f22725e.schedule(this);
            }
        }

        public final void cancel() {
            if (!this.f22730j) {
                this.f22730j = true;
                this.f22726f.cancel();
                this.f22725e.dispose();
                if (getAndIncrement() == 0) {
                    this.f22724d.clear();
                }
            }
        }

        public final void onComplete() {
            if (!this.f22727g) {
                this.f22727g = true;
                a();
            }
        }

        public final void onError(Throwable th2) {
            if (this.f22727g) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f22728h = th2;
            this.f22727g = true;
            a();
        }

        public final void onNext(T t11) {
            if (!this.f22727g) {
                if (!this.f22724d.offer(t11)) {
                    this.f22726f.cancel();
                    onError(new MissingBackpressureException("Queue is full?!"));
                    return;
                }
                a();
            }
        }

        public final void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f22729i, j11);
                a();
            }
        }
    }

    public final class MultiWorkerCallback implements SchedulerMultiWorkerSupport.WorkerCallback {

        /* renamed from: a  reason: collision with root package name */
        public final Subscriber<? super T>[] f22732a;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<T>[] f22733b;

        public MultiWorkerCallback(Subscriber<? super T>[] subscriberArr, Subscriber<T>[] subscriberArr2) {
            this.f22732a = subscriberArr;
            this.f22733b = subscriberArr2;
        }

        public void onWorker(int i11, Scheduler.Worker worker) {
            ParallelRunOn.this.b(i11, this.f22732a, this.f22733b, worker);
        }
    }

    public static final class RunOnConditionalSubscriber<T> extends BaseRunOnSubscriber<T> {
        private static final long serialVersionUID = 1075119423897941642L;

        /* renamed from: l  reason: collision with root package name */
        public final ConditionalSubscriber<? super T> f22735l;

        public RunOnConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, int i11, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
            super(i11, spscArrayQueue, worker);
            this.f22735l = conditionalSubscriber;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f22726f, subscription)) {
                this.f22726f = subscription;
                this.f22735l.onSubscribe(this);
                subscription.request((long) this.f22722b);
            }
        }

        public void run() {
            int i11;
            boolean z11;
            Throwable th2;
            int i12 = this.f22731k;
            SpscArrayQueue<T> spscArrayQueue = this.f22724d;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.f22735l;
            int i13 = this.f22723c;
            int i14 = 1;
            do {
                long j11 = this.f22729i.get();
                long j12 = 0;
                while (true) {
                    i11 = (j12 > j11 ? 1 : (j12 == j11 ? 0 : -1));
                    if (i11 == 0) {
                        break;
                    } else if (this.f22730j) {
                        spscArrayQueue.clear();
                        return;
                    } else {
                        boolean z12 = this.f22727g;
                        if (!z12 || (th2 = this.f22728h) == null) {
                            T poll = spscArrayQueue.poll();
                            if (poll == null) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (z12 && z11) {
                                conditionalSubscriber.onComplete();
                                this.f22725e.dispose();
                                return;
                            } else if (z11) {
                                break;
                            } else {
                                if (conditionalSubscriber.tryOnNext(poll)) {
                                    j12++;
                                }
                                i12++;
                                if (i12 == i13) {
                                    this.f22726f.request((long) i12);
                                    i12 = 0;
                                }
                            }
                        } else {
                            spscArrayQueue.clear();
                            conditionalSubscriber.onError(th2);
                            this.f22725e.dispose();
                            return;
                        }
                    }
                }
                if (i11 == 0) {
                    if (this.f22730j) {
                        spscArrayQueue.clear();
                        return;
                    } else if (this.f22727g) {
                        Throwable th3 = this.f22728h;
                        if (th3 != null) {
                            spscArrayQueue.clear();
                            conditionalSubscriber.onError(th3);
                            this.f22725e.dispose();
                            return;
                        } else if (spscArrayQueue.isEmpty()) {
                            conditionalSubscriber.onComplete();
                            this.f22725e.dispose();
                            return;
                        }
                    }
                }
                if (j12 != 0) {
                    BackpressureHelper.produced(this.f22729i, j12);
                }
                this.f22731k = i12;
                i14 = addAndGet(-i14);
            } while (i14 != 0);
        }
    }

    public static final class RunOnSubscriber<T> extends BaseRunOnSubscriber<T> {
        private static final long serialVersionUID = 1075119423897941642L;

        /* renamed from: l  reason: collision with root package name */
        public final Subscriber<? super T> f22736l;

        public RunOnSubscriber(Subscriber<? super T> subscriber, int i11, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
            super(i11, spscArrayQueue, worker);
            this.f22736l = subscriber;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f22726f, subscription)) {
                this.f22726f = subscription;
                this.f22736l.onSubscribe(this);
                subscription.request((long) this.f22722b);
            }
        }

        public void run() {
            int i11;
            boolean z11;
            Throwable th2;
            int i12 = this.f22731k;
            SpscArrayQueue<T> spscArrayQueue = this.f22724d;
            Subscriber<? super T> subscriber = this.f22736l;
            int i13 = this.f22723c;
            int i14 = 1;
            while (true) {
                long j11 = this.f22729i.get();
                long j12 = 0;
                while (true) {
                    i11 = (j12 > j11 ? 1 : (j12 == j11 ? 0 : -1));
                    if (i11 == 0) {
                        break;
                    } else if (this.f22730j) {
                        spscArrayQueue.clear();
                        return;
                    } else {
                        boolean z12 = this.f22727g;
                        if (!z12 || (th2 = this.f22728h) == null) {
                            T poll = spscArrayQueue.poll();
                            if (poll == null) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (z12 && z11) {
                                subscriber.onComplete();
                                this.f22725e.dispose();
                                return;
                            } else if (z11) {
                                break;
                            } else {
                                subscriber.onNext(poll);
                                j12++;
                                i12++;
                                if (i12 == i13) {
                                    this.f22726f.request((long) i12);
                                    i12 = 0;
                                }
                            }
                        } else {
                            spscArrayQueue.clear();
                            subscriber.onError(th2);
                            this.f22725e.dispose();
                            return;
                        }
                    }
                }
                if (i11 == 0) {
                    if (this.f22730j) {
                        spscArrayQueue.clear();
                        return;
                    } else if (this.f22727g) {
                        Throwable th3 = this.f22728h;
                        if (th3 != null) {
                            spscArrayQueue.clear();
                            subscriber.onError(th3);
                            this.f22725e.dispose();
                            return;
                        } else if (spscArrayQueue.isEmpty()) {
                            subscriber.onComplete();
                            this.f22725e.dispose();
                            return;
                        }
                    }
                }
                if (!(j12 == 0 || j11 == Long.MAX_VALUE)) {
                    this.f22729i.addAndGet(-j12);
                }
                int i15 = get();
                if (i15 == i14) {
                    this.f22731k = i12;
                    i14 = addAndGet(-i14);
                    if (i14 == 0) {
                        return;
                    }
                } else {
                    i14 = i15;
                }
            }
        }
    }

    public ParallelRunOn(ParallelFlowable<? extends T> parallelFlowable, Scheduler scheduler, int i11) {
        this.f22719a = parallelFlowable;
        this.f22720b = scheduler;
        this.f22721c = i11;
    }

    public void b(int i11, Subscriber<? super T>[] subscriberArr, Subscriber<T>[] subscriberArr2, Scheduler.Worker worker) {
        ConditionalSubscriber conditionalSubscriber = subscriberArr[i11];
        SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.f22721c);
        if (conditionalSubscriber instanceof ConditionalSubscriber) {
            subscriberArr2[i11] = new RunOnConditionalSubscriber(conditionalSubscriber, this.f22721c, spscArrayQueue, worker);
        } else {
            subscriberArr2[i11] = new RunOnSubscriber(conditionalSubscriber, this.f22721c, spscArrayQueue, worker);
        }
    }

    public int parallelism() {
        return this.f22719a.parallelism();
    }

    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        Subscriber[] onSubscribe = RxJavaPlugins.onSubscribe(this, subscriberArr);
        if (a(onSubscribe)) {
            int length = onSubscribe.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            Scheduler scheduler = this.f22720b;
            if (scheduler instanceof SchedulerMultiWorkerSupport) {
                ((SchedulerMultiWorkerSupport) scheduler).createWorkers(length, new MultiWorkerCallback(onSubscribe, subscriberArr2));
            } else {
                for (int i11 = 0; i11 < length; i11++) {
                    b(i11, onSubscribe, subscriberArr2, this.f22720b.createWorker());
                }
            }
            this.f22719a.subscribe(subscriberArr2);
        }
    }
}
