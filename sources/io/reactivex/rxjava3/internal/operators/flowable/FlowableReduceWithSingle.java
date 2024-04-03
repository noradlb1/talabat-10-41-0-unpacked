package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableReduceSeedSingle;
import java.util.Objects;
import org.reactivestreams.Publisher;

public final class FlowableReduceWithSingle<T, R> extends Single<R> {

    /* renamed from: b  reason: collision with root package name */
    public final Publisher<T> f20183b;

    /* renamed from: c  reason: collision with root package name */
    public final Supplier<R> f20184c;

    /* renamed from: d  reason: collision with root package name */
    public final BiFunction<R, ? super T, R> f20185d;

    public FlowableReduceWithSingle(Publisher<T> publisher, Supplier<R> supplier, BiFunction<R, ? super T, R> biFunction) {
        this.f20183b = publisher;
        this.f20184c = supplier;
        this.f20185d = biFunction;
    }

    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        try {
            R r11 = this.f20184c.get();
            Objects.requireNonNull(r11, "The seedSupplier returned a null value");
            this.f20183b.subscribe(new FlowableReduceSeedSingle.ReduceSeedObserver(singleObserver, this.f20185d, r11));
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (SingleObserver<?>) singleObserver);
        }
    }
}
