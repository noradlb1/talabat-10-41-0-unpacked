package com.huawei.secure.android.common.util;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.RequiresApi;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class ZipUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final String f34007a = "ZipUtil";

    /* renamed from: b  reason: collision with root package name */
    private static final int f34008b = 104857600;

    /* renamed from: c  reason: collision with root package name */
    private static final int f34009c = 100;

    /* renamed from: d  reason: collision with root package name */
    private static final int f34010d = 4096;

    /* renamed from: e  reason: collision with root package name */
    private static final String f34011e = "..";

    /* renamed from: f  reason: collision with root package name */
    private static final String[] f34012f = {"..\\", "../", "./", ".\\.\\", "%00", "..%2F", "..%5C", ".%2F"};

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v0, resolved type: java.util.zip.ZipFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: java.io.FileOutputStream} */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v1 */
    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0181, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0182, code lost:
        r3 = r10;
        r8 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0189, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x018a, code lost:
        r8 = r9;
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x01b4, code lost:
        a((java.util.List<java.io.File>) r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00f2, code lost:
        r8 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        android.util.Log.e(r8, "unzipFileNew: over than top size");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00f9, code lost:
        r9 = null;
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00fc, code lost:
        r0 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0181 A[ExcHandler: all (th java.lang.Throwable), PHI: r11 
      PHI: (r11v2 java.lang.String) = (r11v1 java.lang.String), (r11v1 java.lang.String), (r11v1 java.lang.String), (r11v1 java.lang.String), (r11v1 java.lang.String), (r11v1 java.lang.String), (r11v1 java.lang.String), (r11v1 java.lang.String), (r11v1 java.lang.String), (r11v1 java.lang.String), (r11v4 java.lang.String) binds: [B:16:0x004a, B:19:0x0050, B:94:0x016f, B:95:?, B:21:0x0056, B:41:0x00bf, B:46:0x00cc, B:48:0x00d5, B:50:0x00da, B:53:0x00e1, B:71:0x010e] A[DONT_GENERATE, DONT_INLINE], Splitter:B:16:0x004a] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0189 A[ExcHandler: IOException (e java.io.IOException), PHI: r9 
      PHI: (r9v3 java.lang.String) = (r9v0 java.lang.String), (r9v5 java.lang.String), (r9v5 java.lang.String), (r9v5 java.lang.String) binds: [B:13:0x0044, B:16:0x004a, B:21:0x0056, B:41:0x00bf] A[DONT_GENERATE, DONT_INLINE], Splitter:B:13:0x0044] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x01b4  */
    /* JADX WARNING: Unknown variable types count: 1 */
    @android.annotation.SuppressLint({"NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<java.io.File> a(java.io.File r17, java.io.File r18, long r19, boolean r21, boolean r22) {
        /*
            r1 = r17
            r2 = r18
            r3 = 0
            if (r1 == 0) goto L_0x01b8
            if (r2 != 0) goto L_0x000b
            goto L_0x01b8
        L_0x000b:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.lang.String r9 = "ZipUtil"
            r4 = 1
            if (r22 != 0) goto L_0x0024
            java.util.zip.ZipFile r0 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x001f, all -> 0x001c }
            r0.<init>(r1)     // Catch:{ IOException -> 0x001f, all -> 0x001c }
        L_0x001a:
            r10 = r0
            goto L_0x0044
        L_0x001c:
            r0 = move-exception
            goto L_0x01af
        L_0x001f:
            r0 = move-exception
            r8 = r9
            r9 = 0
            goto L_0x018d
        L_0x0024:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x001f, all -> 0x001c }
            r0.<init>()     // Catch:{ IOException -> 0x001f, all -> 0x001c }
            java.lang.String r5 = "not a utf8 zip file, use gbk open zip file : "
            r0.append(r5)     // Catch:{ IOException -> 0x001f, all -> 0x001c }
            r0.append(r1)     // Catch:{ IOException -> 0x001f, all -> 0x001c }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x001f, all -> 0x001c }
            com.huawei.secure.android.common.util.LogsUtil.i(r9, r0)     // Catch:{ IOException -> 0x001f, all -> 0x001c }
            java.util.zip.ZipFile r0 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x001f, all -> 0x001c }
            java.lang.String r5 = "GBK"
            java.nio.charset.Charset r5 = java.nio.charset.Charset.forName(r5)     // Catch:{ IOException -> 0x001f, all -> 0x001c }
            r0.<init>(r1, r5)     // Catch:{ IOException -> 0x001f, all -> 0x001c }
            goto L_0x001a
        L_0x0044:
            java.util.Enumeration r5 = r10.entries()     // Catch:{ IOException -> 0x0189, all -> 0x0185 }
            r11 = r4
            r4 = 0
        L_0x004a:
            boolean r0 = r5.hasMoreElements()     // Catch:{ IOException -> 0x0189, all -> 0x0181 }
            if (r0 == 0) goto L_0x0177
            java.lang.Object r0 = r5.nextElement()     // Catch:{ IllegalArgumentException -> 0x0136 }
            java.util.zip.ZipEntry r0 = (java.util.zip.ZipEntry) r0     // Catch:{ IllegalArgumentException -> 0x0136 }
            java.lang.String r6 = r0.getName()     // Catch:{ IOException -> 0x0189, all -> 0x0181 }
            boolean r12 = android.text.TextUtils.isEmpty(r6)     // Catch:{ IOException -> 0x0189, all -> 0x0181 }
            if (r12 == 0) goto L_0x0064
        L_0x0060:
            r8 = r9
            r9 = 0
            goto L_0x0172
        L_0x0064:
            java.text.Normalizer$Form r12 = java.text.Normalizer.Form.NFKC     // Catch:{ IOException -> 0x0189, all -> 0x0181 }
            java.lang.String r6 = java.text.Normalizer.normalize(r6, r12)     // Catch:{ IOException -> 0x0189, all -> 0x0181 }
            boolean r12 = e((java.lang.String) r6)     // Catch:{ IOException -> 0x0189, all -> 0x0181 }
            if (r12 == 0) goto L_0x008b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0189, all -> 0x0181 }
            r0.<init>()     // Catch:{ IOException -> 0x0189, all -> 0x0181 }
            java.lang.String r1 = "zipPath is a invalid path: "
            r0.append(r1)     // Catch:{ IOException -> 0x0189, all -> 0x0181 }
            java.lang.String r1 = d((java.lang.String) r6)     // Catch:{ IOException -> 0x0189, all -> 0x0181 }
            r0.append(r1)     // Catch:{ IOException -> 0x0189, all -> 0x0181 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0189, all -> 0x0181 }
            android.util.Log.e(r9, r0)     // Catch:{ IOException -> 0x0189, all -> 0x0181 }
            r8 = 0
            goto L_0x0178
        L_0x008b:
            java.lang.String r12 = "\\\\"
            java.lang.String r13 = "/"
            java.lang.String r6 = r6.replaceAll(r12, r13)     // Catch:{ IOException -> 0x0189, all -> 0x0181 }
            java.io.File r12 = new java.io.File     // Catch:{ IOException -> 0x0189, all -> 0x0181 }
            r12.<init>(r2, r6)     // Catch:{ IOException -> 0x0189, all -> 0x0181 }
            if (r21 == 0) goto L_0x00a9
            boolean r6 = r12.exists()     // Catch:{ IOException -> 0x0189, all -> 0x0181 }
            if (r6 == 0) goto L_0x00a9
            boolean r6 = r12.isFile()     // Catch:{ IOException -> 0x0189, all -> 0x0181 }
            if (r6 == 0) goto L_0x00a9
            e((java.io.File) r12)     // Catch:{ IOException -> 0x0189, all -> 0x0181 }
        L_0x00a9:
            r7.add(r12)     // Catch:{ IOException -> 0x0189, all -> 0x0181 }
            boolean r6 = r0.isDirectory()     // Catch:{ IOException -> 0x0189, all -> 0x0181 }
            if (r6 == 0) goto L_0x00bf
            boolean r0 = a((java.io.File) r12)     // Catch:{ IOException -> 0x0189, all -> 0x0181 }
            if (r0 != 0) goto L_0x0060
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.Closeable) r10)
            a((java.util.List<java.io.File>) r7)
            return r3
        L_0x00bf:
            boolean r6 = b((java.io.File) r12)     // Catch:{ IOException -> 0x0189, all -> 0x0181 }
            if (r6 != 0) goto L_0x00cc
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.Closeable) r10)
            a((java.util.List<java.io.File>) r7)
            return r3
        L_0x00cc:
            java.io.BufferedInputStream r6 = new java.io.BufferedInputStream     // Catch:{ all -> 0x0127 }
            java.io.InputStream r0 = r10.getInputStream(r0)     // Catch:{ all -> 0x0127 }
            r6.<init>(r0)     // Catch:{ all -> 0x0127 }
            java.io.FileOutputStream r13 = new java.io.FileOutputStream     // Catch:{ all -> 0x0122 }
            r13.<init>(r12)     // Catch:{ all -> 0x0122 }
            java.io.BufferedOutputStream r12 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x011c }
            r12.<init>(r13)     // Catch:{ all -> 0x011c }
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0118 }
        L_0x00e3:
            int r14 = r6.read(r0)     // Catch:{ all -> 0x0118 }
            r15 = -1
            if (r14 == r15) goto L_0x010c
            int r4 = r4 + r14
            r16 = r9
            long r8 = (long) r4
            int r8 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r8 <= 0) goto L_0x0102
            java.lang.String r0 = "unzipFileNew: over than top size"
            r8 = r16
            android.util.Log.e(r8, r0)     // Catch:{ all -> 0x00fc }
            r9 = 0
            r11 = 0
            goto L_0x010e
        L_0x00fc:
            r0 = move-exception
            goto L_0x011a
        L_0x00fe:
            r0 = move-exception
            r8 = r16
            goto L_0x011a
        L_0x0102:
            r8 = r16
            r9 = 0
            r12.write(r0, r9, r14)     // Catch:{ all -> 0x010a }
            r9 = r8
            goto L_0x00e3
        L_0x010a:
            r0 = move-exception
            goto L_0x0120
        L_0x010c:
            r8 = r9
            r9 = 0
        L_0x010e:
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.InputStream) r6)     // Catch:{ IOException -> 0x0175, all -> 0x0181 }
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.OutputStream) r12)     // Catch:{ IOException -> 0x0175, all -> 0x0181 }
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.OutputStream) r13)     // Catch:{ IOException -> 0x0175, all -> 0x0181 }
            goto L_0x0172
        L_0x0118:
            r0 = move-exception
            r8 = r9
        L_0x011a:
            r9 = 0
            goto L_0x0120
        L_0x011c:
            r0 = move-exception
            r8 = r9
            r9 = 0
            r12 = r3
        L_0x0120:
            r3 = r13
            goto L_0x012c
        L_0x0122:
            r0 = move-exception
            r8 = r9
            r9 = 0
            r12 = r3
            goto L_0x012c
        L_0x0127:
            r0 = move-exception
            r8 = r9
            r9 = 0
            r6 = r3
            r12 = r6
        L_0x012c:
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.InputStream) r6)     // Catch:{ IOException -> 0x0175, all -> 0x0181 }
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.OutputStream) r12)     // Catch:{ IOException -> 0x0175, all -> 0x0181 }
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.OutputStream) r3)     // Catch:{ IOException -> 0x0175, all -> 0x0181 }
            throw r0     // Catch:{ IOException -> 0x0175, all -> 0x0181 }
        L_0x0136:
            r0 = move-exception
            r8 = r9
            r9 = 0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0175, all -> 0x0181 }
            r6.<init>()     // Catch:{ IOException -> 0x0175, all -> 0x0181 }
            java.lang.String r12 = "not a utf8 zip file, IllegalArgumentException : "
            r6.append(r12)     // Catch:{ IOException -> 0x0175, all -> 0x0181 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ IOException -> 0x0175, all -> 0x0181 }
            r6.append(r0)     // Catch:{ IOException -> 0x0175, all -> 0x0181 }
            java.lang.String r0 = r6.toString()     // Catch:{ IOException -> 0x0175, all -> 0x0181 }
            com.huawei.secure.android.common.util.LogsUtil.i(r8, r0)     // Catch:{ IOException -> 0x0175, all -> 0x0181 }
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ IOException -> 0x0175, all -> 0x0181 }
            r6 = 24
            if (r0 < r6) goto L_0x016d
            r6 = 1
            r1 = r17
            r2 = r18
            r3 = r19
            r5 = r21
            java.util.List r0 = a(r1, r2, r3, r5, r6)     // Catch:{ IOException -> 0x0175, all -> 0x0181 }
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.Closeable) r10)
            if (r11 != 0) goto L_0x016c
            a((java.util.List<java.io.File>) r7)
        L_0x016c:
            return r0
        L_0x016d:
            java.lang.String r0 = "File is not a utf8 zip file and Build.VERSION_CODES < 24"
            com.huawei.secure.android.common.util.LogsUtil.e(r8, r0)     // Catch:{ IOException -> 0x0175, all -> 0x0181 }
        L_0x0172:
            r9 = r8
            goto L_0x004a
        L_0x0175:
            r0 = move-exception
            goto L_0x018c
        L_0x0177:
            r8 = r11
        L_0x0178:
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.Closeable) r10)
            if (r8 != 0) goto L_0x01ab
            a((java.util.List<java.io.File>) r7)
            goto L_0x01ab
        L_0x0181:
            r0 = move-exception
            r3 = r10
            r8 = r11
            goto L_0x01ae
        L_0x0185:
            r0 = move-exception
            r8 = r4
            r3 = r10
            goto L_0x01ae
        L_0x0189:
            r0 = move-exception
            r8 = r9
            r9 = 0
        L_0x018c:
            r3 = r10
        L_0x018d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ac }
            r1.<init>()     // Catch:{ all -> 0x01ac }
            java.lang.String r2 = "unzip new IOException : "
            r1.append(r2)     // Catch:{ all -> 0x01ac }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x01ac }
            r1.append(r0)     // Catch:{ all -> 0x01ac }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x01ac }
            android.util.Log.e(r8, r0)     // Catch:{ all -> 0x01ac }
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.Closeable) r3)
            a((java.util.List<java.io.File>) r7)
        L_0x01ab:
            return r7
        L_0x01ac:
            r0 = move-exception
            r8 = r9
        L_0x01ae:
            r4 = r8
        L_0x01af:
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.Closeable) r3)
            if (r4 != 0) goto L_0x01b7
            a((java.util.List<java.io.File>) r7)
        L_0x01b7:
            throw r0
        L_0x01b8:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.util.ZipUtil.a(java.io.File, java.io.File, long, boolean, boolean):java.util.List");
    }

    private static boolean b(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (!a(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            Log.e(f34007a, "createOrExistsFile IOException ");
            return false;
        }
    }

    private static File c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return b(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0007, code lost:
        r0 = r2.lastIndexOf(java.io.File.separator);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String d(java.lang.String r2) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 == 0) goto L_0x0007
            return r2
        L_0x0007:
            java.lang.String r0 = java.io.File.separator
            int r0 = r2.lastIndexOf(r0)
            r1 = -1
            if (r0 != r1) goto L_0x0011
            goto L_0x0017
        L_0x0011:
            int r0 = r0 + 1
            java.lang.String r2 = r2.substring(r0)
        L_0x0017:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.util.ZipUtil.d(java.lang.String):java.lang.String");
    }

    private static void e(File file) {
        if (file != null) {
            if (file.isFile()) {
                c(file);
            } else if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    c(file);
                    return;
                }
                for (File e11 : listFiles) {
                    e(e11);
                }
                c(file);
            }
        }
    }

    @Deprecated
    public static boolean unZip(String str, String str2, boolean z11) throws SecurityCommonException {
        return unZip(str, str2, 104857600, 100, z11);
    }

    public static List<File> unZipNew(String str, String str2, boolean z11) throws SecurityCommonException {
        return unZipNew(str, str2, 104857600, 100, z11);
    }

    private static void c(File file) {
        if (file != null && !file.delete()) {
            LogsUtil.e(f34007a, "delete file error");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v9, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v15, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v11, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v19, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v20, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v15, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v21, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v22, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v23, resolved type: java.io.FileInputStream} */
    /* JADX WARNING: type inference failed for: r9v0, types: [java.io.BufferedOutputStream] */
    /* JADX WARNING: type inference failed for: r6v2, types: [java.io.BufferedOutputStream] */
    /* JADX WARNING: type inference failed for: r9v2 */
    /* JADX WARNING: type inference failed for: r6v4 */
    /* JADX WARNING: type inference failed for: r9v4 */
    /* JADX WARNING: type inference failed for: r9v5 */
    /* JADX WARNING: type inference failed for: r9v6 */
    /* JADX WARNING: type inference failed for: r9v7 */
    /* JADX WARNING: type inference failed for: r9v8 */
    /* JADX WARNING: type inference failed for: r9v14 */
    /* JADX WARNING: type inference failed for: r9v17 */
    /* JADX WARNING: type inference failed for: r6v20 */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        android.util.Log.e(f34007a, "unzip  over than top size");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d3, code lost:
        r2 = false;
        r10 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00f9, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00fb, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00fc, code lost:
        r16 = r9;
        r9 = r6;
        r6 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0102, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0104, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0106, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0107, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0108, code lost:
        r6 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x011b, code lost:
        r12 = r9;
        r6 = r6;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00f9 A[ExcHandler: all (th java.lang.Throwable), PHI: r6 r9 
      PHI: (r6v9 java.io.FileInputStream) = (r6v17 java.io.FileInputStream), (r6v18 java.io.FileInputStream), (r6v19 java.io.FileInputStream), (r6v24 java.io.FileInputStream), (r6v25 java.io.FileInputStream) binds: [B:14:0x004a, B:71:0x0111, B:72:?, B:55:0x00f1, B:56:?] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r9v16 java.io.FileOutputStream) = (r9v13 java.io.FileOutputStream), (r9v13 java.io.FileOutputStream), (r9v13 java.io.FileOutputStream), (r9v18 java.io.FileOutputStream), (r9v18 java.io.FileOutputStream) binds: [B:14:0x004a, B:71:0x0111, B:72:?, B:55:0x00f1, B:56:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:55:0x00f1] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0104 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:37:0x00c1] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x015b  */
    /* JADX WARNING: Unknown variable types count: 1 */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean unZip(java.lang.String r17, java.lang.String r18, long r19, int r21, boolean r22) throws com.huawei.secure.android.common.util.SecurityCommonException {
        /*
            r0 = r18
            java.lang.String r1 = "ZipUtil"
            boolean r2 = a((java.lang.String) r17, (java.lang.String) r18, (long) r19, (int) r21)
            r3 = 0
            if (r2 != 0) goto L_0x000c
            return r3
        L_0x000c:
            java.lang.String r2 = java.io.File.separator
            boolean r4 = r0.endsWith(r2)
            if (r4 == 0) goto L_0x002b
            int r4 = r18.length()
            int r5 = r2.length()
            if (r4 <= r5) goto L_0x002b
            int r4 = r18.length()
            int r2 = r2.length()
            int r4 = r4 - r2
            java.lang.String r0 = r0.substring(r3, r4)
        L_0x002b:
            r2 = 4096(0x1000, float:5.74E-42)
            byte[] r4 = new byte[r2]
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r6 = 0
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0135, all -> 0x0130 }
            r8 = r17
            r7.<init>(r8)     // Catch:{ IOException -> 0x0135, all -> 0x0130 }
            java.util.zip.ZipInputStream r8 = new java.util.zip.ZipInputStream     // Catch:{ IOException -> 0x0129, all -> 0x0123 }
            java.io.BufferedInputStream r9 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0129, all -> 0x0123 }
            r9.<init>(r7)     // Catch:{ IOException -> 0x0129, all -> 0x0123 }
            r8.<init>(r9)     // Catch:{ IOException -> 0x0129, all -> 0x0123 }
            r9 = 1
            r11 = r3
            r10 = r9
            r9 = r6
        L_0x004a:
            java.util.zip.ZipEntry r12 = r8.getNextEntry()     // Catch:{ IOException -> 0x011e, all -> 0x00f9 }
            if (r12 == 0) goto L_0x0110
            java.lang.String r13 = r12.getName()     // Catch:{ IOException -> 0x011e, all -> 0x00f9 }
            java.lang.String r14 = "\\\\"
            java.lang.String r15 = "/"
            java.lang.String r13 = r13.replaceAll(r14, r15)     // Catch:{ IOException -> 0x011e, all -> 0x00f9 }
            java.io.File r14 = new java.io.File     // Catch:{ IOException -> 0x011e, all -> 0x00f9 }
            r14.<init>(r0, r13)     // Catch:{ IOException -> 0x011e, all -> 0x00f9 }
            java.text.Normalizer$Form r15 = java.text.Normalizer.Form.NFKC     // Catch:{ IOException -> 0x011e, all -> 0x00f9 }
            java.lang.String r13 = java.text.Normalizer.normalize(r13, r15)     // Catch:{ IOException -> 0x011e, all -> 0x00f9 }
            boolean r15 = e((java.lang.String) r13)     // Catch:{ IOException -> 0x011e, all -> 0x00f9 }
            if (r15 == 0) goto L_0x0089
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x011e, all -> 0x00f9 }
            r0.<init>()     // Catch:{ IOException -> 0x011e, all -> 0x00f9 }
            java.lang.String r2 = "zipPath is a invalid path: "
            r0.append(r2)     // Catch:{ IOException -> 0x011e, all -> 0x00f9 }
            java.lang.String r2 = d((java.lang.String) r13)     // Catch:{ IOException -> 0x011e, all -> 0x00f9 }
            r0.append(r2)     // Catch:{ IOException -> 0x011e, all -> 0x00f9 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x011e, all -> 0x00f9 }
            android.util.Log.e(r1, r0)     // Catch:{ IOException -> 0x011e, all -> 0x00f9 }
            r2 = r3
            r10 = r2
            goto L_0x0111
        L_0x0089:
            if (r22 == 0) goto L_0x009a
            boolean r13 = r14.exists()     // Catch:{ IOException -> 0x011e, all -> 0x00f9 }
            if (r13 == 0) goto L_0x009a
            boolean r13 = r14.isFile()     // Catch:{ IOException -> 0x011e, all -> 0x00f9 }
            if (r13 == 0) goto L_0x009a
            e((java.io.File) r14)     // Catch:{ IOException -> 0x011e, all -> 0x00f9 }
        L_0x009a:
            boolean r12 = r12.isDirectory()     // Catch:{ IOException -> 0x011e, all -> 0x00f9 }
            if (r12 == 0) goto L_0x00a8
            d((java.io.File) r14)     // Catch:{ IOException -> 0x011e, all -> 0x00f9 }
            r5.add(r14)     // Catch:{ IOException -> 0x011e, all -> 0x00f9 }
            r2 = r3
            goto L_0x00f1
        L_0x00a8:
            java.io.File r12 = r14.getParentFile()     // Catch:{ IOException -> 0x011e, all -> 0x00f9 }
            if (r12 == 0) goto L_0x00b7
            boolean r13 = r12.exists()     // Catch:{ IOException -> 0x011e, all -> 0x00f9 }
            if (r13 != 0) goto L_0x00b7
            d((java.io.File) r12)     // Catch:{ IOException -> 0x011e, all -> 0x00f9 }
        L_0x00b7:
            java.io.FileOutputStream r12 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x011e, all -> 0x00f9 }
            r12.<init>(r14)     // Catch:{ IOException -> 0x011e, all -> 0x00f9 }
            java.io.BufferedOutputStream r9 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x010d, all -> 0x010b }
            r9.<init>(r12)     // Catch:{ IOException -> 0x010d, all -> 0x010b }
        L_0x00c1:
            int r6 = r8.read(r4, r3, r2)     // Catch:{ IOException -> 0x0106, all -> 0x0104 }
            r13 = -1
            if (r6 == r13) goto L_0x00e2
            int r11 = r11 + r6
            long r2 = (long) r11
            int r2 = (r2 > r19 ? 1 : (r2 == r19 ? 0 : -1))
            if (r2 <= 0) goto L_0x00da
            java.lang.String r2 = "unzip  over than top size"
            android.util.Log.e(r1, r2)     // Catch:{ IOException -> 0x00d6, all -> 0x0104 }
            r2 = 0
            r10 = 0
            goto L_0x00e3
        L_0x00d6:
            r0 = move-exception
            r6 = r12
            r2 = 0
            goto L_0x0109
        L_0x00da:
            r2 = 0
            r9.write(r4, r2, r6)     // Catch:{ IOException -> 0x0102, all -> 0x0104 }
            r3 = r2
            r2 = 4096(0x1000, float:5.74E-42)
            goto L_0x00c1
        L_0x00e2:
            r2 = r3
        L_0x00e3:
            r5.add(r14)     // Catch:{ IOException -> 0x0102, all -> 0x0104 }
            r9.flush()     // Catch:{ IOException -> 0x0102, all -> 0x0104 }
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.OutputStream) r9)     // Catch:{ IOException -> 0x0102, all -> 0x0104 }
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.OutputStream) r12)     // Catch:{ IOException -> 0x0102, all -> 0x0104 }
            r6 = r9
            r9 = r12
        L_0x00f1:
            r8.closeEntry()     // Catch:{ IOException -> 0x00fb, all -> 0x00f9 }
            r3 = r2
            r2 = 4096(0x1000, float:5.74E-42)
            goto L_0x004a
        L_0x00f9:
            r0 = move-exception
            goto L_0x011b
        L_0x00fb:
            r0 = move-exception
            r16 = r9
            r9 = r6
            r6 = r16
            goto L_0x0109
        L_0x0102:
            r0 = move-exception
            goto L_0x0108
        L_0x0104:
            r0 = move-exception
            goto L_0x0127
        L_0x0106:
            r0 = move-exception
            r2 = r3
        L_0x0108:
            r6 = r12
        L_0x0109:
            r12 = r6
            goto L_0x012e
        L_0x010b:
            r0 = move-exception
            goto L_0x011c
        L_0x010d:
            r0 = move-exception
            r2 = r3
            goto L_0x0121
        L_0x0110:
            r2 = r3
        L_0x0111:
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.InputStream) r8)     // Catch:{ IOException -> 0x0119, all -> 0x00f9 }
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.InputStream) r7)     // Catch:{ IOException -> 0x0119, all -> 0x00f9 }
            r3 = r10
            goto L_0x0156
        L_0x0119:
            r0 = move-exception
            goto L_0x0120
        L_0x011b:
            r12 = r9
        L_0x011c:
            r9 = r6
            goto L_0x0127
        L_0x011e:
            r0 = move-exception
            r2 = r3
        L_0x0120:
            r12 = r9
        L_0x0121:
            r9 = r6
            goto L_0x012e
        L_0x0123:
            r0 = move-exception
            r8 = r6
            r9 = r8
            r12 = r9
        L_0x0127:
            r6 = r7
            goto L_0x0160
        L_0x0129:
            r0 = move-exception
            r2 = r3
            r8 = r6
            r9 = r8
            r12 = r9
        L_0x012e:
            r6 = r7
            goto L_0x013a
        L_0x0130:
            r0 = move-exception
            r8 = r6
            r9 = r8
            r12 = r9
            goto L_0x0160
        L_0x0135:
            r0 = move-exception
            r2 = r3
            r8 = r6
            r9 = r8
            r12 = r9
        L_0x013a:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x015f }
            r3.<init>()     // Catch:{ all -> 0x015f }
            java.lang.String r4 = "Unzip IOException : "
            r3.append(r4)     // Catch:{ all -> 0x015f }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x015f }
            r3.append(r0)     // Catch:{ all -> 0x015f }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x015f }
            com.huawei.secure.android.common.util.LogsUtil.e(r1, r0)     // Catch:{ all -> 0x015f }
            r3 = r2
            r7 = r6
            r6 = r9
            r9 = r12
        L_0x0156:
            a((java.io.FileInputStream) r7, (java.io.BufferedOutputStream) r6, (java.util.zip.ZipInputStream) r8, (java.io.FileOutputStream) r9)
            if (r3 != 0) goto L_0x015e
            a((java.util.List<java.io.File>) r5)
        L_0x015e:
            return r3
        L_0x015f:
            r0 = move-exception
        L_0x0160:
            a((java.io.FileInputStream) r6, (java.io.BufferedOutputStream) r9, (java.util.zip.ZipInputStream) r8, (java.io.FileOutputStream) r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.util.ZipUtil.unZip(java.lang.String, java.lang.String, long, int, boolean):boolean");
    }

    public static List<File> unZipNew(String str, String str2, long j11, int i11, boolean z11) throws SecurityCommonException {
        if (!a(str, str2, j11, i11)) {
            return null;
        }
        String str3 = File.separator;
        if (str2.endsWith(str3) && str2.length() > str3.length()) {
            str2 = str2.substring(0, str2.length() - str3.length());
        }
        return a(c(str), c(str2), j11, z11, false);
    }

    private static void d(File file) {
        if (file != null && !file.exists() && !file.mkdirs()) {
            LogsUtil.e(f34007a, "mkdirs error , files exists or IOException.");
        }
    }

    private static File b(String str) {
        a(str);
        return new File(str);
    }

    private static boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e(f34007a, "isContainInvalidStr: name is null");
            return false;
        } else if (str.equals(f34011e)) {
            return true;
        } else {
            for (String contains : f34012f) {
                if (str.contains(contains)) {
                    return true;
                }
            }
            return false;
        }
    }

    private static void a(String str) {
        if (!TextUtils.isEmpty(str) && e(str)) {
            Log.e(f34007a, "IllegalArgumentException--path is not a standard path");
            throw new IllegalArgumentException("path is not a standard path");
        }
    }

    private static boolean a(File file) {
        return file != null && (!file.exists() ? file.mkdirs() : file.isDirectory());
    }

    @RequiresApi(api = 24)
    private static boolean a(String str, long j11, int i11, boolean z11) {
        ZipFile zipFile;
        String str2 = str;
        long j12 = j11;
        int i12 = i11;
        ZipFile zipFile2 = null;
        boolean z12 = false;
        if (!z11) {
            try {
                zipFile = new ZipFile(str2);
            } catch (IOException e11) {
                LogsUtil.e(f34007a, "not a valid zip file, IOException : " + e11.getMessage());
                if (zipFile2 != null) {
                    zipFile2.close();
                }
            } catch (Throwable th2) {
                if (zipFile2 != null) {
                    try {
                        zipFile2.close();
                    } catch (IOException unused) {
                        LogsUtil.e(f34007a, "close zipFile IOException ");
                    }
                }
                throw th2;
            }
        } else {
            LogsUtil.i(f34007a, "not a utf8 zip file, use gbk open zip file : " + str2);
            zipFile = new ZipFile(str2, Charset.forName("GBK"));
        }
        zipFile2 = zipFile;
        Enumeration<? extends ZipEntry> entries = zipFile2.entries();
        long j13 = 0;
        int i13 = 0;
        boolean z13 = true;
        while (true) {
            if (!entries.hasMoreElements()) {
                break;
            }
            try {
                ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                j13 += zipEntry.getSize();
                i13++;
                if (e(zipEntry.getName()) || i13 >= i12 || j13 > j12 || zipEntry.getSize() == -1) {
                    LogsUtil.e(f34007a, "File name is invalid or too many files or too big");
                }
            } catch (IllegalArgumentException e12) {
                LogsUtil.i(f34007a, "not a utf8 zip file, IllegalArgumentException : " + e12.getMessage());
                if (Build.VERSION.SDK_INT >= 24) {
                    z13 = a(str2, j12, i12, true);
                    z12 = z13;
                    zipFile2.close();
                    return z12;
                }
                LogsUtil.e(f34007a, "File is not a utf8 zip file and Build.VERSION_CODES < 24");
                z13 = false;
            }
            zipFile2.close();
            return z12;
        }
        LogsUtil.e(f34007a, "File name is invalid or too many files or too big");
        try {
            zipFile2.close();
        } catch (IOException unused2) {
            LogsUtil.e(f34007a, "close zipFile IOException ");
        }
        return z12;
    }

    private static boolean a(String str, String str2, long j11, int i11) throws SecurityCommonException {
        if (TextUtils.isEmpty(str) || e(str)) {
            LogsUtil.e(f34007a, "zip file is not valid");
            return false;
        } else if (TextUtils.isEmpty(str2) || e(str2)) {
            LogsUtil.e(f34007a, "target directory is not valid");
            return false;
        } else if (a(str, j11, i11, false)) {
            return true;
        } else {
            LogsUtil.e(f34007a, "zip file contains valid chars or too many files");
            throw new SecurityCommonException("unsecure zipfile!");
        }
    }

    private static boolean a(List<File> list) {
        try {
            for (File e11 : list) {
                e(e11);
            }
            return true;
        } catch (Exception e12) {
            LogsUtil.e(f34007a, "unzip fail delete file failed" + e12.getMessage());
            return false;
        }
    }

    private static void a(FileInputStream fileInputStream, BufferedOutputStream bufferedOutputStream, ZipInputStream zipInputStream, FileOutputStream fileOutputStream) {
        IOUtil.closeSecure((InputStream) fileInputStream);
        IOUtil.closeSecure((OutputStream) bufferedOutputStream);
        IOUtil.closeSecure((InputStream) zipInputStream);
        IOUtil.closeSecure((OutputStream) fileOutputStream);
    }
}
