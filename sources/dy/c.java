package dy;

import JsonModels.Request.WalletDeleteCreditCardRequest;
import com.talabat.wallet.screens.walletManageCard.interactor.WalletManageCreditCardsScreenInteractor;
import io.reactivex.functions.Function;

public final /* synthetic */ class c implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WalletManageCreditCardsScreenInteractor f13911b;

    public /* synthetic */ c(WalletManageCreditCardsScreenInteractor walletManageCreditCardsScreenInteractor) {
        this.f13911b = walletManageCreditCardsScreenInteractor;
    }

    public final Object apply(Object obj) {
        return WalletManageCreditCardsScreenInteractor.m5980deleteCards$lambda2(this.f13911b, (WalletDeleteCreditCardRequest) obj);
    }
}
