package com.talabat.core.flutter.channels.data.di;

import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.channels.domain.vendormenuinfo.VendorMenuInfoChannelCallback;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FlutterChannelsCoreLibModule_Companion_ProvideVendorMenuInfoMethodChannelFactory implements Factory<PlatformChannel> {
    private final Provider<VendorMenuInfoChannelCallback> vendorMenuInfoChannelCallbackProvider;

    public FlutterChannelsCoreLibModule_Companion_ProvideVendorMenuInfoMethodChannelFactory(Provider<VendorMenuInfoChannelCallback> provider) {
        this.vendorMenuInfoChannelCallbackProvider = provider;
    }

    public static FlutterChannelsCoreLibModule_Companion_ProvideVendorMenuInfoMethodChannelFactory create(Provider<VendorMenuInfoChannelCallback> provider) {
        return new FlutterChannelsCoreLibModule_Companion_ProvideVendorMenuInfoMethodChannelFactory(provider);
    }

    public static PlatformChannel provideVendorMenuInfoMethodChannel(VendorMenuInfoChannelCallback vendorMenuInfoChannelCallback) {
        return (PlatformChannel) Preconditions.checkNotNullFromProvides(FlutterChannelsCoreLibModule.Companion.provideVendorMenuInfoMethodChannel(vendorMenuInfoChannelCallback));
    }

    public PlatformChannel get() {
        return provideVendorMenuInfoMethodChannel(this.vendorMenuInfoChannelCallbackProvider.get());
    }
}
