package com.talabat.growth.ui.lifecyclevoucher;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class LoginLifecycleVoucherView_MembersInjector implements MembersInjector<LoginLifecycleVoucherView> {
    private final Provider<ITalabatFeatureFlag> featureFlagRepoProvider;

    public LoginLifecycleVoucherView_MembersInjector(Provider<ITalabatFeatureFlag> provider) {
        this.featureFlagRepoProvider = provider;
    }

    public static MembersInjector<LoginLifecycleVoucherView> create(Provider<ITalabatFeatureFlag> provider) {
        return new LoginLifecycleVoucherView_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.growth.ui.lifecyclevoucher.LoginLifecycleVoucherView.featureFlagRepo")
    public static void injectFeatureFlagRepo(LoginLifecycleVoucherView loginLifecycleVoucherView, ITalabatFeatureFlag iTalabatFeatureFlag) {
        loginLifecycleVoucherView.featureFlagRepo = iTalabatFeatureFlag;
    }

    public void injectMembers(LoginLifecycleVoucherView loginLifecycleVoucherView) {
        injectFeatureFlagRepo(loginLifecycleVoucherView, this.featureFlagRepoProvider.get());
    }
}
