package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class FlowableReduceSeedSingle<T, R> extends Single<R> {

    /* renamed from: b  reason: collision with root package name */
    public final Publisher<T> f20176b;

    /* renamed from: c  reason: collision with root package name */
    public final R f20177c;

    /* renamed from: d  reason: collision with root package name */
    public final BiFunction<R, ? super T, R> f20178d;

    public static final class ReduceSeedObserver<T, R> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super R> f20179b;

        /* renamed from: c  reason: collision with root package name */
        public final BiFunction<R, ? super T, R> f20180c;

        /* renamed from: d  reason: collision with root package name */
        public R f20181d;

        /* renamed from: e  reason: collision with root package name */
        public Subscription f20182e;

        public ReduceSeedObserver(SingleObserver<? super R> singleObserver, BiFunction<R, ? super T, R> biFunction, R r11) {
            this.f20179b = singleObserver;
            this.f20181d = r11;
            this.f20180c = biFunction;
        }

        public void dispose() {
            this.f20182e.cancel();
            this.f20182e = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f20182e == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            R r11 = this.f20181d;
            if (r11 != null) {
                this.f20181d = null;
                this.f20182e = SubscriptionHelper.CANCELLED;
                this.f20179b.onSuccess(r11);
            }
        }

        public void onError(Throwable th2) {
            if (this.f20181d != null) {
                this.f20181d = null;
                this.f20182e = SubscriptionHelper.CANCELLED;
                this.f20179b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            R r11 = this.f20181d;
            if (r11 != null) {
                try {
                    R apply = this.f20180c.apply(r11, t11);
                    Objects.requireNonNull(apply, "The reducer returned a null value");
                    this.f20181d = apply;
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f20182e.cancel();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f20182e, subscription)) {
                this.f20182e = subscription;
                this.f20179b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableReduceSeedSingle(Publisher<T> publisher, R r11, BiFunction<R, ? super T, R> biFunction) {
        this.f20176b = publisher;
        this.f20177c = r11;
        this.f20178d = biFunction;
    }

    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.f20176b.subscribe(new ReduceSeedObserver(singleObserver, this.f20178d, this.f20177c));
    }
}
