package dy;

import JsonModels.Response.WalletCreditCardGetListResponse;
import com.talabat.wallet.screens.walletManageCard.interactor.WalletManageCreditCardsScreenInteractor;
import io.reactivex.functions.Function;

public final /* synthetic */ class a implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WalletManageCreditCardsScreenInteractor f13907b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f13908c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f13909d;

    public /* synthetic */ a(WalletManageCreditCardsScreenInteractor walletManageCreditCardsScreenInteractor, String str, String str2) {
        this.f13907b = walletManageCreditCardsScreenInteractor;
        this.f13908c = str;
        this.f13909d = str2;
    }

    public final Object apply(Object obj) {
        return WalletManageCreditCardsScreenInteractor.m5981getAllWalletCreditCards$lambda0(this.f13907b, this.f13908c, this.f13909d, (WalletCreditCardGetListResponse) obj);
    }
}
