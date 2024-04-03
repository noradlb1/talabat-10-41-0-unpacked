package com.talabat.talabatcommon.feature.walletPayment.model.request;

import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001f\u0018\u00002\u00020\u0001BY\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007¢\u0006\u0002\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u000b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001a\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R\u001a\u0010\f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R\u001a\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018¨\u0006&"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletPayment/model/request/WalletTopUpRequestModel;", "", "amount", "", "country", "", "cardTokenId", "", "card4Digits", "cardType", "paymentMethod", "binNumber", "feature", "requestorTransactionId", "(FILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;)V", "getAmount", "()F", "setAmount", "(F)V", "getBinNumber", "()I", "setBinNumber", "(I)V", "getCard4Digits", "()Ljava/lang/String;", "setCard4Digits", "(Ljava/lang/String;)V", "getCardTokenId", "setCardTokenId", "getCardType", "setCardType", "getCountry", "setCountry", "getFeature", "setFeature", "getPaymentMethod", "setPaymentMethod", "getRequestorTransactionId", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTopUpRequestModel {
    private float amount;
    private int binNumber;
    @NotNull
    private String card4Digits;
    @NotNull
    private String cardTokenId;
    @NotNull
    private String cardType;
    private int country;
    private int feature;
    private int paymentMethod;
    @NotNull
    private final String requestorTransactionId;

    public WalletTopUpRequestModel(float f11, int i11, @NotNull String str, @NotNull String str2, @NotNull String str3, int i12, int i13, int i14, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "cardTokenId");
        Intrinsics.checkNotNullParameter(str2, WalletNavigatorActions.EXTRA_CARD_4_DIGITS);
        Intrinsics.checkNotNullParameter(str3, "cardType");
        Intrinsics.checkNotNullParameter(str4, "requestorTransactionId");
        this.amount = f11;
        this.country = i11;
        this.cardTokenId = str;
        this.card4Digits = str2;
        this.cardType = str3;
        this.paymentMethod = i12;
        this.binNumber = i13;
        this.feature = i14;
        this.requestorTransactionId = str4;
    }

    public final float getAmount() {
        return this.amount;
    }

    public final int getBinNumber() {
        return this.binNumber;
    }

    @NotNull
    public final String getCard4Digits() {
        return this.card4Digits;
    }

    @NotNull
    public final String getCardTokenId() {
        return this.cardTokenId;
    }

    @NotNull
    public final String getCardType() {
        return this.cardType;
    }

    public final int getCountry() {
        return this.country;
    }

    public final int getFeature() {
        return this.feature;
    }

    public final int getPaymentMethod() {
        return this.paymentMethod;
    }

    @NotNull
    public final String getRequestorTransactionId() {
        return this.requestorTransactionId;
    }

    public final void setAmount(float f11) {
        this.amount = f11;
    }

    public final void setBinNumber(int i11) {
        this.binNumber = i11;
    }

    public final void setCard4Digits(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.card4Digits = str;
    }

    public final void setCardTokenId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cardTokenId = str;
    }

    public final void setCardType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cardType = str;
    }

    public final void setCountry(int i11) {
        this.country = i11;
    }

    public final void setFeature(int i11) {
        this.feature = i11;
    }

    public final void setPaymentMethod(int i11) {
        this.paymentMethod = i11;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ WalletTopUpRequestModel(float r13, int r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, int r18, int r19, int r20, java.lang.String r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
        /*
            r12 = this;
            r0 = r22
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0009
            r1 = 0
            r3 = r1
            goto L_0x000a
        L_0x0009:
            r3 = r13
        L_0x000a:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0016
            kotlin.jvm.internal.StringCompanionObject r1 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r1 = com.talabat.talabatcommon.extentions.StringUtils.empty(r1)
            r5 = r1
            goto L_0x0017
        L_0x0016:
            r5 = r15
        L_0x0017:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0023
            kotlin.jvm.internal.StringCompanionObject r1 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r1 = com.talabat.talabatcommon.extentions.StringUtils.empty(r1)
            r6 = r1
            goto L_0x0025
        L_0x0023:
            r6 = r16
        L_0x0025:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0031
            kotlin.jvm.internal.StringCompanionObject r1 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r1 = com.talabat.talabatcommon.extentions.StringUtils.empty(r1)
            r7 = r1
            goto L_0x0033
        L_0x0031:
            r7 = r17
        L_0x0033:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x003f
            com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod r1 = com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod.NONE
            int r1 = r1.getValue()
            r8 = r1
            goto L_0x0041
        L_0x003f:
            r8 = r18
        L_0x0041:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0049
            java.lang.String r0 = ""
            r11 = r0
            goto L_0x004b
        L_0x0049:
            r11 = r21
        L_0x004b:
            r2 = r12
            r4 = r14
            r9 = r19
            r10 = r20
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.feature.walletPayment.model.request.WalletTopUpRequestModel.<init>(float, int, java.lang.String, java.lang.String, java.lang.String, int, int, int, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
