package com.talabat.darkstores.domain.common;

import com.talabat.darkstores.domain.voucher.IsVoucherBottomSheetNavigationEnabledUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class BuildVoucherDetailsNavigationUseCaseImpl_Factory implements Factory<BuildVoucherDetailsNavigationUseCaseImpl> {
    private final Provider<GetFlutterConfigurationParamsUseCase> getFlutterConfigurationParamsProvider;
    private final Provider<IsVoucherBottomSheetNavigationEnabledUseCase> isVoucherBottomSheetNavigationEnabledUseCaseProvider;

    public BuildVoucherDetailsNavigationUseCaseImpl_Factory(Provider<GetFlutterConfigurationParamsUseCase> provider, Provider<IsVoucherBottomSheetNavigationEnabledUseCase> provider2) {
        this.getFlutterConfigurationParamsProvider = provider;
        this.isVoucherBottomSheetNavigationEnabledUseCaseProvider = provider2;
    }

    public static BuildVoucherDetailsNavigationUseCaseImpl_Factory create(Provider<GetFlutterConfigurationParamsUseCase> provider, Provider<IsVoucherBottomSheetNavigationEnabledUseCase> provider2) {
        return new BuildVoucherDetailsNavigationUseCaseImpl_Factory(provider, provider2);
    }

    public static BuildVoucherDetailsNavigationUseCaseImpl newInstance(GetFlutterConfigurationParamsUseCase getFlutterConfigurationParamsUseCase, IsVoucherBottomSheetNavigationEnabledUseCase isVoucherBottomSheetNavigationEnabledUseCase) {
        return new BuildVoucherDetailsNavigationUseCaseImpl(getFlutterConfigurationParamsUseCase, isVoucherBottomSheetNavigationEnabledUseCase);
    }

    public BuildVoucherDetailsNavigationUseCaseImpl get() {
        return newInstance(this.getFlutterConfigurationParamsProvider.get(), this.isVoucherBottomSheetNavigationEnabledUseCaseProvider.get());
    }
}
