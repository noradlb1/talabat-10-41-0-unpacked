package com.huawei.hms.dtm.core;

import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.ea  reason: case insensitive filesystem */
public class C0363ea extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (x11.b("dtm.needSendToHA")) {
            x11.b("dtm.needSendToHA", C0430rc.a(false));
        } else {
            x11.a("dtm.needSendToHA", C0430rc.a(false));
        }
        return Ec.f48288a;
    }

    public String a() {
        return "__block2ha";
    }
}
