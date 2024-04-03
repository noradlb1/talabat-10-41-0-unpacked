package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Collection;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableToList<T, U extends Collection<? super T>> extends AbstractFlowableWithUpstream<T, U> {

    /* renamed from: d  reason: collision with root package name */
    public final Callable<U> f16062d;

    public static final class ToListSubscriber<T, U extends Collection<? super T>> extends DeferredScalarSubscription<U> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -8134157938864266736L;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f16063d;

        /* JADX WARNING: type inference failed for: r2v0, types: [T, U] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ToListSubscriber(org.reactivestreams.Subscriber<? super U> r1, U r2) {
            /*
                r0 = this;
                r0.<init>(r1)
                r0.f18610c = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableToList.ToListSubscriber.<init>(org.reactivestreams.Subscriber, java.util.Collection):void");
        }

        public void cancel() {
            super.cancel();
            this.f16063d.cancel();
        }

        public void onComplete() {
            complete(this.f18610c);
        }

        public void onError(Throwable th2) {
            this.f18610c = null;
            this.f18609b.onError(th2);
        }

        public void onNext(T t11) {
            Collection collection = (Collection) this.f18610c;
            if (collection != null) {
                collection.add(t11);
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f16063d, subscription)) {
                this.f16063d = subscription;
                this.f18609b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableToList(Flowable<T> flowable, Callable<U> callable) {
        super(flowable);
        this.f16062d = callable;
    }

    public void subscribeActual(Subscriber<? super U> subscriber) {
        try {
            this.f14763c.subscribe(new ToListSubscriber(subscriber, (Collection) ObjectHelper.requireNonNull(this.f16062d.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptySubscription.error(th2, subscriber);
        }
    }
}
