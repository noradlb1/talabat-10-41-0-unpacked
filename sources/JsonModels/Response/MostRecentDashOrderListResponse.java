package JsonModels.Response;

import com.google.gson.annotations.SerializedName;
import com.talabat.helpers.AppUrls;
import datamodels.MostRecentOrderList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J6\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"LJsonModels/Response/MostRecentDashOrderListResponse;", "", "orders", "", "Ldatamodels/MostRecentOrderList;", "baseUrl", "", "timestamp", "([Ldatamodels/MostRecentOrderList;Ljava/lang/String;Ljava/lang/String;)V", "getBaseUrl", "()Ljava/lang/String;", "getOrders", "()[Ldatamodels/MostRecentOrderList;", "[Ldatamodels/MostRecentOrderList;", "getTimestamp", "component1", "component2", "component3", "copy", "([Ldatamodels/MostRecentOrderList;Ljava/lang/String;Ljava/lang/String;)LJsonModels/Response/MostRecentDashOrderListResponse;", "equals", "", "other", "hashCode", "", "toString", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MostRecentDashOrderListResponse {
    @Nullable
    private final String baseUrl;
    @SerializedName("Orders")
    @NotNull
    private final MostRecentOrderList[] orders;
    @Nullable
    private final String timestamp;

    public MostRecentDashOrderListResponse(@NotNull MostRecentOrderList[] mostRecentOrderListArr, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(mostRecentOrderListArr, AppUrls.PLACEORDER_SEGMENT);
        this.orders = mostRecentOrderListArr;
        this.baseUrl = str;
        this.timestamp = str2;
    }

    public static /* synthetic */ MostRecentDashOrderListResponse copy$default(MostRecentDashOrderListResponse mostRecentDashOrderListResponse, MostRecentOrderList[] mostRecentOrderListArr, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            mostRecentOrderListArr = mostRecentDashOrderListResponse.orders;
        }
        if ((i11 & 2) != 0) {
            str = mostRecentDashOrderListResponse.baseUrl;
        }
        if ((i11 & 4) != 0) {
            str2 = mostRecentDashOrderListResponse.timestamp;
        }
        return mostRecentDashOrderListResponse.copy(mostRecentOrderListArr, str, str2);
    }

    @NotNull
    public final MostRecentOrderList[] component1() {
        return this.orders;
    }

    @Nullable
    public final String component2() {
        return this.baseUrl;
    }

    @Nullable
    public final String component3() {
        return this.timestamp;
    }

    @NotNull
    public final MostRecentDashOrderListResponse copy(@NotNull MostRecentOrderList[] mostRecentOrderListArr, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(mostRecentOrderListArr, AppUrls.PLACEORDER_SEGMENT);
        return new MostRecentDashOrderListResponse(mostRecentOrderListArr, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MostRecentDashOrderListResponse)) {
            return false;
        }
        MostRecentDashOrderListResponse mostRecentDashOrderListResponse = (MostRecentDashOrderListResponse) obj;
        return Intrinsics.areEqual((Object) this.orders, (Object) mostRecentDashOrderListResponse.orders) && Intrinsics.areEqual((Object) this.baseUrl, (Object) mostRecentDashOrderListResponse.baseUrl) && Intrinsics.areEqual((Object) this.timestamp, (Object) mostRecentDashOrderListResponse.timestamp);
    }

    @Nullable
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    @NotNull
    public final MostRecentOrderList[] getOrders() {
        return this.orders;
    }

    @Nullable
    public final String getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        int hashCode = Arrays.hashCode(this.orders) * 31;
        String str = this.baseUrl;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.timestamp;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        String arrays = Arrays.toString(this.orders);
        String str = this.baseUrl;
        String str2 = this.timestamp;
        return "MostRecentDashOrderListResponse(orders=" + arrays + ", baseUrl=" + str + ", timestamp=" + str2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MostRecentDashOrderListResponse(MostRecentOrderList[] mostRecentOrderListArr, String str, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(mostRecentOrderListArr, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : str2);
    }
}
