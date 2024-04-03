package com.talabat.di.delivery;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.di.delivery.DeliveryAreaFragmentComponent;
import com.talabat.fragments.DeliveryAreaFragment;
import com.talabat.fragments.DeliveryAreaFragment_MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerDeliveryAreaFragmentComponent {

    public static final class DeliveryAreaFragmentComponentImpl implements DeliveryAreaFragmentComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final DeliveryAreaFragmentComponentImpl deliveryAreaFragmentComponentImpl;

        private DeliveryAreaFragmentComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
            this.deliveryAreaFragmentComponentImpl = this;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private DeliveryAreaFragment injectDeliveryAreaFragment(DeliveryAreaFragment deliveryAreaFragment) {
            DeliveryAreaFragment_MembersInjector.injectConfigurationLocalRepository(deliveryAreaFragment, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            DeliveryAreaFragment_MembersInjector.injectLocationConfigurationRepository(deliveryAreaFragment, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            return deliveryAreaFragment;
        }

        public void inject(DeliveryAreaFragment deliveryAreaFragment) {
            injectDeliveryAreaFragment(deliveryAreaFragment);
        }
    }

    public static final class Factory implements DeliveryAreaFragmentComponent.Factory {
        private Factory() {
        }

        public DeliveryAreaFragmentComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            return new DeliveryAreaFragmentComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi);
        }
    }

    private DaggerDeliveryAreaFragmentComponent() {
    }

    public static DeliveryAreaFragmentComponent.Factory factory() {
        return new Factory();
    }
}
