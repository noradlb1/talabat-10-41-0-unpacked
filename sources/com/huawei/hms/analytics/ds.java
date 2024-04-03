package com.huawei.hms.analytics;

import android.content.Context;
import android.text.TextUtils;
import net.bytebuddy.utility.JavaConstant;

public final class ds {
    public static String[] klm(Context context) {
        String klm = dv.klm(context, "latest_upload_time", "lct_policy_time", "");
        return TextUtils.isEmpty(klm) ? new String[0] : klm.split(JavaConstant.Dynamic.DEFAULT_NAME);
    }

    public static void lmn(Context context, String str, String[] strArr) {
        dv.lmn(context, "latest_upload_time", "grs_ser_conf", str + JavaConstant.Dynamic.DEFAULT_NAME + dw.lmn((CharSequence) ",", (CharSequence[]) strArr) + JavaConstant.Dynamic.DEFAULT_NAME + System.currentTimeMillis());
    }

    public static String[] lmn(Context context) {
        String klm = dv.klm(context, "latest_upload_time", "grs_ser_conf", "");
        return TextUtils.isEmpty(klm) ? new String[0] : klm.split(JavaConstant.Dynamic.DEFAULT_NAME);
    }
}
