package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.DeferredScalarSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelReduce<T, R> extends ParallelFlowable<R> {

    /* renamed from: a  reason: collision with root package name */
    public final ParallelFlowable<? extends T> f18165a;

    /* renamed from: b  reason: collision with root package name */
    public final Callable<R> f18166b;

    /* renamed from: c  reason: collision with root package name */
    public final BiFunction<R, ? super T, R> f18167c;

    public static final class ParallelReduceSubscriber<T, R> extends DeferredScalarSubscriber<T, R> {
        private static final long serialVersionUID = 8200530050639449080L;

        /* renamed from: f  reason: collision with root package name */
        public final BiFunction<R, ? super T, R> f18168f;

        /* renamed from: g  reason: collision with root package name */
        public R f18169g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f18170h;

        public ParallelReduceSubscriber(Subscriber<? super R> subscriber, R r11, BiFunction<R, ? super T, R> biFunction) {
            super(subscriber);
            this.f18169g = r11;
            this.f18168f = biFunction;
        }

        public void cancel() {
            super.cancel();
            this.f18568d.cancel();
        }

        public void onComplete() {
            if (!this.f18170h) {
                this.f18170h = true;
                R r11 = this.f18169g;
                this.f18169g = null;
                complete(r11);
            }
        }

        public void onError(Throwable th2) {
            if (this.f18170h) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f18170h = true;
            this.f18169g = null;
            this.f18609b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f18170h) {
                try {
                    this.f18169g = ObjectHelper.requireNonNull(this.f18168f.apply(this.f18169g, t11), "The reducer returned a null value");
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    cancel();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f18568d, subscription)) {
                this.f18568d = subscription;
                this.f18609b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public ParallelReduce(ParallelFlowable<? extends T> parallelFlowable, Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        this.f18165a = parallelFlowable;
        this.f18166b = callable;
        this.f18167c = biFunction;
    }

    public void b(Subscriber<?>[] subscriberArr, Throwable th2) {
        for (Subscriber<?> error : subscriberArr) {
            EmptySubscription.error(th2, error);
        }
    }

    public int parallelism() {
        return this.f18165a.parallelism();
    }

    public void subscribe(Subscriber<? super R>[] subscriberArr) {
        if (a(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            int i11 = 0;
            while (i11 < length) {
                try {
                    subscriberArr2[i11] = new ParallelReduceSubscriber(subscriberArr[i11], ObjectHelper.requireNonNull(this.f18166b.call(), "The initialSupplier returned a null value"), this.f18167c);
                    i11++;
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    b(subscriberArr, th2);
                    return;
                }
            }
            this.f18165a.subscribe(subscriberArr2);
        }
    }
}
