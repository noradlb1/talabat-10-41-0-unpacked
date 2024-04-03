package com.huawei.hms.feature.dynamic;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.common.util.FileUtils;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.feature.dynamic.f.d;
import java.io.File;
import java.io.IOException;

public class ModuleCopy {

    /* renamed from: a  reason: collision with root package name */
    private static final String f48740a = "ModuleCopy";

    /* renamed from: b  reason: collision with root package name */
    private static final int f48741b = 2048;

    /* renamed from: c  reason: collision with root package name */
    private static final int f48742c = 0;

    /* renamed from: d  reason: collision with root package name */
    private static final int f48743d = 1;

    /* renamed from: e  reason: collision with root package name */
    private static final String f48744e = "module_uri_path";

    /* renamed from: f  reason: collision with root package name */
    private static final String f48745f = "loader_uri_path";

    /* renamed from: g  reason: collision with root package name */
    private static final String f48746g = "dynamic_modules";

    /* renamed from: h  reason: collision with root package name */
    private static final String f48747h = ".apk";

    /* renamed from: i  reason: collision with root package name */
    private static final String f48748i = "0";

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f48749a;

        public a(String str) {
            this.f48749a = str;
        }

        public void run() {
            try {
                FileUtils.a(this.f48749a);
            } catch (SecurityException unused) {
                Logger.w(ModuleCopy.f48740a, "Delete file failed: SecurityException.");
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String[] f48750a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f48751b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f48752c;

        public b(String[] strArr, int i11, String str) {
            this.f48750a = strArr;
            this.f48751b = i11;
            this.f48752c = str;
        }

        public void run() {
            for (String str : this.f48750a) {
                if (Integer.parseInt(str) < this.f48751b) {
                    Logger.i(ModuleCopy.f48740a, "Delete low version:" + this.f48751b + " in modulePath.");
                    FileUtils.a(this.f48752c + File.separator + str);
                }
            }
        }
    }

    private static int a(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            Logger.i(f48740a, "No version dirs in module path, need mkdir.");
            return 0;
        }
        int i11 = 0;
        for (String parseInt : strArr) {
            i11 = Math.max(Integer.parseInt(parseInt), i11);
        }
        return i11;
    }

    private static String a(Context context, Bundle bundle, int i11, Uri uri) {
        String str;
        StringBuilder sb2;
        String str2;
        String str3;
        if (i11 == 0) {
            str = "module_name";
            str3 = bundle.getString(str);
            str2 = String.valueOf(bundle.getInt(b.f48768k));
            sb2 = new StringBuilder();
        } else {
            str = b.f48773p;
            str3 = bundle.getString(str);
            str2 = String.valueOf(bundle.getInt(b.f48774q));
            sb2 = new StringBuilder();
        }
        sb2.append(bundle.getString(str));
        sb2.append(f48747h);
        String sb3 = sb2.toString();
        try {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(getProtectedPath(context));
            String str4 = File.separator;
            sb4.append(str4);
            sb4.append(f48746g);
            sb4.append(str4);
            sb4.append(str3);
            String sb5 = sb4.toString();
            if (!new File(sb5).exists()) {
                return a(context, sb5, uri, sb3, str2);
            }
            String[] list = new File(sb5).list();
            int a11 = a(list);
            if (a11 < Integer.parseInt(str2)) {
                return a(context, sb5, uri, sb3, str2);
            }
            clearLowVersionModule(a11, sb5, list, f48740a);
            return sb5 + str4 + a11 + str4 + sb3;
        } catch (IOException | IllegalArgumentException e11) {
            Logger.w(f48740a, "request modulePath error: " + e11.getMessage());
            return null;
        }
    }

    private static String a(Context context, String str, Uri uri, String str2, String str3) {
        boolean z11;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        String str4 = File.separator;
        sb2.append(str4);
        sb2.append("0");
        String sb3 = sb2.toString();
        String str5 = sb3 + str4 + str2;
        if (!FileUtils.b(sb3)) {
            Logger.e(f48740a, "makeDirectory:tmpModuleFileDir return false.");
            return null;
        }
        a(context, uri, str5);
        if (!d.b(context, str5)) {
            Logger.w(f48740a, "The coped tmp module apk is invalid.");
            a(str5);
            return null;
        }
        String str6 = str + str4 + str3;
        String str7 = str6 + str4 + str2;
        if (!FileUtils.b(str6)) {
            Logger.w(f48740a, "makeDirectory:finalModuleFileDir return false.");
            a(str5);
            return null;
        }
        try {
            z11 = new File(str5).renameTo(new File(str7));
        } catch (SecurityException unused) {
            Logger.w(f48740a, "rename SecurityException.");
            z11 = false;
        }
        if (z11) {
            return str7;
        }
        Logger.w(f48740a, "rename the apk file to the final path failed, should return null.");
        a(str5);
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v22, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v25, resolved type: android.content.Context} */
    /* JADX WARNING: type inference failed for: r3v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r3v6, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r3v15 */
    /* JADX WARNING: type inference failed for: r3v16 */
    /* JADX WARNING: type inference failed for: r3v18 */
    /* JADX WARNING: type inference failed for: r3v19 */
    /* JADX WARNING: type inference failed for: r3v23 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(android.content.Context r3, android.net.Uri r4, java.lang.String r5) {
        /*
            java.lang.String r0 = "ModuleCopy"
            r1 = 0
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ FileNotFoundException -> 0x0068, IOException -> 0x004f, all -> 0x004b }
            java.io.InputStream r3 = r3.openInputStream(r4)     // Catch:{ FileNotFoundException -> 0x0068, IOException -> 0x004f, all -> 0x004b }
            if (r3 != 0) goto L_0x001d
            java.lang.String r4 = "Get input stream failed: null."
            com.huawei.hms.common.util.Logger.w(r0, r4)     // Catch:{ FileNotFoundException -> 0x001b, IOException -> 0x0019, all -> 0x0049 }
            com.huawei.hms.common.util.FileUtils.a((java.io.Closeable) r3)
            com.huawei.hms.common.util.FileUtils.a((java.io.Closeable) r1)
            return
        L_0x0019:
            r4 = move-exception
            goto L_0x0052
        L_0x001b:
            r4 = move-exception
            goto L_0x006b
        L_0x001d:
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch:{ FileNotFoundException -> 0x001b, IOException -> 0x0019, all -> 0x0049 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x001b, IOException -> 0x0019, all -> 0x0049 }
            r2.<init>(r5)     // Catch:{ FileNotFoundException -> 0x001b, IOException -> 0x0019, all -> 0x0049 }
            r4.<init>(r2)     // Catch:{ FileNotFoundException -> 0x001b, IOException -> 0x0019, all -> 0x0049 }
            r5 = 2048(0x800, float:2.87E-42)
            byte[] r5 = new byte[r5]     // Catch:{ FileNotFoundException -> 0x0045, IOException -> 0x0041, all -> 0x003e }
        L_0x002b:
            int r1 = r3.read(r5)     // Catch:{ FileNotFoundException -> 0x0045, IOException -> 0x0041, all -> 0x003e }
            r2 = -1
            if (r1 == r2) goto L_0x0037
            r2 = 0
            r4.write(r5, r2, r1)     // Catch:{ FileNotFoundException -> 0x0045, IOException -> 0x0041, all -> 0x003e }
            goto L_0x002b
        L_0x0037:
            com.huawei.hms.common.util.FileUtils.a((java.io.Closeable) r3)
            com.huawei.hms.common.util.FileUtils.a((java.io.Closeable) r4)
            goto L_0x0086
        L_0x003e:
            r5 = move-exception
            r1 = r4
            goto L_0x0088
        L_0x0041:
            r5 = move-exception
            r1 = r4
            r4 = r5
            goto L_0x0052
        L_0x0045:
            r5 = move-exception
            r1 = r4
            r4 = r5
            goto L_0x006b
        L_0x0049:
            r4 = move-exception
            goto L_0x004d
        L_0x004b:
            r4 = move-exception
            r3 = r1
        L_0x004d:
            r5 = r4
            goto L_0x0088
        L_0x004f:
            r3 = move-exception
            r4 = r3
            r3 = r1
        L_0x0052:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0087 }
            r5.<init>()     // Catch:{ all -> 0x0087 }
            java.lang.String r2 = "IOException "
            r5.append(r2)     // Catch:{ all -> 0x0087 }
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x0087 }
            r5.append(r4)     // Catch:{ all -> 0x0087 }
        L_0x0063:
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x0087 }
            goto L_0x007d
        L_0x0068:
            r3 = move-exception
            r4 = r3
            r3 = r1
        L_0x006b:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0087 }
            r5.<init>()     // Catch:{ all -> 0x0087 }
            java.lang.String r2 = "FileNotFoundException:"
            r5.append(r2)     // Catch:{ all -> 0x0087 }
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x0087 }
            r5.append(r4)     // Catch:{ all -> 0x0087 }
            goto L_0x0063
        L_0x007d:
            com.huawei.hms.common.util.Logger.e(r0, r4)     // Catch:{ all -> 0x0087 }
            com.huawei.hms.common.util.FileUtils.a((java.io.Closeable) r3)
            com.huawei.hms.common.util.FileUtils.a((java.io.Closeable) r1)
        L_0x0086:
            return
        L_0x0087:
            r5 = move-exception
        L_0x0088:
            com.huawei.hms.common.util.FileUtils.a((java.io.Closeable) r3)
            com.huawei.hms.common.util.FileUtils.a((java.io.Closeable) r1)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.feature.dynamic.ModuleCopy.a(android.content.Context, android.net.Uri, java.lang.String):void");
    }

    private static void a(Context context, Bundle bundle, int i11) {
        String string = bundle.getString(i11 == 0 ? f48744e : f48745f);
        Logger.i(f48740a, "path:" + string);
        String a11 = a(context, bundle, i11, Uri.parse(string));
        if (TextUtils.isEmpty(a11)) {
            Logger.w(f48740a, "checkModulePath failed: null.");
        } else {
            bundle.putString(i11 == 0 ? b.f48771n : b.f48775r, a11);
        }
    }

    private static void a(String str) {
        c.a(1, "DeleteFile").execute(new a(str));
    }

    private static boolean a(Bundle bundle) {
        return TextUtils.equals(bundle.getString(b.f48771n), bundle.getString(b.f48775r));
    }

    public static void clearLowVersionModule(int i11, String str, String[] strArr, String str2) {
        c.a(1, str2).execute(new b(strArr, i11, str));
    }

    public static void copyModule(Context context, Bundle bundle) {
        if (context == null || bundle == null) {
            Logger.e(f48740a, "The context or module info bundle is null.");
            return;
        }
        boolean a11 = a(bundle);
        a(context, bundle, 0);
        if (a11) {
            bundle.putString(b.f48775r, bundle.getString(b.f48771n));
        } else {
            a(context, bundle, 1);
        }
    }

    public static String getProtectedPath(Context context) throws IllegalArgumentException, IOException {
        if (context == null) {
            throw new IllegalArgumentException("context is null");
        } else if (Build.VERSION.SDK_INT >= 24) {
            return context.createDeviceProtectedStorageContext().getDataDir().getCanonicalPath();
        } else {
            String canonicalPath = context.getFilesDir().getCanonicalPath();
            int lastIndexOf = canonicalPath.lastIndexOf(File.separator);
            return lastIndexOf <= 0 ? canonicalPath : canonicalPath.substring(0, lastIndexOf);
        }
    }

    public static boolean isLocalModuleFile(Context context, String str) {
        if (context == null) {
            Logger.w(f48740a, "context is null.");
            return false;
        } else if (isPathInvalid(str)) {
            return false;
        } else {
            try {
                String canonicalPath = new File(str).getCanonicalPath();
                return canonicalPath.startsWith(getProtectedPath(context) + File.separator + f48746g);
            } catch (IOException | IllegalArgumentException unused) {
                return false;
            }
        }
    }

    public static boolean isPathInvalid(String str) {
        if (!TextUtils.isEmpty(str) && !str.contains("..")) {
            return false;
        }
        Logger.e(f48740a, "The path is invalid.");
        return true;
    }
}
