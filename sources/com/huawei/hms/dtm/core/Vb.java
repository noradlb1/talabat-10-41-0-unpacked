package com.huawei.hms.dtm.core;

import java.util.List;

public class Vb extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (list == null || list.size() < 2 || list.get(0) == null) {
            throw new V("_div#wrong params");
        }
        Double c11 = list.get(0).c();
        int i11 = 1;
        while (i11 < list.size()) {
            if (list.get(i11) != null) {
                c11 = Double.valueOf(c11.doubleValue() / list.get(i11).c().doubleValue());
                i11++;
            } else {
                throw new V("_div#wrong params");
            }
        }
        return new C0440tc(c11);
    }

    public String a() {
        return "_div";
    }
}
