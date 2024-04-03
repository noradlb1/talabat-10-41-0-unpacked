package com.huawei.hms.dtm.core;

import com.huawei.hms.dtm.core.util.g;
import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.ia  reason: case insensitive filesystem */
public class C0383ia extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (list.isEmpty() || list.get(0) == null) {
            throw new V("__codec#wrong params");
        }
        String scVar = list.get(0).toString();
        String scVar2 = (list.size() <= 1 || list.get(1) == null) ? "utf-8" : list.get(1).toString();
        int i11 = 2;
        String scVar3 = (list.size() <= 2 || list.get(2) == null) ? "base16" : list.get(2).toString();
        if (list.size() > 3 && list.get(3) != null && Boolean.getBoolean(list.get(3).toString())) {
            i11 = 3;
        }
        return g.a(g.a(scVar, scVar2, i11), scVar3, i11);
    }

    public String a() {
        return "__codec";
    }
}
