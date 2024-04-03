package com.huawei.hms.dtm.core;

import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.ib  reason: case insensitive filesystem */
public class C0384ib extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (list != null && list.size() == 1 && list.get(0) != null) {
            return new Cc(list.get(0).toString());
        }
        throw new V("__tostring#wrong params");
    }

    public String a() {
        return "__tostring";
    }
}
