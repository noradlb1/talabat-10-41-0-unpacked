package com.huawei.hms.dtm.core.util;

import com.google.common.base.Ascii;
import com.huawei.hms.dtm.core.C0435sc;
import com.huawei.hms.dtm.core.Cc;
import com.huawei.hms.dtm.core.V;
import com.huawei.hms.dtm.core.safe.SafeBase64;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public final class g {
    public static C0435sc<?> a(byte[] bArr, String str, int i11) {
        if ("base16".equals(str)) {
            return new Cc(a(bArr));
        }
        if ("base64".equals(str)) {
            return new Cc(new String(SafeBase64.encode(bArr, i11), StandardCharsets.UTF_8));
        }
        if ("base64url".equals(str)) {
            return new Cc(new String(SafeBase64.encode(bArr, i11 | 8), StandardCharsets.UTF_8));
        }
        throw new V("__codec#illegal encode type:" + str);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:12|11|13|14|15|16|17|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002b, code lost:
        r3 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0023 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.graphics.Bitmap r3) {
        /*
            if (r3 != 0) goto L_0x0005
            java.lang.String r3 = ""
            return r3
        L_0x0005:
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0023 }
            r1.<init>()     // Catch:{ Exception -> 0x0023 }
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ Exception -> 0x0022, all -> 0x001f }
            r2 = 100
            r3.compress(r0, r2, r1)     // Catch:{ Exception -> 0x0022, all -> 0x001f }
            byte[] r3 = r1.toByteArray()     // Catch:{ Exception -> 0x0022, all -> 0x001f }
            r0 = 2
            java.lang.String r3 = com.huawei.hms.dtm.core.safe.SafeBase64.encodeToString(r3, r0)     // Catch:{ Exception -> 0x0022, all -> 0x001f }
            com.huawei.hms.dtm.core.util.k.a(r1)
            return r3
        L_0x001f:
            r3 = move-exception
            r0 = r1
            goto L_0x002c
        L_0x0022:
            r0 = r1
        L_0x0023:
            com.huawei.hms.dtm.core.V r3 = new com.huawei.hms.dtm.core.V     // Catch:{ all -> 0x002b }
            java.lang.String r1 = "getString#exception"
            r3.<init>(r1)     // Catch:{ all -> 0x002b }
            throw r3     // Catch:{ all -> 0x002b }
        L_0x002b:
            r3 = move-exception
        L_0x002c:
            com.huawei.hms.dtm.core.util.k.a(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.dtm.core.util.g.a(android.graphics.Bitmap):java.lang.String");
    }

    public static String a(String str, String str2) {
        char[] charArray = new String(str.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1).toCharArray();
        StringBuilder sb2 = new StringBuilder();
        for (char c11 : charArray) {
            if (a(c11, str2)) {
                sb2.append(c11);
            } else {
                sb2.append("%");
                sb2.append(Integer.toHexString(c11).toUpperCase(Locale.ENGLISH));
            }
        }
        return sb2.toString();
    }

    public static String a(byte[] bArr) {
        if (bArr != null) {
            StringBuilder sb2 = new StringBuilder(bArr.length * 2);
            for (byte b11 : bArr) {
                sb2.append(Integer.toHexString((b11 >> 4) & 15));
                sb2.append(Integer.toHexString(b11 & Ascii.SI));
            }
            return sb2.toString().toUpperCase(Locale.ENGLISH);
        }
        throw new V("b16Encode input is null");
    }

    private static boolean a(char c11, String str) {
        if (c11 >= 'a' && c11 <= 'z') {
            return true;
        }
        if (c11 < 'A' || c11 > 'Z') {
            return (c11 >= '0' && c11 <= '9') || str.indexOf(c11) >= 0;
        }
        return true;
    }

    public static byte[] a(String str) {
        if (str.length() % 2 == 0) {
            int length = str.length();
            byte[] bArr = new byte[(length / 2)];
            int i11 = 0;
            int i12 = 0;
            while (i11 < length) {
                int i13 = i11 + 1;
                bArr[i12] = (byte) ((Character.digit(str.charAt(i11), 16) << 4) | Character.digit(str.charAt(i13), 16));
                i12++;
                i11 = i13 + 1;
            }
            return bArr;
        }
        throw new V("base16 input length must be even");
    }

    public static byte[] a(String str, String str2, int i11) {
        try {
            return "utf-8".equals(str2) ? str.getBytes(StandardCharsets.UTF_8) : "base16".equals(str2) ? a(str) : "base64".equals(str2) ? SafeBase64.decode(str, i11) : "base64url".equals(str2) ? SafeBase64.decode(str, i11 | 8) : new byte[0];
        } catch (Exception unused) {
            throw new V("__codec#illegal decode type");
        }
    }
}
