package com.huawei.hms.dtm.core;

import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.ka  reason: case insensitive filesystem */
public class C0393ka extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (list != null && list.size() == 1) {
            return list.get(0);
        }
        throw new V("constant#wrong params");
    }

    public String a() {
        return "constant";
    }
}
