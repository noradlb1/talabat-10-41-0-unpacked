package com.talabat.feature.subscriptions.data.model;

import com.talabat.feature.subscriptions.data.remote.model.SubscriptionResponseModel;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.mapper.ModelMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ProCentralizationModelMapper_Factory implements Factory<ProCentralizationModelMapper> {
    private final Provider<ModelMapper<SubscriptionResponseModel, Subscription>> subscriptionModelMapperProvider;

    public ProCentralizationModelMapper_Factory(Provider<ModelMapper<SubscriptionResponseModel, Subscription>> provider) {
        this.subscriptionModelMapperProvider = provider;
    }

    public static ProCentralizationModelMapper_Factory create(Provider<ModelMapper<SubscriptionResponseModel, Subscription>> provider) {
        return new ProCentralizationModelMapper_Factory(provider);
    }

    public static ProCentralizationModelMapper newInstance(ModelMapper<SubscriptionResponseModel, Subscription> modelMapper) {
        return new ProCentralizationModelMapper(modelMapper);
    }

    public ProCentralizationModelMapper get() {
        return newInstance(this.subscriptionModelMapperProvider.get());
    }
}
