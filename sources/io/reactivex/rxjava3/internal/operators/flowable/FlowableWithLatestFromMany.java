package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWithLatestFromMany<T, R> extends AbstractFlowableWithUpstream<T, R> {
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final Publisher<?>[] f20721d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public final Iterable<? extends Publisher<?>> f20722e;

    /* renamed from: f  reason: collision with root package name */
    public final Function<? super Object[], R> f20723f;

    public final class SingletonArrayFunc implements Function<T, R> {
        public SingletonArrayFunc() {
        }

        public R apply(T t11) throws Throwable {
            R apply = FlowableWithLatestFromMany.this.f20723f.apply(new Object[]{t11});
            Objects.requireNonNull(apply, "The combiner returned a null value");
            return apply;
        }
    }

    public static final class WithLatestFromSubscriber<T, R> extends AtomicInteger implements ConditionalSubscriber<T>, Subscription {
        private static final long serialVersionUID = 1577321883966341961L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f20725b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super Object[], R> f20726c;

        /* renamed from: d  reason: collision with root package name */
        public final WithLatestInnerSubscriber[] f20727d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReferenceArray<Object> f20728e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicReference<Subscription> f20729f;

        /* renamed from: g  reason: collision with root package name */
        public final AtomicLong f20730g;

        /* renamed from: h  reason: collision with root package name */
        public final AtomicThrowable f20731h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f20732i;

        public WithLatestFromSubscriber(Subscriber<? super R> subscriber, Function<? super Object[], R> function, int i11) {
            this.f20725b = subscriber;
            this.f20726c = function;
            WithLatestInnerSubscriber[] withLatestInnerSubscriberArr = new WithLatestInnerSubscriber[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                withLatestInnerSubscriberArr[i12] = new WithLatestInnerSubscriber(this, i12);
            }
            this.f20727d = withLatestInnerSubscriberArr;
            this.f20728e = new AtomicReferenceArray<>(i11);
            this.f20729f = new AtomicReference<>();
            this.f20730g = new AtomicLong();
            this.f20731h = new AtomicThrowable();
        }

        public void a(int i11) {
            WithLatestInnerSubscriber[] withLatestInnerSubscriberArr = this.f20727d;
            for (int i12 = 0; i12 < withLatestInnerSubscriberArr.length; i12++) {
                if (i12 != i11) {
                    withLatestInnerSubscriberArr[i12].a();
                }
            }
        }

        public void b(int i11, boolean z11) {
            if (!z11) {
                this.f20732i = true;
                SubscriptionHelper.cancel(this.f20729f);
                a(i11);
                HalfSerializer.onComplete((Subscriber<?>) this.f20725b, (AtomicInteger) this, this.f20731h);
            }
        }

        public void c(int i11, Throwable th2) {
            this.f20732i = true;
            SubscriptionHelper.cancel(this.f20729f);
            a(i11);
            HalfSerializer.onError((Subscriber<?>) this.f20725b, th2, (AtomicInteger) this, this.f20731h);
        }

        public void cancel() {
            SubscriptionHelper.cancel(this.f20729f);
            for (WithLatestInnerSubscriber a11 : this.f20727d) {
                a11.a();
            }
        }

        public void d(int i11, Object obj) {
            this.f20728e.set(i11, obj);
        }

        public void e(Publisher<?>[] publisherArr, int i11) {
            WithLatestInnerSubscriber[] withLatestInnerSubscriberArr = this.f20727d;
            AtomicReference<Subscription> atomicReference = this.f20729f;
            for (int i12 = 0; i12 < i11 && atomicReference.get() != SubscriptionHelper.CANCELLED; i12++) {
                publisherArr[i12].subscribe(withLatestInnerSubscriberArr[i12]);
            }
        }

        public void onComplete() {
            if (!this.f20732i) {
                this.f20732i = true;
                a(-1);
                HalfSerializer.onComplete((Subscriber<?>) this.f20725b, (AtomicInteger) this, this.f20731h);
            }
        }

        public void onError(Throwable th2) {
            if (this.f20732i) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f20732i = true;
            a(-1);
            HalfSerializer.onError((Subscriber<?>) this.f20725b, th2, (AtomicInteger) this, this.f20731h);
        }

        public void onNext(T t11) {
            if (!tryOnNext(t11) && !this.f20732i) {
                this.f20729f.get().request(1);
            }
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.f20729f, this.f20730g, subscription);
        }

        public void request(long j11) {
            SubscriptionHelper.deferredRequest(this.f20729f, this.f20730g, j11);
        }

        public boolean tryOnNext(T t11) {
            if (this.f20732i) {
                return false;
            }
            AtomicReferenceArray<Object> atomicReferenceArray = this.f20728e;
            int length = atomicReferenceArray.length();
            Object[] objArr = new Object[(length + 1)];
            objArr[0] = t11;
            int i11 = 0;
            while (i11 < length) {
                Object obj = atomicReferenceArray.get(i11);
                if (obj == null) {
                    return false;
                }
                i11++;
                objArr[i11] = obj;
            }
            try {
                R apply = this.f20726c.apply(objArr);
                Objects.requireNonNull(apply, "The combiner returned a null value");
                HalfSerializer.onNext(this.f20725b, apply, (AtomicInteger) this, this.f20731h);
                return true;
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                cancel();
                onError(th2);
                return false;
            }
        }
    }

    public static final class WithLatestInnerSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
        private static final long serialVersionUID = 3256684027868224024L;

        /* renamed from: b  reason: collision with root package name */
        public final WithLatestFromSubscriber<?, ?> f20733b;

        /* renamed from: c  reason: collision with root package name */
        public final int f20734c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f20735d;

        public WithLatestInnerSubscriber(WithLatestFromSubscriber<?, ?> withLatestFromSubscriber, int i11) {
            this.f20733b = withLatestFromSubscriber;
            this.f20734c = i11;
        }

        public void a() {
            SubscriptionHelper.cancel(this);
        }

        public void onComplete() {
            this.f20733b.b(this.f20734c, this.f20735d);
        }

        public void onError(Throwable th2) {
            this.f20733b.c(this.f20734c, th2);
        }

        public void onNext(Object obj) {
            if (!this.f20735d) {
                this.f20735d = true;
            }
            this.f20733b.d(this.f20734c, obj);
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    public FlowableWithLatestFromMany(@NonNull Flowable<T> flowable, @NonNull Publisher<?>[] publisherArr, Function<? super Object[], R> function) {
        super(flowable);
        this.f20721d = publisherArr;
        this.f20722e = null;
        this.f20723f = function;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        int i11;
        Publisher<?>[] publisherArr = this.f20721d;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            try {
                i11 = 0;
                for (Publisher<?> publisher : this.f20722e) {
                    if (i11 == publisherArr.length) {
                        publisherArr = (Publisher[]) Arrays.copyOf(publisherArr, (i11 >> 1) + i11);
                    }
                    int i12 = i11 + 1;
                    publisherArr[i11] = publisher;
                    i11 = i12;
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                EmptySubscription.error(th2, subscriber);
                return;
            }
        } else {
            i11 = publisherArr.length;
        }
        if (i11 == 0) {
            new FlowableMap(this.f19260c, new SingletonArrayFunc()).subscribeActual(subscriber);
            return;
        }
        WithLatestFromSubscriber withLatestFromSubscriber = new WithLatestFromSubscriber(subscriber, this.f20723f, i11);
        subscriber.onSubscribe(withLatestFromSubscriber);
        withLatestFromSubscriber.e(publisherArr, i11);
        this.f19260c.subscribe(withLatestFromSubscriber);
    }

    public FlowableWithLatestFromMany(@NonNull Flowable<T> flowable, @NonNull Iterable<? extends Publisher<?>> iterable, @NonNull Function<? super Object[], R> function) {
        super(flowable);
        this.f20721d = null;
        this.f20722e = iterable;
        this.f20723f = function;
    }
}
