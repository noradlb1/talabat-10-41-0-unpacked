package com.talabat.feature.bnplcheckout.presentation;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\""}, d2 = {"Lcom/talabat/feature/bnplcheckout/presentation/CardInfo;", "Landroid/os/Parcelable;", "cardTokenId", "", "expiryDate", "cardNetwork", "binNumber", "last4Digits", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBinNumber", "()Ljava/lang/String;", "getCardNetwork", "getCardTokenId", "getExpiryDate", "getLast4Digits", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_feature_bnpl-checkout_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class CardInfo implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<CardInfo> CREATOR = new Creator();
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

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CardInfo> {
        @NotNull
        public final CardInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CardInfo(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @NotNull
        public final CardInfo[] newArray(int i11) {
            return new CardInfo[i11];
        }
    }

    public CardInfo(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "cardTokenId");
        Intrinsics.checkNotNullParameter(str2, "expiryDate");
        Intrinsics.checkNotNullParameter(str3, "cardNetwork");
        Intrinsics.checkNotNullParameter(str4, "binNumber");
        Intrinsics.checkNotNullParameter(str5, "last4Digits");
        this.cardTokenId = str;
        this.expiryDate = str2;
        this.cardNetwork = str3;
        this.binNumber = str4;
        this.last4Digits = str5;
    }

    public static /* synthetic */ CardInfo copy$default(CardInfo cardInfo, String str, String str2, String str3, String str4, String str5, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = cardInfo.cardTokenId;
        }
        if ((i11 & 2) != 0) {
            str2 = cardInfo.expiryDate;
        }
        String str6 = str2;
        if ((i11 & 4) != 0) {
            str3 = cardInfo.cardNetwork;
        }
        String str7 = str3;
        if ((i11 & 8) != 0) {
            str4 = cardInfo.binNumber;
        }
        String str8 = str4;
        if ((i11 & 16) != 0) {
            str5 = cardInfo.last4Digits;
        }
        return cardInfo.copy(str, str6, str7, str8, str5);
    }

    @NotNull
    public final String component1() {
        return this.cardTokenId;
    }

    @NotNull
    public final String component2() {
        return this.expiryDate;
    }

    @NotNull
    public final String component3() {
        return this.cardNetwork;
    }

    @NotNull
    public final String component4() {
        return this.binNumber;
    }

    @NotNull
    public final String component5() {
        return this.last4Digits;
    }

    @NotNull
    public final CardInfo copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "cardTokenId");
        Intrinsics.checkNotNullParameter(str2, "expiryDate");
        Intrinsics.checkNotNullParameter(str3, "cardNetwork");
        Intrinsics.checkNotNullParameter(str4, "binNumber");
        Intrinsics.checkNotNullParameter(str5, "last4Digits");
        return new CardInfo(str, str2, str3, str4, str5);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CardInfo)) {
            return false;
        }
        CardInfo cardInfo = (CardInfo) obj;
        return Intrinsics.areEqual((Object) this.cardTokenId, (Object) cardInfo.cardTokenId) && Intrinsics.areEqual((Object) this.expiryDate, (Object) cardInfo.expiryDate) && Intrinsics.areEqual((Object) this.cardNetwork, (Object) cardInfo.cardNetwork) && Intrinsics.areEqual((Object) this.binNumber, (Object) cardInfo.binNumber) && Intrinsics.areEqual((Object) this.last4Digits, (Object) cardInfo.last4Digits);
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
        return (((((((this.cardTokenId.hashCode() * 31) + this.expiryDate.hashCode()) * 31) + this.cardNetwork.hashCode()) * 31) + this.binNumber.hashCode()) * 31) + this.last4Digits.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.cardTokenId;
        String str2 = this.expiryDate;
        String str3 = this.cardNetwork;
        String str4 = this.binNumber;
        String str5 = this.last4Digits;
        return "CardInfo(cardTokenId=" + str + ", expiryDate=" + str2 + ", cardNetwork=" + str3 + ", binNumber=" + str4 + ", last4Digits=" + str5 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.cardTokenId);
        parcel.writeString(this.expiryDate);
        parcel.writeString(this.cardNetwork);
        parcel.writeString(this.binNumber);
        parcel.writeString(this.last4Digits);
    }
}
