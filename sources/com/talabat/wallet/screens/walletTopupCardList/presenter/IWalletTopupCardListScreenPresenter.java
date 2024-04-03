package com.talabat.wallet.screens.walletTopupCardList.presenter;

import JsonModels.Response.WalletCreditCardGetListDataItem;
import kotlin.Metadata;
import library.talabat.mvp.IGlobalPresenter;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/talabat/wallet/screens/walletTopupCardList/presenter/IWalletTopupCardListScreenPresenter;", "Llibrary/talabat/mvp/IGlobalPresenter;", "setAllWalletCreditCards", "", "setWalletBankPartnerCardMessage", "card", "LJsonModels/Response/WalletCreditCardGetListDataItem$WalletCreditCardGetListResponseResult;", "position", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IWalletTopupCardListScreenPresenter extends IGlobalPresenter {
    void setAllWalletCreditCards();

    void setWalletBankPartnerCardMessage(@NotNull WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult walletCreditCardGetListResponseResult, int i11);
}
