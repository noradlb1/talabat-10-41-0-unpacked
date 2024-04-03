package com.huawei.hms.dtm.core;

public class Uc extends Sc<Double> {
    public Uc(Double d11) {
        super(d11);
    }

    public C0435sc<?> a(X x11) {
        return new C0440tc((Double) this.f48409a);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Uc)) {
            return false;
        }
        return ((Double) ((Uc) obj).f48409a).equals(this.f48409a);
    }

    public int hashCode() {
        return ((Double) this.f48409a).hashCode();
    }
}
