package JsonModels.Response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\t¨\u0006\u0019"}, d2 = {"LJsonModels/Response/WalletSetDefaultCreditCardResponse;", "", "timestamp", "", "result", "LJsonModels/Response/WalletSetDefaultCreditCardsResponseResult;", "baseUrl", "(Ljava/lang/String;LJsonModels/Response/WalletSetDefaultCreditCardsResponseResult;Ljava/lang/String;)V", "getBaseUrl", "()Ljava/lang/String;", "getResult", "()LJsonModels/Response/WalletSetDefaultCreditCardsResponseResult;", "setResult", "(LJsonModels/Response/WalletSetDefaultCreditCardsResponseResult;)V", "getTimestamp", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletSetDefaultCreditCardResponse {
    @SerializedName("baseUrl")
    @Nullable
    private final String baseUrl;
    @SerializedName("result")
    @Nullable
    private WalletSetDefaultCreditCardsResponseResult result;
    @SerializedName("timestamp")
    @Nullable
    private final String timestamp;

    public WalletSetDefaultCreditCardResponse(@Nullable String str, @Nullable WalletSetDefaultCreditCardsResponseResult walletSetDefaultCreditCardsResponseResult, @Nullable String str2) {
        this.timestamp = str;
        this.result = walletSetDefaultCreditCardsResponseResult;
        this.baseUrl = str2;
    }

    public static /* synthetic */ WalletSetDefaultCreditCardResponse copy$default(WalletSetDefaultCreditCardResponse walletSetDefaultCreditCardResponse, String str, WalletSetDefaultCreditCardsResponseResult walletSetDefaultCreditCardsResponseResult, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = walletSetDefaultCreditCardResponse.timestamp;
        }
        if ((i11 & 2) != 0) {
            walletSetDefaultCreditCardsResponseResult = walletSetDefaultCreditCardResponse.result;
        }
        if ((i11 & 4) != 0) {
            str2 = walletSetDefaultCreditCardResponse.baseUrl;
        }
        return walletSetDefaultCreditCardResponse.copy(str, walletSetDefaultCreditCardsResponseResult, str2);
    }

    @Nullable
    public final String component1() {
        return this.timestamp;
    }

    @Nullable
    public final WalletSetDefaultCreditCardsResponseResult component2() {
        return this.result;
    }

    @Nullable
    public final String component3() {
        return this.baseUrl;
    }

    @NotNull
    public final WalletSetDefaultCreditCardResponse copy(@Nullable String str, @Nullable WalletSetDefaultCreditCardsResponseResult walletSetDefaultCreditCardsResponseResult, @Nullable String str2) {
        return new WalletSetDefaultCreditCardResponse(str, walletSetDefaultCreditCardsResponseResult, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletSetDefaultCreditCardResponse)) {
            return false;
        }
        WalletSetDefaultCreditCardResponse walletSetDefaultCreditCardResponse = (WalletSetDefaultCreditCardResponse) obj;
        return Intrinsics.areEqual((Object) this.timestamp, (Object) walletSetDefaultCreditCardResponse.timestamp) && Intrinsics.areEqual((Object) this.result, (Object) walletSetDefaultCreditCardResponse.result) && Intrinsics.areEqual((Object) this.baseUrl, (Object) walletSetDefaultCreditCardResponse.baseUrl);
    }

    @Nullable
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    @Nullable
    public final WalletSetDefaultCreditCardsResponseResult getResult() {
        return this.result;
    }

    @Nullable
    public final String getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        String str = this.timestamp;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        WalletSetDefaultCreditCardsResponseResult walletSetDefaultCreditCardsResponseResult = this.result;
        int hashCode2 = (hashCode + (walletSetDefaultCreditCardsResponseResult == null ? 0 : walletSetDefaultCreditCardsResponseResult.hashCode())) * 31;
        String str2 = this.baseUrl;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode2 + i11;
    }

    public final void setResult(@Nullable WalletSetDefaultCreditCardsResponseResult walletSetDefaultCreditCardsResponseResult) {
        this.result = walletSetDefaultCreditCardsResponseResult;
    }

    @NotNull
    public String toString() {
        String str = this.timestamp;
        WalletSetDefaultCreditCardsResponseResult walletSetDefaultCreditCardsResponseResult = this.result;
        String str2 = this.baseUrl;
        return "WalletSetDefaultCreditCardResponse(timestamp=" + str + ", result=" + walletSetDefaultCreditCardsResponseResult + ", baseUrl=" + str2 + ")";
    }
}
