package com.talabat.talabatcommon.views.wallet.walletCardManagement.view;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/talabat/talabatcommon/views/wallet/walletCardManagement/view/WalletAddCardThreeDsSuccess$addWebViewListener$1", "Landroid/webkit/WebViewClient;", "shouldOverrideUrlLoading", "", "view", "Landroid/webkit/WebView;", "url", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletAddCardThreeDsSuccess$addWebViewListener$1 extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WalletAddCardThreeDsSuccess f11957a;

    public WalletAddCardThreeDsSuccess$addWebViewListener$1(WalletAddCardThreeDsSuccess walletAddCardThreeDsSuccess) {
        this.f11957a = walletAddCardThreeDsSuccess;
    }

    public boolean shouldOverrideUrlLoading(@Nullable WebView webView, @Nullable String str) {
        if (str == null) {
            return false;
        }
        WalletAddCardThreeDsSuccess walletAddCardThreeDsSuccess = this.f11957a;
        if (StringsKt__StringsKt.contains((CharSequence) str, (CharSequence) "ThankYou", true)) {
            walletAddCardThreeDsSuccess.redirectToSuccessScreen();
            return false;
        } else if (!StringsKt__StringsKt.contains((CharSequence) str, (CharSequence) "error", true)) {
            return false;
        } else {
            walletAddCardThreeDsSuccess.redirectToErrorScreen();
            return false;
        }
    }
}
