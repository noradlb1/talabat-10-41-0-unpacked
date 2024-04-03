package com.talabat.feature.tmart.growth.presentation.sheet;

import com.talabat.feature.tmart.growth.domain.confirmation.TMartGrowthClaimVoucherUseCase;
import com.talabat.feature.tmart.growth.domain.confirmation.TMartGrowthConfirmationImagesUseCase;
import com.talabat.feature.tmart.growth.domain.confirmation.TMartGrowthConfirmationTrackingUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TMartGrowthBottomSheetViewModel_Factory implements Factory<TMartGrowthBottomSheetViewModel> {
    private final Provider<TMartGrowthConfirmationImagesUseCase> bottomSheetImagesUseCaseProvider;
    private final Provider<TMartGrowthClaimVoucherUseCase> claimVoucherUseCaseProvider;
    private final Provider<TMartGrowthConfirmationTrackingUseCase> trackingUseCaseProvider;

    public TMartGrowthBottomSheetViewModel_Factory(Provider<TMartGrowthConfirmationImagesUseCase> provider, Provider<TMartGrowthClaimVoucherUseCase> provider2, Provider<TMartGrowthConfirmationTrackingUseCase> provider3) {
        this.bottomSheetImagesUseCaseProvider = provider;
        this.claimVoucherUseCaseProvider = provider2;
        this.trackingUseCaseProvider = provider3;
    }

    public static TMartGrowthBottomSheetViewModel_Factory create(Provider<TMartGrowthConfirmationImagesUseCase> provider, Provider<TMartGrowthClaimVoucherUseCase> provider2, Provider<TMartGrowthConfirmationTrackingUseCase> provider3) {
        return new TMartGrowthBottomSheetViewModel_Factory(provider, provider2, provider3);
    }

    public static TMartGrowthBottomSheetViewModel newInstance(TMartGrowthConfirmationImagesUseCase tMartGrowthConfirmationImagesUseCase, TMartGrowthClaimVoucherUseCase tMartGrowthClaimVoucherUseCase, TMartGrowthConfirmationTrackingUseCase tMartGrowthConfirmationTrackingUseCase) {
        return new TMartGrowthBottomSheetViewModel(tMartGrowthConfirmationImagesUseCase, tMartGrowthClaimVoucherUseCase, tMartGrowthConfirmationTrackingUseCase);
    }

    public TMartGrowthBottomSheetViewModel get() {
        return newInstance(this.bottomSheetImagesUseCaseProvider.get(), this.claimVoucherUseCaseProvider.get(), this.trackingUseCaseProvider.get());
    }
}
