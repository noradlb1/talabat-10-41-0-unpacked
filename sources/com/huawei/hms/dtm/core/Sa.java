package com.huawei.hms.dtm.core;

import java.util.List;

public class Sa extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (list == null || x11 == null) {
            throw new V("__putmap#params error");
        } else if (list.size() != 3 || list.get(0) == null || list.get(1) == null) {
            throw new V("__putmap#params error");
        } else {
            C0435sc<?> scVar = list.get(0);
            if (scVar instanceof C0465yc) {
                ((C0465yc) scVar).value().put(list.get(1).toString(), list.get(2));
                return scVar;
            }
            throw new V("__putmap#wrong params.The 1st param isn't map");
        }
    }

    public String a() {
        return "__putmap";
    }
}
