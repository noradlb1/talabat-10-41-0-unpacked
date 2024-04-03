package com.huawei.hms.dtm.core;

import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.ua  reason: case insensitive filesystem */
public class C0443ua extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (list == null || x11 == null || list.size() != 3) {
            throw new V("__for#wrong params");
        }
        C0435sc scVar = list.get(0);
        C0435sc scVar2 = list.get(1);
        C0435sc scVar3 = list.get(2);
        if (!(scVar instanceof C0455wc) || !(scVar2 instanceof C0455wc) || !(scVar3 instanceof C0455wc)) {
            throw new V("__for#wrong params type");
        }
        while (true) {
            C0435sc<?> a11 = C0343aa.a(x11, (List<C0435sc<?>>) ((C0455wc) scVar).value());
            if (!(a11 instanceof C0430rc)) {
                throw new V("__for#1st param is not boolean");
            } else if (!((Boolean) ((C0430rc) a11).value()).booleanValue()) {
                return Ec.f48288a;
            } else {
                C0435sc<?> a12 = C0343aa.a(x11, (List<C0435sc<?>>) ((C0455wc) scVar3).value());
                if (a12 instanceof C0445uc) {
                    return ((C0445uc) a12).e() ? a12 : Ec.f48288a;
                }
                C0343aa.a(x11, (List<C0435sc<?>>) ((C0455wc) scVar2).value());
            }
        }
    }

    public String a() {
        return "__for";
    }
}
