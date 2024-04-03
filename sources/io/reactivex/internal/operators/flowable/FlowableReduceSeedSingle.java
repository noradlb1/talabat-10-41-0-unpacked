package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class FlowableReduceSeedSingle<T, R> extends Single<R> {

    /* renamed from: b  reason: collision with root package name */
    public final Publisher<T> f15669b;

    /* renamed from: c  reason: collision with root package name */
    public final R f15670c;

    /* renamed from: d  reason: collision with root package name */
    public final BiFunction<R, ? super T, R> f15671d;

    public static final class ReduceSeedObserver<T, R> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super R> f15672b;

        /* renamed from: c  reason: collision with root package name */
        public final BiFunction<R, ? super T, R> f15673c;

        /* renamed from: d  reason: collision with root package name */
        public R f15674d;

        /* renamed from: e  reason: collision with root package name */
        public Subscription f15675e;

        public ReduceSeedObserver(SingleObserver<? super R> singleObserver, BiFunction<R, ? super T, R> biFunction, R r11) {
            this.f15672b = singleObserver;
            this.f15674d = r11;
            this.f15673c = biFunction;
        }

        public void dispose() {
            this.f15675e.cancel();
            this.f15675e = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f15675e == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            R r11 = this.f15674d;
            if (r11 != null) {
                this.f15674d = null;
                this.f15675e = SubscriptionHelper.CANCELLED;
                this.f15672b.onSuccess(r11);
            }
        }

        public void onError(Throwable th2) {
            if (this.f15674d != null) {
                this.f15674d = null;
                this.f15675e = SubscriptionHelper.CANCELLED;
                this.f15672b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            R r11 = this.f15674d;
            if (r11 != null) {
                try {
                    this.f15674d = ObjectHelper.requireNonNull(this.f15673c.apply(r11, t11), "The reducer returned a null value");
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f15675e.cancel();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15675e, subscription)) {
                this.f15675e = subscription;
                this.f15672b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableReduceSeedSingle(Publisher<T> publisher, R r11, BiFunction<R, ? super T, R> biFunction) {
        this.f15669b = publisher;
        this.f15670c = r11;
        this.f15671d = biFunction;
    }

    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.f15669b.subscribe(new ReduceSeedObserver(singleObserver, this.f15671d, this.f15670c));
    }
}
