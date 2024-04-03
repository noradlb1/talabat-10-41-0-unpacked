package com.talabat.darkstores.data.tracking;

import com.integration.IntegrationGlobalDataModel;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class LocationTrackingProvider_Factory implements Factory<LocationTrackingProvider> {
    private final Provider<IntegrationGlobalDataModel.Companion> globalDataModelProvider;

    public LocationTrackingProvider_Factory(Provider<IntegrationGlobalDataModel.Companion> provider) {
        this.globalDataModelProvider = provider;
    }

    public static LocationTrackingProvider_Factory create(Provider<IntegrationGlobalDataModel.Companion> provider) {
        return new LocationTrackingProvider_Factory(provider);
    }

    public static LocationTrackingProvider newInstance(IntegrationGlobalDataModel.Companion companion) {
        return new LocationTrackingProvider(companion);
    }

    public LocationTrackingProvider get() {
        return newInstance(this.globalDataModelProvider.get());
    }
}
