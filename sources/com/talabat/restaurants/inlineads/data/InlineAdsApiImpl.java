package com.talabat.restaurants.inlineads.data;

import com.talabat.core.network.network.TalabatAPIBuilder;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/restaurants/inlineads/data/InlineAdsApiImpl;", "Lcom/talabat/restaurants/inlineads/data/InlineAdsApi;", "talabatAPIBuilder", "Lcom/talabat/core/network/network/TalabatAPIBuilder;", "(Lcom/talabat/core/network/network/TalabatAPIBuilder;)V", "getInlineAds", "Lio/reactivex/Single;", "Lcom/talabat/restaurants/inlineads/data/InLineAdsResponse;", "countryId", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InlineAdsApiImpl implements InlineAdsApi {
    @NotNull
    private final TalabatAPIBuilder talabatAPIBuilder;

    public InlineAdsApiImpl() {
        this((TalabatAPIBuilder) null, 1, (DefaultConstructorMarker) null);
    }

    public InlineAdsApiImpl(@NotNull TalabatAPIBuilder talabatAPIBuilder2) {
        Intrinsics.checkNotNullParameter(talabatAPIBuilder2, "talabatAPIBuilder");
        this.talabatAPIBuilder = talabatAPIBuilder2;
    }

    @NotNull
    public Single<InLineAdsResponse> getInlineAds(int i11) {
        return ((InlineAdsApi) this.talabatAPIBuilder.createApi(InlineAdsUrlConstants.INSTANCE.getBaseUrl(), InlineAdsApi.class)).getInlineAds(i11);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InlineAdsApiImpl(TalabatAPIBuilder talabatAPIBuilder2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new TalabatAPIBuilder() : talabatAPIBuilder2);
    }
}
