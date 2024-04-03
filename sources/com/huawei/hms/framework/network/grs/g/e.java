package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.framework.common.hianalytics.LinkedHashMapPack;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.json.JSONArray;

public class e {

    @Instrumented
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f48911a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f48912b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ JSONArray f48913c;

        public a(long j11, ArrayList arrayList, JSONArray jSONArray) {
            this.f48911a = j11;
            this.f48912b = arrayList;
            this.f48913c = jSONArray;
        }

        /* JADX WARNING: Removed duplicated region for block: B:29:0x0038 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:3:0x001a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
                com.huawei.hms.framework.network.grs.g.j.a r0 = new com.huawei.hms.framework.network.grs.g.j.a
                r0.<init>()
                long r1 = r6.f48911a
                java.lang.String r3 = "total_time"
                r0.put((java.lang.String) r3, (long) r1)
                java.util.ArrayList r1 = r6.f48912b
                java.util.Iterator r1 = r1.iterator()
            L_0x0012:
                boolean r2 = r1.hasNext()
                r3 = 1
                r4 = 0
                if (r2 == 0) goto L_0x0038
                java.lang.Object r2 = r1.next()
                com.huawei.hms.framework.network.grs.g.d r2 = (com.huawei.hms.framework.network.grs.g.d) r2
                boolean r5 = r2.o()
                if (r5 != 0) goto L_0x002c
                boolean r5 = r2.m()
                if (r5 == 0) goto L_0x0012
            L_0x002c:
                java.util.LinkedHashMap r2 = com.huawei.hms.framework.network.grs.g.e.b(r2)
                r0.put(r2)
                r1.remove()
                r1 = r3
                goto L_0x0039
            L_0x0038:
                r1 = r4
            L_0x0039:
                if (r1 != 0) goto L_0x005c
                java.util.ArrayList r1 = r6.f48912b
                int r1 = r1.size()
                if (r1 <= 0) goto L_0x005c
                java.util.ArrayList r1 = r6.f48912b
                int r2 = r1.size()
                int r2 = r2 - r3
                java.lang.Object r1 = r1.get(r2)
                com.huawei.hms.framework.network.grs.g.d r1 = (com.huawei.hms.framework.network.grs.g.d) r1
                java.util.LinkedHashMap r2 = com.huawei.hms.framework.network.grs.g.e.b(r1)
                r0.put(r2)
                java.util.ArrayList r2 = r6.f48912b
                r2.remove(r1)
            L_0x005c:
                java.util.ArrayList r1 = r6.f48912b
                int r1 = r1.size()
                if (r1 <= 0) goto L_0x0085
                java.util.ArrayList r1 = r6.f48912b
                java.util.Iterator r1 = r1.iterator()
            L_0x006a:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L_0x0085
                java.lang.Object r2 = r1.next()
                com.huawei.hms.framework.network.grs.g.d r2 = (com.huawei.hms.framework.network.grs.g.d) r2
                org.json.JSONObject r5 = new org.json.JSONObject
                java.util.LinkedHashMap r2 = com.huawei.hms.framework.network.grs.g.e.b(r2)
                r5.<init>((java.util.Map<?, ?>) r2)
                org.json.JSONArray r2 = r6.f48913c
                r2.put((java.lang.Object) r5)
                goto L_0x006a
            L_0x0085:
                org.json.JSONArray r1 = r6.f48913c
                int r1 = r1.length()
                if (r1 <= 0) goto L_0x00a1
                org.json.JSONArray r1 = r6.f48913c
                boolean r2 = r1 instanceof org.json.JSONArray
                if (r2 != 0) goto L_0x0098
                java.lang.String r1 = r1.toString()
                goto L_0x009c
            L_0x0098:
                java.lang.String r1 = com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation.toString(r1)
            L_0x009c:
                java.lang.String r2 = "failed_info"
                r0.put((java.lang.String) r2, (java.lang.String) r1)
            L_0x00a1:
                java.lang.Object[] r1 = new java.lang.Object[r3]
                org.json.JSONObject r2 = new org.json.JSONObject
                java.util.LinkedHashMap r3 = r0.get()
                r2.<init>((java.util.Map<?, ?>) r3)
                r1[r4] = r2
                java.lang.String r2 = "HaReportHelper"
                java.lang.String r3 = "grssdk report data to aiops is: %s"
                com.huawei.hms.framework.common.Logger.d(r2, r3, r1)
                com.huawei.hms.framework.common.hianalytics.HianalyticsHelper r1 = com.huawei.hms.framework.common.hianalytics.HianalyticsHelper.getInstance()
                java.util.LinkedHashMap r0 = r0.get()
                java.lang.String r2 = "grs_request"
                r1.onEvent(r0, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.g.e.a.run():void");
        }
    }

    public static void a(ArrayList<d> arrayList, long j11, JSONArray jSONArray, Context context) {
        if (context != null && arrayList != null && arrayList.size() > 0 && HianalyticsHelper.getInstance().isEnableReport(context)) {
            HianalyticsHelper.getInstance().getReportExecutor().submit(new a(j11, arrayList, jSONArray));
        }
    }

    /* access modifiers changed from: private */
    public static LinkedHashMap<String, String> b(d dVar) {
        LinkedHashMapPack linkedHashMapPack = new LinkedHashMapPack();
        Exception d11 = dVar.d();
        if (d11 != null) {
            linkedHashMapPack.put("error_code", (long) ExceptionCode.getErrorCodeFromException(d11));
            linkedHashMapPack.put(CrashHianalyticsData.EXCEPTION_NAME, d11.getClass().getSimpleName());
            linkedHashMapPack.put("message", StringUtils.anonymizeMessage(d11.getMessage()));
        } else {
            linkedHashMapPack.put("error_code", (long) dVar.b());
            linkedHashMapPack.put(CrashHianalyticsData.EXCEPTION_NAME, (long) dVar.c());
        }
        try {
            linkedHashMapPack.put("domain", new URL(dVar.l()).getHost());
        } catch (MalformedURLException e11) {
            Logger.w("HaReportHelper", "report host MalformedURLException", (Throwable) e11);
        }
        linkedHashMapPack.put("req_start_time", dVar.h());
        linkedHashMapPack.put("req_end_time", dVar.g());
        linkedHashMapPack.put("req_total_time", dVar.i());
        return linkedHashMapPack.getAll();
    }
}
