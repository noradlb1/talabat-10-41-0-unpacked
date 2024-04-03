package com.huawei.hms.dtm.core;

import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.xb  reason: case insensitive filesystem */
public class C0459xb extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (x11 != null) {
            return new Cc(x11.getConfigurationID());
        }
        throw new V("configId#params error");
    }

    public String a() {
        return "configId";
    }
}
