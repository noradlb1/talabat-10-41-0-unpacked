package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class ParallelConcatMap<T, R> extends ParallelFlowable<R> {

    /* renamed from: a  reason: collision with root package name */
    public final ParallelFlowable<T> f22584a;

    /* renamed from: b  reason: collision with root package name */
    public final Function<? super T, ? extends Publisher<? extends R>> f22585b;

    /* renamed from: c  reason: collision with root package name */
    public final int f22586c;

    /* renamed from: d  reason: collision with root package name */
    public final ErrorMode f22587d;

    public ParallelConcatMap(ParallelFlowable<T> parallelFlowable, Function<? super T, ? extends Publisher<? extends R>> function, int i11, ErrorMode errorMode) {
        this.f22584a = parallelFlowable;
        Objects.requireNonNull(function, "mapper");
        this.f22585b = function;
        this.f22586c = i11;
        Objects.requireNonNull(errorMode, "errorMode");
        this.f22587d = errorMode;
    }

    public int parallelism() {
        return this.f22584a.parallelism();
    }

    public void subscribe(Subscriber<? super R>[] subscriberArr) {
        Subscriber[] onSubscribe = RxJavaPlugins.onSubscribe(this, (Subscriber<? super T>[]) subscriberArr);
        if (a(onSubscribe)) {
            int length = onSubscribe.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i11 = 0; i11 < length; i11++) {
                subscriberArr2[i11] = FlowableConcatMap.subscribe(onSubscribe[i11], this.f22585b, this.f22586c, this.f22587d);
            }
            this.f22584a.subscribe(subscriberArr2);
        }
    }
}
