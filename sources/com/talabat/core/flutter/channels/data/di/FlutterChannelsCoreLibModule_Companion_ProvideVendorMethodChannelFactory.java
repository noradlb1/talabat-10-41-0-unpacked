package com.talabat.core.flutter.channels.data.di;

import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.channels.domain.vendor.VendorChannelCallback;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FlutterChannelsCoreLibModule_Companion_ProvideVendorMethodChannelFactory implements Factory<PlatformChannel> {
    private final Provider<VendorChannelCallback> vendorChannelCallbackProvider;

    public FlutterChannelsCoreLibModule_Companion_ProvideVendorMethodChannelFactory(Provider<VendorChannelCallback> provider) {
        this.vendorChannelCallbackProvider = provider;
    }

    public static FlutterChannelsCoreLibModule_Companion_ProvideVendorMethodChannelFactory create(Provider<VendorChannelCallback> provider) {
        return new FlutterChannelsCoreLibModule_Companion_ProvideVendorMethodChannelFactory(provider);
    }

    public static PlatformChannel provideVendorMethodChannel(VendorChannelCallback vendorChannelCallback) {
        return (PlatformChannel) Preconditions.checkNotNullFromProvides(FlutterChannelsCoreLibModule.Companion.provideVendorMethodChannel(vendorChannelCallback));
    }

    public PlatformChannel get() {
        return provideVendorMethodChannel(this.vendorChannelCallbackProvider.get());
    }
}
