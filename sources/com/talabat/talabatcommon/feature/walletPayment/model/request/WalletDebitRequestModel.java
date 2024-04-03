package com.talabat.talabatcommon.feature.walletPayment.model.request;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b%\u0018\u00002\u00020\u0001Bw\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n¢\u0006\u0002\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u000e\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\r\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u001a\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\u001a\u0010\f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001a\"\u0004\b'\u0010\u001cR\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0016\"\u0004\b)\u0010\u0018R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u0006/"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletPayment/model/request/WalletDebitRequestModel;", "", "amount", "", "transactionType", "", "transactionId", "paymentMethod", "feature", "transId", "", "encVendorId", "orderId", "encOrderId", "country", "requestorTransactionId", "(FLjava/lang/Integer;IIILjava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;)V", "getAmount", "()F", "setAmount", "(F)V", "getCountry", "()I", "setCountry", "(I)V", "getEncOrderId", "()Ljava/lang/String;", "setEncOrderId", "(Ljava/lang/String;)V", "getEncVendorId", "setEncVendorId", "getFeature", "setFeature", "getOrderId", "setOrderId", "getPaymentMethod", "setPaymentMethod", "getRequestorTransactionId", "getTransId", "setTransId", "getTransactionId", "setTransactionId", "getTransactionType", "()Ljava/lang/Integer;", "setTransactionType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletDebitRequestModel {
    private float amount;
    private int country;
    @NotNull
    private String encOrderId;
    @NotNull
    private String encVendorId;
    private int feature;
    private int orderId;
    private int paymentMethod;
    @NotNull
    private final String requestorTransactionId;
    @Nullable
    private String transId;
    private int transactionId;
    @Nullable
    private Integer transactionType;

    public WalletDebitRequestModel() {
        this(0.0f, (Integer) null, 0, 0, 0, (String) null, (String) null, 0, (String) null, 0, (String) null, 2047, (DefaultConstructorMarker) null);
    }

    public WalletDebitRequestModel(float f11, @Nullable Integer num, int i11, int i12, int i13, @Nullable String str, @NotNull String str2, int i14, @NotNull String str3, int i15, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str2, "encVendorId");
        Intrinsics.checkNotNullParameter(str3, "encOrderId");
        Intrinsics.checkNotNullParameter(str4, "requestorTransactionId");
        this.amount = f11;
        this.transactionType = num;
        this.transactionId = i11;
        this.paymentMethod = i12;
        this.feature = i13;
        this.transId = str;
        this.encVendorId = str2;
        this.orderId = i14;
        this.encOrderId = str3;
        this.country = i15;
        this.requestorTransactionId = str4;
    }

    public final float getAmount() {
        return this.amount;
    }

    public final int getCountry() {
        return this.country;
    }

    @NotNull
    public final String getEncOrderId() {
        return this.encOrderId;
    }

    @NotNull
    public final String getEncVendorId() {
        return this.encVendorId;
    }

    public final int getFeature() {
        return this.feature;
    }

    public final int getOrderId() {
        return this.orderId;
    }

    public final int getPaymentMethod() {
        return this.paymentMethod;
    }

    @NotNull
    public final String getRequestorTransactionId() {
        return this.requestorTransactionId;
    }

    @Nullable
    public final String getTransId() {
        return this.transId;
    }

    public final int getTransactionId() {
        return this.transactionId;
    }

    @Nullable
    public final Integer getTransactionType() {
        return this.transactionType;
    }

    public final void setAmount(float f11) {
        this.amount = f11;
    }

    public final void setCountry(int i11) {
        this.country = i11;
    }

    public final void setEncOrderId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.encOrderId = str;
    }

    public final void setEncVendorId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.encVendorId = str;
    }

    public final void setFeature(int i11) {
        this.feature = i11;
    }

    public final void setOrderId(int i11) {
        this.orderId = i11;
    }

    public final void setPaymentMethod(int i11) {
        this.paymentMethod = i11;
    }

    public final void setTransId(@Nullable String str) {
        this.transId = str;
    }

    public final void setTransactionId(int i11) {
        this.transactionId = i11;
    }

    public final void setTransactionType(@Nullable Integer num) {
        this.transactionType = num;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ WalletDebitRequestModel(float r12, java.lang.Integer r13, int r14, int r15, int r16, java.lang.String r17, java.lang.String r18, int r19, java.lang.String r20, int r21, java.lang.String r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r11 = this;
            r0 = r23
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x0009
        L_0x0008:
            r1 = r12
        L_0x0009:
            r2 = r0 & 2
            r3 = 0
            if (r2 == 0) goto L_0x0010
            r2 = r3
            goto L_0x0011
        L_0x0010:
            r2 = r13
        L_0x0011:
            r4 = r0 & 4
            r5 = 0
            if (r4 == 0) goto L_0x0018
            r4 = r5
            goto L_0x0019
        L_0x0018:
            r4 = r14
        L_0x0019:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0024
            com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod r6 = com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod.WALLET
            int r6 = r6.getValue()
            goto L_0x0025
        L_0x0024:
            r6 = r15
        L_0x0025:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x002b
            r7 = r5
            goto L_0x002d
        L_0x002b:
            r7 = r16
        L_0x002d:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0032
            goto L_0x0034
        L_0x0032:
            r3 = r17
        L_0x0034:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x003f
            kotlin.jvm.internal.StringCompanionObject r8 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r8 = com.talabat.talabatcommon.extentions.StringUtils.empty(r8)
            goto L_0x0041
        L_0x003f:
            r8 = r18
        L_0x0041:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0046
            goto L_0x0048
        L_0x0046:
            r5 = r19
        L_0x0048:
            r9 = r0 & 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L_0x0053
            kotlin.jvm.internal.StringCompanionObject r9 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r9 = com.talabat.talabatcommon.extentions.StringUtils.empty(r9)
            goto L_0x0055
        L_0x0053:
            r9 = r20
        L_0x0055:
            r10 = r0 & 512(0x200, float:7.175E-43)
            if (r10 == 0) goto L_0x005b
            r10 = -1
            goto L_0x005d
        L_0x005b:
            r10 = r21
        L_0x005d:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0064
            java.lang.String r0 = ""
            goto L_0x0066
        L_0x0064:
            r0 = r22
        L_0x0066:
            r12 = r11
            r13 = r1
            r14 = r2
            r15 = r4
            r16 = r6
            r17 = r7
            r18 = r3
            r19 = r8
            r20 = r5
            r21 = r9
            r22 = r10
            r23 = r0
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.feature.walletPayment.model.request.WalletDebitRequestModel.<init>(float, java.lang.Integer, int, int, int, java.lang.String, java.lang.String, int, java.lang.String, int, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
