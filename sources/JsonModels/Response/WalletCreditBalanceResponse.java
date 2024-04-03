package JsonModels.Response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"LJsonModels/Response/WalletCreditBalanceResponse;", "", "result", "LJsonModels/Response/WalletCreditBalanceResultModel;", "(LJsonModels/Response/WalletCreditBalanceResultModel;)V", "getResult", "()LJsonModels/Response/WalletCreditBalanceResultModel;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCreditBalanceResponse {
    @SerializedName("result")
    @Nullable
    private final WalletCreditBalanceResultModel result;

    public WalletCreditBalanceResponse(@Nullable WalletCreditBalanceResultModel walletCreditBalanceResultModel) {
        this.result = walletCreditBalanceResultModel;
    }

    public static /* synthetic */ WalletCreditBalanceResponse copy$default(WalletCreditBalanceResponse walletCreditBalanceResponse, WalletCreditBalanceResultModel walletCreditBalanceResultModel, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            walletCreditBalanceResultModel = walletCreditBalanceResponse.result;
        }
        return walletCreditBalanceResponse.copy(walletCreditBalanceResultModel);
    }

    @Nullable
    public final WalletCreditBalanceResultModel component1() {
        return this.result;
    }

    @NotNull
    public final WalletCreditBalanceResponse copy(@Nullable WalletCreditBalanceResultModel walletCreditBalanceResultModel) {
        return new WalletCreditBalanceResponse(walletCreditBalanceResultModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof WalletCreditBalanceResponse) && Intrinsics.areEqual((Object) this.result, (Object) ((WalletCreditBalanceResponse) obj).result);
    }

    @Nullable
    public final WalletCreditBalanceResultModel getResult() {
        return this.result;
    }

    public int hashCode() {
        WalletCreditBalanceResultModel walletCreditBalanceResultModel = this.result;
        if (walletCreditBalanceResultModel == null) {
            return 0;
        }
        return walletCreditBalanceResultModel.hashCode();
    }

    @NotNull
    public String toString() {
        WalletCreditBalanceResultModel walletCreditBalanceResultModel = this.result;
        return "WalletCreditBalanceResponse(result=" + walletCreditBalanceResultModel + ")";
    }
}
