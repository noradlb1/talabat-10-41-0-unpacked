package com.talabat.feature.darkstoresscheduleddelivery.data.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DeliveryDateResponseMapper_Factory implements Factory<DeliveryDateResponseMapper> {
    private final Provider<DeliverySlotResponseMapper> deliverySlotResponseMapperProvider;

    public DeliveryDateResponseMapper_Factory(Provider<DeliverySlotResponseMapper> provider) {
        this.deliverySlotResponseMapperProvider = provider;
    }

    public static DeliveryDateResponseMapper_Factory create(Provider<DeliverySlotResponseMapper> provider) {
        return new DeliveryDateResponseMapper_Factory(provider);
    }

    public static DeliveryDateResponseMapper newInstance(DeliverySlotResponseMapper deliverySlotResponseMapper) {
        return new DeliveryDateResponseMapper(deliverySlotResponseMapper);
    }

    public DeliveryDateResponseMapper get() {
        return newInstance(this.deliverySlotResponseMapperProvider.get());
    }
}
