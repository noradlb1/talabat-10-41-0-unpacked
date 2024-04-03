package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import org.reactivestreams.Subscriber;

public final class FlowableRange extends Flowable<Integer> {

    /* renamed from: c  reason: collision with root package name */
    public final int f15645c;

    /* renamed from: d  reason: collision with root package name */
    public final int f15646d;

    public static abstract class BaseRangeSubscription extends BasicQueueSubscription<Integer> {
        private static final long serialVersionUID = -2252972430506210021L;

        /* renamed from: b  reason: collision with root package name */
        public final int f15647b;

        /* renamed from: c  reason: collision with root package name */
        public int f15648c;

        /* renamed from: d  reason: collision with root package name */
        public volatile boolean f15649d;

        public BaseRangeSubscription(int i11, int i12) {
            this.f15648c = i11;
            this.f15647b = i12;
        }

        public abstract void a();

        public abstract void b(long j11);

        public final void cancel() {
            this.f15649d = true;
        }

        public final void clear() {
            this.f15648c = this.f15647b;
        }

        public final boolean isEmpty() {
            return this.f15648c == this.f15647b;
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
            int i11 = this.f15648c;
            if (i11 == this.f15647b) {
                return null;
            }
            this.f15648c = i11 + 1;
            return Integer.valueOf(i11);
        }
    }

    public static final class RangeConditionalSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;

        /* renamed from: e  reason: collision with root package name */
        public final ConditionalSubscriber<? super Integer> f15650e;

        public RangeConditionalSubscription(ConditionalSubscriber<? super Integer> conditionalSubscriber, int i11, int i12) {
            super(i11, i12);
            this.f15650e = conditionalSubscriber;
        }

        public void a() {
            int i11 = this.f15647b;
            ConditionalSubscriber<? super Integer> conditionalSubscriber = this.f15650e;
            int i12 = this.f15648c;
            while (i12 != i11) {
                if (!this.f15649d) {
                    conditionalSubscriber.tryOnNext(Integer.valueOf(i12));
                    i12++;
                } else {
                    return;
                }
            }
            if (!this.f15649d) {
                conditionalSubscriber.onComplete();
            }
        }

        public void b(long j11) {
            int i11 = this.f15647b;
            int i12 = this.f15648c;
            ConditionalSubscriber<? super Integer> conditionalSubscriber = this.f15650e;
            do {
                long j12 = 0;
                while (true) {
                    if (j12 == j11 || i12 == i11) {
                        if (i12 != i11) {
                            j11 = get();
                            if (j12 == j11) {
                                this.f15648c = i12;
                                j11 = addAndGet(-j12);
                            }
                        } else if (!this.f15649d) {
                            conditionalSubscriber.onComplete();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.f15649d) {
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
        public final Subscriber<? super Integer> f15651e;

        public RangeSubscription(Subscriber<? super Integer> subscriber, int i11, int i12) {
            super(i11, i12);
            this.f15651e = subscriber;
        }

        public void a() {
            int i11 = this.f15647b;
            Subscriber<? super Integer> subscriber = this.f15651e;
            int i12 = this.f15648c;
            while (i12 != i11) {
                if (!this.f15649d) {
                    subscriber.onNext(Integer.valueOf(i12));
                    i12++;
                } else {
                    return;
                }
            }
            if (!this.f15649d) {
                subscriber.onComplete();
            }
        }

        public void b(long j11) {
            int i11 = this.f15647b;
            int i12 = this.f15648c;
            Subscriber<? super Integer> subscriber = this.f15651e;
            do {
                long j12 = 0;
                while (true) {
                    if (j12 == j11 || i12 == i11) {
                        if (i12 != i11) {
                            j11 = get();
                            if (j12 == j11) {
                                this.f15648c = i12;
                                j11 = addAndGet(-j12);
                            }
                        } else if (!this.f15649d) {
                            subscriber.onComplete();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.f15649d) {
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
        this.f15645c = i11;
        this.f15646d = i11 + i12;
    }

    public void subscribeActual(Subscriber<? super Integer> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            subscriber.onSubscribe(new RangeConditionalSubscription((ConditionalSubscriber) subscriber, this.f15645c, this.f15646d));
        } else {
            subscriber.onSubscribe(new RangeSubscription(subscriber, this.f15645c, this.f15646d));
        }
    }
}
