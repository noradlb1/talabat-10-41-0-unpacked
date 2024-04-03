package com.apptimize;

import org.json.JSONException;

public class jc<R, S, T> implements jj<R, T> {

    /* renamed from: a  reason: collision with root package name */
    private jj<S, T> f43108a;

    /* renamed from: b  reason: collision with root package name */
    private jj<R, S> f43109b;

    private jc(jj<S, T> jjVar, jj<R, S> jjVar2) {
        this.f43108a = jjVar;
        this.f43109b = jjVar2;
    }

    public static <R, S, T> jc<R, S, T> a(jj<S, T> jjVar, jj<R, S> jjVar2) {
        return new jc<>(jjVar, jjVar2);
    }

    public R b(T t11) throws JSONException, hk {
        return this.f43109b.b(this.f43108a.b(t11));
    }

    public T a(R r11) throws JSONException, hk {
        return this.f43108a.a(this.f43109b.a(r11));
    }

    public Class<? extends T> b() {
        return this.f43108a.b();
    }

    public Class<R> a() {
        return this.f43109b.a();
    }
}
