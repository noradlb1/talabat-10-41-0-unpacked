package com.huawei.hms.maps.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.huawei.hms.common.util.AGCUtils;
import com.huawei.hms.framework.common.SystemPropUtils;
import com.huawei.hms.maps.MapClientIdentify;
import com.visa.checkout.Profile;

public class MapClientUtil {
    private static String a(Context context) {
        try {
            Object obj = context.getPackageManager().getApplicationInfo(context.getApplicationContext().getPackageName(), 128).metaData.get("com.huawei.hms.client.appid");
            if (obj != null) {
                String valueOf = String.valueOf(obj);
                return valueOf.startsWith("appid=") ? valueOf.substring(6) : valueOf;
            }
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
        }
        return "";
    }

    public static String getAppId(Context context) {
        String appId = MapClientIdentify.getAppId();
        if (TextUtils.isEmpty(appId)) {
            appId = AgcCoreUtil.getString(context, "client/app_id");
        }
        if (TextUtils.isEmpty(appId)) {
            appId = AGCUtils.getAppId(context);
        }
        return TextUtils.isEmpty(appId) ? a(context) : appId;
    }

    public static String getSystemProperties(String str, String str2) {
        return SystemPropUtils.getProperty("get", str, "android.os.SystemProperties", str2);
    }

    public static boolean isOutOfChina(double d11, double d12) {
        return d11 < 72.004d || d11 > 137.8347d || d12 < 0.8293d || d12 > 55.8271d;
    }

    public static boolean validCountryCode(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.equals(Profile.Country.CN) || str.equals("DE") || str.equals(Profile.Country.SG) || str.equals("RU")) {
            return true;
        }
        LogM.i("MapClientUtil", "Invalid parameter,Valid values include CN、DE、SG、RU");
        return false;
    }
}
