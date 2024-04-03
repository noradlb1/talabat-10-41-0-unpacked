package com.talabat.core.tracking.data.di;

import com.talabat.core.tracking.domain.AnalyticsType;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.core.gms.base.domain.IsGmsAvailable", "com.talabat.core.hms.base.domain.IsHmsAvailable"})
public final class TrackingCoreModule_AnalyticsTypeFactory implements Factory<AnalyticsType> {
    private final Provider<Boolean> isGmsAvailableProvider;
    private final Provider<Boolean> isHmsAvailableProvider;

    public TrackingCoreModule_AnalyticsTypeFactory(Provider<Boolean> provider, Provider<Boolean> provider2) {
        this.isGmsAvailableProvider = provider;
        this.isHmsAvailableProvider = provider2;
    }

    public static AnalyticsType analyticsType(boolean z11, boolean z12) {
        return (AnalyticsType) Preconditions.checkNotNullFromProvides(TrackingCoreModule.INSTANCE.analyticsType(z11, z12));
    }

    public static TrackingCoreModule_AnalyticsTypeFactory create(Provider<Boolean> provider, Provider<Boolean> provider2) {
        return new TrackingCoreModule_AnalyticsTypeFactory(provider, provider2);
    }

    public AnalyticsType get() {
        return analyticsType(this.isGmsAvailableProvider.get().booleanValue(), this.isHmsAvailableProvider.get().booleanValue());
    }
}
