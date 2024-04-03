package com.talabat.talabatcommon.views.ridersTip.bottomSheet.di;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.talabatcommon.views.ridersTip.bottomSheet.RiderTipFragment;
import com.talabat.talabatcommon.views.ridersTip.bottomSheet.RiderTipFragment_MembersInjector;
import com.talabat.talabatcommon.views.ridersTip.bottomSheet.di.RiderTipFragmentComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerRiderTipFragmentComponent {

    public static final class Factory implements RiderTipFragmentComponent.Factory {
        private Factory() {
        }

        public RiderTipFragmentComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            return new RiderTipFragmentComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, featureFlagCoreLibApi);
        }
    }

    public static final class RiderTipFragmentComponentImpl implements RiderTipFragmentComponent {
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final RiderTipFragmentComponentImpl riderTipFragmentComponentImpl;

        private RiderTipFragmentComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2) {
            this.riderTipFragmentComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
        }

        private RiderTipFragment injectRiderTipFragment(RiderTipFragment riderTipFragment) {
            RiderTipFragment_MembersInjector.injectLocationConfigurationRepository(riderTipFragment, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            RiderTipFragment_MembersInjector.injectFeatureFlagRepository(riderTipFragment, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            return riderTipFragment;
        }

        public void inject(RiderTipFragment riderTipFragment) {
            injectRiderTipFragment(riderTipFragment);
        }
    }

    private DaggerRiderTipFragmentComponent() {
    }

    public static RiderTipFragmentComponent.Factory factory() {
        return new Factory();
    }
}
