package com.google.android.gms.internal.gtm;

import android.os.Build;

final class zzeg {
    public static int version() {
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
            zzev.zzav(str);
            return 0;
        }
    }
}
