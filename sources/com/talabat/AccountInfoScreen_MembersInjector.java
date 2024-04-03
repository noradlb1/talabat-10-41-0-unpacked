package com.talabat;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.safety.domain.SafetyAgent;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class AccountInfoScreen_MembersInjector implements MembersInjector<AccountInfoScreen> {
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<SafetyAgent> safetyAgentProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public AccountInfoScreen_MembersInjector(Provider<AppVersionProvider> provider, Provider<ConfigurationLocalRepository> provider2, Provider<SafetyAgent> provider3, Provider<ITalabatFeatureFlag> provider4) {
        this.appVersionProvider = provider;
        this.configurationLocalRepositoryProvider = provider2;
        this.safetyAgentProvider = provider3;
        this.talabatFeatureFlagProvider = provider4;
    }

    public static MembersInjector<AccountInfoScreen> create(Provider<AppVersionProvider> provider, Provider<ConfigurationLocalRepository> provider2, Provider<SafetyAgent> provider3, Provider<ITalabatFeatureFlag> provider4) {
        return new AccountInfoScreen_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.talabat.AccountInfoScreen.appVersionProvider")
    public static void injectAppVersionProvider(AccountInfoScreen accountInfoScreen, AppVersionProvider appVersionProvider2) {
        accountInfoScreen.f53486i = appVersionProvider2;
    }

    @InjectedFieldSignature("com.talabat.AccountInfoScreen.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(AccountInfoScreen accountInfoScreen, ConfigurationLocalRepository configurationLocalRepository) {
        accountInfoScreen.f53487j = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.AccountInfoScreen.safetyAgent")
    public static void injectSafetyAgent(AccountInfoScreen accountInfoScreen, SafetyAgent safetyAgent) {
        accountInfoScreen.f53488k = safetyAgent;
    }

    @InjectedFieldSignature("com.talabat.AccountInfoScreen.talabatFeatureFlag")
    public static void injectTalabatFeatureFlag(AccountInfoScreen accountInfoScreen, ITalabatFeatureFlag iTalabatFeatureFlag) {
        accountInfoScreen.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    public void injectMembers(AccountInfoScreen accountInfoScreen) {
        injectAppVersionProvider(accountInfoScreen, this.appVersionProvider.get());
        injectConfigurationLocalRepository(accountInfoScreen, this.configurationLocalRepositoryProvider.get());
        injectSafetyAgent(accountInfoScreen, this.safetyAgentProvider.get());
        injectTalabatFeatureFlag(accountInfoScreen, this.talabatFeatureFlagProvider.get());
    }
}
