package JsonModels.Response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"LJsonModels/Response/WalletCashbackCampaignOfferMessageResponseResult;", "", "adTextMessage", "", "(Ljava/lang/String;)V", "getAdTextMessage", "()Ljava/lang/String;", "setAdTextMessage", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCashbackCampaignOfferMessageResponseResult {
    @SerializedName("adText")
    @Nullable
    private String adTextMessage;

    public WalletCashbackCampaignOfferMessageResponseResult() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public WalletCashbackCampaignOfferMessageResponseResult(@Nullable String str) {
        this.adTextMessage = str;
    }

    @Nullable
    public final String getAdTextMessage() {
        return this.adTextMessage;
    }

    public final void setAdTextMessage(@Nullable String str) {
        this.adTextMessage = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletCashbackCampaignOfferMessageResponseResult(String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str);
    }
}
