package com.talabat.address.list;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.AddressList;
import com.talabat.AddressList_MembersInjector;
import com.talabat.address.list.AddressListComponent;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerAddressListComponent {

    public static final class AddressListComponentImpl implements AddressListComponent {
        private final AddressListComponentImpl addressListComponentImpl;
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final TrackingCoreLibApi trackingCoreLibApi;

        private AddressListComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, TrackingCoreLibApi trackingCoreLibApi2) {
            this.addressListComponentImpl = this;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.trackingCoreLibApi = trackingCoreLibApi2;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
        }

        private AddressListEventsListener addressListEventsListener() {
            return AddressListModule_AddressListEventsListenerFactory.addressListEventsListener((TalabatTracker) Preconditions.checkNotNullFromComponent(this.trackingCoreLibApi.getTalabatTracker()), (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
        }

        @CanIgnoreReturnValue
        private AddressList injectAddressList(AddressList addressList) {
            AddressList_MembersInjector.injectConfigurationLocalRepository(addressList, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            AddressList_MembersInjector.injectAddressListEventsListener(addressList, addressListEventsListener());
            AddressList_MembersInjector.injectAppVersionProvider(addressList, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider()));
            AddressList_MembersInjector.injectTalabatFeatureFlag(addressList, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            AddressList_MembersInjector.injectLocationConfigurationRepository(addressList, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            return addressList;
        }

        public void inject(AddressList addressList) {
            injectAddressList(addressList);
        }
    }

    public static final class Factory implements AddressListComponent.Factory {
        private Factory() {
        }

        public AddressListComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, TrackingCoreLibApi trackingCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(trackingCoreLibApi);
            return new AddressListComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, featureFlagCoreLibApi, trackingCoreLibApi);
        }
    }

    private DaggerAddressListComponent() {
    }

    public static AddressListComponent.Factory factory() {
        return new Factory();
    }
}
