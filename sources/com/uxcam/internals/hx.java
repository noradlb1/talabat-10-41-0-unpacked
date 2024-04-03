package com.uxcam.internals;

import android.util.Pair;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.lang.Thread;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class hx implements Thread.UncaughtExceptionHandler {

    /* renamed from: b  reason: collision with root package name */
    public static final String f13610b = "hx";

    /* renamed from: a  reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f13611a;

    public hx(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f13611a = uncaughtExceptionHandler;
    }

    public static Pair<JSONArray, String> a(String str, boolean z11) {
        JSONArray jSONArray = new JSONArray();
        Iterator<Map.Entry<Thread, StackTraceElement[]>> it = Thread.getAllStackTraces().entrySet().iterator();
        String str2 = "";
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry next = it.next();
            try {
                boolean equals = ((Thread) next.getKey()).getName().equals(str);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("title", (Object) ((Thread) next.getKey()).getName());
                jSONObject.put("state", (Object) ((Thread) next.getKey()).getState());
                JSONArray jSONArray2 = new JSONArray();
                for (StackTraceElement stackTraceElement : (StackTraceElement[]) next.getValue()) {
                    if (equals && str2.isEmpty()) {
                        str2 = stackTraceElement.toString();
                    }
                    jSONArray2.put((Object) stackTraceElement.toString());
                }
                jSONObject.put("backtrace", (Object) jSONArray2);
                if (equals && z11) {
                    jSONArray = new JSONArray().put((Object) jSONObject);
                    break;
                }
                jSONArray.put((Object) jSONObject);
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
        }
        return new Pair<>(jSONArray, str2);
    }

    public void uncaughtException(Thread thread, Throwable th2) {
        String str;
        gu.a(f13610b).getClass();
        JSONArray jSONArray = new JSONArray();
        jSONArray.put((Object) a(th2));
        if (th2.getStackTrace()[0] != null) {
            str = th2.getStackTrace()[0].toString();
        } else {
            str = "";
        }
        for (Throwable cause = th2.getCause(); cause != null; cause = cause.getCause()) {
            jSONArray.put((Object) a(cause));
            if (str.isEmpty() && cause.getStackTrace()[0] != null) {
                str = cause.getStackTrace()[0].toString();
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("crashedThread", (Object) ((JSONArray) a(thread.getName(), true).first).getJSONObject(0));
            jSONObject.put("crashExceptions", (Object) jSONArray);
            jSONObject.put("screen", (Object) hb.c().d());
            jSONObject.put("threads", a(thread.getName(), false).first);
            jSONObject.put("crashedThread-TopOfStack", (Object) str);
            jSONObject.put("time", (double) ia.d());
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("exception", th2);
            hu.c("UnCaughtExceptionHandled", hashMap);
        } catch (Exception e12) {
            fx fxVar = new fx();
            fxVar.a("EXCEPTION");
            fxVar.a("site_of_error", "UncaughtExceptionHandler::uncaughtException()");
            fxVar.a("reason", e12.getMessage());
            fxVar.a(2);
        }
        gk.a().a(ia.f13617c, JSONObjectInstrumentation.toString(jSONObject));
        this.f13611a.uncaughtException(thread, th2);
    }

    public static JSONObject a(Throwable th2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("UnhandledExceptionName", (Object) th2.getClass().getName());
            jSONObject.put("UnhandledExceptionReason", (Object) th2.getMessage());
            JSONArray jSONArray = new JSONArray();
            StackTraceElement[] stackTrace = th2.getStackTrace();
            int length = stackTrace.length;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                jSONArray.put((Object) stackTrace[i11].toString());
                i12++;
                if (i12 > 100) {
                    jSONArray.put((Object) "---BACKTRACE STOPPED AT 100 ENTRIES---");
                    break;
                }
                i11++;
            }
            jSONObject.put("UnhandledExceptionCallStack", (Object) jSONArray);
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return jSONObject;
    }
}
