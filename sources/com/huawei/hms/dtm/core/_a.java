package com.huawei.hms.dtm.core;

import java.util.ArrayList;
import java.util.List;

public class _a extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (list != null && list.size() >= 1 && list.size() <= 2) {
            if (list.get(0) instanceof Cc) {
                ArrayList arrayList = new ArrayList();
                if (list.size() == 1) {
                    arrayList.add(list.get(0));
                    return new C0455wc(arrayList);
                }
                for (String cc2 : ((String) ((Cc) list.get(0)).value()).split(list.get(1) != null ? list.get(1).toString() : "")) {
                    arrayList.add(new Cc(cc2));
                }
                return new C0455wc(arrayList);
            }
        }
        throw new V("__split#params error");
    }

    public String a() {
        return "__split";
    }
}
