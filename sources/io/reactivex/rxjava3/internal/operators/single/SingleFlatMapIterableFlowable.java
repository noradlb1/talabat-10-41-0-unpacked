package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;

public final class SingleFlatMapIterableFlowable<T, R> extends Flowable<R> {

    /* renamed from: c  reason: collision with root package name */
    public final SingleSource<T> f22879c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends Iterable<? extends R>> f22880d;

    public static final class FlatMapIterableObserver<T, R> extends BasicIntQueueSubscription<R> implements SingleObserver<T> {
        private static final long serialVersionUID = -8938804753851907758L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f22881b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends Iterable<? extends R>> f22882c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicLong f22883d = new AtomicLong();

        /* renamed from: e  reason: collision with root package name */
        public Disposable f22884e;

        /* renamed from: f  reason: collision with root package name */
        public volatile Iterator<? extends R> f22885f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f22886g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f22887h;

        public FlatMapIterableObserver(Subscriber<? super R> subscriber, Function<? super T, ? extends Iterable<? extends R>> function) {
            this.f22881b = subscriber;
            this.f22882c = function;
        }

        public void a(Subscriber<? super R> subscriber, Iterator<? extends R> it) {
            while (!this.f22886g) {
                try {
                    subscriber.onNext(it.next());
                    if (!this.f22886g) {
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
            this.f22886g = true;
            this.f22884e.dispose();
            this.f22884e = DisposableHelper.DISPOSED;
        }

        public void clear() {
            this.f22885f = null;
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                Subscriber<? super R> subscriber = this.f22881b;
                Iterator<? extends R> it = this.f22885f;
                if (!this.f22887h || it == null) {
                    int i11 = 1;
                    while (true) {
                        if (it != null) {
                            long j11 = this.f22883d.get();
                            if (j11 == Long.MAX_VALUE) {
                                a(subscriber, it);
                                return;
                            }
                            long j12 = 0;
                            while (j12 != j11) {
                                if (!this.f22886g) {
                                    try {
                                        Object next = it.next();
                                        Objects.requireNonNull(next, "The iterator returned a null value");
                                        subscriber.onNext(next);
                                        if (!this.f22886g) {
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
                                BackpressureHelper.produced(this.f22883d, j12);
                            }
                        }
                        i11 = addAndGet(-i11);
                        if (i11 != 0) {
                            if (it == null) {
                                it = this.f22885f;
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
            return this.f22885f == null;
        }

        public void onError(Throwable th2) {
            this.f22884e = DisposableHelper.DISPOSED;
            this.f22881b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22884e, disposable)) {
                this.f22884e = disposable;
                this.f22881b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            try {
                Iterator<? extends R> it = ((Iterable) this.f22882c.apply(t11)).iterator();
                if (!it.hasNext()) {
                    this.f22881b.onComplete();
                    return;
                }
                this.f22885f = it;
                drain();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f22881b.onError(th2);
            }
        }

        @Nullable
        public R poll() {
            Iterator<? extends R> it = this.f22885f;
            if (it == null) {
                return null;
            }
            R next = it.next();
            Objects.requireNonNull(next, "The iterator returned a null value");
            if (!it.hasNext()) {
                this.f22885f = null;
            }
            return next;
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f22883d, j11);
                drain();
            }
        }

        public int requestFusion(int i11) {
            if ((i11 & 2) == 0) {
                return 0;
            }
            this.f22887h = true;
            return 2;
        }
    }

    public SingleFlatMapIterableFlowable(SingleSource<T> singleSource, Function<? super T, ? extends Iterable<? extends R>> function) {
        this.f22879c = singleSource;
        this.f22880d = function;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f22879c.subscribe(new FlatMapIterableObserver(subscriber, this.f22880d));
    }
}
