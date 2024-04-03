package com.huawei.hms.analytics;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.m;

public final class z extends ah {
    private final m.lmn ijk;

    public z(Context context, m.lmn lmn) {
        super(context, lmn, (ah) null);
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        this.ikl = new ab(context, intent, this);
        this.ijk = lmn;
    }

    public final boolean klm() {
        return klm("com.android.vending");
    }

    public final void lmn() {
        try {
            this.ikl.lmn();
        } catch (Exception unused) {
            lmn("GMS getOaid,bindService error, begin get gaid");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002e, code lost:
        throw new java.lang.IllegalArgumentException("get gaid error");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002f, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0030, code lost:
        ikl();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0033, code lost:
        throw r4;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0027 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void lmn(com.huawei.hms.analytics.ab.lmn r4) {
        /*
            r3 = this;
            com.huawei.hms.analytics.ai r0 = new com.huawei.hms.analytics.ai     // Catch:{ all -> 0x0027 }
            java.lang.String r1 = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService"
            android.os.IBinder r4 = r4.lmn()     // Catch:{ all -> 0x0027 }
            r0.<init>(r1, r4)     // Catch:{ all -> 0x0027 }
            r4 = 0
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ all -> 0x0027 }
            java.lang.String r4 = r0.lmn(r4)     // Catch:{ all -> 0x0027 }
            boolean r0 = r0.lmn()     // Catch:{ all -> 0x0027 }
            r3.ikl()
            com.huawei.hms.analytics.m$lmn r1 = r3.ijk
            r0 = r0 ^ 1
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r2 = "gaid"
            r1.lmn(r4, r0, r2)
            return
        L_0x0027:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x002f }
            java.lang.String r0 = "get gaid error"
            r4.<init>(r0)     // Catch:{ all -> 0x002f }
            throw r4     // Catch:{ all -> 0x002f }
        L_0x002f:
            r4 = move-exception
            r3.ikl()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.analytics.z.lmn(com.huawei.hms.analytics.ab$lmn):void");
    }

    public final void lmn(String str) {
        HiLog.w("gaidHepler", "bind service error");
        this.ijk.lmn("", "", "");
    }
}
