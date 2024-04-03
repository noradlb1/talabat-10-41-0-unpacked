package com.talabat.core.flutter.binding.data.di;

import com.talabat.core.flutter.binding.data.search.SearchFlutterEngineBinding;
import com.talabat.core.flutter.channels.domain.PlatformChannel;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Map;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FlutterBindingCoreLibModule_ProvideSearchFlutterBindingFactory implements Factory<SearchFlutterEngineBinding> {
    private final Provider<Map<Class<?>, Provider<PlatformChannel>>> channelsProvider;

    public FlutterBindingCoreLibModule_ProvideSearchFlutterBindingFactory(Provider<Map<Class<?>, Provider<PlatformChannel>>> provider) {
        this.channelsProvider = provider;
    }

    public static FlutterBindingCoreLibModule_ProvideSearchFlutterBindingFactory create(Provider<Map<Class<?>, Provider<PlatformChannel>>> provider) {
        return new FlutterBindingCoreLibModule_ProvideSearchFlutterBindingFactory(provider);
    }

    public static SearchFlutterEngineBinding provideSearchFlutterBinding(Map<Class<?>, Provider<PlatformChannel>> map) {
        return (SearchFlutterEngineBinding) Preconditions.checkNotNullFromProvides(FlutterBindingCoreLibModule.INSTANCE.provideSearchFlutterBinding(map));
    }

    public SearchFlutterEngineBinding get() {
        return provideSearchFlutterBinding(this.channelsProvider.get());
    }
}
