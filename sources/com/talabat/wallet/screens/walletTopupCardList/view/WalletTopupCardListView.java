package com.talabat.wallet.screens.walletTopupCardList.view;

import JsonModels.Response.WalletCreditCardGetListDataItem;
import com.talabat.helpers.Talabat;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0016\u0010\b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nH&J\b\u0010\u000b\u001a\u00020\u0003H&J\u0018\u0010\f\u001a\u00020\u00032\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\nH&J\b\u0010\u000e\u001a\u00020\u0003H&¨\u0006\u000f"}, d2 = {"Lcom/talabat/wallet/screens/walletTopupCardList/view/WalletTopupCardListView;", "Lcom/talabat/helpers/Talabat;", "onReceivedBankPartnerCardAdvertMessage", "", "walletCreditCardGetListDataItem", "LJsonModels/Response/WalletCreditCardGetListDataItem;", "position", "", "onReceivedBankPartnerData", "walletCreditCardList", "", "onServerError", "onWalletCardReceived", "LJsonModels/Response/WalletCreditCardGetListDataItem$WalletCreditCardGetListResponseResult;", "setupViewsBeforeServiceRequest", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface WalletTopupCardListView extends Talabat {
    void onReceivedBankPartnerCardAdvertMessage(@NotNull WalletCreditCardGetListDataItem walletCreditCardGetListDataItem, int i11);

    void onReceivedBankPartnerData(@NotNull List<? extends WalletCreditCardGetListDataItem> list);

    void onServerError();

    void onWalletCardReceived(@Nullable List<WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult> list);

    void setupViewsBeforeServiceRequest();
}
