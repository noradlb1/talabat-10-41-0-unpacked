package com.talabat;

import com.talabat.authentication.authenticate.domain.repository.AuthenticationRepository;
import com.talabat.authentication.token.domain.repository.TokenRepository;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.gms.base.domain.IsGmsAvailable;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.safety.domain.SafetyAgent;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.feature.subscriptions.domain.wrapper.ProCentralizationStatusWrapper;
import com.talabat.tracking.event.ul.users.LoginTracker;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata({"com.talabat.core.gms.base.domain.IsGmsAvailable"})
@DaggerGenerated
public final class LoginScreen_MembersInjector implements MembersInjector<LoginScreen> {
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<AuthenticationRepository> authenticationRepositoryProvider;
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<Navigator> coreNavigatorProvider;
    private final Provider<CoroutineDispatchersFactory> coroutineDispatchersFactoryProvider;
    private final Provider<CustomerRepository> customerRepositoryProvider;
    private final Provider<ITalabatExperiment> experimentProvider;
    private final Provider<ProCentralizationStatusWrapper> getProCentralizationStatusWrapperProvider;
    private final Provider<Boolean> isGmsAvailableProvider;
    private final Provider<LocationConfigurationRepository> locationConfigRepositoryProvider;
    private final Provider<LoginTracker> loginTrackerProvider;
    private final Provider<DeepLinkNavigator> navigatorProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<SafetyAgent> safetyAgentProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;
    private final Provider<TokenRepository> tokenRepositoryProvider;

    public LoginScreen_MembersInjector(Provider<AppVersionProvider> provider, Provider<AuthenticationRepository> provider2, Provider<ConfigurationLocalRepository> provider3, Provider<LocationConfigurationRepository> provider4, Provider<IObservabilityManager> provider5, Provider<ITalabatFeatureFlag> provider6, Provider<LoginTracker> provider7, Provider<ProCentralizationStatusWrapper> provider8, Provider<Boolean> provider9, Provider<CustomerRepository> provider10, Provider<TokenRepository> provider11, Provider<CoroutineDispatchersFactory> provider12, Provider<DeepLinkNavigator> provider13, Provider<SafetyAgent> provider14, Provider<ITalabatExperiment> provider15, Provider<Navigator> provider16) {
        this.appVersionProvider = provider;
        this.authenticationRepositoryProvider = provider2;
        this.configurationLocalRepositoryProvider = provider3;
        this.locationConfigRepositoryProvider = provider4;
        this.observabilityManagerProvider = provider5;
        this.talabatFeatureFlagProvider = provider6;
        this.loginTrackerProvider = provider7;
        this.getProCentralizationStatusWrapperProvider = provider8;
        this.isGmsAvailableProvider = provider9;
        this.customerRepositoryProvider = provider10;
        this.tokenRepositoryProvider = provider11;
        this.coroutineDispatchersFactoryProvider = provider12;
        this.navigatorProvider = provider13;
        this.safetyAgentProvider = provider14;
        this.experimentProvider = provider15;
        this.coreNavigatorProvider = provider16;
    }

    public static MembersInjector<LoginScreen> create(Provider<AppVersionProvider> provider, Provider<AuthenticationRepository> provider2, Provider<ConfigurationLocalRepository> provider3, Provider<LocationConfigurationRepository> provider4, Provider<IObservabilityManager> provider5, Provider<ITalabatFeatureFlag> provider6, Provider<LoginTracker> provider7, Provider<ProCentralizationStatusWrapper> provider8, Provider<Boolean> provider9, Provider<CustomerRepository> provider10, Provider<TokenRepository> provider11, Provider<CoroutineDispatchersFactory> provider12, Provider<DeepLinkNavigator> provider13, Provider<SafetyAgent> provider14, Provider<ITalabatExperiment> provider15, Provider<Navigator> provider16) {
        return new LoginScreen_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16);
    }

    @InjectedFieldSignature("com.talabat.LoginScreen.appVersionProvider")
    public static void injectAppVersionProvider(LoginScreen loginScreen, AppVersionProvider appVersionProvider2) {
        loginScreen.f54288j = appVersionProvider2;
    }

    @InjectedFieldSignature("com.talabat.LoginScreen.authenticationRepository")
    public static void injectAuthenticationRepository(LoginScreen loginScreen, AuthenticationRepository authenticationRepository) {
        loginScreen.f54289k = authenticationRepository;
    }

    @InjectedFieldSignature("com.talabat.LoginScreen.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(LoginScreen loginScreen, ConfigurationLocalRepository configurationLocalRepository) {
        loginScreen.f54290l = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.LoginScreen.coreNavigator")
    public static void injectCoreNavigator(LoginScreen loginScreen, Navigator navigator) {
        loginScreen.f54303y = navigator;
    }

    @InjectedFieldSignature("com.talabat.LoginScreen.coroutineDispatchersFactory")
    public static void injectCoroutineDispatchersFactory(LoginScreen loginScreen, CoroutineDispatchersFactory coroutineDispatchersFactory) {
        loginScreen.f54299u = coroutineDispatchersFactory;
    }

    @InjectedFieldSignature("com.talabat.LoginScreen.customerRepository")
    public static void injectCustomerRepository(LoginScreen loginScreen, CustomerRepository customerRepository) {
        loginScreen.f54297s = customerRepository;
    }

    @InjectedFieldSignature("com.talabat.LoginScreen.experiment")
    public static void injectExperiment(LoginScreen loginScreen, ITalabatExperiment iTalabatExperiment) {
        loginScreen.f54302x = iTalabatExperiment;
    }

    @InjectedFieldSignature("com.talabat.LoginScreen.getProCentralizationStatusWrapper")
    public static void injectGetProCentralizationStatusWrapper(LoginScreen loginScreen, ProCentralizationStatusWrapper proCentralizationStatusWrapper) {
        loginScreen.f54295q = proCentralizationStatusWrapper;
    }

    @IsGmsAvailable
    @InjectedFieldSignature("com.talabat.LoginScreen.isGmsAvailable")
    public static void injectIsGmsAvailable(LoginScreen loginScreen, boolean z11) {
        loginScreen.f54296r = z11;
    }

    @InjectedFieldSignature("com.talabat.LoginScreen.locationConfigRepository")
    public static void injectLocationConfigRepository(LoginScreen loginScreen, LocationConfigurationRepository locationConfigurationRepository) {
        loginScreen.f54291m = locationConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.LoginScreen.loginTracker")
    public static void injectLoginTracker(LoginScreen loginScreen, LoginTracker loginTracker) {
        loginScreen.f54294p = loginTracker;
    }

    @InjectedFieldSignature("com.talabat.LoginScreen.navigator")
    public static void injectNavigator(LoginScreen loginScreen, DeepLinkNavigator deepLinkNavigator) {
        loginScreen.f54300v = deepLinkNavigator;
    }

    @InjectedFieldSignature("com.talabat.LoginScreen.observabilityManager")
    public static void injectObservabilityManager(LoginScreen loginScreen, IObservabilityManager iObservabilityManager) {
        loginScreen.f54292n = iObservabilityManager;
    }

    @InjectedFieldSignature("com.talabat.LoginScreen.safetyAgent")
    public static void injectSafetyAgent(LoginScreen loginScreen, SafetyAgent safetyAgent) {
        loginScreen.f54301w = safetyAgent;
    }

    @InjectedFieldSignature("com.talabat.LoginScreen.talabatFeatureFlag")
    public static void injectTalabatFeatureFlag(LoginScreen loginScreen, ITalabatFeatureFlag iTalabatFeatureFlag) {
        loginScreen.f54293o = iTalabatFeatureFlag;
    }

    @InjectedFieldSignature("com.talabat.LoginScreen.tokenRepository")
    public static void injectTokenRepository(LoginScreen loginScreen, TokenRepository tokenRepository) {
        loginScreen.f54298t = tokenRepository;
    }

    public void injectMembers(LoginScreen loginScreen) {
        injectAppVersionProvider(loginScreen, this.appVersionProvider.get());
        injectAuthenticationRepository(loginScreen, this.authenticationRepositoryProvider.get());
        injectConfigurationLocalRepository(loginScreen, this.configurationLocalRepositoryProvider.get());
        injectLocationConfigRepository(loginScreen, this.locationConfigRepositoryProvider.get());
        injectObservabilityManager(loginScreen, this.observabilityManagerProvider.get());
        injectTalabatFeatureFlag(loginScreen, this.talabatFeatureFlagProvider.get());
        injectLoginTracker(loginScreen, this.loginTrackerProvider.get());
        injectGetProCentralizationStatusWrapper(loginScreen, this.getProCentralizationStatusWrapperProvider.get());
        injectIsGmsAvailable(loginScreen, this.isGmsAvailableProvider.get().booleanValue());
        injectCustomerRepository(loginScreen, this.customerRepositoryProvider.get());
        injectTokenRepository(loginScreen, this.tokenRepositoryProvider.get());
        injectCoroutineDispatchersFactory(loginScreen, this.coroutineDispatchersFactoryProvider.get());
        injectNavigator(loginScreen, this.navigatorProvider.get());
        injectSafetyAgent(loginScreen, this.safetyAgentProvider.get());
        injectExperiment(loginScreen, this.experimentProvider.get());
        injectCoreNavigator(loginScreen, this.coreNavigatorProvider.get());
    }
}
