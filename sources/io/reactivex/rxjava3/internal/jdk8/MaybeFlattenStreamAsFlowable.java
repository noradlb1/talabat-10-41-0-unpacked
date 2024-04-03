package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.stream.Stream;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;

public final class MaybeFlattenStreamAsFlowable<T, R> extends Flowable<R> {

    /* renamed from: c  reason: collision with root package name */
    public final Maybe<T> f18877c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends Stream<? extends R>> f18878d;

    public static final class FlattenStreamMultiObserver<T, R> extends BasicIntQueueSubscription<R> implements MaybeObserver<T>, SingleObserver<T> {
        private static final long serialVersionUID = 7363336003027148283L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f18879b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends Stream<? extends R>> f18880c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicLong f18881d = new AtomicLong();

        /* renamed from: e  reason: collision with root package name */
        public Disposable f18882e;

        /* renamed from: f  reason: collision with root package name */
        public volatile Iterator<? extends R> f18883f;

        /* renamed from: g  reason: collision with root package name */
        public AutoCloseable f18884g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f18885h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f18886i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f18887j;

        /* renamed from: k  reason: collision with root package name */
        public long f18888k;

        public FlattenStreamMultiObserver(Subscriber<? super R> subscriber, Function<? super T, ? extends Stream<? extends R>> function) {
            this.f18879b = subscriber;
            this.f18880c = function;
        }

        public void a(AutoCloseable autoCloseable) {
            if (autoCloseable != null) {
                try {
                    autoCloseable.close();
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(th2);
                }
            }
        }

        public void cancel() {
            this.f18886i = true;
            this.f18882e.dispose();
            if (!this.f18887j) {
                drain();
            }
        }

        public void clear() {
            this.f18883f = null;
            AutoCloseable autoCloseable = this.f18884g;
            this.f18884g = null;
            a(autoCloseable);
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                Subscriber<? super R> subscriber = this.f18879b;
                long j11 = this.f18888k;
                long j12 = this.f18881d.get();
                Iterator<? extends R> it = this.f18883f;
                int i11 = 1;
                while (true) {
                    if (this.f18886i) {
                        clear();
                    } else if (this.f18887j) {
                        if (it != null) {
                            subscriber.onNext(null);
                            subscriber.onComplete();
                        }
                    } else if (!(it == null || j11 == j12)) {
                        try {
                            Object next = it.next();
                            if (!this.f18886i) {
                                subscriber.onNext(next);
                                j11++;
                                if (!this.f18886i) {
                                    try {
                                        boolean hasNext = it.hasNext();
                                        if (!this.f18886i && !hasNext) {
                                            subscriber.onComplete();
                                            this.f18886i = true;
                                        }
                                    } catch (Throwable th2) {
                                        Exceptions.throwIfFatal(th2);
                                        subscriber.onError(th2);
                                        this.f18886i = true;
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            Exceptions.throwIfFatal(th3);
                            subscriber.onError(th3);
                            this.f18886i = true;
                        }
                    }
                    this.f18888k = j11;
                    i11 = addAndGet(-i11);
                    if (i11 != 0) {
                        j12 = this.f18881d.get();
                        if (it == null) {
                            it = this.f18883f;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        public boolean isEmpty() {
            Iterator<? extends R> it = this.f18883f;
            if (it == null) {
                return true;
            }
            if (!this.f18885h || it.hasNext()) {
                return false;
            }
            clear();
            return true;
        }

        public void onComplete() {
            this.f18879b.onComplete();
        }

        public void onError(@NonNull Throwable th2) {
            this.f18879b.onError(th2);
        }

        public void onSubscribe(@NonNull Disposable disposable) {
            if (DisposableHelper.validate(this.f18882e, disposable)) {
                this.f18882e = disposable;
                this.f18879b.onSubscribe(this);
            }
        }

        public void onSuccess(@NonNull T t11) {
            try {
                Object apply = this.f18880c.apply(t11);
                Objects.requireNonNull(apply, "The mapper returned a null Stream");
                Stream stream = (Stream) apply;
                Iterator<? extends R> it = stream.iterator();
                if (!it.hasNext()) {
                    this.f18879b.onComplete();
                    a(stream);
                    return;
                }
                this.f18883f = it;
                this.f18884g = stream;
                drain();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f18879b.onError(th2);
            }
        }

        @Nullable
        public R poll() throws Throwable {
            Iterator<? extends R> it = this.f18883f;
            if (it == null) {
                return null;
            }
            if (!this.f18885h) {
                this.f18885h = true;
            } else if (!it.hasNext()) {
                clear();
                return null;
            }
            return it.next();
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f18881d, j11);
                drain();
            }
        }

        public int requestFusion(int i11) {
            if ((i11 & 2) == 0) {
                return 0;
            }
            this.f18887j = true;
            return 2;
        }
    }

    public MaybeFlattenStreamAsFlowable(Maybe<T> maybe, Function<? super T, ? extends Stream<? extends R>> function) {
        this.f18877c = maybe;
        this.f18878d = function;
    }

    public void subscribeActual(@NonNull Subscriber<? super R> subscriber) {
        this.f18877c.subscribe(new FlattenStreamMultiObserver(subscriber, this.f18878d));
    }
}
