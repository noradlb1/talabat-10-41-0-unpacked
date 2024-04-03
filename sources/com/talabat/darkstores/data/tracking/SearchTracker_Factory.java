package com.talabat.darkstores.data.tracking;

import com.talabat.feature.darkstores.domain.tracking.ScreenTrackingProvider;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SearchTracker_Factory implements Factory<SearchTracker> {
    private final Provider<BaseTracker> baseTrackerProvider;
    private final Provider<ProductTrackingProvider> productTrackingProvider;
    private final Provider<ScreenTrackingProvider> screenTrackingProvider;

    public SearchTracker_Factory(Provider<BaseTracker> provider, Provider<ScreenTrackingProvider> provider2, Provider<ProductTrackingProvider> provider3) {
        this.baseTrackerProvider = provider;
        this.screenTrackingProvider = provider2;
        this.productTrackingProvider = provider3;
    }

    public static SearchTracker_Factory create(Provider<BaseTracker> provider, Provider<ScreenTrackingProvider> provider2, Provider<ProductTrackingProvider> provider3) {
        return new SearchTracker_Factory(provider, provider2, provider3);
    }

    public static SearchTracker newInstance(BaseTracker baseTracker, ScreenTrackingProvider screenTrackingProvider2, ProductTrackingProvider productTrackingProvider2) {
        return new SearchTracker(baseTracker, screenTrackingProvider2, productTrackingProvider2);
    }

    public SearchTracker get() {
        return newInstance(this.baseTrackerProvider.get(), this.screenTrackingProvider.get(), this.productTrackingProvider.get());
    }
}
