package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public final class FlowableElementAtMaybe<T> extends Maybe<T> implements FuseToFlowable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Flowable<T> f15178b;

    /* renamed from: c  reason: collision with root package name */
    public final long f15179c;

    public static final class ElementAtSubscriber<T> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f15180b;

        /* renamed from: c  reason: collision with root package name */
        public final long f15181c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f15182d;

        /* renamed from: e  reason: collision with root package name */
        public long f15183e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f15184f;

        public ElementAtSubscriber(MaybeObserver<? super T> maybeObserver, long j11) {
            this.f15180b = maybeObserver;
            this.f15181c = j11;
        }

        public void dispose() {
            this.f15182d.cancel();
            this.f15182d = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f15182d == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            this.f15182d = SubscriptionHelper.CANCELLED;
            if (!this.f15184f) {
                this.f15184f = true;
                this.f15180b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f15184f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f15184f = true;
            this.f15182d = SubscriptionHelper.CANCELLED;
            this.f15180b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f15184f) {
                long j11 = this.f15183e;
                if (j11 == this.f15181c) {
                    this.f15184f = true;
                    this.f15182d.cancel();
                    this.f15182d = SubscriptionHelper.CANCELLED;
                    this.f15180b.onSuccess(t11);
                    return;
                }
                this.f15183e = j11 + 1;
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15182d, subscription)) {
                this.f15182d = subscription;
                this.f15180b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableElementAtMaybe(Flowable<T> flowable, long j11) {
        this.f15178b = flowable;
        this.f15179c = j11;
    }

    public Flowable<T> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableElementAt(this.f15178b, this.f15179c, null, false));
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f15178b.subscribe(new ElementAtSubscriber(maybeObserver, this.f15179c));
    }
}
