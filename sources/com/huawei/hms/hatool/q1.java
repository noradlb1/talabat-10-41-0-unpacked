package com.huawei.hms.hatool;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.UserManager;

public class q1 {

    /* renamed from: c  reason: collision with root package name */
    private static q1 f49103c = new q1();

    /* renamed from: a  reason: collision with root package name */
    private boolean f49104a = false;

    /* renamed from: b  reason: collision with root package name */
    private Context f49105b = q0.i();

    private q1() {
    }

    public static q1 b() {
        return f49103c;
    }

    @TargetApi(24)
    public boolean a() {
        boolean z11;
        if (!this.f49104a) {
            Context context = this.f49105b;
            if (context == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                UserManager userManager = (UserManager) context.getSystemService("user");
                if (userManager != null) {
                    z11 = userManager.isUserUnlocked();
                } else {
                    this.f49104a = false;
                }
            } else {
                z11 = true;
            }
            this.f49104a = z11;
        }
        return this.f49104a;
    }
}
