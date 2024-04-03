package com.huawei.hms.analytics;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.analytics.m;

public final class al extends ah {
    public al(Context context, m.lmn lmn) {
        super(context, lmn, new z(context, lmn));
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        this.ikl = new ab(context, intent, this);
    }

    public final boolean klm() {
        return klm("com.samsung.android.deviceidservice");
    }

    public final void lmn() {
        try {
            this.ikl.lmn();
        } catch (Exception unused) {
            lmn("getOaid,bindService error, begin get gaid");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0039, code lost:
        throw new java.lang.IllegalArgumentException("get oaid error");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003a, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        ikl();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003e, code lost:
        throw r4;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0032 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void lmn(com.huawei.hms.analytics.ab.lmn r4) {
        /*
            r3 = this;
            com.huawei.hms.analytics.ai r0 = new com.huawei.hms.analytics.ai     // Catch:{ all -> 0x0032 }
            java.lang.String r1 = "com.samsung.android.deviceidservice.IDeviceIdService"
            android.os.IBinder r4 = r4.lmn()     // Catch:{ all -> 0x0032 }
            r0.<init>(r1, r4)     // Catch:{ all -> 0x0032 }
            r4 = 0
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ all -> 0x0032 }
            java.lang.String r4 = r0.lmn(r4)     // Catch:{ all -> 0x0032 }
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0032 }
            if (r0 != 0) goto L_0x0025
            com.huawei.hms.analytics.m$lmn r0 = r3.lmn     // Catch:{ all -> 0x0032 }
            java.lang.String r1 = ""
            java.lang.String r2 = "oaid"
            r0.lmn(r4, r1, r2)     // Catch:{ all -> 0x0032 }
            r3.ikl()
            return
        L_0x0025:
            java.lang.String r4 = "SamSungDeviceIdHelper"
            java.lang.String r0 = "oaid is empty"
            com.huawei.hms.analytics.core.log.HiLog.w(r4, r0)     // Catch:{ all -> 0x0032 }
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0032 }
            r4.<init>()     // Catch:{ all -> 0x0032 }
            throw r4     // Catch:{ all -> 0x0032 }
        L_0x0032:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x003a }
            java.lang.String r0 = "get oaid error"
            r4.<init>(r0)     // Catch:{ all -> 0x003a }
            throw r4     // Catch:{ all -> 0x003a }
        L_0x003a:
            r4 = move-exception
            r3.ikl()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.analytics.al.lmn(com.huawei.hms.analytics.ab$lmn):void");
    }
}
