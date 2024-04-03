package com.talabat;

import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class ChangePasswordScreen_MembersInjector implements MembersInjector<ChangePasswordScreen> {
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public ChangePasswordScreen_MembersInjector(Provider<AppVersionProvider> provider, Provider<ITalabatFeatureFlag> provider2) {
        this.appVersionProvider = provider;
        this.talabatFeatureFlagProvider = provider2;
    }

    public static MembersInjector<ChangePasswordScreen> create(Provider<AppVersionProvider> provider, Provider<ITalabatFeatureFlag> provider2) {
        return new ChangePasswordScreen_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.talabat.ChangePasswordScreen.appVersionProvider")
    public static void injectAppVersionProvider(ChangePasswordScreen changePasswordScreen, AppVersionProvider appVersionProvider2) {
        changePasswordScreen.f53817i = appVersionProvider2;
    }

    @InjectedFieldSignature("com.talabat.ChangePasswordScreen.talabatFeatureFlag")
    public static void injectTalabatFeatureFlag(ChangePasswordScreen changePasswordScreen, ITalabatFeatureFlag iTalabatFeatureFlag) {
        changePasswordScreen.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    public void injectMembers(ChangePasswordScreen changePasswordScreen) {
        injectAppVersionProvider(changePasswordScreen, this.appVersionProvider.get());
        injectTalabatFeatureFlag(changePasswordScreen, this.talabatFeatureFlagProvider.get());
    }
}
