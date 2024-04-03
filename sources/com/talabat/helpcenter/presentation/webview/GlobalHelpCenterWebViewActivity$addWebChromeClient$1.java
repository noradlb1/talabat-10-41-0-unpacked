package com.talabat.helpcenter.presentation.webview;

import android.net.Uri;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0014\u0010\u0006\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"com/talabat/helpcenter/presentation/webview/GlobalHelpCenterWebViewActivity$addWebChromeClient$1", "Landroid/webkit/WebChromeClient;", "onShowFileChooser", "", "webView", "Landroid/webkit/WebView;", "filePathCallback", "Landroid/webkit/ValueCallback;", "", "Landroid/net/Uri;", "fileChooserParams", "Landroid/webkit/WebChromeClient$FileChooserParams;", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GlobalHelpCenterWebViewActivity$addWebChromeClient$1 extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GlobalHelpCenterWebViewActivity f60771a;

    public GlobalHelpCenterWebViewActivity$addWebChromeClient$1(GlobalHelpCenterWebViewActivity globalHelpCenterWebViewActivity) {
        this.f60771a = globalHelpCenterWebViewActivity;
    }

    public boolean onShowFileChooser(@Nullable WebView webView, @Nullable ValueCallback<Uri[]> valueCallback, @Nullable WebChromeClient.FileChooserParams fileChooserParams) {
        this.f60771a.getViewModel().onShowFileChooser(valueCallback);
        return true;
    }
}
