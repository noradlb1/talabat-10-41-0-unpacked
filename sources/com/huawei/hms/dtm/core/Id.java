package com.huawei.hms.dtm.core;

import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.huawei.hms.dtm.core.util.Logger;

public class Id implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebView f48320a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ValueCallback f48321b;

    public Id(WebView webView, ValueCallback valueCallback) {
        this.f48320a = webView;
        this.f48321b = valueCallback;
    }

    public void run() {
        float a11 = _d.b().a(this.f48320a);
        float a12 = _d.b().a();
        String str = a11 + "," + (((float) (-this.f48320a.getScrollX())) / a12) + "," + (((float) (-this.f48320a.getScrollY())) / a12);
        Logger.info("DTM-AutoTrace", "__dtmGetViewTree param： " + str);
        this.f48320a.evaluateJavascript("javascript:__dtmGetViewTree(" + str + ")", this.f48321b);
    }
}
