package com.talabat.talabatlife.ui.onBoarding.di;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.talabatlife.ui.onBoarding.TLifeOnBoardingFragment;
import com.talabat.talabatlife.ui.onBoarding.TLifeOnBoardingFragment_MembersInjector;
import com.talabat.talabatlife.ui.onBoarding.di.TLifeOnBoardingFragmentComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerTLifeOnBoardingFragmentComponent {

    public static final class Factory implements TLifeOnBoardingFragmentComponent.Factory {
        private Factory() {
        }

        public TLifeOnBoardingFragmentComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            return new TLifeOnBoardingFragmentComponentImpl(configurationLocalCoreLibApi, featureFlagCoreLibApi);
        }
    }

    public static final class TLifeOnBoardingFragmentComponentImpl implements TLifeOnBoardingFragmentComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final TLifeOnBoardingFragmentComponentImpl tLifeOnBoardingFragmentComponentImpl;

        private TLifeOnBoardingFragmentComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2) {
            this.tLifeOnBoardingFragmentComponentImpl = this;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
        }

        private TLifeOnBoardingFragment injectTLifeOnBoardingFragment(TLifeOnBoardingFragment tLifeOnBoardingFragment) {
            TLifeOnBoardingFragment_MembersInjector.injectConfigurationLocalCoreLibApi(tLifeOnBoardingFragment, this.configurationLocalCoreLibApi);
            TLifeOnBoardingFragment_MembersInjector.injectFeatureFlagRepo(tLifeOnBoardingFragment, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            return tLifeOnBoardingFragment;
        }

        public void inject(TLifeOnBoardingFragment tLifeOnBoardingFragment) {
            injectTLifeOnBoardingFragment(tLifeOnBoardingFragment);
        }
    }

    private DaggerTLifeOnBoardingFragmentComponent() {
    }

    public static TLifeOnBoardingFragmentComponent.Factory factory() {
        return new Factory();
    }
}
