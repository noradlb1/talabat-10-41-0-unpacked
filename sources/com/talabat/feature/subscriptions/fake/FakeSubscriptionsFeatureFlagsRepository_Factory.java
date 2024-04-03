package com.talabat.feature.subscriptions.fake;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.feature.subscriptions.fake.di.FakeSubscriptionsFeature"})
public final class FakeSubscriptionsFeatureFlagsRepository_Factory implements Factory<FakeSubscriptionsFeatureFlagsRepository> {
    private final Provider<Boolean> defaultFlagProvider;
    private final Provider<Boolean> isNewBrandEnabledProvider;
    private final Provider<Boolean> isSavingsBannerEnabledProvider;
    private final Provider<Boolean> isSavingsFlowEnabledProvider;
    private final Provider<Boolean> isTProEnabledProvider;
    private final Provider<Boolean> isTProFeatureEnabledProvider;

    public FakeSubscriptionsFeatureFlagsRepository_Factory(Provider<Boolean> provider, Provider<Boolean> provider2, Provider<Boolean> provider3, Provider<Boolean> provider4, Provider<Boolean> provider5, Provider<Boolean> provider6) {
        this.isTProEnabledProvider = provider;
        this.isSavingsFlowEnabledProvider = provider2;
        this.isSavingsBannerEnabledProvider = provider3;
        this.isNewBrandEnabledProvider = provider4;
        this.isTProFeatureEnabledProvider = provider5;
        this.defaultFlagProvider = provider6;
    }

    public static FakeSubscriptionsFeatureFlagsRepository_Factory create(Provider<Boolean> provider, Provider<Boolean> provider2, Provider<Boolean> provider3, Provider<Boolean> provider4, Provider<Boolean> provider5, Provider<Boolean> provider6) {
        return new FakeSubscriptionsFeatureFlagsRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static FakeSubscriptionsFeatureFlagsRepository newInstance(boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        return new FakeSubscriptionsFeatureFlagsRepository(z11, z12, z13, z14, z15, z16);
    }

    public FakeSubscriptionsFeatureFlagsRepository get() {
        return newInstance(this.isTProEnabledProvider.get().booleanValue(), this.isSavingsFlowEnabledProvider.get().booleanValue(), this.isSavingsBannerEnabledProvider.get().booleanValue(), this.isNewBrandEnabledProvider.get().booleanValue(), this.isTProFeatureEnabledProvider.get().booleanValue(), this.defaultFlagProvider.get().booleanValue());
    }
}
