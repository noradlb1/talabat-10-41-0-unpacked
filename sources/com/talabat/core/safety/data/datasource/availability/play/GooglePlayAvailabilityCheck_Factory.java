package com.talabat.core.safety.data.datasource.availability.play;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.core.safety.data.di.DebugValue", "com.talabat.core.gms.base.domain.IsGmsAvailable"})
public final class GooglePlayAvailabilityCheck_Factory implements Factory<GooglePlayAvailabilityCheck> {
    private final Provider<Boolean> isDebugProvider;
    private final Provider<Boolean> isGmsAvailableProvider;

    public GooglePlayAvailabilityCheck_Factory(Provider<Boolean> provider, Provider<Boolean> provider2) {
        this.isDebugProvider = provider;
        this.isGmsAvailableProvider = provider2;
    }

    public static GooglePlayAvailabilityCheck_Factory create(Provider<Boolean> provider, Provider<Boolean> provider2) {
        return new GooglePlayAvailabilityCheck_Factory(provider, provider2);
    }

    public static GooglePlayAvailabilityCheck newInstance(boolean z11, boolean z12) {
        return new GooglePlayAvailabilityCheck(z11, z12);
    }

    public GooglePlayAvailabilityCheck get() {
        return newInstance(this.isDebugProvider.get().booleanValue(), this.isGmsAvailableProvider.get().booleanValue());
    }
}
