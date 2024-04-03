package com.huawei.hms.dtm.core;

public class Xc extends Sc<Integer> {
    public Xc(Integer num) {
        super(num);
    }

    public C0435sc<?> a(X x11) {
        return new C0450vc((Integer) this.f48409a);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Xc)) {
            return false;
        }
        return ((Integer) ((Xc) obj).f48409a).equals(this.f48409a);
    }

    public /* synthetic */ Object getValue() {
        return super.getValue();
    }

    public int hashCode() {
        return ((Integer) this.f48409a).hashCode();
    }
}
