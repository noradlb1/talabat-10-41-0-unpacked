package com.iab.omid.library.deliveryhero3.utils;

import android.os.Build;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import org.json.JSONObject;

public final class b {
    public static String a() {
        return Build.MANUFACTURER + "; " + Build.MODEL;
    }

    public static String b() {
        return "Android";
    }

    public static String c() {
        return Integer.toString(Build.VERSION.SDK_INT);
    }

    public static JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        c.a(jSONObject, "deviceType", a());
        c.a(jSONObject, AnalyticsAttribute.OS_VERSION_ATTRIBUTE, c());
        c.a(jSONObject, "os", b());
        return jSONObject;
    }
}
