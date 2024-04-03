package com.talabat.feature.mission.control.presentation.viewmodel;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class PrimaryMissionViewModelFactory_Factory implements Factory<PrimaryMissionViewModelFactory> {
    private final Provider<PrimaryMissionViewModel> providerProvider;

    public PrimaryMissionViewModelFactory_Factory(Provider<PrimaryMissionViewModel> provider) {
        this.providerProvider = provider;
    }

    public static PrimaryMissionViewModelFactory_Factory create(Provider<PrimaryMissionViewModel> provider) {
        return new PrimaryMissionViewModelFactory_Factory(provider);
    }

    public static PrimaryMissionViewModelFactory newInstance(Provider<PrimaryMissionViewModel> provider) {
        return new PrimaryMissionViewModelFactory(provider);
    }

    public PrimaryMissionViewModelFactory get() {
        return newInstance(this.providerProvider);
    }
}
