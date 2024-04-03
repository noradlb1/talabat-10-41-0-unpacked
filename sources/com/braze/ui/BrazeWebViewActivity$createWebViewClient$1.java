package com.braze.ui;

import android.content.Context;
import android.net.Uri;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.RequiresApi;
import com.appboy.enums.Channel;
import com.braze.support.BrazeFileUtils;
import com.braze.support.BrazeLogger;
import com.braze.ui.actions.UriAction;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0017J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0011"}, d2 = {"com/braze/ui/BrazeWebViewActivity$createWebViewClient$1", "Landroid/webkit/WebViewClient;", "handleUrlOverride", "", "context", "Landroid/content/Context;", "url", "", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Boolean;", "onRenderProcessGone", "view", "Landroid/webkit/WebView;", "detail", "Landroid/webkit/RenderProcessGoneDetail;", "shouldOverrideUrlLoading", "request", "Landroid/webkit/WebResourceRequest;", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BrazeWebViewActivity$createWebViewClient$1 extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BrazeWebViewActivity f44002a;

    public BrazeWebViewActivity$createWebViewClient$1(BrazeWebViewActivity brazeWebViewActivity) {
        this.f44002a = brazeWebViewActivity;
    }

    private final Boolean handleUrlOverride(Context context, String str) {
        try {
            if (CollectionsKt___CollectionsKt.contains(BrazeFileUtils.REMOTE_SCHEMES, Uri.parse(str).getScheme())) {
                return null;
            }
            UriAction createUriActionFromUrlString = BrazeDeeplinkHandler.Companion.getInstance().createUriActionFromUrlString(str, this.f44002a.getIntent().getExtras(), false, Channel.UNKNOWN);
            if (createUriActionFromUrlString == null) {
                return Boolean.FALSE;
            }
            createUriActionFromUrlString.execute(context);
            this.f44002a.finish();
            return Boolean.TRUE;
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new BrazeWebViewActivity$createWebViewClient$1$handleUrlOverride$1(str), 4, (Object) null);
            return null;
        }
    }

    public boolean onRenderProcessGone(@NotNull WebView webView, @NotNull RenderProcessGoneDetail renderProcessGoneDetail) {
        Intrinsics.checkNotNullParameter(webView, "view");
        Intrinsics.checkNotNullParameter(renderProcessGoneDetail, ProductAction.ACTION_DETAIL);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) BrazeWebViewActivity$createWebViewClient$1$onRenderProcessGone$1.INSTANCE, 6, (Object) null);
        return true;
    }

    @RequiresApi(api = 21)
    public boolean shouldOverrideUrlLoading(@NotNull WebView webView, @NotNull WebResourceRequest webResourceRequest) {
        Intrinsics.checkNotNullParameter(webView, "view");
        Intrinsics.checkNotNullParameter(webResourceRequest, "request");
        Context context = webView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        String uri = webResourceRequest.getUrl().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "request.url.toString()");
        Boolean handleUrlOverride = handleUrlOverride(context, uri);
        return handleUrlOverride == null ? super.shouldOverrideUrlLoading(webView, webResourceRequest) : handleUrlOverride.booleanValue();
    }

    public boolean shouldOverrideUrlLoading(@NotNull WebView webView, @NotNull String str) {
        Intrinsics.checkNotNullParameter(webView, "view");
        Intrinsics.checkNotNullParameter(str, "url");
        Context context = webView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        Boolean handleUrlOverride = handleUrlOverride(context, str);
        return handleUrlOverride == null ? super.shouldOverrideUrlLoading(webView, str) : handleUrlOverride.booleanValue();
    }
}
