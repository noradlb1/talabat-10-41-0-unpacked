package com.uxcam.internals;

import android.content.pm.PackageManager;
import com.adjust.sdk.AdjustConfig;
import java.util.HashMap;
import java.util.Map;

public class ht {

    /* renamed from: a  reason: collision with root package name */
    public static Map f13602a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public static String f13603b = "android";

    public static String a() {
        try {
            ((HashMap) f13602a).put(AdjustConfig.ENVIRONMENT_PRODUCTION, "https://verify.uxcam.com/v4/verify");
            ((HashMap) f13602a).put("staging", "https://verify-staging.uxcam.com/v4/verify");
            ((HashMap) f13602a).put("ui_test", "http://192.168.232.2:13277/v4/verify");
            String str = (String) ((HashMap) f13602a).get(ia.c().getPackageManager().getApplicationInfo(ia.c().getPackageName(), 128).metaData.getString("UXCamServerRegion"));
            if (str != null) {
                return str;
            }
            return (String) ((HashMap) f13602a).get(AdjustConfig.ENVIRONMENT_PRODUCTION);
        } catch (PackageManager.NameNotFoundException unused) {
            return (String) ((HashMap) f13602a).get(AdjustConfig.ENVIRONMENT_PRODUCTION);
        } catch (NullPointerException unused2) {
            return (String) ((HashMap) f13602a).get(AdjustConfig.ENVIRONMENT_PRODUCTION);
        }
    }
}
