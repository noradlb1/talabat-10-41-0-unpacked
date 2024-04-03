package com.huawei.hms.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.dd;
import com.talabat.helpers.GlobalConstants;

public final class cr implements Runnable {
    private Context lmn;

    public cr(Context context) {
        this.lmn = context;
    }

    public final void run() {
        String str;
        Class<String> cls = String.class;
        if ((ad.lmn() || ad.klm()) && !dv.klm(this.lmn, "global_v2", "isAdRedirect", false)) {
            dd.lmn lmn2 = new dd(this.lmn).lmn();
            dc dcVar = new dc(this.lmn);
            if (lmn2 == null) {
                HiLog.d("RedirectReference", "redirectBean is empty");
            } else {
                String str2 = lmn2.lmn;
                String str3 = lmn2.klm;
                try {
                    if (TextUtils.isEmpty(str2)) {
                        str = "referrerEx is empty";
                    } else if (TextUtils.isEmpty(str3)) {
                        str = "installTimeStr is empty";
                    } else {
                        Class.forName("com.huawei.hms.analytics.extended.Plugin").getMethod(GlobalConstants.ExtraNames.REDIRECT, new Class[]{Context.class, cls, cls}).invoke((Object) null, new Object[]{dcVar.lmn, str2, str3});
                    }
                    HiLog.d("RedirectReference", str);
                } catch (Exception e11) {
                    HiLog.w("RedirectReference", "redirect fail:" + e11.getMessage());
                }
            }
            dv.lmn(this.lmn, "global_v2", "isAdRedirect", true);
        }
    }
}
