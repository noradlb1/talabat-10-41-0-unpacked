package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.functions.Function;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class SorterFunction<T> implements Function<List<T>, List<T>> {

    /* renamed from: b  reason: collision with root package name */
    public final Comparator<? super T> f23200b;

    public SorterFunction(Comparator<? super T> comparator) {
        this.f23200b = comparator;
    }

    public List<T> apply(List<T> list) {
        Collections.sort(list, this.f23200b);
        return list;
    }
}
