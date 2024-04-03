package com.talabat.darkstores.di;

import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.darkstores.data.ConfigurationParameters;
import com.talabat.darkstores.data.tracking.StoreInfoTrackingProvider;
import com.talabat.darkstores.data.tracking.product.ProductTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class DarkstoresApplicationModule_ProvideCategoryTrackerFactory implements Factory<ProductTracker> {
    private final Provider<ConfigurationParameters> configurationParametersProvider;
    private final Provider<StoreInfoTrackingProvider> storeInfoTrackingProvider;
    private final Provider<TalabatTracker> trackerProvider;

    public DarkstoresApplicationModule_ProvideCategoryTrackerFactory(Provider<TalabatTracker> provider, Provider<StoreInfoTrackingProvider> provider2, Provider<ConfigurationParameters> provider3) {
        this.trackerProvider = provider;
        this.storeInfoTrackingProvider = provider2;
        this.configurationParametersProvider = provider3;
    }

    public static DarkstoresApplicationModule_ProvideCategoryTrackerFactory create(Provider<TalabatTracker> provider, Provider<StoreInfoTrackingProvider> provider2, Provider<ConfigurationParameters> provider3) {
        return new DarkstoresApplicationModule_ProvideCategoryTrackerFactory(provider, provider2, provider3);
    }

    public static ProductTracker provideCategoryTracker(TalabatTracker talabatTracker, StoreInfoTrackingProvider storeInfoTrackingProvider2, ConfigurationParameters configurationParameters) {
        return (ProductTracker) Preconditions.checkNotNullFromProvides(DarkstoresApplicationModule.INSTANCE.provideCategoryTracker(talabatTracker, storeInfoTrackingProvider2, configurationParameters));
    }

    public ProductTracker get() {
        return provideCategoryTracker(this.trackerProvider.get(), this.storeInfoTrackingProvider.get(), this.configurationParametersProvider.get());
    }
}
