package com.huawei.hms.dtm.core;

import java.util.List;

public class Ha extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (list == null || list.size() < 1 || list.size() > 2) {
            throw new V("__empty#params error");
        }
        boolean z11 = false;
        if (list.get(0) != null) {
            z11 = list.get(0).b();
        }
        if (list.size() == 1) {
            return C0430rc.a(!z11);
        }
        if ("!".equals(String.valueOf(list.get(1)))) {
            return C0430rc.a(z11);
        }
        throw new V("__empty#params error");
    }

    public String a() {
        return "__empty";
    }
}
