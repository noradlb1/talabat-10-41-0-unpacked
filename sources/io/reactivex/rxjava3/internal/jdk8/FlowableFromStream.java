package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import io.reactivex.rxjava3.operators.QueueSubscription;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.stream.Stream;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;

public final class FlowableFromStream<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final Stream<T> f18860c;

    public static abstract class AbstractStreamSubscription<T> extends AtomicLong implements QueueSubscription<T> {
        private static final long serialVersionUID = -9082954702547571853L;

        /* renamed from: b  reason: collision with root package name */
        public Iterator<T> f18861b;

        /* renamed from: c  reason: collision with root package name */
        public AutoCloseable f18862c;

        /* renamed from: d  reason: collision with root package name */
        public volatile boolean f18863d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f18864e;

        public AbstractStreamSubscription(Iterator<T> it, AutoCloseable autoCloseable) {
            this.f18861b = it;
            this.f18862c = autoCloseable;
        }

        public void cancel() {
            this.f18863d = true;
            request(1);
        }

        public void clear() {
            this.f18861b = null;
            AutoCloseable autoCloseable = this.f18862c;
            this.f18862c = null;
            if (autoCloseable != null) {
                FlowableFromStream.b(autoCloseable);
            }
        }

        public boolean isEmpty() {
            Iterator<T> it = this.f18861b;
            if (it == null) {
                return true;
            }
            if (!this.f18864e || it.hasNext()) {
                return false;
            }
            clear();
            return true;
        }

        public boolean offer(@NonNull T t11) {
            throw new UnsupportedOperationException();
        }

        @Nullable
        public T poll() {
            Iterator<T> it = this.f18861b;
            if (it == null) {
                return null;
            }
            if (!this.f18864e) {
                this.f18864e = true;
            } else if (!it.hasNext()) {
                clear();
                return null;
            }
            T next = this.f18861b.next();
            Objects.requireNonNull(next, "The Stream's Iterator.next() returned a null value");
            return next;
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11) && BackpressureHelper.add(this, j11) == 0) {
                run(j11);
            }
        }

        public int requestFusion(int i11) {
            if ((i11 & 1) == 0) {
                return 0;
            }
            lazySet(Long.MAX_VALUE);
            return 1;
        }

        public abstract void run(long j11);

        public boolean offer(@NonNull T t11, @NonNull T t12) {
            throw new UnsupportedOperationException();
        }
    }

    public static final class StreamConditionalSubscription<T> extends AbstractStreamSubscription<T> {
        private static final long serialVersionUID = -9082954702547571853L;

        /* renamed from: f  reason: collision with root package name */
        public final ConditionalSubscriber<? super T> f18865f;

        public StreamConditionalSubscription(ConditionalSubscriber<? super T> conditionalSubscriber, Iterator<T> it, AutoCloseable autoCloseable) {
            super(it, autoCloseable);
            this.f18865f = conditionalSubscriber;
        }

        public void run(long j11) {
            Iterator<T> it = this.f18861b;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.f18865f;
            long j12 = 0;
            while (!this.f18863d) {
                try {
                    T next = it.next();
                    Objects.requireNonNull(next, "The Stream's Iterator returned a null value");
                    if (conditionalSubscriber.tryOnNext(next)) {
                        j12++;
                    }
                    if (this.f18863d) {
                        continue;
                    } else {
                        try {
                            if (!it.hasNext()) {
                                conditionalSubscriber.onComplete();
                                this.f18863d = true;
                            } else if (j12 != j11) {
                                continue;
                            } else {
                                j11 = get();
                                if (j12 != j11) {
                                    continue;
                                } else if (!compareAndSet(j11, 0)) {
                                    j11 = get();
                                } else {
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            conditionalSubscriber.onError(th2);
                            this.f18863d = true;
                        }
                    }
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    conditionalSubscriber.onError(th3);
                    this.f18863d = true;
                }
            }
            clear();
        }
    }

    public static final class StreamSubscription<T> extends AbstractStreamSubscription<T> {
        private static final long serialVersionUID = -9082954702547571853L;

        /* renamed from: f  reason: collision with root package name */
        public final Subscriber<? super T> f18866f;

        public StreamSubscription(Subscriber<? super T> subscriber, Iterator<T> it, AutoCloseable autoCloseable) {
            super(it, autoCloseable);
            this.f18866f = subscriber;
        }

        public void run(long j11) {
            Iterator<T> it = this.f18861b;
            Subscriber<? super T> subscriber = this.f18866f;
            long j12 = 0;
            while (!this.f18863d) {
                try {
                    T next = it.next();
                    Objects.requireNonNull(next, "The Stream's Iterator returned a null value");
                    subscriber.onNext(next);
                    if (this.f18863d) {
                        continue;
                    } else {
                        try {
                            if (!it.hasNext()) {
                                subscriber.onComplete();
                                this.f18863d = true;
                            } else {
                                j12++;
                                if (j12 != j11) {
                                    continue;
                                } else {
                                    j11 = get();
                                    if (j12 != j11) {
                                        continue;
                                    } else if (!compareAndSet(j11, 0)) {
                                        j11 = get();
                                    } else {
                                        return;
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            subscriber.onError(th2);
                            this.f18863d = true;
                        }
                    }
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    subscriber.onError(th3);
                    this.f18863d = true;
                }
            }
            clear();
        }
    }

    public FlowableFromStream(Stream<T> stream) {
        this.f18860c = stream;
    }

    public static void b(AutoCloseable autoCloseable) {
        try {
            autoCloseable.close();
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(th2);
        }
    }

    public static <T> void subscribeStream(Subscriber<? super T> subscriber, Stream<T> stream) {
        try {
            Iterator<T> it = stream.iterator();
            if (!it.hasNext()) {
                EmptySubscription.complete(subscriber);
                b(stream);
            } else if (subscriber instanceof ConditionalSubscriber) {
                subscriber.onSubscribe(new StreamConditionalSubscription((ConditionalSubscriber) subscriber, it, stream));
            } else {
                subscriber.onSubscribe(new StreamSubscription(subscriber, it, stream));
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptySubscription.error(th2, subscriber);
            b(stream);
        }
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        subscribeStream(subscriber, this.f18860c);
    }
}
