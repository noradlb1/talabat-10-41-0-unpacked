package com.huawei.hms.framework.network.grs.h;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import java.util.Locale;

public class a {
    public static String a() {
        return "6.0.11.300";
    }

    public static String a(Context context) {
        if (context == null) {
            return "";
        }
        if (ContextHolder.getAppContext() != null) {
            context = ContextHolder.getAppContext();
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (PackageManager.NameNotFoundException e11) {
            Logger.w("AgentUtil", "", (Throwable) e11);
            return "";
        }
    }

    public static String a(Context context, String str, String str2) {
        if (context == null) {
            return String.format(Locale.ROOT, str + "/%s", new Object[]{a()});
        }
        String packageName = (ContextHolder.getAppContext() == null ? context : ContextHolder.getAppContext()).getPackageName();
        String a11 = a(context);
        String str3 = Build.VERSION.RELEASE;
        String str4 = Build.MODEL;
        Locale locale = Locale.ROOT;
        String str5 = "%s/%s (Linux; Android %s; %s) " + str + "/%s %s";
        Object[] objArr = new Object[6];
        objArr[0] = packageName;
        objArr[1] = a11;
        objArr[2] = str3;
        objArr[3] = str4;
        objArr[4] = a();
        if (TextUtils.isEmpty(str2)) {
            str2 = "no_service_name";
        }
        objArr[5] = str2;
        return String.format(locale, str5, objArr);
    }

    public static String b(Context context, String str, String str2) {
        return a(context, str, str2);
    }
}
