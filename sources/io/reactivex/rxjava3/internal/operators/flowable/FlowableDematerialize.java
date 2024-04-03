package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDematerialize<T, R> extends AbstractFlowableWithUpstream<T, R> {

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends Notification<R>> f19623d;

    public static final class DematerializeSubscriber<T, R> implements FlowableSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f19624b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends Notification<R>> f19625c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f19626d;

        /* renamed from: e  reason: collision with root package name */
        public Subscription f19627e;

        public DematerializeSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Notification<R>> function) {
            this.f19624b = subscriber;
            this.f19625c = function;
        }

        public void cancel() {
            this.f19627e.cancel();
        }

        public void onComplete() {
            if (!this.f19626d) {
                this.f19626d = true;
                this.f19624b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f19626d) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f19626d = true;
            this.f19624b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f19626d) {
                try {
                    Object apply = this.f19625c.apply(t11);
                    Objects.requireNonNull(apply, "The selector returned a null Notification");
                    Notification notification = (Notification) apply;
                    if (notification.isOnError()) {
                        this.f19627e.cancel();
                        onError(notification.getError());
                    } else if (notification.isOnComplete()) {
                        this.f19627e.cancel();
                        onComplete();
                    } else {
                        this.f19624b.onNext(notification.getValue());
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f19627e.cancel();
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
            if (SubscriptionHelper.validate(this.f19627e, subscription)) {
                this.f19627e = subscription;
                this.f19624b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f19627e.request(j11);
        }
    }

    public FlowableDematerialize(Flowable<T> flowable, Function<? super T, ? extends Notification<R>> function) {
        super(flowable);
        this.f19623d = function;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f19260c.subscribe(new DematerializeSubscriber(subscriber, this.f19623d));
    }
}
