package com.talabat.talabatcommon.feature.vouchers.monolith.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/monolith/model/response/VoucherItemsRootResponse;", "", "timestamp", "", "result", "Lcom/talabat/talabatcommon/feature/vouchers/monolith/model/response/VoucherItemsResultResponse;", "baseUrl", "(Ljava/lang/String;Lcom/talabat/talabatcommon/feature/vouchers/monolith/model/response/VoucherItemsResultResponse;Ljava/lang/String;)V", "getBaseUrl", "()Ljava/lang/String;", "getResult", "()Lcom/talabat/talabatcommon/feature/vouchers/monolith/model/response/VoucherItemsResultResponse;", "getTimestamp", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoucherItemsRootResponse {
    @SerializedName("baseUrl")
    @NotNull
    private final String baseUrl;
    @SerializedName("result")
    @NotNull
    private final VoucherItemsResultResponse result;
    @SerializedName("timestamp")
    @NotNull
    private final String timestamp;

    public VoucherItemsRootResponse() {
        this((String) null, (VoucherItemsResultResponse) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public VoucherItemsRootResponse(@NotNull String str, @NotNull VoucherItemsResultResponse voucherItemsResultResponse, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "timestamp");
        Intrinsics.checkNotNullParameter(voucherItemsResultResponse, "result");
        Intrinsics.checkNotNullParameter(str2, "baseUrl");
        this.timestamp = str;
        this.result = voucherItemsResultResponse;
        this.baseUrl = str2;
    }

    public static /* synthetic */ VoucherItemsRootResponse copy$default(VoucherItemsRootResponse voucherItemsRootResponse, String str, VoucherItemsResultResponse voucherItemsResultResponse, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = voucherItemsRootResponse.timestamp;
        }
        if ((i11 & 2) != 0) {
            voucherItemsResultResponse = voucherItemsRootResponse.result;
        }
        if ((i11 & 4) != 0) {
            str2 = voucherItemsRootResponse.baseUrl;
        }
        return voucherItemsRootResponse.copy(str, voucherItemsResultResponse, str2);
    }

    @NotNull
    public final String component1() {
        return this.timestamp;
    }

    @NotNull
    public final VoucherItemsResultResponse component2() {
        return this.result;
    }

    @NotNull
    public final String component3() {
        return this.baseUrl;
    }

    @NotNull
    public final VoucherItemsRootResponse copy(@NotNull String str, @NotNull VoucherItemsResultResponse voucherItemsResultResponse, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "timestamp");
        Intrinsics.checkNotNullParameter(voucherItemsResultResponse, "result");
        Intrinsics.checkNotNullParameter(str2, "baseUrl");
        return new VoucherItemsRootResponse(str, voucherItemsResultResponse, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VoucherItemsRootResponse)) {
            return false;
        }
        VoucherItemsRootResponse voucherItemsRootResponse = (VoucherItemsRootResponse) obj;
        return Intrinsics.areEqual((Object) this.timestamp, (Object) voucherItemsRootResponse.timestamp) && Intrinsics.areEqual((Object) this.result, (Object) voucherItemsRootResponse.result) && Intrinsics.areEqual((Object) this.baseUrl, (Object) voucherItemsRootResponse.baseUrl);
    }

    @NotNull
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    @NotNull
    public final VoucherItemsResultResponse getResult() {
        return this.result;
    }

    @NotNull
    public final String getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return (((this.timestamp.hashCode() * 31) + this.result.hashCode()) * 31) + this.baseUrl.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.timestamp;
        VoucherItemsResultResponse voucherItemsResultResponse = this.result;
        String str2 = this.baseUrl;
        return "VoucherItemsRootResponse(timestamp=" + str + ", result=" + voucherItemsResultResponse + ", baseUrl=" + str2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VoucherItemsRootResponse(String str, VoucherItemsResultResponse voucherItemsResultResponse, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? new VoucherItemsResultResponse(0, (String) null, (String) null, 0.0f, (String) null, 31, (DefaultConstructorMarker) null) : voucherItemsResultResponse, (i11 & 4) != 0 ? "" : str2);
    }
}
