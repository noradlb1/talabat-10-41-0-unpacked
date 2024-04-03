package io.flutter.plugins.webviewflutter;

import android.annotation.SuppressLint;
import android.os.Build;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.webkit.WebResourceErrorCompat;
import e00.o3;
import e00.p3;
import e00.q3;
import e00.r3;
import e00.s3;
import e00.t3;
import e00.u3;
import e00.v3;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WebViewClientFlutterApiImpl extends GeneratedAndroidWebView.WebViewClientFlutterApi {
    private final BinaryMessenger binaryMessenger;
    private final InstanceManager instanceManager;
    private final WebViewFlutterApiImpl webViewFlutterApi;

    public WebViewClientFlutterApiImpl(@NonNull BinaryMessenger binaryMessenger2, @NonNull InstanceManager instanceManager2) {
        super(binaryMessenger2);
        this.binaryMessenger = binaryMessenger2;
        this.instanceManager = instanceManager2;
        this.webViewFlutterApi = new WebViewFlutterApiImpl(binaryMessenger2, instanceManager2);
    }

    private long getIdentifierForClient(WebViewClient webViewClient) {
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(webViewClient);
        if (identifierForStrongReference != null) {
            return identifierForStrongReference.longValue();
        }
        throw new IllegalStateException("Could not find identifier for WebViewClient.");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$doUpdateVisitedHistory$7(Void voidR) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onPageFinished$1(Void voidR) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onPageStarted$0(Void voidR) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onReceivedError$4(Void voidR) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onReceivedRequestError$2(Void voidR) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onReceivedRequestError$3(Void voidR) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$requestLoading$5(Void voidR) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$urlLoading$6(Void voidR) {
    }

    @RequiresApi(api = 23)
    public static GeneratedAndroidWebView.WebResourceErrorData q(WebResourceError webResourceError) {
        return new GeneratedAndroidWebView.WebResourceErrorData.Builder().setErrorCode(Long.valueOf((long) webResourceError.getErrorCode())).setDescription(webResourceError.getDescription().toString()).build();
    }

    @SuppressLint({"RequiresFeature"})
    public static GeneratedAndroidWebView.WebResourceErrorData r(WebResourceErrorCompat webResourceErrorCompat) {
        return new GeneratedAndroidWebView.WebResourceErrorData.Builder().setErrorCode(Long.valueOf((long) webResourceErrorCompat.getErrorCode())).setDescription(webResourceErrorCompat.getDescription().toString()).build();
    }

    @RequiresApi(api = 21)
    public static GeneratedAndroidWebView.WebResourceRequestData s(WebResourceRequest webResourceRequest) {
        Map map;
        GeneratedAndroidWebView.WebResourceRequestData.Builder method = new GeneratedAndroidWebView.WebResourceRequestData.Builder().setUrl(webResourceRequest.getUrl().toString()).setIsForMainFrame(Boolean.valueOf(webResourceRequest.isForMainFrame())).setHasGesture(Boolean.valueOf(webResourceRequest.hasGesture())).setMethod(webResourceRequest.getMethod());
        if (webResourceRequest.getRequestHeaders() != null) {
            map = webResourceRequest.getRequestHeaders();
        } else {
            map = new HashMap();
        }
        GeneratedAndroidWebView.WebResourceRequestData.Builder requestHeaders = method.setRequestHeaders(map);
        if (Build.VERSION.SDK_INT >= 24) {
            requestHeaders.setIsRedirect(Boolean.valueOf(webResourceRequest.isRedirect()));
        }
        return requestHeaders.build();
    }

    public void doUpdateVisitedHistory(@NonNull WebViewClient webViewClient, @NonNull WebView webView, @NonNull String str, boolean z11, @NonNull GeneratedAndroidWebView.WebViewClientFlutterApi.Reply<Void> reply) {
        this.webViewFlutterApi.create(webView, new p3());
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(webView);
        Objects.requireNonNull(identifierForStrongReference);
        doUpdateVisitedHistory(Long.valueOf(getIdentifierForClient(webViewClient)), identifierForStrongReference, str, Boolean.valueOf(z11), reply);
    }

    public void onPageFinished(@NonNull WebViewClient webViewClient, @NonNull WebView webView, @NonNull String str, @NonNull GeneratedAndroidWebView.WebViewClientFlutterApi.Reply<Void> reply) {
        this.webViewFlutterApi.create(webView, new u3());
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(webView);
        Objects.requireNonNull(identifierForStrongReference);
        onPageFinished(Long.valueOf(getIdentifierForClient(webViewClient)), identifierForStrongReference, str, reply);
    }

    public void onPageStarted(@NonNull WebViewClient webViewClient, @NonNull WebView webView, @NonNull String str, @NonNull GeneratedAndroidWebView.WebViewClientFlutterApi.Reply<Void> reply) {
        this.webViewFlutterApi.create(webView, new q3());
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(webView);
        Objects.requireNonNull(identifierForStrongReference);
        onPageStarted(Long.valueOf(getIdentifierForClient(webViewClient)), identifierForStrongReference, str, reply);
    }

    public void onReceivedError(@NonNull WebViewClient webViewClient, @NonNull WebView webView, @NonNull Long l11, @NonNull String str, @NonNull String str2, @NonNull GeneratedAndroidWebView.WebViewClientFlutterApi.Reply<Void> reply) {
        this.webViewFlutterApi.create(webView, new r3());
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(webView);
        Objects.requireNonNull(identifierForStrongReference);
        onReceivedError(Long.valueOf(getIdentifierForClient(webViewClient)), identifierForStrongReference, l11, str, str2, reply);
    }

    @RequiresApi(api = 23)
    public void onReceivedRequestError(@NonNull WebViewClient webViewClient, @NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest, @NonNull WebResourceError webResourceError, @NonNull GeneratedAndroidWebView.WebViewClientFlutterApi.Reply<Void> reply) {
        this.webViewFlutterApi.create(webView, new t3());
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(webView);
        Objects.requireNonNull(identifierForStrongReference);
        onReceivedRequestError(Long.valueOf(getIdentifierForClient(webViewClient)), identifierForStrongReference, s(webResourceRequest), q(webResourceError), reply);
    }

    @RequiresApi(api = 21)
    public void requestLoading(@NonNull WebViewClient webViewClient, @NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest, @NonNull GeneratedAndroidWebView.WebViewClientFlutterApi.Reply<Void> reply) {
        this.webViewFlutterApi.create(webView, new o3());
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(webView);
        Objects.requireNonNull(identifierForStrongReference);
        requestLoading(Long.valueOf(getIdentifierForClient(webViewClient)), identifierForStrongReference, s(webResourceRequest), reply);
    }

    public void urlLoading(@NonNull WebViewClient webViewClient, @NonNull WebView webView, @NonNull String str, @NonNull GeneratedAndroidWebView.WebViewClientFlutterApi.Reply<Void> reply) {
        this.webViewFlutterApi.create(webView, new s3());
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(webView);
        Objects.requireNonNull(identifierForStrongReference);
        urlLoading(Long.valueOf(getIdentifierForClient(webViewClient)), identifierForStrongReference, str, reply);
    }

    @RequiresApi(api = 21)
    public void onReceivedRequestError(@NonNull WebViewClient webViewClient, @NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest, @NonNull WebResourceErrorCompat webResourceErrorCompat, @NonNull GeneratedAndroidWebView.WebViewClientFlutterApi.Reply<Void> reply) {
        this.webViewFlutterApi.create(webView, new v3());
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(webView);
        Objects.requireNonNull(identifierForStrongReference);
        onReceivedRequestError(Long.valueOf(getIdentifierForClient(webViewClient)), identifierForStrongReference, s(webResourceRequest), r(webResourceErrorCompat), reply);
    }
}
