package io.reactivex.internal.operators.parallel;

import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.parallel.ParallelFlowable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class ParallelConcatMap<T, R> extends ParallelFlowable<R> {

    /* renamed from: a  reason: collision with root package name */
    public final ParallelFlowable<T> f18053a;

    /* renamed from: b  reason: collision with root package name */
    public final Function<? super T, ? extends Publisher<? extends R>> f18054b;

    /* renamed from: c  reason: collision with root package name */
    public final int f18055c;

    /* renamed from: d  reason: collision with root package name */
    public final ErrorMode f18056d;

    public ParallelConcatMap(ParallelFlowable<T> parallelFlowable, Function<? super T, ? extends Publisher<? extends R>> function, int i11, ErrorMode errorMode) {
        this.f18053a = parallelFlowable;
        this.f18054b = (Function) ObjectHelper.requireNonNull(function, "mapper");
        this.f18055c = i11;
        this.f18056d = (ErrorMode) ObjectHelper.requireNonNull(errorMode, "errorMode");
    }

    public int parallelism() {
        return this.f18053a.parallelism();
    }

    public void subscribe(Subscriber<? super R>[] subscriberArr) {
        if (a(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i11 = 0; i11 < length; i11++) {
                subscriberArr2[i11] = FlowableConcatMap.subscribe(subscriberArr[i11], this.f18054b, this.f18055c, this.f18056d);
            }
            this.f18053a.subscribe(subscriberArr2);
        }
    }
}
