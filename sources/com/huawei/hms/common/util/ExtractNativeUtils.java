package com.huawei.hms.common.util;

import android.content.Context;
import android.os.Build;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;

public class ExtractNativeUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final String f48210a = "ExtractNativeUtils";

    /* renamed from: b  reason: collision with root package name */
    public static final int f48211b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static final int f48212c = -1;

    /* renamed from: d  reason: collision with root package name */
    private static final int f48213d = 50;

    /* renamed from: e  reason: collision with root package name */
    private static final int f48214e = 52428800;

    /* renamed from: f  reason: collision with root package name */
    private static final Pattern f48215f = Pattern.compile("lib/([^/]+)/(.*\\.so)$");

    public static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f48216a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public ZipEntry f48217b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public String f48218c;

        private b(ZipEntry zipEntry, String str, String str2) {
            this.f48217b = zipEntry;
            this.f48216a = str;
            this.f48218c = str2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00d3, code lost:
        r12 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00d4, code lost:
        r1 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00d6, code lost:
        r12 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00d7, code lost:
        r4 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x00f8, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x00f9, code lost:
        com.huawei.hms.common.util.Logger.e(f48210a, "IOException:", (java.lang.Throwable) r13);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0056 A[Catch:{ IOException -> 0x00d3, all -> 0x00d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00d6 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:6:0x0018] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00e6 A[SYNTHETIC, Splitter:B:70:0x00e6] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00f4 A[SYNTHETIC, Splitter:B:77:0x00f4] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(java.io.File r12, java.lang.String r13) {
        /*
            java.lang.String r0 = "IOException:"
            java.lang.String r1 = "begin extractNativeLibrary"
            java.lang.String r2 = "ExtractNativeUtils"
            com.huawei.hms.common.util.Logger.i(r2, r1)
            boolean r1 = com.huawei.hms.feature.dynamic.ModuleCopy.isPathInvalid(r13)
            r3 = -1
            if (r1 == 0) goto L_0x0011
            return r3
        L_0x0011:
            r1 = 0
            r4 = 0
            java.util.zip.ZipFile r5 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x00de }
            r5.<init>(r12)     // Catch:{ IOException -> 0x00de }
            java.util.Enumeration r12 = r5.entries()     // Catch:{ IOException -> 0x00d9, all -> 0x00d6 }
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ IOException -> 0x00d9, all -> 0x00d6 }
            r4.<init>()     // Catch:{ IOException -> 0x00d9, all -> 0x00d6 }
            int r12 = a((java.util.Enumeration) r12, (java.util.HashMap<java.lang.String, java.util.HashSet<com.huawei.hms.common.util.ExtractNativeUtils.b>>) r4, (int) r1)     // Catch:{ IOException -> 0x00d9, all -> 0x00d6 }
            if (r12 != r3) goto L_0x0035
            java.lang.String r12 = "Unsafe zip name!"
            com.huawei.hms.common.util.Logger.e(r2, r12)     // Catch:{ IOException -> 0x00d9, all -> 0x00d6 }
            r5.close()     // Catch:{ IOException -> 0x0030 }
            goto L_0x0034
        L_0x0030:
            r12 = move-exception
            com.huawei.hms.common.util.Logger.e((java.lang.String) r2, (java.lang.String) r0, (java.lang.Throwable) r12)
        L_0x0034:
            return r3
        L_0x0035:
            r6 = 50
            if (r12 <= r6) goto L_0x0047
            java.lang.String r12 = "the total number is larger than the max"
            com.huawei.hms.common.util.Logger.e(r2, r12)     // Catch:{ IOException -> 0x00d9, all -> 0x00d6 }
            r5.close()     // Catch:{ IOException -> 0x0042 }
            goto L_0x0046
        L_0x0042:
            r12 = move-exception
            com.huawei.hms.common.util.Logger.e((java.lang.String) r2, (java.lang.String) r0, (java.lang.Throwable) r12)
        L_0x0046:
            return r3
        L_0x0047:
            java.util.Set r12 = r4.keySet()     // Catch:{ IOException -> 0x00d9, all -> 0x00d6 }
            java.util.Iterator r12 = r12.iterator()     // Catch:{ IOException -> 0x00d9, all -> 0x00d6 }
            r6 = r1
        L_0x0050:
            boolean r7 = r12.hasNext()     // Catch:{ IOException -> 0x00d3, all -> 0x00d6 }
            if (r7 == 0) goto L_0x00cd
            java.lang.Object r7 = r12.next()     // Catch:{ IOException -> 0x00d3, all -> 0x00d6 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ IOException -> 0x00d3, all -> 0x00d6 }
            java.lang.Object r7 = r4.get(r7)     // Catch:{ IOException -> 0x00d3, all -> 0x00d6 }
            java.util.Set r7 = (java.util.Set) r7     // Catch:{ IOException -> 0x00d3, all -> 0x00d6 }
            if (r7 != 0) goto L_0x0072
            java.lang.String r12 = "Get nativeZipEntries failed."
            com.huawei.hms.common.util.Logger.e(r2, r12)     // Catch:{ IOException -> 0x00d3, all -> 0x00d6 }
            r5.close()     // Catch:{ IOException -> 0x006d }
            goto L_0x0071
        L_0x006d:
            r12 = move-exception
            com.huawei.hms.common.util.Logger.e((java.lang.String) r2, (java.lang.String) r0, (java.lang.Throwable) r12)
        L_0x0071:
            return r3
        L_0x0072:
            java.util.Iterator r7 = r7.iterator()     // Catch:{ IOException -> 0x00d3, all -> 0x00d6 }
        L_0x0076:
            boolean r8 = r7.hasNext()     // Catch:{ IOException -> 0x00d3, all -> 0x00d6 }
            if (r8 == 0) goto L_0x0050
            java.lang.Object r8 = r7.next()     // Catch:{ IOException -> 0x00d3, all -> 0x00d6 }
            com.huawei.hms.common.util.ExtractNativeUtils$b r8 = (com.huawei.hms.common.util.ExtractNativeUtils.b) r8     // Catch:{ IOException -> 0x00d3, all -> 0x00d6 }
            java.lang.String r9 = r8.f48216a     // Catch:{ IOException -> 0x00d3, all -> 0x00d6 }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ IOException -> 0x00d3, all -> 0x00d6 }
            if (r9 == 0) goto L_0x008d
            goto L_0x0076
        L_0x008d:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00d3, all -> 0x00d6 }
            r9.<init>()     // Catch:{ IOException -> 0x00d3, all -> 0x00d6 }
            r9.append(r13)     // Catch:{ IOException -> 0x00d3, all -> 0x00d6 }
            java.lang.String r10 = java.io.File.separator     // Catch:{ IOException -> 0x00d3, all -> 0x00d6 }
            r9.append(r10)     // Catch:{ IOException -> 0x00d3, all -> 0x00d6 }
            java.lang.String r10 = r8.f48218c     // Catch:{ IOException -> 0x00d3, all -> 0x00d6 }
            r9.append(r10)     // Catch:{ IOException -> 0x00d3, all -> 0x00d6 }
            java.lang.String r9 = r9.toString()     // Catch:{ IOException -> 0x00d3, all -> 0x00d6 }
            com.huawei.hms.common.util.FileUtils.b(r9)     // Catch:{ IOException -> 0x00d3, all -> 0x00d6 }
            java.io.File r10 = new java.io.File     // Catch:{ IOException -> 0x00d3, all -> 0x00d6 }
            r10.<init>(r9)     // Catch:{ IOException -> 0x00d3, all -> 0x00d6 }
            r11 = 1
            r10.setExecutable(r11, r1)     // Catch:{ IOException -> 0x00d3, all -> 0x00d6 }
            int r6 = a((java.util.zip.ZipFile) r5, (com.huawei.hms.common.util.ExtractNativeUtils.b) r8, (java.lang.String) r9)     // Catch:{ IOException -> 0x00d3, all -> 0x00d6 }
            if (r6 == 0) goto L_0x00c0
            r5.close()     // Catch:{ IOException -> 0x00bb }
            goto L_0x00bf
        L_0x00bb:
            r12 = move-exception
            com.huawei.hms.common.util.Logger.e((java.lang.String) r2, (java.lang.String) r0, (java.lang.Throwable) r12)
        L_0x00bf:
            return r6
        L_0x00c0:
            java.io.File r10 = new java.io.File     // Catch:{ IOException -> 0x00d3, all -> 0x00d6 }
            java.lang.String r8 = r8.f48216a     // Catch:{ IOException -> 0x00d3, all -> 0x00d6 }
            r10.<init>(r9, r8)     // Catch:{ IOException -> 0x00d3, all -> 0x00d6 }
            r10.setReadOnly()     // Catch:{ IOException -> 0x00d3, all -> 0x00d6 }
            goto L_0x0076
        L_0x00cd:
            r5.close()     // Catch:{ IOException -> 0x00d1 }
            goto L_0x00f1
        L_0x00d1:
            r12 = move-exception
            goto L_0x00ec
        L_0x00d3:
            r12 = move-exception
            r1 = r6
            goto L_0x00da
        L_0x00d6:
            r12 = move-exception
            r4 = r5
            goto L_0x00f2
        L_0x00d9:
            r12 = move-exception
        L_0x00da:
            r4 = r5
            goto L_0x00df
        L_0x00dc:
            r12 = move-exception
            goto L_0x00f2
        L_0x00de:
            r12 = move-exception
        L_0x00df:
            java.lang.String r13 = "catch IOException "
            com.huawei.hms.common.util.Logger.e((java.lang.String) r2, (java.lang.String) r13, (java.lang.Throwable) r12)     // Catch:{ all -> 0x00dc }
            if (r4 == 0) goto L_0x00f0
            r4.close()     // Catch:{ IOException -> 0x00ea }
            goto L_0x00f0
        L_0x00ea:
            r12 = move-exception
            r6 = r1
        L_0x00ec:
            com.huawei.hms.common.util.Logger.e((java.lang.String) r2, (java.lang.String) r0, (java.lang.Throwable) r12)
            goto L_0x00f1
        L_0x00f0:
            r6 = r1
        L_0x00f1:
            return r6
        L_0x00f2:
            if (r4 == 0) goto L_0x00fc
            r4.close()     // Catch:{ IOException -> 0x00f8 }
            goto L_0x00fc
        L_0x00f8:
            r13 = move-exception
            com.huawei.hms.common.util.Logger.e((java.lang.String) r2, (java.lang.String) r0, (java.lang.Throwable) r13)
        L_0x00fc:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.common.util.ExtractNativeUtils.a(java.io.File, java.lang.String):int");
    }

    private static int a(Enumeration enumeration, HashMap<String, HashSet<b>> hashMap, int i11) {
        while (enumeration.hasMoreElements()) {
            Object nextElement = enumeration.nextElement();
            if (nextElement != null && (nextElement instanceof ZipEntry)) {
                ZipEntry zipEntry = (ZipEntry) nextElement;
                String name2 = zipEntry.getName();
                if (name2.contains("../")) {
                    Logger.e(f48210a, "Unsafe zip name!");
                    return -1;
                }
                Matcher matcher = f48215f.matcher(name2);
                if (matcher.matches()) {
                    String group = matcher.group(1);
                    String group2 = matcher.group(2);
                    HashSet hashSet = hashMap.get(group);
                    if (hashSet == null) {
                        hashSet = new HashSet();
                        hashMap.put(group, hashSet);
                    }
                    hashSet.add(new b(zipEntry, group2, group));
                    i11++;
                }
            }
        }
        return i11;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v9, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v11, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v17, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v13, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v18, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v20, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v21, resolved type: java.io.InputStream} */
    /* JADX WARNING: type inference failed for: r9v13 */
    /* JADX WARNING: type inference failed for: r9v14 */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0085, code lost:
        if (r9 == null) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x009b, code lost:
        if (r9 == null) goto L_0x00a2;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007d A[SYNTHETIC, Splitter:B:37:0x007d] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0093 A[SYNTHETIC, Splitter:B:50:0x0093] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00a9 A[SYNTHETIC, Splitter:B:61:0x00a9] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00b3 A[SYNTHETIC, Splitter:B:66:0x00b3] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int a(java.util.zip.ZipFile r9, com.huawei.hms.common.util.ExtractNativeUtils.b r10, java.lang.String r11) {
        /*
            java.lang.String r0 = "IOException"
            java.lang.String r1 = "ExtractNativeUtils"
            r2 = 4096(0x1000, float:5.74E-42)
            r3 = -1
            r4 = 0
            byte[] r2 = new byte[r2]     // Catch:{ FileNotFoundException -> 0x008b, IOException -> 0x0075, all -> 0x0072 }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x008b, IOException -> 0x0075, all -> 0x0072 }
            java.io.File r6 = new java.io.File     // Catch:{ FileNotFoundException -> 0x008b, IOException -> 0x0075, all -> 0x0072 }
            java.lang.String r7 = r10.f48216a     // Catch:{ FileNotFoundException -> 0x008b, IOException -> 0x0075, all -> 0x0072 }
            r6.<init>(r11, r7)     // Catch:{ FileNotFoundException -> 0x008b, IOException -> 0x0075, all -> 0x0072 }
            r5.<init>(r6)     // Catch:{ FileNotFoundException -> 0x008b, IOException -> 0x0075, all -> 0x0072 }
            java.util.zip.ZipEntry r11 = r10.f48217b     // Catch:{ FileNotFoundException -> 0x006f, IOException -> 0x006b, all -> 0x0067 }
            java.io.InputStream r9 = r9.getInputStream(r11)     // Catch:{ FileNotFoundException -> 0x006f, IOException -> 0x006b, all -> 0x0067 }
            r11 = 0
            r4 = r11
        L_0x0022:
            int r6 = r9.read(r2)     // Catch:{ FileNotFoundException -> 0x0065, IOException -> 0x0062, all -> 0x0060 }
            if (r6 <= 0) goto L_0x0056
            int r4 = r4 + r6
            r7 = 52428800(0x3200000, float:4.7019774E-37)
            if (r4 <= r7) goto L_0x0052
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0065, IOException -> 0x0062, all -> 0x0060 }
            r11.<init>()     // Catch:{ FileNotFoundException -> 0x0065, IOException -> 0x0062, all -> 0x0060 }
            java.lang.String r2 = "so file too big , "
            r11.append(r2)     // Catch:{ FileNotFoundException -> 0x0065, IOException -> 0x0062, all -> 0x0060 }
            java.lang.String r2 = r10.f48218c     // Catch:{ FileNotFoundException -> 0x0065, IOException -> 0x0062, all -> 0x0060 }
            r11.append(r2)     // Catch:{ FileNotFoundException -> 0x0065, IOException -> 0x0062, all -> 0x0060 }
            java.lang.String r2 = " , "
            r11.append(r2)     // Catch:{ FileNotFoundException -> 0x0065, IOException -> 0x0062, all -> 0x0060 }
            java.lang.String r10 = r10.f48216a     // Catch:{ FileNotFoundException -> 0x0065, IOException -> 0x0062, all -> 0x0060 }
            r11.append(r10)     // Catch:{ FileNotFoundException -> 0x0065, IOException -> 0x0062, all -> 0x0060 }
            java.lang.String r10 = r11.toString()     // Catch:{ FileNotFoundException -> 0x0065, IOException -> 0x0062, all -> 0x0060 }
            com.huawei.hms.common.util.Logger.e(r1, r10)     // Catch:{ FileNotFoundException -> 0x0065, IOException -> 0x0062, all -> 0x0060 }
            goto L_0x0057
        L_0x0052:
            r5.write(r2, r11, r6)     // Catch:{ FileNotFoundException -> 0x0065, IOException -> 0x0062, all -> 0x0060 }
            goto L_0x0022
        L_0x0056:
            r3 = r11
        L_0x0057:
            r5.close()     // Catch:{ IOException -> 0x005b }
            goto L_0x0087
        L_0x005b:
            r10 = move-exception
            com.huawei.hms.common.util.Logger.e((java.lang.String) r1, (java.lang.String) r0, (java.lang.Throwable) r10)
            goto L_0x0087
        L_0x0060:
            r10 = move-exception
            goto L_0x0069
        L_0x0062:
            r10 = move-exception
            r4 = r9
            goto L_0x006c
        L_0x0065:
            r4 = r9
            goto L_0x006f
        L_0x0067:
            r10 = move-exception
            r9 = r4
        L_0x0069:
            r4 = r5
            goto L_0x00a4
        L_0x006b:
            r10 = move-exception
        L_0x006c:
            r9 = r4
            r4 = r5
            goto L_0x0078
        L_0x006f:
            r9 = r4
            r4 = r5
            goto L_0x008c
        L_0x0072:
            r9 = move-exception
            r10 = r4
            goto L_0x00a7
        L_0x0075:
            r9 = move-exception
            r10 = r9
            r9 = r4
        L_0x0078:
            com.huawei.hms.common.util.Logger.e((java.lang.String) r1, (java.lang.String) r0, (java.lang.Throwable) r10)     // Catch:{ all -> 0x00a3 }
            if (r4 == 0) goto L_0x0085
            r4.close()     // Catch:{ IOException -> 0x0081 }
            goto L_0x0085
        L_0x0081:
            r10 = move-exception
            com.huawei.hms.common.util.Logger.e((java.lang.String) r1, (java.lang.String) r0, (java.lang.Throwable) r10)
        L_0x0085:
            if (r9 == 0) goto L_0x00a2
        L_0x0087:
            r9.close()     // Catch:{ IOException -> 0x009e }
            goto L_0x00a2
        L_0x008b:
            r9 = r4
        L_0x008c:
            java.lang.String r10 = "FileNotFoundException"
            com.huawei.hms.common.util.Logger.e(r1, r10)     // Catch:{ all -> 0x00a3 }
            if (r4 == 0) goto L_0x009b
            r4.close()     // Catch:{ IOException -> 0x0097 }
            goto L_0x009b
        L_0x0097:
            r10 = move-exception
            com.huawei.hms.common.util.Logger.e((java.lang.String) r1, (java.lang.String) r0, (java.lang.Throwable) r10)
        L_0x009b:
            if (r9 == 0) goto L_0x00a2
            goto L_0x0087
        L_0x009e:
            r9 = move-exception
            com.huawei.hms.common.util.Logger.e((java.lang.String) r1, (java.lang.String) r0, (java.lang.Throwable) r9)
        L_0x00a2:
            return r3
        L_0x00a3:
            r10 = move-exception
        L_0x00a4:
            r8 = r10
            r10 = r9
            r9 = r8
        L_0x00a7:
            if (r4 == 0) goto L_0x00b1
            r4.close()     // Catch:{ IOException -> 0x00ad }
            goto L_0x00b1
        L_0x00ad:
            r11 = move-exception
            com.huawei.hms.common.util.Logger.e((java.lang.String) r1, (java.lang.String) r0, (java.lang.Throwable) r11)
        L_0x00b1:
            if (r10 == 0) goto L_0x00bb
            r10.close()     // Catch:{ IOException -> 0x00b7 }
            goto L_0x00bb
        L_0x00b7:
            r10 = move-exception
            com.huawei.hms.common.util.Logger.e((java.lang.String) r1, (java.lang.String) r0, (java.lang.Throwable) r10)
        L_0x00bb:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.common.util.ExtractNativeUtils.a(java.util.zip.ZipFile, com.huawei.hms.common.util.ExtractNativeUtils$b, java.lang.String):int");
    }

    public static boolean a(Context context, String str) {
        if (Build.VERSION.SDK_INT <= 23) {
            Logger.i(f48210a, "The android version is below android 6.");
            return true;
        }
        try {
            if ((context.getPackageManager().getPackageArchiveInfo(str, 128).applicationInfo.flags & 268435456) == 268435456) {
                Logger.i(f48210a, "The extract-native-flag has set, need to extract.");
                return true;
            }
            Logger.i(f48210a, "The extract-native-flag has not set, No need to extract.");
            return false;
        } catch (Exception unused) {
            Logger.w(f48210a, "Get package name failed: name not found.");
            return true;
        }
    }
}
