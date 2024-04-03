package com.huawei.hms.dtm.core;

import java.util.List;

public class Ka extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (list == null || list.size() < 2 || list.size() > 3) {
            throw new V("__judgenot#params error");
        }
        boolean z11 = list.get(0) != null && list.get(0).b();
        return list.size() == 2 ? !z11 ? list.get(0) : C0343aa.a(x11, list.get(1)) : !z11 ? C0343aa.a(x11, list.get(1)) : C0343aa.a(x11, list.get(2));
    }

    public String a() {
        return "__judgenot";
    }
}
