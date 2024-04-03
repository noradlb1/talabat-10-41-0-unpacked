package io.flutter.plugins.webviewflutter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import e00.o4;
import io.flutter.embedding.android.FlutterView;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import io.flutter.plugins.webviewflutter.WebChromeClientHostApiImpl;
import java.util.Map;
import java.util.Objects;
import xz.b;

public class WebViewHostApiImpl implements GeneratedAndroidWebView.WebViewHostApi {
    private final BinaryMessenger binaryMessenger;
    private Context context;
    private final InstanceManager instanceManager;
    private final WebViewProxy webViewProxy;

    @SuppressLint({"ViewConstructor"})
    public static class WebViewPlatformView extends WebView implements PlatformView {
        private WebViewFlutterApiImpl api;
        private WebChromeClientHostApiImpl.SecureWebChromeClient currentWebChromeClient;
        private WebViewClient currentWebViewClient;
        @NonNull
        private final AndroidSdkChecker sdkChecker;

        @VisibleForTesting
        public interface AndroidSdkChecker {
            @ChecksSdkIntAtLeast(parameter = 0)
            boolean sdkIsAtLeast(int i11);
        }

        public WebViewPlatformView(@NonNull Context context, @NonNull BinaryMessenger binaryMessenger, @NonNull InstanceManager instanceManager) {
            this(context, binaryMessenger, instanceManager, new b());
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$new$0(int i11) {
            return Build.VERSION.SDK_INT >= i11;
        }

        private FlutterView tryFindFlutterView() {
            ViewParent viewParent = this;
            while (viewParent.getParent() != null) {
                viewParent = viewParent.getParent();
                if (viewParent instanceof FlutterView) {
                    return (FlutterView) viewParent;
                }
            }
            return null;
        }

        public void dispose() {
        }

        @Nullable
        public View getView() {
            return this;
        }

        @Nullable
        public WebChromeClient getWebChromeClient() {
            return this.currentWebChromeClient;
        }

        public void onAttachedToWindow() {
            FlutterView tryFindFlutterView;
            super.onAttachedToWindow();
            if (this.sdkChecker.sdkIsAtLeast(26) && (tryFindFlutterView = tryFindFlutterView()) != null) {
                tryFindFlutterView.setImportantForAutofill(1);
            }
        }

        public /* synthetic */ void onFlutterViewAttached(View view) {
            b.a(this, view);
        }

        public /* synthetic */ void onFlutterViewDetached() {
            b.b(this);
        }

        public /* synthetic */ void onInputConnectionLocked() {
            b.c(this);
        }

        public /* synthetic */ void onInputConnectionUnlocked() {
            b.d(this);
        }

        @VisibleForTesting
        public void setApi(WebViewFlutterApiImpl webViewFlutterApiImpl) {
            this.api = webViewFlutterApiImpl;
        }

        public void setWebChromeClient(@Nullable WebChromeClient webChromeClient) {
            super.setWebChromeClient(webChromeClient);
            if (webChromeClient instanceof WebChromeClientHostApiImpl.SecureWebChromeClient) {
                WebChromeClientHostApiImpl.SecureWebChromeClient secureWebChromeClient = (WebChromeClientHostApiImpl.SecureWebChromeClient) webChromeClient;
                this.currentWebChromeClient = secureWebChromeClient;
                secureWebChromeClient.setWebViewClient(this.currentWebViewClient);
                return;
            }
            throw new AssertionError("Client must be a SecureWebChromeClient.");
        }

        public void setWebViewClient(@NonNull WebViewClient webViewClient) {
            super.setWebViewClient(webViewClient);
            this.currentWebViewClient = webViewClient;
            this.currentWebChromeClient.setWebViewClient(webViewClient);
        }

        @VisibleForTesting
        public WebViewPlatformView(@NonNull Context context, @NonNull BinaryMessenger binaryMessenger, @NonNull InstanceManager instanceManager, @NonNull AndroidSdkChecker androidSdkChecker) {
            super(context);
            this.currentWebViewClient = new WebViewClient();
            this.currentWebChromeClient = new WebChromeClientHostApiImpl.SecureWebChromeClient();
            this.api = new WebViewFlutterApiImpl(binaryMessenger, instanceManager);
            this.sdkChecker = androidSdkChecker;
            setWebViewClient(this.currentWebViewClient);
            setWebChromeClient(this.currentWebChromeClient);
        }
    }

    public static class WebViewProxy {
        @NonNull
        public WebViewPlatformView createWebView(@NonNull Context context, @NonNull BinaryMessenger binaryMessenger, @NonNull InstanceManager instanceManager) {
            return new WebViewPlatformView(context, binaryMessenger, instanceManager);
        }

        public void setWebContentsDebuggingEnabled(boolean z11) {
            WebView.setWebContentsDebuggingEnabled(z11);
        }
    }

    public WebViewHostApiImpl(@NonNull InstanceManager instanceManager2, @NonNull BinaryMessenger binaryMessenger2, @NonNull WebViewProxy webViewProxy2, @Nullable Context context2) {
        this.instanceManager = instanceManager2;
        this.binaryMessenger = binaryMessenger2;
        this.webViewProxy = webViewProxy2;
        this.context = context2;
    }

    @SuppressLint({"JavascriptInterface"})
    public void addJavaScriptChannel(@NonNull Long l11, @NonNull Long l12) {
        WebView webView = (WebView) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(webView);
        JavaScriptChannel javaScriptChannel = (JavaScriptChannel) this.instanceManager.getInstance(l12.longValue());
        Objects.requireNonNull(javaScriptChannel);
        webView.addJavascriptInterface(javaScriptChannel, javaScriptChannel.f14424a);
    }

    @NonNull
    public Boolean canGoBack(@NonNull Long l11) {
        WebView webView = (WebView) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(webView);
        return Boolean.valueOf(webView.canGoBack());
    }

    @NonNull
    public Boolean canGoForward(@NonNull Long l11) {
        WebView webView = (WebView) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(webView);
        return Boolean.valueOf(webView.canGoForward());
    }

    public void clearCache(@NonNull Long l11, @NonNull Boolean bool) {
        WebView webView = (WebView) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(webView);
        webView.clearCache(bool.booleanValue());
    }

    public void create(@NonNull Long l11) {
        DisplayListenerProxy displayListenerProxy = new DisplayListenerProxy();
        DisplayManager displayManager = (DisplayManager) this.context.getSystemService("display");
        displayListenerProxy.b(displayManager);
        WebViewPlatformView createWebView = this.webViewProxy.createWebView(this.context, this.binaryMessenger, this.instanceManager);
        displayListenerProxy.a(displayManager);
        this.instanceManager.addDartCreatedInstance(createWebView, l11.longValue());
    }

    public void evaluateJavascript(@NonNull Long l11, @NonNull String str, @NonNull GeneratedAndroidWebView.Result<String> result) {
        WebView webView = (WebView) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(webView);
        Objects.requireNonNull(result);
        webView.evaluateJavascript(str, new o4(result));
    }

    @NonNull
    public InstanceManager getInstanceManager() {
        return this.instanceManager;
    }

    @NonNull
    public GeneratedAndroidWebView.WebViewPoint getScrollPosition(@NonNull Long l11) {
        WebView webView = (WebView) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(webView);
        return new GeneratedAndroidWebView.WebViewPoint.Builder().setX(Long.valueOf((long) webView.getScrollX())).setY(Long.valueOf((long) webView.getScrollY())).build();
    }

    @NonNull
    public Long getScrollX(@NonNull Long l11) {
        WebView webView = (WebView) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(webView);
        return Long.valueOf((long) webView.getScrollX());
    }

    @NonNull
    public Long getScrollY(@NonNull Long l11) {
        WebView webView = (WebView) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(webView);
        return Long.valueOf((long) webView.getScrollY());
    }

    @Nullable
    public String getTitle(@NonNull Long l11) {
        WebView webView = (WebView) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(webView);
        return webView.getTitle();
    }

    @Nullable
    public String getUrl(@NonNull Long l11) {
        WebView webView = (WebView) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(webView);
        return webView.getUrl();
    }

    public void goBack(@NonNull Long l11) {
        WebView webView = (WebView) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(webView);
        webView.goBack();
    }

    public void goForward(@NonNull Long l11) {
        WebView webView = (WebView) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(webView);
        webView.goForward();
    }

    public void loadData(@NonNull Long l11, @NonNull String str, @Nullable String str2, @Nullable String str3) {
        WebView webView = (WebView) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(webView);
        webView.loadData(str, str2, str3);
    }

    public void loadDataWithBaseUrl(@NonNull Long l11, @Nullable String str, @NonNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        WebView webView = (WebView) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(webView);
        webView.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public void loadUrl(@NonNull Long l11, @NonNull String str, @NonNull Map<String, String> map) {
        WebView webView = (WebView) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(webView);
        webView.loadUrl(str, map);
    }

    public void postUrl(@NonNull Long l11, @NonNull String str, @NonNull byte[] bArr) {
        WebView webView = (WebView) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(webView);
        webView.postUrl(str, bArr);
    }

    public void reload(@NonNull Long l11) {
        WebView webView = (WebView) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(webView);
        webView.reload();
    }

    public void removeJavaScriptChannel(@NonNull Long l11, @NonNull Long l12) {
        WebView webView = (WebView) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(webView);
        JavaScriptChannel javaScriptChannel = (JavaScriptChannel) this.instanceManager.getInstance(l12.longValue());
        Objects.requireNonNull(javaScriptChannel);
        webView.removeJavascriptInterface(javaScriptChannel.f14424a);
    }

    public void scrollBy(@NonNull Long l11, @NonNull Long l12, @NonNull Long l13) {
        WebView webView = (WebView) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(webView);
        webView.scrollBy(l12.intValue(), l13.intValue());
    }

    public void scrollTo(@NonNull Long l11, @NonNull Long l12, @NonNull Long l13) {
        WebView webView = (WebView) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(webView);
        webView.scrollTo(l12.intValue(), l13.intValue());
    }

    public void setBackgroundColor(@NonNull Long l11, @NonNull Long l12) {
        WebView webView = (WebView) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(webView);
        webView.setBackgroundColor(l12.intValue());
    }

    public void setContext(@Nullable Context context2) {
        this.context = context2;
    }

    public void setDownloadListener(@NonNull Long l11, @Nullable Long l12) {
        WebView webView = (WebView) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(webView);
        InstanceManager instanceManager2 = this.instanceManager;
        Objects.requireNonNull(l12);
        webView.setDownloadListener((DownloadListener) instanceManager2.getInstance(l12.longValue()));
    }

    public void setWebChromeClient(@NonNull Long l11, @Nullable Long l12) {
        WebView webView = (WebView) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(webView);
        InstanceManager instanceManager2 = this.instanceManager;
        Objects.requireNonNull(l12);
        webView.setWebChromeClient((WebChromeClient) instanceManager2.getInstance(l12.longValue()));
    }

    public void setWebContentsDebuggingEnabled(@NonNull Boolean bool) {
        this.webViewProxy.setWebContentsDebuggingEnabled(bool.booleanValue());
    }

    public void setWebViewClient(@NonNull Long l11, @NonNull Long l12) {
        WebView webView = (WebView) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(webView);
        webView.setWebViewClient((WebViewClient) this.instanceManager.getInstance(l12.longValue()));
    }
}
