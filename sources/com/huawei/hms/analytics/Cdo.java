package com.huawei.hms.analytics;

import com.huawei.hms.analytics.database.LogConfig;
import java.io.Serializable;
import java.util.Comparator;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.analytics.do  reason: invalid class name */
public final class Cdo implements Serializable, Comparator<bb> {

    /* renamed from: com.huawei.hms.analytics.do$klm */
    public static class klm implements Serializable, Comparator<LogConfig> {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return ((LogConfig) obj).getRegion().compareTo(((LogConfig) obj2).getRegion());
        }
    }

    /* renamed from: com.huawei.hms.analytics.do$lmn */
    public static class lmn implements Serializable, Comparator<JSONObject> {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            int i11 = (Long.parseLong(((JSONObject) obj).optString("t", "0")) > Long.parseLong(((JSONObject) obj2).optString("t", "0")) ? 1 : (Long.parseLong(((JSONObject) obj).optString("t", "0")) == Long.parseLong(((JSONObject) obj2).optString("t", "0")) ? 0 : -1));
            if (i11 > 0) {
                return 1;
            }
            return i11 == 0 ? 0 : -1;
        }
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((bb) obj).lmn.compareTo(((bb) obj2).lmn);
    }
}
