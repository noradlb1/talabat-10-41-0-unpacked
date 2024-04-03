package com.talabat.core.gms.location.data;

import com.talabat.location.domain.FusedLocationProviderClient;
import com.talabat.location.domain.LocationRequest;
import com.talabat.location.domain.LocationSettingsRequest;
import com.talabat.location.domain.SettingsClient;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DefaultGmsLocationRepository_Factory implements Factory<DefaultGmsLocationRepository> {
    private final Provider<FusedLocationProviderClient> fusedLocationProviderClientProvider;
    private final Provider<LocationRequest> locationRequestProvider;
    private final Provider<LocationSettingsRequest.Builder> locationSettingsBuilderProvider;
    private final Provider<SettingsClient> settingsClientProvider;

    public DefaultGmsLocationRepository_Factory(Provider<LocationRequest> provider, Provider<FusedLocationProviderClient> provider2, Provider<SettingsClient> provider3, Provider<LocationSettingsRequest.Builder> provider4) {
        this.locationRequestProvider = provider;
        this.fusedLocationProviderClientProvider = provider2;
        this.settingsClientProvider = provider3;
        this.locationSettingsBuilderProvider = provider4;
    }

    public static DefaultGmsLocationRepository_Factory create(Provider<LocationRequest> provider, Provider<FusedLocationProviderClient> provider2, Provider<SettingsClient> provider3, Provider<LocationSettingsRequest.Builder> provider4) {
        return new DefaultGmsLocationRepository_Factory(provider, provider2, provider3, provider4);
    }

    public static DefaultGmsLocationRepository newInstance(Provider<LocationRequest> provider, Provider<FusedLocationProviderClient> provider2, Provider<SettingsClient> provider3, Provider<LocationSettingsRequest.Builder> provider4) {
        return new DefaultGmsLocationRepository(provider, provider2, provider3, provider4);
    }

    public DefaultGmsLocationRepository get() {
        return newInstance(this.locationRequestProvider, this.fusedLocationProviderClientProvider, this.settingsClientProvider, this.locationSettingsBuilderProvider);
    }
}
