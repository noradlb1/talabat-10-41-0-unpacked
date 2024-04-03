package com.talabat.wallet.features.walletCashBack.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/wallet/features/walletCashBack/model/response/WalletCashBackCampaignResponse;", "", "result", "Lcom/talabat/wallet/features/walletCashBack/model/response/WalletCashBackCampaignResponseResult;", "(Lcom/talabat/wallet/features/walletCashBack/model/response/WalletCashBackCampaignResponseResult;)V", "getResult", "()Lcom/talabat/wallet/features/walletCashBack/model/response/WalletCashBackCampaignResponseResult;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCashBackCampaignResponse {
    @SerializedName("result")
    @Nullable
    private final WalletCashBackCampaignResponseResult result;

    public WalletCashBackCampaignResponse() {
        this((WalletCashBackCampaignResponseResult) null, 1, (DefaultConstructorMarker) null);
    }

    public WalletCashBackCampaignResponse(@Nullable WalletCashBackCampaignResponseResult walletCashBackCampaignResponseResult) {
        this.result = walletCashBackCampaignResponseResult;
    }

    public static /* synthetic */ WalletCashBackCampaignResponse copy$default(WalletCashBackCampaignResponse walletCashBackCampaignResponse, WalletCashBackCampaignResponseResult walletCashBackCampaignResponseResult, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            walletCashBackCampaignResponseResult = walletCashBackCampaignResponse.result;
        }
        return walletCashBackCampaignResponse.copy(walletCashBackCampaignResponseResult);
    }

    @Nullable
    public final WalletCashBackCampaignResponseResult component1() {
        return this.result;
    }

    @NotNull
    public final WalletCashBackCampaignResponse copy(@Nullable WalletCashBackCampaignResponseResult walletCashBackCampaignResponseResult) {
        return new WalletCashBackCampaignResponse(walletCashBackCampaignResponseResult);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof WalletCashBackCampaignResponse) && Intrinsics.areEqual((Object) this.result, (Object) ((WalletCashBackCampaignResponse) obj).result);
    }

    @Nullable
    public final WalletCashBackCampaignResponseResult getResult() {
        return this.result;
    }

    public int hashCode() {
        WalletCashBackCampaignResponseResult walletCashBackCampaignResponseResult = this.result;
        if (walletCashBackCampaignResponseResult == null) {
            return 0;
        }
        return walletCashBackCampaignResponseResult.hashCode();
    }

    @NotNull
    public String toString() {
        WalletCashBackCampaignResponseResult walletCashBackCampaignResponseResult = this.result;
        return "WalletCashBackCampaignResponse(result=" + walletCashBackCampaignResponseResult + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletCashBackCampaignResponse(WalletCashBackCampaignResponseResult walletCashBackCampaignResponseResult, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : walletCashBackCampaignResponseResult);
    }
}
