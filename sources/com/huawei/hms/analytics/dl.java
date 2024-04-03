package com.huawei.hms.analytics;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.type.HAEventType;
import com.huawei.hms.analytics.type.HAParamType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public final class dl {
    private static final String[] lmn = {"$HA_LOGIN", HAEventType.SIGNIN, "$HA_LOGOUT", HAEventType.SIGNOUT};

    public static boolean klm(Object obj) {
        if (obj == null) {
            return true;
        }
        try {
            return System.currentTimeMillis() > Long.parseLong((String) obj);
        } catch (NumberFormatException unused) {
            return true;
        }
    }

    public static long lmn(String str, long j11) {
        StringBuilder sb2;
        String str2;
        long j12 = 5000;
        if (j11 < 5000) {
            sb2 = new StringBuilder();
            sb2.append(str);
            str2 = " below minimum size.";
        } else {
            j12 = WorkRequest.MAX_BACKOFF_MILLIS;
            if (j11 <= WorkRequest.MAX_BACKOFF_MILLIS) {
                return j11;
            }
            sb2 = new StringBuilder();
            sb2.append(str);
            str2 = " exceeds the maximum size.";
        }
        sb2.append(str2);
        HiLog.w("CheckToolsKit", sb2.toString());
        return j12;
    }

    private static List<bb> lmn(Map<String, String> map, Map<String, String> map2) {
        String str;
        boolean z11 = map instanceof LinkedHashMap;
        long j11 = 0;
        ArrayList arrayList = null;
        for (Map.Entry next : map.entrySet()) {
            String str2 = (String) next.getKey();
            String str3 = (String) next.getValue();
            boolean z12 = false;
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                HiLog.w("CheckToolsKit", HiLog.ErrorCode.PE001, "tags param is null");
            } else {
                if (str2.length() > 64) {
                    str = "Length of log tag key exceeds the limit. Max Length is 64.";
                } else if (str3.length() > 256) {
                    str = "Length of log tag value exceeds the limit. Max Length is 256.";
                } else {
                    z12 = lmn("logTag", str2, aq.ikl);
                }
                HiLog.w("CheckToolsKit", HiLog.ErrorCode.PE002, str);
            }
            if (z12) {
                if (z11) {
                    map2.put(str2, str3);
                    j11++;
                    if (j11 >= 50) {
                        break;
                    }
                } else {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(new bb(str2, str3));
                }
            }
        }
        return arrayList;
    }

    public static Map<String, String> lmn(Map<String, String> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (map == null || map.size() == 0) {
            HiLog.w("CheckToolsKit", "custom log tags is empty");
            return linkedHashMap;
        }
        List<bb> lmn2 = lmn(map, (Map<String, String>) linkedHashMap);
        if (lmn2 != null && lmn2.size() > 0) {
            lmn(lmn2, (Map<String, String>) linkedHashMap);
        }
        return linkedHashMap;
    }

    private static void lmn(List<bb> list, Map<String, String> map) {
        Collections.sort(list, new Cdo());
        int i11 = 0;
        for (bb next : list) {
            map.put(next.lmn, (String) next.klm);
            i11++;
            if (i11 >= 50) {
                return;
            }
        }
    }

    public static boolean lmn(long j11, long j12) {
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance.setTimeInMillis(j11);
        instance2.setTimeInMillis(j12);
        return (instance.get(1) == instance2.get(1) && instance.get(6) == instance2.get(6)) ? false : true;
    }

    public static boolean lmn(Object obj) {
        return (obj instanceof Number) || (obj instanceof String) || (obj instanceof Character) || (obj instanceof Boolean);
    }

    public static boolean lmn(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "checkProperty: key is empty";
        } else if (str.length() <= 256 && !str.startsWith("ha_")) {
            return true;
        } else {
            str2 = "checkProperty: key check failed";
        }
        HiLog.w("CheckToolsKit", str2);
        return false;
    }

    public static boolean lmn(String str, int i11) {
        if (TextUtils.isEmpty(str)) {
            HiLog.w("CheckToolsKit", HiLog.ErrorCode.PE001, " param is null");
            return false;
        } else if (str.length() <= i11) {
            return true;
        } else {
            HiLog.w("CheckToolsKit", HiLog.ErrorCode.PE002, " Length of param exceeds the limit. Max Length is ".concat(String.valueOf(i11)));
            return false;
        }
    }

    public static boolean lmn(String str, Bundle bundle) {
        if (bundle == null || bundle.isEmpty() || TextUtils.isEmpty(str) || !Arrays.asList(lmn).contains(str)) {
            return false;
        }
        String string = bundle.getString("$HA_METHOD");
        String string2 = bundle.getString(HAParamType.CHANNEL);
        if (!"Account Kit".equals(string) && !"Account Kit".equals(string2)) {
            return false;
        }
        HiLog.w("CheckToolsKit", "params value Account Kit is illegal");
        return true;
    }

    public static boolean lmn(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            HiLog.w("CheckToolsKit", "checkProperty: key is empty");
            return false;
        } else if (str2 != null && TextUtils.isEmpty(str2)) {
            HiLog.w("CheckToolsKit", "checkProperty: value is empty");
            return false;
        } else if (str.length() > 256 || str.startsWith("ha_")) {
            HiLog.w("CheckToolsKit", HiLog.ErrorCode.PE002, "Length of userProperty key exceeds the limit. Max Length is 256.");
            return false;
        } else if (str2 == null || str2.length() <= 256) {
            return lmn("userProfileParams", str, aq.ikl);
        } else {
            HiLog.w("CheckToolsKit", HiLog.ErrorCode.PE002, "Length of userProperty value exceeds the limit. Max Length is 256.");
            return false;
        }
    }

    public static boolean lmn(String str, String str2, Pattern pattern) {
        String str3;
        String str4;
        if (TextUtils.isEmpty(str2)) {
            str3 = str + " is null";
            str4 = HiLog.ErrorCode.PE001;
        } else if (pattern.matcher(str2).matches()) {
            return true;
        } else {
            str3 = str + " is invalid.";
            str4 = HiLog.ErrorCode.PE006;
        }
        HiLog.w("CheckToolsKit", str4, str3);
        return false;
    }

    public static boolean lmn(String str, List<String> list) {
        for (String equals : list) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
