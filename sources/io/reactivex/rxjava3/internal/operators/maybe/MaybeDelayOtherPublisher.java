package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class MaybeDelayOtherPublisher<T, U> extends AbstractMaybeWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<U> f20824c;

    public static final class DelayMaybeObserver<T, U> implements MaybeObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final OtherSubscriber<T> f20825b;

        /* renamed from: c  reason: collision with root package name */
        public final Publisher<U> f20826c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f20827d;

        public DelayMaybeObserver(MaybeObserver<? super T> maybeObserver, Publisher<U> publisher) {
            this.f20825b = new OtherSubscriber<>(maybeObserver);
            this.f20826c = publisher;
        }

        public void a() {
            this.f20826c.subscribe(this.f20825b);
        }

        public void dispose() {
            this.f20827d.dispose();
            this.f20827d = DisposableHelper.DISPOSED;
            SubscriptionHelper.cancel(this.f20825b);
        }

        public boolean isDisposed() {
            return this.f20825b.get() == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            this.f20827d = DisposableHelper.DISPOSED;
            a();
        }

        public void onError(Throwable th2) {
            this.f20827d = DisposableHelper.DISPOSED;
            this.f20825b.f20830d = th2;
            a();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f20827d, disposable)) {
                this.f20827d = disposable;
                this.f20825b.f20828b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f20827d = DisposableHelper.DISPOSED;
            this.f20825b.f20829c = t11;
            a();
        }
    }

    public static final class OtherSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
        private static final long serialVersionUID = -1215060610805418006L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f20828b;

        /* renamed from: c  reason: collision with root package name */
        public T f20829c;

        /* renamed from: d  reason: collision with root package name */
        public Throwable f20830d;

        public OtherSubscriber(MaybeObserver<? super T> maybeObserver) {
            this.f20828b = maybeObserver;
        }

        public void onComplete() {
            Throwable th2 = this.f20830d;
            if (th2 != null) {
                this.f20828b.onError(th2);
                return;
            }
            T t11 = this.f20829c;
            if (t11 != null) {
                this.f20828b.onSuccess(t11);
            } else {
                this.f20828b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            Throwable th3 = this.f20830d;
            if (th3 == null) {
                this.f20828b.onError(th2);
                return;
            }
            this.f20828b.onError(new CompositeException(th3, th2));
        }

        public void onNext(Object obj) {
            Subscription subscription = (Subscription) get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                lazySet(subscriptionHelper);
                subscription.cancel();
                onComplete();
            }
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    public MaybeDelayOtherPublisher(MaybeSource<T> maybeSource, Publisher<U> publisher) {
        super(maybeSource);
        this.f20824c = publisher;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f20763b.subscribe(new DelayMaybeObserver(maybeObserver, this.f20824c));
    }
}
