package com.huawei.hms.analytics;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

public final class be {
    private static boolean ikl = false;
    private static boolean klm = false;
    private static final Map<String, Boolean> lmn = new HashMap();

    public static boolean ghi() {
        Context context = av.lmn().lmn.ghi;
        return dv.lmn(context, "global_v2", "is_restriction_enabled") ? dv.klm(context, "global_v2", "is_restriction_enabled", false) : !dv.klm(context, "global_v2", "is_analytics_enabled", true);
    }

    public static void hij() {
        ikl = true;
    }

    public static boolean ijk() {
        return ikl;
    }

    public static void ikl() {
        klm = true;
    }

    public static Boolean klm(String str) {
        Map<String, Boolean> map = lmn;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        return null;
    }

    public static boolean klm() {
        return klm;
    }

    public static void lmn(String str, Boolean bool) {
        lmn.put(str, bool);
    }

    public static boolean lmn() {
        return lmn("_openness_config_tag");
    }

    public static boolean lmn(String str) {
        Boolean bool;
        Map<String, Boolean> map = lmn;
        if (!map.containsKey(str) || (bool = map.get(str)) == null) {
            return false;
        }
        return bool.booleanValue();
    }
}
