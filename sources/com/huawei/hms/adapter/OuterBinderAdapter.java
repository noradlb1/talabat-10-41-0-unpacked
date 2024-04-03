package com.huawei.hms.adapter;

import android.content.Context;

public class OuterBinderAdapter extends BinderAdapter {

    /* renamed from: j  reason: collision with root package name */
    private static final Object f47801j = new Object();

    /* renamed from: k  reason: collision with root package name */
    private static BinderAdapter f47802k;

    /* renamed from: l  reason: collision with root package name */
    private static String f47803l;

    /* renamed from: m  reason: collision with root package name */
    private static String f47804m;

    private OuterBinderAdapter(Context context, String str, String str2) {
        super(context, str, str2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.huawei.hms.adapter.BinderAdapter getInstance(android.content.Context r3, java.lang.String r4, java.lang.String r5) {
        /*
            java.lang.String r0 = "OuterBinderAdapter"
            java.lang.String r1 = "OuterBinderAdapter getInstance."
            com.huawei.hms.support.log.HMSLog.i(r0, r1)
            java.lang.Object r0 = f47801j
            monitor-enter(r0)
            com.huawei.hms.adapter.BinderAdapter r1 = f47802k     // Catch:{ all -> 0x004b }
            if (r1 != 0) goto L_0x001a
            f47803l = r4     // Catch:{ all -> 0x004b }
            f47804m = r5     // Catch:{ all -> 0x004b }
            com.huawei.hms.adapter.OuterBinderAdapter r1 = new com.huawei.hms.adapter.OuterBinderAdapter     // Catch:{ all -> 0x004b }
            r1.<init>(r3, r4, r5)     // Catch:{ all -> 0x004b }
            f47802k = r1     // Catch:{ all -> 0x004b }
            goto L_0x0047
        L_0x001a:
            java.lang.String r1 = f47803l     // Catch:{ all -> 0x004b }
            boolean r1 = com.huawei.hms.common.internal.Objects.equal(r1, r4)     // Catch:{ all -> 0x004b }
            if (r1 == 0) goto L_0x002d
            java.lang.String r1 = f47804m     // Catch:{ all -> 0x004b }
            boolean r1 = com.huawei.hms.common.internal.Objects.equal(r1, r5)     // Catch:{ all -> 0x004b }
            if (r1 != 0) goto L_0x002b
            goto L_0x002d
        L_0x002b:
            r1 = 0
            goto L_0x002e
        L_0x002d:
            r1 = 1
        L_0x002e:
            if (r1 == 0) goto L_0x0047
            java.lang.String r1 = "OuterBinderAdapter"
            java.lang.String r2 = "OuterBinderAdapter getInstance refresh adapter"
            com.huawei.hms.support.log.HMSLog.i(r1, r2)     // Catch:{ all -> 0x004b }
            f47803l = r4     // Catch:{ all -> 0x004b }
            f47804m = r5     // Catch:{ all -> 0x004b }
            com.huawei.hms.adapter.BinderAdapter r1 = f47802k     // Catch:{ all -> 0x004b }
            r1.unBind()     // Catch:{ all -> 0x004b }
            com.huawei.hms.adapter.OuterBinderAdapter r1 = new com.huawei.hms.adapter.OuterBinderAdapter     // Catch:{ all -> 0x004b }
            r1.<init>(r3, r4, r5)     // Catch:{ all -> 0x004b }
            f47802k = r1     // Catch:{ all -> 0x004b }
        L_0x0047:
            com.huawei.hms.adapter.BinderAdapter r3 = f47802k     // Catch:{ all -> 0x004b }
            monitor-exit(r0)     // Catch:{ all -> 0x004b }
            return r3
        L_0x004b:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004b }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.adapter.OuterBinderAdapter.getInstance(android.content.Context, java.lang.String, java.lang.String):com.huawei.hms.adapter.BinderAdapter");
    }

    public int getConnTimeOut() {
        return 1001;
    }

    public int getMsgDelayDisconnect() {
        return 1002;
    }
}
