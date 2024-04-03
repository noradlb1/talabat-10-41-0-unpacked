package com.huawei.hms.dtm.core;

import android.text.TextUtils;
import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.pc  reason: case insensitive filesystem */
public class C0420pc extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (x11 == null || list == null || list.size() != 2) {
            throw new V("_vp#params error");
        }
        C0435sc<?> a11 = x11.a("dtm.eventName");
        if (a11 instanceof Cc) {
            String str = (String) ((Cc) a11).value();
            C0435sc scVar = list.get(1);
            if (scVar instanceof Cc) {
                String str2 = (String) ((Cc) scVar).value();
                return C0430rc.a((TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? false : str.equals(str2));
            }
            throw new V("_vp#param type error");
        }
        throw new V("_vp#params error");
    }

    public String a() {
        return "_vp";
    }
}
