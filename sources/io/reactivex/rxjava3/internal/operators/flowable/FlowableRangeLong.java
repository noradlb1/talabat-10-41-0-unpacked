package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import org.reactivestreams.Subscriber;

public final class FlowableRangeLong extends Flowable<Long> {

    /* renamed from: c  reason: collision with root package name */
    public final long f20159c;

    /* renamed from: d  reason: collision with root package name */
    public final long f20160d;

    public static abstract class BaseRangeSubscription extends BasicQueueSubscription<Long> {
        private static final long serialVersionUID = -2252972430506210021L;

        /* renamed from: b  reason: collision with root package name */
        public final long f20161b;

        /* renamed from: c  reason: collision with root package name */
        public long f20162c;

        /* renamed from: d  reason: collision with root package name */
        public volatile boolean f20163d;

        public BaseRangeSubscription(long j11, long j12) {
            this.f20162c = j11;
            this.f20161b = j12;
        }

        public abstract void a();

        public abstract void b(long j11);

        public final void cancel() {
            this.f20163d = true;
        }

        public final void clear() {
            this.f20162c = this.f20161b;
        }

        public final boolean isEmpty() {
            return this.f20162c == this.f20161b;
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
            long j11 = this.f20162c;
            if (j11 == this.f20161b) {
                return null;
            }
            this.f20162c = 1 + j11;
            return Long.valueOf(j11);
        }
    }

    public static final class RangeConditionalSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;

        /* renamed from: e  reason: collision with root package name */
        public final ConditionalSubscriber<? super Long> f20164e;

        public RangeConditionalSubscription(ConditionalSubscriber<? super Long> conditionalSubscriber, long j11, long j12) {
            super(j11, j12);
            this.f20164e = conditionalSubscriber;
        }

        public void a() {
            long j11 = this.f20161b;
            ConditionalSubscriber<? super Long> conditionalSubscriber = this.f20164e;
            long j12 = this.f20162c;
            while (j12 != j11) {
                if (!this.f20163d) {
                    conditionalSubscriber.tryOnNext(Long.valueOf(j12));
                    j12++;
                } else {
                    return;
                }
            }
            if (!this.f20163d) {
                conditionalSubscriber.onComplete();
            }
        }

        public void b(long j11) {
            long j12 = this.f20161b;
            long j13 = this.f20162c;
            ConditionalSubscriber<? super Long> conditionalSubscriber = this.f20164e;
            do {
                long j14 = 0;
                while (true) {
                    if (j14 == j11 || j13 == j12) {
                        if (j13 != j12) {
                            j11 = get();
                            if (j14 == j11) {
                                this.f20162c = j13;
                                j11 = addAndGet(-j14);
                            }
                        } else if (!this.f20163d) {
                            conditionalSubscriber.onComplete();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.f20163d) {
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
        public final Subscriber<? super Long> f20165e;

        public RangeSubscription(Subscriber<? super Long> subscriber, long j11, long j12) {
            super(j11, j12);
            this.f20165e = subscriber;
        }

        public void a() {
            long j11 = this.f20161b;
            Subscriber<? super Long> subscriber = this.f20165e;
            long j12 = this.f20162c;
            while (j12 != j11) {
                if (!this.f20163d) {
                    subscriber.onNext(Long.valueOf(j12));
                    j12++;
                } else {
                    return;
                }
            }
            if (!this.f20163d) {
                subscriber.onComplete();
            }
        }

        public void b(long j11) {
            long j12 = this.f20161b;
            long j13 = this.f20162c;
            Subscriber<? super Long> subscriber = this.f20165e;
            do {
                long j14 = 0;
                while (true) {
                    if (j14 == j11 || j13 == j12) {
                        if (j13 != j12) {
                            j11 = get();
                            if (j14 == j11) {
                                this.f20162c = j13;
                                j11 = addAndGet(-j14);
                            }
                        } else if (!this.f20163d) {
                            subscriber.onComplete();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.f20163d) {
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
        this.f20159c = j11;
        this.f20160d = j11 + j12;
    }

    public void subscribeActual(Subscriber<? super Long> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            subscriber.onSubscribe(new RangeConditionalSubscription((ConditionalSubscriber) subscriber, this.f20159c, this.f20160d));
            return;
        }
        subscriber.onSubscribe(new RangeSubscription(subscriber, this.f20159c, this.f20160d));
    }
}
