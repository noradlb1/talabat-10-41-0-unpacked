package com.huawei.hms.analytics;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.analytics.m;

public final class am extends ah {
    public am(Context context, m.lmn lmn) {
        super(context, lmn, new z(context, lmn));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002d, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003a, code lost:
        if (r1 == null) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003d, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002b, code lost:
        if (r1 != null) goto L_0x002d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String ijk() {
        /*
            r9 = this;
            java.lang.String r0 = ""
            r1 = 0
            java.lang.String r2 = "content://com.vivo.vms.IdProvider/IdentifierId/OAID"
            android.net.Uri r4 = android.net.Uri.parse(r2)     // Catch:{ Exception -> 0x0033 }
            android.content.Context r2 = r9.klm     // Catch:{ Exception -> 0x0033 }
            android.content.ContentResolver r3 = r2.getContentResolver()     // Catch:{ Exception -> 0x0033 }
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0033 }
            if (r1 == 0) goto L_0x002b
            boolean r2 = r1.moveToFirst()     // Catch:{ Exception -> 0x0033 }
            if (r2 == 0) goto L_0x002b
            java.lang.String r2 = "value"
            int r2 = r1.getColumnIndex(r2)     // Catch:{ Exception -> 0x0033 }
            if (r2 < 0) goto L_0x002b
            java.lang.String r0 = r1.getString(r2)     // Catch:{ Exception -> 0x0033 }
        L_0x002b:
            if (r1 == 0) goto L_0x003d
        L_0x002d:
            r1.close()
            goto L_0x003d
        L_0x0031:
            r0 = move-exception
            goto L_0x003e
        L_0x0033:
            java.lang.String r2 = "vvOaid"
            java.lang.String r3 = "contentResolver query exception"
            com.huawei.hms.analytics.core.log.HiLog.w(r2, r3)     // Catch:{ all -> 0x0031 }
            if (r1 == 0) goto L_0x003d
            goto L_0x002d
        L_0x003d:
            return r0
        L_0x003e:
            if (r1 == 0) goto L_0x0043
            r1.close()
        L_0x0043:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.analytics.am.ijk():java.lang.String");
    }

    public final boolean klm() {
        return Build.VERSION.SDK_INT >= 28;
    }

    public final void lmn() {
        String ijk = ijk();
        if (TextUtils.isEmpty(ijk)) {
            lmn("oaid is empty, begin get gaid");
        } else {
            this.lmn.lmn(ijk, "", "oaid");
        }
    }
}
