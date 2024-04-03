package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import org.reactivestreams.Subscriber;

public final class MaybeToFlowable<T> extends Flowable<T> implements HasUpstreamMaybeSource<T> {

    /* renamed from: c  reason: collision with root package name */
    public final MaybeSource<T> f16551c;

    public static final class MaybeToFlowableSubscriber<T> extends DeferredScalarSubscription<T> implements MaybeObserver<T> {
        private static final long serialVersionUID = 7603343402964826922L;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f16552d;

        public MaybeToFlowableSubscriber(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public void cancel() {
            super.cancel();
            this.f16552d.dispose();
        }

        public void onComplete() {
            this.f18609b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f18609b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16552d, disposable)) {
                this.f16552d = disposable;
                this.f18609b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            complete(t11);
        }
    }

    public MaybeToFlowable(MaybeSource<T> maybeSource) {
        this.f16551c = maybeSource;
    }

    public MaybeSource<T> source() {
        return this.f16551c;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f16551c.subscribe(new MaybeToFlowableSubscriber(subscriber));
    }
}
