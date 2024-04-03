package com.talabat.wallet.screens.walletTopupCardList.interactor;

import JsonModels.Response.WalletCreditCardGetListDataItem;
import com.talabat.wallet.screens.walletTopupCardList.WalletTopupCardListListener;
import io.reactivex.observers.DisposableObserver;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.HttpException;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0016\u0010\t\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u000b"}, d2 = {"com/talabat/wallet/screens/walletTopupCardList/interactor/WalletTopupCardListScreenInteractor$getAllWalletCreditCards$2", "Lio/reactivex/observers/DisposableObserver;", "", "LJsonModels/Response/WalletCreditCardGetListDataItem$WalletCreditCardGetListResponseResult;", "onComplete", "", "onError", "throwable", "", "onNext", "walletCreditCardList", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTopupCardListScreenInteractor$getAllWalletCreditCards$2 extends DisposableObserver<List<? extends WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult>> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WalletTopupCardListScreenInteractor f12709b;

    public WalletTopupCardListScreenInteractor$getAllWalletCreditCards$2(WalletTopupCardListScreenInteractor walletTopupCardListScreenInteractor) {
        this.f12709b = walletTopupCardListScreenInteractor;
    }

    public void onComplete() {
    }

    public void onError(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "throwable");
        if (th2 instanceof HttpException) {
            WalletTopupCardListListener access$getWalletTopupCardListListener$p = this.f12709b.walletTopupCardListListener;
            if (access$getWalletTopupCardListListener$p != null) {
                access$getWalletTopupCardListListener$p.onServerError();
                return;
            }
            return;
        }
        WalletTopupCardListListener access$getWalletTopupCardListListener$p2 = this.f12709b.walletTopupCardListListener;
        if (access$getWalletTopupCardListListener$p2 != null) {
            access$getWalletTopupCardListListener$p2.onNetworkError();
        }
    }

    public void onNext(@NotNull List<WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult> list) {
        Intrinsics.checkNotNullParameter(list, "walletCreditCardList");
        WalletTopupCardListListener access$getWalletTopupCardListListener$p = this.f12709b.walletTopupCardListListener;
        if (access$getWalletTopupCardListListener$p != null) {
            access$getWalletTopupCardListListener$p.onWalletAllCreditCardsReceived(list);
        }
    }
}
