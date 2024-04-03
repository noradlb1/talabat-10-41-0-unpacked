package com.huawei.secure.android.common.encrypt.hash;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.File;
import java.io.InputStream;

public abstract class FileSHA256 {

    /* renamed from: a  reason: collision with root package name */
    private static final int f33738a = 8192;

    /* renamed from: b  reason: collision with root package name */
    private static final String f33739b = "SHA-256";

    /* renamed from: c  reason: collision with root package name */
    private static final String f33740c = "FileSHA256";

    /* renamed from: d  reason: collision with root package name */
    private static final String f33741d = "";

    /* renamed from: e  reason: collision with root package name */
    private static final String[] f33742e = {"SHA-256", "SHA-384", "SHA-512"};

    private static boolean a(File file) {
        return file != null && file.exists() && file.length() > 0;
    }

    public static String fileSHA256Encrypt(File file) {
        return fileSHAEncrypt(file, "SHA-256");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v4, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String fileSHAEncrypt(java.io.File r5, java.lang.String r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0091
            boolean r0 = a((java.lang.String) r6)
            if (r0 != 0) goto L_0x0010
            goto L_0x0091
        L_0x0010:
            boolean r0 = a((java.io.File) r5)
            if (r0 != 0) goto L_0x001e
            java.lang.String r5 = f33740c
            java.lang.String r6 = "file is not valid"
            com.huawei.secure.android.common.encrypt.utils.b.b(r5, r6)
            return r1
        L_0x001e:
            r0 = 0
            java.security.MessageDigest r6 = java.security.MessageDigest.getInstance(r6)     // Catch:{ NoSuchAlgorithmException -> 0x006b, IOException -> 0x004e, all -> 0x004c }
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ NoSuchAlgorithmException -> 0x006b, IOException -> 0x004e, all -> 0x004c }
            r1.<init>(r5)     // Catch:{ NoSuchAlgorithmException -> 0x006b, IOException -> 0x004e, all -> 0x004c }
            r5 = 8192(0x2000, float:1.14794E-41)
            byte[] r5 = new byte[r5]     // Catch:{ NoSuchAlgorithmException -> 0x004a, IOException -> 0x0048 }
            r2 = 0
            r3 = r2
        L_0x002e:
            int r4 = r1.read(r5)     // Catch:{ NoSuchAlgorithmException -> 0x004a, IOException -> 0x0048 }
            if (r4 <= 0) goto L_0x0039
            r6.update(r5, r2, r4)     // Catch:{ NoSuchAlgorithmException -> 0x004a, IOException -> 0x0048 }
            r3 = 1
            goto L_0x002e
        L_0x0039:
            if (r3 == 0) goto L_0x0044
            byte[] r5 = r6.digest()     // Catch:{ NoSuchAlgorithmException -> 0x004a, IOException -> 0x0048 }
            java.lang.String r5 = com.huawei.secure.android.common.encrypt.utils.HexUtil.byteArray2HexStr((byte[]) r5)     // Catch:{ NoSuchAlgorithmException -> 0x004a, IOException -> 0x0048 }
            r0 = r5
        L_0x0044:
            com.huawei.secure.android.common.encrypt.utils.a.a((java.io.InputStream) r1)
            goto L_0x008a
        L_0x0048:
            r5 = move-exception
            goto L_0x0050
        L_0x004a:
            r5 = move-exception
            goto L_0x006d
        L_0x004c:
            r5 = move-exception
            goto L_0x008d
        L_0x004e:
            r5 = move-exception
            r1 = r0
        L_0x0050:
            java.lang.String r6 = f33740c     // Catch:{ all -> 0x008b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x008b }
            r2.<init>()     // Catch:{ all -> 0x008b }
            java.lang.String r3 = "IOException"
            r2.append(r3)     // Catch:{ all -> 0x008b }
            java.lang.String r5 = r5.getMessage()     // Catch:{ all -> 0x008b }
            r2.append(r5)     // Catch:{ all -> 0x008b }
            java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x008b }
            com.huawei.secure.android.common.encrypt.utils.b.b(r6, r5)     // Catch:{ all -> 0x008b }
            goto L_0x0087
        L_0x006b:
            r5 = move-exception
            r1 = r0
        L_0x006d:
            java.lang.String r6 = f33740c     // Catch:{ all -> 0x008b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x008b }
            r2.<init>()     // Catch:{ all -> 0x008b }
            java.lang.String r3 = "NoSuchAlgorithmException"
            r2.append(r3)     // Catch:{ all -> 0x008b }
            java.lang.String r5 = r5.getMessage()     // Catch:{ all -> 0x008b }
            r2.append(r5)     // Catch:{ all -> 0x008b }
            java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x008b }
            com.huawei.secure.android.common.encrypt.utils.b.b(r6, r5)     // Catch:{ all -> 0x008b }
        L_0x0087:
            com.huawei.secure.android.common.encrypt.utils.a.a((java.io.InputStream) r1)
        L_0x008a:
            return r0
        L_0x008b:
            r5 = move-exception
            r0 = r1
        L_0x008d:
            com.huawei.secure.android.common.encrypt.utils.a.a((java.io.InputStream) r0)
            throw r5
        L_0x0091:
            java.lang.String r5 = f33740c
            java.lang.String r6 = "algorithm is empty or not safe"
            com.huawei.secure.android.common.encrypt.utils.b.b(r5, r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.encrypt.hash.FileSHA256.fileSHAEncrypt(java.io.File, java.lang.String):java.lang.String");
    }

    public static String inputStreamSHA256Encrypt(InputStream inputStream) {
        if (inputStream == null) {
            return "";
        }
        return inputStreamSHAEncrypt(inputStream, "SHA-256");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0026, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        com.huawei.secure.android.common.encrypt.utils.b.b(f33740c, "inputstraem exception");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0032, code lost:
        return "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0033, code lost:
        com.huawei.secure.android.common.encrypt.utils.a.a(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0036, code lost:
        throw r5;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0028 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String inputStreamSHAEncrypt(java.io.InputStream r4, java.lang.String r5) {
        /*
            java.lang.String r0 = ""
            if (r4 != 0) goto L_0x0005
            return r0
        L_0x0005:
            r1 = 8192(0x2000, float:1.14794E-41)
            byte[] r1 = new byte[r1]
            java.security.MessageDigest r5 = java.security.MessageDigest.getInstance(r5)     // Catch:{ IOException | NoSuchAlgorithmException -> 0x0028 }
        L_0x000d:
            int r2 = r4.read(r1)     // Catch:{ IOException | NoSuchAlgorithmException -> 0x0028 }
            if (r2 < 0) goto L_0x001a
            if (r2 <= 0) goto L_0x000d
            r3 = 0
            r5.update(r1, r3, r2)     // Catch:{ IOException | NoSuchAlgorithmException -> 0x0028 }
            goto L_0x000d
        L_0x001a:
            byte[] r5 = r5.digest()     // Catch:{ IOException | NoSuchAlgorithmException -> 0x0028 }
            java.lang.String r5 = com.huawei.secure.android.common.encrypt.utils.HexUtil.byteArray2HexStr((byte[]) r5)     // Catch:{ IOException | NoSuchAlgorithmException -> 0x0028 }
            com.huawei.secure.android.common.encrypt.utils.a.a((java.io.InputStream) r4)
            return r5
        L_0x0026:
            r5 = move-exception
            goto L_0x0033
        L_0x0028:
            java.lang.String r5 = f33740c     // Catch:{ all -> 0x0026 }
            java.lang.String r1 = "inputstraem exception"
            com.huawei.secure.android.common.encrypt.utils.b.b(r5, r1)     // Catch:{ all -> 0x0026 }
            com.huawei.secure.android.common.encrypt.utils.a.a((java.io.InputStream) r4)
            return r0
        L_0x0033:
            com.huawei.secure.android.common.encrypt.utils.a.a((java.io.InputStream) r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.encrypt.hash.FileSHA256.inputStreamSHAEncrypt(java.io.InputStream, java.lang.String):java.lang.String");
    }

    public static boolean validateFileSHA(File file, String str, String str2) {
        if (!TextUtils.isEmpty(str) && a(str2)) {
            return str.equals(fileSHAEncrypt(file, str2));
        }
        b.b(f33740c, "hash value is null || algorithm is illegal");
        return false;
    }

    public static boolean validateFileSHA256(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equalsIgnoreCase(fileSHA256Encrypt(file));
    }

    public static boolean validateInputStreamSHA(InputStream inputStream, String str, String str2) {
        if (!TextUtils.isEmpty(str) && a(str2)) {
            return str.equals(inputStreamSHAEncrypt(inputStream, str2));
        }
        b.b(f33740c, "hash value is null || algorithm is illegal");
        return false;
    }

    public static boolean validateInputStreamSHA256(InputStream inputStream, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals(inputStreamSHA256Encrypt(inputStream));
    }

    private static boolean a(String str) {
        for (String equals : f33742e) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
