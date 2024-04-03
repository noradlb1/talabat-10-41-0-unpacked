package com.talabat.di.auth;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.LoginScreen;
import com.talabat.LoginScreen_MembersInjector;
import com.talabat.authentication.authenticate.domain.AuthenticationCoreLibApi;
import com.talabat.authentication.authenticate.domain.repository.AuthenticationRepository;
import com.talabat.authentication.token.domain.TokenCoreLibApi;
import com.talabat.authentication.token.domain.repository.TokenRepository;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.gms.base.domain.GmsBaseCoreLibApi;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.safety.domain.SafetyAgent;
import com.talabat.core.safety.domain.SafetyCoreLibApi;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import com.talabat.di.auth.LoginScreenComponent;
import com.talabat.feature.subscriptions.domain.ISubscriptionsCustomerRepository;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.subscriptions.domain.usecase.GetProCentralizationStatusUseCase;
import com.talabat.feature.subscriptions.domain.wrapper.ProCentralizationStatusWrapper;
import com.talabat.tracking.event.ul.users.LoginTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerLoginScreenComponent {

    public static final class Factory implements LoginScreenComponent.Factory {
        private Factory() {
        }

        public LoginScreenComponent create(AuthenticationCoreLibApi authenticationCoreLibApi, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, GmsBaseCoreLibApi gmsBaseCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, SafetyCoreLibApi safetyCoreLibApi, TrackingCoreLibApi trackingCoreLibApi, CustomerCoreLibApi customerCoreLibApi, SubscriptionsFeatureApi subscriptionsFeatureApi, TokenCoreLibApi tokenCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, DeepLinkCoreLibApi deepLinkCoreLibApi, NavigationCoreLibApi navigationCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi) {
            FeatureFlagCoreLibApi featureFlagCoreLibApi2 = featureFlagCoreLibApi;
            Preconditions.checkNotNull(authenticationCoreLibApi);
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(gmsBaseCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(safetyCoreLibApi);
            Preconditions.checkNotNull(trackingCoreLibApi);
            Preconditions.checkNotNull(customerCoreLibApi);
            Preconditions.checkNotNull(subscriptionsFeatureApi);
            Preconditions.checkNotNull(tokenCoreLibApi);
            Preconditions.checkNotNull(dispatcherCoreLibApi);
            Preconditions.checkNotNull(deepLinkCoreLibApi);
            Preconditions.checkNotNull(navigationCoreLibApi);
            Preconditions.checkNotNull(experimentCoreLibApi);
            return new LoginScreenComponentImpl(authenticationCoreLibApi, configurationLocalCoreLibApi, configurationRemoteCoreLibApi, featureFlagCoreLibApi2, gmsBaseCoreLibApi, observabilityCoreLibApi, safetyCoreLibApi, trackingCoreLibApi, customerCoreLibApi, subscriptionsFeatureApi, tokenCoreLibApi, dispatcherCoreLibApi, deepLinkCoreLibApi, navigationCoreLibApi, experimentCoreLibApi);
        }
    }

    public static final class LoginScreenComponentImpl implements LoginScreenComponent {
        private final AuthenticationCoreLibApi authenticationCoreLibApi;
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final CustomerCoreLibApi customerCoreLibApi;
        private final DeepLinkCoreLibApi deepLinkCoreLibApi;
        private final DispatcherCoreLibApi dispatcherCoreLibApi;
        private final ExperimentCoreLibApi experimentCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final GmsBaseCoreLibApi gmsBaseCoreLibApi;
        private final LoginScreenComponentImpl loginScreenComponentImpl;
        private final NavigationCoreLibApi navigationCoreLibApi;
        private final ObservabilityCoreLibApi observabilityCoreLibApi;
        private final SafetyCoreLibApi safetyCoreLibApi;
        private final SubscriptionsFeatureApi subscriptionsFeatureApi;
        private final TokenCoreLibApi tokenCoreLibApi;
        private final TrackingCoreLibApi trackingCoreLibApi;

        private LoginScreenComponentImpl(AuthenticationCoreLibApi authenticationCoreLibApi2, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, GmsBaseCoreLibApi gmsBaseCoreLibApi2, ObservabilityCoreLibApi observabilityCoreLibApi2, SafetyCoreLibApi safetyCoreLibApi2, TrackingCoreLibApi trackingCoreLibApi2, CustomerCoreLibApi customerCoreLibApi2, SubscriptionsFeatureApi subscriptionsFeatureApi2, TokenCoreLibApi tokenCoreLibApi2, DispatcherCoreLibApi dispatcherCoreLibApi2, DeepLinkCoreLibApi deepLinkCoreLibApi2, NavigationCoreLibApi navigationCoreLibApi2, ExperimentCoreLibApi experimentCoreLibApi2) {
            this.loginScreenComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            this.authenticationCoreLibApi = authenticationCoreLibApi2;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.observabilityCoreLibApi = observabilityCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.trackingCoreLibApi = trackingCoreLibApi2;
            this.subscriptionsFeatureApi = subscriptionsFeatureApi2;
            this.gmsBaseCoreLibApi = gmsBaseCoreLibApi2;
            this.customerCoreLibApi = customerCoreLibApi2;
            this.tokenCoreLibApi = tokenCoreLibApi2;
            this.dispatcherCoreLibApi = dispatcherCoreLibApi2;
            this.deepLinkCoreLibApi = deepLinkCoreLibApi2;
            this.safetyCoreLibApi = safetyCoreLibApi2;
            this.experimentCoreLibApi = experimentCoreLibApi2;
            this.navigationCoreLibApi = navigationCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private LoginScreen injectLoginScreen(LoginScreen loginScreen) {
            LoginScreen_MembersInjector.injectAppVersionProvider(loginScreen, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider()));
            LoginScreen_MembersInjector.injectAuthenticationRepository(loginScreen, (AuthenticationRepository) Preconditions.checkNotNullFromComponent(this.authenticationCoreLibApi.getAuthenticationRepository()));
            LoginScreen_MembersInjector.injectConfigurationLocalRepository(loginScreen, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            LoginScreen_MembersInjector.injectLocationConfigRepository(loginScreen, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            LoginScreen_MembersInjector.injectObservabilityManager(loginScreen, (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()));
            LoginScreen_MembersInjector.injectTalabatFeatureFlag(loginScreen, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            LoginScreen_MembersInjector.injectLoginTracker(loginScreen, loginTracker());
            LoginScreen_MembersInjector.injectGetProCentralizationStatusWrapper(loginScreen, proCentralizationStatusWrapper());
            LoginScreen_MembersInjector.injectIsGmsAvailable(loginScreen, this.gmsBaseCoreLibApi.isGmsAvailable());
            LoginScreen_MembersInjector.injectCustomerRepository(loginScreen, (CustomerRepository) Preconditions.checkNotNullFromComponent(this.customerCoreLibApi.getRepository()));
            LoginScreen_MembersInjector.injectTokenRepository(loginScreen, (TokenRepository) Preconditions.checkNotNullFromComponent(this.tokenCoreLibApi.getTokenRepository()));
            LoginScreen_MembersInjector.injectCoroutineDispatchersFactory(loginScreen, (CoroutineDispatchersFactory) Preconditions.checkNotNullFromComponent(this.dispatcherCoreLibApi.getCoroutineDispatchersFactory()));
            LoginScreen_MembersInjector.injectNavigator(loginScreen, (DeepLinkNavigator) Preconditions.checkNotNullFromComponent(this.deepLinkCoreLibApi.getDeepLinkNavigator()));
            LoginScreen_MembersInjector.injectSafetyAgent(loginScreen, (SafetyAgent) Preconditions.checkNotNullFromComponent(this.safetyCoreLibApi.getSafetyAgent()));
            LoginScreen_MembersInjector.injectExperiment(loginScreen, (ITalabatExperiment) Preconditions.checkNotNullFromComponent(this.experimentCoreLibApi.getExperimentProvider()));
            LoginScreen_MembersInjector.injectCoreNavigator(loginScreen, (Navigator) Preconditions.checkNotNullFromComponent(this.navigationCoreLibApi.getNavigator()));
            return loginScreen;
        }

        private LoginTracker loginTracker() {
            return new LoginTracker((TalabatTracker) Preconditions.checkNotNullFromComponent(this.trackingCoreLibApi.getTalabatTracker()));
        }

        private ProCentralizationStatusWrapper proCentralizationStatusWrapper() {
            return new ProCentralizationStatusWrapper((GetProCentralizationStatusUseCase) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getGetProCentralizationStatusUseCase()), (ISubscriptionsCustomerRepository) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getSubscriptionsCustomerRepository()));
        }

        public void inject(LoginScreen loginScreen) {
            injectLoginScreen(loginScreen);
        }
    }

    private DaggerLoginScreenComponent() {
    }

    public static LoginScreenComponent.Factory factory() {
        return new Factory();
    }
}
