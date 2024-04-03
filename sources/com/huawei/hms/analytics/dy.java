package com.huawei.hms.analytics;

import java.util.concurrent.CountDownLatch;

public final class dy {
    private CountDownLatch klm;
    private ci lmn;

    public dy() {
    }

    public dy(ci ciVar) {
        this.lmn = ciVar;
    }

    public dy(CountDownLatch countDownLatch, ci ciVar) {
        this.lmn = ciVar;
        this.klm = countDownLatch;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00e9, code lost:
        r1 = r8.indexOf(com.tekartik.sqflite.Constant.PARAM_ERROR_CODE);
        r0 = r8.indexOf("message");
        r1 = r1 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x011f, code lost:
        if ("0".equalsIgnoreCase(r5) != false) goto L_0x013c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0121, code lost:
        r7.lmn = r5;
        r7.klm = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0139, code lost:
        if ("0".equalsIgnoreCase(r5) != false) goto L_0x013c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00f5 A[Catch:{ all -> 0x00ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00fe A[Catch:{ all -> 0x00ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x014a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String lmn() {
        /*
            r12 = this;
            java.lang.String r0 = "message"
            java.lang.String r1 = "code"
            java.lang.String r2 = "SE-003"
            java.lang.String r3 = "0"
            java.lang.String r4 = ""
            java.lang.String r5 = "start get token from agc"
            java.lang.String r6 = "TokenAssignment"
            com.huawei.hms.analytics.core.log.HiLog.i(r6, r5)
            java.lang.String r5 = "1"
            java.lang.String r7 = "Token#getTokenString()"
            com.huawei.hms.analytics.cj r7 = com.huawei.hms.analytics.ck.lmn((java.lang.String) r7)
            com.huawei.agconnect.AGConnectInstance r8 = com.huawei.agconnect.AGConnectInstance.getInstance()     // Catch:{ NoClassDefFoundError -> 0x0126, Exception -> 0x00d1 }
            if (r8 != 0) goto L_0x004b
            java.lang.String r8 = "get AGConnect Instance is null"
            com.huawei.hms.analytics.core.log.HiLog.w(r6, r8)     // Catch:{ NoClassDefFoundError -> 0x0126, Exception -> 0x00d1 }
            com.huawei.hms.analytics.av r8 = com.huawei.hms.analytics.av.lmn()     // Catch:{ NoClassDefFoundError -> 0x0126, Exception -> 0x00d1 }
            com.huawei.hms.analytics.ax r8 = r8.lmn     // Catch:{ NoClassDefFoundError -> 0x0126, Exception -> 0x00d1 }
            android.content.Context r8 = r8.ghi     // Catch:{ NoClassDefFoundError -> 0x0126, Exception -> 0x00d1 }
            com.huawei.agconnect.AGConnectInstance.initialize(r8)     // Catch:{ NoClassDefFoundError -> 0x0126, Exception -> 0x00d1 }
            com.huawei.agconnect.AGConnectInstance r8 = com.huawei.agconnect.AGConnectInstance.getInstance()     // Catch:{ NoClassDefFoundError -> 0x0126, Exception -> 0x00d1 }
            if (r8 != 0) goto L_0x004b
            java.lang.String r8 = "get AGConnect Instance is null again"
            com.huawei.hms.analytics.core.log.HiLog.w(r6, r8)     // Catch:{ NoClassDefFoundError -> 0x0126, Exception -> 0x00d1 }
            java.lang.String r0 = "SE-003:002"
            java.util.concurrent.CountDownLatch r1 = r12.klm
            if (r1 == 0) goto L_0x0043
            r1.countDown()
        L_0x0043:
            r7.lmn = r5
            r7.klm = r0
            com.huawei.hms.analytics.ck.lmn((com.huawei.hms.analytics.cj) r7)
            return r4
        L_0x004b:
            java.lang.Class<com.huawei.agconnect.core.service.auth.CredentialsProvider> r9 = com.huawei.agconnect.core.service.auth.CredentialsProvider.class
            java.lang.Object r8 = r8.getService(r9)     // Catch:{ NoClassDefFoundError -> 0x0126, Exception -> 0x00d1 }
            com.huawei.agconnect.core.service.auth.CredentialsProvider r8 = (com.huawei.agconnect.core.service.auth.CredentialsProvider) r8     // Catch:{ NoClassDefFoundError -> 0x0126, Exception -> 0x00d1 }
            if (r8 != 0) goto L_0x006b
            java.lang.String r8 = "get Credentials Provider is null"
            com.huawei.hms.analytics.core.log.HiLog.w(r6, r8)     // Catch:{ NoClassDefFoundError -> 0x0126, Exception -> 0x00d1 }
            java.lang.String r0 = "SE-003:003"
            java.util.concurrent.CountDownLatch r1 = r12.klm
            if (r1 == 0) goto L_0x0063
            r1.countDown()
        L_0x0063:
            r7.lmn = r5
            r7.klm = r0
            com.huawei.hms.analytics.ck.lmn((com.huawei.hms.analytics.cj) r7)
            return r4
        L_0x006b:
            com.huawei.hmf.tasks.Task r8 = r8.getTokens()     // Catch:{ NoClassDefFoundError -> 0x0126, Exception -> 0x00d1 }
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ NoClassDefFoundError -> 0x0126, Exception -> 0x00d1 }
            r10 = 5000(0x1388, double:2.4703E-320)
            java.lang.Object r8 = com.huawei.hmf.tasks.Tasks.await(r8, r10, r9)     // Catch:{ NoClassDefFoundError -> 0x0126, Exception -> 0x00d1 }
            com.huawei.agconnect.core.service.auth.Token r8 = (com.huawei.agconnect.core.service.auth.Token) r8     // Catch:{ NoClassDefFoundError -> 0x0126, Exception -> 0x00d1 }
            java.lang.String r9 = r8.getTokenString()     // Catch:{ NoClassDefFoundError -> 0x0126, Exception -> 0x00d1 }
            boolean r10 = android.text.TextUtils.isEmpty(r9)     // Catch:{ NoClassDefFoundError -> 0x0127, Exception -> 0x00cc }
            if (r10 != 0) goto L_0x00af
            com.huawei.hms.analytics.av r10 = com.huawei.hms.analytics.av.lmn()     // Catch:{ NoClassDefFoundError -> 0x0127, Exception -> 0x00cc }
            com.huawei.hms.analytics.ax r10 = r10.lmn     // Catch:{ NoClassDefFoundError -> 0x0127, Exception -> 0x00cc }
            r10.hij = r9     // Catch:{ NoClassDefFoundError -> 0x0127, Exception -> 0x00cc }
            long r10 = r8.getExpiration()     // Catch:{ NoClassDefFoundError -> 0x00ac, Exception -> 0x00a9, all -> 0x00a5 }
            com.huawei.hms.analytics.ci r5 = r12.lmn     // Catch:{ NoClassDefFoundError -> 0x00ac, Exception -> 0x00a9, all -> 0x00a5 }
            if (r5 == 0) goto L_0x0096
            r5.klm()     // Catch:{ NoClassDefFoundError -> 0x00ac, Exception -> 0x00a9, all -> 0x00a5 }
        L_0x0096:
            java.lang.String r5 = "success: "
            java.lang.String r8 = java.lang.String.valueOf(r10)     // Catch:{ NoClassDefFoundError -> 0x00ac, Exception -> 0x00a9, all -> 0x00a5 }
            java.lang.String r5 = r5.concat(r8)     // Catch:{ NoClassDefFoundError -> 0x00ac, Exception -> 0x00a9, all -> 0x00a5 }
            com.huawei.hms.analytics.core.log.HiLog.d(r6, r5)     // Catch:{ NoClassDefFoundError -> 0x00ac, Exception -> 0x00a9, all -> 0x00a5 }
            r5 = r3
            goto L_0x00b6
        L_0x00a5:
            r0 = move-exception
            r5 = r3
            goto L_0x013d
        L_0x00a9:
            r8 = move-exception
            r5 = r3
            goto L_0x00d3
        L_0x00ac:
            r5 = r3
            goto L_0x0127
        L_0x00af:
            java.lang.String r8 = "Failed to obtain token from agc, token is empty"
            com.huawei.hms.analytics.core.log.HiLog.e(r6, r2, r8)     // Catch:{ NoClassDefFoundError -> 0x0127, Exception -> 0x00cc }
            java.lang.String r4 = "SE-003:001"
        L_0x00b6:
            java.util.concurrent.CountDownLatch r0 = r12.klm
            if (r0 == 0) goto L_0x00bd
            r0.countDown()
        L_0x00bd:
            boolean r0 = r3.equalsIgnoreCase(r5)
            if (r0 != 0) goto L_0x013c
            r7.lmn = r5
            r7.klm = r4
        L_0x00c7:
            com.huawei.hms.analytics.ck.lmn((com.huawei.hms.analytics.cj) r7)
            goto L_0x013c
        L_0x00cc:
            r8 = move-exception
            goto L_0x00d3
        L_0x00ce:
            r0 = move-exception
            goto L_0x013d
        L_0x00d1:
            r8 = move-exception
            r9 = r4
        L_0x00d3:
            java.lang.String r8 = r8.getMessage()     // Catch:{ all -> 0x00ce }
            boolean r10 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x00ce }
            if (r10 != 0) goto L_0x00fe
            boolean r10 = r8.contains(r1)     // Catch:{ all -> 0x00ce }
            if (r10 == 0) goto L_0x00fe
            boolean r10 = r8.contains(r0)     // Catch:{ all -> 0x00ce }
            if (r10 == 0) goto L_0x00fe
            int r1 = r8.indexOf(r1)     // Catch:{ all -> 0x00ce }
            int r0 = r8.indexOf(r0)     // Catch:{ all -> 0x00ce }
            int r1 = r1 + 4
            if (r0 <= r1) goto L_0x00fe
            java.lang.String r0 = r8.substring(r1, r0)     // Catch:{ all -> 0x00ce }
            java.lang.String r0 = r0.trim()     // Catch:{ all -> 0x00ce }
            goto L_0x00ff
        L_0x00fe:
            r0 = r4
        L_0x00ff:
            java.lang.String r1 = "get token exception on the AGC! "
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x00ce }
            java.lang.String r1 = r1.concat(r8)     // Catch:{ all -> 0x00ce }
            com.huawei.hms.analytics.core.log.HiLog.e(r6, r2, r1)     // Catch:{ all -> 0x00ce }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x00ce }
            java.lang.String r0 = r2.concat(r0)     // Catch:{ all -> 0x00ce }
            java.util.concurrent.CountDownLatch r1 = r12.klm
            if (r1 == 0) goto L_0x011b
            r1.countDown()
        L_0x011b:
            boolean r1 = r3.equalsIgnoreCase(r5)
            if (r1 != 0) goto L_0x013c
        L_0x0121:
            r7.lmn = r5
            r7.klm = r0
            goto L_0x00c7
        L_0x0126:
            r9 = r4
        L_0x0127:
            java.lang.String r0 = "agc class not found"
            com.huawei.hms.analytics.core.log.HiLog.e(r6, r2, r0)     // Catch:{ all -> 0x00ce }
            java.lang.String r0 = "SE-003:004"
            java.util.concurrent.CountDownLatch r1 = r12.klm
            if (r1 == 0) goto L_0x0135
            r1.countDown()
        L_0x0135:
            boolean r1 = r3.equalsIgnoreCase(r5)
            if (r1 != 0) goto L_0x013c
            goto L_0x0121
        L_0x013c:
            return r9
        L_0x013d:
            java.util.concurrent.CountDownLatch r1 = r12.klm
            if (r1 == 0) goto L_0x0144
            r1.countDown()
        L_0x0144:
            boolean r1 = r3.equalsIgnoreCase(r5)
            if (r1 != 0) goto L_0x0151
            r7.lmn = r5
            r7.klm = r4
            com.huawei.hms.analytics.ck.lmn((com.huawei.hms.analytics.cj) r7)
        L_0x0151:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.analytics.dy.lmn():java.lang.String");
    }
}
