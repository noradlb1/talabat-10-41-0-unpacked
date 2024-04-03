package com.talabat.offering.ui.di;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.offering.ui.OfferCollectionActivity;
import com.talabat.offering.ui.OfferCollectionActivity_MembersInjector;
import com.talabat.offering.ui.di.OfferCollectionActivityComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerOfferCollectionActivityComponent {

    public static final class Factory implements OfferCollectionActivityComponent.Factory {
        private Factory() {
        }

        public OfferCollectionActivityComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            return new OfferCollectionActivityComponentImpl(configurationLocalCoreLibApi, featureFlagCoreLibApi);
        }
    }

    public static final class OfferCollectionActivityComponentImpl implements OfferCollectionActivityComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final OfferCollectionActivityComponentImpl offerCollectionActivityComponentImpl;

        private OfferCollectionActivityComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2) {
            this.offerCollectionActivityComponentImpl = this;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
        }

        private OfferCollectionActivity injectOfferCollectionActivity(OfferCollectionActivity offerCollectionActivity) {
            OfferCollectionActivity_MembersInjector.injectConfigurationLocalRepository(offerCollectionActivity, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            OfferCollectionActivity_MembersInjector.injectTalabatFeatureFlag(offerCollectionActivity, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            return offerCollectionActivity;
        }

        public void inject(OfferCollectionActivity offerCollectionActivity) {
            injectOfferCollectionActivity(offerCollectionActivity);
        }
    }

    private DaggerOfferCollectionActivityComponent() {
    }

    public static OfferCollectionActivityComponent.Factory factory() {
        return new Factory();
    }
}
