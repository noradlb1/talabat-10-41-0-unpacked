package com.huawei.hms.dtm.core;

import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.eb  reason: case insensitive filesystem */
public class C0364eb extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        double d11 = 0.0d;
        int i11 = 0;
        while (i11 < list.size()) {
            C0435sc scVar = list.get(i11);
            if (scVar != null) {
                d11 += scVar.c().doubleValue();
                i11++;
            } else {
                throw new V("_sum#param is null");
            }
        }
        return new C0440tc(Double.valueOf(d11));
    }

    public String a() {
        return "_sum";
    }
}
