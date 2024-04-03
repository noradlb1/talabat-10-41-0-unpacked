package com.talabat.core.flutter.binding.data.address;

import com.talabat.core.flutter.channels.domain.address.AddressInfoChannelFlutterDomain;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class AddressInfoFlutterEngineBinding_Factory implements Factory<AddressInfoFlutterEngineBinding> {
    private final Provider<AddressInfoChannelFlutterDomain> addressInfoChannelFlutterDomainProvider;

    public AddressInfoFlutterEngineBinding_Factory(Provider<AddressInfoChannelFlutterDomain> provider) {
        this.addressInfoChannelFlutterDomainProvider = provider;
    }

    public static AddressInfoFlutterEngineBinding_Factory create(Provider<AddressInfoChannelFlutterDomain> provider) {
        return new AddressInfoFlutterEngineBinding_Factory(provider);
    }

    public static AddressInfoFlutterEngineBinding newInstance(AddressInfoChannelFlutterDomain addressInfoChannelFlutterDomain) {
        return new AddressInfoFlutterEngineBinding(addressInfoChannelFlutterDomain);
    }

    public AddressInfoFlutterEngineBinding get() {
        return newInstance(this.addressInfoChannelFlutterDomainProvider.get());
    }
}
