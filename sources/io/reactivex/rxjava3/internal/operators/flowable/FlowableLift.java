package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableOperator;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;

public final class FlowableLift<R, T> extends AbstractFlowableWithUpstream<T, R> {

    /* renamed from: d  reason: collision with root package name */
    public final FlowableOperator<? extends R, ? super T> f19986d;

    public FlowableLift(Flowable<T> flowable, FlowableOperator<? extends R, ? super T> flowableOperator) {
        super(flowable);
        this.f19986d = flowableOperator;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        try {
            Subscriber<? super Object> apply = this.f19986d.apply(subscriber);
            if (apply != null) {
                this.f19260c.subscribe(apply);
                return;
            }
            throw new NullPointerException("Operator " + this.f19986d + " returned a null Subscriber");
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
