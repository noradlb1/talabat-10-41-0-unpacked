package com.talabat.darkstores.data.tracking;

import com.talabat.darkstores.data.ConfigurationParameters;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class StoreInfoTrackingProvider_Factory implements Factory<StoreInfoTrackingProvider> {
    private final Provider<ConfigurationParameters> configurationParametersProvider;

    public StoreInfoTrackingProvider_Factory(Provider<ConfigurationParameters> provider) {
        this.configurationParametersProvider = provider;
    }

    public static StoreInfoTrackingProvider_Factory create(Provider<ConfigurationParameters> provider) {
        return new StoreInfoTrackingProvider_Factory(provider);
    }

    public static StoreInfoTrackingProvider newInstance(ConfigurationParameters configurationParameters) {
        return new StoreInfoTrackingProvider(configurationParameters);
    }

    public StoreInfoTrackingProvider get() {
        return newInstance(this.configurationParametersProvider.get());
    }
}
