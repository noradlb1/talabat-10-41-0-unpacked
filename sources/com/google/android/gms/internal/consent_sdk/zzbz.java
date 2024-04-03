package com.google.android.gms.internal.consent_sdk;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.huawei.location.lite.common.util.DeviceInfoUtil;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class zzbz {
    @GuardedBy("DeviceId.class")
    @Nullable
    private static String zza;

    public static synchronized String zza(Context context) {
        String str;
        String str2;
        synchronized (zzbz.class) {
            if (zza == null) {
                ContentResolver contentResolver = context.getContentResolver();
                if (contentResolver == null) {
                    str2 = null;
                } else {
                    str2 = Settings.Secure.getString(contentResolver, "android_id");
                }
                if (str2 == null || zza()) {
                    str2 = DeviceInfoUtil.DeviceProperty.EMULATOR;
                }
                zza = zza(str2);
            }
            str = zza;
        }
        return str;
    }

    private static String zza(String str) {
        int i11 = 0;
        while (i11 < 3) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(str.getBytes());
                return String.format("%032X", new Object[]{new BigInteger(1, instance.digest())});
            } catch (NoSuchAlgorithmException unused) {
                i11++;
            } catch (ArithmeticException unused2) {
                return "";
            }
        }
        return "";
    }

    public static boolean zza() {
        String str = Build.FINGERPRINT;
        if (str.startsWith("generic") || str.startsWith("unknown")) {
            return true;
        }
        String str2 = Build.MODEL;
        if (str2.contains("google_sdk") || str2.contains("Emulator") || str2.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion")) {
            return true;
        }
        return (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")) || "google_sdk".equals(Build.PRODUCT);
    }
}
