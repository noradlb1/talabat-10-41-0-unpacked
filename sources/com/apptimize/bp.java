package com.apptimize;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class bp {

    /* renamed from: a  reason: collision with root package name */
    public static final String f41399a = "bp";

    /* renamed from: b  reason: collision with root package name */
    private static gd f41400b;

    /* renamed from: c  reason: collision with root package name */
    private static final Object f41401c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static eu f41402d = new eu();

    /* renamed from: e  reason: collision with root package name */
    private static final fp<JSONObject> f41403e = new fp<>(100);

    public static void a(eu euVar) {
        synchronized (f41401c) {
            f41402d = euVar;
        }
    }

    private static JSONObject b(String str, String str2, String str3, Throwable th2) throws JSONException {
        eu euVar;
        synchronized (f41401c) {
            euVar = f41402d;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", (Object) "LogItem");
        jSONObject.put("time", euVar.b());
        jSONObject.put("level", (Object) str);
        jSONObject.put("tag", (Object) str2);
        if (str3 != null) {
            jSONObject.put("msg", (Object) str3);
        }
        if (th2 != null) {
            jSONObject.put("tr", (Object) th2.getClass().getCanonicalName() + ": " + th2.getMessage());
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("type", (Object) "PassThroughToWeb");
        jSONObject2.put("message", (Object) jSONObject);
        return jSONObject2;
    }

    private static JSONObject c(String str, String str2, String str3, Throwable th2) {
        try {
            JSONObject b11 = b(str, str2, str3, th2);
            f41403e.a(b11);
            return b11;
        } catch (JSONException e11) {
            bo.m(f41399a, "error serializing log message.", e11);
            return null;
        }
    }

    private static boolean d(String str, String str2, String str3, Throwable th2) {
        gd gdVar;
        synchronized (f41401c) {
            gdVar = f41400b;
        }
        if (gdVar == null) {
            return false;
        }
        try {
            gdVar.a(b(str, str2, str3, (Throwable) null));
            return true;
        } catch (JSONException e11) {
            bo.m(f41399a, "error serializing log message.", e11);
            return false;
        }
    }

    public static void a(gd gdVar) {
        synchronized (f41401c) {
            f41400b = gdVar;
        }
    }

    public static void a() {
        synchronized (f41401c) {
            f41400b = null;
        }
    }

    public static boolean a(String str, String str2, String str3, Throwable th2) {
        boolean d11;
        synchronized (f41401c) {
            c(str, str2, str3, th2);
            d11 = d(str, str2, str3, th2);
        }
        return d11;
    }

    public static void b() {
        synchronized (f41401c) {
            if (f41400b != null) {
                Iterator<JSONObject> it = f41403e.a().iterator();
                while (it.hasNext()) {
                    f41400b.a(it.next());
                }
            }
        }
    }
}
