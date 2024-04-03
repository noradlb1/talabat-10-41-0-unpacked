package com.talabat.wallet.screens.walletAddCard.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import com.talabat.wallet.screens.walletManageCard.view.WalletManageCreditCardsScreen;
import com.talabat.wallet.screens.walletTopupCardList.view.WalletTopupCardListScreen;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/talabat/wallet/screens/walletAddCard/view/CheckoutWebView$onCreate$1", "Landroid/webkit/WebViewClient;", "shouldOverrideUrlLoading", "", "view", "Landroid/webkit/WebView;", "url", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CheckoutWebView$onCreate$1 extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CheckoutWebView f12675a;

    public CheckoutWebView$onCreate$1(CheckoutWebView checkoutWebView) {
        this.f12675a = checkoutWebView;
    }

    public boolean shouldOverrideUrlLoading(@Nullable WebView webView, @Nullable String str) {
        Intent intent;
        boolean z11;
        boolean z12;
        CheckoutWebView checkoutWebView = this.f12675a;
        Intrinsics.checkNotNull(str);
        if (StringsKt__StringsKt.contains((CharSequence) str, (CharSequence) checkoutWebView.THANK_YOU, true)) {
            String access$getEMPTY_STRING$p = checkoutWebView.EMPTY_STRING;
            if (checkoutWebView.getIntent().hasExtra(checkoutWebView.SOURCE) && (access$getEMPTY_STRING$p = checkoutWebView.getIntent().getStringExtra(checkoutWebView.SOURCE)) == null) {
                access$getEMPTY_STRING$p = "";
            }
            if (StringsKt__StringsJVMKt.equals(access$getEMPTY_STRING$p, checkoutWebView.TOP_UP_SCREEN, false)) {
                intent = new Intent(checkoutWebView, WalletTopupCardListScreen.class);
            } else if (StringsKt__StringsJVMKt.equals(access$getEMPTY_STRING$p, "walletPaymentBottomSheet", false)) {
                checkoutWebView.finish();
                return false;
            } else {
                String stringExtra = checkoutWebView.getIntent().getStringExtra("subscriptionMemberId");
                if (stringExtra == null || stringExtra.length() == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z11) {
                    checkoutWebView.navigateToSubscriptionDetailScreen(checkoutWebView.getIntent().getStringExtra("subscriptionMemberId"));
                    return false;
                }
                if (access$getEMPTY_STRING$p.length() > 0) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z12) {
                    Navigator.Companion companion = Navigator.Companion;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(WalletNavigatorActions.EXTRA_IS_CARD_SUCCESSFULLY_ADDED, true);
                    Unit unit = Unit.INSTANCE;
                    companion.navigate((Context) checkoutWebView, new NavigatorModel(access$getEMPTY_STRING$p, bundle, CheckoutWebView$onCreate$1$shouldOverrideUrlLoading$1$2.INSTANCE));
                    return false;
                }
                intent = new Intent(checkoutWebView, WalletManageCreditCardsScreen.class);
            }
            intent.putExtra(checkoutWebView.STATUS, checkoutWebView.SUCCESS);
            intent.addFlags(335544320);
            intent.addFlags(1073741824);
            checkoutWebView.startActivity(intent);
            checkoutWebView.finish();
        } else if (StringsKt__StringsKt.contains((CharSequence) str, (CharSequence) checkoutWebView.PAYMENT_ERROR, true)) {
            Intent intent2 = new Intent();
            intent2.putExtra(checkoutWebView.STATUS, checkoutWebView.ERROR);
            checkoutWebView.setResult(checkoutWebView.RESULT_CODE, intent2);
            checkoutWebView.finish();
        }
        return false;
    }
}
