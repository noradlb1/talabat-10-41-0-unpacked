package com.huawei.hms.analytics;

import android.content.Context;

public final class dd {
    private Context lmn;

    public static class lmn {
        public String klm;
        public String lmn;
    }

    public dd(Context context) {
        this.lmn = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0035 A[Catch:{ Exception -> 0x00a4, all -> 0x00a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003c A[Catch:{ Exception -> 0x00a4, all -> 0x00a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.huawei.hms.analytics.dd.lmn lmn() {
        /*
            r9 = this;
            java.lang.String r0 = "RedirectReferrer"
            r1 = 0
            android.content.Context r2 = r9.lmn     // Catch:{ Exception -> 0x00a4, all -> 0x00a2 }
            android.content.ContentResolver r3 = r2.getContentResolver()     // Catch:{ Exception -> 0x00a4, all -> 0x00a2 }
            java.lang.String r2 = "content://com.huawei.appmarket.commondata/item/5"
            android.net.Uri r4 = android.net.Uri.parse(r2)     // Catch:{ Exception -> 0x00a4, all -> 0x00a2 }
            android.content.Context r2 = r9.lmn     // Catch:{ Exception -> 0x00a4, all -> 0x00a2 }
            android.content.pm.PackageManager r2 = r2.getPackageManager()     // Catch:{ Exception -> 0x00a4, all -> 0x00a2 }
            java.lang.String r5 = r4.getAuthority()     // Catch:{ Exception -> 0x00a4, all -> 0x00a2 }
            r6 = 0
            android.content.pm.ProviderInfo r2 = r2.resolveContentProvider(r5, r6)     // Catch:{ Exception -> 0x00a4, all -> 0x00a2 }
            if (r2 == 0) goto L_0x002d
            android.content.pm.ApplicationInfo r2 = r2.applicationInfo     // Catch:{ Exception -> 0x00a4, all -> 0x00a2 }
            if (r2 == 0) goto L_0x0032
            java.lang.String r5 = "com.huawei.appmarket"
            java.lang.String r2 = r2.packageName     // Catch:{ Exception -> 0x00a4, all -> 0x00a2 }
            boolean r2 = r5.equals(r2)     // Catch:{ Exception -> 0x00a4, all -> 0x00a2 }
            goto L_0x0033
        L_0x002d:
            java.lang.String r2 = "Invalid param, providerInfo is null"
            com.huawei.hms.analytics.core.log.HiLog.w(r0, r2)     // Catch:{ Exception -> 0x00a4, all -> 0x00a2 }
        L_0x0032:
            r2 = r6
        L_0x0033:
            if (r2 != 0) goto L_0x003c
            java.lang.String r2 = "provder uri pkg check failed"
            com.huawei.hms.analytics.core.log.HiLog.i(r0, r2)     // Catch:{ Exception -> 0x00a4, all -> 0x00a2 }
            goto L_0x00af
        L_0x003c:
            android.content.Context r2 = r9.lmn     // Catch:{ Exception -> 0x00a4, all -> 0x00a2 }
            java.lang.String r2 = r2.getPackageName()     // Catch:{ Exception -> 0x00a4, all -> 0x00a2 }
            r5 = 0
            r7 = 0
            r8 = 1
            java.lang.String[] r8 = new java.lang.String[r8]     // Catch:{ Exception -> 0x00a4, all -> 0x00a2 }
            r8[r6] = r2     // Catch:{ Exception -> 0x00a4, all -> 0x00a2 }
            r2 = 0
            r6 = r7
            r7 = r8
            r8 = r2
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00a4, all -> 0x00a2 }
            com.huawei.hms.analytics.dd$lmn r3 = new com.huawei.hms.analytics.dd$lmn     // Catch:{ Exception -> 0x00a5 }
            r3.<init>()     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r4 = "IE-002"
            if (r2 != 0) goto L_0x0060
            java.lang.String r5 = " Cannot find the App from AG."
        L_0x005c:
            com.huawei.hms.analytics.core.log.HiLog.w(r0, r4, r5)     // Catch:{ Exception -> 0x00a5 }
            goto L_0x009c
        L_0x0060:
            int r5 = r2.getCount()     // Catch:{ Exception -> 0x00a5 }
            if (r5 > 0) goto L_0x0069
            java.lang.String r5 = " has no referrer info stored in AG!"
            goto L_0x005c
        L_0x0069:
            java.lang.String r4 = "referrer query success!"
            com.huawei.hms.analytics.core.log.HiLog.i(r0, r4)     // Catch:{ Exception -> 0x00a5 }
            r2.moveToFirst()     // Catch:{ Exception -> 0x00a5 }
            int r4 = r2.getColumnCount()     // Catch:{ Exception -> 0x00a5 }
            r5 = 4
            if (r4 <= r5) goto L_0x0097
            r4 = 2
            java.lang.String r4 = r2.getString(r4)     // Catch:{ Exception -> 0x00a5 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x00a5 }
            if (r5 != 0) goto L_0x008b
            java.lang.String r5 = "0"
            boolean r5 = r5.equals(r4)     // Catch:{ Exception -> 0x00a5 }
            if (r5 == 0) goto L_0x008d
        L_0x008b:
            java.lang.String r4 = ""
        L_0x008d:
            r3.klm = r4     // Catch:{ Exception -> 0x00a5 }
            r4 = 5
            java.lang.String r4 = r2.getString(r4)     // Catch:{ Exception -> 0x00a5 }
            r3.lmn = r4     // Catch:{ Exception -> 0x00a5 }
            goto L_0x009c
        L_0x0097:
            java.lang.String r4 = "The AG version is too early."
            com.huawei.hms.analytics.core.log.HiLog.w(r0, r4)     // Catch:{ Exception -> 0x00a5 }
        L_0x009c:
            if (r2 == 0) goto L_0x00a1
            r2.close()
        L_0x00a1:
            return r3
        L_0x00a2:
            r0 = move-exception
            goto L_0x00b2
        L_0x00a4:
            r2 = r1
        L_0x00a5:
            java.lang.String r3 = "Redirect query Exception!"
            com.huawei.hms.analytics.core.log.HiLog.e(r0, r3)     // Catch:{ all -> 0x00b0 }
            if (r2 == 0) goto L_0x00af
            r2.close()
        L_0x00af:
            return r1
        L_0x00b0:
            r0 = move-exception
            r1 = r2
        L_0x00b2:
            if (r1 == 0) goto L_0x00b7
            r1.close()
        L_0x00b7:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.analytics.dd.lmn():com.huawei.hms.analytics.dd$lmn");
    }
}
