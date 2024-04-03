package com.huawei.hms.dtm.core;

import android.text.TextUtils;
import java.util.List;
import java.util.Locale;

/* renamed from: com.huawei.hms.dtm.core.hb  reason: case insensitive filesystem */
public class C0379hb extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (list == null || list.size() != 1 || !(list.get(0) instanceof Cc)) {
            throw new V("__tolowercase#param must be a string");
        }
        String str = (String) ((Cc) list.get(0)).value();
        return TextUtils.isEmpty(str) ? new Cc("") : new Cc(str.toLowerCase(Locale.ENGLISH));
    }

    public String a() {
        return "__tolowercase";
    }
}
