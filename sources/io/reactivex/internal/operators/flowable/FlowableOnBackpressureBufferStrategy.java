package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Action;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableOnBackpressureBufferStrategy<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final long f15549d;

    /* renamed from: e  reason: collision with root package name */
    public final Action f15550e;

    /* renamed from: f  reason: collision with root package name */
    public final BackpressureOverflowStrategy f15551f;

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableOnBackpressureBufferStrategy$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f15552a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                io.reactivex.BackpressureOverflowStrategy[] r0 = io.reactivex.BackpressureOverflowStrategy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f15552a = r0
                io.reactivex.BackpressureOverflowStrategy r1 = io.reactivex.BackpressureOverflowStrategy.DROP_LATEST     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f15552a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.reactivex.BackpressureOverflowStrategy r1 = io.reactivex.BackpressureOverflowStrategy.DROP_OLDEST     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableOnBackpressureBufferStrategy.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class OnBackpressureBufferStrategySubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 3240706908776709697L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15553b;

        /* renamed from: c  reason: collision with root package name */
        public final Action f15554c;

        /* renamed from: d  reason: collision with root package name */
        public final BackpressureOverflowStrategy f15555d;

        /* renamed from: e  reason: collision with root package name */
        public final long f15556e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicLong f15557f = new AtomicLong();

        /* renamed from: g  reason: collision with root package name */
        public final Deque<T> f15558g = new ArrayDeque();

        /* renamed from: h  reason: collision with root package name */
        public Subscription f15559h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f15560i;

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f15561j;

        /* renamed from: k  reason: collision with root package name */
        public Throwable f15562k;

        public OnBackpressureBufferStrategySubscriber(Subscriber<? super T> subscriber, Action action, BackpressureOverflowStrategy backpressureOverflowStrategy, long j11) {
            this.f15553b = subscriber;
            this.f15554c = action;
            this.f15555d = backpressureOverflowStrategy;
            this.f15556e = j11;
        }

        public void a(Deque<T> deque) {
            synchronized (deque) {
                deque.clear();
            }
        }

        public void b() {
            int i11;
            boolean isEmpty;
            T poll;
            boolean z11;
            if (getAndIncrement() == 0) {
                Deque<T> deque = this.f15558g;
                Subscriber<? super T> subscriber = this.f15553b;
                int i12 = 1;
                do {
                    long j11 = this.f15557f.get();
                    long j12 = 0;
                    while (true) {
                        i11 = (j12 > j11 ? 1 : (j12 == j11 ? 0 : -1));
                        if (i11 == 0) {
                            break;
                        } else if (this.f15560i) {
                            a(deque);
                            return;
                        } else {
                            boolean z12 = this.f15561j;
                            synchronized (deque) {
                                poll = deque.poll();
                            }
                            if (poll == null) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (z12) {
                                Throwable th2 = this.f15562k;
                                if (th2 != null) {
                                    a(deque);
                                    subscriber.onError(th2);
                                    return;
                                } else if (z11) {
                                    subscriber.onComplete();
                                    return;
                                }
                            }
                            if (z11) {
                                break;
                            }
                            subscriber.onNext(poll);
                            j12++;
                        }
                    }
                    if (i11 == 0) {
                        if (this.f15560i) {
                            a(deque);
                            return;
                        }
                        boolean z13 = this.f15561j;
                        synchronized (deque) {
                            isEmpty = deque.isEmpty();
                        }
                        if (z13) {
                            Throwable th3 = this.f15562k;
                            if (th3 != null) {
                                a(deque);
                                subscriber.onError(th3);
                                return;
                            } else if (isEmpty) {
                                subscriber.onComplete();
                                return;
                            }
                        }
                    }
                    if (j12 != 0) {
                        BackpressureHelper.produced(this.f15557f, j12);
                    }
                    i12 = addAndGet(-i12);
                } while (i12 != 0);
            }
        }

        public void cancel() {
            this.f15560i = true;
            this.f15559h.cancel();
            if (getAndIncrement() == 0) {
                a(this.f15558g);
            }
        }

        public void onComplete() {
            this.f15561j = true;
            b();
        }

        public void onError(Throwable th2) {
            if (this.f15561j) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f15562k = th2;
            this.f15561j = true;
            b();
        }

        public void onNext(T t11) {
            boolean z11;
            boolean z12;
            if (!this.f15561j) {
                Deque<T> deque = this.f15558g;
                synchronized (deque) {
                    z11 = false;
                    if (((long) deque.size()) == this.f15556e) {
                        int i11 = AnonymousClass1.f15552a[this.f15555d.ordinal()];
                        z12 = true;
                        if (i11 == 1) {
                            deque.pollLast();
                            deque.offer(t11);
                        } else if (i11 == 2) {
                            deque.poll();
                            deque.offer(t11);
                        }
                        z12 = false;
                        z11 = true;
                    } else {
                        deque.offer(t11);
                        z12 = false;
                    }
                }
                if (z11) {
                    Action action = this.f15554c;
                    if (action != null) {
                        try {
                            action.run();
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            this.f15559h.cancel();
                            onError(th2);
                        }
                    }
                } else if (z12) {
                    this.f15559h.cancel();
                    onError(new MissingBackpressureException());
                } else {
                    b();
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15559h, subscription)) {
                this.f15559h = subscription;
                this.f15553b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f15557f, j11);
                b();
            }
        }
    }

    public FlowableOnBackpressureBufferStrategy(Flowable<T> flowable, long j11, Action action, BackpressureOverflowStrategy backpressureOverflowStrategy) {
        super(flowable);
        this.f15549d = j11;
        this.f15550e = action;
        this.f15551f = backpressureOverflowStrategy;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f14763c.subscribe(new OnBackpressureBufferStrategySubscriber(subscriber, this.f15550e, this.f15551f, this.f15549d));
    }
}
