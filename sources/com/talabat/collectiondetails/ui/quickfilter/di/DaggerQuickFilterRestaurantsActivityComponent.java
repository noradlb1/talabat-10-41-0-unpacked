package com.talabat.collectiondetails.ui.quickfilter.di;

import com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsActivity;
import com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsActivity_MembersInjector;
import com.talabat.collectiondetails.ui.quickfilter.di.QuickFilterRestaurantsActivityComponent;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerQuickFilterRestaurantsActivityComponent {

    public static final class Factory implements QuickFilterRestaurantsActivityComponent.Factory {
        private Factory() {
        }

        public QuickFilterRestaurantsActivityComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            return new QuickFilterRestaurantsActivityComponentImpl(configurationLocalCoreLibApi, featureFlagCoreLibApi);
        }
    }

    public static final class QuickFilterRestaurantsActivityComponentImpl implements QuickFilterRestaurantsActivityComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final QuickFilterRestaurantsActivityComponentImpl quickFilterRestaurantsActivityComponentImpl;

        private QuickFilterRestaurantsActivityComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2) {
            this.quickFilterRestaurantsActivityComponentImpl = this;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
        }

        private QuickFilterRestaurantsActivity injectQuickFilterRestaurantsActivity(QuickFilterRestaurantsActivity quickFilterRestaurantsActivity) {
            QuickFilterRestaurantsActivity_MembersInjector.injectConfigurationLocalCoreLibApi(quickFilterRestaurantsActivity, this.configurationLocalCoreLibApi);
            QuickFilterRestaurantsActivity_MembersInjector.injectTalabatFeatureFlag(quickFilterRestaurantsActivity, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            return quickFilterRestaurantsActivity;
        }

        public void inject(QuickFilterRestaurantsActivity quickFilterRestaurantsActivity) {
            injectQuickFilterRestaurantsActivity(quickFilterRestaurantsActivity);
        }
    }

    private DaggerQuickFilterRestaurantsActivityComponent() {
    }

    public static QuickFilterRestaurantsActivityComponent.Factory factory() {
        return new Factory();
    }
}
