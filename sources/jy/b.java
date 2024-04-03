package jy;

import JsonModels.Response.WalletCreditCardGetListResponse;
import com.talabat.wallet.screens.walletTopupCardList.interactor.WalletTopupCardListScreenInteractor;
import io.reactivex.functions.Function;

public final /* synthetic */ class b implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WalletTopupCardListScreenInteractor f23735b;

    public /* synthetic */ b(WalletTopupCardListScreenInteractor walletTopupCardListScreenInteractor) {
        this.f23735b = walletTopupCardListScreenInteractor;
    }

    public final Object apply(Object obj) {
        return WalletTopupCardListScreenInteractor.m6003getAllWalletCredit$lambda1(this.f23735b, (WalletCreditCardGetListResponse) obj);
    }
}
