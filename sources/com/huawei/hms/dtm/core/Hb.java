package com.huawei.hms.dtm.core;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.dtm.core.C0411nd;
import java.util.List;

public class Hb extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (x11 != null) {
            Context c11 = x11.c();
            if (c11 != null) {
                C0411nd.a a11 = C0411nd.a(c11, 10000);
                return (a11 == null || TextUtils.isEmpty(a11.a())) ? Cc.f48270b : a11.b() ? new Cc("00000000-0000-0000-0000-000000000000") : new Cc(a11.a());
            }
            throw new V("gaid#appContext null");
        }
        throw new V("gaid#params error");
    }

    public String a() {
        return "gaid";
    }
}
