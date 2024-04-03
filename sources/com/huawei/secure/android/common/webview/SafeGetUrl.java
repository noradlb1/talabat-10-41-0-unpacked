package com.huawei.secure.android.common.webview;

import android.util.Log;
import android.webkit.WebView;
import com.huawei.secure.android.common.util.b;
import com.huawei.secure.android.common.util.c;
import java.util.concurrent.CountDownLatch;

public class SafeGetUrl {

    /* renamed from: c  reason: collision with root package name */
    private static final String f34020c = "SafeGetUrl";

    /* renamed from: d  reason: collision with root package name */
    private static final long f34021d = 200;

    /* renamed from: a  reason: collision with root package name */
    private String f34022a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public WebView f34023b;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f34024b;

        public a(CountDownLatch countDownLatch) {
            this.f34024b = countDownLatch;
        }

        public void run() {
            SafeGetUrl safeGetUrl = SafeGetUrl.this;
            safeGetUrl.setUrl(safeGetUrl.f34023b.getUrl());
            this.f34024b.countDown();
        }
    }

    public SafeGetUrl() {
    }

    public String getUrlMethod() {
        if (this.f34023b == null) {
            return "";
        }
        if (b.a()) {
            return this.f34023b.getUrl();
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        c.a(new a(countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e11) {
            Log.e(f34020c, "getUrlMethod: InterruptedException " + e11.getMessage(), e11);
        }
        return this.f34022a;
    }

    public WebView getWebView() {
        return this.f34023b;
    }

    public void setUrl(String str) {
        this.f34022a = str;
    }

    public void setWebView(WebView webView) {
        this.f34023b = webView;
    }

    public SafeGetUrl(WebView webView) {
        this.f34023b = webView;
    }
}
