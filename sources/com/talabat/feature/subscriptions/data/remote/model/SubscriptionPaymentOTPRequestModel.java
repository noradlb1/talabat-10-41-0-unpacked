package com.talabat.feature.subscriptions.data.remote.model;

import com.squareup.moshi.Json;
import com.talabat.feature.bnplcheckout.presentation.BNPLCheckoutFlutterFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0003\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionPaymentOTPRequestModel;", "", "planId", "", "cardTokenId", "paymentMethod", "", "amount", "orderId", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getAmount", "()Ljava/lang/String;", "getCardTokenId", "getOrderId", "getPaymentMethod", "()I", "getPlanId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionPaymentOTPRequestModel {
    @NotNull
    private final String amount;
    @NotNull
    private final String cardTokenId;
    @NotNull
    private final String orderId;
    private final int paymentMethod;
    @NotNull
    private final String planId;

    public SubscriptionPaymentOTPRequestModel() {
        this((String) null, (String) null, 0, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public SubscriptionPaymentOTPRequestModel(@NotNull @Json(name = "planId") String str, @NotNull @Json(name = "cardTokenId") String str2, @Json(name = "paymentMethod") int i11, @NotNull @Json(name = "amount") String str3, @NotNull @Json(name = "orderId") String str4) {
        Intrinsics.checkNotNullParameter(str, BNPLCheckoutFlutterFragment.PLAN_ID_EXTRA);
        Intrinsics.checkNotNullParameter(str2, "cardTokenId");
        Intrinsics.checkNotNullParameter(str3, "amount");
        Intrinsics.checkNotNullParameter(str4, "orderId");
        this.planId = str;
        this.cardTokenId = str2;
        this.paymentMethod = i11;
        this.amount = str3;
        this.orderId = str4;
    }

    public static /* synthetic */ SubscriptionPaymentOTPRequestModel copy$default(SubscriptionPaymentOTPRequestModel subscriptionPaymentOTPRequestModel, String str, String str2, int i11, String str3, String str4, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = subscriptionPaymentOTPRequestModel.planId;
        }
        if ((i12 & 2) != 0) {
            str2 = subscriptionPaymentOTPRequestModel.cardTokenId;
        }
        String str5 = str2;
        if ((i12 & 4) != 0) {
            i11 = subscriptionPaymentOTPRequestModel.paymentMethod;
        }
        int i13 = i11;
        if ((i12 & 8) != 0) {
            str3 = subscriptionPaymentOTPRequestModel.amount;
        }
        String str6 = str3;
        if ((i12 & 16) != 0) {
            str4 = subscriptionPaymentOTPRequestModel.orderId;
        }
        return subscriptionPaymentOTPRequestModel.copy(str, str5, i13, str6, str4);
    }

    @NotNull
    public final String component1() {
        return this.planId;
    }

    @NotNull
    public final String component2() {
        return this.cardTokenId;
    }

    public final int component3() {
        return this.paymentMethod;
    }

    @NotNull
    public final String component4() {
        return this.amount;
    }

    @NotNull
    public final String component5() {
        return this.orderId;
    }

    @NotNull
    public final SubscriptionPaymentOTPRequestModel copy(@NotNull @Json(name = "planId") String str, @NotNull @Json(name = "cardTokenId") String str2, @Json(name = "paymentMethod") int i11, @NotNull @Json(name = "amount") String str3, @NotNull @Json(name = "orderId") String str4) {
        Intrinsics.checkNotNullParameter(str, BNPLCheckoutFlutterFragment.PLAN_ID_EXTRA);
        Intrinsics.checkNotNullParameter(str2, "cardTokenId");
        Intrinsics.checkNotNullParameter(str3, "amount");
        Intrinsics.checkNotNullParameter(str4, "orderId");
        return new SubscriptionPaymentOTPRequestModel(str, str2, i11, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionPaymentOTPRequestModel)) {
            return false;
        }
        SubscriptionPaymentOTPRequestModel subscriptionPaymentOTPRequestModel = (SubscriptionPaymentOTPRequestModel) obj;
        return Intrinsics.areEqual((Object) this.planId, (Object) subscriptionPaymentOTPRequestModel.planId) && Intrinsics.areEqual((Object) this.cardTokenId, (Object) subscriptionPaymentOTPRequestModel.cardTokenId) && this.paymentMethod == subscriptionPaymentOTPRequestModel.paymentMethod && Intrinsics.areEqual((Object) this.amount, (Object) subscriptionPaymentOTPRequestModel.amount) && Intrinsics.areEqual((Object) this.orderId, (Object) subscriptionPaymentOTPRequestModel.orderId);
    }

    @NotNull
    public final String getAmount() {
        return this.amount;
    }

    @NotNull
    public final String getCardTokenId() {
        return this.cardTokenId;
    }

    @NotNull
    public final String getOrderId() {
        return this.orderId;
    }

    public final int getPaymentMethod() {
        return this.paymentMethod;
    }

    @NotNull
    public final String getPlanId() {
        return this.planId;
    }

    public int hashCode() {
        return (((((((this.planId.hashCode() * 31) + this.cardTokenId.hashCode()) * 31) + this.paymentMethod) * 31) + this.amount.hashCode()) * 31) + this.orderId.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.planId;
        String str2 = this.cardTokenId;
        int i11 = this.paymentMethod;
        String str3 = this.amount;
        String str4 = this.orderId;
        return "SubscriptionPaymentOTPRequestModel(planId=" + str + ", cardTokenId=" + str2 + ", paymentMethod=" + i11 + ", amount=" + str3 + ", orderId=" + str4 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SubscriptionPaymentOTPRequestModel(java.lang.String r5, java.lang.String r6, int r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            java.lang.String r0 = ""
            if (r11 == 0) goto L_0x0008
            r11 = r0
            goto L_0x0009
        L_0x0008:
            r11 = r5
        L_0x0009:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000f
            r1 = r0
            goto L_0x0010
        L_0x000f:
            r1 = r6
        L_0x0010:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r7 = 0
        L_0x0015:
            r2 = r7
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentOTPRequestModel.<init>(java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
