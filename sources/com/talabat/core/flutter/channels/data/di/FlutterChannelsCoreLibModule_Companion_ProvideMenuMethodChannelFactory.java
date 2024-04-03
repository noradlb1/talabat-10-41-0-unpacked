package com.talabat.core.flutter.channels.data.di;

import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.channels.domain.menu.MenuChannelCallback;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FlutterChannelsCoreLibModule_Companion_ProvideMenuMethodChannelFactory implements Factory<PlatformChannel> {
    private final Provider<MenuChannelCallback> menuChannelCallbackProvider;

    public FlutterChannelsCoreLibModule_Companion_ProvideMenuMethodChannelFactory(Provider<MenuChannelCallback> provider) {
        this.menuChannelCallbackProvider = provider;
    }

    public static FlutterChannelsCoreLibModule_Companion_ProvideMenuMethodChannelFactory create(Provider<MenuChannelCallback> provider) {
        return new FlutterChannelsCoreLibModule_Companion_ProvideMenuMethodChannelFactory(provider);
    }

    public static PlatformChannel provideMenuMethodChannel(MenuChannelCallback menuChannelCallback) {
        return (PlatformChannel) Preconditions.checkNotNullFromProvides(FlutterChannelsCoreLibModule.Companion.provideMenuMethodChannel(menuChannelCallback));
    }

    public PlatformChannel get() {
        return provideMenuMethodChannel(this.menuChannelCallbackProvider.get());
    }
}
