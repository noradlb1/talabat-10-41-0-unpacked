package com.huawei.hms.analytics;

import android.text.TextUtils;
import com.huawei.hms.analytics.core.crypto.AesCipher;
import com.huawei.hms.analytics.core.crypto.HAHexUtil;
import com.huawei.hms.analytics.core.crypto.PBKDF2encrypt;
import com.huawei.hms.analytics.core.crypto.RandomUtil;
import com.huawei.hms.analytics.core.log.HiLog;
import java.util.List;

public final class bs {
    private static final Object ijk = new Object();
    private static final Object ikl = new Object();
    private static bs klm;
    private String ghi;
    private String hij;
    public List<lmn> lmn;

    public interface lmn {
        void klm(String str);
    }

    private static boolean fgh() {
        return true;
    }

    private String ghi() {
        String str;
        String str2;
        String str3;
        String str4;
        if (TextUtils.isEmpty(this.hij)) {
            synchronized (ijk) {
                if (TextUtils.isEmpty(this.hij)) {
                    br brVar = new br();
                    long klm2 = dv.klm(brVar.lmn, "Privacy_MY", "assemblyFlash");
                    boolean z11 = true;
                    if (-1 == klm2) {
                        HiLog.i("ComponentCommander", "First init components");
                    } else if (System.currentTimeMillis() - klm2 <= 31536000000L) {
                        z11 = false;
                    }
                    if (z11) {
                        HiLog.i("ComponentCommander", "refresh components");
                        str4 = RandomUtil.getInstance().generateSecureRandomStr(128);
                        brVar.lmn("aprpap", str4);
                        str3 = RandomUtil.getInstance().generateSecureRandomStr(128);
                        brVar.lmn("febdoc", str3);
                        str2 = RandomUtil.getInstance().generateSecureRandomStr(128);
                        brVar.lmn("marfil", str2);
                        str = RandomUtil.getInstance().generateSecureRandomStr(128);
                        brVar.lmn("maywnj", str);
                        dv.lmn(brVar.lmn, "Privacy_MY", "assemblyFlash", System.currentTimeMillis());
                    } else {
                        str4 = brVar.lmn("aprpap");
                        str3 = brVar.lmn("febdoc");
                        str2 = brVar.lmn("marfil");
                        str = brVar.lmn("maywnj");
                    }
                    byte[] hexString2ByteArray = HAHexUtil.hexString2ByteArray(str4);
                    byte[] hexString2ByteArray2 = HAHexUtil.hexString2ByteArray(str3);
                    byte[] hexString2ByteArray3 = HAHexUtil.hexString2ByteArray(str2);
                    byte[] hexString2ByteArray4 = HAHexUtil.hexString2ByteArray("f6040d0e807aaec325ecf44823765544e92905158169f694b282bf17388632cf95a83bae7d2d235c1f039b0df1dcca5fda619b6f7f459f2ff8d70ddb7b601592fe29fcae58c028f319b3b12495e67aa5390942a997a8cb572c8030b2df5c2b622608bea02b0c3e5d4dff3f72c9e3204049a45c0760cd3604af8d57f0e0c693cc");
                    int length = hexString2ByteArray.length;
                    if (length > hexString2ByteArray2.length) {
                        length = hexString2ByteArray2.length;
                    }
                    if (length > hexString2ByteArray3.length) {
                        length = hexString2ByteArray3.length;
                    }
                    if (length > hexString2ByteArray4.length) {
                        length = hexString2ByteArray4.length;
                    }
                    char[] cArr = new char[length];
                    for (int i11 = 0; i11 < length; i11++) {
                        cArr[i11] = (char) (((hexString2ByteArray[i11] ^ hexString2ByteArray2[i11]) ^ hexString2ByteArray3[i11]) ^ hexString2ByteArray4[i11]);
                    }
                    this.hij = HAHexUtil.byteArray2HexString(PBKDF2encrypt.pbkdf2(cArr, HAHexUtil.hexString2ByteArray(str), 10000, 128));
                }
            }
        }
        return this.hij;
    }

    private static synchronized void hij() {
        synchronized (bs.class) {
            if (klm == null) {
                klm = new bs();
            }
        }
    }

    public static boolean ikl() {
        long klm2 = dv.klm(av.lmn().lmn.ghi, "Privacy_MY", "flashKeyTime");
        return klm2 != -1 && System.currentTimeMillis() - klm2 > 31536000000L;
    }

    private String klm(String str) {
        if (!fgh()) {
            return AesCipher.encryptCbc(str, ghi());
        }
        HiLog.i("RootKeyCommander", "load work key encrypt is gcm ks");
        return AesCipher.aesKsEncrypt("analytics_keystore", str);
    }

    public static bs lmn() {
        if (klm == null) {
            hij();
        }
        return klm;
    }

    private static void lmn(String str) {
        ax axVar = av.lmn().lmn;
        dv.lmn(axVar.ghi, "Privacy_MY", "PrivacyData", str);
        dv.lmn(axVar.ghi, "Privacy_MY", "flashKeyTime", System.currentTimeMillis());
    }

    public final void ijk() {
        synchronized (ikl) {
            String generateSecureRandomStr = RandomUtil.getInstance().generateSecureRandomStr(16);
            String klm2 = klm(this.ghi);
            if (TextUtils.isEmpty(klm2)) {
                HiLog.e("RootKeyCommander", "New working secret key encryption failed");
                return;
            }
            this.ghi = generateSecureRandomStr;
            lmn(klm2);
            List<lmn> list = this.lmn;
            if (list != null) {
                for (lmn next : list) {
                    if (next != null) {
                        next.klm(generateSecureRandomStr);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0079, code lost:
        if (fgh() != false) goto L_0x007b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String klm() {
        /*
            r5 = this;
            java.lang.Object r0 = ikl
            monitor-enter(r0)
            java.lang.String r1 = r5.ghi     // Catch:{ all -> 0x0094 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0094 }
            if (r1 == 0) goto L_0x0090
            java.lang.String r1 = r5.ghi     // Catch:{ all -> 0x0094 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0094 }
            if (r1 == 0) goto L_0x0090
            com.huawei.hms.analytics.av r1 = com.huawei.hms.analytics.av.lmn()     // Catch:{ all -> 0x0094 }
            com.huawei.hms.analytics.ax r1 = r1.lmn     // Catch:{ all -> 0x0094 }
            android.content.Context r1 = r1.ghi     // Catch:{ all -> 0x0094 }
            java.lang.String r2 = "Privacy_MY"
            java.lang.String r3 = "PrivacyData"
            java.lang.String r4 = ""
            java.lang.String r1 = com.huawei.hms.analytics.dv.klm((android.content.Context) r1, (java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0094 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0094 }
            r3 = 16
            if (r2 == 0) goto L_0x003d
            com.huawei.hms.analytics.core.crypto.RandomUtil r1 = com.huawei.hms.analytics.core.crypto.RandomUtil.getInstance()     // Catch:{ all -> 0x0094 }
            java.lang.String r1 = r1.generateSecureRandomStr(r3)     // Catch:{ all -> 0x0094 }
            java.lang.String r2 = r5.klm(r1)     // Catch:{ all -> 0x0094 }
            lmn(r2)     // Catch:{ all -> 0x0094 }
            goto L_0x008e
        L_0x003d:
            java.lang.String r2 = ""
            boolean r4 = fgh()     // Catch:{ all -> 0x0094 }
            if (r4 == 0) goto L_0x004b
            java.lang.String r2 = "analytics_keystore"
            java.lang.String r2 = com.huawei.hms.analytics.core.crypto.AesCipher.aesKsDecrypt(r2, r1)     // Catch:{ all -> 0x0094 }
        L_0x004b:
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0094 }
            if (r4 == 0) goto L_0x008d
            java.lang.String r2 = "RootKeyCommander"
            java.lang.String r4 = "deCrypt work key first"
            com.huawei.hms.analytics.core.log.HiLog.i(r2, r4)     // Catch:{ all -> 0x0094 }
            java.lang.String r2 = r5.ghi()     // Catch:{ all -> 0x0094 }
            java.lang.String r1 = com.huawei.hms.analytics.core.crypto.AesCipher.decryptCbc(r1, r2)     // Catch:{ all -> 0x0094 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0094 }
            if (r2 == 0) goto L_0x007f
            com.huawei.hms.analytics.core.crypto.RandomUtil r1 = com.huawei.hms.analytics.core.crypto.RandomUtil.getInstance()     // Catch:{ all -> 0x0094 }
            java.lang.String r1 = r1.generateSecureRandomStr(r3)     // Catch:{ all -> 0x0094 }
            java.lang.String r2 = r5.klm(r1)     // Catch:{ all -> 0x0094 }
            lmn(r2)     // Catch:{ all -> 0x0094 }
            boolean r2 = fgh()     // Catch:{ all -> 0x0094 }
            if (r2 == 0) goto L_0x008e
        L_0x007b:
            com.huawei.hms.analytics.br.lmn()     // Catch:{ all -> 0x0094 }
            goto L_0x008e
        L_0x007f:
            boolean r2 = fgh()     // Catch:{ all -> 0x0094 }
            if (r2 == 0) goto L_0x008e
            java.lang.String r2 = r5.klm(r1)     // Catch:{ all -> 0x0094 }
            lmn(r2)     // Catch:{ all -> 0x0094 }
            goto L_0x007b
        L_0x008d:
            r1 = r2
        L_0x008e:
            r5.ghi = r1     // Catch:{ all -> 0x0094 }
        L_0x0090:
            monitor-exit(r0)     // Catch:{ all -> 0x0094 }
            java.lang.String r0 = r5.ghi
            return r0
        L_0x0094:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.analytics.bs.klm():java.lang.String");
    }
}
