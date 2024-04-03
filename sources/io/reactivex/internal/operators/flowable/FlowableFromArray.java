package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import org.reactivestreams.Subscriber;

public final class FlowableFromArray<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final T[] f15304c;

    public static final class ArrayConditionalSubscription<T> extends BaseArraySubscription<T> {
        private static final long serialVersionUID = 2587302975077663557L;

        /* renamed from: e  reason: collision with root package name */
        public final ConditionalSubscriber<? super T> f15305e;

        public ArrayConditionalSubscription(ConditionalSubscriber<? super T> conditionalSubscriber, T[] tArr) {
            super(tArr);
            this.f15305e = conditionalSubscriber;
        }

        public void a() {
            T[] tArr = this.f15307b;
            int length = tArr.length;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.f15305e;
            int i11 = this.f15308c;
            while (i11 != length) {
                if (!this.f15309d) {
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
            if (!this.f15309d) {
                conditionalSubscriber.onComplete();
            }
        }

        public void b(long j11) {
            T[] tArr = this.f15307b;
            int length = tArr.length;
            int i11 = this.f15308c;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.f15305e;
            do {
                long j12 = 0;
                while (true) {
                    if (j12 == j11 || i11 == length) {
                        if (i11 != length) {
                            j11 = get();
                            if (j12 == j11) {
                                this.f15308c = i11;
                                j11 = addAndGet(-j12);
                            }
                        } else if (!this.f15309d) {
                            conditionalSubscriber.onComplete();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.f15309d) {
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
        public final Subscriber<? super T> f15306e;

        public ArraySubscription(Subscriber<? super T> subscriber, T[] tArr) {
            super(tArr);
            this.f15306e = subscriber;
        }

        public void a() {
            T[] tArr = this.f15307b;
            int length = tArr.length;
            Subscriber<? super T> subscriber = this.f15306e;
            int i11 = this.f15308c;
            while (i11 != length) {
                if (!this.f15309d) {
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
            if (!this.f15309d) {
                subscriber.onComplete();
            }
        }

        public void b(long j11) {
            T[] tArr = this.f15307b;
            int length = tArr.length;
            int i11 = this.f15308c;
            Subscriber<? super T> subscriber = this.f15306e;
            do {
                long j12 = 0;
                while (true) {
                    if (j12 == j11 || i11 == length) {
                        if (i11 != length) {
                            j11 = get();
                            if (j12 == j11) {
                                this.f15308c = i11;
                                j11 = addAndGet(-j12);
                            }
                        } else if (!this.f15309d) {
                            subscriber.onComplete();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.f15309d) {
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
        public final T[] f15307b;

        /* renamed from: c  reason: collision with root package name */
        public int f15308c;

        /* renamed from: d  reason: collision with root package name */
        public volatile boolean f15309d;

        public BaseArraySubscription(T[] tArr) {
            this.f15307b = tArr;
        }

        public abstract void a();

        public abstract void b(long j11);

        public final void cancel() {
            this.f15309d = true;
        }

        public final void clear() {
            this.f15308c = this.f15307b.length;
        }

        public final boolean isEmpty() {
            return this.f15308c == this.f15307b.length;
        }

        @Nullable
        public final T poll() {
            int i11 = this.f15308c;
            T[] tArr = this.f15307b;
            if (i11 == tArr.length) {
                return null;
            }
            this.f15308c = i11 + 1;
            return ObjectHelper.requireNonNull(tArr[i11], "array element is null");
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
        this.f15304c = tArr;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            subscriber.onSubscribe(new ArrayConditionalSubscription((ConditionalSubscriber) subscriber, this.f15304c));
        } else {
            subscriber.onSubscribe(new ArraySubscription(subscriber, this.f15304c));
        }
    }
}
