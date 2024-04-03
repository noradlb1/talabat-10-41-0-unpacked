package com.huawei.hms.dtm.core;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.dtm.core.util.Logger;
import com.huawei.hms.dtm.core.util.b;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;

/* renamed from: com.huawei.hms.dtm.core.pd  reason: case insensitive filesystem */
public class C0421pd {
    public static String a() {
        Context a11 = J.a();
        if (a11 != null) {
            return GrsApp.getInstance().getIssueCountryCode(a11);
        }
        Logger.error("DTM-Execute", "GrsUtil#app context is null.");
        return null;
    }

    private static String a(Context context, String str, String str2, String str3) {
        GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
        grsBaseInfo.setSerCountry(str);
        return new GrsClient(context, grsBaseInfo).synGetGrsUrl(str2, str3);
    }

    public static String a(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "GrsUtil#country code is empty";
        } else {
            Context b11 = J.b();
            if (b11 != null) {
                return a(b11, str, "com.huawei.hms.dtm", "ROOT");
            }
            str2 = "GrsUtil#hms context is null";
        }
        Logger.error("DTM-Execute", str2);
        return null;
    }

    public static String a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return null;
        }
        Context b11 = J.b();
        if (b11 != null) {
            return a(b11, str, str2, str3);
        }
        Logger.error("DTM-Execute", "GrsUtil#hms context is null");
        return null;
    }

    public static String b() {
        return a(b.d());
    }
}
