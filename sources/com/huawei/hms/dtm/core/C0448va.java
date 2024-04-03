package com.huawei.hms.dtm.core;

import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.va  reason: case insensitive filesystem */
public class C0448va extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (x11 != null && list != null && list.size() == 0) {
            return new Ac(x11.c());
        }
        throw new V("__context#wrong params");
    }

    public String a() {
        return "__context";
    }
}
