package com.talabat;

import com.talabat.address.list.AddressListEventsListener;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class AddressList_MembersInjector implements MembersInjector<AddressList> {
    private final Provider<AddressListEventsListener> addressListEventsListenerProvider;
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public AddressList_MembersInjector(Provider<ConfigurationLocalRepository> provider, Provider<AddressListEventsListener> provider2, Provider<AppVersionProvider> provider3, Provider<ITalabatFeatureFlag> provider4, Provider<LocationConfigurationRepository> provider5) {
        this.configurationLocalRepositoryProvider = provider;
        this.addressListEventsListenerProvider = provider2;
        this.appVersionProvider = provider3;
        this.talabatFeatureFlagProvider = provider4;
        this.locationConfigurationRepositoryProvider = provider5;
    }

    public static MembersInjector<AddressList> create(Provider<ConfigurationLocalRepository> provider, Provider<AddressListEventsListener> provider2, Provider<AppVersionProvider> provider3, Provider<ITalabatFeatureFlag> provider4, Provider<LocationConfigurationRepository> provider5) {
        return new AddressList_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.talabat.AddressList.addressListEventsListener")
    public static void injectAddressListEventsListener(AddressList addressList, AddressListEventsListener addressListEventsListener) {
        addressList.f53535m = addressListEventsListener;
    }

    @InjectedFieldSignature("com.talabat.AddressList.appVersionProvider")
    public static void injectAppVersionProvider(AddressList addressList, AppVersionProvider appVersionProvider2) {
        addressList.f53536n = appVersionProvider2;
    }

    @InjectedFieldSignature("com.talabat.AddressList.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(AddressList addressList, ConfigurationLocalRepository configurationLocalRepository) {
        addressList.f53532j = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.AddressList.locationConfigurationRepository")
    public static void injectLocationConfigurationRepository(AddressList addressList, LocationConfigurationRepository locationConfigurationRepository) {
        addressList.f53538p = locationConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.AddressList.talabatFeatureFlag")
    public static void injectTalabatFeatureFlag(AddressList addressList, ITalabatFeatureFlag iTalabatFeatureFlag) {
        addressList.f53537o = iTalabatFeatureFlag;
    }

    public void injectMembers(AddressList addressList) {
        injectConfigurationLocalRepository(addressList, this.configurationLocalRepositoryProvider.get());
        injectAddressListEventsListener(addressList, this.addressListEventsListenerProvider.get());
        injectAppVersionProvider(addressList, this.appVersionProvider.get());
        injectTalabatFeatureFlag(addressList, this.talabatFeatureFlagProvider.get());
        injectLocationConfigurationRepository(addressList, this.locationConfigurationRepositoryProvider.get());
    }
}
