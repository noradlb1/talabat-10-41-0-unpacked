package com.google.android.gms.internal.base;

import android.os.Build;
import androidx.annotation.ChecksSdkIntAtLeast;

final class zan {
    @ChecksSdkIntAtLeast(api = 33, codename = "Tiramisu")
    public static boolean zaa() {
        return Build.VERSION.SDK_INT >= 33 || Build.VERSION.CODENAME.charAt(0) == 'T';
    }
}
