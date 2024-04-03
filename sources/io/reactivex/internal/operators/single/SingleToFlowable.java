package io.reactivex.internal.operators.single;

import io.reactivex.Flowable;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import org.reactivestreams.Subscriber;

public final class SingleToFlowable<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final SingleSource<? extends T> f18418c;

    public static final class SingleToFlowableObserver<T> extends DeferredScalarSubscription<T> implements SingleObserver<T> {
        private static final long serialVersionUID = 187782011903685568L;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f18419d;

        public SingleToFlowableObserver(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public void cancel() {
            super.cancel();
            this.f18419d.dispose();
        }

        public void onError(Throwable th2) {
            this.f18609b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f18419d, disposable)) {
                this.f18419d = disposable;
                this.f18609b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            complete(t11);
        }
    }

    public SingleToFlowable(SingleSource<? extends T> singleSource) {
        this.f18418c = singleSource;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f18418c.subscribe(new SingleToFlowableObserver(subscriber));
    }
}
