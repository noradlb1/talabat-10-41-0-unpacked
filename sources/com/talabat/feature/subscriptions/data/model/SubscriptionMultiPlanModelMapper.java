package com.talabat.feature.subscriptions.data.model;

import com.talabat.feature.subscriptions.data.remote.model.SubscriptionMultiPlanResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.SubscriptionPlanResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.SubscriptionProductResponse;
import com.talabat.feature.subscriptions.domain.model.FreeTrialInfo;
import com.talabat.feature.subscriptions.domain.model.SubscriptionMultiPlan;
import com.talabat.feature.subscriptions.domain.model.SubscriptionPlan;
import com.talabat.feature.subscriptions.domain.model.SubscriptionProduct;
import com.talabat.mapper.ModelMapper;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/feature/subscriptions/data/model/SubscriptionMultiPlanModelMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionMultiPlanResponseModel;", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionMultiPlan;", "subscriptionPlanMapper", "Lcom/talabat/feature/subscriptions/data/model/SubscriptionPlanModelMapper;", "(Lcom/talabat/feature/subscriptions/data/model/SubscriptionPlanModelMapper;)V", "apply", "source", "mapPlans", "", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionPlan;", "responsePlans", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionPlanResponseModel;", "mapProduct", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionProduct;", "product", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionProductResponse;", "mapProductsList", "products", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionMultiPlanModelMapper implements ModelMapper<SubscriptionMultiPlanResponseModel, SubscriptionMultiPlan> {
    @NotNull
    private final SubscriptionPlanModelMapper subscriptionPlanMapper;

    @Inject
    public SubscriptionMultiPlanModelMapper(@NotNull SubscriptionPlanModelMapper subscriptionPlanModelMapper) {
        Intrinsics.checkNotNullParameter(subscriptionPlanModelMapper, "subscriptionPlanMapper");
        this.subscriptionPlanMapper = subscriptionPlanModelMapper;
    }

    private final List<SubscriptionPlan> mapPlans(List<SubscriptionPlanResponseModel> list) {
        Iterable<SubscriptionPlanResponseModel> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (SubscriptionPlanResponseModel apply : iterable) {
            arrayList.add(this.subscriptionPlanMapper.apply(apply));
        }
        return arrayList;
    }

    private final SubscriptionProduct mapProduct(SubscriptionProductResponse subscriptionProductResponse) {
        String title = subscriptionProductResponse.getTitle();
        String str = "";
        if (title == null) {
            title = str;
        }
        String description = subscriptionProductResponse.getDescription();
        if (description == null) {
            description = str;
        }
        String id2 = subscriptionProductResponse.getId();
        if (id2 == null) {
            id2 = str;
        }
        String icon = subscriptionProductResponse.getIcon();
        if (icon != null) {
            str = icon;
        }
        return new SubscriptionProduct(title, id2, description, str);
    }

    private final List<SubscriptionProduct> mapProductsList(List<SubscriptionProductResponse> list) {
        Iterable<SubscriptionProductResponse> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (SubscriptionProductResponse mapProduct : iterable) {
            arrayList.add(mapProduct(mapProduct));
        }
        return arrayList;
    }

    @NotNull
    public SubscriptionMultiPlan apply(@NotNull SubscriptionMultiPlanResponseModel subscriptionMultiPlanResponseModel) {
        String str;
        Intrinsics.checkNotNullParameter(subscriptionMultiPlanResponseModel, "source");
        List<SubscriptionProductResponse> products = subscriptionMultiPlanResponseModel.getProducts();
        if (products == null) {
            products = CollectionsKt__CollectionsKt.emptyList();
        }
        List<SubscriptionPlanResponseModel> plans = subscriptionMultiPlanResponseModel.getPlans();
        if (plans == null) {
            plans = CollectionsKt__CollectionsKt.emptyList();
        }
        Integer freeTrialDays = subscriptionMultiPlanResponseModel.getFreeTrialDays();
        boolean z11 = false;
        int intValue = freeTrialDays != null ? freeTrialDays.intValue() : 0;
        String freeTrialTitle = subscriptionMultiPlanResponseModel.getFreeTrialTitle();
        if (freeTrialTitle == null) {
            freeTrialTitle = "";
        }
        Boolean freeTrialEligible = subscriptionMultiPlanResponseModel.getFreeTrialEligible();
        FreeTrialInfo freeTrialInfo = new FreeTrialInfo(intValue, freeTrialTitle, freeTrialEligible != null ? freeTrialEligible.booleanValue() : false);
        String termsUrl = subscriptionMultiPlanResponseModel.getTermsUrl();
        if (termsUrl == null) {
            str = "";
        } else {
            str = termsUrl;
        }
        List<SubscriptionProduct> mapProductsList = mapProductsList(products);
        Boolean activeSubscription = subscriptionMultiPlanResponseModel.getActiveSubscription();
        if (activeSubscription != null) {
            z11 = activeSubscription.booleanValue();
        }
        return new SubscriptionMultiPlan(z11, freeTrialInfo, mapPlans(plans), mapProductsList, str);
    }
}
