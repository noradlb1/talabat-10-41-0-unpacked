package com.huawei.hms.dtm.core;

import java.util.List;

public class Ub extends Y {
    public C0430rc a(X x11, List<C0435sc<?>> list) throws V {
        if (list == null || list.size() != 2) {
            throw new V("_cn#wrong params size");
        } else if (list.get(0) != null && list.get(1) != null) {
            return C0430rc.a(list.get(0).toString().contains(list.get(1).toString()));
        } else {
            throw new V("_cn#params null");
        }
    }

    public String a() {
        return "_cn";
    }
}
