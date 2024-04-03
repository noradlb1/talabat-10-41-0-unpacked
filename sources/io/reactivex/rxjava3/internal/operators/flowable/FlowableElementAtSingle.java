package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import org.reactivestreams.Subscription;

public final class FlowableElementAtSingle<T> extends Single<T> implements FuseToFlowable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Flowable<T> f19693b;

    /* renamed from: c  reason: collision with root package name */
    public final long f19694c;

    /* renamed from: d  reason: collision with root package name */
    public final T f19695d;

    public static final class ElementAtSubscriber<T> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f19696b;

        /* renamed from: c  reason: collision with root package name */
        public final long f19697c;

        /* renamed from: d  reason: collision with root package name */
        public final T f19698d;

        /* renamed from: e  reason: collision with root package name */
        public Subscription f19699e;

        /* renamed from: f  reason: collision with root package name */
        public long f19700f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f19701g;

        public ElementAtSubscriber(SingleObserver<? super T> singleObserver, long j11, T t11) {
            this.f19696b = singleObserver;
            this.f19697c = j11;
            this.f19698d = t11;
        }

        public void dispose() {
            this.f19699e.cancel();
            this.f19699e = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f19699e == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            this.f19699e = SubscriptionHelper.CANCELLED;
            if (!this.f19701g) {
                this.f19701g = true;
                T t11 = this.f19698d;
                if (t11 != null) {
                    this.f19696b.onSuccess(t11);
                } else {
                    this.f19696b.onError(new NoSuchElementException());
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f19701g) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f19701g = true;
            this.f19699e = SubscriptionHelper.CANCELLED;
            this.f19696b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f19701g) {
                long j11 = this.f19700f;
                if (j11 == this.f19697c) {
                    this.f19701g = true;
                    this.f19699e.cancel();
                    this.f19699e = SubscriptionHelper.CANCELLED;
                    this.f19696b.onSuccess(t11);
                    return;
                }
                this.f19700f = j11 + 1;
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f19699e, subscription)) {
                this.f19699e = subscription;
                this.f19696b.onSubscribe(this);
                subscription.request(this.f19697c + 1);
            }
        }
    }

    public FlowableElementAtSingle(Flowable<T> flowable, long j11, T t11) {
        this.f19693b = flowable;
        this.f19694c = j11;
        this.f19695d = t11;
    }

    public Flowable<T> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableElementAt(this.f19693b, this.f19694c, this.f19695d, true));
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f19693b.subscribe(new ElementAtSubscriber(singleObserver, this.f19694c, this.f19695d));
    }
}
