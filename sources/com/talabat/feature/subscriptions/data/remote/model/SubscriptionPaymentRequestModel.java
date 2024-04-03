package com.talabat.feature.subscriptions.data.remote.model;

import com.squareup.moshi.Json;
import com.talabat.feature.bnplcheckout.presentation.BNPLCheckoutFlutterFragment;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0007\u001a\u00020\b\u0012\b\b\u0003\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\bHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionPaymentRequestModel;", "", "planId", "", "cardTokenId", "card4Digits", "cardType", "paymentMethod", "", "cardExpiryDate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getCard4Digits", "()Ljava/lang/String;", "getCardExpiryDate", "getCardTokenId", "getCardType", "getPaymentMethod", "()I", "getPlanId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionPaymentRequestModel {
    @NotNull
    private final String card4Digits;
    @NotNull
    private final String cardExpiryDate;
    @NotNull
    private final String cardTokenId;
    @NotNull
    private final String cardType;
    private final int paymentMethod;
    @NotNull
    private final String planId;

    public SubscriptionPaymentRequestModel() {
        this((String) null, (String) null, (String) null, (String) null, 0, (String) null, 63, (DefaultConstructorMarker) null);
    }

    public SubscriptionPaymentRequestModel(@NotNull @Json(name = "planId") String str, @NotNull @Json(name = "cardTokenId") String str2, @NotNull @Json(name = "card4Digits") String str3, @NotNull @Json(name = "cardType") String str4, @Json(name = "paymentMethod") int i11, @NotNull @Json(name = "cardExpiryDate") String str5) {
        Intrinsics.checkNotNullParameter(str, BNPLCheckoutFlutterFragment.PLAN_ID_EXTRA);
        Intrinsics.checkNotNullParameter(str2, "cardTokenId");
        Intrinsics.checkNotNullParameter(str3, WalletNavigatorActions.EXTRA_CARD_4_DIGITS);
        Intrinsics.checkNotNullParameter(str4, "cardType");
        Intrinsics.checkNotNullParameter(str5, "cardExpiryDate");
        this.planId = str;
        this.cardTokenId = str2;
        this.card4Digits = str3;
        this.cardType = str4;
        this.paymentMethod = i11;
        this.cardExpiryDate = str5;
    }

    public static /* synthetic */ SubscriptionPaymentRequestModel copy$default(SubscriptionPaymentRequestModel subscriptionPaymentRequestModel, String str, String str2, String str3, String str4, int i11, String str5, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = subscriptionPaymentRequestModel.planId;
        }
        if ((i12 & 2) != 0) {
            str2 = subscriptionPaymentRequestModel.cardTokenId;
        }
        String str6 = str2;
        if ((i12 & 4) != 0) {
            str3 = subscriptionPaymentRequestModel.card4Digits;
        }
        String str7 = str3;
        if ((i12 & 8) != 0) {
            str4 = subscriptionPaymentRequestModel.cardType;
        }
        String str8 = str4;
        if ((i12 & 16) != 0) {
            i11 = subscriptionPaymentRequestModel.paymentMethod;
        }
        int i13 = i11;
        if ((i12 & 32) != 0) {
            str5 = subscriptionPaymentRequestModel.cardExpiryDate;
        }
        return subscriptionPaymentRequestModel.copy(str, str6, str7, str8, i13, str5);
    }

    @NotNull
    public final String component1() {
        return this.planId;
    }

    @NotNull
    public final String component2() {
        return this.cardTokenId;
    }

    @NotNull
    public final String component3() {
        return this.card4Digits;
    }

    @NotNull
    public final String component4() {
        return this.cardType;
    }

    public final int component5() {
        return this.paymentMethod;
    }

    @NotNull
    public final String component6() {
        return this.cardExpiryDate;
    }

    @NotNull
    public final SubscriptionPaymentRequestModel copy(@NotNull @Json(name = "planId") String str, @NotNull @Json(name = "cardTokenId") String str2, @NotNull @Json(name = "card4Digits") String str3, @NotNull @Json(name = "cardType") String str4, @Json(name = "paymentMethod") int i11, @NotNull @Json(name = "cardExpiryDate") String str5) {
        Intrinsics.checkNotNullParameter(str, BNPLCheckoutFlutterFragment.PLAN_ID_EXTRA);
        Intrinsics.checkNotNullParameter(str2, "cardTokenId");
        Intrinsics.checkNotNullParameter(str3, WalletNavigatorActions.EXTRA_CARD_4_DIGITS);
        Intrinsics.checkNotNullParameter(str4, "cardType");
        Intrinsics.checkNotNullParameter(str5, "cardExpiryDate");
        return new SubscriptionPaymentRequestModel(str, str2, str3, str4, i11, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionPaymentRequestModel)) {
            return false;
        }
        SubscriptionPaymentRequestModel subscriptionPaymentRequestModel = (SubscriptionPaymentRequestModel) obj;
        return Intrinsics.areEqual((Object) this.planId, (Object) subscriptionPaymentRequestModel.planId) && Intrinsics.areEqual((Object) this.cardTokenId, (Object) subscriptionPaymentRequestModel.cardTokenId) && Intrinsics.areEqual((Object) this.card4Digits, (Object) subscriptionPaymentRequestModel.card4Digits) && Intrinsics.areEqual((Object) this.cardType, (Object) subscriptionPaymentRequestModel.cardType) && this.paymentMethod == subscriptionPaymentRequestModel.paymentMethod && Intrinsics.areEqual((Object) this.cardExpiryDate, (Object) subscriptionPaymentRequestModel.cardExpiryDate);
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

    public final int getPaymentMethod() {
        return this.paymentMethod;
    }

    @NotNull
    public final String getPlanId() {
        return this.planId;
    }

    public int hashCode() {
        return (((((((((this.planId.hashCode() * 31) + this.cardTokenId.hashCode()) * 31) + this.card4Digits.hashCode()) * 31) + this.cardType.hashCode()) * 31) + this.paymentMethod) * 31) + this.cardExpiryDate.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.planId;
        String str2 = this.cardTokenId;
        String str3 = this.card4Digits;
        String str4 = this.cardType;
        int i11 = this.paymentMethod;
        String str5 = this.cardExpiryDate;
        return "SubscriptionPaymentRequestModel(planId=" + str + ", cardTokenId=" + str2 + ", card4Digits=" + str3 + ", cardType=" + str4 + ", paymentMethod=" + i11 + ", cardExpiryDate=" + str5 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SubscriptionPaymentRequestModel(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, int r10, java.lang.String r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            java.lang.String r0 = ""
            if (r13 == 0) goto L_0x0008
            r13 = r0
            goto L_0x0009
        L_0x0008:
            r13 = r6
        L_0x0009:
            r6 = r12 & 2
            if (r6 == 0) goto L_0x000f
            r1 = r0
            goto L_0x0010
        L_0x000f:
            r1 = r7
        L_0x0010:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0016
            r2 = r0
            goto L_0x0017
        L_0x0016:
            r2 = r8
        L_0x0017:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001d
            r3 = r0
            goto L_0x001e
        L_0x001d:
            r3 = r9
        L_0x001e:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0023
            r10 = 0
        L_0x0023:
            r4 = r10
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002a
            r12 = r0
            goto L_0x002b
        L_0x002a:
            r12 = r11
        L_0x002b:
            r6 = r5
            r7 = r13
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentRequestModel.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
