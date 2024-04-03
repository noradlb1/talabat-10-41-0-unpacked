package com.iab.omid.library.deliveryhero3.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hms.flutter.map.constants.Param;
import com.iab.omid.library.deliveryhero3.adsession.OutputDeviceStatus;
import com.iab.omid.library.deliveryhero3.internal.e;
import com.iab.omid.library.deliveryhero3.walking.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static WindowManager f44998a;

    /* renamed from: b  reason: collision with root package name */
    private static String[] f44999b = {Param.X, Param.Y, "width", "height"};

    /* renamed from: c  reason: collision with root package name */
    public static float f45000c = Resources.getSystem().getDisplayMetrics().density;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f45001a;

        static {
            int[] iArr = new int[OutputDeviceStatus.values().length];
            f45001a = iArr;
            try {
                iArr[OutputDeviceStatus.NOT_DETECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final float f45002a;

        /* renamed from: b  reason: collision with root package name */
        public final float f45003b;

        public b(float f11, float f12) {
            this.f45002a = f11;
            this.f45003b = f12;
        }
    }

    public static float a(int i11) {
        return ((float) i11) / f45000c;
    }

    private static b a(JSONObject jSONObject) {
        float f11;
        float f12;
        if (f44998a != null) {
            Point point = new Point(0, 0);
            f44998a.getDefaultDisplay().getRealSize(point);
            f12 = a(point.x);
            f11 = a(point.y);
        } else {
            f12 = 0.0f;
            f11 = 0.0f;
        }
        return new b(f12, f11);
    }

    public static JSONObject a(int i11, int i12, int i13, int i14) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Param.X, (double) a(i11));
            jSONObject.put(Param.Y, (double) a(i12));
            jSONObject.put("width", (double) a(i13));
            jSONObject.put("height", (double) a(i14));
        } catch (JSONException e11) {
            d.a("Error with creating viewStateObject", e11);
        }
        return jSONObject;
    }

    public static void a(Context context) {
        if (context != null) {
            f45000c = context.getResources().getDisplayMetrics().density;
            f44998a = (WindowManager) context.getSystemService("window");
        }
    }

    public static void a(JSONObject jSONObject, OutputDeviceStatus outputDeviceStatus) {
        try {
            jSONObject.put("noOutputDevice", a(outputDeviceStatus));
        } catch (JSONException e11) {
            d.a("Error with setting output device status", e11);
        }
    }

    public static void a(JSONObject jSONObject, a.C0052a aVar) {
        e a11 = aVar.a();
        JSONArray jSONArray = new JSONArray();
        for (String put : aVar.b()) {
            jSONArray.put((Object) put);
        }
        try {
            jSONObject.put("isFriendlyObstructionFor", (Object) jSONArray);
            jSONObject.put("friendlyObstructionClass", (Object) a11.d());
            jSONObject.put("friendlyObstructionPurpose", (Object) a11.b());
            jSONObject.put("friendlyObstructionReason", (Object) a11.a());
        } catch (JSONException e11) {
            d.a("Error with setting friendly obstruction", e11);
        }
    }

    public static void a(JSONObject jSONObject, Boolean bool) {
        try {
            jSONObject.put("hasWindowFocus", (Object) bool);
        } catch (JSONException e11) {
            d.a("Error with setting has window focus", e11);
        }
    }

    public static void a(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("adSessionId", (Object) str);
        } catch (JSONException e11) {
            d.a("Error with setting ad session id", e11);
        }
    }

    public static void a(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (NullPointerException | JSONException e11) {
            d.a("JSONException during JSONObject.put for name [" + str + "]", e11);
        }
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
                jSONObject.put("childViews", (Object) optJSONArray);
            }
            optJSONArray.put((Object) jSONObject2);
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
    }

    private static boolean a(OutputDeviceStatus outputDeviceStatus) {
        return a.f45001a[outputDeviceStatus.ordinal()] == 1;
    }

    private static boolean a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        if (jSONArray == null || jSONArray2 == null) {
            return false;
        }
        return jSONArray.length() == jSONArray2.length();
    }

    public static void b(JSONObject jSONObject) {
        b a11 = a(jSONObject);
        try {
            jSONObject.put("width", (double) a11.f45002a);
            jSONObject.put("height", (double) a11.f45003b);
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
    }

    public static void b(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("notVisibleReason", (Object) str);
        } catch (JSONException e11) {
            d.a("Error with setting not visible reason", e11);
        }
    }

    private static boolean b(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("childViews");
        if (optJSONArray == null && optJSONArray2 == null) {
            return true;
        }
        if (!a(optJSONArray, optJSONArray2)) {
            return false;
        }
        for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
            if (!h(optJSONArray.optJSONObject(i11), optJSONArray2.optJSONObject(i11))) {
                return false;
            }
        }
        return true;
    }

    private static boolean c(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray = jSONObject.optJSONArray("isFriendlyObstructionFor");
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("isFriendlyObstructionFor");
        if (optJSONArray == null && optJSONArray2 == null) {
            return true;
        }
        if (!a(optJSONArray, optJSONArray2)) {
            return false;
        }
        for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
            if (!optJSONArray.optString(i11, "").equals(optJSONArray2.optString(i11, ""))) {
                return false;
            }
        }
        return true;
    }

    private static boolean d(JSONObject jSONObject, JSONObject jSONObject2) {
        return Boolean.valueOf(jSONObject.optBoolean("hasWindowFocus")).equals(Boolean.valueOf(jSONObject2.optBoolean("hasWindowFocus")));
    }

    private static boolean e(JSONObject jSONObject, JSONObject jSONObject2) {
        return Boolean.valueOf(jSONObject.optBoolean("noOutputDevice")).equals(Boolean.valueOf(jSONObject2.optBoolean("noOutputDevice")));
    }

    private static boolean f(JSONObject jSONObject, JSONObject jSONObject2) {
        for (String str : f44999b) {
            if (jSONObject.optDouble(str) != jSONObject2.optDouble(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean g(JSONObject jSONObject, JSONObject jSONObject2) {
        return jSONObject.optString("adSessionId", "").equals(jSONObject2.optString("adSessionId", ""));
    }

    public static boolean h(@NonNull JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return true;
        }
        if (jSONObject == null || jSONObject2 == null) {
            return false;
        }
        return f(jSONObject, jSONObject2) && g(jSONObject, jSONObject2) && e(jSONObject, jSONObject2) && d(jSONObject, jSONObject2) && c(jSONObject, jSONObject2) && b(jSONObject, jSONObject2);
    }
}
