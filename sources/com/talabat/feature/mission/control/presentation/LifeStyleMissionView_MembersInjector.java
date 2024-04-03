package com.talabat.feature.mission.control.presentation;

import com.talabat.feature.mission.control.presentation.viewmodel.LifeStyleMissionViewModelFactory;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class LifeStyleMissionView_MembersInjector implements MembersInjector<LifeStyleMissionView> {
    private final Provider<LifeStyleMissionViewModelFactory> factoryProvider;

    public LifeStyleMissionView_MembersInjector(Provider<LifeStyleMissionViewModelFactory> provider) {
        this.factoryProvider = provider;
    }

    public static MembersInjector<LifeStyleMissionView> create(Provider<LifeStyleMissionViewModelFactory> provider) {
        return new LifeStyleMissionView_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.feature.mission.control.presentation.LifeStyleMissionView.factory")
    public static void injectFactory(LifeStyleMissionView lifeStyleMissionView, LifeStyleMissionViewModelFactory lifeStyleMissionViewModelFactory) {
        lifeStyleMissionView.factory = lifeStyleMissionViewModelFactory;
    }

    public void injectMembers(LifeStyleMissionView lifeStyleMissionView) {
        injectFactory(lifeStyleMissionView, this.factoryProvider.get());
    }
}
