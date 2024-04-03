package com.talabat.feature.cancellationpolicy.di;

import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.feature.cancellationpolicy.domain.IHelpCenterEventTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class HelpCenterFeatureModule_ProvideHelpCenterEventTrackerFactory implements Factory<IHelpCenterEventTracker> {
    private final Provider<TalabatTracker> talabatTrackerProvider;

    public HelpCenterFeatureModule_ProvideHelpCenterEventTrackerFactory(Provider<TalabatTracker> provider) {
        this.talabatTrackerProvider = provider;
    }

    public static HelpCenterFeatureModule_ProvideHelpCenterEventTrackerFactory create(Provider<TalabatTracker> provider) {
        return new HelpCenterFeatureModule_ProvideHelpCenterEventTrackerFactory(provider);
    }

    public static IHelpCenterEventTracker provideHelpCenterEventTracker(TalabatTracker talabatTracker) {
        return (IHelpCenterEventTracker) Preconditions.checkNotNullFromProvides(HelpCenterFeatureModule.INSTANCE.provideHelpCenterEventTracker(talabatTracker));
    }

    public IHelpCenterEventTracker get() {
        return provideHelpCenterEventTracker(this.talabatTrackerProvider.get());
    }
}
