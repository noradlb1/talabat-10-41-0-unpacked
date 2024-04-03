package JsonModels.Response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"LJsonModels/Response/WalletTopUpResponse;", "", "result", "LJsonModels/Response/WalletTopUpResponseResult;", "responseMessages", "", "(LJsonModels/Response/WalletTopUpResponseResult;Ljava/lang/String;)V", "getResponseMessages", "()Ljava/lang/String;", "setResponseMessages", "(Ljava/lang/String;)V", "getResult", "()LJsonModels/Response/WalletTopUpResponseResult;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTopUpResponse {
    @SerializedName("responseMessages")
    @Nullable
    private String responseMessages;
    @SerializedName("result")
    @Nullable
    private final WalletTopUpResponseResult result;

    public WalletTopUpResponse(@Nullable WalletTopUpResponseResult walletTopUpResponseResult, @Nullable String str) {
        this.result = walletTopUpResponseResult;
        this.responseMessages = str;
    }

    public static /* synthetic */ WalletTopUpResponse copy$default(WalletTopUpResponse walletTopUpResponse, WalletTopUpResponseResult walletTopUpResponseResult, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            walletTopUpResponseResult = walletTopUpResponse.result;
        }
        if ((i11 & 2) != 0) {
            str = walletTopUpResponse.responseMessages;
        }
        return walletTopUpResponse.copy(walletTopUpResponseResult, str);
    }

    @Nullable
    public final WalletTopUpResponseResult component1() {
        return this.result;
    }

    @Nullable
    public final String component2() {
        return this.responseMessages;
    }

    @NotNull
    public final WalletTopUpResponse copy(@Nullable WalletTopUpResponseResult walletTopUpResponseResult, @Nullable String str) {
        return new WalletTopUpResponse(walletTopUpResponseResult, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletTopUpResponse)) {
            return false;
        }
        WalletTopUpResponse walletTopUpResponse = (WalletTopUpResponse) obj;
        return Intrinsics.areEqual((Object) this.result, (Object) walletTopUpResponse.result) && Intrinsics.areEqual((Object) this.responseMessages, (Object) walletTopUpResponse.responseMessages);
    }

    @Nullable
    public final String getResponseMessages() {
        return this.responseMessages;
    }

    @Nullable
    public final WalletTopUpResponseResult getResult() {
        return this.result;
    }

    public int hashCode() {
        WalletTopUpResponseResult walletTopUpResponseResult = this.result;
        int i11 = 0;
        int hashCode = (walletTopUpResponseResult == null ? 0 : walletTopUpResponseResult.hashCode()) * 31;
        String str = this.responseMessages;
        if (str != null) {
            i11 = str.hashCode();
        }
        return hashCode + i11;
    }

    public final void setResponseMessages(@Nullable String str) {
        this.responseMessages = str;
    }

    @NotNull
    public String toString() {
        WalletTopUpResponseResult walletTopUpResponseResult = this.result;
        String str = this.responseMessages;
        return "WalletTopUpResponse(result=" + walletTopUpResponseResult + ", responseMessages=" + str + ")";
    }
}
