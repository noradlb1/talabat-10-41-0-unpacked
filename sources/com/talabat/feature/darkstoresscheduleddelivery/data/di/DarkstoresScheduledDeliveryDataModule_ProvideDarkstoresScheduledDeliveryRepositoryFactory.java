package com.talabat.feature.darkstoresscheduleddelivery.data.di;

import com.talabat.feature.darkstoresscheduleddelivery.data.repository.DarkstoresScheduledDeliveryRepositoryImpl;
import com.talabat.feature.darkstoresscheduleddelivery.domain.repository.DarkstoresScheduledDeliveryRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class DarkstoresScheduledDeliveryDataModule_ProvideDarkstoresScheduledDeliveryRepositoryFactory implements Factory<DarkstoresScheduledDeliveryRepository> {
    private final Provider<DarkstoresScheduledDeliveryRepositoryImpl> darkstoresScheduledDeliveryRepositoryProvider;
    private final DarkstoresScheduledDeliveryDataModule module;

    public DarkstoresScheduledDeliveryDataModule_ProvideDarkstoresScheduledDeliveryRepositoryFactory(DarkstoresScheduledDeliveryDataModule darkstoresScheduledDeliveryDataModule, Provider<DarkstoresScheduledDeliveryRepositoryImpl> provider) {
        this.module = darkstoresScheduledDeliveryDataModule;
        this.darkstoresScheduledDeliveryRepositoryProvider = provider;
    }

    public static DarkstoresScheduledDeliveryDataModule_ProvideDarkstoresScheduledDeliveryRepositoryFactory create(DarkstoresScheduledDeliveryDataModule darkstoresScheduledDeliveryDataModule, Provider<DarkstoresScheduledDeliveryRepositoryImpl> provider) {
        return new DarkstoresScheduledDeliveryDataModule_ProvideDarkstoresScheduledDeliveryRepositoryFactory(darkstoresScheduledDeliveryDataModule, provider);
    }

    public static DarkstoresScheduledDeliveryRepository provideDarkstoresScheduledDeliveryRepository(DarkstoresScheduledDeliveryDataModule darkstoresScheduledDeliveryDataModule, DarkstoresScheduledDeliveryRepositoryImpl darkstoresScheduledDeliveryRepositoryImpl) {
        return (DarkstoresScheduledDeliveryRepository) Preconditions.checkNotNullFromProvides(darkstoresScheduledDeliveryDataModule.provideDarkstoresScheduledDeliveryRepository(darkstoresScheduledDeliveryRepositoryImpl));
    }

    public DarkstoresScheduledDeliveryRepository get() {
        return provideDarkstoresScheduledDeliveryRepository(this.module, this.darkstoresScheduledDeliveryRepositoryProvider.get());
    }
}
