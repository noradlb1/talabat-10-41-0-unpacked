package com.talabat.growth.features.loyalty;

import com.talabat.growth.features.loyalty.models.responses.LoyaltyPointsResponseModel;
import com.talabat.growth.features.loyalty.models.responses.LoyaltySummaryResponseModel;
import com.talabat.growth.ui.loyalty.models.LoyaltyPointsDisplayModel;
import com.talabat.growth.ui.loyalty.models.LoyaltyPointsMapper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/talabat/growth/ui/loyalty/models/LoyaltyPointsDisplayModel;", "it", "Lcom/talabat/growth/features/loyalty/models/responses/LoyaltySummaryResponseModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GetPointsSummary$run$2 extends Lambda implements Function1<LoyaltySummaryResponseModel, LoyaltyPointsDisplayModel> {
    public static final GetPointsSummary$run$2 INSTANCE = new GetPointsSummary$run$2();

    public GetPointsSummary$run$2() {
        super(1);
    }

    @NotNull
    public final LoyaltyPointsDisplayModel invoke(@NotNull LoyaltySummaryResponseModel loyaltySummaryResponseModel) {
        Intrinsics.checkNotNullParameter(loyaltySummaryResponseModel, "it");
        return LoyaltyPointsMapper.Companion.mapToLoyaltyPointsDisplayModel((LoyaltyPointsResponseModel) loyaltySummaryResponseModel.getResult());
    }
}
