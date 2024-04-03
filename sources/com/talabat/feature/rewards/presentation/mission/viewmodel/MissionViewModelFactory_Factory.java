package com.talabat.feature.rewards.presentation.mission.viewmodel;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class MissionViewModelFactory_Factory implements Factory<MissionViewModelFactory> {
    private final Provider<MissionViewModel> providerProvider;

    public MissionViewModelFactory_Factory(Provider<MissionViewModel> provider) {
        this.providerProvider = provider;
    }

    public static MissionViewModelFactory_Factory create(Provider<MissionViewModel> provider) {
        return new MissionViewModelFactory_Factory(provider);
    }

    public static MissionViewModelFactory newInstance(Provider<MissionViewModel> provider) {
        return new MissionViewModelFactory(provider);
    }

    public MissionViewModelFactory get() {
        return newInstance(this.providerProvider);
    }
}
