package com.talabat.feature.mission.control.presentation;

import com.talabat.feature.mission.control.presentation.viewmodel.PrimaryMissionViewModelFactory;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class PrimaryMissionView_MembersInjector implements MembersInjector<PrimaryMissionView> {
    private final Provider<PrimaryMissionViewModelFactory> factoryProvider;

    public PrimaryMissionView_MembersInjector(Provider<PrimaryMissionViewModelFactory> provider) {
        this.factoryProvider = provider;
    }

    public static MembersInjector<PrimaryMissionView> create(Provider<PrimaryMissionViewModelFactory> provider) {
        return new PrimaryMissionView_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.feature.mission.control.presentation.PrimaryMissionView.factory")
    public static void injectFactory(PrimaryMissionView primaryMissionView, PrimaryMissionViewModelFactory primaryMissionViewModelFactory) {
        primaryMissionView.factory = primaryMissionViewModelFactory;
    }

    public void injectMembers(PrimaryMissionView primaryMissionView) {
        injectFactory(primaryMissionView, this.factoryProvider.get());
    }
}
