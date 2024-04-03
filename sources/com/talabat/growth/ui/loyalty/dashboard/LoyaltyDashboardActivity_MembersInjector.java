package com.talabat.growth.ui.loyalty.dashboard;

import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class LoyaltyDashboardActivity_MembersInjector implements MembersInjector<LoyaltyDashboardActivity> {
    private final Provider<DeepLinkNavigator> deeplinkNavigatorProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public LoyaltyDashboardActivity_MembersInjector(Provider<ITalabatFeatureFlag> provider, Provider<DeepLinkNavigator> provider2) {
        this.talabatFeatureFlagProvider = provider;
        this.deeplinkNavigatorProvider = provider2;
    }

    public static MembersInjector<LoyaltyDashboardActivity> create(Provider<ITalabatFeatureFlag> provider, Provider<DeepLinkNavigator> provider2) {
        return new LoyaltyDashboardActivity_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.talabat.growth.ui.loyalty.dashboard.LoyaltyDashboardActivity.deeplinkNavigator")
    public static void injectDeeplinkNavigator(LoyaltyDashboardActivity loyaltyDashboardActivity, DeepLinkNavigator deepLinkNavigator) {
        loyaltyDashboardActivity.deeplinkNavigator = deepLinkNavigator;
    }

    @InjectedFieldSignature("com.talabat.growth.ui.loyalty.dashboard.LoyaltyDashboardActivity.talabatFeatureFlag")
    public static void injectTalabatFeatureFlag(LoyaltyDashboardActivity loyaltyDashboardActivity, ITalabatFeatureFlag iTalabatFeatureFlag) {
        loyaltyDashboardActivity.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    public void injectMembers(LoyaltyDashboardActivity loyaltyDashboardActivity) {
        injectTalabatFeatureFlag(loyaltyDashboardActivity, this.talabatFeatureFlagProvider.get());
        injectDeeplinkNavigator(loyaltyDashboardActivity, this.deeplinkNavigatorProvider.get());
    }
}
