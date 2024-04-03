package com.huawei.hms.analytics;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.q;

public final class cs implements Runnable {
    private String ikl = "0";
    private final df klm;
    private Context lmn;

    public final class lmn implements p {
        private final cj ikl;
        private boolean klm;

        private lmn() {
            this.klm = false;
            this.ikl = ck.lmn("ReferrerTask#ADSReferrer");
        }

        public /* synthetic */ lmn(cs csVar, byte b11) {
            this();
        }

        public final void lmn(String str) {
            HiLog.i("ReferrerMission", "onSuccess");
            cs.this.lmn(TextUtils.isEmpty(str) ? new db("") : new db("PPS", str));
            this.klm = true;
            cj cjVar = this.ikl;
            cjVar.lmn = "0";
            ck.lmn(cjVar);
        }

        public final void lmn(String str, String str2) {
            HiLog.w("ReferrerMission", "onFail: ".concat(String.valueOf(str)));
            if (!this.klm) {
                cs.this.lmn(new db(""));
                cj cjVar = this.ikl;
                cjVar.klm = str2;
                ck.lmn(cjVar);
            }
        }
    }

    public cs(Context context, bl blVar) {
        this.lmn = context;
        this.klm = new da(blVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b3, code lost:
        if (r7.equals("0") != false) goto L_0x00b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0112, code lost:
        if (android.text.TextUtils.isEmpty(r6.ikl) == false) goto L_0x0115;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0115, code lost:
        r3 = "0";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0116, code lost:
        r8.lmn = r3;
        com.huawei.hms.analytics.ck.lmn(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x013d, code lost:
        if (android.text.TextUtils.isEmpty(r6.ikl) != false) goto L_0x0116;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x015e, code lost:
        if (android.text.TextUtils.isEmpty(r6.ikl) != false) goto L_0x0116;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x017f, code lost:
        if (android.text.TextUtils.isEmpty(r6.ikl) != false) goto L_0x0116;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0182, code lost:
        return r6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x004c A[Catch:{ IllegalStateException -> 0x0161, CursorIndexOutOfBoundsException -> 0x0140, Exception -> 0x011f, all -> 0x011c }] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0058 A[Catch:{ IllegalStateException -> 0x0161, CursorIndexOutOfBoundsException -> 0x0140, Exception -> 0x011f, all -> 0x011c }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0196  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.huawei.hms.analytics.db lmn() {
        /*
            r18 = this;
            r1 = r18
            java.lang.String r0 = "isLastReferrerQueryFailed"
            java.lang.String r2 = "global_v2"
            java.lang.String r3 = "1"
            java.lang.String r4 = "0"
            java.lang.String r5 = "ReferrerMission"
            com.huawei.hms.analytics.db r6 = new com.huawei.hms.analytics.db
            java.lang.String r7 = "AG"
            r6.<init>(r7)
            java.lang.String r8 = "ReferrerTask#AGReferrer"
            com.huawei.hms.analytics.cj r8 = com.huawei.hms.analytics.ck.lmn((java.lang.String) r8)
            r9 = 1
            android.content.Context r11 = r1.lmn     // Catch:{ IllegalStateException -> 0x0161, CursorIndexOutOfBoundsException -> 0x0140, Exception -> 0x011f, all -> 0x011c }
            android.content.ContentResolver r12 = r11.getContentResolver()     // Catch:{ IllegalStateException -> 0x0161, CursorIndexOutOfBoundsException -> 0x0140, Exception -> 0x011f, all -> 0x011c }
            java.lang.String r11 = "content://com.huawei.appmarket.commondata/item/5"
            android.net.Uri r13 = android.net.Uri.parse(r11)     // Catch:{ IllegalStateException -> 0x0161, CursorIndexOutOfBoundsException -> 0x0140, Exception -> 0x011f, all -> 0x011c }
            android.content.Context r11 = r1.lmn     // Catch:{ IllegalStateException -> 0x0161, CursorIndexOutOfBoundsException -> 0x0140, Exception -> 0x011f, all -> 0x011c }
            android.content.pm.PackageManager r11 = r11.getPackageManager()     // Catch:{ IllegalStateException -> 0x0161, CursorIndexOutOfBoundsException -> 0x0140, Exception -> 0x011f, all -> 0x011c }
            java.lang.String r14 = r13.getAuthority()     // Catch:{ IllegalStateException -> 0x0161, CursorIndexOutOfBoundsException -> 0x0140, Exception -> 0x011f, all -> 0x011c }
            r15 = 0
            android.content.pm.ProviderInfo r11 = r11.resolveContentProvider(r14, r15)     // Catch:{ IllegalStateException -> 0x0161, CursorIndexOutOfBoundsException -> 0x0140, Exception -> 0x011f, all -> 0x011c }
            if (r11 == 0) goto L_0x0044
            android.content.pm.ApplicationInfo r11 = r11.applicationInfo     // Catch:{ IllegalStateException -> 0x0161, CursorIndexOutOfBoundsException -> 0x0140, Exception -> 0x011f, all -> 0x011c }
            if (r11 == 0) goto L_0x0049
            java.lang.String r14 = "com.huawei.appmarket"
            java.lang.String r11 = r11.packageName     // Catch:{ IllegalStateException -> 0x0161, CursorIndexOutOfBoundsException -> 0x0140, Exception -> 0x011f, all -> 0x011c }
            boolean r11 = r14.equals(r11)     // Catch:{ IllegalStateException -> 0x0161, CursorIndexOutOfBoundsException -> 0x0140, Exception -> 0x011f, all -> 0x011c }
            goto L_0x004a
        L_0x0044:
            java.lang.String r11 = "Invalid param, providerInfo is null"
            com.huawei.hms.analytics.core.log.HiLog.w(r5, r11)     // Catch:{ IllegalStateException -> 0x0161, CursorIndexOutOfBoundsException -> 0x0140, Exception -> 0x011f, all -> 0x011c }
        L_0x0049:
            r11 = r15
        L_0x004a:
            if (r11 != 0) goto L_0x0058
            java.lang.String r7 = "provder uri pkg check failed"
            com.huawei.hms.analytics.core.log.HiLog.i(r5, r7)     // Catch:{ IllegalStateException -> 0x0161, CursorIndexOutOfBoundsException -> 0x0140, Exception -> 0x011f, all -> 0x011c }
            java.lang.String r7 = "002"
            r1.ikl = r7     // Catch:{ IllegalStateException -> 0x0161, CursorIndexOutOfBoundsException -> 0x0140, Exception -> 0x011f, all -> 0x011c }
            r10 = 0
            goto L_0x0103
        L_0x0058:
            android.content.Context r11 = r1.lmn     // Catch:{ IllegalStateException -> 0x0161, CursorIndexOutOfBoundsException -> 0x0140, Exception -> 0x011f, all -> 0x011c }
            java.lang.String r11 = r11.getPackageName()     // Catch:{ IllegalStateException -> 0x0161, CursorIndexOutOfBoundsException -> 0x0140, Exception -> 0x011f, all -> 0x011c }
            r14 = 0
            r16 = 0
            java.lang.String[] r10 = new java.lang.String[r9]     // Catch:{ IllegalStateException -> 0x0161, CursorIndexOutOfBoundsException -> 0x0140, Exception -> 0x011f, all -> 0x011c }
            r10[r15] = r11     // Catch:{ IllegalStateException -> 0x0161, CursorIndexOutOfBoundsException -> 0x0140, Exception -> 0x011f, all -> 0x011c }
            r17 = 0
            r11 = r15
            r15 = r16
            r16 = r10
            android.database.Cursor r10 = r12.query(r13, r14, r15, r16, r17)     // Catch:{ IllegalStateException -> 0x0161, CursorIndexOutOfBoundsException -> 0x0140, Exception -> 0x011f, all -> 0x011c }
            com.huawei.hms.analytics.db r12 = new com.huawei.hms.analytics.db     // Catch:{ IllegalStateException -> 0x0162, CursorIndexOutOfBoundsException -> 0x0141, Exception -> 0x0120 }
            r12.<init>(r7)     // Catch:{ IllegalStateException -> 0x0162, CursorIndexOutOfBoundsException -> 0x0141, Exception -> 0x0120 }
            java.lang.String r7 = "IE-002"
            if (r10 != 0) goto L_0x0089
            java.lang.String r11 = " Cannot find the App from AG."
            com.huawei.hms.analytics.core.log.HiLog.w(r5, r7, r11)     // Catch:{ IllegalStateException -> 0x0162, CursorIndexOutOfBoundsException -> 0x0141, Exception -> 0x0120 }
            java.lang.String r7 = "003"
            r1.ikl = r7     // Catch:{ IllegalStateException -> 0x0162, CursorIndexOutOfBoundsException -> 0x0141, Exception -> 0x0120 }
            android.content.Context r7 = r1.lmn     // Catch:{ IllegalStateException -> 0x0162, CursorIndexOutOfBoundsException -> 0x0141, Exception -> 0x0120 }
        L_0x0084:
            com.huawei.hms.analytics.dv.lmn((android.content.Context) r7, (java.lang.String) r2, (java.lang.String) r0, (boolean) r9)     // Catch:{ IllegalStateException -> 0x0162, CursorIndexOutOfBoundsException -> 0x0141, Exception -> 0x0120 }
            goto L_0x0102
        L_0x0089:
            int r13 = r10.getCount()     // Catch:{ IllegalStateException -> 0x0162, CursorIndexOutOfBoundsException -> 0x0141, Exception -> 0x0120 }
            if (r13 > 0) goto L_0x009b
            java.lang.String r11 = " has no referrer info stored in AG!"
            com.huawei.hms.analytics.core.log.HiLog.w(r5, r7, r11)     // Catch:{ IllegalStateException -> 0x0162, CursorIndexOutOfBoundsException -> 0x0141, Exception -> 0x0120 }
            java.lang.String r7 = "004"
            r1.ikl = r7     // Catch:{ IllegalStateException -> 0x0162, CursorIndexOutOfBoundsException -> 0x0141, Exception -> 0x0120 }
            android.content.Context r7 = r1.lmn     // Catch:{ IllegalStateException -> 0x0162, CursorIndexOutOfBoundsException -> 0x0141, Exception -> 0x0120 }
            goto L_0x0084
        L_0x009b:
            java.lang.String r7 = "referrer query success!"
            com.huawei.hms.analytics.core.log.HiLog.i(r5, r7)     // Catch:{ IllegalStateException -> 0x0162, CursorIndexOutOfBoundsException -> 0x0141, Exception -> 0x0120 }
            r10.moveToFirst()     // Catch:{ IllegalStateException -> 0x0162, CursorIndexOutOfBoundsException -> 0x0141, Exception -> 0x0120 }
            java.lang.String r7 = r10.getString(r11)     // Catch:{ IllegalStateException -> 0x0162, CursorIndexOutOfBoundsException -> 0x0141, Exception -> 0x0120 }
            boolean r11 = android.text.TextUtils.isEmpty(r7)     // Catch:{ IllegalStateException -> 0x0162, CursorIndexOutOfBoundsException -> 0x0141, Exception -> 0x0120 }
            java.lang.String r13 = ""
            if (r11 != 0) goto L_0x00b5
            boolean r11 = r7.equals(r4)     // Catch:{ IllegalStateException -> 0x0162, CursorIndexOutOfBoundsException -> 0x0141, Exception -> 0x0120 }
            if (r11 == 0) goto L_0x00c1
        L_0x00b5:
            java.lang.String r7 = "001"
            r1.ikl = r7     // Catch:{ IllegalStateException -> 0x0162, CursorIndexOutOfBoundsException -> 0x0141, Exception -> 0x0120 }
            java.lang.String r7 = "PE-001"
            java.lang.String r11 = "referrer is null or 0"
            com.huawei.hms.analytics.core.log.HiLog.w(r5, r7, r11)     // Catch:{ IllegalStateException -> 0x0162, CursorIndexOutOfBoundsException -> 0x0141, Exception -> 0x0120 }
            r7 = r13
        L_0x00c1:
            r12.ikl = r7     // Catch:{ IllegalStateException -> 0x0162, CursorIndexOutOfBoundsException -> 0x0141, Exception -> 0x0120 }
            int r7 = r10.getColumnCount()     // Catch:{ IllegalStateException -> 0x0162, CursorIndexOutOfBoundsException -> 0x0141, Exception -> 0x0120 }
            r11 = 4
            if (r7 <= r11) goto L_0x00fd
            java.lang.String r7 = r10.getString(r11)     // Catch:{ IllegalStateException -> 0x0162, CursorIndexOutOfBoundsException -> 0x0141, Exception -> 0x0120 }
            boolean r11 = android.text.TextUtils.isEmpty(r7)     // Catch:{ IllegalStateException -> 0x0162, CursorIndexOutOfBoundsException -> 0x0141, Exception -> 0x0120 }
            if (r11 != 0) goto L_0x00da
            boolean r11 = r7.equals(r4)     // Catch:{ IllegalStateException -> 0x0162, CursorIndexOutOfBoundsException -> 0x0141, Exception -> 0x0120 }
            if (r11 == 0) goto L_0x00e0
        L_0x00da:
            java.lang.String r7 = "trackId is empty"
            com.huawei.hms.analytics.core.log.HiLog.w(r5, r7)     // Catch:{ IllegalStateException -> 0x0162, CursorIndexOutOfBoundsException -> 0x0141, Exception -> 0x0120 }
            r7 = r13
        L_0x00e0:
            r12.lmn = r7     // Catch:{ IllegalStateException -> 0x0162, CursorIndexOutOfBoundsException -> 0x0141, Exception -> 0x0120 }
            java.lang.String r7 = r10.getString(r9)     // Catch:{ IllegalStateException -> 0x0162, CursorIndexOutOfBoundsException -> 0x0141, Exception -> 0x0120 }
            boolean r11 = android.text.TextUtils.isEmpty(r7)     // Catch:{ IllegalStateException -> 0x0162, CursorIndexOutOfBoundsException -> 0x0141, Exception -> 0x0120 }
            if (r11 != 0) goto L_0x00f5
            boolean r11 = r7.equals(r4)     // Catch:{ IllegalStateException -> 0x0162, CursorIndexOutOfBoundsException -> 0x0141, Exception -> 0x0120 }
            if (r11 == 0) goto L_0x00f3
            goto L_0x00f5
        L_0x00f3:
            r13 = r7
            goto L_0x00fa
        L_0x00f5:
            java.lang.String r7 = "trackIdTime is empty"
            com.huawei.hms.analytics.core.log.HiLog.w(r5, r7)     // Catch:{ IllegalStateException -> 0x0162, CursorIndexOutOfBoundsException -> 0x0141, Exception -> 0x0120 }
        L_0x00fa:
            r12.klm = r13     // Catch:{ IllegalStateException -> 0x0162, CursorIndexOutOfBoundsException -> 0x0141, Exception -> 0x0120 }
            goto L_0x0102
        L_0x00fd:
            java.lang.String r7 = "The AG version is too early."
            com.huawei.hms.analytics.core.log.HiLog.w(r5, r7)     // Catch:{ IllegalStateException -> 0x0162, CursorIndexOutOfBoundsException -> 0x0141, Exception -> 0x0120 }
        L_0x0102:
            r6 = r12
        L_0x0103:
            if (r10 == 0) goto L_0x0108
            r10.close()
        L_0x0108:
            java.lang.String r0 = r1.ikl
            r8.klm = r0
            java.lang.String r0 = r6.ikl
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0115
            goto L_0x0116
        L_0x0115:
            r3 = r4
        L_0x0116:
            r8.lmn = r3
            com.huawei.hms.analytics.ck.lmn((com.huawei.hms.analytics.cj) r8)
            goto L_0x0182
        L_0x011c:
            r0 = move-exception
            r10 = 0
            goto L_0x0184
        L_0x011f:
            r10 = 0
        L_0x0120:
            java.lang.String r7 = "Referrer query Exception!"
            com.huawei.hms.analytics.core.log.HiLog.e(r5, r7)     // Catch:{ all -> 0x0183 }
            java.lang.String r5 = "999"
            r1.ikl = r5     // Catch:{ all -> 0x0183 }
            android.content.Context r5 = r1.lmn     // Catch:{ all -> 0x0183 }
            com.huawei.hms.analytics.dv.lmn((android.content.Context) r5, (java.lang.String) r2, (java.lang.String) r0, (boolean) r9)     // Catch:{ all -> 0x0183 }
            if (r10 == 0) goto L_0x0133
            r10.close()
        L_0x0133:
            java.lang.String r0 = r1.ikl
            r8.klm = r0
            java.lang.String r0 = r6.ikl
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0115
            goto L_0x0116
        L_0x0140:
            r10 = 0
        L_0x0141:
            java.lang.String r7 = "Referrer query CursorIndexOutOfBoundsException!"
            com.huawei.hms.analytics.core.log.HiLog.e(r5, r7)     // Catch:{ all -> 0x0183 }
            java.lang.String r5 = "101"
            r1.ikl = r5     // Catch:{ all -> 0x0183 }
            android.content.Context r5 = r1.lmn     // Catch:{ all -> 0x0183 }
            com.huawei.hms.analytics.dv.lmn((android.content.Context) r5, (java.lang.String) r2, (java.lang.String) r0, (boolean) r9)     // Catch:{ all -> 0x0183 }
            if (r10 == 0) goto L_0x0154
            r10.close()
        L_0x0154:
            java.lang.String r0 = r1.ikl
            r8.klm = r0
            java.lang.String r0 = r6.ikl
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0115
            goto L_0x0116
        L_0x0161:
            r10 = 0
        L_0x0162:
            java.lang.String r7 = "Referrer query IllegalStateException!"
            com.huawei.hms.analytics.core.log.HiLog.e(r5, r7)     // Catch:{ all -> 0x0183 }
            java.lang.String r5 = "100"
            r1.ikl = r5     // Catch:{ all -> 0x0183 }
            android.content.Context r5 = r1.lmn     // Catch:{ all -> 0x0183 }
            com.huawei.hms.analytics.dv.lmn((android.content.Context) r5, (java.lang.String) r2, (java.lang.String) r0, (boolean) r9)     // Catch:{ all -> 0x0183 }
            if (r10 == 0) goto L_0x0175
            r10.close()
        L_0x0175:
            java.lang.String r0 = r1.ikl
            r8.klm = r0
            java.lang.String r0 = r6.ikl
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0115
            goto L_0x0116
        L_0x0182:
            return r6
        L_0x0183:
            r0 = move-exception
        L_0x0184:
            if (r10 == 0) goto L_0x0189
            r10.close()
        L_0x0189:
            java.lang.String r2 = r1.ikl
            r8.klm = r2
            java.lang.String r2 = r6.ikl
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0196
            goto L_0x0197
        L_0x0196:
            r3 = r4
        L_0x0197:
            r8.lmn = r3
            com.huawei.hms.analytics.ck.lmn((com.huawei.hms.analytics.cj) r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.analytics.cs.lmn():com.huawei.hms.analytics.db");
    }

    /* access modifiers changed from: private */
    public void lmn(de deVar) {
        this.klm.lmn(deVar);
    }

    public final void run() {
        if (this.lmn == null) {
            return;
        }
        if (ad.lmn() || ad.klm()) {
            boolean klm2 = dv.klm(this.lmn, "global_v2", "isLastReferrerQueryFailed", false);
            db lmn2 = lmn();
            if (!klm2) {
                if (!TextUtils.isEmpty(lmn2.ikl) || !TextUtils.isEmpty(lmn2.lmn)) {
                    lmn(lmn2);
                    return;
                }
            }
            q qVar = new q(this.lmn, new lmn(this, (byte) 0));
            HiLog.i("PpsServiceCommander", "ads bindService..");
            if (qVar.lmn != null) {
                qVar.klm = new q.lmn(qVar, (byte) 0);
                Intent intent = new Intent("com.huawei.android.hms.CHANNEL_SERVICE");
                try {
                    intent.setPackage("com.huawei.hwid");
                    if (!qVar.lmn.bindService(intent, qVar.klm, 1)) {
                        qVar.ikl.lmn("bindService result: false", "009");
                    } else {
                        HiLog.i("PpsServiceCommander", "bindService result: true");
                    }
                } catch (IllegalArgumentException unused) {
                    qVar.ikl.lmn("setPackage IllegalArgumentException", "103");
                }
            }
        } else {
            lmn(new db());
        }
    }
}
