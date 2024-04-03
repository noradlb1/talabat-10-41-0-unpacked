package com.talabat.talabatcommon.feature.walletBalance.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletBalance/model/response/WalletCreditBalanceResultModel;", "", "balanceAmount", "", "(Ljava/lang/Float;)V", "getBalanceAmount", "()Ljava/lang/Float;", "Ljava/lang/Float;", "component1", "copy", "(Ljava/lang/Float;)Lcom/talabat/talabatcommon/feature/walletBalance/model/response/WalletCreditBalanceResultModel;", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCreditBalanceResultModel {
    @SerializedName("balanceAmount")
    @Nullable
    private final Float balanceAmount;

    public WalletCreditBalanceResultModel(@Nullable Float f11) {
        this.balanceAmount = f11;
    }

    public static /* synthetic */ WalletCreditBalanceResultModel copy$default(WalletCreditBalanceResultModel walletCreditBalanceResultModel, Float f11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = walletCreditBalanceResultModel.balanceAmount;
        }
        return walletCreditBalanceResultModel.copy(f11);
    }

    @Nullable
    public final Float component1() {
        return this.balanceAmount;
    }

    @NotNull
    public final WalletCreditBalanceResultModel copy(@Nullable Float f11) {
        return new WalletCreditBalanceResultModel(f11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof WalletCreditBalanceResultModel) && Intrinsics.areEqual((Object) this.balanceAmount, (Object) ((WalletCreditBalanceResultModel) obj).balanceAmount);
    }

    @Nullable
    public final Float getBalanceAmount() {
        return this.balanceAmount;
    }

    public int hashCode() {
        Float f11 = this.balanceAmount;
        if (f11 == null) {
            return 0;
        }
        return f11.hashCode();
    }

    @NotNull
    public String toString() {
        Float f11 = this.balanceAmount;
        return "WalletCreditBalanceResultModel(balanceAmount=" + f11 + ")";
    }
}
