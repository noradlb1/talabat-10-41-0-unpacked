package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelRunOn<T> extends ParallelFlowable<T> {

    /* renamed from: a  reason: collision with root package name */
    public final ParallelFlowable<? extends T> f18185a;

    /* renamed from: b  reason: collision with root package name */
    public final Scheduler f18186b;

    /* renamed from: c  reason: collision with root package name */
    public final int f18187c;

    public static abstract class BaseRunOnSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = 9222303586456402150L;

        /* renamed from: b  reason: collision with root package name */
        public final int f18188b;

        /* renamed from: c  reason: collision with root package name */
        public final int f18189c;

        /* renamed from: d  reason: collision with root package name */
        public final SpscArrayQueue<T> f18190d;

        /* renamed from: e  reason: collision with root package name */
        public final Scheduler.Worker f18191e;

        /* renamed from: f  reason: collision with root package name */
        public Subscription f18192f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f18193g;

        /* renamed from: h  reason: collision with root package name */
        public Throwable f18194h;

        /* renamed from: i  reason: collision with root package name */
        public final AtomicLong f18195i = new AtomicLong();

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f18196j;

        /* renamed from: k  reason: collision with root package name */
        public int f18197k;

        public BaseRunOnSubscriber(int i11, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
            this.f18188b = i11;
            this.f18190d = spscArrayQueue;
            this.f18189c = i11 - (i11 >> 2);
            this.f18191e = worker;
        }

        public final void a() {
            if (getAndIncrement() == 0) {
                this.f18191e.schedule(this);
            }
        }

        public final void cancel() {
            if (!this.f18196j) {
                this.f18196j = true;
                this.f18192f.cancel();
                this.f18191e.dispose();
                if (getAndIncrement() == 0) {
                    this.f18190d.clear();
                }
            }
        }

        public final void onComplete() {
            if (!this.f18193g) {
                this.f18193g = true;
                a();
            }
        }

        public final void onError(Throwable th2) {
            if (this.f18193g) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f18194h = th2;
            this.f18193g = true;
            a();
        }

        public final void onNext(T t11) {
            if (!this.f18193g) {
                if (!this.f18190d.offer(t11)) {
                    this.f18192f.cancel();
                    onError(new MissingBackpressureException("Queue is full?!"));
                    return;
                }
                a();
            }
        }

        public final void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f18195i, j11);
                a();
            }
        }
    }

    public final class MultiWorkerCallback implements SchedulerMultiWorkerSupport.WorkerCallback {

        /* renamed from: a  reason: collision with root package name */
        public final Subscriber<? super T>[] f18198a;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<T>[] f18199b;

        public MultiWorkerCallback(Subscriber<? super T>[] subscriberArr, Subscriber<T>[] subscriberArr2) {
            this.f18198a = subscriberArr;
            this.f18199b = subscriberArr2;
        }

        public void onWorker(int i11, Scheduler.Worker worker) {
            ParallelRunOn.this.b(i11, this.f18198a, this.f18199b, worker);
        }
    }

    public static final class RunOnConditionalSubscriber<T> extends BaseRunOnSubscriber<T> {
        private static final long serialVersionUID = 1075119423897941642L;

        /* renamed from: l  reason: collision with root package name */
        public final ConditionalSubscriber<? super T> f18201l;

        public RunOnConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, int i11, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
            super(i11, spscArrayQueue, worker);
            this.f18201l = conditionalSubscriber;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f18192f, subscription)) {
                this.f18192f = subscription;
                this.f18201l.onSubscribe(this);
                subscription.request((long) this.f18188b);
            }
        }

        public void run() {
            int i11;
            boolean z11;
            Throwable th2;
            int i12 = this.f18197k;
            SpscArrayQueue<T> spscArrayQueue = this.f18190d;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.f18201l;
            int i13 = this.f18189c;
            int i14 = 1;
            while (true) {
                long j11 = this.f18195i.get();
                long j12 = 0;
                while (true) {
                    i11 = (j12 > j11 ? 1 : (j12 == j11 ? 0 : -1));
                    if (i11 == 0) {
                        break;
                    } else if (this.f18196j) {
                        spscArrayQueue.clear();
                        return;
                    } else {
                        boolean z12 = this.f18193g;
                        if (!z12 || (th2 = this.f18194h) == null) {
                            T poll = spscArrayQueue.poll();
                            if (poll == null) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (z12 && z11) {
                                conditionalSubscriber.onComplete();
                                this.f18191e.dispose();
                                return;
                            } else if (z11) {
                                break;
                            } else {
                                if (conditionalSubscriber.tryOnNext(poll)) {
                                    j12++;
                                }
                                i12++;
                                if (i12 == i13) {
                                    this.f18192f.request((long) i12);
                                    i12 = 0;
                                }
                            }
                        } else {
                            spscArrayQueue.clear();
                            conditionalSubscriber.onError(th2);
                            this.f18191e.dispose();
                            return;
                        }
                    }
                }
                if (i11 == 0) {
                    if (this.f18196j) {
                        spscArrayQueue.clear();
                        return;
                    } else if (this.f18193g) {
                        Throwable th3 = this.f18194h;
                        if (th3 != null) {
                            spscArrayQueue.clear();
                            conditionalSubscriber.onError(th3);
                            this.f18191e.dispose();
                            return;
                        } else if (spscArrayQueue.isEmpty()) {
                            conditionalSubscriber.onComplete();
                            this.f18191e.dispose();
                            return;
                        }
                    }
                }
                if (!(j12 == 0 || j11 == Long.MAX_VALUE)) {
                    this.f18195i.addAndGet(-j12);
                }
                int i15 = get();
                if (i15 == i14) {
                    this.f18197k = i12;
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

    public static final class RunOnSubscriber<T> extends BaseRunOnSubscriber<T> {
        private static final long serialVersionUID = 1075119423897941642L;

        /* renamed from: l  reason: collision with root package name */
        public final Subscriber<? super T> f18202l;

        public RunOnSubscriber(Subscriber<? super T> subscriber, int i11, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
            super(i11, spscArrayQueue, worker);
            this.f18202l = subscriber;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f18192f, subscription)) {
                this.f18192f = subscription;
                this.f18202l.onSubscribe(this);
                subscription.request((long) this.f18188b);
            }
        }

        public void run() {
            int i11;
            boolean z11;
            Throwable th2;
            int i12 = this.f18197k;
            SpscArrayQueue<T> spscArrayQueue = this.f18190d;
            Subscriber<? super T> subscriber = this.f18202l;
            int i13 = this.f18189c;
            int i14 = 1;
            while (true) {
                long j11 = this.f18195i.get();
                long j12 = 0;
                while (true) {
                    i11 = (j12 > j11 ? 1 : (j12 == j11 ? 0 : -1));
                    if (i11 == 0) {
                        break;
                    } else if (this.f18196j) {
                        spscArrayQueue.clear();
                        return;
                    } else {
                        boolean z12 = this.f18193g;
                        if (!z12 || (th2 = this.f18194h) == null) {
                            T poll = spscArrayQueue.poll();
                            if (poll == null) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (z12 && z11) {
                                subscriber.onComplete();
                                this.f18191e.dispose();
                                return;
                            } else if (z11) {
                                break;
                            } else {
                                subscriber.onNext(poll);
                                j12++;
                                i12++;
                                if (i12 == i13) {
                                    this.f18192f.request((long) i12);
                                    i12 = 0;
                                }
                            }
                        } else {
                            spscArrayQueue.clear();
                            subscriber.onError(th2);
                            this.f18191e.dispose();
                            return;
                        }
                    }
                }
                if (i11 == 0) {
                    if (this.f18196j) {
                        spscArrayQueue.clear();
                        return;
                    } else if (this.f18193g) {
                        Throwable th3 = this.f18194h;
                        if (th3 != null) {
                            spscArrayQueue.clear();
                            subscriber.onError(th3);
                            this.f18191e.dispose();
                            return;
                        } else if (spscArrayQueue.isEmpty()) {
                            subscriber.onComplete();
                            this.f18191e.dispose();
                            return;
                        }
                    }
                }
                if (!(j12 == 0 || j11 == Long.MAX_VALUE)) {
                    this.f18195i.addAndGet(-j12);
                }
                int i15 = get();
                if (i15 == i14) {
                    this.f18197k = i12;
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
        this.f18185a = parallelFlowable;
        this.f18186b = scheduler;
        this.f18187c = i11;
    }

    public void b(int i11, Subscriber<? super T>[] subscriberArr, Subscriber<T>[] subscriberArr2, Scheduler.Worker worker) {
        ConditionalSubscriber conditionalSubscriber = subscriberArr[i11];
        SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.f18187c);
        if (conditionalSubscriber instanceof ConditionalSubscriber) {
            subscriberArr2[i11] = new RunOnConditionalSubscriber(conditionalSubscriber, this.f18187c, spscArrayQueue, worker);
        } else {
            subscriberArr2[i11] = new RunOnSubscriber(conditionalSubscriber, this.f18187c, spscArrayQueue, worker);
        }
    }

    public int parallelism() {
        return this.f18185a.parallelism();
    }

    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        if (a(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            Scheduler scheduler = this.f18186b;
            if (scheduler instanceof SchedulerMultiWorkerSupport) {
                ((SchedulerMultiWorkerSupport) scheduler).createWorkers(length, new MultiWorkerCallback(subscriberArr, subscriberArr2));
            } else {
                for (int i11 = 0; i11 < length; i11++) {
                    b(i11, subscriberArr, subscriberArr2, this.f18186b.createWorker());
                }
            }
            this.f18185a.subscribe(subscriberArr2);
        }
    }
}
