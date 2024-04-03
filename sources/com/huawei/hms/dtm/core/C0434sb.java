package com.huawei.hms.dtm.core;

import android.content.Context;
import android.content.pm.PackageManager;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.sb  reason: case insensitive filesystem */
public class C0434sb extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (x11 != null) {
            Context c11 = x11.c();
            if (c11 != null) {
                try {
                    PackageManager packageManager = c11.getPackageManager();
                    return new Cc(packageManager.getApplicationLabel(packageManager.getApplicationInfo(c11.getPackageName(), 0)).toString());
                } catch (PackageManager.NameNotFoundException unused) {
                    return Cc.f48270b;
                }
            } else {
                throw new V("appName#appContext null");
            }
        } else {
            throw new V("appName#params error");
        }
    }

    public String a() {
        return AnalyticsAttribute.APP_NAME_ATTRIBUTE;
    }
}
