package com.google.android.gms.tagmanager;

import android.annotation.TargetApi;
import android.os.Build;
import java.io.File;

final class zzbr {
    private static int version() {
        String str;
        try {
            return Integer.parseInt(Build.VERSION.SDK);
        } catch (NumberFormatException unused) {
            String valueOf = String.valueOf(Build.VERSION.SDK);
            if (valueOf.length() != 0) {
                str = "Invalid version number: ".concat(valueOf);
            } else {
                str = new String("Invalid version number: ");
            }
            zzdi.zzav(str);
            return 0;
        }
    }

    @TargetApi(9)
    public static boolean zzbb(String str) {
        if (version() < 9) {
            return false;
        }
        File file = new File(str);
        file.setReadable(false, false);
        file.setWritable(false, false);
        file.setReadable(true, true);
        file.setWritable(true, true);
        return true;
    }
}
