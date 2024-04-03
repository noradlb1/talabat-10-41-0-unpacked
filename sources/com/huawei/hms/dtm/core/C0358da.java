package com.huawei.hms.dtm.core;

import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.da  reason: case insensitive filesystem */
public class C0358da extends Y {
    private void a(List<C0435sc<?>> list, C0435sc<?> scVar) {
        list.add(scVar);
    }

    private void a(List<C0435sc<?>> list, C0435sc<?> scVar, C0435sc<?> scVar2) {
        if (scVar instanceof C0450vc) {
            int intValue = ((Integer) ((C0450vc) scVar).value()).intValue();
            if (intValue < 0 || intValue > list.size()) {
                throw new V("__addlist#the index param " + intValue + " is out of range");
            }
            list.add(intValue, scVar2);
            return;
        }
        throw new V("__addlist#the second param isn't an integer");
    }

    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (list == null || x11 == null || !(list.size() == 2 || list.size() == 3)) {
            throw new V("__addlist#wrong params");
        }
        C0435sc<?> scVar = list.get(0);
        if (scVar instanceof C0455wc) {
            List value = ((C0455wc) scVar).value();
            if (list.size() == 2) {
                C0435sc scVar2 = list.get(1);
                if (scVar2 instanceof Ac) {
                    scVar2 = (C0435sc) ((Ac) scVar2).value();
                }
                a((List<C0435sc<?>>) value, (C0435sc<?>) scVar2);
            } else {
                C0435sc scVar3 = list.get(1);
                C0435sc scVar4 = list.get(2);
                if (scVar4 instanceof Ac) {
                    scVar4 = (C0435sc) ((Ac) scVar4).value();
                }
                a(value, scVar3, scVar4);
            }
            return scVar;
        }
        throw new V("__addlist#1st param isn't list");
    }

    public String a() {
        return "__addlist";
    }
}
