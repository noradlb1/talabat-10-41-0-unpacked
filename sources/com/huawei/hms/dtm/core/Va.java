package com.huawei.hms.dtm.core;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Va extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (list == null || x11 == null) {
            throw new V("__removemap#params error");
        } else if (list.size() != 2 || list.get(0) == null || list.get(1) == null) {
            throw new V("__removemap#params error");
        } else {
            C0435sc<?> scVar = list.get(0);
            C0435sc scVar2 = list.get(1);
            if (scVar instanceof C0465yc) {
                Map value = ((C0465yc) scVar).value();
                String scVar3 = scVar2.toString();
                Iterator it = value.entrySet().iterator();
                while (it.hasNext()) {
                    if (scVar3.equals(((Map.Entry) it.next()).getKey())) {
                        it.remove();
                    }
                }
                return scVar;
            }
            throw new V("__removemap#params error.The 1st param isn't map");
        }
    }

    public String a() {
        return "__removemap";
    }
}
