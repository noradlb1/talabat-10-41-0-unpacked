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
public final class DefaultRewardsTracker_Factory implements Factory<DefaultRewardsTracker> {
    private final Provider<TalabatTracker> talabatTrackerProvider;

    public DefaultRewardsTracker_Factory(Provider<TalabatTracker> provider) {
        this.talabatTrackerProvider = provider;
    }

    public static DefaultRewardsTracker_Factory create(Provider<TalabatTracker> provider) {
        return new DefaultRewardsTracker_Factory(provider);
    }

    public static DefaultRewardsTracker newInstance(TalabatTracker talabatTracker) {
        return new DefaultRewardsTracker(talabatTracker);
    }

    public DefaultRewardsTracker get() {
        return newInstance(this.talabatTrackerProvider.get());
    }
}
