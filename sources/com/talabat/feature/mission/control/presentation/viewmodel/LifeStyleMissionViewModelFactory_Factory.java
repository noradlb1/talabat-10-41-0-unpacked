package com.talabat.feature.mission.control.presentation.viewmodel;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class LifeStyleMissionViewModelFactory_Factory implements Factory<LifeStyleMissionViewModelFactory> {
    private final Provider<LifeStyleMissionViewModel> providerProvider;

    public LifeStyleMissionViewModelFactory_Factory(Provider<LifeStyleMissionViewModel> provider) {
        this.providerProvider = provider;
    }

    public static LifeStyleMissionViewModelFactory_Factory create(Provider<LifeStyleMissionViewModel> provider) {
        return new LifeStyleMissionViewModelFactory_Factory(provider);
    }

    public static LifeStyleMissionViewModelFactory newInstance(Provider<LifeStyleMissionViewModel> provider) {
        return new LifeStyleMissionViewModelFactory(provider);
    }

    public LifeStyleMissionViewModelFactory get() {
        return newInstance(this.providerProvider);
    }
}
