package com.huawei.hms.opendevice;

import android.text.TextUtils;

public class q {
    public static boolean a(String... strArr) {
        for (String isEmpty : strArr) {
            if (TextUtils.isEmpty(isEmpty)) {
                return false;
            }
        }
        return true;
    }
}
