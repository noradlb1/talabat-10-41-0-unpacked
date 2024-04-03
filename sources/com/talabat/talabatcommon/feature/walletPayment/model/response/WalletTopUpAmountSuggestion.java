package com.talabat.talabatcommon.feature.walletPayment.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J&\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletPayment/model/response/WalletTopUpAmountSuggestion;", "", "topUpAmount", "", "topUpCashBack", "(Ljava/lang/Float;Ljava/lang/Float;)V", "getTopUpAmount", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getTopUpCashBack", "component1", "component2", "copy", "(Ljava/lang/Float;Ljava/lang/Float;)Lcom/talabat/talabatcommon/feature/walletPayment/model/response/WalletTopUpAmountSuggestion;", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTopUpAmountSuggestion {
    @SerializedName("amount")
    @Nullable
    private final Float topUpAmount;
    @SerializedName("cashback")
    @Nullable
    private final Float topUpCashBack;

    public WalletTopUpAmountSuggestion(@Nullable Float f11, @Nullable Float f12) {
        this.topUpAmount = f11;
        this.topUpCashBack = f12;
    }

    public static /* synthetic */ WalletTopUpAmountSuggestion copy$default(WalletTopUpAmountSuggestion walletTopUpAmountSuggestion, Float f11, Float f12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = walletTopUpAmountSuggestion.topUpAmount;
        }
        if ((i11 & 2) != 0) {
            f12 = walletTopUpAmountSuggestion.topUpCashBack;
        }
        return walletTopUpAmountSuggestion.copy(f11, f12);
    }

    @Nullable
    public final Float component1() {
        return this.topUpAmount;
    }

    @Nullable
    public final Float component2() {
        return this.topUpCashBack;
    }

    @NotNull
    public final WalletTopUpAmountSuggestion copy(@Nullable Float f11, @Nullable Float f12) {
        return new WalletTopUpAmountSuggestion(f11, f12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletTopUpAmountSuggestion)) {
            return false;
        }
        WalletTopUpAmountSuggestion walletTopUpAmountSuggestion = (WalletTopUpAmountSuggestion) obj;
        return Intrinsics.areEqual((Object) this.topUpAmount, (Object) walletTopUpAmountSuggestion.topUpAmount) && Intrinsics.areEqual((Object) this.topUpCashBack, (Object) walletTopUpAmountSuggestion.topUpCashBack);
    }

    @Nullable
    public final Float getTopUpAmount() {
        return this.topUpAmount;
    }

    @Nullable
    public final Float getTopUpCashBack() {
        return this.topUpCashBack;
    }

    public int hashCode() {
        Float f11 = this.topUpAmount;
        int i11 = 0;
        int hashCode = (f11 == null ? 0 : f11.hashCode()) * 31;
        Float f12 = this.topUpCashBack;
        if (f12 != null) {
            i11 = f12.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        Float f11 = this.topUpAmount;
        Float f12 = this.topUpCashBack;
        return "WalletTopUpAmountSuggestion(topUpAmount=" + f11 + ", topUpCashBack=" + f12 + ")";
    }
}
