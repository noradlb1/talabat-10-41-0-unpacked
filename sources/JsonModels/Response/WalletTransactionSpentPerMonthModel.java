package JsonModels.Response;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ&\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"LJsonModels/Response/WalletTransactionSpentPerMonthModel;", "", "month", "", "spendAmount", "", "(Ljava/lang/String;Ljava/lang/Float;)V", "getMonth", "()Ljava/lang/String;", "setMonth", "(Ljava/lang/String;)V", "getSpendAmount", "()Ljava/lang/Float;", "setSpendAmount", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Float;)LJsonModels/Response/WalletTransactionSpentPerMonthModel;", "equals", "", "other", "hashCode", "", "toString", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionSpentPerMonthModel {
    @Nullable
    private String month;
    @Nullable
    private Float spendAmount;

    public WalletTransactionSpentPerMonthModel(@Nullable String str, @Nullable Float f11) {
        this.month = str;
        this.spendAmount = f11;
    }

    public static /* synthetic */ WalletTransactionSpentPerMonthModel copy$default(WalletTransactionSpentPerMonthModel walletTransactionSpentPerMonthModel, String str, Float f11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = walletTransactionSpentPerMonthModel.month;
        }
        if ((i11 & 2) != 0) {
            f11 = walletTransactionSpentPerMonthModel.spendAmount;
        }
        return walletTransactionSpentPerMonthModel.copy(str, f11);
    }

    @Nullable
    public final String component1() {
        return this.month;
    }

    @Nullable
    public final Float component2() {
        return this.spendAmount;
    }

    @NotNull
    public final WalletTransactionSpentPerMonthModel copy(@Nullable String str, @Nullable Float f11) {
        return new WalletTransactionSpentPerMonthModel(str, f11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletTransactionSpentPerMonthModel)) {
            return false;
        }
        WalletTransactionSpentPerMonthModel walletTransactionSpentPerMonthModel = (WalletTransactionSpentPerMonthModel) obj;
        return Intrinsics.areEqual((Object) this.month, (Object) walletTransactionSpentPerMonthModel.month) && Intrinsics.areEqual((Object) this.spendAmount, (Object) walletTransactionSpentPerMonthModel.spendAmount);
    }

    @Nullable
    public final String getMonth() {
        return this.month;
    }

    @Nullable
    public final Float getSpendAmount() {
        return this.spendAmount;
    }

    public int hashCode() {
        String str = this.month;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Float f11 = this.spendAmount;
        if (f11 != null) {
            i11 = f11.hashCode();
        }
        return hashCode + i11;
    }

    public final void setMonth(@Nullable String str) {
        this.month = str;
    }

    public final void setSpendAmount(@Nullable Float f11) {
        this.spendAmount = f11;
    }

    @NotNull
    public String toString() {
        String str = this.month;
        Float f11 = this.spendAmount;
        return "WalletTransactionSpentPerMonthModel(month=" + str + ", spendAmount=" + f11 + ")";
    }
}
