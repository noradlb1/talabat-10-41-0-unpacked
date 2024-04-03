package com.talabat;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.feature.cancellationpolicy.domain.IHelpCenterDeeplinkBuilder;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class AppFeedBackScreen_MembersInjector implements MembersInjector<AppFeedBackScreen> {
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<DeepLinkNavigator> deepLinkNavigatorProvider;
    private final Provider<IHelpCenterDeeplinkBuilder> helpCenterDeeplinkBuilderProvider;

    public AppFeedBackScreen_MembersInjector(Provider<AppVersionProvider> provider, Provider<ConfigurationLocalRepository> provider2, Provider<IHelpCenterDeeplinkBuilder> provider3, Provider<DeepLinkNavigator> provider4) {
        this.appVersionProvider = provider;
        this.configurationLocalRepositoryProvider = provider2;
        this.helpCenterDeeplinkBuilderProvider = provider3;
        this.deepLinkNavigatorProvider = provider4;
    }

    public static MembersInjector<AppFeedBackScreen> create(Provider<AppVersionProvider> provider, Provider<ConfigurationLocalRepository> provider2, Provider<IHelpCenterDeeplinkBuilder> provider3, Provider<DeepLinkNavigator> provider4) {
        return new AppFeedBackScreen_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.talabat.AppFeedBackScreen.appVersionProvider")
    public static void injectAppVersionProvider(AppFeedBackScreen appFeedBackScreen, AppVersionProvider appVersionProvider2) {
        appFeedBackScreen.f53656i = appVersionProvider2;
    }

    @InjectedFieldSignature("com.talabat.AppFeedBackScreen.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(AppFeedBackScreen appFeedBackScreen, ConfigurationLocalRepository configurationLocalRepository) {
        appFeedBackScreen.f53657j = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.AppFeedBackScreen.deepLinkNavigator")
    public static void injectDeepLinkNavigator(AppFeedBackScreen appFeedBackScreen, DeepLinkNavigator deepLinkNavigator) {
        appFeedBackScreen.f53659l = deepLinkNavigator;
    }

    @InjectedFieldSignature("com.talabat.AppFeedBackScreen.helpCenterDeeplinkBuilder")
    public static void injectHelpCenterDeeplinkBuilder(AppFeedBackScreen appFeedBackScreen, IHelpCenterDeeplinkBuilder iHelpCenterDeeplinkBuilder) {
        appFeedBackScreen.f53658k = iHelpCenterDeeplinkBuilder;
    }

    public void injectMembers(AppFeedBackScreen appFeedBackScreen) {
        injectAppVersionProvider(appFeedBackScreen, this.appVersionProvider.get());
        injectConfigurationLocalRepository(appFeedBackScreen, this.configurationLocalRepositoryProvider.get());
        injectHelpCenterDeeplinkBuilder(appFeedBackScreen, this.helpCenterDeeplinkBuilderProvider.get());
        injectDeepLinkNavigator(appFeedBackScreen, this.deepLinkNavigatorProvider.get());
    }
}
