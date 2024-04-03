package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public final class FlowableSingleMaybe<T> extends Maybe<T> implements FuseToFlowable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Flowable<T> f20353b;

    public static final class SingleElementSubscriber<T> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f20354b;

        /* renamed from: c  reason: collision with root package name */
        public Subscription f20355c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f20356d;

        /* renamed from: e  reason: collision with root package name */
        public T f20357e;

        public SingleElementSubscriber(MaybeObserver<? super T> maybeObserver) {
            this.f20354b = maybeObserver;
        }

        public void dispose() {
            this.f20355c.cancel();
            this.f20355c = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f20355c == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            if (!this.f20356d) {
                this.f20356d = true;
                this.f20355c = SubscriptionHelper.CANCELLED;
                T t11 = this.f20357e;
                this.f20357e = null;
                if (t11 == null) {
                    this.f20354b.onComplete();
                } else {
                    this.f20354b.onSuccess(t11);
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f20356d) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f20356d = true;
            this.f20355c = SubscriptionHelper.CANCELLED;
            this.f20354b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f20356d) {
                if (this.f20357e != null) {
                    this.f20356d = true;
                    this.f20355c.cancel();
                    this.f20355c = SubscriptionHelper.CANCELLED;
                    this.f20354b.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.f20357e = t11;
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f20355c, subscription)) {
                this.f20355c = subscription;
                this.f20354b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableSingleMaybe(Flowable<T> flowable) {
        this.f20353b = flowable;
    }

    public Flowable<T> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableSingle(this.f20353b, null, false));
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f20353b.subscribe(new SingleElementSubscriber(maybeObserver));
    }
}
