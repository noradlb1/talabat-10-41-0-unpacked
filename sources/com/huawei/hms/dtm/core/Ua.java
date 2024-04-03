package com.huawei.hms.dtm.core;

import java.util.Iterator;
import java.util.List;

public class Ua extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (list == null || x11 == null || list.size() != 2) {
            throw new V("__removelist#params error");
        }
        C0435sc<?> scVar = list.get(0);
        if (scVar instanceof C0455wc) {
            List value = ((C0455wc) scVar).value();
            C0435sc scVar2 = list.get(1);
            Iterator it = value.iterator();
            while (it.hasNext()) {
                C0435sc scVar3 = (C0435sc) it.next();
                String str = "null";
                String name2 = scVar2 == null ? str : scVar2.getClass().getName();
                if (scVar3 != null) {
                    str = scVar3.getClass().getName();
                }
                if (name2.equals(str) && String.valueOf(scVar2).equals(String.valueOf(scVar3))) {
                    it.remove();
                }
            }
            return scVar;
        }
        throw new V("__removelist#params error.The 1st param isn't list");
    }

    public String a() {
        return "__removelist";
    }
}
