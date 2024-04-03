package com.huawei.hms.dtm.core;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.ja  reason: case insensitive filesystem */
public class C0388ja extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (list.isEmpty() || list.get(0) == null) {
            throw new V("__concat#wrong params");
        } else if (list.get(0) instanceof C0455wc) {
            ArrayList arrayList = new ArrayList();
            for (C0435sc next : list) {
                if (next instanceof C0455wc) {
                    arrayList.addAll(((C0455wc) next).value());
                } else {
                    arrayList.add(next);
                }
            }
            return new C0455wc(arrayList);
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (C0435sc next2 : list) {
                if (next2 != null) {
                    sb2.append(next2.toString());
                }
            }
            return new Cc(sb2.toString());
        }
    }

    public String a() {
        return "__concat";
    }
}
