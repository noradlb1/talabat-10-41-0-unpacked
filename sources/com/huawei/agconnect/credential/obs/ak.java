package com.huawei.agconnect.credential.obs;

import java.util.HashMap;
import java.util.Map;

public final class ak {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, aj> f47566a = new HashMap();

    /* JADX WARNING: Removed duplicated region for block: B:23:0x004f A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0052 A[SYNTHETIC, Splitter:B:25:0x0052] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.huawei.agconnect.credential.obs.ai a(android.content.Context r4, com.huawei.agconnect.credential.obs.al r5) {
        /*
            java.lang.Class<com.huawei.agconnect.credential.obs.ak> r0 = com.huawei.agconnect.credential.obs.ak.class
            monitor-enter(r0)
            android.os.Looper r1 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x007d }
            android.os.Looper r2 = android.os.Looper.myLooper()     // Catch:{ all -> 0x007d }
            r3 = 0
            if (r1 == r2) goto L_0x0016
            java.lang.String r1 = "HAInstanceManager"
            java.lang.String r2 = "init must be called in the main thread"
        L_0x0012:
            android.util.Log.e(r1, r2)     // Catch:{ all -> 0x007d }
            goto L_0x004d
        L_0x0016:
            if (r4 != 0) goto L_0x001d
            java.lang.String r1 = "HAInstanceManager"
            java.lang.String r2 = "context cannot be null to init HiAnalyticsInstanceEx."
            goto L_0x0012
        L_0x001d:
            java.lang.String r1 = r5.f47567a     // Catch:{ all -> 0x007d }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x007d }
            if (r1 != 0) goto L_0x0048
            java.lang.String r1 = r5.f47567a     // Catch:{ all -> 0x007d }
            int r1 = r1.length()     // Catch:{ all -> 0x007d }
            r2 = 256(0x100, float:3.59E-43)
            if (r1 <= r2) goto L_0x0030
            goto L_0x0048
        L_0x0030:
            java.lang.String r1 = r5.f47568b     // Catch:{ all -> 0x007d }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x007d }
            if (r1 != 0) goto L_0x0043
            java.lang.String r1 = r5.f47568b     // Catch:{ all -> 0x007d }
            int r1 = r1.length()     // Catch:{ all -> 0x007d }
            if (r1 <= r2) goto L_0x0041
            goto L_0x0043
        L_0x0041:
            r3 = 1
            goto L_0x004d
        L_0x0043:
            java.lang.String r1 = "HAInstanceManager"
            java.lang.String r2 = "httpheader check failed"
            goto L_0x0012
        L_0x0048:
            java.lang.String r1 = "HAInstanceManager"
            java.lang.String r2 = "serviceTag check failed"
            goto L_0x0012
        L_0x004d:
            if (r3 != 0) goto L_0x0052
            monitor-exit(r0)
            r4 = 0
            return r4
        L_0x0052:
            java.util.Map<java.lang.String, com.huawei.agconnect.credential.obs.aj> r1 = f47566a     // Catch:{ all -> 0x007d }
            java.lang.String r2 = r5.f47567a     // Catch:{ all -> 0x007d }
            java.lang.Object r2 = r1.get(r2)     // Catch:{ all -> 0x007d }
            com.huawei.agconnect.credential.obs.aj r2 = (com.huawei.agconnect.credential.obs.aj) r2     // Catch:{ all -> 0x007d }
            if (r2 != 0) goto L_0x006a
            com.huawei.agconnect.credential.obs.aj r2 = new com.huawei.agconnect.credential.obs.aj     // Catch:{ all -> 0x007d }
            r2.<init>(r4, r5)     // Catch:{ all -> 0x007d }
            java.lang.String r4 = r5.f47567a     // Catch:{ all -> 0x007d }
            r1.put(r4, r2)     // Catch:{ all -> 0x007d }
            monitor-exit(r0)
            return r2
        L_0x006a:
            java.lang.String r1 = r5.f47569c     // Catch:{ all -> 0x007d }
            com.huawei.agconnect.credential.obs.al r3 = r2.f47564a     // Catch:{ all -> 0x007d }
            java.lang.String r3 = r3.f47569c     // Catch:{ all -> 0x007d }
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x007d }
            if (r1 == 0) goto L_0x0078
            monitor-exit(r0)
            return r2
        L_0x0078:
            r2.a((android.content.Context) r4, (com.huawei.agconnect.credential.obs.al) r5)     // Catch:{ all -> 0x007d }
            monitor-exit(r0)
            return r2
        L_0x007d:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.agconnect.credential.obs.ak.a(android.content.Context, com.huawei.agconnect.credential.obs.al):com.huawei.agconnect.credential.obs.ai");
    }
}
