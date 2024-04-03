package com.huawei.hms.dtm.core;

import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import java.security.SecureRandom;
import java.util.List;

public class Ta extends Y {

    /* renamed from: a  reason: collision with root package name */
    private static final C0440tc f48417a = new C0440tc(Double.valueOf(0.0d));

    /* renamed from: b  reason: collision with root package name */
    private static final C0440tc f48418b = new C0440tc(Double.valueOf(2.147483647E9d));

    private static boolean a(C0435sc<?> scVar) {
        return (scVar instanceof C0440tc) && !Double.isNaN(((Double) ((C0440tc) scVar).value()).doubleValue());
    }

    private static boolean a(C0435sc<?> scVar, C0435sc<?> scVar2) throws V {
        if (scVar == null || scVar2 == null) {
            throw new V("random#params error");
        }
        double doubleValue = scVar.c().doubleValue();
        double doubleValue2 = scVar2.c().doubleValue();
        if (Double.isNaN(doubleValue) || Double.isNaN(doubleValue2) || C0353ca.a(doubleValue, doubleValue2) || doubleValue == Double.POSITIVE_INFINITY) {
            return false;
        }
        if (doubleValue2 == Double.POSITIVE_INFINITY) {
            return true;
        }
        if (doubleValue2 == Double.NEGATIVE_INFINITY) {
            return false;
        }
        if (doubleValue == Double.NEGATIVE_INFINITY) {
            return true;
        }
        return Double.compare(doubleValue, doubleValue2) < 0;
    }

    private static boolean b(C0435sc<?> scVar, C0435sc<?> scVar2) throws V {
        if (C0353ca.b(scVar) || C0353ca.b(scVar2)) {
            throw new V("random#params error.The two param can not compare");
        }
        if ((scVar instanceof C0465yc) || (scVar instanceof C0455wc)) {
            scVar = new Cc(scVar.toString());
        }
        if ((scVar2 instanceof C0465yc) || (scVar2 instanceof C0455wc)) {
            scVar2 = new Cc(scVar2.toString());
        }
        return (!(scVar instanceof Cc) || !(scVar2 instanceof Cc)) ? a(scVar, scVar2) : ((String) ((Cc) scVar).value()).compareTo((String) ((Cc) scVar2).value()) < 0;
    }

    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        double d11;
        double d12;
        if (list != null) {
            C0435sc scVar = list.size() > 0 ? list.get(0) : f48417a;
            C0435sc scVar2 = list.size() > 1 ? list.get(1) : f48418b;
            if (!a(scVar) || !a(scVar2) || !b(scVar, scVar2)) {
                d12 = 0.0d;
                d11 = 2.147483647E9d;
            } else {
                d12 = ((Double) ((C0440tc) scVar).value()).doubleValue();
                d11 = ((Double) ((C0440tc) scVar2).value()).doubleValue();
            }
            SecureRandom genSecureRandom = EncryptUtil.genSecureRandom();
            return new Cc(genSecureRandom != null ? new C0440tc(Double.valueOf((double) Math.round((genSecureRandom.nextDouble() * (d11 - d12)) + d12))).toString() : "");
        }
        throw new V("random#params error");
    }

    public String a() {
        return "random";
    }
}
