package io.reactivex.internal.operators.maybe;

import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class MaybeDelayOtherPublisher<T, U> extends AbstractMaybeWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<U> f16323c;

    public static final class DelayMaybeObserver<T, U> implements MaybeObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final OtherSubscriber<T> f16324b;

        /* renamed from: c  reason: collision with root package name */
        public final Publisher<U> f16325c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f16326d;

        public DelayMaybeObserver(MaybeObserver<? super T> maybeObserver, Publisher<U> publisher) {
            this.f16324b = new OtherSubscriber<>(maybeObserver);
            this.f16325c = publisher;
        }

        public void a() {
            this.f16325c.subscribe(this.f16324b);
        }

        public void dispose() {
            this.f16326d.dispose();
            this.f16326d = DisposableHelper.DISPOSED;
            SubscriptionHelper.cancel(this.f16324b);
        }

        public boolean isDisposed() {
            return this.f16324b.get() == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            this.f16326d = DisposableHelper.DISPOSED;
            a();
        }

        public void onError(Throwable th2) {
            this.f16326d = DisposableHelper.DISPOSED;
            this.f16324b.f16329d = th2;
            a();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16326d, disposable)) {
                this.f16326d = disposable;
                this.f16324b.f16327b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f16326d = DisposableHelper.DISPOSED;
            this.f16324b.f16328c = t11;
            a();
        }
    }

    public static final class OtherSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
        private static final long serialVersionUID = -1215060610805418006L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f16327b;

        /* renamed from: c  reason: collision with root package name */
        public T f16328c;

        /* renamed from: d  reason: collision with root package name */
        public Throwable f16329d;

        public OtherSubscriber(MaybeObserver<? super T> maybeObserver) {
            this.f16327b = maybeObserver;
        }

        public void onComplete() {
            Throwable th2 = this.f16329d;
            if (th2 != null) {
                this.f16327b.onError(th2);
                return;
            }
            T t11 = this.f16328c;
            if (t11 != null) {
                this.f16327b.onSuccess(t11);
            } else {
                this.f16327b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            Throwable th3 = this.f16329d;
            if (th3 == null) {
                this.f16327b.onError(th2);
                return;
            }
            this.f16327b.onError(new CompositeException(th3, th2));
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
        this.f16323c = publisher;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f16264b.subscribe(new DelayMaybeObserver(maybeObserver, this.f16323c));
    }
}
