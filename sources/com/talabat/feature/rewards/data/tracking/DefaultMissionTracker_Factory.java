package com.talabat.feature.rewards.data.tracking;

import com.talabat.core.tracking.domain.TalabatTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DefaultMissionTracker_Factory implements Factory<DefaultMissionTracker> {
    private final Provider<TalabatTracker> talabatTrackerProvider;

    public DefaultMissionTracker_Factory(Provider<TalabatTracker> provider) {
        this.talabatTrackerProvider = provider;
    }

    public static DefaultMissionTracker_Factory create(Provider<TalabatTracker> provider) {
        return new DefaultMissionTracker_Factory(provider);
    }

    public static DefaultMissionTracker newInstance(TalabatTracker talabatTracker) {
        return new DefaultMissionTracker(talabatTracker);
    }

    public DefaultMissionTracker get() {
        return newInstance(this.talabatTrackerProvider.get());
    }
}
