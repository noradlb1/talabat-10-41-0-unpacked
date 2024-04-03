package com.huawei.hms.dtm.core;

import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.hms.dtm.core.ta  reason: case insensitive filesystem */
public class C0438ta extends Y {
    private C0435sc<?> a(X x11, String str, C0435sc<?> scVar, C0435sc<?> scVar2) throws V {
        List<C0435sc> value = ((C0455wc) scVar).value();
        if (value != null && value.size() > 0) {
            for (C0435sc a11 : value) {
                x11.a(str, a11);
                C0435sc<?> a12 = C0343aa.a(x11, (List<C0435sc<?>>) ((C0455wc) scVar2).value());
                if (a12 instanceof C0445uc) {
                    return ((C0445uc) a12).e() ? a12 : Ec.f48288a;
                }
            }
        }
        return Ec.f48288a;
    }

    private C0435sc<?> b(X x11, String str, C0435sc<?> scVar, C0435sc<?> scVar2) throws V {
        Map value = ((C0465yc) scVar).value();
        if (value == null || value.isEmpty()) {
            return Ec.f48288a;
        }
        C0455wc wcVar = (C0455wc) scVar2;
        for (Map.Entry key : value.entrySet()) {
            x11.a(str, new Cc((String) key.getKey()));
            C0435sc<?> a11 = C0343aa.a(x11, (List<C0435sc<?>>) wcVar.value());
            if (a11 instanceof C0445uc) {
                return ((C0445uc) a11).e() ? a11 : Ec.f48288a;
            }
        }
        return Ec.f48288a;
    }

    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (list == null || x11 == null || list.size() != 3 || list.get(0) == null) {
            throw new V("__foreach#wrong params");
        }
        String scVar = list.get(0).toString();
        if (!x11.b(scVar)) {
            x11.a(scVar, C0470zc.f48641a);
        }
        C0435sc scVar2 = list.get(1);
        C0435sc scVar3 = list.get(2);
        if (!(scVar3 instanceof C0455wc)) {
            return Ec.f48288a;
        }
        if (scVar2 instanceof C0455wc) {
            return a(x11, scVar, scVar2, scVar3);
        }
        if (scVar2 instanceof C0465yc) {
            return b(x11, scVar, scVar2, scVar3);
        }
        throw new V("__foreach#only support list/map");
    }

    public String a() {
        return "__foreach";
    }
}
