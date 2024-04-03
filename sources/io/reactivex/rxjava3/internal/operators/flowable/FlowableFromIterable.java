package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import java.util.Iterator;
import java.util.Objects;
import org.reactivestreams.Subscriber;

public final class FlowableFromIterable<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final Iterable<? extends T> f19829c;

    public static abstract class BaseRangeSubscription<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -2252972430506210021L;

        /* renamed from: b  reason: collision with root package name */
        public Iterator<? extends T> f19830b;

        /* renamed from: c  reason: collision with root package name */
        public volatile boolean f19831c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f19832d;

        public BaseRangeSubscription(Iterator<? extends T> it) {
            this.f19830b = it;
        }

        public abstract void a();

        public abstract void b(long j11);

        public final void cancel() {
            this.f19831c = true;
        }

        public final void clear() {
            this.f19830b = null;
        }

        public final boolean isEmpty() {
            Iterator<? extends T> it = this.f19830b;
            if (it == null) {
                return true;
            }
            if (!this.f19832d || it.hasNext()) {
                return false;
            }
            clear();
            return true;
        }

        @Nullable
        public final T poll() {
            Iterator<? extends T> it = this.f19830b;
            if (it == null) {
                return null;
            }
            if (!this.f19832d) {
                this.f19832d = true;
            } else if (!it.hasNext()) {
                return null;
            }
            T next = this.f19830b.next();
            Objects.requireNonNull(next, "Iterator.next() returned a null value");
            return next;
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
        public final ConditionalSubscriber<? super T> f19833e;

        public IteratorConditionalSubscription(ConditionalSubscriber<? super T> conditionalSubscriber, Iterator<? extends T> it) {
            super(it);
            this.f19833e = conditionalSubscriber;
        }

        public void a() {
            Iterator<? extends T> it = this.f19830b;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.f19833e;
            while (!this.f19831c) {
                try {
                    Object next = it.next();
                    if (!this.f19831c) {
                        if (next == null) {
                            conditionalSubscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                            return;
                        }
                        conditionalSubscriber.tryOnNext(next);
                        if (!this.f19831c) {
                            try {
                                if (!it.hasNext()) {
                                    if (!this.f19831c) {
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
            Iterator<? extends T> it = this.f19830b;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.f19833e;
            do {
                long j12 = 0;
                while (true) {
                    if (j12 == j11) {
                        j11 = get();
                        if (j12 == j11) {
                            j11 = addAndGet(-j12);
                        }
                    } else if (!this.f19831c) {
                        try {
                            Object next = it.next();
                            if (!this.f19831c) {
                                if (next == null) {
                                    conditionalSubscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                                    return;
                                }
                                boolean tryOnNext = conditionalSubscriber.tryOnNext(next);
                                if (!this.f19831c) {
                                    try {
                                        if (!it.hasNext()) {
                                            if (!this.f19831c) {
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
        public final Subscriber<? super T> f19834e;

        public IteratorSubscription(Subscriber<? super T> subscriber, Iterator<? extends T> it) {
            super(it);
            this.f19834e = subscriber;
        }

        public void a() {
            Iterator<? extends T> it = this.f19830b;
            Subscriber<? super T> subscriber = this.f19834e;
            while (!this.f19831c) {
                try {
                    Object next = it.next();
                    if (!this.f19831c) {
                        if (next == null) {
                            subscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                            return;
                        }
                        subscriber.onNext(next);
                        if (!this.f19831c) {
                            try {
                                if (!it.hasNext()) {
                                    if (!this.f19831c) {
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
            Iterator<? extends T> it = this.f19830b;
            Subscriber<? super T> subscriber = this.f19834e;
            do {
                long j12 = 0;
                while (true) {
                    if (j12 == j11) {
                        j11 = get();
                        if (j12 == j11) {
                            j11 = addAndGet(-j12);
                        }
                    } else if (!this.f19831c) {
                        try {
                            Object next = it.next();
                            if (!this.f19831c) {
                                if (next == null) {
                                    subscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                                    return;
                                }
                                subscriber.onNext(next);
                                if (!this.f19831c) {
                                    try {
                                        if (it.hasNext()) {
                                            j12++;
                                        } else if (!this.f19831c) {
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
        this.f19829c = iterable;
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
            subscribe(subscriber, this.f19829c.iterator());
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptySubscription.error(th2, subscriber);
        }
    }
}
