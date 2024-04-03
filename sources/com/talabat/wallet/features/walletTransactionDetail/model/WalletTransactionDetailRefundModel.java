package com.talabat.wallet.features.walletTransactionDetail.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011JJ\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0014\u0010\u0011¨\u0006!"}, d2 = {"Lcom/talabat/wallet/features/walletTransactionDetail/model/WalletTransactionDetailRefundModel;", "", "reason", "", "revertMinDays", "", "revertMaxDays", "revertAmount", "", "revertStatus", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Integer;)V", "getReason", "()Ljava/lang/String;", "getRevertAmount", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getRevertMaxDays", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRevertMinDays", "getRevertStatus", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Integer;)Lcom/talabat/wallet/features/walletTransactionDetail/model/WalletTransactionDetailRefundModel;", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionDetailRefundModel {
    @SerializedName("reason")
    @Nullable
    private final String reason;
    @SerializedName("revertAmount")
    @Nullable
    private final Float revertAmount;
    @SerializedName("revertMaxDays")
    @Nullable
    private final Integer revertMaxDays;
    @SerializedName("revertMinDays")
    @Nullable
    private final Integer revertMinDays;
    @SerializedName("revertStatus")
    @Nullable
    private final Integer revertStatus;

    public WalletTransactionDetailRefundModel(@Nullable String str, @Nullable Integer num, @Nullable Integer num2, @Nullable Float f11, @Nullable Integer num3) {
        this.reason = str;
        this.revertMinDays = num;
        this.revertMaxDays = num2;
        this.revertAmount = f11;
        this.revertStatus = num3;
    }

    public static /* synthetic */ WalletTransactionDetailRefundModel copy$default(WalletTransactionDetailRefundModel walletTransactionDetailRefundModel, String str, Integer num, Integer num2, Float f11, Integer num3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = walletTransactionDetailRefundModel.reason;
        }
        if ((i11 & 2) != 0) {
            num = walletTransactionDetailRefundModel.revertMinDays;
        }
        Integer num4 = num;
        if ((i11 & 4) != 0) {
            num2 = walletTransactionDetailRefundModel.revertMaxDays;
        }
        Integer num5 = num2;
        if ((i11 & 8) != 0) {
            f11 = walletTransactionDetailRefundModel.revertAmount;
        }
        Float f12 = f11;
        if ((i11 & 16) != 0) {
            num3 = walletTransactionDetailRefundModel.revertStatus;
        }
        return walletTransactionDetailRefundModel.copy(str, num4, num5, f12, num3);
    }

    @Nullable
    public final String component1() {
        return this.reason;
    }

    @Nullable
    public final Integer component2() {
        return this.revertMinDays;
    }

    @Nullable
    public final Integer component3() {
        return this.revertMaxDays;
    }

    @Nullable
    public final Float component4() {
        return this.revertAmount;
    }

    @Nullable
    public final Integer component5() {
        return this.revertStatus;
    }

    @NotNull
    public final WalletTransactionDetailRefundModel copy(@Nullable String str, @Nullable Integer num, @Nullable Integer num2, @Nullable Float f11, @Nullable Integer num3) {
        return new WalletTransactionDetailRefundModel(str, num, num2, f11, num3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletTransactionDetailRefundModel)) {
            return false;
        }
        WalletTransactionDetailRefundModel walletTransactionDetailRefundModel = (WalletTransactionDetailRefundModel) obj;
        return Intrinsics.areEqual((Object) this.reason, (Object) walletTransactionDetailRefundModel.reason) && Intrinsics.areEqual((Object) this.revertMinDays, (Object) walletTransactionDetailRefundModel.revertMinDays) && Intrinsics.areEqual((Object) this.revertMaxDays, (Object) walletTransactionDetailRefundModel.revertMaxDays) && Intrinsics.areEqual((Object) this.revertAmount, (Object) walletTransactionDetailRefundModel.revertAmount) && Intrinsics.areEqual((Object) this.revertStatus, (Object) walletTransactionDetailRefundModel.revertStatus);
    }

    @Nullable
    public final String getReason() {
        return this.reason;
    }

    @Nullable
    public final Float getRevertAmount() {
        return this.revertAmount;
    }

    @Nullable
    public final Integer getRevertMaxDays() {
        return this.revertMaxDays;
    }

    @Nullable
    public final Integer getRevertMinDays() {
        return this.revertMinDays;
    }

    @Nullable
    public final Integer getRevertStatus() {
        return this.revertStatus;
    }

    public int hashCode() {
        String str = this.reason;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.revertMinDays;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.revertMaxDays;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Float f11 = this.revertAmount;
        int hashCode4 = (hashCode3 + (f11 == null ? 0 : f11.hashCode())) * 31;
        Integer num3 = this.revertStatus;
        if (num3 != null) {
            i11 = num3.hashCode();
        }
        return hashCode4 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.reason;
        Integer num = this.revertMinDays;
        Integer num2 = this.revertMaxDays;
        Float f11 = this.revertAmount;
        Integer num3 = this.revertStatus;
        return "WalletTransactionDetailRefundModel(reason=" + str + ", revertMinDays=" + num + ", revertMaxDays=" + num2 + ", revertAmount=" + f11 + ", revertStatus=" + num3 + ")";
    }
}
