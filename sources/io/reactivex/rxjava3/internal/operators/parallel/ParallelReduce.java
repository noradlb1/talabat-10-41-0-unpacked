package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscribers.DeferredScalarSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelReduce<T, R> extends ParallelFlowable<R> {

    /* renamed from: a  reason: collision with root package name */
    public final ParallelFlowable<? extends T> f22699a;

    /* renamed from: b  reason: collision with root package name */
    public final Supplier<R> f22700b;

    /* renamed from: c  reason: collision with root package name */
    public final BiFunction<R, ? super T, R> f22701c;

    public static final class ParallelReduceSubscriber<T, R> extends DeferredScalarSubscriber<T, R> {
        private static final long serialVersionUID = 8200530050639449080L;

        /* renamed from: f  reason: collision with root package name */
        public final BiFunction<R, ? super T, R> f22702f;

        /* renamed from: g  reason: collision with root package name */
        public R f22703g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f22704h;

        public ParallelReduceSubscriber(Subscriber<? super R> subscriber, R r11, BiFunction<R, ? super T, R> biFunction) {
            super(subscriber);
            this.f22703g = r11;
            this.f22702f = biFunction;
        }

        public void cancel() {
            super.cancel();
            this.f23125d.cancel();
        }

        public void onComplete() {
            if (!this.f22704h) {
                this.f22704h = true;
                R r11 = this.f22703g;
                this.f22703g = null;
                complete(r11);
            }
        }

        public void onError(Throwable th2) {
            if (this.f22704h) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f22704h = true;
            this.f22703g = null;
            this.f23170b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f22704h) {
                try {
                    R apply = this.f22702f.apply(this.f22703g, t11);
                    Objects.requireNonNull(apply, "The reducer returned a null value");
                    this.f22703g = apply;
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    cancel();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f23125d, subscription)) {
                this.f23125d = subscription;
                this.f23170b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public ParallelReduce(ParallelFlowable<? extends T> parallelFlowable, Supplier<R> supplier, BiFunction<R, ? super T, R> biFunction) {
        this.f22699a = parallelFlowable;
        this.f22700b = supplier;
        this.f22701c = biFunction;
    }

    public void b(Subscriber<?>[] subscriberArr, Throwable th2) {
        for (Subscriber<?> error : subscriberArr) {
            EmptySubscription.error(th2, error);
        }
    }

    public int parallelism() {
        return this.f22699a.parallelism();
    }

    public void subscribe(Subscriber<? super R>[] subscriberArr) {
        Subscriber[] onSubscribe = RxJavaPlugins.onSubscribe(this, (Subscriber<? super T>[]) subscriberArr);
        if (a(onSubscribe)) {
            int length = onSubscribe.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            int i11 = 0;
            while (i11 < length) {
                try {
                    R r11 = this.f22700b.get();
                    Objects.requireNonNull(r11, "The initialSupplier returned a null value");
                    subscriberArr2[i11] = new ParallelReduceSubscriber(onSubscribe[i11], r11, this.f22701c);
                    i11++;
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    b(onSubscribe, th2);
                    return;
                }
            }
            this.f22699a.subscribe(subscriberArr2);
        }
    }
}
