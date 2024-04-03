package com.talabat.homescreen.widget;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class HomeScreenHeaderRewardsView_MembersInjector implements MembersInjector<HomeScreenHeaderRewardsView> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<CoroutineDispatchersFactory> coroutineDispatchersFactoryProvider;
    private final Provider<ITalabatFeatureFlag> featureFlagRepoProvider;

    public HomeScreenHeaderRewardsView_MembersInjector(Provider<CoroutineDispatchersFactory> provider, Provider<ITalabatFeatureFlag> provider2, Provider<ConfigurationLocalRepository> provider3) {
        this.coroutineDispatchersFactoryProvider = provider;
        this.featureFlagRepoProvider = provider2;
        this.configurationLocalRepositoryProvider = provider3;
    }

    public static MembersInjector<HomeScreenHeaderRewardsView> create(Provider<CoroutineDispatchersFactory> provider, Provider<ITalabatFeatureFlag> provider2, Provider<ConfigurationLocalRepository> provider3) {
        return new HomeScreenHeaderRewardsView_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.talabat.homescreen.widget.HomeScreenHeaderRewardsView.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(HomeScreenHeaderRewardsView homeScreenHeaderRewardsView, ConfigurationLocalRepository configurationLocalRepository) {
        homeScreenHeaderRewardsView.configurationLocalRepository = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.homescreen.widget.HomeScreenHeaderRewardsView.coroutineDispatchersFactory")
    public static void injectCoroutineDispatchersFactory(HomeScreenHeaderRewardsView homeScreenHeaderRewardsView, CoroutineDispatchersFactory coroutineDispatchersFactory) {
        homeScreenHeaderRewardsView.coroutineDispatchersFactory = coroutineDispatchersFactory;
    }

    @InjectedFieldSignature("com.talabat.homescreen.widget.HomeScreenHeaderRewardsView.featureFlagRepo")
    public static void injectFeatureFlagRepo(HomeScreenHeaderRewardsView homeScreenHeaderRewardsView, ITalabatFeatureFlag iTalabatFeatureFlag) {
        homeScreenHeaderRewardsView.featureFlagRepo = iTalabatFeatureFlag;
    }

    public void injectMembers(HomeScreenHeaderRewardsView homeScreenHeaderRewardsView) {
        injectCoroutineDispatchersFactory(homeScreenHeaderRewardsView, this.coroutineDispatchersFactoryProvider.get());
        injectFeatureFlagRepo(homeScreenHeaderRewardsView, this.featureFlagRepoProvider.get());
        injectConfigurationLocalRepository(homeScreenHeaderRewardsView, this.configurationLocalRepositoryProvider.get());
    }
}
