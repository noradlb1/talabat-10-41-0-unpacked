package com.talabat.darkstores.domain.common;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class ApplyDiscountsAndCampaignsUseCaseImpl_Factory implements Factory<ApplyDiscountsAndCampaignsUseCaseImpl> {
    private final Provider<DarkstoresRepo> darkstoresRepoProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public ApplyDiscountsAndCampaignsUseCaseImpl_Factory(Provider<DarkstoresRepo> provider, Provider<ITalabatFeatureFlag> provider2) {
        this.darkstoresRepoProvider = provider;
        this.talabatFeatureFlagProvider = provider2;
    }

    public static ApplyDiscountsAndCampaignsUseCaseImpl_Factory create(Provider<DarkstoresRepo> provider, Provider<ITalabatFeatureFlag> provider2) {
        return new ApplyDiscountsAndCampaignsUseCaseImpl_Factory(provider, provider2);
    }

    public static ApplyDiscountsAndCampaignsUseCaseImpl newInstance(DarkstoresRepo darkstoresRepo, ITalabatFeatureFlag iTalabatFeatureFlag) {
        return new ApplyDiscountsAndCampaignsUseCaseImpl(darkstoresRepo, iTalabatFeatureFlag);
    }

    public ApplyDiscountsAndCampaignsUseCaseImpl get() {
        return newInstance(this.darkstoresRepoProvider.get(), this.talabatFeatureFlagProvider.get());
    }
}
