package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.ScalarSubscription;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableScalarXMap {

    public static final class ScalarXMapFlowable<T, R> extends Flowable<R> {

        /* renamed from: c  reason: collision with root package name */
        public final T f20296c;

        /* renamed from: d  reason: collision with root package name */
        public final Function<? super T, ? extends Publisher<? extends R>> f20297d;

        public ScalarXMapFlowable(T t11, Function<? super T, ? extends Publisher<? extends R>> function) {
            this.f20296c = t11;
            this.f20297d = function;
        }

        public void subscribeActual(Subscriber<? super R> subscriber) {
            try {
                Object apply = this.f20297d.apply(this.f20296c);
                Objects.requireNonNull(apply, "The mapper returned a null Publisher");
                Publisher publisher = (Publisher) apply;
                if (publisher instanceof Supplier) {
                    try {
                        Object obj = ((Supplier) publisher).get();
                        if (obj == null) {
                            EmptySubscription.complete(subscriber);
                        } else {
                            subscriber.onSubscribe(new ScalarSubscription(subscriber, obj));
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        EmptySubscription.error(th2, subscriber);
                    }
                } else {
                    publisher.subscribe(subscriber);
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                EmptySubscription.error(th3, subscriber);
            }
        }
    }

    private FlowableScalarXMap() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> Flowable<U> scalarXMap(T t11, Function<? super T, ? extends Publisher<? extends U>> function) {
        return RxJavaPlugins.onAssembly(new ScalarXMapFlowable(t11, function));
    }

    public static <T, R> boolean tryScalarXMapSubscribe(Publisher<T> publisher, Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function) {
        if (!(publisher instanceof Supplier)) {
            return false;
        }
        try {
            Object obj = ((Supplier) publisher).get();
            if (obj == null) {
                EmptySubscription.complete(subscriber);
                return true;
            }
            try {
                Object apply = function.apply(obj);
                Objects.requireNonNull(apply, "The mapper returned a null Publisher");
                Publisher publisher2 = (Publisher) apply;
                if (publisher2 instanceof Supplier) {
                    try {
                        Object obj2 = ((Supplier) publisher2).get();
                        if (obj2 == null) {
                            EmptySubscription.complete(subscriber);
                            return true;
                        }
                        subscriber.onSubscribe(new ScalarSubscription(subscriber, obj2));
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        EmptySubscription.error(th2, subscriber);
                        return true;
                    }
                } else {
                    publisher2.subscribe(subscriber);
                }
                return true;
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                EmptySubscription.error(th3, subscriber);
                return true;
            }
        } catch (Throwable th4) {
            Exceptions.throwIfFatal(th4);
            EmptySubscription.error(th4, subscriber);
            return true;
        }
    }
}
