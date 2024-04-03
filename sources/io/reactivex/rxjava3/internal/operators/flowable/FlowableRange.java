package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import org.reactivestreams.Subscriber;

public final class FlowableRange extends Flowable<Integer> {

    /* renamed from: c  reason: collision with root package name */
    public final int f20152c;

    /* renamed from: d  reason: collision with root package name */
    public final int f20153d;

    public static abstract class BaseRangeSubscription extends BasicQueueSubscription<Integer> {
        private static final long serialVersionUID = -2252972430506210021L;

        /* renamed from: b  reason: collision with root package name */
        public final int f20154b;

        /* renamed from: c  reason: collision with root package name */
        public int f20155c;

        /* renamed from: d  reason: collision with root package name */
        public volatile boolean f20156d;

        public BaseRangeSubscription(int i11, int i12) {
            this.f20155c = i11;
            this.f20154b = i12;
        }

        public abstract void a();

        public abstract void b(long j11);

        public final void cancel() {
            this.f20156d = true;
        }

        public final void clear() {
            this.f20155c = this.f20154b;
        }

        public final boolean isEmpty() {
            return this.f20155c == this.f20154b;
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
        public final Integer poll() {
            int i11 = this.f20155c;
            if (i11 == this.f20154b) {
                return null;
            }
            this.f20155c = i11 + 1;
            return Integer.valueOf(i11);
        }
    }

    public static final class RangeConditionalSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;

        /* renamed from: e  reason: collision with root package name */
        public final ConditionalSubscriber<? super Integer> f20157e;

        public RangeConditionalSubscription(ConditionalSubscriber<? super Integer> conditionalSubscriber, int i11, int i12) {
            super(i11, i12);
            this.f20157e = conditionalSubscriber;
        }

        public void a() {
            int i11 = this.f20154b;
            ConditionalSubscriber<? super Integer> conditionalSubscriber = this.f20157e;
            int i12 = this.f20155c;
            while (i12 != i11) {
                if (!this.f20156d) {
                    conditionalSubscriber.tryOnNext(Integer.valueOf(i12));
                    i12++;
                } else {
                    return;
                }
            }
            if (!this.f20156d) {
                conditionalSubscriber.onComplete();
            }
        }

        public void b(long j11) {
            int i11 = this.f20154b;
            int i12 = this.f20155c;
            ConditionalSubscriber<? super Integer> conditionalSubscriber = this.f20157e;
            do {
                long j12 = 0;
                while (true) {
                    if (j12 == j11 || i12 == i11) {
                        if (i12 != i11) {
                            j11 = get();
                            if (j12 == j11) {
                                this.f20155c = i12;
                                j11 = addAndGet(-j12);
                            }
                        } else if (!this.f20156d) {
                            conditionalSubscriber.onComplete();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.f20156d) {
                        if (conditionalSubscriber.tryOnNext(Integer.valueOf(i12))) {
                            j12++;
                        }
                        i12++;
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
        public final Subscriber<? super Integer> f20158e;

        public RangeSubscription(Subscriber<? super Integer> subscriber, int i11, int i12) {
            super(i11, i12);
            this.f20158e = subscriber;
        }

        public void a() {
            int i11 = this.f20154b;
            Subscriber<? super Integer> subscriber = this.f20158e;
            int i12 = this.f20155c;
            while (i12 != i11) {
                if (!this.f20156d) {
                    subscriber.onNext(Integer.valueOf(i12));
                    i12++;
                } else {
                    return;
                }
            }
            if (!this.f20156d) {
                subscriber.onComplete();
            }
        }

        public void b(long j11) {
            int i11 = this.f20154b;
            int i12 = this.f20155c;
            Subscriber<? super Integer> subscriber = this.f20158e;
            do {
                long j12 = 0;
                while (true) {
                    if (j12 == j11 || i12 == i11) {
                        if (i12 != i11) {
                            j11 = get();
                            if (j12 == j11) {
                                this.f20155c = i12;
                                j11 = addAndGet(-j12);
                            }
                        } else if (!this.f20156d) {
                            subscriber.onComplete();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.f20156d) {
                        subscriber.onNext(Integer.valueOf(i12));
                        j12++;
                        i12++;
                    } else {
                        return;
                    }
                }
            } while (j11 != 0);
        }
    }

    public FlowableRange(int i11, int i12) {
        this.f20152c = i11;
        this.f20153d = i11 + i12;
    }

    public void subscribeActual(Subscriber<? super Integer> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            subscriber.onSubscribe(new RangeConditionalSubscription((ConditionalSubscriber) subscriber, this.f20152c, this.f20153d));
        } else {
            subscriber.onSubscribe(new RangeSubscription(subscriber, this.f20152c, this.f20153d));
        }
    }
}
