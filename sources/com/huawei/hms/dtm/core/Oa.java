package com.huawei.hms.dtm.core;

import java.util.ArrayList;
import java.util.List;

public class Oa extends Y {
    public C0455wc a(X x11, List<C0435sc<?>> list) throws V {
        if (list != null) {
            return new C0455wc(new ArrayList(list));
        }
        throw new V("__list#params error");
    }

    public String a() {
        return "__list";
    }
}
