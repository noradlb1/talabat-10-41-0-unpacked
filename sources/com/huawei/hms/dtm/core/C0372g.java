package com.huawei.hms.dtm.core;

import android.app.Activity;
import com.huawei.hms.dtm.core.util.c;

/* renamed from: com.huawei.hms.dtm.core.g  reason: case insensitive filesystem */
public class C0372g {
    public static void a() {
        C0367f a11;
        Activity b11;
        Activity b12 = c.a().b();
        if (b12 != null && !b12.isFinishing() && (a11 = C0382i.a().a(b12.getClass().getCanonicalName())) != null && (b11 = a11.b()) != null && b11 == b12 && !b11.isFinishing()) {
            a11.onGlobalLayout();
        }
    }
}
