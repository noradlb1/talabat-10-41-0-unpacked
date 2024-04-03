package com.huawei.hms.dtm.core;

import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.yb  reason: case insensitive filesystem */
public class C0464yb extends Y {
    public Cc a(X x11, List<C0435sc<?>> list) throws V {
        if (x11 != null) {
            return new Cc(x11.getResourceVersion());
        }
        throw new V("configVersion#params error");
    }

    public String a() {
        return "configVersion";
    }
}
