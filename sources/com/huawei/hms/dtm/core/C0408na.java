package com.huawei.hms.dtm.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.na  reason: case insensitive filesystem */
public class C0408na extends Y {
    private C0435sc<?> a(C0435sc<?> scVar) {
        if (scVar instanceof Cc) {
            return new Cc((String) ((Cc) scVar).value());
        }
        if (scVar instanceof C0450vc) {
            return new C0450vc((Integer) ((C0450vc) scVar).value());
        }
        if (scVar instanceof C0440tc) {
            return new C0440tc((Double) ((C0440tc) scVar).value());
        }
        if (scVar instanceof C0430rc) {
            return C0430rc.a(((Boolean) ((C0430rc) scVar).value()).booleanValue());
        }
        if (scVar instanceof C0445uc) {
            return new C0445uc(((C0445uc) scVar).value());
        }
        if (scVar instanceof Ac) {
            return new Ac(((Ac) scVar).value());
        }
        if (scVar instanceof Bc) {
            return new Bc((Bc) scVar);
        }
        if (scVar instanceof Ec) {
            return Ec.f48288a;
        }
        if (scVar instanceof C0470zc) {
            return C0470zc.f48641a;
        }
        throw new V("__copy#unsupported param type");
    }

    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (!list.isEmpty()) {
            C0435sc scVar = list.get(0);
            return scVar instanceof C0455wc ? new C0455wc(new ArrayList(((C0455wc) scVar).value())) : scVar instanceof C0465yc ? new C0465yc(new HashMap(((C0465yc) scVar).value())) : a(scVar);
        }
        throw new V("__copy#wrong params size");
    }

    public String a() {
        return "__copy";
    }
}
