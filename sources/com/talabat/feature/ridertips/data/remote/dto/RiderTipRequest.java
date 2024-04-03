package com.talabat.feature.ridertips.data.remote.dto;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0005HÆ\u0003J$\u0010\u000e\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/ridertips/data/remote/dto/RiderTipRequest;", "", "amount", "", "removeTip", "", "(Ljava/lang/Double;Z)V", "getAmount", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getRemoveTip", "()Z", "component1", "component2", "copy", "(Ljava/lang/Double;Z)Lcom/talabat/feature/ridertips/data/remote/dto/RiderTipRequest;", "equals", "other", "hashCode", "", "toString", "", "com_talabat_feature_ridertips_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RiderTipRequest {
    @Nullable
    private final Double amount;
    private final boolean removeTip;

    public RiderTipRequest(@Nullable @Json(name = "amount") Double d11, @Json(name = "remove_tip") boolean z11) {
        this.amount = d11;
        this.removeTip = z11;
    }

    public static /* synthetic */ RiderTipRequest copy$default(RiderTipRequest riderTipRequest, Double d11, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            d11 = riderTipRequest.amount;
        }
        if ((i11 & 2) != 0) {
            z11 = riderTipRequest.removeTip;
        }
        return riderTipRequest.copy(d11, z11);
    }

    @Nullable
    public final Double component1() {
        return this.amount;
    }

    public final boolean component2() {
        return this.removeTip;
    }

    @NotNull
    public final RiderTipRequest copy(@Nullable @Json(name = "amount") Double d11, @Json(name = "remove_tip") boolean z11) {
        return new RiderTipRequest(d11, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RiderTipRequest)) {
            return false;
        }
        RiderTipRequest riderTipRequest = (RiderTipRequest) obj;
        return Intrinsics.areEqual((Object) this.amount, (Object) riderTipRequest.amount) && this.removeTip == riderTipRequest.removeTip;
    }

    @Nullable
    public final Double getAmount() {
        return this.amount;
    }

    public final boolean getRemoveTip() {
        return this.removeTip;
    }

    public int hashCode() {
        Double d11 = this.amount;
        int hashCode = (d11 == null ? 0 : d11.hashCode()) * 31;
        boolean z11 = this.removeTip;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        Double d11 = this.amount;
        boolean z11 = this.removeTip;
        return "RiderTipRequest(amount=" + d11 + ", removeTip=" + z11 + ")";
    }
}
