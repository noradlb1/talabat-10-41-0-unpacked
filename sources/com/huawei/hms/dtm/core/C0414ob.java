package com.huawei.hms.dtm.core;

import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.ob  reason: case insensitive filesystem */
public class C0414ob extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        C0435sc<?> a11;
        if (list == null || x11 == null || list.size() != 2) {
            throw new V("__while#wrong params");
        }
        C0435sc scVar = list.get(0);
        C0435sc scVar2 = list.get(1);
        if (!(scVar instanceof C0455wc) || !(scVar2 instanceof C0455wc)) {
            throw new V("__while#wrong params type");
        }
        do {
            C0435sc<?> a12 = C0343aa.a(x11, (List<C0435sc<?>>) ((C0455wc) scVar).value());
            if (!(a12 instanceof C0430rc)) {
                throw new V("__while#1st param is not boolean");
            } else if (!((Boolean) ((C0430rc) a12).value()).booleanValue()) {
                return Ec.f48288a;
            } else {
                a11 = C0343aa.a(x11, (List<C0435sc<?>>) ((C0455wc) scVar2).value());
            }
        } while (!(a11 instanceof C0445uc));
        return ((C0445uc) a11).e() ? a11 : Ec.f48288a;
    }

    public String a() {
        return "__while";
    }
}
