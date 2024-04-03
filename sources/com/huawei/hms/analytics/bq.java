package com.huawei.hms.analytics;

import android.os.Bundle;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public final class bq {
    public static final String[] lmn = {"com.huawei.agconnect.abtest.ABTestHAEventCallback", "com.huawei.agconnect.appmessaging.AppMessagingHAEventCallback"};
    public Map<String, Object> ikl = new HashMap();
    public Map<String, Method> klm = new HashMap();

    public final void lmn(String str, String str2, String str3, Bundle bundle) {
        Map<String, Method> map;
        Map<String, Object> map2 = this.ikl;
        if (map2 != null && map2.size() != 0 && (map = this.klm) != null && map.size() != 0) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("$HA_METADATA_TAG", str);
            bundle2.putString("$HA_METADATA_TYPE", str2);
            bundle2.putString("$HA_METADATA_SOURCE", "Event");
            dg.ikl().lmn(new cm(str3, bundle, bundle2, this.ikl, this.klm));
        }
    }

    public final void lmn(String str, String str2, String str3, Bundle bundle, long j11) {
        Map<String, Method> map;
        Map<String, Object> map2 = this.ikl;
        if (map2 != null && map2.size() != 0 && (map = this.klm) != null && map.size() != 0) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("$HA_METADATA_TAG", str);
            bundle2.putString("$HA_METADATA_TYPE", str2);
            bundle2.putString("$HA_METADATA_SOURCE", "StreamEvent");
            bundle2.putString("$HA_METADATA_TIMESTAMP", String.valueOf(j11));
            dg.ikl().lmn(new cm(str3, bundle, bundle2, this.ikl, this.klm));
        }
    }
}
