package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
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
    public final Publisher<?>[] f16222d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public final Iterable<? extends Publisher<?>> f16223e;

    /* renamed from: f  reason: collision with root package name */
    public final Function<? super Object[], R> f16224f;

    public final class SingletonArrayFunc implements Function<T, R> {
        public SingletonArrayFunc() {
        }

        public R apply(T t11) throws Exception {
            return ObjectHelper.requireNonNull(FlowableWithLatestFromMany.this.f16224f.apply(new Object[]{t11}), "The combiner returned a null value");
        }
    }

    public static final class WithLatestFromSubscriber<T, R> extends AtomicInteger implements ConditionalSubscriber<T>, Subscription {
        private static final long serialVersionUID = 1577321883966341961L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f16226b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super Object[], R> f16227c;

        /* renamed from: d  reason: collision with root package name */
        public final WithLatestInnerSubscriber[] f16228d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReferenceArray<Object> f16229e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicReference<Subscription> f16230f;

        /* renamed from: g  reason: collision with root package name */
        public final AtomicLong f16231g;

        /* renamed from: h  reason: collision with root package name */
        public final AtomicThrowable f16232h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f16233i;

        public WithLatestFromSubscriber(Subscriber<? super R> subscriber, Function<? super Object[], R> function, int i11) {
            this.f16226b = subscriber;
            this.f16227c = function;
            WithLatestInnerSubscriber[] withLatestInnerSubscriberArr = new WithLatestInnerSubscriber[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                withLatestInnerSubscriberArr[i12] = new WithLatestInnerSubscriber(this, i12);
            }
            this.f16228d = withLatestInnerSubscriberArr;
            this.f16229e = new AtomicReferenceArray<>(i11);
            this.f16230f = new AtomicReference<>();
            this.f16231g = new AtomicLong();
            this.f16232h = new AtomicThrowable();
        }

        public void a(int i11) {
            WithLatestInnerSubscriber[] withLatestInnerSubscriberArr = this.f16228d;
            for (int i12 = 0; i12 < withLatestInnerSubscriberArr.length; i12++) {
                if (i12 != i11) {
                    withLatestInnerSubscriberArr[i12].a();
                }
            }
        }

        public void b(int i11, boolean z11) {
            if (!z11) {
                this.f16233i = true;
                SubscriptionHelper.cancel(this.f16230f);
                a(i11);
                HalfSerializer.onComplete((Subscriber<?>) this.f16226b, (AtomicInteger) this, this.f16232h);
            }
        }

        public void c(int i11, Throwable th2) {
            this.f16233i = true;
            SubscriptionHelper.cancel(this.f16230f);
            a(i11);
            HalfSerializer.onError((Subscriber<?>) this.f16226b, th2, (AtomicInteger) this, this.f16232h);
        }

        public void cancel() {
            SubscriptionHelper.cancel(this.f16230f);
            for (WithLatestInnerSubscriber a11 : this.f16228d) {
                a11.a();
            }
        }

        public void d(int i11, Object obj) {
            this.f16229e.set(i11, obj);
        }

        public void e(Publisher<?>[] publisherArr, int i11) {
            WithLatestInnerSubscriber[] withLatestInnerSubscriberArr = this.f16228d;
            AtomicReference<Subscription> atomicReference = this.f16230f;
            for (int i12 = 0; i12 < i11 && atomicReference.get() != SubscriptionHelper.CANCELLED; i12++) {
                publisherArr[i12].subscribe(withLatestInnerSubscriberArr[i12]);
            }
        }

        public void onComplete() {
            if (!this.f16233i) {
                this.f16233i = true;
                a(-1);
                HalfSerializer.onComplete((Subscriber<?>) this.f16226b, (AtomicInteger) this, this.f16232h);
            }
        }

        public void onError(Throwable th2) {
            if (this.f16233i) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f16233i = true;
            a(-1);
            HalfSerializer.onError((Subscriber<?>) this.f16226b, th2, (AtomicInteger) this, this.f16232h);
        }

        public void onNext(T t11) {
            if (!tryOnNext(t11) && !this.f16233i) {
                this.f16230f.get().request(1);
            }
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.f16230f, this.f16231g, subscription);
        }

        public void request(long j11) {
            SubscriptionHelper.deferredRequest(this.f16230f, this.f16231g, j11);
        }

        public boolean tryOnNext(T t11) {
            if (this.f16233i) {
                return false;
            }
            AtomicReferenceArray<Object> atomicReferenceArray = this.f16229e;
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
                HalfSerializer.onNext(this.f16226b, ObjectHelper.requireNonNull(this.f16227c.apply(objArr), "The combiner returned a null value"), (AtomicInteger) this, this.f16232h);
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
        public final WithLatestFromSubscriber<?, ?> f16234b;

        /* renamed from: c  reason: collision with root package name */
        public final int f16235c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f16236d;

        public WithLatestInnerSubscriber(WithLatestFromSubscriber<?, ?> withLatestFromSubscriber, int i11) {
            this.f16234b = withLatestFromSubscriber;
            this.f16235c = i11;
        }

        public void a() {
            SubscriptionHelper.cancel(this);
        }

        public void onComplete() {
            this.f16234b.b(this.f16235c, this.f16236d);
        }

        public void onError(Throwable th2) {
            this.f16234b.c(this.f16235c, th2);
        }

        public void onNext(Object obj) {
            if (!this.f16236d) {
                this.f16236d = true;
            }
            this.f16234b.d(this.f16235c, obj);
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    public FlowableWithLatestFromMany(@NonNull Flowable<T> flowable, @NonNull Publisher<?>[] publisherArr, Function<? super Object[], R> function) {
        super(flowable);
        this.f16222d = publisherArr;
        this.f16223e = null;
        this.f16224f = function;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        int i11;
        Publisher<?>[] publisherArr = this.f16222d;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            try {
                i11 = 0;
                for (Publisher<?> publisher : this.f16223e) {
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
            new FlowableMap(this.f14763c, new SingletonArrayFunc()).subscribeActual(subscriber);
            return;
        }
        WithLatestFromSubscriber withLatestFromSubscriber = new WithLatestFromSubscriber(subscriber, this.f16224f, i11);
        subscriber.onSubscribe(withLatestFromSubscriber);
        withLatestFromSubscriber.e(publisherArr, i11);
        this.f14763c.subscribe(withLatestFromSubscriber);
    }

    public FlowableWithLatestFromMany(@NonNull Flowable<T> flowable, @NonNull Iterable<? extends Publisher<?>> iterable, @NonNull Function<? super Object[], R> function) {
        super(flowable);
        this.f16222d = null;
        this.f16223e = iterable;
        this.f16224f = function;
    }
}
