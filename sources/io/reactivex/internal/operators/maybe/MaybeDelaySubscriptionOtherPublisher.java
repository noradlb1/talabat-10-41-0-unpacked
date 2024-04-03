package io.reactivex.internal.operators.maybe;

import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class MaybeDelaySubscriptionOtherPublisher<T, U> extends AbstractMaybeWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<U> f16330c;

    public static final class DelayMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
        private static final long serialVersionUID = 706635022205076709L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f16331b;

        public DelayMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.f16331b = maybeObserver;
        }

        public void onComplete() {
            this.f16331b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f16331b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void onSuccess(T t11) {
            this.f16331b.onSuccess(t11);
        }
    }

    public static final class OtherSubscriber<T> implements FlowableSubscriber<Object>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final DelayMaybeObserver<T> f16332b;

        /* renamed from: c  reason: collision with root package name */
        public MaybeSource<T> f16333c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f16334d;

        public OtherSubscriber(MaybeObserver<? super T> maybeObserver, MaybeSource<T> maybeSource) {
            this.f16332b = new DelayMaybeObserver<>(maybeObserver);
            this.f16333c = maybeSource;
        }

        public void a() {
            MaybeSource<T> maybeSource = this.f16333c;
            this.f16333c = null;
            maybeSource.subscribe(this.f16332b);
        }

        public void dispose() {
            this.f16334d.cancel();
            this.f16334d = SubscriptionHelper.CANCELLED;
            DisposableHelper.dispose(this.f16332b);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) this.f16332b.get());
        }

        public void onComplete() {
            Subscription subscription = this.f16334d;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                this.f16334d = subscriptionHelper;
                a();
            }
        }

        public void onError(Throwable th2) {
            Subscription subscription = this.f16334d;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                this.f16334d = subscriptionHelper;
                this.f16332b.f16331b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(Object obj) {
            Subscription subscription = this.f16334d;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                subscription.cancel();
                this.f16334d = subscriptionHelper;
                a();
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f16334d, subscription)) {
                this.f16334d = subscription;
                this.f16332b.f16331b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public MaybeDelaySubscriptionOtherPublisher(MaybeSource<T> maybeSource, Publisher<U> publisher) {
        super(maybeSource);
        this.f16330c = publisher;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f16330c.subscribe(new OtherSubscriber(maybeObserver, this.f16264b));
    }
}
