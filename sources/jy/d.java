package jy;

import JsonModels.Response.WalletCreditCardGetListResponse;
import com.talabat.wallet.screens.walletTopupCardList.interactor.WalletTopupCardListScreenInteractor;
import io.reactivex.functions.Function;

public final /* synthetic */ class d implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WalletTopupCardListScreenInteractor f23738b;

    public /* synthetic */ d(WalletTopupCardListScreenInteractor walletTopupCardListScreenInteractor) {
        this.f23738b = walletTopupCardListScreenInteractor;
    }

    public final Object apply(Object obj) {
        return WalletTopupCardListScreenInteractor.m6004getAllWalletCreditCards$lambda0(this.f23738b, (WalletCreditCardGetListResponse) obj);
    }
}
