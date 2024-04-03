package com.talabat.talabatcommon.feature.subscriptionManagement.model;

import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionDefaultCardRequestModel;", "", "cardTokenId", "", "card4Digits", "cardType", "cardExpiryDate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCard4Digits", "()Ljava/lang/String;", "getCardExpiryDate", "getCardTokenId", "getCardType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionDefaultCardRequestModel {
    @NotNull
    private final String card4Digits;
    @NotNull
    private final String cardExpiryDate;
    @NotNull
    private final String cardTokenId;
    @NotNull
    private final String cardType;

    public SubscriptionDefaultCardRequestModel(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "cardTokenId");
        Intrinsics.checkNotNullParameter(str2, WalletNavigatorActions.EXTRA_CARD_4_DIGITS);
        Intrinsics.checkNotNullParameter(str3, "cardType");
        Intrinsics.checkNotNullParameter(str4, "cardExpiryDate");
        this.cardTokenId = str;
        this.card4Digits = str2;
        this.cardType = str3;
        this.cardExpiryDate = str4;
    }

    public static /* synthetic */ SubscriptionDefaultCardRequestModel copy$default(SubscriptionDefaultCardRequestModel subscriptionDefaultCardRequestModel, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = subscriptionDefaultCardRequestModel.cardTokenId;
        }
        if ((i11 & 2) != 0) {
            str2 = subscriptionDefaultCardRequestModel.card4Digits;
        }
        if ((i11 & 4) != 0) {
            str3 = subscriptionDefaultCardRequestModel.cardType;
        }
        if ((i11 & 8) != 0) {
            str4 = subscriptionDefaultCardRequestModel.cardExpiryDate;
        }
        return subscriptionDefaultCardRequestModel.copy(str, str2, str3, str4);
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
    public final SubscriptionDefaultCardRequestModel copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "cardTokenId");
        Intrinsics.checkNotNullParameter(str2, WalletNavigatorActions.EXTRA_CARD_4_DIGITS);
        Intrinsics.checkNotNullParameter(str3, "cardType");
        Intrinsics.checkNotNullParameter(str4, "cardExpiryDate");
        return new SubscriptionDefaultCardRequestModel(str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionDefaultCardRequestModel)) {
            return false;
        }
        SubscriptionDefaultCardRequestModel subscriptionDefaultCardRequestModel = (SubscriptionDefaultCardRequestModel) obj;
        return Intrinsics.areEqual((Object) this.cardTokenId, (Object) subscriptionDefaultCardRequestModel.cardTokenId) && Intrinsics.areEqual((Object) this.card4Digits, (Object) subscriptionDefaultCardRequestModel.card4Digits) && Intrinsics.areEqual((Object) this.cardType, (Object) subscriptionDefaultCardRequestModel.cardType) && Intrinsics.areEqual((Object) this.cardExpiryDate, (Object) subscriptionDefaultCardRequestModel.cardExpiryDate);
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

    @NotNull
    public String toString() {
        String str = this.cardTokenId;
        String str2 = this.card4Digits;
        String str3 = this.cardType;
        String str4 = this.cardExpiryDate;
        return "SubscriptionDefaultCardRequestModel(cardTokenId=" + str + ", card4Digits=" + str2 + ", cardType=" + str3 + ", cardExpiryDate=" + str4 + ")";
    }
}
