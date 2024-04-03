package com.huawei.hms.dtm.core;

import android.content.Context;
import android.webkit.WebSettings;
import java.util.List;

public class Sb extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (x11 != null) {
            Context c11 = x11.c();
            if (c11 != null) {
                return new Cc(WebSettings.getDefaultUserAgent(c11));
            }
            throw new V("userAgent#appContext null");
        }
        throw new V("userAgent#params error");
    }

    public String a() {
        return "userAgent";
    }
}
