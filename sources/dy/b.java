package dy;

import com.talabat.wallet.screens.walletManageCard.interactor.WalletManageCreditCardsScreenInteractor;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class b implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f13910b;

    public /* synthetic */ b(List list) {
        this.f13910b = list;
    }

    public final Object apply(Object obj) {
        return WalletManageCreditCardsScreenInteractor.m5979deleteCards$lambda1(this.f13910b, (List) obj);
    }
}
