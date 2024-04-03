package com.huawei.secure.android.common.webview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.huawei.secure.android.common.util.LogsUtil;
import com.huawei.secure.android.common.webview.WebViewLoadCallBack;
import java.util.Arrays;
import java.util.Map;

public class SafeWebView extends WebView {

    /* renamed from: f  reason: collision with root package name */
    private static final String f34026f = "SafeWebView";

    /* renamed from: a  reason: collision with root package name */
    private String f34027a;

    /* renamed from: b  reason: collision with root package name */
    private String[] f34028b;

    /* renamed from: c  reason: collision with root package name */
    private String[] f34029c;

    /* renamed from: d  reason: collision with root package name */
    private String[] f34030d;

    /* renamed from: e  reason: collision with root package name */
    private WebViewLoadCallBack f34031e;

    public final class b extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        private WebViewClient f34032a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f34033b;

        public void doUpdateVisitedHistory(WebView webView, String str, boolean z11) {
            WebViewClient webViewClient = this.f34032a;
            if (webViewClient != null) {
                webViewClient.doUpdateVisitedHistory(webView, str, z11);
            } else {
                super.doUpdateVisitedHistory(webView, str, z11);
            }
        }

        public void onFormResubmission(WebView webView, Message message, Message message2) {
            WebViewClient webViewClient = this.f34032a;
            if (webViewClient != null) {
                webViewClient.onFormResubmission(webView, message, message2);
            } else {
                super.onFormResubmission(webView, message, message2);
            }
        }

        public void onLoadResource(WebView webView, String str) {
            WebViewClient webViewClient = this.f34032a;
            if (webViewClient != null) {
                webViewClient.onLoadResource(webView, str);
            } else {
                super.onLoadResource(webView, str);
            }
        }

        @TargetApi(23)
        public void onPageCommitVisible(WebView webView, String str) {
            WebViewClient webViewClient = this.f34032a;
            if (webViewClient != null) {
                webViewClient.onPageCommitVisible(webView, str);
            } else {
                super.onPageCommitVisible(webView, str);
            }
        }

        public void onPageFinished(WebView webView, String str) {
            WebViewClient webViewClient = this.f34032a;
            if (webViewClient != null) {
                webViewClient.onPageFinished(webView, str);
            } else {
                super.onPageFinished(webView, str);
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            WebViewClient webViewClient = this.f34032a;
            if (webViewClient != null && !this.f34033b) {
                webViewClient.onPageStarted(webView, str, bitmap);
            } else if (!SafeWebView.this.isWhiteListUrl(str)) {
                SafeWebView.this.onCheckError(webView, str);
            } else {
                super.onPageStarted(webView, str, bitmap);
            }
        }

        @TargetApi(21)
        public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
            WebViewClient webViewClient = this.f34032a;
            if (webViewClient != null) {
                webViewClient.onReceivedClientCertRequest(webView, clientCertRequest);
            } else {
                super.onReceivedClientCertRequest(webView, clientCertRequest);
            }
        }

        public void onReceivedError(WebView webView, int i11, String str, String str2) {
            WebViewClient webViewClient = this.f34032a;
            if (webViewClient != null) {
                webViewClient.onReceivedError(webView, i11, str, str2);
            } else {
                super.onReceivedError(webView, i11, str, str2);
            }
        }

        public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            WebViewClient webViewClient = this.f34032a;
            if (webViewClient != null) {
                webViewClient.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            } else {
                super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            }
        }

        @TargetApi(23)
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            WebViewClient webViewClient = this.f34032a;
            if (webViewClient != null) {
                webViewClient.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            } else {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }
        }

        @TargetApi(12)
        public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
            WebViewClient webViewClient = this.f34032a;
            if (webViewClient != null) {
                webViewClient.onReceivedLoginRequest(webView, str, str2, str3);
            } else {
                super.onReceivedLoginRequest(webView, str, str2, str3);
            }
        }

        @TargetApi(8)
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            WebViewClient webViewClient = this.f34032a;
            if (webViewClient != null) {
                webViewClient.onReceivedSslError(webView, sslErrorHandler, sslError);
            } else {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }

        @SuppressLint({"NewApi"})
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            WebViewClient webViewClient = this.f34032a;
            if (webViewClient != null) {
                return webViewClient.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            return super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }

        @SuppressLint({"NewApi"})
        public void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i11, SafeBrowsingResponse safeBrowsingResponse) {
            WebViewClient webViewClient = this.f34032a;
            if (webViewClient != null) {
                webViewClient.onSafeBrowsingHit(webView, webResourceRequest, i11, safeBrowsingResponse);
            } else {
                super.onSafeBrowsingHit(webView, webResourceRequest, i11, safeBrowsingResponse);
            }
        }

        public void onScaleChanged(WebView webView, float f11, float f12) {
            WebViewClient webViewClient = this.f34032a;
            if (webViewClient != null) {
                webViewClient.onScaleChanged(webView, f11, f12);
            } else {
                super.onScaleChanged(webView, f11, f12);
            }
        }

        public void onTooManyRedirects(WebView webView, Message message, Message message2) {
            WebViewClient webViewClient = this.f34032a;
            if (webViewClient != null) {
                webViewClient.onTooManyRedirects(webView, message, message2);
            } else {
                super.onTooManyRedirects(webView, message, message2);
            }
        }

        public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
            WebViewClient webViewClient = this.f34032a;
            if (webViewClient != null) {
                webViewClient.onUnhandledKeyEvent(webView, keyEvent);
            } else {
                super.onUnhandledKeyEvent(webView, keyEvent);
            }
        }

        @TargetApi(21)
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            WebViewClient webViewClient = this.f34032a;
            if (webViewClient != null) {
                return webViewClient.shouldInterceptRequest(webView, webResourceRequest);
            }
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
            WebViewClient webViewClient = this.f34032a;
            if (webViewClient != null) {
                return webViewClient.shouldOverrideKeyEvent(webView, keyEvent);
            }
            return super.shouldOverrideKeyEvent(webView, keyEvent);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            WebViewClient webViewClient = this.f34032a;
            if (webViewClient != null) {
                return webViewClient.shouldOverrideUrlLoading(webView, str);
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        private b(WebViewClient webViewClient, boolean z11) {
            this.f34032a = webViewClient;
            this.f34033b = z11;
        }

        @TargetApi(23)
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            WebViewClient webViewClient = this.f34032a;
            if (webViewClient != null) {
                webViewClient.onReceivedError(webView, webResourceRequest, webResourceError);
            } else {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }
        }

        @TargetApi(11)
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            WebViewClient webViewClient = this.f34032a;
            if (webViewClient != null) {
                return webViewClient.shouldInterceptRequest(webView, str);
            }
            return super.shouldInterceptRequest(webView, str);
        }

        @TargetApi(24)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            WebViewClient webViewClient = this.f34032a;
            if (webViewClient != null) {
                return webViewClient.shouldOverrideUrlLoading(webView, webResourceRequest);
            }
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
    }

    public SafeWebView(Context context) {
        super(context);
        a();
    }

    private boolean a(String str) {
        return URLUtil.isHttpUrl(str);
    }

    public String getDefaultErrorPage() {
        return this.f34027a;
    }

    public WebViewLoadCallBack getWebViewLoadCallBack() {
        return this.f34031e;
    }

    @TargetApi(9)
    @Deprecated
    public String[] getWhitelist() {
        String[] strArr = this.f34028b;
        if (strArr == null) {
            return null;
        }
        return (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    public String[] getWhitelistNotMatchSubDomain() {
        String[] strArr = this.f34029c;
        if (strArr == null) {
            return null;
        }
        return (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    @Deprecated
    public String[] getWhitelistNotMathcSubDomain() {
        String[] strArr = this.f34029c;
        if (strArr == null) {
            return null;
        }
        return (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    @TargetApi(9)
    public String[] getWhitelistWithPath() {
        String[] strArr = this.f34030d;
        if (strArr == null) {
            return null;
        }
        return (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    @TargetApi(9)
    public boolean isWhiteListUrl(String str) {
        boolean z11;
        boolean z12;
        boolean z13 = false;
        if (TextUtils.isEmpty(str)) {
            LogsUtil.e(f34026f, "url is null");
            return false;
        } else if (!URLUtil.isNetworkUrl(str)) {
            return true;
        } else {
            String[] whitelistWithPath = getWhitelistWithPath();
            String[] whitelistNotMatchSubDomain = getWhitelistNotMatchSubDomain();
            String[] whitelist = getWhitelist();
            if (whitelistWithPath == null || whitelistWithPath.length == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (whitelistNotMatchSubDomain == null || whitelistNotMatchSubDomain.length == 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (whitelist == null || whitelist.length == 0) {
                z13 = true;
            }
            if (z11 && z12 && z13) {
                return true;
            }
            if (whitelistWithPath != null && whitelistWithPath.length != 0) {
                return UriUtil.isUrlHostAndPathInWhitelist(str, whitelistWithPath);
            }
            if (whitelistNotMatchSubDomain == null || whitelistNotMatchSubDomain.length == 0) {
                return UriUtil.isUrlHostInWhitelist(str, whitelist);
            }
            return UriUtil.isUrlHostSameWhitelist(str, whitelistNotMatchSubDomain);
        }
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (a(str)) {
            Log.e(f34026f, "loadDataWithBaseURL: http url , not safe");
            if (!TextUtils.isEmpty(this.f34027a)) {
                super.loadDataWithBaseURL(this.f34027a, str2, str3, str4, str5);
            } else if (getWebViewLoadCallBack() != null) {
                Log.e(f34026f, "WebViewLoadCallBack");
                getWebViewLoadCallBack().onCheckError(str, WebViewLoadCallBack.ErrorCode.HTTP_URL);
            }
        } else {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    public void loadUrl(String str) {
        if (!isWhiteListUrl(str) || a(str)) {
            Log.e(f34026f, "loadUrl: url is not in white list or http url not safe");
            if (!TextUtils.isEmpty(this.f34027a)) {
                super.loadUrl(this.f34027a);
            } else if (getWebViewLoadCallBack() != null) {
                Log.e(f34026f, "WebViewLoadCallBack");
                getWebViewLoadCallBack().onCheckError(str, WebViewLoadCallBack.ErrorCode.HTTP_URL);
            }
        } else {
            super.loadUrl(str);
        }
    }

    public final void onCheckError(WebView webView, String str) {
        LogsUtil.e(f34026f, "onCheckError url is not in white list ", str);
        webView.stopLoading();
        String defaultErrorPage = getDefaultErrorPage();
        if (!TextUtils.isEmpty(defaultErrorPage)) {
            webView.loadUrl(defaultErrorPage);
        } else if (getWebViewLoadCallBack() != null) {
            Log.e(f34026f, "onPageStarted WebViewLoadCallBack");
            getWebViewLoadCallBack().onCheckError(str, WebViewLoadCallBack.ErrorCode.URL_NOT_IN_WHITE_LIST);
        }
    }

    public void postUrl(String str, byte[] bArr) {
        if (!isWhiteListUrl(str) || a(str)) {
            Log.e(f34026f, "postUrl: url is not in white list or http url not safe");
            if (!TextUtils.isEmpty(this.f34027a)) {
                super.postUrl(this.f34027a, bArr);
            } else if (getWebViewLoadCallBack() != null) {
                Log.e(f34026f, "WebViewLoadCallBack");
                getWebViewLoadCallBack().onCheckError(str, WebViewLoadCallBack.ErrorCode.HTTP_URL);
            }
        } else {
            super.postUrl(str, bArr);
        }
    }

    public void setDefaultErrorPage(String str) {
        this.f34027a = str;
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(new b(webViewClient, true));
    }

    public void setWebViewLoadCallBack(WebViewLoadCallBack webViewLoadCallBack) {
        this.f34031e = webViewLoadCallBack;
    }

    @TargetApi(9)
    @Deprecated
    public void setWhitelist(String[] strArr) {
        this.f34028b = strArr == null ? null : (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    public void setWhitelistNotMatchSubDomain(String[] strArr) {
        String[] strArr2;
        if (strArr == null) {
            strArr2 = null;
        } else {
            strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
        }
        this.f34029c = strArr2;
    }

    @Deprecated
    public void setWhitelistNotMathcSubDomain(String[] strArr) {
        String[] strArr2;
        if (strArr == null) {
            strArr2 = null;
        } else {
            strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
        }
        this.f34029c = strArr2;
    }

    @TargetApi(9)
    public void setWhitelistWithPath(String[] strArr) {
        String[] strArr2;
        if (strArr == null) {
            strArr2 = null;
        } else {
            strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
        }
        this.f34030d = strArr2;
    }

    private void a() {
        SafeWebSettings.initWebviewAndSettings(this);
        setWebViewClient((WebViewClient) null);
    }

    public void setWebViewClient(WebViewClient webViewClient, boolean z11) {
        super.setWebViewClient(new b(webViewClient, z11));
    }

    public SafeWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public SafeWebView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a();
    }

    @TargetApi(21)
    public SafeWebView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        a();
    }

    public void loadUrl(String str, Map<String, String> map) {
        if (!isWhiteListUrl(str) || a(str)) {
            Log.e(f34026f, "loadUrl: url is not in white list or http url not safe");
            if (!TextUtils.isEmpty(this.f34027a)) {
                super.loadUrl(this.f34027a, map);
            } else if (getWebViewLoadCallBack() != null) {
                Log.e(f34026f, "WebViewLoadCallBack");
                getWebViewLoadCallBack().onCheckError(str, WebViewLoadCallBack.ErrorCode.HTTP_URL);
            }
        } else {
            super.loadUrl(str, map);
        }
    }
}
