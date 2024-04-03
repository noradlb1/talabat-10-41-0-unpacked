package com.talabat.core.gms.location.data.di;

import android.content.Context;
import com.google.android.gms.location.FusedLocationProviderClient;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GmsGoogleModule_FusedLocationProviderClientFactory implements Factory<FusedLocationProviderClient> {
    private final Provider<Context> contextProvider;

    public GmsGoogleModule_FusedLocationProviderClientFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static GmsGoogleModule_FusedLocationProviderClientFactory create(Provider<Context> provider) {
        return new GmsGoogleModule_FusedLocationProviderClientFactory(provider);
    }

    public static FusedLocationProviderClient fusedLocationProviderClient(Context context) {
        return (FusedLocationProviderClient) Preconditions.checkNotNullFromProvides(GmsGoogleModule.INSTANCE.fusedLocationProviderClient(context));
    }

    public FusedLocationProviderClient get() {
        return fusedLocationProviderClient(this.contextProvider.get());
    }
}
