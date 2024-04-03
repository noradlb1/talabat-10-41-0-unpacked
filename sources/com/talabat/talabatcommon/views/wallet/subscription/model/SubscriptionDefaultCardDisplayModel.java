package com.talabat.talabatcommon.views.wallet.subscription.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.talabat.mapper.ModelMapping;
import com.talabat.talabatcommon.extentions.StringUtils;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0018HÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006$"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionDefaultCardDisplayModel;", "Landroid/os/Parcelable;", "cardTokenId", "", "card4Digits", "cardType", "cardExpiryDate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCard4Digits", "()Ljava/lang/String;", "setCard4Digits", "(Ljava/lang/String;)V", "getCardExpiryDate", "setCardExpiryDate", "getCardTokenId", "setCardTokenId", "getCardType", "setCardType", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class SubscriptionDefaultCardDisplayModel implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<SubscriptionDefaultCardDisplayModel> CREATOR = new Creator();
    @NotNull
    @ModelMapping({"card4Digits"})
    private String card4Digits;
    @NotNull
    @ModelMapping({"cardExpiryDate"})
    private String cardExpiryDate;
    @NotNull
    @ModelMapping({"cardTokenId"})
    private String cardTokenId;
    @NotNull
    @ModelMapping({"cardType"})
    private String cardType;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SubscriptionDefaultCardDisplayModel> {
        @NotNull
        public final SubscriptionDefaultCardDisplayModel createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SubscriptionDefaultCardDisplayModel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @NotNull
        public final SubscriptionDefaultCardDisplayModel[] newArray(int i11) {
            return new SubscriptionDefaultCardDisplayModel[i11];
        }
    }

    public SubscriptionDefaultCardDisplayModel() {
        this((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public SubscriptionDefaultCardDisplayModel(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "cardTokenId");
        Intrinsics.checkNotNullParameter(str2, WalletNavigatorActions.EXTRA_CARD_4_DIGITS);
        Intrinsics.checkNotNullParameter(str3, "cardType");
        Intrinsics.checkNotNullParameter(str4, "cardExpiryDate");
        this.cardTokenId = str;
        this.card4Digits = str2;
        this.cardType = str3;
        this.cardExpiryDate = str4;
    }

    public static /* synthetic */ SubscriptionDefaultCardDisplayModel copy$default(SubscriptionDefaultCardDisplayModel subscriptionDefaultCardDisplayModel, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = subscriptionDefaultCardDisplayModel.cardTokenId;
        }
        if ((i11 & 2) != 0) {
            str2 = subscriptionDefaultCardDisplayModel.card4Digits;
        }
        if ((i11 & 4) != 0) {
            str3 = subscriptionDefaultCardDisplayModel.cardType;
        }
        if ((i11 & 8) != 0) {
            str4 = subscriptionDefaultCardDisplayModel.cardExpiryDate;
        }
        return subscriptionDefaultCardDisplayModel.copy(str, str2, str3, str4);
    }

    @NotNull
    public final String component1() {
        return this.cardTokenId;
    }

    @NotNull
    public final String component2() {
        return this.card4Digits;
    }

    @NotNull
    public final String component3() {
        return this.cardType;
    }

    @NotNull
    public final String component4() {
        return this.cardExpiryDate;
    }

    @NotNull
    public final SubscriptionDefaultCardDisplayModel copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "cardTokenId");
        Intrinsics.checkNotNullParameter(str2, WalletNavigatorActions.EXTRA_CARD_4_DIGITS);
        Intrinsics.checkNotNullParameter(str3, "cardType");
        Intrinsics.checkNotNullParameter(str4, "cardExpiryDate");
        return new SubscriptionDefaultCardDisplayModel(str, str2, str3, str4);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionDefaultCardDisplayModel)) {
            return false;
        }
        SubscriptionDefaultCardDisplayModel subscriptionDefaultCardDisplayModel = (SubscriptionDefaultCardDisplayModel) obj;
        return Intrinsics.areEqual((Object) this.cardTokenId, (Object) subscriptionDefaultCardDisplayModel.cardTokenId) && Intrinsics.areEqual((Object) this.card4Digits, (Object) subscriptionDefaultCardDisplayModel.card4Digits) && Intrinsics.areEqual((Object) this.cardType, (Object) subscriptionDefaultCardDisplayModel.cardType) && Intrinsics.areEqual((Object) this.cardExpiryDate, (Object) subscriptionDefaultCardDisplayModel.cardExpiryDate);
    }

    @NotNull
    public final String getCard4Digits() {
        return this.card4Digits;
    }

    @NotNull
    public final String getCardExpiryDate() {
        return this.cardExpiryDate;
    }

    @NotNull
    public final String getCardTokenId() {
        return this.cardTokenId;
    }

    @NotNull
    public final String getCardType() {
        return this.cardType;
    }

    public int hashCode() {
        return (((((this.cardTokenId.hashCode() * 31) + this.card4Digits.hashCode()) * 31) + this.cardType.hashCode()) * 31) + this.cardExpiryDate.hashCode();
    }

    public final void setCard4Digits(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.card4Digits = str;
    }

    public final void setCardExpiryDate(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cardExpiryDate = str;
    }

    public final void setCardTokenId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cardTokenId = str;
    }

    public final void setCardType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cardType = str;
    }

    @NotNull
    public String toString() {
        String str = this.cardTokenId;
        String str2 = this.card4Digits;
        String str3 = this.cardType;
        String str4 = this.cardExpiryDate;
        return "SubscriptionDefaultCardDisplayModel(cardTokenId=" + str + ", card4Digits=" + str2 + ", cardType=" + str3 + ", cardExpiryDate=" + str4 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.cardTokenId);
        parcel.writeString(this.card4Digits);
        parcel.writeString(this.cardType);
        parcel.writeString(this.cardExpiryDate);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubscriptionDefaultCardDisplayModel(String str, String str2, String str3, String str4, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? StringUtils.empty(StringCompanionObject.INSTANCE) : str, (i11 & 2) != 0 ? StringUtils.empty(StringCompanionObject.INSTANCE) : str2, (i11 & 4) != 0 ? StringUtils.empty(StringCompanionObject.INSTANCE) : str3, (i11 & 8) != 0 ? StringUtils.empty(StringCompanionObject.INSTANCE) : str4);
    }
}
