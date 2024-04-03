package com.huawei.hms.analytics;

import android.content.Context;
import com.huawei.hms.analytics.core.log.HiLog;
import java.util.Map;

public final class i extends f {
    public i(cb cbVar, Context context) {
        this.ikl = cbVar;
        this.klm = context;
        this.lmn = "MiPushHelper";
    }

    public final as lmn() {
        try {
            Class<?> cls = Class.forName("com.xiaomi.mipush.sdk.MiPushMessage");
            Object invoke = cls.getDeclaredMethod("getExtra", new Class[0]).invoke(this.ikl.ijk("key_message"), new Object[0]);
            if (invoke instanceof Map) {
                String str = (String) ((Map) invoke).remove("$CampaignPushInfo");
                if (!f.lmn(str)) {
                    return new as(str);
                }
                HiLog.i(this.lmn, "campaign info check failed");
                return null;
            }
        } catch (Throwable unused) {
            HiLog.w("MiPushHelper", "getCampInfo exception");
        }
        return null;
    }
}
