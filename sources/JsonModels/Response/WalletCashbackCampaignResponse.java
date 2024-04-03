package JsonModels.Response;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"LJsonModels/Response/WalletCashbackCampaignResponse;", "", "result", "LJsonModels/Response/WalletCashbackCampaignResponseResult;", "responseMessages", "", "LJsonModels/Response/WalletErrorMessageModel;", "(LJsonModels/Response/WalletCashbackCampaignResponseResult;Ljava/util/List;)V", "getResponseMessages", "()Ljava/util/List;", "setResponseMessages", "(Ljava/util/List;)V", "getResult", "()LJsonModels/Response/WalletCashbackCampaignResponseResult;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCashbackCampaignResponse {
    @SerializedName("responseMessages")
    @Nullable
    private List<WalletErrorMessageModel> responseMessages;
    @SerializedName("result")
    @Nullable
    private final WalletCashbackCampaignResponseResult result;

    public WalletCashbackCampaignResponse(@Nullable WalletCashbackCampaignResponseResult walletCashbackCampaignResponseResult, @Nullable List<WalletErrorMessageModel> list) {
        this.result = walletCashbackCampaignResponseResult;
        this.responseMessages = list;
    }

    public static /* synthetic */ WalletCashbackCampaignResponse copy$default(WalletCashbackCampaignResponse walletCashbackCampaignResponse, WalletCashbackCampaignResponseResult walletCashbackCampaignResponseResult, List<WalletErrorMessageModel> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            walletCashbackCampaignResponseResult = walletCashbackCampaignResponse.result;
        }
        if ((i11 & 2) != 0) {
            list = walletCashbackCampaignResponse.responseMessages;
        }
        return walletCashbackCampaignResponse.copy(walletCashbackCampaignResponseResult, list);
    }

    @Nullable
    public final WalletCashbackCampaignResponseResult component1() {
        return this.result;
    }

    @Nullable
    public final List<WalletErrorMessageModel> component2() {
        return this.responseMessages;
    }

    @NotNull
    public final WalletCashbackCampaignResponse copy(@Nullable WalletCashbackCampaignResponseResult walletCashbackCampaignResponseResult, @Nullable List<WalletErrorMessageModel> list) {
        return new WalletCashbackCampaignResponse(walletCashbackCampaignResponseResult, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletCashbackCampaignResponse)) {
            return false;
        }
        WalletCashbackCampaignResponse walletCashbackCampaignResponse = (WalletCashbackCampaignResponse) obj;
        return Intrinsics.areEqual((Object) this.result, (Object) walletCashbackCampaignResponse.result) && Intrinsics.areEqual((Object) this.responseMessages, (Object) walletCashbackCampaignResponse.responseMessages);
    }

    @Nullable
    public final List<WalletErrorMessageModel> getResponseMessages() {
        return this.responseMessages;
    }

    @Nullable
    public final WalletCashbackCampaignResponseResult getResult() {
        return this.result;
    }

    public int hashCode() {
        WalletCashbackCampaignResponseResult walletCashbackCampaignResponseResult = this.result;
        int i11 = 0;
        int hashCode = (walletCashbackCampaignResponseResult == null ? 0 : walletCashbackCampaignResponseResult.hashCode()) * 31;
        List<WalletErrorMessageModel> list = this.responseMessages;
        if (list != null) {
            i11 = list.hashCode();
        }
        return hashCode + i11;
    }

    public final void setResponseMessages(@Nullable List<WalletErrorMessageModel> list) {
        this.responseMessages = list;
    }

    @NotNull
    public String toString() {
        WalletCashbackCampaignResponseResult walletCashbackCampaignResponseResult = this.result;
        List<WalletErrorMessageModel> list = this.responseMessages;
        return "WalletCashbackCampaignResponse(result=" + walletCashbackCampaignResponseResult + ", responseMessages=" + list + ")";
    }
}
