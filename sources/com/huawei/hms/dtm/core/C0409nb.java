package com.huawei.hms.dtm.core;

import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.nb  reason: case insensitive filesystem */
public class C0409nb extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) {
        if (list != null) {
            for (int i11 = 0; i11 < list.size(); i11++) {
                C0435sc scVar = list.get(i11);
                if (scVar instanceof Cc) {
                    x11.a((String) ((Cc) scVar).value(), C0470zc.f48641a);
                }
            }
        }
        return Ec.f48288a;
    }

    public String a() {
        return "__init";
    }
}
