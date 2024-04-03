package com.google.android.gms.internal.clearcut;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.UserManager;

public class zzaa {
    private static volatile UserManager zzdc;
    private static volatile boolean zzdd = (!zzf());

    private zzaa() {
    }

    public static boolean zze(Context context) {
        return zzf() && !zzf(context);
    }

    private static boolean zzf() {
        return Build.VERSION.SDK_INT >= 24;
    }

    @TargetApi(24)
    private static boolean zzf(Context context) {
        boolean z11 = zzdd;
        if (!z11) {
            UserManager userManager = zzdc;
            if (userManager == null) {
                synchronized (zzaa.class) {
                    userManager = zzdc;
                    if (userManager == null) {
                        UserManager userManager2 = (UserManager) context.getSystemService(UserManager.class);
                        zzdc = userManager2;
                        if (userManager2 == null) {
                            zzdd = true;
                            return true;
                        }
                        userManager = userManager2;
                    }
                }
            }
            z11 = userManager.isUserUnlocked();
            zzdd = z11;
            if (z11) {
                zzdc = null;
            }
        }
        return z11;
    }
}
