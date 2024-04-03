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
public final class ProductTrackingProvider_Factory implements Factory<ProductTrackingProvider> {
    private final Provider<ConfigurationParameters> configurationParametersProvider;

    public ProductTrackingProvider_Factory(Provider<ConfigurationParameters> provider) {
        this.configurationParametersProvider = provider;
    }

    public static ProductTrackingProvider_Factory create(Provider<ConfigurationParameters> provider) {
        return new ProductTrackingProvider_Factory(provider);
    }

    public static ProductTrackingProvider newInstance(ConfigurationParameters configurationParameters) {
        return new ProductTrackingProvider(configurationParameters);
    }

    public ProductTrackingProvider get() {
        return newInstance(this.configurationParametersProvider.get());
    }
}
