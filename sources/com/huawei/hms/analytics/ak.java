package com.huawei.hms.analytics;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.analytics.m;

public final class ak extends ah {
    private String ijk;

    public ak(Context context, m.lmn lmn) {
        super(context, lmn, new z(context, lmn));
        Intent intent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        this.ikl = new ab(context, intent, this);
    }

    public final boolean klm() {
        return klm("com.heytap.openid");
    }

    public final void lmn() {
        try {
            this.ikl.lmn();
        } catch (Exception unused) {
            lmn("OPPO getOaid,bindService error, begin get gaid");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x007e, code lost:
        throw new java.lang.IllegalAccessException("get sign error");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x007f, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0080, code lost:
        ikl();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0083, code lost:
        throw r10;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0077 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void lmn(com.huawei.hms.analytics.ab.lmn r10) {
        /*
            r9 = this;
            com.huawei.hms.analytics.ai r0 = new com.huawei.hms.analytics.ai     // Catch:{ all -> 0x0077 }
            java.lang.String r1 = "com.heytap.openid.IOpenID"
            android.os.IBinder r10 = r10.lmn()     // Catch:{ all -> 0x0077 }
            r0.<init>(r1, r10)     // Catch:{ all -> 0x0077 }
            android.content.Context r10 = r9.klm     // Catch:{ all -> 0x0077 }
            java.lang.String r10 = r10.getPackageName()     // Catch:{ all -> 0x0077 }
            java.lang.String r1 = r9.ijk     // Catch:{ all -> 0x0077 }
            r2 = 3
            r3 = 1
            r4 = 0
            if (r1 != 0) goto L_0x0059
            android.content.Context r1 = r9.klm     // Catch:{ all -> 0x0077 }
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch:{ all -> 0x0077 }
            r5 = 64
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r10, r5)     // Catch:{ all -> 0x0077 }
            android.content.pm.Signature[] r1 = r1.signatures     // Catch:{ all -> 0x0077 }
            r1 = r1[r4]     // Catch:{ all -> 0x0077 }
            byte[] r1 = r1.toByteArray()     // Catch:{ all -> 0x0077 }
            java.lang.String r5 = "SHA1"
            java.security.MessageDigest r5 = java.security.MessageDigest.getInstance(r5)     // Catch:{ all -> 0x0077 }
            byte[] r1 = r5.digest(r1)     // Catch:{ all -> 0x0077 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0077 }
            r5.<init>()     // Catch:{ all -> 0x0077 }
            int r6 = r1.length     // Catch:{ all -> 0x0077 }
            r7 = r4
        L_0x003d:
            if (r7 >= r6) goto L_0x0053
            byte r8 = r1[r7]     // Catch:{ all -> 0x0077 }
            r8 = r8 & 255(0xff, float:3.57E-43)
            r8 = r8 | 256(0x100, float:3.59E-43)
            java.lang.String r8 = java.lang.Integer.toHexString(r8)     // Catch:{ all -> 0x0077 }
            java.lang.String r8 = r8.substring(r3, r2)     // Catch:{ all -> 0x0077 }
            r5.append(r8)     // Catch:{ all -> 0x0077 }
            int r7 = r7 + 1
            goto L_0x003d
        L_0x0053:
            java.lang.String r1 = r5.toString()     // Catch:{ all -> 0x0077 }
            r9.ijk = r1     // Catch:{ all -> 0x0077 }
        L_0x0059:
            java.lang.String[] r1 = new java.lang.String[r2]     // Catch:{ all -> 0x0077 }
            r1[r4] = r10     // Catch:{ all -> 0x0077 }
            java.lang.String r10 = r9.ijk     // Catch:{ all -> 0x0077 }
            r1[r3] = r10     // Catch:{ all -> 0x0077 }
            java.lang.String r10 = "OUID"
            r2 = 2
            r1[r2] = r10     // Catch:{ all -> 0x0077 }
            java.lang.String r10 = r0.lmn(r1)     // Catch:{ all -> 0x0077 }
            com.huawei.hms.analytics.m$lmn r0 = r9.lmn     // Catch:{ all -> 0x0077 }
            java.lang.String r1 = ""
            java.lang.String r2 = "oaid"
            r0.lmn(r10, r1, r2)     // Catch:{ all -> 0x0077 }
            r9.ikl()
            return
        L_0x0077:
            java.lang.IllegalAccessException r10 = new java.lang.IllegalAccessException     // Catch:{ all -> 0x007f }
            java.lang.String r0 = "get sign error"
            r10.<init>(r0)     // Catch:{ all -> 0x007f }
            throw r10     // Catch:{ all -> 0x007f }
        L_0x007f:
            r10 = move-exception
            r9.ikl()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.analytics.ak.lmn(com.huawei.hms.analytics.ab$lmn):void");
    }
}
