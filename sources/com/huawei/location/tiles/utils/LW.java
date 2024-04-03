package com.huawei.location.tiles.utils;

import com.checkout.frames.utils.constants.ExpiryDateConstantsKt;
import net.bytebuddy.asm.Advice;

public class LW {
    private static final char[] Vw = {'0', ExpiryDateConstantsKt.EXPIRY_DATE_ZERO_POSITION_CHECK, '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL, 'e', 'f'};

    /* renamed from: yn  reason: collision with root package name */
    private static final String f50263yn = "LW";

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0072, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x007b, code lost:
        throw r9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00b8 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String yn(java.lang.String r8, java.lang.String r9) {
        /*
            java.lang.String r8 = com.huawei.location.tiles.utils.yn.yn((java.lang.String) r8)
            java.io.File r0 = new java.io.File
            r0.<init>(r8)
            java.lang.String r8 = "UTF-8"
            java.nio.charset.Charset r8 = java.nio.charset.Charset.forName(r8)
            byte[] r8 = r9.getBytes(r8)
            java.lang.String r9 = "SHA-256"
            boolean r1 = r0.exists()
            r2 = 0
            r3 = 0
            if (r1 != 0) goto L_0x0026
            java.lang.String r8 = f50263yn
            java.lang.String r9 = "file not exist"
        L_0x0021:
            com.huawei.location.lite.common.log.LogConsole.e(r8, r9)
            goto L_0x008b
        L_0x0026:
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ NoSuchAlgorithmException -> 0x0086, FileNotFoundException -> 0x0081, IOException -> 0x007c }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ NoSuchAlgorithmException -> 0x0086, FileNotFoundException -> 0x0081, IOException -> 0x007c }
            r4.<init>(r0)     // Catch:{ NoSuchAlgorithmException -> 0x0086, FileNotFoundException -> 0x0081, IOException -> 0x007c }
            r1.<init>(r4)     // Catch:{ NoSuchAlgorithmException -> 0x0086, FileNotFoundException -> 0x0081, IOException -> 0x007c }
            java.security.MessageDigest r9 = java.security.MessageDigest.getInstance(r9)     // Catch:{ all -> 0x0070 }
            r0 = 8192(0x2000, float:1.14794E-41)
            byte[] r4 = new byte[r0]     // Catch:{ all -> 0x0070 }
            int r5 = r1.read(r4)     // Catch:{ all -> 0x0070 }
            r6 = r2
        L_0x003d:
            r7 = -1
            if (r5 == r7) goto L_0x0049
            r9.update(r4, r2, r5)     // Catch:{ all -> 0x0070 }
            int r6 = r6 + r5
            int r5 = r1.read(r4)     // Catch:{ all -> 0x0070 }
            goto L_0x003d
        L_0x0049:
            if (r6 <= 0) goto L_0x006c
            if (r8 == 0) goto L_0x0064
            int r4 = r8.length     // Catch:{ all -> 0x0070 }
            if (r4 <= 0) goto L_0x0064
            r4 = r2
        L_0x0051:
            int r5 = r8.length     // Catch:{ all -> 0x0070 }
            if (r4 >= r5) goto L_0x0064
            int r5 = r4 + 8192
            int r6 = r8.length     // Catch:{ all -> 0x0070 }
            if (r5 > r6) goto L_0x005d
            r9.update(r8, r4, r0)     // Catch:{ all -> 0x0070 }
            goto L_0x0062
        L_0x005d:
            int r6 = r8.length     // Catch:{ all -> 0x0070 }
            int r6 = r6 - r4
            r9.update(r8, r4, r6)     // Catch:{ all -> 0x0070 }
        L_0x0062:
            r4 = r5
            goto L_0x0051
        L_0x0064:
            byte[] r8 = r9.digest()     // Catch:{ all -> 0x0070 }
            r1.close()     // Catch:{ NoSuchAlgorithmException -> 0x0086, FileNotFoundException -> 0x0081, IOException -> 0x007c }
            goto L_0x008c
        L_0x006c:
            r1.close()     // Catch:{ NoSuchAlgorithmException -> 0x0086, FileNotFoundException -> 0x0081, IOException -> 0x007c }
            goto L_0x008b
        L_0x0070:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x0072 }
        L_0x0072:
            r9 = move-exception
            r1.close()     // Catch:{ all -> 0x0077 }
            goto L_0x007b
        L_0x0077:
            r0 = move-exception
            r8.addSuppressed(r0)     // Catch:{ NoSuchAlgorithmException -> 0x0086, FileNotFoundException -> 0x0081, IOException -> 0x007c }
        L_0x007b:
            throw r9     // Catch:{ NoSuchAlgorithmException -> 0x0086, FileNotFoundException -> 0x0081, IOException -> 0x007c }
        L_0x007c:
            java.lang.String r8 = f50263yn
            java.lang.String r9 = "IOException."
            goto L_0x0021
        L_0x0081:
            java.lang.String r8 = f50263yn
            java.lang.String r9 = "FileNotFoundException."
            goto L_0x0021
        L_0x0086:
            java.lang.String r8 = f50263yn
            java.lang.String r9 = "NoSuchAlgorithmException."
            goto L_0x0021
        L_0x008b:
            r8 = r3
        L_0x008c:
            if (r8 == 0) goto L_0x00b8
            int r9 = r8.length
            if (r9 <= 0) goto L_0x00b8
            java.lang.String r9 = new java.lang.String
            int r0 = r8.length
            int r1 = r0 << 1
            char[] r1 = new char[r1]
            r3 = r2
        L_0x0099:
            if (r2 >= r0) goto L_0x00b4
            int r4 = r3 + 1
            char[] r5 = Vw
            byte r6 = r8[r2]
            r7 = r6 & 240(0xf0, float:3.36E-43)
            int r7 = r7 >>> 4
            char r7 = r5[r7]
            r1[r3] = r7
            int r3 = r4 + 1
            r6 = r6 & 15
            char r5 = r5[r6]
            r1[r4] = r5
            int r2 = r2 + 1
            goto L_0x0099
        L_0x00b4:
            r9.<init>(r1)
            return r9
        L_0x00b8:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.tiles.utils.LW.yn(java.lang.String, java.lang.String):java.lang.String");
    }
}
