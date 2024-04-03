package com.talabat.wallet.features.walletCashBack;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/talabat/wallet/features/walletCashBack/CashBackCampaignOfferParams;", "", "cardBinNumber", "", "position", "", "(Ljava/lang/String;I)V", "getCardBinNumber", "()Ljava/lang/String;", "getPosition", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CashBackCampaignOfferParams {
    @NotNull
    private final String cardBinNumber;
    private final int position;

    public CashBackCampaignOfferParams(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "cardBinNumber");
        this.cardBinNumber = str;
        this.position = i11;
    }

    public static /* synthetic */ CashBackCampaignOfferParams copy$default(CashBackCampaignOfferParams cashBackCampaignOfferParams, String str, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = cashBackCampaignOfferParams.cardBinNumber;
        }
        if ((i12 & 2) != 0) {
            i11 = cashBackCampaignOfferParams.position;
        }
        return cashBackCampaignOfferParams.copy(str, i11);
    }

    @NotNull
    public final String component1() {
        return this.cardBinNumber;
    }

    public final int component2() {
        return this.position;
    }

    @NotNull
    public final CashBackCampaignOfferParams copy(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "cardBinNumber");
        return new CashBackCampaignOfferParams(str, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CashBackCampaignOfferParams)) {
            return false;
        }
        CashBackCampaignOfferParams cashBackCampaignOfferParams = (CashBackCampaignOfferParams) obj;
        return Intrinsics.areEqual((Object) this.cardBinNumber, (Object) cashBackCampaignOfferParams.cardBinNumber) && this.position == cashBackCampaignOfferParams.position;
    }

    @NotNull
    public final String getCardBinNumber() {
        return this.cardBinNumber;
    }

    public final int getPosition() {
        return this.position;
    }

    public int hashCode() {
        return (this.cardBinNumber.hashCode() * 31) + this.position;
    }

    @NotNull
    public String toString() {
        String str = this.cardBinNumber;
        int i11 = this.position;
        return "CashBackCampaignOfferParams(cardBinNumber=" + str + ", position=" + i11 + ")";
    }
}
