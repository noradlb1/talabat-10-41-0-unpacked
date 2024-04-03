package com.talabat.feature.darkstoresscheduleddelivery.data.di;

import com.talabat.feature.darkstoresscheduleddelivery.data.remote.DarkstoresScheduledDeliveryApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import retrofit2.Retrofit;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DarkstoresScheduledDeliveryNetworkModule_ProvideDarkstoresScheduledDeliveryApiFactory implements Factory<DarkstoresScheduledDeliveryApi> {
    private final DarkstoresScheduledDeliveryNetworkModule module;
    private final Provider<Retrofit> retrofitProvider;

    public DarkstoresScheduledDeliveryNetworkModule_ProvideDarkstoresScheduledDeliveryApiFactory(DarkstoresScheduledDeliveryNetworkModule darkstoresScheduledDeliveryNetworkModule, Provider<Retrofit> provider) {
        this.module = darkstoresScheduledDeliveryNetworkModule;
        this.retrofitProvider = provider;
    }

    public static DarkstoresScheduledDeliveryNetworkModule_ProvideDarkstoresScheduledDeliveryApiFactory create(DarkstoresScheduledDeliveryNetworkModule darkstoresScheduledDeliveryNetworkModule, Provider<Retrofit> provider) {
        return new DarkstoresScheduledDeliveryNetworkModule_ProvideDarkstoresScheduledDeliveryApiFactory(darkstoresScheduledDeliveryNetworkModule, provider);
    }

    public static DarkstoresScheduledDeliveryApi provideDarkstoresScheduledDeliveryApi(DarkstoresScheduledDeliveryNetworkModule darkstoresScheduledDeliveryNetworkModule, Retrofit retrofit) {
        return (DarkstoresScheduledDeliveryApi) Preconditions.checkNotNullFromProvides(darkstoresScheduledDeliveryNetworkModule.provideDarkstoresScheduledDeliveryApi(retrofit));
    }

    public DarkstoresScheduledDeliveryApi get() {
        return provideDarkstoresScheduledDeliveryApi(this.module, this.retrofitProvider.get());
    }
}
