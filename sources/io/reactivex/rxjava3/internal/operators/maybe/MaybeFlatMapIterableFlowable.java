package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
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

public final class MaybeFlatMapIterableFlowable<T, R> extends Flowable<R> {

    /* renamed from: c  reason: collision with root package name */
    public final MaybeSource<T> f20901c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends Iterable<? extends R>> f20902d;

    public static final class FlatMapIterableObserver<T, R> extends BasicIntQueueSubscription<R> implements MaybeObserver<T> {
        private static final long serialVersionUID = -8938804753851907758L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f20903b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends Iterable<? extends R>> f20904c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicLong f20905d = new AtomicLong();

        /* renamed from: e  reason: collision with root package name */
        public Disposable f20906e;

        /* renamed from: f  reason: collision with root package name */
        public volatile Iterator<? extends R> f20907f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f20908g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f20909h;

        public FlatMapIterableObserver(Subscriber<? super R> subscriber, Function<? super T, ? extends Iterable<? extends R>> function) {
            this.f20903b = subscriber;
            this.f20904c = function;
        }

        public void a(Subscriber<? super R> subscriber, Iterator<? extends R> it) {
            while (!this.f20908g) {
                try {
                    subscriber.onNext(it.next());
                    if (!this.f20908g) {
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
            this.f20908g = true;
            this.f20906e.dispose();
            this.f20906e = DisposableHelper.DISPOSED;
        }

        public void clear() {
            this.f20907f = null;
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                Subscriber<? super R> subscriber = this.f20903b;
                Iterator<? extends R> it = this.f20907f;
                if (!this.f20909h || it == null) {
                    int i11 = 1;
                    while (true) {
                        if (it != null) {
                            long j11 = this.f20905d.get();
                            if (j11 == Long.MAX_VALUE) {
                                a(subscriber, it);
                                return;
                            }
                            long j12 = 0;
                            while (j12 != j11) {
                                if (!this.f20908g) {
                                    try {
                                        Object next = it.next();
                                        Objects.requireNonNull(next, "The iterator returned a null value");
                                        subscriber.onNext(next);
                                        if (!this.f20908g) {
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
                                BackpressureHelper.produced(this.f20905d, j12);
                            }
                        }
                        i11 = addAndGet(-i11);
                        if (i11 != 0) {
                            if (it == null) {
                                it = this.f20907f;
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
            return this.f20907f == null;
        }

        public void onComplete() {
            this.f20903b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f20906e = DisposableHelper.DISPOSED;
            this.f20903b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f20906e, disposable)) {
                this.f20906e = disposable;
                this.f20903b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            try {
                Iterator<? extends R> it = ((Iterable) this.f20904c.apply(t11)).iterator();
                if (!it.hasNext()) {
                    this.f20903b.onComplete();
                    return;
                }
                this.f20907f = it;
                drain();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f20903b.onError(th2);
            }
        }

        @Nullable
        public R poll() {
            Iterator<? extends R> it = this.f20907f;
            if (it == null) {
                return null;
            }
            R next = it.next();
            Objects.requireNonNull(next, "The iterator returned a null value");
            if (!it.hasNext()) {
                this.f20907f = null;
            }
            return next;
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f20905d, j11);
                drain();
            }
        }

        public int requestFusion(int i11) {
            if ((i11 & 2) == 0) {
                return 0;
            }
            this.f20909h = true;
            return 2;
        }
    }

    public MaybeFlatMapIterableFlowable(MaybeSource<T> maybeSource, Function<? super T, ? extends Iterable<? extends R>> function) {
        this.f20901c = maybeSource;
        this.f20902d = function;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f20901c.subscribe(new FlatMapIterableObserver(subscriber, this.f20902d));
    }
}
