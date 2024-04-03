package com.huawei.hms.dtm;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.dtm.core.debug.PropertyUtil;

/* renamed from: com.huawei.hms.dtm.a  reason: case insensitive filesystem */
public final class C0339a {
    public static void a(Context context, Bundle bundle) {
        String str;
        if (bundle != null && !new E(bundle).a("$HA_FIXED_SOURCE")) {
            if (context == null) {
                str = "HA not initialized.";
            } else {
                String packageName = context.getPackageName();
                if (TextUtils.isEmpty(packageName)) {
                    str = "package name not found.";
                } else if (C.a() && packageName.equals(PropertyUtil.getSystemProperty("debug.huawei.hms.analytics.app", ""))) {
                    bundle.putString("$HA_FIXED_SOURCE", "StreamEvent");
                    bundle.putString("$HA_FIXED_TIMESTAMP", String.valueOf(System.currentTimeMillis()));
                    bundle.putString("$HA_FIXED_TAG", "_openness_config_tag");
                    bundle.putString("$HA_FIXED_TYPE", "oper");
                    return;
                } else {
                    return;
                }
            }
            Log.e("DebugFilter", str);
        }
    }
}
