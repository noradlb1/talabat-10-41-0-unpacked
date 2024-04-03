package com.talabat.core.deeplink.data.registry;

import com.talabat.core.navigation.domain.Navigator;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class AppLinkHandlerRegistry_Factory implements Factory<AppLinkHandlerRegistry> {
    private final Provider<Navigator> navigatorProvider;

    public AppLinkHandlerRegistry_Factory(Provider<Navigator> provider) {
        this.navigatorProvider = provider;
    }

    public static AppLinkHandlerRegistry_Factory create(Provider<Navigator> provider) {
        return new AppLinkHandlerRegistry_Factory(provider);
    }

    public static AppLinkHandlerRegistry newInstance(Navigator navigator) {
        return new AppLinkHandlerRegistry(navigator);
    }

    public AppLinkHandlerRegistry get() {
        return newInstance(this.navigatorProvider.get());
    }
}
