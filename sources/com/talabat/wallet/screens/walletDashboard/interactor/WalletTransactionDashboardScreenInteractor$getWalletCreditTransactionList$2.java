package com.talabat.wallet.screens.walletDashboard.interactor;

import JsonModels.Response.WalletTransactionListDataModel;
import com.talabat.wallet.screens.walletDashboard.WalletTransactionDashboardScreenListener;
import io.reactivex.observers.DisposableObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"com/talabat/wallet/screens/walletDashboard/interactor/WalletTransactionDashboardScreenInteractor$getWalletCreditTransactionList$2", "Lio/reactivex/observers/DisposableObserver;", "LJsonModels/Response/WalletTransactionListDataModel;", "onComplete", "", "onError", "throwable", "", "onNext", "walletTransactionListDataModel", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionDashboardScreenInteractor$getWalletCreditTransactionList$2 extends DisposableObserver<WalletTransactionListDataModel> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WalletTransactionDashboardScreenInteractor f12679b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f12680c;

    public WalletTransactionDashboardScreenInteractor$getWalletCreditTransactionList$2(WalletTransactionDashboardScreenInteractor walletTransactionDashboardScreenInteractor, String str) {
        this.f12679b = walletTransactionDashboardScreenInteractor;
        this.f12680c = str;
    }

    public void onComplete() {
    }

    public void onError(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "throwable");
        th2.printStackTrace();
        String localizedMessage = th2.getLocalizedMessage();
        Intrinsics.checkNotNullExpressionValue(localizedMessage, "throwable.localizedMessage");
        String lowerCase = localizedMessage.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        if (StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) this.f12680c, false, 2, (Object) null)) {
            WalletTransactionDashboardScreenListener access$getWalletTransactionDashboardScreenListener$p = this.f12679b.walletTransactionDashboardScreenListener;
            if (access$getWalletTransactionDashboardScreenListener$p != null) {
                access$getWalletTransactionDashboardScreenListener$p.onServerError();
                return;
            }
            return;
        }
        WalletTransactionDashboardScreenListener access$getWalletTransactionDashboardScreenListener$p2 = this.f12679b.walletTransactionDashboardScreenListener;
        if (access$getWalletTransactionDashboardScreenListener$p2 != null) {
            access$getWalletTransactionDashboardScreenListener$p2.onNetworkError();
        }
    }

    public void onNext(@NotNull WalletTransactionListDataModel walletTransactionListDataModel) {
        Intrinsics.checkNotNullParameter(walletTransactionListDataModel, "walletTransactionListDataModel");
        WalletTransactionDashboardScreenListener access$getWalletTransactionDashboardScreenListener$p = this.f12679b.walletTransactionDashboardScreenListener;
        if (access$getWalletTransactionDashboardScreenListener$p != null) {
            access$getWalletTransactionDashboardScreenListener$p.onWalletCreditTransactionListReceived(walletTransactionListDataModel);
        }
    }
}
