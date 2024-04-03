package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import org.reactivestreams.Subscriber;

public final class FlowableRangeLong extends Flowable<Long> {

    /* renamed from: c  reason: collision with root package name */
    public final long f15652c;

    /* renamed from: d  reason: collision with root package name */
    public final long f15653d;

    public static abstract class BaseRangeSubscription extends BasicQueueSubscription<Long> {
        private static final long serialVersionUID = -2252972430506210021L;

        /* renamed from: b  reason: collision with root package name */
        public final long f15654b;

        /* renamed from: c  reason: collision with root package name */
        public long f15655c;

        /* renamed from: d  reason: collision with root package name */
        public volatile boolean f15656d;

        public BaseRangeSubscription(long j11, long j12) {
            this.f15655c = j11;
            this.f15654b = j12;
        }

        public abstract void a();

        public abstract void b(long j11);

        public final void cancel() {
            this.f15656d = true;
        }

        public final void clear() {
            this.f15655c = this.f15654b;
        }

        public final boolean isEmpty() {
            return this.f15655c == this.f15654b;
        }

        public final void request(long j11) {
            if (SubscriptionHelper.validate(j11) && BackpressureHelper.add(this, j11) == 0) {
                if (j11 == Long.MAX_VALUE) {
                    a();
                } else {
                    b(j11);
                }
            }
        }

        public final int requestFusion(int i11) {
            return i11 & 1;
        }

        @Nullable
        public final Long poll() {
            long j11 = this.f15655c;
            if (j11 == this.f15654b) {
                return null;
            }
            this.f15655c = 1 + j11;
            return Long.valueOf(j11);
        }
    }

    public static final class RangeConditionalSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;

        /* renamed from: e  reason: collision with root package name */
        public final ConditionalSubscriber<? super Long> f15657e;

        public RangeConditionalSubscription(ConditionalSubscriber<? super Long> conditionalSubscriber, long j11, long j12) {
            super(j11, j12);
            this.f15657e = conditionalSubscriber;
        }

        public void a() {
            long j11 = this.f15654b;
            ConditionalSubscriber<? super Long> conditionalSubscriber = this.f15657e;
            long j12 = this.f15655c;
            while (j12 != j11) {
                if (!this.f15656d) {
                    conditionalSubscriber.tryOnNext(Long.valueOf(j12));
                    j12++;
                } else {
                    return;
                }
            }
            if (!this.f15656d) {
                conditionalSubscriber.onComplete();
            }
        }

        public void b(long j11) {
            long j12 = this.f15654b;
            long j13 = this.f15655c;
            ConditionalSubscriber<? super Long> conditionalSubscriber = this.f15657e;
            do {
                long j14 = 0;
                while (true) {
                    if (j14 == j11 || j13 == j12) {
                        if (j13 != j12) {
                            j11 = get();
                            if (j14 == j11) {
                                this.f15655c = j13;
                                j11 = addAndGet(-j14);
                            }
                        } else if (!this.f15656d) {
                            conditionalSubscriber.onComplete();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.f15656d) {
                        if (conditionalSubscriber.tryOnNext(Long.valueOf(j13))) {
                            j14++;
                        }
                        j13++;
                    } else {
                        return;
                    }
                }
            } while (j11 != 0);
        }
    }

    public static final class RangeSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;

        /* renamed from: e  reason: collision with root package name */
        public final Subscriber<? super Long> f15658e;

        public RangeSubscription(Subscriber<? super Long> subscriber, long j11, long j12) {
            super(j11, j12);
            this.f15658e = subscriber;
        }

        public void a() {
            long j11 = this.f15654b;
            Subscriber<? super Long> subscriber = this.f15658e;
            long j12 = this.f15655c;
            while (j12 != j11) {
                if (!this.f15656d) {
                    subscriber.onNext(Long.valueOf(j12));
                    j12++;
                } else {
                    return;
                }
            }
            if (!this.f15656d) {
                subscriber.onComplete();
            }
        }

        public void b(long j11) {
            long j12 = this.f15654b;
            long j13 = this.f15655c;
            Subscriber<? super Long> subscriber = this.f15658e;
            do {
                long j14 = 0;
                while (true) {
                    if (j14 == j11 || j13 == j12) {
                        if (j13 != j12) {
                            j11 = get();
                            if (j14 == j11) {
                                this.f15655c = j13;
                                j11 = addAndGet(-j14);
                            }
                        } else if (!this.f15656d) {
                            subscriber.onComplete();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.f15656d) {
                        subscriber.onNext(Long.valueOf(j13));
                        j14++;
                        j13++;
                    } else {
                        return;
                    }
                }
            } while (j11 != 0);
        }
    }

    public FlowableRangeLong(long j11, long j12) {
        this.f15652c = j11;
        this.f15653d = j11 + j12;
    }

    public void subscribeActual(Subscriber<? super Long> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            subscriber.onSubscribe(new RangeConditionalSubscription((ConditionalSubscriber) subscriber, this.f15652c, this.f15653d));
            return;
        }
        subscriber.onSubscribe(new RangeSubscription(subscriber, this.f15652c, this.f15653d));
    }
}
