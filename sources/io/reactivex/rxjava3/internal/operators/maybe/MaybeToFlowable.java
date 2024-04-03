package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamMaybeSource;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import org.reactivestreams.Subscriber;

public final class MaybeToFlowable<T> extends Flowable<T> implements HasUpstreamMaybeSource<T> {

    /* renamed from: c  reason: collision with root package name */
    public final MaybeSource<T> f21064c;

    public static final class MaybeToFlowableSubscriber<T> extends DeferredScalarSubscription<T> implements MaybeObserver<T> {
        private static final long serialVersionUID = 7603343402964826922L;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f21065d;

        public MaybeToFlowableSubscriber(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public void cancel() {
            super.cancel();
            this.f21065d.dispose();
        }

        public void onComplete() {
            this.f23170b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f23170b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21065d, disposable)) {
                this.f21065d = disposable;
                this.f23170b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            complete(t11);
        }
    }

    public MaybeToFlowable(MaybeSource<T> maybeSource) {
        this.f21064c = maybeSource;
    }

    public MaybeSource<T> source() {
        return this.f21064c;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f21064c.subscribe(new MaybeToFlowableSubscriber(subscriber));
    }
}
