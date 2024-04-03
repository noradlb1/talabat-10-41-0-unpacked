package com.talabat.wallet.features.walletCashBack.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/wallet/features/walletCashBack/model/response/WalletCalculateCashBackResponse;", "", "result", "Lcom/talabat/wallet/features/walletCashBack/model/response/WalletCalculateCashBackResponseResult;", "(Lcom/talabat/wallet/features/walletCashBack/model/response/WalletCalculateCashBackResponseResult;)V", "getResult", "()Lcom/talabat/wallet/features/walletCashBack/model/response/WalletCalculateCashBackResponseResult;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCalculateCashBackResponse {
    @SerializedName("result")
    @Nullable
    private final WalletCalculateCashBackResponseResult result;

    public WalletCalculateCashBackResponse() {
        this((WalletCalculateCashBackResponseResult) null, 1, (DefaultConstructorMarker) null);
    }

    public WalletCalculateCashBackResponse(@Nullable WalletCalculateCashBackResponseResult walletCalculateCashBackResponseResult) {
        this.result = walletCalculateCashBackResponseResult;
    }

    public static /* synthetic */ WalletCalculateCashBackResponse copy$default(WalletCalculateCashBackResponse walletCalculateCashBackResponse, WalletCalculateCashBackResponseResult walletCalculateCashBackResponseResult, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            walletCalculateCashBackResponseResult = walletCalculateCashBackResponse.result;
        }
        return walletCalculateCashBackResponse.copy(walletCalculateCashBackResponseResult);
    }

    @Nullable
    public final WalletCalculateCashBackResponseResult component1() {
        return this.result;
    }

    @NotNull
    public final WalletCalculateCashBackResponse copy(@Nullable WalletCalculateCashBackResponseResult walletCalculateCashBackResponseResult) {
        return new WalletCalculateCashBackResponse(walletCalculateCashBackResponseResult);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof WalletCalculateCashBackResponse) && Intrinsics.areEqual((Object) this.result, (Object) ((WalletCalculateCashBackResponse) obj).result);
    }

    @Nullable
    public final WalletCalculateCashBackResponseResult getResult() {
        return this.result;
    }

    public int hashCode() {
        WalletCalculateCashBackResponseResult walletCalculateCashBackResponseResult = this.result;
        if (walletCalculateCashBackResponseResult == null) {
            return 0;
        }
        return walletCalculateCashBackResponseResult.hashCode();
    }

    @NotNull
    public String toString() {
        WalletCalculateCashBackResponseResult walletCalculateCashBackResponseResult = this.result;
        return "WalletCalculateCashBackResponse(result=" + walletCalculateCashBackResponseResult + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletCalculateCashBackResponse(WalletCalculateCashBackResponseResult walletCalculateCashBackResponseResult, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : walletCalculateCashBackResponseResult);
    }
}
