package com.huawei.hms.dtm.core;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.dtm.core.util.Logger;
import com.huawei.hms.dtm.core.util.i;
import java.io.File;
import java.io.IOException;

/* renamed from: com.huawei.hms.dtm.core.od  reason: case insensitive filesystem */
public class C0416od {
    private static String a(Context context) {
        String str;
        try {
            str = context.getFilesDir().getCanonicalPath();
        } catch (IOException unused) {
            Logger.error("DTM-Decode", "Get Json path IOException.");
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str;
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            Logger.info("DTM-AutoTrace", "get js#file name is null");
            return null;
        }
        Context a11 = J.a();
        if (a11 == null) {
            return null;
        }
        String b11 = b(a11);
        if (TextUtils.isEmpty(b11)) {
            Logger.warn("DTM-Decode", "js cache directory not exist.");
            return null;
        }
        return i.c(b11 + File.separator + str);
    }

    public static void a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            Logger.info("DTM-AutoTrace", "save js#file name is null");
            return;
        }
        Context a11 = J.a();
        if (a11 != null) {
            String b11 = b(a11);
            if (TextUtils.isEmpty(b11)) {
                Logger.error("DTM-Execute", "get js cache directory failed");
            } else if (!i.b(b11)) {
                Logger.error("DTM-Execute", "create js cache directory failed");
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(b11);
                String str3 = File.separator;
                sb2.append(str3);
                sb2.append(str2);
                String sb3 = sb2.toString();
                long currentTimeMillis = System.currentTimeMillis();
                i.a(str, sb3, b11 + str3 + currentTimeMillis + ".bak");
            }
        }
    }

    private static String b(Context context) {
        String a11 = a(context);
        if (TextUtils.isEmpty(a11)) {
            return null;
        }
        return a11 + File.separator + "dtm_js";
    }
}
