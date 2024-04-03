package com.huawei.agconnect.credential.obs;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.huawei.agconnect.common.api.RandomWrapper;
import com.huawei.agconnect.common.appinfo.SafeAppInfo;
import java.util.UUID;

public class c {
    private static String a(int i11) {
        return f.a(RandomWrapper.generateSecureRandom(i11));
    }

    public static String a(Context context) {
        PackageInfo safeGetPackageInfo;
        if (context == null || (safeGetPackageInfo = SafeAppInfo.safeGetPackageInfo(context.getPackageManager(), context.getPackageName(), 64)) == null) {
            return null;
        }
        return safeGetPackageInfo.signatures[0].toCharsString();
    }

    public static synchronized String a(e eVar) {
        String str;
        synchronized (c.class) {
            if (eVar.c("aaid")) {
                str = eVar.a("aaid");
            } else {
                String uuid = UUID.randomUUID().toString();
                eVar.a("aaid", uuid);
                eVar.a("creationTime", Long.valueOf(System.currentTimeMillis()));
                str = uuid;
            }
        }
        return str;
    }

    public static synchronized String a(String str) {
        String b11;
        synchronized (c.class) {
            b11 = b(str + a(32));
        }
        return b11;
    }

    private static String b(String str) {
        String a11 = f.a(str, Constants.SHA256);
        return ((TextUtils.isEmpty(a11) || a11.length() != 64) ? UUID.randomUUID() : c(a11)).toString();
    }

    private static UUID c(String str) {
        return new UUID(d(str.substring(0, 32)), d(str.substring(32, 64)));
    }

    private static long d(String str) {
        return (((((Long.decode("0x" + str.substring(0, 8)).longValue() << 16) | Long.decode("0x" + str.substring(8, 16)).longValue()) << 16) | Long.decode("0x" + str.substring(16, 24)).longValue()) << 16) | Long.decode("0x" + str.substring(24, 32)).longValue();
    }
}
