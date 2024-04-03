package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.pm.PackageManager;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33966a = "f";

    public static String a(String str) {
        Context instance = ContextUtil.getInstance();
        if (instance == null) {
            return "";
        }
        try {
            return instance.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException e11) {
            String str2 = f33966a;
            e.b(str2, "getVersion NameNotFoundException : " + e11.getMessage());
            return "";
        } catch (Exception e12) {
            String str3 = f33966a;
            e.b(str3, "getVersion: " + e12.getMessage());
            return "";
        } catch (Throwable unused) {
            e.b(f33966a, "throwable");
            return "";
        }
    }

    public static int b(String str) {
        Context instance = ContextUtil.getInstance();
        if (instance == null) {
            return 0;
        }
        try {
            return instance.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            e.b(f33966a, "getVersion NameNotFoundException");
            return 0;
        } catch (Exception e11) {
            String str2 = f33966a;
            e.b(str2, "getVersion: " + e11.getMessage());
            return 0;
        }
    }
}
