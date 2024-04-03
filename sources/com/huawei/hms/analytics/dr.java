package com.huawei.hms.analytics;

import android.content.Context;
import android.os.Build;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.huawei.wearengine.common.Constants;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

@Instrumented
public final class dr {
    private static Context klm;
    private static final Set<String> lmn = new HashSet();

    private static String lmn() {
        String str;
        ax axVar = av.lmn().lmn;
        JSONObject jSONObject = new JSONObject();
        bc bcVar = axVar.f47867n;
        if (bcVar == null || (str = bcVar.klm) == null) {
            str = "";
        }
        try {
            jSONObject.put("app_id", (Object) str);
            jSONObject.put("lib_ver", (Object) "6.9.0.302");
            String str2 = axVar.klm;
            if (str2 == null) {
                str2 = dp.hij(klm);
            }
            jSONObject.put("app_ver", (Object) str2);
            Context context = klm;
            jSONObject.put(Constants.PACKAGE_NAME, (Object) context == null ? "" : context.getPackageName());
            jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, (Object) Build.MODEL);
            jSONObject.put("manufacturer", (Object) Build.MANUFACTURER);
            jSONObject.put("lib_type", (Object) "android");
            jSONObject.put("os", (Object) "android");
            jSONObject.put("os_ver", (Object) dp.ijk());
            return JSONObjectInstrumentation.toString(jSONObject);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void lmn(Context context, Throwable th2) {
        klm = context;
        lmn(th2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0042 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0044 A[SYNTHETIC, Splitter:B:28:0x0044] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00d6 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00d8 A[SYNTHETIC, Splitter:B:55:0x00d8] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void lmn(java.lang.Throwable r9) {
        /*
            java.lang.Class<com.huawei.hms.analytics.dr> r0 = com.huawei.hms.analytics.dr.class
            monitor-enter(r0)
            if (r9 != 0) goto L_0x0007
            monitor-exit(r0)
            return
        L_0x0007:
            android.content.Context r1 = klm     // Catch:{ all -> 0x0100 }
            if (r1 != 0) goto L_0x0015
            com.huawei.hms.analytics.av r1 = com.huawei.hms.analytics.av.lmn()     // Catch:{ all -> 0x0100 }
            com.huawei.hms.analytics.ax r1 = r1.lmn     // Catch:{ all -> 0x0100 }
            android.content.Context r1 = r1.ghi     // Catch:{ all -> 0x0100 }
            klm = r1     // Catch:{ all -> 0x0100 }
        L_0x0015:
            boolean r1 = r9 instanceof android.database.sqlite.SQLiteBlobTooBigException     // Catch:{ all -> 0x0100 }
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L_0x0027
            boolean r1 = r9 instanceof android.database.sqlite.SQLiteFullException     // Catch:{ all -> 0x0100 }
            if (r1 != 0) goto L_0x0027
            boolean r1 = r9 instanceof java.lang.NoClassDefFoundError     // Catch:{ all -> 0x0100 }
            if (r1 != 0) goto L_0x0027
            boolean r1 = r9 instanceof java.lang.NoSuchMethodError     // Catch:{ all -> 0x0100 }
            if (r1 == 0) goto L_0x003d
        L_0x0027:
            java.lang.String r1 = r9.getMessage()     // Catch:{ all -> 0x0100 }
            boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0100 }
            if (r4 != 0) goto L_0x003f
            java.util.Set<java.lang.String> r4 = lmn     // Catch:{ all -> 0x0100 }
            boolean r5 = r4.contains(r1)     // Catch:{ all -> 0x0100 }
            if (r5 == 0) goto L_0x003a
            goto L_0x003f
        L_0x003a:
            r4.add(r1)     // Catch:{ all -> 0x0100 }
        L_0x003d:
            r1 = r2
            goto L_0x0040
        L_0x003f:
            r1 = r3
        L_0x0040:
            if (r1 == 0) goto L_0x0044
            monitor-exit(r0)
            return
        L_0x0044:
            android.content.Context r1 = klm     // Catch:{ all -> 0x0100 }
            java.lang.String r4 = "global_v2"
            java.lang.String r5 = "is_analytics_enabled"
            boolean r1 = com.huawei.hms.analytics.dv.klm((android.content.Context) r1, (java.lang.String) r4, (java.lang.String) r5, (boolean) r3)     // Catch:{ all -> 0x0100 }
            if (r1 != 0) goto L_0x0052
            monitor-exit(r0)
            return
        L_0x0052:
            java.lang.Class r1 = r9.getClass()     // Catch:{ all -> 0x0100 }
            java.lang.String r1 = r1.getName()     // Catch:{ all -> 0x0100 }
            java.lang.String r3 = r9.getMessage()     // Catch:{ all -> 0x0100 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0100 }
            r4.<init>()     // Catch:{ all -> 0x0100 }
            java.lang.Throwable r5 = r9.getCause()     // Catch:{ all -> 0x0100 }
            if (r5 == 0) goto L_0x006e
            java.lang.StackTraceElement[] r9 = r5.getStackTrace()     // Catch:{ all -> 0x0100 }
            goto L_0x0072
        L_0x006e:
            java.lang.StackTraceElement[] r9 = r9.getStackTrace()     // Catch:{ all -> 0x0100 }
        L_0x0072:
            int r5 = r9.length     // Catch:{ all -> 0x0100 }
        L_0x0073:
            if (r2 >= r5) goto L_0x0097
            r6 = r9[r2]     // Catch:{ all -> 0x0100 }
            int r7 = r4.length()     // Catch:{ all -> 0x0100 }
            r8 = 204800(0x32000, float:2.86986E-40)
            if (r7 >= r8) goto L_0x0097
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0100 }
            java.lang.String r6 = r6.trim()     // Catch:{ all -> 0x0100 }
            r4.append(r6)     // Catch:{ all -> 0x0100 }
            java.lang.String r6 = "line.separator"
            java.lang.String r6 = java.lang.System.getProperty(r6)     // Catch:{ all -> 0x0100 }
            r4.append(r6)     // Catch:{ all -> 0x0100 }
            int r2 = r2 + 1
            goto L_0x0073
        L_0x0097:
            java.lang.String r9 = r4.toString()     // Catch:{ all -> 0x0100 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0100 }
            if (r2 != 0) goto L_0x00d3
            boolean r2 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0100 }
            if (r2 != 0) goto L_0x00d3
            boolean r2 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0100 }
            if (r2 == 0) goto L_0x00ae
            goto L_0x00d3
        L_0x00ae:
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap     // Catch:{ all -> 0x0100 }
            r2.<init>()     // Catch:{ all -> 0x0100 }
            java.lang.String r4 = "service"
            java.lang.String r5 = "AnalyticsKit"
            r2.put(r4, r5)     // Catch:{ all -> 0x0100 }
            java.lang.String r4 = "exception_type"
            r2.put(r4, r1)     // Catch:{ all -> 0x0100 }
            java.lang.String r1 = "exception_message"
            r2.put(r1, r3)     // Catch:{ all -> 0x0100 }
            java.lang.String r1 = "exception_stack"
            r2.put(r1, r9)     // Catch:{ all -> 0x0100 }
            java.lang.String r9 = "common_prop"
            java.lang.String r1 = lmn()     // Catch:{ all -> 0x0100 }
            r2.put(r9, r1)     // Catch:{ all -> 0x0100 }
            goto L_0x00d4
        L_0x00d3:
            r2 = 0
        L_0x00d4:
            if (r2 != 0) goto L_0x00d8
            monitor-exit(r0)
            return
        L_0x00d8:
            android.content.Context r9 = klm     // Catch:{ all -> 0x0100 }
            com.huawei.hms.utils.HMSBIInitializer r9 = com.huawei.hms.utils.HMSBIInitializer.getInstance(r9)     // Catch:{ all -> 0x0100 }
            boolean r9 = r9.isInit()     // Catch:{ all -> 0x0100 }
            if (r9 != 0) goto L_0x00ed
            android.content.Context r9 = klm     // Catch:{ all -> 0x0100 }
            com.huawei.hms.utils.HMSBIInitializer r9 = com.huawei.hms.utils.HMSBIInitializer.getInstance(r9)     // Catch:{ all -> 0x0100 }
            r9.initBI()     // Catch:{ all -> 0x0100 }
        L_0x00ed:
            com.huawei.hms.support.hianalytics.HiAnalyticsUtil r9 = com.huawei.hms.support.hianalytics.HiAnalyticsUtil.getInstance()     // Catch:{ all -> 0x0100 }
            com.huawei.hms.analytics.av r1 = com.huawei.hms.analytics.av.lmn()     // Catch:{ all -> 0x0100 }
            com.huawei.hms.analytics.ax r1 = r1.lmn     // Catch:{ all -> 0x0100 }
            android.content.Context r1 = r1.ghi     // Catch:{ all -> 0x0100 }
            java.lang.String r3 = "$HAExceptionEvent"
            r9.onNewEvent(r1, r3, r2)     // Catch:{ all -> 0x0100 }
            monitor-exit(r0)
            return
        L_0x0100:
            r9 = move-exception
            monitor-exit(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.analytics.dr.lmn(java.lang.Throwable):void");
    }
}
