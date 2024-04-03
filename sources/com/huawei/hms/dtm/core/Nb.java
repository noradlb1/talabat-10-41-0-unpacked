package com.huawei.hms.dtm.core;

import android.os.Build;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import java.util.List;

public class Nb extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        return new Cc(Build.VERSION.RELEASE);
    }

    public String a() {
        return AnalyticsAttribute.OS_VERSION_ATTRIBUTE;
    }
}
