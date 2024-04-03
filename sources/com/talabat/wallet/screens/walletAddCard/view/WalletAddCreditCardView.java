package com.talabat.wallet.screens.walletAddCard.view;

import com.talabat.helpers.Talabat;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, d2 = {"Lcom/talabat/wallet/screens/walletAddCard/view/WalletAddCreditCardView;", "Lcom/talabat/helpers/Talabat;", "onErrorReceived", "", "message", "", "onNonThreeDSCardSaved", "onServerError", "openWebView", "url", "setUpViewBeforeResponse", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface WalletAddCreditCardView extends Talabat {
    void onErrorReceived();

    void onErrorReceived(@Nullable String str);

    void onNonThreeDSCardSaved();

    void onServerError();

    void openWebView(@Nullable String str);

    void setUpViewBeforeResponse();
}
