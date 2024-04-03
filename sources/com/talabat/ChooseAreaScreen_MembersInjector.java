package com.talabat;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.customer.domain.CustomerRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class ChooseAreaScreen_MembersInjector implements MembersInjector<ChooseAreaScreen> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<CustomerRepository> customerRepositoryProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;

    public ChooseAreaScreen_MembersInjector(Provider<ConfigurationLocalRepository> provider, Provider<LocationConfigurationRepository> provider2, Provider<CustomerRepository> provider3, Provider<IObservabilityManager> provider4) {
        this.configurationLocalRepositoryProvider = provider;
        this.locationConfigurationRepositoryProvider = provider2;
        this.customerRepositoryProvider = provider3;
        this.observabilityManagerProvider = provider4;
    }

    public static MembersInjector<ChooseAreaScreen> create(Provider<ConfigurationLocalRepository> provider, Provider<LocationConfigurationRepository> provider2, Provider<CustomerRepository> provider3, Provider<IObservabilityManager> provider4) {
        return new ChooseAreaScreen_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.talabat.ChooseAreaScreen.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(ChooseAreaScreen chooseAreaScreen, ConfigurationLocalRepository configurationLocalRepository) {
        chooseAreaScreen.f53934m = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.ChooseAreaScreen.customerRepository")
    public static void injectCustomerRepository(ChooseAreaScreen chooseAreaScreen, CustomerRepository customerRepository) {
        chooseAreaScreen.f53936o = customerRepository;
    }

    @InjectedFieldSignature("com.talabat.ChooseAreaScreen.locationConfigurationRepository")
    public static void injectLocationConfigurationRepository(ChooseAreaScreen chooseAreaScreen, LocationConfigurationRepository locationConfigurationRepository) {
        chooseAreaScreen.f53935n = locationConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.ChooseAreaScreen.observabilityManager")
    public static void injectObservabilityManager(ChooseAreaScreen chooseAreaScreen, IObservabilityManager iObservabilityManager) {
        chooseAreaScreen.f53937p = iObservabilityManager;
    }

    public void injectMembers(ChooseAreaScreen chooseAreaScreen) {
        injectConfigurationLocalRepository(chooseAreaScreen, this.configurationLocalRepositoryProvider.get());
        injectLocationConfigurationRepository(chooseAreaScreen, this.locationConfigurationRepositoryProvider.get());
        injectCustomerRepository(chooseAreaScreen, this.customerRepositoryProvider.get());
        injectObservabilityManager(chooseAreaScreen, this.observabilityManagerProvider.get());
    }
}
