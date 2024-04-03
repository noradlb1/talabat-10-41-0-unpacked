package com.huawei.hms.dtm.core;

import java.util.List;

public class Db extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (x11 != null) {
            return x11.b("dtm.eventName") ? x11.a("dtm.eventName") : Cc.f48270b;
        }
        throw new V("event#params error");
    }

    public String a() {
        return "event";
    }
}
