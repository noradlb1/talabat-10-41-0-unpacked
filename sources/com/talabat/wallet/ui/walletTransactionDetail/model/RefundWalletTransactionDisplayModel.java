package com.talabat.wallet.ui.walletTransactionDetail.model;

import com.talabat.mapper.ModelMapping;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J;\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0005HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001e\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016¨\u0006&"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/model/RefundWalletTransactionDisplayModel;", "", "reason", "", "revertMinDays", "", "revertMaxDays", "revertAmount", "", "revertStatus", "(Ljava/lang/String;IIFI)V", "getReason", "()Ljava/lang/String;", "setReason", "(Ljava/lang/String;)V", "getRevertAmount", "()F", "setRevertAmount", "(F)V", "getRevertMaxDays", "()I", "setRevertMaxDays", "(I)V", "getRevertMinDays", "setRevertMinDays", "getRevertStatus", "setRevertStatus", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RefundWalletTransactionDisplayModel {
    @NotNull
    @ModelMapping({"reason"})
    private String reason;
    @ModelMapping({"revertAmount"})
    private float revertAmount;
    @ModelMapping({"revertMaxDays"})
    private int revertMaxDays;
    @ModelMapping({"revertMinDays"})
    private int revertMinDays;
    @ModelMapping({"revertStatus"})
    private int revertStatus;

    public RefundWalletTransactionDisplayModel() {
        this((String) null, 0, 0, 0.0f, 0, 31, (DefaultConstructorMarker) null);
    }

    public RefundWalletTransactionDisplayModel(@NotNull String str, int i11, int i12, float f11, int i13) {
        Intrinsics.checkNotNullParameter(str, "reason");
        this.reason = str;
        this.revertMinDays = i11;
        this.revertMaxDays = i12;
        this.revertAmount = f11;
        this.revertStatus = i13;
    }

    public static /* synthetic */ RefundWalletTransactionDisplayModel copy$default(RefundWalletTransactionDisplayModel refundWalletTransactionDisplayModel, String str, int i11, int i12, float f11, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            str = refundWalletTransactionDisplayModel.reason;
        }
        if ((i14 & 2) != 0) {
            i11 = refundWalletTransactionDisplayModel.revertMinDays;
        }
        int i15 = i11;
        if ((i14 & 4) != 0) {
            i12 = refundWalletTransactionDisplayModel.revertMaxDays;
        }
        int i16 = i12;
        if ((i14 & 8) != 0) {
            f11 = refundWalletTransactionDisplayModel.revertAmount;
        }
        float f12 = f11;
        if ((i14 & 16) != 0) {
            i13 = refundWalletTransactionDisplayModel.revertStatus;
        }
        return refundWalletTransactionDisplayModel.copy(str, i15, i16, f12, i13);
    }

    @NotNull
    public final String component1() {
        return this.reason;
    }

    public final int component2() {
        return this.revertMinDays;
    }

    public final int component3() {
        return this.revertMaxDays;
    }

    public final float component4() {
        return this.revertAmount;
    }

    public final int component5() {
        return this.revertStatus;
    }

    @NotNull
    public final RefundWalletTransactionDisplayModel copy(@NotNull String str, int i11, int i12, float f11, int i13) {
        Intrinsics.checkNotNullParameter(str, "reason");
        return new RefundWalletTransactionDisplayModel(str, i11, i12, f11, i13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RefundWalletTransactionDisplayModel)) {
            return false;
        }
        RefundWalletTransactionDisplayModel refundWalletTransactionDisplayModel = (RefundWalletTransactionDisplayModel) obj;
        return Intrinsics.areEqual((Object) this.reason, (Object) refundWalletTransactionDisplayModel.reason) && this.revertMinDays == refundWalletTransactionDisplayModel.revertMinDays && this.revertMaxDays == refundWalletTransactionDisplayModel.revertMaxDays && Intrinsics.areEqual((Object) Float.valueOf(this.revertAmount), (Object) Float.valueOf(refundWalletTransactionDisplayModel.revertAmount)) && this.revertStatus == refundWalletTransactionDisplayModel.revertStatus;
    }

    @NotNull
    public final String getReason() {
        return this.reason;
    }

    public final float getRevertAmount() {
        return this.revertAmount;
    }

    public final int getRevertMaxDays() {
        return this.revertMaxDays;
    }

    public final int getRevertMinDays() {
        return this.revertMinDays;
    }

    public final int getRevertStatus() {
        return this.revertStatus;
    }

    public int hashCode() {
        return (((((((this.reason.hashCode() * 31) + this.revertMinDays) * 31) + this.revertMaxDays) * 31) + Float.floatToIntBits(this.revertAmount)) * 31) + this.revertStatus;
    }

    public final void setReason(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.reason = str;
    }

    public final void setRevertAmount(float f11) {
        this.revertAmount = f11;
    }

    public final void setRevertMaxDays(int i11) {
        this.revertMaxDays = i11;
    }

    public final void setRevertMinDays(int i11) {
        this.revertMinDays = i11;
    }

    public final void setRevertStatus(int i11) {
        this.revertStatus = i11;
    }

    @NotNull
    public String toString() {
        String str = this.reason;
        int i11 = this.revertMinDays;
        int i12 = this.revertMaxDays;
        float f11 = this.revertAmount;
        int i13 = this.revertStatus;
        return "RefundWalletTransactionDisplayModel(reason=" + str + ", revertMinDays=" + i11 + ", revertMaxDays=" + i12 + ", revertAmount=" + f11 + ", revertStatus=" + i13 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RefundWalletTransactionDisplayModel(java.lang.String r4, int r5, int r6, float r7, int r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L_0x000a
            kotlin.jvm.internal.StringCompanionObject r4 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r4 = com.talabat.talabatcommon.extentions.StringUtils.empty(r4)
        L_0x000a:
            r10 = r9 & 2
            r0 = 0
            if (r10 == 0) goto L_0x0011
            r10 = r0
            goto L_0x0012
        L_0x0011:
            r10 = r5
        L_0x0012:
            r5 = r9 & 4
            if (r5 == 0) goto L_0x0018
            r1 = r0
            goto L_0x0019
        L_0x0018:
            r1 = r6
        L_0x0019:
            r5 = r9 & 8
            if (r5 == 0) goto L_0x001e
            r7 = 0
        L_0x001e:
            r2 = r7
            r5 = r9 & 16
            if (r5 == 0) goto L_0x0024
            goto L_0x0025
        L_0x0024:
            r0 = r8
        L_0x0025:
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r1
            r9 = r2
            r10 = r0
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.ui.walletTransactionDetail.model.RefundWalletTransactionDisplayModel.<init>(java.lang.String, int, int, float, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
