package com.talabat.talabatcommon.views.vouchers.applyVoucherView;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class ApplyVouchersView_MembersInjector implements MembersInjector<ApplyVouchersView> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<ITalabatFeatureFlag> featureFlagRepoProvider;

    public ApplyVouchersView_MembersInjector(Provider<ITalabatFeatureFlag> provider, Provider<ConfigurationLocalRepository> provider2) {
        this.featureFlagRepoProvider = provider;
        this.configurationLocalRepositoryProvider = provider2;
    }

    public static MembersInjector<ApplyVouchersView> create(Provider<ITalabatFeatureFlag> provider, Provider<ConfigurationLocalRepository> provider2) {
        return new ApplyVouchersView_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.talabat.talabatcommon.views.vouchers.applyVoucherView.ApplyVouchersView.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(ApplyVouchersView applyVouchersView, ConfigurationLocalRepository configurationLocalRepository) {
        applyVouchersView.configurationLocalRepository = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.talabatcommon.views.vouchers.applyVoucherView.ApplyVouchersView.featureFlagRepo")
    public static void injectFeatureFlagRepo(ApplyVouchersView applyVouchersView, ITalabatFeatureFlag iTalabatFeatureFlag) {
        applyVouchersView.featureFlagRepo = iTalabatFeatureFlag;
    }

    public void injectMembers(ApplyVouchersView applyVouchersView) {
        injectFeatureFlagRepo(applyVouchersView, this.featureFlagRepoProvider.get());
        injectConfigurationLocalRepository(applyVouchersView, this.configurationLocalRepositoryProvider.get());
    }
}
