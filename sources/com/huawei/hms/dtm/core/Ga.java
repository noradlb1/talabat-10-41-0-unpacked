package com.huawei.hms.dtm.core;

import java.util.List;

public class Ga extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (list != null && list.size() == 1) {
            return C0430rc.a(list.get(0) instanceof C0455wc);
        }
        throw new V("__isarray#params error");
    }

    public String a() {
        return "__isarray";
    }
}
