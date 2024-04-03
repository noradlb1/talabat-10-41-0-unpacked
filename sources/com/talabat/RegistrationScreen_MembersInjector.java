package com.talabat;

import com.talabat.authentication.authenticate.domain.repository.AuthenticationRepository;
import com.talabat.authentication.token.domain.repository.TokenRepository;
import com.talabat.authentication.usecase.RegistrationObservabilityUseCase;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.tcs.TermsAndConditionsConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.safety.domain.SafetyAgent;
import com.talabat.feature.cancellationpolicy.domain.IHelpCenterDeeplinkBuilder;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class RegistrationScreen_MembersInjector implements MembersInjector<RegistrationScreen> {
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<AuthenticationRepository> authenticationRepositoryProvider;
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<CoroutineDispatchersFactory> coroutineDispatchersFactoryProvider;
    private final Provider<DeepLinkNavigator> deepLinkNavigatorProvider;
    private final Provider<IHelpCenterDeeplinkBuilder> helpCenterDeeplinkBuilderProvider;
    private final Provider<LocationConfigurationRepository> locationConfigRepositoryProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<RegistrationObservabilityUseCase> registrationObservabilityUseCaseProvider;
    private final Provider<SafetyAgent> safetyAgentProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;
    private final Provider<TermsAndConditionsConfigurationRepository> termsAndConditionsConfigurationRepositoryProvider;
    private final Provider<TokenRepository> tokenRepositoryProvider;

    public RegistrationScreen_MembersInjector(Provider<AppVersionProvider> provider, Provider<ConfigurationLocalRepository> provider2, Provider<LocationConfigurationRepository> provider3, Provider<ITalabatFeatureFlag> provider4, Provider<SafetyAgent> provider5, Provider<TermsAndConditionsConfigurationRepository> provider6, Provider<IObservabilityManager> provider7, Provider<RegistrationObservabilityUseCase> provider8, Provider<AuthenticationRepository> provider9, Provider<TokenRepository> provider10, Provider<CoroutineDispatchersFactory> provider11, Provider<IHelpCenterDeeplinkBuilder> provider12, Provider<DeepLinkNavigator> provider13) {
        this.appVersionProvider = provider;
        this.configurationLocalRepositoryProvider = provider2;
        this.locationConfigRepositoryProvider = provider3;
        this.talabatFeatureFlagProvider = provider4;
        this.safetyAgentProvider = provider5;
        this.termsAndConditionsConfigurationRepositoryProvider = provider6;
        this.observabilityManagerProvider = provider7;
        this.registrationObservabilityUseCaseProvider = provider8;
        this.authenticationRepositoryProvider = provider9;
        this.tokenRepositoryProvider = provider10;
        this.coroutineDispatchersFactoryProvider = provider11;
        this.helpCenterDeeplinkBuilderProvider = provider12;
        this.deepLinkNavigatorProvider = provider13;
    }

    public static MembersInjector<RegistrationScreen> create(Provider<AppVersionProvider> provider, Provider<ConfigurationLocalRepository> provider2, Provider<LocationConfigurationRepository> provider3, Provider<ITalabatFeatureFlag> provider4, Provider<SafetyAgent> provider5, Provider<TermsAndConditionsConfigurationRepository> provider6, Provider<IObservabilityManager> provider7, Provider<RegistrationObservabilityUseCase> provider8, Provider<AuthenticationRepository> provider9, Provider<TokenRepository> provider10, Provider<CoroutineDispatchersFactory> provider11, Provider<IHelpCenterDeeplinkBuilder> provider12, Provider<DeepLinkNavigator> provider13) {
        return new RegistrationScreen_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13);
    }

    @InjectedFieldSignature("com.talabat.RegistrationScreen.appVersionProvider")
    public static void injectAppVersionProvider(RegistrationScreen registrationScreen, AppVersionProvider appVersionProvider2) {
        registrationScreen.f54927i = appVersionProvider2;
    }

    @InjectedFieldSignature("com.talabat.RegistrationScreen.authenticationRepository")
    public static void injectAuthenticationRepository(RegistrationScreen registrationScreen, AuthenticationRepository authenticationRepository) {
        registrationScreen.authenticationRepository = authenticationRepository;
    }

    @InjectedFieldSignature("com.talabat.RegistrationScreen.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(RegistrationScreen registrationScreen, ConfigurationLocalRepository configurationLocalRepository) {
        registrationScreen.f54928j = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.RegistrationScreen.coroutineDispatchersFactory")
    public static void injectCoroutineDispatchersFactory(RegistrationScreen registrationScreen, CoroutineDispatchersFactory coroutineDispatchersFactory) {
        registrationScreen.coroutineDispatchersFactory = coroutineDispatchersFactory;
    }

    @InjectedFieldSignature("com.talabat.RegistrationScreen.deepLinkNavigator")
    public static void injectDeepLinkNavigator(RegistrationScreen registrationScreen, DeepLinkNavigator deepLinkNavigator) {
        registrationScreen.f54933o = deepLinkNavigator;
    }

    @InjectedFieldSignature("com.talabat.RegistrationScreen.helpCenterDeeplinkBuilder")
    public static void injectHelpCenterDeeplinkBuilder(RegistrationScreen registrationScreen, IHelpCenterDeeplinkBuilder iHelpCenterDeeplinkBuilder) {
        registrationScreen.f54932n = iHelpCenterDeeplinkBuilder;
    }

    @InjectedFieldSignature("com.talabat.RegistrationScreen.locationConfigRepository")
    public static void injectLocationConfigRepository(RegistrationScreen registrationScreen, LocationConfigurationRepository locationConfigurationRepository) {
        registrationScreen.f54929k = locationConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.RegistrationScreen.observabilityManager")
    public static void injectObservabilityManager(RegistrationScreen registrationScreen, IObservabilityManager iObservabilityManager) {
        registrationScreen.observabilityManager = iObservabilityManager;
    }

    @InjectedFieldSignature("com.talabat.RegistrationScreen.registrationObservabilityUseCase")
    public static void injectRegistrationObservabilityUseCase(RegistrationScreen registrationScreen, RegistrationObservabilityUseCase registrationObservabilityUseCase) {
        registrationScreen.registrationObservabilityUseCase = registrationObservabilityUseCase;
    }

    @InjectedFieldSignature("com.talabat.RegistrationScreen.safetyAgent")
    public static void injectSafetyAgent(RegistrationScreen registrationScreen, SafetyAgent safetyAgent) {
        registrationScreen.f54931m = safetyAgent;
    }

    @InjectedFieldSignature("com.talabat.RegistrationScreen.talabatFeatureFlag")
    public static void injectTalabatFeatureFlag(RegistrationScreen registrationScreen, ITalabatFeatureFlag iTalabatFeatureFlag) {
        registrationScreen.f54930l = iTalabatFeatureFlag;
    }

    @InjectedFieldSignature("com.talabat.RegistrationScreen.termsAndConditionsConfigurationRepository")
    public static void injectTermsAndConditionsConfigurationRepository(RegistrationScreen registrationScreen, TermsAndConditionsConfigurationRepository termsAndConditionsConfigurationRepository) {
        registrationScreen.termsAndConditionsConfigurationRepository = termsAndConditionsConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.RegistrationScreen.tokenRepository")
    public static void injectTokenRepository(RegistrationScreen registrationScreen, TokenRepository tokenRepository) {
        registrationScreen.tokenRepository = tokenRepository;
    }

    public void injectMembers(RegistrationScreen registrationScreen) {
        injectAppVersionProvider(registrationScreen, this.appVersionProvider.get());
        injectConfigurationLocalRepository(registrationScreen, this.configurationLocalRepositoryProvider.get());
        injectLocationConfigRepository(registrationScreen, this.locationConfigRepositoryProvider.get());
        injectTalabatFeatureFlag(registrationScreen, this.talabatFeatureFlagProvider.get());
        injectSafetyAgent(registrationScreen, this.safetyAgentProvider.get());
        injectTermsAndConditionsConfigurationRepository(registrationScreen, this.termsAndConditionsConfigurationRepositoryProvider.get());
        injectObservabilityManager(registrationScreen, this.observabilityManagerProvider.get());
        injectRegistrationObservabilityUseCase(registrationScreen, this.registrationObservabilityUseCaseProvider.get());
        injectAuthenticationRepository(registrationScreen, this.authenticationRepositoryProvider.get());
        injectTokenRepository(registrationScreen, this.tokenRepositoryProvider.get());
        injectCoroutineDispatchersFactory(registrationScreen, this.coroutineDispatchersFactoryProvider.get());
        injectHelpCenterDeeplinkBuilder(registrationScreen, this.helpCenterDeeplinkBuilderProvider.get());
        injectDeepLinkNavigator(registrationScreen, this.deepLinkNavigatorProvider.get());
    }
}
