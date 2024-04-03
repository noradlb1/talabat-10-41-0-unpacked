package com.talabat.core.deeplink.data.di;

import com.talabat.core.deeplink.data.di.DeepLinkCoreLibModule;
import com.talabat.core.deeplink.data.handler.flutter.uiless.DeepLinkFlutterNavigationChannel;
import com.talabat.core.deeplink.data.handler.flutter.uiless.UiLessFlutterEngineBinding;
import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.engine.domain.IFlutterEngineProvider;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
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
public final class DeepLinkCoreLibModule_Ext_ProvideUiLessFlutterEngineBindingFactory implements Factory<UiLessFlutterEngineBinding> {
    private final Provider<Map<Class<?>, Provider<PlatformChannel>>> channelsProvider;
    private final Provider<DeepLinkFlutterNavigationChannel> deepLinkFlutterNavigationChannelProvider;
    private final Provider<IFlutterEngineProvider> flutterEngineProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;

    public DeepLinkCoreLibModule_Ext_ProvideUiLessFlutterEngineBindingFactory(Provider<IFlutterEngineProvider> provider, Provider<DeepLinkFlutterNavigationChannel> provider2, Provider<Map<Class<?>, Provider<PlatformChannel>>> provider3, Provider<IObservabilityManager> provider4) {
        this.flutterEngineProvider = provider;
        this.deepLinkFlutterNavigationChannelProvider = provider2;
        this.channelsProvider = provider3;
        this.observabilityManagerProvider = provider4;
    }

    public static DeepLinkCoreLibModule_Ext_ProvideUiLessFlutterEngineBindingFactory create(Provider<IFlutterEngineProvider> provider, Provider<DeepLinkFlutterNavigationChannel> provider2, Provider<Map<Class<?>, Provider<PlatformChannel>>> provider3, Provider<IObservabilityManager> provider4) {
        return new DeepLinkCoreLibModule_Ext_ProvideUiLessFlutterEngineBindingFactory(provider, provider2, provider3, provider4);
    }

    public static UiLessFlutterEngineBinding provideUiLessFlutterEngineBinding(IFlutterEngineProvider iFlutterEngineProvider, DeepLinkFlutterNavigationChannel deepLinkFlutterNavigationChannel, Map<Class<?>, Provider<PlatformChannel>> map, IObservabilityManager iObservabilityManager) {
        return (UiLessFlutterEngineBinding) Preconditions.checkNotNullFromProvides(DeepLinkCoreLibModule.Ext.INSTANCE.provideUiLessFlutterEngineBinding(iFlutterEngineProvider, deepLinkFlutterNavigationChannel, map, iObservabilityManager));
    }

    public UiLessFlutterEngineBinding get() {
        return provideUiLessFlutterEngineBinding(this.flutterEngineProvider.get(), this.deepLinkFlutterNavigationChannelProvider.get(), this.channelsProvider.get(), this.observabilityManagerProvider.get());
    }
}
