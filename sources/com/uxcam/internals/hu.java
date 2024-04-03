package com.uxcam.internals;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.internal.NativeProtocol;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.visa.checkout.Profile;
import java.util.ConcurrentModificationException;
import java.util.Map;
import java.util.Objects;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class hu {

    /* renamed from: a  reason: collision with root package name */
    public static JSONArray f13604a;

    /* renamed from: b  reason: collision with root package name */
    public static SharedPreferences f13605b;

    /* renamed from: c  reason: collision with root package name */
    public static int f13606c;

    public static void a(String str, String str2, Map map) {
        try {
            Context context = ia.f13617c;
            if (context != null) {
                boolean z11 = false;
                if (f13605b == null) {
                    f13605b = context.getSharedPreferences("UXCamLog", 0);
                }
                if (f13605b.getBoolean("debug", true)) {
                    if (f13604a == null) {
                        z11 = true;
                    }
                    if (z11) {
                        f13604a = new JSONArray(f13605b.getString("events", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI));
                    }
                    if (f13604a.length() <= 1000) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("tag", (Object) str2);
                        jSONObject.put("logLevel", (Object) str);
                        jSONObject.put("time", System.currentTimeMillis());
                        jSONObject.put("timeline", (double) ia.d());
                        jSONObject.put("screen", (Object) hb.c().d());
                        jSONObject.put("lastSessionID", (Object) ie.a(context).a(gm.L));
                        jSONObject.put("sessionID", (Object) gm.L);
                        if (map != null) {
                            jSONObject.put(NativeProtocol.WEB_DIALOG_PARAMS, (Object) new JSONObject((Map<?, ?>) map));
                        }
                        f13604a.put((Object) jSONObject);
                        jSONObject.toString();
                        SharedPreferences.Editor edit = f13605b.edit();
                        JSONArray jSONArray = f13604a;
                        edit.putString("events", !(jSONArray instanceof JSONArray) ? jSONArray.toString() : JSONArrayInstrumentation.toString(jSONArray)).apply();
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException | ConcurrentModificationException | JSONException e11) {
            e11.getMessage();
        }
    }

    public static void b(String str, Map map) {
        int i11 = gm.K;
        if (i11 == 3 || i11 == 4) {
            a("I", str, map);
        }
    }

    public static void c(String str, Map map) {
        int i11 = gm.K;
        if (i11 == 1 || i11 == 4) {
            a(Profile.Country.IE, str, map);
        }
    }

    public static void d(String str, Map map) {
        int i11 = gm.K;
        if (i11 == 2 || i11 == 4) {
            a(ExifInterface.LONGITUDE_WEST, str, map);
        }
    }

    public static void a(String str, Map map) {
        if (gm.K == 4) {
            a(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, str, map);
        }
    }

    public static void a(Context context) {
        try {
            JSONArray jSONArray = f13604a;
            if (!(jSONArray instanceof JSONArray)) {
                jSONArray.toString();
            } else {
                JSONArrayInstrumentation.toString(jSONArray);
            }
            JSONArray jSONArray2 = new JSONArray();
            for (int i11 = f13606c + 1; i11 < f13604a.length(); i11++) {
                jSONArray2.put(f13604a.get(i11));
            }
            f13604a = jSONArray2;
            if (jSONArray2.length() > 0) {
                jSONArray2.length();
                Objects.toString(jSONArray2.get(0));
            }
            JSONArray jSONArray3 = f13604a;
            if (!(jSONArray3 instanceof JSONArray)) {
                jSONArray3.toString();
            } else {
                JSONArrayInstrumentation.toString(jSONArray3);
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
            e11.getMessage();
            e11.getMessage();
        }
        SharedPreferences.Editor edit = context.getSharedPreferences("UXCamLog", 0).edit();
        JSONArray jSONArray4 = f13604a;
        edit.putString("events", !(jSONArray4 instanceof JSONArray) ? jSONArray4.toString() : JSONArrayInstrumentation.toString(jSONArray4)).apply();
        f13604a.length();
    }
}
