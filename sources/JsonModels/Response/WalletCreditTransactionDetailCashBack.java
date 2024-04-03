package JsonModels.Response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"LJsonModels/Response/WalletCreditTransactionDetailCashBack;", "", "amount", "", "expiryDays", "", "imageUrl", "", "(Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/String;)V", "getAmount", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getExpiryDays", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getImageUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/String;)LJsonModels/Response/WalletCreditTransactionDetailCashBack;", "equals", "", "other", "hashCode", "toString", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCreditTransactionDetailCashBack {
    @SerializedName("amount")
    @Nullable
    private final Float amount;
    @SerializedName("expiryDays")
    @Nullable
    private final Integer expiryDays;
    @SerializedName("imageUrl")
    @Nullable
    private final String imageUrl;

    public WalletCreditTransactionDetailCashBack(@Nullable Float f11, @Nullable Integer num, @Nullable String str) {
        this.amount = f11;
        this.expiryDays = num;
        this.imageUrl = str;
    }

    public static /* synthetic */ WalletCreditTransactionDetailCashBack copy$default(WalletCreditTransactionDetailCashBack walletCreditTransactionDetailCashBack, Float f11, Integer num, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = walletCreditTransactionDetailCashBack.amount;
        }
        if ((i11 & 2) != 0) {
            num = walletCreditTransactionDetailCashBack.expiryDays;
        }
        if ((i11 & 4) != 0) {
            str = walletCreditTransactionDetailCashBack.imageUrl;
        }
        return walletCreditTransactionDetailCashBack.copy(f11, num, str);
    }

    @Nullable
    public final Float component1() {
        return this.amount;
    }

    @Nullable
    public final Integer component2() {
        return this.expiryDays;
    }

    @Nullable
    public final String component3() {
        return this.imageUrl;
    }

    @NotNull
    public final WalletCreditTransactionDetailCashBack copy(@Nullable Float f11, @Nullable Integer num, @Nullable String str) {
        return new WalletCreditTransactionDetailCashBack(f11, num, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletCreditTransactionDetailCashBack)) {
            return false;
        }
        WalletCreditTransactionDetailCashBack walletCreditTransactionDetailCashBack = (WalletCreditTransactionDetailCashBack) obj;
        return Intrinsics.areEqual((Object) this.amount, (Object) walletCreditTransactionDetailCashBack.amount) && Intrinsics.areEqual((Object) this.expiryDays, (Object) walletCreditTransactionDetailCashBack.expiryDays) && Intrinsics.areEqual((Object) this.imageUrl, (Object) walletCreditTransactionDetailCashBack.imageUrl);
    }

    @Nullable
    public final Float getAmount() {
        return this.amount;
    }

    @Nullable
    public final Integer getExpiryDays() {
        return this.expiryDays;
    }

    @Nullable
    public final String getImageUrl() {
        return this.imageUrl;
    }

    public int hashCode() {
        Float f11 = this.amount;
        int i11 = 0;
        int hashCode = (f11 == null ? 0 : f11.hashCode()) * 31;
        Integer num = this.expiryDays;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.imageUrl;
        if (str != null) {
            i11 = str.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        Float f11 = this.amount;
        Integer num = this.expiryDays;
        String str = this.imageUrl;
        return "WalletCreditTransactionDetailCashBack(amount=" + f11 + ", expiryDays=" + num + ", imageUrl=" + str + ")";
    }
}
