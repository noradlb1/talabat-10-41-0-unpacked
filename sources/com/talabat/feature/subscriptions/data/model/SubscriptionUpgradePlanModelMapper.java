package com.talabat.feature.subscriptions.data.model;

import com.talabat.feature.subscriptions.data.remote.model.SubscriptionUpgradePlanResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.UpgradePlanBenefitResponseModel;
import com.talabat.feature.subscriptions.domain.model.SubscriptionUpgradePlan;
import com.talabat.feature.subscriptions.domain.model.UpgradePlanBenefit;
import com.talabat.mapper.ModelMapper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\fH\u0002¨\u0006\u000e"}, d2 = {"Lcom/talabat/feature/subscriptions/data/model/SubscriptionUpgradePlanModelMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionUpgradePlanResponseModel;", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionUpgradePlan;", "()V", "apply", "source", "mapBenefit", "Lcom/talabat/feature/subscriptions/domain/model/UpgradePlanBenefit;", "product", "Lcom/talabat/feature/subscriptions/data/remote/model/UpgradePlanBenefitResponseModel;", "mapBenefitsList", "", "benefits", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionUpgradePlanModelMapper implements ModelMapper<SubscriptionUpgradePlanResponseModel, SubscriptionUpgradePlan> {
    private final UpgradePlanBenefit mapBenefit(UpgradePlanBenefitResponseModel upgradePlanBenefitResponseModel) {
        String name2 = upgradePlanBenefitResponseModel.getName();
        String str = "";
        if (name2 == null) {
            name2 = str;
        }
        String description = upgradePlanBenefitResponseModel.getDescription();
        if (description == null) {
            description = str;
        }
        String icon = upgradePlanBenefitResponseModel.getIcon();
        if (icon != null) {
            str = icon;
        }
        return new UpgradePlanBenefit(name2, description, str);
    }

    private final List<UpgradePlanBenefit> mapBenefitsList(List<UpgradePlanBenefitResponseModel> list) {
        Iterable<UpgradePlanBenefitResponseModel> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (UpgradePlanBenefitResponseModel mapBenefit : iterable) {
            arrayList.add(mapBenefit(mapBenefit));
        }
        return arrayList;
    }

    @NotNull
    public SubscriptionUpgradePlan apply(@NotNull SubscriptionUpgradePlanResponseModel subscriptionUpgradePlanResponseModel) {
        Intrinsics.checkNotNullParameter(subscriptionUpgradePlanResponseModel, "source");
        List<UpgradePlanBenefitResponseModel> benefits = subscriptionUpgradePlanResponseModel.getBenefits();
        if (benefits == null) {
            benefits = CollectionsKt__CollectionsKt.emptyList();
        }
        String planId = subscriptionUpgradePlanResponseModel.getPlanId();
        String str = "";
        if (planId == null) {
            planId = str;
        }
        String planPeriod = subscriptionUpgradePlanResponseModel.getPlanPeriod();
        if (planPeriod != null) {
            str = planPeriod;
        }
        return new SubscriptionUpgradePlan(planId, str, mapBenefitsList(benefits));
    }
}
