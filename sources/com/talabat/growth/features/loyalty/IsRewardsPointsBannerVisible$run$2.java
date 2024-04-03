package com.talabat.growth.features.loyalty;

import com.talabat.growth.features.loyalty.models.responses.RewardsPointsBannerModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/talabat/growth/features/loyalty/models/responses/RewardsPointsBannerModel;", "it", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class IsRewardsPointsBannerVisible$run$2 extends Lambda implements Function1<RewardsPointsBannerModel, RewardsPointsBannerModel> {
    public static final IsRewardsPointsBannerVisible$run$2 INSTANCE = new IsRewardsPointsBannerVisible$run$2();

    public IsRewardsPointsBannerVisible$run$2() {
        super(1);
    }

    @NotNull
    public final RewardsPointsBannerModel invoke(@NotNull RewardsPointsBannerModel rewardsPointsBannerModel) {
        Intrinsics.checkNotNullParameter(rewardsPointsBannerModel, "it");
        return rewardsPointsBannerModel;
    }
}
