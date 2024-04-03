package com.talabat.splash.presentation.infrastructure.device.currentlocation;

import android.content.Context;
import com.talabat.location.domain.LocationRepository;
import com.talabat.splash.presentation.infrastructure.thirdparty.Tracking;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
public final class CLInfrastructureImpl_Factory implements Factory<CLInfrastructureImpl> {
    private final Provider<Context> contextProvider;
    private final Provider<LocationRepository> locationRepositoryProvider;
    private final Provider<Tracking> trackingProvider;

    public CLInfrastructureImpl_Factory(Provider<Context> provider, Provider<Tracking> provider2, Provider<LocationRepository> provider3) {
        this.contextProvider = provider;
        this.trackingProvider = provider2;
        this.locationRepositoryProvider = provider3;
    }

    public static CLInfrastructureImpl_Factory create(Provider<Context> provider, Provider<Tracking> provider2, Provider<LocationRepository> provider3) {
        return new CLInfrastructureImpl_Factory(provider, provider2, provider3);
    }

    public static CLInfrastructureImpl newInstance(Context context, Tracking tracking2, LocationRepository locationRepository) {
        return new CLInfrastructureImpl(context, tracking2, locationRepository);
    }

    public CLInfrastructureImpl get() {
        return newInstance(this.contextProvider.get(), this.trackingProvider.get(), this.locationRepositoryProvider.get());
    }
}
