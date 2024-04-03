package com.checkout.threedsecure.webview;

import android.graphics.Bitmap;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.checkout.threedsecure.error.ThreeDSError;
import com.checkout.threedsecure.logging.ThreeDSLogger;
import com.checkout.threedsecure.utils.WebResourcesExtensionKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001BU\u0012#\u0010\u0002\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003\u0012!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u001c\u0010\u0012\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\u0015\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J&\u0010\u0018\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u000b\u001a\u0004\u0018\u00010\u001bH\u0016J&\u0010\u001c\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001c\u0010\u001f\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u000e\u0010\u0010\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R)\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0003X\u0004¢\u0006\u0002\n\u0000R+\u0010\u0002\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/checkout/threedsecure/webview/ThreeDSWebViewClient;", "Landroid/webkit/WebViewClient;", "onResult", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "url", "", "onError", "Lcom/checkout/threedsecure/error/ThreeDSError;", "error", "", "logger", "Lcom/checkout/threedsecure/logging/ThreeDSLogger;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lcom/checkout/threedsecure/logging/ThreeDSLogger;)V", "loadedFirstTime", "presentedFirstTime", "onPageCommitVisible", "view", "Landroid/webkit/WebView;", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onReceivedError", "request", "Landroid/webkit/WebResourceRequest;", "Landroid/webkit/WebResourceError;", "onReceivedHttpError", "errorResponse", "Landroid/webkit/WebResourceResponse;", "shouldOverrideUrlLoading", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ThreeDSWebViewClient extends WebViewClient {
    private boolean loadedFirstTime = true;
    @NotNull
    private final ThreeDSLogger logger;
    @NotNull
    private final Function1<ThreeDSError, Unit> onError;
    @NotNull
    private final Function1<String, Boolean> onResult;
    private boolean presentedFirstTime = true;

    public ThreeDSWebViewClient(@NotNull Function1<? super String, Boolean> function1, @NotNull Function1<? super ThreeDSError, Unit> function12, @NotNull ThreeDSLogger threeDSLogger) {
        Intrinsics.checkNotNullParameter(function1, "onResult");
        Intrinsics.checkNotNullParameter(function12, "onError");
        Intrinsics.checkNotNullParameter(threeDSLogger, "logger");
        this.onResult = function1;
        this.onError = function12;
        this.logger = threeDSLogger;
    }

    public void onPageCommitVisible(@Nullable WebView webView, @Nullable String str) {
        super.onPageCommitVisible(webView, str);
        if (this.loadedFirstTime) {
            ThreeDSLogger.DefaultImpls.logLoadedEvent$default(this.logger, true, (Throwable) null, 2, (Object) null);
            this.loadedFirstTime = false;
        }
    }

    public void onPageStarted(@Nullable WebView webView, @Nullable String str, @Nullable Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        if (this.presentedFirstTime) {
            this.logger.logPresentedEvent();
            this.presentedFirstTime = false;
        }
    }

    public void onReceivedError(@Nullable WebView webView, @Nullable WebResourceRequest webResourceRequest, @Nullable WebResourceError webResourceError) {
        ThreeDSError threeDSError;
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (webResourceError != null && (threeDSError = WebResourcesExtensionKt.toThreeDSError(webResourceError)) != null) {
            this.onError.invoke(threeDSError);
        }
    }

    public void onReceivedHttpError(@Nullable WebView webView, @Nullable WebResourceRequest webResourceRequest, @Nullable WebResourceResponse webResourceResponse) {
        ThreeDSError threeDSError;
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (webResourceResponse != null && (threeDSError = WebResourcesExtensionKt.toThreeDSError(webResourceResponse)) != null) {
            this.onError.invoke(threeDSError);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r3.getUrl();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean shouldOverrideUrlLoading(@org.jetbrains.annotations.Nullable android.webkit.WebView r2, @org.jetbrains.annotations.Nullable android.webkit.WebResourceRequest r3) {
        /*
            r1 = this;
            if (r3 == 0) goto L_0x0019
            android.net.Uri r0 = r3.getUrl()
            if (r0 == 0) goto L_0x0019
            kotlin.jvm.functions.Function1<java.lang.String, java.lang.Boolean> r2 = r1.onResult
            java.lang.String r3 = r0.toString()
            java.lang.Object r2 = r2.invoke(r3)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            goto L_0x001d
        L_0x0019:
            boolean r2 = super.shouldOverrideUrlLoading(r2, r3)
        L_0x001d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.threedsecure.webview.ThreeDSWebViewClient.shouldOverrideUrlLoading(android.webkit.WebView, android.webkit.WebResourceRequest):boolean");
    }
}
