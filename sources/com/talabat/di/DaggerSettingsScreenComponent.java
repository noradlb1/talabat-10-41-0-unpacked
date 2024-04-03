package com.talabat.di;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.squareup.moshi.Moshi;
import com.talabat.SettingsScreen;
import com.talabat.SettingsScreen_MembersInjector;
import com.talabat.authentication.authenticate.domain.AuthenticationCoreLibApi;
import com.talabat.authentication.authenticate.domain.repository.AuthenticationRepository;
import com.talabat.configuration.MutableConfigurationLocalRepository;
import com.talabat.configuration.MutableConfigurationRemoteRepository;
import com.talabat.configuration.MutableLocationConfigurationRepository;
import com.talabat.configuration.di.MutableConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.MutableConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.parser.domain.ParserCoreLibApi;
import com.talabat.di.SettingsScreenComponent;
import com.talabat.feature.subscriptions.domain.ISubscriptionsCustomerRepository;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.subscriptions.domain.usecase.GetProCentralizationStatusUseCase;
import com.talabat.feature.ulaccountinfo.domain.AccountInfoFeatureApi;
import com.talabat.feature.ulaccountinfo.domain.IAccountInfoFeatureFlag;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerSettingsScreenComponent {

    public static final class Factory implements SettingsScreenComponent.Factory {
        private Factory() {
        }

        public SettingsScreenComponent create(MutableConfigurationLocalCoreLibApi mutableConfigurationLocalCoreLibApi, MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi, ParserCoreLibApi parserCoreLibApi, SubscriptionsFeatureApi subscriptionsFeatureApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, AccountInfoFeatureApi accountInfoFeatureApi, AuthenticationCoreLibApi authenticationCoreLibApi) {
            Preconditions.checkNotNull(mutableConfigurationLocalCoreLibApi);
            Preconditions.checkNotNull(mutableConfigurationRemoteCoreLibApi);
            Preconditions.checkNotNull(parserCoreLibApi);
            Preconditions.checkNotNull(subscriptionsFeatureApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(accountInfoFeatureApi);
            Preconditions.checkNotNull(authenticationCoreLibApi);
            return new SettingsScreenComponentImpl(mutableConfigurationLocalCoreLibApi, mutableConfigurationRemoteCoreLibApi, parserCoreLibApi, subscriptionsFeatureApi, featureFlagCoreLibApi, accountInfoFeatureApi, authenticationCoreLibApi);
        }
    }

    public static final class SettingsScreenComponentImpl implements SettingsScreenComponent {
        private final AccountInfoFeatureApi accountInfoFeatureApi;
        private final AuthenticationCoreLibApi authenticationCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final MutableConfigurationLocalCoreLibApi mutableConfigurationLocalCoreLibApi;
        private final MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi;
        private final ParserCoreLibApi parserCoreLibApi;
        private final SettingsScreenComponentImpl settingsScreenComponentImpl;
        private final SubscriptionsFeatureApi subscriptionsFeatureApi;

        private SettingsScreenComponentImpl(MutableConfigurationLocalCoreLibApi mutableConfigurationLocalCoreLibApi2, MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi2, ParserCoreLibApi parserCoreLibApi2, SubscriptionsFeatureApi subscriptionsFeatureApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, AccountInfoFeatureApi accountInfoFeatureApi2, AuthenticationCoreLibApi authenticationCoreLibApi2) {
            this.settingsScreenComponentImpl = this;
            this.parserCoreLibApi = parserCoreLibApi2;
            this.mutableConfigurationRemoteCoreLibApi = mutableConfigurationRemoteCoreLibApi2;
            this.mutableConfigurationLocalCoreLibApi = mutableConfigurationLocalCoreLibApi2;
            this.subscriptionsFeatureApi = subscriptionsFeatureApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.accountInfoFeatureApi = accountInfoFeatureApi2;
            this.authenticationCoreLibApi = authenticationCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private SettingsScreen injectSettingsScreen(SettingsScreen settingsScreen) {
            SettingsScreen_MembersInjector.injectMoshi(settingsScreen, (Moshi) Preconditions.checkNotNullFromComponent(this.parserCoreLibApi.getMoshi()));
            SettingsScreen_MembersInjector.injectAppVersionProvider(settingsScreen, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.mutableConfigurationRemoteCoreLibApi.getAppVersionProvider()));
            SettingsScreen_MembersInjector.injectMutableLocationConfigRepository(settingsScreen, (MutableLocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.mutableConfigurationRemoteCoreLibApi.getMutableLocationConfigurationRepository()));
            SettingsScreen_MembersInjector.injectMutableConfigurationLocalRepository(settingsScreen, (MutableConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.mutableConfigurationLocalCoreLibApi.getMutableRepository()));
            SettingsScreen_MembersInjector.injectMutableConfigurationRemoteRepository(settingsScreen, (MutableConfigurationRemoteRepository) Preconditions.checkNotNullFromComponent(this.mutableConfigurationRemoteCoreLibApi.getMutableRepository()));
            SettingsScreen_MembersInjector.injectPaymentConfigurationRepository(settingsScreen, (PaymentConfigurationRepository) Preconditions.checkNotNullFromComponent(this.mutableConfigurationRemoteCoreLibApi.getPaymentConfigurationRepository()));
            SettingsScreen_MembersInjector.injectSubscriptionsRepository(settingsScreen, (ISubscriptionsCustomerRepository) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getSubscriptionsCustomerRepository()));
            SettingsScreen_MembersInjector.injectGetProCentralizationStatusUseCase(settingsScreen, (GetProCentralizationStatusUseCase) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getGetProCentralizationStatusUseCase()));
            SettingsScreen_MembersInjector.injectTalabatFeatureFlag(settingsScreen, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            SettingsScreen_MembersInjector.injectAccountInfoFeatureFlag(settingsScreen, (IAccountInfoFeatureFlag) Preconditions.checkNotNullFromComponent(this.accountInfoFeatureApi.getIAccountInfoFeatureFlag()));
            SettingsScreen_MembersInjector.injectAuthenticationRepository(settingsScreen, (AuthenticationRepository) Preconditions.checkNotNullFromComponent(this.authenticationCoreLibApi.getAuthenticationRepository()));
            return settingsScreen;
        }

        public void inject(SettingsScreen settingsScreen) {
            injectSettingsScreen(settingsScreen);
        }
    }

    private DaggerSettingsScreenComponent() {
    }

    public static SettingsScreenComponent.Factory factory() {
        return new Factory();
    }
}
