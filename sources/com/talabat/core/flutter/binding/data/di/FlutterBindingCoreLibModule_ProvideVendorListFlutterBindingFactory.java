package com.talabat.core.flutter.binding.data.di;

import com.talabat.core.flutter.binding.data.vendorlist.InlineAdsFlutterEngineBinding;
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
public final class FlutterBindingCoreLibModule_ProvideVendorListFlutterBindingFactory implements Factory<InlineAdsFlutterEngineBinding> {
    private final Provider<Map<Class<?>, Provider<PlatformChannel>>> channelsProvider;

    public FlutterBindingCoreLibModule_ProvideVendorListFlutterBindingFactory(Provider<Map<Class<?>, Provider<PlatformChannel>>> provider) {
        this.channelsProvider = provider;
    }

    public static FlutterBindingCoreLibModule_ProvideVendorListFlutterBindingFactory create(Provider<Map<Class<?>, Provider<PlatformChannel>>> provider) {
        return new FlutterBindingCoreLibModule_ProvideVendorListFlutterBindingFactory(provider);
    }

    public static InlineAdsFlutterEngineBinding provideVendorListFlutterBinding(Map<Class<?>, Provider<PlatformChannel>> map) {
        return (InlineAdsFlutterEngineBinding) Preconditions.checkNotNullFromProvides(FlutterBindingCoreLibModule.INSTANCE.provideVendorListFlutterBinding(map));
    }

    public InlineAdsFlutterEngineBinding get() {
        return provideVendorListFlutterBinding(this.channelsProvider.get());
    }
}
