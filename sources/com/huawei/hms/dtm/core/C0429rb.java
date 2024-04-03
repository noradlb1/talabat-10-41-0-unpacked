package com.huawei.hms.dtm.core;

import android.content.Context;
import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.rb  reason: case insensitive filesystem */
public class C0429rb extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (x11 != null) {
            Context c11 = x11.c();
            if (c11 != null) {
                return new Cc(c11.getPackageName());
            }
            throw new V("appId#appContext null");
        }
        throw new V("appId#params error");
    }

    public String a() {
        return "appId";
    }
}
