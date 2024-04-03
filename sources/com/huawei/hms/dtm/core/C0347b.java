package com.huawei.hms.dtm.core;

import android.app.Activity;
import com.huawei.hms.dtm.core.util.Logger;

/* renamed from: com.huawei.hms.dtm.core.b  reason: case insensitive filesystem */
public class C0347b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f48451a;

    public C0347b(Activity activity) {
        this.f48451a = activity;
    }

    public void run() {
        Logger.info("DTM-AutoTrace", "init#onActivityResumed");
        C0352c.f48453b.onActivityResumed(this.f48451a);
    }
}
