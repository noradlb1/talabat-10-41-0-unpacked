package com.talabat.wallet.screens.walletTopupCardList.view;

import JsonModels.Response.WalletCreditCardGetListDataItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "creditCardItem", "LJsonModels/Response/WalletCreditCardGetListDataItem$WalletCreditCardGetListResponseResult;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class WalletTopupCardListScreen$initializeRecyclerView$1 extends Lambda implements Function1<WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ WalletTopupCardListScreen f12712g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletTopupCardListScreen$initializeRecyclerView$1(WalletTopupCardListScreen walletTopupCardListScreen) {
        super(1);
        this.f12712g = walletTopupCardListScreen;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult walletCreditCardGetListResponseResult) {
        Intrinsics.checkNotNullParameter(walletCreditCardGetListResponseResult, "creditCardItem");
        this.f12712g.creditCardItemClicked(walletCreditCardGetListResponseResult);
    }
}
