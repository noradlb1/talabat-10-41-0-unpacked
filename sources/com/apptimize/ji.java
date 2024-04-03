package com.apptimize;

public class ji<T> implements jj<T, T> {

    /* renamed from: a  reason: collision with root package name */
    private Class<T> f43113a;

    private ji(Class<T> cls) {
        this.f43113a = cls;
    }

    public static <T> ji<T> a(Class<T> cls) {
        return new ji<>(cls);
    }

    public T a(T t11) {
        return t11;
    }

    public Class<T> b() {
        return this.f43113a;
    }

    public T b(T t11) {
        return t11;
    }

    public Class<T> a() {
        return this.f43113a;
    }
}
