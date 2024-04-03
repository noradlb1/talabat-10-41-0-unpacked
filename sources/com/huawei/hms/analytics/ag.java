package com.huawei.hms.analytics;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.analytics.m;

public final class ag extends ah {
    private boolean ijk = false;

    public ag(Context context, m.lmn lmn) {
        super(context, lmn, new z(context, lmn));
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String ijk() {
        /*
            r6 = this;
            java.lang.String r0 = ""
            r1 = 24
            r2 = 0
            java.lang.String r3 = "content://cn.nubia.identity/identity"
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ Exception -> 0x005f }
            android.content.Context r4 = r6.klm     // Catch:{ Exception -> 0x005f }
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ Exception -> 0x005f }
            android.content.ContentProviderClient r3 = r4.acquireContentProviderClient(r3)     // Catch:{ Exception -> 0x005f }
            if (r3 != 0) goto L_0x0025
            if (r3 == 0) goto L_0x0024
            int r2 = android.os.Build.VERSION.SDK_INT
            if (r2 < r1) goto L_0x0021
            r3.close()
            goto L_0x0024
        L_0x0021:
            r3.release()
        L_0x0024:
            return r0
        L_0x0025:
            java.lang.String r4 = "getOAID"
            android.os.Bundle r2 = r3.call(r4, r2, r2)     // Catch:{ Exception -> 0x005b, all -> 0x0058 }
            if (r2 != 0) goto L_0x0039
            int r2 = android.os.Build.VERSION.SDK_INT
            if (r2 < r1) goto L_0x0035
            r3.close()
            goto L_0x0038
        L_0x0035:
            r3.release()
        L_0x0038:
            return r0
        L_0x0039:
            java.lang.String r4 = "code"
            r5 = -1
            int r4 = r2.getInt(r4, r5)     // Catch:{ Exception -> 0x005b, all -> 0x0058 }
            if (r4 != 0) goto L_0x0049
            java.lang.String r4 = "id"
            java.lang.String r0 = r2.getString(r4)     // Catch:{ Exception -> 0x005b, all -> 0x0058 }
            goto L_0x004c
        L_0x0049:
            r2 = 1
            r6.ijk = r2     // Catch:{ Exception -> 0x005b, all -> 0x0058 }
        L_0x004c:
            int r2 = android.os.Build.VERSION.SDK_INT
            if (r2 < r1) goto L_0x0054
            r3.close()
            goto L_0x0073
        L_0x0054:
            r3.release()
            goto L_0x0073
        L_0x0058:
            r0 = move-exception
            r2 = r3
            goto L_0x0074
        L_0x005b:
            r2 = r3
            goto L_0x005f
        L_0x005d:
            r0 = move-exception
            goto L_0x0074
        L_0x005f:
            java.lang.String r3 = "NibOaid"
            java.lang.String r4 = "contentResolver query exception"
            com.huawei.hms.analytics.core.log.HiLog.w(r3, r4)     // Catch:{ all -> 0x005d }
            if (r2 == 0) goto L_0x0073
            int r3 = android.os.Build.VERSION.SDK_INT
            if (r3 < r1) goto L_0x0070
            r2.close()
            goto L_0x0073
        L_0x0070:
            r2.release()
        L_0x0073:
            return r0
        L_0x0074:
            if (r2 == 0) goto L_0x0081
            int r3 = android.os.Build.VERSION.SDK_INT
            if (r3 < r1) goto L_0x007e
            r2.close()
            goto L_0x0081
        L_0x007e:
            r2.release()
        L_0x0081:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.analytics.ag.ijk():java.lang.String");
    }

    public final boolean klm() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public final void lmn() {
        String ijk2 = ijk();
        if (!TextUtils.isEmpty(ijk2) || this.ijk) {
            this.lmn.lmn(ijk2, "", "oaid");
        } else {
            lmn("oaid is empty, begin get gaid");
        }
    }
}
