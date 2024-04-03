package com.talabat.core.hms.location.data;

import com.huawei.hms.location.FusedLocationProviderClient;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class HmsFusedLocationProviderClient_Factory implements Factory<HmsFusedLocationProviderClient> {
    private final Provider<FusedLocationProviderClient> fusedLocationProviderClientProvider;

    public HmsFusedLocationProviderClient_Factory(Provider<FusedLocationProviderClient> provider) {
        this.fusedLocationProviderClientProvider = provider;
    }

    public static HmsFusedLocationProviderClient_Factory create(Provider<FusedLocationProviderClient> provider) {
        return new HmsFusedLocationProviderClient_Factory(provider);
    }

    public static HmsFusedLocationProviderClient newInstance(FusedLocationProviderClient fusedLocationProviderClient) {
        return new HmsFusedLocationProviderClient(fusedLocationProviderClient);
    }

    public HmsFusedLocationProviderClient get() {
        return newInstance(this.fusedLocationProviderClientProvider.get());
    }
}
