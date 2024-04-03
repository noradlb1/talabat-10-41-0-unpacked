package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.DeferredScalarSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelCollect<T, C> extends ParallelFlowable<C> {

    /* renamed from: a  reason: collision with root package name */
    public final ParallelFlowable<? extends T> f18047a;

    /* renamed from: b  reason: collision with root package name */
    public final Callable<? extends C> f18048b;

    /* renamed from: c  reason: collision with root package name */
    public final BiConsumer<? super C, ? super T> f18049c;

    public static final class ParallelCollectSubscriber<T, C> extends DeferredScalarSubscriber<T, C> {
        private static final long serialVersionUID = -4767392946044436228L;

        /* renamed from: f  reason: collision with root package name */
        public final BiConsumer<? super C, ? super T> f18050f;

        /* renamed from: g  reason: collision with root package name */
        public C f18051g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f18052h;

        public ParallelCollectSubscriber(Subscriber<? super C> subscriber, C c11, BiConsumer<? super C, ? super T> biConsumer) {
            super(subscriber);
            this.f18051g = c11;
            this.f18050f = biConsumer;
        }

        public void cancel() {
            super.cancel();
            this.f18568d.cancel();
        }

        public void onComplete() {
            if (!this.f18052h) {
                this.f18052h = true;
                C c11 = this.f18051g;
                this.f18051g = null;
                complete(c11);
            }
        }

        public void onError(Throwable th2) {
            if (this.f18052h) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f18052h = true;
            this.f18051g = null;
            this.f18609b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f18052h) {
                try {
                    this.f18050f.accept(this.f18051g, t11);
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

    public ParallelCollect(ParallelFlowable<? extends T> parallelFlowable, Callable<? extends C> callable, BiConsumer<? super C, ? super T> biConsumer) {
        this.f18047a = parallelFlowable;
        this.f18048b = callable;
        this.f18049c = biConsumer;
    }

    public void b(Subscriber<?>[] subscriberArr, Throwable th2) {
        for (Subscriber<?> error : subscriberArr) {
            EmptySubscription.error(th2, error);
        }
    }

    public int parallelism() {
        return this.f18047a.parallelism();
    }

    public void subscribe(Subscriber<? super C>[] subscriberArr) {
        if (a(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            int i11 = 0;
            while (i11 < length) {
                try {
                    subscriberArr2[i11] = new ParallelCollectSubscriber(subscriberArr[i11], ObjectHelper.requireNonNull(this.f18048b.call(), "The initialSupplier returned a null value"), this.f18049c);
                    i11++;
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    b(subscriberArr, th2);
                    return;
                }
            }
            this.f18047a.subscribe(subscriberArr2);
        }
    }
}
