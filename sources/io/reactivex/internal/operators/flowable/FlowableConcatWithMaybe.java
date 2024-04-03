package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

public final class FlowableConcatWithMaybe<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final MaybeSource<? extends T> f15037d;

    public static final class ConcatWithSubscriber<T> extends SinglePostCompleteSubscriber<T, T> implements MaybeObserver<T> {
        private static final long serialVersionUID = -7346385463600070225L;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicReference<Disposable> f15038f = new AtomicReference<>();

        /* renamed from: g  reason: collision with root package name */
        public MaybeSource<? extends T> f15039g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f15040h;

        public ConcatWithSubscriber(Subscriber<? super T> subscriber, MaybeSource<? extends T> maybeSource) {
            super(subscriber);
            this.f15039g = maybeSource;
        }

        public void cancel() {
            super.cancel();
            DisposableHelper.dispose(this.f15038f);
        }

        public void onComplete() {
            if (this.f15040h) {
                this.f18595b.onComplete();
                return;
            }
            this.f15040h = true;
            this.f18596c = SubscriptionHelper.CANCELLED;
            MaybeSource<? extends T> maybeSource = this.f15039g;
            this.f15039g = null;
            maybeSource.subscribe(this);
        }

        public void onError(Throwable th2) {
            this.f18595b.onError(th2);
        }

        public void onNext(T t11) {
            this.f18598e++;
            this.f18595b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f15038f, disposable);
        }

        public void onSuccess(T t11) {
            a(t11);
        }
    }

    public FlowableConcatWithMaybe(Flowable<T> flowable, MaybeSource<? extends T> maybeSource) {
        super(flowable);
        this.f15037d = maybeSource;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f14763c.subscribe(new ConcatWithSubscriber(subscriber, this.f15037d));
    }
}
