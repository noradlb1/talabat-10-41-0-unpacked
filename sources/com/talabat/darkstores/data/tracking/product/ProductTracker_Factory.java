package com.talabat.darkstores.data.tracking.product;

import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.darkstores.data.ConfigurationParameters;
import com.talabat.darkstores.data.tracking.StoreInfoTrackingProvider;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ProductTracker_Factory implements Factory<ProductTracker> {
    private final Provider<ConfigurationParameters> configurationParametersProvider;
    private final Provider<StoreInfoTrackingProvider> storeInfoTrackingProvider;
    private final Provider<TalabatTracker> talabatTrackerProvider;

    public ProductTracker_Factory(Provider<TalabatTracker> provider, Provider<StoreInfoTrackingProvider> provider2, Provider<ConfigurationParameters> provider3) {
        this.talabatTrackerProvider = provider;
        this.storeInfoTrackingProvider = provider2;
        this.configurationParametersProvider = provider3;
    }

    public static ProductTracker_Factory create(Provider<TalabatTracker> provider, Provider<StoreInfoTrackingProvider> provider2, Provider<ConfigurationParameters> provider3) {
        return new ProductTracker_Factory(provider, provider2, provider3);
    }

    public static ProductTracker newInstance(TalabatTracker talabatTracker, StoreInfoTrackingProvider storeInfoTrackingProvider2, ConfigurationParameters configurationParameters) {
        return new ProductTracker(talabatTracker, storeInfoTrackingProvider2, configurationParameters);
    }

    public ProductTracker get() {
        return newInstance(this.talabatTrackerProvider.get(), this.storeInfoTrackingProvider.get(), this.configurationParametersProvider.get());
    }
}
