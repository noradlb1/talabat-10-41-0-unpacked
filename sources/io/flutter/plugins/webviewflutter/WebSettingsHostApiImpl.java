package io.flutter.plugins.webviewflutter;

import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import java.util.Objects;

public class WebSettingsHostApiImpl implements GeneratedAndroidWebView.WebSettingsHostApi {
    private final InstanceManager instanceManager;
    private final WebSettingsCreator webSettingsCreator;

    public static class WebSettingsCreator {
        @NonNull
        public WebSettings createWebSettings(@NonNull WebView webView) {
            return webView.getSettings();
        }
    }

    public WebSettingsHostApiImpl(@NonNull InstanceManager instanceManager2, @NonNull WebSettingsCreator webSettingsCreator2) {
        this.instanceManager = instanceManager2;
        this.webSettingsCreator = webSettingsCreator2;
    }

    public void create(@NonNull Long l11, @NonNull Long l12) {
        WebView webView = (WebView) this.instanceManager.getInstance(l12.longValue());
        Objects.requireNonNull(webView);
        this.instanceManager.addDartCreatedInstance(this.webSettingsCreator.createWebSettings(webView), l11.longValue());
    }

    @NonNull
    public String getUserAgentString(@NonNull Long l11) {
        WebSettings webSettings = (WebSettings) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(webSettings);
        return webSettings.getUserAgentString();
    }

    public void setAllowFileAccess(@NonNull Long l11, @NonNull Boolean bool) {
        WebSettings webSettings = (WebSettings) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(webSettings);
        webSettings.setAllowFileAccess(bool.booleanValue());
    }

    public void setBuiltInZoomControls(@NonNull Long l11, @NonNull Boolean bool) {
        WebSettings webSettings = (WebSettings) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(webSettings);
        webSettings.setBuiltInZoomControls(bool.booleanValue());
    }

    public void setDisplayZoomControls(@NonNull Long l11, @NonNull Boolean bool) {
        WebSettings webSettings = (WebSettings) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(webSettings);
        webSettings.setDisplayZoomControls(bool.booleanValue());
    }

    public void setDomStorageEnabled(@NonNull Long l11, @NonNull Boolean bool) {
        WebSettings webSettings = (WebSettings) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(webSettings);
        webSettings.setDomStorageEnabled(bool.booleanValue());
    }

    public void setJavaScriptCanOpenWindowsAutomatically(@NonNull Long l11, @NonNull Boolean bool) {
        WebSettings webSettings = (WebSettings) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(webSettings);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(bool.booleanValue());
    }

    public void setJavaScriptEnabled(@NonNull Long l11, @NonNull Boolean bool) {
        WebSettings webSettings = (WebSettings) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(webSettings);
        webSettings.setJavaScriptEnabled(bool.booleanValue());
    }

    public void setLoadWithOverviewMode(@NonNull Long l11, @NonNull Boolean bool) {
        WebSettings webSettings = (WebSettings) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(webSettings);
        webSettings.setLoadWithOverviewMode(bool.booleanValue());
    }

    public void setMediaPlaybackRequiresUserGesture(@NonNull Long l11, @NonNull Boolean bool) {
        WebSettings webSettings = (WebSettings) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(webSettings);
        webSettings.setMediaPlaybackRequiresUserGesture(bool.booleanValue());
    }

    public void setSupportMultipleWindows(@NonNull Long l11, @NonNull Boolean bool) {
        WebSettings webSettings = (WebSettings) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(webSettings);
        webSettings.setSupportMultipleWindows(bool.booleanValue());
    }

    public void setSupportZoom(@NonNull Long l11, @NonNull Boolean bool) {
        WebSettings webSettings = (WebSettings) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(webSettings);
        webSettings.setSupportZoom(bool.booleanValue());
    }

    public void setTextZoom(@NonNull Long l11, @NonNull Long l12) {
        WebSettings webSettings = (WebSettings) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(webSettings);
        webSettings.setTextZoom(l12.intValue());
    }

    public void setUseWideViewPort(@NonNull Long l11, @NonNull Boolean bool) {
        WebSettings webSettings = (WebSettings) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(webSettings);
        webSettings.setUseWideViewPort(bool.booleanValue());
    }

    public void setUserAgentString(@NonNull Long l11, @Nullable String str) {
        WebSettings webSettings = (WebSettings) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(webSettings);
        webSettings.setUserAgentString(str);
    }
}
