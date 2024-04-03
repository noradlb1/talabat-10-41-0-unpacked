package com.huawei.hms.dtm.core;

import java.util.HashMap;
import java.util.Map;

public class _c extends Sc<Map<Wc<?>, Wc<?>>> {
    public _c(Map<Wc<?>, Wc<?>> map) {
        super(map);
    }

    public C0435sc<?> a(X x11) {
        HashMap hashMap = new HashMap();
        T t11 = this.f48409a;
        if (t11 == null || ((Map) t11).isEmpty()) {
            return new C0465yc(hashMap);
        }
        for (Map.Entry entry : ((Map) this.f48409a).entrySet()) {
            hashMap.put(((Wc) entry.getKey()).a(x11).toString(), ((Wc) entry.getValue()).a(x11));
        }
        return new C0465yc(hashMap);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof _c)) {
            return false;
        }
        return ((Map) ((_c) obj).f48409a).equals(this.f48409a);
    }

    public int hashCode() {
        return ((Map) this.f48409a).hashCode();
    }
}
