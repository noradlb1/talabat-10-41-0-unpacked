package com.huawei.hms.maps.utils;

public class MapsAdvUtil {

    /* renamed from: a  reason: collision with root package name */
    private static String f49621a = "";

    private static boolean a(String str) {
        try {
            Class.forName(str, false, MapsAdvUtil.class.getClassLoader());
            return true;
        } catch (ClassNotFoundException unused) {
            LogM.d("MapsAdvUtil", "The class:" + str + " not found.");
            return false;
        }
    }

    public static boolean containsMapsAdvance() {
        return a("com.huawei.hms.maps.HuaweiMapEx");
    }

    public static boolean containsMapsBasic() {
        return a("com.huawei.hms.maps.provider.inhuawei.MapViewDelegate");
    }

    public static String getAccessToken() {
        return f49621a;
    }

    public static void setAccessToken(String str) {
        f49621a = str;
    }
}
