package com.talabat.darkstores.di;

import android.content.Context;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.darkstores.data.tracking.LocationTrackingProvider;
import com.talabat.darkstores.data.tracking.StoreInfoTrackingProvider;
import com.talabat.darkstores.feature.tracking.DarkstoresEventTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("com.talabat.darkstores.di.LibScope")
@DaggerGenerated
@QualifierMetadata
public final class DarkstoresApplicationModule_ProvideDarkstoresEventTrackerFactory implements Factory<DarkstoresEventTracker> {
    private final Provider<Context> contextProvider;
    private final Provider<LocationTrackingProvider> locationTrackingProvider;
    private final Provider<StoreInfoTrackingProvider> storeInfoTrackingProvider;
    private final Provider<TalabatTracker> talabatTrackerProvider;

    public DarkstoresApplicationModule_ProvideDarkstoresEventTrackerFactory(Provider<Context> provider, Provider<TalabatTracker> provider2, Provider<StoreInfoTrackingProvider> provider3, Provider<LocationTrackingProvider> provider4) {
        this.contextProvider = provider;
        this.talabatTrackerProvider = provider2;
        this.storeInfoTrackingProvider = provider3;
        this.locationTrackingProvider = provider4;
    }

    public static DarkstoresApplicationModule_ProvideDarkstoresEventTrackerFactory create(Provider<Context> provider, Provider<TalabatTracker> provider2, Provider<StoreInfoTrackingProvider> provider3, Provider<LocationTrackingProvider> provider4) {
        return new DarkstoresApplicationModule_ProvideDarkstoresEventTrackerFactory(provider, provider2, provider3, provider4);
    }

    public static DarkstoresEventTracker provideDarkstoresEventTracker(Context context, TalabatTracker talabatTracker, StoreInfoTrackingProvider storeInfoTrackingProvider2, LocationTrackingProvider locationTrackingProvider2) {
        return (DarkstoresEventTracker) Preconditions.checkNotNullFromProvides(DarkstoresApplicationModule.INSTANCE.provideDarkstoresEventTracker(context, talabatTracker, storeInfoTrackingProvider2, locationTrackingProvider2));
    }

    public DarkstoresEventTracker get() {
        return provideDarkstoresEventTracker(this.contextProvider.get(), this.talabatTrackerProvider.get(), this.storeInfoTrackingProvider.get(), this.locationTrackingProvider.get());
    }
}
