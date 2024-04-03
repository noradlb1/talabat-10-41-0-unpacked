package com.huawei.hms.dtm.core;

import android.webkit.ValueCallback;
import com.huawei.hms.dtm.core.util.Logger;

public class Ud implements ValueCallback<String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Vd f48424a;

    public Ud(Vd vd2) {
        this.f48424a = vd2;
    }

    /* renamed from: a */
    public void onReceiveValue(String str) {
        Logger.info("DTM-AutoTrace", "inject JS.#" + str);
    }
}
