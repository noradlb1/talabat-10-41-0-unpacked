package com.talabat.di.account;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.AccountInfoScreen;
import com.talabat.AccountInfoScreen_MembersInjector;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.safety.domain.SafetyAgent;
import com.talabat.core.safety.domain.SafetyCoreLibApi;
import com.talabat.di.account.AccountInfoScreenComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerAccountInfoScreenComponent {

    public static final class AccountInfoScreenComponentImpl implements AccountInfoScreenComponent {
        private final AccountInfoScreenComponentImpl accountInfoScreenComponentImpl;
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final SafetyCoreLibApi safetyCoreLibApi;

        private AccountInfoScreenComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, SafetyCoreLibApi safetyCoreLibApi2) {
            this.accountInfoScreenComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.safetyCoreLibApi = safetyCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private AccountInfoScreen injectAccountInfoScreen(AccountInfoScreen accountInfoScreen) {
            AccountInfoScreen_MembersInjector.injectAppVersionProvider(accountInfoScreen, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider()));
            AccountInfoScreen_MembersInjector.injectConfigurationLocalRepository(accountInfoScreen, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            AccountInfoScreen_MembersInjector.injectSafetyAgent(accountInfoScreen, (SafetyAgent) Preconditions.checkNotNullFromComponent(this.safetyCoreLibApi.getSafetyAgent()));
            AccountInfoScreen_MembersInjector.injectTalabatFeatureFlag(accountInfoScreen, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            return accountInfoScreen;
        }

        public void inject(AccountInfoScreen accountInfoScreen) {
            injectAccountInfoScreen(accountInfoScreen);
        }
    }

    public static final class Factory implements AccountInfoScreenComponent.Factory {
        private Factory() {
        }

        public AccountInfoScreenComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, SafetyCoreLibApi safetyCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(safetyCoreLibApi);
            return new AccountInfoScreenComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, featureFlagCoreLibApi, safetyCoreLibApi);
        }
    }

    private DaggerAccountInfoScreenComponent() {
    }

    public static AccountInfoScreenComponent.Factory factory() {
        return new Factory();
    }
}
