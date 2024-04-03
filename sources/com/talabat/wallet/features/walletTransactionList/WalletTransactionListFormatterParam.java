package com.talabat.wallet.features.walletTransactionList;

import com.talabat.wallet.features.walletTransactionList.model.response.WalletTransactionListResponse;
import com.talabat.wallet.ui.walletDashboard.model.WalletTransactionListDataItemDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/talabat/wallet/features/walletTransactionList/WalletTransactionListFormatterParam;", "", "walletTransactionListResponse", "Lcom/talabat/wallet/features/walletTransactionList/model/response/WalletTransactionListResponse;", "isFirstResponse", "", "lastDisplayModel", "Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListDataItemDisplayModel$TransactionDisplayModel;", "(Lcom/talabat/wallet/features/walletTransactionList/model/response/WalletTransactionListResponse;ZLcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListDataItemDisplayModel$TransactionDisplayModel;)V", "()Z", "getLastDisplayModel", "()Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListDataItemDisplayModel$TransactionDisplayModel;", "getWalletTransactionListResponse", "()Lcom/talabat/wallet/features/walletTransactionList/model/response/WalletTransactionListResponse;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionListFormatterParam {
    private final boolean isFirstResponse;
    @NotNull
    private final WalletTransactionListDataItemDisplayModel.TransactionDisplayModel lastDisplayModel;
    @Nullable
    private final WalletTransactionListResponse walletTransactionListResponse;

    public WalletTransactionListFormatterParam(@Nullable WalletTransactionListResponse walletTransactionListResponse2, boolean z11, @NotNull WalletTransactionListDataItemDisplayModel.TransactionDisplayModel transactionDisplayModel) {
        Intrinsics.checkNotNullParameter(transactionDisplayModel, "lastDisplayModel");
        this.walletTransactionListResponse = walletTransactionListResponse2;
        this.isFirstResponse = z11;
        this.lastDisplayModel = transactionDisplayModel;
    }

    public static /* synthetic */ WalletTransactionListFormatterParam copy$default(WalletTransactionListFormatterParam walletTransactionListFormatterParam, WalletTransactionListResponse walletTransactionListResponse2, boolean z11, WalletTransactionListDataItemDisplayModel.TransactionDisplayModel transactionDisplayModel, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            walletTransactionListResponse2 = walletTransactionListFormatterParam.walletTransactionListResponse;
        }
        if ((i11 & 2) != 0) {
            z11 = walletTransactionListFormatterParam.isFirstResponse;
        }
        if ((i11 & 4) != 0) {
            transactionDisplayModel = walletTransactionListFormatterParam.lastDisplayModel;
        }
        return walletTransactionListFormatterParam.copy(walletTransactionListResponse2, z11, transactionDisplayModel);
    }

    @Nullable
    public final WalletTransactionListResponse component1() {
        return this.walletTransactionListResponse;
    }

    public final boolean component2() {
        return this.isFirstResponse;
    }

    @NotNull
    public final WalletTransactionListDataItemDisplayModel.TransactionDisplayModel component3() {
        return this.lastDisplayModel;
    }

    @NotNull
    public final WalletTransactionListFormatterParam copy(@Nullable WalletTransactionListResponse walletTransactionListResponse2, boolean z11, @NotNull WalletTransactionListDataItemDisplayModel.TransactionDisplayModel transactionDisplayModel) {
        Intrinsics.checkNotNullParameter(transactionDisplayModel, "lastDisplayModel");
        return new WalletTransactionListFormatterParam(walletTransactionListResponse2, z11, transactionDisplayModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletTransactionListFormatterParam)) {
            return false;
        }
        WalletTransactionListFormatterParam walletTransactionListFormatterParam = (WalletTransactionListFormatterParam) obj;
        return Intrinsics.areEqual((Object) this.walletTransactionListResponse, (Object) walletTransactionListFormatterParam.walletTransactionListResponse) && this.isFirstResponse == walletTransactionListFormatterParam.isFirstResponse && Intrinsics.areEqual((Object) this.lastDisplayModel, (Object) walletTransactionListFormatterParam.lastDisplayModel);
    }

    @NotNull
    public final WalletTransactionListDataItemDisplayModel.TransactionDisplayModel getLastDisplayModel() {
        return this.lastDisplayModel;
    }

    @Nullable
    public final WalletTransactionListResponse getWalletTransactionListResponse() {
        return this.walletTransactionListResponse;
    }

    public int hashCode() {
        WalletTransactionListResponse walletTransactionListResponse2 = this.walletTransactionListResponse;
        int hashCode = (walletTransactionListResponse2 == null ? 0 : walletTransactionListResponse2.hashCode()) * 31;
        boolean z11 = this.isFirstResponse;
        if (z11) {
            z11 = true;
        }
        return ((hashCode + (z11 ? 1 : 0)) * 31) + this.lastDisplayModel.hashCode();
    }

    public final boolean isFirstResponse() {
        return this.isFirstResponse;
    }

    @NotNull
    public String toString() {
        WalletTransactionListResponse walletTransactionListResponse2 = this.walletTransactionListResponse;
        boolean z11 = this.isFirstResponse;
        WalletTransactionListDataItemDisplayModel.TransactionDisplayModel transactionDisplayModel = this.lastDisplayModel;
        return "WalletTransactionListFormatterParam(walletTransactionListResponse=" + walletTransactionListResponse2 + ", isFirstResponse=" + z11 + ", lastDisplayModel=" + transactionDisplayModel + ")";
    }
}
