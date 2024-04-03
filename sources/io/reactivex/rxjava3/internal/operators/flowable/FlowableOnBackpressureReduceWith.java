package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Supplier;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

public final class FlowableOnBackpressureReduceWith<T, R> extends AbstractFlowableWithUpstream<T, R> {

    /* renamed from: d  reason: collision with root package name */
    public final BiFunction<R, ? super T, R> f20096d;

    /* renamed from: e  reason: collision with root package name */
    public final Supplier<R> f20097e;

    public static final class BackpressureReduceWithSubscriber<T, R> extends AbstractBackpressureThrottlingSubscriber<T, R> {
        private static final long serialVersionUID = 8255923705960622424L;

        /* renamed from: i  reason: collision with root package name */
        public final BiFunction<R, ? super T, R> f20098i;

        /* renamed from: j  reason: collision with root package name */
        public final Supplier<R> f20099j;

        public BackpressureReduceWithSubscriber(@NonNull Subscriber<? super R> subscriber, @NonNull Supplier<R> supplier, @NonNull BiFunction<R, ? super T, R> biFunction) {
            super(subscriber);
            this.f20098i = biFunction;
            this.f20099j = supplier;
        }

        public void onNext(T t11) {
            R r11 = this.f19259h.get();
            if (r11 != null) {
                r11 = this.f19259h.getAndSet((Object) null);
            }
            if (r11 == null) {
                try {
                    AtomicReference<R> atomicReference = this.f19259h;
                    BiFunction<R, ? super T, R> biFunction = this.f20098i;
                    R r12 = this.f20099j.get();
                    Objects.requireNonNull(r12, "The supplier returned a null value");
                    R apply = biFunction.apply(r12, t11);
                    Objects.requireNonNull(apply, "The reducer returned a null value");
                    atomicReference.lazySet(apply);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f19254c.cancel();
                    onError(th2);
                    return;
                }
            } else {
                AtomicReference<R> atomicReference2 = this.f19259h;
                R apply2 = this.f20098i.apply(r11, t11);
                Objects.requireNonNull(apply2, "The reducer returned a null value");
                atomicReference2.lazySet(apply2);
            }
            b();
        }
    }

    public FlowableOnBackpressureReduceWith(@NonNull Flowable<T> flowable, @NonNull Supplier<R> supplier, @NonNull BiFunction<R, ? super T, R> biFunction) {
        super(flowable);
        this.f20096d = biFunction;
        this.f20097e = supplier;
    }

    public void subscribeActual(@NonNull Subscriber<? super R> subscriber) {
        this.f19260c.subscribe(new BackpressureReduceWithSubscriber(subscriber, this.f20097e, this.f20096d));
    }
}
