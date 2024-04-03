package com.talabat.feature.subscriptions.domain;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&¨\u0006\u0011"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;", "", "isNewBrandEnabled", "", "isNewHeroBannerEnabled", "isOnboardingDeeplingEnabled", "isROIbannerExpiredModeEnabled", "isReactivateFromROIBannerEnabled", "isSavingsBannerEnabled", "isSavingsFlowEnabled", "isTProDisclaimerTextEnabled", "isTProEnabledForNFV", "isTProEnabledForTMart", "isTProFeatureEnabled", "isTProSideBannerEnabled", "isTproSubscriptionEnabled", "isTproSubscriptionUpgradeEnabled", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ISubscriptionsFeatureFlagsRepository {
    boolean isNewBrandEnabled();

    boolean isNewHeroBannerEnabled();

    boolean isOnboardingDeeplingEnabled();

    boolean isROIbannerExpiredModeEnabled();

    boolean isReactivateFromROIBannerEnabled();

    boolean isSavingsBannerEnabled();

    boolean isSavingsFlowEnabled();

    boolean isTProDisclaimerTextEnabled();

    boolean isTProEnabledForNFV();

    boolean isTProEnabledForTMart();

    boolean isTProFeatureEnabled();

    boolean isTProSideBannerEnabled();

    boolean isTproSubscriptionEnabled();

    boolean isTproSubscriptionUpgradeEnabled();
}
