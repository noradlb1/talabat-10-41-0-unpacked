package com.instabug.library.networkv2;

import androidx.annotation.VisibleForTesting;
import com.instabug.library.Feature;
import com.instabug.library.a;
import com.instabug.library.e0;
import com.instabug.library.networkv2.request.Constants;
import com.instabug.library.networkv2.request.Endpoints;

public abstract class f {
    public static boolean a() {
        e0 c11 = e0.c();
        a aVar = a.BE_DISABLE_SIGNING;
        return c11.c((Object) aVar) && e0.c().a((Object) aVar) != Feature.State.DISABLED;
    }

    @VisibleForTesting
    public static boolean b(String str) {
        return str.contains(Endpoints.APP_SETTINGS);
    }

    public static boolean c(String str) {
        if (str.contains(Constants.BASE_URL) || str.contains(Constants.APM_BASE_URL) || str.contains("monitoring.instabug.com")) {
            return true;
        }
        return false;
    }

    public static boolean a(String str) {
        return c(str) && !b(str);
    }
}
