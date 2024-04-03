package com.huawei.hms.dtm.core;

import android.content.Context;
import android.content.pm.PackageManager;
import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.tb  reason: case insensitive filesystem */
public class C0439tb extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) {
        if (x11 != null) {
            Context c11 = x11.c();
            if (c11 != null) {
                try {
                    return new C0440tc(Double.valueOf((double) c11.getPackageManager().getPackageInfo(c11.getPackageName(), 16384).versionCode));
                } catch (PackageManager.NameNotFoundException unused) {
                    throw new V("appVersion#packageName not found.");
                }
            } else {
                throw new V("appVersion#appContext null");
            }
        } else {
            throw new V("appVersion#params error");
        }
    }

    public String a() {
        return "appVersion";
    }
}
