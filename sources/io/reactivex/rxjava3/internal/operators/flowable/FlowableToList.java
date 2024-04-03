package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.Collection;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableToList<T, U extends Collection<? super T>> extends AbstractFlowableWithUpstream<T, U> {

    /* renamed from: d  reason: collision with root package name */
    public final Supplier<U> f20570d;

    public static final class ToListSubscriber<T, U extends Collection<? super T>> extends DeferredScalarSubscription<U> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -8134157938864266736L;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f20571d;

        /* JADX WARNING: type inference failed for: r2v0, types: [T, U] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ToListSubscriber(org.reactivestreams.Subscriber<? super U> r1, U r2) {
            /*
                r0 = this;
                r0.<init>(r1)
                r0.f23171c = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableToList.ToListSubscriber.<init>(org.reactivestreams.Subscriber, java.util.Collection):void");
        }

        public void cancel() {
            super.cancel();
            this.f20571d.cancel();
        }

        public void onComplete() {
            complete(this.f23171c);
        }

        public void onError(Throwable th2) {
            this.f23171c = null;
            this.f23170b.onError(th2);
        }

        public void onNext(T t11) {
            Collection collection = (Collection) this.f23171c;
            if (collection != null) {
                collection.add(t11);
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f20571d, subscription)) {
                this.f20571d = subscription;
                this.f23170b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableToList(Flowable<T> flowable, Supplier<U> supplier) {
        super(flowable);
        this.f20570d = supplier;
    }

    public void subscribeActual(Subscriber<? super U> subscriber) {
        try {
            this.f19260c.subscribe(new ToListSubscriber(subscriber, (Collection) ExceptionHelper.nullCheck(this.f20570d.get(), "The collectionSupplier returned a null Collection.")));
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptySubscription.error(th2, subscriber);
        }
    }
}
