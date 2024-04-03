package com.talabat.feature.walletcobrandedcc.data.remote;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/walletcobrandedcc/data/remote/WalletCobrandedCcNotificationResponse;", "", "walletCoBrandedResult", "Lcom/talabat/feature/walletcobrandedcc/data/remote/WalletCobrandedCcNotificationResponseResult;", "(Lcom/talabat/feature/walletcobrandedcc/data/remote/WalletCobrandedCcNotificationResponseResult;)V", "getWalletCoBrandedResult", "()Lcom/talabat/feature/walletcobrandedcc/data/remote/WalletCobrandedCcNotificationResponseResult;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_feature_wallet-cobranded-cc_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCobrandedCcNotificationResponse {
    @SerializedName("result")
    @Nullable
    private final WalletCobrandedCcNotificationResponseResult walletCoBrandedResult;

    public WalletCobrandedCcNotificationResponse(@Nullable WalletCobrandedCcNotificationResponseResult walletCobrandedCcNotificationResponseResult) {
        this.walletCoBrandedResult = walletCobrandedCcNotificationResponseResult;
    }

    public static /* synthetic */ WalletCobrandedCcNotificationResponse copy$default(WalletCobrandedCcNotificationResponse walletCobrandedCcNotificationResponse, WalletCobrandedCcNotificationResponseResult walletCobrandedCcNotificationResponseResult, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            walletCobrandedCcNotificationResponseResult = walletCobrandedCcNotificationResponse.walletCoBrandedResult;
        }
        return walletCobrandedCcNotificationResponse.copy(walletCobrandedCcNotificationResponseResult);
    }

    @Nullable
    public final WalletCobrandedCcNotificationResponseResult component1() {
        return this.walletCoBrandedResult;
    }

    @NotNull
    public final WalletCobrandedCcNotificationResponse copy(@Nullable WalletCobrandedCcNotificationResponseResult walletCobrandedCcNotificationResponseResult) {
        return new WalletCobrandedCcNotificationResponse(walletCobrandedCcNotificationResponseResult);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof WalletCobrandedCcNotificationResponse) && Intrinsics.areEqual((Object) this.walletCoBrandedResult, (Object) ((WalletCobrandedCcNotificationResponse) obj).walletCoBrandedResult);
    }

    @Nullable
    public final WalletCobrandedCcNotificationResponseResult getWalletCoBrandedResult() {
        return this.walletCoBrandedResult;
    }

    public int hashCode() {
        WalletCobrandedCcNotificationResponseResult walletCobrandedCcNotificationResponseResult = this.walletCoBrandedResult;
        if (walletCobrandedCcNotificationResponseResult == null) {
            return 0;
        }
        return walletCobrandedCcNotificationResponseResult.hashCode();
    }

    @NotNull
    public String toString() {
        WalletCobrandedCcNotificationResponseResult walletCobrandedCcNotificationResponseResult = this.walletCoBrandedResult;
        return "WalletCobrandedCcNotificationResponse(walletCoBrandedResult=" + walletCobrandedCcNotificationResponseResult + ")";
    }
}
