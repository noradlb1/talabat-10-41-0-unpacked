package com.huawei.hms.dtm.core;

import android.os.Bundle;
import com.huawei.hms.dtm.core.safe.SafeBundle;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.hms.dtm.core.ga  reason: case insensitive filesystem */
public class C0373ga extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (list == null || list.size() < 1) {
            throw new V("__bundle#wrong params size");
        }
        boolean z11 = false;
        C0435sc scVar = list.get(0);
        if (scVar instanceof C0465yc) {
            if (list.size() >= 2) {
                C0435sc scVar2 = list.get(1);
                if (scVar2 instanceof C0430rc) {
                    z11 = ((Boolean) ((C0430rc) scVar2).value()).booleanValue();
                } else {
                    throw new V("__bundle#wrong params type");
                }
            }
            Map value = ((C0465yc) scVar).value();
            Bundle a11 = C0343aa.a((Map<String, Object>) value);
            if (z11) {
                SafeBundle safeBundle = new SafeBundle(a11);
                for (String str : value.keySet()) {
                    if (str != null && str.startsWith("$HA_")) {
                        safeBundle.remove(str);
                    }
                }
            }
            return new Ac(a11);
        }
        throw new V("__bundle#wrong params type");
    }

    public String a() {
        return "__bundle";
    }
}
