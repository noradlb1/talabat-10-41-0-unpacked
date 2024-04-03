package com.huawei.hms.dtm.core;

import android.os.Build;
import java.util.List;

public class Bb extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (!str2.startsWith(str) && !str.equals("unknown")) {
            str2 = str + " " + str2;
        }
        return new Cc(str2);
    }

    public String a() {
        return "deviceName";
    }
}
