package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.jdk8.MaybeFlattenStreamAsFlowable;
import j$.util.stream.Stream;
import org.reactivestreams.Subscriber;

public final class SingleFlattenStreamAsFlowable<T, R> extends Flowable<R> {

    /* renamed from: c  reason: collision with root package name */
    public final Single<T> f18991c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends Stream<? extends R>> f18992d;

    public SingleFlattenStreamAsFlowable(Single<T> single, Function<? super T, ? extends Stream<? extends R>> function) {
        this.f18991c = single;
        this.f18992d = function;
    }

    public void subscribeActual(@NonNull Subscriber<? super R> subscriber) {
        this.f18991c.subscribe(new MaybeFlattenStreamAsFlowable.FlattenStreamMultiObserver(subscriber, this.f18992d));
    }
}
