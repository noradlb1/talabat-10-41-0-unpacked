package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Notification;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDematerialize<T, R> extends AbstractFlowableWithUpstream<T, R> {

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends Notification<R>> f15117d;

    public static final class DematerializeSubscriber<T, R> implements FlowableSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f15118b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends Notification<R>> f15119c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f15120d;

        /* renamed from: e  reason: collision with root package name */
        public Subscription f15121e;

        public DematerializeSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Notification<R>> function) {
            this.f15118b = subscriber;
            this.f15119c = function;
        }

        public void cancel() {
            this.f15121e.cancel();
        }

        public void onComplete() {
            if (!this.f15120d) {
                this.f15120d = true;
                this.f15118b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f15120d) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f15120d = true;
            this.f15118b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f15120d) {
                try {
                    Notification notification = (Notification) ObjectHelper.requireNonNull(this.f15119c.apply(t11), "The selector returned a null Notification");
                    if (notification.isOnError()) {
                        this.f15121e.cancel();
                        onError(notification.getError());
                    } else if (notification.isOnComplete()) {
                        this.f15121e.cancel();
                        onComplete();
                    } else {
                        this.f15118b.onNext(notification.getValue());
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f15121e.cancel();
                    onError(th2);
                }
            } else if (t11 instanceof Notification) {
                Notification notification2 = (Notification) t11;
                if (notification2.isOnError()) {
                    RxJavaPlugins.onError(notification2.getError());
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15121e, subscription)) {
                this.f15121e = subscription;
                this.f15118b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f15121e.request(j11);
        }
    }

    public FlowableDematerialize(Flowable<T> flowable, Function<? super T, ? extends Notification<R>> function) {
        super(flowable);
        this.f15117d = function;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f14763c.subscribe(new DematerializeSubscriber(subscriber, this.f15117d));
    }
}
