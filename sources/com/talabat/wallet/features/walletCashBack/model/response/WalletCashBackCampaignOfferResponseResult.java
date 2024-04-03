package com.talabat.wallet.features.walletCashBack.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/talabat/wallet/features/walletCashBack/model/response/WalletCashBackCampaignOfferResponseResult;", "", "adTextMessage", "", "(Ljava/lang/String;)V", "getAdTextMessage", "()Ljava/lang/String;", "setAdTextMessage", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCashBackCampaignOfferResponseResult {
    @SerializedName("adText")
    @Nullable
    private String adTextMessage;

    public WalletCashBackCampaignOfferResponseResult() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public WalletCashBackCampaignOfferResponseResult(@Nullable String str) {
        this.adTextMessage = str;
    }

    public static /* synthetic */ WalletCashBackCampaignOfferResponseResult copy$default(WalletCashBackCampaignOfferResponseResult walletCashBackCampaignOfferResponseResult, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = walletCashBackCampaignOfferResponseResult.adTextMessage;
        }
        return walletCashBackCampaignOfferResponseResult.copy(str);
    }

    @Nullable
    public final String component1() {
        return this.adTextMessage;
    }

    @NotNull
    public final WalletCashBackCampaignOfferResponseResult copy(@Nullable String str) {
        return new WalletCashBackCampaignOfferResponseResult(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof WalletCashBackCampaignOfferResponseResult) && Intrinsics.areEqual((Object) this.adTextMessage, (Object) ((WalletCashBackCampaignOfferResponseResult) obj).adTextMessage);
    }

    @Nullable
    public final String getAdTextMessage() {
        return this.adTextMessage;
    }

    public int hashCode() {
        String str = this.adTextMessage;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final void setAdTextMessage(@Nullable String str) {
        this.adTextMessage = str;
    }

    @NotNull
    public String toString() {
        String str = this.adTextMessage;
        return "WalletCashBackCampaignOfferResponseResult(adTextMessage=" + str + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletCashBackCampaignOfferResponseResult(String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str);
    }
}
