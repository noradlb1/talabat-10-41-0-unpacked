package com.talabat.feature.pickup.data.di;

import com.talabat.feature.pickup.data.PickupRepositoryImpl;
import com.talabat.feature.pickup.domain.PickupRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class PickupFeatureModule_ProvideRepositoryFactory implements Factory<PickupRepository> {
    private final Provider<PickupRepositoryImpl> implProvider;

    public PickupFeatureModule_ProvideRepositoryFactory(Provider<PickupRepositoryImpl> provider) {
        this.implProvider = provider;
    }

    public static PickupFeatureModule_ProvideRepositoryFactory create(Provider<PickupRepositoryImpl> provider) {
        return new PickupFeatureModule_ProvideRepositoryFactory(provider);
    }

    public static PickupRepository provideRepository(PickupRepositoryImpl pickupRepositoryImpl) {
        return (PickupRepository) Preconditions.checkNotNullFromProvides(PickupFeatureModule.INSTANCE.provideRepository(pickupRepositoryImpl));
    }

    public PickupRepository get() {
        return provideRepository(this.implProvider.get());
    }
}
