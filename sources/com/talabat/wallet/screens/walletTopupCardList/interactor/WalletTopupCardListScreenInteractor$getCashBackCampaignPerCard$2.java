package com.talabat.wallet.screens.walletTopupCardList.interactor;

import JsonModels.Response.WalletCreditCardGetListDataItem;
import com.talabat.wallet.screens.walletTopupCardList.WalletTopupCardListListener;
import io.reactivex.observers.DisposableObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"com/talabat/wallet/screens/walletTopupCardList/interactor/WalletTopupCardListScreenInteractor$getCashBackCampaignPerCard$2", "Lio/reactivex/observers/DisposableObserver;", "LJsonModels/Response/WalletCreditCardGetListDataItem;", "onComplete", "", "onError", "throwable", "", "onNext", "walletCreditCardGetListDataItem", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTopupCardListScreenInteractor$getCashBackCampaignPerCard$2 extends DisposableObserver<WalletCreditCardGetListDataItem> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WalletTopupCardListScreenInteractor f12710b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f12711c;

    public WalletTopupCardListScreenInteractor$getCashBackCampaignPerCard$2(WalletTopupCardListScreenInteractor walletTopupCardListScreenInteractor, int i11) {
        this.f12710b = walletTopupCardListScreenInteractor;
        this.f12711c = i11;
    }

    public void onComplete() {
    }

    public void onError(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "throwable");
    }

    public void onNext(@NotNull WalletCreditCardGetListDataItem walletCreditCardGetListDataItem) {
        Intrinsics.checkNotNullParameter(walletCreditCardGetListDataItem, "walletCreditCardGetListDataItem");
        WalletTopupCardListListener access$getWalletTopupCardListListener$p = this.f12710b.walletTopupCardListListener;
        if (access$getWalletTopupCardListListener$p != null) {
            access$getWalletTopupCardListListener$p.onCardWithBankPartnerAdvertMessageReceived(walletCreditCardGetListDataItem, this.f12711c);
        }
    }
}
