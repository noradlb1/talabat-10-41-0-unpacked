package com.talabat.wallet.screens.walletDashboard.view;

import JsonModels.Response.WalletTransactionListDataItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "transactionItem", "LJsonModels/Response/WalletTransactionListDataItem$TransactionModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionDashboardScreen$initializeRecyclerView$1 extends Lambda implements Function1<WalletTransactionListDataItem.TransactionModel, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ WalletTransactionDashboardScreen f12687g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletTransactionDashboardScreen$initializeRecyclerView$1(WalletTransactionDashboardScreen walletTransactionDashboardScreen) {
        super(1);
        this.f12687g = walletTransactionDashboardScreen;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WalletTransactionListDataItem.TransactionModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull WalletTransactionListDataItem.TransactionModel transactionModel) {
        Intrinsics.checkNotNullParameter(transactionModel, "transactionItem");
        this.f12687g.transactionItemClicked(transactionModel);
    }
}
