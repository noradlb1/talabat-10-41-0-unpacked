package com.huawei.hms.dtm.core;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.huawei.hms.dtm.core.util.Logger;

class Vd extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    private final WebViewClient f48426a;

    /* renamed from: b  reason: collision with root package name */
    private float f48427b = 1.0f;

    /* renamed from: c  reason: collision with root package name */
    private float f48428c = 1.0f;

    public Vd(WebViewClient webViewClient) {
        this.f48426a = webViewClient;
    }

    public float a() {
        return this.f48428c;
    }

    public void a(float f11) {
        this.f48427b = f11;
    }

    public void doUpdateVisitedHistory(WebView webView, String str, boolean z11) {
        WebViewClient webViewClient = this.f48426a;
        if (webViewClient != null) {
            webViewClient.doUpdateVisitedHistory(webView, str, z11);
        } else {
            super.doUpdateVisitedHistory(webView, str, z11);
        }
    }

    public void onFormResubmission(WebView webView, Message message, Message message2) {
        WebViewClient webViewClient = this.f48426a;
        if (webViewClient != null) {
            webViewClient.onFormResubmission(webView, message, message2);
        } else {
            super.onFormResubmission(webView, message, message2);
        }
    }

    public void onLoadResource(WebView webView, String str) {
        WebViewClient webViewClient = this.f48426a;
        if (webViewClient != null) {
            webViewClient.onLoadResource(webView, str);
        } else {
            super.onLoadResource(webView, str);
        }
    }

    public void onPageCommitVisible(WebView webView, String str) {
        WebViewClient webViewClient = this.f48426a;
        if (webViewClient != null) {
            webViewClient.onPageCommitVisible(webView, str);
        } else {
            super.onPageCommitVisible(webView, str);
        }
    }

    public void onPageFinished(WebView webView, String str) {
        WebViewClient webViewClient = this.f48426a;
        if (webViewClient != null) {
            webViewClient.onPageFinished(webView, str);
        } else {
            super.onPageFinished(webView, str);
        }
        Logger.info("DTM-AutoTrace", "DelegateWebViewClient.onPageFinished.#" + str);
        webView.evaluateJavascript(C0416od.a(Ed.d().f() ? "dtm-wv-vt.js" : "dtm-tracker.js"), new Ud(this));
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        WebViewClient webViewClient = this.f48426a;
        if (webViewClient != null) {
            webViewClient.onPageStarted(webView, str, bitmap);
        } else {
            super.onPageStarted(webView, str, bitmap);
        }
    }

    public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        WebViewClient webViewClient = this.f48426a;
        if (webViewClient != null) {
            webViewClient.onReceivedClientCertRequest(webView, clientCertRequest);
        } else {
            super.onReceivedClientCertRequest(webView, clientCertRequest);
        }
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        WebViewClient webViewClient = this.f48426a;
        if (webViewClient != null) {
            webViewClient.onReceivedError(webView, webResourceRequest, webResourceError);
        } else {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }
    }

    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        WebViewClient webViewClient = this.f48426a;
        if (webViewClient != null) {
            webViewClient.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        } else {
            super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        }
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        WebViewClient webViewClient = this.f48426a;
        if (webViewClient != null) {
            webViewClient.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        } else {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        }
    }

    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        WebViewClient webViewClient = this.f48426a;
        if (webViewClient != null) {
            webViewClient.onReceivedLoginRequest(webView, str, str2, str3);
        } else {
            super.onReceivedLoginRequest(webView, str, str2, str3);
        }
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        WebViewClient webViewClient = this.f48426a;
        if (webViewClient != null) {
            webViewClient.onReceivedSslError(webView, sslErrorHandler, sslError);
        } else {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        WebViewClient webViewClient = this.f48426a;
        return (webViewClient == null || Build.VERSION.SDK_INT < 26) ? super.onRenderProcessGone(webView, renderProcessGoneDetail) : webViewClient.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    public void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i11, SafeBrowsingResponse safeBrowsingResponse) {
        WebViewClient webViewClient = this.f48426a;
        if (webViewClient == null || Build.VERSION.SDK_INT < 27) {
            super.onSafeBrowsingHit(webView, webResourceRequest, i11, safeBrowsingResponse);
        } else {
            webViewClient.onSafeBrowsingHit(webView, webResourceRequest, i11, safeBrowsingResponse);
        }
    }

    public void onScaleChanged(WebView webView, float f11, float f12) {
        WebViewClient webViewClient = this.f48426a;
        if (webViewClient != null) {
            webViewClient.onScaleChanged(webView, f11, f12);
        } else {
            super.onScaleChanged(webView, f11, f12);
        }
        this.f48428c = f12 / this.f48427b;
        Logger.info("DTM-AutoTrace", "onScaleChanged.# " + this.f48428c);
    }

    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        WebViewClient webViewClient = this.f48426a;
        if (webViewClient != null) {
            webViewClient.onUnhandledKeyEvent(webView, keyEvent);
        } else {
            super.onUnhandledKeyEvent(webView, keyEvent);
        }
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        WebViewClient webViewClient = this.f48426a;
        return webViewClient != null ? webViewClient.shouldInterceptRequest(webView, webResourceRequest) : super.shouldInterceptRequest(webView, webResourceRequest);
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        WebViewClient webViewClient = this.f48426a;
        return webViewClient != null ? webViewClient.shouldOverrideKeyEvent(webView, keyEvent) : super.shouldOverrideKeyEvent(webView, keyEvent);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        WebViewClient webViewClient = this.f48426a;
        return (webViewClient == null || Build.VERSION.SDK_INT < 24) ? super.shouldOverrideUrlLoading(webView, webResourceRequest) : webViewClient.shouldOverrideUrlLoading(webView, webResourceRequest);
    }
}
