package com.talabat.feature.rewards.presentation.mission;

import com.talabat.feature.rewards.presentation.mission.viewmodel.MissionViewModelFactory;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class RewardsMissionView_MembersInjector implements MembersInjector<RewardsMissionView> {
    private final Provider<MissionViewModelFactory> factoryProvider;

    public RewardsMissionView_MembersInjector(Provider<MissionViewModelFactory> provider) {
        this.factoryProvider = provider;
    }

    public static MembersInjector<RewardsMissionView> create(Provider<MissionViewModelFactory> provider) {
        return new RewardsMissionView_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.feature.rewards.presentation.mission.RewardsMissionView.factory")
    public static void injectFactory(RewardsMissionView rewardsMissionView, MissionViewModelFactory missionViewModelFactory) {
        rewardsMissionView.factory = missionViewModelFactory;
    }

    public void injectMembers(RewardsMissionView rewardsMissionView) {
        injectFactory(rewardsMissionView, this.factoryProvider.get());
    }
}
