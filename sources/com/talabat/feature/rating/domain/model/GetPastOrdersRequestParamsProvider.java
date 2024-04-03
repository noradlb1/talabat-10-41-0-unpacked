package com.talabat.feature.rating.domain.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/talabat/feature/rating/domain/model/GetPastOrdersRequestParamsProvider;", "", "countryCode", "", "(I)V", "getCountryCode", "()I", "getPastOrdersRequestParams", "Lcom/talabat/feature/rating/domain/model/GetPastOrdersRequestParams;", "com_talabat_feature_rating_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetPastOrdersRequestParamsProvider {
    private final int countryCode;

    public GetPastOrdersRequestParamsProvider(int i11) {
        this.countryCode = i11;
    }

    public final int getCountryCode() {
        return this.countryCode;
    }

    @NotNull
    public final GetPastOrdersRequestParams getPastOrdersRequestParams() {
        return new GetPastOrdersRequestParams(this.countryCode);
    }
}
