package com.talabat.core.gms.location.data;

import com.google.android.gms.location.FusedLocationProviderClient;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GmsFusedLocationProviderClient_Factory implements Factory<GmsFusedLocationProviderClient> {
    private final Provider<FusedLocationProviderClient> fusedLocationProviderClientProvider;

    public GmsFusedLocationProviderClient_Factory(Provider<FusedLocationProviderClient> provider) {
        this.fusedLocationProviderClientProvider = provider;
    }

    public static GmsFusedLocationProviderClient_Factory create(Provider<FusedLocationProviderClient> provider) {
        return new GmsFusedLocationProviderClient_Factory(provider);
    }

    public static GmsFusedLocationProviderClient newInstance(FusedLocationProviderClient fusedLocationProviderClient) {
        return new GmsFusedLocationProviderClient(fusedLocationProviderClient);
    }

    public GmsFusedLocationProviderClient get() {
        return newInstance(this.fusedLocationProviderClientProvider.get());
    }
}
