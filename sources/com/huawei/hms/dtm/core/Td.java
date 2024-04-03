package com.huawei.hms.dtm.core;

import android.app.Activity;
import com.huawei.hms.dtm.core.util.Logger;
import com.huawei.hms.dtm.core.util.f;

public class Td implements Bd {
    public void a() {
        Logger.warn("DTM-AutoTrace", "DefaultState#onFailure");
        f.a(J.a(R.string.dtm_visual_toast_connect_failed));
    }

    public void b() {
        Logger.warn("DTM-AutoTrace", "DefaultState#dispatchTouchEvent");
    }

    public void c() {
        Logger.warn("DTM-AutoTrace", "DefaultState#onDisconnected");
    }

    public void onActivityPaused(Activity activity) {
        Logger.warn("DTM-AutoTrace", "DefaultState#onActivityPaused");
    }

    public void onActivityResumed(Activity activity) {
        Logger.warn("DTM-AutoTrace", "DefaultState#onActivityResumed");
    }

    public void onConnected() {
        Logger.warn("DTM-AutoTrace", "DefaultState#onConnected");
    }
}
