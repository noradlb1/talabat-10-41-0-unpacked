package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import java.util.Objects;
import org.reactivestreams.Subscriber;

public final class FlowableFromArray<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final T[] f19816c;

    public static final class ArrayConditionalSubscription<T> extends BaseArraySubscription<T> {
        private static final long serialVersionUID = 2587302975077663557L;

        /* renamed from: e  reason: collision with root package name */
        public final ConditionalSubscriber<? super T> f19817e;

        public ArrayConditionalSubscription(ConditionalSubscriber<? super T> conditionalSubscriber, T[] tArr) {
            super(tArr);
            this.f19817e = conditionalSubscriber;
        }

        public void a() {
            T[] tArr = this.f19819b;
            int length = tArr.length;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.f19817e;
            int i11 = this.f19820c;
            while (i11 != length) {
                if (!this.f19821d) {
                    T t11 = tArr[i11];
                    if (t11 == null) {
                        conditionalSubscriber.onError(new NullPointerException("The element at index " + i11 + " is null"));
                        return;
                    }
                    conditionalSubscriber.tryOnNext(t11);
                    i11++;
                } else {
                    return;
                }
            }
            if (!this.f19821d) {
                conditionalSubscriber.onComplete();
            }
        }

        public void b(long j11) {
            T[] tArr = this.f19819b;
            int length = tArr.length;
            int i11 = this.f19820c;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.f19817e;
            do {
                long j12 = 0;
                while (true) {
                    if (j12 == j11 || i11 == length) {
                        if (i11 != length) {
                            j11 = get();
                            if (j12 == j11) {
                                this.f19820c = i11;
                                j11 = addAndGet(-j12);
                            }
                        } else if (!this.f19821d) {
                            conditionalSubscriber.onComplete();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.f19821d) {
                        T t11 = tArr[i11];
                        if (t11 == null) {
                            conditionalSubscriber.onError(new NullPointerException("The element at index " + i11 + " is null"));
                            return;
                        }
                        if (conditionalSubscriber.tryOnNext(t11)) {
                            j12++;
                        }
                        i11++;
                    } else {
                        return;
                    }
                }
            } while (j11 != 0);
        }
    }

    public static final class ArraySubscription<T> extends BaseArraySubscription<T> {
        private static final long serialVersionUID = 2587302975077663557L;

        /* renamed from: e  reason: collision with root package name */
        public final Subscriber<? super T> f19818e;

        public ArraySubscription(Subscriber<? super T> subscriber, T[] tArr) {
            super(tArr);
            this.f19818e = subscriber;
        }

        public void a() {
            T[] tArr = this.f19819b;
            int length = tArr.length;
            Subscriber<? super T> subscriber = this.f19818e;
            int i11 = this.f19820c;
            while (i11 != length) {
                if (!this.f19821d) {
                    T t11 = tArr[i11];
                    if (t11 == null) {
                        subscriber.onError(new NullPointerException("The element at index " + i11 + " is null"));
                        return;
                    }
                    subscriber.onNext(t11);
                    i11++;
                } else {
                    return;
                }
            }
            if (!this.f19821d) {
                subscriber.onComplete();
            }
        }

        public void b(long j11) {
            T[] tArr = this.f19819b;
            int length = tArr.length;
            int i11 = this.f19820c;
            Subscriber<? super T> subscriber = this.f19818e;
            do {
                long j12 = 0;
                while (true) {
                    if (j12 == j11 || i11 == length) {
                        if (i11 != length) {
                            j11 = get();
                            if (j12 == j11) {
                                this.f19820c = i11;
                                j11 = addAndGet(-j12);
                            }
                        } else if (!this.f19821d) {
                            subscriber.onComplete();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.f19821d) {
                        T t11 = tArr[i11];
                        if (t11 == null) {
                            subscriber.onError(new NullPointerException("The element at index " + i11 + " is null"));
                            return;
                        }
                        subscriber.onNext(t11);
                        j12++;
                        i11++;
                    } else {
                        return;
                    }
                }
            } while (j11 != 0);
        }
    }

    public static abstract class BaseArraySubscription<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -2252972430506210021L;

        /* renamed from: b  reason: collision with root package name */
        public final T[] f19819b;

        /* renamed from: c  reason: collision with root package name */
        public int f19820c;

        /* renamed from: d  reason: collision with root package name */
        public volatile boolean f19821d;

        public BaseArraySubscription(T[] tArr) {
            this.f19819b = tArr;
        }

        public abstract void a();

        public abstract void b(long j11);

        public final void cancel() {
            this.f19821d = true;
        }

        public final void clear() {
            this.f19820c = this.f19819b.length;
        }

        public final boolean isEmpty() {
            return this.f19820c == this.f19819b.length;
        }

        @Nullable
        public final T poll() {
            int i11 = this.f19820c;
            T[] tArr = this.f19819b;
            if (i11 == tArr.length) {
                return null;
            }
            this.f19820c = i11 + 1;
            T t11 = tArr[i11];
            Objects.requireNonNull(t11, "array element is null");
            return t11;
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
    }

    public FlowableFromArray(T[] tArr) {
        this.f19816c = tArr;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            subscriber.onSubscribe(new ArrayConditionalSubscription((ConditionalSubscriber) subscriber, this.f19816c));
        } else {
            subscriber.onSubscribe(new ArraySubscription(subscriber, this.f19816c));
        }
    }
}
