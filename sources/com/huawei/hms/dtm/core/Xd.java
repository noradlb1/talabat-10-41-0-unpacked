package com.huawei.hms.dtm.core;

import android.text.TextUtils;
import com.huawei.hms.dtm.core.util.Logger;

public class Xd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Yd f48439a;

    public Xd(Yd yd2) {
        this.f48439a = yd2;
    }

    public void run() {
        String str;
        String b11 = C0421pd.b();
        if (TextUtils.isEmpty(b11)) {
            Logger.error("DTM-AutoTrace", "failed to get url from grs.");
        }
        String str2 = b11 + "/download/web/dtm-wv-vt.js?sdkversion=" + 60600302;
        Logger.test("js download url:" + str2);
        String a11 = this.f48439a.a(str2);
        if (TextUtils.isEmpty(a11)) {
            str = "failed to download dtm-wv-vt.js.";
        } else {
            C0416od.a(a11, "dtm-wv-vt.js");
            str = "download dtm-wv-vt.js success.";
        }
        Logger.info("DTM-AutoTrace", str);
    }
}
