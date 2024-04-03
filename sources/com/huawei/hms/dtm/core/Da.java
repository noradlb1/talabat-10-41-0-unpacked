package com.huawei.hms.dtm.core;

import java.util.List;

public class Da extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        C0435sc scVar;
        if (list == null || !(list.size() == 2 || list.size() == 3)) {
            throw new V("__if#wrong params size");
        }
        boolean z11 = false;
        if (list.get(0) != null && list.get(0).b()) {
            z11 = true;
        }
        if (z11) {
            scVar = list.get(1);
            if (!(scVar instanceof C0455wc)) {
                throw new V("__if#wrong params type");
            }
        } else if (list.size() != 3) {
            return Ec.f48288a;
        } else {
            scVar = list.get(2);
            if (!(scVar instanceof C0455wc)) {
                throw new V("__if#wrong params type");
            }
        }
        return C0343aa.a(x11, (List<C0435sc<?>>) ((C0455wc) scVar).value());
    }

    public String a() {
        return "__if";
    }
}
