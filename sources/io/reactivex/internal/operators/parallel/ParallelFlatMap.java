package io.reactivex.internal.operators.parallel;

import io.reactivex.functions.Function;
import io.reactivex.internal.operators.flowable.FlowableFlatMap;
import io.reactivex.parallel.ParallelFlowable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class ParallelFlatMap<T, R> extends ParallelFlowable<R> {

    /* renamed from: a  reason: collision with root package name */
    public final ParallelFlowable<T> f18088a;

    /* renamed from: b  reason: collision with root package name */
    public final Function<? super T, ? extends Publisher<? extends R>> f18089b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f18090c;

    /* renamed from: d  reason: collision with root package name */
    public final int f18091d;

    /* renamed from: e  reason: collision with root package name */
    public final int f18092e;

    public ParallelFlatMap(ParallelFlowable<T> parallelFlowable, Function<? super T, ? extends Publisher<? extends R>> function, boolean z11, int i11, int i12) {
        this.f18088a = parallelFlowable;
        this.f18089b = function;
        this.f18090c = z11;
        this.f18091d = i11;
        this.f18092e = i12;
    }

    public int parallelism() {
        return this.f18088a.parallelism();
    }

    public void subscribe(Subscriber<? super R>[] subscriberArr) {
        if (a(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i11 = 0; i11 < length; i11++) {
                subscriberArr2[i11] = FlowableFlatMap.subscribe(subscriberArr[i11], this.f18089b, this.f18090c, this.f18091d, this.f18092e);
            }
            this.f18088a.subscribe(subscriberArr2);
        }
    }
}
