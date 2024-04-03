package com.talabat.helpcenter.presentation.webview;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.talabat.talabatcore.logger.LogManager;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/talabat/helpcenter/presentation/webview/GlobalHelpCenterWebViewActivity$addJavascriptInterface$1", "Landroid/webkit/WebViewClient;", "shouldOverrideUrlLoading", "", "view", "Landroid/webkit/WebView;", "url", "", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GlobalHelpCenterWebViewActivity$addJavascriptInterface$1 extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GlobalHelpCenterWebViewActivity f60770a;

    public GlobalHelpCenterWebViewActivity$addJavascriptInterface$1(GlobalHelpCenterWebViewActivity globalHelpCenterWebViewActivity) {
        this.f60770a = globalHelpCenterWebViewActivity;
    }

    public boolean shouldOverrideUrlLoading(@Nullable WebView webView, @Nullable String str) {
        LogManager.debug("GHC: shouldOverrideUrlLoading: " + str);
        if (str == null || !StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) GlobalHelpCenterWebViewActivity.RIDER_CHAT_DEEP_LINK, false, 2, (Object) null)) {
            return false;
        }
        this.f60770a.redirectToRiderChat(str);
        return true;
    }
}
