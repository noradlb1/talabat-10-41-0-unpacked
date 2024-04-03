package com.huawei.hms.analytics;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;

public final class ea {
    private static final ea lmn = new ea();
    private boolean klm = false;

    public static ea lmn() {
        return lmn;
    }

    public final boolean lmn(Context context) {
        boolean z11;
        if (!this.klm) {
            if (context == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                UserManager userManager = (UserManager) context.getSystemService("user");
                if (userManager != null) {
                    z11 = userManager.isUserUnlocked();
                } else {
                    this.klm = false;
                }
            } else {
                z11 = true;
            }
            this.klm = z11;
        }
        return this.klm;
    }
}
