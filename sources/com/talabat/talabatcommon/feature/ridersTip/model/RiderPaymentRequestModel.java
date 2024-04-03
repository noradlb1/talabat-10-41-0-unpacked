package com.talabat.talabatcommon.feature.ridersTip.model;

import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b \u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005¢\u0006\u0002\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R\u001a\u0010\f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\u001a\u0010\r\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\u001a\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u001e¨\u0006'"}, d2 = {"Lcom/talabat/talabatcommon/feature/ridersTip/model/RiderPaymentRequestModel;", "", "amount", "", "countryId", "", "cardTokenId", "", "card4Digits", "cardType", "vendorId", "encOrderId", "paymentMethod", "transactionType", "(FILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;II)V", "getAmount", "()F", "setAmount", "(F)V", "getCard4Digits", "()Ljava/lang/String;", "setCard4Digits", "(Ljava/lang/String;)V", "getCardTokenId", "setCardTokenId", "getCardType", "setCardType", "getCountryId", "()I", "setCountryId", "(I)V", "getEncOrderId", "setEncOrderId", "getPaymentMethod", "setPaymentMethod", "getTransactionType", "setTransactionType", "getVendorId", "setVendorId", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RiderPaymentRequestModel {
    private float amount;
    @NotNull
    private String card4Digits;
    @NotNull
    private String cardTokenId;
    @NotNull
    private String cardType;
    private int countryId;
    @NotNull
    private String encOrderId;
    private int paymentMethod;
    private int transactionType;
    private int vendorId;

    public RiderPaymentRequestModel() {
        this(0.0f, 0, (String) null, (String) null, (String) null, 0, (String) null, 0, 0, 511, (DefaultConstructorMarker) null);
    }

    public RiderPaymentRequestModel(float f11, int i11, @NotNull String str, @NotNull String str2, @NotNull String str3, int i12, @NotNull String str4, int i13, int i14) {
        Intrinsics.checkNotNullParameter(str, "cardTokenId");
        Intrinsics.checkNotNullParameter(str2, WalletNavigatorActions.EXTRA_CARD_4_DIGITS);
        Intrinsics.checkNotNullParameter(str3, "cardType");
        Intrinsics.checkNotNullParameter(str4, "encOrderId");
        this.amount = f11;
        this.countryId = i11;
        this.cardTokenId = str;
        this.card4Digits = str2;
        this.cardType = str3;
        this.vendorId = i12;
        this.encOrderId = str4;
        this.paymentMethod = i13;
        this.transactionType = i14;
    }

    public final float getAmount() {
        return this.amount;
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

    public final int getCountryId() {
        return this.countryId;
    }

    @NotNull
    public final String getEncOrderId() {
        return this.encOrderId;
    }

    public final int getPaymentMethod() {
        return this.paymentMethod;
    }

    public final int getTransactionType() {
        return this.transactionType;
    }

    public final int getVendorId() {
        return this.vendorId;
    }

    public final void setAmount(float f11) {
        this.amount = f11;
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

    public final void setCountryId(int i11) {
        this.countryId = i11;
    }

    public final void setEncOrderId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.encOrderId = str;
    }

    public final void setPaymentMethod(int i11) {
        this.paymentMethod = i11;
    }

    public final void setTransactionType(int i11) {
        this.transactionType = i11;
    }

    public final void setVendorId(int i11) {
        this.vendorId = i11;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RiderPaymentRequestModel(float r10, int r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, int r15, java.lang.String r16, int r17, int r18, int r19, kotlin.jvm.internal.DefaultConstructorMarker r20) {
        /*
            r9 = this;
            r0 = r19
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x0009
        L_0x0008:
            r1 = r10
        L_0x0009:
            r2 = r0 & 2
            r3 = 0
            if (r2 == 0) goto L_0x0010
            r2 = r3
            goto L_0x0011
        L_0x0010:
            r2 = r11
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001c
            kotlin.jvm.internal.StringCompanionObject r4 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r4 = com.talabat.talabatcommon.extentions.StringUtils.empty(r4)
            goto L_0x001d
        L_0x001c:
            r4 = r12
        L_0x001d:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0028
            kotlin.jvm.internal.StringCompanionObject r5 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r5 = com.talabat.talabatcommon.extentions.StringUtils.empty(r5)
            goto L_0x0029
        L_0x0028:
            r5 = r13
        L_0x0029:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0034
            kotlin.jvm.internal.StringCompanionObject r6 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r6 = com.talabat.talabatcommon.extentions.StringUtils.empty(r6)
            goto L_0x0035
        L_0x0034:
            r6 = r14
        L_0x0035:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x003a
            goto L_0x003b
        L_0x003a:
            r3 = r15
        L_0x003b:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x0046
            kotlin.jvm.internal.StringCompanionObject r7 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r7 = com.talabat.talabatcommon.extentions.StringUtils.empty(r7)
            goto L_0x0048
        L_0x0046:
            r7 = r16
        L_0x0048:
            r8 = r0 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x0053
            com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod r8 = com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod.NONE
            int r8 = r8.getValue()
            goto L_0x0055
        L_0x0053:
            r8 = r17
        L_0x0055:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x005b
            r0 = -1
            goto L_0x005d
        L_0x005b:
            r0 = r18
        L_0x005d:
            r10 = r9
            r11 = r1
            r12 = r2
            r13 = r4
            r14 = r5
            r15 = r6
            r16 = r3
            r17 = r7
            r18 = r8
            r19 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.feature.ridersTip.model.RiderPaymentRequestModel.<init>(float, int, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
