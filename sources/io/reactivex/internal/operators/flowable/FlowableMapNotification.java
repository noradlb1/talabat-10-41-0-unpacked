package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

public final class FlowableMapNotification<T, R> extends AbstractFlowableWithUpstream<T, R> {

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends R> f15467d;

    /* renamed from: e  reason: collision with root package name */
    public final Function<? super Throwable, ? extends R> f15468e;

    /* renamed from: f  reason: collision with root package name */
    public final Callable<? extends R> f15469f;

    public static final class MapNotificationSubscriber<T, R> extends SinglePostCompleteSubscriber<T, R> {
        private static final long serialVersionUID = 2757120512858778108L;

        /* renamed from: f  reason: collision with root package name */
        public final Function<? super T, ? extends R> f15470f;

        /* renamed from: g  reason: collision with root package name */
        public final Function<? super Throwable, ? extends R> f15471g;

        /* renamed from: h  reason: collision with root package name */
        public final Callable<? extends R> f15472h;

        public MapNotificationSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends R> function, Function<? super Throwable, ? extends R> function2, Callable<? extends R> callable) {
            super(subscriber);
            this.f15470f = function;
            this.f15471g = function2;
            this.f15472h = callable;
        }

        public void onComplete() {
            try {
                a(ObjectHelper.requireNonNull(this.f15472h.call(), "The onComplete publisher returned is null"));
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f18595b.onError(th2);
            }
        }

        public void onError(Throwable th2) {
            try {
                a(ObjectHelper.requireNonNull(this.f15471g.apply(th2), "The onError publisher returned is null"));
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.f18595b.onError(new CompositeException(th2, th3));
            }
        }

        public void onNext(T t11) {
            try {
                Object requireNonNull = ObjectHelper.requireNonNull(this.f15470f.apply(t11), "The onNext publisher returned is null");
                this.f18598e++;
                this.f18595b.onNext(requireNonNull);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f18595b.onError(th2);
            }
        }
    }

    public FlowableMapNotification(Flowable<T> flowable, Function<? super T, ? extends R> function, Function<? super Throwable, ? extends R> function2, Callable<? extends R> callable) {
        super(flowable);
        this.f15467d = function;
        this.f15468e = function2;
        this.f15469f = callable;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f14763c.subscribe(new MapNotificationSubscriber(subscriber, this.f15467d, this.f15468e, this.f15469f));
    }
}
