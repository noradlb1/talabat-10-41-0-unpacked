package com.huawei.hms.feature.dynamic.f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.facebook.internal.security.CertificateUtil;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.feature.dynamic.ModuleCopy;
import com.huawei.location.lite.common.log.logwrite.LogWriteConstants;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f48800a = "HMSPkgManager";

    /* renamed from: b  reason: collision with root package name */
    private static final List<String> f48801b = new a();

    /* renamed from: c  reason: collision with root package name */
    private static final int f48802c = 8;

    /* renamed from: d  reason: collision with root package name */
    private static final int f48803d = 4;

    /* renamed from: e  reason: collision with root package name */
    private static final int f48804e = 5;

    public class a extends ArrayList<String> {
        public a() {
            add("com.huawei.hwid");
            add("com.huawei.hwid.tv");
        }
    }

    public class b implements PrivilegedAction {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Field f48805a;

        public b(Field field) {
            this.f48805a = field;
        }

        public Object run() {
            this.f48805a.setAccessible(true);
            return null;
        }
    }

    public static boolean a(Context context) {
        if (context == null) {
            Logger.e(f48800a, "The given context is null.");
            return false;
        }
        for (String next : f48801b) {
            try {
                if (context.getPackageManager().getPackageInfo(next, 0) != null) {
                    Logger.i(f48800a, "The HMS Core is installed, pkgName:" + next);
                    return true;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Logger.w(f48800a, "Query for HMS Core package name:" + next + " failed.");
            }
        }
        return false;
    }

    public static boolean a(Context context, String str) {
        if (context == null) {
            Logger.e(f48800a, "context is null.");
            return false;
        } else if (ModuleCopy.isPathInvalid(str)) {
            return false;
        } else {
            try {
                if (!new File(str).exists()) {
                    Logger.w(f48800a, "the file does not exist.");
                    return false;
                }
                String canonicalPath = new File(str).getCanonicalPath();
                if (canonicalPath.startsWith("/system/app/HFF")) {
                    Logger.i(f48800a, "HFF file path, need not to verify.");
                    return true;
                }
                if (canonicalPath.startsWith(LogWriteConstants.INNER_PATH_DATA_DATA1)) {
                    String[] split = canonicalPath.split("/");
                    if (split.length >= 4) {
                        return b(context, split[3]);
                    }
                } else {
                    if (!canonicalPath.startsWith("/data/user_de/")) {
                        if (!canonicalPath.startsWith(LogWriteConstants.INNER_PATH_DATA_USER1)) {
                            Logger.w(f48800a, "illegal path.");
                        }
                    }
                    String[] split2 = canonicalPath.split("/");
                    if (split2.length >= 5) {
                        return b(context, split2[4]);
                    }
                }
                return false;
            } catch (IOException unused) {
                Logger.e(f48800a, "checkPathValidity IOException");
            }
        }
    }

    public static boolean b(Context context, String str) {
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        if (context == null || TextUtils.isEmpty(str)) {
            Logger.e(f48800a, "context is null or pkgName is null.");
            return false;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (PackageManager.NameNotFoundException e11) {
            Logger.e(f48800a, "get PrivAppFlag err for " + str + CertificateUtil.DELIMITER + e11.getMessage());
            packageInfo = null;
        }
        if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) {
            Logger.i(f48800a, "Get pkg application null:" + str);
            return false;
        }
        try {
            Field field = applicationInfo.getClass().getField("privateFlags");
            AccessController.doPrivileged(new b(field));
            Object obj = field.get(applicationInfo);
            if (!(obj instanceof Integer)) {
                Logger.i(f48800a, "Get privFlag instance error.");
                return false;
            }
            int intValue = ((Integer) obj).intValue();
            Logger.d(f48800a, "privFlag of " + str + " is:" + intValue);
            boolean z11 = (intValue & 8) != 0;
            Logger.i(f48800a, "pkgName:" + str + ", isPrivApp:" + z11);
            return z11;
        } catch (IllegalAccessException | NoSuchFieldException e12) {
            Logger.e(f48800a, "get Priv App Flag err for " + str + CertificateUtil.DELIMITER + e12.getMessage());
            return false;
        }
    }

    public static boolean c(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            Logger.w(f48800a, "context is null or pkgName is null.");
            return false;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
            boolean z11 = (packageInfo == null || (packageInfo.applicationInfo.flags & 1) == 0) ? false : true;
            Logger.i(f48800a, "isHMSSystemApp:" + z11);
            if (z11) {
                Logger.i(f48800a, "The HMS package:" + str + " is SystemApp");
                return true;
            }
        } catch (PackageManager.NameNotFoundException e11) {
            Logger.e(f48800a, "getSystemApp flag error for " + str + CertificateUtil.DELIMITER + e11.getMessage());
        }
        return false;
    }
}
