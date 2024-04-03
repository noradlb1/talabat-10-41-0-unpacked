package com.huawei.hms.dtm.core;

import android.os.Build;
import com.newrelic.agent.android.hybrid.data.HexAttribute;
import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.vb  reason: case insensitive filesystem */
public class C0449vb extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        return new Cc(Build.ID);
    }

    public String a() {
        return HexAttribute.HEX_ATTR_JSERROR_BUILDID;
    }
}
