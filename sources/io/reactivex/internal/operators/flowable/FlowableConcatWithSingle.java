package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

public final class FlowableConcatWithSingle<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final SingleSource<? extends T> f15041d;

    public static final class ConcatWithSubscriber<T> extends SinglePostCompleteSubscriber<T, T> implements SingleObserver<T> {
        private static final long serialVersionUID = -7346385463600070225L;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicReference<Disposable> f15042f = new AtomicReference<>();

        /* renamed from: g  reason: collision with root package name */
        public SingleSource<? extends T> f15043g;

        public ConcatWithSubscriber(Subscriber<? super T> subscriber, SingleSource<? extends T> singleSource) {
            super(subscriber);
            this.f15043g = singleSource;
        }

        public void cancel() {
            super.cancel();
            DisposableHelper.dispose(this.f15042f);
        }

        public void onComplete() {
            this.f18596c = SubscriptionHelper.CANCELLED;
            SingleSource<? extends T> singleSource = this.f15043g;
            this.f15043g = null;
            singleSource.subscribe(this);
        }

        public void onError(Throwable th2) {
            this.f18595b.onError(th2);
        }

        public void onNext(T t11) {
            this.f18598e++;
            this.f18595b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f15042f, disposable);
        }

        public void onSuccess(T t11) {
            a(t11);
        }
    }

    public FlowableConcatWithSingle(Flowable<T> flowable, SingleSource<? extends T> singleSource) {
        super(flowable);
        this.f15041d = singleSource;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f14763c.subscribe(new ConcatWithSubscriber(subscriber, this.f15041d));
    }
}
