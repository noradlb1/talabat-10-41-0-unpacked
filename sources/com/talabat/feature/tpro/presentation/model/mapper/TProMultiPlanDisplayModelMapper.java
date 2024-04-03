package com.talabat.feature.tpro.presentation.model.mapper;

import com.talabat.feature.subscriptions.domain.model.SubscriptionMultiPlan;
import com.talabat.feature.subscriptions.domain.model.SubscriptionPlan;
import com.talabat.feature.subscriptions.domain.model.SubscriptionProduct;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingBannerAndPlanModel;
import com.talabat.feature.tpro.presentation.model.TProMultiPlanDisplayModel;
import com.talabat.feature.tpro.presentation.model.TProOnBoardingDisplayModel;
import com.talabat.mapper.ModelMapper;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/talabat/feature/tpro/presentation/model/mapper/TProMultiPlanDisplayModelMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionMultiPlan;", "Lcom/talabat/feature/tpro/presentation/model/TProMultiPlanDisplayModel;", "tProMapper", "Lcom/talabat/feature/tpro/presentation/model/mapper/TProMapperUtility;", "(Lcom/talabat/feature/tpro/presentation/model/mapper/TProMapperUtility;)V", "apply", "source", "createTProOnBoardingModel", "Lcom/talabat/feature/tpro/presentation/model/TProOnBoardingDisplayModel;", "tProMultiPlanDisplayModel", "tProOnBoardingBannerAndPlanModel", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingBannerAndPlanModel;", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProMultiPlanDisplayModelMapper implements ModelMapper<SubscriptionMultiPlan, TProMultiPlanDisplayModel> {
    @NotNull
    private final TProMapperUtility tProMapper;

    @Inject
    public TProMultiPlanDisplayModelMapper(@NotNull TProMapperUtility tProMapperUtility) {
        Intrinsics.checkNotNullParameter(tProMapperUtility, "tProMapper");
        this.tProMapper = tProMapperUtility;
    }

    @NotNull
    public final TProOnBoardingDisplayModel createTProOnBoardingModel(@NotNull TProMultiPlanDisplayModel tProMultiPlanDisplayModel, @NotNull TProOnBoardingBannerAndPlanModel tProOnBoardingBannerAndPlanModel) {
        Intrinsics.checkNotNullParameter(tProMultiPlanDisplayModel, "tProMultiPlanDisplayModel");
        Intrinsics.checkNotNullParameter(tProOnBoardingBannerAndPlanModel, "tProOnBoardingBannerAndPlanModel");
        return new TProOnBoardingDisplayModel(tProMultiPlanDisplayModel, tProOnBoardingBannerAndPlanModel.getFavoriteVendors(), tProOnBoardingBannerAndPlanModel.getHeroBanner(), tProOnBoardingBannerAndPlanModel.getCards());
    }

    @NotNull
    public TProMultiPlanDisplayModel apply(@NotNull SubscriptionMultiPlan subscriptionMultiPlan) {
        Intrinsics.checkNotNullParameter(subscriptionMultiPlan, "source");
        boolean activeSubscription = subscriptionMultiPlan.getActiveSubscription();
        int freeTrialDays = subscriptionMultiPlan.getFreeTrialInfo().getFreeTrialDays();
        String freeTrialTitle = subscriptionMultiPlan.getFreeTrialInfo().getFreeTrialTitle();
        boolean freeTrialEligible = subscriptionMultiPlan.getFreeTrialInfo().getFreeTrialEligible();
        Iterable<SubscriptionPlan> plans = subscriptionMultiPlan.getPlans();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(plans, 10));
        for (SubscriptionPlan mapPlanDisplayModel : plans) {
            arrayList.add(this.tProMapper.mapPlanDisplayModel(mapPlanDisplayModel));
        }
        List sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new TProMultiPlanDisplayModelMapper$apply$$inlined$sortedBy$1());
        Iterable<SubscriptionProduct> products = subscriptionMultiPlan.getProducts();
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(products, 10));
        for (SubscriptionProduct mapProductDisplayModel : products) {
            arrayList2.add(this.tProMapper.mapProductDisplayModel(mapProductDisplayModel));
        }
        return new TProMultiPlanDisplayModel(activeSubscription, freeTrialDays, freeTrialTitle, freeTrialEligible, sortedWith, arrayList2, subscriptionMultiPlan.getTermsUrl());
    }
}
