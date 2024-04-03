package com.talabat.fluttercore.engine;

import android.content.Context;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.configuration.tcs.TermsAndConditionsConfigurationRepository;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class EngineProvider_Factory implements Factory<EngineProvider> {
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<Context> contextProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<PaymentConfigurationRepository> paymentConfigurationRepositoryProvider;
    private final Provider<IScreenTracker> screenTrackerProvider;
    private final Provider<TermsAndConditionsConfigurationRepository> termsAndConditionsConfigurationRepositoryProvider;

    public EngineProvider_Factory(Provider<Context> provider, Provider<AppVersionProvider> provider2, Provider<ConfigurationLocalRepository> provider3, Provider<LocationConfigurationRepository> provider4, Provider<PaymentConfigurationRepository> provider5, Provider<TermsAndConditionsConfigurationRepository> provider6, Provider<IScreenTracker> provider7, Provider<IObservabilityManager> provider8) {
        this.contextProvider = provider;
        this.appVersionProvider = provider2;
        this.configurationLocalRepositoryProvider = provider3;
        this.locationConfigurationRepositoryProvider = provider4;
        this.paymentConfigurationRepositoryProvider = provider5;
        this.termsAndConditionsConfigurationRepositoryProvider = provider6;
        this.screenTrackerProvider = provider7;
        this.observabilityManagerProvider = provider8;
    }

    public static EngineProvider_Factory create(Provider<Context> provider, Provider<AppVersionProvider> provider2, Provider<ConfigurationLocalRepository> provider3, Provider<LocationConfigurationRepository> provider4, Provider<PaymentConfigurationRepository> provider5, Provider<TermsAndConditionsConfigurationRepository> provider6, Provider<IScreenTracker> provider7, Provider<IObservabilityManager> provider8) {
        return new EngineProvider_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static EngineProvider newInstance(Context context, AppVersionProvider appVersionProvider2, ConfigurationLocalRepository configurationLocalRepository, LocationConfigurationRepository locationConfigurationRepository, PaymentConfigurationRepository paymentConfigurationRepository, TermsAndConditionsConfigurationRepository termsAndConditionsConfigurationRepository, IScreenTracker iScreenTracker, IObservabilityManager iObservabilityManager) {
        return new EngineProvider(context, appVersionProvider2, configurationLocalRepository, locationConfigurationRepository, paymentConfigurationRepository, termsAndConditionsConfigurationRepository, iScreenTracker, iObservabilityManager);
    }

    public EngineProvider get() {
        return newInstance(this.contextProvider.get(), this.appVersionProvider.get(), this.configurationLocalRepositoryProvider.get(), this.locationConfigurationRepositoryProvider.get(), this.paymentConfigurationRepositoryProvider.get(), this.termsAndConditionsConfigurationRepositoryProvider.get(), this.screenTrackerProvider.get(), this.observabilityManagerProvider.get());
    }
}
