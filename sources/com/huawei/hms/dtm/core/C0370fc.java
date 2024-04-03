package com.huawei.hms.dtm.core;

import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.fc  reason: case insensitive filesystem */
public class C0370fc extends Y {
    public C0430rc a(X x11, List<C0435sc<?>> list) throws V {
        if (list != null && list.size() == 2 && list.get(0) != null && list.get(1) != null) {
            return C0430rc.a(!list.get(0).toString().equals(list.get(1).toString()));
        }
        throw new V("_neq#wrong params");
    }

    public String a() {
        return "_neq";
    }
}
