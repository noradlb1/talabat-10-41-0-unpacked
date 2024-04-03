package com.huawei.hms.dtm.core;

import java.util.Iterator;
import java.util.List;

public class Ea extends Y {
    private int a(List<C0435sc<?>> list, int i11) {
        int i12 = 0;
        if (list.size() == 3 && list.get(2) != null) {
            i12 = Math.max(0, list.get(2).c().intValue());
        }
        return i12 > i11 ? i11 : i12;
    }

    private void a(List<C0435sc<?>> list) {
        if (list == null || list.size() == 0 || list.size() > 3) {
            throw new V("__indexof#params error");
        } else if (list.get(0) == null || (!(list.get(0) instanceof Cc) && !(list.get(0) instanceof C0455wc))) {
            throw new V("__indexof#params error");
        }
    }

    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        int i11;
        a(list);
        if (list.get(0) instanceof C0455wc) {
            List value = ((C0455wc) list.get(0)).value();
            C0435sc scVar = list.size() < 2 ? C0470zc.f48641a : list.get(1);
            List subList = value.subList(a(list, value.size()), value.size());
            Iterator it = subList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    i11 = -1;
                    break;
                }
                C0435sc scVar2 = (C0435sc) it.next();
                if (scVar2 != null && C0353ca.a((C0435sc<?>) scVar2, (C0435sc<?>) scVar)) {
                    i11 = subList.indexOf(scVar2);
                    break;
                }
            }
            return new C0450vc(Integer.valueOf(i11));
        } else if (list.size() < 2 || list.get(1) == null) {
            throw new V("__indexof#params error");
        } else {
            String str = (String) ((Cc) list.get(0)).value();
            return new C0450vc(Integer.valueOf(str.indexOf(list.get(1).toString(), a(list, str.length()))));
        }
    }

    public String a() {
        return "__indexof";
    }
}
