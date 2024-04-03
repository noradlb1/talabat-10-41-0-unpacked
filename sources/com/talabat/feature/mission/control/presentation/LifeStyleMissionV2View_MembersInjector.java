package com.talabat.feature.mission.control.presentation;

import com.talabat.feature.mission.control.presentation.viewmodel.LifeStyleMissionViewModelFactory;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class LifeStyleMissionV2View_MembersInjector implements MembersInjector<LifeStyleMissionV2View> {
    private final Provider<LifeStyleMissionViewModelFactory> factoryProvider;

    public LifeStyleMissionV2View_MembersInjector(Provider<LifeStyleMissionViewModelFactory> provider) {
        this.factoryProvider = provider;
    }

    public static MembersInjector<LifeStyleMissionV2View> create(Provider<LifeStyleMissionViewModelFactory> provider) {
        return new LifeStyleMissionV2View_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.feature.mission.control.presentation.LifeStyleMissionV2View.factory")
    public static void injectFactory(LifeStyleMissionV2View lifeStyleMissionV2View, LifeStyleMissionViewModelFactory lifeStyleMissionViewModelFactory) {
        lifeStyleMissionV2View.factory = lifeStyleMissionViewModelFactory;
    }

    public void injectMembers(LifeStyleMissionV2View lifeStyleMissionV2View) {
        injectFactory(lifeStyleMissionV2View, this.factoryProvider.get());
    }
}
