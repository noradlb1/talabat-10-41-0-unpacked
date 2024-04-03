package com.huawei.hms.dtm.core.debug;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.dtm.core.util.Logger;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f48472a = false;

    public static void a(boolean z11) {
        f48472a = z11;
    }

    public static boolean a(Context context) {
        String systemProperty = PropertyUtil.getSystemProperty("debug.huawei.hms.dtm.app", "");
        if (context != null && !TextUtils.isEmpty(systemProperty)) {
            return systemProperty.equals(context.getPackageName()) || f48472a;
        }
        Logger.info("debug mode disable");
        return f48472a;
    }
}
