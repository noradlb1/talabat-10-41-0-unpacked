package com.huawei.hms.dtm.core;

import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.gc  reason: case insensitive filesystem */
public class C0375gc extends Y {
    public C0430rc a(X x11, List<C0435sc<?>> list) throws V {
        if (list == null || x11 == null || list.size() != 1) {
            throw new V("_not#wrong params");
        }
        C0435sc scVar = list.get(0);
        if (scVar instanceof C0430rc) {
            return C0430rc.a(!((Boolean) ((C0430rc) scVar).value()).booleanValue());
        }
        throw new V("_not#only support boolean type");
    }

    public String a() {
        return "_not";
    }
}
