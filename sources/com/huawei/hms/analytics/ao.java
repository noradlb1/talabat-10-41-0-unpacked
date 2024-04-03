package com.huawei.hms.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.framework.config.IConfig;
import java.util.HashMap;
import java.util.Map;

public final class ao extends ijk {
    public ao(Context context, String str) {
        super(context, str);
        this.lmn = this.klm.build(str);
        av.lmn().lmn(str).ikl = dv.klm(context, "global_v2", "is_analytics_enabled".concat(String.valueOf(str)), true);
    }

    public static Map<String, String[]> klm(String str) {
        IConfig klm = av.lmn().lmn.f47867n.klm(str);
        HashMap hashMap = new HashMap();
        if (klm == null) {
            HiLog.i("interactionInstance", "The siteInfo to the current tag cannot be found.".concat(String.valueOf(str)));
            hashMap.put("errorCode", new String[]{be.klm(str) == null ? "-100" : "-101"});
            return hashMap;
        }
        hashMap.put("site", new String[]{klm.getSite()});
        hashMap.put("urls", klm.getServiceUrls());
        return hashMap;
    }

    public final void lmn(String str) {
        if (!TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put("ha-sdk-service", str);
            av.lmn().lmn(this.hij).klm = hashMap;
        }
    }
}
