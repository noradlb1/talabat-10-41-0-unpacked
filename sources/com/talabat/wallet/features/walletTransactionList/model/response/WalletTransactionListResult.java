package com.talabat.wallet.features.walletTransactionList.model.response;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/talabat/wallet/features/walletTransactionList/model/response/WalletTransactionListResult;", "", "transactionList", "", "Lcom/talabat/wallet/features/walletTransactionList/model/response/TransactionModel;", "spendPerMonthList", "Lcom/talabat/wallet/features/walletTransactionList/model/response/WalletTransactionSpentPerMonthModel;", "(Ljava/util/List;Ljava/util/List;)V", "getSpendPerMonthList", "()Ljava/util/List;", "setSpendPerMonthList", "(Ljava/util/List;)V", "getTransactionList", "setTransactionList", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionListResult {
    @Nullable
    private List<WalletTransactionSpentPerMonthModel> spendPerMonthList;
    @Nullable
    private List<TransactionModel> transactionList;

    public WalletTransactionListResult(@Nullable List<TransactionModel> list, @Nullable List<WalletTransactionSpentPerMonthModel> list2) {
        this.transactionList = list;
        this.spendPerMonthList = list2;
    }

    public static /* synthetic */ WalletTransactionListResult copy$default(WalletTransactionListResult walletTransactionListResult, List<TransactionModel> list, List<WalletTransactionSpentPerMonthModel> list2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = walletTransactionListResult.transactionList;
        }
        if ((i11 & 2) != 0) {
            list2 = walletTransactionListResult.spendPerMonthList;
        }
        return walletTransactionListResult.copy(list, list2);
    }

    @Nullable
    public final List<TransactionModel> component1() {
        return this.transactionList;
    }

    @Nullable
    public final List<WalletTransactionSpentPerMonthModel> component2() {
        return this.spendPerMonthList;
    }

    @NotNull
    public final WalletTransactionListResult copy(@Nullable List<TransactionModel> list, @Nullable List<WalletTransactionSpentPerMonthModel> list2) {
        return new WalletTransactionListResult(list, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletTransactionListResult)) {
            return false;
        }
        WalletTransactionListResult walletTransactionListResult = (WalletTransactionListResult) obj;
        return Intrinsics.areEqual((Object) this.transactionList, (Object) walletTransactionListResult.transactionList) && Intrinsics.areEqual((Object) this.spendPerMonthList, (Object) walletTransactionListResult.spendPerMonthList);
    }

    @Nullable
    public final List<WalletTransactionSpentPerMonthModel> getSpendPerMonthList() {
        return this.spendPerMonthList;
    }

    @Nullable
    public final List<TransactionModel> getTransactionList() {
        return this.transactionList;
    }

    public int hashCode() {
        List<TransactionModel> list = this.transactionList;
        int i11 = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<WalletTransactionSpentPerMonthModel> list2 = this.spendPerMonthList;
        if (list2 != null) {
            i11 = list2.hashCode();
        }
        return hashCode + i11;
    }

    public final void setSpendPerMonthList(@Nullable List<WalletTransactionSpentPerMonthModel> list) {
        this.spendPerMonthList = list;
    }

    public final void setTransactionList(@Nullable List<TransactionModel> list) {
        this.transactionList = list;
    }

    @NotNull
    public String toString() {
        List<TransactionModel> list = this.transactionList;
        List<WalletTransactionSpentPerMonthModel> list2 = this.spendPerMonthList;
        return "WalletTransactionListResult(transactionList=" + list + ", spendPerMonthList=" + list2 + ")";
    }
}
