package com.huawei.hms.dtm.core;

import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.ec  reason: case insensitive filesystem */
public class C0365ec extends Y {
    public C0430rc a(X x11, List<C0435sc<?>> list) throws V {
        if (list != null && list.size() == 2 && list.get(0) != null && list.get(1) != null) {
            return C0430rc.a(!list.get(0).toString().contains(list.get(1).toString()));
        }
        throw new V("_ncn#wrong params");
    }

    public String a() {
        return "_ncn";
    }
}
