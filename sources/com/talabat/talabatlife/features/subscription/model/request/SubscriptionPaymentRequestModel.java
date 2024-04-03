package com.talabat.talabatlife.features.subscription.model.request;

import com.talabat.feature.bnplcheckout.presentation.BNPLCheckoutFlutterFragment;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0017\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR$\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000f¨\u0006 "}, d2 = {"Lcom/talabat/talabatlife/features/subscription/model/request/SubscriptionPaymentRequestModel;", "", "planId", "", "walletTransactionId", "cardTokenId", "card4Digits", "cardType", "paymentMethod", "", "cardExpiryDate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getCard4Digits", "()Ljava/lang/String;", "setCard4Digits", "(Ljava/lang/String;)V", "getCardExpiryDate", "setCardExpiryDate", "getCardTokenId", "setCardTokenId", "getCardType", "setCardType", "getPaymentMethod", "()I", "setPaymentMethod", "(I)V", "getPlanId", "setPlanId", "getWalletTransactionId$annotations", "()V", "getWalletTransactionId", "setWalletTransactionId", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionPaymentRequestModel {
    @NotNull
    private String card4Digits;
    @NotNull
    private String cardExpiryDate;
    @NotNull
    private String cardTokenId;
    @NotNull
    private String cardType;
    private int paymentMethod;
    @NotNull
    private String planId;
    @NotNull
    private String walletTransactionId;

    public SubscriptionPaymentRequestModel() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, 0, (String) null, 127, (DefaultConstructorMarker) null);
    }

    public SubscriptionPaymentRequestModel(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, int i11, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, BNPLCheckoutFlutterFragment.PLAN_ID_EXTRA);
        Intrinsics.checkNotNullParameter(str2, "walletTransactionId");
        Intrinsics.checkNotNullParameter(str3, "cardTokenId");
        Intrinsics.checkNotNullParameter(str4, WalletNavigatorActions.EXTRA_CARD_4_DIGITS);
        Intrinsics.checkNotNullParameter(str5, "cardType");
        Intrinsics.checkNotNullParameter(str6, "cardExpiryDate");
        this.planId = str;
        this.walletTransactionId = str2;
        this.cardTokenId = str3;
        this.card4Digits = str4;
        this.cardType = str5;
        this.paymentMethod = i11;
        this.cardExpiryDate = str6;
    }

    @Deprecated(message = "Card details to be used")
    public static /* synthetic */ void getWalletTransactionId$annotations() {
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

    @NotNull
    public final String getWalletTransactionId() {
        return this.walletTransactionId;
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

    public final void setPaymentMethod(int i11) {
        this.paymentMethod = i11;
    }

    public final void setPlanId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.planId = str;
    }

    public final void setWalletTransactionId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.walletTransactionId = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SubscriptionPaymentRequestModel(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, int r11, java.lang.String r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r5 = this;
            r14 = r13 & 1
            if (r14 == 0) goto L_0x000a
            kotlin.jvm.internal.StringCompanionObject r6 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r6 = com.talabat.talabatcommon.extentions.StringUtils.empty(r6)
        L_0x000a:
            r14 = r13 & 2
            if (r14 == 0) goto L_0x0014
            kotlin.jvm.internal.StringCompanionObject r7 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r7 = com.talabat.talabatcommon.extentions.StringUtils.empty(r7)
        L_0x0014:
            r14 = r7
            r7 = r13 & 4
            if (r7 == 0) goto L_0x001f
            kotlin.jvm.internal.StringCompanionObject r7 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r8 = com.talabat.talabatcommon.extentions.StringUtils.empty(r7)
        L_0x001f:
            r0 = r8
            r7 = r13 & 8
            if (r7 == 0) goto L_0x002a
            kotlin.jvm.internal.StringCompanionObject r7 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r9 = com.talabat.talabatcommon.extentions.StringUtils.empty(r7)
        L_0x002a:
            r1 = r9
            r7 = r13 & 16
            if (r7 == 0) goto L_0x0035
            kotlin.jvm.internal.StringCompanionObject r7 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r10 = com.talabat.talabatcommon.extentions.StringUtils.empty(r7)
        L_0x0035:
            r2 = r10
            r7 = r13 & 32
            if (r7 == 0) goto L_0x0040
            kotlin.jvm.internal.IntCompanionObject r7 = kotlin.jvm.internal.IntCompanionObject.INSTANCE
            int r11 = com.talabat.talabatcommon.extentions.IntKt.orZero((kotlin.jvm.internal.IntCompanionObject) r7)
        L_0x0040:
            r3 = r11
            r7 = r13 & 64
            if (r7 == 0) goto L_0x004b
            kotlin.jvm.internal.StringCompanionObject r7 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r12 = com.talabat.talabatcommon.extentions.StringUtils.empty(r7)
        L_0x004b:
            r4 = r12
            r7 = r5
            r8 = r6
            r9 = r14
            r10 = r0
            r11 = r1
            r12 = r2
            r13 = r3
            r14 = r4
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatlife.features.subscription.model.request.SubscriptionPaymentRequestModel.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
