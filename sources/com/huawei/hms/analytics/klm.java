package com.huawei.hms.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.AGConnectOptions;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.analytics.core.log.HiLog;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

public final class klm {
    public static AGConnectOptions lmn(Context context) {
        AGConnectInstance instance = AGConnectInstance.getInstance();
        if (instance != null) {
            return instance.getOptions();
        }
        HiLog.w("jsonParses", "agConnectInstance is null, get services config");
        try {
            return AGConnectServicesConfig.fromContext(context);
        } catch (NoClassDefFoundError unused) {
            HiLog.w("jsonParses", "AGConnect Services Config not found");
            return null;
        }
    }

    public static void lmn(Map<String, String[]> map, String str, String[] strArr) {
        if (strArr.length > 0) {
            map.put(str, strArr);
        }
    }

    public static String[] lmn(String str) {
        if (TextUtils.isEmpty(str)) {
            return new String[0];
        }
        String[] split = str.split(",");
        ArrayList arrayList = new ArrayList();
        int length = split.length;
        for (int i11 = 0; i11 < length; i11++) {
            String str2 = split[i11];
            String lowerCase = str2.toLowerCase(Locale.US);
            if (lowerCase.startsWith("http://")) {
                HiLog.e("jsonParses", "URL cannot be http protocol");
            } else {
                if (!lowerCase.startsWith("https://")) {
                    str2 = "https://".concat(str2);
                }
                if (dz.lmn(str2)) {
                    arrayList.add(str2);
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
