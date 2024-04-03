package io.reactivex.internal.operators.mixed;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableConcatMapCompletable<T> extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final Flowable<T> f16594b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends CompletableSource> f16595c;

    /* renamed from: d  reason: collision with root package name */
    public final ErrorMode f16596d;

    /* renamed from: e  reason: collision with root package name */
    public final int f16597e;

    public static final class ConcatMapCompletableObserver<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {
        private static final long serialVersionUID = 3610901111000061034L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f16598b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends CompletableSource> f16599c;

        /* renamed from: d  reason: collision with root package name */
        public final ErrorMode f16600d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicThrowable f16601e = new AtomicThrowable();

        /* renamed from: f  reason: collision with root package name */
        public final ConcatMapInnerObserver f16602f = new ConcatMapInnerObserver(this);

        /* renamed from: g  reason: collision with root package name */
        public final int f16603g;

        /* renamed from: h  reason: collision with root package name */
        public final SimplePlainQueue<T> f16604h;

        /* renamed from: i  reason: collision with root package name */
        public Subscription f16605i;

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f16606j;

        /* renamed from: k  reason: collision with root package name */
        public volatile boolean f16607k;

        /* renamed from: l  reason: collision with root package name */
        public volatile boolean f16608l;

        /* renamed from: m  reason: collision with root package name */
        public int f16609m;

        public static final class ConcatMapInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = 5638352172918776687L;

            /* renamed from: b  reason: collision with root package name */
            public final ConcatMapCompletableObserver<?> f16610b;

            public ConcatMapInnerObserver(ConcatMapCompletableObserver<?> concatMapCompletableObserver) {
                this.f16610b = concatMapCompletableObserver;
            }

            public void a() {
                DisposableHelper.dispose(this);
            }

            public void onComplete() {
                this.f16610b.b();
            }

            public void onError(Throwable th2) {
                this.f16610b.c(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }
        }

        public ConcatMapCompletableObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, ErrorMode errorMode, int i11) {
            this.f16598b = completableObserver;
            this.f16599c = function;
            this.f16600d = errorMode;
            this.f16603g = i11;
            this.f16604h = new SpscArrayQueue(i11);
        }

        public void a() {
            boolean z11;
            if (getAndIncrement() == 0) {
                while (!this.f16608l) {
                    if (!this.f16606j) {
                        if (this.f16600d != ErrorMode.BOUNDARY || this.f16601e.get() == null) {
                            boolean z12 = this.f16607k;
                            T poll = this.f16604h.poll();
                            if (poll == null) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (z12 && z11) {
                                Throwable terminate = this.f16601e.terminate();
                                if (terminate != null) {
                                    this.f16598b.onError(terminate);
                                    return;
                                } else {
                                    this.f16598b.onComplete();
                                    return;
                                }
                            } else if (!z11) {
                                int i11 = this.f16603g;
                                int i12 = i11 - (i11 >> 1);
                                int i13 = this.f16609m + 1;
                                if (i13 == i12) {
                                    this.f16609m = 0;
                                    this.f16605i.request((long) i12);
                                } else {
                                    this.f16609m = i13;
                                }
                                try {
                                    CompletableSource completableSource = (CompletableSource) ObjectHelper.requireNonNull(this.f16599c.apply(poll), "The mapper returned a null CompletableSource");
                                    this.f16606j = true;
                                    completableSource.subscribe(this.f16602f);
                                } catch (Throwable th2) {
                                    Exceptions.throwIfFatal(th2);
                                    this.f16604h.clear();
                                    this.f16605i.cancel();
                                    this.f16601e.addThrowable(th2);
                                    this.f16598b.onError(this.f16601e.terminate());
                                    return;
                                }
                            }
                        } else {
                            this.f16604h.clear();
                            this.f16598b.onError(this.f16601e.terminate());
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                this.f16604h.clear();
            }
        }

        public void b() {
            this.f16606j = false;
            a();
        }

        public void c(Throwable th2) {
            if (!this.f16601e.addThrowable(th2)) {
                RxJavaPlugins.onError(th2);
            } else if (this.f16600d == ErrorMode.IMMEDIATE) {
                this.f16605i.cancel();
                Throwable terminate = this.f16601e.terminate();
                if (terminate != ExceptionHelper.TERMINATED) {
                    this.f16598b.onError(terminate);
                }
                if (getAndIncrement() == 0) {
                    this.f16604h.clear();
                }
            } else {
                this.f16606j = false;
                a();
            }
        }

        public void dispose() {
            this.f16608l = true;
            this.f16605i.cancel();
            this.f16602f.a();
            if (getAndIncrement() == 0) {
                this.f16604h.clear();
            }
        }

        public boolean isDisposed() {
            return this.f16608l;
        }

        public void onComplete() {
            this.f16607k = true;
            a();
        }

        public void onError(Throwable th2) {
            if (!this.f16601e.addThrowable(th2)) {
                RxJavaPlugins.onError(th2);
            } else if (this.f16600d == ErrorMode.IMMEDIATE) {
                this.f16602f.a();
                Throwable terminate = this.f16601e.terminate();
                if (terminate != ExceptionHelper.TERMINATED) {
                    this.f16598b.onError(terminate);
                }
                if (getAndIncrement() == 0) {
                    this.f16604h.clear();
                }
            } else {
                this.f16607k = true;
                a();
            }
        }

        public void onNext(T t11) {
            if (this.f16604h.offer(t11)) {
                a();
                return;
            }
            this.f16605i.cancel();
            onError(new MissingBackpressureException("Queue full?!"));
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f16605i, subscription)) {
                this.f16605i = subscription;
                this.f16598b.onSubscribe(this);
                subscription.request((long) this.f16603g);
            }
        }
    }

    public FlowableConcatMapCompletable(Flowable<T> flowable, Function<? super T, ? extends CompletableSource> function, ErrorMode errorMode, int i11) {
        this.f16594b = flowable;
        this.f16595c = function;
        this.f16596d = errorMode;
        this.f16597e = i11;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f16594b.subscribe(new ConcatMapCompletableObserver(completableObserver, this.f16595c, this.f16596d, this.f16597e));
    }
}
