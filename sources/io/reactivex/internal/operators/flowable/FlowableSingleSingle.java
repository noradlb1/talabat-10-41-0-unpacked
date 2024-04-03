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

public final class FlowableSingleSingle<T> extends Single<T> implements FuseToFlowable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Flowable<T> f15848b;

    /* renamed from: c  reason: collision with root package name */
    public final T f15849c;

    public static final class SingleElementSubscriber<T> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f15850b;

        /* renamed from: c  reason: collision with root package name */
        public final T f15851c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f15852d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f15853e;

        /* renamed from: f  reason: collision with root package name */
        public T f15854f;

        public SingleElementSubscriber(SingleObserver<? super T> singleObserver, T t11) {
            this.f15850b = singleObserver;
            this.f15851c = t11;
        }

        public void dispose() {
            this.f15852d.cancel();
            this.f15852d = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f15852d == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            if (!this.f15853e) {
                this.f15853e = true;
                this.f15852d = SubscriptionHelper.CANCELLED;
                T t11 = this.f15854f;
                this.f15854f = null;
                if (t11 == null) {
                    t11 = this.f15851c;
                }
                if (t11 != null) {
                    this.f15850b.onSuccess(t11);
                } else {
                    this.f15850b.onError(new NoSuchElementException());
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f15853e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f15853e = true;
            this.f15852d = SubscriptionHelper.CANCELLED;
            this.f15850b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f15853e) {
                if (this.f15854f != null) {
                    this.f15853e = true;
                    this.f15852d.cancel();
                    this.f15852d = SubscriptionHelper.CANCELLED;
                    this.f15850b.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.f15854f = t11;
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15852d, subscription)) {
                this.f15852d = subscription;
                this.f15850b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableSingleSingle(Flowable<T> flowable, T t11) {
        this.f15848b = flowable;
        this.f15849c = t11;
    }

    public Flowable<T> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableSingle(this.f15848b, this.f15849c, true));
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f15848b.subscribe(new SingleElementSubscriber(singleObserver, this.f15849c));
    }
}
