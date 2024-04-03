package com.talabat.wallet.features.walletTransactionList.model.response;

import com.talabat.talabatcommon.model.wallet.WalletErrorMessageModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/talabat/wallet/features/walletTransactionList/model/response/WalletTransactionListResponse;", "", "result", "Lcom/talabat/wallet/features/walletTransactionList/model/response/WalletTransactionListResult;", "responseMessages", "", "Lcom/talabat/talabatcommon/model/wallet/WalletErrorMessageModel;", "(Lcom/talabat/wallet/features/walletTransactionList/model/response/WalletTransactionListResult;Ljava/util/List;)V", "getResponseMessages", "()Ljava/util/List;", "setResponseMessages", "(Ljava/util/List;)V", "getResult", "()Lcom/talabat/wallet/features/walletTransactionList/model/response/WalletTransactionListResult;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionListResponse {
    @Nullable
    private List<WalletErrorMessageModel> responseMessages;
    @Nullable
    private final WalletTransactionListResult result;

    public WalletTransactionListResponse() {
        this((WalletTransactionListResult) null, (List) null, 3, (DefaultConstructorMarker) null);
    }

    public WalletTransactionListResponse(@Nullable WalletTransactionListResult walletTransactionListResult, @Nullable List<WalletErrorMessageModel> list) {
        this.result = walletTransactionListResult;
        this.responseMessages = list;
    }

    public static /* synthetic */ WalletTransactionListResponse copy$default(WalletTransactionListResponse walletTransactionListResponse, WalletTransactionListResult walletTransactionListResult, List<WalletErrorMessageModel> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            walletTransactionListResult = walletTransactionListResponse.result;
        }
        if ((i11 & 2) != 0) {
            list = walletTransactionListResponse.responseMessages;
        }
        return walletTransactionListResponse.copy(walletTransactionListResult, list);
    }

    @Nullable
    public final WalletTransactionListResult component1() {
        return this.result;
    }

    @Nullable
    public final List<WalletErrorMessageModel> component2() {
        return this.responseMessages;
    }

    @NotNull
    public final WalletTransactionListResponse copy(@Nullable WalletTransactionListResult walletTransactionListResult, @Nullable List<WalletErrorMessageModel> list) {
        return new WalletTransactionListResponse(walletTransactionListResult, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletTransactionListResponse)) {
            return false;
        }
        WalletTransactionListResponse walletTransactionListResponse = (WalletTransactionListResponse) obj;
        return Intrinsics.areEqual((Object) this.result, (Object) walletTransactionListResponse.result) && Intrinsics.areEqual((Object) this.responseMessages, (Object) walletTransactionListResponse.responseMessages);
    }

    @Nullable
    public final List<WalletErrorMessageModel> getResponseMessages() {
        return this.responseMessages;
    }

    @Nullable
    public final WalletTransactionListResult getResult() {
        return this.result;
    }

    public int hashCode() {
        WalletTransactionListResult walletTransactionListResult = this.result;
        int i11 = 0;
        int hashCode = (walletTransactionListResult == null ? 0 : walletTransactionListResult.hashCode()) * 31;
        List<WalletErrorMessageModel> list = this.responseMessages;
        if (list != null) {
            i11 = list.hashCode();
        }
        return hashCode + i11;
    }

    public final void setResponseMessages(@Nullable List<WalletErrorMessageModel> list) {
        this.responseMessages = list;
    }

    @NotNull
    public String toString() {
        WalletTransactionListResult walletTransactionListResult = this.result;
        List<WalletErrorMessageModel> list = this.responseMessages;
        return "WalletTransactionListResponse(result=" + walletTransactionListResult + ", responseMessages=" + list + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletTransactionListResponse(WalletTransactionListResult walletTransactionListResult, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : walletTransactionListResult, (i11 & 2) != 0 ? null : list);
    }
}
