package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

public final class FlowableOnBackpressureReduce<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final BiFunction<T, T, T> f20094d;

    public static final class BackpressureReduceSubscriber<T> extends AbstractBackpressureThrottlingSubscriber<T, T> {
        private static final long serialVersionUID = 821363947659780367L;

        /* renamed from: i  reason: collision with root package name */
        public final BiFunction<T, T, T> f20095i;

        public BackpressureReduceSubscriber(@NonNull Subscriber<? super T> subscriber, @NonNull BiFunction<T, T, T> biFunction) {
            super(subscriber);
            this.f20095i = biFunction;
        }

        public void onNext(T t11) {
            R r11 = this.f19259h.get();
            if (r11 != null) {
                r11 = this.f19259h.getAndSet((Object) null);
            }
            if (r11 == null) {
                this.f19259h.lazySet(t11);
            } else {
                try {
                    AtomicReference<R> atomicReference = this.f19259h;
                    T apply = this.f20095i.apply(r11, t11);
                    Objects.requireNonNull(apply, "The reducer returned a null value");
                    atomicReference.lazySet(apply);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f19254c.cancel();
                    onError(th2);
                    return;
                }
            }
            b();
        }
    }

    public FlowableOnBackpressureReduce(@NonNull Flowable<T> flowable, @NonNull BiFunction<T, T, T> biFunction) {
        super(flowable);
        this.f20094d = biFunction;
    }

    public void subscribeActual(@NonNull Subscriber<? super T> subscriber) {
        this.f19260c.subscribe(new BackpressureReduceSubscriber(subscriber, this.f20094d));
    }
}
