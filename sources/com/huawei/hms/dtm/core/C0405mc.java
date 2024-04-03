package com.huawei.hms.dtm.core;

import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.mc  reason: case insensitive filesystem */
public class C0405mc extends Y {
    private boolean a(Double d11, Double d12) {
        return !d11.isNaN() && !d12.isNaN() && !d11.isInfinite() && !C0353ca.a(d12.doubleValue(), 0.0d);
    }

    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (list == null || list.size() != 2 || list.get(0) == null || list.get(1) == null) {
            throw new V("_rem#params error");
        }
        Double c11 = list.get(0).c();
        Double c12 = list.get(1).c();
        return !a(c11, c12) ? new C0440tc(Double.valueOf(Double.NaN)) : (c12.isInfinite() || C0353ca.a(c11.doubleValue(), 0.0d)) ? new C0440tc(c11) : new C0440tc(Double.valueOf(c11.doubleValue() % c12.doubleValue()));
    }

    public String a() {
        return "_rem";
    }
}
