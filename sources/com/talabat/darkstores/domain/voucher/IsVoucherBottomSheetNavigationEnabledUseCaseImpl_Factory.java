package com.talabat.darkstores.domain.voucher;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class IsVoucherBottomSheetNavigationEnabledUseCaseImpl_Factory implements Factory<IsVoucherBottomSheetNavigationEnabledUseCaseImpl> {
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public IsVoucherBottomSheetNavigationEnabledUseCaseImpl_Factory(Provider<ITalabatFeatureFlag> provider) {
        this.talabatFeatureFlagProvider = provider;
    }

    public static IsVoucherBottomSheetNavigationEnabledUseCaseImpl_Factory create(Provider<ITalabatFeatureFlag> provider) {
        return new IsVoucherBottomSheetNavigationEnabledUseCaseImpl_Factory(provider);
    }

    public static IsVoucherBottomSheetNavigationEnabledUseCaseImpl newInstance(ITalabatFeatureFlag iTalabatFeatureFlag) {
        return new IsVoucherBottomSheetNavigationEnabledUseCaseImpl(iTalabatFeatureFlag);
    }

    public IsVoucherBottomSheetNavigationEnabledUseCaseImpl get() {
        return newInstance(this.talabatFeatureFlagProvider.get());
    }
}
