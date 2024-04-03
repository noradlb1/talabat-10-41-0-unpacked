package com.huawei.hms.dtm.core;

import java.util.List;

public class La extends Y {
    private int a(List<C0435sc<?>> list, int i11) {
        if (list.size() != 3 || list.get(2) == null) {
            return i11;
        }
        int a11 = (int) C0353ca.a(list.get(2));
        return a11 < 0 ? i11 - Math.abs(a11) : Math.min(i11, a11);
    }

    private void a(List<C0435sc<?>> list) {
        if (b(list)) {
            throw new V("__lastIndexOf#params error");
        }
    }

    private boolean b(List<C0435sc<?>> list) {
        return list == null || list.size() == 0 || list.size() > 3 || !(list.get(0) instanceof Cc) || !(list.get(0) instanceof C0455wc);
    }

    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        a(list);
        if (!(list.get(0) instanceof Cc)) {
            List value = ((C0455wc) list.get(0)).value();
            C0435sc scVar = list.size() < 2 ? C0470zc.f48641a : list.get(1);
            int a11 = a(list, value.size() - 1);
            while (true) {
                if (a11 >= 0) {
                    C0435sc scVar2 = (C0435sc) value.get(a11);
                    if (scVar2 != null && C0353ca.a((C0435sc<?>) scVar2, (C0435sc<?>) scVar)) {
                        break;
                    }
                    a11--;
                } else {
                    a11 = -1;
                    break;
                }
            }
            return new C0450vc(Integer.valueOf(a11));
        } else if (list.size() < 2 || list.get(1) == null) {
            throw new V("__lastindexof#params error");
        } else {
            String str = (String) ((Cc) list.get(0)).value();
            String scVar3 = list.get(1).toString();
            double length = (double) str.length();
            double a12 = (list.size() != 3 || list.get(2) == null || Double.isNaN(list.get(2).c().doubleValue())) ? Double.POSITIVE_INFINITY : C0353ca.a(list.get(2));
            if (a12 <= length) {
                length = 0.0d;
                if (a12 >= 0.0d) {
                    length = a12;
                }
            }
            return new C0450vc(Integer.valueOf(str.lastIndexOf(scVar3, (int) length)));
        }
    }

    public String a() {
        return "__lastindexof";
    }
}
