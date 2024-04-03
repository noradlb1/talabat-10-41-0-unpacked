package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.jdk8.MaybeFlattenStreamAsObservable;
import j$.util.stream.Stream;

public final class SingleFlattenStreamAsObservable<T, R> extends Observable<R> {

    /* renamed from: b  reason: collision with root package name */
    public final Single<T> f18993b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends Stream<? extends R>> f18994c;

    public SingleFlattenStreamAsObservable(Single<T> single, Function<? super T, ? extends Stream<? extends R>> function) {
        this.f18993b = single;
        this.f18994c = function;
    }

    public void subscribeActual(@NonNull Observer<? super R> observer) {
        this.f18993b.subscribe(new MaybeFlattenStreamAsObservable.FlattenStreamMultiObserver(observer, this.f18994c));
    }
}
