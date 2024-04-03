package com.huawei.hms.dtm.core;

import java.util.List;

public class Aa extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (list != null && list.size() == 1 && list.get(0) != null) {
            return new C0440tc(Double.valueOf(0.0d - list.get(0).c().doubleValue()));
        }
        throw new V("__getnegative#wrong  params");
    }

    public String a() {
        return "__getnegative";
    }
}
