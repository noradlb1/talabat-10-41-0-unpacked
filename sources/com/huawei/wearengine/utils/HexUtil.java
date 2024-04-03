package com.huawei.wearengine.utils;

import com.checkout.frames.utils.constants.ExpiryDateConstantsKt;
import com.google.common.base.Ascii;
import net.bytebuddy.asm.Advice;

public final class HexUtil {
    private static final int BIT_OFFSET = 4;
    private static final int BUFFER_SIZE = 1024;
    private static final char[] DIGITS_LOWER = {'0', ExpiryDateConstantsKt.EXPIRY_DATE_ZERO_POSITION_CHECK, '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL, 'e', 'f'};
    private static final char[] DIGITS_UPPER = {'0', ExpiryDateConstantsKt.EXPIRY_DATE_ZERO_POSITION_CHECK, '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final int FILE_STREAM_END = -1;
    private static final int HIGH_BIT_CONVERTER = 240;
    private static final int LOW_BIT_CONVERTER = 15;
    private static final String SHA256_NAME = "SHA-256";
    private static final String TAG = "HexUtil";

    private HexUtil() {
    }

    private static char[] encodeHex(byte[] bArr, boolean z11) {
        return encodeHex(bArr, z11 ? DIGITS_UPPER : DIGITS_LOWER);
    }

    private static char[] encodeHex(byte[] bArr, char[] cArr) {
        char[] cArr2 = new char[(r0 << 1)];
        int i11 = 0;
        for (byte b11 : bArr) {
            int i12 = i11 + 1;
            cArr2[i11] = cArr[(b11 & 240) >>> 4];
            i11 = i12 + 1;
            cArr2[i12] = cArr[b11 & Ascii.SI];
        }
        return cArr2;
    }

    public static String encodeHexString(byte[] bArr, boolean z11) {
        return new String(encodeHex(bArr, z11));
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0053 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getFileShaHex(java.io.File r7) {
        /*
            java.lang.String r0 = "getFileShaHex IOException"
            boolean r1 = r7.exists()
            r2 = 0
            java.lang.String r3 = "HexUtil"
            if (r1 != 0) goto L_0x0011
            java.lang.String r7 = "getFileShaHex file not exit"
            com.huawei.wearengine.common.a.a((java.lang.String) r3, (java.lang.String) r7)
            return r2
        L_0x0011:
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0017 }
            r1.<init>(r7)     // Catch:{ FileNotFoundException -> 0x0017 }
            goto L_0x001d
        L_0x0017:
            java.lang.String r7 = "getFileShaHex FileNotFoundException"
            com.huawei.wearengine.common.a.a((java.lang.String) r3, (java.lang.String) r7)
            r1 = r2
        L_0x001d:
            if (r1 != 0) goto L_0x0020
            return r2
        L_0x0020:
            java.lang.String r7 = "SHA-256"
            java.security.MessageDigest r7 = java.security.MessageDigest.getInstance(r7)     // Catch:{ NoSuchAlgorithmException -> 0x005a, IOException -> 0x0053 }
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch:{ NoSuchAlgorithmException -> 0x005a, IOException -> 0x0053 }
            int r4 = r1.read(r2)     // Catch:{ NoSuchAlgorithmException -> 0x005a, IOException -> 0x0053 }
            r5 = -1
            r6 = 0
            if (r4 != r5) goto L_0x0036
            r7.update(r2, r6, r6)     // Catch:{ NoSuchAlgorithmException -> 0x005a, IOException -> 0x0053 }
            goto L_0x0040
        L_0x0036:
            r7.update(r2, r6, r4)     // Catch:{ NoSuchAlgorithmException -> 0x005a, IOException -> 0x0053 }
            int r4 = r1.read(r2)     // Catch:{ NoSuchAlgorithmException -> 0x005a, IOException -> 0x0053 }
            if (r4 == r5) goto L_0x0040
            goto L_0x0036
        L_0x0040:
            byte[] r7 = r7.digest()     // Catch:{ NoSuchAlgorithmException -> 0x005a, IOException -> 0x0053 }
            r2 = 1
            java.lang.String r7 = encodeHexString(r7, r2)     // Catch:{ NoSuchAlgorithmException -> 0x005a, IOException -> 0x0053 }
            r1.close()     // Catch:{ IOException -> 0x004d }
            goto L_0x0050
        L_0x004d:
            com.huawei.wearengine.common.a.a((java.lang.String) r3, (java.lang.String) r0)
        L_0x0050:
            return r7
        L_0x0051:
            r7 = move-exception
            goto L_0x0066
        L_0x0053:
            com.huawei.wearengine.common.a.a((java.lang.String) r3, (java.lang.String) r0)     // Catch:{ all -> 0x0051 }
        L_0x0056:
            r1.close()     // Catch:{ IOException -> 0x0060 }
            goto L_0x0063
        L_0x005a:
            java.lang.String r7 = "getFileShaHex NoSuchAlgorithmException"
            com.huawei.wearengine.common.a.a((java.lang.String) r3, (java.lang.String) r7)     // Catch:{ all -> 0x0051 }
            goto L_0x0056
        L_0x0060:
            com.huawei.wearengine.common.a.a((java.lang.String) r3, (java.lang.String) r0)
        L_0x0063:
            java.lang.String r7 = ""
            return r7
        L_0x0066:
            r1.close()     // Catch:{ IOException -> 0x006a }
            goto L_0x006d
        L_0x006a:
            com.huawei.wearengine.common.a.a((java.lang.String) r3, (java.lang.String) r0)
        L_0x006d:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.wearengine.utils.HexUtil.getFileShaHex(java.io.File):java.lang.String");
    }
}
