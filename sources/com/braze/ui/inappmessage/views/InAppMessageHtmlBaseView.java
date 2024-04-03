package com.braze.ui.inappmessage.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import androidx.core.view.WindowInsetsCompat;
import androidx.webkit.WebSettingsCompat;
import androidx.webkit.WebViewFeature;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.support.BrazeLogger;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import com.braze.ui.inappmessage.listeners.IWebViewClientStateListener;
import com.braze.ui.inappmessage.utils.InAppMessageViewUtils;
import com.braze.ui.inappmessage.utils.InAppMessageWebViewClient;
import com.braze.ui.support.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001.B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u001bH\u0016J\b\u0010\"\u001a\u00020#H&J\u0018\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0012\u0010&\u001a\u00020\u001b2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010)\u001a\u00020\u001b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001e\u0010*\u001a\u00020\u001b2\b\u0010+\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,H\u0017R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\t8WX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006/"}, d2 = {"Lcom/braze/ui/inappmessage/views/InAppMessageHtmlBaseView;", "Landroid/widget/RelativeLayout;", "Lcom/braze/ui/inappmessage/views/IInAppMessageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "configuredMessageWebView", "Landroid/webkit/WebView;", "hasAppliedWindowInsets", "", "getHasAppliedWindowInsets", "()Z", "setHasAppliedWindowInsets", "(Z)V", "inAppMessageWebViewClient", "Lcom/braze/ui/inappmessage/utils/InAppMessageWebViewClient;", "isFinished", "messageClickableView", "Landroid/view/View;", "getMessageClickableView", "()Landroid/view/View;", "messageWebView", "getMessageWebView", "()Landroid/webkit/WebView;", "applyWindowInsets", "", "insets", "Landroidx/core/view/WindowInsetsCompat;", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "finishWebViewDisplay", "getWebViewViewId", "", "onKeyDown", "keyCode", "setHtmlPageFinishedListener", "listener", "Lcom/braze/ui/inappmessage/listeners/IWebViewClientStateListener;", "setInAppMessageWebViewClient", "setWebViewContent", "htmlBody", "", "assetDirectoryUrl", "Companion", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class InAppMessageHtmlBaseView extends RelativeLayout implements IInAppMessageView {
    @NotNull
    public static final String BRAZE_BRIDGE_PREFIX = "brazeInternalBridge";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String FILE_URI_SCHEME_PREFIX = "file://";
    @NotNull
    private static final String FINISHED_WEBVIEW_URL = "about:blank";
    @NotNull
    private static final String HTML_ENCODING = "utf-8";
    @NotNull
    private static final String HTML_MIME_TYPE = "text/html";
    @Nullable
    private WebView configuredMessageWebView;
    private boolean hasAppliedWindowInsets;
    @Nullable
    private InAppMessageWebViewClient inAppMessageWebViewClient;
    private boolean isFinished;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/braze/ui/inappmessage/views/InAppMessageHtmlBaseView$Companion;", "", "()V", "BRAZE_BRIDGE_PREFIX", "", "FILE_URI_SCHEME_PREFIX", "FINISHED_WEBVIEW_URL", "HTML_ENCODING", "HTML_MIME_TYPE", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public InAppMessageHtmlBaseView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static /* synthetic */ void setWebViewContent$default(InAppMessageHtmlBaseView inAppMessageHtmlBaseView, String str, String str2, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                str2 = null;
            }
            inAppMessageHtmlBaseView.setWebViewContent(str, str2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setWebViewContent");
    }

    public void applyWindowInsets(@NotNull WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "insets");
        setHasAppliedWindowInsets(true);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "this.context");
        if (new BrazeConfigurationProvider(context).isHtmlInAppMessageApplyWindowInsetsEnabled() && getLayoutParams() != null && (getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMargins(ViewUtils.getMaxSafeLeftInset(windowInsetsCompat) + marginLayoutParams.leftMargin, ViewUtils.getMaxSafeTopInset(windowInsetsCompat) + marginLayoutParams.topMargin, ViewUtils.getMaxSafeRightInset(windowInsetsCompat) + marginLayoutParams.rightMargin, ViewUtils.getMaxSafeBottomInset(windowInsetsCompat) + marginLayoutParams.bottomMargin);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
    }

    public boolean dispatchKeyEvent(@NotNull KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "event");
        if (isInTouchMode() || keyEvent.getKeyCode() != 4 || !BrazeInAppMessageManager.Companion.getInstance().getDoesBackButtonDismissInAppMessageView()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        InAppMessageViewUtils.closeInAppMessageOnKeycodeBack();
        return true;
    }

    public void finishWebViewDisplay() {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) InAppMessageHtmlBaseView$finishWebViewDisplay$1.INSTANCE, 7, (Object) null);
        this.isFinished = true;
        WebView webView = this.configuredMessageWebView;
        if (webView != null) {
            webView.loadUrl(FINISHED_WEBVIEW_URL);
            webView.onPause();
            webView.removeAllViews();
            this.configuredMessageWebView = null;
        }
    }

    public boolean getHasAppliedWindowInsets() {
        return this.hasAppliedWindowInsets;
    }

    @Nullable
    public View getMessageClickableView() {
        return this;
    }

    @Nullable
    @SuppressLint({"SetJavaScriptEnabled"})
    public WebView getMessageWebView() {
        if (this.isFinished) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) InAppMessageHtmlBaseView$messageWebView$1.INSTANCE, 6, (Object) null);
            return null;
        }
        int webViewViewId = getWebViewViewId();
        if (webViewViewId == 0) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) InAppMessageHtmlBaseView$messageWebView$2.INSTANCE, 7, (Object) null);
            return null;
        }
        WebView webView = this.configuredMessageWebView;
        if (webView != null) {
            return webView;
        }
        WebView webView2 = (WebView) findViewById(webViewViewId);
        if (webView2 == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new InAppMessageHtmlBaseView$messageWebView$3(webViewViewId), 7, (Object) null);
            return null;
        }
        WebSettings settings = webView2.getSettings();
        Intrinsics.checkNotNullExpressionValue(settings, "webView.settings");
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setDisplayZoomControls(false);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        webView2.setLayerType(2, (Paint) null);
        webView2.setBackgroundColor(0);
        try {
            if (WebViewFeature.isFeatureSupported("FORCE_DARK")) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                if (ViewUtils.isDeviceInNightMode(context)) {
                    WebSettingsCompat.setForceDark(settings, 2);
                }
            }
            if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK_STRATEGY)) {
                WebSettingsCompat.setForceDarkStrategy(settings, 1);
            }
        } catch (Throwable th2) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, th2, false, (Function0) InAppMessageHtmlBaseView$messageWebView$4.INSTANCE, 4, (Object) null);
        }
        webView2.setWebChromeClient(new InAppMessageHtmlBaseView$messageWebView$5(this));
        this.configuredMessageWebView = webView2;
        return webView2;
    }

    public abstract int getWebViewViewId();

    public boolean onKeyDown(int i11, @NotNull KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "event");
        if (i11 != 4 || !BrazeInAppMessageManager.Companion.getInstance().getDoesBackButtonDismissInAppMessageView()) {
            WebView webView = this.configuredMessageWebView;
            if (webView != null) {
                ViewUtils.setFocusableInTouchModeAndRequestFocus(webView);
            }
            return super.onKeyDown(i11, keyEvent);
        }
        InAppMessageViewUtils.closeInAppMessageOnKeycodeBack();
        return true;
    }

    public void setHasAppliedWindowInsets(boolean z11) {
        this.hasAppliedWindowInsets = z11;
    }

    public void setHtmlPageFinishedListener(@Nullable IWebViewClientStateListener iWebViewClientStateListener) {
        InAppMessageWebViewClient inAppMessageWebViewClient2 = this.inAppMessageWebViewClient;
        if (inAppMessageWebViewClient2 != null) {
            inAppMessageWebViewClient2.setWebViewClientStateListener(iWebViewClientStateListener);
        }
    }

    public void setInAppMessageWebViewClient(@NotNull InAppMessageWebViewClient inAppMessageWebViewClient2) {
        Intrinsics.checkNotNullParameter(inAppMessageWebViewClient2, "inAppMessageWebViewClient");
        WebView messageWebView = getMessageWebView();
        if (messageWebView != null) {
            messageWebView.setWebViewClient(inAppMessageWebViewClient2);
        }
        this.inAppMessageWebViewClient = inAppMessageWebViewClient2;
    }

    @JvmOverloads
    public final void setWebViewContent(@Nullable String str) {
        setWebViewContent$default(this, str, (String) null, 2, (Object) null);
    }

    @JvmOverloads
    public void setWebViewContent(@Nullable String str, @Nullable String str2) {
        if (str != null) {
            WebView messageWebView = getMessageWebView();
            if (messageWebView != null) {
                messageWebView.loadDataWithBaseURL(FILE_URI_SCHEME_PREFIX + str2 + '/', str, "text/html", HTML_ENCODING, (String) null);
                return;
            }
            return;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) InAppMessageHtmlBaseView$setWebViewContent$1.INSTANCE, 7, (Object) null);
    }
}
