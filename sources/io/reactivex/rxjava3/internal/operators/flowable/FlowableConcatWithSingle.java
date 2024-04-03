package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

public final class FlowableConcatWithSingle<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final SingleSource<? extends T> f19547d;

    public static final class ConcatWithSubscriber<T> extends SinglePostCompleteSubscriber<T, T> implements SingleObserver<T> {
        private static final long serialVersionUID = -7346385463600070225L;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicReference<Disposable> f19548f = new AtomicReference<>();

        /* renamed from: g  reason: collision with root package name */
        public SingleSource<? extends T> f19549g;

        public ConcatWithSubscriber(Subscriber<? super T> subscriber, SingleSource<? extends T> singleSource) {
            super(subscriber);
            this.f19549g = singleSource;
        }

        public void cancel() {
            super.cancel();
            DisposableHelper.dispose(this.f19548f);
        }

        public void onComplete() {
            this.f23157c = SubscriptionHelper.CANCELLED;
            SingleSource<? extends T> singleSource = this.f19549g;
            this.f19549g = null;
            singleSource.subscribe(this);
        }

        public void onError(Throwable th2) {
            this.f23156b.onError(th2);
        }

        public void onNext(T t11) {
            this.f23159e++;
            this.f23156b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f19548f, disposable);
        }

        public void onSuccess(T t11) {
            a(t11);
        }
    }

    public FlowableConcatWithSingle(Flowable<T> flowable, SingleSource<? extends T> singleSource) {
        super(flowable);
        this.f19547d = singleSource;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f19260c.subscribe(new ConcatWithSubscriber(subscriber, this.f19547d));
    }
}
