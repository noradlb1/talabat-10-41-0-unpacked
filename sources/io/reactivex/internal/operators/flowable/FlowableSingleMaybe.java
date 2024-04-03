package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public final class FlowableSingleMaybe<T> extends Maybe<T> implements FuseToFlowable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Flowable<T> f15843b;

    public static final class SingleElementSubscriber<T> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f15844b;

        /* renamed from: c  reason: collision with root package name */
        public Subscription f15845c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f15846d;

        /* renamed from: e  reason: collision with root package name */
        public T f15847e;

        public SingleElementSubscriber(MaybeObserver<? super T> maybeObserver) {
            this.f15844b = maybeObserver;
        }

        public void dispose() {
            this.f15845c.cancel();
            this.f15845c = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f15845c == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            if (!this.f15846d) {
                this.f15846d = true;
                this.f15845c = SubscriptionHelper.CANCELLED;
                T t11 = this.f15847e;
                this.f15847e = null;
                if (t11 == null) {
                    this.f15844b.onComplete();
                } else {
                    this.f15844b.onSuccess(t11);
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f15846d) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f15846d = true;
            this.f15845c = SubscriptionHelper.CANCELLED;
            this.f15844b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f15846d) {
                if (this.f15847e != null) {
                    this.f15846d = true;
                    this.f15845c.cancel();
                    this.f15845c = SubscriptionHelper.CANCELLED;
                    this.f15844b.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.f15847e = t11;
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15845c, subscription)) {
                this.f15845c = subscription;
                this.f15844b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableSingleMaybe(Flowable<T> flowable) {
        this.f15843b = flowable;
    }

    public Flowable<T> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableSingle(this.f15843b, null, false));
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f15843b.subscribe(new SingleElementSubscriber(maybeObserver));
    }
}
