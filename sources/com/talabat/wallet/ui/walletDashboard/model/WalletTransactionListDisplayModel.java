package com.talabat.wallet.ui.walletDashboard.model;

import com.talabat.wallet.ui.walletDashboard.model.WalletTransactionListDataItemDisplayModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListDisplayModel;", "", "()V", "isWalletTransactionListLoaded", "", "()Z", "setWalletTransactionListLoaded", "(Z)V", "lastTransactionDisplayModel", "Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListDataItemDisplayModel$TransactionDisplayModel;", "getLastTransactionDisplayModel", "()Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListDataItemDisplayModel$TransactionDisplayModel;", "setLastTransactionDisplayModel", "(Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListDataItemDisplayModel$TransactionDisplayModel;)V", "spendPerMonthList", "", "Lcom/talabat/wallet/ui/walletDashboard/model/MonthlySpentDisplayModel;", "getSpendPerMonthList", "()Ljava/util/List;", "setSpendPerMonthList", "(Ljava/util/List;)V", "walletTransactionList", "Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListDataItemDisplayModel;", "getWalletTransactionList", "setWalletTransactionList", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionListDisplayModel {
    private boolean isWalletTransactionListLoaded;
    @NotNull
    private WalletTransactionListDataItemDisplayModel.TransactionDisplayModel lastTransactionDisplayModel = new WalletTransactionListDataItemDisplayModel.TransactionDisplayModel();
    @NotNull
    private List<MonthlySpentDisplayModel> spendPerMonthList = CollectionsKt__CollectionsKt.emptyList();
    @NotNull
    private List<? extends WalletTransactionListDataItemDisplayModel> walletTransactionList = CollectionsKt__CollectionsKt.emptyList();

    @NotNull
    public final WalletTransactionListDataItemDisplayModel.TransactionDisplayModel getLastTransactionDisplayModel() {
        return this.lastTransactionDisplayModel;
    }

    @NotNull
    public final List<MonthlySpentDisplayModel> getSpendPerMonthList() {
        return this.spendPerMonthList;
    }

    @NotNull
    public final List<WalletTransactionListDataItemDisplayModel> getWalletTransactionList() {
        return this.walletTransactionList;
    }

    public final boolean isWalletTransactionListLoaded() {
        return this.isWalletTransactionListLoaded;
    }

    public final void setLastTransactionDisplayModel(@NotNull WalletTransactionListDataItemDisplayModel.TransactionDisplayModel transactionDisplayModel) {
        Intrinsics.checkNotNullParameter(transactionDisplayModel, "<set-?>");
        this.lastTransactionDisplayModel = transactionDisplayModel;
    }

    public final void setSpendPerMonthList(@NotNull List<MonthlySpentDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.spendPerMonthList = list;
    }

    public final void setWalletTransactionList(@NotNull List<? extends WalletTransactionListDataItemDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.walletTransactionList = list;
    }

    public final void setWalletTransactionListLoaded(boolean z11) {
        this.isWalletTransactionListLoaded = z11;
    }
}
