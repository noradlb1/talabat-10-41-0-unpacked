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
public final class ChangeEmailScreen_MembersInjector implements MembersInjector<ChangeEmailScreen> {
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public ChangeEmailScreen_MembersInjector(Provider<AppVersionProvider> provider, Provider<ITalabatFeatureFlag> provider2) {
        this.appVersionProvider = provider;
        this.talabatFeatureFlagProvider = provider2;
    }

    public static MembersInjector<ChangeEmailScreen> create(Provider<AppVersionProvider> provider, Provider<ITalabatFeatureFlag> provider2) {
        return new ChangeEmailScreen_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.talabat.ChangeEmailScreen.appVersionProvider")
    public static void injectAppVersionProvider(ChangeEmailScreen changeEmailScreen, AppVersionProvider appVersionProvider2) {
        changeEmailScreen.f53812j = appVersionProvider2;
    }

    @InjectedFieldSignature("com.talabat.ChangeEmailScreen.talabatFeatureFlag")
    public static void injectTalabatFeatureFlag(ChangeEmailScreen changeEmailScreen, ITalabatFeatureFlag iTalabatFeatureFlag) {
        changeEmailScreen.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    public void injectMembers(ChangeEmailScreen changeEmailScreen) {
        injectAppVersionProvider(changeEmailScreen, this.appVersionProvider.get());
        injectTalabatFeatureFlag(changeEmailScreen, this.talabatFeatureFlagProvider.get());
    }
}
