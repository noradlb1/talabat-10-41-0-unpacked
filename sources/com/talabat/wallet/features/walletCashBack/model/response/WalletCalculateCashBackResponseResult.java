package com.talabat.wallet.features.walletCashBack.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ&\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0004\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/talabat/wallet/features/walletCashBack/model/response/WalletCalculateCashBackResponseResult;", "", "amount", "", "isCampaignActive", "", "(Ljava/lang/Float;Ljava/lang/Boolean;)V", "getAmount", "()Ljava/lang/Float;", "setAmount", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "()Ljava/lang/Boolean;", "setCampaignActive", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/lang/Float;Ljava/lang/Boolean;)Lcom/talabat/wallet/features/walletCashBack/model/response/WalletCalculateCashBackResponseResult;", "equals", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCalculateCashBackResponseResult {
    @SerializedName("amount")
    @Nullable
    private Float amount;
    @SerializedName("isCampaignActive")
    @Nullable
    private Boolean isCampaignActive;

    public WalletCalculateCashBackResponseResult(@Nullable Float f11, @Nullable Boolean bool) {
        this.amount = f11;
        this.isCampaignActive = bool;
    }

    public static /* synthetic */ WalletCalculateCashBackResponseResult copy$default(WalletCalculateCashBackResponseResult walletCalculateCashBackResponseResult, Float f11, Boolean bool, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = walletCalculateCashBackResponseResult.amount;
        }
        if ((i11 & 2) != 0) {
            bool = walletCalculateCashBackResponseResult.isCampaignActive;
        }
        return walletCalculateCashBackResponseResult.copy(f11, bool);
    }

    @Nullable
    public final Float component1() {
        return this.amount;
    }

    @Nullable
    public final Boolean component2() {
        return this.isCampaignActive;
    }

    @NotNull
    public final WalletCalculateCashBackResponseResult copy(@Nullable Float f11, @Nullable Boolean bool) {
        return new WalletCalculateCashBackResponseResult(f11, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletCalculateCashBackResponseResult)) {
            return false;
        }
        WalletCalculateCashBackResponseResult walletCalculateCashBackResponseResult = (WalletCalculateCashBackResponseResult) obj;
        return Intrinsics.areEqual((Object) this.amount, (Object) walletCalculateCashBackResponseResult.amount) && Intrinsics.areEqual((Object) this.isCampaignActive, (Object) walletCalculateCashBackResponseResult.isCampaignActive);
    }

    @Nullable
    public final Float getAmount() {
        return this.amount;
    }

    public int hashCode() {
        Float f11 = this.amount;
        int i11 = 0;
        int hashCode = (f11 == null ? 0 : f11.hashCode()) * 31;
        Boolean bool = this.isCampaignActive;
        if (bool != null) {
            i11 = bool.hashCode();
        }
        return hashCode + i11;
    }

    @Nullable
    public final Boolean isCampaignActive() {
        return this.isCampaignActive;
    }

    public final void setAmount(@Nullable Float f11) {
        this.amount = f11;
    }

    public final void setCampaignActive(@Nullable Boolean bool) {
        this.isCampaignActive = bool;
    }

    @NotNull
    public String toString() {
        Float f11 = this.amount;
        Boolean bool = this.isCampaignActive;
        return "WalletCalculateCashBackResponseResult(amount=" + f11 + ", isCampaignActive=" + bool + ")";
    }
}
