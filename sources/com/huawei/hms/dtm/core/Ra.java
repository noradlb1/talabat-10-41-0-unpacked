package com.huawei.hms.dtm.core;

import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.util.List;

public class Ra extends Y {
    private static double a(C0435sc<?> scVar, C0435sc<?> scVar2) {
        if (scVar == null || scVar2 == null) {
            throw new V("_oper#params error");
        }
        Double c11 = scVar.c();
        Double c12 = scVar2.c();
        if (Double.isNaN(c11.doubleValue()) || Double.isNaN(c12.doubleValue())) {
            return Double.NaN;
        }
        if (Double.isInfinite(c11.doubleValue()) && Double.isInfinite(c12.doubleValue())) {
            return Double.NaN;
        }
        if (!Double.isInfinite(c11.doubleValue()) && !Double.isInfinite(c12.doubleValue())) {
            return c11.doubleValue() + c12.doubleValue();
        }
        if (!Double.isInfinite(c11.doubleValue())) {
            c11 = c12;
        }
        return c11.doubleValue();
    }

    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (list == null || list.size() < 2 || list.size() > 3) {
            throw new V("_oper#params error");
        } else if (list.get(0) == null || list.get(1) == null) {
            throw new V("_oper#params error");
        } else if (list.size() == 2) {
            return new C0440tc(Double.valueOf(a(list.get(0), list.get(1))));
        } else {
            String valueOf = String.valueOf(list.get(1));
            if (valueOf.equals("+")) {
                return new C0440tc(Double.valueOf(a(list.get(0), list.get(2))));
            }
            if (valueOf.equals(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE)) {
                return new C0440tc(Double.valueOf(list.get(0).c().doubleValue() - list.get(2).c().doubleValue()));
            } else if (valueOf.equals("*")) {
                return new C0440tc(Double.valueOf(list.get(0).c().doubleValue() * list.get(2).c().doubleValue()));
            } else if (valueOf.equals("/")) {
                return new C0440tc(Double.valueOf(list.get(0).c().doubleValue() / list.get(2).c().doubleValue()));
            } else {
                throw new V("_oper#unsupported Operator");
            }
        }
    }

    public String a() {
        return "_oper";
    }
}
