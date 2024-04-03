package com.huawei.hms.maps;

import android.content.Context;
import com.huawei.hms.maps.common.util.maa;
import com.huawei.hms.maps.model.BitmapDescriptorFactory;
import com.huawei.hms.maps.utils.MapsAdvUtil;

public final class MapsInitializer {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f49343a = false;

    /* renamed from: b  reason: collision with root package name */
    private static String f49344b;

    public static boolean a() {
        return f49343a;
    }

    public static synchronized void initialize(Context context) {
        synchronized (MapsInitializer.class) {
            BitmapDescriptorFactory.setContext(context);
            if (context != null) {
                if (!f49343a) {
                    maa.a(context, f49344b);
                }
                f49343a = true;
            }
        }
    }

    public static synchronized void initialize(Context context, String str) {
        synchronized (MapsInitializer.class) {
            f49344b = str;
            initialize(context);
        }
    }

    public static void setAccessToken(String str) {
        MapsAdvUtil.setAccessToken(str);
    }

    public static void setApiKey(String str) {
        MapClientIdentify.setApiKey(str);
    }

    public static void setAppId(String str) {
        MapClientIdentify.setAppId(str);
    }
}
