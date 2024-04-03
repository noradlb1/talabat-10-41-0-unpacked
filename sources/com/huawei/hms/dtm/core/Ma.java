package com.huawei.hms.dtm.core;

import java.util.List;
import java.util.Map;

public class Ma extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (list == null || list.size() != 1) {
            throw new V("__len#params error");
        }
        int i11 = 0;
        C0435sc scVar = list.get(0);
        if (scVar instanceof Cc) {
            String str = (String) ((Cc) scVar).value();
            if (str != null) {
                i11 = str.length();
            }
            return new C0450vc(Integer.valueOf(i11));
        } else if (scVar instanceof C0455wc) {
            List value = ((C0455wc) scVar).value();
            if (value != null) {
                i11 = value.size();
            }
            return new C0450vc(Integer.valueOf(i11));
        } else if (scVar instanceof C0465yc) {
            Map value2 = ((C0465yc) scVar).value();
            if (value2 != null) {
                i11 = value2.size();
            }
            return new C0450vc(Integer.valueOf(i11));
        } else {
            throw new V("__len#wrong params type ");
        }
    }

    public String a() {
        return "__len";
    }
}
