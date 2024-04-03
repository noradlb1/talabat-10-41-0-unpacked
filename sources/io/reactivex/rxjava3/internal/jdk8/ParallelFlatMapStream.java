package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import j$.util.stream.Stream;
import org.reactivestreams.Subscriber;

public final class ParallelFlatMapStream<T, R> extends ParallelFlowable<R> {

    /* renamed from: a  reason: collision with root package name */
    public final ParallelFlowable<T> f18964a;

    /* renamed from: b  reason: collision with root package name */
    public final Function<? super T, ? extends Stream<? extends R>> f18965b;

    /* renamed from: c  reason: collision with root package name */
    public final int f18966c;

    public ParallelFlatMapStream(ParallelFlowable<T> parallelFlowable, Function<? super T, ? extends Stream<? extends R>> function, int i11) {
        this.f18964a = parallelFlowable;
        this.f18965b = function;
        this.f18966c = i11;
    }

    public int parallelism() {
        return this.f18964a.parallelism();
    }

    public void subscribe(Subscriber<? super R>[] subscriberArr) {
        if (a(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i11 = 0; i11 < length; i11++) {
                subscriberArr2[i11] = FlowableFlatMapStream.subscribe(subscriberArr[i11], this.f18965b, this.f18966c);
            }
            this.f18964a.subscribe(subscriberArr2);
        }
    }
}
