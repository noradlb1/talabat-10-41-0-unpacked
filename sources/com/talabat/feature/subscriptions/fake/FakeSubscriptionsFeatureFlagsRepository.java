package com.talabat.feature.subscriptions.fake;

import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import com.talabat.feature.subscriptions.fake.di.FakeSubscriptionsFeature;
import javax.inject.Inject;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u00002\u00020\u0001BC\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u000e\u0010\b\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/feature/subscriptions/fake/FakeSubscriptionsFeatureFlagsRepository;", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;", "isTProEnabled", "", "isSavingsFlowEnabled", "isSavingsBannerEnabled", "isNewBrandEnabled", "isTProFeatureEnabled", "defaultFlag", "(ZZZZZZ)V", "isNewHeroBannerEnabled", "isOnboardingDeeplingEnabled", "isROIbannerExpiredModeEnabled", "isReactivateFromROIBannerEnabled", "isTProDisclaimerTextEnabled", "isTProEnabledForNFV", "isTProEnabledForTMart", "isTProSideBannerEnabled", "isTproSubscriptionEnabled", "isTproSubscriptionUpgradeEnabled", "com_talabat_feature_subscriptions_fake_fake"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FakeSubscriptionsFeatureFlagsRepository implements ISubscriptionsFeatureFlagsRepository {
    private final boolean defaultFlag;
    private final boolean isNewBrandEnabled;
    private final boolean isSavingsBannerEnabled;
    private final boolean isSavingsFlowEnabled;
    private final boolean isTProEnabled;
    private final boolean isTProFeatureEnabled;

    @Inject
    public FakeSubscriptionsFeatureFlagsRepository(@FakeSubscriptionsFeature(name = "isTProEnabled") boolean z11, @FakeSubscriptionsFeature(name = "isSavingsFlowEnabled") boolean z12, @FakeSubscriptionsFeature(name = "isSavingsBannerEnabled") boolean z13, @FakeSubscriptionsFeature(name = "isNewBrandEnabled") boolean z14, @FakeSubscriptionsFeature(name = "isTProFeatureEnabled") boolean z15, @FakeSubscriptionsFeature(name = "defaultFlag") boolean z16) {
        this.isTProEnabled = z11;
        this.isSavingsFlowEnabled = z12;
        this.isSavingsBannerEnabled = z13;
        this.isNewBrandEnabled = z14;
        this.isTProFeatureEnabled = z15;
        this.defaultFlag = z16;
    }

    public boolean isNewBrandEnabled() {
        System.out.println("requesting flag: isNewBrandEnabled");
        return this.isNewBrandEnabled;
    }

    public boolean isNewHeroBannerEnabled() {
        System.out.println("requesting flag: isNewHeroBannerEnabled");
        return this.defaultFlag;
    }

    public boolean isOnboardingDeeplingEnabled() {
        System.out.println("requesting flag: isOnboardingDeeplingEnabled");
        return this.defaultFlag;
    }

    public boolean isROIbannerExpiredModeEnabled() {
        System.out.println("requesting flag: isROIbannerExpiredModeEnabled");
        return this.defaultFlag;
    }

    public boolean isReactivateFromROIBannerEnabled() {
        System.out.println("requesting flag: isReactivateFromROIBannerEnabled");
        return this.defaultFlag;
    }

    public boolean isSavingsBannerEnabled() {
        System.out.println("requesting flag: isSavingsBannerEnabled");
        return this.isSavingsBannerEnabled;
    }

    public boolean isSavingsFlowEnabled() {
        System.out.println("requesting flag: isSavingsFlowEnabled");
        return this.isSavingsFlowEnabled;
    }

    public boolean isTProDisclaimerTextEnabled() {
        System.out.println("requesting flag: isTproDisclaimerTextEnabled");
        return this.defaultFlag;
    }

    public boolean isTProEnabledForNFV() {
        System.out.println("requesting flag: isTProEnabledForNFV");
        return this.defaultFlag;
    }

    public boolean isTProEnabledForTMart() {
        System.out.println("requesting flag: isTProEnabledForTMart");
        return this.isTProEnabled;
    }

    public boolean isTProFeatureEnabled() {
        System.out.println("requesting flag: isTProFeatureEnabled");
        return this.isTProFeatureEnabled;
    }

    public boolean isTProSideBannerEnabled() {
        System.out.println("requesting flag: isTProSideBannerEnabled");
        return this.defaultFlag;
    }

    public boolean isTproSubscriptionEnabled() {
        System.out.println("requesting flag: isTproSubscriptionEnabled");
        return this.defaultFlag;
    }

    public boolean isTproSubscriptionUpgradeEnabled() {
        System.out.println("requesting flag: isTproSubscriptionUpgradeEnabled");
        return this.defaultFlag;
    }
}
