package com.talabat.talabatlife.features.subscription.repository;

import com.talabat.talabatlife.features.subscription.model.response.TLifePlansRootResponse;
import com.talabat.talabatlife.ui.onBoarding.model.TLifeOnBoardingDisplayModelMapper;
import com.talabat.talabatlife.ui.onBoarding.model.TLifeOnBoardingPlanDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/talabat/talabatlife/ui/onBoarding/model/TLifeOnBoardingPlanDisplayModel;", "it", "Lcom/talabat/talabatlife/features/subscription/model/response/TLifePlansRootResponse;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionRepositoryImpl$getUserPlans$1 extends Lambda implements Function1<TLifePlansRootResponse, TLifeOnBoardingPlanDisplayModel> {
    public static final SubscriptionRepositoryImpl$getUserPlans$1 INSTANCE = new SubscriptionRepositoryImpl$getUserPlans$1();

    public SubscriptionRepositoryImpl$getUserPlans$1() {
        super(1);
    }

    @NotNull
    public final TLifeOnBoardingPlanDisplayModel invoke(@NotNull TLifePlansRootResponse tLifePlansRootResponse) {
        Intrinsics.checkNotNullParameter(tLifePlansRootResponse, "it");
        return TLifeOnBoardingDisplayModelMapper.Companion.mapToTLifeOnBoardingDisplayModel(tLifePlansRootResponse);
    }
}
