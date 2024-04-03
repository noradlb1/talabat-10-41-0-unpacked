package androidx.webkit;

import android.app.PendingIntent;
import android.webkit.SafeBrowsingResponse;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.webkit.internal.ApiHelperForLollipop;
import androidx.webkit.internal.SafeBrowsingResponseImpl;
import androidx.webkit.internal.WebResourceErrorImpl;
import androidx.webkit.internal.WebViewFeatureInternal;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebViewClientBoundaryInterface;

public class WebViewClientCompat extends WebViewClient implements WebViewClientBoundaryInterface {
    private static final String[] sSupportedFeatures = {"VISUAL_STATE_CALLBACK", "RECEIVE_WEB_RESOURCE_ERROR", "RECEIVE_HTTP_ERROR", "SHOULD_OVERRIDE_WITH_REDIRECTS", "SAFE_BROWSING_HIT"};

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface SafeBrowsingThreat {
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final String[] getSupportedFeatures() {
        return sSupportedFeatures;
    }

    @UiThread
    public void onPageCommitVisible(@NonNull WebView webView, @NonNull String str) {
    }

    @RequiresApi(21)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void onReceivedError(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest, @NonNull InvocationHandler invocationHandler) {
        onReceivedError(webView, webResourceRequest, (WebResourceErrorCompat) new WebResourceErrorImpl(invocationHandler));
    }

    @UiThread
    public void onReceivedHttpError(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest, @NonNull WebResourceResponse webResourceResponse) {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void onSafeBrowsingHit(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest, int i11, @NonNull InvocationHandler invocationHandler) {
        onSafeBrowsingHit(webView, webResourceRequest, i11, (SafeBrowsingResponseCompat) new SafeBrowsingResponseImpl(invocationHandler));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean onWebAuthnIntent(@NonNull WebView webView, @NonNull PendingIntent pendingIntent, @NonNull InvocationHandler invocationHandler) {
        return false;
    }

    @RequiresApi(21)
    @UiThread
    public boolean shouldOverrideUrlLoading(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest) {
        return shouldOverrideUrlLoading(webView, ApiHelperForLollipop.getUrl(webResourceRequest).toString());
    }

    @RequiresApi(23)
    public final void onReceivedError(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest, @NonNull WebResourceError webResourceError) {
        onReceivedError(webView, webResourceRequest, (WebResourceErrorCompat) new WebResourceErrorImpl(webResourceError));
    }

    @RequiresApi(27)
    public final void onSafeBrowsingHit(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest, int i11, @NonNull SafeBrowsingResponse safeBrowsingResponse) {
        onSafeBrowsingHit(webView, webResourceRequest, i11, (SafeBrowsingResponseCompat) new SafeBrowsingResponseImpl(safeBrowsingResponse));
    }

    @RequiresApi(21)
    @UiThread
    public void onReceivedError(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest, @NonNull WebResourceErrorCompat webResourceErrorCompat) {
        if (WebViewFeature.isFeatureSupported("WEB_RESOURCE_ERROR_GET_CODE") && WebViewFeature.isFeatureSupported("WEB_RESOURCE_ERROR_GET_DESCRIPTION") && ApiHelperForLollipop.isForMainFrame(webResourceRequest)) {
            onReceivedError(webView, webResourceErrorCompat.getErrorCode(), webResourceErrorCompat.getDescription().toString(), ApiHelperForLollipop.getUrl(webResourceRequest).toString());
        }
    }

    @UiThread
    public void onSafeBrowsingHit(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest, int i11, @NonNull SafeBrowsingResponseCompat safeBrowsingResponseCompat) {
        if (WebViewFeature.isFeatureSupported("SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL")) {
            safeBrowsingResponseCompat.showInterstitial(true);
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }
}
