package com.talabat.core.flutter.binding.data.menu;

import com.talabat.core.flutter.channels.domain.menu.MenuChannelFlutterDomain;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class MenuFlutterEngineBinding_Factory implements Factory<MenuFlutterEngineBinding> {
    private final Provider<MenuChannelFlutterDomain> menuChannelFlutterDomainProvider;

    public MenuFlutterEngineBinding_Factory(Provider<MenuChannelFlutterDomain> provider) {
        this.menuChannelFlutterDomainProvider = provider;
    }

    public static MenuFlutterEngineBinding_Factory create(Provider<MenuChannelFlutterDomain> provider) {
        return new MenuFlutterEngineBinding_Factory(provider);
    }

    public static MenuFlutterEngineBinding newInstance(MenuChannelFlutterDomain menuChannelFlutterDomain) {
        return new MenuFlutterEngineBinding(menuChannelFlutterDomain);
    }

    public MenuFlutterEngineBinding get() {
        return newInstance(this.menuChannelFlutterDomainProvider.get());
    }
}
