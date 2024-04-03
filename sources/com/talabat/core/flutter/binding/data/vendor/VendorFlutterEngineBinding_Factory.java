package com.talabat.core.flutter.binding.data.vendor;

import com.talabat.core.flutter.channels.domain.vendor.VendorChannelFlutterDomain;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class VendorFlutterEngineBinding_Factory implements Factory<VendorFlutterEngineBinding> {
    private final Provider<VendorChannelFlutterDomain> vendorChannelFlutterDomainProvider;

    public VendorFlutterEngineBinding_Factory(Provider<VendorChannelFlutterDomain> provider) {
        this.vendorChannelFlutterDomainProvider = provider;
    }

    public static VendorFlutterEngineBinding_Factory create(Provider<VendorChannelFlutterDomain> provider) {
        return new VendorFlutterEngineBinding_Factory(provider);
    }

    public static VendorFlutterEngineBinding newInstance(VendorChannelFlutterDomain vendorChannelFlutterDomain) {
        return new VendorFlutterEngineBinding(vendorChannelFlutterDomain);
    }

    public VendorFlutterEngineBinding get() {
        return newInstance(this.vendorChannelFlutterDomainProvider.get());
    }
}
