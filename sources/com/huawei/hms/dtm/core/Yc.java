package com.huawei.hms.dtm.core;

import java.util.ArrayList;
import java.util.List;

public class Yc extends Sc<List<Wc<?>>> {
    public Yc(List<Wc<?>> list) {
        super(list);
    }

    public C0435sc<?> a(X x11) {
        ArrayList arrayList = new ArrayList();
        T t11 = this.f48409a;
        if (t11 == null || ((List) t11).isEmpty()) {
            return new C0455wc(arrayList);
        }
        for (Wc a11 : (List) this.f48409a) {
            arrayList.add(a11.a(x11));
        }
        return new C0455wc(arrayList);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Yc)) {
            return false;
        }
        return ((List) ((Yc) obj).f48409a).equals(this.f48409a);
    }

    public /* synthetic */ Object getValue() {
        return super.getValue();
    }

    public int hashCode() {
        return ((List) this.f48409a).hashCode();
    }
}
