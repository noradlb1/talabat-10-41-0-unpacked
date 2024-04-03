package com.talabat.feature.pickup.data.di;

import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.feature.pickup.data.PickupBaseUrl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class PickupNetworkModule_ProvideBaseUrlFactory implements Factory<String> {
    private final Provider<BaseUrlFactory> baseUrlFactoryProvider;
    private final Provider<PickupBaseUrl> pickupBaseUrlProvider;

    public PickupNetworkModule_ProvideBaseUrlFactory(Provider<BaseUrlFactory> provider, Provider<PickupBaseUrl> provider2) {
        this.baseUrlFactoryProvider = provider;
        this.pickupBaseUrlProvider = provider2;
    }

    public static PickupNetworkModule_ProvideBaseUrlFactory create(Provider<BaseUrlFactory> provider, Provider<PickupBaseUrl> provider2) {
        return new PickupNetworkModule_ProvideBaseUrlFactory(provider, provider2);
    }

    public static String provideBaseUrl(BaseUrlFactory baseUrlFactory, PickupBaseUrl pickupBaseUrl) {
        return (String) Preconditions.checkNotNullFromProvides(PickupNetworkModule.INSTANCE.provideBaseUrl(baseUrlFactory, pickupBaseUrl));
    }

    public String get() {
        return provideBaseUrl(this.baseUrlFactoryProvider.get(), this.pickupBaseUrlProvider.get());
    }
}
