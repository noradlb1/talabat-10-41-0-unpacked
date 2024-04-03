package com.talabat.growth.ui.vouchers.redeembottomsheet;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class RedeemVoucherBottomSheetView_MembersInjector implements MembersInjector<RedeemVoucherBottomSheetView> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public RedeemVoucherBottomSheetView_MembersInjector(Provider<ConfigurationLocalRepository> provider, Provider<ITalabatFeatureFlag> provider2, Provider<IObservabilityManager> provider3) {
        this.configurationLocalRepositoryProvider = provider;
        this.talabatFeatureFlagProvider = provider2;
        this.observabilityManagerProvider = provider3;
    }

    public static MembersInjector<RedeemVoucherBottomSheetView> create(Provider<ConfigurationLocalRepository> provider, Provider<ITalabatFeatureFlag> provider2, Provider<IObservabilityManager> provider3) {
        return new RedeemVoucherBottomSheetView_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.talabat.growth.ui.vouchers.redeembottomsheet.RedeemVoucherBottomSheetView.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(RedeemVoucherBottomSheetView redeemVoucherBottomSheetView, ConfigurationLocalRepository configurationLocalRepository) {
        redeemVoucherBottomSheetView.configurationLocalRepository = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.growth.ui.vouchers.redeembottomsheet.RedeemVoucherBottomSheetView.observabilityManager")
    public static void injectObservabilityManager(RedeemVoucherBottomSheetView redeemVoucherBottomSheetView, IObservabilityManager iObservabilityManager) {
        redeemVoucherBottomSheetView.observabilityManager = iObservabilityManager;
    }

    @InjectedFieldSignature("com.talabat.growth.ui.vouchers.redeembottomsheet.RedeemVoucherBottomSheetView.talabatFeatureFlag")
    public static void injectTalabatFeatureFlag(RedeemVoucherBottomSheetView redeemVoucherBottomSheetView, ITalabatFeatureFlag iTalabatFeatureFlag) {
        redeemVoucherBottomSheetView.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    public void injectMembers(RedeemVoucherBottomSheetView redeemVoucherBottomSheetView) {
        injectConfigurationLocalRepository(redeemVoucherBottomSheetView, this.configurationLocalRepositoryProvider.get());
        injectTalabatFeatureFlag(redeemVoucherBottomSheetView, this.talabatFeatureFlagProvider.get());
        injectObservabilityManager(redeemVoucherBottomSheetView, this.observabilityManagerProvider.get());
    }
}
