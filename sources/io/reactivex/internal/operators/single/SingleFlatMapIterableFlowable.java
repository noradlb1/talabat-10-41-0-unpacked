package io.reactivex.internal.operators.single;

import io.reactivex.Flowable;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
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

public final class SingleFlatMapIterableFlowable<T, R> extends Flowable<R> {

    /* renamed from: c  reason: collision with root package name */
    public final SingleSource<T> f18330c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends Iterable<? extends R>> f18331d;

    public static final class FlatMapIterableObserver<T, R> extends BasicIntQueueSubscription<R> implements SingleObserver<T> {
        private static final long serialVersionUID = -8938804753851907758L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f18332b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends Iterable<? extends R>> f18333c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicLong f18334d = new AtomicLong();

        /* renamed from: e  reason: collision with root package name */
        public Disposable f18335e;

        /* renamed from: f  reason: collision with root package name */
        public volatile Iterator<? extends R> f18336f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f18337g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f18338h;

        public FlatMapIterableObserver(Subscriber<? super R> subscriber, Function<? super T, ? extends Iterable<? extends R>> function) {
            this.f18332b = subscriber;
            this.f18333c = function;
        }

        public void a(Subscriber<? super R> subscriber, Iterator<? extends R> it) {
            while (!this.f18337g) {
                try {
                    subscriber.onNext(it.next());
                    if (!this.f18337g) {
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
            this.f18337g = true;
            this.f18335e.dispose();
            this.f18335e = DisposableHelper.DISPOSED;
        }

        public void clear() {
            this.f18336f = null;
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                Subscriber<? super R> subscriber = this.f18332b;
                Iterator<? extends R> it = this.f18336f;
                if (!this.f18338h || it == null) {
                    int i11 = 1;
                    while (true) {
                        if (it != null) {
                            long j11 = this.f18334d.get();
                            if (j11 == Long.MAX_VALUE) {
                                a(subscriber, it);
                                return;
                            }
                            long j12 = 0;
                            while (j12 != j11) {
                                if (!this.f18337g) {
                                    try {
                                        subscriber.onNext(ObjectHelper.requireNonNull(it.next(), "The iterator returned a null value"));
                                        if (!this.f18337g) {
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
                                BackpressureHelper.produced(this.f18334d, j12);
                            }
                        }
                        i11 = addAndGet(-i11);
                        if (i11 != 0) {
                            if (it == null) {
                                it = this.f18336f;
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
            return this.f18336f == null;
        }

        public void onError(Throwable th2) {
            this.f18335e = DisposableHelper.DISPOSED;
            this.f18332b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f18335e, disposable)) {
                this.f18335e = disposable;
                this.f18332b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            try {
                Iterator<? extends R> it = ((Iterable) this.f18333c.apply(t11)).iterator();
                if (!it.hasNext()) {
                    this.f18332b.onComplete();
                    return;
                }
                this.f18336f = it;
                drain();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f18332b.onError(th2);
            }
        }

        @Nullable
        public R poll() throws Exception {
            Iterator<? extends R> it = this.f18336f;
            if (it == null) {
                return null;
            }
            R requireNonNull = ObjectHelper.requireNonNull(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.f18336f = null;
            }
            return requireNonNull;
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f18334d, j11);
                drain();
            }
        }

        public int requestFusion(int i11) {
            if ((i11 & 2) == 0) {
                return 0;
            }
            this.f18338h = true;
            return 2;
        }
    }

    public SingleFlatMapIterableFlowable(SingleSource<T> singleSource, Function<? super T, ? extends Iterable<? extends R>> function) {
        this.f18330c = singleSource;
        this.f18331d = function;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f18330c.subscribe(new FlatMapIterableObserver(subscriber, this.f18331d));
    }
}
