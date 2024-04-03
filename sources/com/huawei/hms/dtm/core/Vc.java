package com.huawei.hms.dtm.core;

import java.util.List;

public class Vc extends Sc<List<Wc<?>>> {
    public Vc(List<Wc<?>> list) {
        super(list);
    }

    public C0435sc<?> a(X x11) {
        T t11 = this.f48409a;
        if (t11 == null || ((List) t11).isEmpty()) {
            return Cc.f48270b;
        }
        StringBuilder sb2 = new StringBuilder();
        for (Wc a11 : (List) this.f48409a) {
            sb2.append(a11.a(x11));
        }
        return new Cc(sb2.toString());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Vc)) {
            return false;
        }
        return ((List) ((Vc) obj).f48409a).equals(this.f48409a);
    }

    public int hashCode() {
        return ((List) this.f48409a).hashCode();
    }
}
