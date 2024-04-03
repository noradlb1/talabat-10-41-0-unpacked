package JsonModels.Response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ2\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\t\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"LJsonModels/Response/WalletTopUpResponseResult;", "", "message", "", "walletTransactionId", "walletTransactionStatus", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getMessage", "()Ljava/lang/String;", "getWalletTransactionId", "setWalletTransactionId", "(Ljava/lang/String;)V", "getWalletTransactionStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)LJsonModels/Response/WalletTopUpResponseResult;", "equals", "", "other", "hashCode", "toString", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTopUpResponseResult {
    @SerializedName("message")
    @Nullable
    private final String message;
    @SerializedName("walletTransactionId")
    @Nullable
    private String walletTransactionId;
    @SerializedName("walletTransactionStatus")
    @Nullable
    private final Integer walletTransactionStatus;

    public WalletTopUpResponseResult(@Nullable String str, @Nullable String str2, @Nullable Integer num) {
        this.message = str;
        this.walletTransactionId = str2;
        this.walletTransactionStatus = num;
    }

    public static /* synthetic */ WalletTopUpResponseResult copy$default(WalletTopUpResponseResult walletTopUpResponseResult, String str, String str2, Integer num, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = walletTopUpResponseResult.message;
        }
        if ((i11 & 2) != 0) {
            str2 = walletTopUpResponseResult.walletTransactionId;
        }
        if ((i11 & 4) != 0) {
            num = walletTopUpResponseResult.walletTransactionStatus;
        }
        return walletTopUpResponseResult.copy(str, str2, num);
    }

    @Nullable
    public final String component1() {
        return this.message;
    }

    @Nullable
    public final String component2() {
        return this.walletTransactionId;
    }

    @Nullable
    public final Integer component3() {
        return this.walletTransactionStatus;
    }

    @NotNull
    public final WalletTopUpResponseResult copy(@Nullable String str, @Nullable String str2, @Nullable Integer num) {
        return new WalletTopUpResponseResult(str, str2, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletTopUpResponseResult)) {
            return false;
        }
        WalletTopUpResponseResult walletTopUpResponseResult = (WalletTopUpResponseResult) obj;
        return Intrinsics.areEqual((Object) this.message, (Object) walletTopUpResponseResult.message) && Intrinsics.areEqual((Object) this.walletTransactionId, (Object) walletTopUpResponseResult.walletTransactionId) && Intrinsics.areEqual((Object) this.walletTransactionStatus, (Object) walletTopUpResponseResult.walletTransactionStatus);
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final String getWalletTransactionId() {
        return this.walletTransactionId;
    }

    @Nullable
    public final Integer getWalletTransactionStatus() {
        return this.walletTransactionStatus;
    }

    public int hashCode() {
        String str = this.message;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.walletTransactionId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.walletTransactionStatus;
        if (num != null) {
            i11 = num.hashCode();
        }
        return hashCode2 + i11;
    }

    public final void setWalletTransactionId(@Nullable String str) {
        this.walletTransactionId = str;
    }

    @NotNull
    public String toString() {
        String str = this.message;
        String str2 = this.walletTransactionId;
        Integer num = this.walletTransactionStatus;
        return "WalletTopUpResponseResult(message=" + str + ", walletTransactionId=" + str2 + ", walletTransactionStatus=" + num + ")";
    }
}
