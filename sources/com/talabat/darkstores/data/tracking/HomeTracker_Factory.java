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
public final class HomeTracker_Factory implements Factory<HomeTracker> {
    private final Provider<BaseTracker> baseTrackerProvider;
    private final Provider<ScreenTrackingProvider> screenTrackingProvider;

    public HomeTracker_Factory(Provider<BaseTracker> provider, Provider<ScreenTrackingProvider> provider2) {
        this.baseTrackerProvider = provider;
        this.screenTrackingProvider = provider2;
    }

    public static HomeTracker_Factory create(Provider<BaseTracker> provider, Provider<ScreenTrackingProvider> provider2) {
        return new HomeTracker_Factory(provider, provider2);
    }

    public static HomeTracker newInstance(BaseTracker baseTracker, ScreenTrackingProvider screenTrackingProvider2) {
        return new HomeTracker(baseTracker, screenTrackingProvider2);
    }

    public HomeTracker get() {
        return newInstance(this.baseTrackerProvider.get(), this.screenTrackingProvider.get());
    }
}
