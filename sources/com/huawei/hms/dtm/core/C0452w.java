package com.huawei.hms.dtm.core;

import com.adjust.sdk.Constants;
import com.checkout.frames.utils.constants.ExpiryDateConstantsKt;
import com.google.common.base.Ascii;
import com.huawei.hms.dtm.core.util.Logger;
import com.huawei.hms.dtm.core.util.k;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import net.bytebuddy.asm.Advice;

/* renamed from: com.huawei.hms.dtm.core.w  reason: case insensitive filesystem */
public final class C0452w {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f48627a = {Constants.SHA256, "SHA-384", "SHA-512"};

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f48628b = {'0', ExpiryDateConstantsKt.EXPIRY_DATE_ZERO_POSITION_CHECK, '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL, 'e', 'f'};

    public static String a(File file) {
        return a(file, Constants.SHA256);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v4, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(java.io.File r6, java.lang.String r7) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            java.lang.String r1 = ""
            java.lang.String r2 = "HMS-DTM"
            if (r0 != 0) goto L_0x005a
            boolean r0 = a((java.lang.String) r7)
            if (r0 != 0) goto L_0x0011
            goto L_0x005a
        L_0x0011:
            boolean r0 = b(r6)
            if (r0 != 0) goto L_0x001d
            java.lang.String r6 = "file is not valid"
        L_0x0019:
            com.huawei.hms.dtm.core.util.Logger.error(r2, r6)
            return r1
        L_0x001d:
            r0 = 0
            java.security.MessageDigest r7 = java.security.MessageDigest.getInstance(r7)     // Catch:{ NoSuchAlgorithmException -> 0x004a, IOException -> 0x0046, all -> 0x0044 }
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ NoSuchAlgorithmException -> 0x004a, IOException -> 0x0046, all -> 0x0044 }
            r1.<init>(r6)     // Catch:{ NoSuchAlgorithmException -> 0x004a, IOException -> 0x0046, all -> 0x0044 }
            r6 = 8192(0x2000, float:1.14794E-41)
            byte[] r6 = new byte[r6]     // Catch:{ NoSuchAlgorithmException -> 0x004b, IOException -> 0x0047 }
            r3 = 0
            r4 = r3
        L_0x002d:
            int r5 = r1.read(r6)     // Catch:{ NoSuchAlgorithmException -> 0x004b, IOException -> 0x0047 }
            if (r5 <= 0) goto L_0x0038
            r7.update(r6, r3, r5)     // Catch:{ NoSuchAlgorithmException -> 0x004b, IOException -> 0x0047 }
            r4 = 1
            goto L_0x002d
        L_0x0038:
            if (r4 == 0) goto L_0x0050
            byte[] r6 = r7.digest()     // Catch:{ NoSuchAlgorithmException -> 0x004b, IOException -> 0x0047 }
            java.lang.String r6 = a((byte[]) r6)     // Catch:{ NoSuchAlgorithmException -> 0x004b, IOException -> 0x0047 }
            r0 = r6
            goto L_0x0050
        L_0x0044:
            r6 = move-exception
            goto L_0x0056
        L_0x0046:
            r1 = r0
        L_0x0047:
            java.lang.String r6 = "IOException in fileSHAEncrypt"
            goto L_0x004d
        L_0x004a:
            r1 = r0
        L_0x004b:
            java.lang.String r6 = "NoSuchAlgorithmException in fileSHAEncrypt"
        L_0x004d:
            com.huawei.hms.dtm.core.util.Logger.error(r2, r6)     // Catch:{ all -> 0x0054 }
        L_0x0050:
            com.huawei.hms.dtm.core.util.k.a(r1)
            return r0
        L_0x0054:
            r6 = move-exception
            r0 = r1
        L_0x0056:
            com.huawei.hms.dtm.core.util.k.a(r0)
            throw r6
        L_0x005a:
            java.lang.String r6 = "algorithm is empty or not safe"
            goto L_0x0019
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.dtm.core.C0452w.a(java.io.File, java.lang.String):java.lang.String");
    }

    public static String a(InputStream inputStream) {
        return inputStream == null ? "" : a(inputStream, Constants.SHA256);
    }

    private static String a(InputStream inputStream, String str) {
        if (inputStream == null) {
            return "";
        }
        byte[] bArr = new byte[8192];
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            while (true) {
                int read = inputStream.read(bArr);
                if (read < 0) {
                    return a(instance.digest());
                }
                if (read > 0) {
                    instance.update(bArr, 0, read);
                }
            }
        } catch (IOException | NoSuchAlgorithmException unused) {
            Logger.error("HMS-DTM", "inputstraem exception");
            return "";
        } finally {
            k.a(inputStream);
        }
    }

    private static String a(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (byte b11 : bArr) {
            char[] cArr = f48628b;
            sb2.append(cArr[(b11 >> 4) & 15]);
            sb2.append(cArr[b11 & Ascii.SI]);
        }
        return sb2.toString();
    }

    private static boolean a(String str) {
        for (String equals : f48627a) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private static boolean b(File file) {
        return file != null && file.exists() && file.length() > 0;
    }
}
