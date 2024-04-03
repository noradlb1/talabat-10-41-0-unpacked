package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class MaybeDelaySubscriptionOtherPublisher<T, U> extends AbstractMaybeWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<U> f20831c;

    public static final class DelayMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
        private static final long serialVersionUID = 706635022205076709L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f20832b;

        public DelayMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.f20832b = maybeObserver;
        }

        public void onComplete() {
            this.f20832b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f20832b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void onSuccess(T t11) {
            this.f20832b.onSuccess(t11);
        }
    }

    public static final class OtherSubscriber<T> implements FlowableSubscriber<Object>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final DelayMaybeObserver<T> f20833b;

        /* renamed from: c  reason: collision with root package name */
        public MaybeSource<T> f20834c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f20835d;

        public OtherSubscriber(MaybeObserver<? super T> maybeObserver, MaybeSource<T> maybeSource) {
            this.f20833b = new DelayMaybeObserver<>(maybeObserver);
            this.f20834c = maybeSource;
        }

        public void a() {
            MaybeSource<T> maybeSource = this.f20834c;
            this.f20834c = null;
            maybeSource.subscribe(this.f20833b);
        }

        public void dispose() {
            this.f20835d.cancel();
            this.f20835d = SubscriptionHelper.CANCELLED;
            DisposableHelper.dispose(this.f20833b);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) this.f20833b.get());
        }

        public void onComplete() {
            Subscription subscription = this.f20835d;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                this.f20835d = subscriptionHelper;
                a();
            }
        }

        public void onError(Throwable th2) {
            Subscription subscription = this.f20835d;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                this.f20835d = subscriptionHelper;
                this.f20833b.f20832b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(Object obj) {
            Subscription subscription = this.f20835d;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                subscription.cancel();
                this.f20835d = subscriptionHelper;
                a();
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f20835d, subscription)) {
                this.f20835d = subscription;
                this.f20833b.f20832b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public MaybeDelaySubscriptionOtherPublisher(MaybeSource<T> maybeSource, Publisher<U> publisher) {
        super(maybeSource);
        this.f20831c = publisher;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f20831c.subscribe(new OtherSubscriber(maybeObserver, this.f20763b));
    }
}
