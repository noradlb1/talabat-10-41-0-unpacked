package com.talabat.feature.darkstoresscheduleddelivery.data.repository;

import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.feature.darkstoresscheduleddelivery.data.mapper.DeliveryDateResponseMapper;
import com.talabat.feature.darkstoresscheduleddelivery.data.remote.DarkstoresScheduledDeliveryApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DarkstoresScheduledDeliveryRepositoryImpl_Factory implements Factory<DarkstoresScheduledDeliveryRepositoryImpl> {
    private final Provider<DarkstoresScheduledDeliveryApi> apiProvider;
    private final Provider<DeliveryDateResponseMapper> deliveryDateResponseMapperProvider;
    private final Provider<RxSchedulersFactory> rxSchedulersFactoryProvider;

    public DarkstoresScheduledDeliveryRepositoryImpl_Factory(Provider<DarkstoresScheduledDeliveryApi> provider, Provider<RxSchedulersFactory> provider2, Provider<DeliveryDateResponseMapper> provider3) {
        this.apiProvider = provider;
        this.rxSchedulersFactoryProvider = provider2;
        this.deliveryDateResponseMapperProvider = provider3;
    }

    public static DarkstoresScheduledDeliveryRepositoryImpl_Factory create(Provider<DarkstoresScheduledDeliveryApi> provider, Provider<RxSchedulersFactory> provider2, Provider<DeliveryDateResponseMapper> provider3) {
        return new DarkstoresScheduledDeliveryRepositoryImpl_Factory(provider, provider2, provider3);
    }

    public static DarkstoresScheduledDeliveryRepositoryImpl newInstance(DarkstoresScheduledDeliveryApi darkstoresScheduledDeliveryApi, RxSchedulersFactory rxSchedulersFactory, DeliveryDateResponseMapper deliveryDateResponseMapper) {
        return new DarkstoresScheduledDeliveryRepositoryImpl(darkstoresScheduledDeliveryApi, rxSchedulersFactory, deliveryDateResponseMapper);
    }

    public DarkstoresScheduledDeliveryRepositoryImpl get() {
        return newInstance(this.apiProvider.get(), this.rxSchedulersFactoryProvider.get(), this.deliveryDateResponseMapperProvider.get());
    }
}
