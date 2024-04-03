package com.talabat.feature.rating.domain.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/rating/domain/model/GetPastOrdersRequestParams;", "", "countryId", "", "(I)V", "getCountryId", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "com_talabat_feature_rating_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetPastOrdersRequestParams {
    private final int countryId;

    public GetPastOrdersRequestParams(int i11) {
        this.countryId = i11;
    }

    public static /* synthetic */ GetPastOrdersRequestParams copy$default(GetPastOrdersRequestParams getPastOrdersRequestParams, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = getPastOrdersRequestParams.countryId;
        }
        return getPastOrdersRequestParams.copy(i11);
    }

    public final int component1() {
        return this.countryId;
    }

    @NotNull
    public final GetPastOrdersRequestParams copy(int i11) {
        return new GetPastOrdersRequestParams(i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GetPastOrdersRequestParams) && this.countryId == ((GetPastOrdersRequestParams) obj).countryId;
    }

    public final int getCountryId() {
        return this.countryId;
    }

    public int hashCode() {
        return this.countryId;
    }

    @NotNull
    public String toString() {
        int i11 = this.countryId;
        return "GetPastOrdersRequestParams(countryId=" + i11 + ")";
    }
}
