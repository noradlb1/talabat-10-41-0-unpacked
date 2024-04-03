package com.huawei.hms.dtm.core;

import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.hc  reason: case insensitive filesystem */
public class C0380hc extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (list == null || x11 == null || list.size() < 1) {
            throw new V("_or#params error");
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (list.get(i11) != null && C0343aa.a(x11, list.get(i11)).b()) {
                return C0430rc.a(true);
            }
        }
        return C0430rc.a(false);
    }

    public String a() {
        return "_or";
    }
}
