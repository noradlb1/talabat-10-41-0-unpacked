package com.talabat.core.flutter.binding.data.vendormenuinfo;

import com.talabat.core.flutter.channels.domain.vendormenuinfo.VendorMenuInfoChannelFlutterDomain;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class VendorMenuInfoFlutterEngineBinding_Factory implements Factory<VendorMenuInfoFlutterEngineBinding> {
    private final Provider<VendorMenuInfoChannelFlutterDomain> vendorMenuInfoChannelFlutterDomainProvider;

    public VendorMenuInfoFlutterEngineBinding_Factory(Provider<VendorMenuInfoChannelFlutterDomain> provider) {
        this.vendorMenuInfoChannelFlutterDomainProvider = provider;
    }

    public static VendorMenuInfoFlutterEngineBinding_Factory create(Provider<VendorMenuInfoChannelFlutterDomain> provider) {
        return new VendorMenuInfoFlutterEngineBinding_Factory(provider);
    }

    public static VendorMenuInfoFlutterEngineBinding newInstance(VendorMenuInfoChannelFlutterDomain vendorMenuInfoChannelFlutterDomain) {
        return new VendorMenuInfoFlutterEngineBinding(vendorMenuInfoChannelFlutterDomain);
    }

    public VendorMenuInfoFlutterEngineBinding get() {
        return newInstance(this.vendorMenuInfoChannelFlutterDomainProvider.get());
    }
}
