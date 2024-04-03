package com.talabat.growth.features.matketPlace;

import com.talabat.growth.features.matketPlace.model.response.BurnOptionCategoryDetailResponse;
import com.talabat.growth.features.matketPlace.model.response.BurnOptionCategoryResponse;
import com.talabat.growth.features.matketPlace.model.response.MarketPlaceBurnOptionCategory;
import com.talabat.growth.ui.loyalty.burn.models.BurnItemCategoryDisplayModel;
import com.talabat.growth.ui.loyalty.burn.models.BurnOptionsMapper;
import com.talabat.talabatcommon.extentions.SafeLetKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemCategoryDisplayModel;", "burnOptionCategoryResponse", "Lcom/talabat/growth/features/matketPlace/model/response/BurnOptionCategoryResponse;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GetBurnCategoryDetails$run$2 extends Lambda implements Function1<BurnOptionCategoryResponse, BurnItemCategoryDisplayModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GetBurnCategoryDetails f60570g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetBurnCategoryDetails$run$2(GetBurnCategoryDetails getBurnCategoryDetails) {
        super(1);
        this.f60570g = getBurnCategoryDetails;
    }

    @NotNull
    public final BurnItemCategoryDisplayModel invoke(@NotNull BurnOptionCategoryResponse burnOptionCategoryResponse) {
        Intrinsics.checkNotNullParameter(burnOptionCategoryResponse, "burnOptionCategoryResponse");
        Object result = burnOptionCategoryResponse.getResult();
        BurnOptionCategoryDetailResponse burnOptionCategoryDetailResponse = (BurnOptionCategoryDetailResponse) burnOptionCategoryResponse.getResult();
        MarketPlaceBurnOptionCategory burnCategory = burnOptionCategoryDetailResponse != null ? burnOptionCategoryDetailResponse.getBurnCategory() : null;
        final GetBurnCategoryDetails getBurnCategoryDetails = this.f60570g;
        BurnItemCategoryDisplayModel burnItemCategoryDisplayModel = (BurnItemCategoryDisplayModel) SafeLetKt.safeLet(result, burnCategory, new Function2<BurnOptionCategoryDetailResponse, MarketPlaceBurnOptionCategory, BurnItemCategoryDisplayModel>() {
            @Nullable
            public final BurnItemCategoryDisplayModel invoke(@NotNull BurnOptionCategoryDetailResponse burnOptionCategoryDetailResponse, @NotNull MarketPlaceBurnOptionCategory marketPlaceBurnOptionCategory) {
                Intrinsics.checkNotNullParameter(burnOptionCategoryDetailResponse, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(marketPlaceBurnOptionCategory, "category");
                return BurnOptionsMapper.INSTANCE.mapMarketPlaceBurnOptionCategory(marketPlaceBurnOptionCategory, getBurnCategoryDetails.locationConfigurationRepository);
            }
        });
        return burnItemCategoryDisplayModel == null ? new BurnItemCategoryDisplayModel() : burnItemCategoryDisplayModel;
    }
}
