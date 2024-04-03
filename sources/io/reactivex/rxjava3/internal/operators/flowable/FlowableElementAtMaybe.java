package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public final class FlowableElementAtMaybe<T> extends Maybe<T> implements FuseToFlowable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Flowable<T> f19684b;

    /* renamed from: c  reason: collision with root package name */
    public final long f19685c;

    public static final class ElementAtSubscriber<T> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f19686b;

        /* renamed from: c  reason: collision with root package name */
        public final long f19687c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f19688d;

        /* renamed from: e  reason: collision with root package name */
        public long f19689e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f19690f;

        public ElementAtSubscriber(MaybeObserver<? super T> maybeObserver, long j11) {
            this.f19686b = maybeObserver;
            this.f19687c = j11;
        }

        public void dispose() {
            this.f19688d.cancel();
            this.f19688d = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f19688d == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            this.f19688d = SubscriptionHelper.CANCELLED;
            if (!this.f19690f) {
                this.f19690f = true;
                this.f19686b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f19690f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f19690f = true;
            this.f19688d = SubscriptionHelper.CANCELLED;
            this.f19686b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f19690f) {
                long j11 = this.f19689e;
                if (j11 == this.f19687c) {
                    this.f19690f = true;
                    this.f19688d.cancel();
                    this.f19688d = SubscriptionHelper.CANCELLED;
                    this.f19686b.onSuccess(t11);
                    return;
                }
                this.f19689e = j11 + 1;
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f19688d, subscription)) {
                this.f19688d = subscription;
                this.f19686b.onSubscribe(this);
                subscription.request(this.f19687c + 1);
            }
        }
    }

    public FlowableElementAtMaybe(Flowable<T> flowable, long j11) {
        this.f19684b = flowable;
        this.f19685c = j11;
    }

    public Flowable<T> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableElementAt(this.f19684b, this.f19685c, null, false));
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f19684b.subscribe(new ElementAtSubscriber(maybeObserver, this.f19685c));
    }
}
