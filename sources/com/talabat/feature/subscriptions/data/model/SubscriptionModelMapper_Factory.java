package com.talabat.feature.subscriptions.data.model;

import com.talabat.feature.subscriptions.data.remote.model.SubscriptionPlanResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.SubscriptionUpgradePlanResponseModel;
import com.talabat.feature.subscriptions.domain.model.SubscriptionPlan;
import com.talabat.feature.subscriptions.domain.model.SubscriptionUpgradePlan;
import com.talabat.mapper.ModelMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SubscriptionModelMapper_Factory implements Factory<SubscriptionModelMapper> {
    private final Provider<ModelMapper<SubscriptionPlanResponseModel, SubscriptionPlan>> subscriptionPlanMapperProvider;
    private final Provider<ModelMapper<SubscriptionUpgradePlanResponseModel, SubscriptionUpgradePlan>> subscriptionUpgradePlanMapperProvider;

    public SubscriptionModelMapper_Factory(Provider<ModelMapper<SubscriptionPlanResponseModel, SubscriptionPlan>> provider, Provider<ModelMapper<SubscriptionUpgradePlanResponseModel, SubscriptionUpgradePlan>> provider2) {
        this.subscriptionPlanMapperProvider = provider;
        this.subscriptionUpgradePlanMapperProvider = provider2;
    }

    public static SubscriptionModelMapper_Factory create(Provider<ModelMapper<SubscriptionPlanResponseModel, SubscriptionPlan>> provider, Provider<ModelMapper<SubscriptionUpgradePlanResponseModel, SubscriptionUpgradePlan>> provider2) {
        return new SubscriptionModelMapper_Factory(provider, provider2);
    }

    public static SubscriptionModelMapper newInstance(ModelMapper<SubscriptionPlanResponseModel, SubscriptionPlan> modelMapper, ModelMapper<SubscriptionUpgradePlanResponseModel, SubscriptionUpgradePlan> modelMapper2) {
        return new SubscriptionModelMapper(modelMapper, modelMapper2);
    }

    public SubscriptionModelMapper get() {
        return newInstance(this.subscriptionPlanMapperProvider.get(), this.subscriptionUpgradePlanMapperProvider.get());
    }
}
