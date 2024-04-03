package com.talabat;

import com.squareup.moshi.Moshi;
import com.talabat.authentication.authenticate.domain.repository.AuthenticationRepository;
import com.talabat.configuration.MutableConfigurationLocalRepository;
import com.talabat.configuration.MutableConfigurationRemoteRepository;
import com.talabat.configuration.MutableLocationConfigurationRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.feature.subscriptions.domain.ISubscriptionsCustomerRepository;
import com.talabat.feature.subscriptions.domain.usecase.GetProCentralizationStatusUseCase;
import com.talabat.feature.ulaccountinfo.domain.IAccountInfoFeatureFlag;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class SettingsScreen_MembersInjector implements MembersInjector<SettingsScreen> {
    private final Provider<IAccountInfoFeatureFlag> accountInfoFeatureFlagProvider;
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<AuthenticationRepository> authenticationRepositoryProvider;
    private final Provider<GetProCentralizationStatusUseCase> getProCentralizationStatusUseCaseProvider;
    private final Provider<Moshi> moshiProvider;
    private final Provider<MutableConfigurationLocalRepository> mutableConfigurationLocalRepositoryProvider;
    private final Provider<MutableConfigurationRemoteRepository> mutableConfigurationRemoteRepositoryProvider;
    private final Provider<MutableLocationConfigurationRepository> mutableLocationConfigRepositoryProvider;
    private final Provider<PaymentConfigurationRepository> paymentConfigurationRepositoryProvider;
    private final Provider<ISubscriptionsCustomerRepository> subscriptionsRepositoryProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public SettingsScreen_MembersInjector(Provider<Moshi> provider, Provider<AppVersionProvider> provider2, Provider<MutableLocationConfigurationRepository> provider3, Provider<MutableConfigurationLocalRepository> provider4, Provider<MutableConfigurationRemoteRepository> provider5, Provider<PaymentConfigurationRepository> provider6, Provider<ISubscriptionsCustomerRepository> provider7, Provider<GetProCentralizationStatusUseCase> provider8, Provider<ITalabatFeatureFlag> provider9, Provider<IAccountInfoFeatureFlag> provider10, Provider<AuthenticationRepository> provider11) {
        this.moshiProvider = provider;
        this.appVersionProvider = provider2;
        this.mutableLocationConfigRepositoryProvider = provider3;
        this.mutableConfigurationLocalRepositoryProvider = provider4;
        this.mutableConfigurationRemoteRepositoryProvider = provider5;
        this.paymentConfigurationRepositoryProvider = provider6;
        this.subscriptionsRepositoryProvider = provider7;
        this.getProCentralizationStatusUseCaseProvider = provider8;
        this.talabatFeatureFlagProvider = provider9;
        this.accountInfoFeatureFlagProvider = provider10;
        this.authenticationRepositoryProvider = provider11;
    }

    public static MembersInjector<SettingsScreen> create(Provider<Moshi> provider, Provider<AppVersionProvider> provider2, Provider<MutableLocationConfigurationRepository> provider3, Provider<MutableConfigurationLocalRepository> provider4, Provider<MutableConfigurationRemoteRepository> provider5, Provider<PaymentConfigurationRepository> provider6, Provider<ISubscriptionsCustomerRepository> provider7, Provider<GetProCentralizationStatusUseCase> provider8, Provider<ITalabatFeatureFlag> provider9, Provider<IAccountInfoFeatureFlag> provider10, Provider<AuthenticationRepository> provider11) {
        return new SettingsScreen_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    @InjectedFieldSignature("com.talabat.SettingsScreen.accountInfoFeatureFlag")
    public static void injectAccountInfoFeatureFlag(SettingsScreen settingsScreen, IAccountInfoFeatureFlag iAccountInfoFeatureFlag) {
        settingsScreen.f55051r = iAccountInfoFeatureFlag;
    }

    @InjectedFieldSignature("com.talabat.SettingsScreen.appVersionProvider")
    public static void injectAppVersionProvider(SettingsScreen settingsScreen, AppVersionProvider appVersionProvider2) {
        settingsScreen.f55043j = appVersionProvider2;
    }

    @InjectedFieldSignature("com.talabat.SettingsScreen.authenticationRepository")
    public static void injectAuthenticationRepository(SettingsScreen settingsScreen, AuthenticationRepository authenticationRepository) {
        settingsScreen.f55052s = authenticationRepository;
    }

    @InjectedFieldSignature("com.talabat.SettingsScreen.getProCentralizationStatusUseCase")
    public static void injectGetProCentralizationStatusUseCase(SettingsScreen settingsScreen, GetProCentralizationStatusUseCase getProCentralizationStatusUseCase) {
        settingsScreen.f55049p = getProCentralizationStatusUseCase;
    }

    @InjectedFieldSignature("com.talabat.SettingsScreen.moshi")
    public static void injectMoshi(SettingsScreen settingsScreen, Moshi moshi) {
        settingsScreen.f55042i = moshi;
    }

    @InjectedFieldSignature("com.talabat.SettingsScreen.mutableConfigurationLocalRepository")
    public static void injectMutableConfigurationLocalRepository(SettingsScreen settingsScreen, MutableConfigurationLocalRepository mutableConfigurationLocalRepository) {
        settingsScreen.f55045l = mutableConfigurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.SettingsScreen.mutableConfigurationRemoteRepository")
    public static void injectMutableConfigurationRemoteRepository(SettingsScreen settingsScreen, MutableConfigurationRemoteRepository mutableConfigurationRemoteRepository) {
        settingsScreen.f55046m = mutableConfigurationRemoteRepository;
    }

    @InjectedFieldSignature("com.talabat.SettingsScreen.mutableLocationConfigRepository")
    public static void injectMutableLocationConfigRepository(SettingsScreen settingsScreen, MutableLocationConfigurationRepository mutableLocationConfigurationRepository) {
        settingsScreen.f55044k = mutableLocationConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.SettingsScreen.paymentConfigurationRepository")
    public static void injectPaymentConfigurationRepository(SettingsScreen settingsScreen, PaymentConfigurationRepository paymentConfigurationRepository) {
        settingsScreen.f55047n = paymentConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.SettingsScreen.subscriptionsRepository")
    public static void injectSubscriptionsRepository(SettingsScreen settingsScreen, ISubscriptionsCustomerRepository iSubscriptionsCustomerRepository) {
        settingsScreen.f55048o = iSubscriptionsCustomerRepository;
    }

    @InjectedFieldSignature("com.talabat.SettingsScreen.talabatFeatureFlag")
    public static void injectTalabatFeatureFlag(SettingsScreen settingsScreen, ITalabatFeatureFlag iTalabatFeatureFlag) {
        settingsScreen.f55050q = iTalabatFeatureFlag;
    }

    public void injectMembers(SettingsScreen settingsScreen) {
        injectMoshi(settingsScreen, this.moshiProvider.get());
        injectAppVersionProvider(settingsScreen, this.appVersionProvider.get());
        injectMutableLocationConfigRepository(settingsScreen, this.mutableLocationConfigRepositoryProvider.get());
        injectMutableConfigurationLocalRepository(settingsScreen, this.mutableConfigurationLocalRepositoryProvider.get());
        injectMutableConfigurationRemoteRepository(settingsScreen, this.mutableConfigurationRemoteRepositoryProvider.get());
        injectPaymentConfigurationRepository(settingsScreen, this.paymentConfigurationRepositoryProvider.get());
        injectSubscriptionsRepository(settingsScreen, this.subscriptionsRepositoryProvider.get());
        injectGetProCentralizationStatusUseCase(settingsScreen, this.getProCentralizationStatusUseCaseProvider.get());
        injectTalabatFeatureFlag(settingsScreen, this.talabatFeatureFlagProvider.get());
        injectAccountInfoFeatureFlag(settingsScreen, this.accountInfoFeatureFlagProvider.get());
        injectAuthenticationRepository(settingsScreen, this.authenticationRepositoryProvider.get());
    }
}
