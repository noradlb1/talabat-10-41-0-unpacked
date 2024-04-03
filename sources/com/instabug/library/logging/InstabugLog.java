package com.instabug.library.logging;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.Feature;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.e0;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.util.InstabugDateFormatter;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.StringUtility;
import com.instabug.library.util.threading.PoolProvider;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class InstabugLog {
    public static final String LOG_MESSAGE_DATE_FORMAT = "MM-dd HH:mm:ss.SSS";

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f51414b;

        public a(String str) {
            this.f51414b = str;
        }

        public void run() {
            if (!InstabugLog.isInstabugLogsDisabled()) {
                InstabugLog.addLog(new h().c(StringUtility.trimString(this.f51414b)).b(g.V).a(InstabugLog.getDate()));
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f51415b;

        public b(String str) {
            this.f51415b = str;
        }

        public void run() {
            if (!InstabugLog.isInstabugLogsDisabled()) {
                InstabugLog.addLog(new h().c(StringUtility.trimString(this.f51415b)).b(g.D).a(InstabugLog.getDate()));
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f51416b;

        public c(String str) {
            this.f51416b = str;
        }

        public void run() {
            if (!InstabugLog.isInstabugLogsDisabled()) {
                InstabugLog.addLog(new h().c(StringUtility.trimString(this.f51416b)).b(g.I).a(InstabugLog.getDate()));
            }
        }
    }

    public class d implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f51417b;

        public d(String str) {
            this.f51417b = str;
        }

        public void run() {
            if (!InstabugLog.isInstabugLogsDisabled()) {
                InstabugLog.addLog(new h().c(StringUtility.trimString(this.f51417b)).b(g.E).a(InstabugLog.getDate()));
            }
        }
    }

    public class e implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f51418b;

        public e(String str) {
            this.f51418b = str;
        }

        public void run() {
            if (!InstabugLog.isInstabugLogsDisabled()) {
                InstabugLog.addLog(new h().c(StringUtility.trimString(this.f51418b)).b(g.W).a(InstabugLog.getDate()));
            }
        }
    }

    public class f implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f51419b;

        public f(String str) {
            this.f51419b = str;
        }

        public void run() {
            if (!InstabugLog.isInstabugLogsDisabled()) {
                InstabugLog.addLog(new h().c(StringUtility.trimString(this.f51419b)).b(g.WTF).a(InstabugLog.getDate()));
            }
        }
    }

    public enum g {
        V("v"),
        D("d"),
        I("i"),
        E("e"),
        W("w"),
        WTF("wtf");
        
        private final String level;

        private g(String str) {
            this.level = str;
        }

        @NonNull
        public String toString() {
            return this.level;
        }
    }

    public static class h {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private String f51420a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private g f51421b;

        /* renamed from: c  reason: collision with root package name */
        private long f51422c;

        public h a(long j11) {
            this.f51422c = j11;
            return this;
        }

        public h b(g gVar) {
            this.f51421b = gVar;
            return this;
        }

        public h c(String str) {
            this.f51420a = str;
            return this;
        }

        @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
        public JSONObject d() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(InstabugDbContract.InstabugLogEntry.COLUMN_LOG_MESSAGE, (Object) e());
                if (g() != null) {
                    jSONObject.put("log_message_level", (Object) g().toString());
                }
                jSONObject.put("log_message_date", f());
            } catch (JSONException e11) {
                InstabugSDKLogger.e("IBG-Core", "Error while parsing instabug logs", e11);
            }
            return jSONObject;
        }

        @Nullable
        public String e() {
            return this.f51420a;
        }

        public long f() {
            return this.f51422c;
        }

        @Nullable
        public g g() {
            return this.f51421b;
        }
    }

    /* access modifiers changed from: private */
    public static synchronized void addLog(h hVar) {
        synchronized (InstabugLog.class) {
            b.c(hVar);
        }
    }

    private static void clearLogMessages() {
        b.e();
    }

    public static void clearLogs() {
        clearLogMessages();
    }

    public static void d(String str) {
        PoolProvider.getSingleThreadExecutor("Database-Logging").execute(new b(str));
    }

    public static void e(String str) {
        PoolProvider.getSingleThreadExecutor("Database-Logging").execute(new d(str));
    }

    /* access modifiers changed from: private */
    public static long getDate() {
        return InstabugDateFormatter.getCurrentUTCTimeStampInMiliSeconds();
    }

    private static String getLogMessages(float f11) {
        JSONArray b11 = b.b(f11);
        try {
            if (!(b11 instanceof JSONArray)) {
                return b11.toString();
            }
            return JSONArrayInstrumentation.toString(b11);
        } catch (OutOfMemoryError e11) {
            InstabugCore.reportError(e11, "Couldn't parse Instabug logs due to an OOM");
            InstabugSDKLogger.e("IBG-Core", "Couldn't parse Instabug logs due to an OOM", e11);
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
    }

    public static String getLogs() {
        return getLogs(1.0f);
    }

    public static void i(String str) {
        PoolProvider.getSingleThreadExecutor("Database-Logging").execute(new c(str));
    }

    /* access modifiers changed from: private */
    public static boolean isInstabugLogsDisabled() {
        return e0.c().b((Object) Feature.INSTABUG_LOGS) == Feature.State.DISABLED;
    }

    public static void trimLogs() {
        b.g();
    }

    public static void v(String str) {
        PoolProvider.getSingleThreadExecutor("Database-Logging").execute(new a(str));
    }

    public static void w(String str) {
        PoolProvider.getSingleThreadExecutor("Database-Logging").execute(new e(str));
    }

    public static void wtf(String str) {
        PoolProvider.getSingleThreadExecutor("Database-Logging").execute(new f(str));
    }

    public static String getLogs(float f11) {
        return getLogMessages(f11);
    }
}
