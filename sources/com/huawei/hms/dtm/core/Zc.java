package com.huawei.hms.dtm.core;

public class Zc extends Sc<Long> {
    public Zc(Long l11) {
        super(l11);
    }

    public C0435sc<?> a(X x11) {
        return new C0460xc((Long) this.f48409a);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Zc)) {
            return false;
        }
        return ((Long) ((Zc) obj).f48409a).equals(this.f48409a);
    }

    public int hashCode() {
        return ((Long) this.f48409a).hashCode();
    }
}
