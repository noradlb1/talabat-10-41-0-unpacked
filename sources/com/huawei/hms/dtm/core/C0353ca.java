package com.huawei.hms.dtm.core;

/* renamed from: com.huawei.hms.dtm.core.ca  reason: case insensitive filesystem */
public final class C0353ca {
    public static double a(C0435sc<?> scVar) throws V {
        if (scVar != null) {
            Double c11 = scVar.c();
            if (Double.isNaN(c11.doubleValue())) {
                return 0.0d;
            }
            return (a(c11.doubleValue(), 0.0d) || Double.isInfinite(c11.doubleValue())) ? c11.doubleValue() : Math.signum(c11.doubleValue()) * Math.floor(Math.abs(c11.doubleValue()));
        }
        throw new V("convert null to double");
    }

    public static boolean a(double d11, double d12) {
        return Math.abs(d11 - d12) < 1.0E-20d;
    }

    public static boolean a(C0435sc<?> scVar, C0435sc<?> scVar2) throws V {
        if (scVar == null || scVar2 == null) {
            throw new V("equals#unsupport null object");
        }
        boolean equals = scVar.toString().equals(scVar2.toString());
        if (scVar.getClass().equals(scVar2.getClass())) {
            return equals;
        }
        if (b(scVar) || b(scVar2)) {
            return false;
        }
        return equals;
    }

    public static boolean b(C0435sc<?> scVar) {
        return (scVar instanceof C0470zc) || (scVar instanceof Ec) || (scVar instanceof C0445uc) || (scVar instanceof C0455wc) || (scVar instanceof C0465yc) || (scVar instanceof Bc);
    }
}
