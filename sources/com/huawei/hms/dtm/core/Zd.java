package com.huawei.hms.dtm.core;

import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.huawei.hms.dtm.core.util.Logger;

public class Zd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebView f48442a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ _d f48443b;

    public Zd(_d _dVar, WebView webView) {
        this.f48443b = _dVar;
        this.f48442a = webView;
    }

    public void run() {
        Logger.info("DTM-AutoTrace", "JsManager.setJsInterface.");
        String url = this.f48442a.getUrl();
        if (TextUtils.isEmpty(url) || url.contains("http://")) {
            Logger.info("DTM-AutoTrace", "url is empty or not https url");
            return;
        }
        Wd wd2 = new Wd();
        this.f48442a.addJavascriptInterface(wd2, "JsBridge");
        this.f48443b.f48446c.put(String.valueOf(this.f48442a.hashCode()), wd2);
        if (Build.VERSION.SDK_INT >= 26) {
            WebViewClient a11 = this.f48442a.getWebViewClient();
            if (!(a11 instanceof Vd)) {
                Vd vd2 = new Vd(a11);
                vd2.a(this.f48443b.f48444a);
                this.f48442a.setWebViewClient(vd2);
                this.f48443b.f48445b.put(String.valueOf(this.f48442a.hashCode()), vd2);
                return;
            }
            this.f48443b.f48445b.put(String.valueOf(this.f48442a.hashCode()), (Vd) a11);
            return;
        }
        Logger.info("DTM-AutoTrace", "sdk version is less than 26, skip WebView trace");
    }
}
