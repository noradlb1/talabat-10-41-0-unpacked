package com.huawei.hms.dtm.core;

import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.xa  reason: case insensitive filesystem */
public class C0458xa extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (list == null || list.size() != 1) {
            throw new V("__get#wrong  params size");
        }
        C0435sc scVar = list.get(0);
        if (scVar instanceof Cc) {
            return x11.a((String) ((Cc) scVar).value());
        }
        throw new V("__get#wrong  params type");
    }

    public String a() {
        return "__get";
    }
}
