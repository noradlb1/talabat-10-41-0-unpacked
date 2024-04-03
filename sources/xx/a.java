package xx;

import JsonModels.Response.WalletTransactionListDataItem;
import JsonModels.Response.WalletTransactionListResponse;
import com.talabat.wallet.screens.walletDashboard.interactor.WalletTransactionDashboardScreenInteractor;
import io.reactivex.functions.Function;

public final /* synthetic */ class a implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WalletTransactionDashboardScreenInteractor f24185b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WalletTransactionListDataItem.TransactionModel f24186c;

    public /* synthetic */ a(WalletTransactionDashboardScreenInteractor walletTransactionDashboardScreenInteractor, WalletTransactionListDataItem.TransactionModel transactionModel) {
        this.f24185b = walletTransactionDashboardScreenInteractor;
        this.f24186c = transactionModel;
    }

    public final Object apply(Object obj) {
        return WalletTransactionDashboardScreenInteractor.m5969getWalletCreditTransactionList$lambda0(this.f24185b, this.f24186c, (WalletTransactionListResponse) obj);
    }
}
