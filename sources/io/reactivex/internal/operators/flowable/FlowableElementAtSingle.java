package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import org.reactivestreams.Subscription;

public final class FlowableElementAtSingle<T> extends Single<T> implements FuseToFlowable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Flowable<T> f15185b;

    /* renamed from: c  reason: collision with root package name */
    public final long f15186c;

    /* renamed from: d  reason: collision with root package name */
    public final T f15187d;

    public static final class ElementAtSubscriber<T> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f15188b;

        /* renamed from: c  reason: collision with root package name */
        public final long f15189c;

        /* renamed from: d  reason: collision with root package name */
        public final T f15190d;

        /* renamed from: e  reason: collision with root package name */
        public Subscription f15191e;

        /* renamed from: f  reason: collision with root package name */
        public long f15192f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f15193g;

        public ElementAtSubscriber(SingleObserver<? super T> singleObserver, long j11, T t11) {
            this.f15188b = singleObserver;
            this.f15189c = j11;
            this.f15190d = t11;
        }

        public void dispose() {
            this.f15191e.cancel();
            this.f15191e = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f15191e == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            this.f15191e = SubscriptionHelper.CANCELLED;
            if (!this.f15193g) {
                this.f15193g = true;
                T t11 = this.f15190d;
                if (t11 != null) {
                    this.f15188b.onSuccess(t11);
                } else {
                    this.f15188b.onError(new NoSuchElementException());
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f15193g) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f15193g = true;
            this.f15191e = SubscriptionHelper.CANCELLED;
            this.f15188b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f15193g) {
                long j11 = this.f15192f;
                if (j11 == this.f15189c) {
                    this.f15193g = true;
                    this.f15191e.cancel();
                    this.f15191e = SubscriptionHelper.CANCELLED;
                    this.f15188b.onSuccess(t11);
                    return;
                }
                this.f15192f = j11 + 1;
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15191e, subscription)) {
                this.f15191e = subscription;
                this.f15188b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableElementAtSingle(Flowable<T> flowable, long j11, T t11) {
        this.f15185b = flowable;
        this.f15186c = j11;
        this.f15187d = t11;
    }

    public Flowable<T> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableElementAt(this.f15185b, this.f15186c, this.f15187d, true));
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f15185b.subscribe(new ElementAtSubscriber(singleObserver, this.f15186c, this.f15187d));
    }
}
