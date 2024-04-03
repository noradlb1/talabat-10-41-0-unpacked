package io.reactivex.internal.operators.flowable;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableReduceSeedSingle;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;

public final class FlowableReduceWithSingle<T, R> extends Single<R> {

    /* renamed from: b  reason: collision with root package name */
    public final Publisher<T> f15676b;

    /* renamed from: c  reason: collision with root package name */
    public final Callable<R> f15677c;

    /* renamed from: d  reason: collision with root package name */
    public final BiFunction<R, ? super T, R> f15678d;

    public FlowableReduceWithSingle(Publisher<T> publisher, Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        this.f15676b = publisher;
        this.f15677c = callable;
        this.f15678d = biFunction;
    }

    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        try {
            this.f15676b.subscribe(new FlowableReduceSeedSingle.ReduceSeedObserver(singleObserver, this.f15678d, ObjectHelper.requireNonNull(this.f15677c.call(), "The seedSupplier returned a null value")));
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (SingleObserver<?>) singleObserver);
        }
    }
}
