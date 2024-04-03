package com.huawei.agconnect.credential.obs;

import android.content.Context;
import android.util.Log;
import com.visa.checkout.Profile;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class ah {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f47562a;

    /* renamed from: b  reason: collision with root package name */
    private static final List<String> f47563b;

    static {
        String[] strArr = {Profile.Country.CN, "DE", Profile.Country.SG, "RU", "UNKNOWN"};
        f47562a = strArr;
        f47563b = Collections.unmodifiableList(Arrays.asList(strArr));
    }

    public static ai a(Context context, String str, String str2, String str3) {
        if (str3 != null) {
            List<String> list = f47563b;
            Locale locale = Locale.ENGLISH;
            if (list.contains(str3.toUpperCase(locale))) {
                return ak.a(context, new al(str, str2, str3.toUpperCase(locale)));
            }
        }
        Log.e("HiAnalyticsBridge", "RoutePolicy check failed: ".concat(String.valueOf(str3)));
        return null;
    }
}
