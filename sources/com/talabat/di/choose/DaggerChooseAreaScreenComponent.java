package com.talabat.di.choose;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.ChooseAreaScreen;
import com.talabat.ChooseAreaScreen_MembersInjector;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import com.talabat.di.choose.ChooseAreaScreenComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerChooseAreaScreenComponent {

    public static final class ChooseAreaScreenComponentImpl implements ChooseAreaScreenComponent {
        private final ChooseAreaScreenComponentImpl chooseAreaScreenComponentImpl;
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final CustomerCoreLibApi customerCoreLibApi;
        private final ObservabilityCoreLibApi observabilityCoreLibApi;

        private ChooseAreaScreenComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, CustomerCoreLibApi customerCoreLibApi2, ObservabilityCoreLibApi observabilityCoreLibApi2) {
            this.chooseAreaScreenComponentImpl = this;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            this.customerCoreLibApi = customerCoreLibApi2;
            this.observabilityCoreLibApi = observabilityCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private ChooseAreaScreen injectChooseAreaScreen(ChooseAreaScreen chooseAreaScreen) {
            ChooseAreaScreen_MembersInjector.injectConfigurationLocalRepository(chooseAreaScreen, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            ChooseAreaScreen_MembersInjector.injectLocationConfigurationRepository(chooseAreaScreen, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            ChooseAreaScreen_MembersInjector.injectCustomerRepository(chooseAreaScreen, (CustomerRepository) Preconditions.checkNotNullFromComponent(this.customerCoreLibApi.getRepository()));
            ChooseAreaScreen_MembersInjector.injectObservabilityManager(chooseAreaScreen, (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()));
            return chooseAreaScreen;
        }

        public void inject(ChooseAreaScreen chooseAreaScreen) {
            injectChooseAreaScreen(chooseAreaScreen);
        }
    }

    public static final class Factory implements ChooseAreaScreenComponent.Factory {
        private Factory() {
        }

        public ChooseAreaScreenComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, CustomerCoreLibApi customerCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(customerCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            return new ChooseAreaScreenComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, customerCoreLibApi, observabilityCoreLibApi);
        }
    }

    private DaggerChooseAreaScreenComponent() {
    }

    public static ChooseAreaScreenComponent.Factory factory() {
        return new Factory();
    }
}
