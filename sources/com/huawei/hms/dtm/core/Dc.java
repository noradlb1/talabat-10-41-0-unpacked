package com.huawei.hms.dtm.core;

public abstract class Dc<T> implements C0435sc<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T f48273a;

    public Dc(T t11) {
        this.f48273a = t11;
    }

    public String a() {
        return toString();
    }

    public T d() {
        return this.f48273a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Dc)) {
            return false;
        }
        return ((Dc) obj).f48273a.equals(this.f48273a);
    }

    public int hashCode() {
        return this.f48273a.hashCode();
    }

    public String toString() {
        return String.valueOf(this.f48273a);
    }

    public T value() {
        return this.f48273a;
    }
}
