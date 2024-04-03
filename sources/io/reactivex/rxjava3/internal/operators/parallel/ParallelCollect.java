package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscribers.DeferredScalarSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelCollect<T, C> extends ParallelFlowable<C> {

    /* renamed from: a  reason: collision with root package name */
    public final ParallelFlowable<? extends T> f22578a;

    /* renamed from: b  reason: collision with root package name */
    public final Supplier<? extends C> f22579b;

    /* renamed from: c  reason: collision with root package name */
    public final BiConsumer<? super C, ? super T> f22580c;

    public static final class ParallelCollectSubscriber<T, C> extends DeferredScalarSubscriber<T, C> {
        private static final long serialVersionUID = -4767392946044436228L;

        /* renamed from: f  reason: collision with root package name */
        public final BiConsumer<? super C, ? super T> f22581f;

        /* renamed from: g  reason: collision with root package name */
        public C f22582g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f22583h;

        public ParallelCollectSubscriber(Subscriber<? super C> subscriber, C c11, BiConsumer<? super C, ? super T> biConsumer) {
            super(subscriber);
            this.f22582g = c11;
            this.f22581f = biConsumer;
        }

        public void cancel() {
            super.cancel();
            this.f23125d.cancel();
        }

        public void onComplete() {
            if (!this.f22583h) {
                this.f22583h = true;
                C c11 = this.f22582g;
                this.f22582g = null;
                complete(c11);
            }
        }

        public void onError(Throwable th2) {
            if (this.f22583h) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f22583h = true;
            this.f22582g = null;
            this.f23170b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f22583h) {
                try {
                    this.f22581f.accept(this.f22582g, t11);
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

    public ParallelCollect(ParallelFlowable<? extends T> parallelFlowable, Supplier<? extends C> supplier, BiConsumer<? super C, ? super T> biConsumer) {
        this.f22578a = parallelFlowable;
        this.f22579b = supplier;
        this.f22580c = biConsumer;
    }

    public void b(Subscriber<?>[] subscriberArr, Throwable th2) {
        for (Subscriber<?> error : subscriberArr) {
            EmptySubscription.error(th2, error);
        }
    }

    public int parallelism() {
        return this.f22578a.parallelism();
    }

    public void subscribe(Subscriber<? super C>[] subscriberArr) {
        Subscriber[] onSubscribe = RxJavaPlugins.onSubscribe(this, (Subscriber<? super T>[]) subscriberArr);
        if (a(onSubscribe)) {
            int length = onSubscribe.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            int i11 = 0;
            while (i11 < length) {
                try {
                    Object obj = this.f22579b.get();
                    Objects.requireNonNull(obj, "The initialSupplier returned a null value");
                    subscriberArr2[i11] = new ParallelCollectSubscriber(onSubscribe[i11], obj, this.f22580c);
                    i11++;
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    b(onSubscribe, th2);
                    return;
                }
            }
            this.f22578a.subscribe(subscriberArr2);
        }
    }
}
