package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Subscription;

public final class FlowableCollectSingle<T, U> extends Single<U> implements FuseToFlowable<U> {

    /* renamed from: b  reason: collision with root package name */
    public final Flowable<T> f19430b;

    /* renamed from: c  reason: collision with root package name */
    public final Supplier<? extends U> f19431c;

    /* renamed from: d  reason: collision with root package name */
    public final BiConsumer<? super U, ? super T> f19432d;

    public static final class CollectSubscriber<T, U> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super U> f19433b;

        /* renamed from: c  reason: collision with root package name */
        public final BiConsumer<? super U, ? super T> f19434c;

        /* renamed from: d  reason: collision with root package name */
        public final U f19435d;

        /* renamed from: e  reason: collision with root package name */
        public Subscription f19436e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f19437f;

        public CollectSubscriber(SingleObserver<? super U> singleObserver, U u11, BiConsumer<? super U, ? super T> biConsumer) {
            this.f19433b = singleObserver;
            this.f19434c = biConsumer;
            this.f19435d = u11;
        }

        public void dispose() {
            this.f19436e.cancel();
            this.f19436e = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f19436e == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            if (!this.f19437f) {
                this.f19437f = true;
                this.f19436e = SubscriptionHelper.CANCELLED;
                this.f19433b.onSuccess(this.f19435d);
            }
        }

        public void onError(Throwable th2) {
            if (this.f19437f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f19437f = true;
            this.f19436e = SubscriptionHelper.CANCELLED;
            this.f19433b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f19437f) {
                try {
                    this.f19434c.accept(this.f19435d, t11);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f19436e.cancel();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f19436e, subscription)) {
                this.f19436e = subscription;
                this.f19433b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableCollectSingle(Flowable<T> flowable, Supplier<? extends U> supplier, BiConsumer<? super U, ? super T> biConsumer) {
        this.f19430b = flowable;
        this.f19431c = supplier;
        this.f19432d = biConsumer;
    }

    public Flowable<U> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableCollect(this.f19430b, this.f19431c, this.f19432d));
    }

    public void subscribeActual(SingleObserver<? super U> singleObserver) {
        try {
            Object obj = this.f19431c.get();
            Objects.requireNonNull(obj, "The initialSupplier returned a null value");
            this.f19430b.subscribe(new CollectSubscriber(singleObserver, obj, this.f19432d));
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (SingleObserver<?>) singleObserver);
        }
    }
}
