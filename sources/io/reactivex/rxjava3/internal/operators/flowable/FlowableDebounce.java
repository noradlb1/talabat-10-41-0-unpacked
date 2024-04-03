package io.reactivex.rxjava3.internal.operators.flowable;

import i.b;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.subscribers.DisposableSubscriber;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDebounce<T, U> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends Publisher<U>> f19573d;

    public static final class DebounceSubscriber<T, U> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 6725975399620862591L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f19574b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends Publisher<U>> f19575c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f19576d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReference<Disposable> f19577e = new AtomicReference<>();

        /* renamed from: f  reason: collision with root package name */
        public volatile long f19578f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f19579g;

        public static final class DebounceInnerSubscriber<T, U> extends DisposableSubscriber<U> {

            /* renamed from: c  reason: collision with root package name */
            public final DebounceSubscriber<T, U> f19580c;

            /* renamed from: d  reason: collision with root package name */
            public final long f19581d;

            /* renamed from: e  reason: collision with root package name */
            public final T f19582e;

            /* renamed from: f  reason: collision with root package name */
            public boolean f19583f;

            /* renamed from: g  reason: collision with root package name */
            public final AtomicBoolean f19584g = new AtomicBoolean();

            public DebounceInnerSubscriber(DebounceSubscriber<T, U> debounceSubscriber, long j11, T t11) {
                this.f19580c = debounceSubscriber;
                this.f19581d = j11;
                this.f19582e = t11;
            }

            public void c() {
                if (this.f19584g.compareAndSet(false, true)) {
                    this.f19580c.a(this.f19581d, this.f19582e);
                }
            }

            public void onComplete() {
                if (!this.f19583f) {
                    this.f19583f = true;
                    c();
                }
            }

            public void onError(Throwable th2) {
                if (this.f19583f) {
                    RxJavaPlugins.onError(th2);
                    return;
                }
                this.f19583f = true;
                this.f19580c.onError(th2);
            }

            public void onNext(U u11) {
                if (!this.f19583f) {
                    this.f19583f = true;
                    a();
                    c();
                }
            }
        }

        public DebounceSubscriber(Subscriber<? super T> subscriber, Function<? super T, ? extends Publisher<U>> function) {
            this.f19574b = subscriber;
            this.f19575c = function;
        }

        public void a(long j11, T t11) {
            if (j11 != this.f19578f) {
                return;
            }
            if (get() != 0) {
                this.f19574b.onNext(t11);
                BackpressureHelper.produced(this, 1);
                return;
            }
            cancel();
            this.f19574b.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
        }

        public void cancel() {
            this.f19576d.cancel();
            DisposableHelper.dispose(this.f19577e);
        }

        public void onComplete() {
            if (!this.f19579g) {
                this.f19579g = true;
                Disposable disposable = this.f19577e.get();
                if (!DisposableHelper.isDisposed(disposable)) {
                    DebounceInnerSubscriber debounceInnerSubscriber = (DebounceInnerSubscriber) disposable;
                    if (debounceInnerSubscriber != null) {
                        debounceInnerSubscriber.c();
                    }
                    DisposableHelper.dispose(this.f19577e);
                    this.f19574b.onComplete();
                }
            }
        }

        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.f19577e);
            this.f19574b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f19579g) {
                long j11 = this.f19578f + 1;
                this.f19578f = j11;
                Disposable disposable = this.f19577e.get();
                if (disposable != null) {
                    disposable.dispose();
                }
                try {
                    Object apply = this.f19575c.apply(t11);
                    Objects.requireNonNull(apply, "The publisher supplied is null");
                    Publisher publisher = (Publisher) apply;
                    DebounceInnerSubscriber debounceInnerSubscriber = new DebounceInnerSubscriber(this, j11, t11);
                    if (b.a(this.f19577e, disposable, debounceInnerSubscriber)) {
                        publisher.subscribe(debounceInnerSubscriber);
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    cancel();
                    this.f19574b.onError(th2);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f19576d, subscription)) {
                this.f19576d = subscription;
                this.f19574b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this, j11);
            }
        }
    }

    public FlowableDebounce(Flowable<T> flowable, Function<? super T, ? extends Publisher<U>> function) {
        super(flowable);
        this.f19573d = function;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f19260c.subscribe(new DebounceSubscriber(new SerializedSubscriber(subscriber), this.f19573d));
    }
}
