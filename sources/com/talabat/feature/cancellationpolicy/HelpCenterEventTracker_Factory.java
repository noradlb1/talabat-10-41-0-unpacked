package com.talabat.feature.cancellationpolicy;

import com.talabat.core.tracking.domain.TalabatTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class HelpCenterEventTracker_Factory implements Factory<HelpCenterEventTracker> {
    private final Provider<TalabatTracker> talabatTrackerProvider;

    public HelpCenterEventTracker_Factory(Provider<TalabatTracker> provider) {
        this.talabatTrackerProvider = provider;
    }

    public static HelpCenterEventTracker_Factory create(Provider<TalabatTracker> provider) {
        return new HelpCenterEventTracker_Factory(provider);
    }

    public static HelpCenterEventTracker newInstance(TalabatTracker talabatTracker) {
        return new HelpCenterEventTracker(talabatTracker);
    }

    public HelpCenterEventTracker get() {
        return newInstance(this.talabatTrackerProvider.get());
    }
}
