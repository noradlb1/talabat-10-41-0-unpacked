package com.talabat.feature.rewards.presentation.mission.details;

import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.feature.rewards.domain.MissionTracker;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class MissionDetailsDialogFragment_MembersInjector implements MembersInjector<MissionDetailsDialogFragment> {
    private final Provider<DeepLinkNavigator> deepLinkNavigatorProvider;
    private final Provider<MissionTracker> missionTrackerProvider;

    public MissionDetailsDialogFragment_MembersInjector(Provider<DeepLinkNavigator> provider, Provider<MissionTracker> provider2) {
        this.deepLinkNavigatorProvider = provider;
        this.missionTrackerProvider = provider2;
    }

    public static MembersInjector<MissionDetailsDialogFragment> create(Provider<DeepLinkNavigator> provider, Provider<MissionTracker> provider2) {
        return new MissionDetailsDialogFragment_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.talabat.feature.rewards.presentation.mission.details.MissionDetailsDialogFragment.deepLinkNavigator")
    public static void injectDeepLinkNavigator(MissionDetailsDialogFragment missionDetailsDialogFragment, DeepLinkNavigator deepLinkNavigator) {
        missionDetailsDialogFragment.deepLinkNavigator = deepLinkNavigator;
    }

    @InjectedFieldSignature("com.talabat.feature.rewards.presentation.mission.details.MissionDetailsDialogFragment.missionTracker")
    public static void injectMissionTracker(MissionDetailsDialogFragment missionDetailsDialogFragment, MissionTracker missionTracker) {
        missionDetailsDialogFragment.missionTracker = missionTracker;
    }

    public void injectMembers(MissionDetailsDialogFragment missionDetailsDialogFragment) {
        injectDeepLinkNavigator(missionDetailsDialogFragment, this.deepLinkNavigatorProvider.get());
        injectMissionTracker(missionDetailsDialogFragment, this.missionTrackerProvider.get());
    }
}
