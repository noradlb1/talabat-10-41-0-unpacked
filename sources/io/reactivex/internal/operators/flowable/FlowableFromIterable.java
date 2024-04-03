package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.Iterator;
import org.reactivestreams.Subscriber;

public final class FlowableFromIterable<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final Iterable<? extends T> f15314c;

    public static abstract class BaseRangeSubscription<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -2252972430506210021L;

        /* renamed from: b  reason: collision with root package name */
        public Iterator<? extends T> f15315b;

        /* renamed from: c  reason: collision with root package name */
        public volatile boolean f15316c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f15317d;

        public BaseRangeSubscription(Iterator<? extends T> it) {
            this.f15315b = it;
        }

        public abstract void a();

        public abstract void b(long j11);

        public final void cancel() {
            this.f15316c = true;
        }

        public final void clear() {
            this.f15315b = null;
        }

        public final boolean isEmpty() {
            Iterator<? extends T> it = this.f15315b;
            return it == null || !it.hasNext();
        }

        @Nullable
        public final T poll() {
            Iterator<? extends T> it = this.f15315b;
            if (it == null) {
                return null;
            }
            if (!this.f15317d) {
                this.f15317d = true;
            } else if (!it.hasNext()) {
                return null;
            }
            return ObjectHelper.requireNonNull(this.f15315b.next(), "Iterator.next() returned a null value");
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

    public static final class IteratorConditionalSubscription<T> extends BaseRangeSubscription<T> {
        private static final long serialVersionUID = -6022804456014692607L;

        /* renamed from: e  reason: collision with root package name */
        public final ConditionalSubscriber<? super T> f15318e;

        public IteratorConditionalSubscription(ConditionalSubscriber<? super T> conditionalSubscriber, Iterator<? extends T> it) {
            super(it);
            this.f15318e = conditionalSubscriber;
        }

        public void a() {
            Iterator<? extends T> it = this.f15315b;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.f15318e;
            while (!this.f15316c) {
                try {
                    Object next = it.next();
                    if (!this.f15316c) {
                        if (next == null) {
                            conditionalSubscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                            return;
                        }
                        conditionalSubscriber.tryOnNext(next);
                        if (!this.f15316c) {
                            try {
                                if (!it.hasNext()) {
                                    if (!this.f15316c) {
                                        conditionalSubscriber.onComplete();
                                        return;
                                    }
                                    return;
                                }
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                conditionalSubscriber.onError(th2);
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    conditionalSubscriber.onError(th3);
                    return;
                }
            }
        }

        public void b(long j11) {
            Iterator<? extends T> it = this.f15315b;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.f15318e;
            do {
                long j12 = 0;
                while (true) {
                    if (j12 == j11) {
                        j11 = get();
                        if (j12 == j11) {
                            j11 = addAndGet(-j12);
                        }
                    } else if (!this.f15316c) {
                        try {
                            Object next = it.next();
                            if (!this.f15316c) {
                                if (next == null) {
                                    conditionalSubscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                                    return;
                                }
                                boolean tryOnNext = conditionalSubscriber.tryOnNext(next);
                                if (!this.f15316c) {
                                    try {
                                        if (!it.hasNext()) {
                                            if (!this.f15316c) {
                                                conditionalSubscriber.onComplete();
                                                return;
                                            }
                                            return;
                                        } else if (tryOnNext) {
                                            j12++;
                                        }
                                    } catch (Throwable th2) {
                                        Exceptions.throwIfFatal(th2);
                                        conditionalSubscriber.onError(th2);
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th3) {
                            Exceptions.throwIfFatal(th3);
                            conditionalSubscriber.onError(th3);
                            return;
                        }
                    } else {
                        return;
                    }
                }
            } while (j11 != 0);
        }
    }

    public static final class IteratorSubscription<T> extends BaseRangeSubscription<T> {
        private static final long serialVersionUID = -6022804456014692607L;

        /* renamed from: e  reason: collision with root package name */
        public final Subscriber<? super T> f15319e;

        public IteratorSubscription(Subscriber<? super T> subscriber, Iterator<? extends T> it) {
            super(it);
            this.f15319e = subscriber;
        }

        public void a() {
            Iterator<? extends T> it = this.f15315b;
            Subscriber<? super T> subscriber = this.f15319e;
            while (!this.f15316c) {
                try {
                    Object next = it.next();
                    if (!this.f15316c) {
                        if (next == null) {
                            subscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                            return;
                        }
                        subscriber.onNext(next);
                        if (!this.f15316c) {
                            try {
                                if (!it.hasNext()) {
                                    if (!this.f15316c) {
                                        subscriber.onComplete();
                                        return;
                                    }
                                    return;
                                }
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                subscriber.onError(th2);
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    subscriber.onError(th3);
                    return;
                }
            }
        }

        public void b(long j11) {
            Iterator<? extends T> it = this.f15315b;
            Subscriber<? super T> subscriber = this.f15319e;
            do {
                long j12 = 0;
                while (true) {
                    if (j12 == j11) {
                        j11 = get();
                        if (j12 == j11) {
                            j11 = addAndGet(-j12);
                        }
                    } else if (!this.f15316c) {
                        try {
                            Object next = it.next();
                            if (!this.f15316c) {
                                if (next == null) {
                                    subscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                                    return;
                                }
                                subscriber.onNext(next);
                                if (!this.f15316c) {
                                    try {
                                        if (it.hasNext()) {
                                            j12++;
                                        } else if (!this.f15316c) {
                                            subscriber.onComplete();
                                            return;
                                        } else {
                                            return;
                                        }
                                    } catch (Throwable th2) {
                                        Exceptions.throwIfFatal(th2);
                                        subscriber.onError(th2);
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th3) {
                            Exceptions.throwIfFatal(th3);
                            subscriber.onError(th3);
                            return;
                        }
                    } else {
                        return;
                    }
                }
            } while (j11 != 0);
        }
    }

    public FlowableFromIterable(Iterable<? extends T> iterable) {
        this.f15314c = iterable;
    }

    public static <T> void subscribe(Subscriber<? super T> subscriber, Iterator<? extends T> it) {
        try {
            if (!it.hasNext()) {
                EmptySubscription.complete(subscriber);
            } else if (subscriber instanceof ConditionalSubscriber) {
                subscriber.onSubscribe(new IteratorConditionalSubscription((ConditionalSubscriber) subscriber, it));
            } else {
                subscriber.onSubscribe(new IteratorSubscription(subscriber, it));
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptySubscription.error(th2, subscriber);
        }
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            subscribe(subscriber, this.f15314c.iterator());
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptySubscription.error(th2, subscriber);
        }
    }
}
