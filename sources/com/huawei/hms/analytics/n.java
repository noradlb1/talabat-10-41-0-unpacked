package com.huawei.hms.analytics;

import android.os.Bundle;
import com.huawei.hms.analytics.bcd;
import com.huawei.hms.analytics.framework.config.IConfig;
import com.huawei.hms.analytics.type.HAParamType;

public final class n extends bcd.lmn {
    private bl klm;
    IConfig lmn;

    public n(bl blVar) {
        this.klm = blVar;
    }

    private static Bundle lmn(Bundle bundle) {
        String str;
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String next : bundle.keySet()) {
                if ("$HA_METHOD".equals(next)) {
                    str = HAParamType.CHANNEL;
                } else if ("$HA_RESULT".equals(next)) {
                    str = HAParamType.EVTRESULT;
                }
                bundle2.putString(str, bundle.getString(next));
            }
        }
        return bundle2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a7 A[Catch:{ RuntimeException -> 0x00d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ad A[Catch:{ RuntimeException -> 0x00d0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int lmn(java.util.List<com.huawei.hms.analytics.CustomEvent> r14) {
        /*
            r13 = this;
            java.lang.String r0 = "$HA_LOGIN"
            com.huawei.hms.analytics.av r1 = com.huawei.hms.analytics.av.lmn()
            com.huawei.hms.analytics.ax r1 = r1.lmn
            boolean r1 = r1.fgh
            r2 = -1
            java.lang.String r3 = "ServiceRingback"
            if (r1 != 0) goto L_0x0015
            java.lang.String r14 = "isAnalyticsEnabled is false"
            com.huawei.hms.analytics.core.log.HiLog.w(r3, r14)
            return r2
        L_0x0015:
            boolean r1 = com.huawei.hms.analytics.be.lmn()
            if (r1 != 0) goto L_0x0025
            com.huawei.hms.analytics.framework.config.IConfig r1 = r13.lmn
            if (r1 != 0) goto L_0x0025
            java.lang.String r14 = "opennessInitComplete is false"
            com.huawei.hms.analytics.core.log.HiLog.w(r3, r14)
            return r2
        L_0x0025:
            java.lang.String r1 = "ServiceCallback#handleCustomEvent(List<CustomEvent>)"
            com.huawei.hms.analytics.cj r4 = com.huawei.hms.analytics.ck.lmn((java.lang.String) r1)
            r4.ikl = r1
            if (r14 == 0) goto L_0x00d9
            boolean r1 = r14.isEmpty()
            if (r1 != 0) goto L_0x00d9
            com.huawei.hms.analytics.bl r1 = r13.klm
            if (r1 != 0) goto L_0x003b
            goto L_0x00d9
        L_0x003b:
            java.lang.String r1 = "events got"
            com.huawei.hms.analytics.core.log.HiLog.i(r3, r1)
            com.huawei.hms.analytics.framework.config.IConfig r1 = r13.lmn     // Catch:{ RuntimeException -> 0x00d0 }
            r5 = 0
            if (r1 != 0) goto L_0x0047
            r1 = 1
            goto L_0x0048
        L_0x0047:
            r1 = r5
        L_0x0048:
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ RuntimeException -> 0x00d0 }
            r6.<init>()     // Catch:{ RuntimeException -> 0x00d0 }
            java.util.Iterator r14 = r14.iterator()     // Catch:{ RuntimeException -> 0x00d0 }
        L_0x0051:
            boolean r7 = r14.hasNext()     // Catch:{ RuntimeException -> 0x00d0 }
            r8 = 0
            if (r7 == 0) goto L_0x00bd
            java.lang.Object r7 = r14.next()     // Catch:{ RuntimeException -> 0x00d0 }
            com.huawei.hms.analytics.CustomEvent r7 = (com.huawei.hms.analytics.CustomEvent) r7     // Catch:{ RuntimeException -> 0x00d0 }
            java.lang.String r9 = r7.lmn     // Catch:{ RuntimeException -> 0x00d0 }
            com.huawei.hms.analytics.av r10 = com.huawei.hms.analytics.av.lmn()     // Catch:{ RuntimeException -> 0x00d0 }
            com.huawei.hms.analytics.ax r10 = r10.lmn     // Catch:{ RuntimeException -> 0x00d0 }
            android.content.Context r10 = r10.ghi     // Catch:{ RuntimeException -> 0x00d0 }
            java.lang.String r10 = r10.getPackageName()     // Catch:{ RuntimeException -> 0x00d0 }
            boolean r9 = r9.equals(r10)     // Catch:{ RuntimeException -> 0x00d0 }
            if (r9 == 0) goto L_0x0051
            java.lang.String r9 = r7.klm     // Catch:{ RuntimeException -> 0x00d0 }
            android.os.Bundle r7 = r7.ikl     // Catch:{ RuntimeException -> 0x00d0 }
            boolean r10 = r0.equals(r9)     // Catch:{ RuntimeException -> 0x00d0 }
            java.lang.String r11 = "$HA_LOGOUT"
            if (r10 != 0) goto L_0x0087
            boolean r10 = r11.equals(r9)     // Catch:{ RuntimeException -> 0x00d0 }
            if (r10 == 0) goto L_0x0085
            goto L_0x0087
        L_0x0085:
            r8 = r9
            goto L_0x009c
        L_0x0087:
            boolean r10 = r0.equals(r9)     // Catch:{ RuntimeException -> 0x00d0 }
            if (r10 == 0) goto L_0x0090
            java.lang.String r8 = "$SignIn"
            goto L_0x0098
        L_0x0090:
            boolean r10 = r11.equals(r9)     // Catch:{ RuntimeException -> 0x00d0 }
            if (r10 == 0) goto L_0x0098
            java.lang.String r8 = "$SignOut"
        L_0x0098:
            android.os.Bundle r7 = lmn((android.os.Bundle) r7)     // Catch:{ RuntimeException -> 0x00d0 }
        L_0x009c:
            com.huawei.hms.analytics.dt r10 = new com.huawei.hms.analytics.dt     // Catch:{ RuntimeException -> 0x00d0 }
            r10.<init>((java.lang.String) r8, (boolean) r5)     // Catch:{ RuntimeException -> 0x00d0 }
            boolean r7 = r10.lmn((android.os.Bundle) r7)     // Catch:{ RuntimeException -> 0x00d0 }
            if (r7 != 0) goto L_0x00ad
            java.lang.String r7 = "bundle params is invalid."
            com.huawei.hms.analytics.core.log.HiLog.w(r3, r7)     // Catch:{ RuntimeException -> 0x00d0 }
            goto L_0x0051
        L_0x00ad:
            if (r1 == 0) goto L_0x00b9
            com.huawei.hms.analytics.bl r7 = r13.klm     // Catch:{ RuntimeException -> 0x00d0 }
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ RuntimeException -> 0x00d0 }
            r7.lmn((java.lang.String) r8, (com.huawei.hms.analytics.dt) r10, (long) r11)     // Catch:{ RuntimeException -> 0x00d0 }
            goto L_0x0051
        L_0x00b9:
            r6.put(r9, r10)     // Catch:{ RuntimeException -> 0x00d0 }
            goto L_0x0051
        L_0x00bd:
            if (r1 != 0) goto L_0x00c8
            com.huawei.hms.analytics.bl r14 = r13.klm     // Catch:{ RuntimeException -> 0x00d0 }
            com.huawei.hms.analytics.framework.config.IConfig r0 = r13.lmn     // Catch:{ RuntimeException -> 0x00d0 }
            r14.lmn((com.huawei.hms.analytics.framework.config.IConfig) r0, (java.util.Map<java.lang.String, com.huawei.hms.analytics.dt>) r6)     // Catch:{ RuntimeException -> 0x00d0 }
            r13.lmn = r8     // Catch:{ RuntimeException -> 0x00d0 }
        L_0x00c8:
            java.lang.String r14 = "0"
            r4.lmn = r14
            com.huawei.hms.analytics.ck.lmn((com.huawei.hms.analytics.cj) r4)
            return r5
        L_0x00d0:
            java.lang.String r14 = "handleCustomEvent RuntimeException"
            com.huawei.hms.analytics.core.log.HiLog.w(r3, r14)
            com.huawei.hms.analytics.ck.lmn((com.huawei.hms.analytics.cj) r4)
            return r2
        L_0x00d9:
            java.lang.String r14 = "events empty"
            com.huawei.hms.analytics.core.log.HiLog.w(r3, r14)
            com.huawei.hms.analytics.ck.lmn((com.huawei.hms.analytics.cj) r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.analytics.n.lmn(java.util.List):int");
    }
}
