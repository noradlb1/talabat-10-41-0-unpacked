package com.huawei.hms.dtm.core;

import android.content.Context;
import android.content.pm.PackageManager;
import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.ub  reason: case insensitive filesystem */
public class C0444ub extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (x11 != null) {
            Context c11 = x11.c();
            if (c11 != null) {
                try {
                    return new Cc(c11.getPackageManager().getPackageInfo(c11.getPackageName(), 16384).versionName);
                } catch (PackageManager.NameNotFoundException unused) {
                    throw new V("appVersionName#package name not found.");
                }
            } else {
                throw new V("appVersionName#appContext null");
            }
        } else {
            throw new V("appVersionName#params error");
        }
    }

    public String a() {
        return "appVersionName";
    }
}
