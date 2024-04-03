package com.huawei.hms.dtm.core.util;

import android.app.Activity;
import android.widget.Toast;

public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f48625a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f48626b;

    public e(Activity activity, String str) {
        this.f48625a = activity;
        this.f48626b = str;
    }

    public void run() {
        Toast.makeText(this.f48625a, this.f48626b, 0).show();
    }
}
