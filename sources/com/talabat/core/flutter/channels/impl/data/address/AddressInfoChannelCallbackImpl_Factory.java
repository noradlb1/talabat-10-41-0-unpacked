package com.talabat.core.flutter.channels.impl.data.address;

import android.app.Application;
import com.squareup.moshi.Moshi;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.MutableConfigurationLocalRepository;
import com.talabat.configuration.MutableConfigurationRemoteRepository;
import com.talabat.configuration.MutableLocationConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.pinless.checkout.domain.GetHasUserPinnedLocationInCurrentOnboardingSessionUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class AddressInfoChannelCallbackImpl_Factory implements Factory<AddressInfoChannelCallbackImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<FlutterAddressMapper> flutterAddressMapperProvider;
    private final Provider<GetHasUserPinnedLocationInCurrentOnboardingSessionUseCase> getHasUserPinnedLocationInCurrentOnboardingSessionUseCaseProvider;
    private final Provider<Moshi> moshiProvider;
    private final Provider<MutableConfigurationLocalRepository> mutableConfigurationLocalRepositoryProvider;
    private final Provider<MutableConfigurationRemoteRepository> mutableConfigurationRemoteRepositoryProvider;
    private final Provider<MutableLocationConfigurationRepository> mutableLocationConfigRepositoryProvider;
    private final Provider<NativeAddressMapper> nativeAddressMapperProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<PaymentConfigurationRepository> paymentConfigurationRepositoryProvider;
    private final Provider<ITalabatExperiment> talabatExperimentProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public AddressInfoChannelCallbackImpl_Factory(Provider<Application> provider, Provider<GetHasUserPinnedLocationInCurrentOnboardingSessionUseCase> provider2, Provider<FlutterAddressMapper> provider3, Provider<NativeAddressMapper> provider4, Provider<IObservabilityManager> provider5, Provider<ITalabatExperiment> provider6, Provider<Moshi> provider7, Provider<PaymentConfigurationRepository> provider8, Provider<MutableConfigurationLocalRepository> provider9, Provider<ConfigurationLocalRepository> provider10, Provider<MutableLocationConfigurationRepository> provider11, Provider<MutableConfigurationRemoteRepository> provider12, Provider<ITalabatFeatureFlag> provider13) {
        this.applicationProvider = provider;
        this.getHasUserPinnedLocationInCurrentOnboardingSessionUseCaseProvider = provider2;
        this.flutterAddressMapperProvider = provider3;
        this.nativeAddressMapperProvider = provider4;
        this.observabilityManagerProvider = provider5;
        this.talabatExperimentProvider = provider6;
        this.moshiProvider = provider7;
        this.paymentConfigurationRepositoryProvider = provider8;
        this.mutableConfigurationLocalRepositoryProvider = provider9;
        this.configurationLocalRepositoryProvider = provider10;
        this.mutableLocationConfigRepositoryProvider = provider11;
        this.mutableConfigurationRemoteRepositoryProvider = provider12;
        this.talabatFeatureFlagProvider = provider13;
    }

    public static AddressInfoChannelCallbackImpl_Factory create(Provider<Application> provider, Provider<GetHasUserPinnedLocationInCurrentOnboardingSessionUseCase> provider2, Provider<FlutterAddressMapper> provider3, Provider<NativeAddressMapper> provider4, Provider<IObservabilityManager> provider5, Provider<ITalabatExperiment> provider6, Provider<Moshi> provider7, Provider<PaymentConfigurationRepository> provider8, Provider<MutableConfigurationLocalRepository> provider9, Provider<ConfigurationLocalRepository> provider10, Provider<MutableLocationConfigurationRepository> provider11, Provider<MutableConfigurationRemoteRepository> provider12, Provider<ITalabatFeatureFlag> provider13) {
        return new AddressInfoChannelCallbackImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13);
    }

    public static AddressInfoChannelCallbackImpl newInstance(Application application, GetHasUserPinnedLocationInCurrentOnboardingSessionUseCase getHasUserPinnedLocationInCurrentOnboardingSessionUseCase, FlutterAddressMapper flutterAddressMapper, NativeAddressMapper nativeAddressMapper, IObservabilityManager iObservabilityManager, ITalabatExperiment iTalabatExperiment, Moshi moshi, PaymentConfigurationRepository paymentConfigurationRepository, MutableConfigurationLocalRepository mutableConfigurationLocalRepository, ConfigurationLocalRepository configurationLocalRepository, MutableLocationConfigurationRepository mutableLocationConfigurationRepository, MutableConfigurationRemoteRepository mutableConfigurationRemoteRepository, ITalabatFeatureFlag iTalabatFeatureFlag) {
        return new AddressInfoChannelCallbackImpl(application, getHasUserPinnedLocationInCurrentOnboardingSessionUseCase, flutterAddressMapper, nativeAddressMapper, iObservabilityManager, iTalabatExperiment, moshi, paymentConfigurationRepository, mutableConfigurationLocalRepository, configurationLocalRepository, mutableLocationConfigurationRepository, mutableConfigurationRemoteRepository, iTalabatFeatureFlag);
    }

    public AddressInfoChannelCallbackImpl get() {
        return newInstance(this.applicationProvider.get(), this.getHasUserPinnedLocationInCurrentOnboardingSessionUseCaseProvider.get(), this.flutterAddressMapperProvider.get(), this.nativeAddressMapperProvider.get(), this.observabilityManagerProvider.get(), this.talabatExperimentProvider.get(), this.moshiProvider.get(), this.paymentConfigurationRepositoryProvider.get(), this.mutableConfigurationLocalRepositoryProvider.get(), this.configurationLocalRepositoryProvider.get(), this.mutableLocationConfigRepositoryProvider.get(), this.mutableConfigurationRemoteRepositoryProvider.get(), this.talabatFeatureFlagProvider.get());
    }
}
