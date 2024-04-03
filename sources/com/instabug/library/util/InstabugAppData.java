package com.instabug.library.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class InstabugAppData {
    @Nullable
    private ApplicationInfo applicationInfo;
    @NonNull

    /* renamed from: pm  reason: collision with root package name */
    private final PackageManager f52050pm;

    public InstabugAppData(@NonNull Context context) {
        PackageManager packageManager = context.getPackageManager();
        this.f52050pm = packageManager;
        try {
            this.applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e11) {
            e11.getMessage();
            InstabugSDKLogger.e("IBG-Core", "Error while getting application info", e11);
        }
    }

    public int getAppIcon() {
        ApplicationInfo applicationInfo2 = this.applicationInfo;
        if (applicationInfo2 == null) {
            return 0;
        }
        return applicationInfo2.icon;
    }

    public String getAppName() {
        ApplicationInfo applicationInfo2 = this.applicationInfo;
        return (String) (applicationInfo2 != null ? this.f52050pm.getApplicationLabel(applicationInfo2) : "(unknown)");
    }
}
