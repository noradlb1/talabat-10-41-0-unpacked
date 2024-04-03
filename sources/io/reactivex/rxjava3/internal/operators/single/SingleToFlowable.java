package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import org.reactivestreams.Subscriber;

public final class SingleToFlowable<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final SingleSource<? extends T> f22987c;

    public static final class SingleToFlowableObserver<T> extends DeferredScalarSubscription<T> implements SingleObserver<T> {
        private static final long serialVersionUID = 187782011903685568L;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f22988d;

        public SingleToFlowableObserver(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public void cancel() {
            super.cancel();
            this.f22988d.dispose();
        }

        public void onError(Throwable th2) {
            this.f23170b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22988d, disposable)) {
                this.f22988d = disposable;
                this.f23170b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            complete(t11);
        }
    }

    public SingleToFlowable(SingleSource<? extends T> singleSource) {
        this.f22987c = singleSource;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f22987c.subscribe(new SingleToFlowableObserver(subscriber));
    }
}
