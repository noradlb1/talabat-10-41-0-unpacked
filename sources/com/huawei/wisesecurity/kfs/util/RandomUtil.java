package com.huawei.wisesecurity.kfs.util;

public final class RandomUtil {
    public static final String TAG = "RandomUtil";

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] generateRandomBytes(int r4) {
        /*
            java.lang.String r0 = "RandomUtil"
            byte[] r4 = new byte[r4]
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ NoSuchAlgorithmException -> 0x000f }
            r2 = 26
            if (r1 < r2) goto L_0x0014
            java.security.SecureRandom r1 = java.security.SecureRandom.getInstanceStrong()     // Catch:{ NoSuchAlgorithmException -> 0x000f }
            goto L_0x0015
        L_0x000f:
            java.lang.String r1 = "getSecureRandomBytes: NoSuchAlgorithmException"
            android.util.Log.e(r0, r1)
        L_0x0014:
            r1 = 0
        L_0x0015:
            if (r1 != 0) goto L_0x001d
            java.lang.String r1 = "SHA1PRNG"
            java.security.SecureRandom r1 = java.security.SecureRandom.getInstance(r1)     // Catch:{ NoSuchAlgorithmException -> 0x0038, Exception -> 0x0021 }
        L_0x001d:
            r1.nextBytes(r4)     // Catch:{ NoSuchAlgorithmException -> 0x0038, Exception -> 0x0021 }
            return r4
        L_0x0021:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "getSecureRandomBytes getInstance: exception : "
            r2.append(r3)
            java.lang.String r1 = r1.getMessage()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            goto L_0x003a
        L_0x0038:
            java.lang.String r1 = "getSecureRandomBytes getInstance: NoSuchAlgorithmException"
        L_0x003a:
            android.util.Log.e(r0, r1)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.wisesecurity.kfs.util.RandomUtil.generateRandomBytes(int):byte[]");
    }
}
