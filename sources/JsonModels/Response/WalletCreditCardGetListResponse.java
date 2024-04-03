package JsonModels.Response;

import JsonModels.Response.WalletCreditCardGetListDataItem;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B3\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\nJ\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J?\u0010\u0016\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001d"}, d2 = {"LJsonModels/Response/WalletCreditCardGetListResponse;", "", "result", "", "LJsonModels/Response/WalletCreditCardGetListDataItem$WalletCreditCardGetListResponseResult;", "timestamp", "", "meta", "LJsonModels/Response/WalletCreditCardMetadataObject;", "baseUrl", "(Ljava/util/List;Ljava/lang/String;LJsonModels/Response/WalletCreditCardMetadataObject;Ljava/lang/String;)V", "getBaseUrl", "()Ljava/lang/String;", "getMeta", "()LJsonModels/Response/WalletCreditCardMetadataObject;", "getResult", "()Ljava/util/List;", "getTimestamp", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCreditCardGetListResponse {
    @SerializedName("baseUrl")
    @Nullable
    private final String baseUrl;
    @SerializedName("meta")
    @Nullable
    private final WalletCreditCardMetadataObject meta;
    @SerializedName("result")
    @Nullable
    private final List<WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult> result;
    @SerializedName("timestamp")
    @Nullable
    private final String timestamp;

    public WalletCreditCardGetListResponse(@Nullable List<WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult> list, @Nullable String str, @Nullable WalletCreditCardMetadataObject walletCreditCardMetadataObject, @Nullable String str2) {
        this.result = list;
        this.timestamp = str;
        this.meta = walletCreditCardMetadataObject;
        this.baseUrl = str2;
    }

    public static /* synthetic */ WalletCreditCardGetListResponse copy$default(WalletCreditCardGetListResponse walletCreditCardGetListResponse, List<WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult> list, String str, WalletCreditCardMetadataObject walletCreditCardMetadataObject, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = walletCreditCardGetListResponse.result;
        }
        if ((i11 & 2) != 0) {
            str = walletCreditCardGetListResponse.timestamp;
        }
        if ((i11 & 4) != 0) {
            walletCreditCardMetadataObject = walletCreditCardGetListResponse.meta;
        }
        if ((i11 & 8) != 0) {
            str2 = walletCreditCardGetListResponse.baseUrl;
        }
        return walletCreditCardGetListResponse.copy(list, str, walletCreditCardMetadataObject, str2);
    }

    @Nullable
    public final List<WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult> component1() {
        return this.result;
    }

    @Nullable
    public final String component2() {
        return this.timestamp;
    }

    @Nullable
    public final WalletCreditCardMetadataObject component3() {
        return this.meta;
    }

    @Nullable
    public final String component4() {
        return this.baseUrl;
    }

    @NotNull
    public final WalletCreditCardGetListResponse copy(@Nullable List<WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult> list, @Nullable String str, @Nullable WalletCreditCardMetadataObject walletCreditCardMetadataObject, @Nullable String str2) {
        return new WalletCreditCardGetListResponse(list, str, walletCreditCardMetadataObject, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletCreditCardGetListResponse)) {
            return false;
        }
        WalletCreditCardGetListResponse walletCreditCardGetListResponse = (WalletCreditCardGetListResponse) obj;
        return Intrinsics.areEqual((Object) this.result, (Object) walletCreditCardGetListResponse.result) && Intrinsics.areEqual((Object) this.timestamp, (Object) walletCreditCardGetListResponse.timestamp) && Intrinsics.areEqual((Object) this.meta, (Object) walletCreditCardGetListResponse.meta) && Intrinsics.areEqual((Object) this.baseUrl, (Object) walletCreditCardGetListResponse.baseUrl);
    }

    @Nullable
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    @Nullable
    public final WalletCreditCardMetadataObject getMeta() {
        return this.meta;
    }

    @Nullable
    public final List<WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult> getResult() {
        return this.result;
    }

    @Nullable
    public final String getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        List<WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult> list = this.result;
        int i11 = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.timestamp;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        WalletCreditCardMetadataObject walletCreditCardMetadataObject = this.meta;
        int hashCode3 = (hashCode2 + (walletCreditCardMetadataObject == null ? 0 : walletCreditCardMetadataObject.hashCode())) * 31;
        String str2 = this.baseUrl;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode3 + i11;
    }

    @NotNull
    public String toString() {
        List<WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult> list = this.result;
        String str = this.timestamp;
        WalletCreditCardMetadataObject walletCreditCardMetadataObject = this.meta;
        String str2 = this.baseUrl;
        return "WalletCreditCardGetListResponse(result=" + list + ", timestamp=" + str + ", meta=" + walletCreditCardMetadataObject + ", baseUrl=" + str2 + ")";
    }
}
