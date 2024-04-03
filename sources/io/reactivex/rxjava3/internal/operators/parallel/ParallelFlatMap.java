package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFlatMap;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class ParallelFlatMap<T, R> extends ParallelFlowable<R> {

    /* renamed from: a  reason: collision with root package name */
    public final ParallelFlowable<T> f22619a;

    /* renamed from: b  reason: collision with root package name */
    public final Function<? super T, ? extends Publisher<? extends R>> f22620b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f22621c;

    /* renamed from: d  reason: collision with root package name */
    public final int f22622d;

    /* renamed from: e  reason: collision with root package name */
    public final int f22623e;

    public ParallelFlatMap(ParallelFlowable<T> parallelFlowable, Function<? super T, ? extends Publisher<? extends R>> function, boolean z11, int i11, int i12) {
        this.f22619a = parallelFlowable;
        this.f22620b = function;
        this.f22621c = z11;
        this.f22622d = i11;
        this.f22623e = i12;
    }

    public int parallelism() {
        return this.f22619a.parallelism();
    }

    public void subscribe(Subscriber<? super R>[] subscriberArr) {
        Subscriber[] onSubscribe = RxJavaPlugins.onSubscribe(this, (Subscriber<? super T>[]) subscriberArr);
        if (a(onSubscribe)) {
            int length = onSubscribe.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i11 = 0; i11 < length; i11++) {
                subscriberArr2[i11] = FlowableFlatMap.subscribe(onSubscribe[i11], this.f22620b, this.f22621c, this.f22622d, this.f22623e);
            }
            this.f22619a.subscribe(subscriberArr2);
        }
    }
}
