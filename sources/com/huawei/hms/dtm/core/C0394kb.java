package com.huawei.hms.dtm.core;

import com.huawei.hms.dtm.core.util.Logger;
import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.kb  reason: case insensitive filesystem */
public class C0394kb extends Y {
    private void a(X x11, C0435sc<?> scVar) {
        if (scVar instanceof C0455wc) {
            C0343aa.a(x11, (List<C0435sc<?>>) ((C0455wc) scVar).value());
        } else {
            Logger.warn("DTM-Execute", "TryCatchExecutor#wrong param type");
        }
    }

    private void b(X x11, List<C0435sc<?>> list) {
        if (list.size() >= 2) {
            a(x11, list.get(1));
        }
    }

    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (list == null || list.size() == 0) {
            Logger.warn("DTM-Execute", "TryCatchExecutor#wrong param size");
            return Ec.f48288a;
        }
        try {
            a(x11, list.get(0));
        } catch (Exception e11) {
            Logger.debug("DTM-Execute", "TryCatchExecutor#" + e11.getMessage());
            b(x11, list);
        }
        return Ec.f48288a;
    }

    public String a() {
        return "__tryCatch";
    }
}
