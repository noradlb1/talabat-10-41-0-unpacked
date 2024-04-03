package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.ScalarSubscription;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableScalarXMap {

    public static final class ScalarXMapFlowable<T, R> extends Flowable<R> {

        /* renamed from: c  reason: collision with root package name */
        public final T f15786c;

        /* renamed from: d  reason: collision with root package name */
        public final Function<? super T, ? extends Publisher<? extends R>> f15787d;

        public ScalarXMapFlowable(T t11, Function<? super T, ? extends Publisher<? extends R>> function) {
            this.f15786c = t11;
            this.f15787d = function;
        }

        public void subscribeActual(Subscriber<? super R> subscriber) {
            try {
                Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.f15787d.apply(this.f15786c), "The mapper returned a null Publisher");
                if (publisher instanceof Callable) {
                    try {
                        Object call = ((Callable) publisher).call();
                        if (call == null) {
                            EmptySubscription.complete(subscriber);
                        } else {
                            subscriber.onSubscribe(new ScalarSubscription(subscriber, call));
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        EmptySubscription.error(th2, subscriber);
                    }
                } else {
                    publisher.subscribe(subscriber);
                }
            } catch (Throwable th3) {
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
        if (!(publisher instanceof Callable)) {
            return false;
        }
        try {
            Object call = ((Callable) publisher).call();
            if (call == null) {
                EmptySubscription.complete(subscriber);
                return true;
            }
            try {
                Publisher publisher2 = (Publisher) ObjectHelper.requireNonNull(function.apply(call), "The mapper returned a null Publisher");
                if (publisher2 instanceof Callable) {
                    try {
                        Object call2 = ((Callable) publisher2).call();
                        if (call2 == null) {
                            EmptySubscription.complete(subscriber);
                            return true;
                        }
                        subscriber.onSubscribe(new ScalarSubscription(subscriber, call2));
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
