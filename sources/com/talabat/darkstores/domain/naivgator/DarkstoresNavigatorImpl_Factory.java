package com.talabat.darkstores.domain.naivgator;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.navigation.domain.Navigator;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DarkstoresNavigatorImpl_Factory implements Factory<DarkstoresNavigatorImpl> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<DeepLinkNavigator> deeplinkNavigatorProvider;
    private final Provider<CoroutineDispatchersFactory> dispatchersFactoryProvider;
    private final Provider<Navigator> navigatorProvider;

    public DarkstoresNavigatorImpl_Factory(Provider<ConfigurationLocalRepository> provider, Provider<DeepLinkNavigator> provider2, Provider<Navigator> provider3, Provider<CoroutineDispatchersFactory> provider4) {
        this.configurationLocalRepositoryProvider = provider;
        this.deeplinkNavigatorProvider = provider2;
        this.navigatorProvider = provider3;
        this.dispatchersFactoryProvider = provider4;
    }

    public static DarkstoresNavigatorImpl_Factory create(Provider<ConfigurationLocalRepository> provider, Provider<DeepLinkNavigator> provider2, Provider<Navigator> provider3, Provider<CoroutineDispatchersFactory> provider4) {
        return new DarkstoresNavigatorImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static DarkstoresNavigatorImpl newInstance(ConfigurationLocalRepository configurationLocalRepository, DeepLinkNavigator deepLinkNavigator, Navigator navigator, CoroutineDispatchersFactory coroutineDispatchersFactory) {
        return new DarkstoresNavigatorImpl(configurationLocalRepository, deepLinkNavigator, navigator, coroutineDispatchersFactory);
    }

    public DarkstoresNavigatorImpl get() {
        return newInstance(this.configurationLocalRepositoryProvider.get(), this.deeplinkNavigatorProvider.get(), this.navigatorProvider.get(), this.dispatchersFactoryProvider.get());
    }
}
