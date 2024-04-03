package com.huawei.hms.locationSdk;

import com.huawei.hms.location.LocationCallback;
import com.huawei.hms.support.api.location.common.CollectionsUtil;
import com.huawei.hms.support.log.HMSLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class d0 extends c0 {

    /* renamed from: c  reason: collision with root package name */
    private static volatile d0 f49160c;

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f49161d = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    private List<LocationCallback> f49162b = new ArrayList(10);

    public static d0 b() {
        if (f49160c == null) {
            synchronized (f49161d) {
                if (f49160c == null) {
                    f49160c = new d0();
                }
            }
        }
        return f49160c;
    }

    public void a(e0 e0Var, int i11) {
        if (e0Var == null || CollectionsUtil.isEmpty((Collection<?>) a())) {
            HMSLog.i("LocationRequestCacheManager", "updateCacheNumUpdates fail, cache or numUpdates is null");
            return;
        }
        for (int i12 = 0; i12 < a().size(); i12++) {
            e0 e0Var2 = a().get(i12) instanceof e0 ? (e0) a().get(i12) : null;
            if (e0Var2 != null && e0Var2.equals(e0Var)) {
                if (i11 > 0) {
                    e0Var2.d().setNumUpdates(i11);
                }
                e0Var2.a(i11);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0052, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.huawei.hms.location.LocationCallback r6) {
        /*
            r5 = this;
            byte[] r0 = f49161d
            monitor-enter(r0)
            r1 = 0
            if (r6 == 0) goto L_0x0051
            java.util.List<com.huawei.hms.location.LocationCallback> r2 = r5.f49162b     // Catch:{ all -> 0x004f }
            boolean r2 = com.huawei.hms.support.api.location.common.CollectionsUtil.isEmpty((java.util.Collection<?>) r2)     // Catch:{ all -> 0x004f }
            if (r2 == 0) goto L_0x000f
            goto L_0x0051
        L_0x000f:
            java.util.List<com.huawei.hms.location.LocationCallback> r2 = r5.f49162b     // Catch:{ all -> 0x004f }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x004f }
        L_0x0015:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x004f }
            if (r3 == 0) goto L_0x004d
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x004f }
            com.huawei.hms.location.LocationCallback r3 = (com.huawei.hms.location.LocationCallback) r3     // Catch:{ all -> 0x004f }
            boolean r4 = r3.equals(r6)     // Catch:{ all -> 0x004f }
            if (r4 == 0) goto L_0x0015
            java.util.List<com.huawei.hms.location.LocationCallback> r6 = r5.f49162b     // Catch:{ all -> 0x004f }
            r6.remove(r3)     // Catch:{ all -> 0x004f }
            java.lang.String r6 = "LocationRequestCacheManager"
            java.lang.String r1 = ""
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x004f }
            r2.<init>()     // Catch:{ all -> 0x004f }
            java.lang.String r3 = "remove callback from removingCallbackList, size is : "
            r2.append(r3)     // Catch:{ all -> 0x004f }
            java.util.List<com.huawei.hms.location.LocationCallback> r3 = r5.f49162b     // Catch:{ all -> 0x004f }
            int r3 = r3.size()     // Catch:{ all -> 0x004f }
            r2.append(r3)     // Catch:{ all -> 0x004f }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x004f }
            com.huawei.hms.support.api.location.common.HMSLocationLog.i(r6, r1, r2)     // Catch:{ all -> 0x004f }
            monitor-exit(r0)     // Catch:{ all -> 0x004f }
            r6 = 1
            return r6
        L_0x004d:
            monitor-exit(r0)     // Catch:{ all -> 0x004f }
            return r1
        L_0x004f:
            r6 = move-exception
            goto L_0x0053
        L_0x0051:
            monitor-exit(r0)     // Catch:{ all -> 0x004f }
            return r1
        L_0x0053:
            monitor-exit(r0)     // Catch:{ all -> 0x004f }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.locationSdk.d0.a(com.huawei.hms.location.LocationCallback):boolean");
    }
}
