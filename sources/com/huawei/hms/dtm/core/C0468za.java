package com.huawei.hms.dtm.core;

import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.za  reason: case insensitive filesystem */
public class C0468za extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (list.size() == 2) {
            C0435sc scVar = list.get(0);
            if (scVar instanceof C0455wc) {
                C0435sc scVar2 = list.get(1);
                if (scVar2 instanceof C0450vc) {
                    List value = ((C0455wc) scVar).value();
                    int intValue = ((Integer) ((C0450vc) scVar2).value()).intValue();
                    if (intValue >= 0 && intValue < value.size()) {
                        return (C0435sc) value.get(intValue);
                    }
                    throw new V("__getlist#over");
                }
                throw new V("__getlist#not int");
            }
            throw new V("__getlist#not list");
        }
        throw new V("__getlist#size not 2");
    }

    public String a() {
        return "__getlist";
    }
}
