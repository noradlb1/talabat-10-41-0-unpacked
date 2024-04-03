package com.huawei.hms.dtm.core;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.wb  reason: case insensitive filesystem */
public class C0454wb extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (x11 != null) {
            Context c11 = x11.c();
            if (c11 != null) {
                TelephonyManager telephonyManager = (TelephonyManager) c11.getSystemService("phone");
                if (telephonyManager != null) {
                    String networkOperatorName = telephonyManager.getNetworkOperatorName();
                    if (!TextUtils.isEmpty(networkOperatorName)) {
                        return new Cc(networkOperatorName);
                    }
                }
                return Cc.f48270b;
            }
            throw new V("carrier#appContext null");
        }
        throw new V("carrier#params error");
    }

    public String a() {
        return "carrier";
    }
}
