package jy;

import JsonModels.Response.WalletCashbackCampaignResponse;
import com.talabat.wallet.screens.walletTopupCardList.interactor.WalletTopupCardListScreenInteractor;
import io.reactivex.functions.BiFunction;
import java.util.List;

public final /* synthetic */ class a implements BiFunction {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WalletTopupCardListScreenInteractor f23734b;

    public /* synthetic */ a(WalletTopupCardListScreenInteractor walletTopupCardListScreenInteractor) {
        this.f23734b = walletTopupCardListScreenInteractor;
    }

    public final Object apply(Object obj, Object obj2) {
        return WalletTopupCardListScreenInteractor.m6002getAllApiDataForBankPartnership$lambda2(this.f23734b, (WalletCashbackCampaignResponse) obj, (List) obj2);
    }
}
