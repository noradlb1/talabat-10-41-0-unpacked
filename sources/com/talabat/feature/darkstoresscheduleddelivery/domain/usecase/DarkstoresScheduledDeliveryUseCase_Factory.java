package com.talabat.feature.darkstoresscheduleddelivery.domain.usecase;

import com.talabat.feature.darkstoresscheduleddelivery.domain.repository.DarkstoresScheduledDeliveryRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DarkstoresScheduledDeliveryUseCase_Factory implements Factory<DarkstoresScheduledDeliveryUseCase> {
    private final Provider<DarkstoresScheduledDeliveryRepository> repositoryProvider;

    public DarkstoresScheduledDeliveryUseCase_Factory(Provider<DarkstoresScheduledDeliveryRepository> provider) {
        this.repositoryProvider = provider;
    }

    public static DarkstoresScheduledDeliveryUseCase_Factory create(Provider<DarkstoresScheduledDeliveryRepository> provider) {
        return new DarkstoresScheduledDeliveryUseCase_Factory(provider);
    }

    public static DarkstoresScheduledDeliveryUseCase newInstance(DarkstoresScheduledDeliveryRepository darkstoresScheduledDeliveryRepository) {
        return new DarkstoresScheduledDeliveryUseCase(darkstoresScheduledDeliveryRepository);
    }

    public DarkstoresScheduledDeliveryUseCase get() {
        return newInstance(this.repositoryProvider.get());
    }
}
