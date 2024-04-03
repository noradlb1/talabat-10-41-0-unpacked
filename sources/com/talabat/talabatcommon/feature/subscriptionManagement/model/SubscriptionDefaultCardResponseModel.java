package com.talabat.talabatcommon.feature.subscriptionManagement.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionDefaultCardResponseModel;", "", "cardTokenId", "", "card4Digits", "cardType", "cardExpiryDate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCard4Digits", "()Ljava/lang/String;", "setCard4Digits", "(Ljava/lang/String;)V", "getCardExpiryDate", "getCardTokenId", "getCardType", "setCardType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionDefaultCardResponseModel {
    @SerializedName("card4Digits")
    @Nullable
    private String card4Digits;
    @SerializedName("cardExpiryDate")
    @Nullable
    private final String cardExpiryDate;
    @SerializedName("cardTokenId")
    @Nullable
    private final String cardTokenId;
    @SerializedName("cardType")
    @Nullable
    private String cardType;

    public SubscriptionDefaultCardResponseModel(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.cardTokenId = str;
        this.card4Digits = str2;
        this.cardType = str3;
        this.cardExpiryDate = str4;
    }

    public static /* synthetic */ SubscriptionDefaultCardResponseModel copy$default(SubscriptionDefaultCardResponseModel subscriptionDefaultCardResponseModel, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = subscriptionDefaultCardResponseModel.cardTokenId;
        }
        if ((i11 & 2) != 0) {
            str2 = subscriptionDefaultCardResponseModel.card4Digits;
        }
        if ((i11 & 4) != 0) {
            str3 = subscriptionDefaultCardResponseModel.cardType;
        }
        if ((i11 & 8) != 0) {
            str4 = subscriptionDefaultCardResponseModel.cardExpiryDate;
        }
        return subscriptionDefaultCardResponseModel.copy(str, str2, str3, str4);
    }

    @Nullable
    public final String component1() {
        return this.cardTokenId;
    }

    @Nullable
    public final String component2() {
        return this.card4Digits;
    }

    @Nullable
    public final String component3() {
        return this.cardType;
    }

    @Nullable
    public final String component4() {
        return this.cardExpiryDate;
    }

    @NotNull
    public final SubscriptionDefaultCardResponseModel copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        return new SubscriptionDefaultCardResponseModel(str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionDefaultCardResponseModel)) {
            return false;
        }
        SubscriptionDefaultCardResponseModel subscriptionDefaultCardResponseModel = (SubscriptionDefaultCardResponseModel) obj;
        return Intrinsics.areEqual((Object) this.cardTokenId, (Object) subscriptionDefaultCardResponseModel.cardTokenId) && Intrinsics.areEqual((Object) this.card4Digits, (Object) subscriptionDefaultCardResponseModel.card4Digits) && Intrinsics.areEqual((Object) this.cardType, (Object) subscriptionDefaultCardResponseModel.cardType) && Intrinsics.areEqual((Object) this.cardExpiryDate, (Object) subscriptionDefaultCardResponseModel.cardExpiryDate);
    }

    @Nullable
    public final String getCard4Digits() {
        return this.card4Digits;
    }

    @Nullable
    public final String getCardExpiryDate() {
        return this.cardExpiryDate;
    }

    @Nullable
    public final String getCardTokenId() {
        return this.cardTokenId;
    }

    @Nullable
    public final String getCardType() {
        return this.cardType;
    }

    public int hashCode() {
        String str = this.cardTokenId;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.card4Digits;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.cardType;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.cardExpiryDate;
        if (str4 != null) {
            i11 = str4.hashCode();
        }
        return hashCode3 + i11;
    }

    public final void setCard4Digits(@Nullable String str) {
        this.card4Digits = str;
    }

    public final void setCardType(@Nullable String str) {
        this.cardType = str;
    }

    @NotNull
    public String toString() {
        String str = this.cardTokenId;
        String str2 = this.card4Digits;
        String str3 = this.cardType;
        String str4 = this.cardExpiryDate;
        return "SubscriptionDefaultCardResponseModel(cardTokenId=" + str + ", card4Digits=" + str2 + ", cardType=" + str3 + ", cardExpiryDate=" + str4 + ")";
    }
}
