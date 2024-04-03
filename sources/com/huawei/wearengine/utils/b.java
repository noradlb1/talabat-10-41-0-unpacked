package com.huawei.wearengine.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.huawei.wearengine.WearEngineException;
import com.huawei.wearengine.common.a;
import com.huawei.wearengine.notify.Notification;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static Context f44850a;

    public static Context a() {
        return f44850a;
    }

    private static File a(String str) {
        File file = new File(str);
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            a.a("WearEngineFileUtil", "createFileFromPfd parentFile is invalid");
            return null;
        }
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    private static void a(int i11, String str) {
        try {
            if (TextUtils.isEmpty(str) || str.getBytes("UTF-8").length > i11) {
                a.a("NotifyParamCheckUtil", "checkBtnContentLength content length not match");
                throw new WearEngineException(5);
            }
        } catch (UnsupportedEncodingException unused) {
            throw com.huawei.wearengine.a.a("NotifyParamCheckUtil", "checkBtnContentLength UnsupportedEncodingException", 5);
        }
    }

    public static void a(Context context) {
        if (context != null) {
            f44850a = context.getApplicationContext();
        }
    }

    public static void a(Notification notification) {
        int templateId = notification.getTemplateId();
        HashMap<Integer, String> buttonContents = notification.getButtonContents();
        switch (templateId) {
            case 50:
                if (buttonContents != null && !buttonContents.isEmpty()) {
                    throw com.huawei.wearengine.a.a("NotifyParamCheckUtil", "checkNoButtonStyle styles and buttons not match", 5);
                }
                return;
            case 51:
                a(buttonContents);
                Set<Integer> keySet = buttonContents.keySet();
                a(keySet, 1);
                HashSet hashSet = new HashSet();
                hashSet.add(2);
                a(keySet, (HashSet<Integer>) hashSet);
                a(12, buttonContents.get(2));
                return;
            case 52:
                a(buttonContents);
                Set<Integer> keySet2 = buttonContents.keySet();
                a(keySet2, 2);
                HashSet hashSet2 = new HashSet();
                hashSet2.add(2);
                hashSet2.add(3);
                a(keySet2, (HashSet<Integer>) hashSet2);
                a(12, buttonContents.get(2));
                a(12, buttonContents.get(3));
                return;
            case 53:
                a(buttonContents);
                Set<Integer> keySet3 = buttonContents.keySet();
                a(keySet3, 3);
                HashSet hashSet3 = new HashSet();
                hashSet3.add(2);
                hashSet3.add(3);
                hashSet3.add(4);
                a(keySet3, (HashSet<Integer>) hashSet3);
                a(12, buttonContents.get(2));
                a(12, buttonContents.get(3));
                a(12, buttonContents.get(4));
                return;
            default:
                return;
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                a.a("WearEngineFileUtil", "closeQuietly IOException");
            }
        }
    }

    private static void a(HashMap<Integer, String> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            throw com.huawei.wearengine.a.a("NotifyParamCheckUtil", "checkHashMapIsEmpty hashMap is null or hashMap is Empty", 5);
        }
    }

    private static void a(Set<Integer> set, int i11) {
        if (set.size() != i11) {
            throw com.huawei.wearengine.a.a("NotifyParamCheckUtil", "checkInputIndexSize button indexSize not match", 5);
        }
    }

    private static void a(Set<Integer> set, HashSet<Integer> hashSet) {
        if (!new HashSet(set).containsAll(hashSet)) {
            throw com.huawei.wearengine.a.a("NotifyParamCheckUtil", "checkInputButtonIndex keySet index not match", 5);
        }
    }

    public static Intent a(Intent intent) {
        PackageManager packageManager = f44850a.getPackageManager();
        if (packageManager == null) {
            a.a("PackageUtil", "getPackageManager is null");
            return null;
        }
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        if (queryIntentActivities == null || queryIntentActivities.size() != 1) {
            a.c("PackageUtil", "createExplicitFromImplicitIntent implicitIntent List are null");
            return null;
        }
        ActivityInfo activityInfo = queryIntentActivities.get(0).activityInfo;
        ComponentName componentName = new ComponentName(activityInfo.packageName, activityInfo.name);
        Intent intent2 = new Intent(intent);
        intent2.setComponent(componentName);
        return intent2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001e A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0020 A[SYNTHETIC, Splitter:B:14:0x0020] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0081 A[Catch:{ IOException -> 0x006a }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008a A[SYNTHETIC, Splitter:B:39:0x008a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.io.File a(java.lang.String r9, android.os.ParcelFileDescriptor r10) {
        /*
            java.lang.Class<com.huawei.wearengine.utils.b> r0 = com.huawei.wearengine.utils.b.class
            monitor-enter(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x013b }
            r2 = 0
            if (r1 == 0) goto L_0x0013
            java.lang.String r1 = "WearEngineFileUtil"
            java.lang.String r3 = "createFileFromPfd fileName is invalid"
        L_0x000e:
            com.huawei.wearengine.common.a.a((java.lang.String) r1, (java.lang.String) r3)     // Catch:{ all -> 0x013b }
            r1 = r2
            goto L_0x001b
        L_0x0013:
            if (r10 != 0) goto L_0x001a
            java.lang.String r1 = "WearEngineFileUtil"
            java.lang.String r3 = "createFileFromPfd fileDescriptor is null"
            goto L_0x000e
        L_0x001a:
            r1 = 1
        L_0x001b:
            r3 = 0
            if (r1 != 0) goto L_0x0020
            monitor-exit(r0)
            return r3
        L_0x0020:
            android.content.Context r1 = f44850a     // Catch:{ all -> 0x013b }
            if (r1 != 0) goto L_0x002e
            java.lang.String r9 = "WearEngineFileUtil"
            java.lang.String r1 = "getCheckedFilePath context is null"
            com.huawei.wearengine.common.a.a((java.lang.String) r9, (java.lang.String) r1)     // Catch:{ all -> 0x013b }
        L_0x002b:
            java.lang.String r9 = ""
            goto L_0x007b
        L_0x002e:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0073 }
            r4.<init>()     // Catch:{ IOException -> 0x0073 }
            java.io.File r1 = r1.getFilesDir()     // Catch:{ IOException -> 0x0073 }
            java.lang.String r1 = r1.getCanonicalPath()     // Catch:{ IOException -> 0x0073 }
            r4.append(r1)     // Catch:{ IOException -> 0x0073 }
            java.lang.String r1 = java.io.File.separator     // Catch:{ IOException -> 0x0073 }
            r4.append(r1)     // Catch:{ IOException -> 0x0073 }
            java.lang.String r5 = "WearEngine"
            r4.append(r5)     // Catch:{ IOException -> 0x0073 }
            r4.append(r1)     // Catch:{ IOException -> 0x0073 }
            r4.append(r9)     // Catch:{ IOException -> 0x0073 }
            java.lang.String r9 = r4.toString()     // Catch:{ IOException -> 0x0073 }
            boolean r1 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x013b }
            if (r1 == 0) goto L_0x0060
            java.lang.String r9 = "WearEngineFileUtil"
            java.lang.String r1 = "createFileFromPfd path is invalid"
            com.huawei.wearengine.common.a.a((java.lang.String) r9, (java.lang.String) r1)     // Catch:{ all -> 0x013b }
            goto L_0x002b
        L_0x0060:
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x013b }
            r1.<init>(r9)     // Catch:{ all -> 0x013b }
            java.lang.String r9 = r1.getCanonicalPath()     // Catch:{ IOException -> 0x006a }
            goto L_0x007b
        L_0x006a:
            java.lang.String r9 = "WearEngineFileUtil"
            java.lang.String r1 = "getCheckedFilePath IOException"
            com.huawei.wearengine.common.a.a((java.lang.String) r9, (java.lang.String) r1)     // Catch:{ all -> 0x013b }
            r9 = r3
            goto L_0x007b
        L_0x0073:
            java.lang.String r9 = "WearEngineFileUtil"
            java.lang.String r1 = "getCanonicalPath IOException"
            com.huawei.wearengine.common.a.a((java.lang.String) r9, (java.lang.String) r1)     // Catch:{ all -> 0x013b }
            goto L_0x002b
        L_0x007b:
            boolean r1 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x013b }
            if (r1 == 0) goto L_0x008a
            java.lang.String r9 = "WearEngineFileUtil"
            java.lang.String r10 = "createFileFromPfd path is invalid"
            com.huawei.wearengine.common.a.a((java.lang.String) r9, (java.lang.String) r10)     // Catch:{ all -> 0x013b }
            monitor-exit(r0)
            return r3
        L_0x008a:
            java.io.File r9 = a((java.lang.String) r9)     // Catch:{ IOException -> 0x011d, Exception -> 0x0113, all -> 0x0110 }
            if (r9 != 0) goto L_0x00a2
            java.lang.String r9 = "WearEngineFileUtil"
            java.lang.String r1 = "createFileFromPfd dest file is null"
            com.huawei.wearengine.common.a.a((java.lang.String) r9, (java.lang.String) r1)     // Catch:{ IOException -> 0x011d, Exception -> 0x0113, all -> 0x0110 }
            a((java.io.Closeable) r3)     // Catch:{ all -> 0x013b }
            a((java.io.Closeable) r3)     // Catch:{ all -> 0x013b }
            a((java.io.Closeable) r10)     // Catch:{ all -> 0x013b }
            monitor-exit(r0)
            return r3
        L_0x00a2:
            java.io.FileDescriptor r1 = r10.getFileDescriptor()     // Catch:{ IOException -> 0x011d, Exception -> 0x0113, all -> 0x0110 }
            if (r1 == 0) goto L_0x00fe
            boolean r4 = r1.valid()     // Catch:{ IOException -> 0x011d, Exception -> 0x0113, all -> 0x0110 }
            if (r4 != 0) goto L_0x00af
            goto L_0x00fe
        L_0x00af:
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x011d, Exception -> 0x0113, all -> 0x0110 }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ IOException -> 0x011d, Exception -> 0x0113, all -> 0x0110 }
            r5.<init>(r1)     // Catch:{ IOException -> 0x011d, Exception -> 0x0113, all -> 0x0110 }
            r4.<init>(r5)     // Catch:{ IOException -> 0x011d, Exception -> 0x0113, all -> 0x0110 }
            r1 = 2048(0x800, float:2.87E-42)
            byte[] r1 = new byte[r1]     // Catch:{ IOException -> 0x00fc, Exception -> 0x00fa, all -> 0x00f8 }
            int r5 = r4.read(r1)     // Catch:{ IOException -> 0x00fc, Exception -> 0x00fa, all -> 0x00f8 }
            r6 = -1
            if (r5 != r6) goto L_0x00d6
            java.lang.String r1 = "WearEngineFileUtil"
            java.lang.String r2 = "inputStream is empty, do not write file"
            com.huawei.wearengine.common.a.c(r1, r2)     // Catch:{ IOException -> 0x00fc, Exception -> 0x00fa, all -> 0x00f8 }
            a((java.io.Closeable) r4)     // Catch:{ all -> 0x013b }
            a((java.io.Closeable) r3)     // Catch:{ all -> 0x013b }
            a((java.io.Closeable) r10)     // Catch:{ all -> 0x013b }
            monitor-exit(r0)
            return r9
        L_0x00d6:
            java.io.BufferedOutputStream r7 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x00fc, Exception -> 0x00fa, all -> 0x00f8 }
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00fc, Exception -> 0x00fa, all -> 0x00f8 }
            r8.<init>(r9)     // Catch:{ IOException -> 0x00fc, Exception -> 0x00fa, all -> 0x00f8 }
            r7.<init>(r8)     // Catch:{ IOException -> 0x00fc, Exception -> 0x00fa, all -> 0x00f8 }
        L_0x00e0:
            if (r5 == r6) goto L_0x00ea
            r7.write(r1, r2, r5)     // Catch:{ IOException -> 0x011f, Exception -> 0x0115 }
            int r5 = r4.read(r1)     // Catch:{ IOException -> 0x011f, Exception -> 0x0115 }
            goto L_0x00e0
        L_0x00ea:
            r7.flush()     // Catch:{ IOException -> 0x011f, Exception -> 0x0115 }
            a((java.io.Closeable) r4)     // Catch:{ all -> 0x013b }
            a((java.io.Closeable) r7)     // Catch:{ all -> 0x013b }
            a((java.io.Closeable) r10)     // Catch:{ all -> 0x013b }
            monitor-exit(r0)
            return r9
        L_0x00f8:
            r9 = move-exception
            goto L_0x0131
        L_0x00fa:
            r7 = r3
            goto L_0x0115
        L_0x00fc:
            r7 = r3
            goto L_0x011f
        L_0x00fe:
            java.lang.String r1 = "WearEngineFileUtil"
            java.lang.String r2 = "fd is invalid"
            com.huawei.wearengine.common.a.c(r1, r2)     // Catch:{ IOException -> 0x011d, Exception -> 0x0113, all -> 0x0110 }
            a((java.io.Closeable) r3)     // Catch:{ all -> 0x013b }
            a((java.io.Closeable) r3)     // Catch:{ all -> 0x013b }
            a((java.io.Closeable) r10)     // Catch:{ all -> 0x013b }
            monitor-exit(r0)
            return r9
        L_0x0110:
            r9 = move-exception
            r4 = r3
            goto L_0x0131
        L_0x0113:
            r4 = r3
            r7 = r4
        L_0x0115:
            java.lang.String r9 = "WearEngineFileUtil"
            java.lang.String r1 = "createFileFromPfd Exception"
        L_0x0119:
            com.huawei.wearengine.common.a.a((java.lang.String) r9, (java.lang.String) r1)     // Catch:{ all -> 0x012f }
            goto L_0x0124
        L_0x011d:
            r4 = r3
            r7 = r4
        L_0x011f:
            java.lang.String r9 = "WearEngineFileUtil"
            java.lang.String r1 = "createFileFromPfd IOException"
            goto L_0x0119
        L_0x0124:
            a((java.io.Closeable) r4)     // Catch:{ all -> 0x013b }
            a((java.io.Closeable) r7)     // Catch:{ all -> 0x013b }
            a((java.io.Closeable) r10)     // Catch:{ all -> 0x013b }
            monitor-exit(r0)
            return r3
        L_0x012f:
            r9 = move-exception
            r3 = r7
        L_0x0131:
            a((java.io.Closeable) r4)     // Catch:{ all -> 0x013b }
            a((java.io.Closeable) r3)     // Catch:{ all -> 0x013b }
            a((java.io.Closeable) r10)     // Catch:{ all -> 0x013b }
            throw r9     // Catch:{ all -> 0x013b }
        L_0x013b:
            r9 = move-exception
            monitor-exit(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.wearengine.utils.b.a(java.lang.String, android.os.ParcelFileDescriptor):java.io.File");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0058, code lost:
        if (r6 != null) goto L_0x005a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0051 A[Catch:{ NameNotFoundException -> 0x0052, CertificateException -> 0x0049, all -> 0x0047, all -> 0x0088 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0066 A[SYNTHETIC, Splitter:B:42:0x0066] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x008c A[SYNTHETIC, Splitter:B:59:0x008c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r5, java.lang.String r6) {
        /*
            java.lang.String r0 = "getPackageCertificate IOException"
            r1 = 0
            if (r5 == 0) goto L_0x0094
            boolean r2 = android.text.TextUtils.isEmpty(r6)
            if (r2 == 0) goto L_0x000d
            goto L_0x0094
        L_0x000d:
            android.content.pm.PackageManager r5 = r5.getPackageManager()
            r2 = 0
            java.lang.String r3 = "PackageUtil"
            if (r5 != 0) goto L_0x001d
            java.lang.String r5 = "getPackageManager is null"
        L_0x0018:
            com.huawei.wearengine.common.a.a((java.lang.String) r3, (java.lang.String) r5)
            r5 = r1
            goto L_0x0064
        L_0x001d:
            r4 = 64
            android.content.pm.PackageInfo r5 = r5.getPackageInfo(r6, r4)     // Catch:{ NameNotFoundException -> 0x0052, CertificateException -> 0x0049, all -> 0x0047 }
            if (r5 == 0) goto L_0x0061
            android.content.pm.Signature[] r5 = r5.signatures     // Catch:{ NameNotFoundException -> 0x0052, CertificateException -> 0x0049, all -> 0x0047 }
            int r6 = r5.length     // Catch:{ NameNotFoundException -> 0x0052, CertificateException -> 0x0049, all -> 0x0047 }
            if (r6 <= 0) goto L_0x0061
            r5 = r5[r2]     // Catch:{ NameNotFoundException -> 0x0052, CertificateException -> 0x0049, all -> 0x0047 }
            byte[] r5 = r5.toByteArray()     // Catch:{ NameNotFoundException -> 0x0052, CertificateException -> 0x0049, all -> 0x0047 }
            java.io.ByteArrayInputStream r6 = new java.io.ByteArrayInputStream     // Catch:{ NameNotFoundException -> 0x0052, CertificateException -> 0x0049, all -> 0x0047 }
            r6.<init>(r5)     // Catch:{ NameNotFoundException -> 0x0052, CertificateException -> 0x0049, all -> 0x0047 }
            java.lang.String r5 = "X.509"
            java.security.cert.CertificateFactory r5 = java.security.cert.CertificateFactory.getInstance(r5)     // Catch:{ NameNotFoundException -> 0x0053, CertificateException -> 0x004a }
            java.security.cert.Certificate r5 = r5.generateCertificate(r6)     // Catch:{ NameNotFoundException -> 0x0053, CertificateException -> 0x004a }
            r6.close()     // Catch:{ IOException -> 0x0043 }
            goto L_0x0064
        L_0x0043:
            com.huawei.wearengine.common.a.a((java.lang.String) r3, (java.lang.String) r0)
            goto L_0x0064
        L_0x0047:
            r5 = move-exception
            goto L_0x008a
        L_0x0049:
            r6 = r1
        L_0x004a:
            java.lang.String r5 = "getPackageCertificate CertificateException"
            com.huawei.wearengine.common.a.a((java.lang.String) r3, (java.lang.String) r5)     // Catch:{ all -> 0x0088 }
            if (r6 == 0) goto L_0x0061
            goto L_0x005a
        L_0x0052:
            r6 = r1
        L_0x0053:
            java.lang.String r5 = "getPackageCertificate NameNotFoundException"
            com.huawei.wearengine.common.a.a((java.lang.String) r3, (java.lang.String) r5)     // Catch:{ all -> 0x0088 }
            if (r6 == 0) goto L_0x0061
        L_0x005a:
            r6.close()     // Catch:{ IOException -> 0x005e }
            goto L_0x0061
        L_0x005e:
            com.huawei.wearengine.common.a.a((java.lang.String) r3, (java.lang.String) r0)
        L_0x0061:
            java.lang.String r5 = "getPackageCertificate failed to get certificate"
            goto L_0x0018
        L_0x0064:
            if (r5 == 0) goto L_0x0087
            byte[] r5 = r5.getEncoded()     // Catch:{ CertificateEncodingException -> 0x0082 }
            java.lang.String r6 = "SHA-256"
            java.security.MessageDigest r6 = java.security.MessageDigest.getInstance(r6)     // Catch:{ NoSuchAlgorithmException -> 0x0075 }
            byte[] r5 = r6.digest(r5)     // Catch:{ NoSuchAlgorithmException -> 0x0075 }
            goto L_0x007c
        L_0x0075:
            java.lang.String r5 = "digest NoSuchAlgorithmException"
            com.huawei.wearengine.common.a.a((java.lang.String) r3, (java.lang.String) r5)     // Catch:{ CertificateEncodingException -> 0x0082 }
            byte[] r5 = new byte[r2]     // Catch:{ CertificateEncodingException -> 0x0082 }
        L_0x007c:
            r6 = 1
            java.lang.String r5 = com.huawei.wearengine.utils.HexUtil.encodeHexString(r5, r6)     // Catch:{ CertificateEncodingException -> 0x0082 }
            return r5
        L_0x0082:
            java.lang.String r5 = "getPackageFingerprint CertificateEncodingException"
            com.huawei.wearengine.common.a.a((java.lang.String) r3, (java.lang.String) r5)
        L_0x0087:
            return r1
        L_0x0088:
            r5 = move-exception
            r1 = r6
        L_0x008a:
            if (r1 == 0) goto L_0x0093
            r1.close()     // Catch:{ IOException -> 0x0090 }
            goto L_0x0093
        L_0x0090:
            com.huawei.wearengine.common.a.a((java.lang.String) r3, (java.lang.String) r0)
        L_0x0093:
            throw r5
        L_0x0094:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.wearengine.utils.b.a(android.content.Context, java.lang.String):java.lang.String");
    }
}
