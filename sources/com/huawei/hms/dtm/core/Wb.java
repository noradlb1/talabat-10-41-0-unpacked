package com.huawei.hms.dtm.core;

import java.util.List;

public class Wb extends Y {
    public C0430rc a(X x11, List<C0435sc<?>> list) throws V {
        if (list != null && list.size() == 2 && list.get(0) != null && list.get(1) != null) {
            return C0430rc.a(list.get(0).toString().endsWith(list.get(1).toString()));
        }
        throw new V("_ew#wrong params");
    }

    public String a() {
        return "_ew";
    }
}
