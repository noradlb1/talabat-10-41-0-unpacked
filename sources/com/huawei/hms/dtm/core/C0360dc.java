package com.huawei.hms.dtm.core;

import com.huawei.hms.common.Preconditions;
import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.dc  reason: case insensitive filesystem */
public class C0360dc extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (list == null || list.size() < 2 || list.get(0) == null) {
            throw new V("_mul#wrong params");
        }
        Double c11 = list.get(0).c();
        int i11 = 1;
        while (i11 < list.size()) {
            Preconditions.checkArgument(list.get(i11) != null, C0360dc.class.getSimpleName());
            if (list.get(i11) != null) {
                c11 = Double.valueOf(c11.doubleValue() * list.get(i11).c().doubleValue());
                i11++;
            } else {
                throw new V("_mul#wrong params");
            }
        }
        return new C0440tc(c11);
    }

    public String a() {
        return "_mul";
    }
}
