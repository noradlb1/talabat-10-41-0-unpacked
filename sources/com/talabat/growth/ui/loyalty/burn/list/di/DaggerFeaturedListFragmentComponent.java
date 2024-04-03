package com.talabat.growth.ui.loyalty.burn.list.di;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.growth.ui.loyalty.burn.list.FeaturedListFragment;
import com.talabat.growth.ui.loyalty.burn.list.FeaturedListFragment_MembersInjector;
import com.talabat.growth.ui.loyalty.burn.list.di.FeaturedListFragmentComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerFeaturedListFragmentComponent {

    public static final class Factory implements FeaturedListFragmentComponent.Factory {
        private Factory() {
        }

        public FeaturedListFragmentComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            return new FeaturedListFragmentComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, featureFlagCoreLibApi);
        }
    }

    public static final class FeaturedListFragmentComponentImpl implements FeaturedListFragmentComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final FeaturedListFragmentComponentImpl featuredListFragmentComponentImpl;

        private FeaturedListFragmentComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2) {
            this.featuredListFragmentComponentImpl = this;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
        }

        private FeaturedListFragment injectFeaturedListFragment(FeaturedListFragment featuredListFragment) {
            FeaturedListFragment_MembersInjector.injectConfigurationLocalRepository(featuredListFragment, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            FeaturedListFragment_MembersInjector.injectFeatureFlagRepository(featuredListFragment, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            FeaturedListFragment_MembersInjector.injectLocationConfigurationRepository(featuredListFragment, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            return featuredListFragment;
        }

        public void inject(FeaturedListFragment featuredListFragment) {
            injectFeaturedListFragment(featuredListFragment);
        }
    }

    private DaggerFeaturedListFragmentComponent() {
    }

    public static FeaturedListFragmentComponent.Factory factory() {
        return new Factory();
    }
}
