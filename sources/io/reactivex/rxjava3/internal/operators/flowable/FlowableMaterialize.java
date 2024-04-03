package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;

public final class FlowableMaterialize<T> extends AbstractFlowableWithUpstream<T, Notification<T>> {

    public static final class MaterializeSubscriber<T> extends SinglePostCompleteSubscriber<T, Notification<T>> {
        private static final long serialVersionUID = -3740826063558713822L;

        public MaterializeSubscriber(Subscriber<? super Notification<T>> subscriber) {
            super(subscriber);
        }

        /* renamed from: c */
        public void b(Notification<T> notification) {
            if (notification.isOnError()) {
                RxJavaPlugins.onError(notification.getError());
            }
        }

        public void onComplete() {
            a(Notification.createOnComplete());
        }

        public void onError(Throwable th2) {
            a(Notification.createOnError(th2));
        }

        public void onNext(T t11) {
            this.f23159e++;
            this.f23156b.onNext(Notification.createOnNext(t11));
        }
    }

    public FlowableMaterialize(Flowable<T> flowable) {
        super(flowable);
    }

    public void subscribeActual(Subscriber<? super Notification<T>> subscriber) {
        this.f19260c.subscribe(new MaterializeSubscriber(subscriber));
    }
}
