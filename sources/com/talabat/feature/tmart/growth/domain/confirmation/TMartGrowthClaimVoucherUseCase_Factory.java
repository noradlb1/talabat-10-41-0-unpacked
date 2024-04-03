package com.talabat.feature.tmart.growth.domain.confirmation;

import com.talabat.feature.tmart.growth.domain.ITMartGrowthRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TMartGrowthClaimVoucherUseCase_Factory implements Factory<TMartGrowthClaimVoucherUseCase> {
    private final Provider<ITMartGrowthRepository> repositoryProvider;

    public TMartGrowthClaimVoucherUseCase_Factory(Provider<ITMartGrowthRepository> provider) {
        this.repositoryProvider = provider;
    }

    public static TMartGrowthClaimVoucherUseCase_Factory create(Provider<ITMartGrowthRepository> provider) {
        return new TMartGrowthClaimVoucherUseCase_Factory(provider);
    }

    public static TMartGrowthClaimVoucherUseCase newInstance(ITMartGrowthRepository iTMartGrowthRepository) {
        return new TMartGrowthClaimVoucherUseCase(iTMartGrowthRepository);
    }

    public TMartGrowthClaimVoucherUseCase get() {
        return newInstance(this.repositoryProvider.get());
    }
}
