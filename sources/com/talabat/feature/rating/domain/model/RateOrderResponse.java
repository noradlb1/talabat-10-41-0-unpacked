package com.talabat.feature.rating.domain.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/talabat/feature/rating/domain/model/RateOrderResponse;", "", "hasError", "", "data", "Lcom/talabat/feature/rating/domain/model/Data;", "(ZLcom/talabat/feature/rating/domain/model/Data;)V", "getData", "()Lcom/talabat/feature/rating/domain/model/Data;", "getHasError", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "com_talabat_feature_rating_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RateOrderResponse {
    @SerializedName("result")
    @NotNull
    private final Data data;
    @SerializedName("haserror")
    private final boolean hasError;

    public RateOrderResponse(boolean z11, @NotNull Data data2) {
        Intrinsics.checkNotNullParameter(data2, "data");
        this.hasError = z11;
        this.data = data2;
    }

    public static /* synthetic */ RateOrderResponse copy$default(RateOrderResponse rateOrderResponse, boolean z11, Data data2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = rateOrderResponse.hasError;
        }
        if ((i11 & 2) != 0) {
            data2 = rateOrderResponse.data;
        }
        return rateOrderResponse.copy(z11, data2);
    }

    public final boolean component1() {
        return this.hasError;
    }

    @NotNull
    public final Data component2() {
        return this.data;
    }

    @NotNull
    public final RateOrderResponse copy(boolean z11, @NotNull Data data2) {
        Intrinsics.checkNotNullParameter(data2, "data");
        return new RateOrderResponse(z11, data2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RateOrderResponse)) {
            return false;
        }
        RateOrderResponse rateOrderResponse = (RateOrderResponse) obj;
        return this.hasError == rateOrderResponse.hasError && Intrinsics.areEqual((Object) this.data, (Object) rateOrderResponse.data);
    }

    @NotNull
    public final Data getData() {
        return this.data;
    }

    public final boolean getHasError() {
        return this.hasError;
    }

    public int hashCode() {
        boolean z11 = this.hasError;
        if (z11) {
            z11 = true;
        }
        return ((z11 ? 1 : 0) * true) + this.data.hashCode();
    }

    @NotNull
    public String toString() {
        boolean z11 = this.hasError;
        Data data2 = this.data;
        return "RateOrderResponse(hasError=" + z11 + ", data=" + data2 + ")";
    }
}
