package com.visa.checkout;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.CookieManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

final class c extends WebView {

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean f151 = false;

    public c(Context context) {
        super(context);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDomStorageEnabled(true);
        CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setBackgroundColor(context.getResources().getColor(R.color.transparent));
        setWebViewClient(new WebViewClient() {
            public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                c.this.setVisibility(0);
            }

            public final void onReceivedError(WebView webView, int i11, String str, String str2) {
                super.onReceivedError(webView, i11, str, str2);
                c.this.setVisibility(4);
            }

            @TargetApi(23)
            public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                if (webResourceRequest.isForMainFrame()) {
                    c.this.setVisibility(4);
                }
            }

            public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }

            @TargetApi(23)
            public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame()) {
                    c.this.setVisibility(4);
                }
            }
        });
    }

    public final void computeScroll() {
    }

    public final boolean overScrollBy(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, boolean z11) {
        return false;
    }

    public final void scrollTo(int i11, int i12) {
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final boolean m6121() {
        return this.f151;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m6120(boolean z11) {
        this.f151 = z11;
    }
}
