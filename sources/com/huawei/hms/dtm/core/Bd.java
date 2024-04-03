package com.huawei.hms.dtm.core;

import android.app.Activity;

public interface Bd {
    void a();

    void b();

    void c();

    void onActivityPaused(Activity activity);

    void onActivityResumed(Activity activity);

    void onConnected();
}
