package com.huawei.hms.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.analytics.framework.config.IConfig;
import java.util.HashMap;
import java.util.Map;

public final class b {
    private static final Map<String, b> klm = new HashMap();
    private final String ikl;
    public String lmn;

    private b(Context context, String str) {
        this.ikl = str;
        String klm2 = dv.klm(context, "Privacy_MY", str + "_region", "");
        this.lmn = klm2;
        if (TextUtils.isEmpty(klm2)) {
            this.lmn = av.lmn().lmn.f47867n.hij;
            dv.lmn(context, "Privacy_MY", str + "_region", this.lmn);
        }
    }

    public static b lmn(Context context, String str) {
        Map<String, b> map = klm;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        b bVar = new b(context, str);
        map.put(str, bVar);
        return bVar;
    }

    public static Map<String, b> lmn() {
        return klm;
    }

    public final void klm() {
        bl lmn2 = cde.lmn().lmn(this.ikl);
        if (lmn2 != null) {
            bc bcVar = av.lmn().lmn.f47867n;
            String str = this.lmn;
            ca caVar = new ca(str, bcVar.lmn.get(str));
            if ("_openness_config_tag".equals(this.ikl)) {
                lmn2.lmn((IConfig) caVar);
            }
            lmn2.klm((IConfig) caVar);
        }
    }

    public final void lmn(String str) {
        this.lmn = str;
        av.lmn().lmn.f47867n.lmn(this.ikl, str);
        Context context = av.lmn().lmn.ghi;
        dv.lmn(context, "Privacy_MY", this.ikl + "_region", str);
    }
}
