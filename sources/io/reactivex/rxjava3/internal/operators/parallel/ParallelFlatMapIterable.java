package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFlattenIterable;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;

public final class ParallelFlatMapIterable<T, R> extends ParallelFlowable<R> {

    /* renamed from: a  reason: collision with root package name */
    public final ParallelFlowable<T> f22624a;

    /* renamed from: b  reason: collision with root package name */
    public final Function<? super T, ? extends Iterable<? extends R>> f22625b;

    /* renamed from: c  reason: collision with root package name */
    public final int f22626c;

    public ParallelFlatMapIterable(ParallelFlowable<T> parallelFlowable, Function<? super T, ? extends Iterable<? extends R>> function, int i11) {
        this.f22624a = parallelFlowable;
        this.f22625b = function;
        this.f22626c = i11;
    }

    public int parallelism() {
        return this.f22624a.parallelism();
    }

    public void subscribe(Subscriber<? super R>[] subscriberArr) {
        Subscriber[] onSubscribe = RxJavaPlugins.onSubscribe(this, (Subscriber<? super T>[]) subscriberArr);
        if (a(onSubscribe)) {
            int length = onSubscribe.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i11 = 0; i11 < length; i11++) {
                subscriberArr2[i11] = FlowableFlattenIterable.subscribe(onSubscribe[i11], this.f22625b, this.f22626c);
            }
            this.f22624a.subscribe(subscriberArr2);
        }
    }
}
