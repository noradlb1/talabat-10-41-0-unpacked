package com.huawei.hms.dtm.core;

import android.content.Context;
import com.huawei.hms.dtm.core.C0411nd;
import java.util.List;

public class Jb extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (x11 != null) {
            Context c11 = x11.c();
            if (c11 != null) {
                C0411nd.a a11 = C0411nd.a(c11, 10000);
                return C0430rc.a(a11 == null ? false : a11.b());
            }
            throw new V("gaidTrackLimit#appContext null");
        }
        throw new V("gaidTrackLimit#params error");
    }

    public String a() {
        return "gaidTrackLimit";
    }
}
