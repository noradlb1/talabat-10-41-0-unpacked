package com.huawei.hms.dtm.core;

import java.util.ArrayList;
import java.util.List;

public class Z extends Y {

    /* renamed from: a  reason: collision with root package name */
    private final C0348ba f48441a;

    public Z(C0348ba baVar) {
        this.f48441a = baVar;
    }

    private static List<C0435sc<?>> b(X x11, List<C0435sc<?>> list) throws V {
        ArrayList arrayList = new ArrayList();
        for (C0435sc<?> next : list) {
            if (next instanceof Bc) {
                next = C0343aa.a(x11, (Bc) next);
            }
            arrayList.add(next);
        }
        return arrayList;
    }

    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        return this.f48441a.a(x11, b(x11, list));
    }

    public String a() {
        return this.f48441a.a();
    }
}
