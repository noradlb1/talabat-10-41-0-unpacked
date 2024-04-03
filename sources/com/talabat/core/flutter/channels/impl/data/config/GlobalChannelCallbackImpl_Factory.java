package com.talabat.core.flutter.channels.impl.data.config;

import com.talabat.application.device.id.domain.DeviceIdProvider;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.configuration.tcs.TermsAndConditionsConfigurationRepository;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.data.googleclientid.GoogleClientIdProvider;
import com.talabat.location.SelectedLocationProvider;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GlobalChannelCallbackImpl_Factory implements Factory<GlobalChannelCallbackImpl> {
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<DeviceIdProvider> deviceIdProvider;
    private final Provider<GoogleClientIdProvider> googleClientIdProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<PaymentConfigurationRepository> paymentConfigurationRepositoryProvider;
    private final Provider<SelectedLocationProvider> selectedLocationProvider;
    private final Provider<TermsAndConditionsConfigurationRepository> termsAndConditionsConfigurationRepositoryProvider;

    public GlobalChannelCallbackImpl_Factory(Provider<AppVersionProvider> provider, Provider<ConfigurationLocalRepository> provider2, Provider<LocationConfigurationRepository> provider3, Provider<SelectedLocationProvider> provider4, Provider<DeviceIdProvider> provider5, Provider<GoogleClientIdProvider> provider6, Provider<PaymentConfigurationRepository> provider7, Provider<TermsAndConditionsConfigurationRepository> provider8, Provider<IObservabilityManager> provider9) {
        this.appVersionProvider = provider;
        this.configurationLocalRepositoryProvider = provider2;
        this.locationConfigurationRepositoryProvider = provider3;
        this.selectedLocationProvider = provider4;
        this.deviceIdProvider = provider5;
        this.googleClientIdProvider = provider6;
        this.paymentConfigurationRepositoryProvider = provider7;
        this.termsAndConditionsConfigurationRepositoryProvider = provider8;
        this.observabilityManagerProvider = provider9;
    }

    public static GlobalChannelCallbackImpl_Factory create(Provider<AppVersionProvider> provider, Provider<ConfigurationLocalRepository> provider2, Provider<LocationConfigurationRepository> provider3, Provider<SelectedLocationProvider> provider4, Provider<DeviceIdProvider> provider5, Provider<GoogleClientIdProvider> provider6, Provider<PaymentConfigurationRepository> provider7, Provider<TermsAndConditionsConfigurationRepository> provider8, Provider<IObservabilityManager> provider9) {
        return new GlobalChannelCallbackImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static GlobalChannelCallbackImpl newInstance(AppVersionProvider appVersionProvider2, ConfigurationLocalRepository configurationLocalRepository, LocationConfigurationRepository locationConfigurationRepository, SelectedLocationProvider selectedLocationProvider2, DeviceIdProvider deviceIdProvider2, GoogleClientIdProvider googleClientIdProvider2, PaymentConfigurationRepository paymentConfigurationRepository, TermsAndConditionsConfigurationRepository termsAndConditionsConfigurationRepository, IObservabilityManager iObservabilityManager) {
        return new GlobalChannelCallbackImpl(appVersionProvider2, configurationLocalRepository, locationConfigurationRepository, selectedLocationProvider2, deviceIdProvider2, googleClientIdProvider2, paymentConfigurationRepository, termsAndConditionsConfigurationRepository, iObservabilityManager);
    }

    public GlobalChannelCallbackImpl get() {
        return newInstance(this.appVersionProvider.get(), this.configurationLocalRepositoryProvider.get(), this.locationConfigurationRepositoryProvider.get(), this.selectedLocationProvider.get(), this.deviceIdProvider.get(), this.googleClientIdProvider.get(), this.paymentConfigurationRepositoryProvider.get(), this.termsAndConditionsConfigurationRepositoryProvider.get(), this.observabilityManagerProvider.get());
    }
}
