package com.huawei.hms.analytics;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.receiver.SafeIntent;
import java.util.LinkedHashMap;
import java.util.Map;

public final class cde {
    private static final cde lmn = new cde();
    private final Map<String, bl> klm = new LinkedHashMap();

    public static void klm(Context context) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            SafeIntent safeIntent = new SafeIntent(activity.getIntent());
            cb lmn2 = di.lmn(activity);
            if (TextUtils.isEmpty(av.lmn().lmn.f47857d)) {
                di.lmn(activity, lmn2);
            }
            if (TextUtils.isEmpty(av.lmn().lmn.f47858e)) {
                di.klm(lmn2);
            }
            av.lmn().lmn.cde = safeIntent.getAction();
        }
    }

    public static cde lmn() {
        return lmn;
    }

    public static void lmn(Context context) {
        dv.lmn(context, "global_v2", "is_analytics_initialized", 1);
    }

    public static void lmn(Context context, bl blVar) {
        Application lmn2 = context instanceof Application ? (Application) context : dp.lmn();
        e lmn3 = e.lmn((Context) lmn2);
        lmn3.ikl = blVar;
        if (lmn3.lmn) {
            lmn3.lmn();
        }
        c.lmn().def = blVar;
        d.lmn().lmn(lmn2);
    }

    public static void lmn(hij hij) {
        dg.lmn().lmn(hij);
    }

    public final void klm() {
        for (Map.Entry next : this.klm.entrySet()) {
            String str = (String) next.getKey();
            if (!str.equals("_openness_config_tag")) {
                if (!av.lmn().lmn(str).ikl) {
                    HiLog.w("HiAnalyticsInstanceCommander", HiLog.ErrorCode.IE006, "The Analytics Kit is disabled. serviceTag: ".concat(str));
                } else {
                    ((bl) next.getValue()).lmn();
                }
            }
        }
    }

    public final bl lmn(String str) {
        return this.klm.get(str);
    }

    public final void lmn(String str, bl blVar) {
        this.klm.put(str, blVar);
    }
}
