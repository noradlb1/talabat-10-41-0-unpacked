package com.huawei.hms.dtm.core;

import java.util.List;

public class Za extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) {
        if (list != null && list.size() == 2) {
            C0435sc scVar = list.get(0);
            if (scVar instanceof Cc) {
                x11.b((String) ((Cc) scVar).value(), list.get(1));
            }
        }
        return Ec.f48288a;
    }

    public String a() {
        return "__set";
    }
}
