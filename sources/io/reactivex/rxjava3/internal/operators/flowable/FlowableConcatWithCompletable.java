package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableConcatWithCompletable<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final CompletableSource f19538d;

    public FlowableConcatWithCompletable(Flowable<T> flowable, CompletableSource completableSource) {
        super(flowable);
        this.f19538d = completableSource;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f19260c.subscribe(new ConcatWithSubscriber(subscriber, this.f19538d));
    }

    public static final class ConcatWithSubscriber<T> extends AtomicReference<Disposable> implements FlowableSubscriber<T>, CompletableObserver, Subscription {
        private static final long serialVersionUID = -7346385463600070225L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f19539b;

        /* renamed from: c  reason: collision with root package name */
        public Subscription f19540c;

        /* renamed from: d  reason: collision with root package name */
        public CompletableSource f19541d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f19542e;

        public ConcatWithSubscriber(Subscriber<? super T> subscriber, CompletableSource completableSource) {
            this.f19539b = subscriber;
            this.f19541d = completableSource;
        }

        public void cancel() {
            this.f19540c.cancel();
            DisposableHelper.dispose(this);
        }

        public void onComplete() {
            if (this.f19542e) {
                this.f19539b.onComplete();
                return;
            }
            this.f19542e = true;
            this.f19540c = SubscriptionHelper.CANCELLED;
            CompletableSource completableSource = this.f19541d;
            this.f19541d = null;
            completableSource.subscribe(this);
        }

        public void onError(Throwable th2) {
            this.f19539b.onError(th2);
        }

        public void onNext(T t11) {
            this.f19539b.onNext(t11);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f19540c, subscription)) {
                this.f19540c = subscription;
                this.f19539b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f19540c.request(j11);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }
}
