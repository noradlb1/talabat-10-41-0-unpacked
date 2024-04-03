package com.talabat.talabatcommon.views.wallet.walletPaymentOption.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tR\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/BottomSheetPaymentStatusModel;", "", "paymentStatus", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletPaymentStatus;", "title", "", "description", "threeDSUrl", "transactionId", "(Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletPaymentStatus;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "getPaymentStatus", "()Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletPaymentStatus;", "setPaymentStatus", "(Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletPaymentStatus;)V", "getThreeDSUrl", "setThreeDSUrl", "getTitle", "setTitle", "getTransactionId", "setTransactionId", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BottomSheetPaymentStatusModel {
    @NotNull
    private String description;
    @NotNull
    private WalletPaymentStatus paymentStatus;
    @NotNull
    private String threeDSUrl;
    @NotNull
    private String title;
    @NotNull
    private String transactionId;

    public BottomSheetPaymentStatusModel() {
        this((WalletPaymentStatus) null, (String) null, (String) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public BottomSheetPaymentStatusModel(@NotNull WalletPaymentStatus walletPaymentStatus, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(walletPaymentStatus, "paymentStatus");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "description");
        Intrinsics.checkNotNullParameter(str3, "threeDSUrl");
        Intrinsics.checkNotNullParameter(str4, "transactionId");
        this.paymentStatus = walletPaymentStatus;
        this.title = str;
        this.description = str2;
        this.threeDSUrl = str3;
        this.transactionId = str4;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final WalletPaymentStatus getPaymentStatus() {
        return this.paymentStatus;
    }

    @NotNull
    public final String getThreeDSUrl() {
        return this.threeDSUrl;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getTransactionId() {
        return this.transactionId;
    }

    public final void setDescription(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.description = str;
    }

    public final void setPaymentStatus(@NotNull WalletPaymentStatus walletPaymentStatus) {
        Intrinsics.checkNotNullParameter(walletPaymentStatus, "<set-?>");
        this.paymentStatus = walletPaymentStatus;
    }

    public final void setThreeDSUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.threeDSUrl = str;
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final void setTransactionId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.transactionId = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ BottomSheetPaymentStatusModel(com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletPaymentStatus r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L_0x0006
            com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletPaymentStatus r4 = com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletPaymentStatus.NONE
        L_0x0006:
            r10 = r9 & 2
            if (r10 == 0) goto L_0x0010
            kotlin.jvm.internal.StringCompanionObject r5 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r5 = com.talabat.talabatcommon.extentions.StringUtils.empty(r5)
        L_0x0010:
            r10 = r5
            r5 = r9 & 4
            if (r5 == 0) goto L_0x001b
            kotlin.jvm.internal.StringCompanionObject r5 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r6 = com.talabat.talabatcommon.extentions.StringUtils.empty(r5)
        L_0x001b:
            r0 = r6
            r5 = r9 & 8
            if (r5 == 0) goto L_0x0026
            kotlin.jvm.internal.StringCompanionObject r5 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r7 = com.talabat.talabatcommon.extentions.StringUtils.empty(r5)
        L_0x0026:
            r1 = r7
            r5 = r9 & 16
            if (r5 == 0) goto L_0x0031
            kotlin.jvm.internal.StringCompanionObject r5 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r8 = com.talabat.talabatcommon.extentions.StringUtils.empty(r5)
        L_0x0031:
            r2 = r8
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r0
            r9 = r1
            r10 = r2
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.BottomSheetPaymentStatusModel.<init>(com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletPaymentStatus, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
