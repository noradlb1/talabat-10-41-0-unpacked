package com.talabat.talabatcommon.feature.vouchers.loyalty.domain;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.talabatcommon.feature.vouchers.loyalty.repository.VoucherRepository;
import com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.GrowthTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class RedeemVoucherCodeUseCase_Factory implements Factory<RedeemVoucherCodeUseCase> {
    private final Provider<GrowthTracker> growthTrackerProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;
    private final Provider<VoucherRepository> voucherRepositoryProvider;

    public RedeemVoucherCodeUseCase_Factory(Provider<VoucherRepository> provider, Provider<GrowthTracker> provider2, Provider<ITalabatFeatureFlag> provider3) {
        this.voucherRepositoryProvider = provider;
        this.growthTrackerProvider = provider2;
        this.talabatFeatureFlagProvider = provider3;
    }

    public static RedeemVoucherCodeUseCase_Factory create(Provider<VoucherRepository> provider, Provider<GrowthTracker> provider2, Provider<ITalabatFeatureFlag> provider3) {
        return new RedeemVoucherCodeUseCase_Factory(provider, provider2, provider3);
    }

    public static RedeemVoucherCodeUseCase newInstance(VoucherRepository voucherRepository, GrowthTracker growthTracker, ITalabatFeatureFlag iTalabatFeatureFlag) {
        return new RedeemVoucherCodeUseCase(voucherRepository, growthTracker, iTalabatFeatureFlag);
    }

    public RedeemVoucherCodeUseCase get() {
        return newInstance(this.voucherRepositoryProvider.get(), this.growthTrackerProvider.get(), this.talabatFeatureFlagProvider.get());
    }
}
