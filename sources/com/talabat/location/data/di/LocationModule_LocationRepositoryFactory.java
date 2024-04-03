package com.talabat.location.data.di;

import com.talabat.core.gms.location.domain.GmsLocationRepository;
import com.talabat.core.hms.location.domain.HmsLocationRepository;
import com.talabat.location.domain.LocationRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.core.gms.base.domain.IsGmsAvailable", "com.talabat.core.hms.base.domain.IsHmsAvailable"})
public final class LocationModule_LocationRepositoryFactory implements Factory<LocationRepository> {
    private final Provider<GmsLocationRepository> gmsLocationRepositoryProvider;
    private final Provider<HmsLocationRepository> hmsLocationRepositoryProvider;
    private final Provider<Boolean> isGmsAvailableProvider;
    private final Provider<Boolean> isHmsAvailableProvider;

    public LocationModule_LocationRepositoryFactory(Provider<Boolean> provider, Provider<Boolean> provider2, Provider<GmsLocationRepository> provider3, Provider<HmsLocationRepository> provider4) {
        this.isGmsAvailableProvider = provider;
        this.isHmsAvailableProvider = provider2;
        this.gmsLocationRepositoryProvider = provider3;
        this.hmsLocationRepositoryProvider = provider4;
    }

    public static LocationModule_LocationRepositoryFactory create(Provider<Boolean> provider, Provider<Boolean> provider2, Provider<GmsLocationRepository> provider3, Provider<HmsLocationRepository> provider4) {
        return new LocationModule_LocationRepositoryFactory(provider, provider2, provider3, provider4);
    }

    public static LocationRepository locationRepository(boolean z11, boolean z12, GmsLocationRepository gmsLocationRepository, HmsLocationRepository hmsLocationRepository) {
        return (LocationRepository) Preconditions.checkNotNullFromProvides(LocationModule.INSTANCE.locationRepository(z11, z12, gmsLocationRepository, hmsLocationRepository));
    }

    public LocationRepository get() {
        return locationRepository(this.isGmsAvailableProvider.get().booleanValue(), this.isHmsAvailableProvider.get().booleanValue(), this.gmsLocationRepositoryProvider.get(), this.hmsLocationRepositoryProvider.get());
    }
}
