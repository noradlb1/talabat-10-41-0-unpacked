package com.braze.ui.inappmessage.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.support.BrazeFileUtils;
import com.braze.support.BrazeLogger;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import com.braze.ui.inappmessage.listeners.IInAppMessageWebViewClientListener;
import com.braze.ui.inappmessage.listeners.IWebViewClientStateListener;
import com.braze.ui.support.UriUtils;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 $2\u00020\u0001:\u0001$B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0014H\u0002J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00142\b\u0010 \u001a\u0004\u0018\u00010\u0012J\u0018\u0010!\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020#H\u0017J\u0018\u0010!\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/braze/ui/inappmessage/utils/InAppMessageWebViewClient;", "Landroid/webkit/WebViewClient;", "context", "Landroid/content/Context;", "inAppMessage", "Lcom/braze/models/inappmessage/IInAppMessage;", "inAppMessageWebViewClientListener", "Lcom/braze/ui/inappmessage/listeners/IInAppMessageWebViewClientListener;", "(Landroid/content/Context;Lcom/braze/models/inappmessage/IInAppMessage;Lcom/braze/ui/inappmessage/listeners/IInAppMessageWebViewClientListener;)V", "hasCalledPageFinishedOnListener", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasPageFinishedLoading", "", "markPageFinishedJob", "Lkotlinx/coroutines/Job;", "maxOnPageFinishedWaitTimeMs", "", "webViewClientStateListener", "Lcom/braze/ui/inappmessage/listeners/IWebViewClientStateListener;", "appendBridgeJavascript", "", "view", "Landroid/webkit/WebView;", "handleUrlOverride", "url", "", "markPageFinished", "onPageFinished", "onRenderProcessGone", "detail", "Landroid/webkit/RenderProcessGoneDetail;", "setWebViewClientStateListener", "listener", "shouldOverrideUrlLoading", "request", "Landroid/webkit/WebResourceRequest;", "Companion", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class InAppMessageWebViewClient extends WebViewClient {
    @NotNull
    private static final String APPBOY_INAPP_MESSAGE_SCHEME = "appboy";
    @NotNull
    private static final String AUTHORITY_NAME_CLOSE = "close";
    @NotNull
    private static final String AUTHORITY_NAME_CUSTOM_EVENT = "customEvent";
    @NotNull
    private static final String AUTHORITY_NAME_NEWSFEED = "feed";
    @NotNull
    private static final String BRIDGE_JS_FILE = "braze-html-in-app-message-bridge.js";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String JAVASCRIPT_PREFIX = "javascript:";
    @NotNull
    public static final String QUERY_NAME_BUTTON_ID = "abButtonId";
    @NotNull
    public static final String QUERY_NAME_DEEPLINK = "abDeepLink";
    @NotNull
    public static final String QUERY_NAME_EXTERNAL_OPEN = "abExternalOpen";
    @NotNull
    private final Context context;
    @NotNull
    private final AtomicBoolean hasCalledPageFinishedOnListener = new AtomicBoolean(false);
    private boolean hasPageFinishedLoading;
    @NotNull
    private final IInAppMessage inAppMessage;
    @Nullable
    private final IInAppMessageWebViewClientListener inAppMessageWebViewClientListener;
    @Nullable
    private Job markPageFinishedJob;
    private final int maxOnPageFinishedWaitTimeMs;
    @Nullable
    private IWebViewClientStateListener webViewClientStateListener;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/braze/ui/inappmessage/utils/InAppMessageWebViewClient$Companion;", "", "()V", "APPBOY_INAPP_MESSAGE_SCHEME", "", "AUTHORITY_NAME_CLOSE", "AUTHORITY_NAME_CUSTOM_EVENT", "AUTHORITY_NAME_NEWSFEED", "BRIDGE_JS_FILE", "JAVASCRIPT_PREFIX", "QUERY_NAME_BUTTON_ID", "QUERY_NAME_DEEPLINK", "QUERY_NAME_EXTERNAL_OPEN", "getBundleFromUrl", "Landroid/os/Bundle;", "url", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        @VisibleForTesting
        public final Bundle getBundleFromUrl(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "url");
            Bundle bundle = new Bundle();
            if (StringsKt__StringsJVMKt.isBlank(str)) {
                return bundle;
            }
            Uri parse = Uri.parse(str);
            Intrinsics.checkNotNullExpressionValue(parse, "uri");
            for (Map.Entry next : UriUtils.getQueryParameters(parse).entrySet()) {
                bundle.putString((String) next.getKey(), (String) next.getValue());
            }
            return bundle;
        }
    }

    public InAppMessageWebViewClient(@NotNull Context context2, @NotNull IInAppMessage iInAppMessage, @Nullable IInAppMessageWebViewClientListener iInAppMessageWebViewClientListener) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        this.context = context2;
        this.inAppMessage = iInAppMessage;
        this.inAppMessageWebViewClientListener = iInAppMessageWebViewClientListener;
        this.maxOnPageFinishedWaitTimeMs = new BrazeConfigurationProvider(context2).getInAppMessageWebViewClientOnPageFinishedMaxWaitMs();
    }

    private final void appendBridgeJavascript(WebView webView) {
        try {
            AssetManager assets = this.context.getAssets();
            Intrinsics.checkNotNullExpressionValue(assets, "context.assets");
            webView.loadUrl(Intrinsics.stringPlus(JAVASCRIPT_PREFIX, BrazeFileUtils.getAssetFileStringContents(assets, BRIDGE_JS_FILE)));
        } catch (Exception e11) {
            BrazeInAppMessageManager.Companion.getInstance().hideCurrentlyDisplayingInAppMessage(false);
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) InAppMessageWebViewClient$appendBridgeJavascript$javascriptString$1.INSTANCE, 4, (Object) null);
        }
    }

    @JvmStatic
    @NotNull
    @VisibleForTesting
    public static final Bundle getBundleFromUrl(@NotNull String str) {
        return Companion.getBundleFromUrl(str);
    }

    private final boolean handleUrlOverride(String str) {
        if (this.inAppMessageWebViewClientListener == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) InAppMessageWebViewClient$handleUrlOverride$1.INSTANCE, 6, (Object) null);
            return true;
        } else if (StringsKt__StringsJVMKt.isBlank(str)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) InAppMessageWebViewClient$handleUrlOverride$2.INSTANCE, 6, (Object) null);
            return true;
        } else {
            Uri parse = Uri.parse(str);
            Bundle bundleFromUrl = Companion.getBundleFromUrl(str);
            if (parse.getScheme() == null || !Intrinsics.areEqual((Object) parse.getScheme(), (Object) APPBOY_INAPP_MESSAGE_SCHEME)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new InAppMessageWebViewClient$handleUrlOverride$4(parse), 7, (Object) null);
                this.inAppMessageWebViewClientListener.onOtherUrlAction(this.inAppMessage, str, bundleFromUrl);
                return true;
            }
            String authority = parse.getAuthority();
            if (authority != null) {
                int hashCode = authority.hashCode();
                if (hashCode != -1801488983) {
                    if (hashCode != 3138974) {
                        if (hashCode == 94756344 && authority.equals(AUTHORITY_NAME_CLOSE)) {
                            this.inAppMessageWebViewClientListener.onCloseAction(this.inAppMessage, str, bundleFromUrl);
                        }
                    } else if (authority.equals(AUTHORITY_NAME_NEWSFEED)) {
                        this.inAppMessageWebViewClientListener.onNewsfeedAction(this.inAppMessage, str, bundleFromUrl);
                    }
                } else if (authority.equals(AUTHORITY_NAME_CUSTOM_EVENT)) {
                    this.inAppMessageWebViewClientListener.onCustomEventAction(this.inAppMessage, str, bundleFromUrl);
                }
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new InAppMessageWebViewClient$handleUrlOverride$3(parse), 7, (Object) null);
            }
            return true;
        }
    }

    /* access modifiers changed from: private */
    public final void markPageFinished() {
        IWebViewClientStateListener iWebViewClientStateListener = this.webViewClientStateListener;
        if (iWebViewClientStateListener != null && this.hasCalledPageFinishedOnListener.compareAndSet(false, true)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) InAppMessageWebViewClient$markPageFinished$1$1.INSTANCE, 6, (Object) null);
            iWebViewClientStateListener.onPageFinished();
        }
    }

    public void onPageFinished(@NotNull WebView webView, @NotNull String str) {
        Intrinsics.checkNotNullParameter(webView, "view");
        Intrinsics.checkNotNullParameter(str, "url");
        appendBridgeJavascript(webView);
        IWebViewClientStateListener iWebViewClientStateListener = this.webViewClientStateListener;
        if (iWebViewClientStateListener != null && this.hasCalledPageFinishedOnListener.compareAndSet(false, true)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) InAppMessageWebViewClient$onPageFinished$1$1.INSTANCE, 6, (Object) null);
            iWebViewClientStateListener.onPageFinished();
        }
        this.hasPageFinishedLoading = true;
        Job job = this.markPageFinishedJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.markPageFinishedJob = null;
    }

    public boolean onRenderProcessGone(@NotNull WebView webView, @NotNull RenderProcessGoneDetail renderProcessGoneDetail) {
        Intrinsics.checkNotNullParameter(webView, "view");
        Intrinsics.checkNotNullParameter(renderProcessGoneDetail, ProductAction.ACTION_DETAIL);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) InAppMessageWebViewClient$onRenderProcessGone$1.INSTANCE, 6, (Object) null);
        return true;
    }

    public final void setWebViewClientStateListener(@Nullable IWebViewClientStateListener iWebViewClientStateListener) {
        if (iWebViewClientStateListener == null || !this.hasPageFinishedLoading || !this.hasCalledPageFinishedOnListener.compareAndSet(false, true)) {
            this.markPageFinishedJob = BrazeCoroutineScope.launchDelayed$default(BrazeCoroutineScope.INSTANCE, Integer.valueOf(this.maxOnPageFinishedWaitTimeMs), (CoroutineContext) null, new InAppMessageWebViewClient$setWebViewClientStateListener$1(this, (Continuation<? super InAppMessageWebViewClient$setWebViewClientStateListener$1>) null), 2, (Object) null);
        } else {
            iWebViewClientStateListener.onPageFinished();
        }
        this.webViewClientStateListener = iWebViewClientStateListener;
    }

    @RequiresApi(api = 21)
    public boolean shouldOverrideUrlLoading(@NotNull WebView webView, @NotNull WebResourceRequest webResourceRequest) {
        Intrinsics.checkNotNullParameter(webView, "view");
        Intrinsics.checkNotNullParameter(webResourceRequest, "request");
        String uri = webResourceRequest.getUrl().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "request.url.toString()");
        return handleUrlOverride(uri);
    }

    public boolean shouldOverrideUrlLoading(@NotNull WebView webView, @NotNull String str) {
        Intrinsics.checkNotNullParameter(webView, "view");
        Intrinsics.checkNotNullParameter(str, "url");
        return handleUrlOverride(str);
    }
}
