package com.talabat.core.flutter.binding.data.di;

import com.talabat.core.flutter.binding.data.vendor.VendorFlutterEngineBinding;
import com.talabat.core.flutter.channels.domain.PlatformChannel;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Map;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class FlutterBindingCoreLibModule_ProvideVendorFlutterBindingFactory implements Factory<VendorFlutterEngineBinding> {
    private final Provider<Map<Class<?>, Provider<PlatformChannel>>> channelsProvider;

    public FlutterBindingCoreLibModule_ProvideVendorFlutterBindingFactory(Provider<Map<Class<?>, Provider<PlatformChannel>>> provider) {
        this.channelsProvider = provider;
    }

    public static FlutterBindingCoreLibModule_ProvideVendorFlutterBindingFactory create(Provider<Map<Class<?>, Provider<PlatformChannel>>> provider) {
        return new FlutterBindingCoreLibModule_ProvideVendorFlutterBindingFactory(provider);
    }

    public static VendorFlutterEngineBinding provideVendorFlutterBinding(Map<Class<?>, Provider<PlatformChannel>> map) {
        return (VendorFlutterEngineBinding) Preconditions.checkNotNullFromProvides(FlutterBindingCoreLibModule.INSTANCE.provideVendorFlutterBinding(map));
    }

    public VendorFlutterEngineBinding get() {
        return provideVendorFlutterBinding(this.channelsProvider.get());
    }
}
