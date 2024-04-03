package com.instabug.library.util;

import android.content.Context;
import androidx.annotation.Nullable;

public abstract class a {
    @Nullable
    public static String a(@Nullable Context context) {
        if (context != null) {
            return context.getPackageManager().getInstallerPackageName(context.getApplicationContext().getPackageName());
        }
        return null;
    }
}
