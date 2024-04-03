package com.huawei.hms.dtm.core;

import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.cb  reason: case insensitive filesystem */
public class C0354cb extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (list != null) {
            int i11 = 1;
            if (1 <= list.size()) {
                if (list.get(0) != null) {
                    Double c11 = list.get(0).c();
                    while (i11 < list.size()) {
                        C0435sc scVar = list.get(i11);
                        if (scVar != null) {
                            c11 = Double.valueOf(c11.doubleValue() - scVar.c().doubleValue());
                            i11++;
                        } else {
                            throw new V("_sub#param null");
                        }
                    }
                    return new C0440tc(c11);
                }
                throw new V("_sub#1st param null");
            }
        }
        throw new V("_sub#wrong params size");
    }

    public String a() {
        return "_sub";
    }
}
