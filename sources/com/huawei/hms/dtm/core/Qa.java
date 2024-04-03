package com.huawei.hms.dtm.core;

import java.util.HashMap;
import java.util.List;

public class Qa extends Y {
    public C0465yc a(X x11, List<C0435sc<?>> list) throws V {
        if (list == null || list.size() % 2 != 0) {
            throw new V("__map#params error");
        }
        HashMap hashMap = new HashMap();
        for (int i11 = 0; i11 < list.size(); i11 += 2) {
            hashMap.put(list.get(i11).value().toString(), list.get(i11 + 1));
        }
        return new C0465yc(hashMap);
    }

    public String a() {
        return "__map";
    }
}
