package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.ArrayListSupplier;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Collection;
import org.reactivestreams.Subscription;

public final class FlowableToListSingle<T, U extends Collection<? super T>> extends Single<U> implements FuseToFlowable<U> {

    /* renamed from: b  reason: collision with root package name */
    public final Flowable<T> f20572b;

    /* renamed from: c  reason: collision with root package name */
    public final Supplier<U> f20573c;

    public static final class ToListSubscriber<T, U extends Collection<? super T>> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super U> f20574b;

        /* renamed from: c  reason: collision with root package name */
        public Subscription f20575c;

        /* renamed from: d  reason: collision with root package name */
        public U f20576d;

        public ToListSubscriber(SingleObserver<? super U> singleObserver, U u11) {
            this.f20574b = singleObserver;
            this.f20576d = u11;
        }

        public void dispose() {
            this.f20575c.cancel();
            this.f20575c = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f20575c == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            this.f20575c = SubscriptionHelper.CANCELLED;
            this.f20574b.onSuccess(this.f20576d);
        }

        public void onError(Throwable th2) {
            this.f20576d = null;
            this.f20575c = SubscriptionHelper.CANCELLED;
            this.f20574b.onError(th2);
        }

        public void onNext(T t11) {
            this.f20576d.add(t11);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f20575c, subscription)) {
                this.f20575c = subscription;
                this.f20574b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableToListSingle(Flowable<T> flowable) {
        this(flowable, ArrayListSupplier.asSupplier());
    }

    public Flowable<U> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableToList(this.f20572b, this.f20573c));
    }

    public void subscribeActual(SingleObserver<? super U> singleObserver) {
        try {
            this.f20572b.subscribe(new ToListSubscriber(singleObserver, (Collection) ExceptionHelper.nullCheck(this.f20573c.get(), "The collectionSupplier returned a null Collection.")));
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (SingleObserver<?>) singleObserver);
        }
    }

    public FlowableToListSingle(Flowable<T> flowable, Supplier<U> supplier) {
        this.f20572b = flowable;
        this.f20573c = supplier;
    }
}
