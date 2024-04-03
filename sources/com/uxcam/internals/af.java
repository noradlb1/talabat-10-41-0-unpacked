package com.uxcam.internals;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class af {
    public static void a(String str) {
        try {
            List a11 = a();
            ArrayList arrayList = (ArrayList) a11;
            if (!arrayList.contains(str)) {
                arrayList.add(str);
            }
            ga.a("UXCam_AppKeys", TextUtils.join(",", a11));
        } catch (Exception e11) {
            fx fxVar = new fx();
            fxVar.a("EXCEPTION");
            fxVar.a("site_of_error", "AppKeyStorage::saveAppKey()");
            fxVar.a("reason", e11.getMessage());
            fxVar.a(2);
        }
    }

    public static List a() {
        SharedPreferences b11 = ga.b();
        String str = "";
        if (b11 != null && b11.contains("UXCam_AppKeys")) {
            str = ga.a().a(b11.getString("UXCam_AppKeys", str), ga.a("UXCam_AppKeys"));
        }
        if (str == null || str.isEmpty()) {
            return new ArrayList();
        }
        return new ArrayList(Arrays.asList(str.split(",")));
    }
}
