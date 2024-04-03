package io.flutter.plugins.webviewflutter;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.KeyEvent;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.webkit.WebResourceErrorCompat;
import androidx.webkit.WebViewClientCompat;
import e00.a4;
import e00.b4;
import e00.c4;
import e00.d4;
import e00.e4;
import e00.f4;
import e00.g4;
import e00.h4;
import e00.i4;
import e00.j4;
import e00.w3;
import e00.x3;
import e00.y3;
import e00.z3;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import java.util.Objects;

public class WebViewClientHostApiImpl implements GeneratedAndroidWebView.WebViewClientHostApi {
    private final WebViewClientFlutterApiImpl flutterApi;
    private final InstanceManager instanceManager;
    private final WebViewClientCreator webViewClientCreator;

    public static class WebViewClientCompatImpl extends WebViewClientCompat {
        private final WebViewClientFlutterApiImpl flutterApi;
        private boolean returnValueForShouldOverrideUrlLoading = false;

        public WebViewClientCompatImpl(@NonNull WebViewClientFlutterApiImpl webViewClientFlutterApiImpl) {
            this.flutterApi = webViewClientFlutterApiImpl;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$doUpdateVisitedHistory$6(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onPageFinished$1(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onPageStarted$0(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onReceivedError$2(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onReceivedError$3(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$shouldOverrideUrlLoading$4(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$shouldOverrideUrlLoading$5(Void voidR) {
        }

        public void doUpdateVisitedHistory(@NonNull WebView webView, @NonNull String str, boolean z11) {
            this.flutterApi.doUpdateVisitedHistory(this, webView, str, z11, new w3());
        }

        public void onPageFinished(@NonNull WebView webView, @NonNull String str) {
            this.flutterApi.onPageFinished(this, webView, str, new x3());
        }

        public void onPageStarted(@NonNull WebView webView, @NonNull String str, @NonNull Bitmap bitmap) {
            this.flutterApi.onPageStarted(this, webView, str, new c4());
        }

        @RequiresApi(api = 21)
        @SuppressLint({"RequiresFeature"})
        public void onReceivedError(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest, @NonNull WebResourceErrorCompat webResourceErrorCompat) {
            this.flutterApi.onReceivedRequestError((WebViewClient) this, webView, webResourceRequest, webResourceErrorCompat, (GeneratedAndroidWebView.WebViewClientFlutterApi.Reply<Void>) new y3());
        }

        public void onUnhandledKeyEvent(@NonNull WebView webView, @NonNull KeyEvent keyEvent) {
        }

        public void setReturnValueForShouldOverrideUrlLoading(boolean z11) {
            this.returnValueForShouldOverrideUrlLoading = z11;
        }

        @TargetApi(21)
        public boolean shouldOverrideUrlLoading(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest) {
            this.flutterApi.requestLoading(this, webView, webResourceRequest, new a4());
            return this.returnValueForShouldOverrideUrlLoading;
        }

        public void onReceivedError(@NonNull WebView webView, int i11, @NonNull String str, @NonNull String str2) {
            this.flutterApi.onReceivedError(this, webView, Long.valueOf((long) i11), str, str2, new b4());
        }

        public boolean shouldOverrideUrlLoading(@NonNull WebView webView, @NonNull String str) {
            this.flutterApi.urlLoading(this, webView, str, new z3());
            return this.returnValueForShouldOverrideUrlLoading;
        }
    }

    public static class WebViewClientCreator {
        @NonNull
        public WebViewClient createWebViewClient(@NonNull WebViewClientFlutterApiImpl webViewClientFlutterApiImpl) {
            if (Build.VERSION.SDK_INT >= 24) {
                return new WebViewClientImpl(webViewClientFlutterApiImpl);
            }
            return new WebViewClientCompatImpl(webViewClientFlutterApiImpl);
        }
    }

    @RequiresApi(24)
    public static class WebViewClientImpl extends WebViewClient {
        private final WebViewClientFlutterApiImpl flutterApi;
        private boolean returnValueForShouldOverrideUrlLoading = false;

        public WebViewClientImpl(@NonNull WebViewClientFlutterApiImpl webViewClientFlutterApiImpl) {
            this.flutterApi = webViewClientFlutterApiImpl;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$doUpdateVisitedHistory$6(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onPageFinished$1(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onPageStarted$0(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onReceivedError$2(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onReceivedError$3(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$shouldOverrideUrlLoading$4(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$shouldOverrideUrlLoading$5(Void voidR) {
        }

        public void doUpdateVisitedHistory(@NonNull WebView webView, @NonNull String str, boolean z11) {
            this.flutterApi.doUpdateVisitedHistory(this, webView, str, z11, new f4());
        }

        public void onPageFinished(@NonNull WebView webView, @NonNull String str) {
            this.flutterApi.onPageFinished(this, webView, str, new e4());
        }

        public void onPageStarted(@NonNull WebView webView, @NonNull String str, @NonNull Bitmap bitmap) {
            this.flutterApi.onPageStarted(this, webView, str, new d4());
        }

        public void onReceivedError(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest, @NonNull WebResourceError webResourceError) {
            this.flutterApi.onReceivedRequestError((WebViewClient) this, webView, webResourceRequest, webResourceError, (GeneratedAndroidWebView.WebViewClientFlutterApi.Reply<Void>) new j4());
        }

        public void onUnhandledKeyEvent(@NonNull WebView webView, @NonNull KeyEvent keyEvent) {
        }

        public void setReturnValueForShouldOverrideUrlLoading(boolean z11) {
            this.returnValueForShouldOverrideUrlLoading = z11;
        }

        public boolean shouldOverrideUrlLoading(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest) {
            this.flutterApi.requestLoading(this, webView, webResourceRequest, new i4());
            return this.returnValueForShouldOverrideUrlLoading;
        }

        public void onReceivedError(@NonNull WebView webView, int i11, @NonNull String str, @NonNull String str2) {
            this.flutterApi.onReceivedError(this, webView, Long.valueOf((long) i11), str, str2, new g4());
        }

        public boolean shouldOverrideUrlLoading(@NonNull WebView webView, @NonNull String str) {
            this.flutterApi.urlLoading(this, webView, str, new h4());
            return this.returnValueForShouldOverrideUrlLoading;
        }
    }

    public WebViewClientHostApiImpl(@NonNull InstanceManager instanceManager2, @NonNull WebViewClientCreator webViewClientCreator2, @NonNull WebViewClientFlutterApiImpl webViewClientFlutterApiImpl) {
        this.instanceManager = instanceManager2;
        this.webViewClientCreator = webViewClientCreator2;
        this.flutterApi = webViewClientFlutterApiImpl;
    }

    public void create(@NonNull Long l11) {
        this.instanceManager.addDartCreatedInstance(this.webViewClientCreator.createWebViewClient(this.flutterApi), l11.longValue());
    }

    public void setSynchronousReturnValueForShouldOverrideUrlLoading(@NonNull Long l11, @NonNull Boolean bool) {
        WebViewClient webViewClient = (WebViewClient) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(webViewClient);
        if (webViewClient instanceof WebViewClientCompatImpl) {
            ((WebViewClientCompatImpl) webViewClient).setReturnValueForShouldOverrideUrlLoading(bool.booleanValue());
        } else if (Build.VERSION.SDK_INT < 24 || !(webViewClient instanceof WebViewClientImpl)) {
            throw new IllegalStateException("This WebViewClient doesn't support setting the returnValueForShouldOverrideUrlLoading.");
        } else {
            ((WebViewClientImpl) webViewClient).setReturnValueForShouldOverrideUrlLoading(bool.booleanValue());
        }
    }
}
