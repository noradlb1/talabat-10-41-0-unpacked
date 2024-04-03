package com.talabat.feature.bnplcore.data.di;

import com.talabat.feature.bnplcore.data.remote.BnplApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import retrofit2.Retrofit;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class BnplNetworkModule_ProvideBNPLApiFactory implements Factory<BnplApi> {
    private final Provider<Retrofit> retrofitProvider;

    public BnplNetworkModule_ProvideBNPLApiFactory(Provider<Retrofit> provider) {
        this.retrofitProvider = provider;
    }

    public static BnplNetworkModule_ProvideBNPLApiFactory create(Provider<Retrofit> provider) {
        return new BnplNetworkModule_ProvideBNPLApiFactory(provider);
    }

    public static BnplApi provideBNPLApi(Retrofit retrofit) {
        return (BnplApi) Preconditions.checkNotNullFromProvides(BnplNetworkModule.provideBNPLApi(retrofit));
    }

    public BnplApi get() {
        return provideBNPLApi(this.retrofitProvider.get());
    }
}
