package com.talabat.feature.darkstoresscheduleddelivery.data.di;

import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.feature.darkstoresscheduleddelivery.data.remote.DarkstoresScheduleDeliveryBaseUrl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DarkstoresScheduledDeliveryNetworkModule_ProvideBaseUrlFactory implements Factory<String> {
    private final Provider<BaseUrlFactory> baseUrlFactoryProvider;
    private final Provider<DarkstoresScheduleDeliveryBaseUrl> darkstoresScheduleDeliveryBaseUrlProvider;
    private final DarkstoresScheduledDeliveryNetworkModule module;

    public DarkstoresScheduledDeliveryNetworkModule_ProvideBaseUrlFactory(DarkstoresScheduledDeliveryNetworkModule darkstoresScheduledDeliveryNetworkModule, Provider<BaseUrlFactory> provider, Provider<DarkstoresScheduleDeliveryBaseUrl> provider2) {
        this.module = darkstoresScheduledDeliveryNetworkModule;
        this.baseUrlFactoryProvider = provider;
        this.darkstoresScheduleDeliveryBaseUrlProvider = provider2;
    }

    public static DarkstoresScheduledDeliveryNetworkModule_ProvideBaseUrlFactory create(DarkstoresScheduledDeliveryNetworkModule darkstoresScheduledDeliveryNetworkModule, Provider<BaseUrlFactory> provider, Provider<DarkstoresScheduleDeliveryBaseUrl> provider2) {
        return new DarkstoresScheduledDeliveryNetworkModule_ProvideBaseUrlFactory(darkstoresScheduledDeliveryNetworkModule, provider, provider2);
    }

    public static String provideBaseUrl(DarkstoresScheduledDeliveryNetworkModule darkstoresScheduledDeliveryNetworkModule, BaseUrlFactory baseUrlFactory, DarkstoresScheduleDeliveryBaseUrl darkstoresScheduleDeliveryBaseUrl) {
        return (String) Preconditions.checkNotNullFromProvides(darkstoresScheduledDeliveryNetworkModule.provideBaseUrl(baseUrlFactory, darkstoresScheduleDeliveryBaseUrl));
    }

    public String get() {
        return provideBaseUrl(this.module, this.baseUrlFactoryProvider.get(), this.darkstoresScheduleDeliveryBaseUrlProvider.get());
    }
}
