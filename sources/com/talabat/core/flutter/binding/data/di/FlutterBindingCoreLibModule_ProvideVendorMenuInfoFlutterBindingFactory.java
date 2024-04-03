package com.talabat.core.flutter.binding.data.di;

import com.talabat.core.flutter.binding.data.vendormenuinfo.VendorMenuInfoFlutterEngineBinding;
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
public final class FlutterBindingCoreLibModule_ProvideVendorMenuInfoFlutterBindingFactory implements Factory<VendorMenuInfoFlutterEngineBinding> {
    private final Provider<Map<Class<?>, Provider<PlatformChannel>>> channelsProvider;

    public FlutterBindingCoreLibModule_ProvideVendorMenuInfoFlutterBindingFactory(Provider<Map<Class<?>, Provider<PlatformChannel>>> provider) {
        this.channelsProvider = provider;
    }

    public static FlutterBindingCoreLibModule_ProvideVendorMenuInfoFlutterBindingFactory create(Provider<Map<Class<?>, Provider<PlatformChannel>>> provider) {
        return new FlutterBindingCoreLibModule_ProvideVendorMenuInfoFlutterBindingFactory(provider);
    }

    public static VendorMenuInfoFlutterEngineBinding provideVendorMenuInfoFlutterBinding(Map<Class<?>, Provider<PlatformChannel>> map) {
        return (VendorMenuInfoFlutterEngineBinding) Preconditions.checkNotNullFromProvides(FlutterBindingCoreLibModule.INSTANCE.provideVendorMenuInfoFlutterBinding(map));
    }

    public VendorMenuInfoFlutterEngineBinding get() {
        return provideVendorMenuInfoFlutterBinding(this.channelsProvider.get());
    }
}
