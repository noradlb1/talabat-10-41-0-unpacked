package com.talabat.wallet.screens.walletTopupCardList.interactor;

import JsonModels.Response.WalletCashbackCampaignResponse;
import JsonModels.Response.WalletCreditCardGetListDataItem;
import io.reactivex.Observable;
import kotlin.Metadata;
import library.talabat.mvp.IGlobalInteractor;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\tJ)\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\rJ!\u0010\u000e\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\u000fJ$\u0010\u0010\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0007H&¨\u0006\u0014"}, d2 = {"Lcom/talabat/wallet/screens/walletTopupCardList/interactor/IWalletTopupCardListScreenInteractor;", "Llibrary/talabat/mvp/IGlobalInteractor;", "getAllApiDataForBankPartnership", "", "countryId", "", "paymentProvider", "", "eventId", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAllCashBackCampaigns", "Lio/reactivex/Observable;", "LJsonModels/Response/WalletCashbackCampaignResponse;", "(Ljava/lang/String;Ljava/lang/Integer;)Lio/reactivex/Observable;", "getAllWalletCreditCards", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getCashBackCampaignPerCard", "card", "LJsonModels/Response/WalletCreditCardGetListDataItem$WalletCreditCardGetListResponseResult;", "position", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IWalletTopupCardListScreenInteractor extends IGlobalInteractor {
    void getAllApiDataForBankPartnership(@Nullable String str, @Nullable Integer num, @Nullable Integer num2);

    @Nullable
    Observable<WalletCashbackCampaignResponse> getAllCashBackCampaigns(@Nullable String str, @Nullable Integer num);

    void getAllWalletCreditCards(@Nullable Integer num, @Nullable Integer num2);

    void getCashBackCampaignPerCard(@Nullable String str, @Nullable WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult walletCreditCardGetListResponseResult, int i11);
}
