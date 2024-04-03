package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ArrayListSupplier;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscription;

public final class FlowableToListSingle<T, U extends Collection<? super T>> extends Single<U> implements FuseToFlowable<U> {

    /* renamed from: b  reason: collision with root package name */
    public final Flowable<T> f16064b;

    /* renamed from: c  reason: collision with root package name */
    public final Callable<U> f16065c;

    public static final class ToListSubscriber<T, U extends Collection<? super T>> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super U> f16066b;

        /* renamed from: c  reason: collision with root package name */
        public Subscription f16067c;

        /* renamed from: d  reason: collision with root package name */
        public U f16068d;

        public ToListSubscriber(SingleObserver<? super U> singleObserver, U u11) {
            this.f16066b = singleObserver;
            this.f16068d = u11;
        }

        public void dispose() {
            this.f16067c.cancel();
            this.f16067c = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f16067c == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            this.f16067c = SubscriptionHelper.CANCELLED;
            this.f16066b.onSuccess(this.f16068d);
        }

        public void onError(Throwable th2) {
            this.f16068d = null;
            this.f16067c = SubscriptionHelper.CANCELLED;
            this.f16066b.onError(th2);
        }

        public void onNext(T t11) {
            this.f16068d.add(t11);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f16067c, subscription)) {
                this.f16067c = subscription;
                this.f16066b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableToListSingle(Flowable<T> flowable) {
        this(flowable, ArrayListSupplier.asCallable());
    }

    public Flowable<U> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableToList(this.f16064b, this.f16065c));
    }

    public void subscribeActual(SingleObserver<? super U> singleObserver) {
        try {
            this.f16064b.subscribe(new ToListSubscriber(singleObserver, (Collection) ObjectHelper.requireNonNull(this.f16065c.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (SingleObserver<?>) singleObserver);
        }
    }

    public FlowableToListSingle(Flowable<T> flowable, Callable<U> callable) {
        this.f16064b = flowable;
        this.f16065c = callable;
    }
}
