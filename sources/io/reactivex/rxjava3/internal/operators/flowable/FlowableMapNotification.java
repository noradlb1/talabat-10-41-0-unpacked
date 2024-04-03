package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscribers.SinglePostCompleteSubscriber;
import java.util.Objects;
import org.reactivestreams.Subscriber;

public final class FlowableMapNotification<T, R> extends AbstractFlowableWithUpstream<T, R> {

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends R> f19990d;

    /* renamed from: e  reason: collision with root package name */
    public final Function<? super Throwable, ? extends R> f19991e;

    /* renamed from: f  reason: collision with root package name */
    public final Supplier<? extends R> f19992f;

    public static final class MapNotificationSubscriber<T, R> extends SinglePostCompleteSubscriber<T, R> {
        private static final long serialVersionUID = 2757120512858778108L;

        /* renamed from: f  reason: collision with root package name */
        public final Function<? super T, ? extends R> f19993f;

        /* renamed from: g  reason: collision with root package name */
        public final Function<? super Throwable, ? extends R> f19994g;

        /* renamed from: h  reason: collision with root package name */
        public final Supplier<? extends R> f19995h;

        public MapNotificationSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends R> function, Function<? super Throwable, ? extends R> function2, Supplier<? extends R> supplier) {
            super(subscriber);
            this.f19993f = function;
            this.f19994g = function2;
            this.f19995h = supplier;
        }

        public void onComplete() {
            try {
                Object obj = this.f19995h.get();
                Objects.requireNonNull(obj, "The onComplete publisher returned is null");
                a(obj);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f23156b.onError(th2);
            }
        }

        public void onError(Throwable th2) {
            try {
                Object apply = this.f19994g.apply(th2);
                Objects.requireNonNull(apply, "The onError publisher returned is null");
                a(apply);
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.f23156b.onError(new CompositeException(th2, th3));
            }
        }

        public void onNext(T t11) {
            try {
                Object apply = this.f19993f.apply(t11);
                Objects.requireNonNull(apply, "The onNext publisher returned is null");
                this.f23159e++;
                this.f23156b.onNext(apply);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f23156b.onError(th2);
            }
        }
    }

    public FlowableMapNotification(Flowable<T> flowable, Function<? super T, ? extends R> function, Function<? super Throwable, ? extends R> function2, Supplier<? extends R> supplier) {
        super(flowable);
        this.f19990d = function;
        this.f19991e = function2;
        this.f19992f = supplier;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f19260c.subscribe(new MapNotificationSubscriber(subscriber, this.f19990d, this.f19991e, this.f19992f));
    }
}
