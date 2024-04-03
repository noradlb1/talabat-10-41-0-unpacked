package com.huawei.hms.analytics;

import android.content.Context;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.internal.filter.EventFilter;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class bn {
    private static bq ijk = new bq();
    private static bo ikl = new EventFilter();
    /* access modifiers changed from: private */
    public static Context klm;
    private static bn lmn;

    public static class lmn implements bp {
        private lmn() {
        }

        public /* synthetic */ lmn(byte b11) {
            this();
        }

        private static boolean lmn() {
            return dv.klm(bn.klm, "global_v2", "is_analytics_enabled", true);
        }

        public final void klm(final String str, final String str2, final List<JSONObject> list) {
            if (!lmn()) {
                HiLog.w("ThirdRingback", HiLog.ErrorCode.IE006, "The Analytics Kit is disabled");
            } else {
                dg.lmn().lmn(new Runnable() {
                    public final void run() {
                        bl lmn2;
                        if (be.lmn() && (lmn2 = cde.lmn().lmn(str)) != null) {
                            lmn2.lmn((List<JSONObject>) list);
                        }
                    }
                });
            }
        }

        public final String lmn(String str) {
            if (!dl.lmn(str)) {
                return null;
            }
            Map<String, Object> lmn = av.lmn().klm().lmn();
            return lmn.containsKey(str) ? String.valueOf(lmn.get(str)) : "";
        }

        public final void lmn(final String str, final String str2, final List<JSONObject> list) {
            if (!lmn()) {
                HiLog.w("ThirdRingback", HiLog.ErrorCode.IE006, "The Analytics Kit is disabled");
            } else {
                dg.lmn().lmn(new Runnable() {
                    public final void run() {
                        bl lmn2;
                        if (be.lmn() && (lmn2 = cde.lmn().lmn(str)) != null) {
                            lmn2.lmn(str2, (List<JSONObject>) list);
                        }
                    }
                });
            }
        }
    }

    private bn() {
    }

    public static bq klm() {
        return ijk;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void klm(android.content.Context r13) {
        /*
            java.lang.Class<com.huawei.hms.analytics.bn> r0 = com.huawei.hms.analytics.bn.class
            monitor-enter(r0)
            com.huawei.hms.analytics.bn r1 = lmn     // Catch:{ all -> 0x008c }
            if (r1 != 0) goto L_0x008a
            com.huawei.hms.analytics.bn r1 = new com.huawei.hms.analytics.bn     // Catch:{ all -> 0x008c }
            r1.<init>()     // Catch:{ all -> 0x008c }
            lmn = r1     // Catch:{ all -> 0x008c }
            if (r13 != 0) goto L_0x0012
            monitor-exit(r0)
            return
        L_0x0012:
            klm = r13     // Catch:{ all -> 0x008c }
            com.huawei.hms.analytics.bo r1 = ikl     // Catch:{ all -> 0x008c }
            r1.lmn((android.content.Context) r13)     // Catch:{ all -> 0x008c }
            com.huawei.hms.analytics.bo r1 = ikl     // Catch:{ all -> 0x008c }
            com.huawei.hms.analytics.bn$lmn r2 = new com.huawei.hms.analytics.bn$lmn     // Catch:{ all -> 0x008c }
            r3 = 0
            r2.<init>(r3)     // Catch:{ all -> 0x008c }
            r1.lmn((com.huawei.hms.analytics.bp) r2)     // Catch:{ all -> 0x008c }
            com.huawei.hms.analytics.bq r1 = ijk     // Catch:{ all -> 0x008c }
            java.lang.String[] r2 = com.huawei.hms.analytics.bq.lmn     // Catch:{ all -> 0x008c }
            int r4 = r2.length     // Catch:{ all -> 0x008c }
            r5 = r3
        L_0x002a:
            if (r5 >= r4) goto L_0x008a
            r6 = r2[r5]     // Catch:{ all -> 0x008c }
            java.lang.Class r7 = java.lang.Class.forName(r6)     // Catch:{ ClassNotFoundException -> 0x0082, IllegalAccessException -> 0x007d, InstantiationException -> 0x0078, NoSuchMethodException -> 0x0073, InvocationTargetException -> 0x006b }
            java.lang.Object r8 = r7.newInstance()     // Catch:{ ClassNotFoundException -> 0x0082, IllegalAccessException -> 0x007d, InstantiationException -> 0x0078, NoSuchMethodException -> 0x0073, InvocationTargetException -> 0x006b }
            java.util.Map<java.lang.String, java.lang.Object> r9 = r1.ikl     // Catch:{ ClassNotFoundException -> 0x0082, IllegalAccessException -> 0x007d, InstantiationException -> 0x0078, NoSuchMethodException -> 0x0073, InvocationTargetException -> 0x006b }
            r9.put(r6, r8)     // Catch:{ ClassNotFoundException -> 0x0082, IllegalAccessException -> 0x007d, InstantiationException -> 0x0078, NoSuchMethodException -> 0x0073, InvocationTargetException -> 0x006b }
            java.lang.String r9 = "initialize"
            r10 = 1
            java.lang.Class[] r11 = new java.lang.Class[r10]     // Catch:{ ClassNotFoundException -> 0x0082, IllegalAccessException -> 0x007d, InstantiationException -> 0x0078, NoSuchMethodException -> 0x0073, InvocationTargetException -> 0x006b }
            java.lang.Class<android.content.Context> r12 = android.content.Context.class
            r11[r3] = r12     // Catch:{ ClassNotFoundException -> 0x0082, IllegalAccessException -> 0x007d, InstantiationException -> 0x0078, NoSuchMethodException -> 0x0073, InvocationTargetException -> 0x006b }
            java.lang.reflect.Method r9 = r7.getDeclaredMethod(r9, r11)     // Catch:{ ClassNotFoundException -> 0x0082, IllegalAccessException -> 0x007d, InstantiationException -> 0x0078, NoSuchMethodException -> 0x0073, InvocationTargetException -> 0x006b }
            java.lang.Object[] r11 = new java.lang.Object[r10]     // Catch:{ ClassNotFoundException -> 0x0082, IllegalAccessException -> 0x007d, InstantiationException -> 0x0078, NoSuchMethodException -> 0x0073, InvocationTargetException -> 0x006b }
            r11[r3] = r13     // Catch:{ ClassNotFoundException -> 0x0082, IllegalAccessException -> 0x007d, InstantiationException -> 0x0078, NoSuchMethodException -> 0x0073, InvocationTargetException -> 0x006b }
            r9.invoke(r8, r11)     // Catch:{ ClassNotFoundException -> 0x0082, IllegalAccessException -> 0x007d, InstantiationException -> 0x0078, NoSuchMethodException -> 0x0073, InvocationTargetException -> 0x006b }
            java.lang.String r8 = "onEvent"
            r9 = 3
            java.lang.Class[] r9 = new java.lang.Class[r9]     // Catch:{ ClassNotFoundException -> 0x0082, IllegalAccessException -> 0x007d, InstantiationException -> 0x0078, NoSuchMethodException -> 0x0073, InvocationTargetException -> 0x006b }
            java.lang.Class<java.lang.String> r11 = java.lang.String.class
            r9[r3] = r11     // Catch:{ ClassNotFoundException -> 0x0082, IllegalAccessException -> 0x007d, InstantiationException -> 0x0078, NoSuchMethodException -> 0x0073, InvocationTargetException -> 0x006b }
            java.lang.Class<android.os.Bundle> r11 = android.os.Bundle.class
            r9[r10] = r11     // Catch:{ ClassNotFoundException -> 0x0082, IllegalAccessException -> 0x007d, InstantiationException -> 0x0078, NoSuchMethodException -> 0x0073, InvocationTargetException -> 0x006b }
            java.lang.Class<android.os.Bundle> r10 = android.os.Bundle.class
            r11 = 2
            r9[r11] = r10     // Catch:{ ClassNotFoundException -> 0x0082, IllegalAccessException -> 0x007d, InstantiationException -> 0x0078, NoSuchMethodException -> 0x0073, InvocationTargetException -> 0x006b }
            java.lang.reflect.Method r7 = r7.getDeclaredMethod(r8, r9)     // Catch:{ ClassNotFoundException -> 0x0082, IllegalAccessException -> 0x007d, InstantiationException -> 0x0078, NoSuchMethodException -> 0x0073, InvocationTargetException -> 0x006b }
            java.util.Map<java.lang.String, java.lang.reflect.Method> r8 = r1.klm     // Catch:{ ClassNotFoundException -> 0x0082, IllegalAccessException -> 0x007d, InstantiationException -> 0x0078, NoSuchMethodException -> 0x0073, InvocationTargetException -> 0x006b }
            r8.put(r6, r7)     // Catch:{ ClassNotFoundException -> 0x0082, IllegalAccessException -> 0x007d, InstantiationException -> 0x0078, NoSuchMethodException -> 0x0073, InvocationTargetException -> 0x006b }
            goto L_0x0087
        L_0x006b:
            java.lang.String r6 = "IncidentAdapter"
            java.lang.String r7 = "Invocation target warning"
        L_0x006f:
            com.huawei.hms.analytics.core.log.HiLog.w(r6, r7)     // Catch:{ all -> 0x008c }
            goto L_0x0087
        L_0x0073:
            java.lang.String r6 = "IncidentAdapter"
            java.lang.String r7 = "No such method warning"
            goto L_0x006f
        L_0x0078:
            java.lang.String r6 = "IncidentAdapter"
            java.lang.String r7 = "Instantiation warning"
            goto L_0x006f
        L_0x007d:
            java.lang.String r6 = "IncidentAdapter"
            java.lang.String r7 = "Illegal access warning"
            goto L_0x006f
        L_0x0082:
            java.lang.String r6 = "IncidentAdapter"
            java.lang.String r7 = "Class not found warning"
            goto L_0x006f
        L_0x0087:
            int r5 = r5 + 1
            goto L_0x002a
        L_0x008a:
            monitor-exit(r0)
            return
        L_0x008c:
            r13 = move-exception
            monitor-exit(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.analytics.bn.klm(android.content.Context):void");
    }

    public static bn lmn(Context context) {
        if (lmn == null) {
            klm(context);
        }
        return lmn;
    }

    public static bo lmn() {
        return ikl;
    }
}
