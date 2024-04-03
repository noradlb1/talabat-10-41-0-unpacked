package com.talabat.talabatcommon.views.wallet.walletPaymentOption.view;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.viewModel.WalletPaymentOptionViewModel;
import com.talabat.talabatcore.logger.LogManager;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/talabat/talabatcommon/views/wallet/walletPaymentOption/view/WalletPaymentThreeDsFragment$addWebViewListener$1", "Landroid/webkit/WebViewClient;", "shouldOverrideUrlLoading", "", "view", "Landroid/webkit/WebView;", "url", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletPaymentThreeDsFragment$addWebViewListener$1 extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WalletPaymentThreeDsFragment f11986a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f11987b;

    public WalletPaymentThreeDsFragment$addWebViewListener$1(WalletPaymentThreeDsFragment walletPaymentThreeDsFragment, boolean z11) {
        this.f11986a = walletPaymentThreeDsFragment;
        this.f11987b = z11;
    }

    public boolean shouldOverrideUrlLoading(@Nullable WebView webView, @Nullable String str) {
        String str2;
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        LogManager.debug(str2);
        WalletPaymentOptionViewModel access$getViewModel = WalletPaymentThreeDsFragment.access$getViewModel(this.f11986a);
        if (str == null) {
            str = "";
        }
        access$getViewModel.onThreeDSURLCheck(str, this.f11987b);
        return false;
    }
}
