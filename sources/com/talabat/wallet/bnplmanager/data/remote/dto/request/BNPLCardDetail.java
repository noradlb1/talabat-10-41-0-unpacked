package com.talabat.wallet.bnplmanager.data.remote.dto.request;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/talabat/wallet/bnplmanager/data/remote/dto/request/BNPLCardDetail;", "", "cardTokenId", "", "last4Digits", "expiryDate", "cardNetwork", "binNumber", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBinNumber", "()Ljava/lang/String;", "getCardNetwork", "getCardTokenId", "getExpiryDate", "getLast4Digits", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BNPLCardDetail {
    @NotNull
    private final String binNumber;
    @NotNull
    private final String cardNetwork;
    @NotNull
    private final String cardTokenId;
    @NotNull
    private final String expiryDate;
    @NotNull
    private final String last4Digits;

    public BNPLCardDetail(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "cardTokenId");
        Intrinsics.checkNotNullParameter(str2, "last4Digits");
        Intrinsics.checkNotNullParameter(str3, "expiryDate");
        Intrinsics.checkNotNullParameter(str4, "cardNetwork");
        Intrinsics.checkNotNullParameter(str5, "binNumber");
        this.cardTokenId = str;
        this.last4Digits = str2;
        this.expiryDate = str3;
        this.cardNetwork = str4;
        this.binNumber = str5;
    }

    public static /* synthetic */ BNPLCardDetail copy$default(BNPLCardDetail bNPLCardDetail, String str, String str2, String str3, String str4, String str5, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = bNPLCardDetail.cardTokenId;
        }
        if ((i11 & 2) != 0) {
            str2 = bNPLCardDetail.last4Digits;
        }
        String str6 = str2;
        if ((i11 & 4) != 0) {
            str3 = bNPLCardDetail.expiryDate;
        }
        String str7 = str3;
        if ((i11 & 8) != 0) {
            str4 = bNPLCardDetail.cardNetwork;
        }
        String str8 = str4;
        if ((i11 & 16) != 0) {
            str5 = bNPLCardDetail.binNumber;
        }
        return bNPLCardDetail.copy(str, str6, str7, str8, str5);
    }

    @NotNull
    public final String component1() {
        return this.cardTokenId;
    }

    @NotNull
    public final String component2() {
        return this.last4Digits;
    }

    @NotNull
    public final String component3() {
        return this.expiryDate;
    }

    @NotNull
    public final String component4() {
        return this.cardNetwork;
    }

    @NotNull
    public final String component5() {
        return this.binNumber;
    }

    @NotNull
    public final BNPLCardDetail copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "cardTokenId");
        Intrinsics.checkNotNullParameter(str2, "last4Digits");
        Intrinsics.checkNotNullParameter(str3, "expiryDate");
        Intrinsics.checkNotNullParameter(str4, "cardNetwork");
        Intrinsics.checkNotNullParameter(str5, "binNumber");
        return new BNPLCardDetail(str, str2, str3, str4, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BNPLCardDetail)) {
            return false;
        }
        BNPLCardDetail bNPLCardDetail = (BNPLCardDetail) obj;
        return Intrinsics.areEqual((Object) this.cardTokenId, (Object) bNPLCardDetail.cardTokenId) && Intrinsics.areEqual((Object) this.last4Digits, (Object) bNPLCardDetail.last4Digits) && Intrinsics.areEqual((Object) this.expiryDate, (Object) bNPLCardDetail.expiryDate) && Intrinsics.areEqual((Object) this.cardNetwork, (Object) bNPLCardDetail.cardNetwork) && Intrinsics.areEqual((Object) this.binNumber, (Object) bNPLCardDetail.binNumber);
    }

    @NotNull
    public final String getBinNumber() {
        return this.binNumber;
    }

    @NotNull
    public final String getCardNetwork() {
        return this.cardNetwork;
    }

    @NotNull
    public final String getCardTokenId() {
        return this.cardTokenId;
    }

    @NotNull
    public final String getExpiryDate() {
        return this.expiryDate;
    }

    @NotNull
    public final String getLast4Digits() {
        return this.last4Digits;
    }

    public int hashCode() {
        return (((((((this.cardTokenId.hashCode() * 31) + this.last4Digits.hashCode()) * 31) + this.expiryDate.hashCode()) * 31) + this.cardNetwork.hashCode()) * 31) + this.binNumber.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.cardTokenId;
        String str2 = this.last4Digits;
        String str3 = this.expiryDate;
        String str4 = this.cardNetwork;
        String str5 = this.binNumber;
        return "BNPLCardDetail(cardTokenId=" + str + ", last4Digits=" + str2 + ", expiryDate=" + str3 + ", cardNetwork=" + str4 + ", binNumber=" + str5 + ")";
    }
}
