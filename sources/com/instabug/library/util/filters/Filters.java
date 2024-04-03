package com.instabug.library.util.filters;

import com.instabug.library.util.filters.actions.a;
import com.instabug.library.util.filters.actions.b;

public class Filters<T> {

    /* renamed from: t  reason: collision with root package name */
    private T f52064t;

    private Filters(T t11) {
        this.f52064t = t11;
    }

    public static <T> Filters<T> applyOn(T t11) {
        return new Filters<>(t11);
    }

    public Filters<T> apply(Filter<T> filter) {
        this.f52064t = filter.apply(this.f52064t);
        return this;
    }

    public void thenDo(a aVar) {
        aVar.apply(this.f52064t);
    }

    public <N> N thenDoReturn(b bVar) {
        return bVar.apply(this.f52064t);
    }

    public T thenGet() {
        return this.f52064t;
    }
}
