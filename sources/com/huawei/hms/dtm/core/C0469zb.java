package com.huawei.hms.dtm.core;

import android.content.Context;
import android.provider.Settings;
import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.zb  reason: case insensitive filesystem */
public class C0469zb extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (x11 != null) {
            Context c11 = x11.c();
            if (c11 != null) {
                String string = Settings.System.getString(c11.getContentResolver(), "android_id");
                return string == null ? Cc.f48270b : new Cc(string);
            }
            throw new V("deviceId#appContext null");
        }
        throw new V("deviceId#params error");
    }

    public String a() {
        return "deviceId";
    }
}
