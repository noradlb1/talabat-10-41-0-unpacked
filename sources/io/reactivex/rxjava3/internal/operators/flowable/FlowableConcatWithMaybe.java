package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

public final class FlowableConcatWithMaybe<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final MaybeSource<? extends T> f19543d;

    public static final class ConcatWithSubscriber<T> extends SinglePostCompleteSubscriber<T, T> implements MaybeObserver<T> {
        private static final long serialVersionUID = -7346385463600070225L;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicReference<Disposable> f19544f = new AtomicReference<>();

        /* renamed from: g  reason: collision with root package name */
        public MaybeSource<? extends T> f19545g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f19546h;

        public ConcatWithSubscriber(Subscriber<? super T> subscriber, MaybeSource<? extends T> maybeSource) {
            super(subscriber);
            this.f19545g = maybeSource;
        }

        public void cancel() {
            super.cancel();
            DisposableHelper.dispose(this.f19544f);
        }

        public void onComplete() {
            if (this.f19546h) {
                this.f23156b.onComplete();
                return;
            }
            this.f19546h = true;
            this.f23157c = SubscriptionHelper.CANCELLED;
            MaybeSource<? extends T> maybeSource = this.f19545g;
            this.f19545g = null;
            maybeSource.subscribe(this);
        }

        public void onError(Throwable th2) {
            this.f23156b.onError(th2);
        }

        public void onNext(T t11) {
            this.f23159e++;
            this.f23156b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f19544f, disposable);
        }

        public void onSuccess(T t11) {
            a(t11);
        }
    }

    public FlowableConcatWithMaybe(Flowable<T> flowable, MaybeSource<? extends T> maybeSource) {
        super(flowable);
        this.f19543d = maybeSource;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f19260c.subscribe(new ConcatWithSubscriber(subscriber, this.f19543d));
    }
}
