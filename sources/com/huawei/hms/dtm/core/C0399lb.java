package com.huawei.hms.dtm.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.hms.dtm.core.lb  reason: case insensitive filesystem */
public class C0399lb extends Y {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, Cc> f48511a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static final Cc f48512b = new Cc("Others");

    static {
        f48511a.put(C0455wc.class.getSimpleName(), new Cc("List"));
        f48511a.put(C0465yc.class.getSimpleName(), new Cc("Map"));
        f48511a.put(Cc.class.getSimpleName(), new Cc("String"));
        f48511a.put(C0430rc.class.getSimpleName(), new Cc("Bool"));
        f48511a.put(C0450vc.class.getSimpleName(), new Cc("Integer"));
        f48511a.put(C0440tc.class.getSimpleName(), new Cc("Double"));
        f48511a.put(C0460xc.class.getSimpleName(), new Cc("Long"));
        f48511a.put(C0470zc.class.getSimpleName(), new Cc("Null"));
        f48511a.put(Ac.class.getSimpleName(), new Cc("Object"));
    }

    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (list == null || list.size() != 1) {
            throw new V("__type#params error");
        }
        Cc cc2 = f48511a.get(list.get(0).getClass().getSimpleName());
        return cc2 == null ? f48512b : cc2;
    }

    public String a() {
        return "__type";
    }
}
