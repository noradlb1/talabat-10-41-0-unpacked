package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.BackpressureOverflowStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableOnBackpressureBufferStrategy<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final long f20072d;

    /* renamed from: e  reason: collision with root package name */
    public final Action f20073e;

    /* renamed from: f  reason: collision with root package name */
    public final BackpressureOverflowStrategy f20074f;

    /* renamed from: io.reactivex.rxjava3.internal.operators.flowable.FlowableOnBackpressureBufferStrategy$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f20075a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                io.reactivex.rxjava3.core.BackpressureOverflowStrategy[] r0 = io.reactivex.rxjava3.core.BackpressureOverflowStrategy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f20075a = r0
                io.reactivex.rxjava3.core.BackpressureOverflowStrategy r1 = io.reactivex.rxjava3.core.BackpressureOverflowStrategy.DROP_LATEST     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20075a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.reactivex.rxjava3.core.BackpressureOverflowStrategy r1 = io.reactivex.rxjava3.core.BackpressureOverflowStrategy.DROP_OLDEST     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableOnBackpressureBufferStrategy.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class OnBackpressureBufferStrategySubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 3240706908776709697L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f20076b;

        /* renamed from: c  reason: collision with root package name */
        public final Action f20077c;

        /* renamed from: d  reason: collision with root package name */
        public final BackpressureOverflowStrategy f20078d;

        /* renamed from: e  reason: collision with root package name */
        public final long f20079e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicLong f20080f = new AtomicLong();

        /* renamed from: g  reason: collision with root package name */
        public final Deque<T> f20081g = new ArrayDeque();

        /* renamed from: h  reason: collision with root package name */
        public Subscription f20082h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f20083i;

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f20084j;

        /* renamed from: k  reason: collision with root package name */
        public Throwable f20085k;

        public OnBackpressureBufferStrategySubscriber(Subscriber<? super T> subscriber, Action action, BackpressureOverflowStrategy backpressureOverflowStrategy, long j11) {
            this.f20076b = subscriber;
            this.f20077c = action;
            this.f20078d = backpressureOverflowStrategy;
            this.f20079e = j11;
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
                Deque<T> deque = this.f20081g;
                Subscriber<? super T> subscriber = this.f20076b;
                int i12 = 1;
                do {
                    long j11 = this.f20080f.get();
                    long j12 = 0;
                    while (true) {
                        i11 = (j12 > j11 ? 1 : (j12 == j11 ? 0 : -1));
                        if (i11 == 0) {
                            break;
                        } else if (this.f20083i) {
                            a(deque);
                            return;
                        } else {
                            boolean z12 = this.f20084j;
                            synchronized (deque) {
                                poll = deque.poll();
                            }
                            if (poll == null) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (z12) {
                                Throwable th2 = this.f20085k;
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
                        if (this.f20083i) {
                            a(deque);
                            return;
                        }
                        boolean z13 = this.f20084j;
                        synchronized (deque) {
                            isEmpty = deque.isEmpty();
                        }
                        if (z13) {
                            Throwable th3 = this.f20085k;
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
                        BackpressureHelper.produced(this.f20080f, j12);
                    }
                    i12 = addAndGet(-i12);
                } while (i12 != 0);
            }
        }

        public void cancel() {
            this.f20083i = true;
            this.f20082h.cancel();
            if (getAndIncrement() == 0) {
                a(this.f20081g);
            }
        }

        public void onComplete() {
            this.f20084j = true;
            b();
        }

        public void onError(Throwable th2) {
            if (this.f20084j) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f20085k = th2;
            this.f20084j = true;
            b();
        }

        public void onNext(T t11) {
            boolean z11;
            boolean z12;
            if (!this.f20084j) {
                Deque<T> deque = this.f20081g;
                synchronized (deque) {
                    z11 = false;
                    if (((long) deque.size()) == this.f20079e) {
                        int i11 = AnonymousClass1.f20075a[this.f20078d.ordinal()];
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
                    Action action = this.f20077c;
                    if (action != null) {
                        try {
                            action.run();
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            this.f20082h.cancel();
                            onError(th2);
                        }
                    }
                } else if (z12) {
                    this.f20082h.cancel();
                    onError(new MissingBackpressureException());
                } else {
                    b();
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f20082h, subscription)) {
                this.f20082h = subscription;
                this.f20076b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f20080f, j11);
                b();
            }
        }
    }

    public FlowableOnBackpressureBufferStrategy(Flowable<T> flowable, long j11, Action action, BackpressureOverflowStrategy backpressureOverflowStrategy) {
        super(flowable);
        this.f20072d = j11;
        this.f20073e = action;
        this.f20074f = backpressureOverflowStrategy;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f19260c.subscribe(new OnBackpressureBufferStrategySubscriber(subscriber, this.f20073e, this.f20074f, this.f20072d));
    }
}
