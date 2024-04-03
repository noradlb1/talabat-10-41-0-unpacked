package com.instabug.library.model;

import android.annotation.SuppressLint;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.internal.storage.cache.Cacheable;
import com.instabug.library.logging.InstabugLog;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.StringUtility;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class a implements Cacheable, Serializable {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private String f51507a;

    /* renamed from: b  reason: collision with root package name */
    private long f51508b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private String f51509c;

    public static ArrayList a(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                a aVar = new a();
                JSONObject jSONObject = jSONArray.getJSONObject(i11);
                aVar.fromJson(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    @Nullable
    public String b() {
        return this.f51507a;
    }

    public long c() {
        return this.f51508b;
    }

    public void fromJson(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("timestamp")) {
            if (StringUtility.isNumeric(jSONObject.getString("timestamp"))) {
                a(jSONObject.getLong("timestamp"));
            } else {
                a(a(jSONObject.getString("timestamp")));
            }
        }
        if (jSONObject.has("message")) {
            c(jSONObject.getString("message"));
        }
        if (jSONObject.has("date")) {
            b(jSONObject.getString("date"));
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public String toJson() throws JSONException {
        if (this.f51508b == 0 && Looper.myLooper() != Looper.getMainLooper()) {
            a(a(a()));
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("timestamp", c());
        jSONObject.put("message", (Object) b());
        jSONObject.put("date", (Object) a());
        return JSONObjectInstrumentation.toString(jSONObject);
    }

    @NonNull
    public String toString() {
        return "ConsoleLog{timeStamp='" + this.f51508b + '\'' + ", message='" + this.f51507a + '\'' + ", date='" + this.f51509c + '\'' + AbstractJsonLexerKt.END_OBJ;
    }

    public void b(String str) {
        this.f51509c = str;
    }

    public void c(@Nullable String str) {
        this.f51507a = str;
    }

    public static JSONArray a(@Nullable ArrayList arrayList) {
        JSONArray jSONArray = new JSONArray();
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                try {
                    jSONArray.put((Object) new JSONObject(((a) it.next()).toJson()));
                } catch (JSONException e11) {
                    InstabugSDKLogger.e("IBG-Core", "Error while parsing console log " + e11.getMessage());
                }
            }
        }
        return jSONArray;
    }

    public void a(long j11) {
        this.f51508b = j11;
    }

    @Nullable
    public String a() {
        return this.f51509c;
    }

    public static long a(@Nullable String str) {
        if (str != null) {
            try {
                Date parse = new SimpleDateFormat(InstabugLog.LOG_MESSAGE_DATE_FORMAT, Locale.US).parse(str);
                Calendar instance = Calendar.getInstance();
                if (parse != null) {
                    instance.setTime(parse);
                }
                Calendar instance2 = Calendar.getInstance();
                instance2.set(2, instance.get(2));
                instance2.set(5, instance.get(5));
                instance2.set(11, instance.get(11));
                instance2.set(12, instance.get(12));
                instance2.set(13, instance.get(13));
                instance2.set(14, instance.get(14));
                return instance2.getTimeInMillis();
            } catch (Exception e11) {
                InstabugSDKLogger.e("IBG-Core", "Error happened when trying to parse Console log message date: " + str + ", error message: " + e11.getMessage());
            }
        }
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b7, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        com.instabug.library.util.InstabugSDKLogger.e("IBG-Core", "Failed to close file reader", r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c1, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        r2.destroy();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00e3, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        com.instabug.library.util.InstabugSDKLogger.e("IBG-Core", "Failed to close file reader", r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00eb, code lost:
        throw r9;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:28:0x00b3, B:39:0x00c8] */
    @android.annotation.SuppressLint({"RESOURCE_LEAK"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.util.ArrayList a(float r9) {
        /*
            java.lang.Class<com.instabug.library.model.a> r0 = com.instabug.library.model.a.class
            monitor-enter(r0)
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x00f0 }
            r1.<init>()     // Catch:{ all -> 0x00f0 }
            com.instabug.library.e0 r2 = com.instabug.library.e0.c()     // Catch:{ all -> 0x00f0 }
            com.instabug.library.Feature r3 = com.instabug.library.Feature.CONSOLE_LOGS     // Catch:{ all -> 0x00f0 }
            com.instabug.library.Feature$State r2 = r2.b((java.lang.Object) r3)     // Catch:{ all -> 0x00f0 }
            com.instabug.library.Feature$State r3 = com.instabug.library.Feature.State.ENABLED     // Catch:{ all -> 0x00f0 }
            if (r2 != r3) goto L_0x00ee
            r2 = 1143930880(0x442f0000, float:700.0)
            float r9 = r9 * r2
            int r9 = java.lang.Math.round(r9)     // Catch:{ all -> 0x00f0 }
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x00ec }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ec }
            r3.<init>()     // Catch:{ Exception -> 0x00ec }
            java.lang.String r4 = "logcat -v time -d -t "
            r3.append(r4)     // Catch:{ Exception -> 0x00ec }
            r3.append(r9)     // Catch:{ Exception -> 0x00ec }
            int r4 = android.os.Process.myPid()     // Catch:{ Exception -> 0x00ec }
            r3.append(r4)     // Catch:{ Exception -> 0x00ec }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00ec }
            java.lang.Process r2 = r2.exec(r3)     // Catch:{ Exception -> 0x00ec }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ all -> 0x00f0 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ all -> 0x00f0 }
            java.io.InputStream r5 = r2.getInputStream()     // Catch:{ all -> 0x00f0 }
            java.lang.String r6 = "UTF-8"
            java.nio.charset.Charset r6 = java.nio.charset.Charset.forName(r6)     // Catch:{ all -> 0x00f0 }
            r4.<init>(r5, r6)     // Catch:{ all -> 0x00f0 }
            r3.<init>(r4)     // Catch:{ all -> 0x00f0 }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x00c3 }
            r4.<init>()     // Catch:{ Exception -> 0x00c3 }
        L_0x0056:
            java.lang.String r5 = r3.readLine()     // Catch:{ Exception -> 0x00c3 }
            if (r5 == 0) goto L_0x0060
            r4.add(r5)     // Catch:{ Exception -> 0x00c3 }
            goto L_0x0056
        L_0x0060:
            r3.close()     // Catch:{ Exception -> 0x00c3 }
            r4.trimToSize()     // Catch:{ Exception -> 0x00c3 }
            int r5 = r4.size()     // Catch:{ Exception -> 0x00c3 }
            r6 = 0
            if (r5 <= r9) goto L_0x0073
            int r5 = r4.size()     // Catch:{ Exception -> 0x00c3 }
            int r5 = r5 - r9
            goto L_0x0074
        L_0x0073:
            r5 = r6
        L_0x0074:
            int r9 = r4.size()     // Catch:{ Exception -> 0x00c3 }
            if (r5 >= r9) goto L_0x00ad
            java.lang.Object r9 = r4.get(r5)     // Catch:{ Exception -> 0x00c3 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x00c3 }
            int r9 = r9.length()     // Catch:{ Exception -> 0x00c3 }
            r7 = 18
            if (r9 <= r7) goto L_0x00aa
            com.instabug.library.model.a r9 = new com.instabug.library.model.a     // Catch:{ Exception -> 0x00c3 }
            r9.<init>()     // Catch:{ Exception -> 0x00c3 }
            java.lang.Object r8 = r4.get(r5)     // Catch:{ Exception -> 0x00c3 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x00c3 }
            java.lang.String r8 = r8.substring(r7)     // Catch:{ Exception -> 0x00c3 }
            r9.c(r8)     // Catch:{ Exception -> 0x00c3 }
            java.lang.Object r8 = r4.get(r5)     // Catch:{ Exception -> 0x00c3 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x00c3 }
            java.lang.String r7 = r8.substring(r6, r7)     // Catch:{ Exception -> 0x00c3 }
            r9.b(r7)     // Catch:{ Exception -> 0x00c3 }
            r1.add(r9)     // Catch:{ Exception -> 0x00c3 }
        L_0x00aa:
            int r5 = r5 + 1
            goto L_0x0074
        L_0x00ad:
            r4.clear()     // Catch:{ Exception -> 0x00c3 }
            r2.destroy()     // Catch:{ all -> 0x00f0 }
            r3.close()     // Catch:{ IOException -> 0x00b7 }
            goto L_0x00bf
        L_0x00b7:
            r9 = move-exception
            java.lang.String r2 = "IBG-Core"
            java.lang.String r3 = "Failed to close file reader"
            com.instabug.library.util.InstabugSDKLogger.e(r2, r3, r9)     // Catch:{ all -> 0x00f0 }
        L_0x00bf:
            monitor-exit(r0)
            return r1
        L_0x00c1:
            r9 = move-exception
            goto L_0x00dc
        L_0x00c3:
            r9 = move-exception
            java.lang.String r4 = "IBG-Core"
            java.lang.String r5 = "Could not read logcat log"
            com.instabug.library.util.InstabugSDKLogger.e(r4, r5, r9)     // Catch:{ all -> 0x00c1 }
            r2.destroy()     // Catch:{ all -> 0x00f0 }
            r3.close()     // Catch:{ IOException -> 0x00d2 }
            goto L_0x00da
        L_0x00d2:
            r9 = move-exception
            java.lang.String r2 = "IBG-Core"
            java.lang.String r3 = "Failed to close file reader"
            com.instabug.library.util.InstabugSDKLogger.e(r2, r3, r9)     // Catch:{ all -> 0x00f0 }
        L_0x00da:
            monitor-exit(r0)
            return r1
        L_0x00dc:
            r2.destroy()     // Catch:{ all -> 0x00f0 }
            r3.close()     // Catch:{ IOException -> 0x00e3 }
            goto L_0x00eb
        L_0x00e3:
            r1 = move-exception
            java.lang.String r2 = "IBG-Core"
            java.lang.String r3 = "Failed to close file reader"
            com.instabug.library.util.InstabugSDKLogger.e(r2, r3, r1)     // Catch:{ all -> 0x00f0 }
        L_0x00eb:
            throw r9     // Catch:{ all -> 0x00f0 }
        L_0x00ec:
            monitor-exit(r0)
            return r1
        L_0x00ee:
            monitor-exit(r0)
            return r1
        L_0x00f0:
            r9 = move-exception
            monitor-exit(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.model.a.a(float):java.util.ArrayList");
    }
}
