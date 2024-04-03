package jy;

import JsonModels.Response.WalletCashbackCampaignOfferMessageResponse;
import JsonModels.Response.WalletCreditCardGetListDataItem;
import com.talabat.wallet.screens.walletTopupCardList.interactor.WalletTopupCardListScreenInteractor;
import io.reactivex.functions.Function;

public final /* synthetic */ class c implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WalletTopupCardListScreenInteractor f23736b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult f23737c;

    public /* synthetic */ c(WalletTopupCardListScreenInteractor walletTopupCardListScreenInteractor, WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult walletCreditCardGetListResponseResult) {
        this.f23736b = walletTopupCardListScreenInteractor;
        this.f23737c = walletCreditCardGetListResponseResult;
    }

    public final Object apply(Object obj) {
        return WalletTopupCardListScreenInteractor.m6005getCashBackCampaignPerCard$lambda6(this.f23736b, this.f23737c, (WalletCashbackCampaignOfferMessageResponse) obj);
    }
}
