package com.talabat.feature.tmart.growth.data.remote.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import com.talabat.talabatcommon.feature.vouchers.loyalty.VoucherUrlConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthClaimRequest;", "", "voucherId", "", "(Ljava/lang/String;)V", "getVoucherId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TMartGrowthClaimRequest {
    @NotNull
    private final String voucherId;

    public TMartGrowthClaimRequest(@NotNull @Json(name = "voucher_option_id") String str) {
        Intrinsics.checkNotNullParameter(str, VoucherUrlConstantsKt.PATH_VOUCHER_ID);
        this.voucherId = str;
    }

    public static /* synthetic */ TMartGrowthClaimRequest copy$default(TMartGrowthClaimRequest tMartGrowthClaimRequest, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = tMartGrowthClaimRequest.voucherId;
        }
        return tMartGrowthClaimRequest.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.voucherId;
    }

    @NotNull
    public final TMartGrowthClaimRequest copy(@NotNull @Json(name = "voucher_option_id") String str) {
        Intrinsics.checkNotNullParameter(str, VoucherUrlConstantsKt.PATH_VOUCHER_ID);
        return new TMartGrowthClaimRequest(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TMartGrowthClaimRequest) && Intrinsics.areEqual((Object) this.voucherId, (Object) ((TMartGrowthClaimRequest) obj).voucherId);
    }

    @NotNull
    public final String getVoucherId() {
        return this.voucherId;
    }

    public int hashCode() {
        return this.voucherId.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.voucherId;
        return "TMartGrowthClaimRequest(voucherId=" + str + ")";
    }
}
