package com.huawei.hms.dtm.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.huawei.hms.dtm.core.mb  reason: case insensitive filesystem */
public class C0404mb extends Y {
    private boolean a(C0435sc<?> scVar) {
        return (scVar instanceof C0430rc) || (scVar instanceof C0440tc) || (scVar instanceof Cc) || (scVar instanceof C0450vc);
    }

    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (list == null || list.size() != 1 || !(list.get(0) instanceof C0465yc)) {
            throw new V("__val2string#param must be one map");
        }
        Set<Map.Entry> entrySet = ((C0465yc) list.get(0)).value().entrySet();
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : entrySet) {
            if ((entry.getValue() instanceof C0435sc) && a((C0435sc) entry.getValue())) {
                hashMap.put(entry.getKey(), entry.getValue() == null ? "" : entry.getValue().toString());
            }
        }
        return new C0465yc(hashMap);
    }

    public String a() {
        return "__val2string";
    }
}
