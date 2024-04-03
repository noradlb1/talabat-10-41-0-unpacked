package com.talabat.growth.features.matketPlace;

import com.talabat.growth.features.matketPlace.model.response.MarketPlaceBurnListResponse;
import com.talabat.growth.features.matketPlace.model.response.MarketPlaceBurnOptionsResponse;
import com.talabat.growth.ui.loyalty.burn.models.BurnListDisplayModel;
import com.talabat.growth.ui.loyalty.burn.models.BurnOptionsMapper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnListDisplayModel;", "it", "Lcom/talabat/growth/features/matketPlace/model/response/MarketPlaceBurnOptionsResponse;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GetMarketPlaceItems$run$2 extends Lambda implements Function1<MarketPlaceBurnOptionsResponse, BurnListDisplayModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GetMarketPlaceItems f60573g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetMarketPlaceItems$run$2(GetMarketPlaceItems getMarketPlaceItems) {
        super(1);
        this.f60573g = getMarketPlaceItems;
    }

    @NotNull
    public final BurnListDisplayModel invoke(@NotNull MarketPlaceBurnOptionsResponse marketPlaceBurnOptionsResponse) {
        Intrinsics.checkNotNullParameter(marketPlaceBurnOptionsResponse, "it");
        return BurnOptionsMapper.INSTANCE.map((MarketPlaceBurnListResponse) marketPlaceBurnOptionsResponse.getResult(), this.f60573g.locationConfigurationRepository);
    }
}
