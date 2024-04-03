package io.reactivex.internal.operators.flowable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableConcatWithCompletable<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final CompletableSource f15032d;

    public FlowableConcatWithCompletable(Flowable<T> flowable, CompletableSource completableSource) {
        super(flowable);
        this.f15032d = completableSource;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f14763c.subscribe(new ConcatWithSubscriber(subscriber, this.f15032d));
    }

    public static final class ConcatWithSubscriber<T> extends AtomicReference<Disposable> implements FlowableSubscriber<T>, CompletableObserver, Subscription {
        private static final long serialVersionUID = -7346385463600070225L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15033b;

        /* renamed from: c  reason: collision with root package name */
        public Subscription f15034c;

        /* renamed from: d  reason: collision with root package name */
        public CompletableSource f15035d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f15036e;

        public ConcatWithSubscriber(Subscriber<? super T> subscriber, CompletableSource completableSource) {
            this.f15033b = subscriber;
            this.f15035d = completableSource;
        }

        public void cancel() {
            this.f15034c.cancel();
            DisposableHelper.dispose(this);
        }

        public void onComplete() {
            if (this.f15036e) {
                this.f15033b.onComplete();
                return;
            }
            this.f15036e = true;
            this.f15034c = SubscriptionHelper.CANCELLED;
            CompletableSource completableSource = this.f15035d;
            this.f15035d = null;
            completableSource.subscribe(this);
        }

        public void onError(Throwable th2) {
            this.f15033b.onError(th2);
        }

        public void onNext(T t11) {
            this.f15033b.onNext(t11);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15034c, subscription)) {
                this.f15034c = subscription;
                this.f15033b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f15034c.request(j11);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }
}
