package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscription;

public final class FlowableCollectSingle<T, U> extends Single<U> implements FuseToFlowable<U> {

    /* renamed from: b  reason: collision with root package name */
    public final Flowable<T> f14942b;

    /* renamed from: c  reason: collision with root package name */
    public final Callable<? extends U> f14943c;

    /* renamed from: d  reason: collision with root package name */
    public final BiConsumer<? super U, ? super T> f14944d;

    public static final class CollectSubscriber<T, U> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super U> f14945b;

        /* renamed from: c  reason: collision with root package name */
        public final BiConsumer<? super U, ? super T> f14946c;

        /* renamed from: d  reason: collision with root package name */
        public final U f14947d;

        /* renamed from: e  reason: collision with root package name */
        public Subscription f14948e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f14949f;

        public CollectSubscriber(SingleObserver<? super U> singleObserver, U u11, BiConsumer<? super U, ? super T> biConsumer) {
            this.f14945b = singleObserver;
            this.f14946c = biConsumer;
            this.f14947d = u11;
        }

        public void dispose() {
            this.f14948e.cancel();
            this.f14948e = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f14948e == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            if (!this.f14949f) {
                this.f14949f = true;
                this.f14948e = SubscriptionHelper.CANCELLED;
                this.f14945b.onSuccess(this.f14947d);
            }
        }

        public void onError(Throwable th2) {
            if (this.f14949f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f14949f = true;
            this.f14948e = SubscriptionHelper.CANCELLED;
            this.f14945b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f14949f) {
                try {
                    this.f14946c.accept(this.f14947d, t11);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f14948e.cancel();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f14948e, subscription)) {
                this.f14948e = subscription;
                this.f14945b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableCollectSingle(Flowable<T> flowable, Callable<? extends U> callable, BiConsumer<? super U, ? super T> biConsumer) {
        this.f14942b = flowable;
        this.f14943c = callable;
        this.f14944d = biConsumer;
    }

    public Flowable<U> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableCollect(this.f14942b, this.f14943c, this.f14944d));
    }

    public void subscribeActual(SingleObserver<? super U> singleObserver) {
        try {
            this.f14942b.subscribe(new CollectSubscriber(singleObserver, ObjectHelper.requireNonNull(this.f14943c.call(), "The initialSupplier returned a null value"), this.f14944d));
        } catch (Throwable th2) {
            EmptyDisposable.error(th2, (SingleObserver<?>) singleObserver);
        }
    }
}
