package com.huawei.hms.dtm.core;

import com.huawei.hms.dtm.core.util.g;
import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.sa  reason: case insensitive filesystem */
public class C0433sa extends Y {
    private static String a(String str) {
        return g.a(str, "-_.!~*'();/?:@&=+$,#");
    }

    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (!list.isEmpty()) {
            return new Cc(a(list.get(0).toString()));
        }
        throw new V("__encodeuri#wrong params");
    }

    public String a() {
        return "__encodeuri";
    }
}
