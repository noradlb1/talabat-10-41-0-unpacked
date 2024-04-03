package com.talabat.core.deeplink.data;

import com.talabat.core.deeplink.data.parser.LinkParser;
import com.talabat.core.deeplink.data.registry.LinkHandlerRegistry;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.core.deeplink.data.di.DeepLink", "com.talabat.core.deeplink.data.di.AppLink"})
public final class DefaultDeepLinkNavigator_Factory implements Factory<DefaultDeepLinkNavigator> {
    private final Provider<LinkHandlerRegistry> appLinkHandlerRegistryProvider;
    private final Provider<LinkParser> appLinkParserProvider;
    private final Provider<CoroutineDispatchersFactory> coroutineDispatchersFactoryProvider;
    private final Provider<LinkHandlerRegistry> deepLinkHandlerRegistryProvider;
    private final Provider<LinkParser> deepLinkParserProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public DefaultDeepLinkNavigator_Factory(Provider<LinkParser> provider, Provider<LinkHandlerRegistry> provider2, Provider<LinkParser> provider3, Provider<LinkHandlerRegistry> provider4, Provider<IObservabilityManager> provider5, Provider<CoroutineDispatchersFactory> provider6, Provider<ITalabatFeatureFlag> provider7) {
        this.deepLinkParserProvider = provider;
        this.deepLinkHandlerRegistryProvider = provider2;
        this.appLinkParserProvider = provider3;
        this.appLinkHandlerRegistryProvider = provider4;
        this.observabilityManagerProvider = provider5;
        this.coroutineDispatchersFactoryProvider = provider6;
        this.talabatFeatureFlagProvider = provider7;
    }

    public static DefaultDeepLinkNavigator_Factory create(Provider<LinkParser> provider, Provider<LinkHandlerRegistry> provider2, Provider<LinkParser> provider3, Provider<LinkHandlerRegistry> provider4, Provider<IObservabilityManager> provider5, Provider<CoroutineDispatchersFactory> provider6, Provider<ITalabatFeatureFlag> provider7) {
        return new DefaultDeepLinkNavigator_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static DefaultDeepLinkNavigator newInstance(LinkParser linkParser, LinkHandlerRegistry linkHandlerRegistry, LinkParser linkParser2, LinkHandlerRegistry linkHandlerRegistry2, IObservabilityManager iObservabilityManager, CoroutineDispatchersFactory coroutineDispatchersFactory, ITalabatFeatureFlag iTalabatFeatureFlag) {
        return new DefaultDeepLinkNavigator(linkParser, linkHandlerRegistry, linkParser2, linkHandlerRegistry2, iObservabilityManager, coroutineDispatchersFactory, iTalabatFeatureFlag);
    }

    public DefaultDeepLinkNavigator get() {
        return newInstance(this.deepLinkParserProvider.get(), this.deepLinkHandlerRegistryProvider.get(), this.appLinkParserProvider.get(), this.appLinkHandlerRegistryProvider.get(), this.observabilityManagerProvider.get(), this.coroutineDispatchersFactoryProvider.get(), this.talabatFeatureFlagProvider.get());
    }
}
