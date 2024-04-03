package com.talabat.wallet.screens.walletTopUp.view;

import JsonModels.Response.WalletCalculateCashBackResult;
import JsonModels.Response.WalletTopUpAmountSuggestion;
import com.talabat.helpers.Talabat;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u0016\u0010\u000f\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H&J\b\u0010\u0013\u001a\u00020\u0003H&¨\u0006\u0014"}, d2 = {"Lcom/talabat/wallet/screens/walletTopUp/view/WalletTopUpView;", "Lcom/talabat/helpers/Talabat;", "onServerError", "", "onTopUpFailure", "message", "", "onTopUpServerError", "onTopUpSuccess", "onTopUpSuggestionError", "setEmptyWalletTopUpSuggestion", "setUpTopupLoader", "setWalletCalculatedCashBack", "walletCalculateCashBackResult", "LJsonModels/Response/WalletCalculateCashBackResult;", "setWalletTopUpAmountSuggestion", "walletTopUpAmountSuggestionList", "", "LJsonModels/Response/WalletTopUpAmountSuggestion;", "setupViewsBeforeServiceRequest", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface WalletTopUpView extends Talabat {
    void onServerError();

    void onTopUpFailure(@NotNull String str);

    void onTopUpServerError();

    void onTopUpSuccess();

    void onTopUpSuggestionError();

    void setEmptyWalletTopUpSuggestion();

    void setUpTopupLoader();

    void setWalletCalculatedCashBack(@Nullable WalletCalculateCashBackResult walletCalculateCashBackResult);

    void setWalletTopUpAmountSuggestion(@NotNull List<WalletTopUpAmountSuggestion> list);

    void setupViewsBeforeServiceRequest();
}
