package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableOperator;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;

public final class FlowableLift<R, T> extends AbstractFlowableWithUpstream<T, R> {

    /* renamed from: d  reason: collision with root package name */
    public final FlowableOperator<? extends R, ? super T> f15459d;

    public FlowableLift(Flowable<T> flowable, FlowableOperator<? extends R, ? super T> flowableOperator) {
        super(flowable);
        this.f15459d = flowableOperator;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        try {
            Subscriber<? super Object> apply = this.f15459d.apply(subscriber);
            if (apply != null) {
                this.f14763c.subscribe(apply);
                return;
            }
            throw new NullPointerException("Operator " + this.f15459d + " returned a null Subscriber");
        } catch (NullPointerException e11) {
            throw e11;
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(th2);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th2);
            throw nullPointerException;
        }
    }
}
