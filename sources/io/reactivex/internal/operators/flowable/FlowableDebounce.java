package io.reactivex.internal.operators.flowable;

import i.b;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.DisposableSubscriber;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDebounce<T, U> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends Publisher<U>> f15067d;

    public static final class DebounceSubscriber<T, U> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 6725975399620862591L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15068b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends Publisher<U>> f15069c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f15070d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReference<Disposable> f15071e = new AtomicReference<>();

        /* renamed from: f  reason: collision with root package name */
        public volatile long f15072f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f15073g;

        public static final class DebounceInnerSubscriber<T, U> extends DisposableSubscriber<U> {

            /* renamed from: c  reason: collision with root package name */
            public final DebounceSubscriber<T, U> f15074c;

            /* renamed from: d  reason: collision with root package name */
            public final long f15075d;

            /* renamed from: e  reason: collision with root package name */
            public final T f15076e;

            /* renamed from: f  reason: collision with root package name */
            public boolean f15077f;

            /* renamed from: g  reason: collision with root package name */
            public final AtomicBoolean f15078g = new AtomicBoolean();

            public DebounceInnerSubscriber(DebounceSubscriber<T, U> debounceSubscriber, long j11, T t11) {
                this.f15074c = debounceSubscriber;
                this.f15075d = j11;
                this.f15076e = t11;
            }

            public void c() {
                if (this.f15078g.compareAndSet(false, true)) {
                    this.f15074c.a(this.f15075d, this.f15076e);
                }
            }

            public void onComplete() {
                if (!this.f15077f) {
                    this.f15077f = true;
                    c();
                }
            }

            public void onError(Throwable th2) {
                if (this.f15077f) {
                    RxJavaPlugins.onError(th2);
                    return;
                }
                this.f15077f = true;
                this.f15074c.onError(th2);
            }

            public void onNext(U u11) {
                if (!this.f15077f) {
                    this.f15077f = true;
                    a();
                    c();
                }
            }
        }

        public DebounceSubscriber(Subscriber<? super T> subscriber, Function<? super T, ? extends Publisher<U>> function) {
            this.f15068b = subscriber;
            this.f15069c = function;
        }

        public void a(long j11, T t11) {
            if (j11 != this.f15072f) {
                return;
            }
            if (get() != 0) {
                this.f15068b.onNext(t11);
                BackpressureHelper.produced(this, 1);
                return;
            }
            cancel();
            this.f15068b.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
        }

        public void cancel() {
            this.f15070d.cancel();
            DisposableHelper.dispose(this.f15071e);
        }

        public void onComplete() {
            if (!this.f15073g) {
                this.f15073g = true;
                Disposable disposable = this.f15071e.get();
                if (!DisposableHelper.isDisposed(disposable)) {
                    DebounceInnerSubscriber debounceInnerSubscriber = (DebounceInnerSubscriber) disposable;
                    if (debounceInnerSubscriber != null) {
                        debounceInnerSubscriber.c();
                    }
                    DisposableHelper.dispose(this.f15071e);
                    this.f15068b.onComplete();
                }
            }
        }

        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.f15071e);
            this.f15068b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f15073g) {
                long j11 = this.f15072f + 1;
                this.f15072f = j11;
                Disposable disposable = this.f15071e.get();
                if (disposable != null) {
                    disposable.dispose();
                }
                try {
                    Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.f15069c.apply(t11), "The publisher supplied is null");
                    DebounceInnerSubscriber debounceInnerSubscriber = new DebounceInnerSubscriber(this, j11, t11);
                    if (b.a(this.f15071e, disposable, debounceInnerSubscriber)) {
                        publisher.subscribe(debounceInnerSubscriber);
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    cancel();
                    this.f15068b.onError(th2);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15070d, subscription)) {
                this.f15070d = subscription;
                this.f15068b.onSubscribe(this);
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
        this.f15067d = function;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f14763c.subscribe(new DebounceSubscriber(new SerializedSubscriber(subscriber), this.f15067d));
    }
}
