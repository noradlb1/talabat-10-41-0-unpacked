package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;

public final class MaybeFlatMapIterableFlowable<T, R> extends Flowable<R> {

    /* renamed from: c  reason: collision with root package name */
    public final MaybeSource<T> f16390c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends Iterable<? extends R>> f16391d;

    public static final class FlatMapIterableObserver<T, R> extends BasicIntQueueSubscription<R> implements MaybeObserver<T> {
        private static final long serialVersionUID = -8938804753851907758L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f16392b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends Iterable<? extends R>> f16393c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicLong f16394d = new AtomicLong();

        /* renamed from: e  reason: collision with root package name */
        public Disposable f16395e;

        /* renamed from: f  reason: collision with root package name */
        public volatile Iterator<? extends R> f16396f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f16397g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f16398h;

        public FlatMapIterableObserver(Subscriber<? super R> subscriber, Function<? super T, ? extends Iterable<? extends R>> function) {
            this.f16392b = subscriber;
            this.f16393c = function;
        }

        public void a(Subscriber<? super R> subscriber, Iterator<? extends R> it) {
            while (!this.f16397g) {
                try {
                    subscriber.onNext(it.next());
                    if (!this.f16397g) {
                        try {
                            if (!it.hasNext()) {
                                subscriber.onComplete();
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
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    subscriber.onError(th3);
                    return;
                }
            }
        }

        public void cancel() {
            this.f16397g = true;
            this.f16395e.dispose();
            this.f16395e = DisposableHelper.DISPOSED;
        }

        public void clear() {
            this.f16396f = null;
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                Subscriber<? super R> subscriber = this.f16392b;
                Iterator<? extends R> it = this.f16396f;
                if (!this.f16398h || it == null) {
                    int i11 = 1;
                    while (true) {
                        if (it != null) {
                            long j11 = this.f16394d.get();
                            if (j11 == Long.MAX_VALUE) {
                                a(subscriber, it);
                                return;
                            }
                            long j12 = 0;
                            while (j12 != j11) {
                                if (!this.f16397g) {
                                    try {
                                        subscriber.onNext(ObjectHelper.requireNonNull(it.next(), "The iterator returned a null value"));
                                        if (!this.f16397g) {
                                            j12++;
                                            try {
                                                if (!it.hasNext()) {
                                                    subscriber.onComplete();
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
                                    } catch (Throwable th3) {
                                        Exceptions.throwIfFatal(th3);
                                        subscriber.onError(th3);
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            }
                            if (j12 != 0) {
                                BackpressureHelper.produced(this.f16394d, j12);
                            }
                        }
                        i11 = addAndGet(-i11);
                        if (i11 != 0) {
                            if (it == null) {
                                it = this.f16396f;
                            }
                        } else {
                            return;
                        }
                    }
                } else {
                    subscriber.onNext(null);
                    subscriber.onComplete();
                }
            }
        }

        public boolean isEmpty() {
            return this.f16396f == null;
        }

        public void onComplete() {
            this.f16392b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f16395e = DisposableHelper.DISPOSED;
            this.f16392b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16395e, disposable)) {
                this.f16395e = disposable;
                this.f16392b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            try {
                Iterator<? extends R> it = ((Iterable) this.f16393c.apply(t11)).iterator();
                if (!it.hasNext()) {
                    this.f16392b.onComplete();
                    return;
                }
                this.f16396f = it;
                drain();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f16392b.onError(th2);
            }
        }

        @Nullable
        public R poll() throws Exception {
            Iterator<? extends R> it = this.f16396f;
            if (it == null) {
                return null;
            }
            R requireNonNull = ObjectHelper.requireNonNull(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.f16396f = null;
            }
            return requireNonNull;
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f16394d, j11);
                drain();
            }
        }

        public int requestFusion(int i11) {
            if ((i11 & 2) == 0) {
                return 0;
            }
            this.f16398h = true;
            return 2;
        }
    }

    public MaybeFlatMapIterableFlowable(MaybeSource<T> maybeSource, Function<? super T, ? extends Iterable<? extends R>> function) {
        this.f16390c = maybeSource;
        this.f16391d = function;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f16390c.subscribe(new FlatMapIterableObserver(subscriber, this.f16391d));
    }
}
