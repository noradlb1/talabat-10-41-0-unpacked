package com.talabat.di.auth;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.RegistrationScreen;
import com.talabat.RegistrationScreen_MembersInjector;
import com.talabat.authentication.authenticate.domain.AuthenticationCoreLibApi;
import com.talabat.authentication.authenticate.domain.repository.AuthenticationRepository;
import com.talabat.authentication.token.domain.TokenCoreLibApi;
import com.talabat.authentication.token.domain.repository.TokenRepository;
import com.talabat.authentication.usecase.RegistrationObservabilityUseCase;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.tcs.TermsAndConditionsConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.safety.domain.SafetyAgent;
import com.talabat.core.safety.domain.SafetyCoreLibApi;
import com.talabat.di.auth.RegistrationScreenComponent;
import com.talabat.feature.cancellationpolicy.domain.HelpCenterFeatureApi;
import com.talabat.feature.cancellationpolicy.domain.IHelpCenterDeeplinkBuilder;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerRegistrationScreenComponent {

    public static final class Factory implements RegistrationScreenComponent.Factory {
        private Factory() {
        }

        public RegistrationScreenComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, SafetyCoreLibApi safetyCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, AuthenticationCoreLibApi authenticationCoreLibApi, TokenCoreLibApi tokenCoreLibApi, HelpCenterFeatureApi helpCenterFeatureApi, DeepLinkCoreLibApi deepLinkCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(dispatcherCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(safetyCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            Preconditions.checkNotNull(authenticationCoreLibApi);
            Preconditions.checkNotNull(tokenCoreLibApi);
            Preconditions.checkNotNull(helpCenterFeatureApi);
            Preconditions.checkNotNull(deepLinkCoreLibApi);
            return new RegistrationScreenComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, dispatcherCoreLibApi, featureFlagCoreLibApi, safetyCoreLibApi, observabilityCoreLibApi, authenticationCoreLibApi, tokenCoreLibApi, helpCenterFeatureApi, deepLinkCoreLibApi);
        }
    }

    public static final class RegistrationScreenComponentImpl implements RegistrationScreenComponent {
        private final AuthenticationCoreLibApi authenticationCoreLibApi;
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final DeepLinkCoreLibApi deepLinkCoreLibApi;
        private final DispatcherCoreLibApi dispatcherCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final HelpCenterFeatureApi helpCenterFeatureApi;
        private final ObservabilityCoreLibApi observabilityCoreLibApi;
        private final RegistrationScreenComponentImpl registrationScreenComponentImpl;
        private final SafetyCoreLibApi safetyCoreLibApi;
        private final TokenCoreLibApi tokenCoreLibApi;

        private RegistrationScreenComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, DispatcherCoreLibApi dispatcherCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, SafetyCoreLibApi safetyCoreLibApi2, ObservabilityCoreLibApi observabilityCoreLibApi2, AuthenticationCoreLibApi authenticationCoreLibApi2, TokenCoreLibApi tokenCoreLibApi2, HelpCenterFeatureApi helpCenterFeatureApi2, DeepLinkCoreLibApi deepLinkCoreLibApi2) {
            this.registrationScreenComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.safetyCoreLibApi = safetyCoreLibApi2;
            this.observabilityCoreLibApi = observabilityCoreLibApi2;
            this.authenticationCoreLibApi = authenticationCoreLibApi2;
            this.tokenCoreLibApi = tokenCoreLibApi2;
            this.dispatcherCoreLibApi = dispatcherCoreLibApi2;
            this.helpCenterFeatureApi = helpCenterFeatureApi2;
            this.deepLinkCoreLibApi = deepLinkCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private RegistrationScreen injectRegistrationScreen(RegistrationScreen registrationScreen) {
            RegistrationScreen_MembersInjector.injectAppVersionProvider(registrationScreen, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider()));
            RegistrationScreen_MembersInjector.injectConfigurationLocalRepository(registrationScreen, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            RegistrationScreen_MembersInjector.injectLocationConfigRepository(registrationScreen, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            RegistrationScreen_MembersInjector.injectTalabatFeatureFlag(registrationScreen, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            RegistrationScreen_MembersInjector.injectSafetyAgent(registrationScreen, (SafetyAgent) Preconditions.checkNotNullFromComponent(this.safetyCoreLibApi.getSafetyAgent()));
            RegistrationScreen_MembersInjector.injectTermsAndConditionsConfigurationRepository(registrationScreen, (TermsAndConditionsConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getTermsAndConditionsConfigurationRepository()));
            RegistrationScreen_MembersInjector.injectObservabilityManager(registrationScreen, (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()));
            RegistrationScreen_MembersInjector.injectRegistrationObservabilityUseCase(registrationScreen, (RegistrationObservabilityUseCase) Preconditions.checkNotNullFromComponent(this.authenticationCoreLibApi.getRegistrationObservabilityUseCase()));
            RegistrationScreen_MembersInjector.injectAuthenticationRepository(registrationScreen, (AuthenticationRepository) Preconditions.checkNotNullFromComponent(this.authenticationCoreLibApi.getAuthenticationRepository()));
            RegistrationScreen_MembersInjector.injectTokenRepository(registrationScreen, (TokenRepository) Preconditions.checkNotNullFromComponent(this.tokenCoreLibApi.getTokenRepository()));
            RegistrationScreen_MembersInjector.injectCoroutineDispatchersFactory(registrationScreen, (CoroutineDispatchersFactory) Preconditions.checkNotNullFromComponent(this.dispatcherCoreLibApi.getCoroutineDispatchersFactory()));
            RegistrationScreen_MembersInjector.injectHelpCenterDeeplinkBuilder(registrationScreen, (IHelpCenterDeeplinkBuilder) Preconditions.checkNotNullFromComponent(this.helpCenterFeatureApi.getHelpCenterDeeplinkNavigator()));
            RegistrationScreen_MembersInjector.injectDeepLinkNavigator(registrationScreen, (DeepLinkNavigator) Preconditions.checkNotNullFromComponent(this.deepLinkCoreLibApi.getDeepLinkNavigator()));
            return registrationScreen;
        }

        public void inject(RegistrationScreen registrationScreen) {
            injectRegistrationScreen(registrationScreen);
        }
    }

    private DaggerRegistrationScreenComponent() {
    }

    public static RegistrationScreenComponent.Factory factory() {
        return new Factory();
    }
}
