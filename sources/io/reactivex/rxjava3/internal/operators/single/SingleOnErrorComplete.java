package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeOnErrorComplete;

public final class SingleOnErrorComplete<T> extends Maybe<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Single<T> f22942b;

    /* renamed from: c  reason: collision with root package name */
    public final Predicate<? super Throwable> f22943c;

    public SingleOnErrorComplete(Single<T> single, Predicate<? super Throwable> predicate) {
        this.f22942b = single;
        this.f22943c = predicate;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f22942b.subscribe(new MaybeOnErrorComplete.OnErrorCompleteMultiObserver(maybeObserver, this.f22943c));
    }
}
