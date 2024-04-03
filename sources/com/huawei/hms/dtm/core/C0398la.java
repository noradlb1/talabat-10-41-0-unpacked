package com.huawei.hms.dtm.core;

import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.la  reason: case insensitive filesystem */
public class C0398la extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        boolean contains;
        if (list == null || list.size() != 2) {
            throw new V("__contains#wrong params");
        }
        String scVar = list.get(1) != null ? list.get(1).toString() : null;
        if (scVar == null) {
            return C0430rc.a(false);
        }
        C0435sc scVar2 = list.get(0);
        if (scVar2 instanceof C0455wc) {
            for (C0435sc scVar3 : ((C0455wc) scVar2).value()) {
                if ((scVar3 instanceof Cc) && scVar.equals((String) ((Cc) scVar3).value())) {
                    return C0430rc.a(true);
                }
            }
            return C0430rc.a(false);
        }
        if (scVar2 instanceof C0465yc) {
            contains = ((C0465yc) scVar2).value().containsKey(scVar);
        } else if (scVar2 instanceof Cc) {
            contains = scVar2.toString().contains(scVar);
        } else {
            throw new V("__contains#contains only support list/map/string");
        }
        return C0430rc.a(contains);
    }

    public String a() {
        return "__contains";
    }
}
