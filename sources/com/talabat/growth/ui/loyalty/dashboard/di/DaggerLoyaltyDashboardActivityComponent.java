package com.talabat.growth.ui.loyalty.dashboard.di;

import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.growth.ui.loyalty.dashboard.LoyaltyDashboardActivity;
import com.talabat.growth.ui.loyalty.dashboard.LoyaltyDashboardActivity_MembersInjector;
import com.talabat.growth.ui.loyalty.dashboard.di.LoyaltyDashboardActivityComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerLoyaltyDashboardActivityComponent {

    public static final class Factory implements LoyaltyDashboardActivityComponent.Factory {
        private Factory() {
        }

        public LoyaltyDashboardActivityComponent create(FeatureFlagCoreLibApi featureFlagCoreLibApi, DeepLinkCoreLibApi deepLinkCoreLibApi) {
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(deepLinkCoreLibApi);
            return new LoyaltyDashboardActivityComponentImpl(featureFlagCoreLibApi, deepLinkCoreLibApi);
        }
    }

    public static final class LoyaltyDashboardActivityComponentImpl implements LoyaltyDashboardActivityComponent {
        private final DeepLinkCoreLibApi deepLinkCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final LoyaltyDashboardActivityComponentImpl loyaltyDashboardActivityComponentImpl;

        private LoyaltyDashboardActivityComponentImpl(FeatureFlagCoreLibApi featureFlagCoreLibApi2, DeepLinkCoreLibApi deepLinkCoreLibApi2) {
            this.loyaltyDashboardActivityComponentImpl = this;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.deepLinkCoreLibApi = deepLinkCoreLibApi2;
        }

        private LoyaltyDashboardActivity injectLoyaltyDashboardActivity(LoyaltyDashboardActivity loyaltyDashboardActivity) {
            LoyaltyDashboardActivity_MembersInjector.injectTalabatFeatureFlag(loyaltyDashboardActivity, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            LoyaltyDashboardActivity_MembersInjector.injectDeeplinkNavigator(loyaltyDashboardActivity, (DeepLinkNavigator) Preconditions.checkNotNullFromComponent(this.deepLinkCoreLibApi.getDeepLinkNavigator()));
            return loyaltyDashboardActivity;
        }

        public void inject(LoyaltyDashboardActivity loyaltyDashboardActivity) {
            injectLoyaltyDashboardActivity(loyaltyDashboardActivity);
        }
    }

    private DaggerLoyaltyDashboardActivityComponent() {
    }

    public static LoyaltyDashboardActivityComponent.Factory factory() {
        return new Factory();
    }
}
