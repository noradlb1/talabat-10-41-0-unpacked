package com.talabat.homescreen.widget.di;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.homescreen.widget.HomeScreenHeaderRewardsView;
import com.talabat.homescreen.widget.HomeScreenHeaderRewardsView_MembersInjector;
import com.talabat.homescreen.widget.di.HomeScreenHeaderRewardsComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerHomeScreenHeaderRewardsComponent {

    public static final class Factory implements HomeScreenHeaderRewardsComponent.Factory {
        private Factory() {
        }

        public HomeScreenHeaderRewardsComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(dispatcherCoreLibApi);
            return new HomeScreenHeaderRewardsComponentImpl(configurationLocalCoreLibApi, featureFlagCoreLibApi, dispatcherCoreLibApi);
        }
    }

    public static final class HomeScreenHeaderRewardsComponentImpl implements HomeScreenHeaderRewardsComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final DispatcherCoreLibApi dispatcherCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final HomeScreenHeaderRewardsComponentImpl homeScreenHeaderRewardsComponentImpl;

        private HomeScreenHeaderRewardsComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, DispatcherCoreLibApi dispatcherCoreLibApi2) {
            this.homeScreenHeaderRewardsComponentImpl = this;
            this.dispatcherCoreLibApi = dispatcherCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
        }

        private HomeScreenHeaderRewardsView injectHomeScreenHeaderRewardsView(HomeScreenHeaderRewardsView homeScreenHeaderRewardsView) {
            HomeScreenHeaderRewardsView_MembersInjector.injectCoroutineDispatchersFactory(homeScreenHeaderRewardsView, (CoroutineDispatchersFactory) Preconditions.checkNotNullFromComponent(this.dispatcherCoreLibApi.getCoroutineDispatchersFactory()));
            HomeScreenHeaderRewardsView_MembersInjector.injectFeatureFlagRepo(homeScreenHeaderRewardsView, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            HomeScreenHeaderRewardsView_MembersInjector.injectConfigurationLocalRepository(homeScreenHeaderRewardsView, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            return homeScreenHeaderRewardsView;
        }

        public void inject(HomeScreenHeaderRewardsView homeScreenHeaderRewardsView) {
            injectHomeScreenHeaderRewardsView(homeScreenHeaderRewardsView);
        }
    }

    private DaggerHomeScreenHeaderRewardsComponent() {
    }

    public static HomeScreenHeaderRewardsComponent.Factory factory() {
        return new Factory();
    }
}
